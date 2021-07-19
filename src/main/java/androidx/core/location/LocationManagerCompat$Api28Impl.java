/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.LocationManager
 */
package androidx.core.location;

import android.location.LocationManager;

public class LocationManagerCompat$Api28Impl {
    private LocationManagerCompat$Api28Impl() {
    }

    public static boolean isLocationEnabled(LocationManager locationManager) {
        return locationManager.isLocationEnabled();
    }
}

