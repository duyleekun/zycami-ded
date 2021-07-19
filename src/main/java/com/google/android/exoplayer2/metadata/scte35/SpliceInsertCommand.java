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
import com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand$1;
import com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand$ComponentSplice;
import com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceInsertCommand
extends SpliceCommand {
    public static final Parcelable.Creator CREATOR;
    public final boolean autoReturn;
    public final int availNum;
    public final int availsExpected;
    public final long breakDurationUs;
    public final List componentSpliceList;
    public final boolean outOfNetworkIndicator;
    public final boolean programSpliceFlag;
    public final long programSplicePlaybackPositionUs;
    public final long programSplicePts;
    public final boolean spliceEventCancelIndicator;
    public final long spliceEventId;
    public final boolean spliceImmediateFlag;
    public final int uniqueProgramId;

    static {
        SpliceInsertCommand$1 spliceInsertCommand$1 = new SpliceInsertCommand$1();
        CREATOR = spliceInsertCommand$1;
    }

    private SpliceInsertCommand(long l10, boolean bl2, boolean bl3, boolean bl4, boolean bl5, long l11, long l12, List list, boolean bl6, long l13, int n10, int n11, int n12) {
        List list2;
        this.spliceEventId = l10;
        this.spliceEventCancelIndicator = bl2;
        this.outOfNetworkIndicator = bl3;
        this.programSpliceFlag = bl4;
        this.spliceImmediateFlag = bl5;
        this.programSplicePts = l11;
        this.programSplicePlaybackPositionUs = l12;
        this.componentSpliceList = list2 = Collections.unmodifiableList(list);
        this.autoReturn = bl6;
        this.breakDurationUs = l13;
        this.uniqueProgramId = n10;
        this.availNum = n11;
        this.availsExpected = n12;
    }

    private SpliceInsertCommand(Parcel parcel) {
        int n10;
        long l10;
        List list;
        long l11;
        this.spliceEventId = l11 = parcel.readLong();
        int n11 = parcel.readByte();
        int n12 = 0;
        int n13 = 1;
        if (n11 == n13) {
            n11 = n13;
        } else {
            n11 = 0;
            list = null;
        }
        this.spliceEventCancelIndicator = n11;
        n11 = parcel.readByte();
        if (n11 == n13) {
            n11 = n13;
        } else {
            n11 = 0;
            list = null;
        }
        this.outOfNetworkIndicator = n11;
        n11 = parcel.readByte();
        if (n11 == n13) {
            n11 = n13;
        } else {
            n11 = 0;
            list = null;
        }
        this.programSpliceFlag = n11;
        n11 = parcel.readByte();
        if (n11 == n13) {
            n11 = n13;
        } else {
            n11 = 0;
            list = null;
        }
        this.spliceImmediateFlag = n11;
        this.programSplicePts = l10 = parcel.readLong();
        this.programSplicePlaybackPositionUs = l10 = parcel.readLong();
        n11 = parcel.readInt();
        ArrayList<SpliceInsertCommand$ComponentSplice> arrayList = new ArrayList<SpliceInsertCommand$ComponentSplice>(n11);
        for (int i10 = 0; i10 < n11; ++i10) {
            SpliceInsertCommand$ComponentSplice spliceInsertCommand$ComponentSplice = SpliceInsertCommand$ComponentSplice.createFromParcel(parcel);
            arrayList.add(spliceInsertCommand$ComponentSplice);
        }
        this.componentSpliceList = list = Collections.unmodifiableList(arrayList);
        n11 = parcel.readByte();
        if (n11 == n13) {
            n12 = n13;
        }
        this.autoReturn = n12;
        this.breakDurationUs = l11 = parcel.readLong();
        this.uniqueProgramId = n11 = parcel.readInt();
        this.availNum = n11 = parcel.readInt();
        this.availsExpected = n10 = parcel.readInt();
    }

    public /* synthetic */ SpliceInsertCommand(Parcel parcel, SpliceInsertCommand$1 spliceInsertCommand$1) {
        this(parcel);
    }

    public static SpliceInsertCommand parseFromSection(ParsableByteArray parsableByteArray, long l10, TimestampAdjuster timestampAdjuster) {
        SpliceInsertCommand spliceInsertCommand;
        long l11;
        long l12;
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        Object object;
        int n15;
        int n16;
        List list;
        TimestampAdjuster timestampAdjuster2 = timestampAdjuster;
        long l13 = parsableByteArray.readUnsignedInt();
        int n17 = parsableByteArray.readUnsignedByte() & 0x80;
        int n18 = n17 != 0 ? 1 : 0;
        ArrayList arrayList = Collections.emptyList();
        if (n18 == 0) {
            SpliceInsertCommand$ComponentSplice spliceInsertCommand$ComponentSplice;
            long l14;
            float f10;
            float f11;
            int n19 = parsableByteArray.readUnsignedByte();
            int n20 = n19 & 0x80;
            if (n20 != 0) {
                n20 = 1;
                f11 = Float.MIN_VALUE;
            } else {
                n20 = 0;
                f11 = 0.0f;
            }
            int n21 = n19 & 0x40;
            if (n21 != 0) {
                n21 = 1;
                f10 = Float.MIN_VALUE;
            } else {
                n21 = 0;
                f10 = 0.0f;
            }
            int n22 = n19 & 0x20;
            if (n22 != 0) {
                n22 = 1;
            } else {
                n22 = 0;
                list = null;
            }
            n19 = (n19 &= 0x10) != 0 ? 1 : 0;
            long l15 = n21 != 0 && n19 == 0 ? TimeSignalCommand.parseSpliceTime(parsableByteArray, l10) : -9223372036854775807L;
            if (n21 == 0) {
                n17 = parsableByteArray.readUnsignedByte();
                ArrayList arrayList2 = new ArrayList(n17);
                for (n16 = 0; n16 < n17; ++n16) {
                    long l16;
                    n15 = parsableByteArray.readUnsignedByte();
                    l14 = n19 == 0 ? (l16 = TimeSignalCommand.parseSpliceTime(parsableByteArray, l10)) : -9223372036854775807L;
                    long l17 = timestampAdjuster2.adjustTsTimestamp(l14);
                    l16 = l14;
                    spliceInsertCommand$ComponentSplice = new SpliceInsertCommand$ComponentSplice(n15, l14, l17, null);
                    arrayList2.add(spliceInsertCommand$ComponentSplice);
                }
                arrayList = arrayList2;
            }
            if (n22 != 0) {
                long l18;
                n16 = parsableByteArray.readUnsignedByte();
                long l19 = n16;
                l14 = 0x80L & l19;
                long l20 = l14 - (l18 = 0L);
                object = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
                if (object != 0) {
                    n14 = 1;
                    float f12 = Float.MIN_VALUE;
                } else {
                    n14 = 0;
                    float f13 = 0.0f;
                }
                l19 &= 1L;
                object = 32;
                l19 <<= object;
                l14 = parsableByteArray.readUnsignedInt();
                l19 = (l19 | l14) * 1000L;
                l14 = l19 / (long)90;
                n13 = n14;
            } else {
                n13 = 0;
                spliceInsertCommand$ComponentSplice = null;
                l14 = -9223372036854775807L;
            }
            n16 = parsableByteArray.readUnsignedShort();
            n22 = parsableByteArray.readUnsignedByte();
            int n23 = parsableByteArray.readUnsignedByte();
            n14 = n16;
            n12 = n21;
            float f14 = f10;
            n11 = n22;
            n15 = n23;
            list = arrayList;
            n10 = n13;
            l12 = l14;
            object = n19;
            n13 = n20;
            l11 = l15;
        } else {
            list = arrayList;
            n13 = 0;
            Object var26_22 = null;
            object = 0;
            l11 = -9223372036854775807L;
            n10 = 0;
            l12 = -9223372036854775807L;
            n14 = 0;
            float f15 = 0.0f;
            n11 = 0;
            n15 = 0;
            n12 = 0;
            float f16 = 0.0f;
        }
        arrayList = spliceInsertCommand;
        long l21 = timestampAdjuster2.adjustTsTimestamp(l11);
        n16 = n18;
        n18 = n12;
        spliceInsertCommand = new SpliceInsertCommand(l13, n16 != 0, n13 != 0, n12 != 0, (boolean)object, l11, l21, list, n10 != 0, l12, n14, n11, n15);
        return spliceInsertCommand;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        long l10 = this.spliceEventId;
        parcel.writeLong(l10);
        n10 = (byte)(this.spliceEventCancelIndicator ? 1 : 0);
        parcel.writeByte((byte)n10);
        n10 = (byte)(this.outOfNetworkIndicator ? 1 : 0);
        parcel.writeByte((byte)n10);
        n10 = (byte)(this.programSpliceFlag ? 1 : 0);
        parcel.writeByte((byte)n10);
        n10 = (byte)(this.spliceImmediateFlag ? 1 : 0);
        parcel.writeByte((byte)n10);
        l10 = this.programSplicePts;
        parcel.writeLong(l10);
        l10 = this.programSplicePlaybackPositionUs;
        parcel.writeLong(l10);
        List list = this.componentSpliceList;
        n10 = list.size();
        parcel.writeInt(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            SpliceInsertCommand$ComponentSplice spliceInsertCommand$ComponentSplice = (SpliceInsertCommand$ComponentSplice)this.componentSpliceList.get(i10);
            spliceInsertCommand$ComponentSplice.writeToParcel(parcel);
        }
        n10 = (byte)(this.autoReturn ? 1 : 0);
        parcel.writeByte((byte)n10);
        l10 = this.breakDurationUs;
        parcel.writeLong(l10);
        n10 = this.uniqueProgramId;
        parcel.writeInt(n10);
        n10 = this.availNum;
        parcel.writeInt(n10);
        n10 = this.availsExpected;
        parcel.writeInt(n10);
    }
}

