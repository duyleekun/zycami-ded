/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.location;

import androidx.core.location.GnssStatusCompat$Callback;
import androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport;
import java.util.concurrent.Executor;

public class LocationManagerCompat$PreRGnssStatusTransport$3
implements Runnable {
    public final /* synthetic */ LocationManagerCompat$PreRGnssStatusTransport this$0;
    public final /* synthetic */ Executor val$executor;
    public final /* synthetic */ int val$ttffMillis;

    public LocationManagerCompat$PreRGnssStatusTransport$3(LocationManagerCompat$PreRGnssStatusTransport locationManagerCompat$PreRGnssStatusTransport, Executor executor, int n10) {
        this.this$0 = locationManagerCompat$PreRGnssStatusTransport;
        this.val$executor = executor;
        this.val$ttffMillis = n10;
    }

    public void run() {
        Object object = this.this$0.mExecutor;
        Executor executor = this.val$executor;
        if (object != executor) {
            return;
        }
        object = this.this$0.mCallback;
        int n10 = this.val$ttffMillis;
        ((GnssStatusCompat$Callback)object).onFirstFix(n10);
    }
}

