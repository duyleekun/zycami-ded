/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnLayoutChangeListener
 */
package d.h.a.a.p0;

import android.view.View;
import com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager;

public final class v
implements View.OnLayoutChangeListener {
    public final /* synthetic */ StyledPlayerControlViewLayoutManager a;

    public /* synthetic */ v(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager) {
        this.a = styledPlayerControlViewLayoutManager;
    }

    public final void onLayoutChange(View view, int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17) {
        StyledPlayerControlViewLayoutManager.e(this.a, view, n10, n11, n12, n13, n14, n15, n16, n17);
    }
}

