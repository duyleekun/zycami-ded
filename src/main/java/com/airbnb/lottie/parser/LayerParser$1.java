/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.layer.Layer$MatteType;

public class LayerParser$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        Layer$MatteType layer$MatteType;
        int n12 = Layer$MatteType.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType = nArray;
        try {
            layer$MatteType = Layer$MatteType.LUMA;
            n11 = layer$MatteType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType;
            layer$MatteType = Layer$MatteType.LUMA_INVERTED;
            n11 = layer$MatteType.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

