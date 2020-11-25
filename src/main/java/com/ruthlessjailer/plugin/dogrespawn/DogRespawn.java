package com.ruthlessjailer.plugin.dogrespawn;

import com.ruthlessjailer.api.theseus.PluginBase;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public final class DogRespawn extends PluginBase implements Listener {

	@Override
	protected void onStart() {
		this.registerEvents(this);
		System.out.println("DogRespawn started.");
	}

	@EventHandler
	public void onDamage(final EntityDamageEvent event) {
		if (event.getEntity().getType() != EntityType.WOLF) {
			return;
		}
		
		if (!((Wolf) event.getEntity()).isTamed()) {
			return;
		}

		if (((Wolf) event.getEntity()).getHealth() - event.getFinalDamage() <= 0) {
			event.setCancelled(true);
			event.getEntity().teleport(event.getEntity().getWorld().getSpawnLocation());
		}

	}


}
