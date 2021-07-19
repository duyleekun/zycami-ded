/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.MenuItem$OnMenuItemClickListener
 *  android.view.SubMenu
 *  android.view.View
 */
package androidx.appcompat.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.SupportMenuInflater$InflatedOnMenuItemClickListener;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import java.lang.reflect.Constructor;

public class SupportMenuInflater$MenuState {
    private static final int defaultGroupId = 0;
    private static final int defaultItemCategory = 0;
    private static final int defaultItemCheckable = 0;
    private static final boolean defaultItemChecked = false;
    private static final boolean defaultItemEnabled = true;
    private static final int defaultItemId = 0;
    private static final int defaultItemOrder = 0;
    private static final boolean defaultItemVisible = true;
    private int groupCategory;
    private int groupCheckable;
    private boolean groupEnabled;
    private int groupId;
    private int groupOrder;
    private boolean groupVisible;
    public ActionProvider itemActionProvider;
    private String itemActionProviderClassName;
    private String itemActionViewClassName;
    private int itemActionViewLayout;
    private boolean itemAdded;
    private int itemAlphabeticModifiers;
    private char itemAlphabeticShortcut;
    private int itemCategoryOrder;
    private int itemCheckable;
    private boolean itemChecked;
    private CharSequence itemContentDescription;
    private boolean itemEnabled;
    private int itemIconResId;
    private ColorStateList itemIconTintList = null;
    private PorterDuff.Mode itemIconTintMode = null;
    private int itemId;
    private String itemListenerMethodName;
    private int itemNumericModifiers;
    private char itemNumericShortcut;
    private int itemShowAsAction;
    private CharSequence itemTitle;
    private CharSequence itemTitleCondensed;
    private CharSequence itemTooltipText;
    private boolean itemVisible;
    private Menu menu;
    public final /* synthetic */ SupportMenuInflater this$0;

    public SupportMenuInflater$MenuState(SupportMenuInflater supportMenuInflater, Menu menu2) {
        this.this$0 = supportMenuInflater;
        this.menu = menu2;
        this.resetGroup();
    }

    private char getShortcut(String string2) {
        if (string2 == null) {
            return '\u0000';
        }
        return string2.charAt(0);
    }

    private Object newInstance(String string2, Class[] object, Object[] object2) {
        Object object3;
        boolean bl2 = false;
        Class<?> clazz = null;
        try {
            object3 = this.this$0;
        }
        catch (Exception exception) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Cannot instantiate class: ");
            ((StringBuilder)object2).append(string2);
            string2 = ((StringBuilder)object2).toString();
            Log.w((String)"SupportMenuInflater", (String)string2, (Throwable)exception);
            return null;
        }
        object3 = object3.mContext;
        object3 = object3.getClassLoader();
        clazz = Class.forName(string2, false, (ClassLoader)object3);
        object = clazz.getConstructor((Class<?>)object);
        bl2 = true;
        ((Constructor)object).setAccessible(bl2);
        return ((Constructor)object).newInstance((Object[])object2);
    }

    private void setItem(MenuItem object) {
        Object object2;
        int c10 = this.itemChecked;
        Object object3 = object.setChecked(c10 != 0);
        int n10 = this.itemVisible;
        object3 = object3.setVisible(n10 != 0);
        n10 = this.itemEnabled;
        object3 = object3.setEnabled(n10 != 0);
        n10 = this.itemCheckable;
        int n11 = 0;
        Object[] objectArray = null;
        int n12 = 1;
        if (n10 >= n12) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        object3 = object3.setCheckable(n10 != 0);
        object2 = this.itemTitleCondensed;
        object3 = object3.setTitleCondensed((CharSequence)object2);
        n10 = this.itemIconResId;
        object3.setIcon(n10);
        c10 = this.itemShowAsAction;
        if (c10 >= 0) {
            object.setShowAsAction(c10);
        }
        if ((object3 = this.itemListenerMethodName) != null) {
            object3 = this.this$0.mContext;
            c10 = object3.isRestricted() ? 1 : 0;
            if (c10 == 0) {
                object2 = this.this$0.getRealOwner();
                String string2 = this.itemListenerMethodName;
                object3 = new SupportMenuInflater$InflatedOnMenuItemClickListener(object2, string2);
                object.setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)object3);
            } else {
                object = new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                throw object;
            }
        }
        if ((c10 = this.itemCheckable) >= (n10 = 2)) {
            c10 = object instanceof MenuItemImpl;
            if (c10 != 0) {
                object3 = object;
                object3 = (MenuItemImpl)object;
                ((MenuItemImpl)object3).setExclusiveCheckable(n12 != 0);
            } else {
                c10 = object instanceof MenuItemWrapperICS;
                if (c10 != 0) {
                    object3 = object;
                    object3 = (MenuItemWrapperICS)object;
                    ((MenuItemWrapperICS)object3).setExclusiveCheckable(n12 != 0);
                }
            }
        }
        if ((object3 = this.itemActionViewClassName) != null) {
            object2 = SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
            objectArray = this.this$0.mActionViewConstructorArguments;
            object3 = (View)this.newInstance((String)object3, (Class[])object2, objectArray);
            object.setActionView((View)object3);
            n11 = n12;
        }
        if ((c10 = this.itemActionViewLayout) > 0) {
            if (n11 == 0) {
                object.setActionView(c10);
            } else {
                object3 = "SupportMenuInflater";
                object2 = "Ignoring attribute 'itemActionViewLayout'. Action view already specified.";
                Log.w((String)object3, (String)object2);
            }
        }
        if ((object3 = this.itemActionProvider) != null) {
            MenuItemCompat.setActionProvider(object, (ActionProvider)object3);
        }
        object3 = this.itemContentDescription;
        MenuItemCompat.setContentDescription(object, (CharSequence)object3);
        object3 = this.itemTooltipText;
        MenuItemCompat.setTooltipText(object, (CharSequence)object3);
        c10 = this.itemAlphabeticShortcut;
        n10 = this.itemAlphabeticModifiers;
        MenuItemCompat.setAlphabeticShortcut(object, c10, n10);
        c10 = this.itemNumericShortcut;
        n10 = this.itemNumericModifiers;
        MenuItemCompat.setNumericShortcut(object, c10, n10);
        object3 = this.itemIconTintMode;
        if (object3 != null) {
            MenuItemCompat.setIconTintMode(object, (PorterDuff.Mode)object3);
        }
        if ((object3 = this.itemIconTintList) != null) {
            MenuItemCompat.setIconTintList(object, (ColorStateList)object3);
        }
    }

    public void addItem() {
        this.itemAdded = true;
        Menu menu2 = this.menu;
        int n10 = this.groupId;
        int n11 = this.itemId;
        int n12 = this.itemCategoryOrder;
        CharSequence charSequence = this.itemTitle;
        menu2 = menu2.add(n10, n11, n12, charSequence);
        this.setItem((MenuItem)menu2);
    }

    public SubMenu addSubMenuItem() {
        this.itemAdded = true;
        Menu menu2 = this.menu;
        int n10 = this.groupId;
        int n11 = this.itemId;
        int n12 = this.itemCategoryOrder;
        CharSequence charSequence = this.itemTitle;
        menu2 = menu2.addSubMenu(n10, n11, n12, charSequence);
        MenuItem menuItem = menu2.getItem();
        this.setItem(menuItem);
        return menu2;
    }

    public boolean hasAddedItem() {
        return this.itemAdded;
    }

    public void readGroup(AttributeSet attributeSet) {
        Context context = this.this$0.mContext;
        int[] nArray = R$styleable.MenuGroup;
        attributeSet = context.obtainStyledAttributes(attributeSet, nArray);
        int n10 = R$styleable.MenuGroup_android_id;
        this.groupId = n10 = attributeSet.getResourceId(n10, 0);
        n10 = R$styleable.MenuGroup_android_menuCategory;
        this.groupCategory = n10 = attributeSet.getInt(n10, 0);
        n10 = R$styleable.MenuGroup_android_orderInCategory;
        this.groupOrder = n10 = attributeSet.getInt(n10, 0);
        n10 = R$styleable.MenuGroup_android_checkableBehavior;
        this.groupCheckable = n10 = attributeSet.getInt(n10, 0);
        n10 = R$styleable.MenuGroup_android_visible;
        boolean bl2 = true;
        n10 = attributeSet.getBoolean(n10, bl2) ? 1 : 0;
        this.groupVisible = n10;
        n10 = R$styleable.MenuGroup_android_enabled;
        n10 = attributeSet.getBoolean(n10, bl2) ? 1 : 0;
        this.groupEnabled = n10;
        attributeSet.recycle();
    }

    public void readItem(AttributeSet object) {
        Object[] objectArray;
        int n10;
        Class[] classArray;
        Object object2 = this.this$0.mContext;
        int[] nArray = R$styleable.MenuItem;
        object = TintTypedArray.obtainStyledAttributes(object2, (AttributeSet)object, nArray);
        int n11 = R$styleable.MenuItem_android_id;
        nArray = null;
        this.itemId = n11 = ((TintTypedArray)object).getResourceId(n11, 0);
        n11 = R$styleable.MenuItem_android_menuCategory;
        int n12 = this.groupCategory;
        n11 = ((TintTypedArray)object).getInt(n11, n12);
        n12 = R$styleable.MenuItem_android_orderInCategory;
        int n13 = this.groupOrder;
        n12 = ((TintTypedArray)object).getInt(n12, n13);
        n11 &= 0xFFFF0000;
        n13 = (char)-1;
        this.itemCategoryOrder = n11 |= (n12 &= n13);
        n11 = R$styleable.MenuItem_android_title;
        object2 = ((TintTypedArray)object).getText(n11);
        this.itemTitle = object2;
        n11 = R$styleable.MenuItem_android_titleCondensed;
        object2 = ((TintTypedArray)object).getText(n11);
        this.itemTitleCondensed = object2;
        n11 = R$styleable.MenuItem_android_icon;
        this.itemIconResId = n11 = ((TintTypedArray)object).getResourceId(n11, 0);
        n11 = R$styleable.MenuItem_android_alphabeticShortcut;
        object2 = ((TintTypedArray)object).getString(n11);
        n11 = this.getShortcut((String)object2);
        this.itemAlphabeticShortcut = (char)n11;
        n11 = R$styleable.MenuItem_alphabeticModifiers;
        n12 = 4096;
        this.itemAlphabeticModifiers = n11 = ((TintTypedArray)object).getInt(n11, n12);
        n11 = R$styleable.MenuItem_android_numericShortcut;
        object2 = ((TintTypedArray)object).getString(n11);
        n11 = this.getShortcut((String)object2);
        this.itemNumericShortcut = (char)n11;
        n11 = R$styleable.MenuItem_numericModifiers;
        this.itemNumericModifiers = n11 = ((TintTypedArray)object).getInt(n11, n12);
        n11 = R$styleable.MenuItem_android_checkable;
        n12 = ((TintTypedArray)object).hasValue(n11) ? 1 : 0;
        this.itemCheckable = n12 != 0 ? (n11 = (int)(((TintTypedArray)object).getBoolean(n11, false) ? 1 : 0)) : (n11 = this.groupCheckable);
        n11 = R$styleable.MenuItem_android_checked;
        n11 = ((TintTypedArray)object).getBoolean(n11, false) ? 1 : 0;
        this.itemChecked = n11;
        n11 = R$styleable.MenuItem_android_visible;
        n12 = this.groupVisible ? 1 : 0;
        n11 = ((TintTypedArray)object).getBoolean(n11, n12 != 0) ? 1 : 0;
        this.itemVisible = n11;
        n11 = R$styleable.MenuItem_android_enabled;
        n12 = this.groupEnabled;
        n11 = ((TintTypedArray)object).getBoolean(n11, n12 != 0) ? 1 : 0;
        this.itemEnabled = n11;
        n11 = R$styleable.MenuItem_showAsAction;
        n12 = -1;
        this.itemShowAsAction = n11 = ((TintTypedArray)object).getInt(n11, n12);
        n11 = R$styleable.MenuItem_android_onClick;
        object2 = ((TintTypedArray)object).getString(n11);
        this.itemListenerMethodName = object2;
        n11 = R$styleable.MenuItem_actionLayout;
        this.itemActionViewLayout = n11 = ((TintTypedArray)object).getResourceId(n11, 0);
        n11 = R$styleable.MenuItem_actionViewClass;
        object2 = ((TintTypedArray)object).getString(n11);
        this.itemActionViewClassName = object2;
        n11 = R$styleable.MenuItem_actionProviderClass;
        object2 = ((TintTypedArray)object).getString(n11);
        this.itemActionProviderClassName = object2;
        if (object2 != null) {
            n13 = 1;
        } else {
            n13 = 0;
            classArray = null;
        }
        if (n13 != 0 && (n10 = this.itemActionViewLayout) == 0 && (objectArray = this.itemActionViewClassName) == null) {
            classArray = SupportMenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE;
            objectArray = this.this$0.mActionProviderConstructorArguments;
            object2 = (ActionProvider)this.newInstance((String)object2, classArray, objectArray);
            this.itemActionProvider = object2;
        } else {
            if (n13 != 0) {
                object2 = "SupportMenuInflater";
                classArray = "Ignoring attribute 'actionProviderClass'. Action view already specified.";
                Log.w((String)object2, (String)classArray);
            }
            this.itemActionProvider = null;
        }
        n11 = R$styleable.MenuItem_contentDescription;
        object2 = ((TintTypedArray)object).getText(n11);
        this.itemContentDescription = object2;
        n11 = R$styleable.MenuItem_tooltipText;
        object2 = ((TintTypedArray)object).getText(n11);
        this.itemTooltipText = object2;
        n11 = R$styleable.MenuItem_iconTintMode;
        n13 = ((TintTypedArray)object).hasValue(n11) ? 1 : 0;
        if (n13 != 0) {
            n11 = ((TintTypedArray)object).getInt(n11, n12);
            PorterDuff.Mode mode = this.itemIconTintMode;
            object2 = DrawableUtils.parseTintMode(n11, mode);
            this.itemIconTintMode = object2;
        } else {
            this.itemIconTintMode = null;
        }
        n11 = R$styleable.MenuItem_iconTint;
        n12 = ((TintTypedArray)object).hasValue(n11) ? 1 : 0;
        if (n12 != 0) {
            object2 = ((TintTypedArray)object).getColorStateList(n11);
            this.itemIconTintList = object2;
        } else {
            this.itemIconTintList = null;
        }
        ((TintTypedArray)object).recycle();
        this.itemAdded = false;
    }

    public void resetGroup() {
        boolean bl2;
        this.groupId = 0;
        this.groupCategory = 0;
        this.groupOrder = 0;
        this.groupCheckable = 0;
        this.groupVisible = bl2 = true;
        this.groupEnabled = bl2;
    }
}

