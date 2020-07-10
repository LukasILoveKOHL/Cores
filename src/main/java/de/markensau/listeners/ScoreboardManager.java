package de.markensau.listeners;

import de.markensau.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

/**
 * ©2016-2020 LvckyWorld - By StossenHDYT all Rights reserved
 * Licensed to Iven Schlenther & Lukas Oetken
 **/
public class ScoreboardManager {

    public static int sekunden = 60;
    public static int minuten = 9;
    public static int sched2;

    public static boolean clockIsRunning = false;

    public static Score one;

    public static void startClock(){
        sched2 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {

                if (sekunden <= 0) {
                    minuten--;
                    updateBoard();
                    if (minuten <= 0) {
                        sekunden = 0;
                        minuten = 0;
                        Bukkit.getScheduler().cancelTask(sched2);
                    }
                    sekunden = 60;
                    sekunden--;
                    updateBoard();

                }else {
                    sekunden--;
                    updateBoard();
                }
            }
        },0,20);


    }

    @SuppressWarnings("deprecation")
    public static void updateBoard(){
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.registerNewObjective("aaa","bbb");

        obj.setDisplayName("§b§lCores");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        for (Player all : Bukkit.getOnlinePlayers()){
            all.setScoreboard(board);
        }

        Score ten = obj.getScore(Bukkit.getOfflinePlayer("§4Team Rot:"));ten.setScore(10);

        Score nine = obj.getScore(Bukkit.getOfflinePlayer("§aok §8| §cLeftCore"));nine.setScore(9);
        Score eight = obj.getScore(Bukkit.getOfflinePlayer("§aok §8| §cRightCore"));eight.setScore(8);

        Score seven = obj.getScore(Bukkit.getOfflinePlayer("§7------------"));seven.setScore(7);

        Score six = obj.getScore(Bukkit.getOfflinePlayer("§9Team Blau:"));six.setScore(6);
        Score five = obj.getScore(Bukkit.getOfflinePlayer("§aok §8| §9LeftCore"));five.setScore(5);
        Score four = obj.getScore(Bukkit.getOfflinePlayer("§aok §8| §9RightCore"));four.setScore(4);

        Score three = obj.getScore(Bukkit.getOfflinePlayer("§1"));three.setScore(3);

        Score two = obj.getScore(Bukkit.getOfflinePlayer("§aTime Left:"));two.setScore(2);

        if (sekunden >= 10){
            one = obj.getScore(Bukkit.getOfflinePlayer("§a" + 0 + minuten + "§5:§f" + sekunden));one.setScore(1);
        }else {
            one = obj.getScore(Bukkit.getOfflinePlayer("§a" + 0 + minuten + "§5:§f" + 0 + sekunden));one.setScore(1);

        }

        Score zero = obj.getScore(Bukkit.getOfflinePlayer("§4"));zero.setScore(0);

        if (!clockIsRunning){
            clockIsRunning = true;
            startClock();
        }

    }

}
