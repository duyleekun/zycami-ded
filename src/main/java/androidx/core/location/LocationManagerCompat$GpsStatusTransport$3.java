/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.location;

import androidx.core.location.GnssStatusCompat$Callback;
import androidx.core.location.LocationManagerCompat$GpsStatusTransport;
import java.util.concurrent.Executor;

public class LocationManagerCompat$GpsStatusTransport$3
implements Runnable {
    public final /* synthetic */ LocationManagerCompat$GpsStatusTransport this$0;
    public final /* synthetic */ Executor val$executor;
    public final /* synthetic */ int val$ttff;

    public LocationManagerCompat$GpsStatusTransport$3(LocationManagerCompat$GpsStatusTransport locationManagerCompat$GpsStatusTransport, Executor executor, int n10) {
        this.this$0 = locationManagerCompat$GpsStatusTransport;
        this.val$executor = executor;
        this.val$ttff = n10;
    }

    public void run() {
        Object object = this.this$0.mExecutor;
        Executor executor = this.val$executor;
        if (object != executor) {
            return;
        }
        object = this.this$0.mCallback;
        int n10 = this.val$ttff;
        ((GnssStatusCompat$Callback)object).onFirstFix(n10);
    }
}

