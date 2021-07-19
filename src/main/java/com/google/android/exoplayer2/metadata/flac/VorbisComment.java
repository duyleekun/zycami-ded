/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.metadata.flac.VorbisComment$1;
import com.google.android.exoplayer2.util.Util;

public final class VorbisComment
implements Metadata$Entry {
    public static final Parcelable.Creator CREATOR;
    public final String key;
    public final String value;

    static {
        VorbisComment$1 vorbisComment$1 = new VorbisComment$1();
        CREATOR = vorbisComment$1;
    }

    public VorbisComment(Parcel object) {
        String string2;
        this.key = string2 = (String)Util.castNonNull(object.readString());
        object = (String)Util.castNonNull(object.readString());
        this.value = object;
    }

    public VorbisComment(String string2, String string3) {
        this.key = string2;
        this.value = string3;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = VorbisComment.class) == (object2 = object.getClass())) {
            boolean bl3;
            object = (VorbisComment)object;
            object3 = this.key;
            object2 = ((VorbisComment)object).key;
            boolean bl4 = ((String)object3).equals(object2);
            if (!bl4 || !(bl3 = ((String)(object3 = this.value)).equals(object = ((VorbisComment)object).value))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.key.hashCode();
        int n11 = (527 + n10) * 31;
        n10 = this.value.hashCode();
        return n11 + n10;
    }

    public String toString() {
        String string2 = this.key;
        String string3 = this.value;
        int n10 = String.valueOf(string2).length() + 5;
        int n11 = String.valueOf(string3).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append("VC: ");
        stringBuilder.append(string2);
        stringBuilder.append("=");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        String string2 = this.key;
        parcel.writeString(string2);
        string2 = this.value;
        parcel.writeString(string2);
    }
}

