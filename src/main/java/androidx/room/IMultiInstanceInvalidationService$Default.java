/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 */
package androidx.room;

import android.os.IBinder;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService;

public class IMultiInstanceInvalidationService$Default
implements IMultiInstanceInvalidationService {
    public IBinder asBinder() {
        return null;
    }

    public void broadcastInvalidation(int n10, String[] stringArray) {
    }

    public int registerCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String string2) {
        return 0;
    }

    public void unregisterCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int n10) {
    }
}

