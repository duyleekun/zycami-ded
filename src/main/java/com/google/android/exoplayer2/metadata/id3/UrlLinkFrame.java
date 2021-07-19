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
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame$1;
import com.google.android.exoplayer2.util.Util;

public final class UrlLinkFrame
extends Id3Frame {
    public static final Parcelable.Creator CREATOR;
    public final String description;
    public final String url;

    static {
        UrlLinkFrame$1 urlLinkFrame$1 = new UrlLinkFrame$1();
        CREATOR = urlLinkFrame$1;
    }

    public UrlLinkFrame(Parcel object) {
        String string2 = (String)Util.castNonNull(object.readString());
        super(string2);
        this.description = string2 = object.readString();
        object = (String)Util.castNonNull(object.readString());
        this.url = object;
    }

    public UrlLinkFrame(String string2, String string3, String string4) {
        super(string2);
        this.description = string3;
        this.url = string4;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = UrlLinkFrame.class) == (object2 = object.getClass())) {
            boolean bl3;
            object = (UrlLinkFrame)object;
            object3 = this.id;
            object2 = ((Id3Frame)object).id;
            boolean bl4 = ((String)object3).equals(object2);
            if (!(bl4 && (bl4 = Util.areEqual(object3 = this.description, object2 = ((UrlLinkFrame)object).description)) && (bl3 = Util.areEqual(object3 = this.url, object = ((UrlLinkFrame)object).url)))) {
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
        string2 = this.url;
        if (string2 != null) {
            n12 = string2.hashCode();
        }
        return n11 + n12;
    }

    public String toString() {
        String string2 = this.id;
        String string3 = this.url;
        int n10 = String.valueOf(string2).length() + 6;
        int n11 = String.valueOf(string3).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append(string2);
        stringBuilder.append(": url=");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        String string2 = this.id;
        parcel.writeString(string2);
        string2 = this.description;
        parcel.writeString(string2);
        string2 = this.url;
        parcel.writeString(string2);
    }
}

