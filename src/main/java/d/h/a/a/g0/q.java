/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.g0;

import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;
import com.google.android.exoplayer2.util.Consumer;

public final class q
implements Consumer {
    public static final /* synthetic */ q a;

    static {
        q q10;
        a = q10 = new q();
    }

    public final void accept(Object object) {
        ((DrmSessionEventListener$EventDispatcher)object).drmKeysRestored();
    }
}

