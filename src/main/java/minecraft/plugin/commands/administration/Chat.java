package minecraft.plugin.commands.administration;

import minecraft.plugin.commands.util.ChatUtil;

import org.apache.commons.lang.mutable.MutableBoolean;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;


public class Chat implements CommandExecutor, Listener {




    public MutableBoolean chat = new MutableBoolean(true);


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
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
                if (getChat().isTrue() /*isChatBlock() == true*/) {
                    sender.sendMessage(ChatUtil.color("&l&cChat jest juz wylaczony!"));

                } else {
                    sender.sendMessage(ChatUtil.color("&l&cCzat zostal wylaczony."));
                    //setChatBlock(true);
                    getChat().setValue(true);


                    return true;
                }
            } else if (args[0].equalsIgnoreCase("on")) {

                if (getChat().isFalse()) {
                    sender.sendMessage(ChatUtil.color("&l&aChat jest juz wlaczony!"));

                } else {
                    sender.sendMessage(ChatUtil.color("&l&aCzat zostal wlaczony."));

                    //setChatBlock(false);
                    getChat().setValue(false);

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






    public MutableBoolean getChat() {
        return chat;
    }

    public void setChat(MutableBoolean chat) {
        this.chat = chat;
    }

    /* @EventHandler(priority = EventPriority.HIGHEST)
    public void PlayerEvent(AsyncPlayerChatEvent event) {


        Player player = event.getPlayer();
        if (getChat().toBoolean() == true) {
            event.setCancelled(true);
            player.sendMessage("TRUE");
        } else {
            player.sendMessage("Zbychu nie dziala");
            return;
        }*/
    }






