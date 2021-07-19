/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a;

import com.google.android.exoplayer2.ExoPlayerImpl;
import com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdate;

public final class t
implements Runnable {
    public final /* synthetic */ ExoPlayerImpl a;
    public final /* synthetic */ ExoPlayerImplInternal$PlaybackInfoUpdate b;

    public /* synthetic */ t(ExoPlayerImpl exoPlayerImpl, ExoPlayerImplInternal$PlaybackInfoUpdate exoPlayerImplInternal$PlaybackInfoUpdate) {
        this.a = exoPlayerImpl;
        this.b = exoPlayerImplInternal$PlaybackInfoUpdate;
    }

    public final void run() {
        ExoPlayerImpl exoPlayerImpl = this.a;
        ExoPlayerImplInternal$PlaybackInfoUpdate exoPlayerImplInternal$PlaybackInfoUpdate = this.b;
        exoPlayerImpl.c(exoPlayerImplInternal$PlaybackInfoUpdate);
    }
}

