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
import com.google.android.gms.vision.face.internal.client.zzf;

public final class zze
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        int n10 = SafeParcelReader.validateObjectHeader(object);
        int n11 = 0;
        int n12 = -1082130432;
        float f10 = -1.0f;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        boolean bl2 = false;
        boolean bl3 = false;
        float f11 = f10;
        block8: while ((n11 = object.dataPosition()) < n10) {
            n11 = SafeParcelReader.readHeader(object);
            n12 = SafeParcelReader.getFieldId(n11);
            switch (n12) {
                default: {
                    SafeParcelReader.skipUnknownField(object, n11);
                    continue block8;
                }
                case 7: {
                    f11 = SafeParcelReader.readFloat(object, n11);
                    continue block8;
                }
                case 6: {
                    bl3 = SafeParcelReader.readBoolean(object, n11);
                    continue block8;
                }
                case 5: {
                    bl2 = SafeParcelReader.readBoolean(object, n11);
                    continue block8;
                }
                case 4: {
                    n15 = SafeParcelReader.readInt(object, n11);
                    continue block8;
                }
                case 3: {
                    n14 = SafeParcelReader.readInt(object, n11);
                    continue block8;
                }
                case 2: 
            }
            n13 = SafeParcelReader.readInt(object, n11);
        }
        SafeParcelReader.ensureAtEnd(object, n10);
        object = new zzf(n13, n14, n15, bl2, bl3, f11);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new zzf[n10];
    }
}

