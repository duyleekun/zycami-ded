/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.graphics.Color
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.SparseArray
 *  android.util.SparseIntArray
 *  android.util.TypedValue
 *  android.util.Xml
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintAttribute$AttributeType;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import androidx.constraintlayout.widget.ConstraintSet$Constraint;
import androidx.constraintlayout.widget.ConstraintSet$Layout;
import androidx.constraintlayout.widget.ConstraintSet$Motion;
import androidx.constraintlayout.widget.ConstraintSet$PropertySet;
import androidx.constraintlayout.widget.ConstraintSet$Transform;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.Constraints$LayoutParams;
import androidx.constraintlayout.widget.Guideline;
import androidx.constraintlayout.widget.R$id;
import androidx.constraintlayout.widget.R$styleable;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ConstraintSet {
    private static final int ALPHA = 43;
    private static final int ANIMATE_RELATIVE_TO = 64;
    private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
    private static final int BARRIER_DIRECTION = 72;
    private static final int BARRIER_MARGIN = 73;
    private static final int BARRIER_TYPE = 1;
    public static final int BASELINE = 5;
    private static final int BASELINE_TO_BASELINE = 1;
    public static final int BOTTOM = 4;
    private static final int BOTTOM_MARGIN = 2;
    private static final int BOTTOM_TO_BOTTOM = 3;
    private static final int BOTTOM_TO_TOP = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    private static final int CHAIN_USE_RTL = 71;
    private static final int CIRCLE = 61;
    private static final int CIRCLE_ANGLE = 63;
    private static final int CIRCLE_RADIUS = 62;
    private static final int CONSTRAINED_HEIGHT = 81;
    private static final int CONSTRAINED_WIDTH = 80;
    private static final int CONSTRAINT_REFERENCED_IDS = 74;
    private static final int CONSTRAINT_TAG = 77;
    private static final boolean DEBUG = false;
    private static final int DIMENSION_RATIO = 5;
    private static final int DRAW_PATH = 66;
    private static final int EDITOR_ABSOLUTE_X = 6;
    private static final int EDITOR_ABSOLUTE_Y = 7;
    private static final int ELEVATION = 44;
    public static final int END = 7;
    private static final int END_MARGIN = 8;
    private static final int END_TO_END = 9;
    private static final int END_TO_START = 10;
    private static final String ERROR_MESSAGE = "XML parser error must be within a Constraint ";
    public static final int GONE = 8;
    private static final int GONE_BOTTOM_MARGIN = 11;
    private static final int GONE_END_MARGIN = 12;
    private static final int GONE_LEFT_MARGIN = 13;
    private static final int GONE_RIGHT_MARGIN = 14;
    private static final int GONE_START_MARGIN = 15;
    private static final int GONE_TOP_MARGIN = 16;
    private static final int GUIDE_BEGIN = 17;
    private static final int GUIDE_END = 18;
    private static final int GUIDE_PERCENT = 19;
    private static final int HEIGHT_DEFAULT = 55;
    private static final int HEIGHT_MAX = 57;
    private static final int HEIGHT_MIN = 59;
    private static final int HEIGHT_PERCENT = 70;
    public static final int HORIZONTAL = 0;
    private static final int HORIZONTAL_BIAS = 20;
    public static final int HORIZONTAL_GUIDELINE = 0;
    private static final int HORIZONTAL_STYLE = 41;
    private static final int HORIZONTAL_WEIGHT = 39;
    public static final int INVISIBLE = 4;
    private static final int LAYOUT_HEIGHT = 21;
    private static final int LAYOUT_VISIBILITY = 22;
    private static final int LAYOUT_WIDTH = 23;
    public static final int LEFT = 1;
    private static final int LEFT_MARGIN = 24;
    private static final int LEFT_TO_LEFT = 25;
    private static final int LEFT_TO_RIGHT = 26;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    private static final int MOTION_STAGGER = 79;
    private static final int ORIENTATION = 27;
    public static final int PARENT_ID = 0;
    private static final int PATH_MOTION_ARC = 76;
    private static final int PROGRESS = 68;
    public static final int RIGHT = 2;
    private static final int RIGHT_MARGIN = 28;
    private static final int RIGHT_TO_LEFT = 29;
    private static final int RIGHT_TO_RIGHT = 30;
    private static final int ROTATION = 60;
    private static final int ROTATION_X = 45;
    private static final int ROTATION_Y = 46;
    private static final int SCALE_X = 47;
    private static final int SCALE_Y = 48;
    public static final int START = 6;
    private static final int START_MARGIN = 31;
    private static final int START_TO_END = 32;
    private static final int START_TO_START = 33;
    private static final String TAG = "ConstraintSet";
    public static final int TOP = 3;
    private static final int TOP_MARGIN = 34;
    private static final int TOP_TO_BOTTOM = 35;
    private static final int TOP_TO_TOP = 36;
    private static final int TRANSFORM_PIVOT_X = 49;
    private static final int TRANSFORM_PIVOT_Y = 50;
    private static final int TRANSITION_EASING = 65;
    private static final int TRANSITION_PATH_ROTATE = 67;
    private static final int TRANSLATION_X = 51;
    private static final int TRANSLATION_Y = 52;
    private static final int TRANSLATION_Z = 53;
    public static final int UNSET = 255;
    private static final int UNUSED = 82;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_BIAS = 37;
    public static final int VERTICAL_GUIDELINE = 1;
    private static final int VERTICAL_STYLE = 42;
    private static final int VERTICAL_WEIGHT = 40;
    private static final int VIEW_ID = 38;
    private static final int[] VISIBILITY_FLAGS;
    private static final int VISIBILITY_MODE = 78;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 0;
    private static final int WIDTH_DEFAULT = 54;
    private static final int WIDTH_MAX = 56;
    private static final int WIDTH_MIN = 58;
    private static final int WIDTH_PERCENT = 69;
    public static final int WRAP_CONTENT = 254;
    private static SparseIntArray mapToConstant;
    private HashMap mConstraints;
    private boolean mForceId;
    private HashMap mSavedAttributes;
    private boolean mValidate;

    static {
        Object object;
        int n10 = 3;
        int[] nArray = object = new int[n10];
        object[0] = 0;
        nArray[1] = 4;
        nArray[2] = 8;
        VISIBILITY_FLAGS = object;
        object = new SparseIntArray;
        object();
        mapToConstant = (SparseIntArray)object;
        int n11 = R$styleable.Constraint_layout_constraintLeft_toLeftOf;
        object.append(n11, 25);
        object = mapToConstant;
        n11 = R$styleable.Constraint_layout_constraintLeft_toRightOf;
        object.append(n11, 26);
        object = mapToConstant;
        n11 = R$styleable.Constraint_layout_constraintRight_toLeftOf;
        object.append(n11, 29);
        object = mapToConstant;
        n11 = R$styleable.Constraint_layout_constraintRight_toRightOf;
        object.append(n11, 30);
        object = mapToConstant;
        n11 = R$styleable.Constraint_layout_constraintTop_toTopOf;
        object.append(n11, 36);
        object = mapToConstant;
        n11 = R$styleable.Constraint_layout_constraintTop_toBottomOf;
        object.append(n11, 35);
        object = mapToConstant;
        n11 = R$styleable.Constraint_layout_constraintBottom_toTopOf;
        object.append(n11, 4);
        object = mapToConstant;
        n11 = R$styleable.Constraint_layout_constraintBottom_toBottomOf;
        object.append(n11, n10);
        SparseIntArray sparseIntArray = mapToConstant;
        int n12 = R$styleable.Constraint_layout_constraintBaseline_toBaselineOf;
        sparseIntArray.append(n12, 1);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_editor_absoluteX;
        sparseIntArray.append(n12, 6);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_editor_absoluteY;
        sparseIntArray.append(n12, 7);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintGuide_begin;
        sparseIntArray.append(n12, 17);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintGuide_end;
        sparseIntArray.append(n12, 18);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintGuide_percent;
        sparseIntArray.append(n12, 19);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_android_orientation;
        sparseIntArray.append(n12, 27);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintStart_toEndOf;
        sparseIntArray.append(n12, 32);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintStart_toStartOf;
        sparseIntArray.append(n12, 33);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintEnd_toStartOf;
        sparseIntArray.append(n12, 10);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintEnd_toEndOf;
        sparseIntArray.append(n12, 9);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_goneMarginLeft;
        sparseIntArray.append(n12, 13);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_goneMarginTop;
        sparseIntArray.append(n12, 16);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_goneMarginRight;
        sparseIntArray.append(n12, 14);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_goneMarginBottom;
        sparseIntArray.append(n12, 11);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_goneMarginStart;
        sparseIntArray.append(n12, 15);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_goneMarginEnd;
        sparseIntArray.append(n12, 12);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintVertical_weight;
        sparseIntArray.append(n12, 40);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintHorizontal_weight;
        sparseIntArray.append(n12, 39);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintHorizontal_chainStyle;
        sparseIntArray.append(n12, 41);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintVertical_chainStyle;
        sparseIntArray.append(n12, 42);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintHorizontal_bias;
        sparseIntArray.append(n12, 20);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintVertical_bias;
        sparseIntArray.append(n12, 37);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintDimensionRatio;
        sparseIntArray.append(n12, 5);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintLeft_creator;
        n11 = 82;
        sparseIntArray.append(n12, n11);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintTop_creator;
        sparseIntArray.append(n12, n11);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintRight_creator;
        sparseIntArray.append(n12, n11);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintBottom_creator;
        sparseIntArray.append(n12, n11);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintBaseline_creator;
        sparseIntArray.append(n12, n11);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_android_layout_marginLeft;
        sparseIntArray.append(n12, 24);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_android_layout_marginRight;
        sparseIntArray.append(n12, 28);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_android_layout_marginStart;
        sparseIntArray.append(n12, 31);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_android_layout_marginEnd;
        sparseIntArray.append(n12, 8);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_android_layout_marginTop;
        sparseIntArray.append(n12, 34);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_android_layout_marginBottom;
        sparseIntArray.append(n12, 2);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_android_layout_width;
        sparseIntArray.append(n12, 23);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_android_layout_height;
        sparseIntArray.append(n12, 21);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_android_visibility;
        sparseIntArray.append(n12, 22);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_android_alpha;
        sparseIntArray.append(n12, 43);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_android_elevation;
        sparseIntArray.append(n12, 44);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_android_rotationX;
        sparseIntArray.append(n12, 45);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_android_rotationY;
        sparseIntArray.append(n12, 46);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_android_rotation;
        sparseIntArray.append(n12, 60);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_android_scaleX;
        sparseIntArray.append(n12, 47);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_android_scaleY;
        sparseIntArray.append(n12, 48);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_android_transformPivotX;
        sparseIntArray.append(n12, 49);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_android_transformPivotY;
        sparseIntArray.append(n12, 50);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_android_translationX;
        sparseIntArray.append(n12, 51);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_android_translationY;
        sparseIntArray.append(n12, 52);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_android_translationZ;
        sparseIntArray.append(n12, 53);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintWidth_default;
        sparseIntArray.append(n12, 54);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintHeight_default;
        sparseIntArray.append(n12, 55);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintWidth_max;
        sparseIntArray.append(n12, 56);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintHeight_max;
        sparseIntArray.append(n12, 57);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintWidth_min;
        sparseIntArray.append(n12, 58);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintHeight_min;
        sparseIntArray.append(n12, 59);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintCircle;
        sparseIntArray.append(n12, 61);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintCircleRadius;
        sparseIntArray.append(n12, 62);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintCircleAngle;
        sparseIntArray.append(n12, 63);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_animate_relativeTo;
        sparseIntArray.append(n12, 64);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_transitionEasing;
        sparseIntArray.append(n12, 65);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_drawPath;
        sparseIntArray.append(n12, 66);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_transitionPathRotate;
        sparseIntArray.append(n12, 67);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_motionStagger;
        sparseIntArray.append(n12, 79);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_android_id;
        sparseIntArray.append(n12, 38);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_motionProgress;
        sparseIntArray.append(n12, 68);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintWidth_percent;
        sparseIntArray.append(n12, 69);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintHeight_percent;
        sparseIntArray.append(n12, 70);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_chainUseRtl;
        sparseIntArray.append(n12, 71);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_barrierDirection;
        sparseIntArray.append(n12, 72);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_barrierMargin;
        sparseIntArray.append(n12, 73);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_constraint_referenced_ids;
        sparseIntArray.append(n12, 74);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_barrierAllowsGoneWidgets;
        sparseIntArray.append(n12, 75);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_pathMotionArc;
        sparseIntArray.append(n12, 76);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constraintTag;
        sparseIntArray.append(n12, 77);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_visibilityMode;
        sparseIntArray.append(n12, 78);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constrainedWidth;
        sparseIntArray.append(n12, 80);
        sparseIntArray = mapToConstant;
        n12 = R$styleable.Constraint_layout_constrainedHeight;
        sparseIntArray.append(n12, 81);
    }

    public ConstraintSet() {
        HashMap hashMap;
        this.mSavedAttributes = hashMap = new HashMap();
        this.mForceId = true;
        this.mConstraints = hashMap = new HashMap();
    }

    public static /* synthetic */ int access$100(TypedArray typedArray, int n10, int n11) {
        return ConstraintSet.lookupID(typedArray, n10, n11);
    }

    public static /* synthetic */ int[] access$200() {
        return VISIBILITY_FLAGS;
    }

    private void addAttributes(ConstraintAttribute$AttributeType object, String ... object2) {
        int n10;
        String string2 = null;
        for (int i10 = 0; i10 < (n10 = ((String[])object2).length); ++i10) {
            Object object3 = this.mSavedAttributes;
            Object object4 = object2[i10];
            n10 = (int)(((HashMap)object3).containsKey(object4) ? 1 : 0);
            if (n10 != 0) {
                object3 = this.mSavedAttributes;
                object4 = object2[i10];
                if ((object4 = ((ConstraintAttribute)(object3 = (ConstraintAttribute)((HashMap)object3).get(object4))).getType()) == object) continue;
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("ConstraintAttribute is already a ");
                string2 = ((ConstraintAttribute)object3).getType().name();
                ((StringBuilder)object2).append(string2);
                object2 = ((StringBuilder)object2).toString();
                object = new IllegalArgumentException((String)object2);
                throw object;
            }
            object4 = object2[i10];
            object3 = new ConstraintAttribute((String)object4, (ConstraintAttribute$AttributeType)((Object)object));
            object4 = this.mSavedAttributes;
            String string3 = object2[i10];
            ((HashMap)object4).put(string3, object3);
        }
    }

    private int[] convertReferenceString(View view, String stringArray) {
        int n10;
        stringArray = stringArray.split(",");
        Context context = view.getContext();
        int n11 = stringArray.length;
        int[] nArray = new int[n11];
        int n12 = 0;
        for (int i10 = 0; i10 < (n10 = stringArray.length); ++i10) {
            int n13;
            Object object = stringArray[i10].trim();
            Object object2 = R$id.class;
            object2 = ((Class)object2).getField((String)object);
            boolean bl2 = false;
            Object object3 = null;
            try {
                n13 = ((Field)object2).getInt(null);
            }
            catch (Exception exception) {
                n13 = 0;
                object2 = null;
            }
            if (n13 == 0) {
                object2 = context.getResources();
                object3 = context.getPackageName();
                String string2 = "id";
                n13 = object2.getIdentifier((String)object, string2, (String)object3);
            }
            if (n13 == 0 && (bl2 = view.isInEditMode()) && (bl2 = (object3 = view.getParent()) instanceof ConstraintLayout) && (object = ((ConstraintLayout)((Object)(object3 = (ConstraintLayout)view.getParent()))).getDesignInformation(0, object)) != null && (bl2 = object instanceof Integer)) {
                object = (Integer)object;
                n13 = (Integer)object;
            }
            n10 = n12 + 1;
            nArray[n12] = n13;
            n12 = n10;
        }
        int n14 = stringArray.length;
        if (n12 != n14) {
            nArray = Arrays.copyOf(nArray, n12);
        }
        return nArray;
    }

    private void createHorizontalChain(int n10, int n11, int n12, int n13, int[] nArray, float[] fArray, int n14, int n15, int n16) {
        int[] nArray2 = nArray;
        float[] fArray2 = fArray;
        int n17 = nArray.length;
        Object object = "must have 2 or more widgets in a chain";
        int n18 = 2;
        float f10 = 2.8E-45f;
        if (n17 >= n18) {
            int n19;
            int n20;
            if (fArray != null && (n17 = fArray.length) != (n18 = nArray.length)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
                throw illegalArgumentException;
            }
            n17 = 0;
            Object object2 = null;
            if (fArray2 != null) {
                n20 = nArray2[0];
                object = this.get((int)n20).layout;
                ((ConstraintSet$Layout)object).horizontalWeight = f10 = fArray2[0];
            }
            n20 = nArray2[0];
            object = this.get((int)n20).layout;
            n18 = n14;
            ((ConstraintSet$Layout)object).horizontalChainStyle = n14;
            n20 = nArray2[0];
            int n21 = -1;
            object2 = this;
            n18 = n15;
            int n22 = n10;
            this.connect(n20, n15, n10, n11, n21);
            for (int i10 = n19 = 1; i10 < (n17 = nArray2.length); ++i10) {
                float f11;
                n17 = nArray2[i10];
                n20 = nArray2[i10];
                int n23 = i10 + -1;
                n22 = nArray2[n23];
                n21 = -1;
                object2 = this;
                n18 = n15;
                this.connect(n20, n15, n22, n16, n21);
                n20 = nArray2[n23];
                n22 = nArray2[i10];
                n18 = n16;
                this.connect(n20, n16, n22, n15, n21);
                if (fArray2 == null) continue;
                n17 = nArray2[i10];
                object2 = this.get((int)n17).layout;
                ((ConstraintSet$Layout)object2).horizontalWeight = f11 = fArray2[i10];
            }
            n17 = nArray2.length - n19;
            n20 = nArray2[n17];
            object2 = this;
            n18 = n16;
            n22 = n12;
            this.connect(n20, n16, n12, n13, -1);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    private ConstraintSet$Constraint fillFromAttributeList(Context context, AttributeSet attributeSet) {
        ConstraintSet$Constraint constraintSet$Constraint = new ConstraintSet$Constraint();
        int[] nArray = R$styleable.Constraint;
        attributeSet = context.obtainStyledAttributes(attributeSet, nArray);
        this.populateConstraint(context, constraintSet$Constraint, (TypedArray)attributeSet);
        attributeSet.recycle();
        return constraintSet$Constraint;
    }

    private ConstraintSet$Constraint get(int n10) {
        HashMap hashMap = this.mConstraints;
        Integer n11 = n10;
        boolean bl2 = hashMap.containsKey(n11);
        if (!bl2) {
            hashMap = this.mConstraints;
            n11 = n10;
            ConstraintSet$Constraint constraintSet$Constraint = new ConstraintSet$Constraint();
            hashMap.put(n11, constraintSet$Constraint);
        }
        hashMap = this.mConstraints;
        Integer n12 = n10;
        return (ConstraintSet$Constraint)hashMap.get(n12);
    }

    private static int lookupID(TypedArray typedArray, int n10, int n11) {
        int n12;
        if ((n11 = typedArray.getResourceId(n10, n11)) == (n12 = -1)) {
            n11 = typedArray.getInt(n10, n12);
        }
        return n11;
    }

    private void populateConstraint(Context context, ConstraintSet$Constraint constraintSet$Constraint, TypedArray typedArray) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = typedArray.getIndexCount();
        block84: for (int i10 = 0; i10 < n11; ++i10) {
            Object object;
            int n12 = typedArray.getIndex(i10);
            Object object2 = R$styleable.Constraint_android_id;
            Object n13 = 1;
            float f10 = Float.MIN_VALUE;
            if (n12 != object2 && (object2 = R$styleable.Constraint_android_layout_marginStart) != n12 && (object2 = R$styleable.Constraint_android_layout_marginEnd) != n12) {
                constraintSet$Constraint.motion.mApply = n13;
                constraintSet$Constraint.layout.mApply = n13;
                constraintSet$Constraint.propertySet.mApply = n13;
                object = constraintSet$Constraint.transform;
                ((ConstraintSet$Transform)object).mApply = n13;
            }
            object = mapToConstant;
            object2 = object.get(n12);
            String string2 = "   ";
            float f11 = 1.0f;
            int n14 = 21;
            int n15 = 17;
            String string3 = TAG;
            switch (object2) {
                default: {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Unknown attribute 0x");
                    SparseIntArray sparseIntArray = Integer.toHexString(n12);
                    ((StringBuilder)object).append((String)sparseIntArray);
                    ((StringBuilder)object).append(string2);
                    sparseIntArray = mapToConstant;
                    n12 = sparseIntArray.get(n12);
                    ((StringBuilder)object).append(n12);
                    Object object3 = ((StringBuilder)object).toString();
                    Log.w((String)string3, (String)object3);
                    continue block84;
                }
                case 82: {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("unused attribute 0x");
                    SparseIntArray sparseIntArray = Integer.toHexString(n12);
                    ((StringBuilder)object).append((String)sparseIntArray);
                    ((StringBuilder)object).append(string2);
                    sparseIntArray = mapToConstant;
                    n12 = sparseIntArray.get(n12);
                    ((StringBuilder)object).append(n12);
                    Object object3 = ((StringBuilder)object).toString();
                    Log.w((String)string3, (String)object3);
                    continue block84;
                }
                case 81: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).constrainedHeight;
                    n12 = (int)(typedArray.getBoolean(n12, n13 != 0) ? 1 : 0);
                    ((ConstraintSet$Layout)object).constrainedHeight = n12;
                    continue block84;
                }
                case 80: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).constrainedWidth;
                    n12 = (int)(typedArray.getBoolean(n12, n13 != 0) ? 1 : 0);
                    ((ConstraintSet$Layout)object).constrainedWidth = n12;
                    continue block84;
                }
                case 79: {
                    float f12;
                    object = constraintSet$Constraint.motion;
                    f10 = ((ConstraintSet$Motion)object).mMotionStagger;
                    ((ConstraintSet$Motion)object).mMotionStagger = f12 = typedArray.getFloat(n12, f10);
                    continue block84;
                }
                case 78: {
                    object = constraintSet$Constraint.propertySet;
                    n13 = ((ConstraintSet$PropertySet)object).mVisibilityMode;
                    ((ConstraintSet$PropertySet)object).mVisibilityMode = n12 = typedArray.getInt(n12, n13);
                    continue block84;
                }
                case 77: {
                    object = constraintSet$Constraint.layout;
                    Object object3 = typedArray.getString(n12);
                    ((ConstraintSet$Layout)object).mConstraintTag = object3;
                    continue block84;
                }
                case 76: {
                    object = constraintSet$Constraint.motion;
                    n13 = ((ConstraintSet$Motion)object).mPathMotionArc;
                    ((ConstraintSet$Motion)object).mPathMotionArc = n12 = typedArray.getInt(n12, n13);
                    continue block84;
                }
                case 75: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).mBarrierAllowsGoneWidgets ? 1 : 0;
                    n12 = (int)(typedArray.getBoolean(n12, n13 != 0) ? 1 : 0);
                    ((ConstraintSet$Layout)object).mBarrierAllowsGoneWidgets = n12;
                    continue block84;
                }
                case 74: {
                    object = constraintSet$Constraint.layout;
                    Object object3 = typedArray.getString(n12);
                    ((ConstraintSet$Layout)object).mReferenceIdString = object3;
                    continue block84;
                }
                case 73: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).mBarrierMargin;
                    ((ConstraintSet$Layout)object).mBarrierMargin = n12 = typedArray.getDimensionPixelSize(n12, n13);
                    continue block84;
                }
                case 72: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).mBarrierDirection;
                    ((ConstraintSet$Layout)object).mBarrierDirection = n12 = typedArray.getInt(n12, n13);
                    continue block84;
                }
                case 71: {
                    Object object3 = "CURRENTLY UNSUPPORTED";
                    Log.e((String)string3, (String)object3);
                    continue block84;
                }
                case 70: {
                    float f12;
                    object = constraintSet$Constraint.layout;
                    ((ConstraintSet$Layout)object).heightPercent = f12 = typedArray.getFloat(n12, f11);
                    continue block84;
                }
                case 69: {
                    float f12;
                    object = constraintSet$Constraint.layout;
                    ((ConstraintSet$Layout)object).widthPercent = f12 = typedArray.getFloat(n12, f11);
                    continue block84;
                }
                case 68: {
                    float f12;
                    object = constraintSet$Constraint.propertySet;
                    f10 = ((ConstraintSet$PropertySet)object).mProgress;
                    ((ConstraintSet$PropertySet)object).mProgress = f12 = typedArray.getFloat(n12, f10);
                    continue block84;
                }
                case 67: {
                    float f12;
                    object = constraintSet$Constraint.motion;
                    f10 = ((ConstraintSet$Motion)object).mPathRotate;
                    ((ConstraintSet$Motion)object).mPathRotate = f12 = typedArray.getFloat(n12, f10);
                    continue block84;
                }
                case 66: {
                    object = constraintSet$Constraint.motion;
                    ((ConstraintSet$Motion)object).mDrawPath = n12 = typedArray.getInt(n12, 0);
                    continue block84;
                }
                case 65: {
                    Object object3;
                    object = typedArray.peekValue(n12);
                    object2 = ((TypedValue)object).type;
                    n13 = 3;
                    f10 = 4.2E-45f;
                    if (object2 == n13) {
                        object = constraintSet$Constraint.motion;
                        ((ConstraintSet$Motion)object).mTransitionEasing = object3 = typedArray.getString(n12);
                        continue block84;
                    }
                    object = constraintSet$Constraint.motion;
                    SparseIntArray sparseIntArray = Easing.NAMED_EASING;
                    n12 = typedArray.getInteger(n12, 0);
                    ((ConstraintSet$Motion)object).mTransitionEasing = object3 = sparseIntArray[n12];
                    continue block84;
                }
                case 64: {
                    object = constraintSet$Constraint.motion;
                    n13 = ((ConstraintSet$Motion)object).mAnimateRelativeTo;
                    ((ConstraintSet$Motion)object).mAnimateRelativeTo = n12 = ConstraintSet.lookupID(typedArray, n12, n13);
                    continue block84;
                }
                case 63: {
                    float f12;
                    object = constraintSet$Constraint.layout;
                    f10 = ((ConstraintSet$Layout)object).circleAngle;
                    ((ConstraintSet$Layout)object).circleAngle = f12 = typedArray.getFloat(n12, f10);
                    continue block84;
                }
                case 62: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).circleRadius;
                    ((ConstraintSet$Layout)object).circleRadius = n12 = typedArray.getDimensionPixelSize(n12, n13);
                    continue block84;
                }
                case 61: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).circleConstraint;
                    ((ConstraintSet$Layout)object).circleConstraint = n12 = ConstraintSet.lookupID(typedArray, n12, n13);
                    continue block84;
                }
                case 60: {
                    float f12;
                    object = constraintSet$Constraint.transform;
                    f10 = ((ConstraintSet$Transform)object).rotation;
                    ((ConstraintSet$Transform)object).rotation = f12 = typedArray.getFloat(n12, f10);
                    continue block84;
                }
                case 59: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).heightMin;
                    ((ConstraintSet$Layout)object).heightMin = n12 = typedArray.getDimensionPixelSize(n12, n13);
                    continue block84;
                }
                case 58: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).widthMin;
                    ((ConstraintSet$Layout)object).widthMin = n12 = typedArray.getDimensionPixelSize(n12, n13);
                    continue block84;
                }
                case 57: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).heightMax;
                    ((ConstraintSet$Layout)object).heightMax = n12 = typedArray.getDimensionPixelSize(n12, n13);
                    continue block84;
                }
                case 56: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).widthMax;
                    ((ConstraintSet$Layout)object).widthMax = n12 = typedArray.getDimensionPixelSize(n12, n13);
                    continue block84;
                }
                case 55: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).heightDefault;
                    ((ConstraintSet$Layout)object).heightDefault = n12 = typedArray.getInt(n12, n13);
                    continue block84;
                }
                case 54: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).widthDefault;
                    ((ConstraintSet$Layout)object).widthDefault = n12 = typedArray.getInt(n12, n13);
                    continue block84;
                }
                case 53: {
                    float f12;
                    if (n10 < n14) continue block84;
                    object = constraintSet$Constraint.transform;
                    f10 = ((ConstraintSet$Transform)object).translationZ;
                    ((ConstraintSet$Transform)object).translationZ = f12 = typedArray.getDimension(n12, f10);
                    continue block84;
                }
                case 52: {
                    float f12;
                    object = constraintSet$Constraint.transform;
                    f10 = ((ConstraintSet$Transform)object).translationY;
                    ((ConstraintSet$Transform)object).translationY = f12 = typedArray.getDimension(n12, f10);
                    continue block84;
                }
                case 51: {
                    float f12;
                    object = constraintSet$Constraint.transform;
                    f10 = ((ConstraintSet$Transform)object).translationX;
                    ((ConstraintSet$Transform)object).translationX = f12 = typedArray.getDimension(n12, f10);
                    continue block84;
                }
                case 50: {
                    float f12;
                    object = constraintSet$Constraint.transform;
                    f10 = ((ConstraintSet$Transform)object).transformPivotY;
                    ((ConstraintSet$Transform)object).transformPivotY = f12 = typedArray.getDimension(n12, f10);
                    continue block84;
                }
                case 49: {
                    float f12;
                    object = constraintSet$Constraint.transform;
                    f10 = ((ConstraintSet$Transform)object).transformPivotX;
                    ((ConstraintSet$Transform)object).transformPivotX = f12 = typedArray.getDimension(n12, f10);
                    continue block84;
                }
                case 48: {
                    float f12;
                    object = constraintSet$Constraint.transform;
                    f10 = ((ConstraintSet$Transform)object).scaleY;
                    ((ConstraintSet$Transform)object).scaleY = f12 = typedArray.getFloat(n12, f10);
                    continue block84;
                }
                case 47: {
                    float f12;
                    object = constraintSet$Constraint.transform;
                    f10 = ((ConstraintSet$Transform)object).scaleX;
                    ((ConstraintSet$Transform)object).scaleX = f12 = typedArray.getFloat(n12, f10);
                    continue block84;
                }
                case 46: {
                    float f12;
                    object = constraintSet$Constraint.transform;
                    f10 = ((ConstraintSet$Transform)object).rotationY;
                    ((ConstraintSet$Transform)object).rotationY = f12 = typedArray.getFloat(n12, f10);
                    continue block84;
                }
                case 45: {
                    float f12;
                    object = constraintSet$Constraint.transform;
                    f10 = ((ConstraintSet$Transform)object).rotationX;
                    ((ConstraintSet$Transform)object).rotationX = f12 = typedArray.getFloat(n12, f10);
                    continue block84;
                }
                case 44: {
                    float f12;
                    if (n10 < n14) continue block84;
                    object = constraintSet$Constraint.transform;
                    ((ConstraintSet$Transform)object).applyElevation = n13;
                    f10 = ((ConstraintSet$Transform)object).elevation;
                    ((ConstraintSet$Transform)object).elevation = f12 = typedArray.getDimension(n12, f10);
                    continue block84;
                }
                case 43: {
                    float f12;
                    object = constraintSet$Constraint.propertySet;
                    f10 = ((ConstraintSet$PropertySet)object).alpha;
                    ((ConstraintSet$PropertySet)object).alpha = f12 = typedArray.getFloat(n12, f10);
                    continue block84;
                }
                case 42: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).verticalChainStyle;
                    ((ConstraintSet$Layout)object).verticalChainStyle = n12 = typedArray.getInt(n12, n13);
                    continue block84;
                }
                case 41: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).horizontalChainStyle;
                    ((ConstraintSet$Layout)object).horizontalChainStyle = n12 = typedArray.getInt(n12, n13);
                    continue block84;
                }
                case 40: {
                    float f12;
                    object = constraintSet$Constraint.layout;
                    f10 = ((ConstraintSet$Layout)object).verticalWeight;
                    ((ConstraintSet$Layout)object).verticalWeight = f12 = typedArray.getFloat(n12, f10);
                    continue block84;
                }
                case 39: {
                    float f12;
                    object = constraintSet$Constraint.layout;
                    f10 = ((ConstraintSet$Layout)object).horizontalWeight;
                    ((ConstraintSet$Layout)object).horizontalWeight = f12 = typedArray.getFloat(n12, f10);
                    continue block84;
                }
                case 38: {
                    object2 = constraintSet$Constraint.mViewId;
                    constraintSet$Constraint.mViewId = n12 = typedArray.getResourceId(n12, object2);
                    continue block84;
                }
                case 37: {
                    float f12;
                    object = constraintSet$Constraint.layout;
                    f10 = ((ConstraintSet$Layout)object).verticalBias;
                    ((ConstraintSet$Layout)object).verticalBias = f12 = typedArray.getFloat(n12, f10);
                    continue block84;
                }
                case 36: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).topToTop;
                    ((ConstraintSet$Layout)object).topToTop = n12 = ConstraintSet.lookupID(typedArray, n12, n13);
                    continue block84;
                }
                case 35: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).topToBottom;
                    ((ConstraintSet$Layout)object).topToBottom = n12 = ConstraintSet.lookupID(typedArray, n12, n13);
                    continue block84;
                }
                case 34: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).topMargin;
                    ((ConstraintSet$Layout)object).topMargin = n12 = typedArray.getDimensionPixelSize(n12, n13);
                    continue block84;
                }
                case 33: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).startToStart;
                    ((ConstraintSet$Layout)object).startToStart = n12 = ConstraintSet.lookupID(typedArray, n12, n13);
                    continue block84;
                }
                case 32: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).startToEnd;
                    ((ConstraintSet$Layout)object).startToEnd = n12 = ConstraintSet.lookupID(typedArray, n12, n13);
                    continue block84;
                }
                case 31: {
                    if (n10 < n15) continue block84;
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).startMargin;
                    ((ConstraintSet$Layout)object).startMargin = n12 = typedArray.getDimensionPixelSize(n12, n13);
                    continue block84;
                }
                case 30: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).rightToRight;
                    ((ConstraintSet$Layout)object).rightToRight = n12 = ConstraintSet.lookupID(typedArray, n12, n13);
                    continue block84;
                }
                case 29: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).rightToLeft;
                    ((ConstraintSet$Layout)object).rightToLeft = n12 = ConstraintSet.lookupID(typedArray, n12, n13);
                    continue block84;
                }
                case 28: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).rightMargin;
                    ((ConstraintSet$Layout)object).rightMargin = n12 = typedArray.getDimensionPixelSize(n12, n13);
                    continue block84;
                }
                case 27: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).orientation;
                    ((ConstraintSet$Layout)object).orientation = n12 = typedArray.getInt(n12, n13);
                    continue block84;
                }
                case 26: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).leftToRight;
                    ((ConstraintSet$Layout)object).leftToRight = n12 = ConstraintSet.lookupID(typedArray, n12, n13);
                    continue block84;
                }
                case 25: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).leftToLeft;
                    ((ConstraintSet$Layout)object).leftToLeft = n12 = ConstraintSet.lookupID(typedArray, n12, n13);
                    continue block84;
                }
                case 24: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).leftMargin;
                    ((ConstraintSet$Layout)object).leftMargin = n12 = typedArray.getDimensionPixelSize(n12, n13);
                    continue block84;
                }
                case 23: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).mWidth;
                    ((ConstraintSet$Layout)object).mWidth = n12 = typedArray.getLayoutDimension(n12, n13);
                    continue block84;
                }
                case 22: {
                    object = constraintSet$Constraint.propertySet;
                    n13 = ((ConstraintSet$PropertySet)object).visibility;
                    ((ConstraintSet$PropertySet)object).visibility = n12 = typedArray.getInt(n12, n13);
                    Object object3 = constraintSet$Constraint.propertySet;
                    object = VISIBILITY_FLAGS;
                    n13 = ((ConstraintSet$PropertySet)object3).visibility;
                    ((ConstraintSet$PropertySet)object3).visibility = object2 = (Object)object[n13];
                    continue block84;
                }
                case 21: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).mHeight;
                    ((ConstraintSet$Layout)object).mHeight = n12 = typedArray.getLayoutDimension(n12, n13);
                    continue block84;
                }
                case 20: {
                    float f12;
                    object = constraintSet$Constraint.layout;
                    f10 = ((ConstraintSet$Layout)object).horizontalBias;
                    ((ConstraintSet$Layout)object).horizontalBias = f12 = typedArray.getFloat(n12, f10);
                    continue block84;
                }
                case 19: {
                    float f12;
                    object = constraintSet$Constraint.layout;
                    f10 = ((ConstraintSet$Layout)object).guidePercent;
                    ((ConstraintSet$Layout)object).guidePercent = f12 = typedArray.getFloat(n12, f10);
                    continue block84;
                }
                case 18: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).guideEnd;
                    ((ConstraintSet$Layout)object).guideEnd = n12 = typedArray.getDimensionPixelOffset(n12, n13);
                    continue block84;
                }
                case 17: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).guideBegin;
                    ((ConstraintSet$Layout)object).guideBegin = n12 = typedArray.getDimensionPixelOffset(n12, n13);
                    continue block84;
                }
                case 16: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).goneTopMargin;
                    ((ConstraintSet$Layout)object).goneTopMargin = n12 = typedArray.getDimensionPixelSize(n12, n13);
                    continue block84;
                }
                case 15: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).goneStartMargin;
                    ((ConstraintSet$Layout)object).goneStartMargin = n12 = typedArray.getDimensionPixelSize(n12, n13);
                    continue block84;
                }
                case 14: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).goneRightMargin;
                    ((ConstraintSet$Layout)object).goneRightMargin = n12 = typedArray.getDimensionPixelSize(n12, n13);
                    continue block84;
                }
                case 13: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).goneLeftMargin;
                    ((ConstraintSet$Layout)object).goneLeftMargin = n12 = typedArray.getDimensionPixelSize(n12, n13);
                    continue block84;
                }
                case 12: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).goneEndMargin;
                    ((ConstraintSet$Layout)object).goneEndMargin = n12 = typedArray.getDimensionPixelSize(n12, n13);
                    continue block84;
                }
                case 11: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).goneBottomMargin;
                    ((ConstraintSet$Layout)object).goneBottomMargin = n12 = typedArray.getDimensionPixelSize(n12, n13);
                    continue block84;
                }
                case 10: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).endToStart;
                    ((ConstraintSet$Layout)object).endToStart = n12 = ConstraintSet.lookupID(typedArray, n12, n13);
                    continue block84;
                }
                case 9: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).endToEnd;
                    ((ConstraintSet$Layout)object).endToEnd = n12 = ConstraintSet.lookupID(typedArray, n12, n13);
                    continue block84;
                }
                case 8: {
                    if (n10 < n15) continue block84;
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).endMargin;
                    ((ConstraintSet$Layout)object).endMargin = n12 = typedArray.getDimensionPixelSize(n12, n13);
                    continue block84;
                }
                case 7: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).editorAbsoluteY;
                    ((ConstraintSet$Layout)object).editorAbsoluteY = n12 = typedArray.getDimensionPixelOffset(n12, n13);
                    continue block84;
                }
                case 6: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).editorAbsoluteX;
                    ((ConstraintSet$Layout)object).editorAbsoluteX = n12 = typedArray.getDimensionPixelOffset(n12, n13);
                    continue block84;
                }
                case 5: {
                    object = constraintSet$Constraint.layout;
                    Object object3 = typedArray.getString(n12);
                    ((ConstraintSet$Layout)object).dimensionRatio = object3;
                    continue block84;
                }
                case 4: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).bottomToTop;
                    ((ConstraintSet$Layout)object).bottomToTop = n12 = ConstraintSet.lookupID(typedArray, n12, n13);
                    continue block84;
                }
                case 3: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).bottomToBottom;
                    ((ConstraintSet$Layout)object).bottomToBottom = n12 = ConstraintSet.lookupID(typedArray, n12, n13);
                    continue block84;
                }
                case 2: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).bottomMargin;
                    ((ConstraintSet$Layout)object).bottomMargin = n12 = typedArray.getDimensionPixelSize(n12, n13);
                    continue block84;
                }
                case 1: {
                    object = constraintSet$Constraint.layout;
                    n13 = ((ConstraintSet$Layout)object).baselineToBaseline;
                    ((ConstraintSet$Layout)object).baselineToBaseline = n12 = ConstraintSet.lookupID(typedArray, n12, n13);
                }
            }
        }
    }

    private String sideToString(int n10) {
        switch (n10) {
            default: {
                return "undefined";
            }
            case 7: {
                return "end";
            }
            case 6: {
                return "start";
            }
            case 5: {
                return "baseline";
            }
            case 4: {
                return "bottom";
            }
            case 3: {
                return "top";
            }
            case 2: {
                return "right";
            }
            case 1: 
        }
        return "left";
    }

    private static String[] splitString(String stringArray) {
        Object object;
        stringArray = (String[])stringArray.toCharArray();
        ArrayList<String> arrayList = new ArrayList<String>();
        String string2 = null;
        int n10 = 0;
        int n11 = 0;
        for (int i10 = 0; i10 < (object = stringArray.length); ++i10) {
            object = stringArray[i10];
            Object object2 = 44;
            if (object == object2 && n11 == 0) {
                object2 = i10 - n10;
                String string3 = new String((char[])stringArray, n10, (int)object2);
                arrayList.add(string3);
                n10 = i10 + 1;
                continue;
            }
            object = stringArray[i10];
            object2 = 34;
            if (object != object2) continue;
            n11 ^= 1;
        }
        n11 = stringArray.length - n10;
        string2 = new String((char[])stringArray, n10, n11);
        arrayList.add(string2);
        stringArray = new String[arrayList.size()];
        return arrayList.toArray(stringArray);
    }

    public void addColorAttributes(String ... stringArray) {
        ConstraintAttribute$AttributeType constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.COLOR_TYPE;
        this.addAttributes(constraintAttribute$AttributeType, stringArray);
    }

    public void addFloatAttributes(String ... stringArray) {
        ConstraintAttribute$AttributeType constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.FLOAT_TYPE;
        this.addAttributes(constraintAttribute$AttributeType, stringArray);
    }

    public void addIntAttributes(String ... stringArray) {
        ConstraintAttribute$AttributeType constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.INT_TYPE;
        this.addAttributes(constraintAttribute$AttributeType, stringArray);
    }

    public void addStringAttributes(String ... stringArray) {
        ConstraintAttribute$AttributeType constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.STRING_TYPE;
        this.addAttributes(constraintAttribute$AttributeType, stringArray);
    }

    public void addToHorizontalChain(int n10, int n11, int n12) {
        int n13 = 1;
        int n14 = 2;
        int n15 = n11 == 0 ? n13 : n14;
        this.connect(n10, 1, n11, n15, 0);
        int n16 = 2;
        n15 = n12 == 0 ? n14 : n13;
        this.connect(n10, n16, n12, n15, 0);
        if (n11 != 0) {
            n16 = 2;
            n15 = 1;
            this.connect(n11, n16, n10, n15, 0);
        }
        if (n12 != 0) {
            n16 = 1;
            n15 = 2;
            this.connect(n12, n16, n10, n15, 0);
        }
    }

    public void addToHorizontalChainRTL(int n10, int n11, int n12) {
        int n13 = 6;
        int n14 = 7;
        int n15 = n11 == 0 ? n13 : n14;
        this.connect(n10, 6, n11, n15, 0);
        int n16 = 7;
        n15 = n12 == 0 ? n14 : n13;
        this.connect(n10, n16, n12, n15, 0);
        if (n11 != 0) {
            n16 = 7;
            n15 = 6;
            this.connect(n11, n16, n10, n15, 0);
        }
        if (n12 != 0) {
            n16 = 6;
            n15 = 7;
            this.connect(n12, n16, n10, n15, 0);
        }
    }

    public void addToVerticalChain(int n10, int n11, int n12) {
        int n13 = 3;
        int n14 = 4;
        int n15 = n11 == 0 ? n13 : n14;
        this.connect(n10, 3, n11, n15, 0);
        int n16 = 4;
        n15 = n12 == 0 ? n14 : n13;
        this.connect(n10, n16, n12, n15, 0);
        if (n11 != 0) {
            n16 = 4;
            n15 = 3;
            this.connect(n11, n16, n10, n15, 0);
        }
        if (n12 != 0) {
            n16 = 3;
            n15 = 4;
            this.connect(n12, n16, n10, n15, 0);
        }
    }

    public void applyCustomAttributes(ConstraintLayout object) {
        int n10 = object.getChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object2;
            Object object3 = this.mConstraints;
            Object object4 = object.getChildAt(i10);
            int n11 = object4.getId();
            Integer n12 = n11;
            int n13 = ((HashMap)object3).containsKey(n12);
            if (n13 == 0) {
                object2 = new StringBuilder();
                object3 = "id unknown ";
                ((StringBuilder)object2).append((String)object3);
                object4 = Debug.getName(object4);
                ((StringBuilder)object2).append((String)object4);
                object4 = ((StringBuilder)object2).toString();
                object2 = TAG;
                Log.v((String)object2, (String)object4);
                continue;
            }
            n13 = this.mForceId;
            if (n13 != 0 && n11 == (n13 = -1)) {
                object = new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                throw object;
            }
            object3 = this.mConstraints;
            n12 = n11;
            n13 = (int)(((HashMap)object3).containsKey(n12) ? 1 : 0);
            if (n13 == 0) continue;
            object3 = this.mConstraints;
            object2 = n11;
            object2 = ((ConstraintSet$Constraint)object3.get((Object)object2)).mCustomConstraints;
            ConstraintAttribute.setAttributes(object4, (HashMap)object2);
        }
    }

    public void applyTo(ConstraintLayout constraintLayout) {
        this.applyToInternal(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void applyToHelper(ConstraintHelper constraintHelper, ConstraintWidget constraintWidget, ConstraintLayout$LayoutParams constraintLayout$LayoutParams, SparseArray sparseArray) {
        HashMap hashMap = this.mConstraints;
        int n10 = constraintHelper.getId();
        Integer n11 = n10;
        boolean bl2 = hashMap.containsKey(n11);
        if (bl2) {
            hashMap = this.mConstraints;
            Object object = n10;
            object = (ConstraintSet$Constraint)hashMap.get(object);
            bl2 = constraintWidget instanceof HelperWidget;
            if (bl2) {
                constraintWidget = (HelperWidget)constraintWidget;
                constraintHelper.loadParameters((ConstraintSet$Constraint)object, (HelperWidget)constraintWidget, constraintLayout$LayoutParams, sparseArray);
            }
        }
    }

    public void applyToInternal(ConstraintLayout object, boolean bl2) {
        Object object2;
        Object object3;
        Object n10;
        Object n11;
        Object n12 = object.getChildCount();
        Object object4 = this.mConstraints.keySet();
        Object object5 = new HashSet(object4);
        Object n13 = 0;
        object4 = null;
        while (true) {
            Object object6;
            Object object7;
            n11 = 1;
            float f10 = Float.MIN_VALUE;
            n10 = -1;
            float f11 = 0.0f / 0.0f;
            if (n13 >= n12) break;
            object3 = object.getChildAt(n13);
            Object n14 = object3.getId();
            Object object8 = this.mConstraints;
            Object object9 = n14;
            boolean bl3 = ((HashMap)object8).containsKey(object9);
            object9 = TAG;
            if (!bl3) {
                object7 = new StringBuilder();
                ((StringBuilder)object7).append("id unknown ");
                object6 = Debug.getName(object3);
                ((StringBuilder)object7).append((String)object6);
                object7 = ((StringBuilder)object7).toString();
                Log.w((String)object9, (String)object7);
            } else {
                bl3 = this.mForceId;
                if (bl3 && n14 == n10) {
                    object = new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                    throw object;
                }
                if (n14 != n10) {
                    object8 = this.mConstraints;
                    Integer n15 = n14;
                    bl3 = ((HashMap)object8).containsKey(n15);
                    if (bl3) {
                        object8 = n14;
                        ((HashSet)object5).remove(object8);
                        object8 = this.mConstraints;
                        object9 = n14;
                        object8 = (ConstraintSet$Constraint)((HashMap)object8).get(object9);
                        int n16 = object3 instanceof Barrier;
                        if (n16 != 0) {
                            object9 = ((ConstraintSet$Constraint)object8).layout;
                            ((ConstraintSet$Layout)object9).mHelperType = n11;
                        }
                        object9 = ((ConstraintSet$Constraint)object8).layout;
                        n16 = ((ConstraintSet$Layout)object9).mHelperType;
                        if (n16 != n10 && n16 == n11) {
                            object7 = object3;
                            object7 = (Barrier)((Object)object3);
                            object7.setId(n14);
                            n10 = object8.layout.mBarrierDirection;
                            ((Barrier)((Object)object7)).setType((int)n10);
                            n10 = object8.layout.mBarrierMargin;
                            ((Barrier)((Object)object7)).setMargin((int)n10);
                            n10 = object8.layout.mBarrierAllowsGoneWidgets ? 1 : 0;
                            ((Barrier)((Object)object7)).setAllowsGoneWidget(n10 != 0);
                            object6 = ((ConstraintSet$Constraint)object8).layout;
                            object2 = ((ConstraintSet$Layout)object6).mReferenceIds;
                            if (object2 != null) {
                                ((ConstraintHelper)((Object)object7)).setReferencedIds((int[])object2);
                            } else {
                                object2 = ((ConstraintSet$Layout)object6).mReferenceIdString;
                                if (object2 != null) {
                                    ((ConstraintSet$Layout)object6).mReferenceIds = object2 = this.convertReferenceString((View)object7, (String)object2);
                                    object6 = object8.layout.mReferenceIds;
                                    ((ConstraintHelper)((Object)object7)).setReferencedIds((int[])object6);
                                }
                            }
                        }
                        object7 = (ConstraintLayout$LayoutParams)object3.getLayoutParams();
                        ((ConstraintLayout$LayoutParams)((Object)object7)).validate();
                        ((ConstraintSet$Constraint)object8).applyTo((ConstraintLayout$LayoutParams)((Object)object7));
                        if (bl2) {
                            object6 = ((ConstraintSet$Constraint)object8).mCustomConstraints;
                            ConstraintAttribute.setAttributes(object3, (HashMap)object6);
                        }
                        object3.setLayoutParams((ViewGroup.LayoutParams)object7);
                        object7 = ((ConstraintSet$Constraint)object8).propertySet;
                        n10 = ((ConstraintSet$PropertySet)object7).mVisibilityMode;
                        if (n10 == 0) {
                            n11 = ((ConstraintSet$PropertySet)object7).visibility;
                            object3.setVisibility(n11);
                        }
                        n11 = Build.VERSION.SDK_INT;
                        n10 = 17;
                        f11 = 2.4E-44f;
                        if (n11 >= n10) {
                            f11 = object8.propertySet.alpha;
                            object3.setAlpha(f11);
                            f11 = object8.transform.rotation;
                            object3.setRotation(f11);
                            f11 = object8.transform.rotationX;
                            object3.setRotationX(f11);
                            f11 = object8.transform.rotationY;
                            object3.setRotationY(f11);
                            f11 = object8.transform.scaleX;
                            object3.setScaleX(f11);
                            f11 = object8.transform.scaleY;
                            object3.setScaleY(f11);
                            object6 = ((ConstraintSet$Constraint)object8).transform;
                            f11 = ((ConstraintSet$Transform)object6).transformPivotX;
                            n10 = Float.isNaN(f11);
                            if (n10 == 0) {
                                object6 = ((ConstraintSet$Constraint)object8).transform;
                                f11 = ((ConstraintSet$Transform)object6).transformPivotX;
                                object3.setPivotX(f11);
                            }
                            object6 = ((ConstraintSet$Constraint)object8).transform;
                            f11 = ((ConstraintSet$Transform)object6).transformPivotY;
                            n10 = Float.isNaN(f11);
                            if (n10 == 0) {
                                object6 = ((ConstraintSet$Constraint)object8).transform;
                                f11 = ((ConstraintSet$Transform)object6).transformPivotY;
                                object3.setPivotY(f11);
                            }
                            f11 = object8.transform.translationX;
                            object3.setTranslationX(f11);
                            object6 = ((ConstraintSet$Constraint)object8).transform;
                            f11 = ((ConstraintSet$Transform)object6).translationY;
                            object3.setTranslationY(f11);
                            n10 = 21;
                            f11 = 2.9E-44f;
                            if (n11 >= n10) {
                                f10 = object8.transform.translationZ;
                                object3.setTranslationZ(f10);
                                object7 = ((ConstraintSet$Constraint)object8).transform;
                                n10 = ((ConstraintSet$Transform)object7).applyElevation ? 1 : 0;
                                if (n10 != 0) {
                                    f10 = ((ConstraintSet$Transform)object7).elevation;
                                    object3.setElevation(f10);
                                }
                            }
                        }
                    } else {
                        object7 = new StringBuilder();
                        object6 = "WARNING NO CONSTRAINTS for view ";
                        ((StringBuilder)object7).append((String)object6);
                        ((StringBuilder)object7).append((int)n14);
                        object7 = ((StringBuilder)object7).toString();
                        Log.v((String)object9, (String)object7);
                    }
                }
            }
            ++n13;
        }
        Iterator iterator2 = ((HashSet)object5).iterator();
        while ((n12 = (Object)(iterator2.hasNext() ? 1 : 0)) != 0) {
            Object object10 = (Integer)iterator2.next();
            object5 = (ConstraintSet$Constraint)this.mConstraints.get(object10);
            object4 = ((ConstraintSet$Constraint)object5).layout;
            n13 = ((ConstraintSet$Layout)object4).mHelperType;
            if (n13 != n10 && n13 == n11) {
                object3 = object.getContext();
                object4 = new Barrier((Context)object3);
                int n17 = object10;
                object4.setId(n17);
                object3 = ((ConstraintSet$Constraint)object5).layout;
                object2 = object3.mReferenceIds;
                if (object2 != null) {
                    ((ConstraintHelper)((Object)object4)).setReferencedIds((int[])object2);
                } else {
                    object2 = object3.mReferenceIdString;
                    if (object2 != null) {
                        object3.mReferenceIds = object2 = this.convertReferenceString((View)object4, (String)object2);
                        object3 = object5.layout.mReferenceIds;
                        ((ConstraintHelper)((Object)object4)).setReferencedIds((int[])object3);
                    }
                }
                n17 = object5.layout.mBarrierDirection;
                ((Barrier)((Object)object4)).setType(n17);
                n17 = object5.layout.mBarrierMargin;
                ((Barrier)((Object)object4)).setMargin(n17);
                object3 = ((ConstraintLayout)((Object)object)).generateDefaultLayoutParams();
                ((ConstraintHelper)((Object)object4)).validateParams();
                ((ConstraintSet$Constraint)object5).applyTo((ConstraintLayout$LayoutParams)((Object)object3));
                object.addView((View)object4, (ViewGroup.LayoutParams)object3);
            }
            object4 = ((ConstraintSet$Constraint)object5).layout;
            n13 = ((ConstraintSet$Layout)object4).mIsGuideline ? 1 : 0;
            if (n13 == 0) continue;
            object3 = object.getContext();
            object4 = new Guideline((Context)object3);
            n12 = object10;
            object4.setId(n12);
            object10 = ((ConstraintLayout)((Object)object)).generateDefaultLayoutParams();
            ((ConstraintSet$Constraint)object5).applyTo((ConstraintLayout$LayoutParams)((Object)object10));
            object.addView((View)object4, (ViewGroup.LayoutParams)object10);
        }
    }

    public void applyToLayoutParams(int n10, ConstraintLayout$LayoutParams constraintLayout$LayoutParams) {
        HashMap hashMap = this.mConstraints;
        Integer n11 = n10;
        boolean bl2 = hashMap.containsKey(n11);
        if (bl2) {
            hashMap = this.mConstraints;
            Object object = n10;
            object = (ConstraintSet$Constraint)hashMap.get(object);
            ((ConstraintSet$Constraint)object).applyTo(constraintLayout$LayoutParams);
        }
    }

    public void applyToWithoutCustom(ConstraintLayout constraintLayout) {
        this.applyToInternal(constraintLayout, false);
        constraintLayout.setConstraintSet(null);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void center(int n10, int n11, int n12, int n13, int n14, int n15, int n16, float f10) {
        float f11;
        ConstraintSet constraintSet = this;
        float f12 = f10;
        Object object = "margin must be > 0";
        if (n13 < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
        if (n16 < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
        float f13 = 0.0f;
        object = null;
        float f14 = f10 - 0.0f;
        float f15 = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
        if (f15 > 0 && (f15 = (f11 = f10 - (f13 = 1.0f)) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) <= 0) {
            f15 = 1.0f;
            f13 = Float.MIN_VALUE;
            if (n12 != f15) {
                f15 = 2;
                f13 = 2.8E-45f;
                if (n12 != f15) {
                    f15 = 6;
                    f13 = 8.4E-45f;
                    if (n12 != f15) {
                        f15 = 7;
                        f13 = 9.8E-45f;
                        if (n12 != f15) {
                            object = this;
                            this.connect(n10, 3, n11, n12, n13);
                            int n17 = 4;
                            this.connect(n10, n17, n14, n15, n16);
                            object = this.mConstraints;
                            Integer n18 = n10;
                            object = ((ConstraintSet$Constraint)object.get((Object)n18)).layout;
                            ((ConstraintSet$Layout)object).verticalBias = f10;
                            return;
                        }
                    }
                    object = this;
                    this.connect(n10, 6, n11, n12, n13);
                    int n19 = 7;
                    this.connect(n10, n19, n14, n15, n16);
                    object = constraintSet.mConstraints;
                    Integer n20 = n10;
                    object = ((ConstraintSet$Constraint)object.get((Object)n20)).layout;
                    ((ConstraintSet$Layout)object).horizontalBias = f12;
                    return;
                }
            }
            object = this;
            this.connect(n10, 1, n11, n12, n13);
            int n21 = 2;
            this.connect(n10, n21, n14, n15, n16);
            object = constraintSet.mConstraints;
            Integer n22 = n10;
            object = ((ConstraintSet$Constraint)object.get((Object)n22)).layout;
            ((ConstraintSet$Layout)object).horizontalBias = f12;
            return;
        }
        object = new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        throw object;
    }

    public void centerHorizontally(int n10, int n11) {
        if (n11 == 0) {
            int n12 = 1;
            int n13 = 2;
            float f10 = 0.5f;
            this.center(n10, 0, n12, 0, 0, n13, 0, f10);
        } else {
            int n14 = 2;
            int n15 = 1;
            float f11 = 0.5f;
            this.center(n10, n11, n14, 0, n11, n15, 0, f11);
        }
    }

    public void centerHorizontally(int n10, int n11, int n12, int n13, int n14, int n15, int n16, float f10) {
        this.connect(n10, 1, n11, n12, n13);
        this.connect(n10, 2, n14, n15, n16);
        HashMap hashMap = this.mConstraints;
        Integer n17 = n10;
        ((ConstraintSet$Constraint)hashMap.get((Object)n17)).layout.horizontalBias = f10;
    }

    public void centerHorizontallyRtl(int n10, int n11) {
        if (n11 == 0) {
            int n12 = 6;
            int n13 = 7;
            float f10 = 0.5f;
            this.center(n10, 0, n12, 0, 0, n13, 0, f10);
        } else {
            int n14 = 7;
            int n15 = 6;
            float f11 = 0.5f;
            this.center(n10, n11, n14, 0, n11, n15, 0, f11);
        }
    }

    public void centerHorizontallyRtl(int n10, int n11, int n12, int n13, int n14, int n15, int n16, float f10) {
        this.connect(n10, 6, n11, n12, n13);
        this.connect(n10, 7, n14, n15, n16);
        HashMap hashMap = this.mConstraints;
        Integer n17 = n10;
        ((ConstraintSet$Constraint)hashMap.get((Object)n17)).layout.horizontalBias = f10;
    }

    public void centerVertically(int n10, int n11) {
        if (n11 == 0) {
            int n12 = 3;
            int n13 = 4;
            float f10 = 0.5f;
            this.center(n10, 0, n12, 0, 0, n13, 0, f10);
        } else {
            int n14 = 4;
            int n15 = 3;
            float f11 = 0.5f;
            this.center(n10, n11, n14, 0, n11, n15, 0, f11);
        }
    }

    public void centerVertically(int n10, int n11, int n12, int n13, int n14, int n15, int n16, float f10) {
        this.connect(n10, 3, n11, n12, n13);
        this.connect(n10, 4, n14, n15, n16);
        HashMap hashMap = this.mConstraints;
        Integer n17 = n10;
        ((ConstraintSet$Constraint)hashMap.get((Object)n17)).layout.verticalBias = f10;
    }

    public void clear(int n10) {
        HashMap hashMap = this.mConstraints;
        Integer n11 = n10;
        hashMap.remove(n11);
    }

    public void clear(int n10, int n11) {
        HashMap hashMap = this.mConstraints;
        Integer n12 = n10;
        int n13 = hashMap.containsKey(n12);
        if (n13 != 0) {
            hashMap = this.mConstraints;
            Object object = n10;
            object = (ConstraintSet$Constraint)hashMap.get(object);
            n13 = -1;
            switch (n11) {
                default: {
                    object = new IllegalArgumentException("unknown constraint");
                    throw object;
                }
                case 7: {
                    object = ((ConstraintSet$Constraint)object).layout;
                    ((ConstraintSet$Layout)object).endToStart = n13;
                    ((ConstraintSet$Layout)object).endToEnd = n13;
                    ((ConstraintSet$Layout)object).endMargin = n13;
                    ((ConstraintSet$Layout)object).goneEndMargin = n13;
                    break;
                }
                case 6: {
                    object = ((ConstraintSet$Constraint)object).layout;
                    ((ConstraintSet$Layout)object).startToEnd = n13;
                    ((ConstraintSet$Layout)object).startToStart = n13;
                    ((ConstraintSet$Layout)object).startMargin = n13;
                    ((ConstraintSet$Layout)object).goneStartMargin = n13;
                    break;
                }
                case 5: {
                    object = ((ConstraintSet$Constraint)object).layout;
                    ((ConstraintSet$Layout)object).baselineToBaseline = n13;
                    break;
                }
                case 4: {
                    object = ((ConstraintSet$Constraint)object).layout;
                    ((ConstraintSet$Layout)object).bottomToTop = n13;
                    ((ConstraintSet$Layout)object).bottomToBottom = n13;
                    ((ConstraintSet$Layout)object).bottomMargin = n13;
                    ((ConstraintSet$Layout)object).goneBottomMargin = n13;
                    break;
                }
                case 3: {
                    object = ((ConstraintSet$Constraint)object).layout;
                    ((ConstraintSet$Layout)object).topToBottom = n13;
                    ((ConstraintSet$Layout)object).topToTop = n13;
                    ((ConstraintSet$Layout)object).topMargin = n13;
                    ((ConstraintSet$Layout)object).goneTopMargin = n13;
                    break;
                }
                case 2: {
                    object = ((ConstraintSet$Constraint)object).layout;
                    ((ConstraintSet$Layout)object).rightToRight = n13;
                    ((ConstraintSet$Layout)object).rightToLeft = n13;
                    ((ConstraintSet$Layout)object).rightMargin = n13;
                    ((ConstraintSet$Layout)object).goneRightMargin = n13;
                    break;
                }
                case 1: {
                    object = ((ConstraintSet$Constraint)object).layout;
                    ((ConstraintSet$Layout)object).leftToRight = n13;
                    ((ConstraintSet$Layout)object).leftToLeft = n13;
                    ((ConstraintSet$Layout)object).leftMargin = n13;
                    ((ConstraintSet$Layout)object).goneLeftMargin = n13;
                }
            }
        }
    }

    public void clone(Context object, int n10) {
        object = (ConstraintLayout)LayoutInflater.from((Context)object).inflate(n10, null);
        this.clone((ConstraintLayout)((Object)object));
    }

    public void clone(ConstraintLayout object) {
        int n10 = object.getChildCount();
        this.mConstraints.clear();
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            Object object2;
            Object object3;
            View view = object.getChildAt(i10);
            Object object4 = (ConstraintLayout$LayoutParams)view.getLayoutParams();
            int n12 = view.getId();
            int n13 = this.mForceId;
            if (n13 != 0 && n12 == (n13 = -1)) {
                object = new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                throw object;
            }
            Object object5 = this.mConstraints;
            Serializable serializable = n12;
            n13 = (int)(((HashMap)object5).containsKey(serializable) ? 1 : 0);
            if (n13 == 0) {
                object5 = this.mConstraints;
                serializable = n12;
                object3 = new ConstraintSet$Constraint();
                ((HashMap)object5).put(serializable, object3);
            }
            object5 = this.mConstraints;
            serializable = n12;
            object5 = (ConstraintSet$Constraint)((HashMap)object5).get(serializable);
            serializable = ConstraintAttribute.extractAttributes(this.mSavedAttributes, view);
            ((ConstraintSet$Constraint)object5).mCustomConstraints = serializable;
            ConstraintSet$Constraint.access$000((ConstraintSet$Constraint)object5, n12, object4);
            object4 = ((ConstraintSet$Constraint)object5).propertySet;
            ((ConstraintSet$PropertySet)object4).visibility = n12 = view.getVisibility();
            int n14 = Build.VERSION.SDK_INT;
            n12 = 17;
            float f10 = 2.4E-44f;
            if (n14 >= n12) {
                double d10;
                float f11;
                object2 = ((ConstraintSet$Constraint)object5).propertySet;
                ((ConstraintSet$PropertySet)object2).alpha = f11 = view.getAlpha();
                object2 = ((ConstraintSet$Constraint)object5).transform;
                ((ConstraintSet$Transform)object2).rotation = f11 = view.getRotation();
                object2 = ((ConstraintSet$Constraint)object5).transform;
                ((ConstraintSet$Transform)object2).rotationX = f11 = view.getRotationX();
                object2 = ((ConstraintSet$Constraint)object5).transform;
                ((ConstraintSet$Transform)object2).rotationY = f11 = view.getRotationY();
                object2 = ((ConstraintSet$Constraint)object5).transform;
                ((ConstraintSet$Transform)object2).scaleX = f11 = view.getScaleX();
                object2 = ((ConstraintSet$Constraint)object5).transform;
                ((ConstraintSet$Transform)object2).scaleY = f11 = view.getScaleY();
                f10 = view.getPivotX();
                f11 = view.getPivotY();
                double d11 = f10;
                double d12 = 0.0;
                double d13 = d11 - d12;
                double d14 = d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1);
                if (d14 != false || (d14 = (d10 = (d11 = (double)f11) - d12) == 0.0 ? 0 : (d10 > 0.0 ? 1 : -1)) != false) {
                    object3 = ((ConstraintSet$Constraint)object5).transform;
                    ((ConstraintSet$Transform)object3).transformPivotX = f10;
                    ((ConstraintSet$Transform)object3).transformPivotY = f11;
                }
                object2 = ((ConstraintSet$Constraint)object5).transform;
                ((ConstraintSet$Transform)object2).translationX = f11 = view.getTranslationX();
                object2 = ((ConstraintSet$Constraint)object5).transform;
                ((ConstraintSet$Transform)object2).translationY = f11 = view.getTranslationY();
                n12 = 21;
                f10 = 2.9E-44f;
                if (n14 >= n12) {
                    object4 = ((ConstraintSet$Constraint)object5).transform;
                    ((ConstraintSet$Transform)object4).translationZ = f10 = view.getTranslationZ();
                    object4 = ((ConstraintSet$Constraint)object5).transform;
                    n12 = (int)(((ConstraintSet$Transform)object4).applyElevation ? 1 : 0);
                    if (n12 != 0) {
                        ((ConstraintSet$Transform)object4).elevation = f10 = view.getElevation();
                    }
                }
            }
            if ((n14 = view instanceof Barrier) == 0) continue;
            view = (Barrier)view;
            object4 = ((ConstraintSet$Constraint)object5).layout;
            n12 = (int)(view.allowsGoneWidget() ? 1 : 0);
            ((ConstraintSet$Layout)object4).mBarrierAllowsGoneWidgets = n12;
            object4 = ((ConstraintSet$Constraint)object5).layout;
            object2 = view.getReferencedIds();
            ((ConstraintSet$Layout)object4).mReferenceIds = (int[])object2;
            object4 = ((ConstraintSet$Constraint)object5).layout;
            ((ConstraintSet$Layout)object4).mBarrierDirection = n12 = view.getType();
            object4 = ((ConstraintSet$Constraint)object5).layout;
            ((ConstraintSet$Layout)object4).mBarrierMargin = n11 = view.getMargin();
        }
    }

    public void clone(ConstraintSet constraintSet) {
        boolean bl2;
        this.mConstraints.clear();
        Iterator iterator2 = constraintSet.mConstraints.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Integer n10 = (Integer)iterator2.next();
            HashMap hashMap = this.mConstraints;
            ConstraintSet$Constraint constraintSet$Constraint = ((ConstraintSet$Constraint)constraintSet.mConstraints.get(n10)).clone();
            hashMap.put(n10, constraintSet$Constraint);
        }
    }

    public void clone(Constraints object) {
        int n10 = object.getChildCount();
        this.mConstraints.clear();
        for (int i10 = 0; i10 < n10; ++i10) {
            View view = object.getChildAt(i10);
            Constraints$LayoutParams constraints$LayoutParams = (Constraints$LayoutParams)view.getLayoutParams();
            int n11 = view.getId();
            int n12 = this.mForceId;
            if (n12 != 0 && n11 == (n12 = -1)) {
                object = new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                throw object;
            }
            Object object2 = this.mConstraints;
            Integer n13 = n11;
            n12 = (int)(((HashMap)object2).containsKey(n13) ? 1 : 0);
            if (n12 == 0) {
                object2 = this.mConstraints;
                n13 = n11;
                ConstraintSet$Constraint constraintSet$Constraint = new ConstraintSet$Constraint();
                ((HashMap)object2).put(n13, constraintSet$Constraint);
            }
            object2 = this.mConstraints;
            n13 = n11;
            object2 = (ConstraintSet$Constraint)((HashMap)object2).get(n13);
            boolean bl2 = view instanceof ConstraintHelper;
            if (bl2) {
                view = (ConstraintHelper)view;
                ConstraintSet$Constraint.access$300((ConstraintSet$Constraint)object2, (ConstraintHelper)view, n11, constraints$LayoutParams);
            }
            ConstraintSet$Constraint.access$400((ConstraintSet$Constraint)object2, n11, constraints$LayoutParams);
        }
    }

    public void connect(int n10, int n11, int n12, int n13) {
        String string2;
        Object object;
        block22: {
            HashMap hashMap = this.mConstraints;
            Integer n14 = n10;
            int n15 = hashMap.containsKey(n14);
            if (n15 == 0) {
                hashMap = this.mConstraints;
                n14 = n10;
                ConstraintSet$Constraint constraintSet$Constraint = new ConstraintSet$Constraint();
                hashMap.put(n14, constraintSet$Constraint);
            }
            hashMap = this.mConstraints;
            object = n10;
            object = (ConstraintSet$Constraint)hashMap.get(object);
            n15 = 2;
            int n16 = 7;
            int n17 = 6;
            int n18 = 4;
            int n19 = 3;
            int n20 = 1;
            String string3 = "right to ";
            string2 = " undefined";
            int n21 = -1;
            switch (n11) {
                default: {
                    StringBuilder stringBuilder = new StringBuilder();
                    String string4 = this.sideToString(n11);
                    stringBuilder.append(string4);
                    stringBuilder.append(" to ");
                    string4 = this.sideToString(n13);
                    stringBuilder.append(string4);
                    stringBuilder.append(" unknown");
                    string4 = stringBuilder.toString();
                    object = new IllegalArgumentException(string4);
                    throw object;
                }
                case 7: {
                    if (n13 == n16) {
                        object = ((ConstraintSet$Constraint)object).layout;
                        ((ConstraintSet$Layout)object).endToEnd = n12;
                        ((ConstraintSet$Layout)object).endToStart = n21;
                        break;
                    }
                    if (n13 == n17) {
                        object = ((ConstraintSet$Constraint)object).layout;
                        ((ConstraintSet$Layout)object).endToStart = n12;
                        ((ConstraintSet$Layout)object).endToEnd = n21;
                        break;
                    }
                    CharSequence charSequence = new StringBuilder();
                    charSequence.append(string3);
                    String string5 = this.sideToString(n13);
                    charSequence.append(string5);
                    charSequence.append(string2);
                    charSequence = charSequence.toString();
                    object = new IllegalArgumentException((String)charSequence);
                    throw object;
                }
                case 6: {
                    if (n13 == n17) {
                        object = ((ConstraintSet$Constraint)object).layout;
                        ((ConstraintSet$Layout)object).startToStart = n12;
                        ((ConstraintSet$Layout)object).startToEnd = n21;
                        break;
                    }
                    if (n13 == n16) {
                        object = ((ConstraintSet$Constraint)object).layout;
                        ((ConstraintSet$Layout)object).startToEnd = n12;
                        ((ConstraintSet$Layout)object).startToStart = n21;
                        break;
                    }
                    CharSequence charSequence = new StringBuilder();
                    charSequence.append(string3);
                    String string6 = this.sideToString(n13);
                    charSequence.append(string6);
                    charSequence.append(string2);
                    charSequence = charSequence.toString();
                    object = new IllegalArgumentException((String)charSequence);
                    throw object;
                }
                case 5: {
                    n11 = 5;
                    if (n13 == n11) {
                        object = ((ConstraintSet$Constraint)object).layout;
                        ((ConstraintSet$Layout)object).baselineToBaseline = n12;
                        ((ConstraintSet$Layout)object).bottomToBottom = n21;
                        ((ConstraintSet$Layout)object).bottomToTop = n21;
                        ((ConstraintSet$Layout)object).topToTop = n21;
                        ((ConstraintSet$Layout)object).topToBottom = n21;
                        break;
                    }
                    CharSequence charSequence = new StringBuilder();
                    charSequence.append(string3);
                    String string7 = this.sideToString(n13);
                    charSequence.append(string7);
                    charSequence.append(string2);
                    charSequence = charSequence.toString();
                    object = new IllegalArgumentException((String)charSequence);
                    throw object;
                }
                case 4: {
                    if (n13 == n18) {
                        object = ((ConstraintSet$Constraint)object).layout;
                        ((ConstraintSet$Layout)object).bottomToBottom = n12;
                        ((ConstraintSet$Layout)object).bottomToTop = n21;
                        ((ConstraintSet$Layout)object).baselineToBaseline = n21;
                        break;
                    }
                    if (n13 == n19) {
                        object = ((ConstraintSet$Constraint)object).layout;
                        ((ConstraintSet$Layout)object).bottomToTop = n12;
                        ((ConstraintSet$Layout)object).bottomToBottom = n21;
                        ((ConstraintSet$Layout)object).baselineToBaseline = n21;
                        break;
                    }
                    CharSequence charSequence = new StringBuilder();
                    charSequence.append(string3);
                    String string8 = this.sideToString(n13);
                    charSequence.append(string8);
                    charSequence.append(string2);
                    charSequence = charSequence.toString();
                    object = new IllegalArgumentException((String)charSequence);
                    throw object;
                }
                case 3: {
                    if (n13 == n19) {
                        object = ((ConstraintSet$Constraint)object).layout;
                        ((ConstraintSet$Layout)object).topToTop = n12;
                        ((ConstraintSet$Layout)object).topToBottom = n21;
                        ((ConstraintSet$Layout)object).baselineToBaseline = n21;
                        break;
                    }
                    if (n13 == n18) {
                        object = ((ConstraintSet$Constraint)object).layout;
                        ((ConstraintSet$Layout)object).topToBottom = n12;
                        ((ConstraintSet$Layout)object).topToTop = n21;
                        ((ConstraintSet$Layout)object).baselineToBaseline = n21;
                        break;
                    }
                    CharSequence charSequence = new StringBuilder();
                    charSequence.append(string3);
                    String string9 = this.sideToString(n13);
                    charSequence.append(string9);
                    charSequence.append(string2);
                    charSequence = charSequence.toString();
                    object = new IllegalArgumentException((String)charSequence);
                    throw object;
                }
                case 2: {
                    if (n13 == n20) {
                        object = ((ConstraintSet$Constraint)object).layout;
                        ((ConstraintSet$Layout)object).rightToLeft = n12;
                        ((ConstraintSet$Layout)object).rightToRight = n21;
                        break;
                    }
                    if (n13 == n15) {
                        object = ((ConstraintSet$Constraint)object).layout;
                        ((ConstraintSet$Layout)object).rightToRight = n12;
                        ((ConstraintSet$Layout)object).rightToLeft = n21;
                        break;
                    }
                    CharSequence charSequence = new StringBuilder();
                    charSequence.append(string3);
                    String string10 = this.sideToString(n13);
                    charSequence.append(string10);
                    charSequence.append(string2);
                    charSequence = charSequence.toString();
                    object = new IllegalArgumentException((String)charSequence);
                    throw object;
                }
                case 1: {
                    if (n13 == n20) {
                        object = ((ConstraintSet$Constraint)object).layout;
                        ((ConstraintSet$Layout)object).leftToLeft = n12;
                        ((ConstraintSet$Layout)object).leftToRight = n21;
                        break;
                    }
                    if (n13 != n15) break block22;
                    object = ((ConstraintSet$Constraint)object).layout;
                    ((ConstraintSet$Layout)object).leftToRight = n12;
                    ((ConstraintSet$Layout)object).leftToLeft = n21;
                }
            }
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("left to ");
        String string11 = this.sideToString(n13);
        charSequence.append(string11);
        charSequence.append(string2);
        charSequence = charSequence.toString();
        object = new IllegalArgumentException((String)charSequence);
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void connect(int n10, int n11, int n12, int n13, int n14) {
        String string2;
        Object object;
        block31: {
            block30: {
                int n15;
                int n16;
                block29: {
                    HashMap hashMap = this.mConstraints;
                    Integer n17 = n10;
                    n16 = hashMap.containsKey(n17);
                    if (n16 == 0) {
                        hashMap = this.mConstraints;
                        n17 = n10;
                        ConstraintSet$Constraint constraintSet$Constraint = new ConstraintSet$Constraint();
                        hashMap.put(n17, constraintSet$Constraint);
                    }
                    hashMap = this.mConstraints;
                    object = n10;
                    object = (ConstraintSet$Constraint)hashMap.get(object);
                    n16 = 2;
                    int n18 = 7;
                    int n19 = 6;
                    int n20 = 4;
                    int n21 = 3;
                    int n22 = 1;
                    String string3 = "right to ";
                    string2 = " undefined";
                    n15 = -1;
                    switch (n11) {
                        default: {
                            StringBuilder stringBuilder = new StringBuilder();
                            String string4 = this.sideToString(n11);
                            stringBuilder.append(string4);
                            stringBuilder.append(" to ");
                            String string5 = this.sideToString(n13);
                            stringBuilder.append(string5);
                            stringBuilder.append(" unknown");
                            String string6 = stringBuilder.toString();
                            object = new IllegalArgumentException(string6);
                            throw object;
                        }
                        case 7: {
                            if (n13 == n18) {
                                ConstraintSet$Layout constraintSet$Layout = ((ConstraintSet$Constraint)object).layout;
                                constraintSet$Layout.endToEnd = n12;
                                constraintSet$Layout.endToStart = n15;
                            } else {
                                if (n13 != n19) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append(string3);
                                    String string7 = this.sideToString(n13);
                                    stringBuilder.append(string7);
                                    stringBuilder.append(string2);
                                    String string8 = stringBuilder.toString();
                                    object = new IllegalArgumentException(string8);
                                    throw object;
                                }
                                ConstraintSet$Layout constraintSet$Layout = ((ConstraintSet$Constraint)object).layout;
                                constraintSet$Layout.endToStart = n12;
                                constraintSet$Layout.endToEnd = n15;
                            }
                            object = ((ConstraintSet$Constraint)object).layout;
                            ((ConstraintSet$Layout)object).endMargin = n14;
                            return;
                        }
                        case 6: {
                            if (n13 == n19) {
                                ConstraintSet$Layout constraintSet$Layout = ((ConstraintSet$Constraint)object).layout;
                                constraintSet$Layout.startToStart = n12;
                                constraintSet$Layout.startToEnd = n15;
                            } else {
                                if (n13 != n18) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append(string3);
                                    String string9 = this.sideToString(n13);
                                    stringBuilder.append(string9);
                                    stringBuilder.append(string2);
                                    String string10 = stringBuilder.toString();
                                    object = new IllegalArgumentException(string10);
                                    throw object;
                                }
                                ConstraintSet$Layout constraintSet$Layout = ((ConstraintSet$Constraint)object).layout;
                                constraintSet$Layout.startToEnd = n12;
                                constraintSet$Layout.startToStart = n15;
                            }
                            object = ((ConstraintSet$Constraint)object).layout;
                            ((ConstraintSet$Layout)object).startMargin = n14;
                            return;
                        }
                        case 5: {
                            n11 = 5;
                            if (n13 == n11) {
                                object = ((ConstraintSet$Constraint)object).layout;
                                ((ConstraintSet$Layout)object).baselineToBaseline = n12;
                                ((ConstraintSet$Layout)object).bottomToBottom = n15;
                                ((ConstraintSet$Layout)object).bottomToTop = n15;
                                ((ConstraintSet$Layout)object).topToTop = n15;
                                ((ConstraintSet$Layout)object).topToBottom = n15;
                                return;
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(string3);
                            String string11 = this.sideToString(n13);
                            stringBuilder.append(string11);
                            stringBuilder.append(string2);
                            String string12 = stringBuilder.toString();
                            object = new IllegalArgumentException(string12);
                            throw object;
                        }
                        case 4: {
                            if (n13 == n20) {
                                ConstraintSet$Layout constraintSet$Layout = ((ConstraintSet$Constraint)object).layout;
                                constraintSet$Layout.bottomToBottom = n12;
                                constraintSet$Layout.bottomToTop = n15;
                                constraintSet$Layout.baselineToBaseline = n15;
                            } else {
                                if (n13 != n21) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append(string3);
                                    String string13 = this.sideToString(n13);
                                    stringBuilder.append(string13);
                                    stringBuilder.append(string2);
                                    String string14 = stringBuilder.toString();
                                    object = new IllegalArgumentException(string14);
                                    throw object;
                                }
                                ConstraintSet$Layout constraintSet$Layout = ((ConstraintSet$Constraint)object).layout;
                                constraintSet$Layout.bottomToTop = n12;
                                constraintSet$Layout.bottomToBottom = n15;
                                constraintSet$Layout.baselineToBaseline = n15;
                            }
                            object = ((ConstraintSet$Constraint)object).layout;
                            ((ConstraintSet$Layout)object).bottomMargin = n14;
                            return;
                        }
                        case 3: {
                            if (n13 == n21) {
                                ConstraintSet$Layout constraintSet$Layout = ((ConstraintSet$Constraint)object).layout;
                                constraintSet$Layout.topToTop = n12;
                                constraintSet$Layout.topToBottom = n15;
                                constraintSet$Layout.baselineToBaseline = n15;
                            } else {
                                if (n13 != n20) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append(string3);
                                    String string15 = this.sideToString(n13);
                                    stringBuilder.append(string15);
                                    stringBuilder.append(string2);
                                    String string16 = stringBuilder.toString();
                                    object = new IllegalArgumentException(string16);
                                    throw object;
                                }
                                ConstraintSet$Layout constraintSet$Layout = ((ConstraintSet$Constraint)object).layout;
                                constraintSet$Layout.topToBottom = n12;
                                constraintSet$Layout.topToTop = n15;
                                constraintSet$Layout.baselineToBaseline = n15;
                            }
                            object = ((ConstraintSet$Constraint)object).layout;
                            ((ConstraintSet$Layout)object).topMargin = n14;
                            return;
                        }
                        case 2: {
                            if (n13 == n22) {
                                ConstraintSet$Layout constraintSet$Layout = ((ConstraintSet$Constraint)object).layout;
                                constraintSet$Layout.rightToLeft = n12;
                                constraintSet$Layout.rightToRight = n15;
                            } else {
                                if (n13 != n16) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append(string3);
                                    String string17 = this.sideToString(n13);
                                    stringBuilder.append(string17);
                                    stringBuilder.append(string2);
                                    String string18 = stringBuilder.toString();
                                    object = new IllegalArgumentException(string18);
                                    throw object;
                                }
                                ConstraintSet$Layout constraintSet$Layout = ((ConstraintSet$Constraint)object).layout;
                                constraintSet$Layout.rightToRight = n12;
                                constraintSet$Layout.rightToLeft = n15;
                            }
                            object = ((ConstraintSet$Constraint)object).layout;
                            ((ConstraintSet$Layout)object).rightMargin = n14;
                            return;
                        }
                        case 1: 
                    }
                    if (n13 != n22) break block29;
                    ConstraintSet$Layout constraintSet$Layout = ((ConstraintSet$Constraint)object).layout;
                    constraintSet$Layout.leftToLeft = n12;
                    constraintSet$Layout.leftToRight = n15;
                    break block30;
                }
                if (n13 != n16) break block31;
                ConstraintSet$Layout constraintSet$Layout = ((ConstraintSet$Constraint)object).layout;
                constraintSet$Layout.leftToRight = n12;
                constraintSet$Layout.leftToLeft = n15;
            }
            object = ((ConstraintSet$Constraint)object).layout;
            ((ConstraintSet$Layout)object).leftMargin = n14;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Left to ");
        String string19 = this.sideToString(n13);
        stringBuilder.append(string19);
        stringBuilder.append(string2);
        String string20 = stringBuilder.toString();
        object = new IllegalArgumentException(string20);
        throw object;
    }

    public void constrainCircle(int n10, int n11, int n12, float f10) {
        ConstraintSet$Layout constraintSet$Layout = this.get((int)n10).layout;
        constraintSet$Layout.circleConstraint = n11;
        constraintSet$Layout.circleRadius = n12;
        constraintSet$Layout.circleAngle = f10;
    }

    public void constrainDefaultHeight(int n10, int n11) {
        this.get((int)n10).layout.heightDefault = n11;
    }

    public void constrainDefaultWidth(int n10, int n11) {
        this.get((int)n10).layout.widthDefault = n11;
    }

    public void constrainHeight(int n10, int n11) {
        this.get((int)n10).layout.mHeight = n11;
    }

    public void constrainMaxHeight(int n10, int n11) {
        this.get((int)n10).layout.heightMax = n11;
    }

    public void constrainMaxWidth(int n10, int n11) {
        this.get((int)n10).layout.widthMax = n11;
    }

    public void constrainMinHeight(int n10, int n11) {
        this.get((int)n10).layout.heightMin = n11;
    }

    public void constrainMinWidth(int n10, int n11) {
        this.get((int)n10).layout.widthMin = n11;
    }

    public void constrainPercentHeight(int n10, float f10) {
        this.get((int)n10).layout.heightPercent = f10;
    }

    public void constrainPercentWidth(int n10, float f10) {
        this.get((int)n10).layout.widthPercent = f10;
    }

    public void constrainWidth(int n10, int n11) {
        this.get((int)n10).layout.mWidth = n11;
    }

    public void constrainedHeight(int n10, boolean bl2) {
        this.get((int)n10).layout.constrainedHeight = bl2;
    }

    public void constrainedWidth(int n10, boolean bl2) {
        this.get((int)n10).layout.constrainedWidth = bl2;
    }

    public void create(int n10, int n11) {
        ConstraintSet$Layout constraintSet$Layout = this.get((int)n10).layout;
        constraintSet$Layout.mIsGuideline = true;
        constraintSet$Layout.orientation = n11;
    }

    public void createBarrier(int n10, int n11, int n12, int ... nArray) {
        ConstraintSet$Layout constraintSet$Layout = this.get((int)n10).layout;
        constraintSet$Layout.mHelperType = 1;
        constraintSet$Layout.mBarrierDirection = n11;
        constraintSet$Layout.mBarrierMargin = n12;
        constraintSet$Layout.mIsGuideline = false;
        constraintSet$Layout.mReferenceIds = nArray;
    }

    public void createHorizontalChain(int n10, int n11, int n12, int n13, int[] nArray, float[] fArray, int n14) {
        this.createHorizontalChain(n10, n11, n12, n13, nArray, fArray, n14, 1, 2);
    }

    public void createHorizontalChainRtl(int n10, int n11, int n12, int n13, int[] nArray, float[] fArray, int n14) {
        this.createHorizontalChain(n10, n11, n12, n13, nArray, fArray, n14, 6, 7);
    }

    public void createVerticalChain(int n10, int n11, int n12, int n13, int[] nArray, float[] fArray, int n14) {
        int[] nArray2 = nArray;
        float[] fArray2 = fArray;
        int n15 = nArray.length;
        Object object = "must have 2 or more widgets in a chain";
        int n16 = 2;
        float f10 = 2.8E-45f;
        if (n15 >= n16) {
            int n17;
            int n18;
            if (fArray != null && (n15 = fArray.length) != (n16 = nArray.length)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
                throw illegalArgumentException;
            }
            n15 = 0;
            Object object2 = null;
            if (fArray2 != null) {
                n18 = nArray2[0];
                object = this.get((int)n18).layout;
                ((ConstraintSet$Layout)object).verticalWeight = f10 = fArray2[0];
            }
            n18 = nArray2[0];
            object = this.get((int)n18).layout;
            n16 = n14;
            ((ConstraintSet$Layout)object).verticalChainStyle = n14;
            n18 = nArray2[0];
            n16 = 3;
            f10 = 4.2E-45f;
            object2 = this;
            int n19 = n10;
            int n20 = n11;
            this.connect(n18, n16, n10, n11, 0);
            for (int i10 = n17 = 1; i10 < (n15 = nArray2.length); ++i10) {
                float f11;
                n15 = nArray2[i10];
                n18 = nArray2[i10];
                int n21 = i10 + -1;
                n19 = nArray2[n21];
                object2 = this;
                this.connect(n18, 3, n19, 4, 0);
                n18 = nArray2[n21];
                n16 = 4;
                f10 = 5.6E-45f;
                n19 = nArray2[i10];
                n20 = 3;
                this.connect(n18, n16, n19, n20, 0);
                if (fArray2 == null) continue;
                n15 = nArray2[i10];
                object2 = this.get((int)n15).layout;
                ((ConstraintSet$Layout)object2).verticalWeight = f11 = fArray2[i10];
            }
            n15 = nArray2.length - n17;
            n18 = nArray2[n15];
            object2 = this;
            n19 = n12;
            n20 = n13;
            this.connect(n18, 4, n12, n13, 0);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public void dump(MotionScene object, int ... object2) {
        Object object3;
        int n10;
        Object object4;
        Integer[] integerArray = this.mConstraints.keySet();
        int n11 = ((int[])object2).length;
        int n12 = 0;
        if (n11 != 0) {
            integerArray = new HashSet();
            n11 = ((int[])object2).length;
            object4 = null;
            for (n10 = 0; n10 < n11; ++n10) {
                int n13 = object2[n10];
                object3 = n13;
                integerArray.add(object3);
            }
        } else {
            object2 = new HashSet;
            ((HashSet)object2)(integerArray);
            integerArray = (Integer[])object2;
        }
        object2 = System.out;
        Integer[] integerArray2 = new StringBuilder();
        n10 = integerArray.size();
        integerArray2.append(n10);
        object4 = " constraints";
        integerArray2.append((String)object4);
        integerArray2 = integerArray2.toString();
        ((PrintStream)object2).println((String)integerArray2);
        object2 = new StringBuilder();
        integerArray2 = new Integer[]{};
        integerArray = integerArray.toArray(integerArray2);
        n11 = integerArray.length;
        while (n12 < n11) {
            object4 = integerArray[n12];
            object3 = (ConstraintSet$Constraint)this.mConstraints.get(object4);
            String string2 = "<Constraint id=";
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(object4);
            ((StringBuilder)object2).append(" \n");
            ((ConstraintSet$Constraint)object3).layout.dump((MotionScene)object, (StringBuilder)object2);
            object4 = "/>\n";
            ((StringBuilder)object2).append((String)object4);
            ++n12;
        }
        object = System.out;
        object2 = ((StringBuilder)object2).toString();
        ((PrintStream)object).println((String)object2);
    }

    public boolean getApplyElevation(int n10) {
        return this.get((int)n10).transform.applyElevation;
    }

    public ConstraintSet$Constraint getConstraint(int n10) {
        HashMap hashMap = this.mConstraints;
        Integer n11 = n10;
        boolean bl2 = hashMap.containsKey(n11);
        if (bl2) {
            hashMap = this.mConstraints;
            Integer n12 = n10;
            return (ConstraintSet$Constraint)hashMap.get(n12);
        }
        return null;
    }

    public HashMap getCustomAttributeSet() {
        return this.mSavedAttributes;
    }

    public int getHeight(int n10) {
        return this.get((int)n10).layout.mHeight;
    }

    public int[] getKnownIds() {
        Integer[] integerArray = this.mConstraints.keySet();
        Integer[] integerArray2 = new Integer[]{};
        integerArray = integerArray.toArray(integerArray2);
        int n10 = integerArray.length;
        int[] nArray = new int[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            Integer n12 = integerArray[i10];
            nArray[i10] = n11 = n12.intValue();
        }
        return nArray;
    }

    public ConstraintSet$Constraint getParameters(int n10) {
        return this.get(n10);
    }

    public int[] getReferencedIds(int n10) {
        int[] nArray = this.get((int)n10).layout.mReferenceIds;
        if (nArray == null) {
            return new int[0];
        }
        int n11 = nArray.length;
        return Arrays.copyOf(nArray, n11);
    }

    public int getVisibility(int n10) {
        return this.get((int)n10).propertySet.visibility;
    }

    public int getVisibilityMode(int n10) {
        return this.get((int)n10).propertySet.mVisibilityMode;
    }

    public int getWidth(int n10) {
        return this.get((int)n10).layout.mWidth;
    }

    public boolean isForceId() {
        return this.mForceId;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void load(Context context, int n10) {
        Object object = context.getResources();
        XmlResourceParser xmlResourceParser = object.getXml(n10);
        try {
            int n11;
            int n12 = xmlResourceParser.getEventType();
            while (n12 != (n11 = 1)) {
                if (n12 != 0) {
                    int n13 = 2;
                    if (n12 == n13) {
                        object = xmlResourceParser.getName();
                        AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlResourceParser);
                        ConstraintSet$Constraint constraintSet$Constraint = this.fillFromAttributeList(context, attributeSet);
                        String string2 = "Guideline";
                        n12 = (int)(((String)object).equalsIgnoreCase(string2) ? 1 : 0);
                        if (n12 != 0) {
                            object = constraintSet$Constraint.layout;
                            ((ConstraintSet$Layout)object).mIsGuideline = n11;
                        }
                        object = this.mConstraints;
                        n11 = constraintSet$Constraint.mViewId;
                        Integer n14 = n11;
                        ((HashMap)object).put(n14, constraintSet$Constraint);
                    }
                } else {
                    xmlResourceParser.getName();
                }
                n12 = xmlResourceParser.next();
            }
            return;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return;
        }
        catch (XmlPullParserException xmlPullParserException) {
            xmlPullParserException.printStackTrace();
        }
    }

    /*
     * Exception decompiling
     */
    public void load(Context var1_1, XmlPullParser var2_4) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [82[CASE]], but top level block is 56[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public void parseColorAttributes(ConstraintSet$Constraint constraintSet$Constraint, String stringArray) {
        int n10;
        stringArray = stringArray.split(",");
        for (int i10 = 0; i10 < (n10 = stringArray.length); ++i10) {
            int n11;
            Object object = stringArray[i10];
            String string2 = "=";
            int n12 = ((String[])(object = ((String)object).split(string2))).length;
            if (n12 != (n11 = 2)) {
                object = new StringBuilder();
                ((StringBuilder)object).append(" Unable to parse ");
                string2 = stringArray[i10];
                ((StringBuilder)object).append(string2);
                object = ((StringBuilder)object).toString();
                string2 = TAG;
                Log.w((String)string2, (String)object);
                continue;
            }
            string2 = object[0];
            n11 = 1;
            object = object[n11];
            n10 = Color.parseColor((String)object);
            ConstraintSet$Constraint.access$600(constraintSet$Constraint, string2, n10);
        }
    }

    public void parseFloatAttributes(ConstraintSet$Constraint constraintSet$Constraint, String stringArray) {
        int n10;
        stringArray = stringArray.split(",");
        for (int i10 = 0; i10 < (n10 = stringArray.length); ++i10) {
            int n11;
            Object object = stringArray[i10];
            String string2 = "=";
            int n12 = ((String[])(object = ((String)object).split(string2))).length;
            if (n12 != (n11 = 2)) {
                object = new StringBuilder();
                ((StringBuilder)object).append(" Unable to parse ");
                string2 = stringArray[i10];
                ((StringBuilder)object).append(string2);
                object = ((StringBuilder)object).toString();
                string2 = TAG;
                Log.w((String)string2, (String)object);
                continue;
            }
            string2 = object[0];
            n11 = 1;
            object = object[n11];
            float f10 = Float.parseFloat((String)object);
            ConstraintSet$Constraint.access$700(constraintSet$Constraint, string2, f10);
        }
    }

    public void parseIntAttributes(ConstraintSet$Constraint constraintSet$Constraint, String stringArray) {
        int n10;
        stringArray = stringArray.split(",");
        for (int i10 = 0; i10 < (n10 = stringArray.length); ++i10) {
            int n11;
            Object object = stringArray[i10];
            String string2 = "=";
            int n12 = ((String[])(object = ((String)object).split(string2))).length;
            if (n12 != (n11 = 2)) {
                object = new StringBuilder();
                ((StringBuilder)object).append(" Unable to parse ");
                string2 = stringArray[i10];
                ((StringBuilder)object).append(string2);
                object = ((StringBuilder)object).toString();
                string2 = TAG;
                Log.w((String)string2, (String)object);
                continue;
            }
            string2 = object[0];
            n11 = 1;
            object = Integer.decode((String)object[n11]);
            n10 = (Integer)object;
            float f10 = n10;
            ConstraintSet$Constraint.access$700(constraintSet$Constraint, string2, f10);
        }
    }

    public void parseStringAttributes(ConstraintSet$Constraint constraintSet$Constraint, String stringArray) {
        int n10;
        stringArray = ConstraintSet.splitString((String)stringArray);
        for (int i10 = 0; i10 < (n10 = stringArray.length); ++i10) {
            Object object = stringArray[i10].split("=");
            CharSequence charSequence = new StringBuilder();
            charSequence.append(" Unable to parse ");
            String string2 = stringArray[i10];
            charSequence.append(string2);
            charSequence = charSequence.toString();
            string2 = TAG;
            Log.w((String)string2, (String)charSequence);
            charSequence = object[0];
            int n11 = 1;
            object = object[n11];
            ConstraintSet$Constraint.access$800(constraintSet$Constraint, (String)charSequence, (String)object);
        }
    }

    public void readFallback(ConstraintLayout object) {
        int n10 = object.getChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10;
            double d10;
            float f11;
            float f12;
            Object object2;
            int n11;
            Object object3;
            View view = object.getChildAt(i10);
            Object object4 = (ConstraintLayout$LayoutParams)view.getLayoutParams();
            int n12 = view.getId();
            int n13 = this.mForceId;
            if (n13 != 0 && n12 == (n13 = -1)) {
                object = new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                throw object;
            }
            Object object5 = this.mConstraints;
            Object object6 = n12;
            n13 = (int)(((HashMap)object5).containsKey(object6) ? 1 : 0);
            if (n13 == 0) {
                object5 = this.mConstraints;
                object6 = n12;
                object3 = new ConstraintSet$Constraint();
                ((HashMap)object5).put(object6, object3);
            }
            object5 = this.mConstraints;
            object6 = n12;
            object5 = (ConstraintSet$Constraint)((HashMap)object5).get(object6);
            object6 = ((ConstraintSet$Constraint)object5).layout;
            int n14 = ((ConstraintSet$Layout)object6).mApply;
            Object object7 = 1;
            if (n14 == 0) {
                ConstraintSet$Constraint.access$000((ConstraintSet$Constraint)object5, n12, (ConstraintLayout$LayoutParams)((Object)object4));
                n11 = view instanceof ConstraintHelper;
                if (n11 != 0) {
                    object4 = ((ConstraintSet$Constraint)object5).layout;
                    object2 = view;
                    object2 = ((ConstraintHelper)view).getReferencedIds();
                    ((ConstraintSet$Layout)object4).mReferenceIds = (int[])object2;
                    n11 = view instanceof Barrier;
                    if (n11 != 0) {
                        object4 = view;
                        object4 = (Barrier)view;
                        object2 = ((ConstraintSet$Constraint)object5).layout;
                        object2.mBarrierAllowsGoneWidgets = n14 = ((Barrier)((Object)object4)).allowsGoneWidget();
                        object2 = ((ConstraintSet$Constraint)object5).layout;
                        object2.mBarrierDirection = n14 = ((Barrier)((Object)object4)).getType();
                        object2 = ((ConstraintSet$Constraint)object5).layout;
                        object2.mBarrierMargin = n11 = ((Barrier)((Object)object4)).getMargin();
                    }
                }
                object4 = ((ConstraintSet$Constraint)object5).layout;
                ((ConstraintSet$Layout)object4).mApply = object7;
            }
            object4 = ((ConstraintSet$Constraint)object5).propertySet;
            n12 = (int)(((ConstraintSet$PropertySet)object4).mApply ? 1 : 0);
            if (n12 == 0) {
                ((ConstraintSet$PropertySet)object4).visibility = n12 = view.getVisibility();
                object4 = ((ConstraintSet$Constraint)object5).propertySet;
                ((ConstraintSet$PropertySet)object4).alpha = f12 = view.getAlpha();
                object4 = ((ConstraintSet$Constraint)object5).propertySet;
                ((ConstraintSet$PropertySet)object4).mApply = object7;
            }
            n11 = Build.VERSION.SDK_INT;
            n12 = 17;
            f12 = 2.4E-44f;
            if (n11 < n12) continue;
            object2 = ((ConstraintSet$Constraint)object5).transform;
            n14 = object2.mApply;
            if (n14 != 0) continue;
            object2.mApply = object7;
            object2.rotation = f11 = view.getRotation();
            object2 = ((ConstraintSet$Constraint)object5).transform;
            object2.rotationX = f11 = view.getRotationX();
            object2 = ((ConstraintSet$Constraint)object5).transform;
            object2.rotationY = f11 = view.getRotationY();
            object2 = ((ConstraintSet$Constraint)object5).transform;
            object2.scaleX = f11 = view.getScaleX();
            object2 = ((ConstraintSet$Constraint)object5).transform;
            object2.scaleY = f11 = view.getScaleY();
            f12 = view.getPivotX();
            f11 = view.getPivotY();
            double d11 = f12;
            double d12 = 0.0;
            double d13 = d11 - d12;
            object7 = d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1);
            if (object7 || (object7 = (d10 = (d11 = (double)f11) - d12) == 0.0 ? 0 : (d10 > 0.0 ? 1 : -1))) {
                object3 = ((ConstraintSet$Constraint)object5).transform;
                ((ConstraintSet$Transform)object3).transformPivotX = f12;
                ((ConstraintSet$Transform)object3).transformPivotY = f11;
            }
            object2 = ((ConstraintSet$Constraint)object5).transform;
            object2.translationX = f11 = view.getTranslationX();
            object2 = ((ConstraintSet$Constraint)object5).transform;
            object2.translationY = f11 = view.getTranslationY();
            n12 = 21;
            f12 = 2.9E-44f;
            if (n11 < n12) continue;
            object4 = ((ConstraintSet$Constraint)object5).transform;
            ((ConstraintSet$Transform)object4).translationZ = f12 = view.getTranslationZ();
            object4 = ((ConstraintSet$Constraint)object5).transform;
            n12 = (int)(((ConstraintSet$Transform)object4).applyElevation ? 1 : 0);
            if (n12 == 0) continue;
            ((ConstraintSet$Transform)object4).elevation = f10 = view.getElevation();
        }
    }

    public void readFallback(ConstraintSet constraintSet) {
        boolean bl2;
        Iterator iterator2 = constraintSet.mConstraints.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object;
            Object object2 = (Integer)iterator2.next();
            int n10 = (Integer)object2;
            object2 = (ConstraintSet$Constraint)constraintSet.mConstraints.get(object2);
            Object object3 = this.mConstraints;
            Object object4 = n10;
            boolean bl3 = ((HashMap)object3).containsKey(object4);
            if (!bl3) {
                object3 = this.mConstraints;
                object4 = n10;
                object = new ConstraintSet$Constraint();
                ((HashMap)object3).put(object4, object);
            }
            object3 = this.mConstraints;
            Object object5 = n10;
            object5 = (ConstraintSet$Constraint)((HashMap)object3).get(object5);
            object3 = ((ConstraintSet$Constraint)object5).layout;
            boolean bl4 = ((ConstraintSet$Layout)object3).mApply;
            if (!bl4) {
                object4 = ((ConstraintSet$Constraint)object2).layout;
                ((ConstraintSet$Layout)object3).copyFrom((ConstraintSet$Layout)object4);
            }
            object3 = ((ConstraintSet$Constraint)object5).propertySet;
            bl4 = ((ConstraintSet$PropertySet)object3).mApply;
            if (!bl4) {
                object4 = ((ConstraintSet$Constraint)object2).propertySet;
                ((ConstraintSet$PropertySet)object3).copyFrom((ConstraintSet$PropertySet)object4);
            }
            object3 = ((ConstraintSet$Constraint)object5).transform;
            bl4 = ((ConstraintSet$Transform)object3).mApply;
            if (!bl4) {
                object4 = ((ConstraintSet$Constraint)object2).transform;
                ((ConstraintSet$Transform)object3).copyFrom((ConstraintSet$Transform)object4);
            }
            object3 = ((ConstraintSet$Constraint)object5).motion;
            bl4 = ((ConstraintSet$Motion)object3).mApply;
            if (!bl4) {
                object4 = ((ConstraintSet$Constraint)object2).motion;
                ((ConstraintSet$Motion)object3).copyFrom((ConstraintSet$Motion)object4);
            }
            object3 = ((ConstraintSet$Constraint)object2).mCustomConstraints.keySet().iterator();
            while (bl4 = object3.hasNext()) {
                object = ((ConstraintSet$Constraint)object5).mCustomConstraints;
                object4 = (String)object3.next();
                boolean bl5 = ((HashMap)object).containsKey(object4);
                if (bl5) continue;
                object = ((ConstraintSet$Constraint)object5).mCustomConstraints;
                Object v10 = ((ConstraintSet$Constraint)object2).mCustomConstraints.get(object4);
                ((HashMap)object).put(object4, v10);
            }
        }
    }

    public void removeAttribute(String string2) {
        this.mSavedAttributes.remove(string2);
    }

    public void removeFromHorizontalChain(int n10) {
        Object object = this.mConstraints;
        Integer n11 = n10;
        boolean n12 = ((HashMap)object).containsKey(n11);
        if (n12) {
            object = this.mConstraints;
            n11 = n10;
            object = ((ConstraintSet$Constraint)object.get((Object)n11)).layout;
            int n13 = ((ConstraintSet$Layout)object).leftToRight;
            int n14 = ((ConstraintSet$Layout)object).rightToLeft;
            int n15 = -1;
            if (n13 == n15 && n14 == n15) {
                int n26 = ((ConstraintSet$Layout)object).startToEnd;
                n14 = ((ConstraintSet$Layout)object).endToStart;
                if (n26 != n15 || n14 != n15) {
                    if (n26 != n15 && n14 != n15) {
                        object = this;
                        n15 = n26;
                        n26 = 7;
                        int n22 = n14;
                        this.connect(n15, n26, n14, 6, 0);
                        n26 = 6;
                        int n21 = 7;
                        n15 = n14;
                        n22 = n13;
                        this.connect(n14, n26, n13, n21, 0);
                    } else if (n13 != n15 || n14 != n15) {
                        int n25 = ((ConstraintSet$Layout)object).rightToRight;
                        if (n25 != n15) {
                            n26 = 7;
                            int n24 = 7;
                            object = this;
                            n15 = n13;
                            this.connect(n13, n26, n25, n24, 0);
                        } else {
                            n25 = ((ConstraintSet$Layout)object).leftToLeft;
                            if (n25 != n15) {
                                n26 = 6;
                                int n27 = 6;
                                object = this;
                                n15 = n14;
                                this.connect(n14, n26, n25, n27, 0);
                            }
                        }
                    }
                }
                this.clear(n10, 6);
                int n16 = 7;
                this.clear(n10, n16);
            } else {
                if (n13 != n15 && n14 != n15) {
                    object = this;
                    n15 = n13;
                    int n17 = n14;
                    this.connect(n13, 2, n14, 1, 0);
                    int n28 = 1;
                    int n29 = 2;
                    n15 = n14;
                    n17 = n13;
                    this.connect(n14, n28, n13, n29, 0);
                } else if (n13 != n15 || n14 != n15) {
                    int n18 = ((ConstraintSet$Layout)object).rightToRight;
                    if (n18 != n15) {
                        int n19 = 2;
                        int n20 = 2;
                        object = this;
                        n15 = n13;
                        this.connect(n13, n19, n18, n20, 0);
                    } else {
                        n18 = ((ConstraintSet$Layout)object).leftToLeft;
                        if (n18 != n15) {
                            int n21 = 1;
                            int n22 = 1;
                            object = this;
                            n15 = n14;
                            this.connect(n14, n21, n18, n22, 0);
                        }
                    }
                }
                this.clear(n10, 1);
                int n23 = 2;
                this.clear(n10, n23);
            }
        }
    }

    public void removeFromVerticalChain(int n10) {
        Object object = this.mConstraints;
        Object object2 = n10;
        boolean bl2 = ((HashMap)object).containsKey(object2);
        if (bl2) {
            object = this.mConstraints;
            object2 = n10;
            object = ((ConstraintSet$Constraint)object.get((Object)object2)).layout;
            int n11 = ((ConstraintSet$Layout)object).topToBottom;
            int n12 = ((ConstraintSet$Layout)object).bottomToTop;
            int n13 = -1;
            if (n11 != n13 || n12 != n13) {
                if (n11 != n13 && n12 != n13) {
                    object2 = this;
                    int n14 = n12;
                    this.connect(n11, 4, n12, 3, 0);
                    int n15 = 3;
                    int n16 = 4;
                    n14 = n11;
                    this.connect(n12, n15, n11, n16, 0);
                } else if (n11 != n13 || n12 != n13) {
                    int n17 = ((ConstraintSet$Layout)object).bottomToBottom;
                    if (n17 != n13) {
                        int n18 = 4;
                        int n19 = 4;
                        object2 = this;
                        this.connect(n11, n18, n17, n19, 0);
                    } else {
                        n17 = ((ConstraintSet$Layout)object).topToTop;
                        if (n17 != n13) {
                            int n20 = 3;
                            int n21 = 3;
                            object2 = this;
                            this.connect(n12, n20, n17, n21, 0);
                        }
                    }
                }
            }
        }
        this.clear(n10, 3);
        this.clear(n10, 4);
    }

    public void setAlpha(int n10, float f10) {
        this.get((int)n10).propertySet.alpha = f10;
    }

    public void setApplyElevation(int n10, boolean bl2) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 21;
        if (n11 >= n12) {
            ConstraintSet$Transform constraintSet$Transform = this.get((int)n10).transform;
            constraintSet$Transform.applyElevation = bl2;
        }
    }

    public void setBarrierType(int n10, int n11) {
        this.get((int)n10).layout.mHelperType = n11;
    }

    public void setColorValue(int n10, String string2, int n11) {
        ConstraintSet$Constraint.access$600(this.get(n10), string2, n11);
    }

    public void setDimensionRatio(int n10, String string2) {
        this.get((int)n10).layout.dimensionRatio = string2;
    }

    public void setEditorAbsoluteX(int n10, int n11) {
        this.get((int)n10).layout.editorAbsoluteX = n11;
    }

    public void setEditorAbsoluteY(int n10, int n11) {
        this.get((int)n10).layout.editorAbsoluteY = n11;
    }

    public void setElevation(int n10, float f10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 21;
        if (n11 >= n12) {
            ConstraintSet$Transform constraintSet$Transform = this.get((int)n10).transform;
            constraintSet$Transform.elevation = f10;
            ConstraintSet$Transform constraintSet$Transform2 = this.get((int)n10).transform;
            boolean bl2 = true;
            f10 = Float.MIN_VALUE;
            constraintSet$Transform2.applyElevation = bl2;
        }
    }

    public void setFloatValue(int n10, String string2, float f10) {
        ConstraintSet$Constraint.access$700(this.get(n10), string2, f10);
    }

    public void setForceId(boolean bl2) {
        this.mForceId = bl2;
    }

    public void setGoneMargin(int n10, int n11, int n12) {
        Object object = this.get(n10);
        switch (n11) {
            default: {
                object = new IllegalArgumentException("unknown constraint");
                throw object;
            }
            case 7: {
                object = ((ConstraintSet$Constraint)object).layout;
                ((ConstraintSet$Layout)object).goneEndMargin = n12;
                break;
            }
            case 6: {
                object = ((ConstraintSet$Constraint)object).layout;
                ((ConstraintSet$Layout)object).goneStartMargin = n12;
                break;
            }
            case 5: {
                object = new IllegalArgumentException("baseline does not support margins");
                throw object;
            }
            case 4: {
                object = ((ConstraintSet$Constraint)object).layout;
                ((ConstraintSet$Layout)object).goneBottomMargin = n12;
                break;
            }
            case 3: {
                object = ((ConstraintSet$Constraint)object).layout;
                ((ConstraintSet$Layout)object).goneTopMargin = n12;
                break;
            }
            case 2: {
                object = ((ConstraintSet$Constraint)object).layout;
                ((ConstraintSet$Layout)object).goneRightMargin = n12;
                break;
            }
            case 1: {
                object = ((ConstraintSet$Constraint)object).layout;
                ((ConstraintSet$Layout)object).goneLeftMargin = n12;
            }
        }
    }

    public void setGuidelineBegin(int n10, int n11) {
        this.get((int)n10).layout.guideBegin = n11;
        this.get((int)n10).layout.guideEnd = -1;
        this.get((int)n10).layout.guidePercent = -1.0f;
    }

    public void setGuidelineEnd(int n10, int n11) {
        this.get((int)n10).layout.guideEnd = n11;
        this.get((int)n10).layout.guideBegin = -1;
        this.get((int)n10).layout.guidePercent = -1.0f;
    }

    public void setGuidelinePercent(int n10, float f10) {
        int n11;
        this.get((int)n10).layout.guidePercent = f10;
        ConstraintSet$Layout constraintSet$Layout = this.get((int)n10).layout;
        constraintSet$Layout.guideEnd = n11 = -1;
        this.get((int)n10).layout.guideBegin = n11;
    }

    public void setHorizontalBias(int n10, float f10) {
        this.get((int)n10).layout.horizontalBias = f10;
    }

    public void setHorizontalChainStyle(int n10, int n11) {
        this.get((int)n10).layout.horizontalChainStyle = n11;
    }

    public void setHorizontalWeight(int n10, float f10) {
        this.get((int)n10).layout.horizontalWeight = f10;
    }

    public void setIntValue(int n10, String string2, int n11) {
        ConstraintSet$Constraint.access$500(this.get(n10), string2, n11);
    }

    public void setMargin(int n10, int n11, int n12) {
        Object object = this.get(n10);
        switch (n11) {
            default: {
                object = new IllegalArgumentException("unknown constraint");
                throw object;
            }
            case 7: {
                object = ((ConstraintSet$Constraint)object).layout;
                ((ConstraintSet$Layout)object).endMargin = n12;
                break;
            }
            case 6: {
                object = ((ConstraintSet$Constraint)object).layout;
                ((ConstraintSet$Layout)object).startMargin = n12;
                break;
            }
            case 5: {
                object = new IllegalArgumentException("baseline does not support margins");
                throw object;
            }
            case 4: {
                object = ((ConstraintSet$Constraint)object).layout;
                ((ConstraintSet$Layout)object).bottomMargin = n12;
                break;
            }
            case 3: {
                object = ((ConstraintSet$Constraint)object).layout;
                ((ConstraintSet$Layout)object).topMargin = n12;
                break;
            }
            case 2: {
                object = ((ConstraintSet$Constraint)object).layout;
                ((ConstraintSet$Layout)object).rightMargin = n12;
                break;
            }
            case 1: {
                object = ((ConstraintSet$Constraint)object).layout;
                ((ConstraintSet$Layout)object).leftMargin = n12;
            }
        }
    }

    public void setReferencedIds(int n10, int ... nArray) {
        this.get((int)n10).layout.mReferenceIds = nArray;
    }

    public void setRotation(int n10, float f10) {
        this.get((int)n10).transform.rotation = f10;
    }

    public void setRotationX(int n10, float f10) {
        this.get((int)n10).transform.rotationX = f10;
    }

    public void setRotationY(int n10, float f10) {
        this.get((int)n10).transform.rotationY = f10;
    }

    public void setScaleX(int n10, float f10) {
        this.get((int)n10).transform.scaleX = f10;
    }

    public void setScaleY(int n10, float f10) {
        this.get((int)n10).transform.scaleY = f10;
    }

    public void setStringValue(int n10, String string2, String string3) {
        ConstraintSet$Constraint.access$800(this.get(n10), string2, string3);
    }

    public void setTransformPivot(int n10, float f10, float f11) {
        ConstraintSet$Transform constraintSet$Transform = this.get((int)n10).transform;
        constraintSet$Transform.transformPivotY = f11;
        constraintSet$Transform.transformPivotX = f10;
    }

    public void setTransformPivotX(int n10, float f10) {
        this.get((int)n10).transform.transformPivotX = f10;
    }

    public void setTransformPivotY(int n10, float f10) {
        this.get((int)n10).transform.transformPivotY = f10;
    }

    public void setTranslation(int n10, float f10, float f11) {
        ConstraintSet$Transform constraintSet$Transform = this.get((int)n10).transform;
        constraintSet$Transform.translationX = f10;
        constraintSet$Transform.translationY = f11;
    }

    public void setTranslationX(int n10, float f10) {
        this.get((int)n10).transform.translationX = f10;
    }

    public void setTranslationY(int n10, float f10) {
        this.get((int)n10).transform.translationY = f10;
    }

    public void setTranslationZ(int n10, float f10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 21;
        if (n11 >= n12) {
            ConstraintSet$Transform constraintSet$Transform = this.get((int)n10).transform;
            constraintSet$Transform.translationZ = f10;
        }
    }

    public void setValidateOnParse(boolean bl2) {
        this.mValidate = bl2;
    }

    public void setVerticalBias(int n10, float f10) {
        this.get((int)n10).layout.verticalBias = f10;
    }

    public void setVerticalChainStyle(int n10, int n11) {
        this.get((int)n10).layout.verticalChainStyle = n11;
    }

    public void setVerticalWeight(int n10, float f10) {
        this.get((int)n10).layout.verticalWeight = f10;
    }

    public void setVisibility(int n10, int n11) {
        this.get((int)n10).propertySet.visibility = n11;
    }

    public void setVisibilityMode(int n10, int n11) {
        this.get((int)n10).propertySet.mVisibilityMode = n11;
    }
}

