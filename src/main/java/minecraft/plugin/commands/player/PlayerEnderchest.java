package minecraft.plugin.commands.player;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerEnderchest implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        Player player = (Player) sender;

        Location loc = player.getLocation();
        World world = player.getWorld();

        player.openInventory(player.getEnderChest());
        return true;
    }
}
