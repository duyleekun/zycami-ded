/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.support.log;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;

public final class HMSDebugger {
    public static void init(Context context, int n10) {
        HMSLog.init(context, n10, "HMSSdk");
    }
}

