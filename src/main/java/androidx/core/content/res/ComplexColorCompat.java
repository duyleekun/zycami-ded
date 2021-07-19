/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.Shader
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.core.content.res.ColorStateListInflaterCompat;
import androidx.core.content.res.GradientColorInflaterCompat;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ComplexColorCompat {
    private static final String LOG_TAG = "ComplexColorCompat";
    private int mColor;
    private final ColorStateList mColorStateList;
    private final Shader mShader;

    private ComplexColorCompat(Shader shader, ColorStateList colorStateList, int n10) {
        this.mShader = shader;
        this.mColorStateList = colorStateList;
        this.mColor = n10;
    }

    private static ComplexColorCompat createFromXml(Resources object, int n10, Resources.Theme object2) {
        int n11;
        int n12;
        int n13;
        Object object3 = object.getXml(n10);
        AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)object3);
        while ((n13 = object3.next()) != (n12 = 2) && n13 != (n11 = 1)) {
        }
        if (n13 == n12) {
            String string2 = object3.getName();
            string2.hashCode();
            String string3 = "gradient";
            n12 = (int)(string2.equals(string3) ? 1 : 0);
            if (n12 == 0) {
                string3 = "selector";
                n12 = (int)(string2.equals(string3) ? 1 : 0);
                if (n12 != 0) {
                    return ComplexColorCompat.from(ColorStateListInflaterCompat.createFromXmlInner(object, (XmlPullParser)object3, attributeSet, (Resources.Theme)object2));
                }
                object2 = new StringBuilder();
                object3 = object3.getPositionDescription();
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append(": unsupported complex color tag ");
                ((StringBuilder)object2).append(string2);
                object3 = ((StringBuilder)object2).toString();
                object = new XmlPullParserException((String)object3);
                throw object;
            }
            return ComplexColorCompat.from(GradientColorInflaterCompat.createFromXmlInner(object, (XmlPullParser)object3, attributeSet, (Resources.Theme)object2));
        }
        object = new XmlPullParserException("No start tag found");
        throw object;
    }

    public static ComplexColorCompat from(int n10) {
        ComplexColorCompat complexColorCompat = new ComplexColorCompat(null, null, n10);
        return complexColorCompat;
    }

    public static ComplexColorCompat from(ColorStateList colorStateList) {
        int n10 = colorStateList.getDefaultColor();
        ComplexColorCompat complexColorCompat = new ComplexColorCompat(null, colorStateList, n10);
        return complexColorCompat;
    }

    public static ComplexColorCompat from(Shader shader) {
        ComplexColorCompat complexColorCompat = new ComplexColorCompat(shader, null, 0);
        return complexColorCompat;
    }

    public static ComplexColorCompat inflate(Resources resources, int n10, Resources.Theme theme) {
        try {
            return ComplexColorCompat.createFromXml(resources, n10, theme);
        }
        catch (Exception exception) {
            Log.e((String)LOG_TAG, (String)"Failed to inflate ComplexColor.", (Throwable)exception);
            return null;
        }
    }

    public int getColor() {
        return this.mColor;
    }

    public Shader getShader() {
        return this.mShader;
    }

    public boolean isGradient() {
        boolean bl2;
        Shader shader = this.mShader;
        if (shader != null) {
            bl2 = true;
        } else {
            bl2 = false;
            shader = null;
        }
        return bl2;
    }

    public boolean isStateful() {
        boolean bl2;
        Shader shader = this.mShader;
        if (shader == null && (shader = this.mColorStateList) != null && (bl2 = shader.isStateful())) {
            bl2 = true;
        } else {
            bl2 = false;
            shader = null;
        }
        return bl2;
    }

    public boolean onStateChanged(int[] nArray) {
        int n10;
        ColorStateList colorStateList;
        int n11;
        int n12 = this.isStateful();
        if (n12 != 0 && (n11 = (colorStateList = this.mColorStateList).getColorForState(nArray, n10 = colorStateList.getDefaultColor())) != (n12 = this.mColor)) {
            n12 = 1;
            this.mColor = n11;
        } else {
            n12 = 0;
            colorStateList = null;
        }
        return n12 != 0;
    }

    public void setColor(int n10) {
        this.mColor = n10;
    }

    public boolean willDraw() {
        boolean bl2 = this.isGradient();
        bl2 = bl2 || (bl2 = this.mColor);
        return bl2;
    }
}

