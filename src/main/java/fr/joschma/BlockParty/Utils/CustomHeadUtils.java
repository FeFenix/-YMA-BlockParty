package fr.joschma.BlockParty.Utils;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.Objects;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;

public class CustomHeadUtils {
//http://textures.minecraft.net/texture/ac4970ea91ab06ece59d45fce7604d255431f2e03a737b226082c4cce1aca1c4
    public ItemStack getCustomSkull(String url) {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) item.getItemMeta();

        PlayerProfile profile = Bukkit.createPlayerProfile("null");
        PlayerTextures textures = profile.getTextures();

        try {
            textures.setSkin(new URL(url));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        profile.setTextures(textures);

        Objects.requireNonNull(meta).setOwnerProfile(profile);

        item.setItemMeta(meta);

        return item;
    }
}
