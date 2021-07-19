/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.o0;

import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection$Definition;
import com.google.android.exoplayer2.trackselection.RandomTrackSelection$Factory;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil$AdaptiveTrackSelectionFactory;

public final class d
implements TrackSelectionUtil$AdaptiveTrackSelectionFactory {
    public final /* synthetic */ RandomTrackSelection$Factory a;

    public /* synthetic */ d(RandomTrackSelection$Factory randomTrackSelection$Factory) {
        this.a = randomTrackSelection$Factory;
    }

    public final ExoTrackSelection createAdaptiveTrackSelection(ExoTrackSelection$Definition exoTrackSelection$Definition) {
        return this.a.b(exoTrackSelection$Definition);
    }
}

