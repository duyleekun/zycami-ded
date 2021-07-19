/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IFragmentWrapper;
import com.google.android.gms.dynamic.IFragmentWrapper$Stub;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper$Stub;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzd;

public final class IFragmentWrapper$Stub$zza
extends zzb
implements IFragmentWrapper {
    public IFragmentWrapper$Stub$zza(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamic.IFragmentWrapper");
    }

    public final IObjectWrapper zza() {
        Parcel parcel = this.a_();
        parcel = this.zza(2, parcel);
        IObjectWrapper iObjectWrapper = IObjectWrapper$Stub.asInterface(parcel.readStrongBinder());
        parcel.recycle();
        return iObjectWrapper;
    }

    public final void zza(Intent intent) {
        Parcel parcel = this.a_();
        zzd.zza(parcel, (Parcelable)intent);
        this.zzb(25, parcel);
    }

    public final void zza(Intent intent, int n10) {
        Parcel parcel = this.a_();
        zzd.zza(parcel, (Parcelable)intent);
        parcel.writeInt(n10);
        this.zzb(26, parcel);
    }

    public final void zza(IObjectWrapper iObjectWrapper) {
        Parcel parcel = this.a_();
        zzd.zza(parcel, iObjectWrapper);
        this.zzb(20, parcel);
    }

    public final void zza(boolean bl2) {
        Parcel parcel = this.a_();
        zzd.zza(parcel, bl2);
        this.zzb(21, parcel);
    }

    public final Bundle zzb() {
        Parcel parcel = this.a_();
        parcel = this.zza(3, parcel);
        Parcelable.Creator creator = Bundle.CREATOR;
        creator = (Bundle)zzd.zza(parcel, creator);
        parcel.recycle();
        return creator;
    }

    public final void zzb(IObjectWrapper iObjectWrapper) {
        Parcel parcel = this.a_();
        zzd.zza(parcel, iObjectWrapper);
        this.zzb(27, parcel);
    }

    public final void zzb(boolean bl2) {
        Parcel parcel = this.a_();
        zzd.zza(parcel, bl2);
        this.zzb(22, parcel);
    }

    public final int zzc() {
        Parcel parcel = this.a_();
        parcel = this.zza(4, parcel);
        int n10 = parcel.readInt();
        parcel.recycle();
        return n10;
    }

    public final void zzc(boolean bl2) {
        Parcel parcel = this.a_();
        zzd.zza(parcel, bl2);
        this.zzb(23, parcel);
    }

    public final IFragmentWrapper zzd() {
        Parcel parcel = this.a_();
        parcel = this.zza(5, parcel);
        IFragmentWrapper iFragmentWrapper = IFragmentWrapper$Stub.asInterface(parcel.readStrongBinder());
        parcel.recycle();
        return iFragmentWrapper;
    }

    public final void zzd(boolean bl2) {
        Parcel parcel = this.a_();
        zzd.zza(parcel, bl2);
        this.zzb(24, parcel);
    }

    public final IObjectWrapper zze() {
        Parcel parcel = this.a_();
        parcel = this.zza(6, parcel);
        IObjectWrapper iObjectWrapper = IObjectWrapper$Stub.asInterface(parcel.readStrongBinder());
        parcel.recycle();
        return iObjectWrapper;
    }

    public final boolean zzf() {
        Parcel parcel = this.a_();
        parcel = this.zza(7, parcel);
        boolean bl2 = zzd.zza(parcel);
        parcel.recycle();
        return bl2;
    }

    public final String zzg() {
        Parcel parcel = this.a_();
        parcel = this.zza(8, parcel);
        String string2 = parcel.readString();
        parcel.recycle();
        return string2;
    }

    public final IFragmentWrapper zzh() {
        Parcel parcel = this.a_();
        parcel = this.zza(9, parcel);
        IFragmentWrapper iFragmentWrapper = IFragmentWrapper$Stub.asInterface(parcel.readStrongBinder());
        parcel.recycle();
        return iFragmentWrapper;
    }

    public final int zzi() {
        Parcel parcel = this.a_();
        parcel = this.zza(10, parcel);
        int n10 = parcel.readInt();
        parcel.recycle();
        return n10;
    }

    public final boolean zzj() {
        Parcel parcel = this.a_();
        parcel = this.zza(11, parcel);
        boolean bl2 = zzd.zza(parcel);
        parcel.recycle();
        return bl2;
    }

    public final IObjectWrapper zzk() {
        Parcel parcel = this.a_();
        parcel = this.zza(12, parcel);
        IObjectWrapper iObjectWrapper = IObjectWrapper$Stub.asInterface(parcel.readStrongBinder());
        parcel.recycle();
        return iObjectWrapper;
    }

    public final boolean zzl() {
        Parcel parcel = this.a_();
        parcel = this.zza(13, parcel);
        boolean bl2 = zzd.zza(parcel);
        parcel.recycle();
        return bl2;
    }

    public final boolean zzm() {
        Parcel parcel = this.a_();
        parcel = this.zza(14, parcel);
        boolean bl2 = zzd.zza(parcel);
        parcel.recycle();
        return bl2;
    }

    public final boolean zzn() {
        Parcel parcel = this.a_();
        parcel = this.zza(15, parcel);
        boolean bl2 = zzd.zza(parcel);
        parcel.recycle();
        return bl2;
    }

    public final boolean zzo() {
        Parcel parcel = this.a_();
        parcel = this.zza(16, parcel);
        boolean bl2 = zzd.zza(parcel);
        parcel.recycle();
        return bl2;
    }

    public final boolean zzp() {
        Parcel parcel = this.a_();
        parcel = this.zza(17, parcel);
        boolean bl2 = zzd.zza(parcel);
        parcel.recycle();
        return bl2;
    }

    public final boolean zzq() {
        Parcel parcel = this.a_();
        parcel = this.zza(18, parcel);
        boolean bl2 = zzd.zza(parcel);
        parcel.recycle();
        return bl2;
    }

    public final boolean zzr() {
        Parcel parcel = this.a_();
        parcel = this.zza(19, parcel);
        boolean bl2 = zzd.zza(parcel);
        parcel.recycle();
        return bl2;
    }
}

