/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Path
 *  android.graphics.PathMeasure
 *  android.util.AttributeSet
 *  android.view.InflateException
 *  android.view.animation.Interpolator
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.vectordrawable.graphics.drawable.AndroidResources;
import org.xmlpull.v1.XmlPullParser;

public class PathInterpolatorCompat
implements Interpolator {
    public static final double EPSILON = 1.0E-5;
    public static final int MAX_NUM_POINTS = 3000;
    private static final float PRECISION = 0.002f;
    private float[] mX;
    private float[] mY;

    public PathInterpolatorCompat(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        Resources resources = context.getResources();
        context = context.getTheme();
        this(resources, (Resources.Theme)context, attributeSet, xmlPullParser);
    }

    public PathInterpolatorCompat(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        int[] nArray = AndroidResources.STYLEABLE_PATH_INTERPOLATOR;
        resources = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, nArray);
        this.parseInterpolatorFromTypeArray((TypedArray)resources, xmlPullParser);
        resources.recycle();
    }

    private void initCubic(float f10, float f11, float f12, float f13) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f10, f11, f12, f13, 1.0f, 1.0f);
        this.initPath(path);
    }

    private void initPath(Path object) {
        int n10 = 0;
        float f10 = 0.0f;
        Object object2 = null;
        Object object3 = new PathMeasure(object, false);
        float f11 = object3.getLength();
        float f12 = f11 / 0.002f;
        int n11 = (int)f12;
        int n12 = 1;
        float f13 = Float.MIN_VALUE;
        n11 += n12;
        int n13 = 3000;
        float f14 = 4.204E-42f;
        if ((n11 = Math.min(n13, n11)) > 0) {
            double d10;
            double d11;
            int n14;
            Object object4 = new float[n11];
            this.mX = object4;
            object4 = new float[n11];
            this.mY = object4;
            n13 = 2;
            f14 = 2.8E-45f;
            object4 = new float[n13];
            float f15 = 0.0f;
            for (n14 = 0; n14 < n11; ++n14) {
                float f16 = (float)n14 * f11;
                float f17 = n11 + -1;
                object3.getPosTan(f16 /= f17, object4, null);
                float[] fArray = this.mX;
                fArray[n14] = f17 = object4[0];
                fArray = this.mY;
                fArray[n14] = f17 = object4[n12];
            }
            object = this.mX;
            f11 = Math.abs((float)object[0]);
            double d12 = f11;
            double d13 = d12 - (d11 = 1.0E-5);
            Object object5 = d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1);
            if (object5 <= 0 && (object5 = (d10 = (d12 = (double)(f11 = Math.abs((float)(object = (Object)this.mY)[0]))) - d11) == 0.0 ? 0 : (d10 > 0.0 ? 1 : -1)) <= 0) {
                double d14;
                object = this.mX;
                n13 = n11 + -1;
                f11 = (float)object[n13];
                n14 = 1065353216;
                f15 = 1.0f;
                double d15 = f11 = Math.abs(f11 - f15);
                double d16 = d15 - d11;
                object5 = d16 == 0.0 ? 0 : (d16 > 0.0 ? 1 : -1);
                if (object5 <= 0 && (object5 = (d14 = (d12 = (double)(f11 = Math.abs((float)((object = (Object)this.mY)[n13] - f15)))) - d11) == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1)) <= 0) {
                    object5 = false;
                    f11 = 0.0f;
                    object = null;
                    n12 = 0;
                    f13 = 0.0f;
                    while (n10 < n11) {
                        object4 = this.mX;
                        n14 = n12 + 1;
                        f13 = object4[n12];
                        float f18 = f13 - f11;
                        object5 = f18 == 0.0f ? 0 : (f18 < 0.0f ? -1 : 1);
                        if (object5 >= 0) {
                            object4[n10] = f13;
                            ++n10;
                            f11 = f13;
                            n12 = n14;
                            continue;
                        }
                        object3 = new StringBuilder();
                        ((StringBuilder)object3).append("The Path cannot loop back on itself, x :");
                        ((StringBuilder)object3).append(f13);
                        object3 = ((StringBuilder)object3).toString();
                        object = new IllegalArgumentException((String)object3);
                        throw object;
                    }
                    object5 = object3.nextContour();
                    if (object5 == false) {
                        return;
                    }
                    object = new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                    throw object;
                }
            }
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("The Path must start at (0,0) and end at (1,1) start: ");
            f14 = this.mX[0];
            ((StringBuilder)object3).append(f14);
            object4 = ",";
            ((StringBuilder)object3).append((String)object4);
            f10 = this.mY[0];
            ((StringBuilder)object3).append(f10);
            ((StringBuilder)object3).append(" end:");
            object2 = this.mX;
            f10 = (float)object2[n11 -= n12];
            ((StringBuilder)object3).append(f10);
            ((StringBuilder)object3).append((String)object4);
            f10 = this.mY[n11];
            ((StringBuilder)object3).append(f10);
            object3 = ((StringBuilder)object3).toString();
            object = new IllegalArgumentException((String)object3);
            throw object;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("The Path has a invalid length ");
        ((StringBuilder)object2).append(f11);
        object = ((StringBuilder)object2).toString();
        object3 = new IllegalArgumentException((String)object);
        throw object3;
    }

    private void initQuad(float f10, float f11) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        float f12 = 1.0f;
        path.quadTo(f10, f11, f12, f12);
        this.initPath(path);
    }

    private void parseInterpolatorFromTypeArray(TypedArray object, XmlPullParser xmlPullParser) {
        block8: {
            block9: {
                block10: {
                    block7: {
                        String string2;
                        boolean bl2;
                        int n10;
                        CharSequence charSequence;
                        block5: {
                            block6: {
                                charSequence = "pathData";
                                n10 = TypedArrayUtils.hasAttribute(xmlPullParser, (String)charSequence);
                                if (n10 == 0) break block5;
                                n10 = 4;
                                float f10 = 5.6E-45f;
                                if ((xmlPullParser = PathParser.createPathFromPathData((String)(object = TypedArrayUtils.getNamedString(object, xmlPullParser, (String)charSequence, n10)))) == null) break block6;
                                this.initPath((Path)xmlPullParser);
                                break block7;
                            }
                            charSequence = new StringBuilder();
                            ((StringBuilder)charSequence).append("The path is null, which is created from ");
                            ((StringBuilder)charSequence).append((String)object);
                            object = ((StringBuilder)charSequence).toString();
                            xmlPullParser = new InflateException((String)object);
                            throw xmlPullParser;
                        }
                        charSequence = "controlX1";
                        n10 = (int)(TypedArrayUtils.hasAttribute(xmlPullParser, (String)charSequence) ? 1 : 0);
                        if (n10 == 0) break block8;
                        String string3 = "controlY1";
                        int n11 = (int)(TypedArrayUtils.hasAttribute(xmlPullParser, string3) ? 1 : 0);
                        if (n11 == 0) break block9;
                        float f11 = TypedArrayUtils.getNamedFloat(object, xmlPullParser, (String)charSequence, 0, 0.0f);
                        n11 = 1;
                        float f12 = Float.MIN_VALUE;
                        float f13 = TypedArrayUtils.getNamedFloat(object, xmlPullParser, string3, n11, 0.0f);
                        String string4 = "controlX2";
                        int n12 = TypedArrayUtils.hasAttribute(xmlPullParser, string4);
                        if (n12 != (bl2 = TypedArrayUtils.hasAttribute(xmlPullParser, string2 = "controlY2"))) break block10;
                        if (n12 == 0) {
                            this.initQuad(f11, f13);
                        } else {
                            f12 = TypedArrayUtils.getNamedFloat(object, xmlPullParser, string4, 2, 0.0f);
                            n12 = 3;
                            float f14 = TypedArrayUtils.getNamedFloat(object, xmlPullParser, string2, n12, 0.0f);
                            this.initCubic(f11, f13, f12, f14);
                        }
                    }
                    return;
                }
                object = new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
                throw object;
            }
            object = new InflateException("pathInterpolator requires the controlY1 attribute");
            throw object;
        }
        object = new InflateException("pathInterpolator requires the controlX1 attribute");
        throw object;
    }

    public float getInterpolation(float f10) {
        float f11;
        float f12;
        Object object = false;
        float f13 = 0.0f;
        float[] fArray = null;
        float f14 = f10 - 0.0f;
        Object object2 = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
        if (object2 <= 0) {
            return 0.0f;
        }
        object2 = 1065353216;
        float f15 = 1.0f;
        float f16 = f10 - f15;
        Object object3 = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
        if (object3 >= 0) {
            return f15;
        }
        object2 = false;
        f15 = 0.0f;
        float[] fArray2 = this.mX;
        object3 = fArray2.length;
        boolean bl2 = true;
        object3 -= bl2;
        while ((f12 = object3 - object2) > bl2) {
            float[] fArray3 = this.mX;
            f12 = (object2 + object3) / 2;
            f11 = fArray3[f12];
            float f17 = f10 - f11;
            Object object4 = f17 == 0.0f ? 0 : (f17 < 0.0f ? -1 : 1);
            if (object4 < 0) {
                object3 = f12;
                continue;
            }
            object2 = f12;
        }
        float[] fArray4 = this.mX;
        float f18 = fArray4[object3];
        f11 = fArray4[object2];
        float f19 = (f18 -= f11) - 0.0f;
        object = f19 == 0.0f ? 0 : (f19 > 0.0f ? 1 : -1);
        if (!object) {
            return this.mY[object2];
        }
        f13 = fArray4[object2];
        f10 = (f10 - f13) / f18;
        fArray = this.mY;
        f15 = fArray[object2];
        f13 = fArray[object3] - f15;
        return f15 + (f10 *= f13);
    }
}

