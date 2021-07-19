/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.g0;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;

public final class j
implements Runnable {
    public final /* synthetic */ DrmSessionEventListener$EventDispatcher a;
    public final /* synthetic */ DrmSessionEventListener b;
    public final /* synthetic */ Exception c;

    public /* synthetic */ j(DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher, DrmSessionEventListener drmSessionEventListener, Exception exception) {
        this.a = drmSessionEventListener$EventDispatcher;
        this.b = drmSessionEventListener;
        this.c = exception;
    }

    public final void run() {
        DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher = this.a;
        DrmSessionEventListener drmSessionEventListener = this.b;
        Exception exception = this.c;
        drmSessionEventListener$EventDispatcher.j(drmSessionEventListener, exception);
    }
}

