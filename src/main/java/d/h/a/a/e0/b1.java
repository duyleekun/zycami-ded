/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.e0;

import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class b1
implements ListenerSet$Event {
    public final /* synthetic */ AnalyticsListener$EventTime a;
    public final /* synthetic */ long b;

    public /* synthetic */ b1(AnalyticsListener$EventTime analyticsListener$EventTime, long l10) {
        this.a = analyticsListener$EventTime;
        this.b = l10;
    }

    public final void invoke(Object object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.a;
        long l10 = this.b;
        object = (AnalyticsListener)object;
        AnalyticsCollector.i(analyticsListener$EventTime, l10, (AnalyticsListener)object);
    }
}

