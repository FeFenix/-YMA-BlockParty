package fr.joschma.BlockParty.Utils;

import fr.joschma.BlockParty.Arena.Arena;
import org.bukkit.Color;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class ColourUtils {

    public String getBlockColourName(Material ma) {
        String blockName = ma.name();
        String colour = "";
        if (blockName.contains("_")) {
            colour = blockName.split("_")[0];
            if (colour.equals("LIGHT") || colour.equals("DARK"))
                colour = blockName.split("_")[1];
        }
        return colour;
    }

    public boolean isAColour(String colour, Arena a) {
        List<String> colours = new ArrayList<>(a.getPl().getColourName());
        return colours.contains(colour.toLowerCase());
    }

    public Color getBlockColour(Arena a, Material ma) {
        String colour = a.getPl().getColourUtils().getBlockColourName(ma).toLowerCase();
        return switch (colour) {
            case "red" -> Color.RED;
            case "gold" -> Color.fromRGB(255, 215, 0);
            case "yellow" -> Color.YELLOW;
            case "green" -> Color.GREEN;
            case "aqua" -> Color.AQUA;
            case "blue" -> Color.BLUE;
            case "purple" -> Color.PURPLE;
            case "white" -> Color.WHITE;
            case "gray" -> Color.GRAY;
            case "black" -> Color.BLACK;
            default -> a.getDefaultParticleColour();
        };
    }
}
