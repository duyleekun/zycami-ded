/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.util.TypedValue
 */
package com.bumptech.glide.integration.webp;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import com.bumptech.glide.integration.webp.WebpHeaderParser;
import com.bumptech.glide.integration.webp.WebpHeaderParser$WebpImageType;
import java.io.BufferedInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class WebpBitmapFactory {
    private static final int IN_TEMP_BUFFER_SIZE = 8192;
    private static final int MAX_WEBP_HEADER_SIZE = 21;

    static {
        System.loadLibrary("glide-webp");
    }

    private static Bitmap createBitmap(int n10, int n11, BitmapFactory.Options options) {
        boolean bl2;
        Bitmap bitmap;
        if (options != null && (bitmap = options.inBitmap) != null && (bl2 = bitmap.isMutable())) {
            return options.inBitmap;
        }
        options = Bitmap.Config.ARGB_8888;
        Bitmap bitmap2 = Bitmap.createBitmap((int)n10, (int)n11, (Bitmap.Config)options);
        bitmap2.setHasAlpha(true);
        bitmap2.eraseColor(0);
        return bitmap2;
    }

    public static Bitmap decodeByteArray(byte[] byArray, int n10, int n11) {
        return WebpBitmapFactory.decodeByteArray(byArray, n10, n11, null);
    }

    public static Bitmap decodeByteArray(byte[] object, int n10, int n11, BitmapFactory.Options options) {
        int n12;
        int n13 = n10 | n11;
        if (n13 >= 0 && (n13 = ((byte[])object).length) >= (n12 = n10 + n11)) {
            n13 = (int)(WebpBitmapFactory.webpSupportRequired(object, n10, n11) ? 1 : 0);
            if (n13 != 0) {
                float f10 = WebpBitmapFactory.getScaleFromOptions(options);
                byte[] byArray = WebpBitmapFactory.getInTempStorageFromOptions(options);
                object = WebpBitmapFactory.nativeDecodeByteArray(object, n10, n11, options, f10, byArray);
                WebpBitmapFactory.setWebpBitmapOptions((Bitmap)object, options);
            } else {
                object = BitmapFactory.decodeByteArray((byte[])object, (int)n10, (int)n11, (BitmapFactory.Options)options);
            }
            return object;
        }
        object = new ArrayIndexOutOfBoundsException;
        object();
        throw object;
    }

    public static Bitmap decodeFile(String string2) {
        return WebpBitmapFactory.decodeFile(string2, null);
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Bitmap decodeFile(String string2, BitmapFactory.Options object) {
        void var0_5;
        InputStream inputStream;
        block13: {
            FileInputStream fileInputStream;
            block11: {
                block12: {
                    inputStream = null;
                    fileInputStream = new FileInputStream(string2);
                    try {
                        inputStream = WebpBitmapFactory.decodeStream(fileInputStream, null, object);
                        break block11;
                    }
                    catch (Exception exception) {
                        break block12;
                    }
                    catch (Throwable throwable) {
                        break block13;
                    }
                    catch (Exception exception) {
                        fileInputStream = null;
                    }
                }
                String string3 = "WebpBitmapFactory";
                StringBuilder stringBuilder = new StringBuilder();
                String string4 = "Unable to decode stream: ";
                stringBuilder.append(string4);
                stringBuilder.append((Object)string2);
                string2 = stringBuilder.toString();
                Log.e((String)string3, (String)string2);
                if (fileInputStream == null) return inputStream;
            }
            try {
                ((InputStream)fileInputStream).close();
                return inputStream;
            }
            catch (IOException iOException) {}
            return inputStream;
            catch (Throwable throwable) {
                inputStream = fileInputStream;
            }
        }
        if (inputStream == null) throw var0_5;
        try {
            inputStream.close();
        }
        catch (IOException iOException) {
            throw var0_5;
        }
        throw var0_5;
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor) {
        return WebpBitmapFactory.decodeFileDescriptor(fileDescriptor, null, null);
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        InputStream inputStream = new FileInputStream(fileDescriptor);
        inputStream = WebpBitmapFactory.wrapToMarkSupportedStream(inputStream);
        try {
            byte[] byArray = WebpBitmapFactory.getImageHeader(inputStream);
            int n10 = 21;
            boolean bl2 = WebpBitmapFactory.webpSupportRequired(byArray, 0, n10);
            if (bl2) {
                float f10 = WebpBitmapFactory.getScaleFromOptions(options);
                byArray = WebpBitmapFactory.getInTempStorageFromOptions(options);
                fileDescriptor = WebpBitmapFactory.nativeDecodeStream(inputStream, options, f10, byArray);
                WebpBitmapFactory.setWebpBitmapOptions((Bitmap)fileDescriptor, options);
                WebpBitmapFactory.setDefaultPadding(rect);
            } else {
                fileDescriptor = BitmapFactory.decodeFileDescriptor((FileDescriptor)fileDescriptor, (Rect)rect, (BitmapFactory.Options)options);
            }
            return fileDescriptor;
        }
        finally {
            inputStream.close();
        }
    }

    public static Bitmap decodeResource(Resources resources, int n10) {
        return WebpBitmapFactory.decodeResource(resources, n10, null);
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Bitmap decodeResource(Resources object, int n10, BitmapFactory.Options options) {
        void var2_7;
        InputStream inputStream;
        block11: {
            InputStream inputStream2;
            block12: {
                void var0_3;
                int n11;
                block13: {
                    inputStream = null;
                    TypedValue typedValue = new TypedValue();
                    inputStream2 = object.openRawResource(n11, typedValue);
                    try {
                        inputStream = WebpBitmapFactory.decodeResourceStream(object, typedValue, inputStream2, null, (BitmapFactory.Options)var2_7);
                        if (inputStream2 == null) break block11;
                        break block12;
                    }
                    catch (Throwable throwable) {
                        inputStream = inputStream2;
                        break block13;
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                if (inputStream == null) throw var0_3;
                inputStream.close();
                {
                    catch (IOException iOException) {
                        throw var0_3;
                    }
                }
                throw var0_3;
                catch (Exception exception) {
                    block14: {
                        n11 = 0;
                        inputStream2 = null;
                        break block14;
                        catch (Exception exception2) {}
                    }
                    if (inputStream2 == null) break block11;
                }
            }
            try {
                inputStream2.close();
            }
            catch (IOException iOException) {}
        }
        if (inputStream != null) return inputStream;
        if (var2_7 == null) return inputStream;
        Bitmap bitmap = var2_7.inBitmap;
        if (bitmap == null) {
            return inputStream;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Problem decoding into existing bitmap");
        throw illegalArgumentException;
    }

    public static Bitmap decodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        int n10;
        int n11;
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        if ((n11 = options.inDensity) == 0 && typedValue != null) {
            n10 = typedValue.density;
            if (n10 == 0) {
                options.inDensity = n10 = 160;
            } else {
                n11 = (char)-1;
                if (n10 != n11) {
                    options.inDensity = n10;
                }
            }
        }
        if ((n10 = options.inTargetDensity) == 0 && resources != null) {
            int n12;
            resources = resources.getDisplayMetrics();
            options.inTargetDensity = n12 = resources.densityDpi;
        }
        return WebpBitmapFactory.decodeStream(inputStream, rect, options);
    }

    public static Bitmap decodeStream(InputStream inputStream) {
        return WebpBitmapFactory.decodeStream(inputStream, null, null);
    }

    public static Bitmap decodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        if (inputStream == null) {
            return null;
        }
        inputStream = WebpBitmapFactory.wrapToMarkSupportedStream(inputStream);
        byte[] byArray = WebpBitmapFactory.getImageHeader(inputStream);
        byte[] byArray2 = null;
        int n10 = 21;
        boolean bl2 = WebpBitmapFactory.webpSupportRequired(byArray, 0, n10);
        if (bl2) {
            float f10 = WebpBitmapFactory.getScaleFromOptions(options);
            byArray2 = WebpBitmapFactory.getInTempStorageFromOptions(options);
            inputStream = WebpBitmapFactory.nativeDecodeStream(inputStream, options, f10, byArray2);
            WebpBitmapFactory.setWebpBitmapOptions((Bitmap)inputStream, options);
            WebpBitmapFactory.setDefaultPadding(rect);
        } else {
            inputStream = BitmapFactory.decodeStream((InputStream)inputStream, (Rect)rect, (BitmapFactory.Options)options);
        }
        return inputStream;
    }

    private static byte[] getImageHeader(InputStream object) {
        Object object2;
        boolean bl2 = ((InputStream)object).markSupported();
        int n10 = 21;
        if (!bl2) {
            object = object2 = new BufferedInputStream((InputStream)object, n10);
        }
        ((InputStream)object).mark(n10);
        object2 = new byte[n10];
        try {
            ((InputStream)object).read((byte[])object2, 0, n10);
            ((InputStream)object).reset();
            return object2;
        }
        catch (IOException iOException) {
            return null;
        }
    }

    private static byte[] getInTempStorageFromOptions(BitmapFactory.Options object) {
        if (object != null && (object = (Object)object.inTempStorage) != null) {
            return object;
        }
        return new byte[8192];
    }

    private static float getScaleFromOptions(BitmapFactory.Options options) {
        float f10 = 1.0f;
        if (options != null) {
            int n10 = options.inSampleSize;
            int n11 = 1;
            if (n10 > n11) {
                float f11 = n10;
                f10 /= f11;
            }
            if ((n10 = (int)(options.inScaled ? 1 : 0)) != 0) {
                n10 = options.inDensity;
                n11 = options.inTargetDensity;
                int n12 = options.inScreenDensity;
                if (n10 != 0 && n11 != 0 && n10 != n12) {
                    float f12 = n11;
                    f10 = n10;
                    f10 = f12 / f10;
                }
            }
        }
        return f10;
    }

    private static native Bitmap nativeDecodeByteArray(byte[] var0, int var1, int var2, BitmapFactory.Options var3, float var4, byte[] var5);

    private static native Bitmap nativeDecodeStream(InputStream var0, BitmapFactory.Options var1, float var2, byte[] var3);

    private static void setDefaultPadding(Rect rect) {
        if (rect != null) {
            int n10;
            rect.top = n10 = -1;
            rect.left = n10;
            rect.bottom = n10;
            rect.right = n10;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void setDensityFromOptions(Bitmap bitmap, BitmapFactory.Options options) {
        if (bitmap == null || options == null) return;
        int n10 = options.inDensity;
        if (n10 != 0) {
            int n11;
            bitmap.setDensity(n10);
            int n12 = options.inTargetDensity;
            if (n12 == 0 || n10 == n12 || n10 == (n11 = options.inScreenDensity)) return;
            boolean bl2 = options.inScaled;
            if (!bl2) return;
            bitmap.setDensity(n12);
            return;
        } else {
            options = options.inBitmap;
            if (options == null) return;
            int n13 = 160;
            bitmap.setDensity(n13);
        }
    }

    private static boolean setOutDimensions(BitmapFactory.Options options, int n10, int n11) {
        if (options != null) {
            options.outWidth = n10;
            options.outHeight = n11;
            return options.inJustDecodeBounds;
        }
        return false;
    }

    private static void setWebpBitmapOptions(Bitmap object, BitmapFactory.Options options) {
        WebpBitmapFactory.setDensityFromOptions(object, options);
        if (options != null) {
            object = "image/webp";
            options.outMimeType = object;
        }
    }

    public static boolean webpSupportRequired(byte[] object, int n10, int n11) {
        boolean bl2;
        try {
            object = (Object)WebpHeaderParser.e(object, n10, n11);
        }
        catch (IOException iOException) {
            object = (Object)WebpHeaderParser$WebpImageType.NONE_WEBP;
        }
        n10 = Build.VERSION.SDK_INT;
        n11 = 17;
        if (n10 <= n11 && (bl2 = WebpHeaderParser.h((WebpHeaderParser$WebpImageType)((Object)object)))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    private static InputStream wrapToMarkSupportedStream(InputStream inputStream) {
        boolean bl2 = inputStream.markSupported();
        if (!bl2) {
            int n10 = 8192;
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, n10);
            inputStream = bufferedInputStream;
        }
        return inputStream;
    }
}

