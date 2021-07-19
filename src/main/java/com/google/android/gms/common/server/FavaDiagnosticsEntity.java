/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.zaa;

public class FavaDiagnosticsEntity
extends AbstractSafeParcelable
implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int zalf;
    private final String zapj;
    private final int zapk;

    static {
        zaa zaa2 = new zaa();
        CREATOR = zaa2;
    }

    public FavaDiagnosticsEntity(int n10, String string2, int n11) {
        this.zalf = n10;
        this.zapj = string2;
        this.zapk = n11;
    }

    public FavaDiagnosticsEntity(String string2, int n10) {
        this.zalf = 1;
        this.zapj = string2;
        this.zapk = n10;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        int n11 = this.zalf;
        SafeParcelWriter.writeInt(parcel, 1, n11);
        String string2 = this.zapj;
        SafeParcelWriter.writeString(parcel, 2, string2, false);
        n11 = this.zapk;
        SafeParcelWriter.writeInt(parcel, 3, n11);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

