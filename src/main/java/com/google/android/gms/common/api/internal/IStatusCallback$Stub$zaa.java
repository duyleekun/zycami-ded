/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 */
package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

public final class IStatusCallback$Stub$zaa
extends zaa
implements IStatusCallback {
    public IStatusCallback$Stub$zaa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.api.internal.IStatusCallback");
    }

    public final void onResult(Status status) {
        Parcel parcel = this.zaa();
        zac.zaa(parcel, status);
        this.zac(1, parcel);
    }
}

