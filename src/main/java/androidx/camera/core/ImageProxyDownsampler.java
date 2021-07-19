/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package androidx.camera.core;

import android.util.Size;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageProxy$PlaneProxy;
import androidx.camera.core.ImageProxyDownsampler$1;
import androidx.camera.core.ImageProxyDownsampler$2;
import androidx.camera.core.ImageProxyDownsampler$DownsamplingMethod;
import androidx.camera.core.ImageProxyDownsampler$ForwardingImageProxyImpl;
import java.nio.ByteBuffer;

public final class ImageProxyDownsampler {
    private ImageProxyDownsampler() {
    }

    private static ImageProxy$PlaneProxy createPlaneProxy(int n10, int n11, byte[] byArray) {
        ImageProxyDownsampler$1 imageProxyDownsampler$1 = new ImageProxyDownsampler$1(byArray, n10, n11);
        return imageProxyDownsampler$1;
    }

    public static ForwardingImageProxy downsample(ImageProxy imageProxy, int n10, int n11, ImageProxyDownsampler$DownsamplingMethod imageProxyDownsampler$DownsamplingMethod) {
        int n12;
        Object object = imageProxy;
        int n13 = n10;
        int n14 = n11;
        int n15 = imageProxy.getFormat();
        if (n15 == (n12 = 35)) {
            n15 = imageProxy.getWidth();
            if (n15 >= n10 && (n15 = imageProxy.getHeight()) >= n11) {
                int n16;
                int n17;
                int n18;
                n15 = imageProxy.getWidth();
                if (n15 == n10 && (n15 = imageProxy.getHeight()) == n11) {
                    ImageProxy$PlaneProxy[] imageProxy$PlaneProxyArray = imageProxy.getPlanes();
                    ImageProxyDownsampler$ForwardingImageProxyImpl imageProxyDownsampler$ForwardingImageProxyImpl = new ImageProxyDownsampler$ForwardingImageProxyImpl(imageProxy, imageProxy$PlaneProxyArray, n10, n11);
                    return imageProxyDownsampler$ForwardingImageProxyImpl;
                }
                n15 = 3;
                int[] nArray = new int[n15];
                int n19 = imageProxy.getWidth();
                nArray[0] = n19;
                n19 = imageProxy.getWidth();
                int n20 = 2;
                int n21 = 1;
                nArray[n21] = n19 /= n20;
                nArray[n20] = n19 = imageProxy.getWidth() / n20;
                int[] nArray2 = new int[n15];
                nArray2[0] = n18 = imageProxy.getHeight();
                nArray2[n21] = n18 = imageProxy.getHeight() / n20;
                nArray2[n20] = n18 = imageProxy.getHeight() / n20;
                int[] nArray3 = new int[n15];
                nArray3[0] = n13;
                nArray3[n21] = n17 = n13 / 2;
                nArray3[n20] = n17;
                int[] nArray4 = new int[n15];
                nArray4[0] = n14;
                nArray4[n21] = n16 = n14 / 2;
                nArray4[n20] = n16;
                ImageProxy$PlaneProxy[] imageProxy$PlaneProxyArray = new ImageProxy$PlaneProxy[n15];
                for (int i10 = 0; i10 < n15; ++i10) {
                    int n22;
                    int n23;
                    int n24;
                    int n25;
                    byte[] byArray;
                    ImageProxy$PlaneProxy imageProxy$PlaneProxy = imageProxy.getPlanes()[i10];
                    Object object2 = imageProxy$PlaneProxy.getBuffer();
                    int n26 = nArray3[i10];
                    int n27 = nArray4[i10];
                    byte[] byArray2 = new byte[n26 * n27];
                    int[] nArray5 = ImageProxyDownsampler$2.$SwitchMap$androidx$camera$core$ImageProxyDownsampler$DownsamplingMethod;
                    int n28 = imageProxyDownsampler$DownsamplingMethod.ordinal();
                    n26 = nArray5[n28];
                    if (n26 != n21) {
                        if (n26 != n20) {
                            byArray = byArray2;
                        } else {
                            n26 = nArray[i10];
                            n28 = imageProxy$PlaneProxy.getPixelStride();
                            n25 = imageProxy$PlaneProxy.getRowStride();
                            n24 = nArray2[i10];
                            n23 = nArray3[i10];
                            n22 = nArray4[i10];
                            byArray = byArray2;
                            n27 = n28;
                            n28 = n25;
                            ImageProxyDownsampler.resizeAveraging((ByteBuffer)object2, n26, n27, n25, n24, byArray2, n23, n22);
                        }
                    } else {
                        byArray = byArray2;
                        n26 = nArray[i10];
                        n27 = imageProxy$PlaneProxy.getPixelStride();
                        n28 = imageProxy$PlaneProxy.getRowStride();
                        n24 = nArray2[i10];
                        n23 = nArray3[i10];
                        n22 = nArray4[i10];
                        ImageProxyDownsampler.resizeNearestNeighbor((ByteBuffer)object2, n26, n27, n28, n24, byArray2, n23, n22);
                    }
                    n25 = nArray3[i10];
                    object2 = byArray;
                    imageProxy$PlaneProxyArray[i10] = imageProxy$PlaneProxy = ImageProxyDownsampler.createPlaneProxy(n25, n21, byArray);
                }
                ImageProxyDownsampler$ForwardingImageProxyImpl imageProxyDownsampler$ForwardingImageProxyImpl = new ImageProxyDownsampler$ForwardingImageProxyImpl((ImageProxy)object, imageProxy$PlaneProxyArray, n13, n14);
                return imageProxyDownsampler$ForwardingImageProxyImpl;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Downsampled dimension ");
            Size size = new Size(n13, n14);
            stringBuilder.append(size);
            stringBuilder.append(" is not <= original dimension ");
            n14 = imageProxy.getWidth();
            int n29 = imageProxy.getHeight();
            Size size2 = new Size(n14, n29);
            stringBuilder.append(size2);
            stringBuilder.append(".");
            object = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
        object = new UnsupportedOperationException("Only YUV_420_888 format is currently supported.");
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void resizeAveraging(ByteBuffer byteBuffer, int n10, int n11, int n12, int n13, byte[] byArray, int n14, int n15) {
        int n16;
        int n17;
        ByteBuffer byteBuffer2 = byteBuffer;
        int n18 = n12;
        int n19 = n13;
        int n20 = n14;
        int n21 = n10;
        int n22 = n15;
        float f10 = n10;
        float f11 = n14;
        f10 /= f11;
        f11 = n13;
        float f12 = n15;
        f11 /= f12;
        byte[] byArray2 = new byte[n12];
        byte[] byArray3 = new byte[n12];
        int[] nArray = new int[n14];
        int n23 = 0;
        float f13 = 0.0f;
        for (n17 = 0; n17 < n20; ++n17) {
            float f14 = (float)n17 * f10;
            nArray[n17] = n16 = (int)f14 * n11;
        }
        synchronized (byteBuffer) {
            byteBuffer.rewind();
            n21 = 0;
            f10 = 0.0f;
            while (n21 < n22) {
                f13 = (float)n21 * f11;
                n17 = (int)f13;
                n16 = n19 + -1;
                int n24 = Math.min(n17, n16) * n18;
                ++n17;
                n17 = Math.min(n17, n16) * n18;
                n16 = n21 * n20;
                byteBuffer2.position(n24);
                n24 = byteBuffer.remaining();
                n24 = Math.min(n18, n24);
                byteBuffer2.get(byArray2, 0, n24);
                byteBuffer2.position(n17);
                n17 = byteBuffer.remaining();
                n17 = Math.min(n18, n17);
                byteBuffer2.get(byArray3, 0, n17);
                f13 = 0.0f;
                for (n17 = 0; n17 < n20; ++n17) {
                    n24 = nArray[n17];
                    n24 = byArray2[n24] & 0xFF;
                    int n25 = nArray[n17] + n11;
                    n25 = byArray2[n25] & 0xFF;
                    int n26 = nArray[n17];
                    n26 = byArray3[n26] & 0xFF;
                    int n27 = nArray[n17] + n11;
                    n23 = byArray3[n27] & 0xFF;
                    n24 = n24 + n25 + n26 + n23;
                    n24 /= 4;
                    n23 = n16 + n17;
                    byArray[n23] = n24 = (int)((byte)(n24 & 0xFF));
                    n23 = 0;
                }
                ++n21;
                n23 = 0;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void resizeNearestNeighbor(ByteBuffer byteBuffer, int n10, int n11, int n12, int n13, byte[] byArray, int n14, int n15) {
        int n16;
        int n17;
        float f10 = n10;
        float f11 = n14;
        f10 /= f11;
        f11 = n13;
        float f12 = n15;
        f11 /= f12;
        byte[] byArray2 = new byte[n12];
        int[] nArray = new int[n14];
        for (n17 = 0; n17 < n14; ++n17) {
            float f13 = (float)n17 * f10;
            nArray[n17] = n16 = (int)f13 * n11;
        }
        synchronized (byteBuffer) {
            byteBuffer.rewind();
            n10 = 0;
            Object var16_16 = null;
            f10 = 0.0f;
            while (n10 < n15) {
                float f14 = (float)n10 * f11;
                n11 = (int)f14;
                n17 = n13 + -1;
                n11 = Math.min(n11, n17) * n12;
                n17 = n10 * n14;
                byteBuffer.position(n11);
                n11 = byteBuffer.remaining();
                n11 = Math.min(n12, n11);
                byteBuffer.get(byArray2, 0, n11);
                f14 = 0.0f;
                for (n11 = 0; n11 < n14; ++n11) {
                    n16 = n17 + n11;
                    int n18 = nArray[n11];
                    byArray[n16] = n18 = byArray2[n18];
                }
                ++n10;
            }
            return;
        }
    }
}

