/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.e0;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class o
implements ListenerSet$Event {
    public final /* synthetic */ AnalyticsListener$EventTime a;
    public final /* synthetic */ MediaItem b;
    public final /* synthetic */ int c;

    public /* synthetic */ o(AnalyticsListener$EventTime analyticsListener$EventTime, MediaItem mediaItem, int n10) {
        this.a = analyticsListener$EventTime;
        this.b = mediaItem;
        this.c = n10;
    }

    public final void invoke(Object object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.a;
        MediaItem mediaItem = this.b;
        int n10 = this.c;
        object = (AnalyticsListener)object;
        AnalyticsCollector.B(analyticsListener$EventTime, mediaItem, n10, (AnalyticsListener)object);
    }
}

