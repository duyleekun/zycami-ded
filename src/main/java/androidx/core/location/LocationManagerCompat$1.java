/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.GpsStatus$Listener
 *  android.location.LocationManager
 */
package androidx.core.location;

import android.location.GpsStatus;
import android.location.LocationManager;
import androidx.core.location.LocationManagerCompat$GpsStatusTransport;
import java.util.concurrent.Callable;

public class LocationManagerCompat$1
implements Callable {
    public final /* synthetic */ LocationManager val$locationManager;
    public final /* synthetic */ LocationManagerCompat$GpsStatusTransport val$myTransport;

    public LocationManagerCompat$1(LocationManager locationManager, LocationManagerCompat$GpsStatusTransport gpsStatusTransport) {
        this.val$locationManager = locationManager;
        this.val$myTransport = gpsStatusTransport;
    }

    public Boolean call() {
        LocationManager locationManager = this.val$locationManager;
        LocationManagerCompat$GpsStatusTransport locationManagerCompat$GpsStatusTransport = this.val$myTransport;
        return locationManager.addGpsStatusListener((GpsStatus.Listener)locationManagerCompat$GpsStatusTransport);
    }
}

