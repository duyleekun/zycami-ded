/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 */
package i.f.d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import i.f.d.a;
import i.f.d.a$a$a;

public abstract class a$a
extends Binder
implements a {
    private static final String a = "org.opencv.engine.OpenCVEngineInterface";
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;

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

    public boolean onTransact(int n10, Parcel parcel, Parcel parcel2, int n11) {
        int n12 = 1;
        String string2 = a;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                n13 = 3;
                if (n10 != n13) {
                    n13 = 4;
                    if (n10 != n13) {
                        n13 = 1598968902;
                        if (n10 != n13) {
                            return super.onTransact(n10, parcel, parcel2, n11);
                        }
                        parcel2.writeString(string2);
                        return n12;
                    }
                    parcel.enforceInterface(string2);
                    String string3 = parcel.readString();
                    string3 = this.m(string3);
                    parcel2.writeNoException();
                    parcel2.writeString(string3);
                    return n12;
                }
                parcel.enforceInterface(string2);
                String string4 = parcel.readString();
                n10 = (int)(this.d(string4) ? 1 : 0);
                parcel2.writeNoException();
                parcel2.writeInt(n10);
                return n12;
            }
            parcel.enforceInterface(string2);
            String string5 = parcel.readString();
            string5 = this.g(string5);
            parcel2.writeNoException();
            parcel2.writeString(string5);
            return n12;
        }
        parcel.enforceInterface(string2);
        n10 = this.b();
        parcel2.writeNoException();
        parcel2.writeInt(n10);
        return n12;
    }
}

