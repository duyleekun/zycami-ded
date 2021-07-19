/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.HandlerThread
 */
package b.a.b;

import android.os.HandlerThread;

public final class a
implements Runnable {
    public final /* synthetic */ HandlerThread a;

    public /* synthetic */ a(HandlerThread handlerThread) {
        this.a = handlerThread;
    }

    public final void run() {
        this.a.quitSafely();
    }
}

