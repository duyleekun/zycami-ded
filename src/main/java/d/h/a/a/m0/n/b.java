/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.m0.n;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.source.dash.DashMediaSource$Factory;

public final class b
implements DrmSessionManagerProvider {
    public final /* synthetic */ DrmSessionManager a;

    public /* synthetic */ b(DrmSessionManager drmSessionManager) {
        this.a = drmSessionManager;
    }

    public final DrmSessionManager get(MediaItem mediaItem) {
        DrmSessionManager drmSessionManager = this.a;
        DashMediaSource$Factory.a(drmSessionManager, mediaItem);
        return drmSessionManager;
    }
}

