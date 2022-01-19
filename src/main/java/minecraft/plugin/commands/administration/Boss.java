package minecraft.plugin.commands.administration;

import minecraft.plugin.commands.util.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Boss implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        if (!(sender instanceof Player)) {
            sender.sendMessage("You are not allowed to perform this command");
        }

        if (args.length == 0) {
            player.setHealthScale(40);
            player.setHealth(40);
            loadItems();
            player.getInventory().addItem(loadItems());

        } else if (args.length == 1) {
            Player gracz = Bukkit.getPlayerExact(args[1]);
            if (gracz == null) {
                player.sendMessage(ChatUtil.color("&c[Blad] &fNie ma takiego gracza na liscie"));
                return true;
            }
            gracz.setHealthScale(40);
            gracz.setHealth(40);
            loadItems();
            gracz.getInventory().addItem(loadItems());


            return true;
        }
        return true;
    }


    public ItemStack[] loadItems() {
        ItemStack[] items = new ItemStack[6];

        items[0] = new ItemStack(Material.CHAINMAIL_BOOTS);
        items[1] = new ItemStack(Material.CHAINMAIL_LEGGINGS);
        items[2] = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        items[3] = new ItemStack(Material.CHAINMAIL_HELMET);
        items[4] = new ItemStack(Material.IRON_SWORD);
        items[5] = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 4);


        for (int i = 0; i < 5; i++) {
            ItemMeta meta = items[i].getItemMeta();
            items[i].addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
            items[i].addUnsafeEnchantment(Enchantment.DURABILITY, 20);
            items[i].setItemMeta(meta);
        }
        ItemMeta meta = items[4].getItemMeta();
        items[4].getItemMeta();
        items[4].addUnsafeEnchantment(Enchantment.KNOCKBACK, 6);
        items[4].addUnsafeEnchantment(Enchantment.DURABILITY, 20);
        items[4].setItemMeta(meta);
        return items;

    }


}
