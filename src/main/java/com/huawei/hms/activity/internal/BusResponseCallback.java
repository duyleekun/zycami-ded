/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 */
package com.huawei.hms.activity.internal;

import android.app.Activity;
import android.content.Intent;
import com.huawei.hms.activity.internal.BusResponseResult;

public interface BusResponseCallback {
    public BusResponseResult innerError(Activity var1, int var2, String var3);

    public BusResponseResult succeedReturn(Activity var1, int var2, Intent var3);
}

