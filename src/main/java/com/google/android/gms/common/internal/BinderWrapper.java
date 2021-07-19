/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zza;

public final class BinderWrapper
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private IBinder zza = null;

    static {
        zza zza2 = new zza();
        CREATOR = zza2;
    }

    public BinderWrapper() {
    }

    public BinderWrapper(IBinder iBinder) {
        this.zza = iBinder;
    }

    private BinderWrapper(Parcel parcel) {
        parcel = parcel.readStrongBinder();
        this.zza = parcel;
    }

    public /* synthetic */ BinderWrapper(Parcel parcel, zza zza2) {
        this(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        IBinder iBinder = this.zza;
        parcel.writeStrongBinder(iBinder);
    }
}

