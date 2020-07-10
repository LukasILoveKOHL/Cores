package de.markensau.main;

import de.markensau.listeners.JoinListener;
import de.markensau.listeners.TeamChoose;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * ©2016-2020 LvckyWorld - By StossenHDYT all Rights reserved
 * Licensed to Iven Schlenther & Lukas Oetken
 **/
public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("Cores wurde geladen!");
        instance = this;
        new JoinListener(this);
        new TeamChoose(this);
        new CoresBuild(this);

    }
    public static String p = "§7[§aLvcky§fCores§7] §a";

    public static boolean build = false;

    public static Main instance;
    public static Main getInstance(){
        return instance;
    }





    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args){
        Player p = (Player) s;

        if (cmd.getName().equalsIgnoreCase("cores")){
            if (p.hasPermission("cores.*")){
                if (args.length == 0) {
                    p.sendMessage(Main.p + "Bitte benutze /cores setspawn lobby | rot | blau");
                } else if (args.length >= 1) {
                    if (args[0].equalsIgnoreCase("setspawn")) {
                        if (args[1].equalsIgnoreCase("red") || args[1].equalsIgnoreCase("blue") || args[1].equalsIgnoreCase("lobby") || args[1].equalsIgnoreCase("spec")) {
                            double x = p.getLocation().getX();
                            double y = p.getLocation().getY();
                            double z = p.getLocation().getZ();
                            String w = p.getWorld().getName();

                            float yaw = p.getLocation().getYaw();
                            float pitch = p.getLocation().getPitch();

                            getConfig().set("cores.spawn." + args[1] + ".X", x);
                            getConfig().set("cores.spawn." + args[1] + ".Y", y);
                            getConfig().set("cores.spawn." + args[1] + ".Z", z);
                            getConfig().set("cores.spawn." + args[1] + ".World", w);
                            getConfig().set("cores.spawn." + args[1] + ".Yaw", yaw);
                            getConfig().set("cores.spawn." + args[1] + ".Pitch", pitch);
                            saveConfig();

                            p.sendMessage(Main.p + "Der Spawnpunkt für §6" + args[1] + " §awurde hinzu gefügt!");

                        } else {
                            p.sendMessage(Main.p + "/cores lobby | blue | red");
                        }
                    } else if (args[0].equalsIgnoreCase("start")) {
                        if (p.hasPermission("cores.start")) {
                            if (JoinListener.xp >= 6) {
                                JoinListener.xp = 6;
                                p.sendMessage(Main.p + "Du hast das Spiel erfolgreich gestartet!");
                            }else {
                                p.sendMessage(Main.p + "§4Das Spielt startet bereits!");
                            }

                        } else {
                            p.sendMessage(Main.p + "§4Dazu hast du keine Rechte!");
                        }
                    }else if (args[0].equalsIgnoreCase("build")){
                        if (p.hasPermission("cores.build")){
                            if (build == false){
                                build = true;
                                p.sendMessage(Main.p + "Du kannst nun bauen!");
                            }else {
                                build = false;
                                p.sendMessage(Main.p + "Du kannst nun nicht mehr bauen!");
                            }
                        }else {
                            p.sendMessage(Main.p + "§4Dazu hast du keine Rechte!");
                        }
                    }
                }
            } else {
                p.sendMessage(Main.p + "§4Dazu hast du keine Rechte!");

            }
        }else if (cmd.getName().equalsIgnoreCase("start")){
            if (p.hasPermission("cores.start")){
                if (JoinListener.xp >= 6) {
                    JoinListener.xp = 6;
                    p.sendMessage(Main.p + "Du hast das Spiel erfolgreich gestartet!");
                }else {
                    p.sendMessage(Main.p + "§4Das Spielt startet bereits!");
                }
            }else {
                p.sendMessage(Main.p + "§4Dazu hast du keine Rechte!");
            }
        }


        return true;
    }


}
