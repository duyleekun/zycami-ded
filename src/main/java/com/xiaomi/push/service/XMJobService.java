/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.Intent
 *  android.os.Binder
 *  android.os.Build$VERSION
 *  android.os.IBinder
 */
package com.xiaomi.push.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import com.xiaomi.push.service.XMJobService$a;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class XMJobService
extends Service {
    public static Service a;
    private IBinder a = null;

    public static Service a() {
        return a;
    }

    public IBinder onBind(Intent intent) {
        intent = this.a;
        if (intent != null) {
            return intent;
        }
        intent = new Binder();
        return intent;
    }

    public void onCreate() {
        super.onCreate();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            XMJobService$a xMJobService$a = new XMJobService$a(this);
            xMJobService$a = xMJobService$a.a;
            this.a = xMJobService$a;
        }
        a = this;
    }

    public void onDestroy() {
        super.onDestroy();
        a = null;
    }
}

