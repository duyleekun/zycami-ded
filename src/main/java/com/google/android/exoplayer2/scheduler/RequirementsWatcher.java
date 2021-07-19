/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.IntentFilter
 *  android.net.ConnectivityManager
 *  android.net.ConnectivityManager$NetworkCallback
 *  android.os.Handler
 */
package com.google.android.exoplayer2.scheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Handler;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.scheduler.RequirementsWatcher$DeviceStatusChangeReceiver;
import com.google.android.exoplayer2.scheduler.RequirementsWatcher$Listener;
import com.google.android.exoplayer2.scheduler.RequirementsWatcher$NetworkCallback;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class RequirementsWatcher {
    private final Context context;
    private final Handler handler;
    private final RequirementsWatcher$Listener listener;
    private RequirementsWatcher$NetworkCallback networkCallback;
    private int notMetRequirements;
    private RequirementsWatcher$DeviceStatusChangeReceiver receiver;
    private final Requirements requirements;

    public RequirementsWatcher(Context context, RequirementsWatcher$Listener requirementsWatcher$Listener, Requirements requirements) {
        this.context = context = context.getApplicationContext();
        this.listener = requirementsWatcher$Listener;
        this.requirements = requirements;
        context = Util.createHandlerForCurrentOrMainLooper();
        this.handler = context;
    }

    public static /* synthetic */ void access$200(RequirementsWatcher requirementsWatcher) {
        requirementsWatcher.checkRequirements();
    }

    public static /* synthetic */ Handler access$300(RequirementsWatcher requirementsWatcher) {
        return requirementsWatcher.handler;
    }

    public static /* synthetic */ RequirementsWatcher$NetworkCallback access$400(RequirementsWatcher requirementsWatcher) {
        return requirementsWatcher.networkCallback;
    }

    public static /* synthetic */ void access$500(RequirementsWatcher requirementsWatcher) {
        requirementsWatcher.recheckNotMetNetworkRequirements();
    }

    private void checkRequirements() {
        int n10 = this.notMetRequirements;
        Requirements requirements = this.requirements;
        Object object = this.context;
        int n11 = requirements.getNotMetRequirements((Context)object);
        if (n10 != n11) {
            this.notMetRequirements = n11;
            object = this.listener;
            object.onRequirementsStateChanged(this, n11);
        }
    }

    private void recheckNotMetNetworkRequirements() {
        int n10 = this.notMetRequirements & 3;
        if (n10 == 0) {
            return;
        }
        this.checkRequirements();
    }

    private void registerNetworkCallbackV24() {
        RequirementsWatcher$NetworkCallback requirementsWatcher$NetworkCallback;
        ConnectivityManager connectivityManager = (ConnectivityManager)Assertions.checkNotNull((ConnectivityManager)this.context.getSystemService("connectivity"));
        this.networkCallback = requirementsWatcher$NetworkCallback = new RequirementsWatcher$NetworkCallback(this, null);
        connectivityManager.registerDefaultNetworkCallback((ConnectivityManager.NetworkCallback)requirementsWatcher$NetworkCallback);
    }

    private void unregisterNetworkCallbackV24() {
        ConnectivityManager connectivityManager = (ConnectivityManager)Assertions.checkNotNull((ConnectivityManager)this.context.getSystemService("connectivity"));
        ConnectivityManager.NetworkCallback networkCallback = (ConnectivityManager.NetworkCallback)Assertions.checkNotNull((Object)this.networkCallback);
        connectivityManager.unregisterNetworkCallback(networkCallback);
        this.networkCallback = null;
    }

    public Requirements getRequirements() {
        return this.requirements;
    }

    public int start() {
        int n10;
        int n11;
        Requirements requirements = this.requirements;
        Object object = this.context;
        this.notMetRequirements = n11 = requirements.getNotMetRequirements((Context)object);
        requirements = new IntentFilter();
        object = this.requirements;
        int n12 = object.isNetworkRequired();
        if (n12 != 0) {
            n12 = Util.SDK_INT;
            n10 = 24;
            if (n12 >= n10) {
                this.registerNetworkCallbackV24();
            } else {
                object = "android.net.conn.CONNECTIVITY_CHANGE";
                requirements.addAction((String)object);
            }
        }
        if ((n12 = (int)((object = this.requirements).isChargingRequired() ? 1 : 0)) != 0) {
            requirements.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            object = "android.intent.action.ACTION_POWER_DISCONNECTED";
            requirements.addAction((String)object);
        }
        if ((n12 = (int)((object = this.requirements).isIdleRequired() ? 1 : 0)) != 0) {
            n12 = Util.SDK_INT;
            n10 = 23;
            if (n12 >= n10) {
                object = "android.os.action.DEVICE_IDLE_MODE_CHANGED";
                requirements.addAction((String)object);
            } else {
                requirements.addAction("android.intent.action.SCREEN_ON");
                object = "android.intent.action.SCREEN_OFF";
                requirements.addAction((String)object);
            }
        }
        if ((n12 = (int)((object = this.requirements).isStorageNotLowRequired() ? 1 : 0)) != 0) {
            requirements.addAction("android.intent.action.DEVICE_STORAGE_LOW");
            object = "android.intent.action.DEVICE_STORAGE_OK";
            requirements.addAction((String)object);
        }
        object = new RequirementsWatcher$DeviceStatusChangeReceiver(this, null);
        this.receiver = object;
        Context context = this.context;
        Handler handler = this.handler;
        context.registerReceiver((BroadcastReceiver)object, (IntentFilter)requirements, null, handler);
        return this.notMetRequirements;
    }

    public void stop() {
        Object object = this.context;
        BroadcastReceiver broadcastReceiver = (BroadcastReceiver)Assertions.checkNotNull((Object)this.receiver);
        object.unregisterReceiver(broadcastReceiver);
        object = null;
        this.receiver = null;
        int n10 = Util.SDK_INT;
        int n11 = 24;
        if (n10 >= n11 && (object = this.networkCallback) != null) {
            this.unregisterNetworkCallbackV24();
        }
    }
}

