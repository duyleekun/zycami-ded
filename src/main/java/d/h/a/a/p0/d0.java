/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 */
package d.h.a.a.p0;

import android.content.DialogInterface;
import com.google.android.exoplayer2.ui.TrackSelectionDialogBuilder;
import com.google.android.exoplayer2.ui.TrackSelectionView;

public final class d0
implements DialogInterface.OnClickListener {
    public final /* synthetic */ TrackSelectionDialogBuilder a;
    public final /* synthetic */ TrackSelectionView b;

    public /* synthetic */ d0(TrackSelectionDialogBuilder trackSelectionDialogBuilder, TrackSelectionView trackSelectionView) {
        this.a = trackSelectionDialogBuilder;
        this.b = trackSelectionView;
    }

    public final void onClick(DialogInterface dialogInterface, int n10) {
        TrackSelectionDialogBuilder trackSelectionDialogBuilder = this.a;
        TrackSelectionView trackSelectionView = this.b;
        trackSelectionDialogBuilder.c(trackSelectionView, dialogInterface, n10);
    }
}

