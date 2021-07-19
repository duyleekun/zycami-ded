/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 */
package com.xiaomi.push;

import android.os.IBinder;
import android.os.Parcel;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ap$b {
    public static String a(IBinder object) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        String string2 = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
        try {
            parcel.writeInterfaceToken(string2);
            int n10 = 1;
            object.transact(n10, parcel, parcel2, 0);
            parcel2.readException();
            object = parcel2.readString();
            return object;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public static boolean a(IBinder iBinder) {
        boolean bl2;
        Parcel parcel;
        Parcel parcel2;
        block3: {
            int n10;
            parcel2 = Parcel.obtain();
            parcel = Parcel.obtain();
            String string2 = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
            try {
                parcel2.writeInterfaceToken(string2);
                n10 = 2;
                bl2 = false;
            }
            catch (Throwable throwable) {
                parcel.recycle();
                parcel2.recycle();
                throw throwable;
            }
            iBinder.transact(n10, parcel2, parcel, 0);
            parcel.readException();
            int n11 = parcel.readInt();
            if (n11 == 0) break block3;
            bl2 = true;
        }
        parcel.recycle();
        parcel2.recycle();
        return bl2;
    }
}

