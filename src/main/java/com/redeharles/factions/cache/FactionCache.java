package com.redeharles.factions.cache;

import io.github.yeetzy.core.cache.DoubleCache;
import io.github.yeetzy.core.singleton.SingletonMapper;
import io.github.yeetzy.core.singleton.annotation.Singleton;
import com.redeharles.factions.dao.FactionDao;
import com.redeharles.factions.entity.Faction;

import java.util.UUID;

@Singleton(id = "factionCache")
public class FactionCache extends DoubleCache<UUID, Faction> {

    private final FactionDao factionDao = SingletonMapper.of(FactionDao.class);

    @Override
    public void load() {
        for (Faction faction : factionDao.find()) {
            putElement(faction.getId(), faction);
        }
    }

    @Override
    public void save() {
        for (Faction faction : getValues()) {
            factionDao.replace(faction);
        }
    }

}
