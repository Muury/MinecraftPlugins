package minecraft.plugin.commands.util;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


public class StatueUtil {
    static String on_hover= "Kliknij!";
    private String on_click;
    private  TextComponent message;
    private String on_send;

    public StatueUtil(String send_to, String link) {
        this.on_send = "Kliknij aby przejsc do " + send_to;
        this.on_click = link;
        this.message = new TextComponent();
        this.message.setText(this.on_send);
        this.message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(on_hover)).create()));
        this.message.setClickEvent(new ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.OPEN_URL, this.on_click));
    }
    public void sendMessage(Player player,String str) {
        player.sendMessage(ChatColor.GOLD + "=======================");
        player.sendMessage(str);
        player.spigot().sendMessage(message);
        player.sendMessage(ChatColor.GOLD + "=======================");
    }


}
