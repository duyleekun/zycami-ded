/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.TypedArray
 *  android.util.Log
 *  android.util.SparseIntArray
 */
package androidx.constraintlayout.motion.widget;

import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.KeyPosition;
import androidx.constraintlayout.motion.widget.KeyPositionBase;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R$styleable;

public class KeyPosition$Loader {
    private static final int CURVE_FIT = 4;
    private static final int DRAW_PATH = 5;
    private static final int FRAME_POSITION = 2;
    private static final int PATH_MOTION_ARC = 10;
    private static final int PERCENT_HEIGHT = 12;
    private static final int PERCENT_WIDTH = 11;
    private static final int PERCENT_X = 6;
    private static final int PERCENT_Y = 7;
    private static final int SIZE_PERCENT = 8;
    private static final int TARGET_ID = 1;
    private static final int TRANSITION_EASING = 3;
    private static final int TYPE = 9;
    private static SparseIntArray mAttrMap;

    static {
        SparseIntArray sparseIntArray;
        mAttrMap = sparseIntArray = new SparseIntArray();
        int n10 = R$styleable.KeyPosition_motionTarget;
        sparseIntArray.append(n10, 1);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyPosition_framePosition;
        sparseIntArray.append(n10, 2);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyPosition_transitionEasing;
        sparseIntArray.append(n10, 3);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyPosition_curveFit;
        sparseIntArray.append(n10, 4);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyPosition_drawPath;
        sparseIntArray.append(n10, 5);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyPosition_percentX;
        sparseIntArray.append(n10, 6);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyPosition_percentY;
        sparseIntArray.append(n10, 7);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyPosition_keyPositionType;
        sparseIntArray.append(n10, 9);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyPosition_sizePercent;
        sparseIntArray.append(n10, 8);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyPosition_percentWidth;
        sparseIntArray.append(n10, 11);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyPosition_percentHeight;
        sparseIntArray.append(n10, 12);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyPosition_pathMotionArc;
        sparseIntArray.append(n10, 10);
    }

    private KeyPosition$Loader() {
    }

    public static /* synthetic */ void access$000(KeyPosition keyPosition, TypedArray typedArray) {
        KeyPosition$Loader.read(keyPosition, typedArray);
    }

    private static void read(KeyPosition object, TypedArray typedArray) {
        int n10;
        Object object2;
        int n11 = typedArray.getIndexCount();
        int n12 = 0;
        while (true) {
            object2 = "KeyPosition";
            n10 = -1;
            if (n12 >= n11) break;
            int n13 = typedArray.getIndex(n12);
            Object object3 = mAttrMap;
            int n14 = object3.get(n13);
            int n15 = 3;
            switch (n14) {
                default: {
                    CharSequence charSequence = new StringBuilder();
                    charSequence.append("unused attribute 0x");
                    object3 = Integer.toHexString(n13);
                    charSequence.append((String)object3);
                    charSequence.append("   ");
                    object3 = mAttrMap;
                    n13 = object3.get(n13);
                    charSequence.append(n13);
                    charSequence = charSequence.toString();
                    Log.e((String)object2, (String)charSequence);
                    break;
                }
                case 12: {
                    float f10 = ((KeyPosition)object).mPercentHeight;
                    ((KeyPosition)object).mPercentHeight = f10 = typedArray.getFloat(n13, f10);
                    break;
                }
                case 11: {
                    float f10 = ((KeyPosition)object).mPercentWidth;
                    ((KeyPosition)object).mPercentWidth = f10 = typedArray.getFloat(n13, f10);
                    break;
                }
                case 10: {
                    int n16 = ((KeyPosition)object).mPathMotionArc;
                    ((KeyPosition)object).mPathMotionArc = n16 = typedArray.getInt(n13, n16);
                    break;
                }
                case 9: {
                    int n16 = ((KeyPosition)object).mPositionType;
                    ((KeyPosition)object).mPositionType = n16 = typedArray.getInt(n13, n16);
                    break;
                }
                case 8: {
                    float f10 = ((KeyPosition)object).mPercentHeight;
                    ((KeyPosition)object).mPercentWidth = f10 = typedArray.getFloat(n13, f10);
                    ((KeyPosition)object).mPercentHeight = f10;
                    break;
                }
                case 7: {
                    float f10 = ((KeyPosition)object).mPercentY;
                    ((KeyPosition)object).mPercentY = f10 = typedArray.getFloat(n13, f10);
                    break;
                }
                case 6: {
                    float f10 = ((KeyPosition)object).mPercentX;
                    ((KeyPosition)object).mPercentX = f10 = typedArray.getFloat(n13, f10);
                    break;
                }
                case 5: {
                    int n16 = ((KeyPosition)object).mDrawPath;
                    ((KeyPosition)object).mDrawPath = n16 = typedArray.getInt(n13, n16);
                    break;
                }
                case 4: {
                    int n16 = ((KeyPositionBase)object).mCurveFit;
                    ((KeyPositionBase)object).mCurveFit = n16 = typedArray.getInteger(n13, n16);
                    break;
                }
                case 3: {
                    object2 = typedArray.peekValue(n13);
                    int n16 = object2.type;
                    if (n16 == n15) {
                        ((KeyPosition)object).mTransitionEasing = object2 = typedArray.getString(n13);
                        break;
                    }
                    object2 = Easing.NAMED_EASING;
                    n10 = typedArray.getInteger(n13, 0);
                    ((KeyPosition)object).mTransitionEasing = object2 = object2[n10];
                    break;
                }
                case 2: {
                    int n16 = ((Key)object).mFramePosition;
                    ((Key)object).mFramePosition = n16 = typedArray.getInt(n13, n16);
                    break;
                }
                case 1: {
                    int n16 = MotionLayout.IS_IN_EDIT_MODE;
                    if (n16 != 0) {
                        n16 = ((Key)object).mTargetId;
                        ((Key)object).mTargetId = n16 = typedArray.getResourceId(n13, n16);
                        if (n16 != n10) break;
                        ((Key)object).mTargetString = object2 = typedArray.getString(n13);
                        break;
                    }
                    object2 = typedArray.peekValue(n13);
                    n16 = object2.type;
                    if (n16 == n15) {
                        ((Key)object).mTargetString = object2 = typedArray.getString(n13);
                        break;
                    }
                    n16 = ((Key)object).mTargetId;
                    ((Key)object).mTargetId = n16 = typedArray.getResourceId(n13, n16);
                }
            }
            ++n12;
        }
        int n17 = ((Key)object).mFramePosition;
        if (n17 == n10) {
            object = "no frame position";
            Log.e((String)object2, (String)object);
        }
    }
}

