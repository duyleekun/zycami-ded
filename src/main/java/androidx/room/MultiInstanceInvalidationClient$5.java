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
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.InvalidationTracker$Observer;
import androidx.room.MultiInstanceInvalidationClient;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class MultiInstanceInvalidationClient$5
extends InvalidationTracker$Observer {
    public final /* synthetic */ MultiInstanceInvalidationClient this$0;

    public MultiInstanceInvalidationClient$5(MultiInstanceInvalidationClient multiInstanceInvalidationClient, String[] stringArray) {
        this.this$0 = multiInstanceInvalidationClient;
        super(stringArray);
    }

    public boolean isRemote() {
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onInvalidated(Set stringArray) {
        Object object = this.this$0.mStopped;
        int n10 = ((AtomicBoolean)object).get();
        if (n10 != 0) {
            return;
        }
        try {
            object = this.this$0;
            IMultiInstanceInvalidationService iMultiInstanceInvalidationService = ((MultiInstanceInvalidationClient)object).mService;
            if (iMultiInstanceInvalidationService == null) return;
            n10 = ((MultiInstanceInvalidationClient)object).mClientId;
            String[] stringArray2 = null;
            stringArray2 = new String[]{};
            stringArray = stringArray.toArray(stringArray2);
            iMultiInstanceInvalidationService.broadcastInvalidation(n10, stringArray);
            return;
        }
        catch (RemoteException remoteException) {
            object = "ROOM";
            String string2 = "Cannot broadcast invalidation";
            Log.w((String)object, (String)string2, (Throwable)remoteException);
        }
    }
}

