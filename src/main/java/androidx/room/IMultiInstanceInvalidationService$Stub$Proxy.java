/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 */
package androidx.room;

import android.os.IBinder;
import android.os.Parcel;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.IMultiInstanceInvalidationService$Stub;

public class IMultiInstanceInvalidationService$Stub$Proxy
implements IMultiInstanceInvalidationService {
    public static IMultiInstanceInvalidationService sDefaultImpl;
    private IBinder mRemote;

    public IMultiInstanceInvalidationService$Stub$Proxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public void broadcastInvalidation(int n10, String[] stringArray) {
        Parcel parcel;
        block9: {
            parcel = Parcel.obtain();
            Object object = "androidx.room.IMultiInstanceInvalidationService";
            parcel.writeInterfaceToken((String)object);
            parcel.writeInt(n10);
            parcel.writeStringArray(stringArray);
            object = this.mRemote;
            int n11 = 3;
            int n12 = 1;
            boolean bl2 = object.transact(n11, parcel, null, n12);
            if (bl2) break block9;
            object = IMultiInstanceInvalidationService$Stub.getDefaultImpl();
            if (object == null) break block9;
            object = IMultiInstanceInvalidationService$Stub.getDefaultImpl();
            object.broadcastInvalidation(n10, stringArray);
            return;
        }
        parcel.recycle();
        return;
        finally {
            parcel.recycle();
        }
    }

    public String getInterfaceDescriptor() {
        return "androidx.room.IMultiInstanceInvalidationService";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int registerCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String string2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "androidx.room.IMultiInstanceInvalidationService";
        try {
            boolean bl2;
            parcel.writeInterfaceToken((String)object);
            if (iMultiInstanceInvalidationCallback != null) {
                object = iMultiInstanceInvalidationCallback.asBinder();
            } else {
                bl2 = false;
                object = null;
            }
            parcel.writeStrongBinder((IBinder)object);
            parcel.writeString(string2);
            object = this.mRemote;
            int n10 = 1;
            bl2 = object.transact(n10, parcel, parcel2, 0);
            if (!bl2 && (object = IMultiInstanceInvalidationService$Stub.getDefaultImpl()) != null) {
                object = IMultiInstanceInvalidationService$Stub.getDefaultImpl();
                int n11 = object.registerCallback(iMultiInstanceInvalidationCallback, string2);
                return n11;
            }
            parcel2.readException();
            int n12 = parcel2.readInt();
            return n12;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unregisterCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int n10) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "androidx.room.IMultiInstanceInvalidationService";
        try {
            boolean bl2;
            parcel.writeInterfaceToken((String)object);
            if (iMultiInstanceInvalidationCallback != null) {
                object = iMultiInstanceInvalidationCallback.asBinder();
            } else {
                bl2 = false;
                object = null;
            }
            parcel.writeStrongBinder((IBinder)object);
            parcel.writeInt(n10);
            object = this.mRemote;
            int n11 = 2;
            bl2 = object.transact(n11, parcel, parcel2, 0);
            if (!bl2 && (object = IMultiInstanceInvalidationService$Stub.getDefaultImpl()) != null) {
                object = IMultiInstanceInvalidationService$Stub.getDefaultImpl();
                object.unregisterCallback(iMultiInstanceInvalidationCallback, n10);
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

