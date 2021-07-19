/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.util.SparseArray
 */
package com.google.android.gms.vision.barcode;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzm;
import com.google.android.gms.internal.vision.zzu;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.zzc;
import java.nio.ByteBuffer;

public final class BarcodeDetector
extends Detector {
    private final zzm zzbr;

    private BarcodeDetector() {
        IllegalStateException illegalStateException = new IllegalStateException("Default constructor called");
        throw illegalStateException;
    }

    private BarcodeDetector(zzm zzm2) {
        this.zzbr = zzm2;
    }

    public /* synthetic */ BarcodeDetector(zzm zzm2, zzc zzc2) {
        this(zzm2);
    }

    /*
     * WARNING - void declaration
     */
    public final SparseArray detect(Frame object) {
        if (object != null) {
            void var1_7;
            zzu zzu2 = zzu.zzd((Frame)object);
            Object object2 = ((Frame)object).getBitmap();
            if (object2 != null) {
                object2 = this.zzbr;
                Bitmap bitmap = ((Frame)object).getBitmap();
                Barcode[] barcodeArray = ((zzm)object2).zza(bitmap, zzu2);
                if (barcodeArray == null) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Internal barcode detector error; check logcat output.");
                    throw illegalArgumentException;
                }
            } else {
                ByteBuffer byteBuffer = ((Frame)object).getGrayscaleImageData();
                object2 = this.zzbr;
                Barcode[] barcodeArray = ((zzm)object2).zza(byteBuffer, zzu2);
            }
            int n10 = ((void)var1_7).length;
            zzu2 = new SparseArray(n10);
            for (void var6_13 : var1_7) {
                String string2 = var6_13.rawValue;
                int n11 = string2.hashCode();
                zzu2.append(n11, var6_13);
            }
            return zzu2;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No frame supplied.");
        throw illegalArgumentException;
    }

    public final boolean isOperational() {
        return this.zzbr.isOperational();
    }

    public final void release() {
        super.release();
        this.zzbr.zzq();
    }
}

