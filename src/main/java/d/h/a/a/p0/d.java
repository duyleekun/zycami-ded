/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.p0;

import com.google.android.exoplayer2.ui.PlayerControlView;

public final class d
implements Runnable {
    public final /* synthetic */ PlayerControlView a;

    public /* synthetic */ d(PlayerControlView playerControlView) {
        this.a = playerControlView;
    }

    public final void run() {
        PlayerControlView.a(this.a);
    }
}

