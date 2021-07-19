/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.ResourceManagerInternal$InflateDelegate;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;

public class ResourceManagerInternal$DrawableDelegate
implements ResourceManagerInternal$InflateDelegate {
    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Drawable createFromXmlInner(Context context, XmlPullParser object, AttributeSet object2, Resources.Theme theme) {
        void var3_5;
        String string2 = var3_5.getClassAttribute();
        if (string2 == null) return null;
        Object[] objectArray = ResourceManagerInternal$DrawableDelegate.class;
        try {
            Drawable drawable2;
            objectArray = objectArray.getClassLoader();
            Class<?> clazz = objectArray.loadClass(string2);
            objectArray = Drawable.class;
            Class<Drawable> clazz2 = clazz.asSubclass(objectArray);
            int n10 = 0;
            objectArray = null;
            Class[] classArray = new Class[]{};
            Constructor<Drawable> constructor = clazz2.getDeclaredConstructor(classArray);
            objectArray = new Object[]{};
            Drawable drawable3 = drawable2 = constructor.newInstance(objectArray);
            n10 = Build.VERSION.SDK_INT;
            int n11 = 21;
            if (n10 >= n11) {
                void var4_7;
                context = context.getResources();
                drawable3.inflate((Resources)context, object, (AttributeSet)var3_5, (Resources.Theme)var4_7);
                return drawable3;
            }
            context = context.getResources();
            drawable3.inflate((Resources)context, object, (AttributeSet)var3_5);
            return drawable3;
        }
        catch (Exception exception) {
            String string3 = "DrawableDelegate";
            String string4 = "Exception while inflating <drawable>";
            Log.e((String)string3, (String)string4, (Throwable)exception);
        }
        return null;
    }
}

