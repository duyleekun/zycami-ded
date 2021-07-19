/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils;

import androidx.camera.core.impl.CameraCaptureMetaData$FlashState;
import androidx.camera.core.impl.utils.ExifData$WhiteBalanceMode;

public class ExifData$1 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState;
    public static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$impl$utils$ExifData$WhiteBalanceMode;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object;
        int n10;
        Enum enum_;
        int n11;
        Object object2;
        int n12 = ExifData$WhiteBalanceMode.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$androidx$camera$core$impl$utils$ExifData$WhiteBalanceMode = nArray;
        int n13 = 1;
        try {
            object2 = ExifData$WhiteBalanceMode.AUTO;
            n11 = ((Enum)object2).ordinal();
            nArray[n11] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = 2;
        try {
            object2 = $SwitchMap$androidx$camera$core$impl$utils$ExifData$WhiteBalanceMode;
            enum_ = ExifData$WhiteBalanceMode.MANUAL;
            n10 = enum_.ordinal();
            object2[n10] = (ExifData$WhiteBalanceMode)n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = CameraCaptureMetaData$FlashState.values().length;
        object2 = new int[n11];
        $SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState = (int[])object2;
        try {
            enum_ = CameraCaptureMetaData$FlashState.READY;
            n10 = enum_.ordinal();
            object2[n10] = (ExifData$WhiteBalanceMode)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = $SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState;
            object2 = CameraCaptureMetaData$FlashState.NONE;
            n11 = ((Enum)object2).ordinal();
            object[n11] = n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState;
            object = (Object)CameraCaptureMetaData$FlashState.FIRED;
            n13 = ((Enum)object).ordinal();
            nArray[n13] = n11 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

