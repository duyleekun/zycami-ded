/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 */
package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class BatteryState {
    public static final int VELOCITY_CHARGING = 2;
    public static final int VELOCITY_FULL = 3;
    public static final int VELOCITY_UNPLUGGED = 1;
    private final Float level;
    private final boolean powerConnected;

    private BatteryState(Float f10, boolean bl2) {
        this.powerConnected = bl2;
        this.level = f10;
    }

    public static BatteryState get(Context object) {
        boolean bl2;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Float f10 = null;
        if ((object = object.registerReceiver(null, intentFilter)) != null) {
            bl2 = BatteryState.isPowerConnected((Intent)object);
            f10 = BatteryState.getLevel((Intent)object);
        } else {
            bl2 = false;
            intentFilter = null;
        }
        object = new BatteryState(f10, bl2);
        return object;
    }

    private static Float getLevel(Intent intent) {
        String string2 = "level";
        int n10 = -1;
        int n11 = intent.getIntExtra(string2, n10);
        String string3 = "scale";
        int n12 = intent.getIntExtra(string3, n10);
        if (n11 != n10 && n12 != n10) {
            float f10 = n11;
            float f11 = n12;
            return Float.valueOf(f10 / f11);
        }
        return null;
    }

    private static boolean isPowerConnected(Intent intent) {
        int n10 = -1;
        int n11 = intent.getIntExtra("status", n10);
        boolean bl2 = false;
        if (n11 == n10) {
            return false;
        }
        n10 = 2;
        if (n11 == n10 || n11 == (n10 = 5)) {
            bl2 = true;
        }
        return bl2;
    }

    public Float getBatteryLevel() {
        return this.level;
    }

    public int getBatteryVelocity() {
        Float f10;
        Object object = this.powerConnected;
        if (object != 0 && (f10 = this.level) != null) {
            double d10;
            float f11 = f10.floatValue();
            double d11 = f11;
            double d12 = d11 - (d10 = 0.99);
            object = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
            if (object < 0) {
                return 2;
            }
            return 3;
        }
        return 1;
    }

    public boolean isPowerConnected() {
        return this.powerConnected;
    }
}

