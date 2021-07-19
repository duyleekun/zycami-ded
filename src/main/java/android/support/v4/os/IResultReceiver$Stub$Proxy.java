/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 */
package android.support.v4.os;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.support.v4.os.IResultReceiver;
import android.support.v4.os.IResultReceiver$Stub;

public class IResultReceiver$Stub$Proxy
implements IResultReceiver {
    public static IResultReceiver sDefaultImpl;
    private IBinder mRemote;

    public IResultReceiver$Stub$Proxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public String getInterfaceDescriptor() {
        return "android.support.v4.os.IResultReceiver";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void send(int n10, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Object object = "android.support.v4.os.IResultReceiver";
        try {
            parcel.writeInterfaceToken((String)object);
            parcel.writeInt(n10);
            boolean bl2 = false;
            object = null;
            int n11 = 1;
            if (bundle != null) {
                parcel.writeInt(n11);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            object = this.mRemote;
            bl2 = object.transact(n11, parcel, null, n11);
            if (bl2) return;
            object = IResultReceiver$Stub.getDefaultImpl();
            if (object == null) return;
            object = IResultReceiver$Stub.getDefaultImpl();
            object.send(n10, bundle);
            return;
        }
        finally {
            parcel.recycle();
        }
    }
}

