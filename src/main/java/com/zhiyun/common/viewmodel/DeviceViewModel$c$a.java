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
import androidx.core.util.Pair;
import com.zhiyun.common.viewmodel.DeviceViewModel$c;
import e.a.l;

public class DeviceViewModel$c$a
extends BroadcastReceiver {
    public final /* synthetic */ l a;
    public final /* synthetic */ DeviceViewModel.c b;

    public DeviceViewModel$c$a(DeviceViewModel.c c10, l l10) {
        this.b = c10;
        this.a = l10;
    }

    /*
     * WARNING - void declaration
     */
    public void onReceive(Context object, Intent object2) {
        void var8_12;
        object = "level";
        int bl2 = -1;
        int n10 = object2.getIntExtra((String)object, bl2);
        String string2 = "scale";
        int n11 = object2.getIntExtra(string2, bl2);
        String string3 = "status";
        int n12 = object2.getIntExtra(string3, bl2);
        float f10 = n10 * 100;
        float f11 = n11;
        n10 = (int)(f10 /= f11);
        int n13 = 2;
        f11 = 2.8E-45f;
        if (n12 == n13) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            object2 = null;
        }
        l l10 = this.a;
        object2 = (boolean)var8_12;
        object = n10;
        object = Pair.create(object2, object);
        l10.onNext(object);
    }
}

