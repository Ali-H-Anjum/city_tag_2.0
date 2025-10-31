package com.ali_h_anjum.citytag.discord.listeners;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import com.ali_h_anjum.citytag.models.*;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MemberLoader extends ListenerAdapter {
    private final GameDetails gameDetails;
    private final CompletableFuture<Void> initializationFuture;

    public MemberLoader(GameDetails gameDetails, CompletableFuture<Void> initializationFuture) {
        this.gameDetails = gameDetails;
        this.initializationFuture = initializationFuture;
    }

    @Override
    public void onReady(ReadyEvent event) {
        final String BOT_CHANNEL = "1432729756121563186";
        TextChannel channel = event.getJDA().getTextChannelById(BOT_CHANNEL);
        
        channel.getGuild().loadMembers()
                .onSuccess(members -> {
                    loadPlayers(members);;
                    initializationFuture.complete(null);
                })
                .onError(initializationFuture::completeExceptionally);
    }

    private void loadPlayers(List<Member> members) {
        members.stream()
                .filter(member -> !member.getUser().isBot())
                .map(member -> new Player(
                    member.getUser().getId(),
                    member.getUser().getEffectiveName()
                ))
                .forEach(gameDetails::addPlayer);
        
        System.out.printf("Loaded %d players%n", gameDetails.getPlayerCount());
    }
}