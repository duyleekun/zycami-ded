/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.GnssStatus
 *  android.location.GnssStatus$Callback
 */
package androidx.core.location;

import android.location.GnssStatus;
import androidx.core.location.GnssStatusCompat$Callback;
import androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport$1;
import androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport$2;
import androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport$3;
import androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport$4;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;

public class LocationManagerCompat$PreRGnssStatusTransport
extends GnssStatus.Callback {
    public final GnssStatusCompat$Callback mCallback;
    public volatile Executor mExecutor;

    public LocationManagerCompat$PreRGnssStatusTransport(GnssStatusCompat$Callback gnssStatusCompat$Callback) {
        boolean bl2 = gnssStatusCompat$Callback != null;
        Preconditions.checkArgument(bl2, "invalid null callback");
        this.mCallback = gnssStatusCompat$Callback;
    }

    public void onFirstFix(int n10) {
        Executor executor = this.mExecutor;
        if (executor == null) {
            return;
        }
        LocationManagerCompat$PreRGnssStatusTransport$3 locationManagerCompat$PreRGnssStatusTransport$3 = new LocationManagerCompat$PreRGnssStatusTransport$3(this, executor, n10);
        executor.execute(locationManagerCompat$PreRGnssStatusTransport$3);
    }

    public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
        Executor executor = this.mExecutor;
        if (executor == null) {
            return;
        }
        LocationManagerCompat$PreRGnssStatusTransport$4 locationManagerCompat$PreRGnssStatusTransport$4 = new LocationManagerCompat$PreRGnssStatusTransport$4(this, executor, gnssStatus);
        executor.execute(locationManagerCompat$PreRGnssStatusTransport$4);
    }

    public void onStarted() {
        Executor executor = this.mExecutor;
        if (executor == null) {
            return;
        }
        LocationManagerCompat$PreRGnssStatusTransport$1 locationManagerCompat$PreRGnssStatusTransport$1 = new LocationManagerCompat$PreRGnssStatusTransport$1(this, executor);
        executor.execute(locationManagerCompat$PreRGnssStatusTransport$1);
    }

    public void onStopped() {
        Executor executor = this.mExecutor;
        if (executor == null) {
            return;
        }
        LocationManagerCompat$PreRGnssStatusTransport$2 locationManagerCompat$PreRGnssStatusTransport$2 = new LocationManagerCompat$PreRGnssStatusTransport$2(this, executor);
        executor.execute(locationManagerCompat$PreRGnssStatusTransport$2);
    }

    public void register(Executor executor) {
        Executor executor2;
        boolean bl2;
        boolean bl3 = true;
        if (executor != null) {
            bl2 = bl3;
        } else {
            bl2 = false;
            executor2 = null;
        }
        String string2 = "invalid null executor";
        Preconditions.checkArgument(bl2, string2);
        executor2 = this.mExecutor;
        if (executor2 != null) {
            bl3 = false;
        }
        Preconditions.checkState(bl3);
        this.mExecutor = executor;
    }

    public void unregister() {
        this.mExecutor = null;
    }
}

