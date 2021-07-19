/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 */
package d.j.e.a.a;

import android.os.IBinder;
import android.os.Parcel;
import d.j.e.a.a.a;
import java.util.List;

public class a$a$a
implements a {
    private IBinder a;

    public a$a$a(IBinder iBinder) {
        this.a = iBinder;
    }

    public IBinder asBinder() {
        return this.a;
    }

    public void c(String string2, String string3) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        String string4 = "com.huawei.multimedia.audioengine.IHwAudioEngine";
        parcel.writeInterfaceToken(string4);
        parcel.writeString(string2);
        parcel.writeString(string3);
        string2 = this.a;
        int n10 = 3;
        string4 = null;
        try {
            string2.transact(n10, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public List h() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "com.huawei.multimedia.audioengine.IHwAudioEngine";
        try {
            parcel.writeInterfaceToken((String)object);
            object = this.a;
            int n10 = 1;
            object.transact(n10, parcel, parcel2, 0);
            parcel2.readException();
            object = this.getClass();
            object = ((Class)object).getClassLoader();
            object = parcel2.readArrayList((ClassLoader)object);
            return object;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public boolean n(int n10) {
        boolean bl2;
        Parcel parcel;
        Parcel parcel2;
        block4: {
            parcel2 = Parcel.obtain();
            parcel = Parcel.obtain();
            String string2 = "com.huawei.multimedia.audioengine.IHwAudioEngine";
            try {
                parcel2.writeInterfaceToken(string2);
            }
            catch (Throwable throwable) {
                parcel.recycle();
                parcel2.recycle();
                throw throwable;
            }
            parcel2.writeInt(n10);
            IBinder iBinder = this.a;
            int n11 = 2;
            bl2 = false;
            iBinder.transact(n11, parcel2, parcel, 0);
            parcel.readException();
            n10 = parcel.readInt();
            if (n10 == 0) break block4;
            bl2 = true;
        }
        parcel.recycle();
        parcel2.recycle();
        return bl2;
    }

    public String o() {
        return "com.huawei.multimedia.audioengine.IHwAudioEngine";
    }
}

