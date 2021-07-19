/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 */
package d.r.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import d.r.a.m;
import d.r.a.n$a;
import d.r.a.u.s;

public final class n {
    private static final Handler a;
    private static final HandlerThread b;
    private static final Handler c;

    static {
        Handler handler;
        Object object = Looper.getMainLooper();
        a = handler = new Handler(object);
        handler = new HandlerThread("push_client_thread");
        b = handler;
        handler.start();
        handler = handler.getLooper();
        object = new n$a((Looper)handler);
        c = object;
    }

    public static void a(m m10) {
        if (m10 == null) {
            s.a("PushClientThread", "client thread error, task is null!");
            return;
        }
        int n10 = m10.b;
        Message message = new Message();
        message.what = n10;
        message.obj = m10;
        c.sendMessageDelayed(message, 0L);
    }

    public static void b(Runnable runnable) {
        Handler handler = c;
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, 15000L);
    }

    public static void c(Runnable runnable) {
        a.post(runnable);
    }
}

