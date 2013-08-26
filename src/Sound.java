/**
 * Created with IntelliJ IDEA.
 * User: andre
 * Date: 26.08.13
 * Time: 02:20
 * To change this template use File | Settings | File Templates.
 */
import java.io.IOException;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.openal.AL;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.openal.SoundStore;
import org.newdawn.slick.util.ResourceLoader;

public class Sound {
    /** The ogg sound effect */
    public Audio music;


    /**
     * Initialise resources
     */
    public void init() {

        try {
            // you can play oggs by loading the complete thing into
            // a sound
            music = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("res/soundtrack.wav"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}
