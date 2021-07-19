/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.util.Log
 *  androidx.constraintlayout.motion.widget.TimeCycleSplineSet
 *  androidx.constraintlayout.motion.widget.TimeCycleSplineSet$CustomSet
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.KeyTimeCycle$Loader;
import androidx.constraintlayout.motion.widget.TimeCycleSplineSet;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class KeyTimeCycle
extends Key {
    public static final int KEY_TYPE = 3;
    public static final String NAME = "KeyTimeCycle";
    private static final String TAG = "KeyTimeCycle";
    private float mAlpha;
    private int mCurveFit = -1;
    private float mElevation;
    private float mProgress;
    private float mRotation;
    private float mRotationX;
    private float mRotationY;
    private float mScaleX;
    private float mScaleY;
    private String mTransitionEasing;
    private float mTransitionPathRotate;
    private float mTranslationX;
    private float mTranslationY;
    private float mTranslationZ;
    private float mWaveOffset;
    private float mWavePeriod;
    private int mWaveShape;

    public KeyTimeCycle() {
        HashMap hashMap;
        float f10;
        this.mAlpha = f10 = 0.0f / 0.0f;
        this.mElevation = f10;
        this.mRotation = f10;
        this.mRotationX = f10;
        this.mRotationY = f10;
        this.mTransitionPathRotate = f10;
        this.mScaleX = f10;
        this.mScaleY = f10;
        this.mTranslationX = f10;
        this.mTranslationY = f10;
        this.mTranslationZ = f10;
        this.mProgress = f10;
        this.mWaveShape = 0;
        this.mWavePeriod = f10;
        this.mWaveOffset = 0.0f;
        this.mType = 3;
        this.mCustomConstraints = hashMap = new HashMap();
    }

    public static /* synthetic */ float access$000(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mAlpha;
    }

    public static /* synthetic */ float access$002(KeyTimeCycle keyTimeCycle, float f10) {
        keyTimeCycle.mAlpha = f10;
        return f10;
    }

    public static /* synthetic */ float access$100(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mElevation;
    }

    public static /* synthetic */ String access$1002(KeyTimeCycle keyTimeCycle, String string2) {
        keyTimeCycle.mTransitionEasing = string2;
        return string2;
    }

    public static /* synthetic */ float access$102(KeyTimeCycle keyTimeCycle, float f10) {
        keyTimeCycle.mElevation = f10;
        return f10;
    }

    public static /* synthetic */ float access$1100(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mScaleY;
    }

    public static /* synthetic */ float access$1102(KeyTimeCycle keyTimeCycle, float f10) {
        keyTimeCycle.mScaleY = f10;
        return f10;
    }

    public static /* synthetic */ float access$1200(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mTransitionPathRotate;
    }

    public static /* synthetic */ float access$1202(KeyTimeCycle keyTimeCycle, float f10) {
        keyTimeCycle.mTransitionPathRotate = f10;
        return f10;
    }

    public static /* synthetic */ float access$1300(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mTranslationX;
    }

    public static /* synthetic */ float access$1302(KeyTimeCycle keyTimeCycle, float f10) {
        keyTimeCycle.mTranslationX = f10;
        return f10;
    }

    public static /* synthetic */ float access$1400(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mTranslationY;
    }

    public static /* synthetic */ float access$1402(KeyTimeCycle keyTimeCycle, float f10) {
        keyTimeCycle.mTranslationY = f10;
        return f10;
    }

    public static /* synthetic */ float access$1500(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mTranslationZ;
    }

    public static /* synthetic */ float access$1502(KeyTimeCycle keyTimeCycle, float f10) {
        keyTimeCycle.mTranslationZ = f10;
        return f10;
    }

    public static /* synthetic */ float access$1600(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mProgress;
    }

    public static /* synthetic */ float access$1602(KeyTimeCycle keyTimeCycle, float f10) {
        keyTimeCycle.mProgress = f10;
        return f10;
    }

    public static /* synthetic */ float access$200(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mRotation;
    }

    public static /* synthetic */ float access$202(KeyTimeCycle keyTimeCycle, float f10) {
        keyTimeCycle.mRotation = f10;
        return f10;
    }

    public static /* synthetic */ int access$300(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mCurveFit;
    }

    public static /* synthetic */ int access$302(KeyTimeCycle keyTimeCycle, int n10) {
        keyTimeCycle.mCurveFit = n10;
        return n10;
    }

    public static /* synthetic */ int access$400(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mWaveShape;
    }

    public static /* synthetic */ int access$402(KeyTimeCycle keyTimeCycle, int n10) {
        keyTimeCycle.mWaveShape = n10;
        return n10;
    }

    public static /* synthetic */ float access$500(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mWavePeriod;
    }

    public static /* synthetic */ float access$502(KeyTimeCycle keyTimeCycle, float f10) {
        keyTimeCycle.mWavePeriod = f10;
        return f10;
    }

    public static /* synthetic */ float access$600(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mWaveOffset;
    }

    public static /* synthetic */ float access$602(KeyTimeCycle keyTimeCycle, float f10) {
        keyTimeCycle.mWaveOffset = f10;
        return f10;
    }

    public static /* synthetic */ float access$700(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mScaleX;
    }

    public static /* synthetic */ float access$702(KeyTimeCycle keyTimeCycle, float f10) {
        keyTimeCycle.mScaleX = f10;
        return f10;
    }

    public static /* synthetic */ float access$800(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mRotationX;
    }

    public static /* synthetic */ float access$802(KeyTimeCycle keyTimeCycle, float f10) {
        keyTimeCycle.mRotationX = f10;
        return f10;
    }

    public static /* synthetic */ float access$900(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mRotationY;
    }

    public static /* synthetic */ float access$902(KeyTimeCycle keyTimeCycle, float f10) {
        keyTimeCycle.mRotationY = f10;
        return f10;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void addTimeValues(HashMap hashMap) {
        Iterator iterator2 = hashMap.keySet().iterator();
        block28: while (true) {
            float f10;
            int n10;
            float f11;
            float f12;
            float f13;
            int n11;
            TimeCycleSplineSet timeCycleSplineSet;
            Object object;
            String string2;
            boolean bl2;
            block32: {
                block33: {
                    int n12;
                    if (!(bl2 = iterator2.hasNext())) {
                        return;
                    }
                    string2 = (String)iterator2.next();
                    object = hashMap.get(string2);
                    Object v10 = object;
                    timeCycleSplineSet = (TimeCycleSplineSet)object;
                    object = "CUSTOM";
                    int n13 = string2.startsWith((String)object);
                    n11 = 7;
                    if (n13 != 0) {
                        string2 = string2.substring(n11);
                        object = this.mCustomConstraints;
                        string2 = ((HashMap)object).get(string2);
                        Object object2 = string2;
                        object2 = (ConstraintAttribute)((Object)string2);
                        if (object2 == null) continue;
                        TimeCycleSplineSet timeCycleSplineSet2 = timeCycleSplineSet;
                        TimeCycleSplineSet.CustomSet customSet = (TimeCycleSplineSet.CustomSet)timeCycleSplineSet;
                        n12 = this.mFramePosition;
                        float f14 = this.mWavePeriod;
                        int n14 = this.mWaveShape;
                        float f15 = this.mWaveOffset;
                        customSet.setPoint(n12, (ConstraintAttribute)object2, f14, n14, f15);
                        continue;
                    }
                    string2.hashCode();
                    n13 = -1;
                    n12 = string2.hashCode();
                    switch (n12) {
                        case 92909918: {
                            String string3 = "alpha";
                            n11 = (int)(string2.equals(string3) ? 1 : 0);
                            if (n11 == 0) break;
                            n11 = 11;
                            break block32;
                        }
                        case 37232917: {
                            String string4 = "transitionPathRotate";
                            n11 = (int)(string2.equals(string4) ? 1 : 0);
                            if (n11 == 0) break;
                            n11 = 10;
                            break block32;
                        }
                        case -4379043: {
                            String string5 = "elevation";
                            n11 = (int)(string2.equals(string5) ? 1 : 0);
                            if (n11 == 0) break;
                            n11 = 9;
                            break block32;
                        }
                        case -40300674: {
                            String string6 = "rotation";
                            n11 = (int)(string2.equals(string6) ? 1 : 0);
                            if (n11 == 0) break;
                            n11 = 8;
                            break block32;
                        }
                        case -908189617: {
                            String string7 = "scaleY";
                            n12 = (int)(string2.equals(string7) ? 1 : 0);
                            if (n12 == 0) {
                                break;
                            }
                            break block32;
                        }
                        case -908189618: {
                            String string8 = "scaleX";
                            n11 = (int)(string2.equals(string8) ? 1 : 0);
                            if (n11 == 0) break;
                            n11 = 6;
                            break block32;
                        }
                        case -1001078227: {
                            String string9 = "progress";
                            n11 = (int)(string2.equals(string9) ? 1 : 0);
                            if (n11 == 0) break;
                            n11 = 5;
                            break block32;
                        }
                        case -1225497655: {
                            String string10 = "translationZ";
                            n11 = (int)(string2.equals(string10) ? 1 : 0);
                            if (n11 == 0) break;
                            n11 = 4;
                            break block32;
                        }
                        case -1225497656: {
                            String string11 = "translationY";
                            n11 = (int)(string2.equals(string11) ? 1 : 0);
                            if (n11 == 0) break;
                            n11 = 3;
                            break block32;
                        }
                        case -1225497657: {
                            String string12 = "translationX";
                            n11 = (int)(string2.equals(string12) ? 1 : 0);
                            if (n11 == 0) break;
                            n11 = 2;
                            break block32;
                        }
                        case -1249320805: {
                            String string13 = "rotationY";
                            n11 = (int)(string2.equals(string13) ? 1 : 0);
                            if (n11 == 0) break;
                            n11 = 1;
                            break block32;
                        }
                        case -1249320806: {
                            String string14 = "rotationX";
                            n11 = (int)(string2.equals(string14) ? 1 : 0);
                            if (n11 != 0) break block33;
                        }
                    }
                    n11 = n13;
                    break block32;
                }
                n11 = 0;
                Object var10_27 = null;
            }
            switch (n11) {
                default: {
                    object = new StringBuilder();
                    String string15 = "UNKNOWN addValues \"";
                    ((StringBuilder)object).append(string15);
                    ((StringBuilder)object).append(string2);
                    ((StringBuilder)object).append("\"");
                    string2 = ((StringBuilder)object).toString();
                    object = "KeyTimeCycles";
                    Log.e((String)object, (String)string2);
                    continue block28;
                }
                case 11: {
                    f13 = this.mAlpha;
                    bl2 = Float.isNaN(f13);
                    if (bl2) continue block28;
                    n11 = this.mFramePosition;
                    f12 = this.mAlpha;
                    f11 = this.mWavePeriod;
                    n10 = this.mWaveShape;
                    f10 = this.mWaveOffset;
                    timeCycleSplineSet.setPoint(n11, f12, f11, n10, f10);
                    continue block28;
                }
                case 10: {
                    f13 = this.mTransitionPathRotate;
                    bl2 = Float.isNaN(f13);
                    if (bl2) continue block28;
                    n11 = this.mFramePosition;
                    f12 = this.mTransitionPathRotate;
                    f11 = this.mWavePeriod;
                    n10 = this.mWaveShape;
                    f10 = this.mWaveOffset;
                    timeCycleSplineSet.setPoint(n11, f12, f11, n10, f10);
                    continue block28;
                }
                case 9: {
                    f13 = this.mElevation;
                    bl2 = Float.isNaN(f13);
                    if (bl2) continue block28;
                    n11 = this.mFramePosition;
                    f12 = this.mElevation;
                    f11 = this.mWavePeriod;
                    n10 = this.mWaveShape;
                    f10 = this.mWaveOffset;
                    timeCycleSplineSet.setPoint(n11, f12, f11, n10, f10);
                    continue block28;
                }
                case 8: {
                    f13 = this.mRotation;
                    bl2 = Float.isNaN(f13);
                    if (bl2) continue block28;
                    n11 = this.mFramePosition;
                    f12 = this.mRotation;
                    f11 = this.mWavePeriod;
                    n10 = this.mWaveShape;
                    f10 = this.mWaveOffset;
                    timeCycleSplineSet.setPoint(n11, f12, f11, n10, f10);
                    continue block28;
                }
                case 7: {
                    f13 = this.mScaleY;
                    bl2 = Float.isNaN(f13);
                    if (bl2) continue block28;
                    n11 = this.mFramePosition;
                    f12 = this.mScaleY;
                    f11 = this.mWavePeriod;
                    n10 = this.mWaveShape;
                    f10 = this.mWaveOffset;
                    timeCycleSplineSet.setPoint(n11, f12, f11, n10, f10);
                    continue block28;
                }
                case 6: {
                    f13 = this.mScaleX;
                    bl2 = Float.isNaN(f13);
                    if (bl2) continue block28;
                    n11 = this.mFramePosition;
                    f12 = this.mScaleX;
                    f11 = this.mWavePeriod;
                    n10 = this.mWaveShape;
                    f10 = this.mWaveOffset;
                    timeCycleSplineSet.setPoint(n11, f12, f11, n10, f10);
                    continue block28;
                }
                case 5: {
                    f13 = this.mProgress;
                    bl2 = Float.isNaN(f13);
                    if (bl2) continue block28;
                    n11 = this.mFramePosition;
                    f12 = this.mProgress;
                    f11 = this.mWavePeriod;
                    n10 = this.mWaveShape;
                    f10 = this.mWaveOffset;
                    timeCycleSplineSet.setPoint(n11, f12, f11, n10, f10);
                    continue block28;
                }
                case 4: {
                    f13 = this.mTranslationZ;
                    bl2 = Float.isNaN(f13);
                    if (bl2) continue block28;
                    n11 = this.mFramePosition;
                    f12 = this.mTranslationZ;
                    f11 = this.mWavePeriod;
                    n10 = this.mWaveShape;
                    f10 = this.mWaveOffset;
                    timeCycleSplineSet.setPoint(n11, f12, f11, n10, f10);
                    continue block28;
                }
                case 3: {
                    f13 = this.mTranslationY;
                    bl2 = Float.isNaN(f13);
                    if (bl2) continue block28;
                    n11 = this.mFramePosition;
                    f12 = this.mTranslationY;
                    f11 = this.mWavePeriod;
                    n10 = this.mWaveShape;
                    f10 = this.mWaveOffset;
                    timeCycleSplineSet.setPoint(n11, f12, f11, n10, f10);
                    continue block28;
                }
                case 2: {
                    f13 = this.mTranslationX;
                    bl2 = Float.isNaN(f13);
                    if (bl2) continue block28;
                    n11 = this.mFramePosition;
                    f12 = this.mTranslationX;
                    f11 = this.mWavePeriod;
                    n10 = this.mWaveShape;
                    f10 = this.mWaveOffset;
                    timeCycleSplineSet.setPoint(n11, f12, f11, n10, f10);
                    continue block28;
                }
                case 1: {
                    f13 = this.mRotationY;
                    bl2 = Float.isNaN(f13);
                    if (bl2) continue block28;
                    n11 = this.mFramePosition;
                    f12 = this.mRotationY;
                    f11 = this.mWavePeriod;
                    n10 = this.mWaveShape;
                    f10 = this.mWaveOffset;
                    timeCycleSplineSet.setPoint(n11, f12, f11, n10, f10);
                    continue block28;
                }
                case 0: 
            }
            f13 = this.mRotationX;
            bl2 = Float.isNaN(f13);
            if (bl2) continue;
            n11 = this.mFramePosition;
            f12 = this.mRotationX;
            f11 = this.mWavePeriod;
            n10 = this.mWaveShape;
            f10 = this.mWaveOffset;
            timeCycleSplineSet.setPoint(n11, f12, f11, n10, f10);
        }
    }

    public void addValues(HashMap serializable) {
        serializable = new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
        throw serializable;
    }

    public void getAttributeNames(HashSet hashSet) {
        Iterator iterator2;
        float f10 = this.mAlpha;
        int n10 = Float.isNaN(f10);
        if (n10 == 0) {
            iterator2 = "alpha";
            hashSet.add(iterator2);
        }
        if ((n10 = Float.isNaN(f10 = this.mElevation)) == 0) {
            iterator2 = "elevation";
            hashSet.add(iterator2);
        }
        if ((n10 = Float.isNaN(f10 = this.mRotation)) == 0) {
            iterator2 = "rotation";
            hashSet.add(iterator2);
        }
        if ((n10 = Float.isNaN(f10 = this.mRotationX)) == 0) {
            iterator2 = "rotationX";
            hashSet.add(iterator2);
        }
        if ((n10 = Float.isNaN(f10 = this.mRotationY)) == 0) {
            iterator2 = "rotationY";
            hashSet.add(iterator2);
        }
        if ((n10 = Float.isNaN(f10 = this.mTranslationX)) == 0) {
            iterator2 = "translationX";
            hashSet.add(iterator2);
        }
        if ((n10 = Float.isNaN(f10 = this.mTranslationY)) == 0) {
            iterator2 = "translationY";
            hashSet.add(iterator2);
        }
        if ((n10 = Float.isNaN(f10 = this.mTranslationZ)) == 0) {
            iterator2 = "translationZ";
            hashSet.add(iterator2);
        }
        if ((n10 = Float.isNaN(f10 = this.mTransitionPathRotate)) == 0) {
            iterator2 = "transitionPathRotate";
            hashSet.add(iterator2);
        }
        if ((n10 = Float.isNaN(f10 = this.mScaleX)) == 0) {
            iterator2 = "scaleX";
            hashSet.add(iterator2);
        }
        if ((n10 = Float.isNaN(f10 = this.mScaleY)) == 0) {
            iterator2 = "scaleY";
            hashSet.add(iterator2);
        }
        if ((n10 = Float.isNaN(f10 = this.mProgress)) == 0) {
            iterator2 = "progress";
            hashSet.add(iterator2);
        }
        if ((n10 = ((HashMap)((Object)(iterator2 = this.mCustomConstraints))).size()) > 0) {
            boolean bl2;
            iterator2 = this.mCustomConstraints.keySet().iterator();
            while (bl2 = iterator2.hasNext()) {
                String string2 = (String)iterator2.next();
                StringBuilder stringBuilder = new StringBuilder();
                String string3 = "CUSTOM,";
                stringBuilder.append(string3);
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
                hashSet.add(string2);
            }
        }
    }

    public void load(Context context, AttributeSet attributeSet) {
        int[] nArray = R$styleable.KeyTimeCycle;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        KeyTimeCycle$Loader.read(this, (TypedArray)context);
    }

    public void setInterpolation(HashMap hashMap) {
        String string2;
        Object object;
        int n10 = this.mCurveFit;
        int n11 = -1;
        if (n10 == n11) {
            return;
        }
        float f10 = this.mAlpha;
        n10 = (int)(Float.isNaN(f10) ? 1 : 0);
        if (n10 == 0) {
            n10 = this.mCurveFit;
            object = n10;
            string2 = "alpha";
            hashMap.put(string2, object);
        }
        if ((n10 = (int)(Float.isNaN(f10 = this.mElevation) ? 1 : 0)) == 0) {
            n10 = this.mCurveFit;
            object = n10;
            string2 = "elevation";
            hashMap.put(string2, object);
        }
        if ((n10 = (int)(Float.isNaN(f10 = this.mRotation) ? 1 : 0)) == 0) {
            n10 = this.mCurveFit;
            object = n10;
            string2 = "rotation";
            hashMap.put(string2, object);
        }
        if ((n10 = (int)(Float.isNaN(f10 = this.mRotationX) ? 1 : 0)) == 0) {
            n10 = this.mCurveFit;
            object = n10;
            string2 = "rotationX";
            hashMap.put(string2, object);
        }
        if ((n10 = (int)(Float.isNaN(f10 = this.mRotationY) ? 1 : 0)) == 0) {
            n10 = this.mCurveFit;
            object = n10;
            string2 = "rotationY";
            hashMap.put(string2, object);
        }
        if ((n10 = (int)(Float.isNaN(f10 = this.mTranslationX) ? 1 : 0)) == 0) {
            n10 = this.mCurveFit;
            object = n10;
            string2 = "translationX";
            hashMap.put(string2, object);
        }
        if ((n10 = (int)(Float.isNaN(f10 = this.mTranslationY) ? 1 : 0)) == 0) {
            n10 = this.mCurveFit;
            object = n10;
            string2 = "translationY";
            hashMap.put(string2, object);
        }
        if ((n10 = (int)(Float.isNaN(f10 = this.mTranslationZ) ? 1 : 0)) == 0) {
            n10 = this.mCurveFit;
            object = n10;
            string2 = "translationZ";
            hashMap.put(string2, object);
        }
        if ((n10 = (int)(Float.isNaN(f10 = this.mTransitionPathRotate) ? 1 : 0)) == 0) {
            n10 = this.mCurveFit;
            object = n10;
            string2 = "transitionPathRotate";
            hashMap.put(string2, object);
        }
        if ((n10 = (int)(Float.isNaN(f10 = this.mScaleX) ? 1 : 0)) == 0) {
            n10 = this.mCurveFit;
            object = n10;
            string2 = "scaleX";
            hashMap.put(string2, object);
        }
        if ((n10 = (int)(Float.isNaN(f10 = this.mScaleX) ? 1 : 0)) == 0) {
            n10 = this.mCurveFit;
            object = n10;
            string2 = "scaleY";
            hashMap.put(string2, object);
        }
        if ((n10 = (int)(Float.isNaN(f10 = this.mProgress) ? 1 : 0)) == 0) {
            n10 = this.mCurveFit;
            object = n10;
            string2 = "progress";
            hashMap.put(string2, object);
        }
        if ((n10 = ((HashMap)(object = this.mCustomConstraints)).size()) > 0) {
            object = this.mCustomConstraints.keySet().iterator();
            while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                string2 = (String)object.next();
                Comparable<StringBuilder> comparable = new StringBuilder();
                String string3 = "CUSTOM,";
                comparable.append(string3);
                comparable.append(string2);
                string2 = comparable.toString();
                int n12 = this.mCurveFit;
                comparable = n12;
                hashMap.put(string2, comparable);
            }
        }
    }

    public void setValue(String string2, Object object) {
        int n10;
        string2.hashCode();
        int n11 = string2.hashCode();
        int n12 = -1;
        switch (n11) {
            default: {
                break;
            }
            case 1317633238: {
                String string3 = "mTranslationZ";
                n10 = string2.equals(string3);
                if (n10 == 0) break;
                n12 = 13;
                break;
            }
            case 579057826: {
                String string4 = "curveFit";
                n10 = string2.equals(string4);
                if (n10 == 0) break;
                n12 = 12;
                break;
            }
            case 92909918: {
                String string5 = "alpha";
                n10 = string2.equals(string5);
                if (n10 == 0) break;
                n12 = 11;
                break;
            }
            case 37232917: {
                String string6 = "transitionPathRotate";
                n10 = string2.equals(string6);
                if (n10 == 0) break;
                n12 = 10;
                break;
            }
            case -4379043: {
                String string7 = "elevation";
                n10 = string2.equals(string7);
                if (n10 == 0) break;
                n12 = 9;
                break;
            }
            case -40300674: {
                String string8 = "rotation";
                n10 = string2.equals(string8);
                if (n10 == 0) break;
                n12 = 8;
                break;
            }
            case -908189617: {
                String string9 = "scaleY";
                n10 = string2.equals(string9);
                if (n10 == 0) break;
                n12 = 7;
                break;
            }
            case -908189618: {
                String string10 = "scaleX";
                n10 = string2.equals(string10);
                if (n10 == 0) break;
                n12 = 6;
                break;
            }
            case -1001078227: {
                String string11 = "progress";
                n10 = string2.equals(string11);
                if (n10 == 0) break;
                n12 = 5;
                break;
            }
            case -1225497656: {
                String string12 = "translationY";
                n10 = string2.equals(string12);
                if (n10 == 0) break;
                n12 = 4;
                break;
            }
            case -1225497657: {
                String string13 = "translationX";
                n10 = string2.equals(string13);
                if (n10 == 0) break;
                n12 = 3;
                break;
            }
            case -1249320805: {
                String string14 = "rotationY";
                n10 = string2.equals(string14);
                if (n10 == 0) break;
                n12 = 2;
                break;
            }
            case -1249320806: {
                String string15 = "rotationX";
                n10 = string2.equals(string15);
                if (n10 == 0) break;
                n12 = 1;
                break;
            }
            case -1812823328: {
                String string16 = "transitionEasing";
                n10 = string2.equals(string16);
                if (n10 == 0) break;
                n12 = 0;
            }
        }
        switch (n12) {
            default: {
                break;
            }
            case 13: {
                float f10;
                this.mTranslationZ = f10 = this.toFloat(object);
                break;
            }
            case 12: {
                this.mCurveFit = n10 = this.toInt(object);
                break;
            }
            case 11: {
                float f11;
                this.mAlpha = f11 = this.toFloat(object);
                break;
            }
            case 10: {
                float f12;
                this.mTransitionPathRotate = f12 = this.toFloat(object);
                break;
            }
            case 9: {
                float f13;
                this.mElevation = f13 = this.toFloat(object);
                break;
            }
            case 8: {
                float f14;
                this.mRotation = f14 = this.toFloat(object);
                break;
            }
            case 7: {
                float f15;
                this.mScaleY = f15 = this.toFloat(object);
                break;
            }
            case 6: {
                float f16;
                this.mScaleX = f16 = this.toFloat(object);
                break;
            }
            case 5: {
                float f17;
                this.mProgress = f17 = this.toFloat(object);
                break;
            }
            case 4: {
                float f18;
                this.mTranslationY = f18 = this.toFloat(object);
                break;
            }
            case 3: {
                float f19;
                this.mTranslationX = f19 = this.toFloat(object);
                break;
            }
            case 2: {
                float f20;
                this.mRotationY = f20 = this.toFloat(object);
                break;
            }
            case 1: {
                float f21;
                this.mRotationX = f21 = this.toFloat(object);
                break;
            }
            case 0: {
                this.mTransitionEasing = string2 = object.toString();
            }
        }
    }
}

