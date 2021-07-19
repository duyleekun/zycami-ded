/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 */
package androidx.appcompat.app;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ActionMode$Callback;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder$Callback;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import java.lang.ref.WeakReference;

public class WindowDecorActionBar$ActionModeImpl
extends ActionMode
implements MenuBuilder$Callback {
    private final Context mActionModeContext;
    private ActionMode$Callback mCallback;
    private WeakReference mCustomView;
    private final MenuBuilder mMenu;
    public final /* synthetic */ WindowDecorActionBar this$0;

    public WindowDecorActionBar$ActionModeImpl(WindowDecorActionBar object, Context context, ActionMode$Callback actionMode$Callback) {
        this.this$0 = object;
        this.mActionModeContext = context;
        this.mCallback = actionMode$Callback;
        object = new MenuBuilder(context);
        this.mMenu = object = ((MenuBuilder)object).setDefaultShowAsAction(1);
        ((MenuBuilder)object).setCallback(this);
    }

    public boolean dispatchOnCreate() {
        Object object = this.mMenu;
        ((MenuBuilder)object).stopDispatchingItemsChanged();
        try {
            object = this.mCallback;
            MenuBuilder menuBuilder = this.mMenu;
            boolean bl2 = object.onCreateActionMode(this, menuBuilder);
            return bl2;
        }
        finally {
            this.mMenu.startDispatchingItemsChanged();
        }
    }

    public void finish() {
        Object object = this.this$0;
        Object object2 = ((WindowDecorActionBar)object).mActionMode;
        if (object2 != this) {
            return;
        }
        boolean bl2 = ((WindowDecorActionBar)object).mHiddenByApp;
        boolean bl3 = ((WindowDecorActionBar)object).mHiddenBySystem;
        ActionBarOverlayLayout actionBarOverlayLayout = null;
        if (!(bl3 = WindowDecorActionBar.checkShowingFlags(bl2, bl3, false))) {
            object = this.this$0;
            ((WindowDecorActionBar)object).mDeferredDestroyActionMode = this;
            ((WindowDecorActionBar)object).mDeferredModeDestroyCallback = object2 = this.mCallback;
        } else {
            object = this.mCallback;
            object.onDestroyActionMode(this);
        }
        this.mCallback = null;
        this.this$0.animateToMode(false);
        this.this$0.mContextView.closeMode();
        this.this$0.mDecorToolbar.getViewGroup().sendAccessibilityEvent(32);
        object2 = this.this$0;
        actionBarOverlayLayout = ((WindowDecorActionBar)object2).mOverlayLayout;
        bl2 = ((WindowDecorActionBar)object2).mHideOnContentScroll;
        actionBarOverlayLayout.setHideOnContentScrollEnabled(bl2);
        this.this$0.mActionMode = null;
    }

    public View getCustomView() {
        WeakReference weakReference = this.mCustomView;
        weakReference = weakReference != null ? (View)weakReference.get() : null;
        return weakReference;
    }

    public Menu getMenu() {
        return this.mMenu;
    }

    public MenuInflater getMenuInflater() {
        Context context = this.mActionModeContext;
        SupportMenuInflater supportMenuInflater = new SupportMenuInflater(context);
        return supportMenuInflater;
    }

    public CharSequence getSubtitle() {
        return this.this$0.mContextView.getSubtitle();
    }

    public CharSequence getTitle() {
        return this.this$0.mContextView.getTitle();
    }

    public void invalidate() {
        Object object = this.this$0.mActionMode;
        if (object != this) {
            return;
        }
        object = this.mMenu;
        ((MenuBuilder)object).stopDispatchingItemsChanged();
        try {
            object = this.mCallback;
            MenuBuilder menuBuilder = this.mMenu;
            object.onPrepareActionMode(this, menuBuilder);
            return;
        }
        finally {
            this.mMenu.startDispatchingItemsChanged();
        }
    }

    public boolean isTitleOptional() {
        return this.this$0.mContextView.isTitleOptional();
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl2) {
    }

    public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
    }

    public boolean onMenuItemSelected(MenuBuilder object, MenuItem menuItem) {
        object = this.mCallback;
        if (object != null) {
            return object.onActionItemClicked(this, menuItem);
        }
        return false;
    }

    public void onMenuModeChange(MenuBuilder object) {
        object = this.mCallback;
        if (object == null) {
            return;
        }
        this.invalidate();
        this.this$0.mContextView.showOverflowMenu();
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        Object object = this.mCallback;
        if (object == null) {
            return false;
        }
        boolean bl2 = subMenuBuilder.hasVisibleItems();
        boolean bl3 = true;
        if (!bl2) {
            return bl3;
        }
        Context context = this.this$0.getThemedContext();
        object = new MenuPopupHelper(context, subMenuBuilder);
        ((MenuPopupHelper)object).show();
        return bl3;
    }

    public void setCustomView(View view) {
        WeakReference<View> weakReference;
        this.this$0.mContextView.setCustomView(view);
        this.mCustomView = weakReference = new WeakReference<View>(view);
    }

    public void setSubtitle(int n10) {
        String string2 = this.this$0.mContext.getResources().getString(n10);
        this.setSubtitle(string2);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.this$0.mContextView.setSubtitle(charSequence);
    }

    public void setTitle(int n10) {
        String string2 = this.this$0.mContext.getResources().getString(n10);
        this.setTitle(string2);
    }

    public void setTitle(CharSequence charSequence) {
        this.this$0.mContextView.setTitle(charSequence);
    }

    public void setTitleOptionalHint(boolean bl2) {
        super.setTitleOptionalHint(bl2);
        this.this$0.mContextView.setTitleOptional(bl2);
    }
}

