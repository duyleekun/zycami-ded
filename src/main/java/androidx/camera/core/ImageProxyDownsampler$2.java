/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ImageProxyDownsampler$DownsamplingMethod;

public class ImageProxyDownsampler$2 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$ImageProxyDownsampler$DownsamplingMethod;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        ImageProxyDownsampler$DownsamplingMethod imageProxyDownsampler$DownsamplingMethod;
        int n12 = ImageProxyDownsampler$DownsamplingMethod.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$androidx$camera$core$ImageProxyDownsampler$DownsamplingMethod = nArray;
        try {
            imageProxyDownsampler$DownsamplingMethod = ImageProxyDownsampler$DownsamplingMethod.NEAREST_NEIGHBOR;
            n11 = imageProxyDownsampler$DownsamplingMethod.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$core$ImageProxyDownsampler$DownsamplingMethod;
            imageProxyDownsampler$DownsamplingMethod = ImageProxyDownsampler$DownsamplingMethod.AVERAGING;
            n11 = imageProxyDownsampler$DownsamplingMethod.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

