/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.e0;

import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class e
implements ListenerSet$Event {
    public final /* synthetic */ AnalyticsListener$EventTime a;
    public final /* synthetic */ MediaLoadData b;

    public /* synthetic */ e(AnalyticsListener$EventTime analyticsListener$EventTime, MediaLoadData mediaLoadData) {
        this.a = analyticsListener$EventTime;
        this.b = mediaLoadData;
    }

    public final void invoke(Object object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.a;
        MediaLoadData mediaLoadData = this.b;
        object = (AnalyticsListener)object;
        AnalyticsCollector.n(analyticsListener$EventTime, mediaLoadData, (AnalyticsListener)object);
    }
}

