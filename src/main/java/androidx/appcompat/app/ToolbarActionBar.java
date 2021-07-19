/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.graphics.drawable.Drawable
 *  android.view.KeyCharacterMap
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window$Callback
 *  android.widget.SpinnerAdapter
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBar$LayoutParams;
import androidx.appcompat.app.ActionBar$OnMenuVisibilityListener;
import androidx.appcompat.app.ActionBar$OnNavigationListener;
import androidx.appcompat.app.ActionBar$Tab;
import androidx.appcompat.app.NavItemSelectedListener;
import androidx.appcompat.app.ToolbarActionBar$1;
import androidx.appcompat.app.ToolbarActionBar$2;
import androidx.appcompat.app.ToolbarActionBar$ActionMenuPresenterCallback;
import androidx.appcompat.app.ToolbarActionBar$MenuBuilderCallback;
import androidx.appcompat.app.ToolbarActionBar$ToolbarCallbackWrapper;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar$OnMenuItemClickListener;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

public class ToolbarActionBar
extends ActionBar {
    public DecorToolbar mDecorToolbar;
    private boolean mLastMenuVisibility;
    private boolean mMenuCallbackSet;
    private final Toolbar$OnMenuItemClickListener mMenuClicker;
    private final Runnable mMenuInvalidator;
    private ArrayList mMenuVisibilityListeners;
    public boolean mToolbarMenuPrepared;
    public Window.Callback mWindowCallback;

    public ToolbarActionBar(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        Object object = new ArrayList();
        this.mMenuVisibilityListeners = object;
        this.mMenuInvalidator = object = new ToolbarActionBar$1(this);
        this.mMenuClicker = object = new ToolbarActionBar$2(this);
        Object object2 = new ToolbarWidgetWrapper(toolbar, false);
        this.mDecorToolbar = object2;
        object2 = new ToolbarActionBar$ToolbarCallbackWrapper(this, callback);
        this.mWindowCallback = object2;
        this.mDecorToolbar.setWindowCallback((Window.Callback)object2);
        toolbar.setOnMenuItemClickListener((Toolbar$OnMenuItemClickListener)object);
        this.mDecorToolbar.setWindowTitle(charSequence);
    }

    private Menu getMenu() {
        boolean bl2 = this.mMenuCallbackSet;
        if (!bl2) {
            DecorToolbar decorToolbar = this.mDecorToolbar;
            ToolbarActionBar$ActionMenuPresenterCallback toolbarActionBar$ActionMenuPresenterCallback = new ToolbarActionBar$ActionMenuPresenterCallback(this);
            ToolbarActionBar$MenuBuilderCallback toolbarActionBar$MenuBuilderCallback = new ToolbarActionBar$MenuBuilderCallback(this);
            decorToolbar.setMenuCallbacks(toolbarActionBar$ActionMenuPresenterCallback, toolbarActionBar$MenuBuilderCallback);
            this.mMenuCallbackSet = bl2 = true;
        }
        return this.mDecorToolbar.getMenu();
    }

    public void addOnMenuVisibilityListener(ActionBar$OnMenuVisibilityListener actionBar$OnMenuVisibilityListener) {
        this.mMenuVisibilityListeners.add(actionBar$OnMenuVisibilityListener);
    }

    public void addTab(ActionBar$Tab object) {
        object = new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
        throw object;
    }

    public void addTab(ActionBar$Tab object, int n10) {
        object = new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
        throw object;
    }

    public void addTab(ActionBar$Tab object, int n10, boolean bl2) {
        object = new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
        throw object;
    }

    public void addTab(ActionBar$Tab object, boolean bl2) {
        object = new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
        throw object;
    }

    public boolean closeOptionsMenu() {
        return this.mDecorToolbar.hideOverflowMenu();
    }

    public boolean collapseActionView() {
        DecorToolbar decorToolbar = this.mDecorToolbar;
        boolean bl2 = decorToolbar.hasExpandedActionView();
        if (bl2) {
            this.mDecorToolbar.collapseActionView();
            return true;
        }
        return false;
    }

    public void dispatchMenuVisibilityChanged(boolean n10) {
        int n11 = this.mLastMenuVisibility;
        if (n10 == n11) {
            return;
        }
        this.mLastMenuVisibility = n10;
        ArrayList arrayList = this.mMenuVisibilityListeners;
        n11 = arrayList.size();
        for (int i10 = 0; i10 < n11; ++i10) {
            ActionBar$OnMenuVisibilityListener actionBar$OnMenuVisibilityListener = (ActionBar$OnMenuVisibilityListener)this.mMenuVisibilityListeners.get(i10);
            actionBar$OnMenuVisibilityListener.onMenuVisibilityChanged(n10 != 0);
        }
    }

    public View getCustomView() {
        return this.mDecorToolbar.getCustomView();
    }

    public int getDisplayOptions() {
        return this.mDecorToolbar.getDisplayOptions();
    }

    public float getElevation() {
        return ViewCompat.getElevation((View)this.mDecorToolbar.getViewGroup());
    }

    public int getHeight() {
        return this.mDecorToolbar.getHeight();
    }

    public int getNavigationItemCount() {
        return 0;
    }

    public int getNavigationMode() {
        return 0;
    }

    public int getSelectedNavigationIndex() {
        return -1;
    }

    public ActionBar$Tab getSelectedTab() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
        throw unsupportedOperationException;
    }

    public CharSequence getSubtitle() {
        return this.mDecorToolbar.getSubtitle();
    }

    public ActionBar$Tab getTabAt(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
        throw unsupportedOperationException;
    }

    public int getTabCount() {
        return 0;
    }

    public Context getThemedContext() {
        return this.mDecorToolbar.getContext();
    }

    public CharSequence getTitle() {
        return this.mDecorToolbar.getTitle();
    }

    public Window.Callback getWrappedWindowCallback() {
        return this.mWindowCallback;
    }

    public void hide() {
        this.mDecorToolbar.setVisibility(8);
    }

    public boolean invalidateOptionsMenu() {
        ViewGroup viewGroup = this.mDecorToolbar.getViewGroup();
        Runnable runnable = this.mMenuInvalidator;
        viewGroup.removeCallbacks(runnable);
        viewGroup = this.mDecorToolbar.getViewGroup();
        runnable = this.mMenuInvalidator;
        ViewCompat.postOnAnimation((View)viewGroup, runnable);
        return true;
    }

    public boolean isShowing() {
        DecorToolbar decorToolbar = this.mDecorToolbar;
        int n10 = decorToolbar.getVisibility();
        if (!n10) {
            n10 = 1;
        } else {
            n10 = 0;
            decorToolbar = null;
        }
        return n10 != 0;
    }

    public boolean isTitleTruncated() {
        return super.isTitleTruncated();
    }

    public ActionBar$Tab newTab() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
        throw unsupportedOperationException;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onDestroy() {
        ViewGroup viewGroup = this.mDecorToolbar.getViewGroup();
        Runnable runnable = this.mMenuInvalidator;
        viewGroup.removeCallbacks(runnable);
    }

    /*
     * WARNING - void declaration
     */
    public boolean onKeyShortcut(int n10, KeyEvent keyEvent) {
        Menu menu2 = this.getMenu();
        if (menu2 != null) {
            void var4_6;
            if (keyEvent != null) {
                int bl3 = keyEvent.getDeviceId();
            } else {
                int n11 = -1;
            }
            KeyCharacterMap keyCharacterMap = KeyCharacterMap.load((int)var4_6);
            boolean bl2 = keyCharacterMap.getKeyboardType();
            boolean bl3 = true;
            if (bl2 == bl3) {
                bl3 = false;
            }
            menu2.setQwertyMode(bl3);
            return menu2.performShortcut(n10, keyEvent, 0);
        }
        return false;
    }

    public boolean onMenuKeyEvent(KeyEvent keyEvent) {
        int n10;
        int n11 = keyEvent.getAction();
        if (n11 == (n10 = 1)) {
            this.openOptionsMenu();
        }
        return n10 != 0;
    }

    public boolean openOptionsMenu() {
        return this.mDecorToolbar.showOverflowMenu();
    }

    public void populateOptionsMenu() {
        Menu menu2;
        block12: {
            Menu menu3;
            block11: {
                menu3 = this.getMenu();
                boolean bl2 = menu3 instanceof MenuBuilder;
                boolean bl3 = false;
                if (bl2) {
                    menu2 = menu3;
                    menu2 = (MenuBuilder)menu3;
                } else {
                    bl2 = false;
                    menu2 = null;
                }
                if (menu2 != null) {
                    menu2.stopDispatchingItemsChanged();
                }
                menu3.clear();
                Window.Callback callback = this.mWindowCallback;
                boolean bl4 = callback.onCreatePanelMenu(0, menu3);
                if (!bl4) break block11;
                callback = this.mWindowCallback;
                bl3 = callback.onPreparePanel(0, null, menu3);
                if (bl3) break block12;
            }
            menu3.clear();
        }
        return;
        finally {
            if (menu2 != null) {
                menu2.startDispatchingItemsChanged();
            }
        }
    }

    public void removeAllTabs() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
        throw unsupportedOperationException;
    }

    public void removeOnMenuVisibilityListener(ActionBar$OnMenuVisibilityListener actionBar$OnMenuVisibilityListener) {
        this.mMenuVisibilityListeners.remove(actionBar$OnMenuVisibilityListener);
    }

    public void removeTab(ActionBar$Tab object) {
        object = new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
        throw object;
    }

    public void removeTabAt(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
        throw unsupportedOperationException;
    }

    public boolean requestFocus() {
        boolean bl2;
        ViewGroup viewGroup = this.mDecorToolbar.getViewGroup();
        if (viewGroup != null && !(bl2 = viewGroup.hasFocus())) {
            viewGroup.requestFocus();
            return true;
        }
        return false;
    }

    public void selectTab(ActionBar$Tab object) {
        object = new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
        throw object;
    }

    public void setBackgroundDrawable(Drawable drawable2) {
        this.mDecorToolbar.setBackgroundDrawable(drawable2);
    }

    public void setCustomView(int n10) {
        LayoutInflater layoutInflater = LayoutInflater.from((Context)this.mDecorToolbar.getContext());
        ViewGroup viewGroup = this.mDecorToolbar.getViewGroup();
        View view = layoutInflater.inflate(n10, viewGroup, false);
        this.setCustomView(view);
    }

    public void setCustomView(View view) {
        int n10 = -2;
        ActionBar$LayoutParams actionBar$LayoutParams = new ActionBar$LayoutParams(n10, n10);
        this.setCustomView(view, actionBar$LayoutParams);
    }

    public void setCustomView(View view, ActionBar$LayoutParams actionBar$LayoutParams) {
        if (view != null) {
            view.setLayoutParams((ViewGroup.LayoutParams)actionBar$LayoutParams);
        }
        this.mDecorToolbar.setCustomView(view);
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean bl2) {
    }

    /*
     * WARNING - void declaration
     */
    public void setDisplayHomeAsUpEnabled(boolean bl2) {
        void var1_4;
        int n10 = 4;
        if (bl2) {
            int n11 = n10;
        } else {
            boolean bl3 = false;
        }
        this.setDisplayOptions((int)var1_4, n10);
    }

    public void setDisplayOptions(int n10) {
        this.setDisplayOptions(n10, -1);
    }

    public void setDisplayOptions(int n10, int n11) {
        int n12 = this.mDecorToolbar.getDisplayOptions();
        DecorToolbar decorToolbar = this.mDecorToolbar;
        n10 &= n11;
        n11 = ~n11 & n12;
        decorToolbar.setDisplayOptions(n10 |= n11);
    }

    /*
     * WARNING - void declaration
     */
    public void setDisplayShowCustomEnabled(boolean bl2) {
        void var1_4;
        int n10 = 16;
        if (bl2) {
            int n11 = n10;
        } else {
            boolean bl3 = false;
        }
        this.setDisplayOptions((int)var1_4, n10);
    }

    /*
     * WARNING - void declaration
     */
    public void setDisplayShowHomeEnabled(boolean bl2) {
        void var1_4;
        int n10 = 2;
        if (bl2) {
            int n11 = n10;
        } else {
            boolean bl3 = false;
        }
        this.setDisplayOptions((int)var1_4, n10);
    }

    /*
     * WARNING - void declaration
     */
    public void setDisplayShowTitleEnabled(boolean bl2) {
        void var1_4;
        int n10 = 8;
        if (bl2) {
            int n11 = n10;
        } else {
            boolean bl3 = false;
        }
        this.setDisplayOptions((int)var1_4, n10);
    }

    public void setDisplayUseLogoEnabled(boolean bl2) {
        this.setDisplayOptions((int)(bl2 ? 1 : 0), 1);
    }

    public void setElevation(float f10) {
        ViewCompat.setElevation((View)this.mDecorToolbar.getViewGroup(), f10);
    }

    public void setHomeActionContentDescription(int n10) {
        this.mDecorToolbar.setNavigationContentDescription(n10);
    }

    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.mDecorToolbar.setNavigationContentDescription(charSequence);
    }

    public void setHomeAsUpIndicator(int n10) {
        this.mDecorToolbar.setNavigationIcon(n10);
    }

    public void setHomeAsUpIndicator(Drawable drawable2) {
        this.mDecorToolbar.setNavigationIcon(drawable2);
    }

    public void setHomeButtonEnabled(boolean bl2) {
    }

    public void setIcon(int n10) {
        this.mDecorToolbar.setIcon(n10);
    }

    public void setIcon(Drawable drawable2) {
        this.mDecorToolbar.setIcon(drawable2);
    }

    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar$OnNavigationListener actionBar$OnNavigationListener) {
        DecorToolbar decorToolbar = this.mDecorToolbar;
        NavItemSelectedListener navItemSelectedListener = new NavItemSelectedListener(actionBar$OnNavigationListener);
        decorToolbar.setDropdownParams(spinnerAdapter, navItemSelectedListener);
    }

    public void setLogo(int n10) {
        this.mDecorToolbar.setLogo(n10);
    }

    public void setLogo(Drawable drawable2) {
        this.mDecorToolbar.setLogo(drawable2);
    }

    public void setNavigationMode(int n10) {
        int n11 = 2;
        if (n10 != n11) {
            this.mDecorToolbar.setNavigationMode(n10);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Tabs not supported in this configuration");
        throw illegalArgumentException;
    }

    public void setSelectedNavigationItem(int n10) {
        int n11;
        DecorToolbar decorToolbar = this.mDecorToolbar;
        int n12 = decorToolbar.getNavigationMode();
        if (n12 == (n11 = 1)) {
            this.mDecorToolbar.setDropdownSelectedPosition(n10);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        throw illegalStateException;
    }

    public void setShowHideAnimationEnabled(boolean bl2) {
    }

    public void setSplitBackgroundDrawable(Drawable drawable2) {
    }

    public void setStackedBackgroundDrawable(Drawable drawable2) {
    }

    public void setSubtitle(int n10) {
        CharSequence charSequence;
        DecorToolbar decorToolbar = this.mDecorToolbar;
        if (n10 != 0) {
            Context context = decorToolbar.getContext();
            charSequence = context.getText(n10);
        } else {
            n10 = 0;
            charSequence = null;
        }
        decorToolbar.setSubtitle(charSequence);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mDecorToolbar.setSubtitle(charSequence);
    }

    public void setTitle(int n10) {
        CharSequence charSequence;
        DecorToolbar decorToolbar = this.mDecorToolbar;
        if (n10 != 0) {
            Context context = decorToolbar.getContext();
            charSequence = context.getText(n10);
        } else {
            n10 = 0;
            charSequence = null;
        }
        decorToolbar.setTitle(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        this.mDecorToolbar.setTitle(charSequence);
    }

    public void setWindowTitle(CharSequence charSequence) {
        this.mDecorToolbar.setWindowTitle(charSequence);
    }

    public void show() {
        this.mDecorToolbar.setVisibility(0);
    }
}

