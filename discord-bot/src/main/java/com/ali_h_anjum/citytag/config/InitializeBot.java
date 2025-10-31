package com.ali_h_anjum.citytag.config;

import java.util.List;

import com.ali_h_anjum.citytag.models.GameDetails;
import com.ali_h_anjum.citytag.models.Player;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Widget;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;



public class InitializeBot extends ListenerAdapter{
    private GameDetails gameDetails;

    public InitializeBot(GameDetails gameDetails) {
        this.gameDetails = gameDetails;
    }

    @Override
    public void onReady(ReadyEvent event) {
        final String BOT_CHANNEL = "1432729756121563186";
        TextChannel channel = event.getJDA().getTextChannelById(BOT_CHANNEL);
        channel.getGuild().loadMembers().onSuccess(members -> {
            for (Member member : members) {
                 User user = member.getUser();
                 if(!user.isBot()){
                    gameDetails.addMember(new Player(user.getId(), user.getEffectiveName()));
                 } 
            }
        });
    }
}
