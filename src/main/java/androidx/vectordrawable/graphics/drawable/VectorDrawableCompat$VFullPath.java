/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Join
 *  android.util.AttributeSet
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.vectordrawable.graphics.drawable.AndroidResources;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VPath;
import org.xmlpull.v1.XmlPullParser;

public class VectorDrawableCompat$VFullPath
extends VectorDrawableCompat$VPath {
    public float mFillAlpha;
    public ComplexColorCompat mFillColor;
    public float mStrokeAlpha;
    public ComplexColorCompat mStrokeColor;
    public Paint.Cap mStrokeLineCap;
    public Paint.Join mStrokeLineJoin;
    public float mStrokeMiterlimit;
    public float mStrokeWidth = 0.0f;
    private int[] mThemeAttrs;
    public float mTrimPathEnd;
    public float mTrimPathOffset;
    public float mTrimPathStart;

    public VectorDrawableCompat$VFullPath() {
        Paint.Cap cap;
        float f10;
        this.mStrokeAlpha = f10 = 1.0f;
        this.mFillAlpha = f10;
        this.mTrimPathStart = 0.0f;
        this.mTrimPathEnd = f10;
        this.mTrimPathOffset = 0.0f;
        this.mStrokeLineCap = cap = Paint.Cap.BUTT;
        cap = Paint.Join.MITER;
        this.mStrokeLineJoin = cap;
        this.mStrokeMiterlimit = 4.0f;
    }

    public VectorDrawableCompat$VFullPath(VectorDrawableCompat$VFullPath vectorDrawableCompat$VFullPath) {
        super(vectorDrawableCompat$VFullPath);
        float f10;
        int n10;
        float f11;
        Object object;
        float f12;
        this.mStrokeAlpha = f12 = 1.0f;
        this.mFillAlpha = f12;
        this.mTrimPathStart = 0.0f;
        this.mTrimPathEnd = f12;
        this.mTrimPathOffset = 0.0f;
        this.mStrokeLineCap = object = Paint.Cap.BUTT;
        object = Paint.Join.MITER;
        this.mStrokeLineJoin = object;
        this.mStrokeMiterlimit = 4.0f;
        object = vectorDrawableCompat$VFullPath.mThemeAttrs;
        this.mThemeAttrs = (int[])object;
        object = vectorDrawableCompat$VFullPath.mStrokeColor;
        this.mStrokeColor = object;
        this.mStrokeWidth = f11 = vectorDrawableCompat$VFullPath.mStrokeWidth;
        this.mStrokeAlpha = f11 = vectorDrawableCompat$VFullPath.mStrokeAlpha;
        object = vectorDrawableCompat$VFullPath.mFillColor;
        this.mFillColor = object;
        this.mFillRule = n10 = vectorDrawableCompat$VFullPath.mFillRule;
        this.mFillAlpha = f11 = vectorDrawableCompat$VFullPath.mFillAlpha;
        this.mTrimPathStart = f11 = vectorDrawableCompat$VFullPath.mTrimPathStart;
        this.mTrimPathEnd = f11 = vectorDrawableCompat$VFullPath.mTrimPathEnd;
        this.mTrimPathOffset = f11 = vectorDrawableCompat$VFullPath.mTrimPathOffset;
        this.mStrokeLineCap = object = vectorDrawableCompat$VFullPath.mStrokeLineCap;
        object = vectorDrawableCompat$VFullPath.mStrokeLineJoin;
        this.mStrokeLineJoin = object;
        this.mStrokeMiterlimit = f10 = vectorDrawableCompat$VFullPath.mStrokeMiterlimit;
    }

    private Paint.Cap getStrokeLineCap(int n10, Paint.Cap cap) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    return cap;
                }
                return Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }
        return Paint.Cap.BUTT;
    }

    private Paint.Join getStrokeLineJoin(int n10, Paint.Join join) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    return join;
                }
                return Paint.Join.BEVEL;
            }
            return Paint.Join.ROUND;
        }
        return Paint.Join.MITER;
    }

    private void updateStateFromTypedArray(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme object) {
        int n10;
        float f10;
        float f11 = 0.0f;
        this.mThemeAttrs = null;
        Object object2 = "pathData";
        int n11 = TypedArrayUtils.hasAttribute(xmlPullParser, (String)object2);
        if (n11 == 0) {
            return;
        }
        n11 = 0;
        f11 = 0.0f;
        object2 = typedArray.getString(0);
        if (object2 != null) {
            this.mPathName = object2;
        }
        n11 = 2;
        f11 = 2.8E-45f;
        object2 = typedArray.getString(n11);
        if (object2 != null) {
            object2 = PathParser.createNodesFromPathData((String)object2);
            this.mNodes = object2;
        }
        TypedArray typedArray2 = typedArray;
        object2 = TypedArrayUtils.getNamedComplexColor(typedArray, xmlPullParser, object, "fillColor", 1, 0);
        this.mFillColor = object2;
        float f12 = this.mFillAlpha;
        this.mFillAlpha = f11 = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "fillAlpha", 12, f12);
        int n12 = -1;
        n11 = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineCap", 8, n12);
        typedArray2 = this.mStrokeLineCap;
        this.mStrokeLineCap = object2 = this.getStrokeLineCap(n11, (Paint.Cap)typedArray2);
        n11 = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineJoin", 9, n12);
        typedArray2 = this.mStrokeLineJoin;
        object2 = this.getStrokeLineJoin(n11, (Paint.Join)typedArray2);
        this.mStrokeLineJoin = object2;
        f12 = this.mStrokeMiterlimit;
        this.mStrokeMiterlimit = f11 = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeMiterLimit", 10, f12);
        typedArray2 = typedArray;
        object = TypedArrayUtils.getNamedComplexColor(typedArray, xmlPullParser, object, "strokeColor", 3, 0);
        this.mStrokeColor = object;
        f11 = this.mStrokeAlpha;
        this.mStrokeAlpha = f10 = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeAlpha", 11, f11);
        f11 = this.mStrokeWidth;
        this.mStrokeWidth = f10 = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeWidth", 4, f11);
        f11 = this.mTrimPathEnd;
        this.mTrimPathEnd = f10 = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathEnd", 6, f11);
        f11 = this.mTrimPathOffset;
        this.mTrimPathOffset = f10 = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathOffset", 7, f11);
        f11 = this.mTrimPathStart;
        this.mTrimPathStart = f10 = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathStart", 5, f11);
        n11 = this.mFillRule;
        this.mFillRule = n10 = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "fillType", 13, n11);
    }

    public void applyTheme(Resources.Theme object) {
        object = this.mThemeAttrs;
        if (object == null) {
            // empty if block
        }
    }

    public boolean canApplyTheme() {
        boolean bl2;
        int[] nArray = this.mThemeAttrs;
        if (nArray != null) {
            bl2 = true;
        } else {
            bl2 = false;
            nArray = null;
        }
        return bl2;
    }

    public float getFillAlpha() {
        return this.mFillAlpha;
    }

    public int getFillColor() {
        return this.mFillColor.getColor();
    }

    public float getStrokeAlpha() {
        return this.mStrokeAlpha;
    }

    public int getStrokeColor() {
        return this.mStrokeColor.getColor();
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public float getTrimPathEnd() {
        return this.mTrimPathEnd;
    }

    public float getTrimPathOffset() {
        return this.mTrimPathOffset;
    }

    public float getTrimPathStart() {
        return this.mTrimPathStart;
    }

    public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
        int[] nArray = AndroidResources.STYLEABLE_VECTOR_DRAWABLE_PATH;
        resources = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, nArray);
        this.updateStateFromTypedArray((TypedArray)resources, xmlPullParser, theme);
        resources.recycle();
    }

    public boolean isStateful() {
        ComplexColorCompat complexColorCompat = this.mFillColor;
        boolean bl2 = complexColorCompat.isStateful();
        if (!bl2 && !(bl2 = (complexColorCompat = this.mStrokeColor).isStateful())) {
            bl2 = false;
            complexColorCompat = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean onStateChanged(int[] nArray) {
        boolean bl2 = this.mFillColor.onStateChanged(nArray);
        return this.mStrokeColor.onStateChanged(nArray) | bl2;
    }

    public void setFillAlpha(float f10) {
        this.mFillAlpha = f10;
    }

    public void setFillColor(int n10) {
        this.mFillColor.setColor(n10);
    }

    public void setStrokeAlpha(float f10) {
        this.mStrokeAlpha = f10;
    }

    public void setStrokeColor(int n10) {
        this.mStrokeColor.setColor(n10);
    }

    public void setStrokeWidth(float f10) {
        this.mStrokeWidth = f10;
    }

    public void setTrimPathEnd(float f10) {
        this.mTrimPathEnd = f10;
    }

    public void setTrimPathOffset(float f10) {
        this.mTrimPathOffset = f10;
    }

    public void setTrimPathStart(float f10) {
        this.mTrimPathStart = f10;
    }
}

