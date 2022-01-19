package minecraft.plugin.listeners;

import minecraft.plugin.commands.util.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.ArrayList;
import java.util.List;

public class blockedCommands implements Listener {


    @EventHandler(priority = EventPriority.LOWEST)
    public void onPreprocess(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String command = event.getMessage();
        List<String> bCmds = new ArrayList<>();
        bCmds.add("/pl");
        bCmds.add("/essentials");
        bCmds.add("/seen");
        bCmds.add("/whois");
        bCmds.add("/me");
        bCmds.add("//calc");
        bCmds.add("/help");
        bCmds.add("/?");
        bCmds.add("/version");
        bCmds.add("/ver");
        bCmds.add("/bukkit");
        bCmds.add("/about");


        String error = "&b{Plugin} &4Blad: &cNie posiadasz uprawnien by uzyc tej komendy.";


        if (player.hasPermission("admin.dev")) {
            return;
        }
        for (int i = 0; i < bCmds.size(); i++) {
            if (command.toLowerCase().startsWith(bCmds.get(i))) {
                event.setCancelled(true);
                player.sendMessage(ChatUtil.color(error));

            }
        }

/*        if (command.toLowerCase().startsWith(("/pl")) || command.toLowerCase().startsWith("/bukkit") || command.toLowerCase().startsWith("/essentials") || command.toLowerCase().startsWith("/seen")
                || command.toLowerCase().startsWith("/whois") || command.toLowerCase().startsWith("/me") || command.toLowerCase().startsWith("//calc") || command.toLowerCase().startsWith("/help")
                || command.toLowerCase().startsWith("/?") || command.toLowerCase().startsWith("/version") || command.toLowerCase().startsWith("/ver") || command.toLowerCase().startsWith("/about")) {
            event.setCancelled(true);
            player.sendMessage(ChatUtil.color(error));
        }*/
    }
}
