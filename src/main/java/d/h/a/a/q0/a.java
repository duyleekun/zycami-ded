/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.q0;

import com.google.android.exoplayer2.upstream.BandwidthMeter$EventListener$EventDispatcher;
import com.google.android.exoplayer2.upstream.BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener;

public final class a
implements Runnable {
    public final /* synthetic */ BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;

    public /* synthetic */ a(BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener bandwidthMeter$EventListener$EventDispatcher$HandlerAndListener, int n10, long l10, long l11) {
        this.a = bandwidthMeter$EventListener$EventDispatcher$HandlerAndListener;
        this.b = n10;
        this.c = l10;
        this.d = l11;
    }

    public final void run() {
        BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener bandwidthMeter$EventListener$EventDispatcher$HandlerAndListener = this.a;
        int n10 = this.b;
        long l10 = this.c;
        long l11 = this.d;
        BandwidthMeter$EventListener$EventDispatcher.a(bandwidthMeter$EventListener$EventDispatcher$HandlerAndListener, n10, l10, l11);
    }
}

