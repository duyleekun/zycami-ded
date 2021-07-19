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
import androidx.appcompat.R$attr;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle$Delegate;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.widget.TintTypedArray;

public class AppCompatDelegateImpl$ActionBarDrawableToggleImpl
implements ActionBarDrawerToggle$Delegate {
    public final /* synthetic */ AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl$ActionBarDrawableToggleImpl(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    public Context getActionBarThemedContext() {
        return this.this$0.getActionBarThemedContext();
    }

    public Drawable getThemeUpIndicator() {
        Object object = this.getActionBarThemedContext();
        int n10 = R$attr.homeAsUpIndicator;
        Object object2 = new int[]{n10};
        object = TintTypedArray.obtainStyledAttributes((Context)object, null, object2);
        object2 = ((TintTypedArray)object).getDrawable(0);
        ((TintTypedArray)object).recycle();
        return object2;
    }

    public boolean isNavigationVisible() {
        boolean bl2;
        ActionBar actionBar = this.this$0.getSupportActionBar();
        if (actionBar != null && (bl2 = actionBar.getDisplayOptions() & 4)) {
            bl2 = true;
        } else {
            bl2 = false;
            actionBar = null;
        }
        return bl2;
    }

    public void setActionBarDescription(int n10) {
        ActionBar actionBar = this.this$0.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeActionContentDescription(n10);
        }
    }

    public void setActionBarUpIndicator(Drawable drawable2, int n10) {
        ActionBar actionBar = this.this$0.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(drawable2);
            actionBar.setHomeActionContentDescription(n10);
        }
    }
}

