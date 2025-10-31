package com.ali_h_anjum.citytag.config;

import com.ali_h_anjum.citytag.models.GameDetails;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class BotConfig {
    private JDA jda;

    public BotConfig(String token, GameDetails gameDetails) throws InterruptedException {
        this.jda = JDABuilder.createDefault(token)
        .enableIntents(
            GatewayIntent.MESSAGE_CONTENT,
            GatewayIntent.GUILD_MEMBERS,
            GatewayIntent.GUILD_MESSAGES
            )
        .addEventListeners(
            new InitializeBot(gameDetails),
            new MessageListener()
            //new PingCommand(),
            //new JoinTeamCommand()
            //Add all command classes here
        )
        .setMemberCachePolicy(MemberCachePolicy.ALL)
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
