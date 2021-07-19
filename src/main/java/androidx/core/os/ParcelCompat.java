/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package androidx.core.os;

import android.os.Parcel;

public final class ParcelCompat {
    private ParcelCompat() {
    }

    public static boolean readBoolean(Parcel parcel) {
        int n10 = parcel.readInt();
        if (n10) {
            n10 = 1;
        } else {
            n10 = 0;
            parcel = null;
        }
        return n10 != 0;
    }

    public static void writeBoolean(Parcel parcel, boolean bl2) {
        parcel.writeInt((int)(bl2 ? 1 : 0));
    }
}

