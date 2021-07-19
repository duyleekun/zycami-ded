/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.p0;

import com.google.android.exoplayer2.ui.StyledPlayerControlView;

public final class n
implements Runnable {
    public final /* synthetic */ StyledPlayerControlView a;

    public /* synthetic */ n(StyledPlayerControlView styledPlayerControlView) {
        this.a = styledPlayerControlView;
    }

    public final void run() {
        StyledPlayerControlView.b(this.a);
    }
}

