package de.markensau.main;

import de.markensau.listeners.JoinListener;
import de.markensau.listeners.TeamChoose;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.TimeUnit;

/**
 * ©2016-2020 LvckyWorld - By StossenHDYT all Rights reserved
 * Licensed to Iven Schlenther & Lukas Oetken
 **/
public class CoresBuild implements Listener {
    public CoresBuild(Main main) {
        main.getServer().getPluginManager().registerEvents(this, main);
    }


    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        e.setQuitMessage("");
    }


    @EventHandler()
    public void onDrop(PlayerDropItemEvent e) {
        e.setCancelled(true);
    }


    @EventHandler()
    public void onBuild(BlockPlaceEvent e) {
        e.setCancelled(JoinListener.damageblockcancelled);

    }

    @EventHandler()
    public void onDeathMessage(PlayerDeathEvent e) {
        Player p = (Player) e.getEntity();
        e.setDeathMessage("");
        e.setDeathMessage(Main.p + "Der Spieler §6" + e.getEntity().getKiller().getDisplayName() + " §ahat den Spieler §6" + p.getDisplayName() + "§a getötet!");
    }

    @EventHandler()
    public void onBuild2(BlockBreakEvent e) {
        e.setCancelled(JoinListener.damageblockcancelled);

    }

    @EventHandler()
    public void onMobSpawning(EntitySpawnEvent e) {
        e.setCancelled(true);

    }
    public String getTeam(Player player){
        if (TeamChoose.loreRed.contains(player)){
            return "red";
        }
        if (TeamChoose.loreBlue.contains(player)){
            return "blue";
        } else {
            return null;
        }

    }
    @EventHandler()
    public void EntityDamageEvent(EntityDamageByEntityEvent e) {
        Player p = (Player) e.getEntity();
        if (JoinListener.damageblockcancelled == true) {
            e.setCancelled(true);
        } else if (getTeam(p).equalsIgnoreCase("red")){
            for (Player all : Bukkit.getOnlinePlayers()) {
                System.out.println(getTeam(all));
                e.setCancelled(true);
            }
        }else if (getTeam(p).equalsIgnoreCase("blue")){
            e.setCancelled(true);
        }else {

        }

    }


    @EventHandler()
    public void onRespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        for (Player all : Bukkit.getOnlinePlayers()) {
            if (!TeamChoose.teams.get(all.getName()).equals("red")) {

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
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
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


                p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET, DyeColor.RED.getData()));
                p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, DyeColor.RED.getData()));
                p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, DyeColor.RED.getData()));
                p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS, DyeColor.RED.getData()));
                p.teleport(loc);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException interruptedException) {

                }
                e.setRespawnLocation(loc);

            }

            p.getInventory().clear();

            p.getInventory().setItem(0, new ItemStack(Material.STONE_SWORD));
            p.getInventory().setItem(1, new ItemStack(Material.IRON_PICKAXE));
            p.getInventory().setItem(2, new ItemStack(Material.BOW));
            p.getInventory().setItem(3, new ItemStack(Material.IRON_AXE));
            p.getInventory().setItem(8, new ItemStack(Material.GOLDEN_APPLE, 16));
            p.getInventory().setItem(22, new ItemStack(Material.ARROW, 12));


            if (TeamChoose.teams.get(all.getName()).equals("red")) {

                p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET, DyeColor.RED.getData()));
                p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, DyeColor.RED.getData()));
                p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, DyeColor.RED.getData()));
                p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS, DyeColor.RED.getData()));

            } else {
                p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET, DyeColor.BLUE.getData()));
                p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, DyeColor.BLUE.getData()));
                p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, DyeColor.BLUE.getData()));
                p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS, DyeColor.BLUE.getData()));
            }


            p.setHealth(20);
            p.setFoodLevel(20);

        }
    }

}

