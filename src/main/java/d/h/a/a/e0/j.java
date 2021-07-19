/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.e0;

import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class j
implements ListenerSet$Event {
    public final /* synthetic */ AnalyticsListener$EventTime a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ float e;

    public /* synthetic */ j(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, int n11, int n12, float f10) {
        this.a = analyticsListener$EventTime;
        this.b = n10;
        this.c = n11;
        this.d = n12;
        this.e = f10;
    }

    public final void invoke(Object object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.a;
        int n10 = this.b;
        int n11 = this.c;
        int n12 = this.d;
        float f10 = this.e;
        Object object2 = object;
        object2 = (AnalyticsListener)object;
        AnalyticsCollector.a0(analyticsListener$EventTime, n10, n11, n12, f10, (AnalyticsListener)object2);
    }
}

