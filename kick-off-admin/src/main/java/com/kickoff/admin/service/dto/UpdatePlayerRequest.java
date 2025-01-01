package com.kickoff.admin.service.dto;

import com.kickoff.core.soccer.player.PlayerPosition;
import com.kickoff.core.soccer.player.service.UpdatePlayerServiceRequest;

public record UpdatePlayerRequest(
        String playerName,
        String leagueTeamName,
        String national,
        PlayerPosition position
) {
    public UpdatePlayerServiceRequest toServiceDto(Long playerId)
    {
        return new UpdatePlayerServiceRequest(playerName, leagueTeamName, national, position, playerId);
    }
}
