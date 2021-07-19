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
package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.os.IResultReceiver;
import android.support.v4.os.IResultReceiver$Stub$Proxy;

public abstract class IResultReceiver$Stub
extends Binder
implements IResultReceiver {
    private static final String DESCRIPTOR = "android.support.v4.os.IResultReceiver";
    public static final int TRANSACTION_send = 1;

    public IResultReceiver$Stub() {
        this.attachInterface(this, DESCRIPTOR);
    }

    public static IResultReceiver asInterface(IBinder iBinder) {
        boolean bl2;
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (iInterface != null && (bl2 = iInterface instanceof IResultReceiver)) {
            return (IResultReceiver)iInterface;
        }
        iInterface = new IResultReceiver$Stub$Proxy(iBinder);
        return iInterface;
    }

    public static IResultReceiver getDefaultImpl() {
        return IResultReceiver$Stub$Proxy.sDefaultImpl;
    }

    public static boolean setDefaultImpl(IResultReceiver object) {
        IResultReceiver iResultReceiver = IResultReceiver$Stub$Proxy.sDefaultImpl;
        if (iResultReceiver == null) {
            if (object != null) {
                IResultReceiver$Stub$Proxy.sDefaultImpl = object;
                return true;
            }
            return false;
        }
        object = new IllegalStateException("setDefaultImpl() called twice");
        throw object;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int n10, Parcel parcel, Parcel parcel2, int n11) {
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
        int n14 = parcel.readInt();
        if (n14 != 0) {
            parcel2 = Bundle.CREATOR;
            parcel = (Bundle)parcel2.createFromParcel(parcel);
        } else {
            parcel = null;
        }
        this.send(n10, (Bundle)parcel);
        return n12;
    }
}

