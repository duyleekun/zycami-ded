/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzb
implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel object) {
        int n10;
        int n11 = SafeParcelReader.validateObjectHeader(object);
        String string2 = null;
        int n12 = 0;
        int n13 = 0;
        Parcelable.Creator creator = null;
        while ((n10 = object.dataPosition()) < n11) {
            int n14;
            n10 = SafeParcelReader.readHeader(object);
            int n15 = SafeParcelReader.getFieldId(n10);
            if (n15 != (n14 = 1)) {
                n14 = 2;
                if (n15 != n14) {
                    n14 = 3;
                    if (n15 != n14) {
                        n14 = 1000;
                        if (n15 != n14) {
                            SafeParcelReader.skipUnknownField(object, n10);
                            continue;
                        }
                        n12 = SafeParcelReader.readInt(object, n10);
                        continue;
                    }
                    creator = PendingIntent.CREATOR;
                    creator = (PendingIntent)SafeParcelReader.createParcelable(object, n10, creator);
                    continue;
                }
                string2 = SafeParcelReader.createString(object, n10);
                continue;
            }
            n13 = SafeParcelReader.readInt(object, n10);
        }
        SafeParcelReader.ensureAtEnd(object, n11);
        object = new Status(n12, n13, string2, (PendingIntent)creator);
        return object;
    }

    public final /* synthetic */ Object[] newArray(int n10) {
        return new Status[n10];
    }
}

