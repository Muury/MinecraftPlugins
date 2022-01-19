package minecraft.plugin.commands.player;

import minecraft.plugin.commands.util.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Regulamin implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        Inventory inv = Bukkit.createInventory(null, 27, ChatUtil.color("&l&f Regulamin"));

        inv.setItem(13, getItem());
        Player player = (Player) sender;
        player.openInventory(inv);
        return true;


    }



   public ItemStack getItem(){
       ItemStack item = new ItemStack(Material.BOOK);
       ItemMeta meta = item.getItemMeta();
       String name = ChatUtil.color("&f&lRegulamin");
       List<String> lore = new ArrayList<>();

       lore.add(ChatUtil.color("&8» &f1.&c Administracja ma zawsze rację."));
       lore.add(ChatUtil.color("&8» &f2.&c Wszystkie bugi nalezy zglaszac do administracji."));
       lore.add(ChatUtil.color("&8» &f3.&c "));
       lore.add(ChatUtil.color("&8» &f4.&c Na chacie obowiązuje kultura osobista"));
       lore.add(ChatUtil.color("&8» &f5.&c Zakaz wykorzystywania bugów."));
       lore.add(ChatUtil.color("&8» &f6.&c Zakaz proszenia o itemy/rangi."));
       lore.add(ChatUtil.color("&8» &f7.&c Zakaz używania niedozwolonych modyfikacji oraz wspomagaczy."));
       lore.add(ChatUtil.color("&8» &f8.&c Zakaz reklamowania innych stron, serwisów, serwerów."));
       lore.add(ChatUtil.color("&8» &f9.&c Zakaz ustawiania nickow obrazajacych innych graczy."));
       lore.add(ChatUtil.color("&8» &f10.&c Zakaz floodowania/spamowania."));


       meta.setDisplayName(name);
       meta.setLore(lore);
       item.setItemMeta(meta);
        return item;
    }
}


//        meta.setDisplayName(ChatUtil.color("&8» &f1.&c Administracja ma zawsze rację"));
//        meta.setDisplayName(ChatUtil.color("- &8» &f2.&c Posiadanie niedozwolonych modyfikacji = ban na 7 dni"));
//        meta.setDisplayName(ChatUtil.color("- &8» &f3.&c Wszystkie bugi nalezy zglaszac do administracji"));
//        meta.setDisplayName(ChatUtil.color("- &8» &f4.&c Wykorzystywanie bugów serwera = ban permamentny"));
//        meta.setDisplayName(ChatUtil.color("- &8» &f5.&c Na chacie obowiązuje kultura osobista"));
//        meta.setDisplayName(ChatUtil.color("- &8» &f6.&c Zakaz proszenia o itemy/rangi."));
//        meta.setDisplayName(ChatUtil.color("- &8» &f7.&c Zakaz chamskiego wyzywania się na chacie."));
//        meta.setDisplayName(ChatUtil.color("- &8» &f8.&c Zakaz reklamowania innych serwerow minecraft."));
//        meta.setDisplayName(ChatUtil.color("- &8» &f9.&c Zakaz ustawiania nickow obrazajacych innych graczy."));
//        meta.setDisplayName(ChatUtil.color("- &8» &f10.&c Zakaz floodowania/spamowania."));