package com.kickoff.core.soccer.player;

import com.kickoff.core.config.CustomQueryDslConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@ActiveProfiles("local")
@SpringBootTest
@Import(CustomQueryDslConfig.class)
class PlayerRepositoryTest {

    @Autowired
    PlayerRepository playerRepository;

    @Test
    public void test()
    {
        Optional<Player> byIdWithFetch = playerRepository.findPlayerFetchImages(12455L);
        System.out.println("###");

        System.out.println(byIdWithFetch.get().getPlayerImages());
    }
}