/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 */
package i.f.d;

import android.os.IBinder;
import android.os.Parcel;
import i.f.d.a;

public class a$a$a
implements a {
    private IBinder a;

    public a$a$a(IBinder iBinder) {
        this.a = iBinder;
    }

    public IBinder asBinder() {
        return this.a;
    }

    public int b() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        String string2 = "org.opencv.engine.OpenCVEngineInterface";
        try {
            parcel.writeInterfaceToken(string2);
            string2 = this.a;
            int n10 = 1;
            string2.transact(n10, parcel, parcel2, 0);
            parcel2.readException();
            int n11 = parcel2.readInt();
            return n11;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public boolean d(String string2) {
        boolean bl2;
        Parcel parcel;
        Parcel parcel2;
        block4: {
            parcel2 = Parcel.obtain();
            parcel = Parcel.obtain();
            String string3 = "org.opencv.engine.OpenCVEngineInterface";
            try {
                parcel2.writeInterfaceToken(string3);
            }
            catch (Throwable throwable) {
                parcel.recycle();
                parcel2.recycle();
                throw throwable;
            }
            parcel2.writeString(string2);
            string2 = this.a;
            int n10 = 3;
            bl2 = false;
            string2.transact(n10, parcel2, parcel, 0);
            parcel.readException();
            int n11 = parcel.readInt();
            if (n11 == 0) break block4;
            bl2 = true;
        }
        parcel.recycle();
        parcel2.recycle();
        return bl2;
    }

    public String g(String string2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        String string3 = "org.opencv.engine.OpenCVEngineInterface";
        try {
            parcel.writeInterfaceToken(string3);
            parcel.writeString(string2);
            string2 = this.a;
            int n10 = 2;
            string2.transact(n10, parcel, parcel2, 0);
            parcel2.readException();
            string2 = parcel2.readString();
            return string2;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public String m(String string2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        String string3 = "org.opencv.engine.OpenCVEngineInterface";
        try {
            parcel.writeInterfaceToken(string3);
            parcel.writeString(string2);
            string2 = this.a;
            int n10 = 4;
            string2.transact(n10, parcel, parcel2, 0);
            parcel2.readException();
            string2 = parcel2.readString();
            return string2;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public String o() {
        return "org.opencv.engine.OpenCVEngineInterface";
    }
}

