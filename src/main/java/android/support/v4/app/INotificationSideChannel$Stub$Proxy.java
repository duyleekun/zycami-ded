/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.os.IBinder
 *  android.os.Parcel
 */
package android.support.v4.app;

import android.app.Notification;
import android.os.IBinder;
import android.os.Parcel;
import android.support.v4.app.INotificationSideChannel;
import android.support.v4.app.INotificationSideChannel$Stub;

public class INotificationSideChannel$Stub$Proxy
implements INotificationSideChannel {
    public static INotificationSideChannel sDefaultImpl;
    private IBinder mRemote;

    public INotificationSideChannel$Stub$Proxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public void cancel(String string2, int n10, String string3) {
        Parcel parcel;
        block10: {
            parcel = Parcel.obtain();
            Object object = "android.support.v4.app.INotificationSideChannel";
            parcel.writeInterfaceToken((String)object);
            parcel.writeString(string2);
            parcel.writeInt(n10);
            parcel.writeString(string3);
            object = this.mRemote;
            int n11 = 2;
            int n12 = 1;
            boolean bl2 = object.transact(n11, parcel, null, n12);
            if (bl2) break block10;
            object = INotificationSideChannel$Stub.getDefaultImpl();
            if (object == null) break block10;
            object = INotificationSideChannel$Stub.getDefaultImpl();
            object.cancel(string2, n10, string3);
            return;
        }
        parcel.recycle();
        return;
        finally {
            parcel.recycle();
        }
    }

    public void cancelAll(String string2) {
        Parcel parcel;
        block8: {
            parcel = Parcel.obtain();
            Object object = "android.support.v4.app.INotificationSideChannel";
            parcel.writeInterfaceToken((String)object);
            parcel.writeString(string2);
            object = this.mRemote;
            int n10 = 3;
            int n11 = 1;
            boolean bl2 = object.transact(n10, parcel, null, n11);
            if (bl2) break block8;
            object = INotificationSideChannel$Stub.getDefaultImpl();
            if (object == null) break block8;
            object = INotificationSideChannel$Stub.getDefaultImpl();
            object.cancelAll(string2);
            return;
        }
        parcel.recycle();
        return;
        finally {
            parcel.recycle();
        }
    }

    public String getInterfaceDescriptor() {
        return "android.support.v4.app.INotificationSideChannel";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void notify(String string2, int n10, String string3, Notification notification) {
        Parcel parcel = Parcel.obtain();
        Object object = "android.support.v4.app.INotificationSideChannel";
        try {
            parcel.writeInterfaceToken((String)object);
            parcel.writeString(string2);
            parcel.writeInt(n10);
            parcel.writeString(string3);
            boolean bl2 = false;
            object = null;
            int n11 = 1;
            if (notification != null) {
                parcel.writeInt(n11);
                notification.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            object = this.mRemote;
            bl2 = object.transact(n11, parcel, null, n11);
            if (bl2) return;
            object = INotificationSideChannel$Stub.getDefaultImpl();
            if (object == null) return;
            object = INotificationSideChannel$Stub.getDefaultImpl();
            object.notify(string2, n10, string3, notification);
            return;
        }
        finally {
            parcel.recycle();
        }
    }
}

