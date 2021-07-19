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
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.internal.common.zzb;

public final class ICancelToken$Stub$zza
extends zzb
implements ICancelToken {
    public ICancelToken$Stub$zza(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICancelToken");
    }

    public final void cancel() {
        Parcel parcel = this.a_();
        this.zzc(2, parcel);
    }
}

