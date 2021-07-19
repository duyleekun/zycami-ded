/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.RectF
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.KeyTrigger$Loader;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R$styleable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

public class KeyTrigger
extends Key {
    public static final int KEY_TYPE = 5;
    public static final String NAME = "KeyTrigger";
    private static final String TAG = "KeyTrigger";
    public RectF mCollisionRect;
    private String mCross = null;
    private int mCurveFit = -1;
    private Method mFireCross;
    private boolean mFireCrossReset;
    private float mFireLastPos;
    private Method mFireNegativeCross;
    private boolean mFireNegativeReset;
    private Method mFirePositiveCross;
    private boolean mFirePositiveReset;
    private float mFireThreshold;
    private String mNegativeCross;
    private String mPositiveCross;
    private boolean mPostLayout;
    public RectF mTargetRect;
    private int mTriggerCollisionId;
    private View mTriggerCollisionView;
    private int mTriggerID;
    private int mTriggerReceiver;
    public float mTriggerSlack;

    public KeyTrigger() {
        Object object;
        boolean bl2;
        int n10;
        this.mTriggerReceiver = n10 = Key.UNSET;
        this.mNegativeCross = null;
        this.mPositiveCross = null;
        this.mTriggerID = n10;
        this.mTriggerCollisionId = n10;
        this.mTriggerCollisionView = null;
        this.mTriggerSlack = 0.1f;
        this.mFireCrossReset = bl2 = true;
        this.mFireNegativeReset = bl2;
        this.mFirePositiveReset = bl2;
        this.mFireThreshold = 0.0f / 0.0f;
        this.mPostLayout = false;
        this.mCollisionRect = object = new RectF();
        this.mTargetRect = object = new RectF();
        this.mType = 5;
        this.mCustomConstraints = object;
    }

    public static /* synthetic */ float access$002(KeyTrigger keyTrigger, float f10) {
        keyTrigger.mFireThreshold = f10;
        return f10;
    }

    public static /* synthetic */ String access$102(KeyTrigger keyTrigger, String string2) {
        keyTrigger.mNegativeCross = string2;
        return string2;
    }

    public static /* synthetic */ String access$202(KeyTrigger keyTrigger, String string2) {
        keyTrigger.mPositiveCross = string2;
        return string2;
    }

    public static /* synthetic */ String access$302(KeyTrigger keyTrigger, String string2) {
        keyTrigger.mCross = string2;
        return string2;
    }

    public static /* synthetic */ int access$400(KeyTrigger keyTrigger) {
        return keyTrigger.mTriggerID;
    }

    public static /* synthetic */ int access$402(KeyTrigger keyTrigger, int n10) {
        keyTrigger.mTriggerID = n10;
        return n10;
    }

    public static /* synthetic */ int access$500(KeyTrigger keyTrigger) {
        return keyTrigger.mTriggerCollisionId;
    }

    public static /* synthetic */ int access$502(KeyTrigger keyTrigger, int n10) {
        keyTrigger.mTriggerCollisionId = n10;
        return n10;
    }

    public static /* synthetic */ boolean access$600(KeyTrigger keyTrigger) {
        return keyTrigger.mPostLayout;
    }

    public static /* synthetic */ boolean access$602(KeyTrigger keyTrigger, boolean bl2) {
        keyTrigger.mPostLayout = bl2;
        return bl2;
    }

    public static /* synthetic */ int access$700(KeyTrigger keyTrigger) {
        return keyTrigger.mTriggerReceiver;
    }

    public static /* synthetic */ int access$702(KeyTrigger keyTrigger, int n10) {
        keyTrigger.mTriggerReceiver = n10;
        return n10;
    }

    private void setUpRect(RectF rectF, View view, boolean bl2) {
        float f10;
        rectF.top = f10 = (float)view.getTop();
        rectF.bottom = f10 = (float)view.getBottom();
        rectF.left = f10 = (float)view.getLeft();
        int n10 = view.getRight();
        rectF.right = f10 = (float)n10;
        if (bl2) {
            view = view.getMatrix();
            view.mapRect(rectF);
        }
    }

    public void addValues(HashMap hashMap) {
    }

    public void conditionallyFire(float f10, View object) {
        Object object2;
        Object object3;
        int n10;
        Object object4;
        Object object5;
        Object object6;
        Object object7;
        Object object8;
        Object object9;
        boolean bl2;
        Object object10;
        int n11;
        block53: {
            float f11;
            float f12;
            block62: {
                float f13;
                block61: {
                    float f14;
                    block60: {
                        float f15;
                        float f16;
                        block59: {
                            block58: {
                                block57: {
                                    float f17;
                                    block56: {
                                        float f18;
                                        block55: {
                                            block54: {
                                                block52: {
                                                    n11 = this.mTriggerCollisionId;
                                                    object10 = Key.UNSET;
                                                    bl2 = true;
                                                    f13 = Float.MIN_VALUE;
                                                    if (n11 == object10) break block52;
                                                    object9 = this.mTriggerCollisionView;
                                                    if (object9 == null) {
                                                        object9 = (ViewGroup)object.getParent();
                                                        object10 = this.mTriggerCollisionId;
                                                        object9 = object9.findViewById(object10);
                                                        this.mTriggerCollisionView = object9;
                                                    }
                                                    object9 = this.mCollisionRect;
                                                    object8 = this.mTriggerCollisionView;
                                                    object7 = this.mPostLayout;
                                                    this.setUpRect((RectF)object9, (View)object8, (boolean)object7);
                                                    object9 = this.mTargetRect;
                                                    object10 = this.mPostLayout;
                                                    this.setUpRect((RectF)object9, (View)object, (boolean)object10);
                                                    object9 = this.mCollisionRect;
                                                    object8 = this.mTargetRect;
                                                    n11 = (int)(object9.intersect((RectF)object8) ? 1 : 0);
                                                    if (n11 != 0) {
                                                        float f19;
                                                        n11 = (int)(this.mFireCrossReset ? 1 : 0);
                                                        if (n11 != 0) {
                                                            this.mFireCrossReset = false;
                                                            n11 = (int)(bl2 ? 1 : 0);
                                                            float f20 = f13;
                                                        } else {
                                                            n11 = 0;
                                                            object9 = null;
                                                            float f21 = 0.0f;
                                                        }
                                                        object10 = this.mFirePositiveReset;
                                                        if (object10 != 0) {
                                                            this.mFirePositiveReset = false;
                                                            object10 = bl2;
                                                            f19 = f13;
                                                        } else {
                                                            object10 = 0;
                                                            object8 = null;
                                                            f19 = 0.0f;
                                                        }
                                                        this.mFireNegativeReset = bl2;
                                                        bl2 = object10;
                                                        f13 = f19;
                                                        object10 = 0;
                                                        object8 = null;
                                                        f19 = 0.0f;
                                                    } else {
                                                        n11 = (int)(this.mFireCrossReset ? 1 : 0);
                                                        if (n11 == 0) {
                                                            this.mFireCrossReset = bl2;
                                                            n11 = (int)(bl2 ? 1 : 0);
                                                            float f22 = f13;
                                                        } else {
                                                            n11 = 0;
                                                            object9 = null;
                                                            float f23 = 0.0f;
                                                        }
                                                        object10 = this.mFireNegativeReset;
                                                        if (object10 != 0) {
                                                            this.mFireNegativeReset = false;
                                                            object10 = bl2;
                                                            float f24 = f13;
                                                        } else {
                                                            object10 = 0;
                                                            object8 = null;
                                                            float f25 = 0.0f;
                                                        }
                                                        this.mFirePositiveReset = bl2;
                                                        bl2 = false;
                                                        object6 = null;
                                                        f13 = 0.0f;
                                                    }
                                                    break block53;
                                                }
                                                n11 = (int)(this.mFireCrossReset ? 1 : 0);
                                                object10 = 0;
                                                f12 = 0.0f;
                                                object8 = null;
                                                if (n11 == 0) break block54;
                                                f18 = this.mFireThreshold;
                                                f11 = f10 - f18;
                                                f14 = this.mFireLastPos - f18;
                                                float f26 = (f11 *= f14) - 0.0f;
                                                n11 = (int)(f26 == 0.0f ? 0 : (f26 < 0.0f ? -1 : 1));
                                                if (n11 >= 0) break block55;
                                                this.mFireCrossReset = false;
                                                n11 = (int)(bl2 ? 1 : 0);
                                                f18 = f13;
                                                break block56;
                                            }
                                            f18 = this.mFireThreshold;
                                            float f27 = (f18 = Math.abs(f10 - f18)) - (f11 = this.mTriggerSlack);
                                            n11 = (int)(f27 == 0.0f ? 0 : (f27 > 0.0f ? 1 : -1));
                                            if (n11 > 0) {
                                                this.mFireCrossReset = bl2;
                                            }
                                        }
                                        n11 = 0;
                                        object9 = null;
                                        f18 = 0.0f;
                                    }
                                    object7 = this.mFireNegativeReset;
                                    if (object7 == 0) break block57;
                                    f11 = this.mFireThreshold;
                                    f14 = f10 - f11;
                                    f16 = (this.mFireLastPos - f11) * f14;
                                    float f28 = f16 - 0.0f;
                                    object7 = f28 == 0.0f ? 0 : (f28 < 0.0f ? -1 : 1);
                                    if (object7 >= 0 || (object7 = (Object)((f17 = f14 - 0.0f) == 0.0f ? 0 : (f17 < 0.0f ? -1 : 1))) >= 0) break block58;
                                    this.mFireNegativeReset = false;
                                    object7 = bl2;
                                    f11 = f13;
                                    break block59;
                                }
                                f11 = this.mFireThreshold;
                                float f29 = (f11 = Math.abs(f10 - f11)) - (f14 = this.mTriggerSlack);
                                object7 = f29 == 0.0f ? 0 : (f29 > 0.0f ? 1 : -1);
                                if (object7 > 0) {
                                    this.mFireNegativeReset = bl2;
                                }
                            }
                            object7 = 0;
                            object5 = null;
                            f11 = 0.0f;
                        }
                        object4 = this.mFirePositiveReset;
                        if (object4 == 0) break block60;
                        f14 = this.mFireThreshold;
                        f16 = f10 - f14;
                        float f30 = (this.mFireLastPos - f14) * f16;
                        float f31 = f30 - 0.0f;
                        object4 = f31 == 0.0f ? 0 : (f31 < 0.0f ? -1 : 1);
                        if (object4 >= 0 || (object10 = (Object)((f15 = f16 - 0.0f) == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1))) <= 0) break block61;
                        this.mFirePositiveReset = false;
                        break block62;
                    }
                    f12 = this.mFireThreshold;
                    float f32 = (f12 = Math.abs(f10 - f12)) - (f14 = this.mTriggerSlack);
                    object10 = f32 == 0.0f ? 0 : (f32 > 0.0f ? 1 : -1);
                    if (object10 > 0) {
                        this.mFirePositiveReset = bl2;
                    }
                }
                bl2 = false;
                object6 = null;
                f13 = 0.0f;
            }
            object10 = object7;
            f12 = f11;
        }
        this.mFireLastPos = f10;
        if (object10 != 0 || n11 != 0 || bl2) {
            object5 = (MotionLayout)object.getParent();
            object4 = this.mTriggerID;
            ((MotionLayout)object5).fireTrigger((int)object4, bl2, f10);
        }
        if ((n10 = this.mTriggerReceiver) != (object7 = Key.UNSET)) {
            object3 = (MotionLayout)object.getParent();
            int n12 = this.mTriggerReceiver;
            object = object3.findViewById(n12);
        }
        object3 = "Could not find method \"";
        object5 = "Exception in call \"";
        String string2 = " ";
        String string3 = "\"on class ";
        String string4 = "KeyTrigger";
        if (object10 != 0 && (object8 = this.mNegativeCross) != null) {
            object8 = this.mFireNegativeCross;
            if (object8 == null) {
                object8 = object.getClass();
                object2 = this.mNegativeCross;
                Class[] classArray = new Class[]{};
                object8 = ((Class)object8).getMethod((String)object2, classArray);
                try {
                    this.mFireNegativeCross = object8;
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    object8 = new StringBuilder();
                    ((StringBuilder)object8).append((String)object3);
                    object2 = this.mNegativeCross;
                    ((StringBuilder)object8).append((String)object2);
                    ((StringBuilder)object8).append(string3);
                    object2 = object.getClass().getSimpleName();
                    ((StringBuilder)object8).append((String)object2);
                    ((StringBuilder)object8).append(string2);
                    object2 = Debug.getName(object);
                    ((StringBuilder)object8).append((String)object2);
                    object8 = ((StringBuilder)object8).toString();
                    Log.e((String)string4, (String)object8);
                }
            }
            object8 = this.mFireNegativeCross;
            object2 = new Object[]{};
            try {
                ((Method)object8).invoke(object, object2);
            }
            catch (Exception exception) {
                object8 = new StringBuilder();
                ((StringBuilder)object8).append((String)object5);
                object2 = this.mNegativeCross;
                ((StringBuilder)object8).append((String)object2);
                ((StringBuilder)object8).append(string3);
                object2 = object.getClass().getSimpleName();
                ((StringBuilder)object8).append((String)object2);
                ((StringBuilder)object8).append(string2);
                object2 = Debug.getName(object);
                ((StringBuilder)object8).append((String)object2);
                object8 = ((StringBuilder)object8).toString();
                Log.e((String)string4, (String)object8);
            }
        }
        if (bl2 && (object8 = this.mPositiveCross) != null) {
            object8 = this.mFirePositiveCross;
            if (object8 == null) {
                object8 = object.getClass();
                object6 = this.mPositiveCross;
                object2 = new Class[]{};
                object8 = ((Class)object8).getMethod((String)object6, (Class<?>[])object2);
                try {
                    this.mFirePositiveCross = object8;
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    object8 = new StringBuilder();
                    ((StringBuilder)object8).append((String)object3);
                    object6 = this.mPositiveCross;
                    ((StringBuilder)object8).append((String)object6);
                    ((StringBuilder)object8).append(string3);
                    object6 = object.getClass().getSimpleName();
                    ((StringBuilder)object8).append((String)object6);
                    ((StringBuilder)object8).append(string2);
                    object6 = Debug.getName(object);
                    ((StringBuilder)object8).append((String)object6);
                    object8 = ((StringBuilder)object8).toString();
                    Log.e((String)string4, (String)object8);
                }
            }
            object8 = this.mFirePositiveCross;
            object6 = new Object[]{};
            try {
                ((Method)object8).invoke(object, object6);
            }
            catch (Exception exception) {
                object8 = new StringBuilder();
                ((StringBuilder)object8).append((String)object5);
                object6 = this.mPositiveCross;
                ((StringBuilder)object8).append((String)object6);
                ((StringBuilder)object8).append(string3);
                object6 = object.getClass().getSimpleName();
                ((StringBuilder)object8).append((String)object6);
                ((StringBuilder)object8).append(string2);
                object6 = Debug.getName(object);
                ((StringBuilder)object8).append((String)object6);
                object8 = ((StringBuilder)object8).toString();
                Log.e((String)string4, (String)object8);
            }
        }
        if (n11 != 0 && (object9 = this.mCross) != null) {
            object9 = this.mFireCross;
            if (object9 == null) {
                object9 = object.getClass();
                object8 = this.mCross;
                object6 = new Class[]{};
                object9 = ((Class)object9).getMethod((String)object8, (Class<?>[])object6);
                try {
                    this.mFireCross = object9;
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    object9 = new StringBuilder();
                    ((StringBuilder)object9).append((String)object3);
                    object3 = this.mCross;
                    ((StringBuilder)object9).append((String)object3);
                    ((StringBuilder)object9).append(string3);
                    object3 = object.getClass().getSimpleName();
                    ((StringBuilder)object9).append((String)object3);
                    ((StringBuilder)object9).append(string2);
                    object3 = Debug.getName(object);
                    ((StringBuilder)object9).append((String)object3);
                    object3 = ((StringBuilder)object9).toString();
                    Log.e((String)string4, (String)object3);
                }
            }
            object3 = this.mFireCross;
            object9 = new Object[]{};
            try {
                ((Method)object3).invoke(object, (Object[])object9);
            }
            catch (Exception exception) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append((String)object5);
                object9 = this.mCross;
                ((StringBuilder)object3).append((String)object9);
                ((StringBuilder)object3).append(string3);
                object9 = object.getClass().getSimpleName();
                ((StringBuilder)object3).append((String)object9);
                ((StringBuilder)object3).append(string2);
                object = Debug.getName(object);
                ((StringBuilder)object3).append((String)object);
                object3 = ((StringBuilder)object3).toString();
                Log.e((String)string4, (String)object3);
            }
        }
    }

    public void getAttributeNames(HashSet hashSet) {
    }

    public int getCurveFit() {
        return this.mCurveFit;
    }

    public void load(Context context, AttributeSet attributeSet) {
        int[] nArray = R$styleable.KeyTrigger;
        attributeSet = context.obtainStyledAttributes(attributeSet, nArray);
        KeyTrigger$Loader.read(this, (TypedArray)attributeSet, context);
    }

    public void setValue(String string2, Object object) {
    }
}

