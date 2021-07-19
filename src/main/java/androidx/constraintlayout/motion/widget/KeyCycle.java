/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.util.Log
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator
 *  androidx.constraintlayout.motion.widget.SplineSet
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.KeyCycle$Loader;
import androidx.constraintlayout.motion.widget.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintAttribute$AttributeType;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class KeyCycle
extends Key {
    public static final int KEY_TYPE = 4;
    public static final String NAME = "KeyCycle";
    private static final String TAG = "KeyCycle";
    private float mAlpha;
    private int mCurveFit = 0;
    private float mElevation;
    private float mProgress;
    private float mRotation;
    private float mRotationX;
    private float mRotationY;
    private float mScaleX;
    private float mScaleY;
    private String mTransitionEasing = null;
    private float mTransitionPathRotate;
    private float mTranslationX;
    private float mTranslationY;
    private float mTranslationZ;
    private float mWaveOffset;
    private float mWavePeriod;
    private int mWaveShape;
    private int mWaveVariesBy;

    public KeyCycle() {
        HashMap hashMap;
        float f10;
        int n10;
        this.mWaveShape = n10 = -1;
        this.mWavePeriod = f10 = 0.0f / 0.0f;
        this.mWaveOffset = 0.0f;
        this.mProgress = f10;
        this.mWaveVariesBy = n10;
        this.mAlpha = f10;
        this.mElevation = f10;
        this.mRotation = f10;
        this.mTransitionPathRotate = f10;
        this.mRotationX = f10;
        this.mRotationY = f10;
        this.mScaleX = f10;
        this.mScaleY = f10;
        this.mTranslationX = f10;
        this.mTranslationY = f10;
        this.mTranslationZ = f10;
        this.mType = 4;
        this.mCustomConstraints = hashMap = new HashMap();
    }

    public static /* synthetic */ float access$1000(KeyCycle keyCycle) {
        return keyCycle.mRotationX;
    }

    public static /* synthetic */ float access$1002(KeyCycle keyCycle, float f10) {
        keyCycle.mRotationX = f10;
        return f10;
    }

    public static /* synthetic */ String access$102(KeyCycle keyCycle, String string2) {
        keyCycle.mTransitionEasing = string2;
        return string2;
    }

    public static /* synthetic */ float access$1100(KeyCycle keyCycle) {
        return keyCycle.mRotationY;
    }

    public static /* synthetic */ float access$1102(KeyCycle keyCycle, float f10) {
        keyCycle.mRotationY = f10;
        return f10;
    }

    public static /* synthetic */ float access$1200(KeyCycle keyCycle) {
        return keyCycle.mTransitionPathRotate;
    }

    public static /* synthetic */ float access$1202(KeyCycle keyCycle, float f10) {
        keyCycle.mTransitionPathRotate = f10;
        return f10;
    }

    public static /* synthetic */ float access$1300(KeyCycle keyCycle) {
        return keyCycle.mScaleX;
    }

    public static /* synthetic */ float access$1302(KeyCycle keyCycle, float f10) {
        keyCycle.mScaleX = f10;
        return f10;
    }

    public static /* synthetic */ float access$1400(KeyCycle keyCycle) {
        return keyCycle.mScaleY;
    }

    public static /* synthetic */ float access$1402(KeyCycle keyCycle, float f10) {
        keyCycle.mScaleY = f10;
        return f10;
    }

    public static /* synthetic */ float access$1500(KeyCycle keyCycle) {
        return keyCycle.mTranslationX;
    }

    public static /* synthetic */ float access$1502(KeyCycle keyCycle, float f10) {
        keyCycle.mTranslationX = f10;
        return f10;
    }

    public static /* synthetic */ float access$1600(KeyCycle keyCycle) {
        return keyCycle.mTranslationY;
    }

    public static /* synthetic */ float access$1602(KeyCycle keyCycle, float f10) {
        keyCycle.mTranslationY = f10;
        return f10;
    }

    public static /* synthetic */ float access$1700(KeyCycle keyCycle) {
        return keyCycle.mTranslationZ;
    }

    public static /* synthetic */ float access$1702(KeyCycle keyCycle, float f10) {
        keyCycle.mTranslationZ = f10;
        return f10;
    }

    public static /* synthetic */ float access$1800(KeyCycle keyCycle) {
        return keyCycle.mProgress;
    }

    public static /* synthetic */ float access$1802(KeyCycle keyCycle, float f10) {
        keyCycle.mProgress = f10;
        return f10;
    }

    public static /* synthetic */ int access$200(KeyCycle keyCycle) {
        return keyCycle.mCurveFit;
    }

    public static /* synthetic */ int access$202(KeyCycle keyCycle, int n10) {
        keyCycle.mCurveFit = n10;
        return n10;
    }

    public static /* synthetic */ int access$300(KeyCycle keyCycle) {
        return keyCycle.mWaveShape;
    }

    public static /* synthetic */ int access$302(KeyCycle keyCycle, int n10) {
        keyCycle.mWaveShape = n10;
        return n10;
    }

    public static /* synthetic */ float access$400(KeyCycle keyCycle) {
        return keyCycle.mWavePeriod;
    }

    public static /* synthetic */ float access$402(KeyCycle keyCycle, float f10) {
        keyCycle.mWavePeriod = f10;
        return f10;
    }

    public static /* synthetic */ float access$500(KeyCycle keyCycle) {
        return keyCycle.mWaveOffset;
    }

    public static /* synthetic */ float access$502(KeyCycle keyCycle, float f10) {
        keyCycle.mWaveOffset = f10;
        return f10;
    }

    public static /* synthetic */ int access$600(KeyCycle keyCycle) {
        return keyCycle.mWaveVariesBy;
    }

    public static /* synthetic */ int access$602(KeyCycle keyCycle, int n10) {
        keyCycle.mWaveVariesBy = n10;
        return n10;
    }

    public static /* synthetic */ float access$700(KeyCycle keyCycle) {
        return keyCycle.mAlpha;
    }

    public static /* synthetic */ float access$702(KeyCycle keyCycle, float f10) {
        keyCycle.mAlpha = f10;
        return f10;
    }

    public static /* synthetic */ float access$800(KeyCycle keyCycle) {
        return keyCycle.mElevation;
    }

    public static /* synthetic */ float access$802(KeyCycle keyCycle, float f10) {
        keyCycle.mElevation = f10;
        return f10;
    }

    public static /* synthetic */ float access$900(KeyCycle keyCycle) {
        return keyCycle.mRotation;
    }

    public static /* synthetic */ float access$902(KeyCycle keyCycle, float f10) {
        keyCycle.mRotation = f10;
        return f10;
    }

    public void addCycleValues(HashMap hashMap) {
        int n10;
        KeyCycle keyCycle = this;
        HashMap hashMap2 = hashMap;
        Iterator iterator2 = hashMap.keySet().iterator();
        while ((n10 = iterator2.hasNext()) != 0) {
            float f10;
            Object object;
            String string2 = (String)iterator2.next();
            int n11 = string2.startsWith((String)(object = "CUSTOM"));
            if (n11 != 0) {
                n11 = 7;
                f10 = 9.8E-45f;
                object = string2.substring(n11);
                Object object2 = keyCycle.mCustomConstraints;
                object = object2.get(object);
                Object object3 = object;
                object3 = (ConstraintAttribute)object;
                if (object3 == null || (object = ((ConstraintAttribute)object3).getType()) != (object2 = ConstraintAttribute$AttributeType.FLOAT_TYPE)) continue;
                string2 = hashMap2.get(string2);
                object2 = string2;
                object2 = (KeyCycleOscillator)string2;
                int n12 = keyCycle.mFramePosition;
                int n13 = keyCycle.mWaveShape;
                int n14 = keyCycle.mWaveVariesBy;
                float f11 = keyCycle.mWavePeriod;
                float f12 = keyCycle.mWaveOffset;
                float f13 = ((ConstraintAttribute)object3).getValueToInterpolate();
                object2.setPoint(n12, n13, n14, f11, f12, f13, (ConstraintAttribute)object3);
                continue;
            }
            float f14 = keyCycle.getValue(string2);
            n11 = (int)(Float.isNaN(f14) ? 1 : 0);
            if (n11 != 0) continue;
            String string3 = string2 = hashMap2.get(string2);
            string3 = (KeyCycleOscillator)string2;
            int n15 = keyCycle.mFramePosition;
            int n16 = keyCycle.mWaveShape;
            n10 = keyCycle.mWaveVariesBy;
            f10 = keyCycle.mWavePeriod;
            float f15 = keyCycle.mWaveOffset;
            string3.setPoint(n15, n16, n10, f10, f15, f14);
        }
    }

    public void addValues(HashMap hashMap) {
        int n10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("add ");
        int n11 = hashMap.size();
        ((StringBuilder)object).append(n11);
        ((StringBuilder)object).append(" values");
        object = ((StringBuilder)object).toString();
        String string2 = "KeyCycle";
        int n12 = 2;
        float f10 = 2.8E-45f;
        Debug.logStack(string2, (String)object, n12);
        object = hashMap.keySet().iterator();
        block30: while ((n10 = object.hasNext()) != 0) {
            String string3;
            String string4 = (String)object.next();
            Object object2 = (SplineSet)hashMap.get(string4);
            string4.hashCode();
            int n13 = -1;
            float f11 = 0.0f / 0.0f;
            int n14 = string4.hashCode();
            switch (n14) {
                default: {
                    break;
                }
                case 156108012: {
                    String string5 = "waveOffset";
                    n14 = (int)(string4.equals(string5) ? 1 : 0);
                    if (n14 == 0) break;
                    n13 = 12;
                    f11 = 1.7E-44f;
                    break;
                }
                case 92909918: {
                    String string5 = "alpha";
                    n14 = (int)(string4.equals(string5) ? 1 : 0);
                    if (n14 == 0) break;
                    n13 = 11;
                    f11 = 1.5E-44f;
                    break;
                }
                case 37232917: {
                    String string5 = "transitionPathRotate";
                    n14 = (int)(string4.equals(string5) ? 1 : 0);
                    if (n14 == 0) break;
                    n13 = 10;
                    f11 = 1.4E-44f;
                    break;
                }
                case -4379043: {
                    String string5 = "elevation";
                    n14 = (int)(string4.equals(string5) ? 1 : 0);
                    if (n14 == 0) break;
                    n13 = 9;
                    f11 = 1.3E-44f;
                    break;
                }
                case -40300674: {
                    String string5 = "rotation";
                    n14 = (int)(string4.equals(string5) ? 1 : 0);
                    if (n14 == 0) break;
                    n13 = 8;
                    f11 = 1.1E-44f;
                    break;
                }
                case -908189617: {
                    String string5 = "scaleY";
                    n14 = (int)(string4.equals(string5) ? 1 : 0);
                    if (n14 == 0) break;
                    n13 = 7;
                    f11 = 9.8E-45f;
                    break;
                }
                case -908189618: {
                    String string5 = "scaleX";
                    n14 = (int)(string4.equals(string5) ? 1 : 0);
                    if (n14 == 0) break;
                    n13 = 6;
                    f11 = 8.4E-45f;
                    break;
                }
                case -1001078227: {
                    String string5 = "progress";
                    n14 = (int)(string4.equals(string5) ? 1 : 0);
                    if (n14 == 0) break;
                    n13 = 5;
                    f11 = 7.0E-45f;
                    break;
                }
                case -1225497655: {
                    String string5 = "translationZ";
                    n14 = (int)(string4.equals(string5) ? 1 : 0);
                    if (n14 == 0) break;
                    n13 = 4;
                    f11 = 5.6E-45f;
                    break;
                }
                case -1225497656: {
                    String string5 = "translationY";
                    n14 = (int)(string4.equals(string5) ? 1 : 0);
                    if (n14 == 0) break;
                    n13 = 3;
                    f11 = 4.2E-45f;
                    break;
                }
                case -1225497657: {
                    String string5 = "translationX";
                    n14 = (int)(string4.equals(string5) ? 1 : 0);
                    if (n14 == 0) break;
                    n13 = n12;
                    f11 = f10;
                    break;
                }
                case -1249320805: {
                    String string5 = "rotationY";
                    n14 = (int)(string4.equals(string5) ? 1 : 0);
                    if (n14 == 0) break;
                    n13 = 1;
                    f11 = Float.MIN_VALUE;
                    break;
                }
                case -1249320806: {
                    String string5 = "rotationX";
                    n14 = (int)(string4.equals(string5) ? 1 : 0);
                    if (n14 == 0) break;
                    n13 = 0;
                    f11 = 0.0f;
                    string3 = null;
                }
            }
            switch (n13) {
                default: {
                    object2 = new StringBuilder();
                    string3 = "WARNING KeyCycle UNKNOWN  ";
                    ((StringBuilder)object2).append(string3);
                    ((StringBuilder)object2).append(string4);
                    string4 = ((StringBuilder)object2).toString();
                    Log.v((String)string2, (String)string4);
                    continue block30;
                }
                case 12: {
                    n10 = this.mFramePosition;
                    f11 = this.mWaveOffset;
                    object2.setPoint(n10, f11);
                    continue block30;
                }
                case 11: {
                    n10 = this.mFramePosition;
                    f11 = this.mAlpha;
                    object2.setPoint(n10, f11);
                    continue block30;
                }
                case 10: {
                    n10 = this.mFramePosition;
                    f11 = this.mTransitionPathRotate;
                    object2.setPoint(n10, f11);
                    continue block30;
                }
                case 9: {
                    n10 = this.mFramePosition;
                    f11 = this.mElevation;
                    object2.setPoint(n10, f11);
                    continue block30;
                }
                case 8: {
                    n10 = this.mFramePosition;
                    f11 = this.mRotation;
                    object2.setPoint(n10, f11);
                    continue block30;
                }
                case 7: {
                    n10 = this.mFramePosition;
                    f11 = this.mScaleY;
                    object2.setPoint(n10, f11);
                    continue block30;
                }
                case 6: {
                    n10 = this.mFramePosition;
                    f11 = this.mScaleX;
                    object2.setPoint(n10, f11);
                    continue block30;
                }
                case 5: {
                    n10 = this.mFramePosition;
                    f11 = this.mProgress;
                    object2.setPoint(n10, f11);
                    continue block30;
                }
                case 4: {
                    n10 = this.mFramePosition;
                    f11 = this.mTranslationZ;
                    object2.setPoint(n10, f11);
                    continue block30;
                }
                case 3: {
                    n10 = this.mFramePosition;
                    f11 = this.mTranslationY;
                    object2.setPoint(n10, f11);
                    continue block30;
                }
                case 2: {
                    n10 = this.mFramePosition;
                    f11 = this.mTranslationX;
                    object2.setPoint(n10, f11);
                    continue block30;
                }
                case 1: {
                    n10 = this.mFramePosition;
                    f11 = this.mRotationY;
                    object2.setPoint(n10, f11);
                    continue block30;
                }
                case 0: 
            }
            n10 = this.mFramePosition;
            f11 = this.mRotationX;
            object2.setPoint(n10, f11);
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
        if ((n10 = Float.isNaN(f10 = this.mScaleX)) == 0) {
            iterator2 = "scaleX";
            hashSet.add(iterator2);
        }
        if ((n10 = Float.isNaN(f10 = this.mScaleY)) == 0) {
            iterator2 = "scaleY";
            hashSet.add(iterator2);
        }
        if ((n10 = Float.isNaN(f10 = this.mTransitionPathRotate)) == 0) {
            iterator2 = "transitionPathRotate";
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

    public float getValue(String string2) {
        CharSequence charSequence;
        string2.hashCode();
        int n10 = string2.hashCode();
        int n11 = -1;
        switch (n10) {
            default: {
                break;
            }
            case 156108012: {
                charSequence = "waveOffset";
                n10 = (int)(string2.equals(charSequence) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 12;
                break;
            }
            case 92909918: {
                charSequence = "alpha";
                n10 = (int)(string2.equals(charSequence) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 11;
                break;
            }
            case 37232917: {
                charSequence = "transitionPathRotate";
                n10 = (int)(string2.equals(charSequence) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 10;
                break;
            }
            case -4379043: {
                charSequence = "elevation";
                n10 = (int)(string2.equals(charSequence) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 9;
                break;
            }
            case -40300674: {
                charSequence = "rotation";
                n10 = (int)(string2.equals(charSequence) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 8;
                break;
            }
            case -908189617: {
                charSequence = "scaleY";
                n10 = (int)(string2.equals(charSequence) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 7;
                break;
            }
            case -908189618: {
                charSequence = "scaleX";
                n10 = (int)(string2.equals(charSequence) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 6;
                break;
            }
            case -1001078227: {
                charSequence = "progress";
                n10 = (int)(string2.equals(charSequence) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 5;
                break;
            }
            case -1225497655: {
                charSequence = "translationZ";
                n10 = (int)(string2.equals(charSequence) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 4;
                break;
            }
            case -1225497656: {
                charSequence = "translationY";
                n10 = (int)(string2.equals(charSequence) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 3;
                break;
            }
            case -1225497657: {
                charSequence = "translationX";
                n10 = (int)(string2.equals(charSequence) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 2;
                break;
            }
            case -1249320805: {
                charSequence = "rotationY";
                n10 = (int)(string2.equals(charSequence) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 1;
                break;
            }
            case -1249320806: {
                charSequence = "rotationX";
                n10 = (int)(string2.equals(charSequence) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 0;
            }
        }
        switch (n11) {
            default: {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("WARNING! KeyCycle UNKNOWN  ");
                ((StringBuilder)charSequence).append(string2);
                string2 = ((StringBuilder)charSequence).toString();
                Log.v((String)"KeyCycle", (String)string2);
                return 0.0f / 0.0f;
            }
            case 12: {
                return this.mWaveOffset;
            }
            case 11: {
                return this.mAlpha;
            }
            case 10: {
                return this.mTransitionPathRotate;
            }
            case 9: {
                return this.mElevation;
            }
            case 8: {
                return this.mRotation;
            }
            case 7: {
                return this.mScaleY;
            }
            case 6: {
                return this.mScaleX;
            }
            case 5: {
                return this.mProgress;
            }
            case 4: {
                return this.mTranslationZ;
            }
            case 3: {
                return this.mTranslationY;
            }
            case 2: {
                return this.mTranslationX;
            }
            case 1: {
                return this.mRotationY;
            }
            case 0: 
        }
        return this.mRotationX;
    }

    public void load(Context context, AttributeSet attributeSet) {
        int[] nArray = R$styleable.KeyCycle;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        KeyCycle$Loader.access$000(this, (TypedArray)context);
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
                n12 = 15;
                break;
            }
            case 579057826: {
                String string4 = "curveFit";
                n10 = string2.equals(string4);
                if (n10 == 0) break;
                n12 = 14;
                break;
            }
            case 184161818: {
                String string5 = "wavePeriod";
                n10 = string2.equals(string5);
                if (n10 == 0) break;
                n12 = 13;
                break;
            }
            case 156108012: {
                String string6 = "waveOffset";
                n10 = string2.equals(string6);
                if (n10 == 0) break;
                n12 = 12;
                break;
            }
            case 92909918: {
                String string7 = "alpha";
                n10 = string2.equals(string7);
                if (n10 == 0) break;
                n12 = 11;
                break;
            }
            case 37232917: {
                String string8 = "transitionPathRotate";
                n10 = string2.equals(string8);
                if (n10 == 0) break;
                n12 = 10;
                break;
            }
            case -4379043: {
                String string9 = "elevation";
                n10 = string2.equals(string9);
                if (n10 == 0) break;
                n12 = 9;
                break;
            }
            case -40300674: {
                String string10 = "rotation";
                n10 = string2.equals(string10);
                if (n10 == 0) break;
                n12 = 8;
                break;
            }
            case -908189617: {
                String string11 = "scaleY";
                n10 = string2.equals(string11);
                if (n10 == 0) break;
                n12 = 7;
                break;
            }
            case -908189618: {
                String string12 = "scaleX";
                n10 = string2.equals(string12);
                if (n10 == 0) break;
                n12 = 6;
                break;
            }
            case -1001078227: {
                String string13 = "progress";
                n10 = string2.equals(string13);
                if (n10 == 0) break;
                n12 = 5;
                break;
            }
            case -1225497656: {
                String string14 = "translationY";
                n10 = string2.equals(string14);
                if (n10 == 0) break;
                n12 = 4;
                break;
            }
            case -1225497657: {
                String string15 = "translationX";
                n10 = string2.equals(string15);
                if (n10 == 0) break;
                n12 = 3;
                break;
            }
            case -1249320805: {
                String string16 = "rotationY";
                n10 = string2.equals(string16);
                if (n10 == 0) break;
                n12 = 2;
                break;
            }
            case -1249320806: {
                String string17 = "rotationX";
                n10 = string2.equals(string17);
                if (n10 == 0) break;
                n12 = 1;
                break;
            }
            case -1812823328: {
                String string18 = "transitionEasing";
                n10 = string2.equals(string18);
                if (n10 == 0) break;
                n12 = 0;
            }
        }
        switch (n12) {
            default: {
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
                this.mWavePeriod = f11 = this.toFloat(object);
                break;
            }
            case 12: {
                float f12;
                this.mWaveOffset = f12 = this.toFloat(object);
                break;
            }
            case 11: {
                float f13;
                this.mAlpha = f13 = this.toFloat(object);
                break;
            }
            case 10: {
                float f14;
                this.mTransitionPathRotate = f14 = this.toFloat(object);
                break;
            }
            case 9: {
                float f15;
                this.mElevation = f15 = this.toFloat(object);
                break;
            }
            case 8: {
                float f16;
                this.mRotation = f16 = this.toFloat(object);
                break;
            }
            case 7: {
                float f17;
                this.mScaleY = f17 = this.toFloat(object);
                break;
            }
            case 6: {
                float f18;
                this.mScaleX = f18 = this.toFloat(object);
                break;
            }
            case 5: {
                float f19;
                this.mProgress = f19 = this.toFloat(object);
                break;
            }
            case 4: {
                float f20;
                this.mTranslationY = f20 = this.toFloat(object);
                break;
            }
            case 3: {
                float f21;
                this.mTranslationX = f21 = this.toFloat(object);
                break;
            }
            case 2: {
                float f22;
                this.mRotationY = f22 = this.toFloat(object);
                break;
            }
            case 1: {
                float f23;
                this.mRotationX = f23 = this.toFloat(object);
                break;
            }
            case 0: {
                this.mTransitionEasing = string2 = object.toString();
            }
        }
    }
}

