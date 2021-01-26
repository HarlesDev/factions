package com.redeharles.factions.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import net.stoonegomes.factions.entity.enums.FactionRole;
import org.bukkit.Location;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Builder
@Data
public class Faction {

    private String name, tag;
    private UUID id;
    private Set<FactionUser> members;
    private Location home;
    private int tokens;

    /*
    Members
     */

    public void addMember(FactionUser factionUser) {
        members.add(factionUser);
    }

    public void removeMember(FactionUser factionUser) {
        members.remove(factionUser);
    }

    public boolean containsMember(FactionUser factionUser) {
        return members.contains(factionUser);
    }

    /*
    Tokens
     */

    public void addTokens(int value) { tokens += value; }

    public void removeTokens(int value) { tokens -= value; }

    public void setTokens(int value) { tokens = value; }

    /*
    Additional methods
     */

    public Optional<FactionUser> getOwner() {
        return getMembersBy(FactionRole.LEADER).stream().findFirst();
    }

    public Set<FactionUser> getMembersBy(FactionRole factionRole) {
        return members.stream().filter(factionUser -> factionUser.getFactionRole().equals(factionRole)).collect(Collectors.toSet());
    }

}
