/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.ListView
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder$ItemInvoker;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;

public final class ExpandedMenuView
extends ListView
implements MenuBuilder$ItemInvoker,
MenuView,
AdapterView.OnItemClickListener {
    private static final int[] TINT_ATTRS;
    private int mAnimations;
    private MenuBuilder mMenu;

    static {
        int[] nArray = new int[]{16842964, 16843049};
        TINT_ATTRS = nArray;
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet);
        int n11;
        this.setOnItemClickListener(this);
        int[] nArray = TINT_ATTRS;
        object = TintTypedArray.obtainStyledAttributes((Context)object, attributeSet, nArray, n10, 0);
        boolean n112 = ((TintTypedArray)object).hasValue(0);
        if (n112) {
            attributeSet = ((TintTypedArray)object).getDrawable(0);
            this.setBackgroundDrawable((Drawable)attributeSet);
        }
        if ((n10 = (int)(((TintTypedArray)object).hasValue(n11 = 1) ? 1 : 0)) != 0) {
            attributeSet = ((TintTypedArray)object).getDrawable(n11);
            this.setDivider((Drawable)attributeSet);
        }
        ((TintTypedArray)object).recycle();
    }

    public int getWindowAnimations() {
        return this.mAnimations;
    }

    public void initialize(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
    }

    public boolean invokeItem(MenuItemImpl menuItemImpl) {
        return this.mMenu.performItemAction(menuItemImpl, 0);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView object, View view, int n10, long l10) {
        object = (MenuItemImpl)this.getAdapter().getItem(n10);
        this.invokeItem((MenuItemImpl)object);
    }
}

