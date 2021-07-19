/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a;

import com.google.android.exoplayer2.ExoPlayerImpl;
import com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdate;
import com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdateListener;

public final class o
implements ExoPlayerImplInternal$PlaybackInfoUpdateListener {
    public final /* synthetic */ ExoPlayerImpl a;

    public /* synthetic */ o(ExoPlayerImpl exoPlayerImpl) {
        this.a = exoPlayerImpl;
    }

    public final void onPlaybackInfoUpdate(ExoPlayerImplInternal$PlaybackInfoUpdate exoPlayerImplInternal$PlaybackInfoUpdate) {
        this.a.e(exoPlayerImplInternal$PlaybackInfoUpdate);
    }
}

