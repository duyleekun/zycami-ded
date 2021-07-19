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
import d.r.b.b;
import d.r.b.b$b;

public class b$b$a
implements b {
    public static b b;
    private IBinder a;

    public b$b$a(IBinder iBinder) {
        this.a = iBinder;
    }

    public IBinder asBinder() {
        return this.a;
    }

    public Bundle k(Bundle object, a a10) {
        Object object2;
        Parcel parcel;
        Parcel parcel2;
        block19: {
            block18: {
                IBinder iBinder;
                int n10;
                Object object3;
                block17: {
                    parcel2 = Parcel.obtain();
                    parcel = Parcel.obtain();
                    object3 = "com.vivo.vms.IPCInvoke";
                    parcel2.writeInterfaceToken((String)object3);
                    n10 = 1;
                    if (object == null) break block17;
                    parcel2.writeInt(n10);
                    object.writeToParcel(parcel2, 0);
                }
                parcel2.writeInt(0);
                object2 = null;
                if (a10 != null) {
                    iBinder = a10.asBinder();
                }
                iBinder = null;
                parcel2.writeStrongBinder(iBinder);
                iBinder = this.a;
                n10 = (int)(iBinder.transact(n10, parcel2, parcel, 0) ? 1 : 0);
                if (n10 != 0) break block18;
                object3 = b$b.p();
                if (object3 == null) break block18;
                object3 = b$b.p();
                object = object3.k((Bundle)object, a10);
                return object;
            }
            parcel.readException();
            int n11 = parcel.readInt();
            if (n11 == 0) break block19;
            object = Bundle.CREATOR;
            object2 = object = object.createFromParcel(parcel);
            object2 = object;
        }
        parcel.recycle();
        parcel2.recycle();
        return object2;
        finally {
            parcel.recycle();
            parcel2.recycle();
        }
    }

    public String o() {
        return "com.vivo.vms.IPCInvoke";
    }
}

