package com.kickoff.core.soccer.game.player;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Embeddable
public class PlayerHistory {
    private String season;
    private String leagueTeam;
    private String award;

    public PlayerHistory(String season, String leagueTeam, String award) {
        this.season = season;
        this.leagueTeam = leagueTeam;
        this.award = award;
    }
}
