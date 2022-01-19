package minecraft.plugin.otherjunk;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import static java.lang.Thread.sleep;

public class StoneMiningListener implements Listener {


    @EventHandler
    public void onMine(BlockBreakEvent event) {
        Player player = (Player) event.getPlayer();
        Block block = event.getBlock();
        Material material = block.getType();
        World world = player.getWorld();
        Location location = player.getLocation();

        ItemStack item = new ItemStack(Material.DIAMOND_BLOCK);


        ItemStack blockItem = new ItemStack(block.getType());

        if (block.getType().equals(Material.STONE)) {
            player.sendMessage("Hello");
            block.setType(Material.AIR);


            block.setType(Material.STONE);

        }
    }

}
