/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import com.google.android.exoplayer2.upstream.BandwidthMeter$EventListener;

public final class BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener {
    private final Handler handler;
    private final BandwidthMeter$EventListener listener;
    private boolean released;

    public BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener(Handler handler, BandwidthMeter$EventListener bandwidthMeter$EventListener) {
        this.handler = handler;
        this.listener = bandwidthMeter$EventListener;
    }

    public static /* synthetic */ BandwidthMeter$EventListener access$000(BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener bandwidthMeter$EventListener$EventDispatcher$HandlerAndListener) {
        return bandwidthMeter$EventListener$EventDispatcher$HandlerAndListener.listener;
    }

    public static /* synthetic */ boolean access$100(BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener bandwidthMeter$EventListener$EventDispatcher$HandlerAndListener) {
        return bandwidthMeter$EventListener$EventDispatcher$HandlerAndListener.released;
    }

    public static /* synthetic */ Handler access$200(BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener bandwidthMeter$EventListener$EventDispatcher$HandlerAndListener) {
        return bandwidthMeter$EventListener$EventDispatcher$HandlerAndListener.handler;
    }

    public void release() {
        this.released = true;
    }
}

