/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 */
package d.j.e.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import d.j.e.a.a.a;
import d.j.e.a.a.a$a$a;
import java.util.List;

public abstract class a$a
extends Binder
implements a {
    private static final String a = "com.huawei.multimedia.audioengine.IHwAudioEngine";
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;

    public a$a() {
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
        iInterface = new a$a$a(iBinder);
        return iInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int n10, Parcel object, Parcel parcel, int n11) {
        String string2 = a;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                n13 = 3;
                if (n10 != n13) {
                    n13 = 1598968902;
                    if (n10 != n13) {
                        return super.onTransact(n10, object, parcel, n11);
                    }
                    parcel.writeString(string2);
                    return n12;
                }
                object.enforceInterface(string2);
                String string3 = object.readString();
                object = object.readString();
                this.c(string3, (String)object);
                parcel.writeNoException();
                return n12;
            }
            object.enforceInterface(string2);
            n10 = object.readInt();
            n10 = (int)(this.n(n10) ? 1 : 0);
            parcel.writeNoException();
            parcel.writeInt(n10);
            return n12;
        }
        object.enforceInterface(string2);
        List list = this.h();
        parcel.writeNoException();
        parcel.writeList(list);
        return n12;
    }
}

