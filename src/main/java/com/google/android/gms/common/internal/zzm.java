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
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper$Stub;
import com.google.android.gms.internal.common.zzb;

public final class zzm
extends zzb
implements zzl {
    public zzm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    public final IObjectWrapper zzb() {
        Parcel parcel = this.a_();
        parcel = this.zza(1, parcel);
        IObjectWrapper iObjectWrapper = IObjectWrapper$Stub.asInterface(parcel.readStrongBinder());
        parcel.recycle();
        return iObjectWrapper;
    }

    public final int zzc() {
        Parcel parcel = this.a_();
        parcel = this.zza(2, parcel);
        int n10 = parcel.readInt();
        parcel.recycle();
        return n10;
    }
}

