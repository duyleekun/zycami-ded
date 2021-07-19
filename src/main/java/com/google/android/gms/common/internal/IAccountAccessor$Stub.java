/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.IAccountAccessor$Stub$zza;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzd;

public abstract class IAccountAccessor$Stub
extends zza
implements IAccountAccessor {
    public IAccountAccessor$Stub() {
        super("com.google.android.gms.common.internal.IAccountAccessor");
    }

    public static IAccountAccessor asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
        boolean bl2 = iInterface instanceof IAccountAccessor;
        if (bl2) {
            return (IAccountAccessor)iInterface;
        }
        iInterface = new IAccountAccessor$Stub$zza(iBinder);
        return iInterface;
    }

    public final boolean zza(int n10, Parcel parcel, Parcel parcel2, int n11) {
        int n12 = 2;
        if (n10 == n12) {
            Account account = this.zza();
            parcel2.writeNoException();
            zzd.zzb(parcel2, (Parcelable)account);
            return true;
        }
        return false;
    }
}

