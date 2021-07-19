/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 */
package androidx.appcompat.app;

import android.content.Context;
import android.graphics.drawable.Drawable;

public interface ActionBarDrawerToggle$Delegate {
    public Context getActionBarThemedContext();

    public Drawable getThemeUpIndicator();

    public boolean isNavigationVisible();

    public void setActionBarDescription(int var1);

    public void setActionBarUpIndicator(Drawable var1, int var2);
}

