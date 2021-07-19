/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.e0;

import com.google.android.exoplayer2.analytics.DefaultPlaybackSessionManager;
import com.google.common.base.Supplier;

public final class f1
implements Supplier {
    public static final /* synthetic */ f1 a;

    static {
        f1 f12;
        a = f12 = new f1();
    }

    public final Object get() {
        return DefaultPlaybackSessionManager.a();
    }
}

