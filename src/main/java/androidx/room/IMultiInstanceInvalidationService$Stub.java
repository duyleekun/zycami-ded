/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 */
package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationCallback$Stub;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.IMultiInstanceInvalidationService$Stub$Proxy;

public abstract class IMultiInstanceInvalidationService$Stub
extends Binder
implements IMultiInstanceInvalidationService {
    private static final String DESCRIPTOR = "androidx.room.IMultiInstanceInvalidationService";
    public static final int TRANSACTION_broadcastInvalidation = 3;
    public static final int TRANSACTION_registerCallback = 1;
    public static final int TRANSACTION_unregisterCallback = 2;

    public IMultiInstanceInvalidationService$Stub() {
        this.attachInterface(this, DESCRIPTOR);
    }

    public static IMultiInstanceInvalidationService asInterface(IBinder iBinder) {
        boolean bl2;
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (iInterface != null && (bl2 = iInterface instanceof IMultiInstanceInvalidationService)) {
            return (IMultiInstanceInvalidationService)iInterface;
        }
        iInterface = new IMultiInstanceInvalidationService$Stub$Proxy(iBinder);
        return iInterface;
    }

    public static IMultiInstanceInvalidationService getDefaultImpl() {
        return IMultiInstanceInvalidationService$Stub$Proxy.sDefaultImpl;
    }

    public static boolean setDefaultImpl(IMultiInstanceInvalidationService object) {
        IMultiInstanceInvalidationService iMultiInstanceInvalidationService = IMultiInstanceInvalidationService$Stub$Proxy.sDefaultImpl;
        if (iMultiInstanceInvalidationService == null) {
            if (object != null) {
                IMultiInstanceInvalidationService$Stub$Proxy.sDefaultImpl = object;
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

    public boolean onTransact(int n10, Parcel stringArray, Parcel parcel, int n11) {
        int n12 = 1;
        String string2 = DESCRIPTOR;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                n13 = 3;
                if (n10 != n13) {
                    n13 = 1598968902;
                    if (n10 != n13) {
                        return super.onTransact(n10, (Parcel)stringArray, parcel, n11);
                    }
                    parcel.writeString(string2);
                    return n12;
                }
                stringArray.enforceInterface(string2);
                n10 = stringArray.readInt();
                stringArray = stringArray.createStringArray();
                this.broadcastInvalidation(n10, stringArray);
                return n12;
            }
            stringArray.enforceInterface(string2);
            IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback = IMultiInstanceInvalidationCallback$Stub.asInterface(stringArray.readStrongBinder());
            int n14 = stringArray.readInt();
            this.unregisterCallback(iMultiInstanceInvalidationCallback, n14);
            parcel.writeNoException();
            return n12;
        }
        stringArray.enforceInterface(string2);
        IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback = IMultiInstanceInvalidationCallback$Stub.asInterface(stringArray.readStrongBinder());
        stringArray = stringArray.readString();
        n10 = this.registerCallback(iMultiInstanceInvalidationCallback, (String)stringArray);
        parcel.writeNoException();
        parcel.writeInt(n10);
        return n12;
    }
}

