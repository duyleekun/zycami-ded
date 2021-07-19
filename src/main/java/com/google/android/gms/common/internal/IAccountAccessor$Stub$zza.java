/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzd;

public final class IAccountAccessor$Stub$zza
extends zzb
implements IAccountAccessor {
    public IAccountAccessor$Stub$zza(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    public final Account zza() {
        Parcel parcel = this.a_();
        parcel = this.zza(2, parcel);
        Parcelable.Creator creator = Account.CREATOR;
        creator = (Account)zzd.zza(parcel, creator);
        parcel.recycle();
        return creator;
    }
}

