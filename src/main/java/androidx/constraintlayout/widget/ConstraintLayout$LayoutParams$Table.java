/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 */
package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R$styleable;

public class ConstraintLayout$LayoutParams$Table {
    public static final int ANDROID_ORIENTATION = 1;
    public static final int LAYOUT_CONSTRAINED_HEIGHT = 28;
    public static final int LAYOUT_CONSTRAINED_WIDTH = 27;
    public static final int LAYOUT_CONSTRAINT_BASELINE_CREATOR = 43;
    public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BASELINE_OF = 16;
    public static final int LAYOUT_CONSTRAINT_BOTTOM_CREATOR = 42;
    public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_BOTTOM_OF = 15;
    public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF = 14;
    public static final int LAYOUT_CONSTRAINT_CIRCLE = 2;
    public static final int LAYOUT_CONSTRAINT_CIRCLE_ANGLE = 4;
    public static final int LAYOUT_CONSTRAINT_CIRCLE_RADIUS = 3;
    public static final int LAYOUT_CONSTRAINT_DIMENSION_RATIO = 44;
    public static final int LAYOUT_CONSTRAINT_END_TO_END_OF = 20;
    public static final int LAYOUT_CONSTRAINT_END_TO_START_OF = 19;
    public static final int LAYOUT_CONSTRAINT_GUIDE_BEGIN = 5;
    public static final int LAYOUT_CONSTRAINT_GUIDE_END = 6;
    public static final int LAYOUT_CONSTRAINT_GUIDE_PERCENT = 7;
    public static final int LAYOUT_CONSTRAINT_HEIGHT_DEFAULT = 32;
    public static final int LAYOUT_CONSTRAINT_HEIGHT_MAX = 37;
    public static final int LAYOUT_CONSTRAINT_HEIGHT_MIN = 36;
    public static final int LAYOUT_CONSTRAINT_HEIGHT_PERCENT = 38;
    public static final int LAYOUT_CONSTRAINT_HORIZONTAL_BIAS = 29;
    public static final int LAYOUT_CONSTRAINT_HORIZONTAL_CHAINSTYLE = 47;
    public static final int LAYOUT_CONSTRAINT_HORIZONTAL_WEIGHT = 45;
    public static final int LAYOUT_CONSTRAINT_LEFT_CREATOR = 39;
    public static final int LAYOUT_CONSTRAINT_LEFT_TO_LEFT_OF = 8;
    public static final int LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF = 9;
    public static final int LAYOUT_CONSTRAINT_RIGHT_CREATOR = 41;
    public static final int LAYOUT_CONSTRAINT_RIGHT_TO_LEFT_OF = 10;
    public static final int LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF = 11;
    public static final int LAYOUT_CONSTRAINT_START_TO_END_OF = 17;
    public static final int LAYOUT_CONSTRAINT_START_TO_START_OF = 18;
    public static final int LAYOUT_CONSTRAINT_TAG = 51;
    public static final int LAYOUT_CONSTRAINT_TOP_CREATOR = 40;
    public static final int LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF = 13;
    public static final int LAYOUT_CONSTRAINT_TOP_TO_TOP_OF = 12;
    public static final int LAYOUT_CONSTRAINT_VERTICAL_BIAS = 30;
    public static final int LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE = 48;
    public static final int LAYOUT_CONSTRAINT_VERTICAL_WEIGHT = 46;
    public static final int LAYOUT_CONSTRAINT_WIDTH_DEFAULT = 31;
    public static final int LAYOUT_CONSTRAINT_WIDTH_MAX = 34;
    public static final int LAYOUT_CONSTRAINT_WIDTH_MIN = 33;
    public static final int LAYOUT_CONSTRAINT_WIDTH_PERCENT = 35;
    public static final int LAYOUT_EDITOR_ABSOLUTEX = 49;
    public static final int LAYOUT_EDITOR_ABSOLUTEY = 50;
    public static final int LAYOUT_GONE_MARGIN_BOTTOM = 24;
    public static final int LAYOUT_GONE_MARGIN_END = 26;
    public static final int LAYOUT_GONE_MARGIN_LEFT = 21;
    public static final int LAYOUT_GONE_MARGIN_RIGHT = 23;
    public static final int LAYOUT_GONE_MARGIN_START = 25;
    public static final int LAYOUT_GONE_MARGIN_TOP = 22;
    public static final int UNUSED;
    public static final SparseIntArray map;

    static {
        SparseIntArray sparseIntArray;
        map = sparseIntArray = new SparseIntArray();
        int n10 = R$styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf;
        sparseIntArray.append(n10, 8);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf;
        sparseIntArray.append(n10, 9);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf;
        sparseIntArray.append(n10, 10);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf;
        sparseIntArray.append(n10, 11);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf;
        sparseIntArray.append(n10, 12);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf;
        sparseIntArray.append(n10, 13);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf;
        sparseIntArray.append(n10, 14);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf;
        sparseIntArray.append(n10, 15);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf;
        sparseIntArray.append(n10, 16);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintCircle;
        sparseIntArray.append(n10, 2);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintCircleRadius;
        sparseIntArray.append(n10, 3);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintCircleAngle;
        sparseIntArray.append(n10, 4);
        n10 = R$styleable.ConstraintLayout_Layout_layout_editor_absoluteX;
        sparseIntArray.append(n10, 49);
        n10 = R$styleable.ConstraintLayout_Layout_layout_editor_absoluteY;
        sparseIntArray.append(n10, 50);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintGuide_begin;
        sparseIntArray.append(n10, 5);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintGuide_end;
        sparseIntArray.append(n10, 6);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintGuide_percent;
        sparseIntArray.append(n10, 7);
        n10 = R$styleable.ConstraintLayout_Layout_android_orientation;
        sparseIntArray.append(n10, 1);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf;
        sparseIntArray.append(n10, 17);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf;
        sparseIntArray.append(n10, 18);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf;
        sparseIntArray.append(n10, 19);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf;
        sparseIntArray.append(n10, 20);
        n10 = R$styleable.ConstraintLayout_Layout_layout_goneMarginLeft;
        sparseIntArray.append(n10, 21);
        n10 = R$styleable.ConstraintLayout_Layout_layout_goneMarginTop;
        sparseIntArray.append(n10, 22);
        n10 = R$styleable.ConstraintLayout_Layout_layout_goneMarginRight;
        sparseIntArray.append(n10, 23);
        n10 = R$styleable.ConstraintLayout_Layout_layout_goneMarginBottom;
        sparseIntArray.append(n10, 24);
        n10 = R$styleable.ConstraintLayout_Layout_layout_goneMarginStart;
        sparseIntArray.append(n10, 25);
        n10 = R$styleable.ConstraintLayout_Layout_layout_goneMarginEnd;
        sparseIntArray.append(n10, 26);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias;
        sparseIntArray.append(n10, 29);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintVertical_bias;
        sparseIntArray.append(n10, 30);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio;
        sparseIntArray.append(n10, 44);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight;
        sparseIntArray.append(n10, 45);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintVertical_weight;
        sparseIntArray.append(n10, 46);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle;
        sparseIntArray.append(n10, 47);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle;
        sparseIntArray.append(n10, 48);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constrainedWidth;
        sparseIntArray.append(n10, 27);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constrainedHeight;
        sparseIntArray.append(n10, 28);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintWidth_default;
        sparseIntArray.append(n10, 31);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintHeight_default;
        sparseIntArray.append(n10, 32);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintWidth_min;
        sparseIntArray.append(n10, 33);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintWidth_max;
        sparseIntArray.append(n10, 34);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintWidth_percent;
        sparseIntArray.append(n10, 35);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintHeight_min;
        sparseIntArray.append(n10, 36);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintHeight_max;
        sparseIntArray.append(n10, 37);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintHeight_percent;
        sparseIntArray.append(n10, 38);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintLeft_creator;
        sparseIntArray.append(n10, 39);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintTop_creator;
        sparseIntArray.append(n10, 40);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintRight_creator;
        sparseIntArray.append(n10, 41);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintBottom_creator;
        sparseIntArray.append(n10, 42);
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator;
        sparseIntArray.append(n10, 43);
        sparseIntArray = map;
        n10 = R$styleable.ConstraintLayout_Layout_layout_constraintTag;
        sparseIntArray.append(n10, 51);
    }

    private ConstraintLayout$LayoutParams$Table() {
    }
}

