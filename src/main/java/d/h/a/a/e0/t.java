/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.e0;

import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class t
implements ListenerSet$Event {
    public final /* synthetic */ AnalyticsListener$EventTime a;
    public final /* synthetic */ Exception b;

    public /* synthetic */ t(AnalyticsListener$EventTime analyticsListener$EventTime, Exception exception) {
        this.a = analyticsListener$EventTime;
        this.b = exception;
    }

    public final void invoke(Object object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.a;
        Exception exception = this.b;
        object = (AnalyticsListener)object;
        AnalyticsCollector.s(analyticsListener$EventTime, exception, (AnalyticsListener)object);
    }
}

