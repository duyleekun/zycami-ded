/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.internal.utils.ImageUtil$CodecFailedException$FailureType;

public class ImageSaver$1 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        ImageUtil$CodecFailedException$FailureType imageUtil$CodecFailedException$FailureType;
        int n12 = ImageUtil$CodecFailedException$FailureType.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType = nArray;
        try {
            imageUtil$CodecFailedException$FailureType = ImageUtil$CodecFailedException$FailureType.ENCODE_FAILED;
            n11 = imageUtil$CodecFailedException$FailureType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType;
            imageUtil$CodecFailedException$FailureType = ImageUtil$CodecFailedException$FailureType.DECODE_FAILED;
            n11 = imageUtil$CodecFailedException$FailureType.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType;
            imageUtil$CodecFailedException$FailureType = ImageUtil$CodecFailedException$FailureType.UNKNOWN;
            n11 = imageUtil$CodecFailedException$FailureType.ordinal();
            nArray[n11] = n10 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

