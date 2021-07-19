/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.k0;

import com.google.android.exoplayer2.offline.ProgressiveDownloader;
import com.google.android.exoplayer2.upstream.cache.CacheWriter$ProgressListener;

public final class n
implements CacheWriter$ProgressListener {
    public final /* synthetic */ ProgressiveDownloader a;

    public /* synthetic */ n(ProgressiveDownloader progressiveDownloader) {
        this.a = progressiveDownloader;
    }

    public final void onProgress(long l10, long l11, long l12) {
        ProgressiveDownloader.a(this.a, l10, l11, l12);
    }
}

