/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.e0;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$Events;
import com.google.android.exoplayer2.util.ListenerSet$IterationFinishedEvent;
import com.google.android.exoplayer2.util.MutableFlags;

public final class e1
implements ListenerSet$IterationFinishedEvent {
    public final /* synthetic */ AnalyticsCollector a;
    public final /* synthetic */ Player b;

    public /* synthetic */ e1(AnalyticsCollector analyticsCollector, Player player) {
        this.a = analyticsCollector;
        this.b = player;
    }

    public final void invoke(Object object, MutableFlags mutableFlags) {
        AnalyticsCollector analyticsCollector = this.a;
        Player player = this.b;
        object = (AnalyticsListener)object;
        mutableFlags = (AnalyticsListener$Events)mutableFlags;
        analyticsCollector.e0(player, (AnalyticsListener)object, (AnalyticsListener$Events)mutableFlags);
    }
}

