/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package com.zhiyun.common.viewmodel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.zhiyun.common.viewmodel.DeviceViewModel;
import e.a.l;

public class DeviceViewModel$f
extends BroadcastReceiver {
    public final /* synthetic */ l a;
    public final /* synthetic */ DeviceViewModel b;

    public DeviceViewModel$f(DeviceViewModel deviceViewModel, l l10) {
        this.b = deviceViewModel;
        this.a = l10;
    }

    public void onReceive(Context object, Intent object2) {
        int n10 = object2.getIntExtra("newRssi", -127);
        object2 = this.a;
        object = n10;
        object2.onNext(object);
    }
}

