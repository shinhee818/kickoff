package com.kickoff.core.soccer.player.service;

import com.kickoff.core.soccer.player.PlayerPosition;

public record UpdatePlayerServiceRequest(
        String playerName,
        String leagueTeam,
        String national,
        PlayerPosition position,
        Long playerId

) {
}
