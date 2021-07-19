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
import androidx.room.IMultiInstanceInvalidationCallback$Stub$Proxy;

public abstract class IMultiInstanceInvalidationCallback$Stub
extends Binder
implements IMultiInstanceInvalidationCallback {
    private static final String DESCRIPTOR = "androidx.room.IMultiInstanceInvalidationCallback";
    public static final int TRANSACTION_onInvalidation = 1;

    public IMultiInstanceInvalidationCallback$Stub() {
        this.attachInterface(this, DESCRIPTOR);
    }

    public static IMultiInstanceInvalidationCallback asInterface(IBinder iBinder) {
        boolean bl2;
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (iInterface != null && (bl2 = iInterface instanceof IMultiInstanceInvalidationCallback)) {
            return (IMultiInstanceInvalidationCallback)iInterface;
        }
        iInterface = new IMultiInstanceInvalidationCallback$Stub$Proxy(iBinder);
        return iInterface;
    }

    public static IMultiInstanceInvalidationCallback getDefaultImpl() {
        return IMultiInstanceInvalidationCallback$Stub$Proxy.sDefaultImpl;
    }

    public static boolean setDefaultImpl(IMultiInstanceInvalidationCallback object) {
        IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback = IMultiInstanceInvalidationCallback$Stub$Proxy.sDefaultImpl;
        if (iMultiInstanceInvalidationCallback == null) {
            if (object != null) {
                IMultiInstanceInvalidationCallback$Stub$Proxy.sDefaultImpl = object;
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
        String[] stringArray = parcel.createStringArray();
        this.onInvalidation(stringArray);
        return n12;
    }
}

