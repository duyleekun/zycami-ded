/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils;

public final class ExifOutputStream$JpegHeader {
    public static final short APP1 = 225;
    public static final short DAC = 204;
    public static final short DHT = 196;
    public static final short EOI = 217;
    public static final short JPG = 200;
    public static final short SOF0 = 192;
    public static final short SOF15 = 207;
    public static final short SOI = 216;

    private ExifOutputStream$JpegHeader() {
    }

    public static boolean isSofMarker(short n10) {
        int n11 = -64;
        n10 = n10 >= n11 && n10 <= (n11 = -49) && n10 != (n11 = -60) && n10 != (n11 = -56) && n10 != (n11 = -52) ? 1 : 0;
        return n10 != 0;
    }
}

