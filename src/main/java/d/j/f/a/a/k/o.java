/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package d.j.f.a.a.k;

import android.os.Handler;
import android.os.Looper;

public class o {
    private static Handler a;

    static {
        Handler handler;
        Looper looper = Looper.getMainLooper();
        a = handler = new Handler(looper);
    }

    public static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        a.post(runnable);
    }
}

