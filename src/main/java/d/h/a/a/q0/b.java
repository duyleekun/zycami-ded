/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.q0;

import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter$ConnectivityActionReceiver;

public final class b
implements Runnable {
    public final /* synthetic */ DefaultBandwidthMeter$ConnectivityActionReceiver a;
    public final /* synthetic */ DefaultBandwidthMeter b;

    public /* synthetic */ b(DefaultBandwidthMeter$ConnectivityActionReceiver defaultBandwidthMeter$ConnectivityActionReceiver, DefaultBandwidthMeter defaultBandwidthMeter) {
        this.a = defaultBandwidthMeter$ConnectivityActionReceiver;
        this.b = defaultBandwidthMeter;
    }

    public final void run() {
        DefaultBandwidthMeter$ConnectivityActionReceiver defaultBandwidthMeter$ConnectivityActionReceiver = this.a;
        DefaultBandwidthMeter defaultBandwidthMeter = this.b;
        defaultBandwidthMeter$ConnectivityActionReceiver.b(defaultBandwidthMeter);
    }
}

