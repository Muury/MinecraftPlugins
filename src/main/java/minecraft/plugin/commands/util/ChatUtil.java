package minecraft.plugin.commands.util;

import org.bukkit.ChatColor;

public class ChatUtil {

    public final static String color(String toColor) {
        return toColor.replaceAll("&", String.valueOf(ChatColor.COLOR_CHAR));
    }
}

