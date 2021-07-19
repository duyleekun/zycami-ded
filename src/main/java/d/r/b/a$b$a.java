/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 */
package d.r.b;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import d.r.b.a;
import d.r.b.a$b;

public class a$b$a
implements a {
    public static a b;
    private IBinder a;

    public a$b$a(IBinder iBinder) {
        this.a = iBinder;
    }

    public IBinder asBinder() {
        return this.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void l(Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "com.vivo.vms.IPCCallback";
        try {
            parcel.writeInterfaceToken((String)object);
            object = this.a;
            int n10 = 1;
            int n11 = object.transact(n10, parcel, parcel2, 0);
            if (n11 == 0 && (object = a$b.p()) != null) {
                object = a$b.p();
                object.l(bundle);
                return;
            }
            parcel2.readException();
            n11 = parcel2.readInt();
            if (n11 == 0) return;
            bundle.readFromParcel(parcel2);
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public String o() {
        return "com.vivo.vms.IPCCallback";
    }
}

