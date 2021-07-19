/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.util.Log
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package androidx.appcompat.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBarDrawerToggle$Delegate;
import androidx.appcompat.app.ActionBarDrawerToggle$DelegateProvider;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.drawerlayout.widget.DrawerLayout$DrawerListener;

public class ActionBarDrawerToggle
implements DrawerLayout$DrawerListener {
    private final ActionBarDrawerToggle$Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    public boolean mDrawerIndicatorEnabled;
    private final DrawerLayout mDrawerLayout;
    private boolean mDrawerSlideAnimationEnabled;
    private boolean mHasCustomUpIndicator;
    private Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private DrawerArrowDrawable mSlider;
    public View.OnClickListener mToolbarNavigationClickListener;
    private boolean mWarnedForDisplayHomeAsUp;

    public ActionBarDrawerToggle(Activity object, Toolbar object2, DrawerLayout drawerLayout, DrawerArrowDrawable drawerArrowDrawable, int n10, int n11) {
        boolean bl2;
        this.mDrawerSlideAnimationEnabled = bl2 = true;
        this.mDrawerIndicatorEnabled = bl2;
        bl2 = false;
        this.mWarnedForDisplayHomeAsUp = false;
        if (object2 != null) {
            super((Toolbar)((Object)object2));
            this.mActivityImpl = object;
            super(this);
            ((Toolbar)((Object)object2)).setNavigationOnClickListener((View.OnClickListener)object);
        } else {
            boolean bl3 = object instanceof ActionBarDrawerToggle$DelegateProvider;
            if (bl3) {
                object = ((ActionBarDrawerToggle$DelegateProvider)object).getDrawerToggleDelegate();
                this.mActivityImpl = object;
            } else {
                super((Activity)object);
                this.mActivityImpl = object2;
            }
        }
        this.mDrawerLayout = drawerLayout;
        this.mOpenDrawerContentDescRes = n10;
        this.mCloseDrawerContentDescRes = n11;
        if (drawerArrowDrawable == null) {
            object2 = this.mActivityImpl.getActionBarThemedContext();
            super((Context)object2);
            this.mSlider = object;
        } else {
            this.mSlider = drawerArrowDrawable;
        }
        object = this.getThemeUpIndicator();
        this.mHomeAsUpIndicator = object;
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, int n10, int n11) {
        this(activity, null, drawerLayout, null, n10, n11);
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, int n10, int n11) {
        this(activity, toolbar, drawerLayout, null, n10, n11);
    }

    private void setPosition(float f10) {
        float f11 = 1.0f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            DrawerArrowDrawable drawerArrowDrawable = this.mSlider;
            boolean bl2 = true;
            drawerArrowDrawable.setVerticalMirror(bl2);
        } else {
            f11 = 0.0f;
            DrawerArrowDrawable drawerArrowDrawable = null;
            float f13 = f10 - 0.0f;
            object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
            if (object == false) {
                drawerArrowDrawable = this.mSlider;
                boolean bl3 = false;
                drawerArrowDrawable.setVerticalMirror(false);
            }
        }
        this.mSlider.setProgress(f10);
    }

    public DrawerArrowDrawable getDrawerArrowDrawable() {
        return this.mSlider;
    }

    public Drawable getThemeUpIndicator() {
        return this.mActivityImpl.getThemeUpIndicator();
    }

    public View.OnClickListener getToolbarNavigationClickListener() {
        return this.mToolbarNavigationClickListener;
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }

    public boolean isDrawerSlideAnimationEnabled() {
        return this.mDrawerSlideAnimationEnabled;
    }

    public void onConfigurationChanged(Configuration configuration) {
        boolean bl2 = this.mHasCustomUpIndicator;
        if (!bl2) {
            configuration = this.getThemeUpIndicator();
            this.mHomeAsUpIndicator = configuration;
        }
        this.syncState();
    }

    public void onDrawerClosed(View view) {
        this.setPosition(0.0f);
        int n10 = this.mDrawerIndicatorEnabled;
        if (n10 != 0) {
            n10 = this.mOpenDrawerContentDescRes;
            this.setActionBarDescription(n10);
        }
    }

    public void onDrawerOpened(View view) {
        float f10 = 1.0f;
        this.setPosition(f10);
        int n10 = this.mDrawerIndicatorEnabled;
        if (n10 != 0) {
            n10 = this.mCloseDrawerContentDescRes;
            this.setActionBarDescription(n10);
        }
    }

    public void onDrawerSlide(View view, float f10) {
        int n10 = this.mDrawerSlideAnimationEnabled;
        if (n10 != 0) {
            n10 = 1065353216;
            f10 = Math.max(0.0f, f10);
            float f11 = Math.min(1.0f, f10);
            this.setPosition(f11);
        } else {
            this.setPosition(0.0f);
        }
    }

    public void onDrawerStateChanged(int n10) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int n10;
        int n11;
        if (menuItem != null && (n11 = menuItem.getItemId()) == (n10 = 16908332) && (n11 = (int)(this.mDrawerIndicatorEnabled ? 1 : 0)) != 0) {
            this.toggle();
            return true;
        }
        return false;
    }

    public void setActionBarDescription(int n10) {
        this.mActivityImpl.setActionBarDescription(n10);
    }

    public void setActionBarUpIndicator(Drawable drawable2, int n10) {
        Object object;
        boolean bl2 = this.mWarnedForDisplayHomeAsUp;
        if (!bl2 && !(bl2 = (object = this.mActivityImpl).isNavigationVisible())) {
            object = "ActionBarDrawerToggle";
            String string2 = "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);";
            Log.w((String)object, (String)string2);
            this.mWarnedForDisplayHomeAsUp = bl2 = true;
        }
        this.mActivityImpl.setActionBarUpIndicator(drawable2, n10);
    }

    public void setDrawerArrowDrawable(DrawerArrowDrawable drawerArrowDrawable) {
        this.mSlider = drawerArrowDrawable;
        this.syncState();
    }

    public void setDrawerIndicatorEnabled(boolean bl2) {
        boolean bl3 = this.mDrawerIndicatorEnabled;
        if (bl2 != bl3) {
            if (bl2) {
                DrawerArrowDrawable drawerArrowDrawable = this.mSlider;
                DrawerLayout drawerLayout = this.mDrawerLayout;
                int n10 = 0x800003;
                int n11 = drawerLayout.isDrawerOpen(n10);
                n11 = n11 != 0 ? this.mCloseDrawerContentDescRes : this.mOpenDrawerContentDescRes;
                this.setActionBarUpIndicator(drawerArrowDrawable, n11);
            } else {
                Drawable drawable2 = this.mHomeAsUpIndicator;
                boolean bl4 = false;
                Object var4_6 = null;
                this.setActionBarUpIndicator(drawable2, 0);
            }
            this.mDrawerIndicatorEnabled = bl2;
        }
    }

    public void setDrawerSlideAnimationEnabled(boolean bl2) {
        this.mDrawerSlideAnimationEnabled = bl2;
        if (!bl2) {
            bl2 = false;
            this.setPosition(0.0f);
        }
    }

    public void setHomeAsUpIndicator(int n10) {
        Drawable drawable2;
        if (n10 != 0) {
            Resources resources = this.mDrawerLayout.getResources();
            drawable2 = resources.getDrawable(n10);
        } else {
            n10 = 0;
            drawable2 = null;
        }
        this.setHomeAsUpIndicator(drawable2);
    }

    public void setHomeAsUpIndicator(Drawable drawable2) {
        boolean bl2;
        if (drawable2 == null) {
            this.mHomeAsUpIndicator = drawable2 = this.getThemeUpIndicator();
            this.mHasCustomUpIndicator = false;
        } else {
            this.mHomeAsUpIndicator = drawable2;
            this.mHasCustomUpIndicator = bl2 = true;
        }
        bl2 = this.mDrawerIndicatorEnabled;
        if (!bl2) {
            drawable2 = this.mHomeAsUpIndicator;
            this.setActionBarUpIndicator(drawable2, 0);
        }
    }

    public void setToolbarNavigationClickListener(View.OnClickListener onClickListener) {
        this.mToolbarNavigationClickListener = onClickListener;
    }

    public void syncState() {
        Object object = this.mDrawerLayout;
        int n10 = 0x800003;
        int n11 = object.isDrawerOpen(n10);
        if (n11 != 0) {
            n11 = 1065353216;
            float f10 = 1.0f;
            this.setPosition(f10);
        } else {
            n11 = 0;
            float f11 = 0.0f;
            object = null;
            this.setPosition(0.0f);
        }
        n11 = (int)(this.mDrawerIndicatorEnabled ? 1 : 0);
        if (n11 != 0) {
            object = this.mSlider;
            DrawerLayout drawerLayout = this.mDrawerLayout;
            n10 = (n10 = (int)(drawerLayout.isDrawerOpen(n10) ? 1 : 0)) != 0 ? this.mCloseDrawerContentDescRes : this.mOpenDrawerContentDescRes;
            this.setActionBarUpIndicator((Drawable)object, n10);
        }
    }

    public void toggle() {
        DrawerLayout drawerLayout = this.mDrawerLayout;
        int n10 = 0x800003;
        int n11 = drawerLayout.getDrawerLockMode(n10);
        DrawerLayout drawerLayout2 = this.mDrawerLayout;
        int n12 = drawerLayout2.isDrawerVisible(n10);
        if (n12 != 0 && n11 != (n12 = 2)) {
            drawerLayout = this.mDrawerLayout;
            drawerLayout.closeDrawer(n10);
        } else {
            n12 = 1;
            if (n11 != n12) {
                drawerLayout = this.mDrawerLayout;
                drawerLayout.openDrawer(n10);
            }
        }
    }
}

