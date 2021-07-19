/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.e0;

import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class k
implements ListenerSet$Event {
    public final /* synthetic */ AnalyticsListener$EventTime a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;

    public /* synthetic */ k(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, long l10, long l11) {
        this.a = analyticsListener$EventTime;
        this.b = n10;
        this.c = l10;
        this.d = l11;
    }

    public final void invoke(Object object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.a;
        int n10 = this.b;
        long l10 = this.c;
        long l11 = this.d;
        Object object2 = object;
        object2 = (AnalyticsListener)object;
        AnalyticsCollector.m(analyticsListener$EventTime, n10, l10, l11, (AnalyticsListener)object2);
    }
}

