/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.e0;

import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class d
implements ListenerSet$Event {
    public final /* synthetic */ AnalyticsListener$EventTime a;
    public final /* synthetic */ Metadata b;

    public /* synthetic */ d(AnalyticsListener$EventTime analyticsListener$EventTime, Metadata metadata) {
        this.a = analyticsListener$EventTime;
        this.b = metadata;
    }

    public final void invoke(Object object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.a;
        Metadata metadata = this.b;
        object = (AnalyticsListener)object;
        AnalyticsCollector.C(analyticsListener$EventTime, metadata, (AnalyticsListener)object);
    }
}

