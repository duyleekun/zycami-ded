/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.util.SparseIntArray
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R$styleable;

public class ConstraintSet$Motion {
    private static final int ANIMATE_RELATIVE_TO = 5;
    private static final int MOTION_DRAW_PATH = 4;
    private static final int MOTION_STAGGER = 6;
    private static final int PATH_MOTION_ARC = 2;
    private static final int TRANSITION_EASING = 3;
    private static final int TRANSITION_PATH_ROTATE = 1;
    private static SparseIntArray mapToConstant;
    public int mAnimateRelativeTo;
    public boolean mApply = false;
    public int mDrawPath;
    public float mMotionStagger;
    public int mPathMotionArc;
    public float mPathRotate;
    public String mTransitionEasing;

    static {
        SparseIntArray sparseIntArray;
        mapToConstant = sparseIntArray = new SparseIntArray();
        int n10 = R$styleable.Motion_motionPathRotate;
        sparseIntArray.append(n10, 1);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Motion_pathMotionArc;
        sparseIntArray.append(n10, 2);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Motion_transitionEasing;
        sparseIntArray.append(n10, 3);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Motion_drawPath;
        sparseIntArray.append(n10, 4);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Motion_animate_relativeTo;
        sparseIntArray.append(n10, 5);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Motion_motionStagger;
        sparseIntArray.append(n10, 6);
    }

    public ConstraintSet$Motion() {
        float f10;
        int n10;
        this.mAnimateRelativeTo = n10 = -1;
        this.mTransitionEasing = null;
        this.mPathMotionArc = n10;
        this.mDrawPath = 0;
        this.mMotionStagger = f10 = 0.0f / 0.0f;
        this.mPathRotate = f10;
    }

    public void copyFrom(ConstraintSet$Motion constraintSet$Motion) {
        float f10;
        float f11;
        String string2;
        int n10;
        this.mApply = n10 = constraintSet$Motion.mApply;
        this.mAnimateRelativeTo = n10 = constraintSet$Motion.mAnimateRelativeTo;
        this.mTransitionEasing = string2 = constraintSet$Motion.mTransitionEasing;
        this.mPathMotionArc = n10 = constraintSet$Motion.mPathMotionArc;
        this.mDrawPath = n10 = constraintSet$Motion.mDrawPath;
        this.mPathRotate = f11 = constraintSet$Motion.mPathRotate;
        this.mMotionStagger = f10 = constraintSet$Motion.mMotionStagger;
    }

    public void fillFromAttributeList(Context context, AttributeSet attributeSet) {
        int[] nArray = R$styleable.Motion;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        this.mApply = true;
        int n10 = context.getIndexCount();
        nArray = null;
        block8: for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = context.getIndex(i10);
            String[] stringArray = mapToConstant;
            int n12 = stringArray.get(n11);
            switch (n12) {
                default: {
                    continue block8;
                }
                case 6: {
                    float f10;
                    float f11 = this.mMotionStagger;
                    this.mMotionStagger = f10 = context.getFloat(n11, f11);
                    continue block8;
                }
                case 5: {
                    n12 = this.mAnimateRelativeTo;
                    this.mAnimateRelativeTo = n11 = ConstraintSet.access$100((TypedArray)context, n11, n12);
                    continue block8;
                }
                case 4: {
                    this.mDrawPath = n11 = context.getInt(n11, 0);
                    continue block8;
                }
                case 3: {
                    String string2;
                    stringArray = context.peekValue(n11);
                    n12 = stringArray.type;
                    int n13 = 3;
                    if (n12 == n13) {
                        this.mTransitionEasing = string2 = context.getString(n11);
                        continue block8;
                    }
                    stringArray = Easing.NAMED_EASING;
                    n11 = context.getInteger(n11, 0);
                    this.mTransitionEasing = string2 = stringArray[n11];
                    continue block8;
                }
                case 2: {
                    n12 = this.mPathMotionArc;
                    this.mPathMotionArc = n11 = context.getInt(n11, n12);
                    continue block8;
                }
                case 1: {
                    float f10;
                    float f11 = this.mPathRotate;
                    this.mPathRotate = f10 = context.getFloat(n11, f11);
                }
            }
        }
        context.recycle();
    }
}

