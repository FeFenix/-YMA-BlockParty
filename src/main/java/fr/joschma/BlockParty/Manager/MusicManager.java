// 
// Decompiled by Procyon v0.5.36
// 

package fr.joschma.BlockParty.Manager;

import fr.joschma.BlockParty.Arena.Arena;
import gtdr.niobium.kostul.SoundNB;
import net.mcjukebox.plugin.bukkit.api.JukeboxAPI;
import org.bukkit.entity.Player;

import java.util.*;

public class MusicManager {

    Random rand = new Random();

    public void startMusic(final Arena a) {
        int i = rand.nextInt(a.getOpenAudioMusic().keySet().size());
        String music = (String) a.getOpenAudioMusic().keySet().toArray()[i];

        for (Player p : a.getPlayers()) {
            SoundNB.play(p, music, 0.5f, true, "BlockParty");
        }
    }

    public void startStopMusic(final Arena a) {
        for (Player p : a.getPlayers()) {
            SoundNB.play(p, a.getOpenAudioStopMusic(), 0.5f, true, "BlockPartyStop");
        }
    }

    public void stopMusic(final Arena a) {
        if (a.isPlayMusic()) {
            for (Player p : a.getPlayers()) {
                SoundNB.stopPlaying(p, "BlockParty");
            }
        }
    }

    public void stopStopMusic(final Arena a) {
        if (a.isPlayStopMusic()) {
            for (Player p : a.getPlayers()) {
                SoundNB.stopPlaying(p, "BlockPartyStop");
            }
        }
    }

    public void stopMcJukeboxMusic(Player p) {
        JukeboxAPI.stopMusic(p);
    }

    public void setUpMusics(final Arena a) {
        a.setPlayMusic(true);
        startMusic(a);
    }
}
