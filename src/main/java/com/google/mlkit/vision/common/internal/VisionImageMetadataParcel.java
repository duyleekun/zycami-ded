/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.mlkit.vision.common.internal;

import android.graphics.Matrix;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.mlkit.vision.common.internal.zze;

public class VisionImageMetadataParcel
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public final int height;
    public final int rotation;
    public final long timestampMillis;
    public final int width;
    private final int zza;

    static {
        zze zze2 = new zze();
        CREATOR = zze2;
    }

    public VisionImageMetadataParcel(int n10, int n11, int n12, long l10, int n13) {
        this.width = n10;
        this.height = n11;
        this.zza = n12;
        this.timestampMillis = l10;
        this.rotation = n13;
    }

    public Matrix getUprightRotationMatrix() {
        int n10 = this.rotation;
        if (n10 == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        float f10 = -this.width;
        float f11 = 2.0f;
        int n11 = -this.height;
        float f12 = (float)n11 / f11;
        matrix.postTranslate(f10 /= f11, f12);
        f10 = this.rotation * 90;
        matrix.postRotate(f10);
        int n12 = this.rotation % 2;
        if (n12 != 0) {
            n12 = 1;
            f10 = Float.MIN_VALUE;
        } else {
            n12 = 0;
            f10 = 0.0f;
        }
        n11 = n12 != 0 ? this.height : this.width;
        n12 = n12 != 0 ? this.width : this.height;
        f12 = (float)n11 / f11;
        f10 = (float)n12 / f11;
        matrix.postTranslate(f12, f10);
        return matrix;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        int n11 = this.width;
        SafeParcelWriter.writeInt(parcel, 1, n11);
        n11 = this.height;
        SafeParcelWriter.writeInt(parcel, 2, n11);
        n11 = this.zza;
        SafeParcelWriter.writeInt(parcel, 3, n11);
        long l10 = this.timestampMillis;
        SafeParcelWriter.writeLong(parcel, 4, l10);
        n11 = this.rotation;
        SafeParcelWriter.writeInt(parcel, 5, n11);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

