/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.zzj;

public final class zzm
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        int n10;
        int n11 = SafeParcelReader.validateObjectHeader(object);
        boolean bl2 = false;
        String string2 = null;
        IBinder iBinder = null;
        boolean bl3 = false;
        while ((n10 = object.dataPosition()) < n11) {
            int n12;
            n10 = SafeParcelReader.readHeader(object);
            int n13 = SafeParcelReader.getFieldId(n10);
            if (n13 != (n12 = 1)) {
                n12 = 2;
                if (n13 != n12) {
                    n12 = 3;
                    if (n13 != n12) {
                        n12 = 4;
                        if (n13 != n12) {
                            SafeParcelReader.skipUnknownField(object, n10);
                            continue;
                        }
                        bl3 = SafeParcelReader.readBoolean(object, n10);
                        continue;
                    }
                    bl2 = SafeParcelReader.readBoolean(object, n10);
                    continue;
                }
                iBinder = SafeParcelReader.readIBinder(object, n10);
                continue;
            }
            string2 = SafeParcelReader.createString(object, n10);
        }
        SafeParcelReader.ensureAtEnd(object, n11);
        object = new zzj(string2, iBinder, bl2, bl3);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new zzj[n10];
    }
}

