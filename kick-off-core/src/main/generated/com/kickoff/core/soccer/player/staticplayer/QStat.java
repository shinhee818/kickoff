package com.kickoff.core.soccer.player.staticplayer;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QStat is a Querydsl query type for Stat
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStat extends EntityPathBase<Stat> {

    private static final long serialVersionUID = -1078810706L;

    public static final QStat stat = new QStat("stat");

    public final NumberPath<Integer> assists = createNumber("assists", Integer.class);

    public final NumberPath<Integer> attack = createNumber("attack", Integer.class);

    public final NumberPath<Integer> goals = createNumber("goals", Integer.class);

    public final NumberPath<Integer> goalsPerGame = createNumber("goalsPerGame", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> playedGameTime = createNumber("playedGameTime", Integer.class);

    public final NumberPath<Long> playerId = createNumber("playerId", Long.class);

    public final StringPath season = createString("season");

    public final NumberPath<Integer> shot = createNumber("shot", Integer.class);

    public final NumberPath<Integer> shotOnGoal = createNumber("shotOnGoal", Integer.class);

    public QStat(String variable) {
        super(Stat.class, forVariable(variable));
    }

    public QStat(Path<? extends Stat> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStat(PathMetadata metadata) {
        super(Stat.class, metadata);
    }

}

