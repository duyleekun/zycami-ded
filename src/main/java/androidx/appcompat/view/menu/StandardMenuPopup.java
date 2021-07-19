/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Rect
 *  android.os.Parcelable
 *  android.view.Gravity
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.View$OnKeyListener
 *  android.view.ViewGroup
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.FrameLayout
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.PopupWindow$OnDismissListener
 *  android.widget.TextView
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopup;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuPresenter$Callback;
import androidx.appcompat.view.menu.StandardMenuPopup$1;
import androidx.appcompat.view.menu.StandardMenuPopup$2;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.ViewCompat;

public final class StandardMenuPopup
extends MenuPopup
implements PopupWindow.OnDismissListener,
AdapterView.OnItemClickListener,
MenuPresenter,
View.OnKeyListener {
    private static final int ITEM_LAYOUT = R$layout.abc_popup_menu_item_layout;
    private final MenuAdapter mAdapter;
    private View mAnchorView;
    private final View.OnAttachStateChangeListener mAttachStateChangeListener;
    private int mContentWidth;
    private final Context mContext;
    private int mDropDownGravity;
    public final ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
    private boolean mHasContentWidth;
    private final MenuBuilder mMenu;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    public final MenuPopupWindow mPopup;
    private final int mPopupMaxWidth;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private MenuPresenter$Callback mPresenterCallback;
    private boolean mShowTitle;
    public View mShownAnchorView;
    public ViewTreeObserver mTreeObserver;
    private boolean mWasDismissed;

    public StandardMenuPopup(Context context, MenuBuilder menuBuilder, View object, int n10, int n11, boolean bl2) {
        int n12;
        MenuAdapter menuAdapter;
        Object object2 = new StandardMenuPopup$1(this);
        this.mGlobalLayoutListener = object2;
        object2 = new StandardMenuPopup$2(this);
        this.mAttachStateChangeListener = object2;
        this.mDropDownGravity = 0;
        this.mContext = context;
        this.mMenu = menuBuilder;
        this.mOverflowOnly = bl2;
        object2 = LayoutInflater.from((Context)context);
        int n13 = ITEM_LAYOUT;
        this.mAdapter = menuAdapter = new MenuAdapter(menuBuilder, (LayoutInflater)object2, bl2, n13);
        this.mPopupStyleAttr = n10;
        this.mPopupStyleRes = n11;
        Resources resources = context.getResources();
        int n14 = resources.getDisplayMetrics().widthPixels / 2;
        int n15 = R$dimen.abc_config_prefDialogWidth;
        int n16 = resources.getDimensionPixelSize(n15);
        this.mPopupMaxWidth = n12 = Math.max(n14, n16);
        this.mAnchorView = object;
        this.mPopup = object = new MenuPopupWindow(context, null, n10, n11);
        menuBuilder.addMenuPresenter(this, context);
    }

    /*
     * WARNING - void declaration
     */
    private boolean tryShow() {
        Object object;
        int n10 = this.isShowing();
        boolean bl2 = true;
        if (n10 != 0) {
            return bl2;
        }
        n10 = this.mWasDismissed;
        MenuAdapter menuAdapter = null;
        if (n10 == 0 && (object = this.mAnchorView) != null) {
            int n11;
            void var6_8;
            Object object2;
            this.mShownAnchorView = object;
            this.mPopup.setOnDismissListener(this);
            this.mPopup.setOnItemClickListener(this);
            this.mPopup.setModal(bl2);
            object = this.mShownAnchorView;
            ViewTreeObserver viewTreeObserver = this.mTreeObserver;
            if (viewTreeObserver == null) {
                boolean bl3 = bl2;
            } else {
                boolean bl3 = false;
                viewTreeObserver = null;
            }
            this.mTreeObserver = object2 = object.getViewTreeObserver();
            if (var6_8 != false) {
                viewTreeObserver = this.mGlobalLayoutListener;
                object2.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)viewTreeObserver);
            }
            viewTreeObserver = this.mAttachStateChangeListener;
            object.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)viewTreeObserver);
            this.mPopup.setAnchorView((View)object);
            object = this.mPopup;
            int n12 = this.mDropDownGravity;
            ((ListPopupWindow)object).setDropDownGravity(n12);
            n10 = this.mHasContentWidth;
            boolean bl4 = false;
            viewTreeObserver = null;
            if (n10 == 0) {
                object = this.mAdapter;
                object2 = this.mContext;
                n11 = this.mPopupMaxWidth;
                this.mContentWidth = n10 = MenuPopup.measureIndividualMenuWidth((ListAdapter)object, null, (Context)object2, n11);
                this.mHasContentWidth = bl2;
            }
            object = this.mPopup;
            int n13 = this.mContentWidth;
            ((ListPopupWindow)object).setContentWidth(n13);
            this.mPopup.setInputMethodMode(2);
            object = this.mPopup;
            object2 = this.getEpicenterBounds();
            ((ListPopupWindow)object).setEpicenterBounds((Rect)object2);
            this.mPopup.show();
            object = this.mPopup.getListView();
            object.setOnKeyListener((View.OnKeyListener)this);
            n13 = (int)(this.mShowTitle ? 1 : 0);
            if (n13 != 0 && (object2 = this.mMenu.getHeaderTitle()) != null) {
                object2 = LayoutInflater.from((Context)this.mContext);
                n11 = R$layout.abc_popup_menu_header_item_layout;
                TextView textView = (TextView)(object2 = (FrameLayout)object2.inflate(n11, (ViewGroup)object, false)).findViewById(n11 = 16908310);
                if (textView != null) {
                    CharSequence charSequence = this.mMenu.getHeaderTitle();
                    textView.setText(charSequence);
                }
                object2.setEnabled(false);
                object.addHeaderView((View)object2, null, false);
            }
            object = this.mPopup;
            menuAdapter = this.mAdapter;
            ((ListPopupWindow)object).setAdapter((ListAdapter)menuAdapter);
            this.mPopup.show();
            return bl2;
        }
        return false;
    }

    public void addMenu(MenuBuilder menuBuilder) {
    }

    public void dismiss() {
        boolean bl2 = this.isShowing();
        if (bl2) {
            MenuPopupWindow menuPopupWindow = this.mPopup;
            menuPopupWindow.dismiss();
        }
    }

    public boolean flagActionItems() {
        return false;
    }

    public ListView getListView() {
        return this.mPopup.getListView();
    }

    public boolean isShowing() {
        MenuPopupWindow menuPopupWindow;
        boolean bl2 = this.mWasDismissed;
        if (!bl2 && (bl2 = (menuPopupWindow = this.mPopup).isShowing())) {
            bl2 = true;
        } else {
            bl2 = false;
            menuPopupWindow = null;
        }
        return bl2;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl2) {
        Object object = this.mMenu;
        if (menuBuilder != object) {
            return;
        }
        this.dismiss();
        object = this.mPresenterCallback;
        if (object != null) {
            object.onCloseMenu(menuBuilder, bl2);
        }
    }

    public void onDismiss() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        boolean bl2;
        this.mWasDismissed = bl2 = true;
        this.mMenu.close();
        ViewTreeObserver viewTreeObserver = this.mTreeObserver;
        if (viewTreeObserver != null) {
            bl2 = viewTreeObserver.isAlive();
            if (!bl2) {
                this.mTreeObserver = viewTreeObserver = this.mShownAnchorView.getViewTreeObserver();
            }
            viewTreeObserver = this.mTreeObserver;
            onAttachStateChangeListener = this.mGlobalLayoutListener;
            viewTreeObserver.removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)onAttachStateChangeListener);
            bl2 = false;
            viewTreeObserver = null;
            this.mTreeObserver = null;
        }
        viewTreeObserver = this.mShownAnchorView;
        onAttachStateChangeListener = this.mAttachStateChangeListener;
        viewTreeObserver.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        viewTreeObserver = this.mOnDismissListener;
        if (viewTreeObserver != null) {
            viewTreeObserver.onDismiss();
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
        boolean bl2 = subMenuBuilder.hasVisibleItems();
        if (bl2) {
            Object object;
            Object object2 = this.mContext;
            View view = this.mShownAnchorView;
            boolean bl3 = this.mOverflowOnly;
            int n10 = this.mPopupStyleAttr;
            int n11 = this.mPopupStyleRes;
            Object object3 = object;
            SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
            object = new MenuPopupHelper((Context)object2, subMenuBuilder, view, bl3, n10, n11);
            object3 = this.mPresenterCallback;
            ((MenuPopupHelper)object).setPresenterCallback((MenuPresenter$Callback)object3);
            int n12 = MenuPopup.shouldPreserveIconSpacing(subMenuBuilder);
            ((MenuPopupHelper)object).setForceShowIcon(n12 != 0);
            object3 = this.mOnDismissListener;
            ((MenuPopupHelper)object).setOnDismissListener((PopupWindow.OnDismissListener)object3);
            this.mOnDismissListener = null;
            this.mMenu.close(false);
            object3 = this.mPopup;
            n12 = ((ListPopupWindow)object3).getHorizontalOffset();
            object2 = this.mPopup;
            int n13 = ((ListPopupWindow)object2).getVerticalOffset();
            int n14 = this.mDropDownGravity;
            view = this.mAnchorView;
            int n15 = ViewCompat.getLayoutDirection(view);
            n14 = Gravity.getAbsoluteGravity((int)n14, (int)n15) & 7;
            n15 = 5;
            if (n14 == n15) {
                subMenuBuilder2 = this.mAnchorView;
                n14 = subMenuBuilder2.getWidth();
                n12 += n14;
            }
            if (bl2 = ((MenuPopupHelper)object).tryShow(n12, n13)) {
                object = this.mPresenterCallback;
                if (object != null) {
                    object.onOpenSubMenu(subMenuBuilder);
                }
                return true;
            }
        }
        return false;
    }

    public void setAnchorView(View view) {
        this.mAnchorView = view;
    }

    public void setCallback(MenuPresenter$Callback menuPresenter$Callback) {
        this.mPresenterCallback = menuPresenter$Callback;
    }

    public void setForceShowIcon(boolean bl2) {
        this.mAdapter.setForceShowIcon(bl2);
    }

    public void setGravity(int n10) {
        this.mDropDownGravity = n10;
    }

    public void setHorizontalOffset(int n10) {
        this.mPopup.setHorizontalOffset(n10);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setShowTitle(boolean bl2) {
        this.mShowTitle = bl2;
    }

    public void setVerticalOffset(int n10) {
        this.mPopup.setVerticalOffset(n10);
    }

    public void show() {
        boolean bl2 = this.tryShow();
        if (bl2) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        throw illegalStateException;
    }

    public void updateMenuView(boolean bl2) {
        this.mHasContentWidth = false;
        MenuAdapter menuAdapter = this.mAdapter;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }
}

