/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.scte35.PrivateCommand$1;
import com.google.android.exoplayer2.metadata.scte35.SpliceCommand;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

public final class PrivateCommand
extends SpliceCommand {
    public static final Parcelable.Creator CREATOR;
    public final byte[] commandBytes;
    public final long identifier;
    public final long ptsAdjustment;

    static {
        PrivateCommand$1 privateCommand$1 = new PrivateCommand$1();
        CREATOR = privateCommand$1;
    }

    private PrivateCommand(long l10, byte[] byArray, long l11) {
        this.ptsAdjustment = l11;
        this.identifier = l10;
        this.commandBytes = byArray;
    }

    private PrivateCommand(Parcel object) {
        long l10;
        this.ptsAdjustment = l10 = object.readLong();
        this.identifier = l10 = object.readLong();
        object = (byte[])Util.castNonNull(object.createByteArray());
        this.commandBytes = (byte[])object;
    }

    public /* synthetic */ PrivateCommand(Parcel parcel, PrivateCommand$1 privateCommand$1) {
        this(parcel);
    }

    public static PrivateCommand parseFromSection(ParsableByteArray object, int n10, long l10) {
        long l11 = ((ParsableByteArray)object).readUnsignedInt();
        byte[] byArray = new byte[n10 += -4];
        ((ParsableByteArray)object).readBytes(byArray, 0, n10);
        object = new PrivateCommand(l11, byArray, l10);
        return object;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        long l10 = this.ptsAdjustment;
        parcel.writeLong(l10);
        l10 = this.identifier;
        parcel.writeLong(l10);
        byte[] byArray = this.commandBytes;
        parcel.writeByteArray(byArray);
    }
}

