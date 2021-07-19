/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.e0;

import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class p0
implements ListenerSet$Event {
    public final /* synthetic */ AnalyticsListener$EventTime a;
    public final /* synthetic */ LoadEventInfo b;
    public final /* synthetic */ MediaLoadData c;

    public /* synthetic */ p0(AnalyticsListener$EventTime analyticsListener$EventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.a = analyticsListener$EventTime;
        this.b = loadEventInfo;
        this.c = mediaLoadData;
    }

    public final void invoke(Object object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.a;
        LoadEventInfo loadEventInfo = this.b;
        MediaLoadData mediaLoadData = this.c;
        object = (AnalyticsListener)object;
        AnalyticsCollector.A(analyticsListener$EventTime, loadEventInfo, mediaLoadData, (AnalyticsListener)object);
    }
}

