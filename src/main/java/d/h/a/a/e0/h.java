/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.e0;

import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class h
implements ListenerSet$Event {
    public final /* synthetic */ AnalyticsListener$EventTime a;
    public final /* synthetic */ TrackGroupArray b;
    public final /* synthetic */ TrackSelectionArray c;

    public /* synthetic */ h(AnalyticsListener$EventTime analyticsListener$EventTime, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        this.a = analyticsListener$EventTime;
        this.b = trackGroupArray;
        this.c = trackSelectionArray;
    }

    public final void invoke(Object object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.a;
        TrackGroupArray trackGroupArray = this.b;
        TrackSelectionArray trackSelectionArray = this.c;
        object = (AnalyticsListener)object;
        AnalyticsCollector.S(analyticsListener$EventTime, trackGroupArray, trackSelectionArray, (AnalyticsListener)object);
    }
}

