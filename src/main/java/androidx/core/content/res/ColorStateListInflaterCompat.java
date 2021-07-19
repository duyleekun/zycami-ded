/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.graphics.Color
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.StateSet
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import androidx.core.R$attr;
import androidx.core.R$styleable;
import androidx.core.content.res.GrowingArrayUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ColorStateListInflaterCompat {
    private ColorStateListInflaterCompat() {
    }

    public static ColorStateList createFromXml(Resources object, XmlPullParser xmlPullParser, Resources.Theme theme) {
        int n10;
        int n11;
        int n12;
        AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlPullParser);
        while ((n12 = xmlPullParser.next()) != (n11 = 2) && n12 != (n10 = 1)) {
        }
        if (n12 == n11) {
            return ColorStateListInflaterCompat.createFromXmlInner(object, xmlPullParser, attributeSet, theme);
        }
        object = new XmlPullParserException("No start tag found");
        throw object;
    }

    public static ColorStateList createFromXmlInner(Resources object, XmlPullParser object2, AttributeSet object3, Resources.Theme theme) {
        String string2;
        String string3 = object2.getName();
        boolean bl2 = string3.equals(string2 = "selector");
        if (bl2) {
            return ColorStateListInflaterCompat.inflate(object, object2, (AttributeSet)object3, theme);
        }
        object3 = new StringBuilder();
        object2 = object2.getPositionDescription();
        ((StringBuilder)object3).append((String)object2);
        ((StringBuilder)object3).append(": invalid color state list tag ");
        ((StringBuilder)object3).append(string3);
        object2 = ((StringBuilder)object3).toString();
        object = new XmlPullParserException((String)object2);
        throw object;
    }

    public static ColorStateList inflate(Resources resources, int n10, Resources.Theme theme) {
        XmlResourceParser xmlResourceParser;
        try {
            xmlResourceParser = resources.getXml(n10);
        }
        catch (Exception exception) {
            Log.e((String)"CSLCompat", (String)"Failed to inflate ColorStateList.", (Throwable)exception);
            return null;
        }
        return ColorStateListInflaterCompat.createFromXml(resources, (XmlPullParser)xmlResourceParser, theme);
    }

    private static ColorStateList inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Object[] objectArray;
        int n10;
        int n11;
        int n12;
        Object object = attributeSet;
        int n13 = xmlPullParser.getDepth();
        int n14 = 1;
        n13 += n14;
        int n15 = 20;
        Object object2 = new int[n15][];
        int[] nArray = new int[n15];
        int n16 = 0;
        while ((n12 = xmlPullParser.next()) != n14 && ((n11 = xmlPullParser.getDepth()) >= n13 || n12 != (n10 = 3))) {
            Object object3;
            Object object4;
            n10 = 2;
            if (n12 == n10 && n11 <= n13 && (n12 = (int)(((String)(object4 = xmlPullParser.getName())).equals(object3 = "item") ? 1 : 0)) != 0) {
                object4 = R$styleable.ColorStateListItem;
                object3 = resources;
                object4 = ColorStateListInflaterCompat.obtainAttributes(resources, theme, object, (int[])object4);
                int n17 = R$styleable.ColorStateListItem_android_color;
                n17 = object4.getColor(n17, -65281);
                float f10 = 1.0f;
                int n18 = R$styleable.ColorStateListItem_android_alpha;
                int n19 = object4.hasValue(n18);
                if (n19 != 0) {
                    f10 = object4.getFloat(n18, f10);
                } else {
                    n18 = R$styleable.ColorStateListItem_alpha;
                    n19 = object4.hasValue(n18);
                    if (n19 != 0) {
                        f10 = object4.getFloat(n18, f10);
                    }
                }
                object4.recycle();
                n12 = attributeSet.getAttributeCount();
                int[] nArray2 = new int[n12];
                int n20 = 0;
                for (n19 = 0; n19 < n12; ++n19) {
                    int n21 = object.getAttributeNameResource(n19);
                    if (n21 != (n14 = 16843173) && n21 != (n14 = 16843551) && n21 != (n14 = R$attr.alpha)) {
                        n14 = n20 + 1;
                        boolean bl2 = object.getAttributeBooleanValue(n19, false);
                        if (!bl2) {
                            n21 = -n21;
                        }
                        nArray2[n20] = n21;
                        n20 = n14;
                    }
                    n14 = 1;
                }
                objectArray = StateSet.trimStateSet((int[])nArray2, (int)n20);
                n12 = ColorStateListInflaterCompat.modulateColorAlpha(n17, f10);
                nArray = GrowingArrayUtils.append(nArray, n16, n12);
                objectArray = GrowingArrayUtils.append((Object[])object2, n16, objectArray);
                object2 = objectArray;
                object2 = (int[][])objectArray;
                ++n16;
            } else {
                object3 = resources;
            }
            n14 = 1;
        }
        object = new int[n16];
        int[][] nArrayArray = new int[n16][];
        System.arraycopy(nArray, 0, object, 0, n16);
        System.arraycopy(object2, 0, nArrayArray, 0, n16);
        objectArray = new ColorStateList((int[][])nArrayArray, (int[])object);
        return objectArray;
    }

    private static int modulateColorAlpha(int n10, float f10) {
        int n11 = Math.round((float)Color.alpha((int)n10) * f10);
        return (n10 &= 0xFFFFFF) | (n11 <<= 24);
    }

    private static TypedArray obtainAttributes(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] nArray) {
        resources = theme == null ? resources.obtainAttributes(attributeSet, nArray) : theme.obtainStyledAttributes(attributeSet, nArray, 0, 0);
        return resources;
    }
}

