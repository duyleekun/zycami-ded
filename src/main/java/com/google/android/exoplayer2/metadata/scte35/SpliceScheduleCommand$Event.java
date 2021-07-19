/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand$ComponentSplice;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceScheduleCommand$Event {
    public final boolean autoReturn;
    public final int availNum;
    public final int availsExpected;
    public final long breakDurationUs;
    public final List componentSpliceList;
    public final boolean outOfNetworkIndicator;
    public final boolean programSpliceFlag;
    public final boolean spliceEventCancelIndicator;
    public final long spliceEventId;
    public final int uniqueProgramId;
    public final long utcSpliceTime;

    private SpliceScheduleCommand$Event(long l10, boolean bl2, boolean bl3, boolean bl4, List list, long l11, boolean bl5, long l12, int n10, int n11, int n12) {
        List list2;
        this.spliceEventId = l10;
        this.spliceEventCancelIndicator = bl2;
        this.outOfNetworkIndicator = bl3;
        this.programSpliceFlag = bl4;
        this.componentSpliceList = list2 = Collections.unmodifiableList(list);
        this.utcSpliceTime = l11;
        this.autoReturn = bl5;
        this.breakDurationUs = l12;
        this.uniqueProgramId = n10;
        this.availNum = n11;
        this.availsExpected = n12;
    }

    private SpliceScheduleCommand$Event(Parcel parcel) {
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
        n11 = parcel.readInt();
        ArrayList<SpliceScheduleCommand$ComponentSplice> arrayList = new ArrayList<SpliceScheduleCommand$ComponentSplice>(n11);
        for (int i10 = 0; i10 < n11; ++i10) {
            SpliceScheduleCommand$ComponentSplice spliceScheduleCommand$ComponentSplice = SpliceScheduleCommand$ComponentSplice.access$000(parcel);
            arrayList.add(spliceScheduleCommand$ComponentSplice);
        }
        this.componentSpliceList = list = Collections.unmodifiableList(arrayList);
        this.utcSpliceTime = l10 = parcel.readLong();
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

    public static /* synthetic */ SpliceScheduleCommand$Event access$300(Parcel parcel) {
        return SpliceScheduleCommand$Event.createFromParcel(parcel);
    }

    public static /* synthetic */ SpliceScheduleCommand$Event access$400(ParsableByteArray parsableByteArray) {
        return SpliceScheduleCommand$Event.parseFromSection(parsableByteArray);
    }

    public static /* synthetic */ void access$500(SpliceScheduleCommand$Event spliceScheduleCommand$Event, Parcel parcel) {
        spliceScheduleCommand$Event.writeToParcel(parcel);
    }

    private static SpliceScheduleCommand$Event createFromParcel(Parcel parcel) {
        SpliceScheduleCommand$Event spliceScheduleCommand$Event = new SpliceScheduleCommand$Event(parcel);
        return spliceScheduleCommand$Event;
    }

    private static SpliceScheduleCommand$Event parseFromSection(ParsableByteArray parsableByteArray) {
        long l10;
        int n10;
        int n11;
        ArrayList arrayList;
        long l11;
        int n12;
        int n13;
        int n14;
        int n15;
        SpliceScheduleCommand$Event spliceScheduleCommand$Event;
        int n16;
        long l12 = parsableByteArray.readUnsignedInt();
        int n17 = parsableByteArray.readUnsignedByte() & 0x80;
        int n18 = n17 != 0 ? 1 : 0;
        ArrayList<SpliceScheduleCommand$ComponentSplice> arrayList2 = new ArrayList<SpliceScheduleCommand$ComponentSplice>();
        if (n18 == 0) {
            float f10;
            SpliceScheduleCommand$ComponentSplice spliceScheduleCommand$ComponentSplice;
            long l13;
            float f11;
            float f12;
            int n19 = parsableByteArray.readUnsignedByte();
            n16 = n19 & 0x80;
            if (n16) {
                n16 = 1;
                f12 = Float.MIN_VALUE;
            } else {
                n16 = 0;
                f12 = 0.0f;
            }
            int n20 = n19 & 0x40;
            if (n20 != 0) {
                n20 = 1;
                f11 = Float.MIN_VALUE;
            } else {
                n20 = 0;
                f11 = 0.0f;
            }
            int n21 = 32;
            n19 = (n19 &= n21) != 0 ? 1 : 0;
            long l14 = n20 != 0 ? parsableByteArray.readUnsignedInt() : -9223372036854775807L;
            if (n20 == 0) {
                n17 = parsableByteArray.readUnsignedByte();
                ArrayList<SpliceScheduleCommand$ComponentSplice> arrayList3 = new ArrayList<SpliceScheduleCommand$ComponentSplice>(n17);
                spliceScheduleCommand$Event = null;
                for (int i10 = 0; i10 < n17; ++i10) {
                    n15 = parsableByteArray.readUnsignedByte();
                    l13 = parsableByteArray.readUnsignedInt();
                    spliceScheduleCommand$ComponentSplice = new SpliceScheduleCommand$ComponentSplice(n15, l13, null);
                    arrayList3.add(spliceScheduleCommand$ComponentSplice);
                    n21 = 32;
                }
                arrayList2 = arrayList3;
            }
            if (n19 != 0) {
                float f13;
                int n22;
                long l15;
                n15 = parsableByteArray.readUnsignedByte();
                long l16 = n15;
                l13 = 0x80L & l16;
                long l17 = l13 - (l15 = 0L);
                Object object = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
                if (object != false) {
                    n22 = 1;
                    f13 = Float.MIN_VALUE;
                } else {
                    n22 = 0;
                    f13 = 0.0f;
                }
                l16 &= 1L;
                object = 32;
                l16 <<= object;
                l13 = parsableByteArray.readUnsignedInt();
                l16 = (l16 | l13) * 1000L;
                l13 = l16 / (long)90;
                n14 = n22;
                f10 = f13;
            } else {
                n14 = 0;
                f10 = 0.0f;
                spliceScheduleCommand$ComponentSplice = null;
                l13 = -9223372036854775807L;
            }
            n15 = parsableByteArray.readUnsignedShort();
            n19 = parsableByteArray.readUnsignedByte();
            n21 = parsableByteArray.readUnsignedByte();
            n13 = n20;
            float f14 = f11;
            n12 = n21;
            l11 = l13;
            arrayList = arrayList2;
            n11 = n15;
            n10 = n19;
            l10 = l14;
            int n23 = n16;
            float f15 = f12;
            n16 = n14;
            f12 = f10;
            n14 = n23;
            f10 = f15;
        } else {
            arrayList = arrayList2;
            n14 = 0;
            float f16 = 0.0f;
            Object var20_20 = null;
            l10 = -9223372036854775807L;
            n16 = 0;
            float f17 = 0.0f;
            l11 = -9223372036854775807L;
            n11 = 0;
            n10 = 0;
            n12 = 0;
            Object var14_14 = null;
            n13 = 0;
            float f18 = 0.0f;
        }
        arrayList2 = spliceScheduleCommand$Event;
        n15 = n18;
        n18 = n13;
        spliceScheduleCommand$Event = new SpliceScheduleCommand$Event(l12, n15 != 0, n14 != 0, n13 != 0, arrayList, l10, n16 != 0, l11, n11, n10, n12);
        return spliceScheduleCommand$Event;
    }

    private void writeToParcel(Parcel parcel) {
        long l10 = this.spliceEventId;
        parcel.writeLong(l10);
        int n10 = (int)(this.spliceEventCancelIndicator ? 1 : 0);
        parcel.writeByte((byte)n10);
        n10 = (byte)(this.outOfNetworkIndicator ? 1 : 0);
        parcel.writeByte((byte)n10);
        n10 = (byte)(this.programSpliceFlag ? 1 : 0);
        parcel.writeByte((byte)n10);
        List list = this.componentSpliceList;
        n10 = list.size();
        parcel.writeInt(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            SpliceScheduleCommand$ComponentSplice spliceScheduleCommand$ComponentSplice = (SpliceScheduleCommand$ComponentSplice)this.componentSpliceList.get(i10);
            SpliceScheduleCommand$ComponentSplice.access$200(spliceScheduleCommand$ComponentSplice, parcel);
        }
        l10 = this.utcSpliceTime;
        parcel.writeLong(l10);
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

