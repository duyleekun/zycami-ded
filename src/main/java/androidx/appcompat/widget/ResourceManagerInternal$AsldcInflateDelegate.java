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
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.widget.ResourceManagerInternal$InflateDelegate;
import org.xmlpull.v1.XmlPullParser;

public class ResourceManagerInternal$AsldcInflateDelegate
implements ResourceManagerInternal$InflateDelegate {
    public Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Resources resources;
        try {
            resources = context.getResources();
        }
        catch (Exception exception) {
            Log.e((String)"AsldcInflateDelegate", (String)"Exception while inflating <animated-selector>", (Throwable)exception);
            return null;
        }
        return AnimatedStateListDrawableCompat.createFromXmlInner(context, resources, xmlPullParser, attributeSet, theme);
    }
}

