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
import androidx.room.IMultiInstanceInvalidationCallback$Stub;

public class IMultiInstanceInvalidationCallback$Stub$Proxy
implements IMultiInstanceInvalidationCallback {
    public static IMultiInstanceInvalidationCallback sDefaultImpl;
    private IBinder mRemote;

    public IMultiInstanceInvalidationCallback$Stub$Proxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public String getInterfaceDescriptor() {
        return "androidx.room.IMultiInstanceInvalidationCallback";
    }

    public void onInvalidation(String[] stringArray) {
        Parcel parcel;
        block8: {
            parcel = Parcel.obtain();
            Object object = "androidx.room.IMultiInstanceInvalidationCallback";
            parcel.writeInterfaceToken((String)object);
            parcel.writeStringArray(stringArray);
            object = this.mRemote;
            int n10 = 1;
            boolean bl2 = object.transact(n10, parcel, null, n10);
            if (bl2) break block8;
            object = IMultiInstanceInvalidationCallback$Stub.getDefaultImpl();
            if (object == null) break block8;
            object = IMultiInstanceInvalidationCallback$Stub.getDefaultImpl();
            object.onInvalidation(stringArray);
            return;
        }
        parcel.recycle();
        return;
        finally {
            parcel.recycle();
        }
    }
}

