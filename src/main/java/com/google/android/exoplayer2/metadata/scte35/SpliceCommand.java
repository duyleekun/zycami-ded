/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.metadata.Metadata$Entry;

public abstract class SpliceCommand
implements Metadata$Entry {
    public int describeContents() {
        return 0;
    }

    public String toString() {
        String string2 = String.valueOf(this.getClass().getSimpleName());
        int n10 = string2.length();
        String string3 = "SCTE-35 splice command: type=";
        string2 = n10 != 0 ? string3.concat(string2) : new String(string3);
        return string2;
    }
}

