package minecraft.plugin.otherjunk;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class KillEvent implements Listener {


    @EventHandler
    public void onKill(PlayerDeathEvent e){
        Player player = e.getEntity().getKiller();
        final Inventory inventory = player.getInventory();
        ItemStack item = new ItemStack(Material.DIAMOND_BLOCK, 1);

        player.sendMessage(ChatColor.GREEN + "Zabiles gracza "+ e.getEntity().isDead());
        inventory.addItem(item);

//Do zmiany, buguje sie, gdy sam siebie zabijesz /kill
    }
}
