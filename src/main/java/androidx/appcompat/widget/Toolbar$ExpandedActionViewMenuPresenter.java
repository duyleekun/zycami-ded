/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Parcelable
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBar$LayoutParams;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuPresenter$Callback;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar$LayoutParams;

public class Toolbar$ExpandedActionViewMenuPresenter
implements MenuPresenter {
    public MenuItemImpl mCurrentExpandedItem;
    public MenuBuilder mMenu;
    public final /* synthetic */ Toolbar this$0;

    public Toolbar$ExpandedActionViewMenuPresenter(Toolbar toolbar) {
        this.this$0 = toolbar;
    }

    public boolean collapseItemActionView(MenuBuilder object, MenuItemImpl menuItemImpl) {
        object = this.this$0.mExpandedActionView;
        boolean bl2 = object instanceof CollapsibleActionView;
        if (bl2) {
            object = (CollapsibleActionView)object;
            object.onActionViewCollapsed();
        }
        object = this.this$0;
        View view = ((Toolbar)object).mExpandedActionView;
        object.removeView(view);
        object = this.this$0;
        view = ((Toolbar)object).mCollapseButtonView;
        object.removeView(view);
        object = this.this$0;
        ((Toolbar)object).mExpandedActionView = null;
        ((Toolbar)((Object)object)).addChildrenForExpandedActionView();
        this.mCurrentExpandedItem = null;
        this.this$0.requestLayout();
        menuItemImpl.setActionViewExpanded(false);
        return true;
    }

    public boolean expandItemActionView(MenuBuilder object, MenuItemImpl object2) {
        int n10;
        boolean bl2;
        this.this$0.ensureCollapseButtonView();
        object = this.this$0.mCollapseButtonView.getParent();
        Toolbar toolbar = this.this$0;
        if (object != toolbar) {
            bl2 = object instanceof ViewGroup;
            if (bl2) {
                object = (ViewGroup)object;
                toolbar = toolbar.mCollapseButtonView;
                object.removeView((View)toolbar);
            }
            object = this.this$0;
            toolbar = ((Toolbar)object).mCollapseButtonView;
            object.addView((View)toolbar);
        }
        object = this.this$0;
        toolbar = ((MenuItemImpl)object2).getActionView();
        ((Toolbar)object).mExpandedActionView = toolbar;
        this.mCurrentExpandedItem = object2;
        object = this.this$0.mExpandedActionView.getParent();
        if (object != (toolbar = this.this$0)) {
            bl2 = object instanceof ViewGroup;
            if (bl2) {
                object = (ViewGroup)object;
                toolbar = toolbar.mExpandedActionView;
                object.removeView((View)toolbar);
            }
            object = this.this$0.generateDefaultLayoutParams();
            Toolbar toolbar2 = this.this$0;
            int n11 = toolbar2.mButtonGravity & 0x70;
            ((ActionBar$LayoutParams)object).gravity = n10 = 0x800003 | n11;
            ((Toolbar$LayoutParams)object).mViewType = n10 = 2;
            toolbar2.mExpandedActionView.setLayoutParams((ViewGroup.LayoutParams)object);
            object = this.this$0;
            toolbar = ((Toolbar)object).mExpandedActionView;
            object.addView((View)toolbar);
        }
        this.this$0.removeChildrenForExpandedActionView();
        object = this.this$0;
        object.requestLayout();
        boolean bl3 = true;
        ((MenuItemImpl)object2).setActionViewExpanded(bl3);
        object2 = this.this$0.mExpandedActionView;
        n10 = object2 instanceof CollapsibleActionView;
        if (n10 != 0) {
            object2 = (CollapsibleActionView)object2;
            object2.onActionViewExpanded();
        }
        return bl3;
    }

    public boolean flagActionItems() {
        return false;
    }

    public int getId() {
        return 0;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        return null;
    }

    public void initForMenu(Context object, MenuBuilder menuBuilder) {
        MenuItemImpl menuItemImpl;
        object = this.mMenu;
        if (object != null && (menuItemImpl = this.mCurrentExpandedItem) != null) {
            ((MenuBuilder)object).collapseItemActionView(menuItemImpl);
        }
        this.mMenu = menuBuilder;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl2) {
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void setCallback(MenuPresenter$Callback menuPresenter$Callback) {
    }

    public void updateMenuView(boolean n10) {
        Object object = this.mCurrentExpandedItem;
        if (object != null) {
            object = this.mMenu;
            boolean bl2 = false;
            MenuItemImpl menuItemImpl = null;
            if (object != null) {
                n10 = ((MenuBuilder)object).size();
                for (int i10 = 0; i10 < n10; ++i10) {
                    MenuItemImpl menuItemImpl2;
                    MenuItem menuItem = this.mMenu.getItem(i10);
                    if (menuItem != (menuItemImpl2 = this.mCurrentExpandedItem)) continue;
                    bl2 = true;
                    break;
                }
            }
            if (!bl2) {
                object = this.mMenu;
                menuItemImpl = this.mCurrentExpandedItem;
                this.collapseItemActionView((MenuBuilder)object, menuItemImpl);
            }
        }
    }
}

