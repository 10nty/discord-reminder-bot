package main.com.Aktilek.reminderbot;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BotListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String msg = event.getMessage().getContentRaw();

        if (msg.startsWith("!remind ")) {
            String[] parts = msg.substring(8).split(" at ");
            if (parts.length == 2) {
                String task = parts[0].trim();
                String time = parts[1].trim();
                ReminderManager.addReminder(task, time, event.getChannel());
                event.getChannel().sendMessage("✅ Напоминание добавлено!").queue();
            } else {
                event.getChannel().sendMessage("⚠️ Формат: `!remind Текст at ЧЧ:ММ`").queue();
            }
        }
    }
}

