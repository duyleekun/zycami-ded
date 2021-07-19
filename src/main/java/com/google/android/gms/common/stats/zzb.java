/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.stats.WakeLockEvent;
import java.util.ArrayList;

public final class zzb
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int n10;
        long l10;
        Object object = parcel;
        int n11 = SafeParcelReader.validateObjectHeader(parcel);
        long l11 = l10 = 0L;
        long l12 = l10;
        long l13 = l10;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        boolean bl2 = false;
        String string2 = null;
        ArrayList arrayList = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        String string6 = null;
        float f10 = 0.0f;
        block17: while ((n10 = parcel.dataPosition()) < n11) {
            n10 = SafeParcelReader.readHeader(parcel);
            int n16 = SafeParcelReader.getFieldId(n10);
            switch (n16) {
                default: {
                    SafeParcelReader.skipUnknownField(object, n10);
                    continue block17;
                }
                case 18: {
                    bl2 = SafeParcelReader.readBoolean(object, n10);
                    continue block17;
                }
                case 17: {
                    string6 = SafeParcelReader.createString(object, n10);
                    continue block17;
                }
                case 16: {
                    l13 = SafeParcelReader.readLong(object, n10);
                    continue block17;
                }
                case 15: {
                    f10 = SafeParcelReader.readFloat(object, n10);
                    continue block17;
                }
                case 14: {
                    n15 = SafeParcelReader.readInt(object, n10);
                    continue block17;
                }
                case 13: {
                    string5 = SafeParcelReader.createString(object, n10);
                    continue block17;
                }
                case 12: {
                    string3 = SafeParcelReader.createString(object, n10);
                    continue block17;
                }
                case 11: {
                    n13 = SafeParcelReader.readInt(object, n10);
                    continue block17;
                }
                case 10: {
                    string4 = SafeParcelReader.createString(object, n10);
                    continue block17;
                }
                case 8: {
                    l12 = SafeParcelReader.readLong(object, n10);
                    continue block17;
                }
                case 6: {
                    arrayList = SafeParcelReader.createStringList(object, n10);
                    continue block17;
                }
                case 5: {
                    n14 = SafeParcelReader.readInt(object, n10);
                    continue block17;
                }
                case 4: {
                    string2 = SafeParcelReader.createString(object, n10);
                    continue block17;
                }
                case 2: {
                    l11 = SafeParcelReader.readLong(object, n10);
                    continue block17;
                }
                case 1: 
            }
            n12 = SafeParcelReader.readInt(object, n10);
        }
        SafeParcelReader.ensureAtEnd(object, n11);
        object = new WakeLockEvent(n12, l11, n13, string2, n14, arrayList, string3, l12, n15, string4, string5, f10, l13, string6, bl2);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new WakeLockEvent[n10];
    }
}

