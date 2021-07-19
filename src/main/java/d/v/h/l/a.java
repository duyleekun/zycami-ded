/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package d.v.h.l;

import android.os.Handler;
import android.os.Looper;
import d.v.h.l.b;

public class a {
    private static final String a = "AndroidUtil";
    private static Handler b;

    public static void a() {
        Handler handler = b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            b = null;
        }
    }

    public static Handler b() {
        return b;
    }

    public static boolean c() {
        Looper looper = Looper.getMainLooper();
        Looper looper2 = Looper.myLooper();
        return looper.equals(looper2);
    }

    public static void d(Runnable runnable) {
        Handler handler = b;
        if (handler == null) {
            d.v.h.l.b.e(a, "main handler is null,recreate main handler");
            Looper looper = Looper.getMainLooper();
            b = handler = new Handler(looper);
        }
        b.post(runnable);
    }

    public static void e(Runnable runnable, long l10) {
        Handler handler = b;
        if (handler == null) {
            d.v.h.l.b.e(a, "main handler is null,recreate main handler");
            Looper looper = Looper.getMainLooper();
            b = handler = new Handler(looper);
        }
        b.postDelayed(runnable, l10);
    }

    public static void f(Runnable runnable) {
        Handler handler = b;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }

    public static void g(Runnable runnable) {
        Handler handler = b;
        if (handler == null) {
            d.v.h.l.b.e(a, "main handler is null,recreate main handler");
            Looper looper = Looper.getMainLooper();
            b = handler = new Handler(looper);
        }
        b.post(runnable);
    }
}

