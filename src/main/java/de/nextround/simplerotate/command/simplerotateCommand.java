package de.nextround.simplerotate.command;

import com.boydti.fawe.FaweAPI;
import com.boydti.fawe.object.FawePlayer;
import com.sk89q.worldedit.EmptyClipboardException;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.WorldEditAPI;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.math.transform.Transform;
import de.nextround.simplerotate.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class simplerotateCommand implements CommandExecutor{

    private Main instance;

    public simplerotateCommand(Main instance) {
        this.instance = instance;
    }

    public boolean onCommand(CommandSender sender, Command command, String arg, String[] args) {
        Player player = (Player) sender;
        FawePlayer fawePlayer = FaweAPI.wrapPlayer(player);

        if(command.getName().equalsIgnoreCase("simplerotate") || command.getName().equalsIgnoreCase("sr")) {
            if(!player.hasPermission("simplerotate.command")) {
                player.sendMessage(instance.getPrefix()+" §cYou don't have permissions to do that! §e--> simplerotate.command");
                return false;
            }

            if(args.length==0) {
                if(!instance.yawSave.containsKey(player)) {
                    player.sendMessage(instance.getPrefix()+" §cYou have to set your clipboard direction: §e/simplerotate direction");
                    return false;
                }
                try {
                    if (fawePlayer.getSession().getClipboard() != null) {

                        instance.fastrotate.rotate(player);

                        player.sendMessage(instance.getPrefix() + " §9Clipboard rotated!");

                    }
                }catch (EmptyClipboardException e) {
                    player.sendMessage(instance.getPrefix()+" §cYour cilpboard is empty!");
                    return false;
                }
            }else if(args.length==1) {
                if(args[0].equalsIgnoreCase("direction")) {
                    if(player.getLocation().getYaw() < 0) {
                        instance.yawSave.put(player, 360 + player.getLocation().getYaw());

                        Bukkit.getServer().dispatchCommand(player, "/copy");

                        player.sendMessage(instance.getPrefix() + " §9Your clipboard direction is now: §e" + (360 + player.getLocation().getYaw()));
                    }else{
                        instance.yawSave.put(player, player.getLocation().getYaw());

                        Bukkit.getServer().dispatchCommand(player, "/copy");

                        player.sendMessage(instance.getPrefix() + " §9Your clipboard direction is now: §e" + player.getLocation().getYaw());
                    }
                }else{
                    player.sendMessage(instance.getPrefix()+" §9Usage§8: §f/simplerotate [direction]");
                    return false;
                }
            }else{
                player.sendMessage(instance.getPrefix()+" §9Usage§8: §f/simplerotate [direction]");
                return false;
            }
        }else if(command.getName().equalsIgnoreCase("srd")) {
            if(!player.hasPermission("simplerotate.command")) {
                player.sendMessage(instance.getPrefix()+" §cYou don't have permissions to do that! §e--> simplerotate.command");
                return false;
            }

            if(args.length==0) {
                if(player.getLocation().getYaw() < 0) {
                    instance.yawSave.put(player, 360 + player.getLocation().getYaw());

                    Bukkit.getServer().dispatchCommand(player, "/copy");

                    player.sendMessage(instance.getPrefix() + " §9Your clipboard direction is now: §e" + (360 + player.getLocation().getYaw()));
                }else{
                    instance.yawSave.put(player, player.getLocation().getYaw());

                    Bukkit.getServer().dispatchCommand(player, "/copy");

                    player.sendMessage(instance.getPrefix() + " §9Your clipboard direction is now: §e" + player.getLocation().getYaw());
                }
            }else{
                player.sendMessage(instance.getPrefix()+" §9Usage§8: §f/srd");
            }
        }
        return false;
    }
}
