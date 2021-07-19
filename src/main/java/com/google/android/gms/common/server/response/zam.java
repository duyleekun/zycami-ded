/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.response.FastJsonResponse$Field;
import com.google.android.gms.common.server.response.zaj;

public final class zam
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int versionCode;
    public final String zaqz;
    public final FastJsonResponse$Field zara;

    static {
        zaj zaj2 = new zaj();
        CREATOR = zaj2;
    }

    public zam(int n10, String string2, FastJsonResponse$Field fastJsonResponse$Field) {
        this.versionCode = n10;
        this.zaqz = string2;
        this.zara = fastJsonResponse$Field;
    }

    public zam(String string2, FastJsonResponse$Field fastJsonResponse$Field) {
        this.versionCode = 1;
        this.zaqz = string2;
        this.zara = fastJsonResponse$Field;
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        int n12 = this.versionCode;
        SafeParcelWriter.writeInt(parcel, 1, n12);
        Object object = this.zaqz;
        SafeParcelWriter.writeString(parcel, 2, (String)object, false);
        object = this.zara;
        SafeParcelWriter.writeParcelable(parcel, 3, (Parcelable)object, n10, false);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }
}

