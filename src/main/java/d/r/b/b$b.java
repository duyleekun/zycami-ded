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
import d.r.b.a$b;
import d.r.b.b;
import d.r.b.b$b$a;

public abstract class b$b
extends Binder
implements b {
    private static final String a = "com.vivo.vms.IPCInvoke";
    public static final int b = 1;

    public b$b() {
        this.attachInterface(this, a);
    }

    public static b o(IBinder iBinder) {
        boolean bl2;
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface(a);
        if (iInterface != null && (bl2 = iInterface instanceof b)) {
            return (b)iInterface;
        }
        iInterface = new b$b$a(iBinder);
        return iInterface;
    }

    public static b p() {
        return b$b$a.b;
    }

    public static boolean q(b b10) {
        b b11 = b$b$a.b;
        if (b11 == null && b10 != null) {
            b$b$a.b = b10;
            return true;
        }
        return false;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int n10, Parcel object, Parcel parcel, int n11) {
        Bundle bundle;
        int n12 = 1;
        String string2 = a;
        if (n10 != n12) {
            int n13 = 1598968902;
            if (n10 != n13) {
                return super.onTransact(n10, object, parcel, n11);
            }
            parcel.writeString(string2);
            return n12;
        }
        object.enforceInterface(string2);
        n10 = object.readInt();
        if (n10 != 0) {
            bundle = (Bundle)Bundle.CREATOR.createFromParcel(object);
        } else {
            n10 = 0;
            bundle = null;
        }
        object = a$b.o(object.readStrongBinder());
        bundle = this.k(bundle, (a)object);
        parcel.writeNoException();
        if (bundle != null) {
            parcel.writeInt(n12);
            bundle.writeToParcel(parcel, n12);
        } else {
            n10 = 0;
            bundle = null;
            parcel.writeInt(0);
        }
        return n12;
    }
}

