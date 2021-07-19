/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.zab;

public class ClientIdentity
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final String packageName;
    private final int uid;

    static {
        zab zab2 = new zab();
        CREATOR = zab2;
    }

    public ClientIdentity(int n10, String string2) {
        this.uid = n10;
        this.packageName = string2;
    }

    public boolean equals(Object object) {
        int n10;
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        if (object != null && (n10 = object instanceof ClientIdentity) != 0) {
            String string2;
            boolean bl3;
            object = (ClientIdentity)object;
            n10 = ((ClientIdentity)object).uid;
            int n11 = this.uid;
            if (n10 == n11 && (bl3 = Objects.equal(object = ((ClientIdentity)object).packageName, string2 = this.packageName))) {
                return bl2;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.uid;
    }

    public String toString() {
        int n10 = this.uid;
        String string2 = this.packageName;
        int n11 = String.valueOf(string2).length() + 12;
        StringBuilder stringBuilder = new StringBuilder(n11);
        stringBuilder.append(n10);
        stringBuilder.append(":");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        int n11 = this.uid;
        SafeParcelWriter.writeInt(parcel, 1, n11);
        String string2 = this.packageName;
        SafeParcelWriter.writeString(parcel, 2, string2, false);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

