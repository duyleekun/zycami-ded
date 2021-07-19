/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.g;

import com.meicam.sdk.NvsStreamingContext$PlaybackCallback2;
import com.meicam.sdk.NvsTimeline;
import d.v.v.g.h;

public final class d
implements NvsStreamingContext$PlaybackCallback2 {
    public final /* synthetic */ h a;

    public /* synthetic */ d(h h10) {
        this.a = h10;
    }

    public final void onPlaybackTimelinePosition(NvsTimeline nvsTimeline, long l10) {
        this.a.x(nvsTimeline, l10);
    }
}

