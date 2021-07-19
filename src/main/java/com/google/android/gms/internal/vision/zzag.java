/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.vision.zzab;
import com.google.android.gms.internal.vision.zzah;
import com.google.android.gms.internal.vision.zzao;

public final class zzag
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Object object = parcel;
        int n10 = SafeParcelReader.validateObjectHeader(parcel);
        int n11 = 0;
        Object[] objectArray = null;
        int n12 = 0;
        Parcelable.Creator creator = null;
        int n13 = 0;
        boolean bl2 = false;
        int n14 = 0;
        int n15 = 0;
        Object[] objectArray2 = null;
        Object object2 = null;
        Object object3 = null;
        Object object4 = null;
        String string2 = null;
        String string3 = null;
        float f10 = 0.0f;
        block13: while ((n11 = parcel.dataPosition()) < n10) {
            n11 = SafeParcelReader.readHeader(parcel);
            n12 = SafeParcelReader.getFieldId(n11);
            switch (n12) {
                default: {
                    SafeParcelReader.skipUnknownField(object, n11);
                    continue block13;
                }
                case 12: {
                    n15 = SafeParcelReader.readInt(object, n11);
                    continue block13;
                }
                case 11: {
                    n14 = SafeParcelReader.readInt(object, n11);
                    continue block13;
                }
                case 10: {
                    bl2 = SafeParcelReader.readBoolean(object, n11);
                    continue block13;
                }
                case 9: {
                    n13 = SafeParcelReader.readInt(object, n11);
                    continue block13;
                }
                case 8: {
                    string3 = SafeParcelReader.createString(object, n11);
                    continue block13;
                }
                case 7: {
                    f10 = SafeParcelReader.readFloat(object, n11);
                    continue block13;
                }
                case 6: {
                    string2 = SafeParcelReader.createString(object, n11);
                    continue block13;
                }
                case 5: {
                    creator = zzab.CREATOR;
                    object4 = objectArray = SafeParcelReader.createParcelable(object, n11, creator);
                    object4 = (zzab)objectArray;
                    continue block13;
                }
                case 4: {
                    creator = zzab.CREATOR;
                    object3 = objectArray = SafeParcelReader.createParcelable(object, n11, creator);
                    object3 = (zzab)objectArray;
                    continue block13;
                }
                case 3: {
                    creator = zzab.CREATOR;
                    object2 = objectArray = SafeParcelReader.createParcelable(object, n11, creator);
                    object2 = (zzab)objectArray;
                    continue block13;
                }
                case 2: 
            }
            creator = zzao.CREATOR;
            objectArray2 = objectArray = SafeParcelReader.createTypedArray(object, n11, creator);
            objectArray2 = (zzao[])objectArray;
        }
        SafeParcelReader.ensureAtEnd(object, n10);
        object = new zzah((zzao[])objectArray2, (zzab)object2, (zzab)object3, (zzab)object4, string2, f10, string3, n13, bl2, n14, n15);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new zzah[n10];
    }
}

