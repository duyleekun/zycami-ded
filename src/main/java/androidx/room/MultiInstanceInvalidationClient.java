/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.os.RemoteException
 *  android.util.Log
 */
package androidx.room;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.InvalidationTracker;
import androidx.room.InvalidationTracker$Observer;
import androidx.room.MultiInstanceInvalidationClient$1;
import androidx.room.MultiInstanceInvalidationClient$2;
import androidx.room.MultiInstanceInvalidationClient$3;
import androidx.room.MultiInstanceInvalidationClient$5;
import androidx.room.MultiInstanceInvalidationService;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class MultiInstanceInvalidationClient {
    public final Context mAppContext;
    public final IMultiInstanceInvalidationCallback mCallback;
    public int mClientId;
    public final Executor mExecutor;
    public final InvalidationTracker mInvalidationTracker;
    public final String mName;
    public final InvalidationTracker$Observer mObserver;
    public final Runnable mRemoveObserverRunnable;
    public IMultiInstanceInvalidationService mService;
    public final ServiceConnection mServiceConnection;
    public final Runnable mSetUpRunnable;
    public final AtomicBoolean mStopped;

    public MultiInstanceInvalidationClient(Context context, String intent, InvalidationTracker object, Executor stringArray) {
        Object object2 = new MultiInstanceInvalidationClient$1(this);
        this.mCallback = object2;
        this.mStopped = object2 = new AtomicBoolean(false);
        object2 = new MultiInstanceInvalidationClient$2(this);
        this.mServiceConnection = object2;
        Runnable runnable = new MultiInstanceInvalidationClient$3(this);
        this.mSetUpRunnable = runnable;
        super(this);
        this.mRemoveObserverRunnable = runnable;
        this.mAppContext = context = context.getApplicationContext();
        this.mName = intent;
        this.mInvalidationTracker = object;
        this.mExecutor = stringArray;
        intent = ((InvalidationTracker)object).mTableIdLookup.keySet();
        stringArray = new String[]{};
        intent = intent.toArray(stringArray);
        this.mObserver = object = new MultiInstanceInvalidationClient$5(this, (String[])intent);
        intent = new Intent(context, MultiInstanceInvalidationService.class);
        context.bindService(intent, (ServiceConnection)object2, 1);
    }

    public void stop() {
        Object object = this.mStopped;
        Object object2 = null;
        int n10 = 1;
        boolean bl2 = ((AtomicBoolean)object).compareAndSet(false, n10 != 0);
        if (bl2) {
            block6: {
                object = this.mInvalidationTracker;
                object2 = this.mObserver;
                ((InvalidationTracker)object).removeObserver((InvalidationTracker$Observer)object2);
                object = this.mService;
                if (object == null) break block6;
                object2 = this.mCallback;
                n10 = this.mClientId;
                try {
                    object.unregisterCallback((IMultiInstanceInvalidationCallback)object2, n10);
                }
                catch (RemoteException remoteException) {
                    object2 = "ROOM";
                    String string2 = "Cannot unregister multi-instance invalidation callback";
                    Log.w((String)object2, (String)string2, (Throwable)remoteException);
                }
            }
            object = this.mAppContext;
            object2 = this.mServiceConnection;
            object.unbindService((ServiceConnection)object2);
        }
    }
}

