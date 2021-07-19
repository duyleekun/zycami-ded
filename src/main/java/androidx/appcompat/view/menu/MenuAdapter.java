/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 */
package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView$ItemView;
import java.util.ArrayList;

public class MenuAdapter
extends BaseAdapter {
    public MenuBuilder mAdapterMenu;
    private int mExpandedIndex = -1;
    private boolean mForceShowIcon;
    private final LayoutInflater mInflater;
    private final int mItemLayoutRes;
    private final boolean mOverflowOnly;

    public MenuAdapter(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean bl2, int n10) {
        this.mOverflowOnly = bl2;
        this.mInflater = layoutInflater;
        this.mAdapterMenu = menuBuilder;
        this.mItemLayoutRes = n10;
        this.findExpandedIndex();
    }

    public void findExpandedIndex() {
        MenuItemImpl menuItemImpl = this.mAdapterMenu.getExpandedItem();
        if (menuItemImpl != null) {
            ArrayList arrayList = this.mAdapterMenu.getNonActionItems();
            int n10 = arrayList.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                MenuItemImpl menuItemImpl2 = (MenuItemImpl)arrayList.get(i10);
                if (menuItemImpl2 != menuItemImpl) continue;
                this.mExpandedIndex = i10;
                return;
            }
        }
        this.mExpandedIndex = -1;
    }

    public MenuBuilder getAdapterMenu() {
        return this.mAdapterMenu;
    }

    public int getCount() {
        boolean bl2 = this.mOverflowOnly;
        ArrayList arrayList = bl2 ? this.mAdapterMenu.getNonActionItems() : this.mAdapterMenu.getVisibleItems();
        int n10 = this.mExpandedIndex;
        if (n10 < 0) {
            return arrayList.size();
        }
        return arrayList.size() + -1;
    }

    public boolean getForceShowIcon() {
        return this.mForceShowIcon;
    }

    public MenuItemImpl getItem(int n10) {
        boolean bl2 = this.mOverflowOnly;
        ArrayList arrayList = bl2 ? this.mAdapterMenu.getNonActionItems() : this.mAdapterMenu.getVisibleItems();
        int n11 = this.mExpandedIndex;
        if (n11 >= 0 && n10 >= n11) {
            ++n10;
        }
        return (MenuItemImpl)arrayList.get(n10);
    }

    public long getItemId(int n10) {
        return n10;
    }

    public View getView(int n10, View view, ViewGroup object) {
        int n11;
        if (view == null) {
            view = this.mInflater;
            n11 = this.mItemLayoutRes;
            view = view.inflate(n11, (ViewGroup)object, false);
        }
        object = this.getItem(n10);
        int n12 = ((MenuItemImpl)object).getGroupId();
        n11 = n10 + -1;
        if (n11 >= 0) {
            MenuItemImpl menuItemImpl = this.getItem(n11);
            n11 = menuItemImpl.getGroupId();
        } else {
            n11 = n12;
        }
        Object object2 = view;
        object2 = (ListMenuItemView)view;
        MenuBuilder menuBuilder = this.mAdapterMenu;
        boolean bl2 = menuBuilder.isGroupDividerEnabled();
        int n13 = 1;
        if (bl2 && n12 != n11) {
            n12 = n13;
        } else {
            n12 = 0;
            object = null;
        }
        ((ListMenuItemView)object2).setGroupDividerEnabled(n12 != 0);
        object = view;
        object = (MenuView$ItemView)view;
        n11 = this.mForceShowIcon ? 1 : 0;
        if (n11 != 0) {
            ((ListMenuItemView)object2).setForceShowIcon(n13 != 0);
        }
        MenuItemImpl menuItemImpl = this.getItem(n10);
        object.initialize(menuItemImpl, 0);
        return view;
    }

    public void notifyDataSetChanged() {
        this.findExpandedIndex();
        super.notifyDataSetChanged();
    }

    public void setForceShowIcon(boolean bl2) {
        this.mForceShowIcon = bl2;
    }
}

