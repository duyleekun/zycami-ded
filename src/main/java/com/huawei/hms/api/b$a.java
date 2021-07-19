/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 */
package com.huawei.hms.api;

import android.app.Activity;
import android.content.Intent;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.BusResponseResult;
import com.huawei.hms.api.b;
import com.huawei.hms.common.api.AvailabilityException;
import com.huawei.hms.support.log.HMSLog;
import d.j.d.a.l;

public class b$a
implements BusResponseCallback {
    public final /* synthetic */ l[] a;

    public b$a(b b10, l[] lArray) {
        this.a = lArray;
    }

    public BusResponseResult innerError(Activity object, int n10, String string2) {
        object = new StringBuilder();
        ((StringBuilder)object).append("Test foreground bus error: resultCode ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(", errMessage");
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        HMSLog.e("HuaweiApiAvailabilityImpl", (String)object);
        object = this.a[0];
        AvailabilityException availabilityException = new AvailabilityException();
        ((l)object).c(availabilityException);
        return null;
    }

    public BusResponseResult succeedReturn(Activity object, int n10, Intent intent) {
        object = new StringBuilder();
        ((StringBuilder)object).append("Test foreground bus success: resultCode ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(", data");
        ((StringBuilder)object).append(intent);
        object = ((StringBuilder)object).toString();
        HMSLog.i("HuaweiApiAvailabilityImpl", (String)object);
        return null;
    }
}

