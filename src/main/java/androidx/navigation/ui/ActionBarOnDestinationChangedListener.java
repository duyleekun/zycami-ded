/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 */
package androidx.navigation.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AbstractAppBarOnDestinationChangedListener;
import androidx.navigation.ui.AppBarConfiguration;

public class ActionBarOnDestinationChangedListener
extends AbstractAppBarOnDestinationChangedListener {
    private final AppCompatActivity mActivity;

    public ActionBarOnDestinationChangedListener(AppCompatActivity appCompatActivity, AppBarConfiguration appBarConfiguration) {
        Context context = appCompatActivity.getDrawerToggleDelegate().getActionBarThemedContext();
        super(context, appBarConfiguration);
        this.mActivity = appCompatActivity;
    }

    public void setNavigationIcon(Drawable drawable2, int n10) {
        Object object = this.mActivity.getSupportActionBar();
        if (drawable2 == null) {
            drawable2 = null;
            ((ActionBar)object).setDisplayHomeAsUpEnabled(false);
        } else {
            boolean bl2 = true;
            ((ActionBar)object).setDisplayHomeAsUpEnabled(bl2);
            object = this.mActivity.getDrawerToggleDelegate();
            object.setActionBarUpIndicator(drawable2, n10);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.mActivity.getSupportActionBar().setTitle(charSequence);
    }
}

