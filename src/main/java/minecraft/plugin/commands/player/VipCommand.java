package minecraft.plugin.commands.player;

import minecraft.plugin.commands.util.StatueUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;




public class VipCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Komenda jedynie dla graczy");
            return true;
        }
        Player p = (Player) sender;
        StatueUtil VipStatue = new StatueUtil("sklepu", "https://www.trollcraft.pl/pages/shop/product.php?id=8983193");

        String info = "Co posiada Vip?:\n" +
                "/kit vip, który posiada:\n" +
                "- diamentowy set ochrona 1,\n" +
                "- diamentowy mieczyk 1/1,\n" +
                "- 1 kox jabłko,\n" +
                "- 5 refili.\n" +
                "Startowy zestaw, który posiada:\n" +
                "- żelazny set prot 1\n" +
                "- diamentowy mieczyk ostrość 1,\n" +
                "- łuk moc 1\n" +
                "\n" +
                "Dostęp do kolorowego pisania na czacie,\n" +
                "Komendę /chat toggle - która umożliwa włączenie/wyłączenie czatu dla siebie.\n" +
                "15 TC za killa\n" +
                "Dostęp do sklepu rang Premium.\n" +
                "Wyróżniający i unikatowy prefix na czacie jak i na tabie.";

        VipStatue.sendMessage(p, info);
        return true;
    }
}