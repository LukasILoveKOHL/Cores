package de.markensau.listeners;

import de.markensau.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.Listener;

/**
 * ©2016-2020 LvckyWorld - By StossenHDYT all Rights reserved
 * Licensed to Iven Schlenther & Lukas Oetken
 **/
public class ServerRestart {

    public static void onrestartcores(){

        double x = Main.getInstance().getConfig().getDouble("cores.core." + "red" + "." + 1 + ".X");
        double y = Main.getInstance().getConfig().getDouble("cores.core." + "red" + "." + 1 + ".Y");
        double z = Main.getInstance().getConfig().getDouble("cores.core." + "red" + "." + 1 + ".Z");
        String w = Main.getInstance().getConfig().getString("cores.core." + "red" + "." + 1 + ".World");
        World world = Bukkit.getWorld(w);
        Location coreR1 = new Location(world, x, y, z);

        double x3 = Main.getInstance().getConfig().getDouble("cores.core." + "blue" + "." + 1 + ".X");
        double y3 = Main.getInstance().getConfig().getDouble("cores.core." + "blue" + "." + 1 + ".Y");
        double z3 = Main.getInstance().getConfig().getDouble("cores.core." + "blue" + "." + 1 + ".Z");
        String w3 = Main.getInstance().getConfig().getString("cores.core." + "blue" + "." + 1 + ".World");
        World world3 = Bukkit.getWorld(w3);
        Location coreB1 = new Location(world3, x3, y3, z3);

        double x4 = Main.getInstance().getConfig().getDouble("cores.core." + "blue" + "." + 2 + ".X");
        double y4 = Main.getInstance().getConfig().getDouble("cores.core." + "blue" + "." + 2 + ".Y");
        double z4 = Main.getInstance().getConfig().getDouble("cores.core." + "blue" + "." + 2 + ".Z");
        String w4 = Main.getInstance().getConfig().getString("cores.core." + "blue" + "." + 2 + ".World");
        World world4 = Bukkit.getWorld(w4);
        Location coreB2 = new Location(world4, x4, y4, z4);

        double x2 = Main.getInstance().getConfig().getDouble("cores.core." + "red" + "." + 2 + ".X");
        double y2 = Main.getInstance().getConfig().getDouble("cores.core." + "red" + "." + 2 + ".Y");
        double z2 = Main.getInstance().getConfig().getDouble("cores.core." + "red" + "." + 2 + ".Z");
        String w2 = Main.getInstance().getConfig().getString("cores.core." + "red" + "." + 2 + ".World");
        World world2 = Bukkit.getWorld(w2);
        Location coreR2 = new Location(world2, x2, y2, z2);

        world.getBlockAt(coreR1).setType(Material.BEACON);
        world2.getBlockAt(coreR2).setType(Material.BEACON);
        world3.getBlockAt(coreB1).setType(Material.BEACON);
        world4.getBlockAt(coreB2).setType(Material.BEACON);


    }


}
