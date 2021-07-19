/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.g0;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;

public final class g
implements Runnable {
    public final /* synthetic */ DrmSessionEventListener$EventDispatcher a;
    public final /* synthetic */ DrmSessionEventListener b;

    public /* synthetic */ g(DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher, DrmSessionEventListener drmSessionEventListener) {
        this.a = drmSessionEventListener$EventDispatcher;
        this.b = drmSessionEventListener;
    }

    public final void run() {
        DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher = this.a;
        DrmSessionEventListener drmSessionEventListener = this.b;
        drmSessionEventListener$EventDispatcher.d(drmSessionEventListener);
    }
}

