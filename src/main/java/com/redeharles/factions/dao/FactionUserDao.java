package com.redeharles.factions.dao;

import io.github.yeetzy.core.dao.Dao;
import io.github.yeetzy.core.singleton.annotation.Singleton;
import com.redeharles.factions.entity.FactionUser;

import java.util.Collection;
import java.util.UUID;

@Singleton(id = "factionUserDao")
public class FactionUserDao implements Dao<UUID, FactionUser> {

    @Override
    public void replace(FactionUser value) {
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
    public FactionUser find(UUID key) {
        return null;
    }

    @Override
    public Collection<FactionUser> find() {
        return null;
    }

}
