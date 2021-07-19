/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.e0;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.util.ListenerSet$Event;

public final class o0
implements ListenerSet$Event {
    public final /* synthetic */ AnalyticsListener$EventTime a;
    public final /* synthetic */ Format b;
    public final /* synthetic */ DecoderReuseEvaluation c;

    public /* synthetic */ o0(AnalyticsListener$EventTime analyticsListener$EventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.a = analyticsListener$EventTime;
        this.b = format;
        this.c = decoderReuseEvaluation;
    }

    public final void invoke(Object object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.a;
        Format format = this.b;
        DecoderReuseEvaluation decoderReuseEvaluation = this.c;
        object = (AnalyticsListener)object;
        AnalyticsCollector.h(analyticsListener$EventTime, format, decoderReuseEvaluation, (AnalyticsListener)object);
    }
}

