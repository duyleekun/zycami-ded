/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.DrawableContainer
 *  android.graphics.drawable.DrawableContainer$DrawableContainerState
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.InsetDrawable
 *  android.graphics.drawable.LayerDrawable
 *  android.graphics.drawable.ScaleDrawable
 *  android.os.Build$VERSION
 */
package l.a.j.a;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import l.a.j.a.e;
import l.a.o.b;

public class c {
    private static final String a = "android.graphics.drawable.VectorDrawable";

    public static boolean a(Drawable drawable2) {
        boolean bl2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 15;
        if (n10 < n11 && (bl2 = drawable2 instanceof InsetDrawable)) {
            return false;
        }
        if (n10 < n11 && (n11 = drawable2 instanceof GradientDrawable) != 0) {
            return false;
        }
        n11 = 17;
        if (n10 < n11 && (n10 = drawable2 instanceof LayerDrawable) != 0) {
            return false;
        }
        n10 = drawable2 instanceof DrawableContainer;
        if (n10 != 0) {
            n10 = (drawable2 = drawable2.getConstantState()) instanceof DrawableContainer.DrawableContainerState;
            if (n10 != 0) {
                for (Drawable drawable3 : ((DrawableContainer.DrawableContainerState)drawable2).getChildren()) {
                    bl2 = c.a(drawable3);
                    if (bl2) continue;
                    return false;
                }
            }
        } else {
            n10 = (int)(b.g(drawable2) ? 1 : 0);
            if (n10 != 0) {
                return c.a(b.a(drawable2));
            }
            n10 = (int)(b.h(drawable2) ? 1 : 0);
            if (n10 != 0) {
                return c.a(b.b(drawable2));
            }
            n10 = (int)(b.i(drawable2) ? 1 : 0);
            if (n10 != 0) {
                return c.a(b.c(drawable2));
            }
            n10 = drawable2 instanceof ScaleDrawable;
            if (n10 != 0 && (drawable2 = ((ScaleDrawable)drawable2).getDrawable()) != null) {
                return c.a(drawable2);
            }
        }
        return true;
    }

    public static void b(Drawable drawable2) {
        String string2;
        String string3;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 == n11 && (n10 = (int)((string3 = a).equals(string2 = drawable2.getClass().getName()) ? 1 : 0)) != 0) {
            c.c(drawable2);
        }
    }

    private static void c(Drawable drawable2) {
        int n10;
        int[] nArray = drawable2.getState();
        if (nArray != null && (n10 = nArray.length) != 0) {
            int[] nArray2 = e.o;
            drawable2.setState(nArray2);
        } else {
            int[] nArray3 = e.l;
            drawable2.setState(nArray3);
        }
        drawable2.setState(nArray);
    }
}

