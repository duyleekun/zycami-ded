/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.graphics.Bitmap
 *  android.graphics.Matrix
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.provider.MediaStore$Images$Media
 */
package com.google.mlkit.vision.common.internal;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_vision_common.zzn;
import com.google.mlkit.vision.common.InputImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;

public class ImageUtils {
    private static final GmsLogger zza;
    private static ImageUtils zzb;

    static {
        Object object = new GmsLogger("MLKitImageUtils", "");
        zza = object;
        zzb = object = new ImageUtils();
    }

    private ImageUtils() {
    }

    public static ImageUtils getInstance() {
        return zzb;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static Bitmap zza(ContentResolver var0, Uri var1_2) {
        block31: {
            block30: {
                var2_3 = MediaStore.Images.Media.getBitmap((ContentResolver)var0, (Uri)var1_2 /* !! */ );
                var3_4 = ImageUtils.zzb(var0, var1_2 /* !! */ );
                var4_5 = new Matrix();
                var5_6 = var2_3.getWidth();
                var6_7 = var2_3.getHeight();
                var7_8 = -1028390912;
                var8_9 = -90.0f;
                var9_10 = 90.0f;
                var10_11 = -1.0f;
                var11_12 = 1065353216 != 0;
                var12_13 = 1.0f;
                switch (var3_4) {
                    default: {
                        var3_4 = 0;
                        var13_14 = 0.0f;
                        var0 = null;
lbl21:
                        // 2 sources

                        while (true) {
                            var14_16 /* !! */  = var0;
                            break block30;
                            break;
                        }
                    }
                    case 8: {
                        var4_5.postRotate(var8_9);
                        ** GOTO lbl61
                    }
                    case 7: {
                        var4_5.postRotate(var8_9);
                        var4_5.postScale(var10_11, var12_13);
                        ** GOTO lbl61
                    }
                    case 6: {
                        var4_5.postRotate(var9_10);
                        ** GOTO lbl61
                    }
                    case 5: {
                        var4_5.postRotate(var9_10);
                        var4_5.postScale(var10_11, var12_13);
                        ** GOTO lbl61
                    }
                    case 4: {
                        var4_5.postScale(var12_13, var10_11);
                        ** GOTO lbl61
                    }
                    case 3: {
                        var3_4 = 0x43340000;
                        var13_15 = 180.0f;
                        var4_5.postRotate(var13_15);
lbl61:
                        // 6 sources

                        var14_16 /* !! */  = var4_5;
                        break block30;
                    }
                    case 2: 
                }
                try {
                    var0 = new Matrix();
                }
                catch (FileNotFoundException var0_1) {
                    var4_5 = ImageUtils.zza;
                    var1_2 /* !! */  = String.valueOf(var1_2 /* !! */ );
                    var7_8 = String.valueOf(var1_2 /* !! */ ).length() + 21;
                    var15_17 = new StringBuilder(var7_8);
                    var15_17.append("Could not open file: ");
                    var15_17.append((String)var1_2 /* !! */ );
                    var1_2 /* !! */  = var15_17.toString();
                    var4_5.e("MLKitImageUtils", (String)var1_2 /* !! */ , var0_1);
                    throw var0_1;
                }
                var0.postScale(var10_11, var12_13);
                ** continue;
            }
            if (var14_16 /* !! */  != null) {
                var7_8 = 0;
                var8_9 = 0.0f;
                var9_10 = 0.0f;
                var15_17 = null;
                var11_12 = true;
                var12_13 = 1.4E-45f;
                var4_5 = var2_3;
                var0 = Bitmap.createBitmap((Bitmap)var2_3, (int)0, (int)0, (int)var5_6, (int)var6_7, (Matrix)var14_16 /* !! */ , (boolean)var11_12);
                if (var2_3 == var0) break block31;
                var2_3.recycle();
                var2_3 = var0;
            }
        }
        return var2_3;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static int zzb(ContentResolver var0, Uri var1_3) {
        var2_4 = var1_3 /* !! */ .getScheme();
        var3_5 = "content".equals(var2_4);
        if (!var3_5 && !(var3_5 = (var4_6 = "file").equals(var2_4 = var1_3 /* !! */ .getScheme()))) {
            return 0;
        }
        var3_5 = false;
        var2_4 = null;
        var0 = var0.openInputStream(var1_3 /* !! */ );
        if (var0 == null) ** GOTO lbl22
        try {
            var2_4 = var4_6 = new ExifInterface((InputStream)var0);
            ** GOTO lbl22
        }
        catch (Throwable var4_7) {
            if (var0 == null) throw var4_7;
            try {
                var0.close();
                throw var4_7;
            }
            catch (Throwable var0_1) {
                try {
                    zzn.zza(var4_7, var0_1);
                    throw var4_7;
lbl22:
                    // 2 sources

                    if (var0 != null) {
                        var0.close();
                    }
                }
                catch (IOException var0_2) {
                    var4_6 = ImageUtils.zza;
                    var1_3 /* !! */  = String.valueOf(var1_3 /* !! */ );
                    var5_8 = String.valueOf(var1_3 /* !! */ ).length() + 48;
                    var6_9 = new StringBuilder(var5_8);
                    var6_9.append("failed to open file to read rotation meta data: ");
                    var6_9.append((String)var1_3 /* !! */ );
                    var1_3 /* !! */  = var6_9.toString();
                    var7_10 = "MLKitImageUtils";
                    var4_6.e(var7_10, (String)var1_3 /* !! */ , var0_2);
                }
            }
        }
        if (var2_4 != null) return var2_4.getAttributeInt("Orientation", 1);
        return 0;
    }

    public int getMobileVisionImageFormat(InputImage inputImage) {
        return inputImage.getFormat();
    }

    public int getMobileVisionImageSize(InputImage object) {
        int n10 = ((InputImage)object).getFormat();
        int n11 = 0;
        int n12 = -1;
        if (n10 == n12) {
            n10 = Build.VERSION.SDK_INT;
            n11 = 19;
            if (n10 >= n11) {
                object = ((InputImage)object).getBitmapInternal();
                n11 = object.getAllocationByteCount();
            } else {
                object = ((InputImage)object).getBitmapInternal();
                n11 = object.getByteCount();
            }
        } else {
            n10 = ((InputImage)object).getFormat();
            if (n10 != (n12 = 17) && (n10 = ((InputImage)object).getFormat()) != (n12 = 842094169)) {
                n10 = ((InputImage)object).getFormat();
                if (n10 == (n12 = 35)) {
                    object = ((InputImage)object).getPlanes()[0].getBuffer();
                    int n13 = ((Buffer)object).limit() * 3;
                    n11 = n13 / 2;
                }
            } else {
                object = ((InputImage)object).getByteBuffer();
                n11 = ((Buffer)object).limit();
            }
        }
        return n11;
    }
}

