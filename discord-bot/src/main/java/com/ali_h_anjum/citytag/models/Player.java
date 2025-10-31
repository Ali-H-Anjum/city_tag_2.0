package com.ali_h_anjum.citytag.models;

import java.util.Optional;
import java.util.Objects;

public class Player {
    private final String id;
    private final String name;
    private Team team; // Optional team association

    public Player(String id, String name) {
        this.id = Objects.requireNonNull(id, "Player ID cannot be null");
        this.name = Objects.requireNonNull(name, "Player name cannot be null");
    }

    // Getters only - immutable identity
    public String getId() { return id; }
    public String getName() { return name; }
    public Optional<Team> getTeam() { return Optional.ofNullable(team); }

    // Package-private setter for controlled modification
    void setTeam(Team team) {
        this.team = team;
    }
}