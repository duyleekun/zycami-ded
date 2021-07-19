/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 */
package d.q.a.f0.e;

import android.os.Looper;
import d.q.a.f0.a;
import d.q.a.f0.e.b;
import e.a.v0.e;

public class c {
    private static final e a = b.a;

    private c() {
    }

    public static boolean a() {
        return d.q.a.f0.a.c(a);
    }

    public static /* synthetic */ boolean b() {
        boolean bl2;
        Looper looper;
        Looper looper2 = Looper.myLooper();
        if (looper2 == (looper = Looper.getMainLooper())) {
            bl2 = true;
        } else {
            bl2 = false;
            looper2 = null;
        }
        return bl2;
    }
}

