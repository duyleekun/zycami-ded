/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Paint$Cap
 */
package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import com.airbnb.lottie.model.content.ShapeStroke$1;

public final class ShapeStroke$LineCapType
extends Enum {
    private static final /* synthetic */ ShapeStroke$LineCapType[] $VALUES;
    public static final /* enum */ ShapeStroke$LineCapType BUTT;
    public static final /* enum */ ShapeStroke$LineCapType ROUND;
    public static final /* enum */ ShapeStroke$LineCapType UNKNOWN;

    static {
        ShapeStroke$LineCapType shapeStroke$LineCapType;
        ShapeStroke$LineCapType shapeStroke$LineCapType2;
        ShapeStroke$LineCapType shapeStroke$LineCapType3;
        BUTT = shapeStroke$LineCapType3 = new ShapeStroke$LineCapType("BUTT", 0);
        int n10 = 1;
        ROUND = shapeStroke$LineCapType2 = new ShapeStroke$LineCapType("ROUND", n10);
        int n11 = 2;
        UNKNOWN = shapeStroke$LineCapType = new ShapeStroke$LineCapType("UNKNOWN", n11);
        ShapeStroke$LineCapType[] shapeStroke$LineCapTypeArray = new ShapeStroke$LineCapType[3];
        shapeStroke$LineCapTypeArray[0] = shapeStroke$LineCapType3;
        shapeStroke$LineCapTypeArray[n10] = shapeStroke$LineCapType2;
        shapeStroke$LineCapTypeArray[n11] = shapeStroke$LineCapType;
        $VALUES = shapeStroke$LineCapTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ShapeStroke$LineCapType() {
        void var2_-1;
        void var1_-1;
    }

    public static ShapeStroke$LineCapType valueOf(String string2) {
        return Enum.valueOf(ShapeStroke$LineCapType.class, string2);
    }

    public static ShapeStroke$LineCapType[] values() {
        return (ShapeStroke$LineCapType[])$VALUES.clone();
    }

    public Paint.Cap toPaintCap() {
        int[] nArray = ShapeStroke$1.$SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineCapType;
        int n10 = this.ordinal();
        int n11 = nArray[n10];
        if (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 != n10) {
                return Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }
        return Paint.Cap.BUTT;
    }
}

