/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 */
package com.huawei.hms.core.aidl;

import android.os.IBinder;
import android.os.Parcel;
import com.huawei.hms.core.aidl.b;
import com.huawei.hms.core.aidl.c;
import com.huawei.hms.core.aidl.d;
import com.huawei.hms.core.aidl.d$a;

public class d$a$a
implements d {
    public static d b;
    private IBinder a;

    public d$a$a(IBinder iBinder) {
        this.a = iBinder;
    }

    public void a(b b10, c c10) {
        Parcel parcel;
        block14: {
            IBinder iBinder;
            int n10;
            Object object;
            block13: {
                parcel = Parcel.obtain();
                object = "com.huawei.hms.core.aidl.IAIDLInvoke";
                parcel.writeInterfaceToken((String)object);
                n10 = 1;
                if (b10 == null) break block13;
                parcel.writeInt(n10);
                b10.writeToParcel(parcel, 0);
            }
            parcel.writeInt(0);
            if (c10 != null) {
                iBinder = c10.asBinder();
            }
            iBinder = null;
            parcel.writeStrongBinder(iBinder);
            iBinder = this.a;
            int n11 = 2;
            n10 = (int)(iBinder.transact(n11, parcel, null, n10) ? 1 : 0);
            if (n10 != 0) break block14;
            object = d$a.a();
            if (object == null) break block14;
            object = d$a.a();
            object.a(b10, c10);
            return;
        }
        parcel.recycle();
        return;
        finally {
            parcel.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }
}

