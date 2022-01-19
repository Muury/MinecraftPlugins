package minecraft.plugin.commands.administration;

import minecraft.plugin.commands.util.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;




        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatUtil.color("&cNie jestes graczem"));
            return true;
        }

        if(!(sender.hasPermission("admin.gm"))) {
            sender.sendMessage(ChatUtil.color("&4&lBLAD!&8 » &cNie posiadasz do tego uprawnien!"));
            return true;
        }


        if (args.length == 0) {
            player.sendMessage(ChatUtil.color("&9Poprawne uzycie /gm [0/1/3] <gracz>"));
            return true;
        }

        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("0")) {
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(ChatUtil.color("&fZmieniles tryb gry na &aSurvival"));
            }
            if (args[0].equalsIgnoreCase("1")) {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(ChatUtil.color("&fZmieniles tryb gry na &aKreatywny"));
            }
            if (args[0].equalsIgnoreCase("3")) {
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage(ChatUtil.color("&fZmieniles tryb gry na &aSpectator"));
            }
            return true;
        }
        if (args.length == 2) {

            Player gracz = Bukkit.getPlayerExact(args[1]);
            if (gracz == null) {
                player.sendMessage(ChatUtil.color("&c[Blad] &fNie ma takiego gracza na liscie"));
                return true;
            }

            if (args[0].equalsIgnoreCase("0")) {
                gracz.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(ChatUtil.color("&fZmieniles tryb gry gracza ") + gracz.getName() + ChatUtil.color(" na &aSurvival"));
            }
            if (args[0].equalsIgnoreCase("1")) {
                gracz.setGameMode(GameMode.CREATIVE);
                player.sendMessage(ChatUtil.color("&fZmieniles tryb gry gracza ") + gracz.getName() + ChatUtil.color(" na &aKreatywny"));
            }
            if (args[0].equalsIgnoreCase("3")) {
                gracz.setGameMode(GameMode.SPECTATOR);
                player.sendMessage(ChatUtil.color("&fZmieniles tryb gry gracza ") + gracz.getName() + ChatUtil.color(" na &aSpectator"));
            }
            return true;

        } else {
            player.sendMessage(ChatUtil.color("&9Poprawne uzycie /gm [0/1/3] <gracz>"));
        }


        return true;
    }

}
