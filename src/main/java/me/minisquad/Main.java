package me.minisquad;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;

/**
 * Main class for the CITS bot discord bot
 * 
 * @github minisquad/UWA-CITS-BOT
 * @version 1.0
 */

 public class Main {
    private static JDA jda;

    public static void main(String[] args) {
        try {
            jda = new JDABuilder(Constants.BOT_TOKEN).build();
            jda.addEventListener(new RoleAssign());
            jda.addEventListener(new Utilities());
            jda.getPresence().setStatus(OnlineStatus.ONLINE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Output consistent logging with data timestamps
     * @param log String to output
     */
    public static void log(String log) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("Australia/Perth"));
        Date date = new Date();
        System.out.println(dateFormat.format(date) + " " + log);
    }
 }