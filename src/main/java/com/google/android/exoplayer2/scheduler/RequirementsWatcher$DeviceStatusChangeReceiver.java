/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package com.google.android.exoplayer2.scheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.exoplayer2.scheduler.RequirementsWatcher;
import com.google.android.exoplayer2.scheduler.RequirementsWatcher$1;

public class RequirementsWatcher$DeviceStatusChangeReceiver
extends BroadcastReceiver {
    public final /* synthetic */ RequirementsWatcher this$0;

    private RequirementsWatcher$DeviceStatusChangeReceiver(RequirementsWatcher requirementsWatcher) {
        this.this$0 = requirementsWatcher;
    }

    public /* synthetic */ RequirementsWatcher$DeviceStatusChangeReceiver(RequirementsWatcher requirementsWatcher, RequirementsWatcher$1 requirementsWatcher$1) {
        this(requirementsWatcher);
    }

    public void onReceive(Context object, Intent intent) {
        boolean bl2 = this.isInitialStickyBroadcast();
        if (!bl2) {
            object = this.this$0;
            RequirementsWatcher.access$200((RequirementsWatcher)object);
        }
    }
}

