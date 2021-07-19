/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.h.a.a.p0;

import android.view.View;
import com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager;

public final class y
implements View.OnClickListener {
    public final /* synthetic */ StyledPlayerControlViewLayoutManager a;

    public /* synthetic */ y(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager) {
        this.a = styledPlayerControlViewLayoutManager;
    }

    public final void onClick(View view) {
        StyledPlayerControlViewLayoutManager.g(this.a, view);
    }
}

