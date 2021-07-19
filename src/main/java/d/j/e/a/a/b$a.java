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
import d.j.e.a.a.b;
import d.j.e.a.a.b$a$a;

public abstract class b$a
extends Binder
implements b {
    private static final String a = "com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature";
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;

    public b$a() {
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
        iInterface = new b$a$a(iBinder);
        return iInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int n10, Parcel parcel, Parcel parcel2, int n11) {
        String string2 = a;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                n13 = 3;
                if (n10 != n13) {
                    n13 = 4;
                    if (n10 != n13) {
                        n13 = 5;
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
                        this.a(string3);
                        parcel2.writeNoException();
                        return n12;
                    }
                    parcel.enforceInterface(string2);
                    String string4 = parcel.readString();
                    int n14 = parcel.readInt();
                    n10 = this.f(string4, n14);
                    parcel2.writeNoException();
                    parcel2.writeInt(n10);
                    return n12;
                }
                parcel.enforceInterface(string2);
                n10 = this.i();
                parcel2.writeNoException();
                parcel2.writeInt(n10);
                return n12;
            }
            parcel.enforceInterface(string2);
            n10 = parcel.readInt();
            if (n10 != 0) {
                n10 = n12;
            } else {
                n10 = 0;
                Object var8_10 = null;
            }
            n10 = this.e(n10 != 0);
            parcel2.writeNoException();
            parcel2.writeInt(n10);
            return n12;
        }
        parcel.enforceInterface(string2);
        n10 = (int)(this.j() ? 1 : 0);
        parcel2.writeNoException();
        parcel2.writeInt(n10);
        return n12;
    }
}

