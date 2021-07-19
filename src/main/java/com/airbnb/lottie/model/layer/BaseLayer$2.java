/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.layer;

import com.airbnb.lottie.model.content.Mask$MaskMode;
import com.airbnb.lottie.model.layer.Layer$LayerType;

public class BaseLayer$2 {
    public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode;
    public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType;

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
        int n12;
        Object object3;
        int n13;
        Object object4;
        int n14 = Mask$MaskMode.values().length;
        int[] nArray = new int[n14];
        $SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode = nArray;
        int n15 = 1;
        try {
            object4 = Mask$MaskMode.MASK_MODE_NONE;
            n13 = object4.ordinal();
            nArray[n13] = n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n14 = 2;
        try {
            object4 = $SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode;
            object3 = Mask$MaskMode.MASK_MODE_SUBTRACT;
            n12 = object3.ordinal();
            object4[n12] = (Mask$MaskMode)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 3;
        try {
            object3 = $SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode;
            object2 = Mask$MaskMode.MASK_MODE_INTERSECT;
            n11 = ((Enum)object2).ordinal();
            object3[n11] = (Mask$MaskMode)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = 4;
        try {
            object2 = $SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode;
            enum_ = Mask$MaskMode.MASK_MODE_ADD;
            n10 = enum_.ordinal();
            object2[n10] = (Mask$MaskMode)n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = Layer$LayerType.values().length;
        object2 = new int[n11];
        $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType = (int[])object2;
        try {
            enum_ = Layer$LayerType.SHAPE;
            n10 = enum_.ordinal();
            object2[n10] = (Mask$MaskMode)n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType;
            object2 = Layer$LayerType.PRE_COMP;
            n11 = ((Enum)object2).ordinal();
            object[n11] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType;
            object = (Object)Layer$LayerType.SOLID;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType;
            object = Layer$LayerType.IMAGE;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType;
            object = Layer$LayerType.NULL;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n13 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType;
            object = Layer$LayerType.TEXT;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n13 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType;
            object = Layer$LayerType.UNKNOWN;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n13 = 7;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

