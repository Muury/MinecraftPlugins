package minecraft.plugin.commands.player;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Repair implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Nie jestes graczem");
            return true;
        }
        Player player = (Player) sender;
        ItemStack item = new ItemStack(player.getInventory().getItemInMainHand());
        if (item.getType() == Material.AIR) {
            sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Musisz trzymac przedmiot w rece.");
            return true;
        }
        if (player.getInventory().getItemInMainHand().getDurability() == 0) {
            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Nie mozesz tego naprawic.");
            return true;
        }
        player.getInventory().getItemInMainHand().setDurability((short) 0);
        player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Przedmiot zostal naprawiony.");

        return true;
    }
}
