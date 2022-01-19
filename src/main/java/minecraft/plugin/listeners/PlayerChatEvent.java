package minecraft.plugin.listeners;


import minecraft.plugin.commands.administration.Test;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class PlayerChatEvent implements Listener {
    Test test = new Test();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void PlayerEvent(AsyncPlayerChatEvent event) {





        Player player = event.getPlayer();
        if (test.getX()==1) {
            event.setMessage(" ");
            event.setCancelled(true);

            player.sendMessage();
            player.sendMessage("TRUE");
        } else if(test.getX()==0) {
            player.sendMessage("false");
            return;
        }
    }
}


/*

        Chat chat = new Chat();


        Player player = event.getPlayer();
        if (chat.chatBlock) {
            player.sendMessage("true");
        }
        if (!chat.chatBlock) {
            if (!player.hasPermission("admin.chat")) {
                event.setCancelled(true);
                player.sendMessage(ChatUtil.color("&cChat jest wylaczony."));

            }
        }
    }
}
*/



