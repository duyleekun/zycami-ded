/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.ConnectivityManager$NetworkCallback
 *  android.net.Network
 *  android.net.NetworkCapabilities
 *  android.os.Handler
 */
package com.google.android.exoplayer2.scheduler;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import com.google.android.exoplayer2.scheduler.RequirementsWatcher;
import com.google.android.exoplayer2.scheduler.RequirementsWatcher$1;
import d.h.a.a.l0.a;
import d.h.a.a.l0.b;

public final class RequirementsWatcher$NetworkCallback
extends ConnectivityManager.NetworkCallback {
    private boolean networkValidated;
    private boolean receivedCapabilitiesChange;
    public final /* synthetic */ RequirementsWatcher this$0;

    private RequirementsWatcher$NetworkCallback(RequirementsWatcher requirementsWatcher) {
        this.this$0 = requirementsWatcher;
    }

    public /* synthetic */ RequirementsWatcher$NetworkCallback(RequirementsWatcher requirementsWatcher, RequirementsWatcher$1 requirementsWatcher$1) {
        this(requirementsWatcher);
    }

    private /* synthetic */ void a() {
        Object object = RequirementsWatcher.access$400(this.this$0);
        if (object != null) {
            object = this.this$0;
            RequirementsWatcher.access$200((RequirementsWatcher)object);
        }
    }

    private /* synthetic */ void c() {
        Object object = RequirementsWatcher.access$400(this.this$0);
        if (object != null) {
            object = this.this$0;
            RequirementsWatcher.access$500((RequirementsWatcher)object);
        }
    }

    private void postCheckRequirements() {
        Handler handler = RequirementsWatcher.access$300(this.this$0);
        a a10 = new a(this);
        handler.post((Runnable)a10);
    }

    private void postRecheckNotMetNetworkRequirements() {
        Handler handler = RequirementsWatcher.access$300(this.this$0);
        b b10 = new b(this);
        handler.post((Runnable)b10);
    }

    public /* synthetic */ void b() {
        this.a();
    }

    public /* synthetic */ void d() {
        this.c();
    }

    public void onAvailable(Network network) {
        this.postCheckRequirements();
    }

    public void onBlockedStatusChanged(Network network, boolean bl2) {
        if (!bl2) {
            this.postRecheckNotMetNetworkRequirements();
        }
    }

    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        boolean bl2 = networkCapabilities.hasCapability(16);
        boolean bl3 = this.receivedCapabilitiesChange;
        if (bl3 && (bl3 = this.networkValidated) == bl2) {
            if (bl2) {
                this.postRecheckNotMetNetworkRequirements();
            }
        } else {
            this.receivedCapabilitiesChange = bl3 = true;
            this.networkValidated = bl2;
            this.postCheckRequirements();
        }
    }

    public void onLost(Network network) {
        this.postCheckRequirements();
    }
}

