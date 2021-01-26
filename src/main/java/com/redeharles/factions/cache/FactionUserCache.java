package com.redeharles.factions.cache;

import io.github.yeetzy.core.cache.DoubleCache;
import io.github.yeetzy.core.singleton.SingletonMapper;
import io.github.yeetzy.core.singleton.annotation.Singleton;
import com.redeharles.factions.dao.FactionUserDao;
import com.redeharles.factions.entity.FactionUser;
import com.redeharles.factions.entity.enums.FactionRole;
import com.redeharles.factions.factory.FactionUserFactory;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

@Singleton(id = "factionUserCache")
public class FactionUserCache extends DoubleCache<UUID, FactionUser> {

    private final FactionUserFactory factionUserFactory = SingletonMapper.of(FactionUserFactory.class)
    private final FactionUserDao factionUserDao = SingletonMapper.of(FactionUserDao.class);

    @Override
    public void load() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            FactionUser findUser = factionUserDao.find(player.getUniqueId());
            if (findUser == null) {
                FactionUser defaultUser = factionUserFactory.buildDefaultUser(player.getUniqueId(), FactionRole.NONE);
                putElement(defaultUser.getUuid(), defaultUser);
                return;
            }

            putElement(findUser.getUuid(), findUser);
        }
    }

    @Override
    public void save() {
        for (FactionUser factionUser : getValues()) {
            factionUserDao.replace(factionUser);
        }
    }

}
