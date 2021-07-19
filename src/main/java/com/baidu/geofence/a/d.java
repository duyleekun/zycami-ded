/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.geofence.a;

import com.baidu.geofence.GeoFenceListener;
import com.baidu.geofence.a.b;

public class d
implements Runnable {
    public final /* synthetic */ b a;

    public d(b b10) {
        this.a = b10;
    }

    public void run() {
        GeoFenceListener geoFenceListener = b.a(this.a);
        if (geoFenceListener != null) {
            geoFenceListener = b.a(this.a);
            int n10 = 9;
            geoFenceListener.onGeoFenceCreateFinished(null, n10, null);
        }
    }
}

