package minecraft.plugin.commands.administration;

import minecraft.plugin.commands.util.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ServerCore implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String [] args){

        Player player = (Player) sender;

        if(sender instanceof Player){
            sender.sendMessage(ChatUtil.color("&cNie jestes graczem"));
        }
        sender.sendMessage(ChatUtil.color("&e&m----------&r&6ServerCore Commands&e&m----------"));
        sender.sendMessage(" ");
        sender.sendMessage(ChatUtil.color("&e/gamemode &f - Zmiana trybu gry"));
        sender.sendMessage(ChatUtil.color("&e/broadcast &f - Broadcast"));
        sender.sendMessage(ChatUtil.color("&e/res &f - Restart serwera"));
        sender.sendMessage(ChatUtil.color("&e/chat &f - Zarzadzanie czatem"));
        sender.sendMessage(ChatUtil.color("&e/regulamin &f - Regulamin serwera"));



        return true;
    }
}
