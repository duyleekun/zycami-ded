/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.car.CarInfoManager
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.IBinder
 */
package com.huawei.updatesdk.a.a.d.h;

import android.car.CarInfoManager;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.huawei.updatesdk.a.a.a;

public final class a$a
implements ServiceConnection {
    public void onServiceConnected(ComponentName object, IBinder object2) {
        object = "CarInfoUtil";
        object2 = com.huawei.updatesdk.a.a.d.h.a.a();
        CharSequence charSequence = "info";
        object2 = object2.getCarManager((String)charSequence);
        object2 = (CarInfoManager)object2;
        charSequence = object2.getManufacturer();
        com.huawei.updatesdk.a.a.d.h.a.a((String)charSequence);
        object2 = object2.getModel();
        com.huawei.updatesdk.a.a.d.h.a.b((String)object2);
        object2 = new StringBuilder();
        charSequence = "car getManufacturer = ";
        ((StringBuilder)object2).append((String)charSequence);
        charSequence = com.huawei.updatesdk.a.a.d.h.a.b();
        ((StringBuilder)object2).append((String)charSequence);
        charSequence = "  getModel = ";
        ((StringBuilder)object2).append((String)charSequence);
        charSequence = com.huawei.updatesdk.a.a.d.h.a.c();
        ((StringBuilder)object2).append((String)charSequence);
        object2 = ((StringBuilder)object2).toString();
        try {
            a.b((String)object, (String)object2);
        }
        catch (Throwable throwable) {
            charSequence = new StringBuilder();
            String string2 = "Car not connected in onServiceConnected";
            ((StringBuilder)charSequence).append(string2);
            String string3 = throwable.toString();
            ((StringBuilder)charSequence).append(string3);
            string3 = ((StringBuilder)charSequence).toString();
            a.a((String)object, string3);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        a.b("CarInfoUtil", "onServiceDisconnected");
    }
}

