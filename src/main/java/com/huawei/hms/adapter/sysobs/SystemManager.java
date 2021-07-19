/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package com.huawei.hms.adapter.sysobs;

import android.content.Intent;
import com.huawei.hms.adapter.sysobs.SystemManager$a;
import com.huawei.hms.adapter.sysobs.SystemNotifier;

public final class SystemManager {
    public static SystemManager a;
    public static final Object b;
    public static SystemNotifier c;

    static {
        Object object = new SystemManager();
        a = object;
        b = object = new Object();
        c = object = new SystemManager$a();
    }

    public static /* synthetic */ Object a() {
        return b;
    }

    public static SystemManager getInstance() {
        return a;
    }

    public static SystemNotifier getSystemNotifier() {
        return c;
    }

    public void notifyResolutionResult(Intent intent, String string2) {
        c.notifyObservers(intent, string2);
    }

    public void notifyUpdateResult(int n10) {
        c.notifyObservers(n10);
    }
}

