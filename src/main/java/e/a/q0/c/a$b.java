/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package e.a.q0.c;

import android.os.Handler;
import android.os.Looper;
import e.a.h0;
import e.a.q0.c.b;

public final class a$b {
    public static final h0 a;

    static {
        Looper looper = Looper.getMainLooper();
        Handler handler = new Handler(looper);
        b b10 = new b(handler, false);
        a = b10;
    }

    private a$b() {
    }
}

