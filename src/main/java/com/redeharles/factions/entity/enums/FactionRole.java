package com.redeharles.factions.entity.enums;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

import static com.redeharles.factions.entity.enums.FactionPermission.*;

@AllArgsConstructor
@Getter
public enum FactionRole {

    LEADER(
            "Leader",
            "#",
            4,
            Sets.newHashSet(BUILD, INTERACT, MANAGE, BASE)
    ),
    CAPTAIN(
            "Captain",
            "*",
            3,
            Sets.newHashSet(BUILD, INTERACT, MANAGE, BASE)
    ),
    MEMBER(
            "Member",
            "+",
            2,
            Sets.newHashSet(BUILD, INTERACT, BASE)
    ),
    RECRUIT(
            "Recruit",
            "-",
            1,
            Sets.newHashSet(BUILD, INTERACT)
    ),
    NONE(
            "None",
            "",
            0,
            Sets.newHashSet()
    );

    private final String name, prefix;
    private final int level;
    private final Set<FactionPermission> permissions;

}
