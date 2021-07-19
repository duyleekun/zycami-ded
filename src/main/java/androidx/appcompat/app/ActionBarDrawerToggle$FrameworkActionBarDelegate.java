/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActionBar
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 */
package androidx.appcompat.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.appcompat.app.ActionBarDrawerToggle$Delegate;
import androidx.appcompat.app.ActionBarDrawerToggleHoneycomb;
import androidx.appcompat.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo;

public class ActionBarDrawerToggle$FrameworkActionBarDelegate
implements ActionBarDrawerToggle$Delegate {
    private final Activity mActivity;
    private ActionBarDrawerToggleHoneycomb$SetIndicatorInfo mSetIndicatorInfo;

    public ActionBarDrawerToggle$FrameworkActionBarDelegate(Activity activity) {
        this.mActivity = activity;
    }

    public Context getActionBarThemedContext() {
        ActionBar actionBar = this.mActivity.getActionBar();
        if (actionBar != null) {
            return actionBar.getThemedContext();
        }
        return this.mActivity;
    }

    public Drawable getThemeUpIndicator() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            Context context = this.getActionBarThemedContext();
            int[] nArray = new int[]{16843531};
            context = context.obtainStyledAttributes(null, nArray, 16843470, 0);
            Drawable drawable2 = context.getDrawable(0);
            context.recycle();
            return drawable2;
        }
        return ActionBarDrawerToggleHoneycomb.getThemeUpIndicator(this.mActivity);
    }

    public boolean isNavigationVisible() {
        boolean bl2;
        ActionBar actionBar = this.mActivity.getActionBar();
        if (actionBar != null && (bl2 = actionBar.getDisplayOptions() & 4)) {
            bl2 = true;
        } else {
            bl2 = false;
            actionBar = null;
        }
        return bl2;
    }

    public void setActionBarDescription(int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 18;
        if (n11 >= n12) {
            ActionBar actionBar = this.mActivity.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(n10);
            }
        } else {
            ActionBarDrawerToggleHoneycomb$SetIndicatorInfo actionBarDrawerToggleHoneycomb$SetIndicatorInfo;
            ActionBarDrawerToggleHoneycomb$SetIndicatorInfo actionBarDrawerToggleHoneycomb$SetIndicatorInfo2 = this.mSetIndicatorInfo;
            Activity activity = this.mActivity;
            this.mSetIndicatorInfo = actionBarDrawerToggleHoneycomb$SetIndicatorInfo = ActionBarDrawerToggleHoneycomb.setActionBarDescription(actionBarDrawerToggleHoneycomb$SetIndicatorInfo2, activity, n10);
        }
    }

    public void setActionBarUpIndicator(Drawable object, int n10) {
        ActionBar actionBar = this.mActivity.getActionBar();
        if (actionBar != null) {
            int n11 = Build.VERSION.SDK_INT;
            int n12 = 18;
            if (n11 >= n12) {
                actionBar.setHomeAsUpIndicator(object);
                actionBar.setHomeActionContentDescription(n10);
            } else {
                n11 = 1;
                actionBar.setDisplayShowHomeEnabled(n11 != 0);
                Activity activity = this.mActivity;
                object = ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(activity, object, n10);
                this.mSetIndicatorInfo = object;
                object = null;
                actionBar.setDisplayShowHomeEnabled(false);
            }
        }
    }
}

