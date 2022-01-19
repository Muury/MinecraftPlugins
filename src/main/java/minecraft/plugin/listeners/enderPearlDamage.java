package minecraft.plugin.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class enderPearlDamage implements Listener {


        @EventHandler(priority = EventPriority.HIGH)
        public void NoPearlDamage(EntityDamageByEntityEvent event) {

            if (event.getEntityType() != EntityType.PLAYER) {
                return;
            }
            if (!(event.getDamager().getType().equals(EntityType.ENDER_PEARL))) {
                return;
            }
            event.setCancelled(true);
        }
    }

