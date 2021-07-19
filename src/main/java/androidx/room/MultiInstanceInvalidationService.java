/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.Intent
 *  android.os.IBinder
 *  android.os.RemoteCallbackList
 */
package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import androidx.room.IMultiInstanceInvalidationService$Stub;
import java.util.HashMap;

public class MultiInstanceInvalidationService
extends Service {
    private final IMultiInstanceInvalidationService$Stub mBinder;
    public final RemoteCallbackList mCallbackList;
    public final HashMap mClientNames;
    public int mMaxClientId = 0;

    public MultiInstanceInvalidationService() {
        Object object;
        this.mClientNames = object = new Object();
        super(this);
        this.mCallbackList = object;
        super(this);
        this.mBinder = object;
    }

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }
}

