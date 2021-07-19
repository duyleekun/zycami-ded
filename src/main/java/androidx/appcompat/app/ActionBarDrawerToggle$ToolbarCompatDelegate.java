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
import androidx.appcompat.app.ActionBarDrawerToggle$Delegate;
import androidx.appcompat.widget.Toolbar;

public class ActionBarDrawerToggle$ToolbarCompatDelegate
implements ActionBarDrawerToggle$Delegate {
    public final CharSequence mDefaultContentDescription;
    public final Drawable mDefaultUpIndicator;
    public final Toolbar mToolbar;

    public ActionBarDrawerToggle$ToolbarCompatDelegate(Toolbar object) {
        Drawable drawable2;
        this.mToolbar = object;
        this.mDefaultUpIndicator = drawable2 = object.getNavigationIcon();
        object = object.getNavigationContentDescription();
        this.mDefaultContentDescription = object;
    }

    public Context getActionBarThemedContext() {
        return this.mToolbar.getContext();
    }

    public Drawable getThemeUpIndicator() {
        return this.mDefaultUpIndicator;
    }

    public boolean isNavigationVisible() {
        return true;
    }

    public void setActionBarDescription(int n10) {
        if (n10 == 0) {
            Toolbar toolbar = this.mToolbar;
            CharSequence charSequence = this.mDefaultContentDescription;
            toolbar.setNavigationContentDescription(charSequence);
        } else {
            Toolbar toolbar = this.mToolbar;
            toolbar.setNavigationContentDescription(n10);
        }
    }

    public void setActionBarUpIndicator(Drawable drawable2, int n10) {
        this.mToolbar.setNavigationIcon(drawable2);
        this.setActionBarDescription(n10);
    }
}

