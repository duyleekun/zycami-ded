/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package com.huawei.hms.adapter;

import android.content.Intent;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.AvailableAdapter$AvailableCallBack;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.support.log.HMSLog;

public class AvailableAdapter$a
implements SystemObserver {
    public final /* synthetic */ AvailableAdapter a;

    public AvailableAdapter$a(AvailableAdapter availableAdapter) {
        this.a = availableAdapter;
    }

    public boolean onSolutionResult(Intent intent, String string2) {
        return false;
    }

    public boolean onUpdateResult(int n10) {
        AvailableAdapter$AvailableCallBack availableAdapter$AvailableCallBack = AvailableAdapter.a(this.a);
        boolean bl2 = true;
        String string2 = "AvailableAdapter";
        if (availableAdapter$AvailableCallBack == null) {
            HMSLog.e(string2, "onUpdateResult baseCallBack null");
            return bl2;
        }
        availableAdapter$AvailableCallBack.onComplete(n10);
        AvailableAdapter.a(n10);
        CharSequence charSequence = new StringBuilder();
        charSequence.append("user response ");
        int n11 = AvailableAdapter.b();
        charSequence.append(n11);
        charSequence = charSequence.toString();
        HMSLog.i(string2, (String)charSequence);
        AvailableAdapter.c().set(false);
        return bl2;
    }
}

