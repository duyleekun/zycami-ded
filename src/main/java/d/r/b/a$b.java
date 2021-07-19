/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 */
package d.r.b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import d.r.b.a;
import d.r.b.a$b$a;

public abstract class a$b
extends Binder
implements a {
    private static final String a = "com.vivo.vms.IPCCallback";
    public static final int b = 1;

    public a$b() {
        this.attachInterface(this, a);
    }

    public static a o(IBinder iBinder) {
        boolean bl2;
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface(a);
        if (iInterface != null && (bl2 = iInterface instanceof a)) {
            return (a)iInterface;
        }
        iInterface = new a$b$a(iBinder);
        return iInterface;
    }

    public static a p() {
        return a$b$a.b;
    }

    public static boolean q(a a10) {
        a a11 = a$b$a.b;
        if (a11 == null && a10 != null) {
            a$b$a.b = a10;
            return true;
        }
        return false;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int n10, Parcel parcel, Parcel parcel2, int n11) {
        int n12 = 1;
        String string2 = a;
        if (n10 != n12) {
            int n13 = 1598968902;
            if (n10 != n13) {
                return super.onTransact(n10, parcel, parcel2, n11);
            }
            parcel2.writeString(string2);
            return n12;
        }
        parcel.enforceInterface(string2);
        Bundle bundle = new Bundle();
        this.l(bundle);
        parcel2.writeNoException();
        parcel2.writeInt(n12);
        bundle.writeToParcel(parcel2, n12);
        return n12;
    }
}

