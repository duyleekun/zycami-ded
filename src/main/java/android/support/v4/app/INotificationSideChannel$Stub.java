/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 */
package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.app.INotificationSideChannel;
import android.support.v4.app.INotificationSideChannel$Stub$Proxy;

public abstract class INotificationSideChannel$Stub
extends Binder
implements INotificationSideChannel {
    private static final String DESCRIPTOR = "android.support.v4.app.INotificationSideChannel";
    public static final int TRANSACTION_cancel = 2;
    public static final int TRANSACTION_cancelAll = 3;
    public static final int TRANSACTION_notify = 1;

    public INotificationSideChannel$Stub() {
        this.attachInterface(this, DESCRIPTOR);
    }

    public static INotificationSideChannel asInterface(IBinder iBinder) {
        boolean bl2;
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (iInterface != null && (bl2 = iInterface instanceof INotificationSideChannel)) {
            return (INotificationSideChannel)iInterface;
        }
        iInterface = new INotificationSideChannel$Stub$Proxy(iBinder);
        return iInterface;
    }

    public static INotificationSideChannel getDefaultImpl() {
        return INotificationSideChannel$Stub$Proxy.sDefaultImpl;
    }

    public static boolean setDefaultImpl(INotificationSideChannel object) {
        INotificationSideChannel iNotificationSideChannel = INotificationSideChannel$Stub$Proxy.sDefaultImpl;
        if (iNotificationSideChannel == null) {
            if (object != null) {
                INotificationSideChannel$Stub$Proxy.sDefaultImpl = object;
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

    public boolean onTransact(int n10, Parcel object, Parcel parcel, int n11) {
        int n12 = 1;
        String string2 = DESCRIPTOR;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                n13 = 3;
                if (n10 != n13) {
                    n13 = 1598968902;
                    if (n10 != n13) {
                        return super.onTransact(n10, object, parcel, n11);
                    }
                    parcel.writeString(string2);
                    return n12;
                }
                object.enforceInterface(string2);
                String string3 = object.readString();
                this.cancelAll(string3);
                return n12;
            }
            object.enforceInterface(string2);
            String string4 = object.readString();
            int n14 = object.readInt();
            object = object.readString();
            this.cancel(string4, n14, (String)object);
            return n12;
        }
        object.enforceInterface(string2);
        String string5 = object.readString();
        int n15 = object.readInt();
        String string6 = object.readString();
        int n16 = object.readInt();
        if (n16 != 0) {
            string2 = Notification.CREATOR;
            object = (Notification)string2.createFromParcel(object);
        } else {
            object = null;
        }
        this.notify(string5, n15, string6, (Notification)object);
        return n12;
    }
}

