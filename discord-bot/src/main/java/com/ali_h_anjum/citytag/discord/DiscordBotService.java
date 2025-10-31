package com.ali_h_anjum.citytag.discord;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import com.ali_h_anjum.citytag.discord.listeners.MemberLoader;
import com.ali_h_anjum.citytag.interfaces.GameDataProvider;
import com.ali_h_anjum.citytag.models.GameDetails;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class DiscordBotService implements GameDataProvider {
    private final JDA jda;
    private final GameDetails gameDetails;
    private final CompletableFuture<Void> initializationFuture;

    public DiscordBotService(String token, GameDetails gameDetails) {
        this.gameDetails = gameDetails;
        this.initializationFuture = new CompletableFuture<>();
        this.jda = initializeJDA(token);
    }

    private JDA initializeJDA(String token) {
        try {
            return JDABuilder.createDefault(token)
                    .enableIntents(GatewayIntent.MESSAGE_CONTENT, 
                                 GatewayIntent.GUILD_MEMBERS, 
                                 GatewayIntent.GUILD_MESSAGES)
                    .addEventListeners(new MemberLoader(gameDetails, initializationFuture))
                    .setMemberCachePolicy(MemberCachePolicy.ALL)
                    .build()
                    .awaitReady();
        } catch (InterruptedException e) {
            throw new RuntimeException("Failed to initialize Discord bot", e);
        }
    }

    public void awaitInitialization() {
        try {
            initializationFuture.get(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            throw new RuntimeException("Initialization failed", e);
        }
    }

    @Override
    public GameDetails getGameDetails() {
        if (!isInitialized()) {
            throw new IllegalStateException("Bot not initialized yet");
        }
        return gameDetails;
    }

    @Override
    public boolean isInitialized() {
        return initializationFuture.isDone() && !initializationFuture.isCompletedExceptionally();
    }

    public void shutdown() {
        if (jda != null) {
            jda.shutdown();
        }
    }
}