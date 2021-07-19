/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.m0;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.source.ProgressiveMediaSource$Factory;

public final class l
implements DrmSessionManagerProvider {
    public final /* synthetic */ DrmSessionManager a;

    public /* synthetic */ l(DrmSessionManager drmSessionManager) {
        this.a = drmSessionManager;
    }

    public final DrmSessionManager get(MediaItem mediaItem) {
        DrmSessionManager drmSessionManager = this.a;
        ProgressiveMediaSource$Factory.a(drmSessionManager, mediaItem);
        return drmSessionManager;
    }
}

