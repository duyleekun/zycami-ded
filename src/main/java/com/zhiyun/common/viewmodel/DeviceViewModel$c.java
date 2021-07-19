/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.IntentFilter
 */
package com.zhiyun.common.viewmodel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.zhiyun.common.viewmodel.DeviceViewModel;
import com.zhiyun.common.viewmodel.DeviceViewModel$c$a;
import d.v.e.m.d;
import e.a.l;
import e.a.m;

public class DeviceViewModel$c
implements m {
    public final /* synthetic */ Context a;
    public final /* synthetic */ DeviceViewModel b;

    public DeviceViewModel$c(DeviceViewModel deviceViewModel, Context context) {
        this.b = deviceViewModel;
        this.a = context;
    }

    public static /* synthetic */ void a(Context context, BroadcastReceiver broadcastReceiver) {
        context.unregisterReceiver(broadcastReceiver);
    }

    public void subscribe(l l10) {
        DeviceViewModel$c$a deviceViewModel$c$a = new DeviceViewModel$c$a(this, l10);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        this.a.registerReceiver((BroadcastReceiver)deviceViewModel$c$a, intentFilter);
        intentFilter = this.a;
        d d10 = new d((Context)intentFilter, deviceViewModel$c$a);
        l10.setCancellable(d10);
    }
}

