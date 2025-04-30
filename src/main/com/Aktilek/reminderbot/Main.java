package main.com.Aktilek.reminderbot;

import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.io.FileInputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {
        Properties config = new Properties();
        config.load(new FileInputStream("src/resources/config.properties"));

        String token = config.getProperty("DISCORD_TOKEN");

        JDA jda  = JDABuilder.createDefault(token)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES)
                .addEventListeners(new BotListener())
                .build();

        ReminderManager.start(); // запускает проверку напоминаний
    }
}