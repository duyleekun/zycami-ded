/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetFileDescriptor
 *  android.graphics.Bitmap
 */
package com.zhishen.imagetool;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import com.zhishen.imagetool.ImagePixelBuffer;
import com.zhishen.imagetool.ImageStitcher$a;
import com.zhishen.imagetool.ImageStitcher$b;

public class ImageStitcher {
    private long a;
    private Bitmap[] b;
    private boolean c;
    private int d;
    private int e;

    private ImageStitcher() {
        long l10;
        this.a = 0L;
        this.b = null;
        this.c = false;
        this.d = 0;
        this.e = 0;
        this.a = l10 = ImageStitcher.nativeCreateImageStitcher();
    }

    private ImageStitcher(Bitmap bitmap) {
        long l10;
        this.a = l10 = 0L;
        this.b = null;
        boolean bl2 = false;
        this.c = false;
        this.d = 0;
        this.e = 0;
        if (bitmap != null) {
            bl2 = true;
        }
        this.c = bl2;
        this.a = l10 = ImageStitcher.nativeCreateImageStitcherWithPV50Picture(bitmap);
    }

    private ImageStitcher(Bitmap[] bitmapArray) {
        long l10;
        this.a = 0L;
        this.b = null;
        this.c = false;
        this.d = 0;
        this.e = 0;
        this.b = bitmapArray;
        this.a = l10 = ImageStitcher.nativeCreateImageStitcher();
    }

    public static /* synthetic */ boolean a(String string2) {
        return ImageStitcher.j(string2);
    }

    public static /* synthetic */ int b(ImageStitcher imageStitcher) {
        return imageStitcher.d;
    }

    public static /* synthetic */ int c(ImageStitcher imageStitcher) {
        int n10;
        int n11 = imageStitcher.d;
        imageStitcher.d = n10 = n11 + 1;
        return n11;
    }

    public static /* synthetic */ int d(ImageStitcher imageStitcher) {
        return imageStitcher.f();
    }

    private int f() {
        return ImageStitcher.nativeImageStitcherGetPV50Status(this.a);
    }

    private static boolean j(String string2) {
        boolean bl2;
        return string2 == null || (bl2 = string2.isEmpty());
        {
        }
    }

    private static native long nativeCreateImageStitcher();

    private static native long nativeCreateImageStitcherWithPV50Picture(Bitmap var0);

    private static native void nativeImageStitcherCancel(long var0);

    private static native int nativeImageStitcherGetPV50Status(long var0);

    private static native boolean nativeImageStitcherIsDisableSeam(long var0);

    private static native boolean nativeImageStitcherIsFinish(long var0);

    private static native boolean nativeImageStitcherIsPano360(long var0);

    private static native void nativeImageStitcherSetDisableSeam(long var0, boolean var2);

    private static native void nativeImageStitcherSetIsPano360(long var0, boolean var2);

    private static native void nativeImageStitcherSetPV50OfPicture(long var0, Bitmap var2);

    private static native Bitmap nativeImageStitcherStitchImages(long var0, Bitmap[] var2);

    private static native Bitmap nativeImageStitcherStitchPV50(long var0, Bitmap var2);

    private static native Bitmap nativeImageStitcherStitchPV50WithBitmap(long var0, Bitmap var2, int var3);

    private static native Bitmap nativeImageStitcherStitchPV50WithI420(long var0, byte[] var2, int var3, int var4, int var5);

    private static native ImagePixelBuffer nativeImageStitcherStitchPV50WithI420InputToNV12(long var0, byte[] var2, int var3, int var4, int var5);

    private static native ImagePixelBuffer nativeImageStitcherStitchPV50WithI420InputToNV21(long var0, byte[] var2, int var3, int var4, int var5);

    private static native ImagePixelBuffer nativeImageStitcherStitchPV50WithI420InputToRGBA(long var0, byte[] var2, int var3, int var4, int var5);

    private static native ImagePixelBuffer nativeImageStitcherStitchPV50WithI420InputToYV12(long var0, byte[] var2, int var3, int var4, int var5);

    private static native ImagePixelBuffer nativeImageStitcherStitchPV50WithI420K(long var0, byte[] var2, int var3, int var4, int var5);

    private static native Bitmap nativeImageStitcherStitchPV50WithNV12(long var0, byte[] var2, int var3, int var4, int var5);

    private static native ImagePixelBuffer nativeImageStitcherStitchPV50WithNV12K(long var0, byte[] var2, int var3, int var4, int var5);

    private static native Bitmap nativeImageStitcherStitchPV50WithNV21(long var0, byte[] var2, int var3, int var4, int var5);

    private static native ImagePixelBuffer nativeImageStitcherStitchPV50WithNV21K(long var0, byte[] var2, int var3, int var4, int var5);

    private static native Bitmap nativeImageStitcherStitchPV50WithRGBA(long var0, byte[] var2, int var3, int var4, int var5);

    private static native ImagePixelBuffer nativeImageStitcherStitchPV50WithRGBAInputToI420(long var0, byte[] var2, int var3, int var4, int var5);

    private static native ImagePixelBuffer nativeImageStitcherStitchPV50WithRGBAInputToNV12(long var0, byte[] var2, int var3, int var4, int var5);

    private static native ImagePixelBuffer nativeImageStitcherStitchPV50WithRGBAInputToNV21(long var0, byte[] var2, int var3, int var4, int var5);

    private static native ImagePixelBuffer nativeImageStitcherStitchPV50WithRGBAInputToYV12(long var0, byte[] var2, int var3, int var4, int var5);

    private static native ImagePixelBuffer nativeImageStitcherStitchPV50WithRGBAK(long var0, byte[] var2, int var3, int var4, int var5);

    private static native void nativeReleaseImageStitcher(long var0);

    private Bitmap o() {
        int n10;
        Bitmap[] bitmapArray = this.b;
        if (bitmapArray != null && (n10 = bitmapArray.length) != 0) {
            return ImageStitcher.nativeImageStitcherStitchImages(this.a, bitmapArray);
        }
        return null;
    }

    public static void r(Bitmap bitmap, String string2, String string3, ImageStitcher$b imageStitcher$b) {
        ImageStitcher.w(bitmap, string2, null, string3, imageStitcher$b);
    }

    public static void s(Bitmap bitmap, AssetFileDescriptor assetFileDescriptor, String string2, ImageStitcher$b imageStitcher$b) {
        ImageStitcher.w(bitmap, null, assetFileDescriptor, string2, imageStitcher$b);
    }

    private static void w(Bitmap bitmap, String string2, AssetFileDescriptor object, String string3, ImageStitcher$b imageStitcher$b) {
        boolean bl2;
        if (!(bitmap == null || (bl2 = ImageStitcher.j(string2)) && object == null || (bl2 = ImageStitcher.j(string3)))) {
            ImageStitcher$a imageStitcher$a = new ImageStitcher$a(string3, bitmap, string2, (AssetFileDescriptor)object, imageStitcher$b);
            Thread thread = new Thread(imageStitcher$a);
            thread.start();
            return;
        }
        if (imageStitcher$b != null) {
            bitmap = null;
            int n10 = -1;
            object = "Parameters null";
            imageStitcher$b.a(false, (String)object, n10);
        }
    }

    public static ImageStitcher x() {
        ImageStitcher imageStitcher = new ImageStitcher(null);
        return imageStitcher;
    }

    public static ImageStitcher y(Bitmap bitmap) {
        ImageStitcher imageStitcher = new ImageStitcher(bitmap);
        return imageStitcher;
    }

    public static ImageStitcher z(boolean bl2) {
        ImageStitcher imageStitcher = new ImageStitcher();
        imageStitcher.m(bl2);
        return imageStitcher;
    }

    public void e() {
        ImageStitcher.nativeImageStitcherCancel(this.a);
    }

    public void finalize() {
        super.finalize();
        ImageStitcher.nativeReleaseImageStitcher(this.a);
        this.a = 0L;
    }

    public boolean g() {
        return ImageStitcher.nativeImageStitcherIsDisableSeam(this.a);
    }

    public boolean h() {
        return ImageStitcher.nativeImageStitcherIsFinish(this.a);
    }

    public boolean i() {
        return ImageStitcher.nativeImageStitcherIsPano360(this.a);
    }

    public void k() {
        ImageStitcher.nativeReleaseImageStitcher(this.a);
        this.a = 0L;
    }

    public void l(boolean bl2) {
        ImageStitcher.nativeImageStitcherSetDisableSeam(this.a, bl2);
    }

    public void m(boolean bl2) {
        ImageStitcher.nativeImageStitcherSetIsPano360(this.a, bl2);
    }

    public void n(Bitmap bitmap) {
        boolean bl2 = bitmap != null;
        this.c = bl2;
        ImageStitcher.nativeImageStitcherSetPV50OfPicture(this.a, bitmap);
    }

    public Bitmap p(Bitmap[] bitmapArray) {
        int n10;
        if (bitmapArray != null && (n10 = bitmapArray.length) != 0) {
            return ImageStitcher.nativeImageStitcherStitchImages(this.a, bitmapArray);
        }
        return null;
    }

    public Bitmap q(Bitmap object) {
        boolean bl2 = this.c;
        if (bl2) {
            return ImageStitcher.nativeImageStitcherStitchPV50(this.a, object);
        }
        object = new NullPointerException("ERROR: PV50 picture should be set before merging with video frame!");
        throw object;
    }

    public ImagePixelBuffer t(byte[] object, int n10, int n11, int n12, int n13) {
        int n14 = 1;
        if (n13 != n14) {
            n14 = 17;
            if (n13 != n14) {
                n14 = 35;
                if (n13 != n14) {
                    long l10 = this.a;
                    object = ImageStitcher.nativeImageStitcherStitchPV50WithI420K(l10, object, n10, n11, n12);
                } else {
                    long l11 = this.a;
                    object = ImageStitcher.nativeImageStitcherStitchPV50WithI420K(l11, object, n10, n11, n12);
                }
            } else {
                long l12 = this.a;
                object = ImageStitcher.nativeImageStitcherStitchPV50WithNV21K(l12, object, n10, n11, n12);
            }
        } else {
            long l13 = this.a;
            object = ImageStitcher.nativeImageStitcherStitchPV50WithRGBAK(l13, object, n10, n11, n12);
        }
        return object;
    }

    public ImagePixelBuffer u(byte[] byArray, int n10, int n11, int n12, int n13, int n14) {
        ImagePixelBuffer imagePixelBuffer;
        int n15 = 8738;
        int n16 = 4369;
        int n17 = 35;
        int n18 = 1;
        int n19 = 17;
        if (n13 != n18) {
            if (n13 != n19) {
                if (n13 != n17) {
                    long l10 = this.a;
                    imagePixelBuffer = ImageStitcher.nativeImageStitcherStitchPV50WithI420K(l10, byArray, n10, n11, n12);
                } else if (n14 == n16) {
                    long l11 = this.a;
                    n17 = n10;
                    n18 = n11;
                    n19 = n12;
                    imagePixelBuffer = ImageStitcher.nativeImageStitcherStitchPV50WithI420InputToNV12(l11, byArray, n10, n11, n12);
                } else if (n14 == n19) {
                    long l12 = this.a;
                    n17 = n10;
                    n18 = n11;
                    n19 = n12;
                    imagePixelBuffer = ImageStitcher.nativeImageStitcherStitchPV50WithI420InputToNV21(l12, byArray, n10, n11, n12);
                } else if (n14 == n15) {
                    long l13 = this.a;
                    n17 = n10;
                    n18 = n11;
                    n19 = n12;
                    imagePixelBuffer = ImageStitcher.nativeImageStitcherStitchPV50WithI420InputToYV12(l13, byArray, n10, n11, n12);
                } else if (n14 == n18) {
                    long l14 = this.a;
                    n17 = n10;
                    n18 = n11;
                    n19 = n12;
                    imagePixelBuffer = ImageStitcher.nativeImageStitcherStitchPV50WithI420InputToRGBA(l14, byArray, n10, n11, n12);
                } else {
                    long l15 = this.a;
                    n17 = n10;
                    n18 = n11;
                    n19 = n12;
                    imagePixelBuffer = ImageStitcher.nativeImageStitcherStitchPV50WithI420K(l15, byArray, n10, n11, n12);
                }
            } else {
                long l16 = this.a;
                n17 = n10;
                n18 = n11;
                n19 = n12;
                imagePixelBuffer = ImageStitcher.nativeImageStitcherStitchPV50WithNV21K(l16, byArray, n10, n11, n12);
            }
        } else if (n14 == n16) {
            long l17 = this.a;
            n17 = n10;
            n18 = n11;
            n19 = n12;
            imagePixelBuffer = ImageStitcher.nativeImageStitcherStitchPV50WithRGBAInputToNV12(l17, byArray, n10, n11, n12);
        } else if (n14 == n19) {
            long l18 = this.a;
            n17 = n10;
            n18 = n11;
            n19 = n12;
            imagePixelBuffer = ImageStitcher.nativeImageStitcherStitchPV50WithRGBAInputToNV21(l18, byArray, n10, n11, n12);
        } else if (n14 == n15) {
            long l19 = this.a;
            n17 = n10;
            n18 = n11;
            n19 = n12;
            imagePixelBuffer = ImageStitcher.nativeImageStitcherStitchPV50WithRGBAInputToYV12(l19, byArray, n10, n11, n12);
        } else if (n14 == n17) {
            long l20 = this.a;
            n17 = n10;
            n18 = n11;
            n19 = n12;
            imagePixelBuffer = ImageStitcher.nativeImageStitcherStitchPV50WithRGBAInputToI420(l20, byArray, n10, n11, n12);
        } else {
            long l21 = this.a;
            n17 = n10;
            n18 = n11;
            n19 = n12;
            imagePixelBuffer = ImageStitcher.nativeImageStitcherStitchPV50WithRGBAK(l21, byArray, n10, n11, n12);
        }
        return imagePixelBuffer;
    }

    public Bitmap v(byte[] object, int n10, int n11, int n12, int n13) {
        int n14 = 1;
        if (n13 != n14) {
            n14 = 17;
            if (n13 != n14) {
                n14 = 35;
                if (n13 != n14) {
                    long l10 = this.a;
                    object = ImageStitcher.nativeImageStitcherStitchPV50WithI420(l10, object, n10, n11, n12);
                } else {
                    long l11 = this.a;
                    object = ImageStitcher.nativeImageStitcherStitchPV50WithI420(l11, object, n10, n11, n12);
                }
            } else {
                long l12 = this.a;
                object = ImageStitcher.nativeImageStitcherStitchPV50WithNV21(l12, object, n10, n11, n12);
            }
        } else {
            long l13 = this.a;
            object = ImageStitcher.nativeImageStitcherStitchPV50WithRGBA(l13, object, n10, n11, n12);
        }
        return object;
    }
}

