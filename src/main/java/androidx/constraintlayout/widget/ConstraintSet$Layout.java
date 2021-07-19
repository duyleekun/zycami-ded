/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.SparseIntArray
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R$styleable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ConstraintSet$Layout {
    private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
    private static final int BARRIER_DIRECTION = 72;
    private static final int BARRIER_MARGIN = 73;
    private static final int BASELINE_TO_BASELINE = 1;
    private static final int BOTTOM_MARGIN = 2;
    private static final int BOTTOM_TO_BOTTOM = 3;
    private static final int BOTTOM_TO_TOP = 4;
    private static final int CHAIN_USE_RTL = 71;
    private static final int CIRCLE = 61;
    private static final int CIRCLE_ANGLE = 63;
    private static final int CIRCLE_RADIUS = 62;
    private static final int CONSTRAINT_REFERENCED_IDS = 74;
    private static final int DIMENSION_RATIO = 5;
    private static final int EDITOR_ABSOLUTE_X = 6;
    private static final int EDITOR_ABSOLUTE_Y = 7;
    private static final int END_MARGIN = 8;
    private static final int END_TO_END = 9;
    private static final int END_TO_START = 10;
    private static final int GONE_BOTTOM_MARGIN = 11;
    private static final int GONE_END_MARGIN = 12;
    private static final int GONE_LEFT_MARGIN = 13;
    private static final int GONE_RIGHT_MARGIN = 14;
    private static final int GONE_START_MARGIN = 15;
    private static final int GONE_TOP_MARGIN = 16;
    private static final int GUIDE_BEGIN = 17;
    private static final int GUIDE_END = 18;
    private static final int GUIDE_PERCENT = 19;
    private static final int HEIGHT_PERCENT = 70;
    private static final int HORIZONTAL_BIAS = 20;
    private static final int HORIZONTAL_STYLE = 39;
    private static final int HORIZONTAL_WEIGHT = 37;
    private static final int LAYOUT_HEIGHT = 21;
    private static final int LAYOUT_WIDTH = 22;
    private static final int LEFT_MARGIN = 23;
    private static final int LEFT_TO_LEFT = 24;
    private static final int LEFT_TO_RIGHT = 25;
    private static final int ORIENTATION = 26;
    private static final int RIGHT_MARGIN = 27;
    private static final int RIGHT_TO_LEFT = 28;
    private static final int RIGHT_TO_RIGHT = 29;
    private static final int START_MARGIN = 30;
    private static final int START_TO_END = 31;
    private static final int START_TO_START = 32;
    private static final int TOP_MARGIN = 33;
    private static final int TOP_TO_BOTTOM = 34;
    private static final int TOP_TO_TOP = 35;
    public static final int UNSET = 255;
    private static final int UNUSED = 76;
    private static final int VERTICAL_BIAS = 36;
    private static final int VERTICAL_STYLE = 40;
    private static final int VERTICAL_WEIGHT = 38;
    private static final int WIDTH_PERCENT = 69;
    private static SparseIntArray mapToConstant;
    public int baselineToBaseline;
    public int bottomMargin;
    public int bottomToBottom;
    public int bottomToTop;
    public float circleAngle;
    public int circleConstraint;
    public int circleRadius;
    public boolean constrainedHeight;
    public boolean constrainedWidth;
    public String dimensionRatio;
    public int editorAbsoluteX;
    public int editorAbsoluteY;
    public int endMargin;
    public int endToEnd;
    public int endToStart;
    public int goneBottomMargin;
    public int goneEndMargin;
    public int goneLeftMargin;
    public int goneRightMargin;
    public int goneStartMargin;
    public int goneTopMargin;
    public int guideBegin;
    public int guideEnd;
    public float guidePercent;
    public int heightDefault;
    public int heightMax;
    public int heightMin;
    public float heightPercent;
    public float horizontalBias;
    public int horizontalChainStyle;
    public float horizontalWeight;
    public int leftMargin;
    public int leftToLeft;
    public int leftToRight;
    public boolean mApply = false;
    public boolean mBarrierAllowsGoneWidgets;
    public int mBarrierDirection;
    public int mBarrierMargin;
    public String mConstraintTag;
    public int mHeight;
    public int mHelperType;
    public boolean mIsGuideline = false;
    public String mReferenceIdString;
    public int[] mReferenceIds;
    public int mWidth;
    public int orientation;
    public int rightMargin;
    public int rightToLeft;
    public int rightToRight;
    public int startMargin;
    public int startToEnd;
    public int startToStart;
    public int topMargin;
    public int topToBottom;
    public int topToTop;
    public float verticalBias;
    public int verticalChainStyle;
    public float verticalWeight;
    public int widthDefault;
    public int widthMax;
    public int widthMin;
    public float widthPercent;

    static {
        SparseIntArray sparseIntArray;
        mapToConstant = sparseIntArray = new SparseIntArray();
        int n10 = R$styleable.Layout_layout_constraintLeft_toLeftOf;
        sparseIntArray.append(n10, 24);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintLeft_toRightOf;
        sparseIntArray.append(n10, 25);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintRight_toLeftOf;
        sparseIntArray.append(n10, 28);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintRight_toRightOf;
        sparseIntArray.append(n10, 29);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintTop_toTopOf;
        sparseIntArray.append(n10, 35);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintTop_toBottomOf;
        sparseIntArray.append(n10, 34);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintBottom_toTopOf;
        sparseIntArray.append(n10, 4);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintBottom_toBottomOf;
        sparseIntArray.append(n10, 3);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintBaseline_toBaselineOf;
        sparseIntArray.append(n10, 1);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_editor_absoluteX;
        sparseIntArray.append(n10, 6);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_editor_absoluteY;
        sparseIntArray.append(n10, 7);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintGuide_begin;
        sparseIntArray.append(n10, 17);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintGuide_end;
        sparseIntArray.append(n10, 18);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintGuide_percent;
        sparseIntArray.append(n10, 19);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_android_orientation;
        sparseIntArray.append(n10, 26);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintStart_toEndOf;
        sparseIntArray.append(n10, 31);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintStart_toStartOf;
        sparseIntArray.append(n10, 32);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintEnd_toStartOf;
        sparseIntArray.append(n10, 10);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintEnd_toEndOf;
        sparseIntArray.append(n10, 9);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_goneMarginLeft;
        sparseIntArray.append(n10, 13);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_goneMarginTop;
        sparseIntArray.append(n10, 16);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_goneMarginRight;
        sparseIntArray.append(n10, 14);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_goneMarginBottom;
        sparseIntArray.append(n10, 11);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_goneMarginStart;
        sparseIntArray.append(n10, 15);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_goneMarginEnd;
        sparseIntArray.append(n10, 12);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintVertical_weight;
        sparseIntArray.append(n10, 38);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintHorizontal_weight;
        sparseIntArray.append(n10, 37);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintHorizontal_chainStyle;
        sparseIntArray.append(n10, 39);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintVertical_chainStyle;
        sparseIntArray.append(n10, 40);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintHorizontal_bias;
        sparseIntArray.append(n10, 20);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintVertical_bias;
        sparseIntArray.append(n10, 36);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintDimensionRatio;
        sparseIntArray.append(n10, 5);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintLeft_creator;
        int n11 = 76;
        sparseIntArray.append(n10, n11);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintTop_creator;
        sparseIntArray.append(n10, n11);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintRight_creator;
        sparseIntArray.append(n10, n11);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintBottom_creator;
        sparseIntArray.append(n10, n11);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintBaseline_creator;
        sparseIntArray.append(n10, n11);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_android_layout_marginLeft;
        sparseIntArray.append(n10, 23);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_android_layout_marginRight;
        sparseIntArray.append(n10, 27);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_android_layout_marginStart;
        sparseIntArray.append(n10, 30);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_android_layout_marginEnd;
        sparseIntArray.append(n10, 8);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_android_layout_marginTop;
        sparseIntArray.append(n10, 33);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_android_layout_marginBottom;
        sparseIntArray.append(n10, 2);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_android_layout_width;
        sparseIntArray.append(n10, 22);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_android_layout_height;
        sparseIntArray.append(n10, 21);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintCircle;
        sparseIntArray.append(n10, 61);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintCircleRadius;
        sparseIntArray.append(n10, 62);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintCircleAngle;
        sparseIntArray.append(n10, 63);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintWidth_percent;
        sparseIntArray.append(n10, 69);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_layout_constraintHeight_percent;
        sparseIntArray.append(n10, 70);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_chainUseRtl;
        sparseIntArray.append(n10, 71);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_barrierDirection;
        sparseIntArray.append(n10, 72);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_barrierMargin;
        sparseIntArray.append(n10, 73);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_constraint_referenced_ids;
        sparseIntArray.append(n10, 74);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Layout_barrierAllowsGoneWidgets;
        sparseIntArray.append(n10, 75);
    }

    public ConstraintSet$Layout() {
        float f10;
        float f11;
        int n10;
        this.guideBegin = n10 = -1;
        this.guideEnd = n10;
        this.guidePercent = f11 = -1.0f;
        this.leftToLeft = n10;
        this.leftToRight = n10;
        this.rightToLeft = n10;
        this.rightToRight = n10;
        this.topToTop = n10;
        this.topToBottom = n10;
        this.bottomToTop = n10;
        this.bottomToBottom = n10;
        this.baselineToBaseline = n10;
        this.startToEnd = n10;
        this.startToStart = n10;
        this.endToStart = n10;
        this.endToEnd = n10;
        this.horizontalBias = f10 = 0.5f;
        this.verticalBias = f10;
        this.dimensionRatio = null;
        this.circleConstraint = n10;
        this.circleRadius = 0;
        this.circleAngle = 0.0f;
        this.editorAbsoluteX = n10;
        this.editorAbsoluteY = n10;
        this.orientation = n10;
        this.leftMargin = n10;
        this.rightMargin = n10;
        this.topMargin = n10;
        this.bottomMargin = n10;
        this.endMargin = n10;
        this.startMargin = n10;
        this.goneLeftMargin = n10;
        this.goneTopMargin = n10;
        this.goneRightMargin = n10;
        this.goneBottomMargin = n10;
        this.goneEndMargin = n10;
        this.goneStartMargin = n10;
        this.verticalWeight = f11;
        this.horizontalWeight = f11;
        this.horizontalChainStyle = 0;
        this.verticalChainStyle = 0;
        this.widthDefault = 0;
        this.heightDefault = 0;
        this.widthMax = n10;
        this.heightMax = n10;
        this.widthMin = n10;
        this.heightMin = n10;
        this.widthPercent = f11 = 1.0f;
        this.heightPercent = f11;
        this.mBarrierDirection = n10;
        this.mBarrierMargin = 0;
        this.mHelperType = n10;
        this.constrainedWidth = false;
        this.constrainedHeight = false;
        this.mBarrierAllowsGoneWidgets = true;
    }

    public void copyFrom(ConstraintSet$Layout constraintSet$Layout) {
        boolean bl2;
        float f10;
        int n10;
        this.mIsGuideline = n10 = constraintSet$Layout.mIsGuideline;
        this.mWidth = n10 = constraintSet$Layout.mWidth;
        n10 = constraintSet$Layout.mApply ? 1 : 0;
        this.mApply = n10;
        this.mHeight = n10 = constraintSet$Layout.mHeight;
        this.guideBegin = n10 = constraintSet$Layout.guideBegin;
        this.guideEnd = n10 = constraintSet$Layout.guideEnd;
        this.guidePercent = f10 = constraintSet$Layout.guidePercent;
        this.leftToLeft = n10 = constraintSet$Layout.leftToLeft;
        this.leftToRight = n10 = constraintSet$Layout.leftToRight;
        this.rightToLeft = n10 = constraintSet$Layout.rightToLeft;
        this.rightToRight = n10 = constraintSet$Layout.rightToRight;
        this.topToTop = n10 = constraintSet$Layout.topToTop;
        this.topToBottom = n10 = constraintSet$Layout.topToBottom;
        this.bottomToTop = n10 = constraintSet$Layout.bottomToTop;
        this.bottomToBottom = n10 = constraintSet$Layout.bottomToBottom;
        this.baselineToBaseline = n10 = constraintSet$Layout.baselineToBaseline;
        this.startToEnd = n10 = constraintSet$Layout.startToEnd;
        this.startToStart = n10 = constraintSet$Layout.startToStart;
        this.endToStart = n10 = constraintSet$Layout.endToStart;
        this.endToEnd = n10 = constraintSet$Layout.endToEnd;
        this.horizontalBias = f10 = constraintSet$Layout.horizontalBias;
        this.verticalBias = f10 = constraintSet$Layout.verticalBias;
        Object object = constraintSet$Layout.dimensionRatio;
        this.dimensionRatio = object;
        this.circleConstraint = n10 = constraintSet$Layout.circleConstraint;
        this.circleRadius = n10 = constraintSet$Layout.circleRadius;
        this.circleAngle = f10 = constraintSet$Layout.circleAngle;
        this.editorAbsoluteX = n10 = constraintSet$Layout.editorAbsoluteX;
        this.editorAbsoluteY = n10 = constraintSet$Layout.editorAbsoluteY;
        this.orientation = n10 = constraintSet$Layout.orientation;
        this.leftMargin = n10 = constraintSet$Layout.leftMargin;
        this.rightMargin = n10 = constraintSet$Layout.rightMargin;
        this.topMargin = n10 = constraintSet$Layout.topMargin;
        this.bottomMargin = n10 = constraintSet$Layout.bottomMargin;
        this.endMargin = n10 = constraintSet$Layout.endMargin;
        this.startMargin = n10 = constraintSet$Layout.startMargin;
        this.goneLeftMargin = n10 = constraintSet$Layout.goneLeftMargin;
        this.goneTopMargin = n10 = constraintSet$Layout.goneTopMargin;
        this.goneRightMargin = n10 = constraintSet$Layout.goneRightMargin;
        this.goneBottomMargin = n10 = constraintSet$Layout.goneBottomMargin;
        this.goneEndMargin = n10 = constraintSet$Layout.goneEndMargin;
        this.goneStartMargin = n10 = constraintSet$Layout.goneStartMargin;
        this.verticalWeight = f10 = constraintSet$Layout.verticalWeight;
        this.horizontalWeight = f10 = constraintSet$Layout.horizontalWeight;
        this.horizontalChainStyle = n10 = constraintSet$Layout.horizontalChainStyle;
        this.verticalChainStyle = n10 = constraintSet$Layout.verticalChainStyle;
        this.widthDefault = n10 = constraintSet$Layout.widthDefault;
        this.heightDefault = n10 = constraintSet$Layout.heightDefault;
        this.widthMax = n10 = constraintSet$Layout.widthMax;
        this.heightMax = n10 = constraintSet$Layout.heightMax;
        this.widthMin = n10 = constraintSet$Layout.widthMin;
        this.heightMin = n10 = constraintSet$Layout.heightMin;
        this.widthPercent = f10 = constraintSet$Layout.widthPercent;
        this.heightPercent = f10 = constraintSet$Layout.heightPercent;
        this.mBarrierDirection = n10 = constraintSet$Layout.mBarrierDirection;
        this.mBarrierMargin = n10 = constraintSet$Layout.mBarrierMargin;
        this.mHelperType = n10 = constraintSet$Layout.mHelperType;
        object = constraintSet$Layout.mConstraintTag;
        this.mConstraintTag = object;
        object = constraintSet$Layout.mReferenceIds;
        if (object != null) {
            int n11 = ((Object)object).length;
            object = Arrays.copyOf((int[])object, n11);
            this.mReferenceIds = (int[])object;
        } else {
            n10 = 0;
            f10 = 0.0f;
            object = null;
            this.mReferenceIds = null;
        }
        this.mReferenceIdString = object = constraintSet$Layout.mReferenceIdString;
        n10 = constraintSet$Layout.constrainedWidth ? 1 : 0;
        this.constrainedWidth = n10;
        n10 = constraintSet$Layout.constrainedHeight ? 1 : 0;
        this.constrainedHeight = n10;
        this.mBarrierAllowsGoneWidgets = bl2 = constraintSet$Layout.mBarrierAllowsGoneWidgets;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void dump(MotionScene motionScene, StringBuilder stringBuilder) {
        Field[] fieldArray = this.getClass().getDeclaredFields();
        stringBuilder.append("\n");
        int n10 = 0;
        while (true) {
            block11: {
                float f10;
                int n11;
                int n12;
                if (n10 >= (n12 = fieldArray.length)) {
                    return;
                }
                Object object = fieldArray[n10];
                String string2 = ((Field)object).getName();
                boolean bl2 = Modifier.isStatic(((Field)object).getModifiers());
                if (bl2) break block11;
                Object object2 = ((Field)object).get(this);
                object = ((Field)object).getType();
                Class<Integer> clazz = Integer.TYPE;
                String string3 = "\"\n";
                String string4 = " = \"";
                String string5 = "    ";
                if (object == clazz) {
                    object2 = (Integer)object2;
                    n12 = (Integer)object2;
                    n11 = -1;
                    f10 = 0.0f / 0.0f;
                    if (n12 != n11) {
                        n12 = (Integer)object2;
                        object = motionScene.lookUpConstraintName(n12);
                        stringBuilder.append(string5);
                        stringBuilder.append(string2);
                        stringBuilder.append(string4);
                        if (object != null) {
                            object2 = object;
                        }
                        stringBuilder.append(object2);
                        stringBuilder.append(string3);
                    }
                    break block11;
                }
                Class<Float> clazz2 = Float.TYPE;
                if (object != clazz2) break block11;
                object2 = (Float)object2;
                float f11 = ((Float)object2).floatValue();
                n11 = -1082130432;
                f10 = -1.0f;
                n12 = f11 == f10 ? 0 : (f11 > f10 ? 1 : -1);
                if (n12 == 0) break block11;
                try {
                    stringBuilder.append(string5);
                    stringBuilder.append(string2);
                    stringBuilder.append(string4);
                    stringBuilder.append(object2);
                    stringBuilder.append(string3);
                }
                catch (IllegalAccessException illegalAccessException) {
                    illegalAccessException.printStackTrace();
                }
            }
            ++n10;
        }
    }

    public void fillFromAttributeList(Context context, AttributeSet attributeSet) {
        int n10 = Build.VERSION.SDK_INT;
        int[] nArray = R$styleable.Layout;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        this.mApply = true;
        int n11 = context.getIndexCount();
        nArray = null;
        block66: for (int i10 = 0; i10 < n11; ++i10) {
            int n12 = context.getIndex(i10);
            Object object = mapToConstant;
            int n13 = object.get(n12);
            int n14 = 80;
            float f10 = 1.12E-43f;
            if (n13 != n14) {
                n14 = 81;
                f10 = 1.14E-43f;
                if (n13 != n14) {
                    n14 = 17;
                    f10 = 2.4E-44f;
                    block0 : switch (n13) {
                        default: {
                            float f11;
                            float f12;
                            String string2;
                            switch (n13) {
                                default: {
                                    switch (n13) {
                                        default: {
                                            n14 = 1065353216;
                                            f10 = 1.0f;
                                            String string3 = "   ";
                                            String string4 = "ConstraintSet";
                                            switch (n13) {
                                                default: {
                                                    object = new StringBuilder();
                                                    ((StringBuilder)object).append("Unknown attribute 0x");
                                                    String string5 = Integer.toHexString(n12);
                                                    ((StringBuilder)object).append(string5);
                                                    ((StringBuilder)object).append(string3);
                                                    string5 = mapToConstant;
                                                    n12 = string5.get(n12);
                                                    ((StringBuilder)object).append(n12);
                                                    string2 = ((StringBuilder)object).toString();
                                                    Log.w((String)string4, (String)string2);
                                                    break block0;
                                                }
                                                case 77: {
                                                    this.mConstraintTag = string2 = context.getString(n12);
                                                    break block0;
                                                }
                                                case 76: {
                                                    object = new StringBuilder();
                                                    ((StringBuilder)object).append("unused attribute 0x");
                                                    String string5 = Integer.toHexString(n12);
                                                    ((StringBuilder)object).append(string5);
                                                    ((StringBuilder)object).append(string3);
                                                    string5 = mapToConstant;
                                                    n12 = string5.get(n12);
                                                    ((StringBuilder)object).append(n12);
                                                    string2 = ((StringBuilder)object).toString();
                                                    Log.w((String)string4, (String)string2);
                                                    break block0;
                                                }
                                                case 75: {
                                                    n13 = this.mBarrierAllowsGoneWidgets ? 1 : 0;
                                                    n12 = context.getBoolean(n12, n13 != 0) ? 1 : 0;
                                                    this.mBarrierAllowsGoneWidgets = n12;
                                                    break block0;
                                                }
                                                case 74: {
                                                    this.mReferenceIdString = string2 = context.getString(n12);
                                                    break block0;
                                                }
                                                case 73: {
                                                    n13 = this.mBarrierMargin;
                                                    this.mBarrierMargin = n12 = context.getDimensionPixelSize(n12, n13);
                                                    break block0;
                                                }
                                                case 72: {
                                                    n13 = this.mBarrierDirection;
                                                    this.mBarrierDirection = n12 = context.getInt(n12, n13);
                                                    break block0;
                                                }
                                                case 71: {
                                                    string2 = "CURRENTLY UNSUPPORTED";
                                                    Log.e((String)string4, (String)string2);
                                                    break block0;
                                                }
                                                case 70: {
                                                    this.heightPercent = f12 = context.getFloat(n12, f10);
                                                    break block0;
                                                }
                                                case 69: 
                                            }
                                            this.widthPercent = f12 = context.getFloat(n12, f10);
                                            break block0;
                                        }
                                        case 63: {
                                            f11 = this.circleAngle;
                                            this.circleAngle = f12 = context.getFloat(n12, f11);
                                            break block0;
                                        }
                                        case 62: {
                                            n13 = this.circleRadius;
                                            this.circleRadius = n12 = context.getDimensionPixelSize(n12, n13);
                                            break block0;
                                        }
                                        case 61: 
                                    }
                                    n13 = this.circleConstraint;
                                    this.circleConstraint = n12 = ConstraintSet.access$100((TypedArray)context, n12, n13);
                                    break block0;
                                }
                                case 59: {
                                    n13 = this.heightMin;
                                    this.heightMin = n12 = context.getDimensionPixelSize(n12, n13);
                                    break block0;
                                }
                                case 58: {
                                    n13 = this.widthMin;
                                    this.widthMin = n12 = context.getDimensionPixelSize(n12, n13);
                                    break block0;
                                }
                                case 57: {
                                    n13 = this.heightMax;
                                    this.heightMax = n12 = context.getDimensionPixelSize(n12, n13);
                                    break block0;
                                }
                                case 56: {
                                    n13 = this.widthMax;
                                    this.widthMax = n12 = context.getDimensionPixelSize(n12, n13);
                                    break block0;
                                }
                                case 55: {
                                    n13 = this.heightDefault;
                                    this.heightDefault = n12 = context.getInt(n12, n13);
                                    break block0;
                                }
                                case 54: 
                            }
                            n13 = this.widthDefault;
                            this.widthDefault = n12 = context.getInt(n12, n13);
                            break;
                        }
                        case 40: {
                            n13 = this.verticalChainStyle;
                            this.verticalChainStyle = n12 = context.getInt(n12, n13);
                            break;
                        }
                        case 39: {
                            n13 = this.horizontalChainStyle;
                            this.horizontalChainStyle = n12 = context.getInt(n12, n13);
                            break;
                        }
                        case 38: {
                            float f12;
                            float f11 = this.verticalWeight;
                            this.verticalWeight = f12 = context.getFloat(n12, f11);
                            break;
                        }
                        case 37: {
                            float f12;
                            float f11 = this.horizontalWeight;
                            this.horizontalWeight = f12 = context.getFloat(n12, f11);
                            break;
                        }
                        case 36: {
                            float f12;
                            float f11 = this.verticalBias;
                            this.verticalBias = f12 = context.getFloat(n12, f11);
                            break;
                        }
                        case 35: {
                            n13 = this.topToTop;
                            this.topToTop = n12 = ConstraintSet.access$100((TypedArray)context, n12, n13);
                            break;
                        }
                        case 34: {
                            n13 = this.topToBottom;
                            this.topToBottom = n12 = ConstraintSet.access$100((TypedArray)context, n12, n13);
                            break;
                        }
                        case 33: {
                            n13 = this.topMargin;
                            this.topMargin = n12 = context.getDimensionPixelSize(n12, n13);
                            break;
                        }
                        case 32: {
                            n13 = this.startToStart;
                            this.startToStart = n12 = ConstraintSet.access$100((TypedArray)context, n12, n13);
                            break;
                        }
                        case 31: {
                            n13 = this.startToEnd;
                            this.startToEnd = n12 = ConstraintSet.access$100((TypedArray)context, n12, n13);
                            break;
                        }
                        case 30: {
                            if (n10 < n14) continue block66;
                            n13 = this.startMargin;
                            this.startMargin = n12 = context.getDimensionPixelSize(n12, n13);
                            break;
                        }
                        case 29: {
                            n13 = this.rightToRight;
                            this.rightToRight = n12 = ConstraintSet.access$100((TypedArray)context, n12, n13);
                            break;
                        }
                        case 28: {
                            n13 = this.rightToLeft;
                            this.rightToLeft = n12 = ConstraintSet.access$100((TypedArray)context, n12, n13);
                            break;
                        }
                        case 27: {
                            n13 = this.rightMargin;
                            this.rightMargin = n12 = context.getDimensionPixelSize(n12, n13);
                            break;
                        }
                        case 26: {
                            n13 = this.orientation;
                            this.orientation = n12 = context.getInt(n12, n13);
                            break;
                        }
                        case 25: {
                            n13 = this.leftToRight;
                            this.leftToRight = n12 = ConstraintSet.access$100((TypedArray)context, n12, n13);
                            break;
                        }
                        case 24: {
                            n13 = this.leftToLeft;
                            this.leftToLeft = n12 = ConstraintSet.access$100((TypedArray)context, n12, n13);
                            break;
                        }
                        case 23: {
                            n13 = this.leftMargin;
                            this.leftMargin = n12 = context.getDimensionPixelSize(n12, n13);
                            break;
                        }
                        case 22: {
                            n13 = this.mWidth;
                            this.mWidth = n12 = context.getLayoutDimension(n12, n13);
                            break;
                        }
                        case 21: {
                            n13 = this.mHeight;
                            this.mHeight = n12 = context.getLayoutDimension(n12, n13);
                            break;
                        }
                        case 20: {
                            float f12;
                            float f11 = this.horizontalBias;
                            this.horizontalBias = f12 = context.getFloat(n12, f11);
                            break;
                        }
                        case 19: {
                            float f12;
                            float f11 = this.guidePercent;
                            this.guidePercent = f12 = context.getFloat(n12, f11);
                            break;
                        }
                        case 18: {
                            n13 = this.guideEnd;
                            this.guideEnd = n12 = context.getDimensionPixelOffset(n12, n13);
                            break;
                        }
                        case 17: {
                            n13 = this.guideBegin;
                            this.guideBegin = n12 = context.getDimensionPixelOffset(n12, n13);
                            break;
                        }
                        case 16: {
                            n13 = this.goneTopMargin;
                            this.goneTopMargin = n12 = context.getDimensionPixelSize(n12, n13);
                            break;
                        }
                        case 15: {
                            n13 = this.goneStartMargin;
                            this.goneStartMargin = n12 = context.getDimensionPixelSize(n12, n13);
                            break;
                        }
                        case 14: {
                            n13 = this.goneRightMargin;
                            this.goneRightMargin = n12 = context.getDimensionPixelSize(n12, n13);
                            break;
                        }
                        case 13: {
                            n13 = this.goneLeftMargin;
                            this.goneLeftMargin = n12 = context.getDimensionPixelSize(n12, n13);
                            break;
                        }
                        case 12: {
                            n13 = this.goneEndMargin;
                            this.goneEndMargin = n12 = context.getDimensionPixelSize(n12, n13);
                            break;
                        }
                        case 11: {
                            n13 = this.goneBottomMargin;
                            this.goneBottomMargin = n12 = context.getDimensionPixelSize(n12, n13);
                            break;
                        }
                        case 10: {
                            n13 = this.endToStart;
                            this.endToStart = n12 = ConstraintSet.access$100((TypedArray)context, n12, n13);
                            break;
                        }
                        case 9: {
                            n13 = this.endToEnd;
                            this.endToEnd = n12 = ConstraintSet.access$100((TypedArray)context, n12, n13);
                            break;
                        }
                        case 8: {
                            if (n10 < n14) continue block66;
                            n13 = this.endMargin;
                            this.endMargin = n12 = context.getDimensionPixelSize(n12, n13);
                            break;
                        }
                        case 7: {
                            n13 = this.editorAbsoluteY;
                            this.editorAbsoluteY = n12 = context.getDimensionPixelOffset(n12, n13);
                            break;
                        }
                        case 6: {
                            n13 = this.editorAbsoluteX;
                            this.editorAbsoluteX = n12 = context.getDimensionPixelOffset(n12, n13);
                            break;
                        }
                        case 5: {
                            String string2;
                            this.dimensionRatio = string2 = context.getString(n12);
                            break;
                        }
                        case 4: {
                            n13 = this.bottomToTop;
                            this.bottomToTop = n12 = ConstraintSet.access$100((TypedArray)context, n12, n13);
                            break;
                        }
                        case 3: {
                            n13 = this.bottomToBottom;
                            this.bottomToBottom = n12 = ConstraintSet.access$100((TypedArray)context, n12, n13);
                            break;
                        }
                        case 2: {
                            n13 = this.bottomMargin;
                            this.bottomMargin = n12 = context.getDimensionPixelSize(n12, n13);
                            break;
                        }
                        case 1: {
                            n13 = this.baselineToBaseline;
                            this.baselineToBaseline = n12 = ConstraintSet.access$100((TypedArray)context, n12, n13);
                            break;
                        }
                    }
                    continue;
                }
                n13 = this.constrainedHeight ? 1 : 0;
                n12 = context.getBoolean(n12, n13 != 0) ? 1 : 0;
                this.constrainedHeight = n12;
                continue;
            }
            n13 = this.constrainedWidth ? 1 : 0;
            n12 = context.getBoolean(n12, n13 != 0) ? 1 : 0;
            this.constrainedWidth = n12;
        }
        context.recycle();
    }
}

