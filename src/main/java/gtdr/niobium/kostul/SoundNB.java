package gtdr.niobium.kostul;

import fr.joschma.BlockParty.BPM;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public enum SoundNB {;

    private static Plugin plugin;
    private static final String namespace = "vibecore:";

    public static void setPlugin (Plugin plugin) {
        if (SoundNB.plugin != null) throw new IllegalStateException();
        SoundNB.plugin = plugin;
    }

    // <RAW_SONG_STRING> -> <normal:song.id> <duration in seconds>

    private static int toTick (int seconds) {
        return seconds * 1000 / 50;
    }

    private static final File fixFile = new File(BPM.getPl().getDataFolder(),"fix.txt");
    private static final HashMap<String, Song> stupidFixMap;

    private record Song (String code, Integer tickDuration) {
        @Override
        public String toString () {
            return "Song{" +
                    "code='" + code + '\'' +
                    ", tickDuration=" + tickDuration +
                    '}';
        }
    }
    private record PlayingSong (Song song, BukkitTask task) {}

    static {
        try {
            List<String> data;
            if (fixFile.exists()) {
                data = Files.readAllLines(fixFile.toPath());
                Bukkit.getLogger().info("Завантажено файл: " + fixFile.getAbsolutePath());
            }
            else {
                Bukkit.getLogger().warning("Файл " + fixFile.getAbsolutePath() + " не знайдено");
                data = List.of();
            }
            stupidFixMap = HashMap.newHashMap(data.size());
            data.forEach(s -> {
                String[] tmp = s.split(" -> ");
                String key = tmp[0];
                tmp = tmp[1].split(" ");
                SoundNB.Song song = new SoundNB.Song(tmp[0], toTick(Integer.parseInt(tmp[1])));
                Bukkit.getLogger().info("Додаю mapping: " + key + " | " + song);
                stupidFixMap.put(
                        key,
                        song
                );
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Song getSong (String song, String id) {
        Song normalSong = stupidFixMap.get(song);
        if (normalSong == null) normalSong = stupidFixMap.get(id);
        if (normalSong == null) {
            Bukkit.getLogger().warning("Відсутній mapping для: " + song + " | " + id);
            return null;
        }
        return normalSong;
    }

    private static final Map<Player, Map<String, PlayingSong>> playingSongs = new LinkedHashMap<>();

    private static void add (Player p, PlayingSong s, String id) {
        Map<String, PlayingSong> tasks = playingSongs.computeIfAbsent(p, k -> new TreeMap<>());
        tasks.put(id, s);
    }

    private static Optional<PlayingSong> remove (Player p, String id) {
        Map<String, PlayingSong> tasks = playingSongs.get(p);
        if (tasks == null) return Optional.empty();
        if (tasks.isEmpty()) playingSongs.remove(p);
        return Optional.ofNullable(tasks.remove(id));
    }

    public static void play (Player p, String song, float volume, boolean looped, String id) {
        Song normalSong = getSong(song, id);
        if (normalSong == null) return;
        Runnable r = () -> p.playSound(p.getLocation(), namespace + normalSong.code, volume, 1);
        if (looped) add(
                p,
                new PlayingSong(
                        normalSong,
                        Bukkit.getScheduler().runTaskTimer(
                                plugin,
                                r,
                                0,
                                normalSong.tickDuration
                        )
                ),
                id
        );
        else Bukkit.getScheduler().runTask(plugin, r);
    }

    public static void stopPlaying (Player p, String id) {
        Map<String, PlayingSong> songs = SoundNB.playingSongs.get(p);
        if (songs == null) return;
        remove(p, id).ifPresent(playingSong -> {
            playingSong.task.cancel();
            p.stopSound(namespace + playingSong.song.code);
        });
    }

}
