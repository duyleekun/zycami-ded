/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.LinearGradient
 *  android.graphics.RadialGradient
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.SweepGradient
 *  android.util.AttributeSet
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.core.R$styleable;
import androidx.core.content.res.GradientColorInflaterCompat$ColorStops;
import androidx.core.content.res.TypedArrayUtils;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class GradientColorInflaterCompat {
    private static final int TILE_MODE_CLAMP = 0;
    private static final int TILE_MODE_MIRROR = 2;
    private static final int TILE_MODE_REPEAT = 1;

    private GradientColorInflaterCompat() {
    }

    private static GradientColorInflaterCompat$ColorStops checkColors(GradientColorInflaterCompat$ColorStops gradientColorInflaterCompat$ColorStops, int n10, int n11, boolean bl2, int n12) {
        if (gradientColorInflaterCompat$ColorStops != null) {
            return gradientColorInflaterCompat$ColorStops;
        }
        if (bl2) {
            gradientColorInflaterCompat$ColorStops = new GradientColorInflaterCompat$ColorStops(n10, n12, n11);
            return gradientColorInflaterCompat$ColorStops;
        }
        gradientColorInflaterCompat$ColorStops = new GradientColorInflaterCompat$ColorStops(n10, n11);
        return gradientColorInflaterCompat$ColorStops;
    }

    public static Shader createFromXml(Resources object, XmlPullParser xmlPullParser, Resources.Theme theme) {
        int n10;
        int n11;
        int n12;
        AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlPullParser);
        while ((n12 = xmlPullParser.next()) != (n11 = 2) && n12 != (n10 = 1)) {
        }
        if (n12 == n11) {
            return GradientColorInflaterCompat.createFromXmlInner(object, xmlPullParser, attributeSet, theme);
        }
        object = new XmlPullParserException("No start tag found");
        throw object;
    }

    public static Shader createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Object object;
        Object object2 = xmlPullParser;
        Object object3 = xmlPullParser.getName();
        boolean n10 = ((String)object3).equals(object = "gradient");
        if (n10) {
            object3 = R$styleable.GradientColor;
            object = resources;
            Object object4 = attributeSet;
            Object object5 = theme;
            object3 = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, (int[])object3);
            int n11 = R$styleable.GradientColor_android_startX;
            float f10 = TypedArrayUtils.getNamedFloat((TypedArray)object3, xmlPullParser, "startX", n11, 0.0f);
            n11 = R$styleable.GradientColor_android_startY;
            float f11 = TypedArrayUtils.getNamedFloat((TypedArray)object3, xmlPullParser, "startY", n11, 0.0f);
            n11 = R$styleable.GradientColor_android_endX;
            float f12 = TypedArrayUtils.getNamedFloat((TypedArray)object3, xmlPullParser, "endX", n11, 0.0f);
            n11 = R$styleable.GradientColor_android_endY;
            float f13 = TypedArrayUtils.getNamedFloat((TypedArray)object3, xmlPullParser, "endY", n11, 0.0f);
            n11 = R$styleable.GradientColor_android_centerX;
            float f14 = TypedArrayUtils.getNamedFloat((TypedArray)object3, xmlPullParser, "centerX", n11, 0.0f);
            n11 = R$styleable.GradientColor_android_centerY;
            float f15 = TypedArrayUtils.getNamedFloat((TypedArray)object3, xmlPullParser, "centerY", n11, 0.0f);
            n11 = R$styleable.GradientColor_android_type;
            String string2 = "type";
            n11 = TypedArrayUtils.getNamedInt((TypedArray)object3, xmlPullParser, string2, n11, 0);
            int n12 = R$styleable.GradientColor_android_startColor;
            n12 = TypedArrayUtils.getNamedColor((TypedArray)object3, xmlPullParser, "startColor", n12, 0);
            Object object6 = "centerColor";
            boolean bl2 = TypedArrayUtils.hasAttribute(xmlPullParser, (String)object6);
            int n14 = R$styleable.GradientColor_android_centerColor;
            n14 = TypedArrayUtils.getNamedColor((TypedArray)object3, xmlPullParser, (String)object6, n14, 0);
            int n15 = R$styleable.GradientColor_android_endColor;
            object4 = "endColor";
            int n16 = TypedArrayUtils.getNamedColor((TypedArray)object3, xmlPullParser, (String)object4, n15, 0);
            n15 = R$styleable.GradientColor_android_tileMode;
            object5 = "tileMode";
            int n17 = TypedArrayUtils.getNamedInt((TypedArray)object3, xmlPullParser, (String)object5, n15, 0);
            int n18 = R$styleable.GradientColor_android_gradientRadius;
            object6 = "gradientRadius";
            float f16 = f14;
            f14 = 0.0f;
            float[] fArray = null;
            float f17 = TypedArrayUtils.getNamedFloat((TypedArray)object3, xmlPullParser, (String)object6, n18, 0.0f);
            object3.recycle();
            object2 = GradientColorInflaterCompat.checkColors(GradientColorInflaterCompat.inflateChildElements(resources, xmlPullParser, attributeSet, theme), n12, n16, bl2, n14);
            int n19 = 1;
            if (n11 != n19) {
                n19 = 2;
                if (n11 != n19) {
                    object6 = object2.mColors;
                    fArray = object2.mOffsets;
                    Shader.TileMode tileMode = GradientColorInflaterCompat.parseTileMode(n17);
                    object3 = new LinearGradient(f10, f11, f12, f13, (int[])object6, fArray, tileMode);
                    return object3;
                }
                object = object2.mColors;
                object2 = object2.mOffsets;
                object3 = new SweepGradient(f16, f15, (int[])object, (float[])object2);
                return object3;
            }
            object3 = null;
            float f18 = f17 - 0.0f;
            n19 = (int)(f18 == 0.0f ? 0 : (f18 < 0.0f ? -1 : 1));
            if (n19 > 0) {
                object = object2.mColors;
                object2 = object2.mOffsets;
                Shader.TileMode tileMode = GradientColorInflaterCompat.parseTileMode(n17);
                object6 = object3;
                f14 = f16;
                object3 = new RadialGradient(f16, f15, f17, (int[])object, (float[])object2, tileMode);
                return object3;
            }
            object2 = new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            throw object2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        object2 = xmlPullParser.getPositionDescription();
        stringBuilder.append((String)object2);
        stringBuilder.append(": invalid gradient color tag ");
        stringBuilder.append((String)object3);
        object2 = stringBuilder.toString();
        object = new XmlPullParserException((String)object2);
        throw object;
    }

    private static GradientColorInflaterCompat$ColorStops inflateChildElements(Resources object, XmlPullParser object2, AttributeSet object3, Resources.Theme theme) {
        int n10;
        int n11 = object2.getDepth();
        int n12 = 1;
        n11 += n12;
        int n13 = 20;
        ArrayList<Object> arrayList = new ArrayList<Object>(n13);
        ArrayList<Object> arrayList2 = new ArrayList<Object>(n13);
        while ((n13 = object2.next()) != n12) {
            String string2;
            Object object4;
            float f10;
            int n14;
            int n15 = object2.getDepth();
            if (n15 < n11) {
                n14 = 3;
                f10 = 4.2E-45f;
                if (n13 == n14) break;
            }
            n14 = 2;
            f10 = 2.8E-45f;
            if (n13 != n14 || n15 > n11 || (n13 = (int)(((String)(object4 = object2.getName())).equals(string2 = "item") ? 1 : 0)) == 0) continue;
            object4 = R$styleable.GradientColorItem;
            object4 = TypedArrayUtils.obtainAttributes(object, theme, (AttributeSet)object3, (int[])object4);
            n15 = R$styleable.GradientColorItem_android_color;
            n14 = (int)(object4.hasValue(n15) ? 1 : 0);
            int n16 = R$styleable.GradientColorItem_android_offset;
            boolean bl2 = object4.hasValue(n16);
            if (n14 != 0 && bl2) {
                n15 = object4.getColor(n15, 0);
                n14 = 0;
                f10 = object4.getFloat(n16, 0.0f);
                object4.recycle();
                object4 = n15;
                arrayList2.add(object4);
                object4 = Float.valueOf(f10);
                arrayList.add(object4);
                continue;
            }
            object3 = new StringBuilder();
            object2 = object2.getPositionDescription();
            ((StringBuilder)object3).append((String)object2);
            ((StringBuilder)object3).append(": <item> tag requires a 'color' attribute and a 'offset' attribute!");
            object2 = ((StringBuilder)object3).toString();
            object = new XmlPullParserException((String)object2);
            throw object;
        }
        if ((n10 = arrayList2.size()) > 0) {
            object = new GradientColorInflaterCompat$ColorStops(arrayList2, arrayList);
            return object;
        }
        return null;
    }

    private static Shader.TileMode parseTileMode(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                return Shader.TileMode.CLAMP;
            }
            return Shader.TileMode.MIRROR;
        }
        return Shader.TileMode.REPEAT;
    }
}

