/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;

public class Dimension {
    public static final Object FIXED_DIMENSION;
    public static final Object PARENT_DIMENSION;
    public static final Object PERCENT_DIMENSION;
    public static final Object SPREAD_DIMENSION;
    public static final Object WRAP_DIMENSION;
    private final int WRAP_CONTENT;
    public Object mInitialValue;
    public boolean mIsSuggested;
    public int mMax = -1 >>> 1;
    public int mMin = 0;
    public float mPercent;
    public float mRatio;
    public int mValue;

    static {
        Object object;
        FIXED_DIMENSION = object = new Object();
        WRAP_DIMENSION = object = new Object();
        SPREAD_DIMENSION = object = new Object();
        PARENT_DIMENSION = object = new Object();
        PERCENT_DIMENSION = object = new Object();
    }

    private Dimension() {
        Object object;
        float f10;
        this.WRAP_CONTENT = -2;
        this.mPercent = f10 = 1.0f;
        this.mValue = 0;
        this.mRatio = f10;
        this.mInitialValue = object = WRAP_DIMENSION;
        this.mIsSuggested = false;
    }

    private Dimension(Object object) {
        Object object2;
        float f10;
        this.WRAP_CONTENT = -2;
        this.mPercent = f10 = 1.0f;
        this.mValue = 0;
        this.mRatio = f10;
        this.mInitialValue = object2 = WRAP_DIMENSION;
        this.mIsSuggested = false;
        this.mInitialValue = object;
    }

    public static Dimension Fixed(int n10) {
        Object object = FIXED_DIMENSION;
        Dimension dimension = new Dimension(object);
        dimension.fixed(n10);
        return dimension;
    }

    public static Dimension Fixed(Object object) {
        Object object2 = FIXED_DIMENSION;
        Dimension dimension = new Dimension(object2);
        dimension.fixed(object);
        return dimension;
    }

    public static Dimension Parent() {
        Object object = PARENT_DIMENSION;
        Dimension dimension = new Dimension(object);
        return dimension;
    }

    public static Dimension Percent(Object object, float f10) {
        Object object2 = PERCENT_DIMENSION;
        Dimension dimension = new Dimension(object2);
        dimension.percent(object, f10);
        return dimension;
    }

    public static Dimension Spread() {
        Object object = SPREAD_DIMENSION;
        Dimension dimension = new Dimension(object);
        return dimension;
    }

    public static Dimension Suggested(int n10) {
        Dimension dimension = new Dimension();
        dimension.suggested(n10);
        return dimension;
    }

    public static Dimension Suggested(Object object) {
        Dimension dimension = new Dimension();
        dimension.suggested(object);
        return dimension;
    }

    public static Dimension Wrap() {
        Object object = WRAP_DIMENSION;
        Dimension dimension = new Dimension(object);
        return dimension;
    }

    public void apply(State object, ConstraintWidget constraintWidget, int n10) {
        int n11 = 2;
        int n12 = 1;
        int n13 = -1 >>> 1;
        float f10 = 0.0f / 0.0f;
        if (n10 == 0) {
            n10 = this.mIsSuggested ? 1 : 0;
            if (n10 != 0) {
                Object object2 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                constraintWidget.setHorizontalDimensionBehaviour((ConstraintWidget$DimensionBehaviour)((Object)object2));
                object2 = this.mInitialValue;
                Object object3 = WRAP_DIMENSION;
                if (object2 == object3) {
                    n11 = n12;
                } else {
                    Object object4 = PERCENT_DIMENSION;
                    if (object2 != object4) {
                        n11 = 0;
                        object = null;
                    }
                }
                n10 = this.mMin;
                n12 = this.mMax;
                f10 = this.mPercent;
                constraintWidget.setHorizontalMatchStyle(n11, n10, n12, f10);
            } else {
                Object object5;
                n11 = this.mMin;
                if (n11 > 0) {
                    constraintWidget.setMinWidth(n11);
                }
                if ((n11 = this.mMax) < n13) {
                    constraintWidget.setMaxWidth(n11);
                }
                if ((object = this.mInitialValue) == (object5 = WRAP_DIMENSION)) {
                    object = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                    constraintWidget.setHorizontalDimensionBehaviour((ConstraintWidget$DimensionBehaviour)((Object)object));
                } else {
                    object5 = PARENT_DIMENSION;
                    if (object == object5) {
                        object = ConstraintWidget$DimensionBehaviour.MATCH_PARENT;
                        constraintWidget.setHorizontalDimensionBehaviour((ConstraintWidget$DimensionBehaviour)((Object)object));
                    } else if (object == null) {
                        object = ConstraintWidget$DimensionBehaviour.FIXED;
                        constraintWidget.setHorizontalDimensionBehaviour((ConstraintWidget$DimensionBehaviour)((Object)object));
                        n11 = this.mValue;
                        constraintWidget.setWidth(n11);
                    }
                }
            }
        } else {
            n10 = this.mIsSuggested ? 1 : 0;
            if (n10 != 0) {
                Object object6 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                constraintWidget.setVerticalDimensionBehaviour((ConstraintWidget$DimensionBehaviour)((Object)object6));
                object6 = this.mInitialValue;
                Object object7 = WRAP_DIMENSION;
                if (object6 == object7) {
                    n11 = n12;
                } else {
                    Object object8 = PERCENT_DIMENSION;
                    if (object6 != object8) {
                        n11 = 0;
                        object = null;
                    }
                }
                n10 = this.mMin;
                n12 = this.mMax;
                f10 = this.mPercent;
                constraintWidget.setVerticalMatchStyle(n11, n10, n12, f10);
            } else {
                Object object9;
                n11 = this.mMin;
                if (n11 > 0) {
                    constraintWidget.setMinHeight(n11);
                }
                if ((n11 = this.mMax) < n13) {
                    constraintWidget.setMaxHeight(n11);
                }
                if ((object = this.mInitialValue) == (object9 = WRAP_DIMENSION)) {
                    object = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                    constraintWidget.setVerticalDimensionBehaviour((ConstraintWidget$DimensionBehaviour)((Object)object));
                } else {
                    object9 = PARENT_DIMENSION;
                    if (object == object9) {
                        object = ConstraintWidget$DimensionBehaviour.MATCH_PARENT;
                        constraintWidget.setVerticalDimensionBehaviour((ConstraintWidget$DimensionBehaviour)((Object)object));
                    } else if (object == null) {
                        object = ConstraintWidget$DimensionBehaviour.FIXED;
                        constraintWidget.setVerticalDimensionBehaviour((ConstraintWidget$DimensionBehaviour)((Object)object));
                        n11 = this.mValue;
                        constraintWidget.setHeight(n11);
                    }
                }
            }
        }
    }

    public Dimension fixed(int n10) {
        this.mInitialValue = null;
        this.mValue = n10;
        return this;
    }

    public Dimension fixed(Object object) {
        this.mInitialValue = object;
        boolean bl2 = object instanceof Integer;
        if (bl2) {
            int n10;
            this.mValue = n10 = ((Integer)object).intValue();
            n10 = 0;
            object = null;
            this.mInitialValue = null;
        }
        return this;
    }

    public float getRatio() {
        return this.mRatio;
    }

    public int getValue() {
        return this.mValue;
    }

    public Dimension max(int n10) {
        int n11 = this.mMax;
        if (n11 >= 0) {
            this.mMax = n10;
        }
        return this;
    }

    public Dimension max(Object object) {
        int n10;
        Object object2 = WRAP_DIMENSION;
        if (object == object2 && (n10 = this.mIsSuggested) != 0) {
            this.mInitialValue = object2;
            this.mMax = n10 = -1 >>> 1;
        }
        return this;
    }

    public Dimension min(int n10) {
        if (n10 >= 0) {
            this.mMin = n10;
        }
        return this;
    }

    public Dimension min(Object object) {
        Object object2 = WRAP_DIMENSION;
        if (object == object2) {
            int n10;
            this.mMin = n10 = -2;
        }
        return this;
    }

    public Dimension percent(Object object, float f10) {
        this.mPercent = f10;
        return this;
    }

    public Dimension ratio(float f10) {
        return this;
    }

    public void setRatio(float f10) {
        this.mRatio = f10;
    }

    public void setValue(int n10) {
        this.mIsSuggested = false;
        this.mInitialValue = null;
        this.mValue = n10;
    }

    public Dimension suggested(int n10) {
        this.mIsSuggested = true;
        return this;
    }

    public Dimension suggested(Object object) {
        this.mInitialValue = object;
        this.mIsSuggested = true;
        return this;
    }
}

