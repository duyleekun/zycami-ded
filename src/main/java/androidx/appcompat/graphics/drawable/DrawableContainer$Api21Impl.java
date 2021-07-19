/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.Outline
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 */
package androidx.appcompat.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

public class DrawableContainer$Api21Impl {
    private DrawableContainer$Api21Impl() {
    }

    public static boolean canApplyTheme(Drawable.ConstantState constantState) {
        return constantState.canApplyTheme();
    }

    public static void getOutline(Drawable drawable2, Outline outline) {
        drawable2.getOutline(outline);
    }

    public static Resources getResources(Resources.Theme theme) {
        return theme.getResources();
    }
}

