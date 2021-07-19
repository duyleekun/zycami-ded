/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.GpsStatus
 *  android.location.GpsStatus$Listener
 *  android.location.LocationManager
 */
package androidx.core.location;

import android.location.GpsStatus;
import android.location.LocationManager;
import androidx.core.location.GnssStatusCompat;
import androidx.core.location.GnssStatusCompat$Callback;
import androidx.core.location.LocationManagerCompat$GpsStatusTransport$1;
import androidx.core.location.LocationManagerCompat$GpsStatusTransport$2;
import androidx.core.location.LocationManagerCompat$GpsStatusTransport$3;
import androidx.core.location.LocationManagerCompat$GpsStatusTransport$4;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;

public class LocationManagerCompat$GpsStatusTransport
implements GpsStatus.Listener {
    public final GnssStatusCompat$Callback mCallback;
    public volatile Executor mExecutor;
    private final LocationManager mLocationManager;

    public LocationManagerCompat$GpsStatusTransport(LocationManager locationManager, GnssStatusCompat$Callback gnssStatusCompat$Callback) {
        boolean bl2 = gnssStatusCompat$Callback != null;
        Preconditions.checkArgument(bl2, "invalid null callback");
        this.mLocationManager = locationManager;
        this.mCallback = gnssStatusCompat$Callback;
    }

    public void onGpsStatusChanged(int n10) {
        Executor executor = this.mExecutor;
        if (executor == null) {
            return;
        }
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    Object object;
                    n11 = 4;
                    if (n10 == n11 && (object = this.mLocationManager.getGpsStatus(null)) != null) {
                        object = GnssStatusCompat.wrap(object);
                        LocationManagerCompat$GpsStatusTransport$4 locationManagerCompat$GpsStatusTransport$4 = new LocationManagerCompat$GpsStatusTransport$4(this, executor, (GnssStatusCompat)object);
                        executor.execute(locationManagerCompat$GpsStatusTransport$4);
                    }
                } else {
                    GpsStatus gpsStatus = this.mLocationManager.getGpsStatus(null);
                    if (gpsStatus != null) {
                        n10 = gpsStatus.getTimeToFirstFix();
                        LocationManagerCompat$GpsStatusTransport$3 locationManagerCompat$GpsStatusTransport$3 = new LocationManagerCompat$GpsStatusTransport$3(this, executor, n10);
                        executor.execute(locationManagerCompat$GpsStatusTransport$3);
                    }
                }
            } else {
                LocationManagerCompat$GpsStatusTransport$2 locationManagerCompat$GpsStatusTransport$2 = new LocationManagerCompat$GpsStatusTransport$2(this, executor);
                executor.execute(locationManagerCompat$GpsStatusTransport$2);
            }
        } else {
            LocationManagerCompat$GpsStatusTransport$1 locationManagerCompat$GpsStatusTransport$1 = new LocationManagerCompat$GpsStatusTransport$1(this, executor);
            executor.execute(locationManagerCompat$GpsStatusTransport$1);
        }
    }

    public void register(Executor executor) {
        boolean bl2;
        Executor executor2 = this.mExecutor;
        if (executor2 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            executor2 = null;
        }
        Preconditions.checkState(bl2);
        this.mExecutor = executor;
    }

    public void unregister() {
        this.mExecutor = null;
    }
}

