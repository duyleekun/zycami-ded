/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.g0;

import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;
import com.google.android.exoplayer2.util.Consumer;

public final class a
implements Consumer {
    public static final /* synthetic */ a a;

    static {
        a a10;
        a = a10 = new a();
    }

    public final void accept(Object object) {
        ((DrmSessionEventListener$EventDispatcher)object).drmSessionReleased();
    }
}

