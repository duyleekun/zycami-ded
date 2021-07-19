/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.e0;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class q
implements ListenerSet$Event {
    public final /* synthetic */ AnalyticsListener$EventTime a;
    public final /* synthetic */ ExoPlaybackException b;

    public /* synthetic */ q(AnalyticsListener$EventTime analyticsListener$EventTime, ExoPlaybackException exoPlaybackException) {
        this.a = analyticsListener$EventTime;
        this.b = exoPlaybackException;
    }

    public final void invoke(Object object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.a;
        ExoPlaybackException exoPlaybackException = this.b;
        object = (AnalyticsListener)object;
        AnalyticsCollector.H(analyticsListener$EventTime, exoPlaybackException, (AnalyticsListener)object);
    }
}

