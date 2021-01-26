package com.redeharles.factions.factory;

import io.github.yeetzy.core.singleton.annotation.Singleton;
import com.redeharles.factions.entity.Faction;
import com.redeharles.factions.entity.FactionUser;
import com.redeharles.factions.entity.enums.FactionRole;

import java.util.UUID;

@Singleton(id = "factionUserFactory")
public class FactionUserFactory {

    public FactionUser buildDefaultUser(FactionRole factionRole) {
        return FactionUser.builder()
                .uuid(UUID.randomUUID())
                .faction(null)
                .factionRole(factionRole)
                .factionPermissions(factionRole.getPermissions())
                .build();
    }

    public FactionUser buildDefaultUser(UUID uuid, FactionRole factionRole) {
        return FactionUser.builder()
                .uuid(uuid)
                .faction(null)
                .factionRole(factionRole)
                .factionPermissions(factionRole.getPermissions())
                .build();
    }

    public FactionUser buildDefaultUser(UUID uuid, Faction faction, FactionRole factionRole) {
        return FactionUser.builder()
                .uuid(uuid)
                .faction(faction)
                .factionRole(factionRole)
                .factionPermissions(factionRole.getPermissions())
                .build();
    }

}
