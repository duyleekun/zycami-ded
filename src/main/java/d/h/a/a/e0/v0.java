/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.e0;

import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class v0
implements ListenerSet$Event {
    public final /* synthetic */ AnalyticsListener$EventTime a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ int c;

    public /* synthetic */ v0(AnalyticsListener$EventTime analyticsListener$EventTime, boolean bl2, int n10) {
        this.a = analyticsListener$EventTime;
        this.b = bl2;
        this.c = n10;
    }

    public final void invoke(Object object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.a;
        boolean bl2 = this.b;
        int n10 = this.c;
        object = (AnalyticsListener)object;
        AnalyticsCollector.D(analyticsListener$EventTime, bl2, n10, (AnalyticsListener)object);
    }
}

