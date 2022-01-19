package minecraft.plugin.commands.administration;

import minecraft.plugin.Plugin;
import minecraft.plugin.commands.util.ChatUtil;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;


public class Restart implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatUtil.color("&cNie jestes graczem"));
            return true;
        }

        Player player = (Player) sender;
        Server server = player.getServer();
        int x;


        if (!sender.hasPermission("admin.dev")) {
            sender.sendMessage(ChatUtil.color("&4&lBLAD!&8 » &cNie posiadasz do tego uprawnien!"));
        }

        if (args.length == 1) {
            try {
                x = Integer.parseInt(args[0]);
                x = x * 60;
            } catch (NumberFormatException e) {
                sender.sendMessage(ChatUtil.color("&4&lBLAD!&8 » &cPodaj liczbe jako argument!"));
                return true;
            }
            sender.sendMessage(ChatUtil.color("&4Odliczanie restartu rozpoczete"));

            int y = x * 20;

            sender.sendMessage("Ticks: " + y);
            sender.sendMessage("Seconds: " + x);

            for (int i = x; i > -1; ) {
                int finalI = i;
                new BukkitRunnable() {
                    public void run() {

                        if (finalI < 61) {

                            if (finalI == 60)
                                server.broadcastMessage(ChatUtil.color("&cRestart serera za " + finalI + "sekund"));
                            if (finalI == 30)
                                server.broadcastMessage(ChatUtil.color("&cRestart serera za " + finalI + "sekund"));
                            if (finalI == 15)
                                server.broadcastMessage(ChatUtil.color("&cRestart serera za " + finalI + "sekund"));
                            if (finalI == 10)
                                server.broadcastMessage(ChatUtil.color("&cRestart serera za " + finalI + "sekund"));
                            if (finalI == 5)
                                server.broadcastMessage(ChatUtil.color("&cRestart serera za " + finalI + "sekund"));

                        }
                    }

                }.runTaskTimer(this.plugin, 20, 20);
                i--;
            }

            player.performCommand("restart");
            return true;
        }

        sender.sendMessage(ChatUtil.color("&9Poprawne uzycie &f/res {liczba w min}"));
        return true;
    }

    final private Plugin plugin;

    public Restart(Plugin plugin) {
        this.plugin = plugin;
    }
}


/*Bukkit.getScheduler().runTaskLater(this.plugin, () -> {
                    for (int i = finalX; i > 0; i--) {


                        if (i < 61 && i > 15) {
                            if (i % 5 == 0 && i % 3 == 0) {
                                server.broadcastMessage(ChatUtil.color("&cRestart serera za " + i + "sekund"));
                            }
                        }
                        if (i == 10)
                            server.broadcastMessage(ChatUtil.color("&cRestart serera za " + i + "sekund"));
                        if (i == 5)
                            server.broadcastMessage(ChatUtil.color("&cRestart serera za " + i + "sekund"));
                        if (i == 4)
                            server.broadcastMessage(ChatUtil.color("&cRestart serera za " + i + "sekund"));
                        if (i == 3)
                            server.broadcastMessage(ChatUtil.color("&cRestart serera za " + i + "sekund"));
                        if (i == 2)
                            server.broadcastMessage(ChatUtil.color("&cRestart serera za " + i + "sekund"));
                        if (i == 1)
                            server.broadcastMessage(ChatUtil.color("&cRestart serera za " + i + "sekund"));
                        player.performCommand("restart");
                    }
                }, 20L); // amount to wait in ticks , 20 ticks = 1 second*/