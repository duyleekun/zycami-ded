/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.m0.o;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory;

public final class a
implements DrmSessionManagerProvider {
    public final /* synthetic */ DrmSessionManager a;

    public /* synthetic */ a(DrmSessionManager drmSessionManager) {
        this.a = drmSessionManager;
    }

    public final DrmSessionManager get(MediaItem mediaItem) {
        DrmSessionManager drmSessionManager = this.a;
        HlsMediaSource$Factory.a(drmSessionManager, mediaItem);
        return drmSessionManager;
    }
}

