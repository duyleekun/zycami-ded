/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 */
package d.h.a.a.e0;

import android.view.Surface;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class w0
implements ListenerSet$Event {
    public final /* synthetic */ AnalyticsListener$EventTime a;
    public final /* synthetic */ Surface b;

    public /* synthetic */ w0(AnalyticsListener$EventTime analyticsListener$EventTime, Surface surface) {
        this.a = analyticsListener$EventTime;
        this.b = surface;
    }

    public final void invoke(Object object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.a;
        Surface surface = this.b;
        object = (AnalyticsListener)object;
        AnalyticsCollector.K(analyticsListener$EventTime, surface, (AnalyticsListener)object);
    }
}

