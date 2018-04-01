package de.nextround.nextrotate.utils;

import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.math.transform.CombinedTransform;
import com.sk89q.worldedit.math.transform.Transform;
import de.nextround.nextrotate.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class fastRotate {

    private Main instance;

    public fastRotate(Main instance) {
        this.instance = instance;
    }

    public void justRotate(final Player player) {
        float firstyaw = convertYaw(instance.yawSave.get(player));
        float secyaw = convertYaw(player.getLocation().getYaw());

        final float pitch = player.getLocation().getPitch();

        final float difference = firstyaw - secyaw;

        if((firstyaw > 0 && firstyaw < 45) || (firstyaw < 360 && firstyaw > 315)) {

            System.out.println("CASE1: FIRSTYAW: "+firstyaw+" SECYAW: "+secyaw+" PITCH: "+pitch+" DIFFERENCE: "+difference);

            Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                public void run() {
                    Bukkit.getServer().dispatchCommand(player, "/rotate 0 " + pitch *(-1) + " 0");

                    Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                        public void run() {
                            Bukkit.getServer().dispatchCommand(player, "/rotate " + difference *(-1) + " 0 0");

                            Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                                public void run() {

                                    Bukkit.getServer().dispatchCommand(player, "/paste");
                                }
                            }, 20);
                        }
                    }, 20);
                }
            }, 20);
        }else if(firstyaw > 45 && firstyaw < 135) {
            System.out.println("CASE2: FIRSTYAW: "+firstyaw+" SECYAW: "+secyaw+" PITCH: "+pitch+" DIFFERENCE: "+difference);

            Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                public void run() {
                    Bukkit.getServer().dispatchCommand(player, "/rotate 0 0 " + pitch *(-1));

                    Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                        public void run() {
                            Bukkit.getServer().dispatchCommand(player, "/rotate " + difference *(-1) + " 0 0");

                            Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                                public void run() {

                                    Bukkit.getServer().dispatchCommand(player, "/paste");
                                }
                            }, 20);
                        }
                    },20);
                }
            }, 20);
        }else if(firstyaw > 135 && firstyaw < 225) {
            System.out.println("CASE3: FIRSTYAW: "+firstyaw+" SECYAW: "+secyaw+" PITCH: "+pitch+" DIFFERENCE: "+difference);

            Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                public void run() {
                    Bukkit.getServer().dispatchCommand(player, "/rotate 0 " + pitch + " 0");

                    Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                        public void run() {
                            Bukkit.getServer().dispatchCommand(player, "/rotate " + difference *(-1) + " 0 0");

                            Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                                public void run() {

                                    Bukkit.getServer().dispatchCommand(player, "/paste");
                                }
                            }, 20);
                        }
                    },20);
                }
            }, 20);
        }else if(firstyaw > 225 && firstyaw < 315) {
            System.out.println("CASE4: FIRSTYAW: "+firstyaw+" SECYAW: "+secyaw+" PITCH: "+pitch+" DIFFERENCE: "+difference);

            Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                public void run() {
                    Bukkit.getServer().dispatchCommand(player, "/rotate 0 0 " + pitch);

                    Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                        public void run() {
                            Bukkit.getServer().dispatchCommand(player, "/rotate " + difference *(-1) + " 0 0");

                            Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                                public void run() {

                                    Bukkit.getServer().dispatchCommand(player, "/paste");
                                }
                            }, 20);
                        }
                    }, 20);
                }
            },20);

        }
    }

    public float convertYaw(float yaw) {
        if(yaw < 0) {
            return 360 + yaw;
        }
        return yaw;
    }

}
