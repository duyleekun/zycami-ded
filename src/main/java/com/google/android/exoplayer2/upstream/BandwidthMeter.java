/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import com.google.android.exoplayer2.upstream.BandwidthMeter$EventListener;
import com.google.android.exoplayer2.upstream.TransferListener;

public interface BandwidthMeter {
    public void addEventListener(Handler var1, BandwidthMeter$EventListener var2);

    public long getBitrateEstimate();

    public TransferListener getTransferListener();

    public void removeEventListener(BandwidthMeter$EventListener var1);
}

