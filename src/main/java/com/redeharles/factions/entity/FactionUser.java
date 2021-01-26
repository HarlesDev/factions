package com.redeharles.factions.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import com.redeharles.factions.entity.enums.FactionPermission;
import com.redeharles.factions.entity.enums.FactionRole;

import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Data
public class FactionUser {

    private UUID uuid;
    private FactionRole factionRole;
    private Faction faction;
    private Set<FactionPermission> factionPermissions;

    /*
    Permissions
     */

    public void addPermission(FactionPermission factionPermission) {
        if (!containsPermission((factionPermission))) factionPermissions.add(factionPermission);
    }

    public void removePermission(FactionPermission factionPermission) {
        if (containsPermission((factionPermission))) factionPermissions.remove(factionPermission);
    }

    public boolean containsPermission(FactionPermission factionPermission) {
        return factionPermissions.contains(factionPermission);
    }

}
