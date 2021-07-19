/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.vision.zzt;
import com.google.android.gms.vision.Frame;

public final class zzu
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public int height;
    public int id;
    public int rotation;
    public int width;
    public long zzaz;

    static {
        zzt zzt2 = new zzt();
        CREATOR = zzt2;
    }

    public zzu() {
    }

    public zzu(int n10, int n11, int n12, long l10, int n13) {
        this.width = n10;
        this.height = n11;
        this.id = n12;
        this.zzaz = l10;
        this.rotation = n13;
    }

    public static zzu zzd(Frame frame) {
        long l10;
        int n10;
        zzu zzu2 = new zzu();
        zzu2.width = n10 = frame.getMetadata().getWidth();
        zzu2.height = n10 = frame.getMetadata().getHeight();
        zzu2.rotation = n10 = frame.getMetadata().getRotation();
        zzu2.id = n10 = frame.getMetadata().getId();
        zzu2.zzaz = l10 = frame.getMetadata().getTimestampMillis();
        return zzu2;
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        int n11 = this.width;
        SafeParcelWriter.writeInt(parcel, 2, n11);
        n11 = this.height;
        SafeParcelWriter.writeInt(parcel, 3, n11);
        n11 = this.id;
        SafeParcelWriter.writeInt(parcel, 4, n11);
        long l10 = this.zzaz;
        SafeParcelWriter.writeLong(parcel, 5, l10);
        n11 = this.rotation;
        SafeParcelWriter.writeInt(parcel, 6, n11);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

