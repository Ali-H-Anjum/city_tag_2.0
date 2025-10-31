package com.ali_h_anjum.citytag;

//import java.util.Scanner;

import com.ali_h_anjum.citytag.models.*;
//import com.ali_h_anjum.citytag.services.*;
import com.ali_h_anjum.citytag.config.*;
import com.ali_h_anjum.citytag.discord.DiscordBotService;

public class CityTagBot {
    private final DiscordBotService botService;
    private final GameDetails gameDetails;

    public CityTagBot(String token) {
        this.gameDetails = new GameDetails();
        this.botService = new DiscordBotService(token, gameDetails);
    }

    public void start() {
        System.out.println("City Tag Bot by Ali-H-Anjum Starting...");
        
        botService.awaitInitialization();
        
        // Now safe to use game data
        System.out.printf("Bot initialized with %d players%n", 
                         gameDetails.getPlayerCount());
        
        startGameLogic();
    }

    private void startGameLogic() {
        // Your main game logic here
    }

    public static void main(String[] args) {
        String token = "";
        CityTagBot bot = new CityTagBot(token);
        bot.start();
    }
}