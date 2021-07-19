/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.g0;

import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;
import com.google.android.exoplayer2.util.Consumer;

public final class p
implements Consumer {
    public static final /* synthetic */ p a;

    static {
        p p10;
        a = p10 = new p();
    }

    public final void accept(Object object) {
        ((DrmSessionEventListener$EventDispatcher)object).drmKeysLoaded();
    }
}

