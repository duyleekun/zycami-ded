/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.animation.content;

import com.airbnb.lottie.model.content.PolystarShape$Type;

public class PolystarContent$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        PolystarShape$Type polystarShape$Type;
        int n12 = PolystarShape$Type.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type = nArray;
        try {
            polystarShape$Type = PolystarShape$Type.STAR;
            n11 = polystarShape$Type.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type;
            polystarShape$Type = PolystarShape$Type.POLYGON;
            n11 = polystarShape$Type.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

