package com.kickoff.core.soccer.game.player;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPlayerHistory is a Querydsl query type for PlayerHistory
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QPlayerHistory extends BeanPath<PlayerHistory> {

    private static final long serialVersionUID = -1649034182L;

    public static final QPlayerHistory playerHistory = new QPlayerHistory("playerHistory");

    public final StringPath award = createString("award");

    public final StringPath leagueTeam = createString("leagueTeam");

    public final StringPath season = createString("season");

    public QPlayerHistory(String variable) {
        super(PlayerHistory.class, forVariable(variable));
    }

    public QPlayerHistory(Path<? extends PlayerHistory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPlayerHistory(PathMetadata metadata) {
        super(PlayerHistory.class, metadata);
    }

}

