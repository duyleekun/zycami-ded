/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.CollapsibleActionView
 *  android.view.View
 *  android.widget.FrameLayout
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.CollapsibleActionView;

public class MenuItemWrapperICS$CollapsibleActionViewWrapper
extends FrameLayout
implements CollapsibleActionView {
    public final android.view.CollapsibleActionView mWrappedView;

    public MenuItemWrapperICS$CollapsibleActionViewWrapper(View view) {
        Context context = view.getContext();
        super(context);
        context = view;
        context = (android.view.CollapsibleActionView)view;
        this.mWrappedView = context;
        this.addView(view);
    }

    public View getWrappedView() {
        return (View)this.mWrappedView;
    }

    public void onActionViewCollapsed() {
        this.mWrappedView.onActionViewCollapsed();
    }

    public void onActionViewExpanded() {
        this.mWrappedView.onActionViewExpanded();
    }
}

