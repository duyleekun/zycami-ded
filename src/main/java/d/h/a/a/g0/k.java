/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.g0;

import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;
import com.google.android.exoplayer2.util.Consumer;

public final class k
implements Consumer {
    public static final /* synthetic */ k a;

    static {
        k k10;
        a = k10 = new k();
    }

    public final void accept(Object object) {
        ((DrmSessionEventListener$EventDispatcher)object).drmSessionAcquired();
    }
}

