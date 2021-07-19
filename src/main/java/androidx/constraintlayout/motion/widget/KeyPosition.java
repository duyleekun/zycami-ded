/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.RectF
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.KeyPosition$Loader;
import androidx.constraintlayout.motion.widget.KeyPositionBase;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;

public class KeyPosition
extends KeyPositionBase {
    public static final int KEY_TYPE = 2;
    public static final String NAME = "KeyPosition";
    private static final String PERCENT_X = "percentX";
    private static final String PERCENT_Y = "percentY";
    private static final String TAG = "KeyPosition";
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;
    public float mAltPercentX;
    public float mAltPercentY;
    private float mCalculatedPositionX;
    private float mCalculatedPositionY;
    public int mDrawPath;
    public int mPathMotionArc;
    public float mPercentHeight;
    public float mPercentWidth;
    public float mPercentX;
    public float mPercentY;
    public int mPositionType;
    public String mTransitionEasing = null;

    public KeyPosition() {
        float f10;
        int n10;
        this.mPathMotionArc = n10 = Key.UNSET;
        this.mDrawPath = 0;
        this.mPercentWidth = f10 = 0.0f / 0.0f;
        this.mPercentHeight = f10;
        this.mPercentX = f10;
        this.mPercentY = f10;
        this.mAltPercentX = f10;
        this.mAltPercentY = f10;
        this.mPositionType = 0;
        this.mCalculatedPositionX = f10;
        this.mCalculatedPositionY = f10;
        this.mType = 2;
    }

    private void calcCartesianPosition(float f10, float f11, float f12, float f13) {
        f12 -= f10;
        f13 -= f11;
        float f14 = this.mPercentX;
        boolean bl2 = Float.isNaN(f14);
        float f15 = 0.0f;
        if (bl2) {
            bl2 = false;
            f14 = 0.0f;
        } else {
            f14 = this.mPercentX;
        }
        float f16 = this.mAltPercentY;
        boolean bl3 = Float.isNaN(f16);
        if (bl3) {
            bl3 = false;
            f16 = 0.0f;
        } else {
            f16 = this.mAltPercentY;
        }
        float f17 = this.mPercentY;
        boolean bl4 = Float.isNaN(f17);
        if (bl4) {
            bl4 = false;
            f17 = 0.0f;
        } else {
            f17 = this.mPercentY;
        }
        float f18 = this.mAltPercentX;
        boolean bl5 = Float.isNaN(f18);
        if (!bl5) {
            f15 = this.mAltPercentX;
        }
        f10 += (f14 *= f12);
        this.mCalculatedPositionX = f10 = (float)((int)(f10 + (f15 *= f13)));
        this.mCalculatedPositionY = f10 = (float)((int)((f11 += (f12 *= f16)) + (f13 *= f17)));
    }

    private void calcPathPosition(float f10, float f11, float f12, float f13) {
        float f14 = -(f13 -= f11);
        float f15 = this.mPercentX;
        float f16 = (f12 -= f10) * f15;
        f10 += f16;
        f16 = this.mPercentY;
        this.mCalculatedPositionX = f10 += (f14 *= f16);
        f11 += (f13 *= f15);
        this.mCalculatedPositionY = f11 += (f12 *= f16);
    }

    private void calcScreenPosition(int n10, int n11) {
        float f10 = n10 - 0;
        float f11 = this.mPercentX;
        f10 *= f11;
        float f12 = 0.0f;
        this.mCalculatedPositionX = f10 += f12;
        this.mCalculatedPositionY = f10 = (float)(n11 - 0) * f11 + f12;
    }

    public void addValues(HashMap hashMap) {
    }

    public void calcPosition(int n10, int n11, float f10, float f11, float f12, float f13) {
        int n12 = this.mPositionType;
        int n13 = 1;
        if (n12 != n13) {
            n13 = 2;
            if (n12 != n13) {
                this.calcCartesianPosition(f10, f11, f12, f13);
                return;
            }
            this.calcScreenPosition(n10, n11);
            return;
        }
        this.calcPathPosition(f10, f11, f12, f13);
    }

    public float getPositionX() {
        return this.mCalculatedPositionX;
    }

    public float getPositionY() {
        return this.mCalculatedPositionY;
    }

    public boolean intersects(int n10, int n11, RectF rectF, RectF rectF2, float f10, float f11) {
        float f12 = rectF.centerX();
        float f13 = rectF.centerY();
        float f14 = rectF2.centerX();
        float f15 = rectF2.centerY();
        this.calcPosition(n10, n11, f12, f13, f14, f15);
        float f16 = this.mCalculatedPositionX;
        f10 -= f16;
        f16 = Math.abs(f10);
        n11 = 1101004800;
        float f17 = 20.0f;
        n10 = (int)(f16 == f17 ? 0 : (f16 < f17 ? -1 : 1));
        if (n10 < 0) {
            f16 = this.mCalculatedPositionY;
            float f18 = (f16 = Math.abs(f11 -= f16)) - f17;
            n10 = (int)(f18 == 0.0f ? 0 : (f18 < 0.0f ? -1 : 1));
            if (n10 < 0) {
                return true;
            }
        }
        return false;
    }

    public void load(Context context, AttributeSet attributeSet) {
        int[] nArray = R$styleable.KeyPosition;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        KeyPosition$Loader.access$000(this, (TypedArray)context);
    }

    public void positionAttributes(View view, RectF rectF, RectF rectF2, float f10, float f11, String[] stringArray, float[] fArray) {
        int n10 = this.mPositionType;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                this.positionCartAttributes(rectF, rectF2, f10, f11, stringArray, fArray);
                return;
            }
            this.positionScreenAttributes(view, rectF, rectF2, f10, f11, stringArray, fArray);
            return;
        }
        this.positionPathAttributes(rectF, rectF2, f10, f11, stringArray, fArray);
    }

    public void positionCartAttributes(RectF rectF, RectF rectF2, float f10, float f11, String[] object, float[] fArray) {
        float f12 = rectF.centerX();
        float f13 = rectF.centerY();
        float f14 = rectF2.centerX();
        float f15 = rectF2.centerY();
        f14 -= f12;
        f15 -= f13;
        String string2 = object[0];
        String string3 = PERCENT_X;
        int n10 = 1;
        if (string2 != null) {
            boolean bl2 = string3.equals(object = object[0]);
            if (bl2) {
                fArray[0] = f10 = (f10 - f12) / f14;
                fArray[n10] = f11 = (f11 - f13) / f15;
            } else {
                fArray[n10] = f10 = (f10 - f12) / f14;
                fArray[0] = f11 = (f11 - f13) / f15;
            }
        } else {
            String string4;
            object[0] = string3;
            fArray[0] = f10 = (f10 - f12) / f14;
            object[n10] = string4 = PERCENT_Y;
            fArray[n10] = f11 = (f11 - f13) / f15;
        }
    }

    public void positionPathAttributes(RectF rectF, RectF object, float f10, float f11, String[] stringArray, float[] fArray) {
        float f12 = rectF.centerX();
        float f13 = rectF.centerY();
        float f14 = object.centerX();
        float f15 = object.centerY();
        double d10 = f14 -= f12;
        double d11 = f15 -= f13;
        d10 = Math.hypot(d10, d11);
        float f16 = (float)d10;
        double d12 = f16;
        double d13 = 1.0E-4;
        double d14 = d12 == d13 ? 0 : (d12 < d13 ? -1 : 1);
        int n10 = 1;
        if (d14 < 0) {
            System.out.println("distance ~ 0");
            fArray[0] = 0.0f;
            fArray[n10] = 0.0f;
            return;
        }
        f11 -= f13;
        f13 = (f14 /= f16) * f11;
        f10 -= f12;
        f12 = f10 * (f15 /= f16);
        f13 = (f13 - f12) / f16;
        f14 *= f10;
        f14 = (f14 + (f15 *= f11)) / f16;
        object = stringArray[0];
        String string2 = PERCENT_X;
        if (object != null) {
            object = stringArray[0];
            boolean bl2 = string2.equals(object);
            if (bl2) {
                fArray[0] = f14;
                fArray[n10] = f13;
            }
        } else {
            stringArray[0] = string2;
            object = PERCENT_Y;
            stringArray[n10] = object;
            fArray[0] = f14;
            fArray[n10] = f13;
        }
    }

    public void positionScreenAttributes(View view, RectF object, RectF rectF, float f10, float f11, String[] object2, float[] fArray) {
        object.centerX();
        object.centerY();
        rectF.centerX();
        rectF.centerY();
        view = (ViewGroup)view.getParent();
        int n10 = view.getWidth();
        int n11 = view.getHeight();
        rectF = null;
        String string2 = object2[0];
        String string3 = PERCENT_X;
        int n12 = 1;
        if (string2 != null) {
            boolean bl2 = string3.equals(object2 = object2[0]);
            if (bl2) {
                float f12 = n10;
                fArray[0] = f10 /= f12;
                float f13 = n11;
                fArray[n12] = f11 /= f13;
            } else {
                float f14 = n10;
                fArray[n12] = f10 /= f14;
                float f15 = n11;
                fArray[0] = f11 /= f15;
            }
        } else {
            object2[0] = string3;
            float f16 = n10;
            fArray[0] = f10 /= f16;
            object = PERCENT_Y;
            object2[n12] = object;
            float f17 = n11;
            fArray[n12] = f11 /= f17;
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
            case 428090548: {
                String string3 = PERCENT_Y;
                n10 = string2.equals(string3);
                if (n10 == 0) break;
                n12 = 6;
                break;
            }
            case 428090547: {
                String string4 = PERCENT_X;
                n10 = string2.equals(string4);
                if (n10 == 0) break;
                n12 = 5;
                break;
            }
            case -200259324: {
                String string5 = "sizePercent";
                n10 = string2.equals(string5);
                if (n10 == 0) break;
                n12 = 4;
                break;
            }
            case -827014263: {
                String string6 = "drawPath";
                n10 = string2.equals(string6);
                if (n10 == 0) break;
                n12 = 3;
                break;
            }
            case -1017587252: {
                String string7 = "percentHeight";
                n10 = string2.equals(string7);
                if (n10 == 0) break;
                n12 = 2;
                break;
            }
            case -1127236479: {
                String string8 = "percentWidth";
                n10 = string2.equals(string8);
                if (n10 == 0) break;
                n12 = 1;
                break;
            }
            case -1812823328: {
                String string9 = "transitionEasing";
                n10 = string2.equals(string9);
                if (n10 == 0) break;
                n12 = 0;
            }
        }
        switch (n12) {
            default: {
                break;
            }
            case 6: {
                float f10;
                this.mPercentY = f10 = this.toFloat(object);
                break;
            }
            case 5: {
                float f11;
                this.mPercentX = f11 = this.toFloat(object);
                break;
            }
            case 4: {
                float f12;
                this.mPercentWidth = f12 = this.toFloat(object);
                this.mPercentHeight = f12;
                break;
            }
            case 3: {
                this.mDrawPath = n10 = this.toInt(object);
                break;
            }
            case 2: {
                float f13;
                this.mPercentHeight = f13 = this.toFloat(object);
                break;
            }
            case 1: {
                float f14;
                this.mPercentWidth = f14 = this.toFloat(object);
                break;
            }
            case 0: {
                this.mTransitionEasing = string2 = object.toString();
            }
        }
    }
}

