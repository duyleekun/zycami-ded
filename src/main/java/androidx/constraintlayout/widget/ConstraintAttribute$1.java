/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.widget;

import androidx.constraintlayout.widget.ConstraintAttribute$AttributeType;

public class ConstraintAttribute$1 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        ConstraintAttribute$AttributeType constraintAttribute$AttributeType;
        int n12 = ConstraintAttribute$AttributeType.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType = nArray;
        try {
            constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.COLOR_TYPE;
            n11 = constraintAttribute$AttributeType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType;
            constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.COLOR_DRAWABLE_TYPE;
            n11 = constraintAttribute$AttributeType.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType;
            constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.INT_TYPE;
            n11 = constraintAttribute$AttributeType.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType;
            constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.FLOAT_TYPE;
            n11 = constraintAttribute$AttributeType.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType;
            constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.STRING_TYPE;
            n11 = constraintAttribute$AttributeType.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType;
            constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.BOOLEAN_TYPE;
            n11 = constraintAttribute$AttributeType.ordinal();
            nArray[n11] = n10 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType;
            constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.DIMENSION_TYPE;
            n11 = constraintAttribute$AttributeType.ordinal();
            nArray[n11] = n10 = 7;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

