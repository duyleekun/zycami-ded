/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.media.Image$Plane
 */
package com.google.android.gms.vision;

import android.graphics.Bitmap;
import android.media.Image;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.Frame$Metadata;
import com.google.android.gms.vision.Frame$zza;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class Frame$Builder {
    private final Frame zzax;

    public Frame$Builder() {
        Frame frame;
        this.zzax = frame = new Frame(null);
    }

    public Frame build() {
        Object object = Frame.zza(this.zzax);
        if (object == null && (object = Frame.zzb(this.zzax)) == null && (object = Frame.zzc(this.zzax)) == null) {
            object = new IllegalStateException("Missing image data.  Call either setBitmap or setImageData to specify the image");
            throw object;
        }
        return this.zzax;
    }

    public Frame$Builder setBitmap(Bitmap object) {
        int n10 = object.getWidth();
        int n11 = object.getHeight();
        Frame.zza(this.zzax, object);
        object = this.zzax.getMetadata();
        Frame$Metadata.zza((Frame$Metadata)object, n10);
        Frame$Metadata.zzb((Frame$Metadata)object, n11);
        return this;
    }

    public Frame$Builder setId(int n10) {
        Frame$Metadata.zzd(this.zzax.getMetadata(), n10);
        return this;
    }

    public Frame$Builder setImageData(ByteBuffer object, int n10, int n11, int n12) {
        if (object != null) {
            int n13;
            int n14 = ((Buffer)object).capacity();
            if (n14 >= (n13 = n10 * n11)) {
                n14 = 16;
                if (n12 != n14 && n12 != (n14 = 17) && n12 != (n14 = 842094169)) {
                    StringBuilder stringBuilder = new StringBuilder(37);
                    stringBuilder.append("Unsupported image format: ");
                    stringBuilder.append(n12);
                    String string2 = stringBuilder.toString();
                    object = new IllegalArgumentException(string2);
                    throw object;
                }
                Frame.zza(this.zzax, (ByteBuffer)object);
                object = this.zzax.getMetadata();
                Frame$Metadata.zza((Frame$Metadata)object, n10);
                Frame$Metadata.zzb((Frame$Metadata)object, n11);
                Frame$Metadata.zzc((Frame$Metadata)object, n12);
                return this;
            }
            object = new IllegalArgumentException("Invalid image data size.");
            throw object;
        }
        object = new IllegalArgumentException("Null image data supplied.");
        throw object;
    }

    public Frame$Builder setPlanes(Image.Plane[] object, int n10, int n11, int n12) {
        if (object != null) {
            int n13 = ((Image.Plane[])object).length;
            int n14 = 3;
            if (n13 == n14) {
                Object object2 = object[0].getBuffer();
                n13 = ((Buffer)object2).capacity();
                if (n13 >= (n14 = n10 * n11)) {
                    object2 = this.zzax;
                    Frame$zza frame$zza = new Frame$zza((Image.Plane[])object);
                    Frame.zza((Frame)object2, frame$zza);
                    object = this.zzax.getMetadata();
                    Frame$Metadata.zza((Frame$Metadata)object, n10);
                    Frame$Metadata.zzb((Frame$Metadata)object, n11);
                    Frame$Metadata.zzc((Frame$Metadata)object, n12);
                    return this;
                }
                object = new IllegalArgumentException("Invalid image data size.");
                throw object;
            }
            object = new IllegalArgumentException("Only android.graphics.ImageFormat#YUV_420_888 is supported which should have 3 planes.");
            throw object;
        }
        object = new IllegalArgumentException("Null image data supplied.");
        throw object;
    }

    public Frame$Builder setRotation(int n10) {
        Frame$Metadata.zze(this.zzax.getMetadata(), n10);
        return this;
    }

    public Frame$Builder setTimestampMillis(long l10) {
        Frame$Metadata.zza(this.zzax.getMetadata(), l10);
        return this;
    }
}

