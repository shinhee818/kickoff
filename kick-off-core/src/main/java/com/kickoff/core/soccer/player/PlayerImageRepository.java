package com.kickoff.core.soccer.player;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerImageRepository extends JpaRepository<PlayerImage,Long> {
    List<PlayerImage> findByPlayer(Player player);
}
