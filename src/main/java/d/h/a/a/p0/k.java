/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.h.a.a.p0;

import android.view.View;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$TextTrackSelectionAdapter;

public final class k
implements View.OnClickListener {
    public final /* synthetic */ StyledPlayerControlView$TextTrackSelectionAdapter a;

    public /* synthetic */ k(StyledPlayerControlView$TextTrackSelectionAdapter styledPlayerControlView$TextTrackSelectionAdapter) {
        this.a = styledPlayerControlView$TextTrackSelectionAdapter;
    }

    public final void onClick(View view) {
        this.a.d(view);
    }
}

