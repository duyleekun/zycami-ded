/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.IntentFilter
 *  android.net.ConnectivityManager
 *  android.net.Network
 *  android.net.NetworkInfo
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.os.PowerManager
 */
package com.google.android.exoplayer2.scheduler;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import com.google.android.exoplayer2.scheduler.Requirements$1;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class Requirements
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public static final int DEVICE_CHARGING = 8;
    public static final int DEVICE_IDLE = 4;
    public static final int DEVICE_STORAGE_NOT_LOW = 16;
    public static final int NETWORK = 1;
    public static final int NETWORK_UNMETERED = 2;
    private final int requirements;

    static {
        Requirements$1 requirements$1 = new Requirements$1();
        CREATOR = requirements$1;
    }

    public Requirements(int n10) {
        int n11 = n10 & 2;
        if (n11 != 0) {
            n10 |= 1;
        }
        this.requirements = n10;
    }

    private int getNotMetNetworkRequirements(Context context) {
        boolean bl2 = this.isNetworkRequired();
        if (!bl2) {
            return 0;
        }
        NetworkInfo networkInfo = (context = (ConnectivityManager)Assertions.checkNotNull(context.getSystemService("connectivity"))).getActiveNetworkInfo();
        if (networkInfo != null && (bl2 = networkInfo.isConnected()) && (bl2 = Requirements.isInternetConnectivityValidated((ConnectivityManager)context))) {
            boolean bl3;
            bl2 = this.isUnmeteredNetworkRequired();
            if (bl2 && (bl3 = context.isActiveNetworkMetered())) {
                return 2;
            }
            return 0;
        }
        return this.requirements & 3;
    }

    private boolean isDeviceCharging(Context context) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        int n10 = 0;
        context = context.registerReceiver(null, intentFilter);
        boolean bl2 = false;
        intentFilter = null;
        if (context == null) {
            return false;
        }
        String string2 = "status";
        int n11 = context.getIntExtra(string2, -1);
        if (n11 == (n10 = 2) || n11 == (n10 = 5)) {
            bl2 = true;
        }
        return bl2;
    }

    private boolean isDeviceIdle(Context context) {
        String string2 = "power";
        context = (PowerManager)Assertions.checkNotNull(context.getSystemService(string2));
        int n10 = Util.SDK_INT;
        boolean bl2 = true;
        int n11 = 23;
        if (n10 >= n11) {
            bl2 = context.isDeviceIdleMode();
        } else {
            boolean bl3;
            boolean bl4;
            n11 = 20;
            if (!(n10 >= n11 ? !(bl4 = context.isInteractive()) : !(bl3 = context.isScreenOn()))) {
                bl2 = false;
            }
        }
        return bl2;
    }

    private static boolean isInternetConnectivityValidated(ConnectivityManager connectivityManager) {
        boolean bl2;
        int n10 = Util.SDK_INT;
        boolean bl3 = true;
        int n11 = 24;
        if (n10 < n11) {
            return bl3;
        }
        Network network = connectivityManager.getActiveNetwork();
        n11 = 0;
        if (network == null) {
            return false;
        }
        if ((connectivityManager = connectivityManager.getNetworkCapabilities(network)) == null || !(bl2 = connectivityManager.hasCapability(n10 = 16))) {
            bl3 = false;
        }
        return bl3;
    }

    private boolean isStorageNotLow(Context context) {
        boolean bl2;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW");
        if ((context = context.registerReceiver(null, intentFilter)) == null) {
            bl2 = true;
        } else {
            bl2 = false;
            context = null;
        }
        return bl2;
    }

    public boolean checkRequirements(Context context) {
        int n10 = this.getNotMetRequirements(context);
        if (!n10) {
            n10 = 1;
        } else {
            n10 = 0;
            context = null;
        }
        return n10 != 0;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class<Requirements> clazz2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (clazz2 = Requirements.class) == (clazz = object.getClass())) {
            int n10 = this.requirements;
            object = (Requirements)object;
            int n11 = ((Requirements)object).requirements;
            if (n10 != n11) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public Requirements filterRequirements(int n10) {
        int n11 = this.requirements;
        Requirements requirements = (n10 &= n11) == n11 ? this : new Requirements(n10);
        return requirements;
    }

    public int getNotMetRequirements(Context context) {
        boolean bl2;
        int n10 = this.getNotMetNetworkRequirements(context);
        boolean bl3 = this.isChargingRequired();
        if (bl3 && !(bl3 = this.isDeviceCharging(context))) {
            n10 |= 8;
        }
        if ((bl3 = this.isIdleRequired()) && !(bl3 = this.isDeviceIdle(context))) {
            n10 |= 4;
        }
        if ((bl3 = this.isStorageNotLowRequired()) && !(bl2 = this.isStorageNotLow(context))) {
            n10 |= 0x10;
        }
        return n10;
    }

    public int getRequirements() {
        return this.requirements;
    }

    public int hashCode() {
        return this.requirements;
    }

    public boolean isChargingRequired() {
        int n10 = this.requirements & 8;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isIdleRequired() {
        int n10 = this.requirements & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isNetworkRequired() {
        int n10 = this.requirements;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean isStorageNotLowRequired() {
        int n10 = this.requirements & 0x10;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isUnmeteredNetworkRequired() {
        int n10 = this.requirements & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this.requirements;
        parcel.writeInt(n10);
    }
}

