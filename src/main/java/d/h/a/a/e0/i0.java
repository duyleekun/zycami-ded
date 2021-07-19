/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.e0;

import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class i0
implements ListenerSet$Event {
    public final /* synthetic */ AnalyticsListener$EventTime a;
    public final /* synthetic */ String b;

    public /* synthetic */ i0(AnalyticsListener$EventTime analyticsListener$EventTime, String string2) {
        this.a = analyticsListener$EventTime;
        this.b = string2;
    }

    public final void invoke(Object object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.a;
        String string2 = this.b;
        object = (AnalyticsListener)object;
        AnalyticsCollector.V(analyticsListener$EventTime, string2, (AnalyticsListener)object);
    }
}

