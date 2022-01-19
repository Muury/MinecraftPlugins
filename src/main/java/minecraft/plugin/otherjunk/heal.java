package minecraft.plugin.otherjunk;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class heal implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        if (!(sender instanceof Player)) {
            sender.sendMessage("Console cannot be healed");
            return true;
        }

        if (args.length == 0) {

            TextComponent message = new TextComponent(ChatColor.YELLOW + "Would you like to be healed?");
            message.setColor(ChatColor.YELLOW);
            message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/doctor healme"));
            message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                    new ComponentBuilder("Click here to be healed").color(ChatColor.GRAY).italic(true).create()));
            player.spigot().sendMessage(message);
            return true;

        }

        if (args[0].equalsIgnoreCase("healme")) {
            player.setHealth(20.0);
            player.setFoodLevel(20);
            player.sendMessage(org.bukkit.ChatColor.GREEN + "You have been healed!");
            //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "heal "+ player.getName());
            return true;
        }
        player.sendMessage(ChatColor.RED + "Usage: /doctor");
        return false;
    }
}
