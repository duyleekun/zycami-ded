/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.signin.internal.zak;

public final class zaj
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final ConnectionResult zadi;
    private final int zalf;
    private final ResolveAccountResponse zase;

    static {
        zak zak2 = new zak();
        CREATOR = zak2;
    }

    public zaj(int n10) {
        ConnectionResult connectionResult = new ConnectionResult(8, null);
        this(connectionResult, null);
    }

    public zaj(int n10, ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this.zalf = n10;
        this.zadi = connectionResult;
        this.zase = resolveAccountResponse;
    }

    private zaj(ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this(1, connectionResult, null);
    }

    public final ConnectionResult getConnectionResult() {
        return this.zadi;
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        int n12 = this.zalf;
        SafeParcelWriter.writeInt(parcel, 1, n12);
        AbstractSafeParcelable abstractSafeParcelable = this.zadi;
        SafeParcelWriter.writeParcelable(parcel, 2, abstractSafeParcelable, n10, false);
        abstractSafeParcelable = this.zase;
        SafeParcelWriter.writeParcelable(parcel, 3, abstractSafeParcelable, n10, false);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }

    public final ResolveAccountResponse zacx() {
        return this.zase;
    }
}

