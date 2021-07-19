/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Parcelable
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.MenuItem
 *  android.view.SubMenu
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.View$OnKeyListener
 *  android.view.ViewGroup
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.FrameLayout
 *  android.widget.HeaderViewListAdapter
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.PopupWindow$OnDismissListener
 *  android.widget.TextView
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.CascadingMenuPopup$1;
import androidx.appcompat.view.menu.CascadingMenuPopup$2;
import androidx.appcompat.view.menu.CascadingMenuPopup$3;
import androidx.appcompat.view.menu.CascadingMenuPopup$CascadingMenuInfo;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopup;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuPresenter$Callback;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class CascadingMenuPopup
extends MenuPopup
implements MenuPresenter,
View.OnKeyListener,
PopupWindow.OnDismissListener {
    public static final int HORIZ_POSITION_LEFT = 0;
    public static final int HORIZ_POSITION_RIGHT = 1;
    private static final int ITEM_LAYOUT = 0;
    public static final int SUBMENU_TIMEOUT_MS = 200;
    private View mAnchorView;
    private final View.OnAttachStateChangeListener mAttachStateChangeListener;
    private final Context mContext;
    private int mDropDownGravity;
    private boolean mForceShowIcon;
    public final ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
    private boolean mHasXOffset;
    private boolean mHasYOffset;
    private int mLastPosition;
    private final MenuItemHoverListener mMenuItemHoverListener;
    private final int mMenuMaxWidth;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    private final List mPendingMenus;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private MenuPresenter$Callback mPresenterCallback;
    private int mRawDropDownGravity;
    public boolean mShouldCloseImmediately;
    private boolean mShowTitle;
    public final List mShowingMenus;
    public View mShownAnchorView;
    public final Handler mSubMenuHoverHandler;
    public ViewTreeObserver mTreeObserver;
    private int mXOffset;
    private int mYOffset;

    static {
        ITEM_LAYOUT = R$layout.abc_cascading_menu_item_layout;
    }

    public CascadingMenuPopup(Context context, View view, int n10, int n11, boolean bl2) {
        int n12;
        Object object = new ArrayList();
        this.mPendingMenus = object;
        object = new ArrayList();
        this.mShowingMenus = object;
        object = new CascadingMenuPopup$1(this);
        this.mGlobalLayoutListener = object;
        object = new CascadingMenuPopup$2(this);
        this.mAttachStateChangeListener = object;
        this.mMenuItemHoverListener = object = new CascadingMenuPopup$3(this);
        this.mRawDropDownGravity = 0;
        this.mDropDownGravity = 0;
        this.mContext = context;
        this.mAnchorView = view;
        this.mPopupStyleAttr = n10;
        this.mPopupStyleRes = n11;
        this.mOverflowOnly = bl2;
        this.mForceShowIcon = false;
        this.mLastPosition = n12 = this.getInitialMenuPosition();
        context = context.getResources();
        n12 = context.getDisplayMetrics().widthPixels / 2;
        n10 = R$dimen.abc_config_prefDialogWidth;
        int n13 = context.getDimensionPixelSize(n10);
        this.mMenuMaxWidth = n13 = Math.max(n12, n13);
        this.mSubMenuHoverHandler = context;
    }

    private MenuPopupWindow createPopupWindow() {
        Object object = this.mContext;
        int n10 = this.mPopupStyleAttr;
        int n11 = this.mPopupStyleRes;
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow((Context)object, null, n10, n11);
        object = this.mMenuItemHoverListener;
        menuPopupWindow.setHoverListener((MenuItemHoverListener)object);
        menuPopupWindow.setOnItemClickListener(this);
        menuPopupWindow.setOnDismissListener(this);
        object = this.mAnchorView;
        menuPopupWindow.setAnchorView((View)object);
        int n12 = this.mDropDownGravity;
        menuPopupWindow.setDropDownGravity(n12);
        menuPopupWindow.setModal(true);
        menuPopupWindow.setInputMethodMode(2);
        return menuPopupWindow;
    }

    private int findIndexOfAddedMenu(MenuBuilder menuBuilder) {
        List list = this.mShowingMenus;
        int n10 = list.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            MenuBuilder menuBuilder2 = ((CascadingMenuPopup$CascadingMenuInfo)this.mShowingMenus.get((int)i10)).menu;
            if (menuBuilder != menuBuilder2) continue;
            return i10;
        }
        return -1;
    }

    private MenuItem findMenuItemForSubmenu(MenuBuilder menuBuilder, MenuBuilder menuBuilder2) {
        int n10 = menuBuilder.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            SubMenu subMenu;
            MenuItem menuItem = menuBuilder.getItem(i10);
            boolean bl2 = menuItem.hasSubMenu();
            if (!bl2 || menuBuilder2 != (subMenu = menuItem.getSubMenu())) continue;
            return menuItem;
        }
        return null;
    }

    private View findParentViewForSubmenu(CascadingMenuPopup$CascadingMenuInfo cascadingMenuPopup$CascadingMenuInfo, MenuBuilder menuBuilder) {
        int n10;
        int n11;
        int n12;
        block7: {
            MenuBuilder menuBuilder2 = cascadingMenuPopup$CascadingMenuInfo.menu;
            menuBuilder = this.findMenuItemForSubmenu(menuBuilder2, menuBuilder);
            menuBuilder2 = null;
            if (menuBuilder == null) {
                return null;
            }
            cascadingMenuPopup$CascadingMenuInfo = cascadingMenuPopup$CascadingMenuInfo.getListView();
            Object object = cascadingMenuPopup$CascadingMenuInfo.getAdapter();
            n12 = object instanceof HeaderViewListAdapter;
            n11 = 0;
            if (n12 != 0) {
                object = (HeaderViewListAdapter)object;
                n12 = object.getHeadersCount();
                object = (MenuAdapter)object.getWrappedAdapter();
            } else {
                object = (MenuAdapter)((Object)object);
                n12 = 0;
            }
            int n13 = ((MenuAdapter)((Object)object)).getCount();
            while (true) {
                n10 = -1;
                if (n11 >= n13) break;
                MenuItemImpl menuItemImpl = ((MenuAdapter)((Object)object)).getItem(n11);
                if (menuBuilder != menuItemImpl) {
                    ++n11;
                    continue;
                }
                break block7;
                break;
            }
            n11 = n10;
        }
        if (n11 == n10) {
            return null;
        }
        n11 += n12;
        int n14 = cascadingMenuPopup$CascadingMenuInfo.getFirstVisiblePosition();
        if ((n11 -= n14) >= 0 && n11 < (n14 = cascadingMenuPopup$CascadingMenuInfo.getChildCount())) {
            return cascadingMenuPopup$CascadingMenuInfo.getChildAt(n11);
        }
        return null;
    }

    private int getInitialMenuPosition() {
        int n10;
        View view = this.mAnchorView;
        int n11 = ViewCompat.getLayoutDirection(view);
        if (n11 == (n10 = 1)) {
            n10 = 0;
        }
        return n10;
    }

    private int getNextMenuPosition(int n10) {
        List list = this.mShowingMenus;
        int n11 = list.size();
        int n12 = 1;
        list = ((CascadingMenuPopup$CascadingMenuInfo)list.get(n11 -= n12)).getListView();
        n11 = 2;
        int[] nArray = new int[n11];
        list.getLocationOnScreen(nArray);
        Rect rect = new Rect();
        View view = this.mShownAnchorView;
        view.getWindowVisibleDisplayFrame(rect);
        int n13 = this.mLastPosition;
        if (n13 == n12) {
            n11 = nArray[0];
            int n14 = list.getWidth();
            if ((n11 = n11 + n14 + n10) > (n10 = rect.right)) {
                return 0;
            }
            return n12;
        }
        int n15 = nArray[0] - n10;
        if (n15 < 0) {
            return n12;
        }
        return 0;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void showMenu(MenuBuilder var1_1) {
        block15: {
            block13: {
                block14: {
                    var2_2 = LayoutInflater.from((Context)this.mContext);
                    var4_4 = this.mOverflowOnly;
                    var5_5 = CascadingMenuPopup.ITEM_LAYOUT;
                    var3_3 = new MenuAdapter((MenuBuilder)var1_1, var2_2, (boolean)var4_4, var5_5);
                    var4_4 = this.isShowing();
                    var5_5 = 1;
                    if (var4_4 == 0 && (var4_4 = this.mForceShowIcon) != 0) {
                        var3_3.setForceShowIcon((boolean)var5_5);
                    } else {
                        var4_4 = this.isShowing();
                        if (var4_4 != 0) {
                            var4_4 = MenuPopup.shouldPreserveIconSpacing((MenuBuilder)var1_1);
                            var3_3.setForceShowIcon((boolean)var4_4);
                        }
                    }
                    var6_6 /* !! */  = this.mContext;
                    var7_7 = this.mMenuMaxWidth;
                    var4_4 = MenuPopup.measureIndividualMenuWidth((ListAdapter)var3_3, null, var6_6 /* !! */ , var7_7);
                    var8_8 = this.createPopupWindow();
                    var8_8.setAdapter((ListAdapter)var3_3);
                    var8_8.setContentWidth(var4_4);
                    var9_9 = this.mDropDownGravity;
                    var8_8.setDropDownGravity(var9_9);
                    var3_3 = this.mShowingMenus;
                    var9_9 = var3_3.size();
                    if (var9_9 > 0) {
                        var3_3 = this.mShowingMenus;
                        var10_10 = var3_3.size() - var5_5;
                        var3_3 = (CascadingMenuPopup$CascadingMenuInfo)var3_3.get(var10_10);
                        var11_12 = this.findParentViewForSubmenu((CascadingMenuPopup$CascadingMenuInfo)var3_3, (MenuBuilder)var1_1);
                    } else {
                        var9_9 = 0;
                        var3_3 = null;
                        var10_11 = false;
                        var11_12 = null;
                    }
                    if (var11_12 == null) break block13;
                    var8_8.setTouchModal(false);
                    var8_8.setEnterTransition(null);
                    var12_13 = this.getNextMenuPosition(var4_4);
                    var13_14 = var12_13 == var5_5 ? var5_5 : 0;
                    this.mLastPosition = var12_13;
                    var12_13 = Build.VERSION.SDK_INT;
                    var14_15 = 26;
                    var15_16 = 5;
                    if (var12_13 >= var14_15) {
                        var8_8.setAnchorView(var11_12);
                        var12_13 = 0;
                        var16_17 = null;
                        var17_19 = 0;
                        var18_20 = null;
                    } else {
                        var12_13 = 2;
                        var19_22 = new int[var12_13];
                        var18_21 = this.mAnchorView;
                        var18_21.getLocationOnScreen(var19_22);
                        var16_18 = new int[var12_13];
                        var11_12.getLocationOnScreen(var16_18);
                        var17_19 = this.mDropDownGravity & 7;
                        if (var17_19 == var15_16) {
                            var17_19 = var19_22[0];
                            var20_23 = this.mAnchorView;
                            var21_24 = var20_23.getWidth();
                            var19_22[0] = var17_19 += var21_24;
                            var17_19 = var16_18[0];
                            var21_24 = var11_12.getWidth();
                            var16_18[0] = var17_19 += var21_24;
                        }
                        var17_19 = var16_18[0];
                        var21_24 = var19_22[0];
                        var17_19 -= var21_24;
                        var12_13 = var16_18[var5_5];
                        var14_15 = var19_22[var5_5];
                        var12_13 -= var14_15;
                    }
                    var14_15 = this.mDropDownGravity & var15_16;
                    if (var14_15 != var15_16) break block14;
                    if (var13_14 != 0) ** GOTO lbl79
                    var4_4 = var11_12.getWidth();
                    ** GOTO lbl-1000
                }
                if (var13_14 != 0) {
                    var4_4 = var11_12.getWidth();
lbl79:
                    // 2 sources

                    var17_19 += var4_4;
                } else lbl-1000:
                // 2 sources

                {
                    var17_19 -= var4_4;
                }
                var8_8.setHorizontalOffset(var17_19);
                var8_8.setOverlapAnchor((boolean)var5_5);
                var8_8.setVerticalOffset(var12_13);
                break block15;
            }
            var4_4 = (int)this.mHasXOffset;
            if (var4_4 != 0) {
                var4_4 = this.mXOffset;
                var8_8.setHorizontalOffset(var4_4);
            }
            if ((var4_4 = (int)this.mHasYOffset) != 0) {
                var4_4 = this.mYOffset;
                var8_8.setVerticalOffset(var4_4);
            }
            var6_6 /* !! */  = this.getEpicenterBounds();
            var8_8.setEpicenterBounds((Rect)var6_6 /* !! */ );
        }
        var5_5 = this.mLastPosition;
        var6_6 /* !! */  = new CascadingMenuPopup$CascadingMenuInfo(var8_8, (MenuBuilder)var1_1, var5_5);
        var22_25 = this.mShowingMenus;
        var22_25.add(var6_6 /* !! */ );
        var8_8.show();
        var6_6 /* !! */  = var8_8.getListView();
        var6_6 /* !! */ .setOnKeyListener((View.OnKeyListener)this);
        if (var3_3 == null && (var9_9 = (int)this.mShowTitle) != 0 && (var3_3 = var1_1.getHeaderTitle()) != null) {
            var9_9 = R$layout.abc_popup_menu_header_item_layout;
            var2_2 = (FrameLayout)var2_2.inflate(var9_9, (ViewGroup)var6_6 /* !! */ , false);
            var9_9 = 16908310;
            var3_3 = (TextView)var2_2.findViewById(var9_9);
            var2_2.setEnabled(false);
            var1_1 = var1_1.getHeaderTitle();
            var3_3.setText((CharSequence)var1_1);
            var6_6 /* !! */ .addHeaderView((View)var2_2, null, false);
            var8_8.show();
        }
    }

    public void addMenu(MenuBuilder menuBuilder) {
        Object object = this.mContext;
        menuBuilder.addMenuPresenter(this, (Context)object);
        boolean bl2 = this.isShowing();
        if (bl2) {
            this.showMenu(menuBuilder);
        } else {
            object = this.mPendingMenus;
            object.add(menuBuilder);
        }
    }

    public boolean closeMenuOnSubMenuOpened() {
        return false;
    }

    public void dismiss() {
        List list = this.mShowingMenus;
        int n10 = list.size();
        if (n10 > 0) {
            CascadingMenuPopup$CascadingMenuInfo[] cascadingMenuPopup$CascadingMenuInfoArray = this.mShowingMenus;
            Object object = new CascadingMenuPopup$CascadingMenuInfo[n10];
            cascadingMenuPopup$CascadingMenuInfoArray = cascadingMenuPopup$CascadingMenuInfoArray.toArray((T[])object);
            n10 += -1;
            while (n10 >= 0) {
                object = cascadingMenuPopup$CascadingMenuInfoArray[n10];
                MenuPopupWindow menuPopupWindow = ((CascadingMenuPopup$CascadingMenuInfo)object).window;
                boolean bl2 = menuPopupWindow.isShowing();
                if (bl2) {
                    object = ((CascadingMenuPopup$CascadingMenuInfo)object).window;
                    ((ListPopupWindow)object).dismiss();
                }
                n10 += -1;
            }
        }
    }

    public boolean flagActionItems() {
        return false;
    }

    public ListView getListView() {
        List list = this.mShowingMenus;
        boolean bl2 = list.isEmpty();
        if (bl2) {
            bl2 = false;
            list = null;
        } else {
            list = this.mShowingMenus;
            int n10 = list.size() + -1;
            list = ((CascadingMenuPopup$CascadingMenuInfo)list.get(n10)).getListView();
        }
        return list;
    }

    public boolean isShowing() {
        Object object = this.mShowingMenus;
        int n10 = object.size();
        boolean bl2 = false;
        if (n10 > 0 && (n10 = (int)(((ListPopupWindow)(object = ((CascadingMenuPopup$CascadingMenuInfo)this.mShowingMenus.get((int)0)).window)).isShowing() ? 1 : 0)) != 0) {
            bl2 = true;
        }
        return bl2;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl2) {
        Object object;
        int n10 = this.findIndexOfAddedMenu(menuBuilder);
        if (n10 < 0) {
            return;
        }
        int n11 = n10 + 1;
        List list = this.mShowingMenus;
        int n12 = list.size();
        if (n11 < n12) {
            list = this.mShowingMenus;
            object = ((CascadingMenuPopup$CascadingMenuInfo)list.get((int)n11)).menu;
            ((MenuBuilder)object).close(false);
        }
        Object object2 = (CascadingMenuPopup$CascadingMenuInfo)this.mShowingMenus.remove(n10);
        object = ((CascadingMenuPopup$CascadingMenuInfo)object2).menu;
        ((MenuBuilder)object).removeMenuPresenter(this);
        n11 = (int)(this.mShouldCloseImmediately ? 1 : 0);
        n12 = 0;
        list = null;
        if (n11 != 0) {
            ((CascadingMenuPopup$CascadingMenuInfo)object2).window.setExitTransition(null);
            object = ((CascadingMenuPopup$CascadingMenuInfo)object2).window;
            ((ListPopupWindow)object).setAnimationStyle(0);
        }
        ((CascadingMenuPopup$CascadingMenuInfo)object2).window.dismiss();
        object2 = this.mShowingMenus;
        n10 = object2.size();
        if (n10 > 0) {
            object = this.mShowingMenus;
            int n13 = n10 + -1;
            object = (CascadingMenuPopup$CascadingMenuInfo)object.get(n13);
            this.mLastPosition = n11 = ((CascadingMenuPopup$CascadingMenuInfo)object).position;
        } else {
            this.mLastPosition = n11 = this.getInitialMenuPosition();
        }
        if (n10 == 0) {
            this.dismiss();
            MenuPresenter$Callback menuPresenter$Callback = this.mPresenterCallback;
            if (menuPresenter$Callback != null) {
                n10 = 1;
                menuPresenter$Callback.onCloseMenu(menuBuilder, n10 != 0);
            }
            if ((menuBuilder = this.mTreeObserver) != null) {
                boolean bl3 = menuBuilder.isAlive();
                if (bl3) {
                    menuBuilder = this.mTreeObserver;
                    menuPresenter$Callback = this.mGlobalLayoutListener;
                    menuBuilder.removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)menuPresenter$Callback);
                }
                this.mTreeObserver = null;
            }
            menuBuilder = this.mShownAnchorView;
            menuPresenter$Callback = this.mAttachStateChangeListener;
            menuBuilder.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)menuPresenter$Callback);
            menuBuilder = this.mOnDismissListener;
            menuBuilder.onDismiss();
        } else if (bl2) {
            menuBuilder = ((CascadingMenuPopup$CascadingMenuInfo)this.mShowingMenus.get((int)0)).menu;
            menuBuilder.close(false);
        }
    }

    public void onDismiss() {
        CascadingMenuPopup$CascadingMenuInfo cascadingMenuPopup$CascadingMenuInfo;
        Object object;
        block3: {
            object = this.mShowingMenus;
            int n10 = object.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                cascadingMenuPopup$CascadingMenuInfo = (CascadingMenuPopup$CascadingMenuInfo)this.mShowingMenus.get(i10);
                MenuPopupWindow menuPopupWindow = cascadingMenuPopup$CascadingMenuInfo.window;
                boolean bl2 = menuPopupWindow.isShowing();
                if (bl2) {
                    continue;
                }
                break block3;
            }
            cascadingMenuPopup$CascadingMenuInfo = null;
        }
        if (cascadingMenuPopup$CascadingMenuInfo != null) {
            object = cascadingMenuPopup$CascadingMenuInfo.menu;
            ((MenuBuilder)object).close(false);
        }
    }

    public boolean onKey(View view, int n10, KeyEvent keyEvent) {
        int n11;
        int n12 = keyEvent.getAction();
        if (n12 == (n11 = 1) && n10 == (n12 = 82)) {
            this.dismiss();
            return n11 != 0;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        boolean bl2;
        Object object;
        block3: {
            CascadingMenuPopup$CascadingMenuInfo cascadingMenuPopup$CascadingMenuInfo;
            MenuBuilder menuBuilder;
            object = this.mShowingMenus.iterator();
            do {
                boolean bl3 = object.hasNext();
                bl2 = true;
                if (!bl3) break block3;
                cascadingMenuPopup$CascadingMenuInfo = (CascadingMenuPopup$CascadingMenuInfo)object.next();
            } while (subMenuBuilder != (menuBuilder = cascadingMenuPopup$CascadingMenuInfo.menu));
            cascadingMenuPopup$CascadingMenuInfo.getListView().requestFocus();
            return bl2;
        }
        boolean bl4 = subMenuBuilder.hasVisibleItems();
        if (bl4) {
            this.addMenu(subMenuBuilder);
            object = this.mPresenterCallback;
            if (object != null) {
                object.onOpenSubMenu(subMenuBuilder);
            }
            return bl2;
        }
        return false;
    }

    public void setAnchorView(View view) {
        View view2 = this.mAnchorView;
        if (view2 != view) {
            this.mAnchorView = view;
            int n10 = this.mRawDropDownGravity;
            int n11 = ViewCompat.getLayoutDirection(view);
            this.mDropDownGravity = n11 = GravityCompat.getAbsoluteGravity(n10, n11);
        }
    }

    public void setCallback(MenuPresenter$Callback menuPresenter$Callback) {
        this.mPresenterCallback = menuPresenter$Callback;
    }

    public void setForceShowIcon(boolean bl2) {
        this.mForceShowIcon = bl2;
    }

    public void setGravity(int n10) {
        int n11 = this.mRawDropDownGravity;
        if (n11 != n10) {
            this.mRawDropDownGravity = n10;
            View view = this.mAnchorView;
            n11 = ViewCompat.getLayoutDirection(view);
            this.mDropDownGravity = n10 = GravityCompat.getAbsoluteGravity(n10, n11);
        }
    }

    public void setHorizontalOffset(int n10) {
        this.mHasXOffset = true;
        this.mXOffset = n10;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setShowTitle(boolean bl2) {
        this.mShowTitle = bl2;
    }

    public void setVerticalOffset(int n10) {
        this.mHasYOffset = true;
        this.mYOffset = n10;
    }

    public void show() {
        MenuBuilder menuBuilder;
        boolean bl2;
        boolean bl3 = this.isShowing();
        if (bl3) {
            return;
        }
        View view = this.mPendingMenus.iterator();
        while (bl2 = view.hasNext()) {
            menuBuilder = (MenuBuilder)view.next();
            this.showMenu(menuBuilder);
        }
        this.mPendingMenus.clear();
        this.mShownAnchorView = view = this.mAnchorView;
        if (view != null) {
            menuBuilder = this.mTreeObserver;
            if (menuBuilder == null) {
                bl2 = true;
            } else {
                bl2 = false;
                menuBuilder = null;
            }
            view = view.getViewTreeObserver();
            this.mTreeObserver = view;
            if (bl2) {
                menuBuilder = this.mGlobalLayoutListener;
                view.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)menuBuilder);
            }
            view = this.mShownAnchorView;
            menuBuilder = this.mAttachStateChangeListener;
            view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)menuBuilder);
        }
    }

    public void updateMenuView(boolean bl2) {
        boolean bl3;
        Iterator iterator2 = this.mShowingMenus.iterator();
        while (bl3 = iterator2.hasNext()) {
            MenuAdapter menuAdapter = MenuPopup.toMenuAdapter(((CascadingMenuPopup$CascadingMenuInfo)iterator2.next()).getListView().getAdapter());
            menuAdapter.notifyDataSetChanged();
        }
    }
}

