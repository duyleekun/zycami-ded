/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 */
package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;
import com.google.android.gms.signin.internal.zad;
import com.google.android.gms.signin.internal.zaf;
import com.google.android.gms.signin.internal.zah;

public final class zag
extends zaa
implements zaf {
    public zag(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void zaa(IAccountAccessor iAccountAccessor, int n10, boolean bl2) {
        Parcel parcel = this.zaa();
        zac.zaa(parcel, iAccountAccessor);
        parcel.writeInt(n10);
        zac.writeBoolean(parcel, bl2);
        this.zab(9, parcel);
    }

    public final void zaa(zah zah2, zad zad2) {
        Parcel parcel = this.zaa();
        zac.zaa(parcel, zah2);
        zac.zaa(parcel, zad2);
        this.zab(12, parcel);
    }

    public final void zam(int n10) {
        Parcel parcel = this.zaa();
        parcel.writeInt(n10);
        this.zab(7, parcel);
    }
}

