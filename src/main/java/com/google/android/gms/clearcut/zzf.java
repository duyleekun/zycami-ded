/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.clearcut.zzr;
import com.google.android.gms.phenotype.ExperimentTokens;

public final class zzf
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        int n10 = SafeParcelReader.validateObjectHeader((Parcel)object);
        int n11 = 0;
        ExperimentTokens[] experimentTokensArray = null;
        boolean bl2 = true;
        Object object2 = null;
        byte[] byArray = null;
        int[] nArray = null;
        String[] stringArray = null;
        int[] nArray2 = null;
        byte[][] byArray2 = null;
        ExperimentTokens[] experimentTokensArray2 = null;
        boolean bl3 = bl2;
        block10: while ((n11 = object.dataPosition()) < n10) {
            Parcelable.Creator creator;
            n11 = SafeParcelReader.readHeader((Parcel)object);
            int n12 = SafeParcelReader.getFieldId(n11);
            switch (n12) {
                default: {
                    SafeParcelReader.skipUnknownField((Parcel)object, n11);
                    continue block10;
                }
                case 9: {
                    creator = ExperimentTokens.CREATOR;
                    experimentTokensArray2 = experimentTokensArray = SafeParcelReader.createTypedArray((Parcel)object, n11, creator);
                    experimentTokensArray2 = experimentTokensArray;
                    continue block10;
                }
                case 8: {
                    bl3 = SafeParcelReader.readBoolean((Parcel)object, n11);
                    continue block10;
                }
                case 7: {
                    byArray2 = SafeParcelReader.createByteArrayArray((Parcel)object, n11);
                    continue block10;
                }
                case 6: {
                    nArray2 = SafeParcelReader.createIntArray((Parcel)object, n11);
                    continue block10;
                }
                case 5: {
                    stringArray = SafeParcelReader.createStringArray((Parcel)object, n11);
                    continue block10;
                }
                case 4: {
                    nArray = SafeParcelReader.createIntArray((Parcel)object, n11);
                    continue block10;
                }
                case 3: {
                    byArray = SafeParcelReader.createByteArray((Parcel)object, n11);
                    continue block10;
                }
                case 2: 
            }
            creator = zzr.CREATOR;
            object2 = experimentTokensArray = SafeParcelReader.createParcelable((Parcel)object, n11, creator);
            object2 = (zzr)experimentTokensArray;
        }
        SafeParcelReader.ensureAtEnd((Parcel)object, n10);
        object = new zze((zzr)object2, byArray, nArray, stringArray, nArray2, byArray2, bl3, experimentTokensArray2);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new zze[n10];
    }
}

