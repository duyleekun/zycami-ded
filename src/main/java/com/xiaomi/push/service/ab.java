/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.NotificationManager
 */
package com.xiaomi.push.service;

import android.app.NotificationManager;
import com.xiaomi.push.ai$a;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ab
extends ai$a {
    public final /* synthetic */ int a;
    public final /* synthetic */ NotificationManager a;

    public ab(int n10, NotificationManager notificationManager) {
        this.a = n10;
        this.a = notificationManager;
    }

    public int a() {
        return this.a;
    }

    public void run() {
        NotificationManager notificationManager = this.a;
        int n10 = this.a;
        notificationManager.cancel(n10);
    }
}

