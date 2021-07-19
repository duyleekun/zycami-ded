/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.e0;

import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class v
implements ListenerSet$Event {
    public final /* synthetic */ AnalyticsListener$EventTime a;
    public final /* synthetic */ int b;

    public /* synthetic */ v(AnalyticsListener$EventTime analyticsListener$EventTime, int n10) {
        this.a = analyticsListener$EventTime;
        this.b = n10;
    }

    public final void invoke(Object object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.a;
        int n10 = this.b;
        object = (AnalyticsListener)object;
        AnalyticsCollector.R(analyticsListener$EventTime, n10, (AnalyticsListener)object);
    }
}

