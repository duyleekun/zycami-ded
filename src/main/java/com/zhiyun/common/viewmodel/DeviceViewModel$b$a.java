/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.zhiyun.common.viewmodel;

import android.content.Context;
import com.zhiyun.common.viewmodel.DeviceViewModel$b;
import com.zhiyun.common.viewmodel.DeviceViewModel$g;
import e.a.l;

public class DeviceViewModel$b$a
extends DeviceViewModel$g {
    public final /* synthetic */ l b;
    public final /* synthetic */ DeviceViewModel.b c;

    public DeviceViewModel$b$a(DeviceViewModel.b b10, Context context, l l10) {
        this.c = b10;
        this.b = l10;
        super(context);
    }

    public void a(int n10) {
        l l10 = this.b;
        Integer n11 = n10;
        l10.onNext(n11);
    }
}

