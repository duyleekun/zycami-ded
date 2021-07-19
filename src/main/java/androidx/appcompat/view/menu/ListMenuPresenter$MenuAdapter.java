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
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView$ItemView;
import java.util.ArrayList;

public class ListMenuPresenter$MenuAdapter
extends BaseAdapter {
    private int mExpandedIndex = -1;
    public final /* synthetic */ ListMenuPresenter this$0;

    public ListMenuPresenter$MenuAdapter(ListMenuPresenter listMenuPresenter) {
        this.this$0 = listMenuPresenter;
        this.findExpandedIndex();
    }

    public void findExpandedIndex() {
        MenuItemImpl menuItemImpl = this.this$0.mMenu.getExpandedItem();
        if (menuItemImpl != null) {
            ArrayList arrayList = this.this$0.mMenu.getNonActionItems();
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

    public int getCount() {
        ArrayList arrayList = this.this$0.mMenu.getNonActionItems();
        int n10 = arrayList.size();
        ListMenuPresenter listMenuPresenter = this.this$0;
        int n11 = listMenuPresenter.mItemIndexOffset;
        n10 -= n11;
        n11 = this.mExpandedIndex;
        if (n11 < 0) {
            return n10;
        }
        return n10 + -1;
    }

    public MenuItemImpl getItem(int n10) {
        ArrayList arrayList = this.this$0.mMenu.getNonActionItems();
        ListMenuPresenter listMenuPresenter = this.this$0;
        int n11 = listMenuPresenter.mItemIndexOffset;
        n10 += n11;
        n11 = this.mExpandedIndex;
        if (n11 >= 0 && n10 >= n11) {
            ++n10;
        }
        return (MenuItemImpl)arrayList.get(n10);
    }

    public long getItemId(int n10) {
        return n10;
    }

    public View getView(int n10, View object, ViewGroup object2) {
        if (object == null) {
            object = this.this$0;
            LayoutInflater layoutInflater = object.mInflater;
            int n11 = object.mItemLayoutRes;
            object = layoutInflater.inflate(n11, (ViewGroup)object2, false);
        }
        object2 = object;
        object2 = (MenuView$ItemView)object;
        MenuItemImpl menuItemImpl = this.getItem(n10);
        object2.initialize(menuItemImpl, 0);
        return object;
    }

    public void notifyDataSetChanged() {
        this.findExpandedIndex();
        super.notifyDataSetChanged();
    }
}

