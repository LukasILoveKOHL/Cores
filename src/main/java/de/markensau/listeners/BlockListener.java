package de.markensau.listeners;

import de.markensau.main.Main;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * ©2016-2020 LvckyWorld - By StossenHDYT all Rights reserved
 * Licensed to Iven Schlenther & Lukas Oetken
 **/
public class BlockListener implements Listener {

    public BlockListener(Main main) {
        main.getServer().getPluginManager().registerEvents(this, main);
    }

    public static int shed;
    public static int xp;

    public static void gameEnd(String team) {
        xp = 11;

        for (Player all : Bukkit.getOnlinePlayers()) {
            all.sendMessage(Main.p + "Das Team " + team + " hat gewonnen!");
        }
        shed = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                if (xp <= 0) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        Bukkit.getScheduler().cancelAllTasks();
                        all.setGameMode(GameMode.SPECTATOR);

                        ByteArrayOutputStream b = new ByteArrayOutputStream();
                        DataOutputStream out = new DataOutputStream(b);

                        //try {
                        //   out.writeUTF("Connect");
                        //     out.writeUTF("NAME");
                        // } catch (IOException e) {
                        //    e.printStackTrace();
                        // }
                        //all.sendPluginMessage(Main.getInstance(),"Bungeecord",b.toByteArray());
                        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                Main.getInstance().getServer().shutdown();
                            }
                        }, 5);
                    }
                } else {
                    xp--;
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.sendMessage(Main.p + "Der Server starte in " + xp + " Sekunden neu!");
                    }
                }

            }
        }, 0, 20);

    }

    @EventHandler()
    public void onbreak(BlockBreakEvent e) {
        Player p = (Player) e.getPlayer();
        org.bukkit.block.Block b = (Block) e.getBlock();
        if (b.getType() == Material.BEACON) {
            Location coreB1 = Main.readSpawnFromConfig("blue", 1);
            Location coreB2 = Main.readSpawnFromConfig("blue", 2);
            Location coreR1 = Main.readSpawnFromConfig("red", 1);
            Location coreR2 = Main.readSpawnFromConfig("red", 2);
            if (b.getLocation().distance(coreB1) <= 6) {

                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.playSound(all.getLocation(), Sound.ENDERDRAGON_DEATH, 15, 15);
                    all.sendMessage(Main.p + "Der Leftcore vom §9Blauen §aTeam wurde Zerstört!");
                    Main.B1isaLive = false;
                    Main.B1isattacked = false;
                    Main.B1isdestroyed = true;

                }

                if (Main.B2isdestroyed == true) {
                    gameEnd("§cRot§a");
                }

            }
            if (b.getLocation().distance(coreB2) <= 6) {
                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.playSound(all.getLocation(), Sound.ENDERDRAGON_DEATH, 15, 15);
                    all.sendMessage(Main.p + "Der Rightcore vom §9Blauen §aTeam wurde Zerstört!");
                    Main.B2isaLive = false;
                    Main.B2isattacked = false;
                    Main.B2isdestroyed = true;
                }

                if (Main.B1isdestroyed == true) {
                    gameEnd("§cRot§a");
                }
            }
            if (b.getLocation().distance(coreR1) <= 6) {
                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.playSound(all.getLocation(), Sound.ENDERDRAGON_DEATH, 15, 15);
                    all.sendMessage(Main.p + "Der Leftcore vom §4Roten §aTeam wurde Zerstört!");
                    Main.R1isaLive = false;
                    Main.R1isattacked = false;
                    Main.R1isdestroyed = true;
                }

                if (Main.R2isdestroyed == true) {
                    gameEnd("§9Blau§a");
                }
            }
            if (b.getLocation().distance(coreR2) <= 6) {
                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.playSound(all.getLocation(), Sound.ENDERDRAGON_DEATH, 15, 15);
                    all.sendMessage(Main.p + "Der Leftcore vom §4Roten §aTeam wurde Zerstört!");
                    Main.R2isaLive = false;
                    Main.R2isattacked = false;
                    Main.R2isdestroyed = true;
                }

                if (Main.R1isdestroyed == true) {
                    gameEnd("§9Blau§a");
                }
            }
        } else if (b.getType() == Material.WOOD) {
            e.setCancelled(false);
        } else if (b.getType() == Material.IRON_BLOCK) {
            e.setCancelled(false);
        } else if (b.getType() == Material.DIAMOND_BLOCK) {
            e.setCancelled(false);
        } else if (b.getType() == Material.CHEST) {
            e.setCancelled(false);
        } else if (b.getType() == Material.ENCHANTMENT_TABLE) {
            e.setCancelled(false);
        } else if (b.getType() == Material.WORKBENCH) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }


    }


}
