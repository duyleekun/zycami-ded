/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  android.util.Log
 */
package androidx.room;

import android.os.RemoteException;
import android.util.Log;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.InvalidationTracker;
import androidx.room.InvalidationTracker$Observer;
import androidx.room.MultiInstanceInvalidationClient;

public class MultiInstanceInvalidationClient$3
implements Runnable {
    public final /* synthetic */ MultiInstanceInvalidationClient this$0;

    public MultiInstanceInvalidationClient$3(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.this$0 = multiInstanceInvalidationClient;
    }

    public void run() {
        block10: {
            Object object = this.this$0;
            Object object2 = ((MultiInstanceInvalidationClient)object).mService;
            if (object2 == null) break block10;
            Object object3 = ((MultiInstanceInvalidationClient)object).mCallback;
            String string2 = ((MultiInstanceInvalidationClient)object).mName;
            int n10 = object2.registerCallback((IMultiInstanceInvalidationCallback)object3, string2);
            ((MultiInstanceInvalidationClient)object).mClientId = n10;
            object = this.this$0;
            object2 = ((MultiInstanceInvalidationClient)object).mInvalidationTracker;
            object = ((MultiInstanceInvalidationClient)object).mObserver;
            try {
                ((InvalidationTracker)object2).addObserver((InvalidationTracker$Observer)object);
            }
            catch (RemoteException remoteException) {
                object2 = "ROOM";
                object3 = "Cannot register multi-instance invalidation callback";
                Log.w((String)object2, (String)object3, (Throwable)remoteException);
            }
        }
    }
}

