package main.com.Aktilek.reminderbot;

import main.com.Aktilek.reminderbot.model.Reminder;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.*;

public class ReminderManager {
    private static final List<Reminder> reminders = new CopyOnWriteArrayList<>();

    public static void addReminder(String text, String timeStr, MessageChannel channel) {
        LocalTime time = LocalTime.parse(timeStr); // формат ЧЧ:ММ
        reminders.add(new Reminder(text, time, channel));
    }

    public static void start() {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(() -> {
            LocalTime now = LocalTime.now().withSecond(0).withNano(0);
            for (Reminder r : reminders) {
                if (r.getTime().equals(now)) {
                    r.getChannel().sendMessage("🔔 Напоминание: " + r.getText()).queue();
                    reminders.remove(r);
                }
            }
        }, 0, 30, TimeUnit.SECONDS); // проверка каждые 30 секунд
    }
}