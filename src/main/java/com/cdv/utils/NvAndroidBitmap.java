/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.BitmapRegionDecoder
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.media.ExifInterface
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package com.cdv.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import com.cdv.utils.NvAndroidBitmap$ImageInfo;
import com.cdv.utils.NvAndroidBitmap$Size;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class NvAndroidBitmap {
    public static final int ASPECT_RATIO_MODE_IGNORE = 0;
    public static final int ASPECT_RATIO_MODE_KEEP = 1;
    public static final int ASPECT_RATIO_MODE_KEEP_EXPANDING = 2;
    private static final String TAG = "NvAndroidBitmap";

    public static Bitmap convertBitmapToRGBA(Bitmap bitmap) {
        Bitmap.Config config;
        if (bitmap == null) {
            return null;
        }
        Bitmap.Config config2 = bitmap.getConfig();
        if (config2 == (config = Bitmap.Config.ARGB_8888)) {
            return bitmap;
        }
        config2 = null;
        try {
            return bitmap.copy(config, false);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static Bitmap createBitmap(Context object, String string2, NvAndroidBitmap$Size nvAndroidBitmap$Size, int n10, boolean bl2) {
        NvAndroidBitmap$Size nvAndroidBitmap$Size2;
        block10: {
            int n11;
            NvAndroidBitmap$ImageInfo nvAndroidBitmap$ImageInfo = NvAndroidBitmap.getImageInfo((Context)object, string2);
            if (nvAndroidBitmap$ImageInfo == null) {
                return null;
            }
            try {
                n11 = nvAndroidBitmap$ImageInfo.width;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return null;
            }
            int n12 = nvAndroidBitmap$ImageInfo.height;
            nvAndroidBitmap$Size2 = new NvAndroidBitmap$Size(n11, n12);
            object = NvAndroidBitmap.tryCreateInputStreamFromImageFilePath((Context)object, string2);
            if (object == null) break block10;
            n11 = 0;
            string2 = NvAndroidBitmap.createBitmap(null, (InputStream)object, nvAndroidBitmap$Size2, nvAndroidBitmap$Size, n10, bl2);
            ((InputStream)object).close();
            return string2;
        }
        return NvAndroidBitmap.createBitmap(string2, null, nvAndroidBitmap$Size2, nvAndroidBitmap$Size, n10, bl2);
    }

    private static Bitmap createBitmap(String string2, InputStream inputStream, NvAndroidBitmap$Size nvAndroidBitmap$Size, NvAndroidBitmap$Size nvAndroidBitmap$Size2, int n10, boolean bl2) {
        BitmapFactory.Options options;
        block46: {
            int n11;
            int n12;
            block51: {
                block50: {
                    block49: {
                        int n13;
                        block47: {
                            NvAndroidBitmap$Size nvAndroidBitmap$Size3;
                            block48: {
                                try {
                                    options = new BitmapFactory.Options();
                                    if (nvAndroidBitmap$Size2 == null) break block46;
                                }
                                catch (Exception exception) {
                                    return null;
                                }
                                n13 = nvAndroidBitmap$Size2.equals(nvAndroidBitmap$Size);
                                if (n13 != 0) break block46;
                                if (n10 == 0) break block47;
                                n13 = nvAndroidBitmap$Size.getWidth();
                                double d10 = n13;
                                int n14 = nvAndroidBitmap$Size.getHeight();
                                double d11 = n14;
                                d10 /= d11;
                                n14 = nvAndroidBitmap$Size2.getWidth();
                                d11 = n14;
                                double d12 = nvAndroidBitmap$Size2.getHeight();
                                d11 /= d12;
                                int n15 = 1;
                                double d13 = 0.5;
                                if (n10 == n15) {
                                    n10 = (int)(d10 == d11 ? 0 : (d10 > d11 ? 1 : -1));
                                    if (n10 >= 0) {
                                        n14 = nvAndroidBitmap$Size2.getWidth();
                                        double d14 = (double)nvAndroidBitmap$Size2.getWidth() / d10 + d13;
                                        int n16 = (int)d14;
                                        nvAndroidBitmap$Size3 = new NvAndroidBitmap$Size(n14, n16);
                                        break block48;
                                    }
                                    n14 = nvAndroidBitmap$Size2.getHeight();
                                    d11 = (double)n14 * d10 + d13;
                                    n13 = (int)d11;
                                    int n17 = nvAndroidBitmap$Size2.getHeight();
                                    nvAndroidBitmap$Size3 = new NvAndroidBitmap$Size(n13, n17);
                                    break block48;
                                }
                                n10 = (int)(d10 == d11 ? 0 : (d10 > d11 ? 1 : -1));
                                if (n10 >= 0) {
                                    n14 = nvAndroidBitmap$Size2.getHeight();
                                    d11 = (double)n14 * d10 + d13;
                                    n13 = (int)d11;
                                    int n18 = nvAndroidBitmap$Size2.getHeight();
                                    nvAndroidBitmap$Size3 = new NvAndroidBitmap$Size(n13, n18);
                                } else {
                                    n14 = nvAndroidBitmap$Size2.getWidth();
                                    double d15 = (double)nvAndroidBitmap$Size2.getWidth() / d10 + d13;
                                    int n19 = (int)d15;
                                    nvAndroidBitmap$Size3 = new NvAndroidBitmap$Size(n14, n19);
                                }
                            }
                            nvAndroidBitmap$Size2 = nvAndroidBitmap$Size3;
                        }
                        n10 = nvAndroidBitmap$Size2.getWidth();
                        float f10 = n10;
                        n13 = nvAndroidBitmap$Size.getWidth();
                        float f11 = n13;
                        f10 /= f11;
                        n13 = nvAndroidBitmap$Size2.getHeight();
                        f11 = n13;
                        n12 = nvAndroidBitmap$Size.getHeight();
                        float f12 = n12;
                        f11 /= f12;
                        f12 = Math.max(f10, f11);
                        n10 = 1065353216;
                        f10 = 1.0f;
                        f12 = Math.min(f12, f10);
                        n12 = (int)(f10 /= f12);
                        options.inSampleSize = n12;
                        if (string2 == null) break block49;
                        string2 = BitmapFactory.decodeFile((String)string2, (BitmapFactory.Options)options);
                        break block50;
                    }
                    string2 = BitmapFactory.decodeStream((InputStream)inputStream, null, (BitmapFactory.Options)options);
                }
                if (string2 == null) {
                    return null;
                }
                n11 = string2.getWidth();
                n12 = nvAndroidBitmap$Size2.getWidth();
                if (n11 > n12) break block51;
                n11 = string2.getHeight();
                n12 = nvAndroidBitmap$Size2.getHeight();
                if (n11 > n12) break block51;
                return string2;
            }
            n11 = nvAndroidBitmap$Size2.getWidth();
            n12 = nvAndroidBitmap$Size2.getHeight();
            return Bitmap.createScaledBitmap((Bitmap)string2, (int)n11, (int)n12, (boolean)bl2);
        }
        if (string2 != null) {
            return BitmapFactory.decodeFile((String)string2, (BitmapFactory.Options)options);
        }
        return BitmapFactory.decodeStream((InputStream)inputStream, null, (BitmapFactory.Options)options);
    }

    public static Bitmap createBitmap(byte[] byArray, NvAndroidBitmap$Size nvAndroidBitmap$Size, int n10, boolean bl2) {
        ByteArrayInputStream byteArrayInputStream;
        NvAndroidBitmap$ImageInfo nvAndroidBitmap$ImageInfo = NvAndroidBitmap.getImageInfo(byArray);
        if (nvAndroidBitmap$ImageInfo == null) {
            return null;
        }
        try {
            byteArrayInputStream = new ByteArrayInputStream(byArray);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        int n11 = nvAndroidBitmap$ImageInfo.width;
        int n12 = nvAndroidBitmap$ImageInfo.height;
        NvAndroidBitmap$Size nvAndroidBitmap$Size2 = new NvAndroidBitmap$Size(n11, n12);
        return NvAndroidBitmap.createBitmap(null, byteArrayInputStream, nvAndroidBitmap$Size2, nvAndroidBitmap$Size, n10, bl2);
    }

    public static Bitmap createBitmapRegion(Context object, String string2, Rect rect) {
        BitmapFactory.Options options;
        block9: {
            try {
                options = new BitmapFactory.Options();
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return null;
            }
            object = NvAndroidBitmap.tryCreateInputStreamFromImageFilePath((Context)object, string2);
            if (object == null) break block9;
            string2 = BitmapRegionDecoder.newInstance((InputStream)object, (boolean)false);
            string2 = string2.decodeRegion(rect, options);
            ((InputStream)object).close();
            return string2;
        }
        object = BitmapRegionDecoder.newInstance((String)string2, (boolean)false);
        return object.decodeRegion(rect, options);
    }

    public static Bitmap createBitmapRegion(byte[] object, Rect rect) {
        int n10;
        BitmapFactory.Options options;
        try {
            options = new BitmapFactory.Options();
            n10 = ((byte[])object).length;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        object = BitmapRegionDecoder.newInstance((byte[])object, (int)0, (int)n10, (boolean)false);
        return object.decodeRegion(rect, options);
    }

    public static Bitmap createRgbaBitmap(int n10, int n11) {
        Bitmap.Config config;
        try {
            config = Bitmap.Config.ARGB_8888;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        return Bitmap.createBitmap((int)n10, (int)n11, (Bitmap.Config)config);
    }

    public static Bitmap createRotatedBitmap(Context object, String string2, NvAndroidBitmap$Size nvAndroidBitmap$Size, int n10, boolean bl2) {
        int n11;
        block15: {
            NvAndroidBitmap$ImageInfo nvAndroidBitmap$ImageInfo;
            block14: {
                NvAndroidBitmap$Size nvAndroidBitmap$Size2;
                int n12;
                block13: {
                    int n13;
                    nvAndroidBitmap$ImageInfo = NvAndroidBitmap.getImageInfo((Context)object, string2);
                    if (nvAndroidBitmap$ImageInfo == null) {
                        return null;
                    }
                    try {
                        n13 = nvAndroidBitmap$ImageInfo.width;
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                        return null;
                    }
                    n12 = nvAndroidBitmap$ImageInfo.height;
                    nvAndroidBitmap$Size2 = new NvAndroidBitmap$Size(n13, n12);
                    object = NvAndroidBitmap.tryCreateInputStreamFromImageFilePath((Context)object, string2);
                    if (object == null) break block13;
                    n13 = 0;
                    string2 = NvAndroidBitmap.createBitmap(null, (InputStream)object, nvAndroidBitmap$Size2, nvAndroidBitmap$Size, n10, bl2);
                    ((InputStream)object).close();
                    break block14;
                }
                n12 = 0;
                string2 = NvAndroidBitmap.createBitmap(string2, null, nvAndroidBitmap$Size2, nvAndroidBitmap$Size, n10, bl2);
            }
            if (string2 == null) {
                return null;
            }
            n11 = nvAndroidBitmap$ImageInfo.orientation;
            int n14 = 1;
            if (n11 != n14) break block15;
            return string2;
        }
        return NvAndroidBitmap.transformBitmap((Bitmap)string2, n11);
    }

    public static Bitmap createRotatedBitmap(byte[] object, NvAndroidBitmap$Size nvAndroidBitmap$Size, int n10, boolean bl2) {
        int n11;
        block11: {
            NvAndroidBitmap$ImageInfo nvAndroidBitmap$ImageInfo;
            block10: {
                ByteArrayInputStream byteArrayInputStream;
                nvAndroidBitmap$ImageInfo = NvAndroidBitmap.getImageInfo(object);
                if (nvAndroidBitmap$ImageInfo == null) {
                    return null;
                }
                try {
                    byteArrayInputStream = new ByteArrayInputStream((byte[])object);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return null;
                }
                int n12 = nvAndroidBitmap$ImageInfo.width;
                int n13 = nvAndroidBitmap$ImageInfo.height;
                NvAndroidBitmap$Size nvAndroidBitmap$Size2 = new NvAndroidBitmap$Size(n12, n13);
                object = NvAndroidBitmap.createBitmap(null, byteArrayInputStream, nvAndroidBitmap$Size2, nvAndroidBitmap$Size, n10, bl2);
                if (object != null) break block10;
                return null;
            }
            n11 = nvAndroidBitmap$ImageInfo.orientation;
            n10 = 1;
            if (n11 != n10) break block11;
            return object;
        }
        return NvAndroidBitmap.transformBitmap((Bitmap)object, n11);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static NvAndroidBitmap$ImageInfo getImageInfo(Context object, String string2) {
        if (string2 == null) return null;
        int n10 = string2.isEmpty();
        if (n10 != 0) {
            return null;
        }
        try {
            Object object2;
            block12: {
                int n11;
                Object object3;
                Object object4;
                block11: {
                    int n12;
                    String string3;
                    int n13;
                    boolean bl2;
                    block10: {
                        object2 = NvAndroidBitmap.tryCreateInputStreamFromImageFilePath((Context)object, string2);
                        if (object2 == null) break block10;
                        object4 = NvAndroidBitmap.getImageInfo((InputStream)object2);
                        ((InputStream)object2).close();
                        if (object4 == null) {
                            return null;
                        }
                        break block11;
                    }
                    object2 = new BitmapFactory.Options();
                    ((BitmapFactory.Options)object2).inJustDecodeBounds = bl2 = true;
                    BitmapFactory.decodeFile((String)string2, (BitmapFactory.Options)object2);
                    object3 = ((BitmapFactory.Options)object2).outMimeType;
                    if (object3 == null || (n13 = ((BitmapFactory.Options)object2).outWidth) < 0 || (n13 = ((BitmapFactory.Options)object2).outHeight) < 0) break block12;
                    object3 = new NvAndroidBitmap$ImageInfo();
                    ((NvAndroidBitmap$ImageInfo)object3).mimeType = string3 = ((BitmapFactory.Options)object2).outMimeType;
                    ((NvAndroidBitmap$ImageInfo)object3).width = n12 = ((BitmapFactory.Options)object2).outWidth;
                    ((NvAndroidBitmap$ImageInfo)object3).height = n10 = ((BitmapFactory.Options)object2).outHeight;
                    ((NvAndroidBitmap$ImageInfo)object3).orientation = (int)(bl2 ? 1 : 0);
                    object4 = object3;
                }
                if ((n10 = ((String)(object2 = ((NvAndroidBitmap$ImageInfo)object4).mimeType)).equals(object3 = "image/jpeg")) == 0) {
                    object2 = ((NvAndroidBitmap$ImageInfo)object4).mimeType;
                    object3 = "image/x-adobe-dng";
                    n10 = ((String)object2).equals(object3);
                    if (n10 == 0) return object4;
                }
                if ((object = NvAndroidBitmap.tryCreateInputStreamFromImageFilePath((Context)object, string2)) != null) {
                    int n14;
                    ((NvAndroidBitmap$ImageInfo)object4).orientation = n14 = NvAndroidBitmap.getImageRotation((InputStream)object);
                    ((InputStream)object).close();
                    return object4;
                }
                ((NvAndroidBitmap$ImageInfo)object4).orientation = n11 = NvAndroidBitmap.getImageRotation(string2);
                return object4;
            }
            object = TAG;
            object2 = new StringBuilder();
            String string4 = "Failed to get image information for ";
            ((StringBuilder)object2).append(string4);
            ((StringBuilder)object2).append(string2);
            string2 = ((StringBuilder)object2).toString();
            Log.e((String)object, (String)string2);
            return null;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    private static NvAndroidBitmap$ImageInfo getImageInfo(InputStream object) {
        block14: {
            boolean bl2;
            BitmapFactory.Options options;
            if (object == null) {
                return null;
            }
            try {
                options = new BitmapFactory.Options();
                bl2 = true;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return null;
            }
            options.inJustDecodeBounds = bl2;
            BitmapFactory.decodeStream((InputStream)object, null, (BitmapFactory.Options)options);
            object = options.outMimeType;
            if (object == null) break block14;
            int n10 = options.outWidth;
            if (n10 < 0) break block14;
            n10 = options.outHeight;
            if (n10 < 0) break block14;
            object = new NvAndroidBitmap$ImageInfo();
            String string2 = options.outMimeType;
            ((NvAndroidBitmap$ImageInfo)object).mimeType = string2;
            int n11 = options.outWidth;
            ((NvAndroidBitmap$ImageInfo)object).width = n11;
            int n12 = options.outHeight;
            ((NvAndroidBitmap$ImageInfo)object).height = n12;
            ((NvAndroidBitmap$ImageInfo)object).orientation = (int)(bl2 ? 1 : 0);
            return object;
        }
        return null;
    }

    public static NvAndroidBitmap$ImageInfo getImageInfo(byte[] byArray) {
        boolean bl2 = false;
        Object object = null;
        if (byArray == null) {
            return null;
        }
        Object object2 = new ByteArrayInputStream(byArray);
        if ((object2 = NvAndroidBitmap.getImageInfo((InputStream)object2)) == null) {
            return null;
        }
        object = ((NvAndroidBitmap$ImageInfo)object2).mimeType;
        String string2 = "image/jpeg";
        bl2 = ((String)object).equals(string2);
        if (bl2 || (bl2 = ((String)(object = ((NvAndroidBitmap$ImageInfo)object2).mimeType)).equals(string2 = "image/x-adobe-dng"))) {
            int n10;
            object = new ByteArrayInputStream(byArray);
            ((NvAndroidBitmap$ImageInfo)object2).orientation = n10 = NvAndroidBitmap.getImageRotation((InputStream)object);
        }
        return object2;
    }

    private static int getImageRotation(InputStream object) {
        ExifInterface exifInterface;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 1;
        int n12 = 24;
        if (n10 < n12) {
            return n11;
        }
        try {
            exifInterface = new ExifInterface((InputStream)object);
            object = "Orientation";
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return n11;
        }
        return exifInterface.getAttributeInt((String)object, n11);
    }

    private static int getImageRotation(String string2) {
        ExifInterface exifInterface;
        int n10 = 1;
        try {
            exifInterface = new ExifInterface(string2);
            string2 = "Orientation";
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return n10;
        }
        return exifInterface.getAttributeInt(string2, n10);
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int n10) {
        Matrix matrix;
        try {
            matrix = new Matrix();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        float f10 = n10;
        matrix.postRotate(f10);
        int n11 = bitmap.getWidth();
        int n12 = bitmap.getHeight();
        return Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)n11, (int)n12, (Matrix)matrix, (boolean)false);
    }

    public static boolean saveBitmapToFile(Bitmap bitmap, int n10, String string2) {
        Bitmap.CompressFormat compressFormat;
        FileOutputStream fileOutputStream;
        block6: {
            String string3;
            try {
                fileOutputStream = new FileOutputStream(string2);
                compressFormat = Bitmap.CompressFormat.JPEG;
                string3 = ".png";
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return false;
            }
            boolean bl2 = string2.endsWith(string3);
            if (!bl2) break block6;
            compressFormat = Bitmap.CompressFormat.PNG;
        }
        return bitmap.compress(compressFormat, n10, (OutputStream)fileOutputStream);
    }

    public static Bitmap transformBitmap(Bitmap bitmap, int n10) {
        Matrix matrix = new Matrix();
        float f10 = 90.0f;
        float f11 = 270.0f;
        float f12 = 1.0f;
        int n11 = -1082130432;
        float f13 = -1.0f;
        switch (n10) {
            default: {
                return bitmap;
            }
            case 8: {
                matrix.postRotate(f11);
                break;
            }
            case 7: {
                matrix.postScale(f13, f12);
                matrix.postRotate(f10);
                break;
            }
            case 6: {
                matrix.postRotate(f10);
                break;
            }
            case 5: {
                matrix.postScale(f13, f12);
                matrix.postRotate(f11);
                break;
            }
            case 4: {
                matrix.postScale(f12, f13);
                break;
            }
            case 3: {
                n10 = 0x43340000;
                float f14 = 180.0f;
                matrix.postRotate(f14);
                break;
            }
            case 2: {
                matrix.postScale(f13, f12);
            }
        }
        n11 = bitmap.getWidth();
        int n12 = bitmap.getHeight();
        return Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)n11, (int)n12, (Matrix)matrix, (boolean)false);
    }

    private static InputStream tryCreateInputStreamFromImageFilePath(Context context, String string2) {
        block11: {
            block12: {
                int n10;
                String string3;
                block9: {
                    block10: {
                        string3 = "assets:/";
                        try {
                            n10 = string2.startsWith(string3);
                            if (n10 == 0) break block9;
                            if (context != null) break block10;
                            return null;
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                            return null;
                        }
                    }
                    context = context.getAssets();
                    n10 = 8;
                    string2 = string2.substring(n10);
                    return context.open(string2);
                }
                string3 = "content://";
                n10 = string2.startsWith(string3);
                if (n10 == 0) break block11;
                if (context != null) break block12;
                return null;
            }
            context = context.getContentResolver();
            string2 = Uri.parse((String)string2);
            return context.openInputStream((Uri)string2);
        }
        return null;
    }
}

