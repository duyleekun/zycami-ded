/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.location;

import androidx.core.location.LocationManagerCompat$GpsStatusTransport;
import java.util.concurrent.Executor;

public class LocationManagerCompat$GpsStatusTransport$2
implements Runnable {
    public final /* synthetic */ LocationManagerCompat$GpsStatusTransport this$0;
    public final /* synthetic */ Executor val$executor;

    public LocationManagerCompat$GpsStatusTransport$2(LocationManagerCompat$GpsStatusTransport locationManagerCompat$GpsStatusTransport, Executor executor) {
        this.this$0 = locationManagerCompat$GpsStatusTransport;
        this.val$executor = executor;
    }

    public void run() {
        Executor executor = this.this$0.mExecutor;
        Executor executor2 = this.val$executor;
        if (executor != executor2) {
            return;
        }
        this.this$0.mCallback.onStopped();
    }
}

