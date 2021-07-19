/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 */
package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper$Stub;
import com.google.android.gms.dynamite.zzk;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzd;

public final class zzj
extends zzb
implements zzk {
    public zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final int zza(IObjectWrapper iObjectWrapper, String string2, boolean bl2) {
        Parcel parcel = this.a_();
        zzd.zza(parcel, iObjectWrapper);
        parcel.writeString(string2);
        zzd.zza(parcel, bl2);
        iObjectWrapper = this.zza(3, parcel);
        int n10 = iObjectWrapper.readInt();
        iObjectWrapper.recycle();
        return n10;
    }

    public final IObjectWrapper zza(IObjectWrapper iObjectWrapper, String object, int n10) {
        Parcel parcel = this.a_();
        zzd.zza(parcel, iObjectWrapper);
        parcel.writeString((String)object);
        parcel.writeInt(n10);
        iObjectWrapper = this.zza(2, parcel);
        object = IObjectWrapper$Stub.asInterface(iObjectWrapper.readStrongBinder());
        iObjectWrapper.recycle();
        return object;
    }

    public final int zzb() {
        Parcel parcel = this.a_();
        parcel = this.zza(6, parcel);
        int n10 = parcel.readInt();
        parcel.recycle();
        return n10;
    }

    public final int zzb(IObjectWrapper iObjectWrapper, String string2, boolean bl2) {
        Parcel parcel = this.a_();
        zzd.zza(parcel, iObjectWrapper);
        parcel.writeString(string2);
        zzd.zza(parcel, bl2);
        iObjectWrapper = this.zza(5, parcel);
        int n10 = iObjectWrapper.readInt();
        iObjectWrapper.recycle();
        return n10;
    }

    public final IObjectWrapper zzb(IObjectWrapper iObjectWrapper, String object, int n10) {
        Parcel parcel = this.a_();
        zzd.zza(parcel, iObjectWrapper);
        parcel.writeString((String)object);
        parcel.writeInt(n10);
        iObjectWrapper = this.zza(4, parcel);
        object = IObjectWrapper$Stub.asInterface(iObjectWrapper.readStrongBinder());
        iObjectWrapper.recycle();
        return object;
    }
}

