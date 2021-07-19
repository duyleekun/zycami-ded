/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 */
package b.a.b;

import android.view.Surface;

public final class t0
implements Runnable {
    public final /* synthetic */ Surface a;

    public /* synthetic */ t0(Surface surface) {
        this.a = surface;
    }

    public final void run() {
        this.a.release();
    }
}

