/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.play_billing.zza;
import com.google.android.gms.internal.play_billing.zzf;
import com.google.android.gms.internal.play_billing.zzh;
import java.util.List;

public final class zzc
extends zzf
implements zza {
    public zzc(IBinder iBinder) {
        super(iBinder, "com.android.vending.billing.IInAppBillingService");
    }

    public final int zza(int n10, String string2, String string3) {
        Parcel parcel = this.zza();
        parcel.writeInt(n10);
        parcel.writeString(string2);
        parcel.writeString(string3);
        Parcel parcel2 = this.zza(1, parcel);
        int n11 = parcel2.readInt();
        parcel2.recycle();
        return n11;
    }

    public final Bundle zza(int n10, String string2, String string3, Bundle bundle) {
        Parcel parcel = this.zza();
        parcel.writeInt(3);
        parcel.writeString(string2);
        parcel.writeString(string3);
        zzh.zza(parcel, (Parcelable)bundle);
        parcel = this.zza(2, parcel);
        string2 = Bundle.CREATOR;
        string2 = (Bundle)zzh.zza(parcel, (Parcelable.Creator)string2);
        parcel.recycle();
        return string2;
    }

    public final Bundle zza(int n10, String string2, String string3, Bundle bundle, Bundle bundle2) {
        Parcel parcel = this.zza();
        parcel.writeInt(10);
        parcel.writeString(string2);
        parcel.writeString(string3);
        zzh.zza(parcel, (Parcelable)bundle);
        zzh.zza(parcel, (Parcelable)bundle2);
        parcel = this.zza(901, parcel);
        string2 = Bundle.CREATOR;
        string2 = (Bundle)zzh.zza(parcel, (Parcelable.Creator)string2);
        parcel.recycle();
        return string2;
    }

    public final Bundle zza(int n10, String string2, String string3, String string4) {
        Parcel parcel = this.zza();
        parcel.writeInt(3);
        parcel.writeString(string2);
        parcel.writeString(string3);
        parcel.writeString(string4);
        parcel = this.zza(4, parcel);
        string2 = Bundle.CREATOR;
        string2 = (Bundle)zzh.zza(parcel, (Parcelable.Creator)string2);
        parcel.recycle();
        return string2;
    }

    public final Bundle zza(int n10, String string2, String string3, String string4, Bundle bundle) {
        Parcel parcel = this.zza();
        parcel.writeInt(6);
        parcel.writeString(string2);
        parcel.writeString(string3);
        parcel.writeString(string4);
        zzh.zza(parcel, (Parcelable)bundle);
        parcel = this.zza(9, parcel);
        string2 = Bundle.CREATOR;
        string2 = (Bundle)zzh.zza(parcel, (Parcelable.Creator)string2);
        parcel.recycle();
        return string2;
    }

    public final Bundle zza(int n10, String string2, String string3, String string4, String string5) {
        Parcel parcel = this.zza();
        int n11 = 3;
        parcel.writeInt(n11);
        parcel.writeString(string2);
        parcel.writeString(string3);
        parcel.writeString(string4);
        parcel.writeString(null);
        parcel = this.zza(n11, parcel);
        string2 = Bundle.CREATOR;
        string2 = (Bundle)zzh.zza(parcel, (Parcelable.Creator)string2);
        parcel.recycle();
        return string2;
    }

    public final Bundle zza(int n10, String string2, String string3, String string4, String string5, Bundle bundle) {
        Parcel parcel = this.zza();
        parcel.writeInt(n10);
        parcel.writeString(string2);
        parcel.writeString(string3);
        parcel.writeString(string4);
        parcel.writeString(string5);
        zzh.zza(parcel, (Parcelable)bundle);
        Parcel parcel2 = this.zza(8, parcel);
        string2 = Bundle.CREATOR;
        string2 = (Bundle)zzh.zza(parcel2, (Parcelable.Creator)string2);
        parcel2.recycle();
        return string2;
    }

    public final Bundle zza(int n10, String string2, List list, String string3, String string4, String string5) {
        Parcel parcel = this.zza();
        parcel.writeInt(5);
        parcel.writeString(string2);
        parcel.writeStringList(list);
        parcel.writeString(string3);
        parcel.writeString(string4);
        parcel.writeString(null);
        parcel = this.zza(7, parcel);
        string2 = Bundle.CREATOR;
        string2 = (Bundle)zzh.zza(parcel, (Parcelable.Creator)string2);
        parcel.recycle();
        return string2;
    }

    public final int zzb(int n10, String string2, String string3) {
        Parcel parcel = this.zza();
        parcel.writeInt(3);
        parcel.writeString(string2);
        parcel.writeString(string3);
        parcel = this.zza(5, parcel);
        int n11 = parcel.readInt();
        parcel.recycle();
        return n11;
    }

    public final int zzb(int n10, String string2, String string3, Bundle bundle) {
        Parcel parcel = this.zza();
        parcel.writeInt(7);
        parcel.writeString(string2);
        parcel.writeString(string3);
        zzh.zza(parcel, (Parcelable)bundle);
        parcel = this.zza(10, parcel);
        int n11 = parcel.readInt();
        parcel.recycle();
        return n11;
    }

    public final Bundle zzb(int n10, String string2, String string3, String string4, Bundle bundle) {
        Parcel parcel = this.zza();
        parcel.writeInt(8);
        parcel.writeString(string2);
        parcel.writeString(string3);
        parcel.writeString(string4);
        zzh.zza(parcel, (Parcelable)bundle);
        parcel = this.zza(801, parcel);
        string2 = Bundle.CREATOR;
        string2 = (Bundle)zzh.zza(parcel, (Parcelable.Creator)string2);
        parcel.recycle();
        return string2;
    }

    public final Bundle zzc(int n10, String string2, String string3, Bundle bundle) {
        Parcel parcel = this.zza();
        parcel.writeInt(9);
        parcel.writeString(string2);
        parcel.writeString(string3);
        zzh.zza(parcel, (Parcelable)bundle);
        parcel = this.zza(12, parcel);
        string2 = Bundle.CREATOR;
        string2 = (Bundle)zzh.zza(parcel, (Parcelable.Creator)string2);
        parcel.recycle();
        return string2;
    }

    public final Bundle zzc(int n10, String string2, String string3, String string4, Bundle bundle) {
        Parcel parcel = this.zza();
        parcel.writeInt(9);
        parcel.writeString(string2);
        parcel.writeString(string3);
        parcel.writeString(string4);
        zzh.zza(parcel, (Parcelable)bundle);
        parcel = this.zza(11, parcel);
        string2 = Bundle.CREATOR;
        string2 = (Bundle)zzh.zza(parcel, (Parcelable.Creator)string2);
        parcel.recycle();
        return string2;
    }

    public final Bundle zzd(int n10, String string2, String string3, Bundle bundle) {
        Parcel parcel = this.zza();
        parcel.writeInt(9);
        parcel.writeString(string2);
        parcel.writeString(string3);
        zzh.zza(parcel, (Parcelable)bundle);
        parcel = this.zza(902, parcel);
        string2 = Bundle.CREATOR;
        string2 = (Bundle)zzh.zza(parcel, (Parcelable.Creator)string2);
        parcel.recycle();
        return string2;
    }
}

