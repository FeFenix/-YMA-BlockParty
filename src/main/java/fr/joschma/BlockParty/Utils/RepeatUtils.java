package fr.joschma.BlockParty.Utils;

import fr.joschma.BlockParty.Arena.Arena;
import fr.joschma.BlockParty.BPM;
import fr.joschma.BlockParty.Manager.FileManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class RepeatUtils {

    public static String repeat(final int count, final String with) {
        return new String(new char[count]).replace("\u0000", with);
    }

    public static String rfcdBar(final Arena a, final int i, Material actualMaterial) {
        if(a.isNoTitleBar())
            return "";

        if (actualMaterial.toString().contains("BLACK")) {
            return ChatColor.BLACK + repeat(i, "⬛") + " " + ChatColor.WHITE + ChatColor.BOLD + i + " " + ChatColor.BLACK + repeat(i, "⬛");
        }
        if (actualMaterial.toString().contains("LIGHT_BLUE")) {
            return ChatColor.AQUA + repeat(i, "⬛") + " " + ChatColor.WHITE + ChatColor.BOLD + i + " " + ChatColor.AQUA + repeat(i, "⬛");
        }
        if (actualMaterial.toString().contains("BLUE")) {
            return ChatColor.BLUE + repeat(i, "⬛") + " " + ChatColor.WHITE + ChatColor.BOLD + i + " " + ChatColor.BLUE + repeat(i, "⬛");
        }
        if (actualMaterial.toString().contains("BROWN")) {
            return ChatColor.DARK_RED + repeat(i, "⬛") + " " + ChatColor.WHITE + ChatColor.BOLD + i + " " + ChatColor.DARK_RED + repeat(i, "⬛");
        }
        if (actualMaterial.toString().contains("CYAN")) {
            return ChatColor.DARK_AQUA + repeat(i, "⬛") + " " + ChatColor.WHITE + ChatColor.BOLD + i + " " + ChatColor.DARK_AQUA + repeat(i, "⬛");
        }
        if (actualMaterial.toString().contains("LIGHT_GRAY")) {
            return ChatColor.GRAY + repeat(i, "⬛") + " " + ChatColor.WHITE + ChatColor.BOLD + i + " " + ChatColor.GRAY + repeat(i, "⬛");
        }
        if (actualMaterial.toString().contains("GRAY")) {
            return ChatColor.DARK_GRAY + repeat(i, "⬛") + " " + ChatColor.WHITE + ChatColor.BOLD + i + " " + ChatColor.DARK_GRAY + repeat(i, "⬛");
        }
        if (actualMaterial.toString().contains("GREEN")) {
            return ChatColor.DARK_GREEN + repeat(i, "⬛") + " " + ChatColor.WHITE + ChatColor.BOLD + i + " " + ChatColor.DARK_GREEN + repeat(i, "⬛");
        }
        if (actualMaterial.toString().contains("LIME")) {
            return ChatColor.GREEN + repeat(i, "⬛") + " " + ChatColor.WHITE + ChatColor.BOLD + i + " " + ChatColor.GREEN + repeat(i, "⬛");
        }
        if (actualMaterial.toString().contains("MAGENTA")) {
            return ChatColor.LIGHT_PURPLE + repeat(i, "⬛") + " " + ChatColor.WHITE + ChatColor.BOLD + i + " " + ChatColor.LIGHT_PURPLE + repeat(i, "⬛");
        }
        if (actualMaterial.toString().contains("ORANGE")) {
            return ChatColor.GOLD + repeat(i, "⬛") + " " + ChatColor.WHITE + ChatColor.BOLD + i + " " + ChatColor.GOLD + repeat(i, "⬛");
        }
        if (actualMaterial.toString().contains("PINK")) {
            return ChatColor.LIGHT_PURPLE + repeat(i, "⬛") + " " + ChatColor.WHITE + ChatColor.BOLD + i + " " + ChatColor.LIGHT_PURPLE + repeat(i, "⬛");
        }
        if (actualMaterial.toString().contains("PURPLE")) {
            return ChatColor.DARK_PURPLE + repeat(i, "⬛") + " " + ChatColor.WHITE + ChatColor.BOLD + i + " " + ChatColor.DARK_PURPLE + repeat(i, "⬛");
        }
        if (actualMaterial.toString().contains("RED")) {
            return ChatColor.RED + repeat(i, "⬛") + " " + ChatColor.WHITE + ChatColor.BOLD + i + " " + ChatColor.RED + repeat(i, "⬛");
        }
        if (actualMaterial.toString().contains("WHITE")) {
            return ChatColor.WHITE + repeat(i, "⬛") + " " + ChatColor.WHITE + ChatColor.BOLD + i + " " + ChatColor.WHITE + repeat(i, "⬛");
        }
        if (actualMaterial.toString().contains("YELLOW")) {
            return ChatColor.YELLOW + repeat(i, "⬛") + " " + ChatColor.WHITE + ChatColor.BOLD + i + " " + ChatColor.YELLOW + repeat(i, "⬛");
        }
        return ChatColor.GOLD + repeat(i, "⬛") + " " + ChatColor.WHITE + ChatColor.BOLD + i + " " + ChatColor.GOLD + repeat(i, "⬛");
    }

    public static String rfcdMsg(final Player p, final Arena a, final int i, String materialName) {
        File file = FileManager.load("ColourLanguage");
        YamlConfiguration fc = YamlConfiguration.loadConfiguration(file);
        BPM pl = a.getPl();

        if (materialName.contains("BLACK")) {
            return ChatColor.BLACK + repeat(i, "⬛") + ChatColor.BLACK + ChatColor.BOLD + pl.msg(p, fc.getString("BLACK")) + ChatColor.RESET + ChatColor.BLACK + repeat(i, "⬛");
        }
        if (materialName.contains("LIGHT_BLUE")) {
            return ChatColor.AQUA + repeat(i, "⬛") + ChatColor.AQUA + ChatColor.BOLD + pl.msg(p, fc.getString("LIGHT_BLUE")) + ChatColor.RESET + ChatColor.AQUA + repeat(i, "⬛");
        }
        if (materialName.contains("BLUE")) {
            return ChatColor.BLUE + repeat(i, "⬛") + ChatColor.BLUE + ChatColor.BOLD + pl.msg(p, fc.getString("BLUE")) + ChatColor.RESET + ChatColor.BLUE + repeat(i, "⬛");
        }
        if (materialName.contains("BROWN")) {
            return ChatColor.DARK_RED + repeat(i, "⬛") + ChatColor.DARK_RED + ChatColor.BOLD + pl.msg(p, fc.getString("BROWN")) + ChatColor.RESET + ChatColor.DARK_RED + repeat(i, "⬛");
        }
        if (materialName.contains("CYAN")) {
            return ChatColor.DARK_AQUA + repeat(i, "⬛") + ChatColor.DARK_AQUA + ChatColor.BOLD + pl.msg(p, fc.getString("CYAN")) + ChatColor.RESET + ChatColor.DARK_AQUA + repeat(i, "⬛");
        }
        if (materialName.contains("LIGHT_GRAY")) {
            return ChatColor.GRAY + repeat(i, "⬛") + ChatColor.GRAY + ChatColor.BOLD + pl.msg(p, fc.getString("LIGHT_GRAY")) + ChatColor.RESET + ChatColor.GRAY + repeat(i, "⬛");
        }
        if (materialName.contains("GRAY")) {
            return ChatColor.DARK_GRAY + repeat(i, "⬛") + ChatColor.DARK_GRAY + ChatColor.BOLD + pl.msg(p, fc.getString("GRAY")) + ChatColor.RESET + ChatColor.DARK_GRAY + repeat(i, "⬛");
        }
        if (materialName.contains("GREEN")) {
            return ChatColor.DARK_GREEN + repeat(i, "⬛") + ChatColor.DARK_GREEN + ChatColor.BOLD + pl.msg(p, fc.getString("GREEN")) + ChatColor.RESET + ChatColor.DARK_GREEN + repeat(i, "⬛");
        }
        if (materialName.contains("LIME")) {
            return ChatColor.GREEN + repeat(i, "⬛") + ChatColor.GREEN + ChatColor.BOLD + pl.msg(p, fc.getString("LIME")) + ChatColor.RESET + ChatColor.GREEN + repeat(i, "⬛");
        }
        if (materialName.contains("MAGENTA")) {
            return ChatColor.LIGHT_PURPLE + repeat(i, "⬛") + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + pl.msg(p, fc.getString("MAGENTA")) + ChatColor.RESET + ChatColor.LIGHT_PURPLE + repeat(i, "⬛");
        }
        if (materialName.contains("ORANGE")) {
            return ChatColor.GOLD + repeat(i, "⬛") + ChatColor.GOLD + ChatColor.BOLD + pl.msg(p, fc.getString("ORANGE")) + ChatColor.RESET + ChatColor.GOLD + repeat(i, "⬛");
        }
        if (materialName.contains("PINK")) {
            return ChatColor.LIGHT_PURPLE + repeat(i, "⬛") + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + pl.msg(p, fc.getString("PINK")) + ChatColor.RESET + ChatColor.LIGHT_PURPLE + repeat(i, "⬛");
        }
        if (materialName.contains("PURPLE")) {
            return ChatColor.DARK_PURPLE + repeat(i, "⬛") + ChatColor.DARK_PURPLE + ChatColor.BOLD + pl.msg(p, fc.getString("PURPLE")) + ChatColor.RESET + ChatColor.DARK_PURPLE + repeat(i, "⬛");
        }
        if (materialName.contains("RED")) {
            return ChatColor.RED + repeat(i, "⬛") + ChatColor.RED + ChatColor.BOLD + pl.msg(p, fc.getString("RED")) + ChatColor.RESET + ChatColor.RED + repeat(i, "⬛");
        }
        if (materialName.contains("YELLOW")) {
            return ChatColor.YELLOW + repeat(i, "⬛") + ChatColor.YELLOW + ChatColor.BOLD + pl.msg(p, fc.getString("YELLOW")) + ChatColor.RESET + ChatColor.YELLOW + repeat(i, "⬛");
        }
        if (materialName.contains("WHITE")) {
            return ChatColor.WHITE + repeat(i, "⬛") + ChatColor.WHITE + ChatColor.BOLD + pl.msg(p, fc.getString("WHITE")) + ChatColor.RESET + ChatColor.WHITE + repeat(i, "⬛");
        }
        return ChatColor.GOLD + repeat(i, "⬛") + ChatColor.WHITE + ChatColor.BOLD + " " + pl.msg(p, fc.getString("DEFAULT")) + " " + ChatColor.RESET + ChatColor.GOLD + repeat(i, "⬛");
    }

}
