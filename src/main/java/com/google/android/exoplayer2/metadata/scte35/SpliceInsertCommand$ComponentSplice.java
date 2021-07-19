/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand$1;

public final class SpliceInsertCommand$ComponentSplice {
    public final long componentSplicePlaybackPositionUs;
    public final long componentSplicePts;
    public final int componentTag;

    private SpliceInsertCommand$ComponentSplice(int n10, long l10, long l11) {
        this.componentTag = n10;
        this.componentSplicePts = l10;
        this.componentSplicePlaybackPositionUs = l11;
    }

    public /* synthetic */ SpliceInsertCommand$ComponentSplice(int n10, long l10, long l11, SpliceInsertCommand$1 spliceInsertCommand$1) {
        this(n10, l10, l11);
    }

    public static SpliceInsertCommand$ComponentSplice createFromParcel(Parcel parcel) {
        int n10 = parcel.readInt();
        long l10 = parcel.readLong();
        long l11 = parcel.readLong();
        SpliceInsertCommand$ComponentSplice spliceInsertCommand$ComponentSplice = new SpliceInsertCommand$ComponentSplice(n10, l10, l11);
        return spliceInsertCommand$ComponentSplice;
    }

    public void writeToParcel(Parcel parcel) {
        int n10 = this.componentTag;
        parcel.writeInt(n10);
        long l10 = this.componentSplicePts;
        parcel.writeLong(l10);
        l10 = this.componentSplicePlaybackPositionUs;
        parcel.writeLong(l10);
    }
}

