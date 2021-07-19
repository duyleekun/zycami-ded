/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.graphics.drawable.Drawable
 *  android.view.KeyEvent
 *  android.view.View
 *  android.widget.SpinnerAdapter
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.ActionBar$LayoutParams;
import androidx.appcompat.app.ActionBar$OnMenuVisibilityListener;
import androidx.appcompat.app.ActionBar$OnNavigationListener;
import androidx.appcompat.app.ActionBar$Tab;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ActionMode$Callback;

public abstract class ActionBar {
    public static final int DISPLAY_HOME_AS_UP = 4;
    public static final int DISPLAY_SHOW_CUSTOM = 16;
    public static final int DISPLAY_SHOW_HOME = 2;
    public static final int DISPLAY_SHOW_TITLE = 8;
    public static final int DISPLAY_USE_LOGO = 1;
    public static final int NAVIGATION_MODE_LIST = 1;
    public static final int NAVIGATION_MODE_STANDARD = 0;
    public static final int NAVIGATION_MODE_TABS = 2;

    public abstract void addOnMenuVisibilityListener(ActionBar$OnMenuVisibilityListener var1);

    public abstract void addTab(ActionBar$Tab var1);

    public abstract void addTab(ActionBar$Tab var1, int var2);

    public abstract void addTab(ActionBar$Tab var1, int var2, boolean var3);

    public abstract void addTab(ActionBar$Tab var1, boolean var2);

    public boolean closeOptionsMenu() {
        return false;
    }

    public boolean collapseActionView() {
        return false;
    }

    public void dispatchMenuVisibilityChanged(boolean bl2) {
    }

    public abstract View getCustomView();

    public abstract int getDisplayOptions();

    public float getElevation() {
        return 0.0f;
    }

    public abstract int getHeight();

    public int getHideOffset() {
        return 0;
    }

    public abstract int getNavigationItemCount();

    public abstract int getNavigationMode();

    public abstract int getSelectedNavigationIndex();

    public abstract ActionBar$Tab getSelectedTab();

    public abstract CharSequence getSubtitle();

    public abstract ActionBar$Tab getTabAt(int var1);

    public abstract int getTabCount();

    public Context getThemedContext() {
        return null;
    }

    public abstract CharSequence getTitle();

    public abstract void hide();

    public boolean invalidateOptionsMenu() {
        return false;
    }

    public boolean isHideOnContentScrollEnabled() {
        return false;
    }

    public abstract boolean isShowing();

    public boolean isTitleTruncated() {
        return false;
    }

    public abstract ActionBar$Tab newTab();

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onDestroy() {
    }

    public boolean onKeyShortcut(int n10, KeyEvent keyEvent) {
        return false;
    }

    public boolean onMenuKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    public boolean openOptionsMenu() {
        return false;
    }

    public abstract void removeAllTabs();

    public abstract void removeOnMenuVisibilityListener(ActionBar$OnMenuVisibilityListener var1);

    public abstract void removeTab(ActionBar$Tab var1);

    public abstract void removeTabAt(int var1);

    public boolean requestFocus() {
        return false;
    }

    public abstract void selectTab(ActionBar$Tab var1);

    public abstract void setBackgroundDrawable(Drawable var1);

    public abstract void setCustomView(int var1);

    public abstract void setCustomView(View var1);

    public abstract void setCustomView(View var1, ActionBar$LayoutParams var2);

    public void setDefaultDisplayHomeAsUpEnabled(boolean bl2) {
    }

    public abstract void setDisplayHomeAsUpEnabled(boolean var1);

    public abstract void setDisplayOptions(int var1);

    public abstract void setDisplayOptions(int var1, int var2);

    public abstract void setDisplayShowCustomEnabled(boolean var1);

    public abstract void setDisplayShowHomeEnabled(boolean var1);

    public abstract void setDisplayShowTitleEnabled(boolean var1);

    public abstract void setDisplayUseLogoEnabled(boolean var1);

    public void setElevation(float f10) {
        float f11 = f10 - 0.0f;
        float f12 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        if (f12 == false) {
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        throw unsupportedOperationException;
    }

    public void setHideOffset(int n10) {
        if (n10 == 0) {
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Setting an explicit action bar hide offset is not supported in this action bar configuration.");
        throw unsupportedOperationException;
    }

    public void setHideOnContentScrollEnabled(boolean bl2) {
        if (!bl2) {
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        throw unsupportedOperationException;
    }

    public void setHomeActionContentDescription(int n10) {
    }

    public void setHomeActionContentDescription(CharSequence charSequence) {
    }

    public void setHomeAsUpIndicator(int n10) {
    }

    public void setHomeAsUpIndicator(Drawable drawable2) {
    }

    public void setHomeButtonEnabled(boolean bl2) {
    }

    public abstract void setIcon(int var1);

    public abstract void setIcon(Drawable var1);

    public abstract void setListNavigationCallbacks(SpinnerAdapter var1, ActionBar$OnNavigationListener var2);

    public abstract void setLogo(int var1);

    public abstract void setLogo(Drawable var1);

    public abstract void setNavigationMode(int var1);

    public abstract void setSelectedNavigationItem(int var1);

    public void setShowHideAnimationEnabled(boolean bl2) {
    }

    public void setSplitBackgroundDrawable(Drawable drawable2) {
    }

    public void setStackedBackgroundDrawable(Drawable drawable2) {
    }

    public abstract void setSubtitle(int var1);

    public abstract void setSubtitle(CharSequence var1);

    public abstract void setTitle(int var1);

    public abstract void setTitle(CharSequence var1);

    public void setWindowTitle(CharSequence charSequence) {
    }

    public abstract void show();

    public ActionMode startActionMode(ActionMode.Callback callback) {
        return null;
    }
}

