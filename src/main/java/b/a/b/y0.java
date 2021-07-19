/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.ProcessingSurface;

public final class y0
implements Runnable {
    public final /* synthetic */ ProcessingSurface a;

    public /* synthetic */ y0(ProcessingSurface processingSurface) {
        this.a = processingSurface;
    }

    public final void run() {
        ProcessingSurface.e(this.a);
    }
}

