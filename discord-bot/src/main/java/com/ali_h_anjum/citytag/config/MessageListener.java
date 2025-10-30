package com.ali_h_anjum.citytag.config;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter{
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        System.out.printf("[%s] %#s: %s\n", event.getChannel(), event.getAuthor(), event.getMessage().getContentDisplay());
    }
}
