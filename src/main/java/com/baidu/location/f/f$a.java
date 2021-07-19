/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.GnssMeasurementsEvent
 *  android.location.GnssMeasurementsEvent$Callback
 */
package com.baidu.location.f;

import android.location.GnssMeasurementsEvent;

public class f$a
extends GnssMeasurementsEvent.Callback {
    public int a;
    public String b;

    public void onGnssMeasurementsReceived(GnssMeasurementsEvent object) {
        int n10 = this.a;
        int n11 = 1;
        if (n10 == n11 && object != null) {
            object = object.toString();
            this.b = object;
        }
    }

    public void onStatusChanged(int n10) {
        this.a = n10;
    }
}

