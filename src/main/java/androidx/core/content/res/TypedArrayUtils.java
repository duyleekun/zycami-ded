/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.util.TypedValue
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.content.res.ColorStateListInflaterCompat;
import androidx.core.content.res.ComplexColorCompat;
import org.xmlpull.v1.XmlPullParser;

public class TypedArrayUtils {
    private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";

    private TypedArrayUtils() {
    }

    public static int getAttr(Context context, int n10, int n11) {
        TypedValue typedValue = new TypedValue();
        context = context.getTheme();
        boolean bl2 = true;
        context.resolveAttribute(n10, typedValue, bl2);
        int n12 = typedValue.resourceId;
        if (n12 != 0) {
            return n10;
        }
        return n11;
    }

    public static boolean getBoolean(TypedArray typedArray, int n10, int n11, boolean bl2) {
        n11 = (int)(typedArray.getBoolean(n11, bl2) ? 1 : 0);
        return typedArray.getBoolean(n10, n11 != 0);
    }

    public static Drawable getDrawable(TypedArray typedArray, int n10, int n11) {
        Drawable drawable2 = typedArray.getDrawable(n10);
        if (drawable2 == null) {
            drawable2 = typedArray.getDrawable(n11);
        }
        return drawable2;
    }

    public static int getInt(TypedArray typedArray, int n10, int n11, int n12) {
        n11 = typedArray.getInt(n11, n12);
        return typedArray.getInt(n10, n11);
    }

    public static boolean getNamedBoolean(TypedArray typedArray, XmlPullParser xmlPullParser, String string2, int n10, boolean bl2) {
        boolean bl3 = TypedArrayUtils.hasAttribute(xmlPullParser, string2);
        if (!bl3) {
            return bl2;
        }
        return typedArray.getBoolean(n10, bl2);
    }

    public static int getNamedColor(TypedArray typedArray, XmlPullParser xmlPullParser, String string2, int n10, int n11) {
        boolean bl2 = TypedArrayUtils.hasAttribute(xmlPullParser, string2);
        if (!bl2) {
            return n11;
        }
        return typedArray.getColor(n10, n11);
    }

    public static ColorStateList getNamedColorStateList(TypedArray object, XmlPullParser object2, Resources.Theme object3, String string2, int n10) {
        boolean bl2 = TypedArrayUtils.hasAttribute(object2, string2);
        if (bl2) {
            object2 = new TypedValue();
            object.getValue(n10, (TypedValue)object2);
            int n11 = object2.type;
            int n12 = 2;
            if (n11 != n12) {
                n12 = 28;
                if (n11 >= n12 && n11 <= (n12 = 31)) {
                    return TypedArrayUtils.getNamedColorStateListFromInt((TypedValue)object2);
                }
                object2 = object.getResources();
                int n13 = object.getResourceId(n10, 0);
                return ColorStateListInflaterCompat.inflate((Resources)object2, n13, (Resources.Theme)object3);
            }
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("Failed to resolve attribute at index ");
            ((StringBuilder)object3).append(n10);
            ((StringBuilder)object3).append(": ");
            ((StringBuilder)object3).append(object2);
            object2 = ((StringBuilder)object3).toString();
            object = new UnsupportedOperationException((String)object2);
            throw object;
        }
        return null;
    }

    private static ColorStateList getNamedColorStateListFromInt(TypedValue typedValue) {
        return ColorStateList.valueOf((int)typedValue.data);
    }

    public static ComplexColorCompat getNamedComplexColor(TypedArray object, XmlPullParser xmlPullParser, Resources.Theme theme, String string2, int n10, int n11) {
        boolean bl2 = TypedArrayUtils.hasAttribute(xmlPullParser, string2);
        if (bl2) {
            xmlPullParser = new TypedValue();
            object.getValue(n10, (TypedValue)xmlPullParser);
            int n12 = xmlPullParser.type;
            int n13 = 28;
            if (n12 >= n13 && n12 <= (n13 = 31)) {
                return ComplexColorCompat.from(xmlPullParser.data);
            }
            xmlPullParser = object.getResources();
            n12 = 0;
            string2 = null;
            int n14 = object.getResourceId(n10, 0);
            if ((object = ComplexColorCompat.inflate((Resources)xmlPullParser, n14, theme)) != null) {
                return object;
            }
        }
        return ComplexColorCompat.from(n11);
    }

    public static float getNamedFloat(TypedArray typedArray, XmlPullParser xmlPullParser, String string2, int n10, float f10) {
        boolean bl2 = TypedArrayUtils.hasAttribute(xmlPullParser, string2);
        if (!bl2) {
            return f10;
        }
        return typedArray.getFloat(n10, f10);
    }

    public static int getNamedInt(TypedArray typedArray, XmlPullParser xmlPullParser, String string2, int n10, int n11) {
        boolean bl2 = TypedArrayUtils.hasAttribute(xmlPullParser, string2);
        if (!bl2) {
            return n11;
        }
        return typedArray.getInt(n10, n11);
    }

    public static int getNamedResourceId(TypedArray typedArray, XmlPullParser xmlPullParser, String string2, int n10, int n11) {
        boolean bl2 = TypedArrayUtils.hasAttribute(xmlPullParser, string2);
        if (!bl2) {
            return n11;
        }
        return typedArray.getResourceId(n10, n11);
    }

    public static String getNamedString(TypedArray typedArray, XmlPullParser xmlPullParser, String string2, int n10) {
        boolean bl2 = TypedArrayUtils.hasAttribute(xmlPullParser, string2);
        if (!bl2) {
            return null;
        }
        return typedArray.getString(n10);
    }

    public static int getResourceId(TypedArray typedArray, int n10, int n11, int n12) {
        n11 = typedArray.getResourceId(n11, n12);
        return typedArray.getResourceId(n10, n11);
    }

    public static String getString(TypedArray typedArray, int n10, int n11) {
        String string2 = typedArray.getString(n10);
        if (string2 == null) {
            string2 = typedArray.getString(n11);
        }
        return string2;
    }

    public static CharSequence getText(TypedArray typedArray, int n10, int n11) {
        CharSequence charSequence = typedArray.getText(n10);
        if (charSequence == null) {
            charSequence = typedArray.getText(n11);
        }
        return charSequence;
    }

    public static CharSequence[] getTextArray(TypedArray typedArray, int n10, int n11) {
        CharSequence[] charSequenceArray = typedArray.getTextArray(n10);
        if (charSequenceArray == null) {
            charSequenceArray = typedArray.getTextArray(n11);
        }
        return charSequenceArray;
    }

    public static boolean hasAttribute(XmlPullParser object, String string2) {
        boolean bl2;
        String string3 = NAMESPACE;
        if ((object = object.getAttributeValue(string3, string2)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static TypedArray obtainAttributes(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] nArray) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, nArray);
        }
        return theme.obtainStyledAttributes(attributeSet, nArray, 0, 0);
    }

    public static TypedValue peekNamedValue(TypedArray typedArray, XmlPullParser xmlPullParser, String string2, int n10) {
        boolean bl2 = TypedArrayUtils.hasAttribute(xmlPullParser, string2);
        if (!bl2) {
            return null;
        }
        return typedArray.peekValue(n10);
    }
}

