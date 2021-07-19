/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.Rect
 *  android.graphics.YuvImage
 *  android.util.SparseArray
 */
package com.google.android.gms.vision.text;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzah;
import com.google.android.gms.internal.vision.zzaj;
import com.google.android.gms.internal.vision.zzan;
import com.google.android.gms.internal.vision.zzu;
import com.google.android.gms.internal.vision.zzv;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.Frame$Metadata;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.zzb;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public final class TextRecognizer
extends Detector {
    private final zzan zzel;

    private TextRecognizer() {
        IllegalStateException illegalStateException = new IllegalStateException("Default constructor called");
        throw illegalStateException;
    }

    private TextRecognizer(zzan zzan2) {
        this.zzel = zzan2;
    }

    public /* synthetic */ TextRecognizer(zzan zzan2, zzb zzb2) {
        this(zzan2);
    }

    public final SparseArray detect(Frame object) {
        Object object2 = new Rect();
        zzaj zzaj2 = new zzaj((Rect)object2);
        if (object != null) {
            int n10;
            int n11;
            int n12;
            int n13;
            Object object3;
            Object object4;
            int n15;
            int n16;
            Object object5;
            object2 = zzu.zzd((Frame)object);
            Object object6 = ((Frame)object).getBitmap();
            int n17 = 0;
            if (object6 != null) {
                object6 = ((Frame)object).getBitmap();
            } else {
                YuvImage yuvImage;
                int n14;
                object6 = ((Frame)object).getMetadata();
                object5 = ((Frame)object).getGrayscaleImageData();
                n16 = object6.getFormat();
                n15 = object2.width;
                int n18 = object2.height;
                boolean n142 = ((ByteBuffer)object5).hasArray();
                if (n142 && (n14 = ((ByteBuffer)object5).arrayOffset()) == 0) {
                    object4 = object5 = (Object)((ByteBuffer)object5).array();
                } else {
                    int n19 = ((Buffer)object5).capacity();
                    object3 = new byte[n19];
                    ((ByteBuffer)object5).get((byte[])object3);
                    object4 = object3;
                }
                object5 = new ByteArrayOutputStream();
                object3 = yuvImage;
                n13 = n15;
                n12 = n18;
                yuvImage = new YuvImage((byte[])object4, n16, n15, n18, null);
                object3 = new Rect(0, 0, n15, n18);
                n15 = 100;
                yuvImage.compressToJpeg((Rect)object3, n15, (OutputStream)object5);
                object6 = ((ByteArrayOutputStream)object5).toByteArray();
                n11 = ((Bitmap)object6).length;
                object6 = BitmapFactory.decodeByteArray((byte[])object6, (int)0, (int)n11);
            }
            object6 = zzv.zzb(object6, (zzu)object2);
            object5 = zzaj2.zzex;
            n11 = object5.isEmpty();
            if (n11 == 0) {
                object5 = zzaj2.zzex;
                object3 = ((Frame)object).getMetadata();
                int n20 = ((Frame$Metadata)object3).getWidth();
                object = ((Frame)object).getMetadata();
                int n21 = ((Frame$Metadata)object).getHeight();
                n10 = object2.rotation;
                n16 = 1;
                if (n10 != n16) {
                    n16 = 2;
                    if (n10 != n16) {
                        n21 = 3;
                        if (n10 == n21) {
                            n10 = ((Rect)object5).top;
                            n16 = ((Rect)object5).right;
                            n16 = n20 - n16;
                            n13 = ((Rect)object5).bottom;
                            n11 = ((Rect)object5).left;
                            int n22 = n20 - n11;
                            object5 = object = new Rect(n10, n16, n13, n22);
                        }
                    } else {
                        n16 = ((Rect)object5).right;
                        n16 = n20 - n16;
                        n13 = ((Rect)object5).bottom;
                        n13 = n21 - n13;
                        n12 = ((Rect)object5).left;
                        int n23 = n20 - n12;
                        n11 = ((Rect)object5).top;
                        object5 = object4 = new Rect(n16, n13, n23, n21 -= n11);
                    }
                } else {
                    n10 = ((Rect)object5).bottom;
                    n10 = n21 - n10;
                    n16 = ((Rect)object5).left;
                    n13 = ((Rect)object5).top;
                    n11 = ((Rect)object5).right;
                    object5 = object3 = new Rect(n10, n16, n21 -= n13, n11);
                }
                object = zzaj2.zzex;
                object.set((Rect)object5);
            }
            object2.rotation = 0;
            object = this.zzel.zza((Bitmap)object6, (zzu)object2, zzaj2);
            zzaj2 = new SparseArray();
            int n24 = ((Object)object).length;
            object6 = null;
            for (n15 = 0; n15 < n24; ++n15) {
                object5 = object[n15];
                int n25 = ((zzah)object5).zzev;
                object3 = (SparseArray)zzaj2.get(n25);
                if (object3 == null) {
                    object3 = new SparseArray();
                    n10 = ((zzah)object5).zzev;
                    zzaj2.append(n10, object3);
                }
                n10 = ((zzah)object5).zzew;
                object3.append(n10, object5);
            }
            n24 = zzaj2.size();
            object = new SparseArray(n24);
            while (n17 < (n24 = zzaj2.size())) {
                n24 = zzaj2.keyAt(n17);
                object5 = (SparseArray)zzaj2.valueAt(n17);
                object6 = new TextBlock((SparseArray)object5);
                object.append(n24, object6);
                ++n17;
            }
            return object;
        }
        object = new IllegalArgumentException("No frame supplied.");
        throw object;
    }

    public final boolean isOperational() {
        return this.zzel.isOperational();
    }

    public final void release() {
        super.release();
        this.zzel.zzq();
    }
}

