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
import d.j.e.a.a.b;

public class b$a$a
implements b {
    private IBinder a;

    public b$a$a(IBinder iBinder) {
        this.a = iBinder;
    }

    public void a(String string2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        String string3 = "com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature";
        try {
            parcel.writeInterfaceToken(string3);
            parcel.writeString(string2);
            string2 = this.a;
            int n10 = 5;
            string2.transact(n10, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }

    /*
     * WARNING - void declaration
     */
    public int e(boolean bl2) {
        IBinder iBinder;
        Parcel parcel;
        Parcel parcel2;
        block6: {
            parcel2 = Parcel.obtain();
            parcel = Parcel.obtain();
            String string2 = "com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature";
            parcel2.writeInterfaceToken(string2);
            string2 = null;
            if (bl2) {
                boolean bl3 = true;
                break block6;
            }
            boolean bl4 = false;
            iBinder = null;
        }
        try {
            void var1_4;
            parcel2.writeInt((int)var1_4);
            iBinder = this.a;
            int n10 = 2;
            iBinder.transact(n10, parcel2, parcel, 0);
            parcel.readException();
            int n11 = parcel.readInt();
            return n11;
        }
        finally {
            parcel.recycle();
            parcel2.recycle();
        }
    }

    public int f(String string2, int n10) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        String string3 = "com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature";
        parcel.writeInterfaceToken(string3);
        parcel.writeString(string2);
        parcel.writeInt(n10);
        string2 = this.a;
        n10 = 4;
        string3 = null;
        try {
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

    public int i() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        String string2 = "com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature";
        try {
            parcel.writeInterfaceToken(string2);
            string2 = this.a;
            int n10 = 3;
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

    public boolean j() {
        boolean bl2;
        Parcel parcel;
        Parcel parcel2;
        block3: {
            boolean bl3;
            parcel2 = Parcel.obtain();
            parcel = Parcel.obtain();
            String string2 = "com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature";
            try {
                parcel2.writeInterfaceToken(string2);
                string2 = this.a;
                bl2 = false;
                bl3 = true;
            }
            catch (Throwable throwable) {
                parcel.recycle();
                parcel2.recycle();
                throw throwable;
            }
            string2.transact((int)(bl3 ? 1 : 0), parcel2, parcel, 0);
            parcel.readException();
            int n10 = parcel.readInt();
            if (n10 == 0) break block3;
            bl2 = bl3;
        }
        parcel.recycle();
        parcel2.recycle();
        return bl2;
    }

    public String o() {
        return "com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature";
    }
}

