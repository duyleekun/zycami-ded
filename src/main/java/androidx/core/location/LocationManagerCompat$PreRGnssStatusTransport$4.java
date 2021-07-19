/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.GnssStatus
 */
package androidx.core.location;

import android.location.GnssStatus;
import androidx.core.location.GnssStatusCompat;
import androidx.core.location.GnssStatusCompat$Callback;
import androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport;
import java.util.concurrent.Executor;

public class LocationManagerCompat$PreRGnssStatusTransport$4
implements Runnable {
    public final /* synthetic */ LocationManagerCompat$PreRGnssStatusTransport this$0;
    public final /* synthetic */ Executor val$executor;
    public final /* synthetic */ GnssStatus val$status;

    public LocationManagerCompat$PreRGnssStatusTransport$4(LocationManagerCompat$PreRGnssStatusTransport locationManagerCompat$PreRGnssStatusTransport, Executor executor, GnssStatus gnssStatus) {
        this.this$0 = locationManagerCompat$PreRGnssStatusTransport;
        this.val$executor = executor;
        this.val$status = gnssStatus;
    }

    public void run() {
        Object object = this.this$0.mExecutor;
        Object object2 = this.val$executor;
        if (object != object2) {
            return;
        }
        object = this.this$0.mCallback;
        object2 = GnssStatusCompat.wrap(this.val$status);
        ((GnssStatusCompat$Callback)object).onSatelliteStatusChanged((GnssStatusCompat)object2);
    }
}

