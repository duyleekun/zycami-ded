/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a;

import com.google.android.exoplayer2.ExoPlayerImplInternal;
import com.google.android.exoplayer2.PlayerMessage;

public final class y
implements Runnable {
    public final /* synthetic */ ExoPlayerImplInternal a;
    public final /* synthetic */ PlayerMessage b;

    public /* synthetic */ y(ExoPlayerImplInternal exoPlayerImplInternal, PlayerMessage playerMessage) {
        this.a = exoPlayerImplInternal;
        this.b = playerMessage;
    }

    public final void run() {
        ExoPlayerImplInternal exoPlayerImplInternal = this.a;
        PlayerMessage playerMessage = this.b;
        exoPlayerImplInternal.d(playerMessage);
    }
}

