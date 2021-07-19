/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.e0;

import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class t0
implements ListenerSet$Event {
    public final /* synthetic */ AnalyticsListener$EventTime a;
    public final /* synthetic */ float b;

    public /* synthetic */ t0(AnalyticsListener$EventTime analyticsListener$EventTime, float f10) {
        this.a = analyticsListener$EventTime;
        this.b = f10;
    }

    public final void invoke(Object object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.a;
        float f10 = this.b;
        object = (AnalyticsListener)object;
        AnalyticsCollector.b0(analyticsListener$EventTime, f10, (AnalyticsListener)object);
    }
}

