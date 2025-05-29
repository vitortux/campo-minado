package dev.vitortux.domain.audio;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Soundtrack {
    private static final String SOUNDTRACK_PATH = "src/main/resources/audio/music/";
    private Clip playingNow = null;

    public void play(String sound) {
        play(sound, false);
    }

    public void play(String sound, boolean loop) {
        if (playingNow != null && playingNow.isRunning()) {
            playingNow.stop();
            playingNow.close();
        }

        new Thread(() -> {
            File file = getFile(sound);

            if (file == null) {
                return;
            }

            try (AudioInputStream audio = AudioSystem.getAudioInputStream(file)) {
                playingNow = AudioSystem.getClip();
                playingNow.open(audio);

                if (loop) {
                    playingNow.loop(Clip.LOOP_CONTINUOUSLY);
                } else {
                    playingNow.start();
                }

                playingNow.drain();
                playingNow.close();
                playingNow = null;
            } catch (Exception e) {
                //
            }
        }).start();
    }

    private File getFile(String path) {
        File file = new File(SOUNDTRACK_PATH + path);

        if (!file.exists()) {
            return null;
        }

        return file;
    }
}
