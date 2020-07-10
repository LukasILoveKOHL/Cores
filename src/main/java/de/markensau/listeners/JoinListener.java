package de.markensau.listeners;

import com.google.gson.internal.$Gson$Preconditions;
import de.markensau.main.Main;
import org.bukkit.*;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * ©2016-2020 LvckyWorld - By StossenHDYT all Rights reserved
 * Licensed to Iven Schlenther & Lukas Oetken
 **/
public class JoinListener implements Listener {


    public JoinListener(Main main) {
        main.getServer().getPluginManager().registerEvents(this, main);
    }

    public static int xp;
    public static int allplayer;
    public static int sched;
    public static boolean damagecancelled = true;
    public static boolean damageblockcancelled = true;
    public static boolean gamestart = true;

    public static boolean respawn = true;

    public boolean isRunning = false;

    public static void count() {
        xp = 31;
        allplayer = Bukkit.getOnlinePlayers().size();
        for (Player all : Bukkit.getOnlinePlayers()) {
            System.out.println(allplayer);
            if (allplayer >= 1){
                sched = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
                    public void run() {

                        xp--;
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            all.setLevel(xp);
                        }

                        if (xp == 30) {
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                all.sendMessage(Main.p + "Das Spiel startet in §6" + xp + " §aSekunden");
                                damagecancelled = true;
                                damageblockcancelled = true;
                                gamestart = true;
                            }
                        } else if (xp == 10) {
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                all.sendMessage(Main.p + "Das Spiel startet in §6" + xp + " §aSekunden");
                                damagecancelled = true;
                                damageblockcancelled = true;
                            }
                        } else if (xp == 5) {
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                all.sendMessage(Main.p + "Das Spiel startet in §6" + xp + " §aSekunden");
                                damagecancelled = true;
                                damageblockcancelled = true;
                            }
                        } else if (xp == 4) {
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                all.sendMessage(Main.p + "Das Spiel startet in §6" + xp + " §aSekunden");
                            }
                        } else if (xp == 3) {
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                all.sendMessage(Main.p + "Das Spiel startet in §6" + xp + " §aSekunden");
                            }
                        } else if (xp == 2) {
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                all.sendMessage(Main.p + "Das Spiel startet in §6" + xp + " §aSekunden");
                            }
                        } else if (xp == 1) {
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                all.sendMessage(Main.p + "Das Spiel startet in §6" + xp + " §aSekunden");
                            }
                        }

                        if (xp == 0) {
                            if (Bukkit.getOnlinePlayers().size() >= 1) {

                                //Spiel Starten
                                for (Player all : Bukkit.getOnlinePlayers()) {
                                    if (TeamChoose.teams.get(all.getName()).equals("red")) {

                                        double x = Main.instance.getConfig().getDouble("cores.spawn.red.X");
                                        double y = Main.instance.getConfig().getDouble("cores.spawn.red.Y");
                                        double z = Main.instance.getConfig().getDouble("cores.spawn.red.Z");
                                        String w = Main.instance.getConfig().getString("cores.spawn.red.World");
                                        float yaw = (float) Main.instance.getConfig().getDouble("cores.spawn.red.Yaw");
                                        float pitch = (float) Main.instance.getConfig().getDouble("cores.spawn.red.Pitch");
                                        World world = Bukkit.getWorld(w);
                                        Location loc = new Location(world, x, y, z, yaw, pitch);
                                        all.teleport(loc);

                                    } else {
                                        double x = (double) Main.getInstance().getConfig().getDouble("cores.spawn.blue.X");
                                        double y = (double) Main.getInstance().getConfig().getDouble("cores.spawn.blue.Y");
                                        double z = (double) Main.getInstance().getConfig().getDouble("cores.spawn.blue.Z");
                                        String w = (String) Main.getInstance().getConfig().getString("cores.spawn.blue.World");
                                        float yaw = (float) Main.getInstance().getConfig().getDouble("cores.spawn.blue.Yaw");
                                        float pitch = (float) Main.getInstance().getConfig().getDouble("cores.spawn.blue.Pitch");
                                        World world = Bukkit.getWorld(w);
                                        Location loc = new Location(world, x, y, z, yaw, pitch);
                                        all.teleport(loc);
                                    }

                                    all.getInventory().clear();

                                    all.getInventory().setItem(0, new ItemStack(Material.STONE_SWORD));
                                    all.getInventory().setItem(1, new ItemStack(Material.STONE_PICKAXE));
                                    all.getInventory().setItem(2, new ItemStack(Material.BOW));
                                    all.getInventory().setItem(3, new ItemStack(Material.STONE_AXE));
                                    all.getInventory().setItem(8, new ItemStack(Material.GOLDEN_APPLE, 16));
                                    all.getInventory().setItem(22, new ItemStack(Material.ARROW, 12));


                                    if (TeamChoose.teams.get(all.getName()).equals("red")) {

                                        all.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET, DyeColor.RED.getData()));
                                        all.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, DyeColor.RED.getData()));
                                        all.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, DyeColor.RED.getData()));
                                        all.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS, DyeColor.RED.getData()));

                                    } else {
                                        all.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET, DyeColor.BLUE.getData()));
                                        all.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, DyeColor.BLUE.getData()));
                                        all.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, DyeColor.BLUE.getData()));
                                        all.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS, DyeColor.BLUE.getData()));
                                    }

                                    damagecancelled = false;
                                    damageblockcancelled = false;
                                    respawn = false;
                                    gamestart = false;

                                    all.setHealth(20);
                                    all.setFoodLevel(20);

                                }

                            } else {
                                Bukkit.getScheduler().cancelTask(sched);
                                Bukkit.getScheduler().cancelTasks(Main.instance);
                                count();
                            }
                        }

                    }
                }, 0, 20);
            }else {
                Bukkit.getScheduler().cancelTask(sched);
                Bukkit.getScheduler().cancelTasks(Main.instance);
            }
        }
    }

    @EventHandler()
    public void onJoin(PlayerJoinEvent e) {
        Player p = (Player) e.getPlayer();
        e.setJoinMessage("");
        if (gamestart == true) {
            p.setGameMode(GameMode.SURVIVAL);
            p.setHealth(20);
            p.setFoodLevel(20);
            e.setJoinMessage(Main.p + "Der Spieler §6" + e.getPlayer().getDisplayName() + " §aist dem Spiel Beigetreten");
            p.sendMessage(Main.p + "Willkommen §6" + e.getPlayer().getDisplayName() + "§a bei Cores!");

            if (!isRunning) {
                isRunning = true;
                count();
            }

            TeamChoose.teams.put(p.getName(), "undecided");

            double x = (double) Main.getInstance().getConfig().getDouble("cores.spawn.lobby.X");
            double y = (double) Main.getInstance().getConfig().getDouble("cores.spawn.lobby.Y");
            double z = (double) Main.getInstance().getConfig().getDouble("cores.spawn.lobby.Z");
            String w = (String) Main.getInstance().getConfig().getString("cores.spawn.lobby.World");
            float yaw = (float) Main.getInstance().getConfig().getDouble("cores.spawn.lobby.Yaw");
            float pitch = (float) Main.getInstance().getConfig().getDouble("cores.spawn.lobby.Pitch");
            World world = Bukkit.getWorld(w);
            Location loc = new Location(world, x, y, z, yaw, pitch);
            p.teleport(loc);

        } else {
            p.setGameMode(GameMode.SPECTATOR);
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.hidePlayer(p);
                p.getInventory().clear();
                try {
                    p.setFlySpeed(2);
                } catch (Exception e1) {

                }
                TeamChoose.teams.put(p.getName(), "undecided");

                double x = (double) Main.getInstance().getConfig().getDouble("cores.spawn.spec.X");
                double y = (double) Main.getInstance().getConfig().getDouble("cores.spawn.spec.Y");
                double z = (double) Main.getInstance().getConfig().getDouble("cores.spawn.spec.Z");
                String w = (String) Main.getInstance().getConfig().getString("cores.spawn.spec.World");
                float yaw = (float) Main.getInstance().getConfig().getDouble("cores.spawn.spec.Yaw");
                float pitch = (float) Main.getInstance().getConfig().getDouble("cores.spawn.spec.Pitch");
                World world = Bukkit.getWorld(w);
                Location loc1 = new Location(world, x, y, z, yaw, pitch);
                p.teleport(loc1);
            }
        }


    }


}


