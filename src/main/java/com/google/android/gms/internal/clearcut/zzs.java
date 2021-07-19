/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.internal.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.clearcut.zzr;

public final class zzs
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        int n10 = SafeParcelReader.validateObjectHeader(object);
        int n11 = 0;
        int n12 = 0;
        boolean bl2 = true;
        int n13 = 0;
        int n14 = 0;
        boolean bl3 = false;
        int n15 = 0;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        boolean bl4 = bl2;
        block11: while ((n11 = object.dataPosition()) < n10) {
            n11 = SafeParcelReader.readHeader(object);
            n12 = SafeParcelReader.getFieldId(n11);
            switch (n12) {
                default: {
                    SafeParcelReader.skipUnknownField(object, n11);
                    continue block11;
                }
                case 10: {
                    n15 = SafeParcelReader.readInt(object, n11);
                    continue block11;
                }
                case 9: {
                    bl3 = SafeParcelReader.readBoolean(object, n11);
                    continue block11;
                }
                case 8: {
                    string5 = SafeParcelReader.createString(object, n11);
                    continue block11;
                }
                case 7: {
                    bl4 = SafeParcelReader.readBoolean(object, n11);
                    continue block11;
                }
                case 6: {
                    string4 = SafeParcelReader.createString(object, n11);
                    continue block11;
                }
                case 5: {
                    string3 = SafeParcelReader.createString(object, n11);
                    continue block11;
                }
                case 4: {
                    n14 = SafeParcelReader.readInt(object, n11);
                    continue block11;
                }
                case 3: {
                    n13 = SafeParcelReader.readInt(object, n11);
                    continue block11;
                }
                case 2: 
            }
            string2 = SafeParcelReader.createString(object, n11);
        }
        SafeParcelReader.ensureAtEnd(object, n10);
        object = new zzr(string2, n13, n14, string3, string4, bl4, string5, bl3, n15);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new zzr[n10];
    }
}

