/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.metadata.dvbsi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable$1;

public final class AppInfoTable
implements Metadata$Entry {
    public static final int CONTROL_CODE_AUTOSTART = 1;
    public static final int CONTROL_CODE_PRESENT = 2;
    public static final Parcelable.Creator CREATOR;
    public final int controlCode;
    public final String url;

    static {
        AppInfoTable$1 appInfoTable$1 = new AppInfoTable$1();
        CREATOR = appInfoTable$1;
    }

    public AppInfoTable(int n10, String string2) {
        this.controlCode = n10;
        this.url = string2;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        int n10 = this.controlCode;
        String string2 = this.url;
        int n11 = String.valueOf(string2).length() + 33;
        StringBuilder stringBuilder = new StringBuilder(n11);
        stringBuilder.append("Ait(controlCode=");
        stringBuilder.append(n10);
        stringBuilder.append(",url=");
        stringBuilder.append(string2);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        String string2 = this.url;
        parcel.writeString(string2);
        n10 = this.controlCode;
        parcel.writeInt(n10);
    }
}

