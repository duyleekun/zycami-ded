/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package com.google.android.exoplayer2.offline;

import android.os.Handler;
import com.google.android.exoplayer2.offline.DownloadHelper$1;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.BandwidthMeter$EventListener;
import com.google.android.exoplayer2.upstream.TransferListener;

public final class DownloadHelper$FakeBandwidthMeter
implements BandwidthMeter {
    private DownloadHelper$FakeBandwidthMeter() {
    }

    public /* synthetic */ DownloadHelper$FakeBandwidthMeter(DownloadHelper$1 downloadHelper$1) {
        this();
    }

    public void addEventListener(Handler handler, BandwidthMeter$EventListener bandwidthMeter$EventListener) {
    }

    public long getBitrateEstimate() {
        return 0L;
    }

    public TransferListener getTransferListener() {
        return null;
    }

    public void removeEventListener(BandwidthMeter$EventListener bandwidthMeter$EventListener) {
    }
}

