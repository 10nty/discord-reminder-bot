package main.com.Aktilek.reminderbot.model;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import java.time.LocalTime;

public class Reminder {

        private final String text;
        private final LocalTime time;
        private final MessageChannel channel;

        public Reminder(String text, LocalTime time, MessageChannel channel) {
            this.text = text;
            this.time = time;
            this.channel = channel;
        }

        public String getText() { return text; }
        public LocalTime getTime() { return time; }
        public MessageChannel getChannel() { return channel; }

}
