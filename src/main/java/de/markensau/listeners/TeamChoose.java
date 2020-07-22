package de.markensau.listeners;

import de.markensau.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * ©2016-2020 LvckyWorld - By StossenHDYT all Rights reserved
 * Licensed to Iven Schlenther & Lukas Oetken
 **/
public class TeamChoose implements Listener {

    public TeamChoose(Main main) {
        main.getServer().getPluginManager().registerEvents(this, main);
    }



    public static HashMap<String, String> teams = new HashMap<>();

    public static ArrayList<Player> teamblue = new ArrayList<>();
    public static ArrayList<Player> teamred = new ArrayList<>();

    public static ArrayList<String> loreRed = new ArrayList<>();
    public static ArrayList<String> loreBlue = new ArrayList<>();




    public static boolean getTeam(Player p){
        if (loreRed.contains(p)){
            return true;
        }
        if (loreBlue.contains(p)){
            return true;
        }else {
            return false;
        }
    }


    @EventHandler()
    public void onJoin2(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        ItemStack beacon = new ItemStack(Material.BEACON);
        ItemMeta bm = beacon.getItemMeta();
        bm.setDisplayName("§4Wähle dein Team");
        beacon.setItemMeta(bm);

        p.getInventory().clear();
        if (JoinListener.respawn == true){
            p.getInventory().setItem(0, beacon);
        }else {
            p.getInventory().clear();
        }

    }

    @EventHandler()
    public void oninter(PlayerInteractEvent e) {
        Player p = (Player) e.getPlayer();

        try {
            if (e.getItem().getType() == Material.BEACON) {

                Inventory inv = Bukkit.createInventory(null, 9, "§4Wähle dein Team");

                ItemStack red = new ItemStack(Material.WOOL, 1, DyeColor.RED.getData());
                ItemMeta redmeta = red.getItemMeta();
                redmeta.setDisplayName("§4Team Rot");
                redmeta.setLore(loreRed);
                red.setItemMeta(redmeta);

                ItemStack blue = new ItemStack(Material.WOOL, 1, DyeColor.BLUE.getData());
                ItemMeta bluemeta = red.getItemMeta();
                bluemeta.setDisplayName("§9Team Blau");
                bluemeta.setLore(loreBlue);
                blue.setItemMeta(bluemeta);

                inv.setItem(0, red);
                inv.setItem(8, blue);

                p.openInventory(inv);

            }else {
                e.setCancelled(false);
            }
        }catch (Exception e1){

        }





    }

    @EventHandler()
    public void onclick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        try {
            if (e.getClickedInventory().getTitle().equalsIgnoreCase("§4Wähle dein Team")){

                if (e.getSlot() == 0){
                    if (!teams.get(p.getName()).equals("red")){

                        if (teams.get(p.getName()).equals("blue")){
                            loreBlue.remove("§7: §9" + p.getName());
                            teams.remove(p.getName() ,"blue");
                        }

                        teams.put(p.getName(), "red");

                        loreRed.add("§7: §4" + p.getName());

                        p.closeInventory();
                        p.sendMessage(Main.p + "Du bist nun im Team§4 Rot§a.");

                    }else {
                        p.sendMessage(Main.p + "§4Du bist bereits in diesen Team!");
                        p.closeInventory();
                    }
                }else if (e.getSlot() == 8){
                    if (!teams.get(p.getName()).equals("blue")){
                        if (teams.get(p.getName()).equals("red")){
                            loreRed.remove("§7: §4" + p.getName());
                            teams.remove(p.getName() ,"red");
                        }
                        teams.put(p.getName(), "blue");

                        loreBlue.add("§7: §9" + p.getName());
                        p.closeInventory();
                        p.sendMessage(Main.p + "Du bist nun im Team§9 Blau§a.");
                    }else {
                        p.sendMessage(Main.p + "§9Du bist bereits in diesen Team!");
                        p.closeInventory();
                    }
                }else {
                    p.closeInventory();
                    e.setCancelled(true);
                }

            }else {
                p.closeInventory();
                e.setCancelled(true);
            }
        }catch (Exception e1){

        }



    }

}
