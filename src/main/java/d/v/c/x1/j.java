/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.HandlerThread
 */
package d.v.c.x1;

import android.os.HandlerThread;
import e.a.h0;
import e.a.q0.c.a;

public class j {
    private static final h0 a = j.a("GestureThread");
    private static final h0 b = j.a("TrackThread");

    private static h0 a(String string2) {
        HandlerThread handlerThread = new HandlerThread(string2);
        handlerThread.start();
        return e.a.q0.c.a.b(handlerThread.getLooper(), true);
    }

    public static h0 b() {
        return a;
    }

    public static h0 c() {
        return b;
    }
}

