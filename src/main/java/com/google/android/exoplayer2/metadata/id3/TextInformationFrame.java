/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame$1;
import com.google.android.exoplayer2.util.Util;

public final class TextInformationFrame
extends Id3Frame {
    public static final Parcelable.Creator CREATOR;
    public final String description;
    public final String value;

    static {
        TextInformationFrame$1 textInformationFrame$1 = new TextInformationFrame$1();
        CREATOR = textInformationFrame$1;
    }

    public TextInformationFrame(Parcel object) {
        String string2 = (String)Util.castNonNull(object.readString());
        super(string2);
        this.description = string2 = object.readString();
        object = (String)Util.castNonNull(object.readString());
        this.value = object;
    }

    public TextInformationFrame(String string2, String string3, String string4) {
        super(string2);
        this.description = string3;
        this.value = string4;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = TextInformationFrame.class) == (object2 = object.getClass())) {
            boolean bl3;
            object = (TextInformationFrame)object;
            object3 = this.id;
            object2 = ((Id3Frame)object).id;
            boolean bl4 = ((String)object3).equals(object2);
            if (!(bl4 && (bl4 = Util.areEqual(object3 = this.description, object2 = ((TextInformationFrame)object).description)) && (bl3 = Util.areEqual(object3 = this.value, object = ((TextInformationFrame)object).value)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.id.hashCode();
        int n11 = (527 + n10) * 31;
        String string2 = this.description;
        int n12 = 0;
        if (string2 != null) {
            n10 = string2.hashCode();
        } else {
            n10 = 0;
            string2 = null;
        }
        n11 = (n11 + n10) * 31;
        string2 = this.value;
        if (string2 != null) {
            n12 = string2.hashCode();
        }
        return n11 + n12;
    }

    public String toString() {
        String string2 = this.id;
        String string3 = this.description;
        String string4 = this.value;
        int n10 = String.valueOf(string2).length() + 22;
        int n11 = String.valueOf(string3).length();
        n10 += n11;
        n11 = String.valueOf(string4).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append(string2);
        stringBuilder.append(": description=");
        stringBuilder.append(string3);
        stringBuilder.append(": value=");
        stringBuilder.append(string4);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        String string2 = this.id;
        parcel.writeString(string2);
        string2 = this.description;
        parcel.writeString(string2);
        string2 = this.value;
        parcel.writeString(string2);
    }
}

