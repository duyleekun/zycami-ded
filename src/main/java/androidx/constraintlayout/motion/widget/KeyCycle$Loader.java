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
import androidx.constraintlayout.motion.widget.KeyCycle;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R$styleable;

public class KeyCycle$Loader {
    private static final int ANDROID_ALPHA = 9;
    private static final int ANDROID_ELEVATION = 10;
    private static final int ANDROID_ROTATION = 11;
    private static final int ANDROID_ROTATION_X = 12;
    private static final int ANDROID_ROTATION_Y = 13;
    private static final int ANDROID_SCALE_X = 15;
    private static final int ANDROID_SCALE_Y = 16;
    private static final int ANDROID_TRANSLATION_X = 17;
    private static final int ANDROID_TRANSLATION_Y = 18;
    private static final int ANDROID_TRANSLATION_Z = 19;
    private static final int CURVE_FIT = 4;
    private static final int FRAME_POSITION = 2;
    private static final int PROGRESS = 20;
    private static final int TARGET_ID = 1;
    private static final int TRANSITION_EASING = 3;
    private static final int TRANSITION_PATH_ROTATE = 14;
    private static final int WAVE_OFFSET = 7;
    private static final int WAVE_PERIOD = 6;
    private static final int WAVE_SHAPE = 5;
    private static final int WAVE_VARIES_BY = 8;
    private static SparseIntArray mAttrMap;

    static {
        SparseIntArray sparseIntArray;
        mAttrMap = sparseIntArray = new SparseIntArray();
        int n10 = R$styleable.KeyCycle_motionTarget;
        sparseIntArray.append(n10, 1);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyCycle_framePosition;
        sparseIntArray.append(n10, 2);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyCycle_transitionEasing;
        sparseIntArray.append(n10, 3);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyCycle_curveFit;
        sparseIntArray.append(n10, 4);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyCycle_waveShape;
        sparseIntArray.append(n10, 5);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyCycle_wavePeriod;
        sparseIntArray.append(n10, 6);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyCycle_waveOffset;
        sparseIntArray.append(n10, 7);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyCycle_waveVariesBy;
        sparseIntArray.append(n10, 8);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyCycle_android_alpha;
        sparseIntArray.append(n10, 9);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyCycle_android_elevation;
        sparseIntArray.append(n10, 10);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyCycle_android_rotation;
        sparseIntArray.append(n10, 11);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyCycle_android_rotationX;
        sparseIntArray.append(n10, 12);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyCycle_android_rotationY;
        sparseIntArray.append(n10, 13);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyCycle_transitionPathRotate;
        sparseIntArray.append(n10, 14);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyCycle_android_scaleX;
        sparseIntArray.append(n10, 15);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyCycle_android_scaleY;
        sparseIntArray.append(n10, 16);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyCycle_android_translationX;
        sparseIntArray.append(n10, 17);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyCycle_android_translationY;
        sparseIntArray.append(n10, 18);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyCycle_android_translationZ;
        sparseIntArray.append(n10, 19);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyCycle_motionProgress;
        sparseIntArray.append(n10, 20);
    }

    private KeyCycle$Loader() {
    }

    public static /* synthetic */ void access$000(KeyCycle keyCycle, TypedArray typedArray) {
        KeyCycle$Loader.read(keyCycle, typedArray);
    }

    private static void read(KeyCycle keyCycle, TypedArray typedArray) {
        int n10 = typedArray.getIndexCount();
        block22: for (int i10 = 0; i10 < n10; ++i10) {
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
                    object = "KeyCycle";
                    Log.e((String)object, (String)string3);
                    continue block22;
                }
                case 20: {
                    float f10 = KeyCycle.access$1800(keyCycle);
                    float f11 = typedArray.getFloat(n11, f10);
                    KeyCycle.access$1802(keyCycle, f11);
                    continue block22;
                }
                case 19: {
                    n12 = Build.VERSION.SDK_INT;
                    int n13 = 21;
                    if (n12 < n13) continue block22;
                    float f10 = KeyCycle.access$1700(keyCycle);
                    float f11 = typedArray.getDimension(n11, f10);
                    KeyCycle.access$1702(keyCycle, f11);
                    continue block22;
                }
                case 18: {
                    float f10 = KeyCycle.access$1600(keyCycle);
                    float f11 = typedArray.getDimension(n11, f10);
                    KeyCycle.access$1602(keyCycle, f11);
                    continue block22;
                }
                case 17: {
                    float f10 = KeyCycle.access$1500(keyCycle);
                    float f11 = typedArray.getDimension(n11, f10);
                    KeyCycle.access$1502(keyCycle, f11);
                    continue block22;
                }
                case 16: {
                    float f10 = KeyCycle.access$1400(keyCycle);
                    float f11 = typedArray.getFloat(n11, f10);
                    KeyCycle.access$1402(keyCycle, f11);
                    continue block22;
                }
                case 15: {
                    float f10 = KeyCycle.access$1300(keyCycle);
                    float f11 = typedArray.getFloat(n11, f10);
                    KeyCycle.access$1302(keyCycle, f11);
                    continue block22;
                }
                case 14: {
                    float f10 = KeyCycle.access$1200(keyCycle);
                    float f11 = typedArray.getFloat(n11, f10);
                    KeyCycle.access$1202(keyCycle, f11);
                    continue block22;
                }
                case 13: {
                    float f10 = KeyCycle.access$1100(keyCycle);
                    float f11 = typedArray.getFloat(n11, f10);
                    KeyCycle.access$1102(keyCycle, f11);
                    continue block22;
                }
                case 12: {
                    float f10 = KeyCycle.access$1000(keyCycle);
                    float f11 = typedArray.getFloat(n11, f10);
                    KeyCycle.access$1002(keyCycle, f11);
                    continue block22;
                }
                case 11: {
                    float f10 = KeyCycle.access$900(keyCycle);
                    float f11 = typedArray.getFloat(n11, f10);
                    KeyCycle.access$902(keyCycle, f11);
                    continue block22;
                }
                case 10: {
                    float f10 = KeyCycle.access$800(keyCycle);
                    float f11 = typedArray.getDimension(n11, f10);
                    KeyCycle.access$802(keyCycle, f11);
                    continue block22;
                }
                case 9: {
                    float f10 = KeyCycle.access$700(keyCycle);
                    float f11 = typedArray.getFloat(n11, f10);
                    KeyCycle.access$702(keyCycle, f11);
                    continue block22;
                }
                case 8: {
                    n12 = KeyCycle.access$600(keyCycle);
                    n11 = typedArray.getInt(n11, n12);
                    KeyCycle.access$602(keyCycle, n11);
                    continue block22;
                }
                case 7: {
                    float f11;
                    float f10;
                    object = typedArray.peekValue(n11);
                    n12 = ((TypedValue)object).type;
                    int n13 = 5;
                    if (n12 == n13) {
                        f10 = KeyCycle.access$500(keyCycle);
                        f11 = typedArray.getDimension(n11, f10);
                        KeyCycle.access$502(keyCycle, f11);
                        continue block22;
                    }
                    f10 = KeyCycle.access$500(keyCycle);
                    f11 = typedArray.getFloat(n11, f10);
                    KeyCycle.access$502(keyCycle, f11);
                    continue block22;
                }
                case 6: {
                    float f10 = KeyCycle.access$400(keyCycle);
                    float f11 = typedArray.getFloat(n11, f10);
                    KeyCycle.access$402(keyCycle, f11);
                    continue block22;
                }
                case 5: {
                    n12 = KeyCycle.access$300(keyCycle);
                    n11 = typedArray.getInt(n11, n12);
                    KeyCycle.access$302(keyCycle, n11);
                    continue block22;
                }
                case 4: {
                    n12 = KeyCycle.access$200(keyCycle);
                    n11 = typedArray.getInteger(n11, n12);
                    KeyCycle.access$202(keyCycle, n11);
                    continue block22;
                }
                case 3: {
                    String string3 = typedArray.getString(n11);
                    KeyCycle.access$102(keyCycle, string3);
                    continue block22;
                }
                case 2: {
                    n12 = keyCycle.mFramePosition;
                    keyCycle.mFramePosition = n11 = typedArray.getInt(n11, n12);
                    continue block22;
                }
                case 1: {
                    int n13;
                    String string3;
                    n12 = MotionLayout.IS_IN_EDIT_MODE ? 1 : 0;
                    if (n12 != 0) {
                        n12 = keyCycle.mTargetId;
                        keyCycle.mTargetId = n12 = typedArray.getResourceId(n11, n12);
                        n13 = -1;
                        if (n12 != n13) continue block22;
                        keyCycle.mTargetString = string3 = typedArray.getString(n11);
                        continue block22;
                    }
                    object = typedArray.peekValue(n11);
                    n12 = ((TypedValue)object).type;
                    n13 = 3;
                    if (n12 == n13) {
                        keyCycle.mTargetString = string3 = typedArray.getString(n11);
                        continue block22;
                    }
                    n12 = keyCycle.mTargetId;
                    keyCycle.mTargetId = n11 = typedArray.getResourceId(n11, n12);
                }
            }
        }
    }
}

