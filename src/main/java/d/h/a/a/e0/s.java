/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.e0;

import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class s
implements ListenerSet$Event {
    public final /* synthetic */ AnalyticsListener$EventTime a;
    public final /* synthetic */ AudioAttributes b;

    public /* synthetic */ s(AnalyticsListener$EventTime analyticsListener$EventTime, AudioAttributes audioAttributes) {
        this.a = analyticsListener$EventTime;
        this.b = audioAttributes;
    }

    public final void invoke(Object object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.a;
        AudioAttributes audioAttributes = this.b;
        object = (AnalyticsListener)object;
        AnalyticsCollector.c(analyticsListener$EventTime, audioAttributes, (AnalyticsListener)object);
    }
}

