/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Matrix
 */
package com.google.android.gms.internal.vision;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.google.android.gms.internal.vision.zzu;

public final class zzv {
    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public static Bitmap zzb(Bitmap object, zzu zzu2) {
        void var0_3;
        int n10;
        int n11;
        int n12;
        void var1_4;
        int n13;
        int n14;
        block7: {
            float f10;
            int n15;
            Matrix matrix;
            block6: {
                block8: {
                    n14 = object.getWidth();
                    n13 = object.getHeight();
                    n12 = var1_4.rotation;
                    n11 = 3;
                    n10 = 1;
                    if (n12 == 0) break block7;
                    matrix = new Matrix();
                    n12 = var1_4.rotation;
                    if (n12 == 0) break block8;
                    if (n12 != n10) {
                        n15 = 2;
                        if (n12 != n15) {
                            if (n12 != n11) {
                                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported rotation degree.");
                                throw illegalArgumentException;
                            }
                            n12 = 270;
                            f10 = 3.78E-43f;
                            break block6;
                        } else {
                            n12 = 180;
                            f10 = 2.52E-43f;
                        }
                        break block6;
                    } else {
                        n12 = 90;
                        f10 = 1.26E-43f;
                    }
                    break block6;
                }
                n12 = 0;
                f10 = 0.0f;
            }
            f10 = n12;
            matrix.postRotate(f10);
            n15 = 0;
            Bitmap bitmap = Bitmap.createBitmap((Bitmap)object, (int)0, (int)0, (int)n14, (int)n13, (Matrix)matrix, (boolean)false);
        }
        if ((n12 = var1_4.rotation) == n10 || n12 == n11) {
            var1_4.width = n13;
            var1_4.height = n14;
        }
        return var0_3;
    }
}

