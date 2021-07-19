/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.converter.zab;
import com.google.android.gms.common.server.response.FastJsonResponse$FieldConverter;

public final class zaa
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int zalf;
    private final StringToIntConverter zapl;

    static {
        zab zab2 = new zab();
        CREATOR = zab2;
    }

    public zaa(int n10, StringToIntConverter stringToIntConverter) {
        this.zalf = n10;
        this.zapl = stringToIntConverter;
    }

    private zaa(StringToIntConverter stringToIntConverter) {
        this.zalf = 1;
        this.zapl = stringToIntConverter;
    }

    public static zaa zaa(FastJsonResponse$FieldConverter object) {
        boolean bl2 = object instanceof StringToIntConverter;
        if (bl2) {
            object = (StringToIntConverter)object;
            zaa zaa2 = new zaa((StringToIntConverter)object);
            return zaa2;
        }
        object = new IllegalArgumentException("Unsupported safe parcelable field converter class.");
        throw object;
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        int n12 = this.zalf;
        SafeParcelWriter.writeInt(parcel, 1, n12);
        StringToIntConverter stringToIntConverter = this.zapl;
        SafeParcelWriter.writeParcelable(parcel, 2, stringToIntConverter, n10, false);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }

    public final FastJsonResponse$FieldConverter zaci() {
        Object object = this.zapl;
        if (object != null) {
            return object;
        }
        object = new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
        throw object;
    }
}

