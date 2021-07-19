/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 */
package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import com.huawei.hms.core.aidl.d;
import com.huawei.hms.core.aidl.d$a$a;

public abstract class d$a
extends Binder
implements d {
    public static d a() {
        return d$a$a.b;
    }

    public static d a(IBinder iBinder) {
        boolean bl2;
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.huawei.hms.core.aidl.IAIDLInvoke");
        if (iInterface != null && (bl2 = iInterface instanceof d)) {
            return (d)iInterface;
        }
        iInterface = new d$a$a(iBinder);
        return iInterface;
    }
}

