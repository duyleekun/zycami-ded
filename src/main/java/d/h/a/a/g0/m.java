/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.g0;

import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.drm.ExoMediaDrm$Provider;
import com.google.android.exoplayer2.drm.FrameworkMediaDrm;
import java.util.UUID;

public final class m
implements ExoMediaDrm$Provider {
    public static final /* synthetic */ m a;

    static {
        m m10;
        a = m10 = new m();
    }

    public final ExoMediaDrm acquireExoMediaDrm(UUID uUID) {
        return FrameworkMediaDrm.g(uUID);
    }
}

