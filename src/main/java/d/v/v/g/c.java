/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.g;

import com.meicam.sdk.NvsStreamingContext$SeekingCallback;
import com.meicam.sdk.NvsTimeline;
import d.v.v.g.h;

public final class c
implements NvsStreamingContext$SeekingCallback {
    public final /* synthetic */ h a;

    public /* synthetic */ c(h h10) {
        this.a = h10;
    }

    public final void onSeekingTimelinePosition(NvsTimeline nvsTimeline, long l10) {
        this.a.z(nvsTimeline, l10);
    }
}

