package com.redeharles.factions.inventory;

import io.github.yeetzy.core.inventory.CustomInventory;
import org.bukkit.entity.Player;

public class MainInventory extends CustomInventory {

    public MainInventory() {
        super("Main factions inventory", 5, true);
    }

    @Override
    public void init(Player player) {

    }

}
