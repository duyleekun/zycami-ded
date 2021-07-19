/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry$1;
import com.google.common.primitives.Floats;

public final class SmtaMetadataEntry
implements Metadata$Entry {
    public static final Parcelable.Creator CREATOR;
    public final float captureFrameRate;
    public final int svcTemporalLayerCount;

    static {
        SmtaMetadataEntry$1 smtaMetadataEntry$1 = new SmtaMetadataEntry$1();
        CREATOR = smtaMetadataEntry$1;
    }

    public SmtaMetadataEntry(float f10, int n10) {
        this.captureFrameRate = f10;
        this.svcTemporalLayerCount = n10;
    }

    private SmtaMetadataEntry(Parcel parcel) {
        int n10;
        float f10;
        this.captureFrameRate = f10 = parcel.readFloat();
        this.svcTemporalLayerCount = n10 = parcel.readInt();
    }

    public /* synthetic */ SmtaMetadataEntry(Parcel parcel, SmtaMetadataEntry$1 smtaMetadataEntry$1) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class<SmtaMetadataEntry> clazz2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (clazz2 = SmtaMetadataEntry.class) == (clazz = object.getClass())) {
            int n10;
            object = (SmtaMetadataEntry)object;
            float f10 = this.captureFrameRate;
            float f11 = ((SmtaMetadataEntry)object).captureFrameRate;
            float f12 = f10 - f11;
            Object object2 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
            if (object2 != false || (object2 = (Object)this.svcTemporalLayerCount) != (n10 = ((SmtaMetadataEntry)object).svcTemporalLayerCount)) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = Floats.hashCode(this.captureFrameRate);
        int n11 = (527 + n10) * 31;
        n10 = this.svcTemporalLayerCount;
        return n11 + n10;
    }

    public String toString() {
        float f10 = this.captureFrameRate;
        int n10 = this.svcTemporalLayerCount;
        StringBuilder stringBuilder = new StringBuilder(73);
        stringBuilder.append("smta: captureFrameRate=");
        stringBuilder.append(f10);
        stringBuilder.append(", svcTemporalLayerCount=");
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        float f10 = this.captureFrameRate;
        parcel.writeFloat(f10);
        n10 = this.svcTemporalLayerCount;
        parcel.writeInt(n10);
    }
}

