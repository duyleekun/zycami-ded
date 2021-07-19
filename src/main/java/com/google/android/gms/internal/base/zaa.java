/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 */
package com.google.android.gms.internal.base;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class zaa
implements IInterface {
    private final IBinder zaa;
    private final String zab;

    public zaa(IBinder iBinder, String string2) {
        this.zaa = iBinder;
        this.zab = string2;
    }

    public IBinder asBinder() {
        return this.zaa;
    }

    public final Parcel zaa() {
        Parcel parcel = Parcel.obtain();
        String string2 = this.zab;
        parcel.writeInterfaceToken(string2);
        return parcel;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Parcel zaa(int n10, Parcel parcel) {
        Throwable throwable2222222;
        block4: {
            Parcel parcel2 = Parcel.obtain();
            IBinder iBinder = this.zaa;
            iBinder.transact(n10, parcel, parcel2, 0);
            parcel2.readException();
            {
                catch (Throwable throwable2222222) {
                    break block4;
                }
                catch (RuntimeException runtimeException) {}
                {
                    parcel2.recycle();
                    throw runtimeException;
                }
            }
            parcel.recycle();
            return parcel2;
        }
        parcel.recycle();
        throw throwable2222222;
    }

    public final void zab(int n10, Parcel parcel) {
        Parcel parcel2 = Parcel.obtain();
        try {
            IBinder iBinder = this.zaa;
            iBinder.transact(n10, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel.recycle();
            parcel2.recycle();
        }
    }

    public final void zac(int n10, Parcel parcel) {
        try {
            IBinder iBinder = this.zaa;
            int n11 = 1;
            iBinder.transact(n11, parcel, null, n11);
            return;
        }
        finally {
            parcel.recycle();
        }
    }
}

