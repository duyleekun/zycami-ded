/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.GnssStatus
 *  android.location.GnssStatus$Callback
 */
package androidx.core.location;

import android.location.GnssStatus;
import androidx.core.location.GnssStatusCompat;
import androidx.core.location.GnssStatusCompat$Callback;
import androidx.core.util.Preconditions;

public class LocationManagerCompat$GnssStatusTransport
extends GnssStatus.Callback {
    public final GnssStatusCompat$Callback mCallback;

    public LocationManagerCompat$GnssStatusTransport(GnssStatusCompat$Callback gnssStatusCompat$Callback) {
        boolean bl2 = gnssStatusCompat$Callback != null;
        Preconditions.checkArgument(bl2, "invalid null callback");
        this.mCallback = gnssStatusCompat$Callback;
    }

    public void onFirstFix(int n10) {
        this.mCallback.onFirstFix(n10);
    }

    public void onSatelliteStatusChanged(GnssStatus object) {
        GnssStatusCompat$Callback gnssStatusCompat$Callback = this.mCallback;
        object = GnssStatusCompat.wrap(object);
        gnssStatusCompat$Callback.onSatelliteStatusChanged((GnssStatusCompat)object);
    }

    public void onStarted() {
        this.mCallback.onStarted();
    }

    public void onStopped() {
        this.mCallback.onStopped();
    }
}

