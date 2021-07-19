/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.internal.utils;

public final class ImageUtil$CodecFailedException$FailureType
extends Enum {
    private static final /* synthetic */ ImageUtil$CodecFailedException$FailureType[] $VALUES;
    public static final /* enum */ ImageUtil$CodecFailedException$FailureType DECODE_FAILED;
    public static final /* enum */ ImageUtil$CodecFailedException$FailureType ENCODE_FAILED;
    public static final /* enum */ ImageUtil$CodecFailedException$FailureType UNKNOWN;

    static {
        ImageUtil$CodecFailedException$FailureType imageUtil$CodecFailedException$FailureType;
        ImageUtil$CodecFailedException$FailureType imageUtil$CodecFailedException$FailureType2;
        ImageUtil$CodecFailedException$FailureType imageUtil$CodecFailedException$FailureType3;
        ENCODE_FAILED = imageUtil$CodecFailedException$FailureType3 = new ImageUtil$CodecFailedException$FailureType("ENCODE_FAILED", 0);
        int n10 = 1;
        DECODE_FAILED = imageUtil$CodecFailedException$FailureType2 = new ImageUtil$CodecFailedException$FailureType("DECODE_FAILED", n10);
        int n11 = 2;
        UNKNOWN = imageUtil$CodecFailedException$FailureType = new ImageUtil$CodecFailedException$FailureType("UNKNOWN", n11);
        ImageUtil$CodecFailedException$FailureType[] imageUtil$CodecFailedException$FailureTypeArray = new ImageUtil$CodecFailedException$FailureType[3];
        imageUtil$CodecFailedException$FailureTypeArray[0] = imageUtil$CodecFailedException$FailureType3;
        imageUtil$CodecFailedException$FailureTypeArray[n10] = imageUtil$CodecFailedException$FailureType2;
        imageUtil$CodecFailedException$FailureTypeArray[n11] = imageUtil$CodecFailedException$FailureType;
        $VALUES = imageUtil$CodecFailedException$FailureTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ImageUtil$CodecFailedException$FailureType() {
        void var2_-1;
        void var1_-1;
    }

    public static ImageUtil$CodecFailedException$FailureType valueOf(String string2) {
        return Enum.valueOf(ImageUtil$CodecFailedException$FailureType.class, string2);
    }

    public static ImageUtil$CodecFailedException$FailureType[] values() {
        return (ImageUtil$CodecFailedException$FailureType[])$VALUES.clone();
    }
}

