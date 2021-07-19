/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 */
package d.j.f.a.a.k;

import android.os.Looper;

public class n {
    public static boolean a() {
        boolean bl2;
        Looper looper;
        Looper looper2 = Looper.getMainLooper();
        if (looper2 == (looper = Looper.myLooper())) {
            bl2 = true;
        } else {
            bl2 = false;
            looper2 = null;
        }
        return bl2;
    }
}

