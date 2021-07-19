/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.phenotype.zzi;

public final class zzk
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Object object = parcel;
        int n10 = SafeParcelReader.validateObjectHeader(parcel);
        int n11 = 0;
        int n12 = 0;
        long l10 = 0L;
        double d10 = 0.0;
        boolean bl2 = false;
        int n13 = 0;
        int n14 = 0;
        String string2 = null;
        String string3 = null;
        byte[] byArray = null;
        long l11 = l10;
        double d11 = d10;
        block10: while ((n11 = parcel.dataPosition()) < n10) {
            n11 = SafeParcelReader.readHeader(parcel);
            n12 = SafeParcelReader.getFieldId(n11);
            switch (n12) {
                default: {
                    SafeParcelReader.skipUnknownField(object, n11);
                    continue block10;
                }
                case 9: {
                    n14 = SafeParcelReader.readInt(object, n11);
                    continue block10;
                }
                case 8: {
                    n13 = SafeParcelReader.readInt(object, n11);
                    continue block10;
                }
                case 7: {
                    byArray = SafeParcelReader.createByteArray(object, n11);
                    continue block10;
                }
                case 6: {
                    string3 = SafeParcelReader.createString(object, n11);
                    continue block10;
                }
                case 5: {
                    d11 = SafeParcelReader.readDouble(object, n11);
                    continue block10;
                }
                case 4: {
                    bl2 = SafeParcelReader.readBoolean(object, n11);
                    continue block10;
                }
                case 3: {
                    l11 = SafeParcelReader.readLong(object, n11);
                    continue block10;
                }
                case 2: 
            }
            string2 = SafeParcelReader.createString(object, n11);
        }
        SafeParcelReader.ensureAtEnd(object, n10);
        object = new zzi(string2, l11, bl2, d11, string3, byArray, n13, n14);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new zzi[n10];
    }
}

