package com.ali_h_anjum.citytag.interfaces;

import java.util.concurrent.CompletableFuture;
import com.ali_h_anjum.citytag.models.GameDetails;

public interface BotInitializationListener {
    CompletableFuture<Void> onBotInitialized(GameDetails gameDetails);
}
