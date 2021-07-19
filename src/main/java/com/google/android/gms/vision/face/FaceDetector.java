/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Color
 *  android.media.Image$Plane
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.util.SparseArray
 */
package com.google.android.gms.vision.face;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.Image;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzu;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.internal.client.zzb;
import com.google.android.gms.vision.face.internal.client.zzf;
import com.google.android.gms.vision.face.zza;
import com.google.android.gms.vision.zzc;
import java.nio.ByteBuffer;
import java.util.HashSet;

public final class FaceDetector
extends Detector {
    public static final int ACCURATE_MODE = 1;
    public static final int ALL_CLASSIFICATIONS = 1;
    public static final int ALL_LANDMARKS = 1;
    public static final int CONTOUR_LANDMARKS = 2;
    public static final int FAST_MODE = 0;
    public static final int NO_CLASSIFICATIONS = 0;
    public static final int NO_LANDMARKS = 0;
    public static final int SELFIE_MODE = 2;
    private final Object lock;
    private final zzc zzcr;
    private final zzb zzcs;
    private boolean zzct;

    private FaceDetector() {
        Object object = new zzc();
        this.zzcr = object;
        this.lock = object = new Object();
        this.zzct = true;
        object = new IllegalStateException("Default constructor called");
        throw object;
    }

    private FaceDetector(zzb zzb2) {
        Object object = new zzc();
        this.zzcr = object;
        this.lock = object = new Object();
        this.zzct = true;
        this.zzcs = zzb2;
    }

    public /* synthetic */ FaceDetector(zzb zzb2, zza zza2) {
        this(zzb2);
    }

    private static boolean zza(zzf object) {
        int n10;
        int n11 = ((zzf)object).mode;
        int n12 = 0;
        String string2 = "FaceDetector";
        int n13 = 1;
        float f10 = Float.MIN_VALUE;
        int n14 = 2;
        if (n11 != n14 && (n11 = ((zzf)object).landmarkType) == n14) {
            Log.e((String)string2, (String)"Contour is not supported for non-SELFIE mode.");
            n11 = 0;
        } else {
            n11 = n13;
        }
        int n15 = ((zzf)object).landmarkType;
        if (n15 == n14 && (n10 = ((zzf)object).zzcw) == n13) {
            object = "Classification is not supported with contour.";
            Log.e((String)string2, (String)object);
        } else {
            n12 = n11;
        }
        return n12 != 0;
    }

    public static /* synthetic */ boolean zzb(zzf zzf2) {
        return FaceDetector.zza(zzf2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final SparseArray detect(Frame object) {
        byte by2;
        int n10;
        Face face;
        int n11;
        int n12;
        Object object2;
        zzb zzb2;
        Object object3;
        if (object == null) {
            object = new IllegalArgumentException("No frame supplied.");
            throw object;
        }
        int n13 = Build.VERSION.SDK_INT;
        int n14 = 19;
        int n15 = 0;
        if (n13 >= n14 && (object3 = object.getPlanes()) != null && (n13 = ((Bitmap)(object3 = object.getPlanes())).length) == (n14 = 3)) {
            object3 = this.lock;
            synchronized (object3) {
                n14 = (int)(this.zzct ? 1 : 0);
                if (n14 == 0) {
                    String string2 = "Cannot use detector after release()";
                    object = new IllegalStateException(string2);
                    throw object;
                }
                zzb2 = this.zzcs;
                object2 = object.getPlanes();
                object = zzu.zzd((Frame)object);
                object = zzb2.zza((Image.Plane[])object2, (zzu)object);
            }
        } else {
            object3 = object.getBitmap();
            if (object3 != null) {
                object3 = object.getBitmap();
                n14 = object3.getWidth();
                n12 = object3.getHeight();
                n11 = n14 * n12;
                int n16 = (n14 + 1) / 2;
                n12 = (n12 + 1) / 2;
                n12 = (n16 * n12 << 1) + n11;
                object2 = ByteBuffer.allocateDirect(n12);
                face = null;
                n10 = n11;
                for (n16 = 0; n16 < n11; ++n16) {
                    by2 = n16 % n14;
                    int n17 = n16 / n14;
                    int n18 = object3.getPixel((int)by2, n17);
                    int n19 = Color.red((int)n18);
                    int n20 = Color.green((int)n18);
                    n18 = Color.blue((int)n18);
                    float f10 = n19;
                    float f11 = 0.299f * f10;
                    float f12 = n20;
                    float f13 = 0.587f * f12;
                    f11 += f13;
                    float f14 = n18;
                    f13 = 0.114f * f14;
                    int n21 = (int)(f11 += f13);
                    ((ByteBuffer)object2).put(n16, (byte)n21);
                    if ((n17 %= 2) != 0 || (by2 %= 2) != 0) continue;
                    float f15 = -0.169f * f10;
                    float f16 = -0.331f * f12;
                    f15 += f16;
                    f16 = 0.5f;
                    f11 = f14 * f16;
                    f15 += f11;
                    n21 = 0x43000000;
                    f11 = 128.0f;
                    f10 *= f16;
                    f10 += (f12 *= -0.419f);
                    f16 = -0.081f;
                    f10 = f10 + (f14 *= f16) + f11;
                    n17 = n10 + 1;
                    by2 = (byte)(f15 += f11);
                    ((ByteBuffer)object2).put(n10, by2);
                    n10 = n17 + 1;
                    by2 = (byte)f10;
                    ((ByteBuffer)object2).put(n17, by2);
                }
            } else {
                object2 = object.getGrayscaleImageData();
            }
            object3 = this.lock;
            synchronized (object3) {
                n14 = (int)(this.zzct ? 1 : 0);
                if (n14 == 0) {
                    String string3 = "Cannot use detector after release()";
                    object = new IllegalStateException(string3);
                    throw object;
                }
                zzb2 = this.zzcs;
                object = zzu.zzd((Frame)object);
                object = zzb2.zzb((ByteBuffer)object2, (zzu)object);
            }
        }
        object3 = new HashSet();
        n12 = ((Face[])object).length;
        zzb2 = new SparseArray(n12);
        n12 = ((Face[])object).length;
        n11 = 0;
        while (n15 < n12) {
            face = object[n15];
            n10 = face.getId();
            n11 = Math.max(n11, n10);
            Object object4 = n10;
            by2 = (byte)(object3.contains(object4) ? 1 : 0);
            if (by2 != 0) {
                n11 = n10 = n11 + 1;
            }
            object4 = n10;
            object3.add(object4);
            object4 = this.zzcr;
            n10 = ((zzc)object4).zzb(n10);
            zzb2.append(n10, face);
            ++n15;
        }
        return zzb2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void finalize() {
        block6: {
            String string2;
            String string3;
            try {
                Object object = this.lock;
                synchronized (object) {
                    boolean bl2 = this.zzct;
                    if (!bl2) break block6;
                    string3 = "FaceDetector";
                    string2 = "FaceDetector was not released with FaceDetector.release()";
                }
            }
            catch (Throwable throwable) {
                super.finalize();
                throw throwable;
            }
            {
                Log.w((String)string3, (String)string2);
                ((Detector)this).release();
            }
        }
        super.finalize();
    }

    public final boolean isOperational() {
        return this.zzcs.isOperational();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void release() {
        super.release();
        Object object = this.lock;
        synchronized (object) {
            boolean bl2 = this.zzct;
            if (!bl2) {
                return;
            }
            zzb zzb2 = this.zzcs;
            zzb2.zzq();
            bl2 = false;
            zzb2 = null;
            this.zzct = false;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean setFocus(int n10) {
        n10 = this.zzcr.zzc(n10);
        Object object = this.lock;
        synchronized (object) {
            boolean bl2 = this.zzct;
            if (bl2) {
                zzb zzb2 = this.zzcs;
                return (int)(zzb2.zzd(n10) ? 1 : 0) != 0;
            }
            String string2 = "Cannot use detector after release()";
            RuntimeException runtimeException = new RuntimeException(string2);
            throw runtimeException;
        }
    }
}

