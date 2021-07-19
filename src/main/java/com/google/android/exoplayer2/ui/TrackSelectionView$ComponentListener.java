/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package com.google.android.exoplayer2.ui;

import android.view.View;
import com.google.android.exoplayer2.ui.TrackSelectionView;
import com.google.android.exoplayer2.ui.TrackSelectionView$1;

public class TrackSelectionView$ComponentListener
implements View.OnClickListener {
    public final /* synthetic */ TrackSelectionView this$0;

    private TrackSelectionView$ComponentListener(TrackSelectionView trackSelectionView) {
        this.this$0 = trackSelectionView;
    }

    public /* synthetic */ TrackSelectionView$ComponentListener(TrackSelectionView trackSelectionView, TrackSelectionView$1 trackSelectionView$1) {
        this(trackSelectionView);
    }

    public void onClick(View view) {
        TrackSelectionView.access$100(this.this$0, view);
    }
}

