/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.Intent
 *  android.os.IBinder
 */
package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ServiceLifecycleDispatcher;

public class LifecycleService
extends Service
implements LifecycleOwner {
    private final ServiceLifecycleDispatcher mDispatcher;

    public LifecycleService() {
        ServiceLifecycleDispatcher serviceLifecycleDispatcher;
        this.mDispatcher = serviceLifecycleDispatcher = new ServiceLifecycleDispatcher(this);
    }

    public Lifecycle getLifecycle() {
        return this.mDispatcher.getLifecycle();
    }

    public IBinder onBind(Intent intent) {
        this.mDispatcher.onServicePreSuperOnBind();
        return null;
    }

    public void onCreate() {
        this.mDispatcher.onServicePreSuperOnCreate();
        super.onCreate();
    }

    public void onDestroy() {
        this.mDispatcher.onServicePreSuperOnDestroy();
        super.onDestroy();
    }

    public void onStart(Intent intent, int n10) {
        this.mDispatcher.onServicePreSuperOnStart();
        super.onStart(intent, n10);
    }

    public int onStartCommand(Intent intent, int n10, int n11) {
        return super.onStartCommand(intent, n10, n11);
    }
}

