package renderEngine;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class DisplayManager {

    public static void createDisplay() {


        Display.setDisplayMode(new DisplayMode());
    }

    public static void updateDisplay() {}

    public static void closeDisplay() {}

}
