/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  android.view.MenuItem
 *  android.view.SubMenu
 *  android.view.View
 */
package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.view.ActionProvider$SubUiVisibilityListener;
import androidx.core.view.ActionProvider$VisibilityListener;

public abstract class ActionProvider {
    private static final String TAG = "ActionProvider(support)";
    private final Context mContext;
    private ActionProvider$SubUiVisibilityListener mSubUiVisibilityListener;
    private ActionProvider$VisibilityListener mVisibilityListener;

    public ActionProvider(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    public abstract View onCreateActionView();

    public View onCreateActionView(MenuItem menuItem) {
        return this.onCreateActionView();
    }

    public boolean onPerformDefaultAction() {
        return false;
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
    }

    public boolean overridesItemVisibility() {
        return false;
    }

    public void refreshVisibility() {
        boolean bl2;
        ActionProvider$VisibilityListener actionProvider$VisibilityListener = this.mVisibilityListener;
        if (actionProvider$VisibilityListener != null && (bl2 = this.overridesItemVisibility())) {
            actionProvider$VisibilityListener = this.mVisibilityListener;
            boolean bl3 = this.isVisible();
            actionProvider$VisibilityListener.onActionProviderVisibilityChanged(bl3);
        }
    }

    public void reset() {
        this.mVisibilityListener = null;
        this.mSubUiVisibilityListener = null;
    }

    public void setSubUiVisibilityListener(ActionProvider$SubUiVisibilityListener actionProvider$SubUiVisibilityListener) {
        this.mSubUiVisibilityListener = actionProvider$SubUiVisibilityListener;
    }

    public void setVisibilityListener(ActionProvider$VisibilityListener actionProvider$VisibilityListener) {
        Object object = this.mVisibilityListener;
        if (object != null && actionProvider$VisibilityListener != null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
            String string2 = this.getClass().getSimpleName();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" instance while it is still in use somewhere else?");
            object = ((StringBuilder)object).toString();
            string2 = "ActionProvider(support)";
            Log.w((String)string2, (String)object);
        }
        this.mVisibilityListener = actionProvider$VisibilityListener;
    }

    public void subUiVisibilityChanged(boolean bl2) {
        ActionProvider$SubUiVisibilityListener actionProvider$SubUiVisibilityListener = this.mSubUiVisibilityListener;
        if (actionProvider$SubUiVisibilityListener != null) {
            actionProvider$SubUiVisibilityListener.onSubUiVisibilityChanged(bl2);
        }
    }
}

