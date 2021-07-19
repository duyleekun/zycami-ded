/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.e0;

import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class m
implements ListenerSet$Event {
    public final /* synthetic */ AnalyticsListener$EventTime a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;

    public /* synthetic */ m(AnalyticsListener$EventTime analyticsListener$EventTime, String string2, long l10) {
        this.a = analyticsListener$EventTime;
        this.b = string2;
        this.c = l10;
    }

    public final void invoke(Object object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.a;
        String string2 = this.b;
        long l10 = this.c;
        object = (AnalyticsListener)object;
        AnalyticsCollector.U(analyticsListener$EventTime, string2, l10, (AnalyticsListener)object);
    }
}

