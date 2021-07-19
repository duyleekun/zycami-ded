/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package androidx.camera.core.impl.utils;

import android.os.Handler;
import android.os.Looper;
import androidx.core.os.HandlerCompat;

public final class MainThreadAsyncHandler {
    private static volatile Handler sHandler;

    private MainThreadAsyncHandler() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Handler getInstance() {
        Object object = sHandler;
        if (object != null) {
            return sHandler;
        }
        object = MainThreadAsyncHandler.class;
        synchronized (object) {
            Handler handler = sHandler;
            if (handler == null) {
                handler = Looper.getMainLooper();
                sHandler = handler = HandlerCompat.createAsync((Looper)handler);
            }
            return sHandler;
        }
    }
}

