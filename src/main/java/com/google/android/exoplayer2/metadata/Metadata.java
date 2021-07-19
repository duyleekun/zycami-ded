/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.Metadata$1;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.List;

public final class Metadata
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private final Metadata$Entry[] entries;

    static {
        Metadata$1 metadata$1 = new Metadata$1();
        CREATOR = metadata$1;
    }

    public Metadata(Parcel parcel) {
        Metadata$Entry[] metadata$EntryArray;
        int n10;
        Metadata$Entry[] metadata$EntryArray2 = new Metadata$Entry[parcel.readInt()];
        this.entries = metadata$EntryArray2;
        metadata$EntryArray2 = null;
        for (int i10 = 0; i10 < (n10 = (metadata$EntryArray = this.entries).length); ++i10) {
            Object object = Metadata$Entry.class.getClassLoader();
            metadata$EntryArray[i10] = object = (Metadata$Entry)parcel.readParcelable((ClassLoader)object);
        }
    }

    public Metadata(List metadata$EntryArray) {
        Metadata$Entry[] metadata$EntryArray2 = new Metadata$Entry[]{};
        metadata$EntryArray = metadata$EntryArray.toArray(metadata$EntryArray2);
        this.entries = metadata$EntryArray;
    }

    public Metadata(Metadata$Entry ... metadata$EntryArray) {
        this.entries = metadata$EntryArray;
    }

    public Metadata copyWithAppendedEntries(Metadata$Entry ... metadata$EntryArray) {
        int n10 = metadata$EntryArray.length;
        if (n10 == 0) {
            return this;
        }
        metadata$EntryArray = (Metadata$Entry[])Util.nullSafeArrayConcatenation(this.entries, metadata$EntryArray);
        Metadata metadata = new Metadata(metadata$EntryArray);
        return metadata;
    }

    public Metadata copyWithAppendedEntriesFrom(Metadata metadata$EntryArray) {
        if (metadata$EntryArray == null) {
            return this;
        }
        metadata$EntryArray = metadata$EntryArray.entries;
        return this.copyWithAppendedEntries(metadata$EntryArray);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object objectArray) {
        Class<?> clazz;
        Object[] objectArray2;
        if (this == objectArray) {
            return true;
        }
        if (objectArray != null && (objectArray2 = Metadata.class) == (clazz = objectArray.getClass())) {
            objectArray = (Metadata)objectArray;
            objectArray2 = this.entries;
            objectArray = objectArray.entries;
            return Arrays.equals(objectArray2, objectArray);
        }
        return false;
    }

    public Metadata$Entry get(int n10) {
        return this.entries[n10];
    }

    public int hashCode() {
        return Arrays.hashCode(this.entries);
    }

    public int length() {
        return this.entries.length;
    }

    public String toString() {
        String string2 = String.valueOf(Arrays.toString(this.entries));
        int n10 = string2.length();
        String string3 = "entries=";
        string2 = n10 != 0 ? string3.concat(string2) : new String(string3);
        return string2;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this.entries.length;
        parcel.writeInt(n10);
        for (Metadata$Entry metadata$Entry : this.entries) {
            parcel.writeParcelable((Parcelable)metadata$Entry, 0);
        }
    }
}

