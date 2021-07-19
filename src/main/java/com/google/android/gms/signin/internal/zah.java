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
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.signin.internal.zai;

public final class zah
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int zalf;
    private final ResolveAccountRequest zasd;

    static {
        zai zai2 = new zai();
        CREATOR = zai2;
    }

    public zah(int n10, ResolveAccountRequest resolveAccountRequest) {
        this.zalf = n10;
        this.zasd = resolveAccountRequest;
    }

    public zah(ResolveAccountRequest resolveAccountRequest) {
        this(1, resolveAccountRequest);
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        int n12 = this.zalf;
        SafeParcelWriter.writeInt(parcel, 1, n12);
        ResolveAccountRequest resolveAccountRequest = this.zasd;
        SafeParcelWriter.writeParcelable(parcel, 2, resolveAccountRequest, n10, false);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }
}

