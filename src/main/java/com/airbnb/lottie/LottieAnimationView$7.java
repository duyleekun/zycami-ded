/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.RenderMode;

public class LottieAnimationView$7 {
    public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$RenderMode;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        RenderMode renderMode;
        int n12 = RenderMode.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$airbnb$lottie$RenderMode = nArray;
        try {
            renderMode = RenderMode.HARDWARE;
            n11 = renderMode.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$airbnb$lottie$RenderMode;
            renderMode = RenderMode.SOFTWARE;
            n11 = renderMode.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$airbnb$lottie$RenderMode;
            renderMode = RenderMode.AUTOMATIC;
            n11 = renderMode.ordinal();
            nArray[n11] = n10 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

