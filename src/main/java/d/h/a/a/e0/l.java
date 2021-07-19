/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.e0;

import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$Events;
import com.google.android.exoplayer2.util.ListenerSet$IterationFinishedEvent;
import com.google.android.exoplayer2.util.MutableFlags;

public final class l
implements ListenerSet$IterationFinishedEvent {
    public static final /* synthetic */ l a;

    static {
        l l10;
        a = l10 = new l();
    }

    public final void invoke(Object object, MutableFlags mutableFlags) {
        object = (AnalyticsListener)object;
        mutableFlags = (AnalyticsListener$Events)mutableFlags;
        AnalyticsCollector.a((AnalyticsListener)object, (AnalyticsListener$Events)mutableFlags);
    }
}

