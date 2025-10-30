package com.ali_h_anjum.citytag.config;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class BotConfig {
    private JDA jda;

    public BotConfig(String token) throws InterruptedException {
        this.jda = JDABuilder.createDefault(token)
        .enableIntents(
            GatewayIntent.MESSAGE_CONTENT,
            GatewayIntent.GUILD_MEMBERS,
            GatewayIntent.GUILD_MESSAGES
            )
        .addEventListeners(
            new MessageListener()
            //new PingCommand(),
            //new JoinTeamCommand()
            //Add all command classes here
        )
        .build();

        this.jda.awaitReady();
    }
    
    public JDA getJDA() {
        return jda;
    }

    public void shutdown() {
        if (jda != null) {
            jda.shutdown();
        }
    }

    public boolean isReady() {
        return jda != null && jda.getStatus() == JDA.Status.CONNECTED;
    }
}
