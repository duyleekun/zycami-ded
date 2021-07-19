/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 */
package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.service.zaj;
import com.google.android.gms.common.internal.service.zal;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

public final class zam
extends zaa
implements zal {
    public zam(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.ICommonService");
    }

    public final void zaa(zaj zaj2) {
        Parcel parcel = this.zaa();
        zac.zaa(parcel, zaj2);
        this.zac(1, parcel);
    }
}

