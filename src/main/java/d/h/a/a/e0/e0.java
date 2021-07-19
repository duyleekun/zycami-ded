/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.e0;

import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.util.ListenerSet$Event;
import java.util.List;

public final class e0
implements ListenerSet$Event {
    public final /* synthetic */ AnalyticsListener$EventTime a;
    public final /* synthetic */ List b;

    public /* synthetic */ e0(AnalyticsListener$EventTime analyticsListener$EventTime, List list) {
        this.a = analyticsListener$EventTime;
        this.b = list;
    }

    public final void invoke(Object object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.a;
        List list = this.b;
        object = (AnalyticsListener)object;
        AnalyticsCollector.P(analyticsListener$EventTime, list, (AnalyticsListener)object);
    }
}

