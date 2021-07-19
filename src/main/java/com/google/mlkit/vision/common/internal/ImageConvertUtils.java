/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.Matrix
 *  android.media.Image
 *  android.media.Image$Plane
 *  android.os.Build$VERSION
 */
package com.google.mlkit.vision.common.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.Image;
import android.os.Build;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.common.InputImage;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class ImageConvertUtils {
    private static final ImageConvertUtils zza;

    static {
        ImageConvertUtils imageConvertUtils;
        zza = imageConvertUtils = new ImageConvertUtils();
    }

    private ImageConvertUtils() {
    }

    public static ImageConvertUtils getInstance() {
        return zza;
    }

    private static Bitmap zza(Bitmap bitmap, int n10, int n11, int n12) {
        if (n10 == 0) {
            return Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)n11, (int)n12);
        }
        Matrix matrix = new Matrix();
        float f10 = n10;
        matrix.postRotate(f10);
        return Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)n11, (int)n12, (Matrix)matrix, (boolean)true);
    }

    private final Bitmap zza(ByteBuffer object, int n10, int n11, int n12) {
        object = ImageConvertUtils.zza(this.byteBufferToByteArray((ByteBuffer)object), n10, n11);
        int n13 = ((Object)object).length;
        return ImageConvertUtils.zza(BitmapFactory.decodeByteArray((byte[])object, (int)0, (int)n13), n12, n10, n11);
    }

    private static ByteBuffer zza(ByteBuffer byteBuffer, boolean bl2) {
        int n10;
        int n11;
        byteBuffer.rewind();
        int n12 = byteBuffer.limit();
        int n13 = n12 / 6;
        ByteBuffer byteBuffer2 = bl2 ? ByteBuffer.allocate(n12) : ByteBuffer.allocateDirect(n12);
        n12 = 0;
        for (n11 = 0; n11 < (n10 = n13 << 2); ++n11) {
            n10 = byteBuffer.get(n11);
            byteBuffer2.put(n11, (byte)n10);
        }
        while (n12 < (n11 = n13 << 1)) {
            n11 = n10 + n12;
            byte by2 = n12 % 2 * n13 + n10;
            int n14 = n12 / 2;
            by2 += n14;
            by2 = byteBuffer.get(by2);
            byteBuffer2.put(n11, by2);
            ++n12;
        }
        return byteBuffer2;
    }

    private static ByteBuffer zza(Image.Plane[] object, int n10, int n11) {
        int n12 = n10 * n11;
        int n13 = n12 / 4;
        int n14 = 2;
        byte[] byArray = new byte[n13 * n14 + n12];
        n13 = 1;
        ByteBuffer byteBuffer = object[n13].getBuffer();
        Object object2 = object[n14].getBuffer();
        int n15 = ((Buffer)object2).position();
        int n16 = byteBuffer.limit();
        int n17 = n15 + 1;
        ((ByteBuffer)object2).position(n17);
        n17 = n16 + -1;
        byteBuffer.limit(n17);
        n17 = ((Buffer)object2).remaining();
        int n18 = n12 * 2 / 4;
        int n19 = n18 + -2;
        int n20 = 0;
        n17 = n17 == n19 && (n17 = ((ByteBuffer)object2).compareTo(byteBuffer)) == 0 ? n13 : 0;
        ((ByteBuffer)object2).position(n15);
        byteBuffer.limit(n16);
        if (n17 != 0) {
            object[0].getBuffer().get(byArray, 0, n12);
            ByteBuffer byteBuffer2 = object[n13].getBuffer();
            object = object[n14].getBuffer();
            ((ByteBuffer)object).get(byArray, n12, n13);
            byteBuffer2.get(byArray, n12 += n13, n18 -= n13);
        } else {
            Image.Plane plane = object[0];
            n16 = n10;
            n17 = n11;
            ImageConvertUtils.zza(plane, n10, n11, byArray, 0, 1);
            plane = object[n13];
            n19 = n12 + 1;
            n20 = 2;
            ImageConvertUtils.zza(plane, n10, n11, byArray, n19, n20);
            Object object3 = object[n14];
            n15 = 2;
            n14 = n10;
            object2 = byArray;
            ImageConvertUtils.zza((Image.Plane)object3, n10, n11, byArray, n12, n15);
        }
        return ByteBuffer.wrap(byArray);
    }

    private static void zza(Image.Plane plane, int n10, int n11, byte[] byArray, int n12, int n13) {
        ByteBuffer byteBuffer = plane.getBuffer();
        byteBuffer.rewind();
        int n14 = byteBuffer.limit();
        int n15 = plane.getRowStride();
        n14 = n14 + n15 + -1;
        n15 = plane.getRowStride();
        if ((n14 /= n15) == 0) {
            return;
        }
        n10 /= (n11 /= n14);
        n11 = 0;
        int n16 = 0;
        for (n15 = 0; n15 < n14; ++n15) {
            int n17;
            int n18 = n16;
            for (n17 = 0; n17 < n10; ++n17) {
                int n19;
                byArray[n12] = n19 = byteBuffer.get(n18);
                n12 += n13;
                n19 = plane.getPixelStride();
                n18 += n19;
            }
            n17 = plane.getRowStride();
            n16 += n17;
        }
    }

    /*
     * Exception decompiling
     */
    private static byte[] zza(byte[] var0, int var1_2, int var2_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public byte[] byteBufferToByteArray(ByteBuffer byteBuffer) {
        int n10 = byteBuffer.hasArray();
        if (n10 != 0 && (n10 = byteBuffer.arrayOffset()) == 0) {
            return byteBuffer.array();
        }
        byteBuffer.rewind();
        n10 = byteBuffer.limit();
        byte[] byArray = new byte[n10];
        byteBuffer.get(byArray, 0, n10);
        return byArray;
    }

    public ByteBuffer cloneByteBuffer(ByteBuffer byteBuffer) {
        Preconditions.checkNotNull(byteBuffer);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(byteBuffer.capacity());
        byteBuffer.rewind();
        byteBuffer2.put(byteBuffer);
        byteBuffer.rewind();
        byteBuffer2.flip();
        return byteBuffer2;
    }

    public Bitmap convertJpegToUpRightBitmap(Image object, int n10) {
        Object object2;
        int n11 = object.getFormat();
        int n12 = 1;
        int n13 = 256;
        if (n11 == n13) {
            n11 = n12;
        } else {
            n11 = 0;
            object2 = null;
        }
        Object object3 = "Only JPEG and YUV_420_888 are supported now";
        Preconditions.checkArgument(n11 != 0, object3);
        object2 = object.getPlanes();
        if (object2 != null && (n13 = ((Image.Plane[])object2).length) == n12) {
            object2 = object2[0].getBuffer();
            ((ByteBuffer)object2).rewind();
            n12 = ((Buffer)object2).remaining();
            object3 = new byte[n12];
            ((ByteBuffer)object2).get((byte[])object3);
            object2 = BitmapFactory.decodeByteArray((byte[])object3, (int)0, (int)n12);
            n12 = object.getWidth();
            int n14 = object.getHeight();
            return ImageConvertUtils.zza((Bitmap)object2, n10, n12, n14);
        }
        object = new IllegalArgumentException("Unexpected image format, JPEG should have exactly 1 image plane");
        throw object;
    }

    public ByteBuffer convertToNv21Buffer(InputImage inputImage, boolean n10) {
        int n11;
        int n12 = n10;
        int n13 = inputImage.getFormat();
        if (n13 != (n11 = -1)) {
            n11 = 17;
            if (n13 != n11) {
                n11 = 35;
                int n14 = 13;
                String string2 = "Unsupported image format";
                if (n13 != n11) {
                    n11 = 842094169;
                    if (n13 == n11) {
                        return ImageConvertUtils.zza(inputImage.getByteBuffer(), n10 != 0);
                    }
                    MlKitException mlKitException = new MlKitException(string2, n14);
                    throw mlKitException;
                }
                n12 = Build.VERSION.SDK_INT;
                n13 = 19;
                if (n12 >= n13) {
                    Image.Plane[] planeArray = inputImage.getPlanes();
                    n13 = inputImage.getWidth();
                    n11 = inputImage.getHeight();
                    return ImageConvertUtils.zza(planeArray, n13, n11);
                }
                MlKitException mlKitException = new MlKitException(string2, n14);
                throw mlKitException;
            }
            if (n10 != 0) {
                ByteBuffer byteBuffer = inputImage.getByteBuffer();
                n13 = (int)(byteBuffer.hasArray() ? 1 : 0);
                if (n13 != 0) {
                    return byteBuffer;
                }
                byteBuffer.rewind();
                byte[] byArray = new byte[byteBuffer.limit()];
                byteBuffer.get(byArray);
                return ByteBuffer.wrap(byArray);
            }
            return inputImage.getByteBuffer();
        }
        Bitmap bitmap = inputImage.getBitmapInternal();
        int n15 = bitmap.getWidth();
        int n16 = bitmap.getHeight();
        int n17 = n15 * n16;
        int[] nArray = new int[n17];
        int n18 = 0;
        int n19 = 0;
        int n20 = 0;
        int n21 = n15;
        int n22 = n15;
        int n23 = n16;
        bitmap.getPixels(nArray, 0, n15, 0, 0, n15, n16);
        double d10 = n16;
        double d11 = 2.0;
        d10 = Math.ceil(d10 / d11);
        n13 = (int)d10 * 2;
        double d12 = (double)n15 / d11;
        double d13 = Math.ceil(d12);
        n11 = (int)d13;
        n13 = n13 * n11 + n17;
        ByteBuffer byteBuffer = n10 != 0 ? ByteBuffer.allocate(n13) : ByteBuffer.allocateDirect(n13);
        n13 = 0;
        bitmap = null;
        n18 = 0;
        n21 = 0;
        Object var7_9 = null;
        for (n11 = 0; n11 < n16; ++n11) {
            for (n19 = 0; n19 < n15; ++n19) {
                n20 = nArray[n21] >> 16;
                n22 = 255;
                n23 = nArray[n21] >> 8 & n22;
                byte by2 = nArray[n21] & n22;
                int n24 = (n20 &= n22) * 66;
                int n25 = n23 * 129;
                n24 += n25;
                n25 = by2 * 25;
                n24 = (n24 + n25 + 128 >> 8) + 16;
                n25 = n20 * -38;
                int n26 = n23 * 74;
                n25 -= n26;
                n26 = by2 * 112;
                n25 = (n25 + n26 + 128 >> 8) + 128;
                n20 *= 112;
                n20 -= (n23 *= 94);
                n20 = (n20 - (by2 *= 18) + 128 >> 8) + 128;
                n23 = n18 + 1;
                byte by2 = n24 < 0 ? (byte)0 : Math.min(n22, n24);
                by2 = by2;
                byteBuffer.put(n18, by2);
                n18 = n11 % 2;
                if (n18 == 0 && (n18 = n21 % 2) == 0) {
                    n18 = n17 + 1;
                    n20 = n20 < 0 ? 0 : Math.min(n22, n20);
                    n20 = (byte)n20;
                    byteBuffer.put(n17, (byte)n20);
                    n17 = n18 + 1;
                    n20 = n25 < 0 ? 0 : Math.min(n22, n25);
                    n20 = (byte)n20;
                    byteBuffer.put(n18, (byte)n20);
                }
                ++n21;
                n18 = n23;
            }
        }
        return byteBuffer;
    }

    public Bitmap convertToUpRightBitmap(InputImage object) {
        int n10;
        int n11 = ((InputImage)object).getFormat();
        if (n11 != (n10 = -1)) {
            n10 = 17;
            if (n11 != n10) {
                n10 = 35;
                int n12 = 13;
                String string2 = "Unsupported image format";
                if (n11 != n10) {
                    n10 = 842094169;
                    if (n11 == n10) {
                        Object object2 = ((InputImage)object).getByteBuffer();
                        n10 = ((InputImage)object).getWidth();
                        n12 = ((InputImage)object).getHeight();
                        int n13 = ((InputImage)object).getRotationDegrees();
                        object2 = ImageConvertUtils.zza(ImageConvertUtils.zza((ByteBuffer)object2, true).array(), n10, n12);
                        int n14 = ((Object)object2).length;
                        return ImageConvertUtils.zza(BitmapFactory.decodeByteArray((byte[])object2, (int)0, (int)n14), n13, n10, n12);
                    }
                    object = new MlKitException(string2, n12);
                    throw object;
                }
                n11 = Build.VERSION.SDK_INT;
                n10 = 19;
                if (n11 >= n10) {
                    Object object3 = ((InputImage)object).getPlanes();
                    n10 = ((InputImage)object).getWidth();
                    n12 = ((InputImage)object).getHeight();
                    object3 = ImageConvertUtils.zza(object3, n10, n12);
                    n10 = ((InputImage)object).getWidth();
                    n12 = ((InputImage)object).getHeight();
                    int n15 = ((InputImage)object).getRotationDegrees();
                    return this.zza((ByteBuffer)object3, n10, n12, n15);
                }
                object = new MlKitException(string2, n12);
                throw object;
            }
            ByteBuffer byteBuffer = ((InputImage)object).getByteBuffer();
            n10 = ((InputImage)object).getWidth();
            int n16 = ((InputImage)object).getHeight();
            int n17 = ((InputImage)object).getRotationDegrees();
            return this.zza(byteBuffer, n10, n16, n17);
        }
        Bitmap bitmap = ((InputImage)object).getBitmapInternal();
        n10 = ((InputImage)object).getRotationDegrees();
        int n18 = ((InputImage)object).getWidth();
        int n19 = ((InputImage)object).getHeight();
        return ImageConvertUtils.zza(bitmap, n10, n18, n19);
    }

    public Bitmap getUpRightBitmap(InputImage inputImage) {
        Bitmap bitmap = inputImage.getBitmapInternal();
        if (bitmap != null) {
            bitmap = inputImage.getBitmapInternal();
            int n10 = inputImage.getRotationDegrees();
            int n11 = inputImage.getWidth();
            int n12 = inputImage.getHeight();
            return ImageConvertUtils.zza(bitmap, n10, n11, n12);
        }
        return this.convertToUpRightBitmap(inputImage);
    }
}

