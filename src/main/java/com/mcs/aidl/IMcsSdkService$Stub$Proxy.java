/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 */
package com.mcs.aidl;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.mcs.aidl.IMcsSdkService;
import com.mcs.aidl.IMcsSdkService$Stub;

public class IMcsSdkService$Stub$Proxy
implements IMcsSdkService {
    public static IMcsSdkService sDefaultImpl;
    private IBinder mRemote;

    public IMcsSdkService$Stub$Proxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public String getInterfaceDescriptor() {
        return "com.mcs.aidl.IMcsSdkService";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void process(Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "com.mcs.aidl.IMcsSdkService";
        try {
            parcel.writeInterfaceToken((String)object);
            int n10 = 1;
            if (bundle != null) {
                parcel.writeInt(n10);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = this.mRemote;
            n10 = (int)(iBinder.transact(n10, parcel, parcel2, 0) ? 1 : 0);
            if (n10 == 0 && (object = IMcsSdkService$Stub.getDefaultImpl()) != null) {
                object = IMcsSdkService$Stub.getDefaultImpl();
                object.process(bundle);
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }
}

