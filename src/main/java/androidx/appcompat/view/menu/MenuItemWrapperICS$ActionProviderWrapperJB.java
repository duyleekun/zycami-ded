/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.ActionProvider
 *  android.view.ActionProvider$VisibilityListener
 *  android.view.MenuItem
 *  android.view.View
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuItemWrapperICS$ActionProviderWrapper;
import androidx.core.view.ActionProvider$VisibilityListener;

public class MenuItemWrapperICS$ActionProviderWrapperJB
extends MenuItemWrapperICS$ActionProviderWrapper
implements ActionProvider.VisibilityListener {
    private ActionProvider$VisibilityListener mListener;
    public final /* synthetic */ MenuItemWrapperICS this$0;

    public MenuItemWrapperICS$ActionProviderWrapperJB(MenuItemWrapperICS menuItemWrapperICS, Context context, ActionProvider actionProvider) {
        this.this$0 = menuItemWrapperICS;
        super(menuItemWrapperICS, context, actionProvider);
    }

    public boolean isVisible() {
        return this.mInner.isVisible();
    }

    public void onActionProviderVisibilityChanged(boolean bl2) {
        ActionProvider$VisibilityListener actionProvider$VisibilityListener = this.mListener;
        if (actionProvider$VisibilityListener != null) {
            actionProvider$VisibilityListener.onActionProviderVisibilityChanged(bl2);
        }
    }

    public View onCreateActionView(MenuItem menuItem) {
        return this.mInner.onCreateActionView(menuItem);
    }

    public boolean overridesItemVisibility() {
        return this.mInner.overridesItemVisibility();
    }

    public void refreshVisibility() {
        this.mInner.refreshVisibility();
    }

    public void setVisibilityListener(ActionProvider$VisibilityListener object) {
        this.mListener = object;
        ActionProvider actionProvider = this.mInner;
        object = object != null ? this : null;
        actionProvider.setVisibilityListener((ActionProvider.VisibilityListener)object);
    }
}

