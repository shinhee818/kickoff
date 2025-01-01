package com.kickoff.core.soccer.player;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PlayerPosition {
    CENTER_FORWARD("센터 포워드"),
    FORWARD("포워드"),
    DEFENDER("수비수"),
    MID_FIELDER("미드필더"),
    KEEPER("골키퍼"),
    LEFT_BACK("레프트백"),
    RIGHT_BACK("라이트백"),
    CENTER_BACK("센터백"),
    CENTRAL_MID_FIELDER("중앙 미드필더"),
    LEFT_WINGER("좌측 윙어"),
    RIGHT_WINGER("우측 윙어"),
    ATTACKING_MIDFIELD("공격형 미드필더"),
    ;

    private final String position;

}
