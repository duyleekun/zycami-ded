/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.geofence.a;

import com.baidu.geofence.GeoFenceListener;
import com.baidu.geofence.a.f;

public class h
implements Runnable {
    public final /* synthetic */ f a;

    public h(f f10) {
        this.a = f10;
    }

    public void run() {
        GeoFenceListener geoFenceListener = f.a(this.a);
        if (geoFenceListener != null) {
            geoFenceListener = f.a(this.a);
            int n10 = 9;
            String string2 = f.b(this.a);
            geoFenceListener.onGeoFenceCreateFinished(null, n10, string2);
        }
    }
}

