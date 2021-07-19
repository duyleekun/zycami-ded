/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.p0;

import com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager;

public final class z
implements Runnable {
    public final /* synthetic */ StyledPlayerControlViewLayoutManager a;

    public /* synthetic */ z(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager) {
        this.a = styledPlayerControlViewLayoutManager;
    }

    public final void run() {
        StyledPlayerControlViewLayoutManager.h(this.a);
    }
}

