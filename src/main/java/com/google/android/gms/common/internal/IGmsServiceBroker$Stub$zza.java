/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 */
package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.IGmsCallbacks;
import com.google.android.gms.common.internal.IGmsServiceBroker;

public final class IGmsServiceBroker$Stub$zza
implements IGmsServiceBroker {
    private final IBinder zza;

    public IGmsServiceBroker$Stub$zza(IBinder iBinder) {
        this.zza = iBinder;
    }

    public final IBinder asBinder() {
        return this.zza;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void getService(IGmsCallbacks iGmsCallbacks, GetServiceRequest getServiceRequest) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        String string2 = "com.google.android.gms.common.internal.IGmsServiceBroker";
        try {
            int n10;
            parcel.writeInterfaceToken(string2);
            iGmsCallbacks = iGmsCallbacks != null ? iGmsCallbacks.asBinder() : null;
            parcel.writeStrongBinder((IBinder)iGmsCallbacks);
            iGmsCallbacks = null;
            if (getServiceRequest != null) {
                n10 = 1;
                parcel.writeInt(n10);
                getServiceRequest.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            getServiceRequest = this.zza;
            n10 = 46;
            getServiceRequest.transact(n10, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }
}

