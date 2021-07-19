/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;

public class EventMessage$1
implements Parcelable.Creator {
    public EventMessage createFromParcel(Parcel parcel) {
        EventMessage eventMessage = new EventMessage(parcel);
        return eventMessage;
    }

    public EventMessage[] newArray(int n10) {
        return new EventMessage[n10];
    }
}

