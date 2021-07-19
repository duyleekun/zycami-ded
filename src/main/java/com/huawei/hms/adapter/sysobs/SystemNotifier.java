/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package com.huawei.hms.adapter.sysobs;

import android.content.Intent;
import com.huawei.hms.adapter.sysobs.SystemObserver;

public interface SystemNotifier {
    public void notifyObservers(int var1);

    public void notifyObservers(Intent var1, String var2);

    public void registerObserver(SystemObserver var1);

    public void unRegisterObserver(SystemObserver var1);
}

