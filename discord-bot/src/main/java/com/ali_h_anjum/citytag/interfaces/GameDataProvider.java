package com.ali_h_anjum.citytag.interfaces;

import com.ali_h_anjum.citytag.models.GameDetails;

public interface GameDataProvider {
    GameDetails getGameDetails();
    boolean isInitialized();
}