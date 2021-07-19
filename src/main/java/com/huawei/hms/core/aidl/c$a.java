/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 */
package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.core.aidl.b;
import com.huawei.hms.core.aidl.c;
import com.huawei.hms.core.aidl.c$a$a;

public abstract class c$a
extends Binder
implements c {
    public c$a() {
        this.attachInterface(this, "com.huawei.hms.core.aidl.IAIDLCallback");
    }

    public static c asInterface(IBinder iBinder) {
        boolean bl2;
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.huawei.hms.core.aidl.IAIDLCallback");
        if (iInterface != null && (bl2 = iInterface instanceof c)) {
            return (c)iInterface;
        }
        iInterface = new c$a$a(iBinder);
        return iInterface;
    }

    public static c getDefaultImpl() {
        return c$a$a.b;
    }

    public static boolean setDefaultImpl(c c10) {
        c c11 = c$a$a.b;
        if (c11 == null && c10 != null) {
            c$a$a.b = c10;
            return true;
        }
        return false;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int n10, Parcel parcel, Parcel parcel2, int n11) {
        b b10;
        int n12 = 1;
        String string2 = "com.huawei.hms.core.aidl.IAIDLCallback";
        if (n10 != n12) {
            int n13 = 1598968902;
            if (n10 != n13) {
                return super.onTransact(n10, parcel, parcel2, n11);
            }
            parcel2.writeString(string2);
            return n12;
        }
        parcel.enforceInterface(string2);
        n10 = parcel.readInt();
        if (n10 != 0) {
            b10 = (b)b.CREATOR.createFromParcel(parcel);
        } else {
            n10 = 0;
            b10 = null;
        }
        this.call(b10);
        return n12;
    }
}

