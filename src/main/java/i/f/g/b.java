/*
 * Decompiled with CFR 0.151.
 */
package i.f.g;

import i.f.g.a;
import java.util.logging.Level;
import java.util.logging.Logger;

public class b
implements a {
    public void a() {
        System.loadLibrary("opencv_java4");
        Logger logger = Logger.getLogger("org.opencv.osgi");
        Level level = Level.INFO;
        logger.log(level, "Successfully loaded OpenCV native library.");
    }
}

