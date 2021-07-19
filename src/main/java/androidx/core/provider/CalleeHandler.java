/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package androidx.core.provider;

import android.os.Handler;
import android.os.Looper;

public class CalleeHandler {
    private CalleeHandler() {
    }

    public static Handler create() {
        Looper looper = Looper.myLooper();
        if (looper == null) {
            Looper looper2 = Looper.getMainLooper();
            looper = new Handler(looper2);
        } else {
            looper = new Handler();
        }
        return looper;
    }
}

