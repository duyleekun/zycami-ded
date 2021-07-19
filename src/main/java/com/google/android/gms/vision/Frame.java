/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Color
 *  android.media.Image$Plane
 */
package com.google.android.gms.vision;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.Image;
import com.google.android.gms.vision.Frame$Metadata;
import com.google.android.gms.vision.Frame$zza;
import com.google.android.gms.vision.zzb;
import java.nio.ByteBuffer;

public class Frame {
    public static final int ROTATION_0 = 0;
    public static final int ROTATION_180 = 2;
    public static final int ROTATION_270 = 3;
    public static final int ROTATION_90 = 1;
    private final Frame$Metadata zzao;
    private ByteBuffer zzap;
    private Frame$zza zzaq;
    private Bitmap zzar;

    private Frame() {
        Frame$Metadata frame$Metadata;
        this.zzao = frame$Metadata = new Frame$Metadata();
        this.zzap = null;
        this.zzaq = null;
        this.zzar = null;
    }

    public /* synthetic */ Frame(zzb zzb2) {
        this();
    }

    public static /* synthetic */ Bitmap zza(Frame frame, Bitmap bitmap) {
        frame.zzar = bitmap;
        return bitmap;
    }

    public static /* synthetic */ Frame$zza zza(Frame frame, Frame$zza frame$zza) {
        frame.zzaq = frame$zza;
        return frame$zza;
    }

    public static /* synthetic */ ByteBuffer zza(Frame frame) {
        return frame.zzap;
    }

    public static /* synthetic */ ByteBuffer zza(Frame frame, ByteBuffer byteBuffer) {
        frame.zzap = byteBuffer;
        return byteBuffer;
    }

    public static /* synthetic */ Bitmap zzb(Frame frame) {
        return frame.zzar;
    }

    public static /* synthetic */ Frame$zza zzc(Frame frame) {
        return frame.zzaq;
    }

    public Bitmap getBitmap() {
        return this.zzar;
    }

    public ByteBuffer getGrayscaleImageData() {
        Bitmap bitmap = this.zzar;
        if (bitmap != null) {
            int n10 = bitmap.getWidth();
            bitmap = this.zzar;
            int n11 = bitmap.getHeight();
            int n12 = n10 * n11;
            int[] nArray = new int[n12];
            Object object = this.zzar;
            byte by2 = 0;
            float f10 = 0.0f;
            float f11 = 0.0f;
            int n13 = n10;
            object.getPixels(nArray, 0, n10, 0, 0, n10, n11);
            object = new byte[n12];
            for (int i10 = 0; i10 < n12; ++i10) {
                f10 = (float)Color.red((int)nArray[i10]) * 0.299f;
                float f12 = (float)Color.green((int)nArray[i10]) * 0.587f;
                f10 += f12;
                n13 = Color.blue((int)nArray[i10]);
                f12 = n13;
                f11 = 0.114f;
                by2 = (byte)(f10 += (f12 *= f11));
                object[i10] = (Bitmap)by2;
            }
            return ByteBuffer.wrap((byte[])object);
        }
        return this.zzap;
    }

    public Frame$Metadata getMetadata() {
        return this.zzao;
    }

    public Image.Plane[] getPlanes() {
        Frame$zza frame$zza = this.zzaq;
        if (frame$zza == null) {
            return null;
        }
        return frame$zza.getPlanes();
    }
}

