/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 */
package com.mcs.aidl;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.mcs.aidl.IMcsSdkService;
import com.mcs.aidl.IMcsSdkService$Stub$Proxy;

public abstract class IMcsSdkService$Stub
extends Binder
implements IMcsSdkService {
    private static final String DESCRIPTOR = "com.mcs.aidl.IMcsSdkService";
    public static final int TRANSACTION_process = 1;

    public IMcsSdkService$Stub() {
        this.attachInterface(this, DESCRIPTOR);
    }

    public static IMcsSdkService asInterface(IBinder iBinder) {
        boolean bl2;
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (iInterface != null && (bl2 = iInterface instanceof IMcsSdkService)) {
            return (IMcsSdkService)iInterface;
        }
        iInterface = new IMcsSdkService$Stub$Proxy(iBinder);
        return iInterface;
    }

    public static IMcsSdkService getDefaultImpl() {
        return IMcsSdkService$Stub$Proxy.sDefaultImpl;
    }

    public static boolean setDefaultImpl(IMcsSdkService iMcsSdkService) {
        IMcsSdkService iMcsSdkService2 = IMcsSdkService$Stub$Proxy.sDefaultImpl;
        if (iMcsSdkService2 == null && iMcsSdkService != null) {
            IMcsSdkService$Stub$Proxy.sDefaultImpl = iMcsSdkService;
            return true;
        }
        return false;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int n10, Parcel parcel, Parcel parcel2, int n11) {
        Bundle bundle;
        int n12 = 1;
        String string2 = DESCRIPTOR;
        if (n10 != n12) {
            int n13 = 1598968902;
            if (n10 != n13) {
                return super.onTransact(n10, parcel, parcel2, n11);
            }
            parcel2.writeString(string2);
            return n12;
        }
        parcel.enforceInterface(string2);
        n10 = parcel.readInt();
        if (n10 != 0) {
            bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
        } else {
            n10 = 0;
            bundle = null;
        }
        this.process(bundle);
        parcel2.writeNoException();
        return n12;
    }
}

