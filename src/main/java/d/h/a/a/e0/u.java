/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.e0;

import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class u
implements ListenerSet$Event {
    public final /* synthetic */ AnalyticsListener$EventTime a;
    public final /* synthetic */ DecoderCounters b;

    public /* synthetic */ u(AnalyticsListener$EventTime analyticsListener$EventTime, DecoderCounters decoderCounters) {
        this.a = analyticsListener$EventTime;
        this.b = decoderCounters;
    }

    public final void invoke(Object object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.a;
        DecoderCounters decoderCounters = this.b;
        object = (AnalyticsListener)object;
        AnalyticsCollector.f(analyticsListener$EventTime, decoderCounters, (AnalyticsListener)object);
    }
}

