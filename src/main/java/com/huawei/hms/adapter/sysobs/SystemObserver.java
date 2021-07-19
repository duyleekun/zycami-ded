/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package com.huawei.hms.adapter.sysobs;

import android.content.Intent;

public interface SystemObserver {
    public boolean onSolutionResult(Intent var1, String var2);

    public boolean onUpdateResult(int var1);
}

