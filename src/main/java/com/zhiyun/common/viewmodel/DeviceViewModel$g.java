/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.OrientationEventListener
 */
package com.zhiyun.common.viewmodel;

import android.content.Context;
import android.view.OrientationEventListener;

public abstract class DeviceViewModel$g
extends OrientationEventListener {
    private int a;

    public DeviceViewModel$g(Context context) {
        super(context);
    }

    public abstract void a(int var1);

    public void onOrientationChanged(int n10) {
        int n11;
        int n12 = -1;
        if (n10 == n12) {
            return;
        }
        n12 = this.a;
        if ((n12 = Math.abs(n10 - n12)) > (n11 = 180)) {
            n12 = 360 - n12;
        }
        if (n12 > (n11 = 60) && (n10 = (n10 + 45) / 90 * 90 % 360) != (n12 = this.a)) {
            this.a = n10;
            this.a(n10);
        }
    }
}

