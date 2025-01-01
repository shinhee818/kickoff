package com.kickoff.core.soccer.player;

import com.kickoff.core.BaseEntity;
import com.kickoff.core.soccer.league.LeagueTeam;
import com.kickoff.core.soccer.league.Season;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class Player extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;

    private String national;

    private String playerName;
    private String playerKrName;

    @Enumerated(EnumType.STRING)
    private PlayerPosition position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "league_team_id")
    private LeagueTeam leagueTeam;

    private String birth;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "season_id")
    private Season season;

    @Embedded
    private Contract contract;

    @BatchSize(size = 1000)
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private final Set<PlayerImage> playerImages = new HashSet<>();

    @Column(columnDefinition = "boolean default false")
    private Boolean isDeleted;

    @Builder
    public Player(
            Long playerId,
            String national,
            String playerName,
            String playerKrName, PlayerPosition position,
            LeagueTeam leagueTeam,
            String birth,
            Season season,
            Contract contract) {
        this.playerId = playerId;
        this.national = national;
        this.playerName = playerName;
        this.playerKrName = playerKrName;
        this.position = position;
        this.leagueTeam = leagueTeam;
        this.birth = birth;
        this.season = season;
        this.contract = contract;
        isDeleted = Boolean.FALSE;
    }

    public void delete()
    {
        if (!isDeleted)
        {
            this.isDeleted = true;
        }
    }

    public void update(Player updatePlayer)
    {
        changePlayerName(updatePlayer.getPlayerName());
        changeNational(updatePlayer.getNational());
        changePosition(updatePlayer.getPosition());
        changeLeagueTeam(updatePlayer.getLeagueTeam());

    }

    public void changePlayerName(String playerName)
    {
        if(playerName == null || playerName.isBlank())
        {
            return ;
        }
        this.playerName = playerName;
    }


    public void changeNational(String national)
    {
        if(national == null)
        {
            return ;
        }
        this.national = national;
    }

    public void changeLeagueTeam(LeagueTeam leagueTeam) {
        if (this.leagueTeam != null) {
            this.leagueTeam = leagueTeam;
        }
    }


    public void changePosition(PlayerPosition position)
    {
        if(position == null)
        {
            return ;
        }
        this.position = position;
    }
}
