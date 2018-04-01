package de.nextround.nextrotate.utils;

import com.sk89q.worldedit.extent.clipboard.Clipboard;
import de.nextround.nextrotate.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class fastRotate {

    private Main instance;

    public fastRotate(Main instance) {
        this.instance = instance;
    }

    public void justRotate(final Player player, Clipboard clipboard) {
        float firstyaw = convertYaw(instance.yawSave.get(player));
        float secyaw = convertYaw(player.getLocation().getYaw());

        final float pitch = player.getLocation().getPitch();

        final float difference = firstyaw - secyaw;

        if((firstyaw > 0 && firstyaw < 45) || (firstyaw < 360 && firstyaw > 315)) {

            System.out.println("CASE1: FIRSTYAW: "+firstyaw+" SECYAW: "+secyaw+" PITCH: "+pitch+" DIFFERENCE: "+difference);

            player.sendMessage(instance.getPrefix() + " §e25%");

            Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                public void run() {
                    Bukkit.getServer().dispatchCommand(player, "/rotate 0 " + pitch *(-1) + " 0");

                    player.sendMessage(instance.getPrefix() + " §e50%");

                    Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                        public void run() {
                            Bukkit.getServer().dispatchCommand(player, "/rotate " + difference *(-1) + " 0 0");

                            player.sendMessage(instance.getPrefix() + " §e75%");

                            Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                                public void run() {

                                    Bukkit.getServer().dispatchCommand(player, "/paste");

                                    player.sendMessage(instance.getPrefix() + " §e100%");
                                }
                            }, 10);
                        }
                    }, 10);
                }
            }, getTick(clipboard));
        }else if(firstyaw > 45 && firstyaw < 135) {

            System.out.println("CASE2: FIRSTYAW: "+firstyaw+" SECYAW: "+secyaw+" PITCH: "+pitch+" DIFFERENCE: "+difference);

            player.sendMessage(instance.getPrefix() + " §e25%");

            Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                public void run() {
                    Bukkit.getServer().dispatchCommand(player, "/rotate 0 0 " + pitch *(-1));

                    player.sendMessage(instance.getPrefix() + " §e50%");

                    Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                        public void run() {
                            Bukkit.getServer().dispatchCommand(player, "/rotate " + difference *(-1) + " 0 0");

                            player.sendMessage(instance.getPrefix() + " §e75%");

                            Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                                public void run() {

                                    Bukkit.getServer().dispatchCommand(player, "/paste");

                                    player.sendMessage(instance.getPrefix() + " §e100%");
                                }
                            }, 10);
                        }
                    },10);
                }
            }, getTick(clipboard));
        }else if(firstyaw > 135 && firstyaw < 225) {

            System.out.println("CASE3: FIRSTYAW: "+firstyaw+" SECYAW: "+secyaw+" PITCH: "+pitch+" DIFFERENCE: "+difference);

            player.sendMessage(instance.getPrefix() + " §e25%");

            Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                public void run() {
                    Bukkit.getServer().dispatchCommand(player, "/rotate 0 " + pitch + " 0");

                    player.sendMessage(instance.getPrefix() + " §e50%");

                    Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                        public void run() {
                            Bukkit.getServer().dispatchCommand(player, "/rotate " + difference *(-1) + " 0 0");

                            player.sendMessage(instance.getPrefix() + " §e75%");

                            Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                                public void run() {

                                    Bukkit.getServer().dispatchCommand(player, "/paste");

                                    player.sendMessage(instance.getPrefix() + " §e100%");
                                }
                            }, 10);
                        }
                    },10);
                }
            }, getTick(clipboard));
        }else if(firstyaw > 225 && firstyaw < 315) {

            System.out.println("CASE4: FIRSTYAW: "+firstyaw+" SECYAW: "+secyaw+" PITCH: "+pitch+" DIFFERENCE: "+difference);

            player.sendMessage(instance.getPrefix() + " §e25%");

            Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                public void run() {
                    Bukkit.getServer().dispatchCommand(player, "/rotate 0 0 " + pitch);

                    player.sendMessage(instance.getPrefix() + " §e50%");

                    Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                        public void run() {
                            Bukkit.getServer().dispatchCommand(player, "/rotate " + difference *(-1) + " 0 0");

                            player.sendMessage(instance.getPrefix() + " §e75%");

                            Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                                public void run() {

                                    Bukkit.getServer().dispatchCommand(player, "/paste");

                                    player.sendMessage(instance.getPrefix() + " §e100%");
                                }
                            }, 10);
                        }
                    }, 10);
                }
            },getTick(clipboard));
        }
    }

    public float convertYaw(float yaw) {
        if(yaw < 0) {
            return 360 + yaw;
        }
        return yaw;
    }

    public int getTick(Clipboard clipboard) {
        int area = clipboard.getRegion().getWidth() * clipboard.getRegion().getHeight() * clipboard.getRegion().getLength();

        if(area < 1000) {
            return 15;
        }else if(area > 1000 && area < 5000) {
            return 20;
        }else if(area > 5000 && area < 10000) {
            return 25;
        }else if(area > 10000) {
            return 35;
        }
        return 20;
    }

}
