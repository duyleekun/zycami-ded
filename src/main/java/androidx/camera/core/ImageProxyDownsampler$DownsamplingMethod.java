/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

public final class ImageProxyDownsampler$DownsamplingMethod
extends Enum {
    private static final /* synthetic */ ImageProxyDownsampler$DownsamplingMethod[] $VALUES;
    public static final /* enum */ ImageProxyDownsampler$DownsamplingMethod AVERAGING;
    public static final /* enum */ ImageProxyDownsampler$DownsamplingMethod NEAREST_NEIGHBOR;

    static {
        ImageProxyDownsampler$DownsamplingMethod imageProxyDownsampler$DownsamplingMethod;
        ImageProxyDownsampler$DownsamplingMethod imageProxyDownsampler$DownsamplingMethod2;
        NEAREST_NEIGHBOR = imageProxyDownsampler$DownsamplingMethod2 = new ImageProxyDownsampler$DownsamplingMethod("NEAREST_NEIGHBOR", 0);
        int n10 = 1;
        AVERAGING = imageProxyDownsampler$DownsamplingMethod = new ImageProxyDownsampler$DownsamplingMethod("AVERAGING", n10);
        ImageProxyDownsampler$DownsamplingMethod[] imageProxyDownsampler$DownsamplingMethodArray = new ImageProxyDownsampler$DownsamplingMethod[2];
        imageProxyDownsampler$DownsamplingMethodArray[0] = imageProxyDownsampler$DownsamplingMethod2;
        imageProxyDownsampler$DownsamplingMethodArray[n10] = imageProxyDownsampler$DownsamplingMethod;
        $VALUES = imageProxyDownsampler$DownsamplingMethodArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ImageProxyDownsampler$DownsamplingMethod() {
        void var2_-1;
        void var1_-1;
    }

    public static ImageProxyDownsampler$DownsamplingMethod valueOf(String string2) {
        return Enum.valueOf(ImageProxyDownsampler$DownsamplingMethod.class, string2);
    }

    public static ImageProxyDownsampler$DownsamplingMethod[] values() {
        return (ImageProxyDownsampler$DownsamplingMethod[])$VALUES.clone();
    }
}

