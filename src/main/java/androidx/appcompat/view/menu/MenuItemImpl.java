/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.ActionProvider
 *  android.view.ContextMenu$ContextMenuInfo
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.MenuItem
 *  android.view.MenuItem$OnActionExpandListener
 *  android.view.MenuItem$OnMenuItemClickListener
 *  android.view.SubMenu
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
 */
package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.R$string;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl$1;
import androidx.appcompat.view.menu.MenuView$ItemView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider$VisibilityListener;

public final class MenuItemImpl
implements SupportMenuItem {
    private static final int CHECKABLE = 1;
    private static final int CHECKED = 2;
    private static final int ENABLED = 16;
    private static final int EXCLUSIVE = 4;
    private static final int HIDDEN = 8;
    private static final int IS_ACTION = 32;
    public static final int NO_ICON = 0;
    private static final int SHOW_AS_ACTION_MASK = 3;
    private static final String TAG = "MenuItemImpl";
    private androidx.core.view.ActionProvider mActionProvider;
    private View mActionView;
    private final int mCategoryOrder;
    private MenuItem.OnMenuItemClickListener mClickListener;
    private CharSequence mContentDescription;
    private int mFlags;
    private final int mGroup;
    private boolean mHasIconTint;
    private boolean mHasIconTintMode;
    private Drawable mIconDrawable;
    private int mIconResId;
    private ColorStateList mIconTintList;
    private PorterDuff.Mode mIconTintMode;
    private final int mId;
    private Intent mIntent;
    private boolean mIsActionViewExpanded;
    private Runnable mItemCallback;
    public MenuBuilder mMenu;
    private ContextMenu.ContextMenuInfo mMenuInfo;
    private boolean mNeedToApplyIconTint;
    private MenuItem.OnActionExpandListener mOnActionExpandListener;
    private final int mOrdering;
    private char mShortcutAlphabeticChar;
    private int mShortcutAlphabeticModifiers;
    private char mShortcutNumericChar;
    private int mShortcutNumericModifiers;
    private int mShowAsAction;
    private SubMenuBuilder mSubMenu;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;
    private CharSequence mTooltipText;

    public MenuItemImpl(MenuBuilder menuBuilder, int n10, int n11, int n12, int n13, CharSequence charSequence, int n14) {
        int n15;
        this.mShortcutNumericModifiers = n15 = 4096;
        this.mShortcutAlphabeticModifiers = n15;
        this.mIconResId = 0;
        this.mIconTintList = null;
        this.mIconTintMode = null;
        this.mHasIconTint = false;
        this.mHasIconTintMode = false;
        this.mNeedToApplyIconTint = false;
        this.mFlags = 16;
        this.mShowAsAction = 0;
        this.mIsActionViewExpanded = false;
        this.mMenu = menuBuilder;
        this.mId = n11;
        this.mGroup = n10;
        this.mCategoryOrder = n12;
        this.mOrdering = n13;
        this.mTitle = charSequence;
        this.mShowAsAction = n14;
    }

    private static void appendModifier(StringBuilder stringBuilder, int n10, int n11, String string2) {
        if ((n10 &= n11) == n11) {
            stringBuilder.append(string2);
        }
    }

    private Drawable applyIconTintIfNecessary(Drawable drawable2) {
        boolean bl2;
        if (drawable2 != null && (bl2 = this.mNeedToApplyIconTint) && ((bl2 = this.mHasIconTint) || (bl2 = this.mHasIconTintMode))) {
            ColorStateList colorStateList;
            drawable2 = DrawableCompat.wrap(drawable2).mutate();
            bl2 = this.mHasIconTint;
            if (bl2) {
                colorStateList = this.mIconTintList;
                DrawableCompat.setTintList(drawable2, colorStateList);
            }
            if (bl2 = this.mHasIconTintMode) {
                colorStateList = this.mIconTintMode;
                DrawableCompat.setTintMode(drawable2, (PorterDuff.Mode)colorStateList);
            }
            bl2 = false;
            colorStateList = null;
            this.mNeedToApplyIconTint = false;
        }
        return drawable2;
    }

    public void actionFormatChanged() {
        this.mMenu.onItemActionRequestChanged(this);
    }

    public boolean collapseActionView() {
        int n10 = this.mShowAsAction & 8;
        if (n10 == 0) {
            return false;
        }
        View view = this.mActionView;
        if (view == null) {
            return true;
        }
        view = this.mOnActionExpandListener;
        if (view != null && (n10 = (int)(view.onMenuItemActionCollapse((MenuItem)this) ? 1 : 0)) == 0) {
            return false;
        }
        return this.mMenu.collapseItemActionView(this);
    }

    public boolean expandActionView() {
        boolean bl2 = this.hasCollapsibleActionView();
        if (!bl2) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.mOnActionExpandListener;
        if (onActionExpandListener != null && !(bl2 = onActionExpandListener.onMenuItemActionExpand((MenuItem)this))) {
            return false;
        }
        return this.mMenu.expandItemActionView(this);
    }

    public ActionProvider getActionProvider() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
        throw unsupportedOperationException;
    }

    public View getActionView() {
        Object object = this.mActionView;
        if (object != null) {
            return object;
        }
        object = this.mActionProvider;
        if (object != null) {
            object = ((androidx.core.view.ActionProvider)object).onCreateActionView(this);
            this.mActionView = object;
            return object;
        }
        return null;
    }

    public int getAlphabeticModifiers() {
        return this.mShortcutAlphabeticModifiers;
    }

    public char getAlphabeticShortcut() {
        return this.mShortcutAlphabeticChar;
    }

    public Runnable getCallback() {
        return this.mItemCallback;
    }

    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    public int getGroupId() {
        return this.mGroup;
    }

    public Drawable getIcon() {
        Drawable drawable2 = this.mIconDrawable;
        if (drawable2 != null) {
            return this.applyIconTintIfNecessary(drawable2);
        }
        int n10 = this.mIconResId;
        if (n10 != 0) {
            drawable2 = this.mMenu.getContext();
            int n11 = this.mIconResId;
            drawable2 = AppCompatResources.getDrawable((Context)drawable2, n11);
            this.mIconResId = 0;
            this.mIconDrawable = drawable2;
            return this.applyIconTintIfNecessary(drawable2);
        }
        return null;
    }

    public ColorStateList getIconTintList() {
        return this.mIconTintList;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.mIconTintMode;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public int getItemId() {
        return this.mId;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.mMenuInfo;
    }

    public int getNumericModifiers() {
        return this.mShortcutNumericModifiers;
    }

    public char getNumericShortcut() {
        return this.mShortcutNumericChar;
    }

    public int getOrder() {
        return this.mCategoryOrder;
    }

    public int getOrdering() {
        return this.mOrdering;
    }

    public char getShortcut() {
        MenuBuilder menuBuilder = this.mMenu;
        char c10 = menuBuilder.isQwertyMode();
        c10 = c10 != '\u0000' ? this.mShortcutAlphabeticChar : this.mShortcutNumericChar;
        return c10;
    }

    public String getShortcutLabel() {
        char c10 = this.getShortcut();
        if (c10 == '\u0000') {
            return "";
        }
        Resources resources = this.mMenu.getContext().getResources();
        StringBuilder stringBuilder = new StringBuilder();
        Object object = ViewConfiguration.get((Context)this.mMenu.getContext());
        int n10 = object.hasPermanentMenuKey();
        if (n10 != 0) {
            n10 = R$string.abc_prepend_shortcut_label;
            object = resources.getString(n10);
            stringBuilder.append((String)object);
        }
        n10 = (n10 = (int)(((MenuBuilder)(object = this.mMenu)).isQwertyMode() ? 1 : 0)) != 0 ? this.mShortcutAlphabeticModifiers : this.mShortcutNumericModifiers;
        int n11 = R$string.abc_menu_meta_shortcut_label;
        String string2 = resources.getString(n11);
        MenuItemImpl.appendModifier(stringBuilder, n10, 65536, string2);
        n11 = R$string.abc_menu_ctrl_shortcut_label;
        string2 = resources.getString(n11);
        MenuItemImpl.appendModifier(stringBuilder, n10, 4096, string2);
        n11 = R$string.abc_menu_alt_shortcut_label;
        string2 = resources.getString(n11);
        MenuItemImpl.appendModifier(stringBuilder, n10, 2, string2);
        n11 = R$string.abc_menu_shift_shortcut_label;
        string2 = resources.getString(n11);
        MenuItemImpl.appendModifier(stringBuilder, n10, 1, string2);
        n11 = R$string.abc_menu_sym_shortcut_label;
        string2 = resources.getString(n11);
        MenuItemImpl.appendModifier(stringBuilder, n10, 4, string2);
        int n12 = R$string.abc_menu_function_shortcut_label;
        String string3 = resources.getString(n12);
        n11 = 8;
        MenuItemImpl.appendModifier(stringBuilder, n10, n11, string3);
        if (c10 != n11) {
            n10 = 10;
            if (c10 != n10) {
                n10 = 32;
                if (c10 != n10) {
                    stringBuilder.append(c10);
                } else {
                    int n13 = R$string.abc_menu_space_shortcut_label;
                    String string4 = resources.getString(n13);
                    stringBuilder.append(string4);
                }
            } else {
                int n14 = R$string.abc_menu_enter_shortcut_label;
                String string5 = resources.getString(n14);
                stringBuilder.append(string5);
            }
        } else {
            int n15 = R$string.abc_menu_delete_shortcut_label;
            String string6 = resources.getString(n15);
            stringBuilder.append(string6);
        }
        return stringBuilder.toString();
    }

    public SubMenu getSubMenu() {
        return this.mSubMenu;
    }

    public androidx.core.view.ActionProvider getSupportActionProvider() {
        return this.mActionProvider;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.mTitleCondensed;
        if (charSequence == null) {
            charSequence = this.mTitle;
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 < n11 && charSequence != null && (n10 = charSequence instanceof String) == 0) {
            charSequence = charSequence.toString();
        }
        return charSequence;
    }

    public CharSequence getTitleForItemView(MenuView$ItemView object) {
        boolean bl2;
        object = object != null && (bl2 = object.prefersCondensedTitle()) ? this.getTitleCondensed() : this.getTitle();
        return object;
    }

    public CharSequence getTooltipText() {
        return this.mTooltipText;
    }

    public boolean hasCollapsibleActionView() {
        int n10 = this.mShowAsAction & 8;
        boolean bl2 = false;
        if (n10 != 0) {
            Object object = this.mActionView;
            if (object == null && (object = this.mActionProvider) != null) {
                object = ((androidx.core.view.ActionProvider)object).onCreateActionView(this);
                this.mActionView = object;
            }
            if ((object = this.mActionView) != null) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public boolean hasSubMenu() {
        boolean bl2;
        SubMenuBuilder subMenuBuilder = this.mSubMenu;
        if (subMenuBuilder != null) {
            bl2 = true;
        } else {
            bl2 = false;
            subMenuBuilder = null;
        }
        return bl2;
    }

    public boolean invoke() {
        boolean bl2;
        Object object = this.mClickListener;
        boolean bl3 = true;
        if (object != null && (bl2 = object.onMenuItemClick((MenuItem)this))) {
            return bl3;
        }
        object = this.mMenu;
        bl2 = ((MenuBuilder)object).dispatchMenuItemSelected((MenuBuilder)object, this);
        if (bl2) {
            return bl3;
        }
        object = this.mItemCallback;
        if (object != null) {
            object.run();
            return bl3;
        }
        object = this.mIntent;
        if (object != null) {
            object = this.mMenu;
            object = ((MenuBuilder)object).getContext();
            String string2 = this.mIntent;
            try {
                object.startActivity((Intent)string2);
                return bl3;
            }
            catch (ActivityNotFoundException activityNotFoundException) {
                string2 = TAG;
                String string3 = "Can't find activity to handle intent; ignoring";
                Log.e((String)string2, (String)string3, (Throwable)activityNotFoundException);
            }
        }
        if ((object = this.mActionProvider) != null && (bl2 = ((androidx.core.view.ActionProvider)object).onPerformDefaultAction())) {
            return bl3;
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    public boolean isActionButton() {
        void var1_5;
        int bl2 = this.mFlags;
        int n10 = 32;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    public boolean isActionViewExpanded() {
        return this.mIsActionViewExpanded;
    }

    public boolean isCheckable() {
        int bl2 = this.mFlags;
        int n10 = 1;
        int n11 = bl2 & n10;
        if (n11 != n10) {
            n10 = 0;
        }
        return n10 != 0;
    }

    /*
     * WARNING - void declaration
     */
    public boolean isChecked() {
        void var1_5;
        int bl2 = this.mFlags;
        int n10 = 2;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    public boolean isEnabled() {
        int n10 = this.mFlags & 0x10;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isExclusiveCheckable() {
        int n10 = this.mFlags & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isVisible() {
        int n10;
        androidx.core.view.ActionProvider actionProvider = this.mActionProvider;
        boolean bl2 = true;
        if (actionProvider != null && (n10 = actionProvider.overridesItemVisibility()) != 0) {
            n10 = this.mFlags & 8;
            if (n10 != 0 || (n10 = (int)((actionProvider = this.mActionProvider).isVisible() ? 1 : 0)) == 0) {
                bl2 = false;
            }
            return bl2;
        }
        n10 = this.mFlags & 8;
        if (n10 != 0) {
            bl2 = false;
        }
        return bl2;
    }

    public boolean requestsActionButton() {
        int bl2 = this.mShowAsAction;
        int n10 = 1;
        int n11 = bl2 & n10;
        if (n11 != n10) {
            n10 = 0;
        }
        return n10 != 0;
    }

    /*
     * WARNING - void declaration
     */
    public boolean requiresActionButton() {
        void var1_5;
        int bl2 = this.mShowAsAction;
        int n10 = 2;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    public boolean requiresOverflow() {
        boolean bl2 = this.requiresActionButton();
        bl2 = !bl2 && !(bl2 = this.requestsActionButton());
        return bl2;
    }

    public MenuItem setActionProvider(ActionProvider object) {
        object = new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
        throw object;
    }

    public SupportMenuItem setActionView(int n10) {
        Context context = this.mMenu.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from((Context)context);
        LinearLayout linearLayout = new LinearLayout(context);
        View view = layoutInflater.inflate(n10, (ViewGroup)linearLayout, false);
        this.setActionView(view);
        return this;
    }

    public SupportMenuItem setActionView(View view) {
        int n10;
        this.mActionView = view;
        int n11 = 0;
        this.mActionProvider = null;
        if (view != null && (n11 = view.getId()) == (n10 = -1) && (n11 = this.mId) > 0) {
            view.setId(n11);
        }
        this.mMenu.onItemActionRequestChanged(this);
        return this;
    }

    public void setActionViewExpanded(boolean bl2) {
        this.mIsActionViewExpanded = bl2;
        this.mMenu.onItemsChanged(false);
    }

    public MenuItem setAlphabeticShortcut(char c10) {
        char c11 = this.mShortcutAlphabeticChar;
        if (c11 == c10) {
            return this;
        }
        this.mShortcutAlphabeticChar = c10 = Character.toLowerCase(c10);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c10, int n10) {
        int n11 = this.mShortcutAlphabeticChar;
        if (n11 == c10 && (n11 = this.mShortcutAlphabeticModifiers) == n10) {
            return this;
        }
        this.mShortcutAlphabeticChar = c10 = Character.toLowerCase(c10);
        c10 = (char)KeyEvent.normalizeMetaState((int)n10);
        this.mShortcutAlphabeticModifiers = c10;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setCallback(Runnable runnable) {
        this.mItemCallback = runnable;
        return this;
    }

    public MenuItem setCheckable(boolean n10) {
        int n11 = this.mFlags;
        int n12 = n11 & 0xFFFFFFFE;
        this.mFlags = n10 |= n12;
        if (n11 != n10) {
            MenuBuilder menuBuilder = this.mMenu;
            n11 = 0;
            menuBuilder.onItemsChanged(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean bl2) {
        int n10 = this.mFlags & 4;
        if (n10 != 0) {
            MenuBuilder menuBuilder = this.mMenu;
            menuBuilder.setExclusiveItemChecked(this);
        } else {
            this.setCheckedInt(bl2);
        }
        return this;
    }

    public void setCheckedInt(boolean n10) {
        MenuBuilder menuBuilder;
        int n11 = this.mFlags;
        int n12 = n11 & 0xFFFFFFFD;
        if (n10 != 0) {
            n10 = 2;
        } else {
            n10 = 0;
            menuBuilder = null;
        }
        this.mFlags = n10 |= n12;
        if (n11 != n10) {
            menuBuilder = this.mMenu;
            menuBuilder.onItemsChanged(false);
        }
    }

    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.mContentDescription = charSequence;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setEnabled(boolean bl2) {
        int n10;
        int n11;
        this.mFlags = bl2 ? (n11 = this.mFlags | 0x10) : (n10 = this.mFlags & 0xFFFFFFEF);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    /*
     * WARNING - void declaration
     */
    public void setExclusiveCheckable(boolean bl2) {
        void var1_4;
        int n10;
        int n11 = this.mFlags & 0xFFFFFFFB;
        if (bl2) {
            int n12 = 4;
        } else {
            boolean bl3 = false;
        }
        this.mFlags = n10 = var1_4 | n11;
    }

    public MenuItem setIcon(int n10) {
        this.mIconDrawable = null;
        this.mIconResId = n10;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable2) {
        this.mIconResId = 0;
        this.mIconDrawable = drawable2;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        boolean bl2;
        this.mIconTintList = colorStateList;
        this.mHasIconTint = bl2 = true;
        this.mNeedToApplyIconTint = bl2;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        boolean bl2;
        this.mIconTintMode = mode;
        this.mHasIconTintMode = bl2 = true;
        this.mNeedToApplyIconTint = bl2;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.mIntent = intent;
        return this;
    }

    public void setIsActionButton(boolean bl2) {
        int n10;
        int n11;
        this.mFlags = bl2 ? (n11 = this.mFlags | 0x20) : (n10 = this.mFlags & 0xFFFFFFDF);
    }

    public void setMenuInfo(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mMenuInfo = contextMenuInfo;
    }

    public MenuItem setNumericShortcut(char c10) {
        char c11 = this.mShortcutNumericChar;
        if (c11 == c10) {
            return this;
        }
        this.mShortcutNumericChar = c10;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setNumericShortcut(char c10, int n10) {
        int n11 = this.mShortcutNumericChar;
        if (n11 == c10 && (n11 = this.mShortcutNumericModifiers) == n10) {
            return this;
        }
        this.mShortcutNumericChar = c10;
        c10 = (char)KeyEvent.normalizeMetaState((int)n10);
        this.mShortcutNumericModifiers = c10;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.mOnActionExpandListener = onActionExpandListener;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mClickListener = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c10, char c11) {
        this.mShortcutNumericChar = c10;
        this.mShortcutAlphabeticChar = c10 = Character.toLowerCase(c11);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setShortcut(char c10, char c11, int n10, int n11) {
        this.mShortcutNumericChar = c10;
        c10 = (char)KeyEvent.normalizeMetaState((int)n10);
        this.mShortcutNumericModifiers = c10;
        this.mShortcutAlphabeticChar = c10 = Character.toLowerCase(c11);
        c10 = (char)KeyEvent.normalizeMetaState((int)n11);
        this.mShortcutAlphabeticModifiers = c10;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public void setShowAsAction(int n10) {
        int n11;
        int n12 = n10 & 3;
        if (n12 != 0 && n12 != (n11 = 1) && n12 != (n11 = 2)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
            throw illegalArgumentException;
        }
        this.mShowAsAction = n10;
        this.mMenu.onItemActionRequestChanged(this);
    }

    public SupportMenuItem setShowAsActionFlags(int n10) {
        this.setShowAsAction(n10);
        return this;
    }

    public void setSubMenu(SubMenuBuilder subMenuBuilder) {
        this.mSubMenu = subMenuBuilder;
        CharSequence charSequence = this.getTitle();
        subMenuBuilder.setHeaderTitle(charSequence);
    }

    public SupportMenuItem setSupportActionProvider(androidx.core.view.ActionProvider object) {
        Object object2 = this.mActionProvider;
        if (object2 != null) {
            ((androidx.core.view.ActionProvider)object2).reset();
        }
        object2 = null;
        this.mActionView = null;
        this.mActionProvider = object;
        object = this.mMenu;
        boolean bl2 = true;
        ((MenuBuilder)object).onItemsChanged(bl2);
        object = this.mActionProvider;
        if (object != null) {
            object2 = new MenuItemImpl$1(this);
            ((androidx.core.view.ActionProvider)object).setVisibilityListener((ActionProvider$VisibilityListener)object2);
        }
        return this;
    }

    public MenuItem setTitle(int n10) {
        String string2 = this.mMenu.getContext().getString(n10);
        return this.setTitle(string2);
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        this.mMenu.onItemsChanged(false);
        SubMenuBuilder subMenuBuilder = this.mSubMenu;
        if (subMenuBuilder != null) {
            subMenuBuilder.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.mTitleCondensed = charSequence;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.mTooltipText = charSequence;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setVisible(boolean bl2) {
        if (bl2 = this.setVisibleInt(bl2)) {
            MenuBuilder menuBuilder = this.mMenu;
            menuBuilder.onItemVisibleChanged(this);
        }
        return this;
    }

    public boolean setVisibleInt(boolean n10) {
        int n11 = this.mFlags;
        int n12 = n11 & 0xFFFFFFF7;
        boolean bl2 = false;
        n10 = n10 != 0 ? 0 : 8;
        this.mFlags = n10 |= n12;
        if (n11 != n10) {
            bl2 = true;
        }
        return bl2;
    }

    public boolean shouldShowIcon() {
        return this.mMenu.getOptionalIconsVisible();
    }

    public boolean shouldShowShortcut() {
        MenuBuilder menuBuilder = this.mMenu;
        boolean bl2 = menuBuilder.isShortcutsVisible();
        if (bl2 && (bl2 = this.getShortcut())) {
            bl2 = true;
        } else {
            bl2 = false;
            menuBuilder = null;
        }
        return bl2;
    }

    /*
     * WARNING - void declaration
     */
    public boolean showsTextAsAction() {
        void var1_5;
        int bl2 = this.mShowAsAction;
        int n10 = 4;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    public String toString() {
        CharSequence charSequence = this.mTitle;
        charSequence = charSequence != null ? charSequence.toString() : null;
        return charSequence;
    }
}

