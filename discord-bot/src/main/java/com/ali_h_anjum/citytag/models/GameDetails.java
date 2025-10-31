package com.ali_h_anjum.citytag.models;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public class GameDetails {
    private final List<Team> teams;
    private final List<Player> players;

    public GameDetails() {
        this.teams = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    // Immutable collections for encapsulation
    public List<Team> getTeams() {
        return Collections.unmodifiableList(teams);
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public int getPlayerCount() {
        return players.size();
    }

    public int getTeamCount() {
        return teams.size();
    }

    // Controlled modification
    public void addPlayer(Player player) {
        if (player == null) throw new IllegalArgumentException("Player cannot be null");
        this.players.add(player);
    }

    public void addTeam(Team team) {
        if (team == null) throw new IllegalArgumentException("Team cannot be null");
        this.teams.add(team);
    }

    // Business logic methods
    public Optional<Player> findPlayerById(String id) {
        return players.stream()
                .filter(player -> player.getId().equals(id))
                .findFirst();
    }
}