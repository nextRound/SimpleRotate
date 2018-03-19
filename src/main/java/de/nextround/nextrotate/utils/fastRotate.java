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
        float clipdirection = instance.yawSave.get(player) * (-1);

        float yaw = player.getLocation().getYaw() * (-1);
        final float pitch = player.getLocation().getPitch() * (-1);

        if (clipdirection > 0) {
            if (yaw > clipdirection) {
                final float difference = yaw - clipdirection;

                if (instance.yawSave.get(player) <= -45 && instance.yawSave.get(player) >= -135) {

                    System.out.println("Yaw: "+yaw+" Pitch: "+pitch+" Clipdirection: "+clipdirection+" Difference: "+difference);

                    if (yaw > 180 && yaw < 360) {
                        Bukkit.getServer().dispatchCommand(player, "/rotate " + difference * (-1) + " 0 " + pitch * (-1));

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                Bukkit.getServer().dispatchCommand(player, "/paste");
                            }
                        }, 10);
                    } else {
                        Bukkit.getServer().dispatchCommand(player, "/rotate " + difference * (-1) + " 0 " + pitch * (-1));

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                Bukkit.getServer().dispatchCommand(player, "/paste");
                            }
                        }, 10);
                    }
                } else if (instance.yawSave.get(player) <= -225 && instance.yawSave.get(player) >= -315) {

                    System.out.println("Yaw: "+yaw+" Pitch: "+pitch+" Clipdirection: "+clipdirection+" Difference: "+difference);

                    if (yaw > 180 && yaw < 360) {
                        Bukkit.getServer().dispatchCommand(player, "/rotate " + difference * (-1) + " 0 " + pitch);

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                Bukkit.getServer().dispatchCommand(player, "/paste");
                            }
                        }, 10);
                    } else {
                        Bukkit.getServer().dispatchCommand(player, "/rotate " + difference + " 0 " + pitch);

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                Bukkit.getServer().dispatchCommand(player, "/paste");
                            }
                        }, 10);
                    }
                } else if (instance.yawSave.get(player) <= -135 && instance.yawSave.get(player) >= -225) {

                    System.out.println("Yaw: "+yaw+" Pitch: "+pitch+" Clipdirection: "+clipdirection+" Difference: "+difference);

                    if (yaw > 180 && yaw < 360) {
                        Bukkit.getServer().dispatchCommand(player, "/rotate " + difference * (-1) + " " + pitch * (-1) + " 0 ");

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                Bukkit.getServer().dispatchCommand(player, "/paste");
                            }
                        }, 10);

                    } else {
                        Bukkit.getServer().dispatchCommand(player, "/rotate " + difference + " " + pitch * (-1) + " 0 ");

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                Bukkit.getServer().dispatchCommand(player, "/paste");
                            }
                        }, 10);
                    }
                } else if ((instance.yawSave.get(player) >= -45 && instance.yawSave.get(player) <= 0) || (instance.yawSave.get(player) <= -315 && instance.yawSave.get(player) >= -360)) {

                    System.out.println("Yaw: "+yaw+" Pitch: "+pitch+" Clipdirection: "+clipdirection+" Difference: "+difference);

                    if (yaw > 180 && yaw < 360) {
                        Bukkit.getServer().dispatchCommand(player, "/rotate " + difference * (-1) + " " + pitch + " 0 ");

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                Bukkit.getServer().dispatchCommand(player, "/paste");
                            }
                        }, 10);

                    } else {
                        if (clipdirection > 0 && clipdirection < 45) {
                            Bukkit.getServer().dispatchCommand(player, "/rotate " + difference * (-1) + " " + pitch + " 0 ");

                            Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                                public void run() {
                                    Bukkit.getServer().dispatchCommand(player, "/paste");
                                }
                            }, 10);
                        } else {
                            Bukkit.getServer().dispatchCommand(player, "/rotate " + difference + " " + pitch + " 0 ");

                            Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                                public void run() {
                                    Bukkit.getServer().dispatchCommand(player, "/paste");
                                }
                            }, 10);
                        }
                    }
                }
            } else {
                final float difference = clipdirection - yaw;
                if (instance.yawSave.get(player) <= -45 && instance.yawSave.get(player) >= -135) {
                    if (yaw > 180 && yaw < 360) {
                        Bukkit.getServer().dispatchCommand(player, "/rotate " + difference * (-1) + " 0 " + pitch * (-1));

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                Bukkit.getServer().dispatchCommand(player, "/paste");
                            }
                        }, 10);
                    } else {
                        Bukkit.getServer().dispatchCommand(player, "/rotate " + difference + " 0 " + pitch * (-1));

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                Bukkit.getServer().dispatchCommand(player, "/paste");
                            }
                        }, 10);
                    }
                } else if (instance.yawSave.get(player) <= -225 && instance.yawSave.get(player) >= -315) {
                    if (yaw > 180 && yaw < 360) {
                        Bukkit.getServer().dispatchCommand(player, "/rotate " + difference + " 0 " + pitch);

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                Bukkit.getServer().dispatchCommand(player, "/paste");
                            }
                        }, 10);
                    } else {
                        Bukkit.getServer().dispatchCommand(player, "/rotate " + difference + " 0 " + pitch);

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                Bukkit.getServer().dispatchCommand(player, "/paste");
                            }
                        }, 10);
                    }
                } else if (instance.yawSave.get(player) <= -135 && instance.yawSave.get(player) >= -225) {
                    if (yaw > 180 && yaw < 360) {
                        Bukkit.getServer().dispatchCommand(player, "/rotate " + difference * (-1) + " " + pitch * (-1) + " 0 ");

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                Bukkit.getServer().dispatchCommand(player, "/paste");
                            }
                        }, 10);

                    } else {
                        Bukkit.getServer().dispatchCommand(player, "/rotate " + difference + " " + pitch * (-1) + " 0 ");

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                Bukkit.getServer().dispatchCommand(player, "/paste");
                            }
                        }, 10);
                    }
                } else if ((instance.yawSave.get(player) >= -45 && instance.yawSave.get(player) <= 0) || (instance.yawSave.get(player) <= -315 && instance.yawSave.get(player) >= -360)) {
                    if (yaw > 180 && yaw < 360) {
                        Bukkit.getServer().dispatchCommand(player, "/rotate " + difference + " " + pitch + " 0 ");

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                Bukkit.getServer().dispatchCommand(player, "/paste");
                            }
                        }, 10);

                    } else {
                        if (clipdirection > 0 && clipdirection < 45) {
                            Bukkit.getServer().dispatchCommand(player, "/rotate " + difference + " " + pitch + " 0 ");

                            Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                                public void run() {
                                    Bukkit.getServer().dispatchCommand(player, "/paste");
                                }
                            }, 10);
                        } else {
                            Bukkit.getServer().dispatchCommand(player, "/rotate " + difference + " " + pitch + " 0 ");

                            Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                                public void run() {
                                    Bukkit.getServer().dispatchCommand(player, "/paste");
                                }
                            }, 10);
                        }
                    }
                }
            }
        }else{
            clipdirection = 360 + clipdirection;
            yaw = 360 + yaw;

            if (yaw > clipdirection) {
                final float difference = yaw - clipdirection;

                if (-360+instance.yawSave.get(player) <= -45 && -360+instance.yawSave.get(player) >= -135) {

                    System.out.println("Yaw: "+yaw+" Pitch: "+pitch+" Clipdirection: "+clipdirection+" Difference: "+difference);

                    if (yaw > 180 && yaw < 360) {
                        Bukkit.getServer().dispatchCommand(player, "/rotate " + difference * (-1) + " 0 " + pitch * (-1));

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                Bukkit.getServer().dispatchCommand(player, "/paste");
                            }
                        }, 10);
                    } else {
                        Bukkit.getServer().dispatchCommand(player, "/rotate " + difference * (-1) + " 0 " + pitch * (-1));

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                Bukkit.getServer().dispatchCommand(player, "/paste");
                            }
                        }, 10);
                    }
                } else if (-360+instance.yawSave.get(player) <= -225 && -360+instance.yawSave.get(player) >= -315) {

                    System.out.println("Yaw: "+yaw+" Pitch: "+pitch+" Clipdirection: "+clipdirection+" Difference: "+difference);

                    if (yaw > 180 && yaw < 360) {
                        Bukkit.getServer().dispatchCommand(player, "/rotate " + difference * (-1) + " 0 " + pitch);

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                Bukkit.getServer().dispatchCommand(player, "/paste");
                            }
                        }, 10);
                    } else {
                        Bukkit.getServer().dispatchCommand(player, "/rotate " + difference + " 0 " + pitch);

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                Bukkit.getServer().dispatchCommand(player, "/paste");
                            }
                        }, 10);
                    }
                } else if (-360+instance.yawSave.get(player) <= -135 && -360+instance.yawSave.get(player) >= -225) {

                    System.out.println("Yaw: "+yaw+" Pitch: "+pitch+" Clipdirection: "+clipdirection+" Difference: "+difference);

                    if (yaw > 180 && yaw < 360) {
                        Bukkit.getServer().dispatchCommand(player, "/rotate " + difference * (-1) + " " + pitch * (-1) + " 0 ");

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                Bukkit.getServer().dispatchCommand(player, "/paste");
                            }
                        }, 10);
                    } else {
                        Bukkit.getServer().dispatchCommand(player, "/rotate " + difference + " " + pitch * (-1) + " 0 ");

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                Bukkit.getServer().dispatchCommand(player, "/paste");
                            }
                        }, 10);
                    }
                } else if ((-360+instance.yawSave.get(player) >= -45 && -360+instance.yawSave.get(player) <= 0) || (-360+instance.yawSave.get(player) <= -315 && -360+instance.yawSave.get(player) >= -360)) {

                    System.out.println("Yaw: "+yaw+" Pitch: "+pitch+" Clipdirection: "+clipdirection+" Difference: "+difference);

                    if (yaw > 180 && yaw < 360) {
                        Bukkit.getServer().dispatchCommand(player, "/rotate " + difference * (-1) + " " + pitch + " 0 ");

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                Bukkit.getServer().dispatchCommand(player, "/paste");
                            }
                        }, 10);
                    } else {
                        if (clipdirection > 0 && clipdirection < 45) {
                            Bukkit.getServer().dispatchCommand(player, "/rotate " + difference * (-1) + " " + pitch + " 0 ");

                            Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                                public void run() {
                                    Bukkit.getServer().dispatchCommand(player, "/paste");
                                }
                            }, 10);
                        } else {
                            Bukkit.getServer().dispatchCommand(player, "/rotate " + difference + " " + pitch + " 0 ");

                            Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                                public void run() {
                                    Bukkit.getServer().dispatchCommand(player, "/paste");
                                }
                            }, 10);
                        }
                    }
                }
            } else {
                final float difference = clipdirection - yaw;

                if (-360+instance.yawSave.get(player) <= -45 && -360+instance.yawSave.get(player) >= -135) {

                    System.out.println("Yaw: "+yaw+" Pitch: "+pitch+" Clipdirection: "+clipdirection+" Difference: "+difference);

                    if (yaw > 180 && yaw < 360) {
                        Bukkit.getServer().dispatchCommand(player, "/rotate " + difference * (-1) + " 0 " + pitch * (-1));

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                Bukkit.getServer().dispatchCommand(player, "/paste");
                            }
                        }, 10);
                    } else {
                        Bukkit.getServer().dispatchCommand(player, "/rotate " + difference + " 0 " + pitch * (-1));

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                Bukkit.getServer().dispatchCommand(player, "/paste");
                            }
                        }, 10);
                    }
                } else if (-360+instance.yawSave.get(player) <= -225 && -360+instance.yawSave.get(player) >= -315) {

                    System.out.println("Yaw: "+yaw+" Pitch: "+pitch+" Clipdirection: "+clipdirection+" Difference: "+difference);

                    if (yaw > 180 && yaw < 360) {
                        Bukkit.getServer().dispatchCommand(player, "/rotate " + difference + " 0 " + pitch);

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                Bukkit.getServer().dispatchCommand(player, "/paste");
                            }
                        }, 10);
                    } else {
                        Bukkit.getServer().dispatchCommand(player, "/rotate " + difference + " 0 " + pitch);

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                Bukkit.getServer().dispatchCommand(player, "/paste");
                            }
                        }, 10);
                    }
                } else if (-360+instance.yawSave.get(player) <= -135 && -360+instance.yawSave.get(player) >= -225) {

                    System.out.println("Yaw: "+yaw+" Pitch: "+pitch+" Clipdirection: "+clipdirection+" Difference: "+difference);

                    if (yaw > 180 && yaw < 360) {
                        Bukkit.getServer().dispatchCommand(player, "/rotate " + difference * (-1) + " " + pitch * (-1) + " 0 ");

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                Bukkit.getServer().dispatchCommand(player, "/paste");
                            }
                        }, 10);

                    } else {
                        Bukkit.getServer().dispatchCommand(player, "/rotate " + difference + " " + pitch * (-1) + " 0 ");

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                Bukkit.getServer().dispatchCommand(player, "/paste");
                            }
                        }, 10);
                    }
                } else if ((-360+instance.yawSave.get(player) >= -45 && -360+instance.yawSave.get(player) <= 0) || (-360+instance.yawSave.get(player) <= -315 && -360+instance.yawSave.get(player) >= -360)) {

                    System.out.println("Yaw: "+yaw+" Pitch: "+pitch+" Clipdirection: "+clipdirection+" Difference: "+difference);

                    if (yaw > 180 && yaw < 360) {
                        Bukkit.getServer().dispatchCommand(player, "/rotate " + difference + " " + pitch + " 0 ");

                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            public void run() {
                                Bukkit.getServer().dispatchCommand(player, "/paste");
                            }
                        }, 10);

                    } else {
                        if (clipdirection > 0 && clipdirection < 45) {
                            Bukkit.getServer().dispatchCommand(player, "/rotate " + difference + " " + pitch + " 0 ");

                            Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                                public void run() {
                                    Bukkit.getServer().dispatchCommand(player, "/paste");
                                }
                            }, 10);
                        } else {
                            Bukkit.getServer().dispatchCommand(player, "/rotate " + difference + " " + pitch + " 0 ");

                            Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                                public void run() {
                                    Bukkit.getServer().dispatchCommand(player, "/paste");
                                }
                            }, 10);
                        }
                    }
                }
            }
        }
    }
}
