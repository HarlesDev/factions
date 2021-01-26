package com.redeharles.factions.listener;

import com.redeharles.factions.cache.FactionUserCache;
import io.github.yeetzy.core.register.annotation.Register;
import io.github.yeetzy.core.register.type.RegisterType;
import io.github.yeetzy.core.singleton.SingletonMapper;
import io.github.yeetzy.core.task.Task;
import com.redeharles.factions.dao.FactionUserDao;
import com.redeharles.factions.entity.FactionUser;
import com.redeharles.factions.entity.enums.FactionRole;
import com.redeharles.factions.factory.FactionUserFactory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

@Register(type = RegisterType.LISTENER)
public class TrafficListener implements Listener {

    private final FactionUserFactory factionUserFactory = SingletonMapper.of(FactionUserFactory.class);
    private final FactionUserDao factionUserDao = SingletonMapper.of(FactionUserDao.class);
    private final FactionUserCache factionUserCache = SingletonMapper.of(FactionUserCache.class);

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Task.runAsync(() -> {
            Player player = event.getPlayer();

            FactionUser factionUser = factionUserDao.find(player.getUniqueId());
            if (factionUser == null) {
                FactionUser defaultUser = factionUserFactory.buildDefaultUser(
                	player.getUniqueId(),
                	 FactionRole.NONE
                	 );
                factionUserCache.putElement(
                	defaultUser.getUuid(),
                	 defaultUser
                	 );
                return;
            }

            factionUserCache.putElement(factionUser.getUuid(),
             factionUser
             );
        });
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
       Task.runAsync(() -> {
          Player player = event.getPlayer();

          if (factionUserCache.containsKey(player.getUniqueId())) factionUserCache.removeElement(player.getUniqueId());
       });
    }

}
