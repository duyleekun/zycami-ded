/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import com.google.android.exoplayer2.upstream.BandwidthMeter$EventListener;
import com.google.android.exoplayer2.upstream.BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener;
import com.google.android.exoplayer2.util.Assertions;
import d.h.a.a.q0.a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class BandwidthMeter$EventListener$EventDispatcher {
    private final CopyOnWriteArrayList listeners;

    public BandwidthMeter$EventListener$EventDispatcher() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        this.listeners = copyOnWriteArrayList = new CopyOnWriteArrayList();
    }

    public static /* synthetic */ void a(BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener bandwidthMeter$EventListener$EventDispatcher$HandlerAndListener, int n10, long l10, long l11) {
        BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener.access$000(bandwidthMeter$EventListener$EventDispatcher$HandlerAndListener).onBandwidthSample(n10, l10, l11);
    }

    public void addListener(Handler handler, BandwidthMeter$EventListener bandwidthMeter$EventListener) {
        Assertions.checkNotNull(handler);
        Assertions.checkNotNull(bandwidthMeter$EventListener);
        this.removeListener(bandwidthMeter$EventListener);
        CopyOnWriteArrayList copyOnWriteArrayList = this.listeners;
        BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener bandwidthMeter$EventListener$EventDispatcher$HandlerAndListener = new BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener(handler, bandwidthMeter$EventListener);
        copyOnWriteArrayList.add(bandwidthMeter$EventListener$EventDispatcher$HandlerAndListener);
    }

    public void bandwidthSample(int n10, long l10, long l11) {
        boolean bl2;
        Iterator iterator2 = this.listeners.iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object;
            Object object2 = object = iterator2.next();
            object2 = (BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener)object;
            bl2 = BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener.access$100(object2);
            if (bl2) continue;
            object = BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener.access$200(object2);
            a a10 = new a((BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener)object2, n10, l10, l11);
            object.post((Runnable)a10);
        }
    }

    public void removeListener(BandwidthMeter$EventListener bandwidthMeter$EventListener) {
        boolean bl2;
        Iterator iterator2 = this.listeners.iterator();
        while (bl2 = iterator2.hasNext()) {
            BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener bandwidthMeter$EventListener$EventDispatcher$HandlerAndListener = (BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener)iterator2.next();
            Object object = BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener.access$000(bandwidthMeter$EventListener$EventDispatcher$HandlerAndListener);
            if (object != bandwidthMeter$EventListener) continue;
            bandwidthMeter$EventListener$EventDispatcher$HandlerAndListener.release();
            object = this.listeners;
            ((CopyOnWriteArrayList)object).remove(bandwidthMeter$EventListener$EventDispatcher$HandlerAndListener);
        }
    }
}

