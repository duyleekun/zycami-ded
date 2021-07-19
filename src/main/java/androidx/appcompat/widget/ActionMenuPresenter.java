/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.graphics.drawable.Drawable
 *  android.os.Parcelable
 *  android.util.SparseBooleanArray
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.ActionMenuItemView$PopupCallback;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder$ItemInvoker;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.MenuView$ItemView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuPresenter$ActionButtonSubmenu;
import androidx.appcompat.widget.ActionMenuPresenter$ActionMenuPopupCallback;
import androidx.appcompat.widget.ActionMenuPresenter$OpenOverflowRunnable;
import androidx.appcompat.widget.ActionMenuPresenter$OverflowMenuButton;
import androidx.appcompat.widget.ActionMenuPresenter$OverflowPopup;
import androidx.appcompat.widget.ActionMenuPresenter$PopupPresenterCallback;
import androidx.appcompat.widget.ActionMenuPresenter$SavedState;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ActionMenuView$LayoutParams;
import androidx.core.view.ActionProvider;
import androidx.core.view.ActionProvider$SubUiVisibilityListener;
import java.util.ArrayList;

public class ActionMenuPresenter
extends BaseMenuPresenter
implements ActionProvider$SubUiVisibilityListener {
    private static final String TAG = "ActionMenuPresenter";
    private final SparseBooleanArray mActionButtonGroups;
    public ActionMenuPresenter$ActionButtonSubmenu mActionButtonPopup;
    private int mActionItemWidthLimit;
    private boolean mExpandedActionViewsExclusive;
    private int mMaxItems;
    private boolean mMaxItemsSet;
    private int mMinCellSize;
    public int mOpenSubMenuId;
    public ActionMenuPresenter$OverflowMenuButton mOverflowButton;
    public ActionMenuPresenter$OverflowPopup mOverflowPopup;
    private Drawable mPendingOverflowIcon;
    private boolean mPendingOverflowIconSet;
    private ActionMenuPresenter$ActionMenuPopupCallback mPopupCallback;
    public final ActionMenuPresenter$PopupPresenterCallback mPopupPresenterCallback;
    public ActionMenuPresenter$OpenOverflowRunnable mPostedOpenRunnable;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet;
    private boolean mStrictWidthLimit;
    private int mWidthLimit;
    private boolean mWidthLimitSet;

    public ActionMenuPresenter(Context object) {
        int n10 = R$layout.abc_action_menu_layout;
        int n11 = R$layout.abc_action_menu_item_layout;
        super((Context)object, n10, n11);
        super();
        this.mActionButtonGroups = object;
        super(this);
        this.mPopupPresenterCallback = object;
    }

    public static /* synthetic */ MenuBuilder access$000(ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.mMenu;
    }

    public static /* synthetic */ MenuBuilder access$100(ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.mMenu;
    }

    public static /* synthetic */ MenuView access$200(ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.mMenuView;
    }

    public static /* synthetic */ MenuBuilder access$300(ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.mMenu;
    }

    public static /* synthetic */ MenuBuilder access$400(ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.mMenu;
    }

    public static /* synthetic */ MenuBuilder access$500(ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.mMenu;
    }

    public static /* synthetic */ MenuView access$600(ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.mMenuView;
    }

    private View findViewForItem(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup)this.mMenuView;
        if (viewGroup == null) {
            return null;
        }
        int n10 = viewGroup.getChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            View view = viewGroup.getChildAt(i10);
            boolean bl2 = view instanceof MenuView$ItemView;
            if (!bl2) continue;
            Object object = view;
            object = ((MenuView$ItemView)view).getItemData();
            if (object != menuItem) continue;
            return view;
        }
        return null;
    }

    public void bindItemView(MenuItemImpl object, MenuView$ItemView menuView$ItemView) {
        menuView$ItemView.initialize((MenuItemImpl)object, 0);
        object = (ActionMenuView)this.mMenuView;
        menuView$ItemView = (ActionMenuItemView)menuView$ItemView;
        ((ActionMenuItemView)menuView$ItemView).setItemInvoker((MenuBuilder$ItemInvoker)object);
        object = this.mPopupCallback;
        if (object == null) {
            this.mPopupCallback = object = new ActionMenuPresenter$ActionMenuPopupCallback(this);
        }
        object = this.mPopupCallback;
        ((ActionMenuItemView)menuView$ItemView).setPopupCallback((ActionMenuItemView$PopupCallback)object);
    }

    public boolean dismissPopupMenus() {
        boolean bl2 = this.hideOverflowMenu();
        boolean bl3 = this.hideSubMenus();
        return bl2 | bl3;
    }

    public boolean filterLeftoverView(ViewGroup viewGroup, int n10) {
        ActionMenuPresenter$OverflowMenuButton actionMenuPresenter$OverflowMenuButton;
        View view = viewGroup.getChildAt(n10);
        if (view == (actionMenuPresenter$OverflowMenuButton = this.mOverflowButton)) {
            return false;
        }
        return super.filterLeftoverView(viewGroup, n10);
    }

    public boolean flagActionItems() {
        boolean bl2;
        MenuItemImpl menuItemImpl;
        int n10;
        View view;
        int n11;
        ActionMenuPresenter actionMenuPresenter = this;
        Object object = this.mMenu;
        int n12 = 0;
        int n13 = 0;
        float f10 = 0.0f;
        if (object != null) {
            object = ((MenuBuilder)object).getVisibleItems();
            n11 = ((ArrayList)object).size();
        } else {
            object = null;
            n11 = 0;
            view = null;
        }
        int n14 = actionMenuPresenter.mMaxItems;
        int n15 = actionMenuPresenter.mActionItemWidthLimit;
        int n16 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
        ViewGroup viewGroup = (ViewGroup)actionMenuPresenter.mMenuView;
        SparseBooleanArray sparseBooleanArray = null;
        int n17 = 0;
        int n18 = 0;
        int n19 = 0;
        for (n10 = 0; n10 < n11; ++n10) {
            menuItemImpl = (MenuItemImpl)((ArrayList)object).get(n10);
            boolean bl3 = menuItemImpl.requiresActionButton();
            if (bl3) {
                ++n18;
            } else {
                bl3 = menuItemImpl.requestsActionButton();
                if (bl3) {
                    ++n19;
                } else {
                    n17 = 1;
                }
            }
            bl2 = actionMenuPresenter.mExpandedActionViewsExclusive;
            if (!bl2 || !(bl2 = menuItemImpl.isActionViewExpanded())) continue;
            n14 = 0;
        }
        n10 = (int)(actionMenuPresenter.mReserveOverflow ? 1 : 0);
        if (n10 != 0 && (n17 != 0 || (n19 += n18) > n14)) {
            n14 += -1;
        }
        n14 -= n18;
        sparseBooleanArray = actionMenuPresenter.mActionButtonGroups;
        sparseBooleanArray.clear();
        n17 = actionMenuPresenter.mStrictWidthLimit;
        if (n17 != 0) {
            n17 = actionMenuPresenter.mMinCellSize;
            n18 = n15 / n17;
            n19 = n15 % n17 / n18;
            n17 += n19;
        } else {
            n17 = 0;
            n18 = 0;
        }
        int n20 = 0;
        menuItemImpl = null;
        for (n19 = 0; n19 < n11; ++n19) {
            int n21;
            int n22;
            Object object2;
            MenuItemImpl menuItemImpl2 = (MenuItemImpl)((ArrayList)object).get(n19);
            boolean bl4 = menuItemImpl2.requiresActionButton();
            if (bl4) {
                object2 = actionMenuPresenter.getItemView(menuItemImpl2, null, viewGroup);
                n12 = (int)(actionMenuPresenter.mStrictWidthLimit ? 1 : 0);
                if (n12 != 0) {
                    n12 = ActionMenuView.measureChildForCells((View)object2, n17, n18, n16, 0);
                    n18 -= n12;
                } else {
                    object2.measure(n16, n16);
                }
                n12 = object2.getMeasuredWidth();
                n15 -= n12;
                if (n20 == 0) {
                    n20 = n12;
                }
                n12 = menuItemImpl2.getGroupId();
                bl2 = true;
                if (n12 != 0) {
                    sparseBooleanArray.put(n12, bl2);
                }
                menuItemImpl2.setIsActionButton(bl2);
                n22 = 0;
                actionMenuPresenter = null;
                n21 = n11;
            } else {
                n12 = menuItemImpl2.requestsActionButton();
                if (n12 != 0) {
                    n12 = menuItemImpl2.getGroupId();
                    bl2 = sparseBooleanArray.get(n12);
                    if (!(n14 <= 0 && !bl2 || n15 <= 0 || (n13 = actionMenuPresenter.mStrictWidthLimit) != 0 && n18 <= 0)) {
                        n13 = 1;
                        f10 = Float.MIN_VALUE;
                    } else {
                        n13 = 0;
                        f10 = 0.0f;
                    }
                    int n23 = n13;
                    float f11 = f10;
                    n21 = n11;
                    if (n13 != 0) {
                        f10 = 0.0f;
                        view = actionMenuPresenter.getItemView(menuItemImpl2, null, viewGroup);
                        n13 = actionMenuPresenter.mStrictWidthLimit;
                        if (n13 != 0) {
                            n13 = 0;
                            f10 = 0.0f;
                            int n24 = ActionMenuView.measureChildForCells(view, n17, n18, n16, 0);
                            n18 -= n24;
                            if (n24 == 0) {
                                n23 = 0;
                                f11 = 0.0f;
                            }
                        } else {
                            view.measure(n16, n16);
                        }
                        n13 = n23;
                        f10 = f11;
                        n11 = view.getMeasuredWidth();
                        n15 -= n11;
                        if (n20 == 0) {
                            n20 = n11;
                        }
                        if ((n11 = (int)(actionMenuPresenter.mStrictWidthLimit ? 1 : 0)) != 0 ? n15 >= 0 : (n11 = n15 + n20) > 0) {
                            n11 = 1;
                        } else {
                            n11 = 0;
                            view = null;
                        }
                        n13 &= n11;
                    }
                    if (n13 != 0 && n12 != 0) {
                        n11 = 1;
                        sparseBooleanArray.put(n12, n11 != 0);
                    } else if (bl2) {
                        sparseBooleanArray.put(n12, false);
                        view = null;
                        for (n11 = 0; n11 < n19; ++n11) {
                            object2 = (MenuItemImpl)((ArrayList)object).get(n11);
                            n22 = ((MenuItemImpl)object2).getGroupId();
                            if (n22 == n12) {
                                n22 = (int)(((MenuItemImpl)object2).isActionButton() ? 1 : 0);
                                if (n22 != 0) {
                                    ++n14;
                                }
                                n22 = 0;
                                actionMenuPresenter = null;
                                ((MenuItemImpl)object2).setIsActionButton(false);
                            }
                            actionMenuPresenter = this;
                        }
                    }
                    if (n13 != 0) {
                        n14 += -1;
                    }
                    menuItemImpl2.setIsActionButton(n13 != 0);
                    n22 = 0;
                    actionMenuPresenter = null;
                } else {
                    n22 = 0;
                    actionMenuPresenter = null;
                    n21 = n11;
                    menuItemImpl2.setIsActionButton(false);
                }
            }
            n13 = 0;
            f10 = 0.0f;
            n11 = n21;
            n12 = 0;
            actionMenuPresenter = this;
        }
        return true;
    }

    public View getItemView(MenuItemImpl object, View view, ViewGroup viewGroup) {
        int n10;
        boolean bl2;
        View view2 = object.getActionView();
        if (view2 == null || (bl2 = object.hasCollapsibleActionView())) {
            view2 = super.getItemView((MenuItemImpl)object, view, viewGroup);
        }
        if ((n10 = object.isActionViewExpanded()) != 0) {
            n10 = 8;
        } else {
            n10 = 0;
            object = null;
        }
        view2.setVisibility(n10);
        viewGroup = (ActionMenuView)viewGroup;
        object = view2.getLayoutParams();
        boolean bl3 = viewGroup.checkLayoutParams((ViewGroup.LayoutParams)object);
        if (!bl3) {
            object = viewGroup.generateLayoutParams((ViewGroup.LayoutParams)object);
            view2.setLayoutParams((ViewGroup.LayoutParams)object);
        }
        return view2;
    }

    public MenuView getMenuView(ViewGroup object) {
        MenuView menuView = this.mMenuView;
        if (menuView != (object = super.getMenuView((ViewGroup)object))) {
            menuView = object;
            menuView = (ActionMenuView)object;
            ((ActionMenuView)menuView).setPresenter(this);
        }
        return object;
    }

    public Drawable getOverflowIcon() {
        ActionMenuPresenter$OverflowMenuButton actionMenuPresenter$OverflowMenuButton = this.mOverflowButton;
        if (actionMenuPresenter$OverflowMenuButton != null) {
            return actionMenuPresenter$OverflowMenuButton.getDrawable();
        }
        boolean bl2 = this.mPendingOverflowIconSet;
        if (bl2) {
            return this.mPendingOverflowIcon;
        }
        return null;
    }

    public boolean hideOverflowMenu() {
        MenuView menuView;
        Object object = this.mPostedOpenRunnable;
        boolean bl2 = true;
        if (object != null && (menuView = this.mMenuView) != null) {
            ((View)menuView).removeCallbacks((Runnable)object);
            this.mPostedOpenRunnable = null;
            return bl2;
        }
        object = this.mOverflowPopup;
        if (object != null) {
            ((MenuPopupHelper)object).dismiss();
            return bl2;
        }
        return false;
    }

    public boolean hideSubMenus() {
        ActionMenuPresenter$ActionButtonSubmenu actionMenuPresenter$ActionButtonSubmenu = this.mActionButtonPopup;
        if (actionMenuPresenter$ActionButtonSubmenu != null) {
            actionMenuPresenter$ActionButtonSubmenu.dismiss();
            return true;
        }
        return false;
    }

    public void initForMenu(Context object, MenuBuilder menuBuilder) {
        int n10;
        super.initForMenu((Context)object, menuBuilder);
        menuBuilder = object.getResources();
        object = ActionBarPolicy.get((Context)object);
        int n11 = this.mReserveOverflowSet;
        if (n11 == 0) {
            this.mReserveOverflow = n11 = ((ActionBarPolicy)object).showsOverflowMenuButton();
        }
        if ((n11 = this.mWidthLimitSet) == 0) {
            this.mWidthLimit = n11 = ((ActionBarPolicy)object).getEmbeddedMenuWidthLimit();
        }
        if ((n11 = (int)(this.mMaxItemsSet ? 1 : 0)) == 0) {
            this.mMaxItems = n10 = ((ActionBarPolicy)object).getMaxActionButtons();
        }
        n10 = this.mWidthLimit;
        n11 = (int)(this.mReserveOverflow ? 1 : 0);
        ActionMenuPresenter$OverflowMenuButton actionMenuPresenter$OverflowMenuButton = null;
        if (n11 != 0) {
            ActionMenuPresenter$OverflowMenuButton actionMenuPresenter$OverflowMenuButton2 = this.mOverflowButton;
            if (actionMenuPresenter$OverflowMenuButton2 == null) {
                Context context = this.mSystemContext;
                this.mOverflowButton = actionMenuPresenter$OverflowMenuButton2 = new ActionMenuPresenter$OverflowMenuButton(this, context);
                boolean bl2 = this.mPendingOverflowIconSet;
                if (bl2) {
                    context = this.mPendingOverflowIcon;
                    actionMenuPresenter$OverflowMenuButton2.setImageDrawable((Drawable)context);
                    this.mPendingOverflowIcon = null;
                    this.mPendingOverflowIconSet = false;
                }
                n11 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
                actionMenuPresenter$OverflowMenuButton = this.mOverflowButton;
                actionMenuPresenter$OverflowMenuButton.measure(n11, n11);
            }
            actionMenuPresenter$OverflowMenuButton2 = this.mOverflowButton;
            n11 = actionMenuPresenter$OverflowMenuButton2.getMeasuredWidth();
            n10 -= n11;
        } else {
            this.mOverflowButton = null;
        }
        this.mActionItemWidthLimit = n10;
        this.mMinCellSize = n10 = (int)(menuBuilder.getDisplayMetrics().density * 56.0f);
    }

    public boolean isOverflowMenuShowPending() {
        boolean bl2;
        ActionMenuPresenter$OpenOverflowRunnable actionMenuPresenter$OpenOverflowRunnable = this.mPostedOpenRunnable;
        if (actionMenuPresenter$OpenOverflowRunnable == null && !(bl2 = this.isOverflowMenuShowing())) {
            bl2 = false;
            actionMenuPresenter$OpenOverflowRunnable = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean isOverflowMenuShowing() {
        boolean bl2;
        ActionMenuPresenter$OverflowPopup actionMenuPresenter$OverflowPopup = this.mOverflowPopup;
        if (actionMenuPresenter$OverflowPopup != null && (bl2 = actionMenuPresenter$OverflowPopup.isShowing())) {
            bl2 = true;
        } else {
            bl2 = false;
            actionMenuPresenter$OverflowPopup = null;
        }
        return bl2;
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl2) {
        this.dismissPopupMenus();
        super.onCloseMenu(menuBuilder, bl2);
    }

    public void onConfigurationChanged(Configuration object) {
        int n10 = this.mMaxItemsSet;
        if (n10 == 0) {
            object = ActionBarPolicy.get(this.mContext);
            this.mMaxItems = n10 = ((ActionBarPolicy)object).getMaxActionButtons();
        }
        if ((object = this.mMenu) != null) {
            boolean bl2 = true;
            ((MenuBuilder)object).onItemsChanged(bl2);
        }
    }

    public void onRestoreInstanceState(Parcelable object) {
        MenuBuilder menuBuilder;
        boolean bl2 = object instanceof ActionMenuPresenter$SavedState;
        if (!bl2) {
            return;
        }
        object = (ActionMenuPresenter$SavedState)object;
        int n10 = object.openSubMenuId;
        if (n10 > 0 && (object = (menuBuilder = this.mMenu).findItem(n10)) != null) {
            object = (SubMenuBuilder)object.getSubMenu();
            this.onSubMenuSelected((SubMenuBuilder)object);
        }
    }

    public Parcelable onSaveInstanceState() {
        int n10;
        ActionMenuPresenter$SavedState actionMenuPresenter$SavedState = new ActionMenuPresenter$SavedState();
        actionMenuPresenter$SavedState.openSubMenuId = n10 = this.mOpenSubMenuId;
        return actionMenuPresenter$SavedState;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        boolean bl2;
        int n10;
        MenuBuilder menuBuilder;
        Object object;
        boolean bl3 = subMenuBuilder.hasVisibleItems();
        boolean bl4 = false;
        if (!bl3) {
            return false;
        }
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while ((object = subMenuBuilder2.getParentMenu()) != (menuBuilder = this.mMenu)) {
            subMenuBuilder2 = (SubMenuBuilder)subMenuBuilder2.getParentMenu();
        }
        subMenuBuilder2 = subMenuBuilder2.getItem();
        if ((subMenuBuilder2 = this.findViewForItem((MenuItem)subMenuBuilder2)) == null) {
            return false;
        }
        object = subMenuBuilder.getItem();
        this.mOpenSubMenuId = n10 = object.getItemId();
        n10 = subMenuBuilder.size();
        int n11 = 0;
        menuBuilder = null;
        while (true) {
            bl2 = true;
            if (n11 >= n10) break;
            MenuItem menuItem = subMenuBuilder.getItem(n11);
            boolean bl5 = menuItem.isVisible();
            if (bl5 && (menuItem = menuItem.getIcon()) != null) {
                bl4 = bl2;
                break;
            }
            ++n11;
        }
        menuBuilder = this.mContext;
        object = new ActionMenuPresenter$ActionButtonSubmenu(this, (Context)menuBuilder, subMenuBuilder, (View)subMenuBuilder2);
        this.mActionButtonPopup = object;
        ((MenuPopupHelper)object).setForceShowIcon(bl4);
        this.mActionButtonPopup.show();
        super.onSubMenuSelected(subMenuBuilder);
        return bl2;
    }

    public void onSubUiVisibilityChanged(boolean bl2) {
        if (bl2) {
            bl2 = false;
            Object var2_2 = null;
            super.onSubMenuSelected(null);
        } else {
            MenuBuilder menuBuilder = this.mMenu;
            if (menuBuilder != null) {
                menuBuilder.close(false);
            }
        }
    }

    public void setExpandedActionViewsExclusive(boolean bl2) {
        this.mExpandedActionViewsExclusive = bl2;
    }

    public void setItemLimit(int n10) {
        this.mMaxItems = n10;
        this.mMaxItemsSet = true;
    }

    public void setMenuView(ActionMenuView actionMenuView) {
        this.mMenuView = actionMenuView;
        MenuBuilder menuBuilder = this.mMenu;
        actionMenuView.initialize(menuBuilder);
    }

    public void setOverflowIcon(Drawable drawable2) {
        ActionMenuPresenter$OverflowMenuButton actionMenuPresenter$OverflowMenuButton = this.mOverflowButton;
        if (actionMenuPresenter$OverflowMenuButton != null) {
            actionMenuPresenter$OverflowMenuButton.setImageDrawable(drawable2);
        } else {
            boolean bl2;
            this.mPendingOverflowIconSet = bl2 = true;
            this.mPendingOverflowIcon = drawable2;
        }
    }

    public void setReserveOverflow(boolean bl2) {
        this.mReserveOverflow = bl2;
        this.mReserveOverflowSet = true;
    }

    public void setWidthLimit(int n10, boolean bl2) {
        this.mWidthLimit = n10;
        this.mStrictWidthLimit = bl2;
        this.mWidthLimitSet = true;
    }

    public boolean shouldIncludeItem(int n10, MenuItemImpl menuItemImpl) {
        return menuItemImpl.isActionButton();
    }

    public boolean showOverflowMenu() {
        Object object;
        Object object2;
        boolean bl2 = this.mReserveOverflow;
        if (bl2 && !(bl2 = this.isOverflowMenuShowing()) && (object2 = this.mMenu) != null && (object = this.mMenuView) != null && (object = this.mPostedOpenRunnable) == null && !(bl2 = ((ArrayList)(object2 = ((MenuBuilder)object2).getNonActionItems())).isEmpty())) {
            Context context = this.mContext;
            MenuBuilder menuBuilder = this.mMenu;
            ActionMenuPresenter$OverflowMenuButton actionMenuPresenter$OverflowMenuButton = this.mOverflowButton;
            object = object2;
            object2 = new ActionMenuPresenter$OverflowPopup(this, context, menuBuilder, (View)actionMenuPresenter$OverflowMenuButton, true);
            this.mPostedOpenRunnable = object = new ActionMenuPresenter$OpenOverflowRunnable(this, (ActionMenuPresenter$OverflowPopup)object2);
            ((View)this.mMenuView).post((Runnable)object);
            return true;
        }
        return false;
    }

    public void updateMenuView(boolean bl2) {
        int n10;
        int n11;
        super.updateMenuView(bl2);
        ((View)this.mMenuView).requestLayout();
        Object object = this.mMenu;
        int n12 = 0;
        Object object2 = null;
        if (object != null) {
            object = ((MenuBuilder)object).getActionItems();
            n11 = ((ArrayList)object).size();
            for (n10 = 0; n10 < n11; n10 += 1) {
                ActionProvider actionProvider = ((MenuItemImpl)((ArrayList)object).get(n10)).getSupportActionProvider();
                if (actionProvider == null) continue;
                actionProvider.setSubUiVisibilityListener(this);
            }
        }
        if ((object = this.mMenu) != null) {
            object = ((MenuBuilder)object).getNonActionItems();
        } else {
            bl2 = false;
            object = null;
        }
        n11 = (int)(this.mReserveOverflow ? 1 : 0);
        if (n11 && object != null) {
            n11 = ((ArrayList)object).size();
            if (n11 == (n10 = 1)) {
                object = (MenuItemImpl)((ArrayList)object).get(0);
                bl2 = ((MenuItemImpl)object).isActionViewExpanded();
                n12 = bl2 ^ true;
            } else if (n11 > 0) {
                n12 = n10;
            }
        }
        if (n12) {
            object = this.mOverflowButton;
            if (object == null) {
                object2 = this.mSystemContext;
                this.mOverflowButton = object = new ActionMenuPresenter$OverflowMenuButton(this, (Context)object2);
            }
            if ((object = (ViewGroup)this.mOverflowButton.getParent()) != (object2 = this.mMenuView)) {
                if (object != null) {
                    object2 = this.mOverflowButton;
                    object.removeView((View)object2);
                }
                object = (ActionMenuView)this.mMenuView;
                object2 = this.mOverflowButton;
                ActionMenuView$LayoutParams actionMenuView$LayoutParams = ((ActionMenuView)object).generateOverflowButtonLayoutParams();
                object.addView((View)object2, (ViewGroup.LayoutParams)actionMenuView$LayoutParams);
            }
        } else {
            object = this.mOverflowButton;
            if (object != null && (object = object.getParent()) == (object2 = this.mMenuView)) {
                object2 = (ViewGroup)object2;
                object = this.mOverflowButton;
                object2.removeView((View)object);
            }
        }
        object = (ActionMenuView)this.mMenuView;
        n12 = (int)(this.mReserveOverflow ? 1 : 0);
        ((ActionMenuView)object).setOverflowReserved(n12 != 0);
    }
}

