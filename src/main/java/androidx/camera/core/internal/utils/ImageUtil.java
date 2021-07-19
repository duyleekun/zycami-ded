/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.BitmapRegionDecoder
 *  android.graphics.Rect
 *  android.graphics.YuvImage
 *  android.util.Rational
 *  android.util.Size
 */
package androidx.camera.core.internal.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageProxy$PlaneProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.internal.utils.ImageUtil$CodecFailedException;
import androidx.camera.core.internal.utils.ImageUtil$CodecFailedException$FailureType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public final class ImageUtil {
    private static final String TAG = "ImageUtil";

    private ImageUtil() {
    }

    public static Rect computeCropRectFromAspectRatio(Size size, Rational rational) {
        int n10 = ImageUtil.isAspectRatioValid(rational);
        if (n10 == 0) {
            Logger.w(TAG, "Invalid view ratio.");
            return null;
        }
        n10 = size.getWidth();
        int n11 = size.getHeight();
        float f10 = n10;
        float f11 = n11;
        float f12 = f10 / f11;
        int n12 = rational.getNumerator();
        int n13 = rational.getDenominator();
        float f13 = rational.floatValue();
        float f14 = f13 == f12 ? 0 : (f13 > f12 ? 1 : -1);
        int n14 = 0;
        f12 = 0.0f;
        if (f14 > 0) {
            f13 = n12;
            f10 /= f13;
            f13 = n13;
            f14 = Math.round(f10 *= f13);
            n11 = (n11 - f14) / 2;
            float f15 = f14;
            f14 = n11;
            n11 = (int)f15;
        } else {
            f13 = n13;
            f11 /= f13;
            f13 = n12;
            f14 = Math.round(f11 *= f13);
            int n15 = (n10 - f14) / 2;
            n10 = (int)f14;
            f14 = 0.0f;
            rational = null;
            f13 = 0.0f;
            n14 = n15;
        }
        Rect rect = new Rect(n14, (int)f14, n10 += n14, n11 += f14);
        return rect;
    }

    public static byte[] cropByteArray(byte[] object, Rect object2) {
        Object object3;
        block10: {
            object3 = "Decode byte array failed.";
            if (object2 == null) {
                return object;
            }
            int n10 = ((byte[])object).length;
            object = BitmapRegionDecoder.newInstance((byte[])object, (int)0, (int)n10, (boolean)false);
            BitmapFactory.Options options = new BitmapFactory.Options();
            object2 = object.decodeRegion(object2, options);
            try {
                object.recycle();
                if (object2 == null) break block10;
            }
            catch (IOException iOException) {
                object = new ImageUtil$CodecFailedException;
                object2 = ImageUtil$CodecFailedException$FailureType.DECODE_FAILED;
                ((ImageUtil$CodecFailedException)object)((String)object3, (ImageUtil$CodecFailedException$FailureType)((Object)object2));
                throw object;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("Decode byte array failed with illegal argument.");
                ((StringBuilder)object3).append(illegalArgumentException);
                String string2 = ((StringBuilder)object3).toString();
                object3 = ImageUtil$CodecFailedException$FailureType.DECODE_FAILED;
                object2 = new ImageUtil$CodecFailedException(string2, (ImageUtil$CodecFailedException$FailureType)((Object)object3));
                throw object2;
            }
            object = new ByteArrayOutputStream;
            ((ByteArrayOutputStream)object)();
            object3 = Bitmap.CompressFormat.JPEG;
            n10 = 100;
            boolean bl2 = object2.compress((Bitmap.CompressFormat)object3, n10, (OutputStream)object);
            if (bl2) {
                object2.recycle();
                return ((ByteArrayOutputStream)object).toByteArray();
            }
            object = new ImageUtil$CodecFailedException;
            object2 = ImageUtil$CodecFailedException$FailureType.ENCODE_FAILED;
            ((ImageUtil$CodecFailedException)object)("Encode bitmap failed.", (ImageUtil$CodecFailedException$FailureType)((Object)object2));
            throw object;
        }
        object = new ImageUtil$CodecFailedException;
        object2 = ImageUtil$CodecFailedException$FailureType.DECODE_FAILED;
        ((ImageUtil$CodecFailedException)object)((String)object3, (ImageUtil$CodecFailedException$FailureType)((Object)object2));
        throw object;
    }

    public static Rational getRotatedAspectRatio(int n10, Rational rational) {
        int n11 = 90;
        if (n10 != n11 && n10 != (n11 = 270)) {
            n11 = rational.getNumerator();
            int n12 = rational.getDenominator();
            Rational rational2 = new Rational(n11, n12);
            return rational2;
        }
        return ImageUtil.inverseRational(rational);
    }

    public static byte[] imageToJpegByteArray(ImageProxy object) {
        int n10;
        int n11 = object.getFormat();
        if (n11 == (n10 = 256)) {
            object = ImageUtil.jpegImageToJpegByteArray((ImageProxy)object);
        } else {
            n11 = object.getFormat();
            if (n11 == (n10 = 35)) {
                object = ImageUtil.yuvImageToJpegByteArray((ImageProxy)object);
            } else {
                CharSequence charSequence = new StringBuilder();
                String string2 = "Unrecognized image format: ";
                charSequence.append(string2);
                int n12 = object.getFormat();
                charSequence.append(n12);
                object = charSequence.toString();
                charSequence = TAG;
                Logger.w((String)charSequence, (String)object);
                n12 = 0;
                object = null;
            }
        }
        return object;
    }

    private static Rational inverseRational(Rational rational) {
        if (rational == null) {
            return rational;
        }
        int n10 = rational.getDenominator();
        int n11 = rational.getNumerator();
        Rational rational2 = new Rational(n10, n11);
        return rational2;
    }

    public static boolean isAspectRatioValid(Rational rational) {
        boolean bl2;
        float f10;
        float f11;
        float f12;
        if (rational != null && (f12 = (f11 = (f10 = rational.floatValue()) - 0.0f) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) > 0 && !(bl2 = rational.isNaN())) {
            bl2 = true;
        } else {
            bl2 = false;
            rational = null;
        }
        return bl2;
    }

    public static boolean isAspectRatioValid(Size size, Rational rational) {
        boolean bl2;
        float f10;
        float f11;
        float f12;
        if (rational != null && (f12 = (f11 = (f10 = rational.floatValue()) - 0.0f) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) > 0 && (bl2 = ImageUtil.isCropAspectRatioHasEffect(size, rational)) && !(bl2 = rational.isNaN())) {
            bl2 = true;
        } else {
            bl2 = false;
            size = null;
        }
        return bl2;
    }

    private static boolean isCropAspectRatioHasEffect(Size size, Rational rational) {
        float f10;
        int n10 = size.getWidth();
        int n11 = size.getHeight();
        int n12 = rational.getNumerator();
        int n13 = rational.getDenominator();
        float f11 = n10;
        float f12 = n12;
        f11 /= f12;
        float f13 = n13;
        int n14 = Math.round(f11 *= f13);
        if (n11 == n14 && n10 == (n11 = Math.round(f10 = (float)n11 / f13 * f12))) {
            n11 = 0;
            f10 = 0.0f;
            size = null;
        } else {
            n11 = 1;
            f10 = Float.MIN_VALUE;
        }
        return n11 != 0;
    }

    private static byte[] jpegImageToJpegByteArray(ImageProxy imageProxy) {
        ByteBuffer byteBuffer = imageProxy.getPlanes()[0].getBuffer();
        int n10 = byteBuffer.capacity();
        byte[] byArray = new byte[n10];
        byteBuffer.rewind();
        byteBuffer.get(byArray);
        boolean bl2 = ImageUtil.shouldCropImage(imageProxy);
        if (bl2) {
            imageProxy = imageProxy.getCropRect();
            byArray = ImageUtil.cropByteArray(byArray, (Rect)imageProxy);
        }
        return byArray;
    }

    public static float min(float f10, float f11, float f12, float f13) {
        f10 = Math.min(f10, f11);
        f11 = Math.min(f12, f13);
        return Math.min(f10, f11);
    }

    private static byte[] nv21ToJpeg(byte[] object, int n10, int n11, Rect rect) {
        boolean bl2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n12 = 17;
        YuvImage yuvImage = new YuvImage(object, n12, n10, n11, null);
        if (rect == null) {
            bl2 = false;
            object = null;
            rect = new Rect(0, 0, n10, n11);
        }
        if (bl2 = yuvImage.compressToJpeg(rect, 100, (OutputStream)byteArrayOutputStream)) {
            return byteArrayOutputStream.toByteArray();
        }
        object = new ImageUtil$CodecFailedException;
        ImageUtil$CodecFailedException$FailureType imageUtil$CodecFailedException$FailureType = ImageUtil$CodecFailedException$FailureType.ENCODE_FAILED;
        object("YuvImage failed to encode jpeg.", imageUtil$CodecFailedException$FailureType);
        throw object;
    }

    private static boolean shouldCropImage(ImageProxy imageProxy) {
        int n10 = imageProxy.getWidth();
        int n11 = imageProxy.getHeight();
        Size size = new Size(n10, n11);
        n11 = imageProxy.getCropRect().width();
        int n12 = imageProxy.getCropRect().height();
        Size size2 = new Size(n11, n12);
        return size2.equals((Object)size) ^ true;
    }

    public static float[] sizeToVertexes(Size size) {
        float f10;
        float f11 = size.getWidth();
        float[] fArray = new float[]{0.0f, 0.0f, f11, 0.0f, f11 = (float)size.getWidth(), f11 = (float)size.getHeight(), 0.0f, f10 = (float)size.getHeight()};
        return fArray;
    }

    private static byte[] yuvImageToJpegByteArray(ImageProxy imageProxy) {
        byte[] byArray = ImageUtil.yuv_420_888toNv21(imageProxy);
        int n10 = imageProxy.getWidth();
        int n11 = imageProxy.getHeight();
        boolean bl2 = ImageUtil.shouldCropImage(imageProxy);
        imageProxy = bl2 ? imageProxy.getCropRect() : null;
        return ImageUtil.nv21ToJpeg(byArray, n10, n11, (Rect)imageProxy);
    }

    public static byte[] yuv_420_888toNv21(ImageProxy imageProxy) {
        int n10;
        int n11;
        ImageProxy$PlaneProxy imageProxy$PlaneProxy = imageProxy.getPlanes()[0];
        Object object = imageProxy.getPlanes();
        int n12 = 1;
        object = object[n12];
        Object object2 = imageProxy.getPlanes();
        int n13 = 2;
        object2 = object2[n13];
        ByteBuffer byteBuffer = imageProxy$PlaneProxy.getBuffer();
        ByteBuffer byteBuffer2 = object.getBuffer();
        ByteBuffer byteBuffer3 = object2.getBuffer();
        byteBuffer.rewind();
        byteBuffer2.rewind();
        byteBuffer3.rewind();
        int n14 = byteBuffer.remaining();
        int n15 = imageProxy.getWidth();
        int n16 = imageProxy.getHeight();
        n15 = n15 * n16 / n13 + n14;
        byte[] byArray = new byte[n15];
        byte[] byArray2 = null;
        int n17 = 0;
        for (n16 = 0; n16 < (n11 = imageProxy.getHeight()); ++n16) {
            n11 = imageProxy.getWidth();
            byteBuffer.get(byArray, n17, n11);
            n11 = imageProxy.getWidth();
            n17 += n11;
            n11 = byteBuffer.position();
            n10 = imageProxy.getWidth();
            n11 -= n10;
            n10 = imageProxy$PlaneProxy.getRowStride();
            n11 += n10;
            n11 = Math.min(n14, n11);
            byteBuffer.position(n11);
        }
        int n18 = imageProxy.getHeight() / n13;
        int n19 = imageProxy.getWidth() / n13;
        n13 = object2.getRowStride();
        n14 = object.getRowStride();
        n12 = object2.getPixelStride();
        int n20 = object.getPixelStride();
        byArray2 = new byte[n13];
        byte[] byArray3 = new byte[n14];
        for (n10 = 0; n10 < n18; ++n10) {
            int n21 = byteBuffer3.remaining();
            n21 = Math.min(n13, n21);
            byteBuffer3.get(byArray2, 0, n21);
            n21 = byteBuffer2.remaining();
            n21 = Math.min(n14, n21);
            byteBuffer2.get(byArray3, 0, n21);
            int n22 = 0;
            int n23 = 0;
            for (n21 = 0; n21 < n19; ++n21) {
                byte by2;
                int n24 = n17 + 1;
                byArray[n17] = by2 = byArray2[n22];
                n17 = n24 + 1;
                byArray[n24] = by2 = byArray3[n23];
                n22 += n12;
                n23 += n20;
            }
        }
        return byArray;
    }
}

