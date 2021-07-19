/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.h.a.a.p0;

import android.view.View;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$TrackInfo;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$TrackSelectionAdapter;

public final class l
implements View.OnClickListener {
    public final /* synthetic */ StyledPlayerControlView$TrackSelectionAdapter a;
    public final /* synthetic */ StyledPlayerControlView$TrackInfo b;

    public /* synthetic */ l(StyledPlayerControlView$TrackSelectionAdapter styledPlayerControlView$TrackSelectionAdapter, StyledPlayerControlView$TrackInfo styledPlayerControlView$TrackInfo) {
        this.a = styledPlayerControlView$TrackSelectionAdapter;
        this.b = styledPlayerControlView$TrackInfo;
    }

    public final void onClick(View view) {
        StyledPlayerControlView$TrackSelectionAdapter styledPlayerControlView$TrackSelectionAdapter = this.a;
        StyledPlayerControlView$TrackInfo styledPlayerControlView$TrackInfo = this.b;
        styledPlayerControlView$TrackSelectionAdapter.b(styledPlayerControlView$TrackInfo, view);
    }
}

