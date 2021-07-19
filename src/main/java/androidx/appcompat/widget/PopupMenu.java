/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.widget.ListView
 *  android.widget.PopupWindow$OnDismissListener
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder$Callback;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.widget.PopupMenu$1;
import androidx.appcompat.widget.PopupMenu$3;
import androidx.appcompat.widget.PopupMenu$OnDismissListener;
import androidx.appcompat.widget.PopupMenu$OnMenuItemClickListener;

public class PopupMenu {
    private final View mAnchor;
    private final Context mContext;
    private View.OnTouchListener mDragListener;
    private final MenuBuilder mMenu;
    public PopupMenu$OnMenuItemClickListener mMenuItemClickListener;
    public PopupMenu$OnDismissListener mOnDismissListener;
    public final MenuPopupHelper mPopup;

    public PopupMenu(Context context, View view) {
        this(context, view, 0);
    }

    public PopupMenu(Context context, View view, int n10) {
        int n11 = R$attr.popupMenuStyle;
        this(context, view, n10, n11, 0);
    }

    public PopupMenu(Context object, View view, int n10, int n11, int n12) {
        MenuPopupHelper menuPopupHelper;
        MenuBuilder menuBuilder;
        this.mContext = object;
        this.mAnchor = view;
        this.mMenu = menuBuilder = new MenuBuilder((Context)object);
        Object object2 = new PopupMenu$1(this);
        menuBuilder.setCallback((MenuBuilder$Callback)object2);
        object2 = menuPopupHelper;
        this.mPopup = menuPopupHelper = new MenuPopupHelper((Context)object, menuBuilder, view, false, n11, n12);
        menuPopupHelper.setGravity(n10);
        super(this);
        menuPopupHelper.setOnDismissListener((PopupWindow.OnDismissListener)object);
    }

    public void dismiss() {
        this.mPopup.dismiss();
    }

    public View.OnTouchListener getDragToOpenListener() {
        View.OnTouchListener onTouchListener = this.mDragListener;
        if (onTouchListener == null) {
            View view = this.mAnchor;
            this.mDragListener = onTouchListener = new PopupMenu$3(this, view);
        }
        return this.mDragListener;
    }

    public int getGravity() {
        return this.mPopup.getGravity();
    }

    public Menu getMenu() {
        return this.mMenu;
    }

    public MenuInflater getMenuInflater() {
        Context context = this.mContext;
        SupportMenuInflater supportMenuInflater = new SupportMenuInflater(context);
        return supportMenuInflater;
    }

    public ListView getMenuListView() {
        MenuPopupHelper menuPopupHelper = this.mPopup;
        boolean bl2 = menuPopupHelper.isShowing();
        if (!bl2) {
            return null;
        }
        return this.mPopup.getListView();
    }

    public void inflate(int n10) {
        MenuInflater menuInflater = this.getMenuInflater();
        MenuBuilder menuBuilder = this.mMenu;
        menuInflater.inflate(n10, (Menu)menuBuilder);
    }

    public void setGravity(int n10) {
        this.mPopup.setGravity(n10);
    }

    public void setOnDismissListener(PopupMenu$OnDismissListener popupMenu$OnDismissListener) {
        this.mOnDismissListener = popupMenu$OnDismissListener;
    }

    public void setOnMenuItemClickListener(PopupMenu$OnMenuItemClickListener popupMenu$OnMenuItemClickListener) {
        this.mMenuItemClickListener = popupMenu$OnMenuItemClickListener;
    }

    public void show() {
        this.mPopup.show();
    }
}

