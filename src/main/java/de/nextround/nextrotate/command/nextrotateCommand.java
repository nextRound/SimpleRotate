package de.nextround.nextrotate.command;

import com.boydti.fawe.FaweAPI;
import com.boydti.fawe.object.FawePlayer;
import com.sk89q.worldedit.EmptyClipboardException;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.session.ClipboardHolder;
import de.nextround.nextrotate.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class nextrotateCommand implements CommandExecutor{

    private Main instance;

    public nextrotateCommand(Main instance) {
        this.instance = instance;
    }

    public boolean onCommand(CommandSender sender, Command command, String arg, String[] args) {
        final Player player = (Player) sender;
        final FawePlayer fawePlayer = FaweAPI.wrapPlayer(player);

        if(command.getName().equalsIgnoreCase("nextrotate") || command.getName().equalsIgnoreCase("nr")) {
            if(!player.hasPermission("nextrotate.command")) {
                player.sendMessage(instance.getPrefix()+" §cYou don't have permissions to do that! §e--> nextrotate.command");
                return false;
            }

            if(args.length==0) {
                if(!instance.yawSave.containsKey(player)) {
                    player.sendMessage(instance.getPrefix()+" §cYou have to set your clipboard direction: §e/nextrotate direction");
                    return false;
                }
                try {
                    if (fawePlayer.getSession().getClipboard() != null) {

                        ClipboardHolder clipboardHolder = fawePlayer.getSession().getClipboard();

                        final Clipboard clipboard = clipboardHolder.getClipboards().get(0);

                        player.sendMessage("YAW: "+player.getLocation().getYaw()+" PITCH: "+player.getLocation().getPitch());

                        instance.fastrotate.justRotate(player);

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                fawePlayer.getSession().setClipboard(new ClipboardHolder(clipboard, fawePlayer.getWorld().getWorldData()));

                                player.sendMessage(instance.getPrefix() + " §9Clipboard rotated and pasted!");
                            }
                        },20);

                    }
                }catch (EmptyClipboardException e) {
                    player.sendMessage(instance.getPrefix()+" §cYour cilpboard is empty!");
                    e.printStackTrace();
                    return false;
                }
            }else if(args.length==1) {
                if(args[0].equalsIgnoreCase("direction")) {
                    instance.yawSave.put(player, player.getLocation().getYaw());

                    Bukkit.getServer().dispatchCommand(player, "/copy");

                    player.sendMessage(instance.getPrefix() + " §9Your clipboard direction is now: §e" + instance.fastrotate.convertYaw(player.getLocation().getYaw()));
                }else{
                    player.sendMessage(instance.getPrefix()+" §9Usage§8: §f/nextrotate [direction]");
                    return false;
                }
            }else{
                player.sendMessage(instance.getPrefix()+" §9Usage§8: §f/nextrotate [direction]");
                return false;
            }
        }else if(command.getName().equalsIgnoreCase("nrd")) {
            if(!player.hasPermission("nextrotate.command")) {
                player.sendMessage(instance.getPrefix()+" §cYou don't have permissions to do that! §e--> nextrotate.command");
                return false;
            }

            if(args.length==0) {
                instance.yawSave.put(player, player.getLocation().getYaw());

                Bukkit.getServer().dispatchCommand(player, "/copy");

                player.sendMessage(instance.getPrefix() + " §9Your clipboard direction is now: §e" + instance.fastrotate.convertYaw(player.getLocation().getYaw()));
            } else{
                player.sendMessage(instance.getPrefix()+" §9Usage§8: §f/nrd");
            }
        }
        return false;
    }
}
