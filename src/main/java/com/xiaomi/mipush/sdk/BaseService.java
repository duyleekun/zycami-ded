/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.Intent
 *  android.os.IBinder
 */
package com.xiaomi.mipush.sdk;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.xiaomi.mipush.sdk.BaseService$a;
import java.lang.ref.WeakReference;

public abstract class BaseService
extends Service {
    private BaseService$a a;

    public abstract boolean a();

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onStart(Intent object, int n10) {
        super.onStart(object, n10);
        object = this.a;
        if (object == null) {
            WeakReference<BaseService> weakReference = new WeakReference<BaseService>(this);
            object = new BaseService$a(weakReference);
            this.a = object;
        }
        this.a.a();
    }
}

