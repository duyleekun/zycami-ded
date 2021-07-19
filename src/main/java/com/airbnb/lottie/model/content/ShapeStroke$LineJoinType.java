/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Paint$Join
 */
package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import com.airbnb.lottie.model.content.ShapeStroke$1;

public final class ShapeStroke$LineJoinType
extends Enum {
    private static final /* synthetic */ ShapeStroke$LineJoinType[] $VALUES;
    public static final /* enum */ ShapeStroke$LineJoinType BEVEL;
    public static final /* enum */ ShapeStroke$LineJoinType MITER;
    public static final /* enum */ ShapeStroke$LineJoinType ROUND;

    static {
        ShapeStroke$LineJoinType shapeStroke$LineJoinType;
        ShapeStroke$LineJoinType shapeStroke$LineJoinType2;
        ShapeStroke$LineJoinType shapeStroke$LineJoinType3;
        MITER = shapeStroke$LineJoinType3 = new ShapeStroke$LineJoinType("MITER", 0);
        int n10 = 1;
        ROUND = shapeStroke$LineJoinType2 = new ShapeStroke$LineJoinType("ROUND", n10);
        int n11 = 2;
        BEVEL = shapeStroke$LineJoinType = new ShapeStroke$LineJoinType("BEVEL", n11);
        ShapeStroke$LineJoinType[] shapeStroke$LineJoinTypeArray = new ShapeStroke$LineJoinType[3];
        shapeStroke$LineJoinTypeArray[0] = shapeStroke$LineJoinType3;
        shapeStroke$LineJoinTypeArray[n10] = shapeStroke$LineJoinType2;
        shapeStroke$LineJoinTypeArray[n11] = shapeStroke$LineJoinType;
        $VALUES = shapeStroke$LineJoinTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ShapeStroke$LineJoinType() {
        void var2_-1;
        void var1_-1;
    }

    public static ShapeStroke$LineJoinType valueOf(String string2) {
        return Enum.valueOf(ShapeStroke$LineJoinType.class, string2);
    }

    public static ShapeStroke$LineJoinType[] values() {
        return (ShapeStroke$LineJoinType[])$VALUES.clone();
    }

    public Paint.Join toPaintJoin() {
        int[] nArray = ShapeStroke$1.$SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineJoinType;
        int n10 = this.ordinal();
        int n11 = nArray[n10];
        if (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 != n10) {
                n10 = 3;
                if (n11 != n10) {
                    return null;
                }
                return Paint.Join.ROUND;
            }
            return Paint.Join.MITER;
        }
        return Paint.Join.BEVEL;
    }
}

