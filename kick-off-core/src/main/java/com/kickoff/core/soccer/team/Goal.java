package com.kickoff.core.soccer.team;

import com.kickoff.core.soccer.league.LeagueTeam;
import com.kickoff.core.soccer.player.Player;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private Player player;

    private int playTime;

    private int injuryTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home")
    private LeagueTeam scoredTeam;

    @Enumerated(EnumType.STRING)
    private GoalType type;

    @Builder
    public Goal(Player player, int playTime, LeagueTeam scoredTeam, GoalType type, int injuryTime) {
        this.player = player;
        this.playTime = playTime;
        this.scoredTeam = scoredTeam;
        this.injuryTime = injuryTime;
        this.type = type;
    }
}
