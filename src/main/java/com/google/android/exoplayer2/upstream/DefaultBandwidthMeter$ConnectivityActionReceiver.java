/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.Handler
 *  android.os.Looper
 */
package com.google.android.exoplayer2.upstream;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import d.h.a.a.q0.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class DefaultBandwidthMeter$ConnectivityActionReceiver
extends BroadcastReceiver {
    private static DefaultBandwidthMeter$ConnectivityActionReceiver staticInstance;
    private final ArrayList bandwidthMeters;
    private final Handler mainHandler;

    private DefaultBandwidthMeter$ConnectivityActionReceiver() {
        Object object;
        Looper looper = Looper.getMainLooper();
        this.mainHandler = object = new Handler(looper);
        this.bandwidthMeters = object;
    }

    private /* synthetic */ void a(DefaultBandwidthMeter defaultBandwidthMeter) {
        this.updateBandwidthMeter(defaultBandwidthMeter);
    }

    public static DefaultBandwidthMeter$ConnectivityActionReceiver getInstance(Context object) {
        Class<DefaultBandwidthMeter$ConnectivityActionReceiver> clazz = DefaultBandwidthMeter$ConnectivityActionReceiver.class;
        synchronized (clazz) {
            DefaultBandwidthMeter$ConnectivityActionReceiver defaultBandwidthMeter$ConnectivityActionReceiver = staticInstance;
            if (defaultBandwidthMeter$ConnectivityActionReceiver == null) {
                staticInstance = defaultBandwidthMeter$ConnectivityActionReceiver = new DefaultBandwidthMeter$ConnectivityActionReceiver();
                defaultBandwidthMeter$ConnectivityActionReceiver = new IntentFilter();
                Object object2 = "android.net.conn.CONNECTIVITY_CHANGE";
                defaultBandwidthMeter$ConnectivityActionReceiver.addAction((String)object2);
                object2 = staticInstance;
                object.registerReceiver((BroadcastReceiver)object2, (IntentFilter)defaultBandwidthMeter$ConnectivityActionReceiver);
            }
            object = staticInstance;
            return object;
        }
    }

    private void removeClearedReferences() {
        ArrayList arrayList = this.bandwidthMeters;
        for (int i10 = arrayList.size() + -1; i10 >= 0; i10 += -1) {
            Object object = (DefaultBandwidthMeter)((WeakReference)this.bandwidthMeters.get(i10)).get();
            if (object != null) continue;
            object = this.bandwidthMeters;
            ((ArrayList)object).remove(i10);
        }
    }

    private void updateBandwidthMeter(DefaultBandwidthMeter defaultBandwidthMeter) {
        DefaultBandwidthMeter.access$100(defaultBandwidthMeter);
    }

    public /* synthetic */ void b(DefaultBandwidthMeter defaultBandwidthMeter) {
        this.a(defaultBandwidthMeter);
    }

    public void onReceive(Context context, Intent object) {
        synchronized (this) {
            int n10;
            block13: {
                n10 = this.isInitialStickyBroadcast();
                if (n10 == 0) break block13;
                return;
            }
            this.removeClearedReferences();
            n10 = 0;
            context = null;
            while (true) {
                block14: {
                    object = this.bandwidthMeters;
                    int n11 = object.size();
                    if (n10 >= n11) break;
                    object = this.bandwidthMeters;
                    object = object.get(n10);
                    object = (WeakReference)object;
                    object = object.get();
                    object = (DefaultBandwidthMeter)object;
                    if (object == null) break block14;
                    this.updateBandwidthMeter((DefaultBandwidthMeter)object);
                }
                ++n10;
            }
            return;
        }
    }

    public void register(DefaultBandwidthMeter defaultBandwidthMeter) {
        synchronized (this) {
            this.removeClearedReferences();
            ArrayList arrayList = this.bandwidthMeters;
            Object object = new WeakReference(defaultBandwidthMeter);
            arrayList.add(object);
            arrayList = this.mainHandler;
            object = new b(this, defaultBandwidthMeter);
            arrayList.post((Runnable)object);
            return;
        }
    }
}

