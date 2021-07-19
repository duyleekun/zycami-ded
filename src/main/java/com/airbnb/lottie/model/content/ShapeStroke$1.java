/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.content.ShapeStroke$LineCapType;
import com.airbnb.lottie.model.content.ShapeStroke$LineJoinType;

public class ShapeStroke$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineCapType;
    public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineJoinType;

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
        int n13 = ShapeStroke$LineJoinType.values().length;
        int[] nArray = new int[n13];
        $SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineJoinType = nArray;
        int n14 = 1;
        try {
            object3 = ShapeStroke$LineJoinType.BEVEL;
            n12 = object3.ordinal();
            nArray[n12] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 2;
        try {
            object3 = $SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineJoinType;
            object2 = ShapeStroke$LineJoinType.MITER;
            n11 = ((Enum)object2).ordinal();
            object3[n11] = (ShapeStroke$LineJoinType)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = 3;
        try {
            object2 = $SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineJoinType;
            enum_ = ShapeStroke$LineJoinType.ROUND;
            n10 = enum_.ordinal();
            object2[n10] = (ShapeStroke$LineJoinType)n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = ShapeStroke$LineCapType.values().length;
        object2 = new int[n11];
        $SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineCapType = (int[])object2;
        try {
            enum_ = ShapeStroke$LineCapType.BUTT;
            n10 = enum_.ordinal();
            object2[n10] = (ShapeStroke$LineJoinType)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = $SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineCapType;
            object2 = ShapeStroke$LineCapType.ROUND;
            n11 = ((Enum)object2).ordinal();
            object[n11] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineCapType;
            object = (Object)ShapeStroke$LineCapType.UNKNOWN;
            n14 = ((Enum)object).ordinal();
            nArray[n14] = n12;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

