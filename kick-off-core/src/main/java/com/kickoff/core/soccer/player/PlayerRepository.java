package com.kickoff.core.soccer.player;

import com.kickoff.core.soccer.league.LeagueTeam;
import com.kickoff.core.soccer.league.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findByPlayerId(Long playerId);

    List<Player> findByLeagueTeamAndSeason(LeagueTeam leagueTeam, Season season);

    @Query("select p from Player p " +
            "   left join fetch p.playerImages " +
            "   left join fetch p.leagueTeam " +
            "where p.playerId = :playerId")
    Optional<Player> findFetchPlayer(@Param("playerId") Long playerId);
}
