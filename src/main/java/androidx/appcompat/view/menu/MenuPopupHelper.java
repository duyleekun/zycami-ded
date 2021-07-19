/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Point
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.WindowManager
 *  android.widget.ListView
 *  android.widget.PopupWindow$OnDismissListener
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$dimen;
import androidx.appcompat.view.menu.CascadingMenuPopup;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuHelper;
import androidx.appcompat.view.menu.MenuPopup;
import androidx.appcompat.view.menu.MenuPopupHelper$1;
import androidx.appcompat.view.menu.MenuPresenter$Callback;
import androidx.appcompat.view.menu.StandardMenuPopup;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

public class MenuPopupHelper
implements MenuHelper {
    private static final int TOUCH_EPICENTER_SIZE_DP = 48;
    private View mAnchorView;
    private final Context mContext;
    private int mDropDownGravity;
    private boolean mForceShowIcon;
    private final PopupWindow.OnDismissListener mInternalOnDismissListener;
    private final MenuBuilder mMenu;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    private MenuPopup mPopup;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private MenuPresenter$Callback mPresenterCallback;

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder) {
        int n10 = R$attr.popupMenuStyle;
        this(context, menuBuilder, null, false, n10, 0);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view) {
        int n10 = R$attr.popupMenuStyle;
        this(context, menuBuilder, view, false, n10, 0);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean bl2, int n10) {
        this(context, menuBuilder, view, bl2, n10, 0);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean bl2, int n10, int n11) {
        this.mDropDownGravity = 0x800003;
        MenuPopupHelper$1 menuPopupHelper$1 = new MenuPopupHelper$1(this);
        this.mInternalOnDismissListener = menuPopupHelper$1;
        this.mContext = context;
        this.mMenu = menuBuilder;
        this.mAnchorView = view;
        this.mOverflowOnly = bl2;
        this.mPopupStyleAttr = n10;
        this.mPopupStyleRes = n11;
    }

    private MenuPopup createPopup() {
        Object object = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay();
        Object object2 = new Point();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11) {
            object.getRealSize(object2);
        } else {
            object.getSize(object2);
        }
        int n12 = object2.x;
        int n13 = object2.y;
        n12 = Math.min(n12, n13);
        object2 = this.mContext.getResources();
        n10 = R$dimen.abc_cascading_menus_min_smallest_width;
        n13 = object2.getDimensionPixelSize(n10);
        if (n12 >= n13) {
            n12 = 1;
        } else {
            n12 = 0;
            object = null;
        }
        if (n12 != 0) {
            Context context = this.mContext;
            View view = this.mAnchorView;
            int n14 = this.mPopupStyleAttr;
            int n15 = this.mPopupStyleRes;
            boolean bl2 = this.mOverflowOnly;
            object2 = object;
            object = new CascadingMenuPopup(context, view, n14, n15, bl2);
        } else {
            Context context = this.mContext;
            MenuBuilder menuBuilder = this.mMenu;
            View view = this.mAnchorView;
            int n16 = this.mPopupStyleAttr;
            int n17 = this.mPopupStyleRes;
            boolean bl3 = this.mOverflowOnly;
            object = new StandardMenuPopup(context, menuBuilder, view, n16, n17, bl3);
        }
        object2 = this.mMenu;
        ((MenuPopup)object).addMenu((MenuBuilder)object2);
        object2 = this.mInternalOnDismissListener;
        ((MenuPopup)object).setOnDismissListener((PopupWindow.OnDismissListener)object2);
        object2 = this.mAnchorView;
        ((MenuPopup)object).setAnchorView((View)object2);
        object2 = this.mPresenterCallback;
        object.setCallback((MenuPresenter$Callback)object2);
        n13 = (int)(this.mForceShowIcon ? 1 : 0);
        ((MenuPopup)object).setForceShowIcon(n13 != 0);
        n13 = this.mDropDownGravity;
        ((MenuPopup)object).setGravity(n13);
        return object;
    }

    /*
     * WARNING - void declaration
     */
    private void showPopup(int n10, int n11, boolean bl2, boolean bl3) {
        void var4_8;
        MenuPopup menuPopup = this.getPopup();
        menuPopup.setShowTitle((boolean)var4_8);
        if (bl2) {
            View view;
            int n12 = this.mDropDownGravity;
            View view2 = this.mAnchorView;
            int n13 = ViewCompat.getLayoutDirection(view2);
            int n14 = GravityCompat.getAbsoluteGravity(n12, n13) & 7;
            int n15 = 5;
            float f10 = 7.0E-45f;
            if (n14 == n15) {
                view = this.mAnchorView;
                int n16 = view.getWidth();
                n10 -= n16;
            }
            menuPopup.setHorizontalOffset(n10);
            menuPopup.setVerticalOffset(n11);
            view = this.mContext.getResources().getDisplayMetrics();
            float f11 = view.density * 48.0f;
            int n17 = 0x40000000;
            f10 = 2.0f;
            int n18 = (int)(f11 /= f10);
            int n19 = n10 - n18;
            int n20 = n11 - n18;
            view2 = new Rect(n19, n20, n10 += n18, n11 += n18);
            menuPopup.setEpicenterBounds((Rect)view2);
        }
        menuPopup.show();
    }

    public void dismiss() {
        boolean bl2 = this.isShowing();
        if (bl2) {
            MenuPopup menuPopup = this.mPopup;
            menuPopup.dismiss();
        }
    }

    public int getGravity() {
        return this.mDropDownGravity;
    }

    public ListView getListView() {
        return this.getPopup().getListView();
    }

    public MenuPopup getPopup() {
        MenuPopup menuPopup = this.mPopup;
        if (menuPopup == null) {
            this.mPopup = menuPopup = this.createPopup();
        }
        return this.mPopup;
    }

    public boolean isShowing() {
        boolean bl2;
        MenuPopup menuPopup = this.mPopup;
        if (menuPopup != null && (bl2 = menuPopup.isShowing())) {
            bl2 = true;
        } else {
            bl2 = false;
            menuPopup = null;
        }
        return bl2;
    }

    public void onDismiss() {
        this.mPopup = null;
        PopupWindow.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void setAnchorView(View view) {
        this.mAnchorView = view;
    }

    public void setForceShowIcon(boolean bl2) {
        this.mForceShowIcon = bl2;
        MenuPopup menuPopup = this.mPopup;
        if (menuPopup != null) {
            menuPopup.setForceShowIcon(bl2);
        }
    }

    public void setGravity(int n10) {
        this.mDropDownGravity = n10;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setPresenterCallback(MenuPresenter$Callback menuPresenter$Callback) {
        this.mPresenterCallback = menuPresenter$Callback;
        MenuPopup menuPopup = this.mPopup;
        if (menuPopup != null) {
            menuPopup.setCallback(menuPresenter$Callback);
        }
    }

    public void show() {
        boolean bl2 = this.tryShow();
        if (bl2) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        throw illegalStateException;
    }

    public void show(int n10, int n11) {
        if ((n10 = (int)(this.tryShow(n10, n11) ? 1 : 0)) != 0) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        throw illegalStateException;
    }

    public boolean tryShow() {
        boolean bl2 = this.isShowing();
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        View view = this.mAnchorView;
        if (view == null) {
            return false;
        }
        this.showPopup(0, 0, false, false);
        return bl3;
    }

    public boolean tryShow(int n10, int n11) {
        boolean bl2 = this.isShowing();
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        View view = this.mAnchorView;
        if (view == null) {
            return false;
        }
        this.showPopup(n10, n11, bl3, bl3);
        return bl3;
    }
}

