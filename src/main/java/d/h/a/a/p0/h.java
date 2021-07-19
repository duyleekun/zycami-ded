/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.h.a.a.p0;

import android.view.View;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$AudioTrackSelectionAdapter;

public final class h
implements View.OnClickListener {
    public final /* synthetic */ StyledPlayerControlView$AudioTrackSelectionAdapter a;

    public /* synthetic */ h(StyledPlayerControlView$AudioTrackSelectionAdapter styledPlayerControlView$AudioTrackSelectionAdapter) {
        this.a = styledPlayerControlView$AudioTrackSelectionAdapter;
    }

    public final void onClick(View view) {
        this.a.d(view);
    }
}

