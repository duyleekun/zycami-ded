/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.TypedArray
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.util.SparseIntArray
 *  android.util.TypedValue
 */
package androidx.constraintlayout.motion.widget;

import android.content.res.TypedArray;
import android.os.Build;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import androidx.constraintlayout.motion.widget.KeyAttributes;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R$styleable;

public class KeyAttributes$Loader {
    private static final int ANDROID_ALPHA = 1;
    private static final int ANDROID_ELEVATION = 2;
    private static final int ANDROID_PIVOT_X = 19;
    private static final int ANDROID_PIVOT_Y = 20;
    private static final int ANDROID_ROTATION = 4;
    private static final int ANDROID_ROTATION_X = 5;
    private static final int ANDROID_ROTATION_Y = 6;
    private static final int ANDROID_SCALE_X = 7;
    private static final int ANDROID_SCALE_Y = 14;
    private static final int ANDROID_TRANSLATION_X = 15;
    private static final int ANDROID_TRANSLATION_Y = 16;
    private static final int ANDROID_TRANSLATION_Z = 17;
    private static final int CURVE_FIT = 13;
    private static final int FRAME_POSITION = 12;
    private static final int PROGRESS = 18;
    private static final int TARGET_ID = 10;
    private static final int TRANSITION_EASING = 9;
    private static final int TRANSITION_PATH_ROTATE = 8;
    private static SparseIntArray mAttrMap;

    static {
        SparseIntArray sparseIntArray;
        mAttrMap = sparseIntArray = new SparseIntArray();
        int n10 = R$styleable.KeyAttribute_android_alpha;
        sparseIntArray.append(n10, 1);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyAttribute_android_elevation;
        sparseIntArray.append(n10, 2);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyAttribute_android_rotation;
        sparseIntArray.append(n10, 4);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyAttribute_android_rotationX;
        sparseIntArray.append(n10, 5);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyAttribute_android_rotationY;
        sparseIntArray.append(n10, 6);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyAttribute_android_transformPivotX;
        sparseIntArray.append(n10, 19);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyAttribute_android_transformPivotY;
        sparseIntArray.append(n10, 20);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyAttribute_android_scaleX;
        sparseIntArray.append(n10, 7);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyAttribute_transitionPathRotate;
        sparseIntArray.append(n10, 8);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyAttribute_transitionEasing;
        sparseIntArray.append(n10, 9);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyAttribute_motionTarget;
        sparseIntArray.append(n10, 10);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyAttribute_framePosition;
        sparseIntArray.append(n10, 12);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyAttribute_curveFit;
        sparseIntArray.append(n10, 13);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyAttribute_android_scaleY;
        sparseIntArray.append(n10, 14);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyAttribute_android_translationX;
        sparseIntArray.append(n10, 15);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyAttribute_android_translationY;
        sparseIntArray.append(n10, 16);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyAttribute_android_translationZ;
        sparseIntArray.append(n10, 17);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyAttribute_motionProgress;
        sparseIntArray.append(n10, 18);
    }

    private KeyAttributes$Loader() {
    }

    public static void read(KeyAttributes keyAttributes, TypedArray typedArray) {
        int n10 = typedArray.getIndexCount();
        block20: for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = typedArray.getIndex(i10);
            Object object = mAttrMap;
            int n12 = object.get(n11);
            switch (n12) {
                default: {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("unused attribute 0x");
                    String string2 = Integer.toHexString(n11);
                    ((StringBuilder)object).append(string2);
                    ((StringBuilder)object).append("   ");
                    string2 = mAttrMap;
                    n11 = string2.get(n11);
                    ((StringBuilder)object).append(n11);
                    String string3 = ((StringBuilder)object).toString();
                    object = "KeyAttribute";
                    Log.e((String)object, (String)string3);
                    continue block20;
                }
                case 20: {
                    float f10 = KeyAttributes.access$800(keyAttributes);
                    float f11 = typedArray.getDimension(n11, f10);
                    KeyAttributes.access$802(keyAttributes, f11);
                    continue block20;
                }
                case 19: {
                    float f10 = KeyAttributes.access$700(keyAttributes);
                    float f11 = typedArray.getDimension(n11, f10);
                    KeyAttributes.access$702(keyAttributes, f11);
                    continue block20;
                }
                case 18: {
                    float f10 = KeyAttributes.access$1500(keyAttributes);
                    float f11 = typedArray.getFloat(n11, f10);
                    KeyAttributes.access$1502(keyAttributes, f11);
                    continue block20;
                }
                case 17: {
                    n12 = Build.VERSION.SDK_INT;
                    int n13 = 21;
                    if (n12 < n13) continue block20;
                    float f10 = KeyAttributes.access$1400(keyAttributes);
                    float f11 = typedArray.getDimension(n11, f10);
                    KeyAttributes.access$1402(keyAttributes, f11);
                    continue block20;
                }
                case 16: {
                    float f10 = KeyAttributes.access$1300(keyAttributes);
                    float f11 = typedArray.getDimension(n11, f10);
                    KeyAttributes.access$1302(keyAttributes, f11);
                    continue block20;
                }
                case 15: {
                    float f10 = KeyAttributes.access$1200(keyAttributes);
                    float f11 = typedArray.getDimension(n11, f10);
                    KeyAttributes.access$1202(keyAttributes, f11);
                    continue block20;
                }
                case 14: {
                    float f10 = KeyAttributes.access$1000(keyAttributes);
                    float f11 = typedArray.getFloat(n11, f10);
                    KeyAttributes.access$1002(keyAttributes, f11);
                    continue block20;
                }
                case 13: {
                    n12 = KeyAttributes.access$300(keyAttributes);
                    n11 = typedArray.getInteger(n11, n12);
                    KeyAttributes.access$302(keyAttributes, n11);
                    continue block20;
                }
                case 12: {
                    n12 = keyAttributes.mFramePosition;
                    keyAttributes.mFramePosition = n11 = typedArray.getInt(n11, n12);
                    continue block20;
                }
                case 10: {
                    int n13;
                    String string3;
                    n12 = MotionLayout.IS_IN_EDIT_MODE ? 1 : 0;
                    if (n12 != 0) {
                        n12 = keyAttributes.mTargetId;
                        keyAttributes.mTargetId = n12 = typedArray.getResourceId(n11, n12);
                        n13 = -1;
                        if (n12 != n13) continue block20;
                        keyAttributes.mTargetString = string3 = typedArray.getString(n11);
                        continue block20;
                    }
                    object = typedArray.peekValue(n11);
                    n12 = ((TypedValue)object).type;
                    n13 = 3;
                    if (n12 == n13) {
                        keyAttributes.mTargetString = string3 = typedArray.getString(n11);
                        continue block20;
                    }
                    n12 = keyAttributes.mTargetId;
                    keyAttributes.mTargetId = n11 = typedArray.getResourceId(n11, n12);
                    continue block20;
                }
                case 9: {
                    String string3 = typedArray.getString(n11);
                    KeyAttributes.access$902(keyAttributes, string3);
                    continue block20;
                }
                case 8: {
                    float f10 = KeyAttributes.access$1100(keyAttributes);
                    float f11 = typedArray.getFloat(n11, f10);
                    KeyAttributes.access$1102(keyAttributes, f11);
                    continue block20;
                }
                case 7: {
                    float f10 = KeyAttributes.access$400(keyAttributes);
                    float f11 = typedArray.getFloat(n11, f10);
                    KeyAttributes.access$402(keyAttributes, f11);
                    continue block20;
                }
                case 6: {
                    float f10 = KeyAttributes.access$600(keyAttributes);
                    float f11 = typedArray.getFloat(n11, f10);
                    KeyAttributes.access$602(keyAttributes, f11);
                    continue block20;
                }
                case 5: {
                    float f10 = KeyAttributes.access$500(keyAttributes);
                    float f11 = typedArray.getFloat(n11, f10);
                    KeyAttributes.access$502(keyAttributes, f11);
                    continue block20;
                }
                case 4: {
                    float f10 = KeyAttributes.access$200(keyAttributes);
                    float f11 = typedArray.getFloat(n11, f10);
                    KeyAttributes.access$202(keyAttributes, f11);
                    continue block20;
                }
                case 2: {
                    float f10 = KeyAttributes.access$100(keyAttributes);
                    float f11 = typedArray.getDimension(n11, f10);
                    KeyAttributes.access$102(keyAttributes, f11);
                    continue block20;
                }
                case 1: {
                    float f10 = KeyAttributes.access$000(keyAttributes);
                    float f11 = typedArray.getFloat(n11, f10);
                    KeyAttributes.access$002(keyAttributes, f11);
                }
            }
        }
    }
}

