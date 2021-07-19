/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.metadata.Metadata$Entry;

public abstract class Id3Frame
implements Metadata$Entry {
    public final String id;

    public Id3Frame(String string2) {
        this.id = string2;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.id;
    }
}

