package minecraft.plugin.commands.administration;

import minecraft.plugin.commands.util.ChatUtil;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class Test implements CommandExecutor, Listener {

    public int x = 0;



    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Server server = sender.getServer();

        if (args.length == 0) {
            sender.sendMessage(ChatUtil.color("&4Poprawne uzycie /chat clear/on/off"));
            return true;
        }
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("clear")) {
                for (int i = 0; i < 50; i++) {
                    server.broadcastMessage(" ");
                }
                server.broadcastMessage(ChatUtil.color("   &7Chat zostal &fwyczyszczony&7!"));
                server.broadcastMessage(ChatUtil.color("   &7Przez administratora &e" + ((Player) sender).getDisplayName()));
                return true;


            } else if (args[0].equalsIgnoreCase("off")) {
                if (x == 1) {
                    sender.sendMessage(ChatUtil.color("&l&cChat jest juz wylaczony!"));

                } else {
                    sender.sendMessage(ChatUtil.color("&l&cCzat zostal wylaczony."));
                    //setChatBlock(true);
                    setX(1);


                    return true;
                }
            } else if (args[0].equalsIgnoreCase("on")) {

                if (x == 0) {
                    sender.sendMessage(ChatUtil.color("&l&aChat jest juz wlaczony!"));

                } else {
                    sender.sendMessage(ChatUtil.color("&l&aCzat zostal wlaczony."));

                    setX(0);
                }
                return true;
            } else {
                sender.sendMessage(ChatUtil.color("&4Poprawne uzycie /chat clear/on/off"));
                return true;
            }


        } else {
            sender.sendMessage(ChatUtil.color("&4Poprawne uzycie /chat clear/on/off"));
            return true;
        }

        return true;

    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

}







