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
package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ActionMode$Callback;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder$Callback;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

public class StandaloneActionMode
extends ActionMode
implements MenuBuilder$Callback {
    private ActionMode$Callback mCallback;
    private Context mContext;
    private ActionBarContextView mContextView;
    private WeakReference mCustomView;
    private boolean mFinished;
    private boolean mFocusable;
    private MenuBuilder mMenu;

    public StandaloneActionMode(Context object, ActionBarContextView actionBarContextView, ActionMode$Callback actionMode$Callback, boolean bl2) {
        this.mContext = object;
        this.mContextView = actionBarContextView;
        this.mCallback = actionMode$Callback;
        actionBarContextView = actionBarContextView.getContext();
        super((Context)actionBarContextView);
        this.mMenu = object = ((MenuBuilder)object).setDefaultShowAsAction(1);
        ((MenuBuilder)object).setCallback(this);
        this.mFocusable = bl2;
    }

    public void finish() {
        boolean bl2 = this.mFinished;
        if (bl2) {
            return;
        }
        this.mFinished = true;
        this.mContextView.sendAccessibilityEvent(32);
        this.mCallback.onDestroyActionMode(this);
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
        Context context = this.mContextView.getContext();
        SupportMenuInflater supportMenuInflater = new SupportMenuInflater(context);
        return supportMenuInflater;
    }

    public CharSequence getSubtitle() {
        return this.mContextView.getSubtitle();
    }

    public CharSequence getTitle() {
        return this.mContextView.getTitle();
    }

    public void invalidate() {
        ActionMode$Callback actionMode$Callback = this.mCallback;
        MenuBuilder menuBuilder = this.mMenu;
        actionMode$Callback.onPrepareActionMode(this, menuBuilder);
    }

    public boolean isTitleOptional() {
        return this.mContextView.isTitleOptional();
    }

    public boolean isUiFocusable() {
        return this.mFocusable;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl2) {
    }

    public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.mCallback.onActionItemClicked(this, menuItem);
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
        this.invalidate();
        this.mContextView.showOverflowMenu();
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        boolean bl2 = subMenuBuilder.hasVisibleItems();
        boolean bl3 = true;
        if (!bl2) {
            return bl3;
        }
        Context context = this.mContextView.getContext();
        MenuPopupHelper menuPopupHelper = new MenuPopupHelper(context, subMenuBuilder);
        menuPopupHelper.show();
        return bl3;
    }

    public void setCustomView(View view) {
        Object object = this.mContextView;
        object.setCustomView(view);
        object = view != null ? new WeakReference(view) : null;
        this.mCustomView = object;
    }

    public void setSubtitle(int n10) {
        String string2 = this.mContext.getString(n10);
        this.setSubtitle(string2);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mContextView.setSubtitle(charSequence);
    }

    public void setTitle(int n10) {
        String string2 = this.mContext.getString(n10);
        this.setTitle(string2);
    }

    public void setTitle(CharSequence charSequence) {
        this.mContextView.setTitle(charSequence);
    }

    public void setTitleOptionalHint(boolean bl2) {
        super.setTitleOptionalHint(bl2);
        this.mContextView.setTitleOptional(bl2);
    }
}

