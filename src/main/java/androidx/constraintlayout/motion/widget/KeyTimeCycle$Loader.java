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
import androidx.constraintlayout.motion.widget.KeyTimeCycle;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R$styleable;

public class KeyTimeCycle$Loader {
    private static final int ANDROID_ALPHA = 1;
    private static final int ANDROID_ELEVATION = 2;
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
    private static final int WAVE_OFFSET = 21;
    private static final int WAVE_PERIOD = 20;
    private static final int WAVE_SHAPE = 19;
    private static SparseIntArray mAttrMap;

    static {
        SparseIntArray sparseIntArray;
        mAttrMap = sparseIntArray = new SparseIntArray();
        int n10 = R$styleable.KeyTimeCycle_android_alpha;
        sparseIntArray.append(n10, 1);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyTimeCycle_android_elevation;
        sparseIntArray.append(n10, 2);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyTimeCycle_android_rotation;
        sparseIntArray.append(n10, 4);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyTimeCycle_android_rotationX;
        sparseIntArray.append(n10, 5);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyTimeCycle_android_rotationY;
        sparseIntArray.append(n10, 6);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyTimeCycle_android_scaleX;
        sparseIntArray.append(n10, 7);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyTimeCycle_transitionPathRotate;
        sparseIntArray.append(n10, 8);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyTimeCycle_transitionEasing;
        sparseIntArray.append(n10, 9);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyTimeCycle_motionTarget;
        sparseIntArray.append(n10, 10);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyTimeCycle_framePosition;
        sparseIntArray.append(n10, 12);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyTimeCycle_curveFit;
        sparseIntArray.append(n10, 13);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyTimeCycle_android_scaleY;
        sparseIntArray.append(n10, 14);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyTimeCycle_android_translationX;
        sparseIntArray.append(n10, 15);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyTimeCycle_android_translationY;
        sparseIntArray.append(n10, 16);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyTimeCycle_android_translationZ;
        sparseIntArray.append(n10, 17);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyTimeCycle_motionProgress;
        sparseIntArray.append(n10, 18);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyTimeCycle_wavePeriod;
        sparseIntArray.append(n10, 20);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyTimeCycle_waveOffset;
        sparseIntArray.append(n10, 21);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyTimeCycle_waveShape;
        sparseIntArray.append(n10, 19);
    }

    private KeyTimeCycle$Loader() {
    }

    public static void read(KeyTimeCycle keyTimeCycle, TypedArray typedArray) {
        int n10 = typedArray.getIndexCount();
        block21: for (int i10 = 0; i10 < n10; ++i10) {
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
                    object = "KeyTimeCycle";
                    Log.e((String)object, (String)string3);
                    continue block21;
                }
                case 21: {
                    float f10;
                    float f11;
                    object = typedArray.peekValue(n11);
                    n12 = ((TypedValue)object).type;
                    int n13 = 5;
                    if (n12 == n13) {
                        f11 = KeyTimeCycle.access$600(keyTimeCycle);
                        f10 = typedArray.getDimension(n11, f11);
                        KeyTimeCycle.access$602(keyTimeCycle, f10);
                        continue block21;
                    }
                    f11 = KeyTimeCycle.access$600(keyTimeCycle);
                    f10 = typedArray.getFloat(n11, f11);
                    KeyTimeCycle.access$602(keyTimeCycle, f10);
                    continue block21;
                }
                case 20: {
                    float f11 = KeyTimeCycle.access$500(keyTimeCycle);
                    float f10 = typedArray.getFloat(n11, f11);
                    KeyTimeCycle.access$502(keyTimeCycle, f10);
                    continue block21;
                }
                case 19: {
                    n12 = KeyTimeCycle.access$400(keyTimeCycle);
                    n11 = typedArray.getInt(n11, n12);
                    KeyTimeCycle.access$402(keyTimeCycle, n11);
                    continue block21;
                }
                case 18: {
                    float f11 = KeyTimeCycle.access$1600(keyTimeCycle);
                    float f10 = typedArray.getFloat(n11, f11);
                    KeyTimeCycle.access$1602(keyTimeCycle, f10);
                    continue block21;
                }
                case 17: {
                    n12 = Build.VERSION.SDK_INT;
                    int n13 = 21;
                    if (n12 < n13) continue block21;
                    float f11 = KeyTimeCycle.access$1500(keyTimeCycle);
                    float f10 = typedArray.getDimension(n11, f11);
                    KeyTimeCycle.access$1502(keyTimeCycle, f10);
                    continue block21;
                }
                case 16: {
                    float f11 = KeyTimeCycle.access$1400(keyTimeCycle);
                    float f10 = typedArray.getDimension(n11, f11);
                    KeyTimeCycle.access$1402(keyTimeCycle, f10);
                    continue block21;
                }
                case 15: {
                    float f11 = KeyTimeCycle.access$1300(keyTimeCycle);
                    float f10 = typedArray.getDimension(n11, f11);
                    KeyTimeCycle.access$1302(keyTimeCycle, f10);
                    continue block21;
                }
                case 14: {
                    float f11 = KeyTimeCycle.access$1100(keyTimeCycle);
                    float f10 = typedArray.getFloat(n11, f11);
                    KeyTimeCycle.access$1102(keyTimeCycle, f10);
                    continue block21;
                }
                case 13: {
                    n12 = KeyTimeCycle.access$300(keyTimeCycle);
                    n11 = typedArray.getInteger(n11, n12);
                    KeyTimeCycle.access$302(keyTimeCycle, n11);
                    continue block21;
                }
                case 12: {
                    n12 = keyTimeCycle.mFramePosition;
                    keyTimeCycle.mFramePosition = n11 = typedArray.getInt(n11, n12);
                    continue block21;
                }
                case 10: {
                    int n13;
                    String string3;
                    n12 = MotionLayout.IS_IN_EDIT_MODE ? 1 : 0;
                    if (n12 != 0) {
                        n12 = keyTimeCycle.mTargetId;
                        keyTimeCycle.mTargetId = n12 = typedArray.getResourceId(n11, n12);
                        n13 = -1;
                        if (n12 != n13) continue block21;
                        keyTimeCycle.mTargetString = string3 = typedArray.getString(n11);
                        continue block21;
                    }
                    object = typedArray.peekValue(n11);
                    n12 = ((TypedValue)object).type;
                    n13 = 3;
                    if (n12 == n13) {
                        keyTimeCycle.mTargetString = string3 = typedArray.getString(n11);
                        continue block21;
                    }
                    n12 = keyTimeCycle.mTargetId;
                    keyTimeCycle.mTargetId = n11 = typedArray.getResourceId(n11, n12);
                    continue block21;
                }
                case 9: {
                    String string3 = typedArray.getString(n11);
                    KeyTimeCycle.access$1002(keyTimeCycle, string3);
                    continue block21;
                }
                case 8: {
                    float f11 = KeyTimeCycle.access$1200(keyTimeCycle);
                    float f10 = typedArray.getFloat(n11, f11);
                    KeyTimeCycle.access$1202(keyTimeCycle, f10);
                    continue block21;
                }
                case 7: {
                    float f11 = KeyTimeCycle.access$700(keyTimeCycle);
                    float f10 = typedArray.getFloat(n11, f11);
                    KeyTimeCycle.access$702(keyTimeCycle, f10);
                    continue block21;
                }
                case 6: {
                    float f11 = KeyTimeCycle.access$900(keyTimeCycle);
                    float f10 = typedArray.getFloat(n11, f11);
                    KeyTimeCycle.access$902(keyTimeCycle, f10);
                    continue block21;
                }
                case 5: {
                    float f11 = KeyTimeCycle.access$800(keyTimeCycle);
                    float f10 = typedArray.getFloat(n11, f11);
                    KeyTimeCycle.access$802(keyTimeCycle, f10);
                    continue block21;
                }
                case 4: {
                    float f11 = KeyTimeCycle.access$200(keyTimeCycle);
                    float f10 = typedArray.getFloat(n11, f11);
                    KeyTimeCycle.access$202(keyTimeCycle, f10);
                    continue block21;
                }
                case 2: {
                    float f11 = KeyTimeCycle.access$100(keyTimeCycle);
                    float f10 = typedArray.getDimension(n11, f11);
                    KeyTimeCycle.access$102(keyTimeCycle, f10);
                    continue block21;
                }
                case 1: {
                    float f11 = KeyTimeCycle.access$000(keyTimeCycle);
                    float f10 = typedArray.getFloat(n11, f11);
                    KeyTimeCycle.access$002(keyTimeCycle, f10);
                }
            }
        }
    }
}

