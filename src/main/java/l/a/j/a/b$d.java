/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.util.Log
 *  org.xmlpull.v1.XmlPullParser
 */
package l.a.j.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import l.a.j.a.b$c;
import org.xmlpull.v1.XmlPullParser;

public class b$d
implements b$c {
    public Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        try {
            context = context.getResources();
        }
        catch (Exception exception) {
            Log.e((String)"VdcInflateDelegate", (String)"Exception while inflating <vector>", (Throwable)exception);
            return null;
        }
        return VectorDrawableCompat.createFromXmlInner((Resources)context, xmlPullParser, attributeSet, theme);
    }
}

