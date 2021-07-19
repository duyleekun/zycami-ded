/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.location;

import androidx.core.location.GnssStatusCompat;
import androidx.core.location.GnssStatusCompat$Callback;
import androidx.core.location.LocationManagerCompat$GpsStatusTransport;
import java.util.concurrent.Executor;

public class LocationManagerCompat$GpsStatusTransport$4
implements Runnable {
    public final /* synthetic */ LocationManagerCompat$GpsStatusTransport this$0;
    public final /* synthetic */ Executor val$executor;
    public final /* synthetic */ GnssStatusCompat val$gnssStatus;

    public LocationManagerCompat$GpsStatusTransport$4(LocationManagerCompat$GpsStatusTransport locationManagerCompat$GpsStatusTransport, Executor executor, GnssStatusCompat gnssStatusCompat) {
        this.this$0 = locationManagerCompat$GpsStatusTransport;
        this.val$executor = executor;
        this.val$gnssStatus = gnssStatusCompat;
    }

    public void run() {
        Object object = this.this$0.mExecutor;
        Object object2 = this.val$executor;
        if (object != object2) {
            return;
        }
        object = this.this$0.mCallback;
        object2 = this.val$gnssStatus;
        ((GnssStatusCompat$Callback)object).onSatelliteStatusChanged((GnssStatusCompat)object2);
    }
}

