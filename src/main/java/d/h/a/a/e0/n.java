/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.e0;

import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class n
implements ListenerSet$Event {
    public final /* synthetic */ AnalyticsListener$EventTime a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public /* synthetic */ n(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, int n11) {
        this.a = analyticsListener$EventTime;
        this.b = n10;
        this.c = n11;
    }

    public final void invoke(Object object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.a;
        int n10 = this.b;
        int n11 = this.c;
        object = (AnalyticsListener)object;
        AnalyticsCollector.Q(analyticsListener$EventTime, n10, n11, (AnalyticsListener)object);
    }
}

