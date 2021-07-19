/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.location;

import androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport;
import java.util.concurrent.Executor;

public class LocationManagerCompat$PreRGnssStatusTransport$1
implements Runnable {
    public final /* synthetic */ LocationManagerCompat$PreRGnssStatusTransport this$0;
    public final /* synthetic */ Executor val$executor;

    public LocationManagerCompat$PreRGnssStatusTransport$1(LocationManagerCompat$PreRGnssStatusTransport preRGnssStatusTransport, Executor executor) {
        this.this$0 = preRGnssStatusTransport;
        this.val$executor = executor;
    }

    public void run() {
        Executor executor = this.this$0.mExecutor;
        Executor executor2 = this.val$executor;
        if (executor != executor2) {
            return;
        }
        this.this$0.mCallback.onStarted();
    }
}

