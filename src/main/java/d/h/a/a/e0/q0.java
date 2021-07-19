/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.e0;

import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class q0
implements ListenerSet$Event {
    public final /* synthetic */ AnalyticsListener$EventTime a;
    public final /* synthetic */ long b;
    public final /* synthetic */ int c;

    public /* synthetic */ q0(AnalyticsListener$EventTime analyticsListener$EventTime, long l10, int n10) {
        this.a = analyticsListener$EventTime;
        this.b = l10;
        this.c = n10;
    }

    public final void invoke(Object object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.a;
        long l10 = this.b;
        int n10 = this.c;
        object = (AnalyticsListener)object;
        AnalyticsCollector.Y(analyticsListener$EventTime, l10, n10, (AnalyticsListener)object);
    }
}

