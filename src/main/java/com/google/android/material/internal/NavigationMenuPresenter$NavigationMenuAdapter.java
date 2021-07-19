/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.util.SparseArray
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package com.google.android.material.internal;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.google.android.material.internal.NavigationMenuItemView;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.NavigationMenuPresenter$HeaderViewHolder;
import com.google.android.material.internal.NavigationMenuPresenter$NavigationMenuHeaderItem;
import com.google.android.material.internal.NavigationMenuPresenter$NavigationMenuItem;
import com.google.android.material.internal.NavigationMenuPresenter$NavigationMenuSeparatorItem;
import com.google.android.material.internal.NavigationMenuPresenter$NavigationMenuTextItem;
import com.google.android.material.internal.NavigationMenuPresenter$NormalViewHolder;
import com.google.android.material.internal.NavigationMenuPresenter$SeparatorViewHolder;
import com.google.android.material.internal.NavigationMenuPresenter$SubheaderViewHolder;
import com.google.android.material.internal.NavigationMenuPresenter$ViewHolder;
import com.google.android.material.internal.ParcelableSparseArray;
import java.util.ArrayList;

public class NavigationMenuPresenter$NavigationMenuAdapter
extends RecyclerView$Adapter {
    private static final String STATE_ACTION_VIEWS = "android:menu:action_views";
    private static final String STATE_CHECKED_ITEM = "android:menu:checked";
    private static final int VIEW_TYPE_HEADER = 3;
    private static final int VIEW_TYPE_NORMAL = 0;
    private static final int VIEW_TYPE_SEPARATOR = 2;
    private static final int VIEW_TYPE_SUBHEADER = 1;
    private MenuItemImpl checkedItem;
    private final ArrayList items;
    public final /* synthetic */ NavigationMenuPresenter this$0;
    private boolean updateSuspended;

    public NavigationMenuPresenter$NavigationMenuAdapter(NavigationMenuPresenter arrayList) {
        this.this$0 = arrayList;
        this.items = arrayList = new ArrayList();
        this.prepareMenuItems();
    }

    private void appendTransparentIconIfMissing(int n10, int n11) {
        while (n10 < n11) {
            boolean bl2;
            NavigationMenuPresenter$NavigationMenuTextItem navigationMenuPresenter$NavigationMenuTextItem = (NavigationMenuPresenter$NavigationMenuTextItem)this.items.get(n10);
            navigationMenuPresenter$NavigationMenuTextItem.needsEmptyIcon = bl2 = true;
            ++n10;
        }
    }

    private void prepareMenuItems() {
        NavigationMenuPresenter$NavigationMenuAdapter navigationMenuPresenter$NavigationMenuAdapter = this;
        int n10 = this.updateSuspended;
        if (n10 != 0) {
            return;
        }
        this.updateSuspended = n10 = 1;
        this.items.clear();
        Object object = this.items;
        Object object2 = new NavigationMenuPresenter$NavigationMenuHeaderItem();
        ((ArrayList)object).add(object2);
        int n11 = -1;
        object2 = this.this$0.menu.getVisibleItems();
        int n12 = ((ArrayList)object2).size();
        boolean bl2 = false;
        int n13 = 0;
        for (int i10 = 0; i10 < n12; ++i10) {
            Object object3;
            int n14;
            Object object4;
            Object object5 = (MenuItemImpl)navigationMenuPresenter$NavigationMenuAdapter.this$0.menu.getVisibleItems().get(i10);
            boolean bl3 = ((MenuItemImpl)object5).isChecked();
            if (bl3) {
                navigationMenuPresenter$NavigationMenuAdapter.setCheckedItem((MenuItemImpl)object5);
            }
            if (bl3 = ((MenuItemImpl)object5).isCheckable()) {
                ((MenuItemImpl)object5).setExclusiveCheckable(false);
            }
            if (bl3 = ((MenuItemImpl)object5).hasSubMenu()) {
                object4 = ((MenuItemImpl)object5).getSubMenu();
                n14 = object4.hasVisibleItems();
                if (n14 != 0) {
                    Object object6;
                    NavigationMenuPresenter$NavigationMenuItem navigationMenuPresenter$NavigationMenuItem;
                    int n15;
                    NavigationMenuPresenter navigationMenuPresenter;
                    if (i10 != 0) {
                        object3 = navigationMenuPresenter$NavigationMenuAdapter.items;
                        navigationMenuPresenter = navigationMenuPresenter$NavigationMenuAdapter.this$0;
                        n15 = navigationMenuPresenter.paddingSeparator;
                        navigationMenuPresenter$NavigationMenuItem = new NavigationMenuPresenter$NavigationMenuSeparatorItem(n15, 0);
                        ((ArrayList)object3).add(navigationMenuPresenter$NavigationMenuItem);
                    }
                    object3 = navigationMenuPresenter$NavigationMenuAdapter.items;
                    navigationMenuPresenter$NavigationMenuItem = new NavigationMenuPresenter$NavigationMenuTextItem((MenuItemImpl)object5);
                    ((ArrayList)object3).add(navigationMenuPresenter$NavigationMenuItem);
                    object3 = navigationMenuPresenter$NavigationMenuAdapter.items;
                    n14 = ((ArrayList)object3).size();
                    int n16 = object4.size();
                    navigationMenuPresenter = null;
                    int n17 = 0;
                    for (n15 = 0; n15 < n16; ++n15) {
                        MenuItemImpl menuItemImpl = (MenuItemImpl)object4.getItem(n15);
                        boolean bl4 = menuItemImpl.isVisible();
                        if (bl4) {
                            Object object7;
                            if (n17 == 0 && (object7 = menuItemImpl.getIcon()) != null) {
                                n17 = n10;
                            }
                            if (bl4 = menuItemImpl.isCheckable()) {
                                menuItemImpl.setExclusiveCheckable(false);
                            }
                            if (bl4 = ((MenuItemImpl)object5).isChecked()) {
                                navigationMenuPresenter$NavigationMenuAdapter.setCheckedItem((MenuItemImpl)object5);
                            }
                            object7 = navigationMenuPresenter$NavigationMenuAdapter.items;
                            object6 = new NavigationMenuPresenter$NavigationMenuTextItem(menuItemImpl);
                            ((ArrayList)object7).add(object6);
                        }
                        n10 = 1;
                    }
                    if (n17 != 0) {
                        object6 = navigationMenuPresenter$NavigationMenuAdapter.items;
                        n10 = ((ArrayList)object6).size();
                        navigationMenuPresenter$NavigationMenuAdapter.appendTransparentIconIfMissing(n14, n10);
                    }
                }
            } else {
                n10 = ((MenuItemImpl)object5).getGroupId();
                if (n10 != n11) {
                    n13 = navigationMenuPresenter$NavigationMenuAdapter.items.size();
                    object = ((MenuItemImpl)object5).getIcon();
                    bl2 = object != null;
                    if (i10 != 0) {
                        ++n13;
                        object = navigationMenuPresenter$NavigationMenuAdapter.items;
                        object3 = navigationMenuPresenter$NavigationMenuAdapter.this$0;
                        n14 = ((NavigationMenuPresenter)object3).paddingSeparator;
                        object4 = new NavigationMenuPresenter$NavigationMenuSeparatorItem(n14, n14);
                        ((ArrayList)object).add(object4);
                    }
                } else if (!bl2 && (object = ((MenuItemImpl)object5).getIcon()) != null) {
                    object = navigationMenuPresenter$NavigationMenuAdapter.items;
                    n11 = ((ArrayList)object).size();
                    navigationMenuPresenter$NavigationMenuAdapter.appendTransparentIconIfMissing(n13, n11);
                    bl2 = true;
                }
                object = new NavigationMenuPresenter$NavigationMenuTextItem((MenuItemImpl)object5);
                ((NavigationMenuPresenter$NavigationMenuTextItem)object).needsEmptyIcon = bl2;
                object5 = navigationMenuPresenter$NavigationMenuAdapter.items;
                ((ArrayList)object5).add(object);
                n11 = n10;
            }
            n10 = 1;
        }
        navigationMenuPresenter$NavigationMenuAdapter.updateSuspended = false;
    }

    public Bundle createInstanceState() {
        String string2;
        Bundle bundle = new Bundle();
        MenuItemImpl menuItemImpl = this.checkedItem;
        if (menuItemImpl != null) {
            int n10 = menuItemImpl.getItemId();
            string2 = STATE_CHECKED_ITEM;
            bundle.putInt(string2, n10);
        }
        menuItemImpl = new SparseArray();
        string2 = null;
        ArrayList arrayList = this.items;
        int n11 = arrayList.size();
        for (int i10 = 0; i10 < n11; ++i10) {
            View view;
            Object object = (NavigationMenuPresenter$NavigationMenuItem)this.items.get(i10);
            boolean bl2 = object instanceof NavigationMenuPresenter$NavigationMenuTextItem;
            if (!bl2) continue;
            if ((object = ((NavigationMenuPresenter$NavigationMenuTextItem)object).getMenuItem()) != null) {
                view = ((MenuItemImpl)object).getActionView();
            } else {
                bl2 = false;
                view = null;
            }
            if (view == null) continue;
            ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
            view.saveHierarchyState((SparseArray)parcelableSparseArray);
            int n12 = ((MenuItemImpl)object).getItemId();
            menuItemImpl.put(n12, (Object)parcelableSparseArray);
        }
        bundle.putSparseParcelableArray(STATE_ACTION_VIEWS, (SparseArray)menuItemImpl);
        return bundle;
    }

    public MenuItemImpl getCheckedItem() {
        return this.checkedItem;
    }

    public int getItemCount() {
        return this.items.size();
    }

    public long getItemId(int n10) {
        return n10;
    }

    public int getItemViewType(int n10) {
        ArrayList arrayList = this.items;
        Object object = (NavigationMenuPresenter$NavigationMenuItem)arrayList.get(n10);
        boolean bl2 = object instanceof NavigationMenuPresenter$NavigationMenuSeparatorItem;
        if (bl2) {
            return 2;
        }
        bl2 = object instanceof NavigationMenuPresenter$NavigationMenuHeaderItem;
        if (bl2) {
            return 3;
        }
        bl2 = object instanceof NavigationMenuPresenter$NavigationMenuTextItem;
        if (bl2) {
            n10 = (int)(((MenuItemImpl)(object = ((NavigationMenuPresenter$NavigationMenuTextItem)object).getMenuItem())).hasSubMenu() ? 1 : 0);
            if (n10 != 0) {
                return 1;
            }
            return 0;
        }
        object = new RuntimeException("Unknown item type.");
        throw object;
    }

    public void onBindViewHolder(NavigationMenuPresenter$ViewHolder object, int n10) {
        int n11 = this.getItemViewType(n10);
        if (n11 != 0) {
            int n12 = 1;
            if (n11 != n12) {
                n12 = 2;
                if (n11 == n12) {
                    ArrayList arrayList = this.items;
                    NavigationMenuPresenter$NavigationMenuSeparatorItem navigationMenuPresenter$NavigationMenuSeparatorItem = (NavigationMenuPresenter$NavigationMenuSeparatorItem)arrayList.get(n10);
                    object = ((RecyclerView$ViewHolder)object).itemView;
                    n11 = navigationMenuPresenter$NavigationMenuSeparatorItem.getPaddingTop();
                    n10 = navigationMenuPresenter$NavigationMenuSeparatorItem.getPaddingBottom();
                    object.setPadding(0, n11, 0, n10);
                }
            } else {
                object = (TextView)((RecyclerView$ViewHolder)object).itemView;
                ArrayList arrayList = this.items;
                CharSequence charSequence = ((NavigationMenuPresenter$NavigationMenuTextItem)arrayList.get(n10)).getMenuItem().getTitle();
                object.setText(charSequence);
            }
        } else {
            object = (NavigationMenuItemView)((RecyclerView$ViewHolder)object).itemView;
            Object object2 = this.this$0.iconTintList;
            ((NavigationMenuItemView)object).setIconTintList((ColorStateList)object2);
            object2 = this.this$0;
            boolean bl2 = object2.textAppearanceSet;
            if (bl2) {
                n11 = object2.textAppearance;
                ((NavigationMenuItemView)object).setTextAppearance(n11);
            }
            if ((object2 = this.this$0.textColor) != null) {
                ((NavigationMenuItemView)object).setTextColor((ColorStateList)object2);
            }
            if ((object2 = this.this$0.itemBackground) != null) {
                object2 = object2.getConstantState().newDrawable();
            } else {
                n11 = 0;
                object2 = null;
            }
            ViewCompat.setBackground((View)object, (Drawable)object2);
            Object object3 = (NavigationMenuPresenter$NavigationMenuTextItem)this.items.get(n10);
            n11 = (int)(((NavigationMenuPresenter$NavigationMenuTextItem)object3).needsEmptyIcon ? 1 : 0);
            ((NavigationMenuItemView)object).setNeedsEmptyIcon(n11 != 0);
            n11 = this.this$0.itemHorizontalPadding;
            ((NavigationMenuItemView)object).setHorizontalPadding(n11);
            object2 = this.this$0;
            n11 = object2.itemIconPadding;
            ((NavigationMenuItemView)object).setIconPadding(n11);
            object3 = ((NavigationMenuPresenter$NavigationMenuTextItem)object3).getMenuItem();
            ((NavigationMenuItemView)object).initialize((MenuItemImpl)object3, 0);
        }
    }

    public NavigationMenuPresenter$ViewHolder onCreateViewHolder(ViewGroup object, int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    int n12 = 3;
                    if (n10 != n12) {
                        return null;
                    }
                    LinearLayout linearLayout = this.this$0.headerLayout;
                    object = new NavigationMenuPresenter$HeaderViewHolder((View)linearLayout);
                    return object;
                }
                LayoutInflater layoutInflater = this.this$0.layoutInflater;
                NavigationMenuPresenter$SeparatorViewHolder navigationMenuPresenter$SeparatorViewHolder = new NavigationMenuPresenter$SeparatorViewHolder(layoutInflater, (ViewGroup)object);
                return navigationMenuPresenter$SeparatorViewHolder;
            }
            LayoutInflater layoutInflater = this.this$0.layoutInflater;
            NavigationMenuPresenter$SubheaderViewHolder navigationMenuPresenter$SubheaderViewHolder = new NavigationMenuPresenter$SubheaderViewHolder(layoutInflater, (ViewGroup)object);
            return navigationMenuPresenter$SubheaderViewHolder;
        }
        NavigationMenuPresenter navigationMenuPresenter = this.this$0;
        LayoutInflater layoutInflater = navigationMenuPresenter.layoutInflater;
        navigationMenuPresenter = navigationMenuPresenter.onClickListener;
        NavigationMenuPresenter$NormalViewHolder navigationMenuPresenter$NormalViewHolder = new NavigationMenuPresenter$NormalViewHolder(layoutInflater, (ViewGroup)object, (View.OnClickListener)navigationMenuPresenter);
        return navigationMenuPresenter$NormalViewHolder;
    }

    public void onViewRecycled(NavigationMenuPresenter$ViewHolder object) {
        boolean bl2 = object instanceof NavigationMenuPresenter$NormalViewHolder;
        if (bl2) {
            object = (NavigationMenuItemView)((RecyclerView$ViewHolder)object).itemView;
            ((NavigationMenuItemView)object).recycle();
        }
    }

    public void restoreInstanceState(Bundle bundle) {
        int n10;
        View view;
        int n11;
        Object object;
        Object object2 = STATE_CHECKED_ITEM;
        int n12 = 0;
        int n13 = bundle.getInt((String)object2, 0);
        if (n13 != 0) {
            this.updateSuspended = true;
            object = this.items;
            n11 = ((ArrayList)object).size();
            view = null;
            for (n10 = 0; n10 < n11; ++n10) {
                Object object3 = (NavigationMenuPresenter$NavigationMenuItem)this.items.get(n10);
                int n14 = object3 instanceof NavigationMenuPresenter$NavigationMenuTextItem;
                if (n14 == 0 || (object3 = ((NavigationMenuPresenter$NavigationMenuTextItem)object3).getMenuItem()) == null || (n14 = ((MenuItemImpl)object3).getItemId()) != n13) continue;
                this.setCheckedItem((MenuItemImpl)object3);
                break;
            }
            this.updateSuspended = false;
            this.prepareMenuItems();
        }
        if ((bundle = bundle.getSparseParcelableArray((String)(object2 = STATE_ACTION_VIEWS))) != null) {
            object2 = this.items;
            n13 = ((ArrayList)object2).size();
            while (n12 < n13) {
                object = (NavigationMenuPresenter$NavigationMenuItem)this.items.get(n12);
                n10 = object instanceof NavigationMenuPresenter$NavigationMenuTextItem;
                if (n10 != 0 && (object = ((NavigationMenuPresenter$NavigationMenuTextItem)object).getMenuItem()) != null && (view = ((MenuItemImpl)object).getActionView()) != null && (object = (ParcelableSparseArray)((Object)bundle.get(n11 = ((MenuItemImpl)object).getItemId()))) != null) {
                    view.restoreHierarchyState((SparseArray)object);
                }
                ++n12;
            }
        }
    }

    public void setCheckedItem(MenuItemImpl menuItemImpl) {
        boolean bl2;
        MenuItemImpl menuItemImpl2 = this.checkedItem;
        if (menuItemImpl2 != menuItemImpl && (bl2 = menuItemImpl.isCheckable())) {
            menuItemImpl2 = this.checkedItem;
            if (menuItemImpl2 != null) {
                menuItemImpl2.setChecked(false);
            }
            this.checkedItem = menuItemImpl;
            bl2 = true;
            menuItemImpl.setChecked(bl2);
        }
    }

    public void setUpdateSuspended(boolean bl2) {
        this.updateSuspended = bl2;
    }

    public void update() {
        this.prepareMenuItems();
        this.notifyDataSetChanged();
    }
}

