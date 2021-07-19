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
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.server.response.FastJsonResponse$Field;

public final class zai
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        int n10 = SafeParcelReader.validateObjectHeader(object);
        int n11 = 0;
        Parcelable parcelable = null;
        int n12 = 0;
        Parcelable.Creator creator = null;
        String string2 = null;
        String string3 = null;
        Parcelable parcelable2 = null;
        int n13 = 0;
        int n14 = 0;
        boolean bl2 = false;
        int n15 = 0;
        boolean bl3 = false;
        int n16 = 0;
        block11: while ((n11 = object.dataPosition()) < n10) {
            n11 = SafeParcelReader.readHeader(object);
            n12 = SafeParcelReader.getFieldId(n11);
            switch (n12) {
                default: {
                    SafeParcelReader.skipUnknownField(object, n11);
                    continue block11;
                }
                case 9: {
                    creator = zaa.CREATOR;
                    parcelable2 = parcelable = SafeParcelReader.createParcelable(object, n11, creator);
                    parcelable2 = (zaa)parcelable;
                    continue block11;
                }
                case 8: {
                    string3 = SafeParcelReader.createString(object, n11);
                    continue block11;
                }
                case 7: {
                    n16 = SafeParcelReader.readInt(object, n11);
                    continue block11;
                }
                case 6: {
                    string2 = SafeParcelReader.createString(object, n11);
                    continue block11;
                }
                case 5: {
                    bl3 = SafeParcelReader.readBoolean(object, n11);
                    continue block11;
                }
                case 4: {
                    n15 = SafeParcelReader.readInt(object, n11);
                    continue block11;
                }
                case 3: {
                    bl2 = SafeParcelReader.readBoolean(object, n11);
                    continue block11;
                }
                case 2: {
                    n14 = SafeParcelReader.readInt(object, n11);
                    continue block11;
                }
                case 1: 
            }
            n13 = SafeParcelReader.readInt(object, n11);
        }
        SafeParcelReader.ensureAtEnd(object, n10);
        object = new FastJsonResponse$Field(n13, n14, bl2, n15, bl3, string2, n16, string3, (zaa)parcelable2);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new FastJsonResponse$Field[n10];
    }
}

