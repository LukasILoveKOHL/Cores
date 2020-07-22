package de.markensau.listeners;

import de.markensau.main.Main;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

/**
 * ©2016-2020 LvckyWorld - By StossenHDYT all Rights reserved
 * Licensed to Iven Schlenther & Lukas Oetken
 **/
public class UsefullListeners implements Listener {

    public UsefullListeners(Main main) {
        main.getServer().getPluginManager().registerEvents(this, main);
    }

    public HashMap<String, String> lastTouched = new HashMap<>();


    @EventHandler()
    public void onkill(PlayerDeathEvent e) {
        Player p = (Player) e.getEntity();

        Player killer = (Player) p.getKiller();
        p.getInventory().clear();
        try {
            if (killer == null) {
                p.sendMessage(Main.p + "Du wurdest von §c " + killer.getDisplayName() + " §agetötet");
                killer.sendMessage(Main.p + "Du hast den Spieler §c " + p.getDisplayName() + " §agetötet");
            } else {
                if (TeamChoose.teams.get(p.getName()).equals("red")) {


                    double x = Main.instance.getConfig().getDouble("cores.spawn.red.X");
                    double y = Main.instance.getConfig().getDouble("cores.spawn.red.Y");
                    double z = Main.instance.getConfig().getDouble("cores.spawn.red.Z");
                    String w = Main.instance.getConfig().getString("cores.spawn.red.World");
                    float yaw = (float) Main.instance.getConfig().getDouble("cores.spawn.red.Yaw");
                    float pitch = (float) Main.instance.getConfig().getDouble("cores.spawn.red.Pitch");
                    World world = Bukkit.getWorld(w);
                    Location loc = new Location(world, x, y, z, yaw, pitch);


                    p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
                    p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                    p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
                    p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
                    p.teleport(loc);
                    TeamChoose.teamred.add(p);
                    p.setHealth(20D);

                } else {
                    double x = (double) Main.getInstance().getConfig().getDouble("cores.spawn.blue.X");
                    double y = (double) Main.getInstance().getConfig().getDouble("cores.spawn.blue.Y");
                    double z = (double) Main.getInstance().getConfig().getDouble("cores.spawn.blue.Z");
                    String w = (String) Main.getInstance().getConfig().getString("cores.spawn.blue.World");
                    float yaw = (float) Main.getInstance().getConfig().getDouble("cores.spawn.blue.Yaw");
                    float pitch = (float) Main.getInstance().getConfig().getDouble("cores.spawn.blue.Pitch");
                    World world = Bukkit.getWorld(w);
                    Location loc = new Location(world, x, y, z, yaw, pitch);


                    p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
                    p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                    p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
                    p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
                    p.teleport(loc);
                    TeamChoose.teamblue.add(p);
                    p.setHealth(20D);
                }
            }
        } catch (Exception e1) {

        }


    }

    @EventHandler()
    public void onRespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();

        p.getInventory().setItem(0, new ItemStack(Material.STONE_SWORD));
        p.getInventory().setItem(1, new ItemStack(Material.STONE_PICKAXE));
        p.getInventory().setItem(2, new ItemStack(Material.BOW));
        p.getInventory().setItem(3, new ItemStack(Material.STONE_AXE));
        p.getInventory().setItem(4, new ItemStack(Material.WOOD, 64));
        p.getInventory().setItem(8, new ItemStack(Material.GOLDEN_APPLE, 16));
        p.getInventory().setItem(22, new ItemStack(Material.ARROW, 12));


        if (TeamChoose.teams.get(p.getName()).equals("red")) {


            double x = Main.instance.getConfig().getDouble("cores.spawn.red.X");
            double y = Main.instance.getConfig().getDouble("cores.spawn.red.Y");
            double z = Main.instance.getConfig().getDouble("cores.spawn.red.Z");
            String w = Main.instance.getConfig().getString("cores.spawn.red.World");
            float yaw = (float) Main.instance.getConfig().getDouble("cores.spawn.red.Yaw");
            float pitch = (float) Main.instance.getConfig().getDouble("cores.spawn.red.Pitch");
            World world = Bukkit.getWorld(w);
            Location loc = new Location(world, x, y, z, yaw, pitch);


            p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
            p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
            p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
            p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
            p.teleport(loc);
            TeamChoose.teamred.add(p);
            p.setHealth(20D);

            e.setRespawnLocation(loc);

        } else {
            double x = (double) Main.getInstance().getConfig().getDouble("cores.spawn.blue.X");
            double y = (double) Main.getInstance().getConfig().getDouble("cores.spawn.blue.Y");
            double z = (double) Main.getInstance().getConfig().getDouble("cores.spawn.blue.Z");
            String w = (String) Main.getInstance().getConfig().getString("cores.spawn.blue.World");
            float yaw = (float) Main.getInstance().getConfig().getDouble("cores.spawn.blue.Yaw");
            float pitch = (float) Main.getInstance().getConfig().getDouble("cores.spawn.blue.Pitch");
            World world = Bukkit.getWorld(w);
            Location loc = new Location(world, x, y, z, yaw, pitch);


            p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
            p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
            p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
            p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
            p.teleport(loc);
            TeamChoose.teamblue.add(p);
            p.setHealth(20D);

            e.setRespawnLocation(loc);
        }
    }


    @EventHandler()
    public void entityd(EntityDamageByEntityEvent e) {
        Player p = (Player) e.getEntity();
        Player killer = (Player) e.getDamager();
        if (killer instanceof Player) {
            if (JoinListener.damageblockcancelled == true) {
                lastTouched.put(p.getName(), killer.getName());
                e.setCancelled(true);
            }
            if (TeamChoose.teamblue.contains(killer)) {
                lastTouched.put(p.getName(), killer.getName());
                e.setCancelled(true);
            }
            if (TeamChoose.teamred.contains(killer)) {
                lastTouched.put(p.getName(), killer.getName());
                e.setCancelled(true);
            } else {
                e.setCancelled(false);
            }
        } else {

        }


    }

    @EventHandler()
    public void onkill(PlayerMoveEvent e) {
        Player p = (Player) e.getPlayer();
        if (p.getLocation().getY() <= 0) {
            try {
                Player killer = Bukkit.getPlayer(lastTouched.get(p.getName()));
                p.sendMessage(Main.p + "Du wurdest von §c " + killer.getDisplayName() + " §agetötet");
                killer.sendMessage(Main.p + "Du hast den Spieler §c " + p.getDisplayName() + " §agetötet");
                p.setNoDamageTicks(20);
                p.setHealth(20D);

                if (TeamChoose.teams.get(p.getName()).equals("red")) {

                    double x = Main.instance.getConfig().getDouble("cores.spawn.red.X");
                    double y = Main.instance.getConfig().getDouble("cores.spawn.red.Y");
                    double z = Main.instance.getConfig().getDouble("cores.spawn.red.Z");
                    String w = Main.instance.getConfig().getString("cores.spawn.red.World");
                    float yaw = (float) Main.instance.getConfig().getDouble("cores.spawn.red.Yaw");
                    float pitch = (float) Main.instance.getConfig().getDouble("cores.spawn.red.Pitch");
                    World world = Bukkit.getWorld(w);
                    Location loc = new Location(world, x, y, z, yaw, pitch);


                    p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET, DyeColor.RED.getData()));
                    p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, DyeColor.RED.getData()));
                    p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, DyeColor.RED.getData()));
                    p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS, DyeColor.RED.getData()));
                    p.teleport(loc);
                    TeamChoose.teamred.add(p);


                } else {


                    double x = (double) Main.getInstance().getConfig().getDouble("cores.spawn.blue.X");
                    double y = (double) Main.getInstance().getConfig().getDouble("cores.spawn.blue.Y");
                    double z = (double) Main.getInstance().getConfig().getDouble("cores.spawn.blue.Z");
                    String w = (String) Main.getInstance().getConfig().getString("cores.spawn.blue.World");
                    float yaw = (float) Main.getInstance().getConfig().getDouble("cores.spawn.blue.Yaw");
                    float pitch = (float) Main.getInstance().getConfig().getDouble("cores.spawn.blue.Pitch");
                    World world = Bukkit.getWorld(w);
                    Location loc = new Location(world, x, y, z, yaw, pitch);


                    p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET, DyeColor.RED.getData()));
                    p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, DyeColor.RED.getData()));
                    p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, DyeColor.RED.getData()));
                    p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS, DyeColor.RED.getData()));
                    p.teleport(loc);
                    TeamChoose.teamblue.add(p);

                }


            } catch (Exception e1) {

            }


        }
    }


    @EventHandler()
    public void onloosehunger(PlayerMoveEvent e) {
        if (e.getPlayer().getFoodLevel() != 20) {
            e.getPlayer().setFoodLevel(20);
        }
    }


}
