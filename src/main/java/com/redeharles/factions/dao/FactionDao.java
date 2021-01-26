package com.redeharles.factions.dao;

import io.github.yeetzy.core.dao.Dao;
import io.github.yeetzy.core.singleton.annotation.Singleton;
import com.redeharles.factions.entity.Faction;

import java.util.Collection;
import java.util.UUID;

@Singleton(id = "factionDao")
public class FactionDao implements Dao<UUID, Faction> {

    @Override
    public void replace(Faction value) {
        /*
        TODO
         */
    }

    @Override
    public void delete(UUID key) {
        /*
        TODO
         */
    }

    @Override
    public Faction find(UUID key) {
        return null;
    }

    @Override
    public Collection<Faction> find() {
        return null;
    }

}
