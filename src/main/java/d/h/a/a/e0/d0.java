/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.e0;

import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class d0
implements ListenerSet$Event {
    public final /* synthetic */ AnalyticsListener$EventTime a;
    public final /* synthetic */ PlaybackParameters b;

    public /* synthetic */ d0(AnalyticsListener$EventTime analyticsListener$EventTime, PlaybackParameters playbackParameters) {
        this.a = analyticsListener$EventTime;
        this.b = playbackParameters;
    }

    public final void invoke(Object object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.a;
        PlaybackParameters playbackParameters = this.b;
        object = (AnalyticsListener)object;
        AnalyticsCollector.E(analyticsListener$EventTime, playbackParameters, (AnalyticsListener)object);
    }
}

