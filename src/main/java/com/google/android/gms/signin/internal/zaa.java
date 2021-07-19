/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.signin.internal.zab;

public final class zaa
extends AbstractSafeParcelable
implements Result {
    public static final Parcelable.Creator CREATOR;
    private final int zalf;
    private int zarz;
    private Intent zasa;

    static {
        zab zab2 = new zab();
        CREATOR = zab2;
    }

    public zaa() {
        this(0, null);
    }

    public zaa(int n10, int n11, Intent intent) {
        this.zalf = n10;
        this.zarz = n11;
        this.zasa = intent;
    }

    private zaa(int n10, Intent intent) {
        this(2, 0, null);
    }

    public final Status getStatus() {
        int n10 = this.zarz;
        if (n10 == 0) {
            return Status.RESULT_SUCCESS;
        }
        return Status.RESULT_CANCELED;
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        int n12 = this.zalf;
        SafeParcelWriter.writeInt(parcel, 1, n12);
        n12 = this.zarz;
        SafeParcelWriter.writeInt(parcel, 2, n12);
        Intent intent = this.zasa;
        SafeParcelWriter.writeParcelable(parcel, 3, (Parcelable)intent, n10, false);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }
}

