/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Path
 *  android.util.AttributeSet
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.PathMotion;
import androidx.transition.Styleable;
import org.xmlpull.v1.XmlPullParser;

public class ArcMotion
extends PathMotion {
    private static final float DEFAULT_MAX_ANGLE_DEGREES = 70.0f;
    private static final float DEFAULT_MAX_TANGENT = (float)Math.tan(Math.toRadians(35.0));
    private static final float DEFAULT_MIN_ANGLE_DEGREES;
    private float mMaximumAngle;
    private float mMaximumTangent;
    private float mMinimumHorizontalAngle = 0.0f;
    private float mMinimumHorizontalTangent;
    private float mMinimumVerticalAngle = 0.0f;
    private float mMinimumVerticalTangent;

    public ArcMotion() {
        float f10;
        this.mMaximumAngle = 70.0f;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = f10 = DEFAULT_MAX_TANGENT;
    }

    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float f10;
        float f11;
        this.mMaximumAngle = f11 = 70.0f;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = f10 = DEFAULT_MAX_TANGENT;
        int[] nArray = Styleable.ARC_MOTION;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        attributeSet = (XmlPullParser)attributeSet;
        f10 = TypedArrayUtils.getNamedFloat((TypedArray)context, (XmlPullParser)attributeSet, "minimumVerticalAngle", 1, 0.0f);
        this.setMinimumVerticalAngle(f10);
        float f12 = TypedArrayUtils.getNamedFloat((TypedArray)context, (XmlPullParser)attributeSet, "minimumHorizontalAngle", 0, 0.0f);
        this.setMinimumHorizontalAngle(f12);
        float f13 = TypedArrayUtils.getNamedFloat((TypedArray)context, (XmlPullParser)attributeSet, "maximumAngle", 2, f11);
        this.setMaximumAngle(f13);
        context.recycle();
    }

    private static float toTangent(float f10) {
        float f11;
        float f12 = 0.0f;
        float f13 = f10 - 0.0f;
        Object object = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
        if (object >= 0 && (object = (f11 = f10 - (f12 = 90.0f)) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) <= 0) {
            return (float)Math.tan(Math.toRadians(f10 / 2.0f));
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Arc must be between 0 and 90 degrees");
        throw illegalArgumentException;
    }

    public float getMaximumAngle() {
        return this.mMaximumAngle;
    }

    public float getMinimumHorizontalAngle() {
        return this.mMinimumHorizontalAngle;
    }

    public float getMinimumVerticalAngle() {
        return this.mMinimumVerticalAngle;
    }

    public Path getPath(float f10, float f11, float f12, float f13) {
        float f14;
        float f15;
        Path path = new Path();
        path.moveTo(f10, f11);
        float f16 = f12 - f10;
        float f17 = f13 - f11;
        float f18 = f16 * f16;
        float f19 = f17 * f17;
        f18 += f19;
        f19 = f10 + f12;
        float f20 = 2.0f;
        f19 /= f20;
        float f21 = (f11 + f13) / f20;
        int n10 = 1048576000;
        float f22 = 0.25f * f18;
        Object object = f11 == f13 ? 0 : (f11 > f13 ? 1 : -1);
        if (object > 0) {
            object = true;
            f15 = Float.MIN_VALUE;
        } else {
            object = false;
            f15 = 0.0f;
        }
        float f23 = Math.abs(f16);
        float f24 = Math.abs(f17);
        float f25 = f23 == f24 ? 0 : (f23 < f24 ? -1 : 1);
        if (f25 < 0) {
            f16 = Math.abs(f18 /= (f17 *= f20));
            if (object != false) {
                f16 += f13;
                f17 = f12;
            } else {
                f16 += f11;
                f17 = f10;
            }
            f18 = this.mMinimumVerticalTangent;
        } else {
            f18 /= (f16 *= f20);
            if (object != false) {
                f16 = f11;
                f17 = f18 += f10;
            } else {
                f17 = f12 - f18;
                f16 = f13;
            }
            f18 = this.mMinimumHorizontalTangent;
        }
        f15 = f22 * f18 * f18;
        f18 = f19 - f17;
        f23 = f21 - f16;
        f18 *= f18;
        f23 *= f23;
        f18 += f23;
        f23 = this.mMaximumTangent;
        f22 = f22 * f23 * f23;
        f25 = f18 == f15 ? 0 : (f18 < f15 ? -1 : 1);
        f24 = 0.0f;
        if (f25 >= 0) {
            object = f18 == f22 ? 0 : (f18 > f22 ? 1 : -1);
            if (object > 0) {
                f15 = f22;
            } else {
                object = false;
                f15 = 0.0f;
            }
        }
        if ((n10 = (int)((f14 = f15 - 0.0f) == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1))) != 0) {
            double d10 = Math.sqrt(f15 /= f18);
            f18 = (float)d10;
            f17 = (f17 - f19) * f18 + f19;
            f16 = f21 + (f18 *= (f16 -= f21));
        }
        f10 = (f10 + f17) / f20;
        f18 = (f11 + f16) / f20;
        f19 = (f17 + f12) / f20;
        f20 = (f16 + f13) / f20;
        f17 = f10;
        f21 = f12;
        f22 = f13;
        path.cubicTo(f10, f18, f19, f20, f12, f13);
        return path;
    }

    public void setMaximumAngle(float f10) {
        this.mMaximumAngle = f10;
        this.mMaximumTangent = f10 = ArcMotion.toTangent(f10);
    }

    public void setMinimumHorizontalAngle(float f10) {
        this.mMinimumHorizontalAngle = f10;
        this.mMinimumHorizontalTangent = f10 = ArcMotion.toTangent(f10);
    }

    public void setMinimumVerticalAngle(float f10) {
        this.mMinimumVerticalAngle = f10;
        this.mMinimumVerticalTangent = f10 = ArcMotion.toTangent(f10);
    }
}

