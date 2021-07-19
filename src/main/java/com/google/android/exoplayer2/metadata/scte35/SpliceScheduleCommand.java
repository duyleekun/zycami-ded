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
import com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand$1;
import com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand$Event;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceScheduleCommand
extends SpliceCommand {
    public static final Parcelable.Creator CREATOR;
    public final List events;

    static {
        SpliceScheduleCommand$1 spliceScheduleCommand$1 = new SpliceScheduleCommand$1();
        CREATOR = spliceScheduleCommand$1;
    }

    private SpliceScheduleCommand(Parcel object) {
        int n10 = object.readInt();
        ArrayList<SpliceScheduleCommand$Event> arrayList = new ArrayList<SpliceScheduleCommand$Event>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            SpliceScheduleCommand$Event spliceScheduleCommand$Event = SpliceScheduleCommand$Event.access$300(object);
            arrayList.add(spliceScheduleCommand$Event);
        }
        object = Collections.unmodifiableList(arrayList);
        this.events = object;
    }

    public /* synthetic */ SpliceScheduleCommand(Parcel parcel, SpliceScheduleCommand$1 spliceScheduleCommand$1) {
        this(parcel);
    }

    private SpliceScheduleCommand(List list) {
        this.events = list = Collections.unmodifiableList(list);
    }

    public static SpliceScheduleCommand parseFromSection(ParsableByteArray object) {
        int n10 = ((ParsableByteArray)object).readUnsignedByte();
        ArrayList<SpliceScheduleCommand$Event> arrayList = new ArrayList<SpliceScheduleCommand$Event>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            SpliceScheduleCommand$Event spliceScheduleCommand$Event = SpliceScheduleCommand$Event.access$400((ParsableByteArray)object);
            arrayList.add(spliceScheduleCommand$Event);
        }
        object = new SpliceScheduleCommand(arrayList);
        return object;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        List list = this.events;
        n10 = list.size();
        parcel.writeInt(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            SpliceScheduleCommand$Event spliceScheduleCommand$Event = (SpliceScheduleCommand$Event)this.events.get(i10);
            SpliceScheduleCommand$Event.access$500(spliceScheduleCommand$Event, parcel);
        }
    }
}

