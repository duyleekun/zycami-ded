/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 */
package androidx.camera.core.impl.utils;

import android.os.Looper;
import androidx.core.util.Preconditions;

public final class Threads {
    private Threads() {
    }

    public static void checkBackgroundThread() {
        Preconditions.checkState(Threads.isBackgroundThread(), "In application's main thread");
    }

    public static void checkMainThread() {
        Preconditions.checkState(Threads.isMainThread(), "Not in application's main thread");
    }

    public static boolean isBackgroundThread() {
        return Threads.isMainThread() ^ true;
    }

    public static boolean isMainThread() {
        boolean bl2;
        Thread thread;
        Thread thread2 = Looper.getMainLooper().getThread();
        if (thread2 == (thread = Thread.currentThread())) {
            bl2 = true;
        } else {
            bl2 = false;
            thread2 = null;
        }
        return bl2;
    }
}

