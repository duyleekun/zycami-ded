/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.p0;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters;
import com.google.android.exoplayer2.ui.TrackSelectionDialogBuilder;
import com.google.android.exoplayer2.ui.TrackSelectionDialogBuilder$DialogCallback;
import java.util.List;

public final class c0
implements TrackSelectionDialogBuilder$DialogCallback {
    public final /* synthetic */ DefaultTrackSelector a;
    public final /* synthetic */ DefaultTrackSelector$Parameters b;
    public final /* synthetic */ int c;
    public final /* synthetic */ TrackGroupArray d;

    public /* synthetic */ c0(DefaultTrackSelector defaultTrackSelector, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, int n10, TrackGroupArray trackGroupArray) {
        this.a = defaultTrackSelector;
        this.b = defaultTrackSelector$Parameters;
        this.c = n10;
        this.d = trackGroupArray;
    }

    public final void onTracksSelected(boolean bl2, List list) {
        DefaultTrackSelector defaultTrackSelector = this.a;
        DefaultTrackSelector$Parameters defaultTrackSelector$Parameters = this.b;
        int n10 = this.c;
        TrackGroupArray trackGroupArray = this.d;
        TrackSelectionDialogBuilder.a(defaultTrackSelector, defaultTrackSelector$Parameters, n10, trackGroupArray, bl2, list);
    }
}

