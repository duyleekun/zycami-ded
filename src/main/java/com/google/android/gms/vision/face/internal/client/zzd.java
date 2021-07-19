/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.face.internal.client.FaceParcel;
import com.google.android.gms.vision.face.internal.client.LandmarkParcel;
import com.google.android.gms.vision.face.internal.client.zza;

public final class zzd
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Object object = parcel;
        int n10 = SafeParcelReader.validateObjectHeader(parcel);
        int n11 = 0;
        Object[] objectArray = null;
        int n12 = 0;
        Parcelable.Creator creator = null;
        float f10 = Float.MAX_VALUE;
        float f11 = -1.0f;
        Object[] objectArray2 = null;
        Object[] objectArray3 = null;
        int n13 = 0;
        int n14 = 0;
        float f12 = f10;
        float f13 = f10;
        float f14 = f10;
        float f15 = 0.0f;
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        float f19 = 0.0f;
        float f20 = 0.0f;
        float f21 = 0.0f;
        float f22 = f11;
        block17: while ((n11 = parcel.dataPosition()) < n10) {
            n11 = SafeParcelReader.readHeader(parcel);
            n12 = SafeParcelReader.getFieldId(n11);
            switch (n12) {
                default: {
                    SafeParcelReader.skipUnknownField(object, n11);
                    continue block17;
                }
                case 15: {
                    f22 = SafeParcelReader.readFloat(object, n11);
                    continue block17;
                }
                case 14: {
                    f14 = SafeParcelReader.readFloat(object, n11);
                    continue block17;
                }
                case 13: {
                    creator = zza.CREATOR;
                    objectArray3 = objectArray = SafeParcelReader.createTypedArray(object, n11, creator);
                    objectArray3 = (zza[])objectArray;
                    continue block17;
                }
                case 12: {
                    f21 = SafeParcelReader.readFloat(object, n11);
                    continue block17;
                }
                case 11: {
                    f20 = SafeParcelReader.readFloat(object, n11);
                    continue block17;
                }
                case 10: {
                    f19 = SafeParcelReader.readFloat(object, n11);
                    continue block17;
                }
                case 9: {
                    creator = LandmarkParcel.CREATOR;
                    objectArray2 = objectArray = SafeParcelReader.createTypedArray(object, n11, creator);
                    objectArray2 = (LandmarkParcel[])objectArray;
                    continue block17;
                }
                case 8: {
                    f13 = SafeParcelReader.readFloat(object, n11);
                    continue block17;
                }
                case 7: {
                    f12 = SafeParcelReader.readFloat(object, n11);
                    continue block17;
                }
                case 6: {
                    f18 = SafeParcelReader.readFloat(object, n11);
                    continue block17;
                }
                case 5: {
                    f17 = SafeParcelReader.readFloat(object, n11);
                    continue block17;
                }
                case 4: {
                    f16 = SafeParcelReader.readFloat(object, n11);
                    continue block17;
                }
                case 3: {
                    f15 = SafeParcelReader.readFloat(object, n11);
                    continue block17;
                }
                case 2: {
                    n14 = SafeParcelReader.readInt(object, n11);
                    continue block17;
                }
                case 1: 
            }
            n13 = SafeParcelReader.readInt(object, n11);
        }
        SafeParcelReader.ensureAtEnd(object, n10);
        object = new FaceParcel(n13, n14, f15, f16, f17, f18, f12, f13, f14, (LandmarkParcel[])objectArray2, f19, f20, f21, (zza[])objectArray3, f22);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new FaceParcel[n10];
    }
}

