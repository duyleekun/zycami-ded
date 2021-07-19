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
import com.google.android.gms.phenotype.ExperimentTokens;

public final class zzh
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        int n10 = SafeParcelReader.validateObjectHeader(object);
        int n11 = 0;
        String string2 = null;
        byte[] byArray = null;
        byte[][] byArray2 = null;
        byte[][] byArray3 = null;
        byte[][] byArray4 = null;
        byte[][] byArray5 = null;
        int[] nArray = null;
        byte[][] byArray6 = null;
        block10: while ((n11 = object.dataPosition()) < n10) {
            n11 = SafeParcelReader.readHeader(object);
            int n12 = SafeParcelReader.getFieldId(n11);
            switch (n12) {
                default: {
                    SafeParcelReader.skipUnknownField(object, n11);
                    continue block10;
                }
                case 9: {
                    byArray6 = SafeParcelReader.createByteArrayArray(object, n11);
                    continue block10;
                }
                case 8: {
                    nArray = SafeParcelReader.createIntArray(object, n11);
                    continue block10;
                }
                case 7: {
                    byArray5 = SafeParcelReader.createByteArrayArray(object, n11);
                    continue block10;
                }
                case 6: {
                    byArray4 = SafeParcelReader.createByteArrayArray(object, n11);
                    continue block10;
                }
                case 5: {
                    byArray3 = SafeParcelReader.createByteArrayArray(object, n11);
                    continue block10;
                }
                case 4: {
                    byArray2 = SafeParcelReader.createByteArrayArray(object, n11);
                    continue block10;
                }
                case 3: {
                    byArray = SafeParcelReader.createByteArray(object, n11);
                    continue block10;
                }
                case 2: 
            }
            string2 = SafeParcelReader.createString(object, n11);
        }
        SafeParcelReader.ensureAtEnd(object, n10);
        object = new ExperimentTokens(string2, byArray, byArray2, byArray3, byArray4, byArray5, nArray, byArray6);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new ExperimentTokens[n10];
    }
}

