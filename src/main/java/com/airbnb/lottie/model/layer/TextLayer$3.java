/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.layer;

import com.airbnb.lottie.model.DocumentData$Justification;

public class TextLayer$3 {
    public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        DocumentData$Justification documentData$Justification;
        int n12 = DocumentData$Justification.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification = nArray;
        try {
            documentData$Justification = DocumentData$Justification.LEFT_ALIGN;
            n11 = documentData$Justification.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification;
            documentData$Justification = DocumentData$Justification.RIGHT_ALIGN;
            n11 = documentData$Justification.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification;
            documentData$Justification = DocumentData$Justification.CENTER;
            n11 = documentData$Justification.ordinal();
            nArray[n11] = n10 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

