package com.quiz.quizapp.controller;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class MusicController {

    private static Clip currentClip;

    public static void playMusic(String location, float volume, boolean loop) {
        try {
            // Stop any currently playing clip
            if (currentClip != null && currentClip.isRunning()) {
                currentClip.stop();
                currentClip.close();
            }

            File musicFile = new File(location);

            if (musicFile.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
                currentClip = AudioSystem.getClip();
                currentClip.open(audioInput);

                // Get the volume control and set the volume
                FloatControl volumeControl = (FloatControl) currentClip.getControl(FloatControl.Type.MASTER_GAIN);
                volumeControl.setValue(volume);

                if (loop) {
                    currentClip.loop(Clip.LOOP_CONTINUOUSLY); // Loop the music continuously
                }
                currentClip.start();

            } else {
                System.out.println("Can't find file: " + location);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stopMusic() {
        if (currentClip != null && currentClip.isRunning()) {
            currentClip.stop();
            currentClip.close();
        }
    }

    public static void playClickSound() {
        String clickSoundPath = "src/main/resources/music/click_sound.wav"; // Path to click sound
        try {
            File soundFile = new File(clickSoundPath);
            if (soundFile.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);

                // Get the volume control and set the volume (optional)
                FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                volumeControl.setValue(-10.0f); // Adjust volume as needed

                clip.start();
            } else {
                System.out.println("Can't find file: " + clickSoundPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

