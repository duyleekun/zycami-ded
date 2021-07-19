/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.media.Image
 *  android.media.Image$Plane
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.SystemClock
 */
package com.google.mlkit.vision.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_common.zzcu;
import com.google.mlkit.common.sdkinternal.MLTaskInput;
import com.google.mlkit.vision.common.InputImage$zza;
import com.google.mlkit.vision.common.internal.ImageConvertUtils;
import com.google.mlkit.vision.common.internal.ImageUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class InputImage
implements MLTaskInput {
    public static final int IMAGE_FORMAT_BITMAP = 255;
    public static final int IMAGE_FORMAT_NV21 = 17;
    public static final int IMAGE_FORMAT_YUV_420_888 = 35;
    public static final int IMAGE_FORMAT_YV12 = 842094169;
    private volatile Bitmap zza;
    private volatile ByteBuffer zzb;
    private volatile InputImage$zza zzc;
    private final int zzd;
    private final int zze;
    private final int zzf;
    private final int zzg;

    private InputImage(Bitmap bitmap, int n10) {
        int n11;
        int n12;
        Bitmap bitmap2;
        this.zza = bitmap2 = (Bitmap)Preconditions.checkNotNull(bitmap);
        this.zzd = n12 = bitmap.getWidth();
        this.zze = n11 = bitmap.getHeight();
        this.zzf = n10;
        this.zzg = -1;
    }

    private InputImage(ByteBuffer byteBuffer, int n10, int n11, int n12, int n13) {
        ByteBuffer byteBuffer2;
        int n14 = 842094169;
        if (n13 != n14 && n13 != (n14 = 17)) {
            n14 = 0;
            byteBuffer2 = null;
        } else {
            n14 = 1;
        }
        Preconditions.checkArgument(n14 != 0);
        this.zzb = byteBuffer2 = (ByteBuffer)Preconditions.checkNotNull(byteBuffer);
        byteBuffer.rewind();
        this.zzd = n10;
        this.zze = n11;
        this.zzf = n12;
        this.zzg = n13;
    }

    private InputImage(byte[] byArray, int n10, int n11, int n12, int n13) {
        ByteBuffer byteBuffer = ByteBuffer.wrap((byte[])Preconditions.checkNotNull(byArray));
        this(byteBuffer, n10, n11, n12, n13);
    }

    private InputImage(Image.Plane[] planeArray, int n10, int n11, int n12) {
        InputImage$zza inputImage$zza;
        Preconditions.checkNotNull(planeArray);
        this.zzc = inputImage$zza = new InputImage$zza(planeArray);
        this.zzd = n10;
        this.zze = n11;
        this.zzf = n12;
        this.zzg = 35;
    }

    public static InputImage fromBitmap(Bitmap bitmap, int n10) {
        long l10 = SystemClock.elapsedRealtime();
        InputImage inputImage = new InputImage(bitmap, n10);
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 19;
        int n13 = n11 > n12 ? bitmap.getAllocationByteCount() : bitmap.getByteCount();
        zzcu.zza(-1, 1, l10, -1, -1, n13, n10);
        return inputImage;
    }

    public static InputImage fromByteArray(byte[] byArray, int n10, int n11, int n12, int n13) {
        long l10 = SystemClock.elapsedRealtime();
        int n14 = n10;
        InputImage inputImage = new InputImage(byArray, n10, n11, n12, n13);
        n14 = byArray.length;
        zzcu.zza(n13, 2, l10, n11, n10, n14, n12);
        return inputImage;
    }

    public static InputImage fromByteBuffer(ByteBuffer byteBuffer, int n10, int n11, int n12, int n13) {
        long l10 = SystemClock.elapsedRealtime();
        int n14 = n10;
        InputImage inputImage = new InputImage(byteBuffer, n10, n11, n12, n13);
        n14 = byteBuffer.limit();
        zzcu.zza(n13, 3, l10, n11, n10, n14, n12);
        return inputImage;
    }

    public static InputImage fromFilePath(Context context, Uri object) {
        Preconditions.checkNotNull(context, "Please provide a valid Context");
        Preconditions.checkNotNull(object, "Please provide a valid imageUri");
        long l10 = SystemClock.elapsedRealtime();
        ImageUtils.getInstance();
        context = ImageUtils.zza(context.getContentResolver(), object);
        object = new InputImage((Bitmap)context, 0);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        int n12 = n10 > n11 ? context.getAllocationByteCount() : context.getByteCount();
        zzcu.zza(-1, 4, l10, -1, -1, n12, 0);
        return object;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static InputImage fromMediaImage(Image image, int n10) {
        int n11;
        Object object;
        int n12;
        long l10 = SystemClock.elapsedRealtime();
        Object object2 = "Please provide a valid image";
        Preconditions.checkNotNull(image, object2);
        int n13 = 1;
        if (n10 != 0 && n10 != (n12 = 90) && n10 != (n12 = 180) && n10 != (n12 = 270)) {
            n12 = 0;
            object = null;
        } else {
            n12 = n13;
        }
        String string2 = "Invalid rotation. Only 0, 90, 180, 270 are supported currently.";
        Preconditions.checkArgument(n12 != 0, string2);
        n12 = image.getFormat();
        int n14 = 256;
        if (n12 != n14 && (n12 = image.getFormat()) != (n11 = 35)) {
            n13 = 0;
            object2 = null;
        }
        object = "Only JPEG and YUV_420_888 are supported now";
        Preconditions.checkArgument(n13 != 0, object);
        object2 = image.getPlanes();
        n12 = image.getFormat();
        if (n12 == n14) {
            object2 = image.getPlanes()[0].getBuffer();
            n13 = ((Buffer)object2).limit();
            string2 = ImageConvertUtils.getInstance().convertJpegToUpRightBitmap(image, n10);
            object = new InputImage((Bitmap)string2, 0);
        } else {
            n12 = ((Image.Plane[])object2).length;
            string2 = null;
            for (n14 = 0; n14 < n12; ++n14) {
                Object object3 = object2[n14];
                ByteBuffer byteBuffer = object3.getBuffer();
                if (byteBuffer == null) continue;
                object3 = object3.getBuffer();
                ((ByteBuffer)object3).rewind();
            }
            n14 = image.getWidth();
            n11 = image.getHeight();
            object = new InputImage((Image.Plane[])object2, n14, n11, n10);
            object2 = image.getPlanes()[0].getBuffer();
            n13 = ((Buffer)object2).limit() * 3 / 2;
        }
        n11 = n13;
        n13 = image.getFormat();
        n12 = image.getHeight();
        n14 = image.getWidth();
        zzcu.zza(n13, 5, l10, n12, n14, n11, n10);
        return object;
    }

    public Bitmap getBitmapInternal() {
        return this.zza;
    }

    public ByteBuffer getByteBuffer() {
        return this.zzb;
    }

    public int getFormat() {
        return this.zzg;
    }

    public int getHeight() {
        return this.zze;
    }

    public Image.Plane[] getPlanes() {
        InputImage$zza inputImage$zza = this.zzc;
        if (inputImage$zza == null) {
            return null;
        }
        return this.zzc.zza();
    }

    public int getRotationDegrees() {
        return this.zzf;
    }

    public int getWidth() {
        return this.zzd;
    }
}

