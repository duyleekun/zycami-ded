/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.e0;

import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class y0
implements ListenerSet$Event {
    public final /* synthetic */ AnalyticsListener$EventTime a;

    public /* synthetic */ y0(AnalyticsListener$EventTime analyticsListener$EventTime) {
        this.a = analyticsListener$EventTime;
    }

    public final void invoke(Object object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.a;
        object = (AnalyticsListener)object;
        AnalyticsCollector.b(analyticsListener$EventTime, (AnalyticsListener)object);
    }
}

