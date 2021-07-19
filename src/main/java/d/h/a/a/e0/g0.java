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
import java.io.IOException;

public final class g0
implements ListenerSet$Event {
    public final /* synthetic */ AnalyticsListener$EventTime a;
    public final /* synthetic */ LoadEventInfo b;
    public final /* synthetic */ MediaLoadData c;
    public final /* synthetic */ IOException d;
    public final /* synthetic */ boolean e;

    public /* synthetic */ g0(AnalyticsListener$EventTime analyticsListener$EventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean bl2) {
        this.a = analyticsListener$EventTime;
        this.b = loadEventInfo;
        this.c = mediaLoadData;
        this.d = iOException;
        this.e = bl2;
    }

    public final void invoke(Object object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.a;
        LoadEventInfo loadEventInfo = this.b;
        MediaLoadData mediaLoadData = this.c;
        IOException iOException = this.d;
        boolean bl2 = this.e;
        Object object2 = object;
        object2 = (AnalyticsListener)object;
        AnalyticsCollector.z(analyticsListener$EventTime, loadEventInfo, mediaLoadData, iOException, bl2, (AnalyticsListener)object2);
    }
}

