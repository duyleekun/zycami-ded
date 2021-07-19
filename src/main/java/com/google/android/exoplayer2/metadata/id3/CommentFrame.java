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
import com.google.android.exoplayer2.metadata.id3.CommentFrame$1;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.util.Util;

public final class CommentFrame
extends Id3Frame {
    public static final Parcelable.Creator CREATOR;
    public static final String ID = "COMM";
    public final String description;
    public final String language;
    public final String text;

    static {
        CommentFrame$1 commentFrame$1 = new CommentFrame$1();
        CREATOR = commentFrame$1;
    }

    public CommentFrame(Parcel object) {
        super(ID);
        String string2;
        this.language = string2 = (String)Util.castNonNull(object.readString());
        this.description = string2 = (String)Util.castNonNull(object.readString());
        object = (String)Util.castNonNull(object.readString());
        this.text = object;
    }

    public CommentFrame(String string2, String string3, String string4) {
        super(ID);
        this.language = string2;
        this.description = string3;
        this.text = string4;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = CommentFrame.class) == (object2 = object.getClass())) {
            boolean bl3;
            object = (CommentFrame)object;
            object3 = this.description;
            object2 = ((CommentFrame)object).description;
            boolean bl4 = Util.areEqual(object3, object2);
            if (!(bl4 && (bl4 = Util.areEqual(object3 = this.language, object2 = ((CommentFrame)object).language)) && (bl3 = Util.areEqual(object3 = this.text, object = ((CommentFrame)object).text)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10;
        String string2 = this.language;
        int n11 = 0;
        if (string2 != null) {
            n10 = string2.hashCode();
        } else {
            n10 = 0;
            string2 = null;
        }
        int n12 = (527 + n10) * 31;
        string2 = this.description;
        if (string2 != null) {
            n10 = string2.hashCode();
        } else {
            n10 = 0;
            string2 = null;
        }
        n12 = (n12 + n10) * 31;
        string2 = this.text;
        if (string2 != null) {
            n11 = string2.hashCode();
        }
        return n12 + n11;
    }

    public String toString() {
        String string2 = this.id;
        String string3 = this.language;
        String string4 = this.description;
        int n10 = String.valueOf(string2).length() + 25;
        int n11 = String.valueOf(string3).length();
        n10 += n11;
        n11 = String.valueOf(string4).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append(string2);
        stringBuilder.append(": language=");
        stringBuilder.append(string3);
        stringBuilder.append(", description=");
        stringBuilder.append(string4);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        String string2 = this.id;
        parcel.writeString(string2);
        string2 = this.language;
        parcel.writeString(string2);
        string2 = this.text;
        parcel.writeString(string2);
    }
}

