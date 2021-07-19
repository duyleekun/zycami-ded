/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.zhiyun.common.viewmodel;

import android.content.Context;
import com.zhiyun.common.viewmodel.DeviceViewModel;
import com.zhiyun.common.viewmodel.DeviceViewModel$b$a;
import d.v.e.m.a;
import e.a.l;
import e.a.m;
import e.a.v0.f;

public class DeviceViewModel$b
implements m {
    public final /* synthetic */ Context a;
    public final /* synthetic */ DeviceViewModel b;

    public DeviceViewModel$b(DeviceViewModel deviceViewModel, Context context) {
        this.b = deviceViewModel;
        this.a = context;
    }

    public void subscribe(l l10) {
        Object object = this.a;
        DeviceViewModel$b$a deviceViewModel$b$a = new DeviceViewModel$b$a(this, (Context)object, l10);
        deviceViewModel$b$a.enable();
        object = new a(deviceViewModel$b$a);
        l10.setCancellable((f)object);
    }
}

