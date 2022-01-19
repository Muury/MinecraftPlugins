package minecraft.plugin.otherjunk;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class MiningListener implements Listener {

    @EventHandler

    public void onMine(BlockBreakEvent event) {
        Player player = (Player) event.getPlayer();
        Block block = event.getBlock();
        Material material = block.getType();
        World world = player.getWorld();
        Location location = player.getLocation();

        ItemStack item = new ItemStack(Material.DIAMOND_BLOCK);


        ItemStack blockItem = new ItemStack(block.getType());

        if (player.getExp() >= 1) {
            player.setExp(player.getExp() + 0.1f);
            player.sendMessage("Masz " + player.getExpToLevel());
            player.setLevel(player.getLevel() + 1);
            player.setExp(player.getExp() - 1);
        } else {
            player.setExp(player.getExp() + 0.1f);
            float zmienna = player.getExpToLevel()-player.getExpToLevel();
            player.sendMessage("Zostalo jeszcze "+ zmienna);

            player.sendMessage("Masz " + player.getExp());
        }
        player.getInventory().addItem(blockItem);
        block.setType(Material.AIR);


        if (material == Material.DIAMOND_ORE) {
            block.setType(Material.AIR);
            player.sendMessage(ChatColor.AQUA + "Zniszczyles rude diamentu");
            world.dropItemNaturally(location, item);
            //player.getInventory().addItem();


        }
    }
}


