/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 */
package d.c.a.o.m.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

public final class a {
    private static volatile boolean a = true;

    private a() {
    }

    public static Drawable a(Context context, int n10, Resources.Theme theme) {
        return d.c.a.o.m.f.a.c(context, context, n10, theme);
    }

    public static Drawable b(Context context, Context context2, int n10) {
        return d.c.a.o.m.f.a.c(context, context2, n10, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Drawable c(Context object, Context context, int n10, Resources.Theme theme) {
        try {
            boolean bl2 = a;
            if (bl2) {
                return d.c.a.o.m.f.a.e(context, n10, theme);
            }
        }
        catch (IllegalStateException illegalStateException) {
            object = object.getPackageName();
            String string2 = context.getPackageName();
            boolean bl3 = ((String)object).equals(string2);
            if (bl3) throw illegalStateException;
            return ContextCompat.getDrawable(context, n10);
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            boolean bl4 = false;
            object = null;
            a = false;
        }
        catch (Resources.NotFoundException notFoundException) {}
        if (theme != null) {
            return d.c.a.o.m.f.a.d(context, n10, theme);
        }
        theme = context.getTheme();
        return d.c.a.o.m.f.a.d(context, n10, theme);
    }

    private static Drawable d(Context context, int n10, Resources.Theme theme) {
        return ResourcesCompat.getDrawable(context.getResources(), n10, theme);
    }

    private static Drawable e(Context object, int n10, Resources.Theme theme) {
        if (theme != null) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper((Context)object, theme);
            object = contextThemeWrapper;
        }
        return AppCompatResources.getDrawable(object, n10);
    }
}

