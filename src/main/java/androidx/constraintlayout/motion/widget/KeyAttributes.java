/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.util.Log
 *  androidx.constraintlayout.motion.widget.SplineSet
 *  androidx.constraintlayout.motion.widget.SplineSet$CustomSet
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.KeyAttributes$Loader;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class KeyAttributes
extends Key {
    public static final int KEY_TYPE = 1;
    public static final String NAME = "KeyAttribute";
    private static final String TAG = "KeyAttribute";
    private float mAlpha;
    private int mCurveFit = -1;
    private float mElevation;
    private float mPivotX;
    private float mPivotY;
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
    private boolean mVisibility = false;

    public KeyAttributes() {
        HashMap hashMap;
        float f10;
        this.mAlpha = f10 = 0.0f / 0.0f;
        this.mElevation = f10;
        this.mRotation = f10;
        this.mRotationX = f10;
        this.mRotationY = f10;
        this.mPivotX = f10;
        this.mPivotY = f10;
        this.mTransitionPathRotate = f10;
        this.mScaleX = f10;
        this.mScaleY = f10;
        this.mTranslationX = f10;
        this.mTranslationY = f10;
        this.mTranslationZ = f10;
        this.mProgress = f10;
        this.mType = 1;
        this.mCustomConstraints = hashMap = new HashMap();
    }

    public static /* synthetic */ float access$000(KeyAttributes keyAttributes) {
        return keyAttributes.mAlpha;
    }

    public static /* synthetic */ float access$002(KeyAttributes keyAttributes, float f10) {
        keyAttributes.mAlpha = f10;
        return f10;
    }

    public static /* synthetic */ float access$100(KeyAttributes keyAttributes) {
        return keyAttributes.mElevation;
    }

    public static /* synthetic */ float access$1000(KeyAttributes keyAttributes) {
        return keyAttributes.mScaleY;
    }

    public static /* synthetic */ float access$1002(KeyAttributes keyAttributes, float f10) {
        keyAttributes.mScaleY = f10;
        return f10;
    }

    public static /* synthetic */ float access$102(KeyAttributes keyAttributes, float f10) {
        keyAttributes.mElevation = f10;
        return f10;
    }

    public static /* synthetic */ float access$1100(KeyAttributes keyAttributes) {
        return keyAttributes.mTransitionPathRotate;
    }

    public static /* synthetic */ float access$1102(KeyAttributes keyAttributes, float f10) {
        keyAttributes.mTransitionPathRotate = f10;
        return f10;
    }

    public static /* synthetic */ float access$1200(KeyAttributes keyAttributes) {
        return keyAttributes.mTranslationX;
    }

    public static /* synthetic */ float access$1202(KeyAttributes keyAttributes, float f10) {
        keyAttributes.mTranslationX = f10;
        return f10;
    }

    public static /* synthetic */ float access$1300(KeyAttributes keyAttributes) {
        return keyAttributes.mTranslationY;
    }

    public static /* synthetic */ float access$1302(KeyAttributes keyAttributes, float f10) {
        keyAttributes.mTranslationY = f10;
        return f10;
    }

    public static /* synthetic */ float access$1400(KeyAttributes keyAttributes) {
        return keyAttributes.mTranslationZ;
    }

    public static /* synthetic */ float access$1402(KeyAttributes keyAttributes, float f10) {
        keyAttributes.mTranslationZ = f10;
        return f10;
    }

    public static /* synthetic */ float access$1500(KeyAttributes keyAttributes) {
        return keyAttributes.mProgress;
    }

    public static /* synthetic */ float access$1502(KeyAttributes keyAttributes, float f10) {
        keyAttributes.mProgress = f10;
        return f10;
    }

    public static /* synthetic */ float access$200(KeyAttributes keyAttributes) {
        return keyAttributes.mRotation;
    }

    public static /* synthetic */ float access$202(KeyAttributes keyAttributes, float f10) {
        keyAttributes.mRotation = f10;
        return f10;
    }

    public static /* synthetic */ int access$300(KeyAttributes keyAttributes) {
        return keyAttributes.mCurveFit;
    }

    public static /* synthetic */ int access$302(KeyAttributes keyAttributes, int n10) {
        keyAttributes.mCurveFit = n10;
        return n10;
    }

    public static /* synthetic */ float access$400(KeyAttributes keyAttributes) {
        return keyAttributes.mScaleX;
    }

    public static /* synthetic */ float access$402(KeyAttributes keyAttributes, float f10) {
        keyAttributes.mScaleX = f10;
        return f10;
    }

    public static /* synthetic */ float access$500(KeyAttributes keyAttributes) {
        return keyAttributes.mRotationX;
    }

    public static /* synthetic */ float access$502(KeyAttributes keyAttributes, float f10) {
        keyAttributes.mRotationX = f10;
        return f10;
    }

    public static /* synthetic */ float access$600(KeyAttributes keyAttributes) {
        return keyAttributes.mRotationY;
    }

    public static /* synthetic */ float access$602(KeyAttributes keyAttributes, float f10) {
        keyAttributes.mRotationY = f10;
        return f10;
    }

    public static /* synthetic */ float access$700(KeyAttributes keyAttributes) {
        return keyAttributes.mPivotX;
    }

    public static /* synthetic */ float access$702(KeyAttributes keyAttributes, float f10) {
        keyAttributes.mPivotX = f10;
        return f10;
    }

    public static /* synthetic */ float access$800(KeyAttributes keyAttributes) {
        return keyAttributes.mPivotY;
    }

    public static /* synthetic */ float access$802(KeyAttributes keyAttributes, float f10) {
        keyAttributes.mPivotY = f10;
        return f10;
    }

    public static /* synthetic */ String access$902(KeyAttributes keyAttributes, String string2) {
        keyAttributes.mTransitionEasing = string2;
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void addValues(HashMap hashMap) {
        Iterator iterator2 = hashMap.keySet().iterator();
        block32: while (true) {
            float f10;
            float f11;
            int n10;
            Object object;
            Object object2;
            Object object3;
            int n11;
            block36: {
                String string2;
                block37: {
                    if ((n11 = iterator2.hasNext()) == 0) {
                        return;
                    }
                    object3 = (String)iterator2.next();
                    object2 = (SplineSet)hashMap.get(object3);
                    object = "CUSTOM";
                    int n12 = ((String)object3).startsWith((String)object);
                    n10 = 7;
                    if (n12 != 0) {
                        object3 = ((String)object3).substring(n10);
                        object = this.mCustomConstraints;
                        if ((object3 = (ConstraintAttribute)((HashMap)object).get(object3)) == null) continue;
                        object2 = (SplineSet.CustomSet)object2;
                        n12 = this.mFramePosition;
                        object2.setPoint(n12, (ConstraintAttribute)object3);
                        continue;
                    }
                    ((String)object3).hashCode();
                    n12 = -1;
                    f11 = 0.0f / 0.0f;
                    int n13 = ((String)object3).hashCode();
                    switch (n13) {
                        case 92909918: {
                            string2 = "alpha";
                            n10 = (int)(((String)object3).equals(string2) ? 1 : 0);
                            if (n10 == 0) break;
                            n10 = 13;
                            break block36;
                        }
                        case 37232917: {
                            string2 = "transitionPathRotate";
                            n10 = (int)(((String)object3).equals(string2) ? 1 : 0);
                            if (n10 == 0) break;
                            n10 = 12;
                            break block36;
                        }
                        case -4379043: {
                            string2 = "elevation";
                            n10 = (int)(((String)object3).equals(string2) ? 1 : 0);
                            if (n10 == 0) break;
                            n10 = 11;
                            break block36;
                        }
                        case -40300674: {
                            string2 = "rotation";
                            n10 = (int)(((String)object3).equals(string2) ? 1 : 0);
                            if (n10 == 0) break;
                            n10 = 10;
                            break block36;
                        }
                        case -760884509: {
                            string2 = "transformPivotY";
                            n10 = (int)(((String)object3).equals(string2) ? 1 : 0);
                            if (n10 == 0) break;
                            n10 = 9;
                            break block36;
                        }
                        case -760884510: {
                            string2 = "transformPivotX";
                            n10 = (int)(((String)object3).equals(string2) ? 1 : 0);
                            if (n10 == 0) break;
                            n10 = 8;
                            break block36;
                        }
                        case -908189617: {
                            String string3 = "scaleY";
                            n13 = (int)(((String)object3).equals(string3) ? 1 : 0);
                            if (n13 == 0) {
                                break;
                            }
                            break block36;
                        }
                        case -908189618: {
                            string2 = "scaleX";
                            n10 = (int)(((String)object3).equals(string2) ? 1 : 0);
                            if (n10 == 0) break;
                            n10 = 6;
                            break block36;
                        }
                        case -1001078227: {
                            string2 = "progress";
                            n10 = (int)(((String)object3).equals(string2) ? 1 : 0);
                            if (n10 == 0) break;
                            n10 = 5;
                            break block36;
                        }
                        case -1225497655: {
                            string2 = "translationZ";
                            n10 = (int)(((String)object3).equals(string2) ? 1 : 0);
                            if (n10 == 0) break;
                            n10 = 4;
                            break block36;
                        }
                        case -1225497656: {
                            string2 = "translationY";
                            n10 = (int)(((String)object3).equals(string2) ? 1 : 0);
                            if (n10 == 0) break;
                            n10 = 3;
                            break block36;
                        }
                        case -1225497657: {
                            string2 = "translationX";
                            n10 = (int)(((String)object3).equals(string2) ? 1 : 0);
                            if (n10 == 0) break;
                            n10 = 2;
                            break block36;
                        }
                        case -1249320805: {
                            string2 = "rotationY";
                            n10 = (int)(((String)object3).equals(string2) ? 1 : 0);
                            if (n10 == 0) break;
                            n10 = 1;
                            break block36;
                        }
                        case -1249320806: {
                            string2 = "rotationX";
                            n10 = (int)(((String)object3).equals(string2) ? 1 : 0);
                            if (n10 != 0) break block37;
                        }
                    }
                    n10 = n12;
                    break block36;
                }
                n10 = 0;
                string2 = null;
            }
            switch (n10) {
                default: {
                    object2 = new StringBuilder();
                    object = "UNKNOWN addValues \"";
                    ((StringBuilder)object2).append((String)object);
                    ((StringBuilder)object2).append((String)object3);
                    ((StringBuilder)object2).append("\"");
                    object3 = ((StringBuilder)object2).toString();
                    object2 = "KeyAttributes";
                    Log.v((String)object2, (String)object3);
                    continue block32;
                }
                case 13: {
                    f10 = this.mAlpha;
                    n11 = Float.isNaN(f10);
                    if (n11 != 0) continue block32;
                    n11 = this.mFramePosition;
                    f11 = this.mAlpha;
                    object2.setPoint(n11, f11);
                    continue block32;
                }
                case 12: {
                    f10 = this.mTransitionPathRotate;
                    n11 = Float.isNaN(f10);
                    if (n11 != 0) continue block32;
                    n11 = this.mFramePosition;
                    f11 = this.mTransitionPathRotate;
                    object2.setPoint(n11, f11);
                    continue block32;
                }
                case 11: {
                    f10 = this.mElevation;
                    n11 = Float.isNaN(f10);
                    if (n11 != 0) continue block32;
                    n11 = this.mFramePosition;
                    f11 = this.mElevation;
                    object2.setPoint(n11, f11);
                    continue block32;
                }
                case 10: {
                    f10 = this.mRotation;
                    n11 = Float.isNaN(f10);
                    if (n11 != 0) continue block32;
                    n11 = this.mFramePosition;
                    f11 = this.mRotation;
                    object2.setPoint(n11, f11);
                    continue block32;
                }
                case 9: {
                    f10 = this.mRotationY;
                    n11 = Float.isNaN(f10);
                    if (n11 != 0) continue block32;
                    n11 = this.mFramePosition;
                    f11 = this.mPivotY;
                    object2.setPoint(n11, f11);
                    continue block32;
                }
                case 8: {
                    f10 = this.mRotationX;
                    n11 = Float.isNaN(f10);
                    if (n11 != 0) continue block32;
                    n11 = this.mFramePosition;
                    f11 = this.mPivotX;
                    object2.setPoint(n11, f11);
                    continue block32;
                }
                case 7: {
                    f10 = this.mScaleY;
                    n11 = Float.isNaN(f10);
                    if (n11 != 0) continue block32;
                    n11 = this.mFramePosition;
                    f11 = this.mScaleY;
                    object2.setPoint(n11, f11);
                    continue block32;
                }
                case 6: {
                    f10 = this.mScaleX;
                    n11 = Float.isNaN(f10);
                    if (n11 != 0) continue block32;
                    n11 = this.mFramePosition;
                    f11 = this.mScaleX;
                    object2.setPoint(n11, f11);
                    continue block32;
                }
                case 5: {
                    f10 = this.mProgress;
                    n11 = Float.isNaN(f10);
                    if (n11 != 0) continue block32;
                    n11 = this.mFramePosition;
                    f11 = this.mProgress;
                    object2.setPoint(n11, f11);
                    continue block32;
                }
                case 4: {
                    f10 = this.mTranslationZ;
                    n11 = Float.isNaN(f10);
                    if (n11 != 0) continue block32;
                    n11 = this.mFramePosition;
                    f11 = this.mTranslationZ;
                    object2.setPoint(n11, f11);
                    continue block32;
                }
                case 3: {
                    f10 = this.mTranslationY;
                    n11 = Float.isNaN(f10);
                    if (n11 != 0) continue block32;
                    n11 = this.mFramePosition;
                    f11 = this.mTranslationY;
                    object2.setPoint(n11, f11);
                    continue block32;
                }
                case 2: {
                    f10 = this.mTranslationX;
                    n11 = Float.isNaN(f10);
                    if (n11 != 0) continue block32;
                    n11 = this.mFramePosition;
                    f11 = this.mTranslationX;
                    object2.setPoint(n11, f11);
                    continue block32;
                }
                case 1: {
                    f10 = this.mRotationY;
                    n11 = Float.isNaN(f10);
                    if (n11 != 0) continue block32;
                    n11 = this.mFramePosition;
                    f11 = this.mRotationY;
                    object2.setPoint(n11, f11);
                    continue block32;
                }
                case 0: 
            }
            f10 = this.mRotationX;
            n11 = Float.isNaN(f10);
            if (n11 != 0) continue;
            n11 = this.mFramePosition;
            f11 = this.mRotationX;
            object2.setPoint(n11, f11);
        }
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
        if ((n10 = Float.isNaN(f10 = this.mPivotX)) == 0) {
            iterator2 = "transformPivotX";
            hashSet.add(iterator2);
        }
        if ((n10 = Float.isNaN(f10 = this.mPivotY)) == 0) {
            iterator2 = "transformPivotY";
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

    public int getCurveFit() {
        return this.mCurveFit;
    }

    public void load(Context context, AttributeSet attributeSet) {
        int[] nArray = R$styleable.KeyAttribute;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        KeyAttributes$Loader.read(this, (TypedArray)context);
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
        if ((n10 = (int)(Float.isNaN(f10 = this.mPivotX) ? 1 : 0)) == 0) {
            n10 = this.mCurveFit;
            object = n10;
            string2 = "transformPivotX";
            hashMap.put(string2, object);
        }
        if ((n10 = (int)(Float.isNaN(f10 = this.mPivotY) ? 1 : 0)) == 0) {
            n10 = this.mCurveFit;
            object = n10;
            string2 = "transformPivotY";
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
        if ((n10 = (int)(Float.isNaN(f10 = this.mScaleY) ? 1 : 0)) == 0) {
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
            case 1941332754: {
                String string3 = "visibility";
                n10 = string2.equals(string3);
                if (n10 == 0) break;
                n12 = 16;
                break;
            }
            case 1317633238: {
                String string4 = "mTranslationZ";
                n10 = string2.equals(string4);
                if (n10 == 0) break;
                n12 = 15;
                break;
            }
            case 579057826: {
                String string5 = "curveFit";
                n10 = string2.equals(string5);
                if (n10 == 0) break;
                n12 = 14;
                break;
            }
            case 92909918: {
                String string6 = "alpha";
                n10 = string2.equals(string6);
                if (n10 == 0) break;
                n12 = 13;
                break;
            }
            case 37232917: {
                String string7 = "transitionPathRotate";
                n10 = string2.equals(string7);
                if (n10 == 0) break;
                n12 = 12;
                break;
            }
            case -4379043: {
                String string8 = "elevation";
                n10 = string2.equals(string8);
                if (n10 == 0) break;
                n12 = 11;
                break;
            }
            case -40300674: {
                String string9 = "rotation";
                n10 = string2.equals(string9);
                if (n10 == 0) break;
                n12 = 10;
                break;
            }
            case -908189617: {
                String string10 = "scaleY";
                n10 = string2.equals(string10);
                if (n10 == 0) break;
                n12 = 9;
                break;
            }
            case -908189618: {
                String string11 = "scaleX";
                n10 = string2.equals(string11);
                if (n10 == 0) break;
                n12 = 8;
                break;
            }
            case -987906985: {
                String string12 = "pivotY";
                n10 = string2.equals(string12);
                if (n10 == 0) break;
                n12 = 7;
                break;
            }
            case -987906986: {
                String string13 = "pivotX";
                n10 = string2.equals(string13);
                if (n10 == 0) break;
                n12 = 6;
                break;
            }
            case -1225497656: {
                String string14 = "translationY";
                n10 = string2.equals(string14);
                if (n10 == 0) break;
                n12 = 5;
                break;
            }
            case -1225497657: {
                String string15 = "translationX";
                n10 = string2.equals(string15);
                if (n10 == 0) break;
                n12 = 4;
                break;
            }
            case -1249320805: {
                String string16 = "rotationY";
                n10 = string2.equals(string16);
                if (n10 == 0) break;
                n12 = 3;
                break;
            }
            case -1249320806: {
                String string17 = "rotationX";
                n10 = string2.equals(string17);
                if (n10 == 0) break;
                n12 = 2;
                break;
            }
            case -1812823328: {
                String string18 = "transitionEasing";
                n10 = string2.equals(string18);
                if (n10 == 0) break;
                n12 = 1;
                break;
            }
            case -1913008125: {
                String string19 = "motionProgress";
                n10 = string2.equals(string19);
                if (n10 == 0) break;
                n12 = 0;
            }
        }
        switch (n12) {
            default: {
                break;
            }
            case 16: {
                n10 = this.toBoolean(object);
                this.mVisibility = n10;
                break;
            }
            case 15: {
                float f10;
                this.mTranslationZ = f10 = this.toFloat(object);
                break;
            }
            case 14: {
                this.mCurveFit = n10 = this.toInt(object);
                break;
            }
            case 13: {
                float f11;
                this.mAlpha = f11 = this.toFloat(object);
                break;
            }
            case 12: {
                float f12;
                this.mTransitionPathRotate = f12 = this.toFloat(object);
                break;
            }
            case 11: {
                float f13;
                this.mElevation = f13 = this.toFloat(object);
                break;
            }
            case 10: {
                float f14;
                this.mRotation = f14 = this.toFloat(object);
                break;
            }
            case 9: {
                float f15;
                this.mScaleY = f15 = this.toFloat(object);
                break;
            }
            case 8: {
                float f16;
                this.mScaleX = f16 = this.toFloat(object);
                break;
            }
            case 7: {
                float f17;
                this.mPivotY = f17 = this.toFloat(object);
                break;
            }
            case 6: {
                float f18;
                this.mPivotX = f18 = this.toFloat(object);
                break;
            }
            case 5: {
                float f19;
                this.mTranslationY = f19 = this.toFloat(object);
                break;
            }
            case 4: {
                float f20;
                this.mTranslationX = f20 = this.toFloat(object);
                break;
            }
            case 3: {
                float f21;
                this.mRotationY = f21 = this.toFloat(object);
                break;
            }
            case 2: {
                float f22;
                this.mRotationX = f22 = this.toFloat(object);
                break;
            }
            case 1: {
                this.mTransitionEasing = string2 = object.toString();
                break;
            }
            case 0: {
                float f23;
                this.mProgress = f23 = this.toFloat(object);
            }
        }
    }
}

