package minecraft.plugin.commands.administration;


import minecraft.plugin.commands.util.ChatUtil;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Broadcast implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        Server server = sender.getServer();

        String text = "";
        if (args.length > 1) {
            if (args[0].equalsIgnoreCase("chat")) {
                for (int i = 1; i < args.length; i++) {
                    text = text + args[i] + " ";

                }
                server.broadcastMessage(ChatUtil.color(" "));
                server.broadcastMessage(ChatUtil.color("&4&l[Ogloszenie]&f " + text));
                server.broadcastMessage(ChatUtil.color(" "));
            } else if (args[0].equalsIgnoreCase("title")) {

                for (int i = 1; i < args.length; i++) {
                    text = text + args[i] + " ";

                }

                if (text.contains("&")) {
                    int x = text.indexOf("&");
                    int y = x + 1;
                    char ch = ' ';
                    String color = " ";
                    String var = "";

                    var = var.concat(text.substring(0, y + 1));
                    text = text.substring(0, x) + ch
                            + text.substring(x + 2);

                    if (var.equalsIgnoreCase("&0")) color = "black";
                    if (var.equalsIgnoreCase("&1")) color = "dark_blue";
                    if (var.equalsIgnoreCase("&2")) color = "dark_green";
                    if (var.equalsIgnoreCase("&3")) color = "dark_aqua";
                    if (var.equalsIgnoreCase("&4")) color = "dark_red";
                    if (var.equalsIgnoreCase("&5")) color = "dark_purple";
                    if (var.equalsIgnoreCase("&6")) color = "gold";
                    if (var.equalsIgnoreCase("&7")) color = "gray";//zmiana
                    if (var.equalsIgnoreCase("&8")) color = "dark_gray";
                    if (var.equalsIgnoreCase("&9")) color = "blue";//zmiana
                    if (var.equalsIgnoreCase("&a")) color = "green";//zmiana
                    if (var.equalsIgnoreCase("&b")) color = "aqua";//zmiana
                    if (var.equalsIgnoreCase("&c")) color = "red";//zmiana
                    if (var.equalsIgnoreCase("&d")) color = "light_purple";//zmiana
                    if (var.equalsIgnoreCase("&e")) color = "yellow";//zmiana
                    if (var.equalsIgnoreCase("&f")) color = "white";

                    player.performCommand("title " + player.getDisplayName() + " times 10 25 10");
                    player.performCommand("title @a title {\"text\":\"" + text + "\", \"bold\":true, \"italic\":true, \"color\":\"" + color + "\"}");
                    return true;
                }
                player.performCommand("title " + player.getDisplayName() + " times 10 25 10");
                player.performCommand("title @a title {\"text\":\"" + text + "\", \"bold\":true, \"italic\":true, \"color\":\"white\"}");

//test
                return true;
            } else if (args[0].equalsIgnoreCase("all")) {
                for (int i = 1; i < args.length; i++) {
                    text = text + args[i] + " ";
                }


                server.broadcastMessage(ChatUtil.color(" "));
                server.broadcastMessage(ChatUtil.color("&4&l[Ogloszenie]&f " + text));
                server.broadcastMessage(ChatUtil.color(" "));

                //server.broadcastMessage(ChatUtil.color("&0&m&l                                                 "));

                if (text.contains("&")) {
                    int x = text.indexOf("&");
                    int y = x + 1;
                    char ch = ' ';
                    String color = " ";
                    String var = "";

                    var = var.concat(text.substring(0, y + 1));
                    text = text.substring(0, x) + ch
                            + text.substring(x + 2);

                    if (var.equalsIgnoreCase("&0")) color = "black";
                    if (var.equalsIgnoreCase("&1")) color = "dark_blue";
                    if (var.equalsIgnoreCase("&2")) color = "dark_green";
                    if (var.equalsIgnoreCase("&3")) color = "dark_aqua";
                    if (var.equalsIgnoreCase("&4")) color = "dark_red";
                    if (var.equalsIgnoreCase("&5")) color = "dark_purple";
                    if (var.equalsIgnoreCase("&6")) color = "gold";
                    if (var.equalsIgnoreCase("&7")) color = "gray";//zmiana
                    if (var.equalsIgnoreCase("&8")) color = "dark_gray";
                    if (var.equalsIgnoreCase("&9")) color = "blue";//zmiana
                    if (var.equalsIgnoreCase("&a")) color = "green";//zmiana
                    if (var.equalsIgnoreCase("&b")) color = "aqua";//zmiana
                    if (var.equalsIgnoreCase("&c")) color = "red";//zmiana
                    if (var.equalsIgnoreCase("&d")) color = "light_purple";//zmiana
                    if (var.equalsIgnoreCase("&e")) color = "yellow";//zmiana
                    if (var.equalsIgnoreCase("&f")) color = "white";

                    player.performCommand("title " + player.getDisplayName() + " times 10 25 10");
                    player.performCommand("title @a title {\"text\":\"" + text + "\", \"bold\":true, \"italic\":true, \"color\":\"" + color + "\"}");
                    return true;
                }
                player.performCommand("title " + player.getDisplayName() + " times 10 25 10");
                player.performCommand("title @a title {\"text\":\"" + text + "\", \"bold\":true, \"italic\":true, \"color\":\"white\"}");
                //gamerule sendCommandFeedback false
                //gamerule commandBlockOutput false


                return true;
            }
            return true;
        } else {
            sender.sendMessage(ChatUtil.color("&9Poprawne uzycie &f/bc {chat/title/all} {kolor}[text]"));

            return true;
        }
    }
}

