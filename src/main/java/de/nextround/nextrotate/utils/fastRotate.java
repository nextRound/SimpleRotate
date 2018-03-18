package de.nextround.nextrotate.utils;

import de.nextround.nextrotate.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class fastRotate {

    private Main instance;

    public fastRotate(Main instance) {
        this.instance = instance;
    }

    public void rotate(final Player player) {
        float clipdirection = instance.yawSave.get(player);
        float yaw = player.getLocation().getYaw();
        float pitch = player.getLocation().getPitch() * (-1);

        if(yaw < 0) {
            float degreeyaw = 360 + yaw;

            if (degreeyaw > clipdirection) {
                float difference = degreeyaw - clipdirection;

                Bukkit.getServer().dispatchCommand(player, "/rotate "+difference+" 0 "+pitch);

                Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                    public void run() {
                        Bukkit.getServer().dispatchCommand(player, "/paste");
                    }
                }, 10);
            } else {
                float difference = clipdirection - degreeyaw;

                Bukkit.getServer().dispatchCommand(player, "/rotate "+difference*(-1)+" 0 "+pitch);

                Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                    public void run() {
                        Bukkit.getServer().dispatchCommand(player, "/paste");
                    }
                }, 10);
            }
        }else{
            if (yaw > clipdirection) {
                float difference = yaw - clipdirection;

                Bukkit.getServer().dispatchCommand(player, "/rotate "+difference+" 0 "+pitch);

                Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                    public void run() {
                        Bukkit.getServer().dispatchCommand(player, "/paste");
                    }
                }, 10);
            } else {
                float difference = clipdirection - yaw;

                Bukkit.getServer().dispatchCommand(player, "/rotate "+difference*(-1)+" 0 "+pitch);

                Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                    public void run() {
                        Bukkit.getServer().dispatchCommand(player, "/paste");
                    }
                }, 10);
            }
        }
    }
}
