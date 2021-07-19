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
import com.google.android.exoplayer2.metadata.scte35.SpliceCommand;
import com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand$1;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public final class TimeSignalCommand
extends SpliceCommand {
    public static final Parcelable.Creator CREATOR;
    public final long playbackPositionUs;
    public final long ptsTime;

    static {
        TimeSignalCommand$1 timeSignalCommand$1 = new TimeSignalCommand$1();
        CREATOR = timeSignalCommand$1;
    }

    private TimeSignalCommand(long l10, long l11) {
        this.ptsTime = l10;
        this.playbackPositionUs = l11;
    }

    public /* synthetic */ TimeSignalCommand(long l10, long l11, TimeSignalCommand$1 timeSignalCommand$1) {
        this(l10, l11);
    }

    public static TimeSignalCommand parseFromSection(ParsableByteArray parsableByteArray, long l10, TimestampAdjuster timestampAdjuster) {
        long l11 = TimeSignalCommand.parseSpliceTime(parsableByteArray, l10);
        long l12 = timestampAdjuster.adjustTsTimestamp(l11);
        TimeSignalCommand timeSignalCommand = new TimeSignalCommand(l11, l12);
        return timeSignalCommand;
    }

    public static long parseSpliceTime(ParsableByteArray parsableByteArray, long l10) {
        long l11;
        long l12;
        int n10 = parsableByteArray.readUnsignedByte();
        long l13 = n10;
        long l14 = 0x80L & l13;
        long l15 = l14 - (l12 = 0L);
        Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object != false) {
            l13 &= 1L;
            object = 32;
            l13 <<= object;
            l14 = parsableByteArray.readUnsignedInt();
            l13 = (l13 | l14) + l10;
            l11 = 0x1FFFFFFFFL & l13;
        } else {
            l11 = -9223372036854775807L;
        }
        return l11;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        long l10 = this.ptsTime;
        parcel.writeLong(l10);
        l10 = this.playbackPositionUs;
        parcel.writeLong(l10);
    }
}

