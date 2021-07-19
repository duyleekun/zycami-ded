/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.e0;

import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class w
implements ListenerSet$Event {
    public final /* synthetic */ AnalyticsListener$EventTime a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ w(AnalyticsListener$EventTime analyticsListener$EventTime, boolean bl2) {
        this.a = analyticsListener$EventTime;
        this.b = bl2;
    }

    public final void invoke(Object object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.a;
        boolean bl2 = this.b;
        object = (AnalyticsListener)object;
        AnalyticsCollector.N(analyticsListener$EventTime, bl2, (AnalyticsListener)object);
    }
}

