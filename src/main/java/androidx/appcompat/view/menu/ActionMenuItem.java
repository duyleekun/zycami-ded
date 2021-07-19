/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.view.ActionProvider
 *  android.view.ContextMenu$ContextMenuInfo
 *  android.view.KeyEvent
 *  android.view.MenuItem
 *  android.view.MenuItem$OnActionExpandListener
 *  android.view.MenuItem$OnMenuItemClickListener
 *  android.view.SubMenu
 *  android.view.View
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;

public class ActionMenuItem
implements SupportMenuItem {
    private static final int CHECKABLE = 1;
    private static final int CHECKED = 2;
    private static final int ENABLED = 16;
    private static final int EXCLUSIVE = 4;
    private static final int HIDDEN = 8;
    private MenuItem.OnMenuItemClickListener mClickListener;
    private CharSequence mContentDescription;
    private Context mContext;
    private int mFlags;
    private final int mGroup;
    private boolean mHasIconTint;
    private boolean mHasIconTintMode;
    private Drawable mIconDrawable;
    private ColorStateList mIconTintList;
    private PorterDuff.Mode mIconTintMode;
    private final int mId;
    private Intent mIntent;
    private final int mOrdering;
    private char mShortcutAlphabeticChar;
    private int mShortcutAlphabeticModifiers;
    private char mShortcutNumericChar;
    private int mShortcutNumericModifiers;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;
    private CharSequence mTooltipText;

    public ActionMenuItem(Context context, int n10, int n11, int n12, int n13, CharSequence charSequence) {
        this.mShortcutNumericModifiers = n12 = 4096;
        this.mShortcutAlphabeticModifiers = n12;
        this.mIconTintList = null;
        this.mIconTintMode = null;
        this.mHasIconTint = false;
        this.mHasIconTintMode = false;
        this.mFlags = 16;
        this.mContext = context;
        this.mId = n11;
        this.mGroup = n10;
        this.mOrdering = n13;
        this.mTitle = charSequence;
    }

    private void applyIconTint() {
        boolean bl2;
        Drawable drawable2 = this.mIconDrawable;
        if (drawable2 != null && ((bl2 = this.mHasIconTint) || (bl2 = this.mHasIconTintMode))) {
            boolean bl3;
            ColorStateList colorStateList;
            this.mIconDrawable = drawable2 = DrawableCompat.wrap(drawable2);
            this.mIconDrawable = drawable2 = drawable2.mutate();
            bl2 = this.mHasIconTint;
            if (bl2) {
                colorStateList = this.mIconTintList;
                DrawableCompat.setTintList(drawable2, colorStateList);
            }
            if (bl3 = this.mHasIconTintMode) {
                drawable2 = this.mIconDrawable;
                colorStateList = this.mIconTintMode;
                DrawableCompat.setTintMode(drawable2, (PorterDuff.Mode)colorStateList);
            }
        }
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean expandActionView() {
        return false;
    }

    public ActionProvider getActionProvider() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public View getActionView() {
        return null;
    }

    public int getAlphabeticModifiers() {
        return this.mShortcutAlphabeticModifiers;
    }

    public char getAlphabeticShortcut() {
        return this.mShortcutAlphabeticChar;
    }

    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    public int getGroupId() {
        return this.mGroup;
    }

    public Drawable getIcon() {
        return this.mIconDrawable;
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
        return null;
    }

    public int getNumericModifiers() {
        return this.mShortcutNumericModifiers;
    }

    public char getNumericShortcut() {
        return this.mShortcutNumericChar;
    }

    public int getOrder() {
        return this.mOrdering;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public androidx.core.view.ActionProvider getSupportActionProvider() {
        return null;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.mTitleCondensed;
        if (charSequence == null) {
            charSequence = this.mTitle;
        }
        return charSequence;
    }

    public CharSequence getTooltipText() {
        return this.mTooltipText;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean invoke() {
        boolean bl2;
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.mClickListener;
        boolean bl3 = true;
        if (onMenuItemClickListener != null && (bl2 = onMenuItemClickListener.onMenuItemClick((MenuItem)this))) {
            return bl3;
        }
        onMenuItemClickListener = this.mIntent;
        if (onMenuItemClickListener != null) {
            this.mContext.startActivity((Intent)onMenuItemClickListener);
            return bl3;
        }
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        int n10 = this.mFlags;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean isChecked() {
        int n10 = this.mFlags & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isEnabled() {
        int n10 = this.mFlags & 0x10;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isVisible() {
        int n10 = this.mFlags & 8;
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean requiresActionButton() {
        return true;
    }

    public boolean requiresOverflow() {
        return false;
    }

    public MenuItem setActionProvider(ActionProvider object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public SupportMenuItem setActionView(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public SupportMenuItem setActionView(View object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public MenuItem setAlphabeticShortcut(char c10) {
        this.mShortcutAlphabeticChar = c10 = Character.toLowerCase(c10);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c10, int n10) {
        this.mShortcutAlphabeticChar = c10 = Character.toLowerCase(c10);
        c10 = (char)KeyEvent.normalizeMetaState((int)n10);
        this.mShortcutAlphabeticModifiers = c10;
        return this;
    }

    public MenuItem setCheckable(boolean bl2) {
        int n10 = this.mFlags & 0xFFFFFFFE;
        this.mFlags = (int)((bl2 |= n10) ? 1 : 0);
        return this;
    }

    /*
     * WARNING - void declaration
     */
    public MenuItem setChecked(boolean bl2) {
        void var1_4;
        int n10;
        int n11 = this.mFlags & 0xFFFFFFFD;
        if (bl2) {
            int n12 = 2;
        } else {
            boolean bl3 = false;
        }
        this.mFlags = n10 = var1_4 | n11;
        return this;
    }

    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.mContentDescription = charSequence;
        return this;
    }

    /*
     * WARNING - void declaration
     */
    public MenuItem setEnabled(boolean bl2) {
        void var1_4;
        int n10;
        int n11 = this.mFlags & 0xFFFFFFEF;
        if (bl2) {
            int n12 = 16;
        } else {
            boolean bl3 = false;
        }
        this.mFlags = n10 = var1_4 | n11;
        return this;
    }

    /*
     * WARNING - void declaration
     */
    public ActionMenuItem setExclusiveCheckable(boolean bl2) {
        void var1_4;
        int n10;
        int n11 = this.mFlags & 0xFFFFFFFB;
        if (bl2) {
            int n12 = 4;
        } else {
            boolean bl3 = false;
        }
        this.mFlags = n10 = var1_4 | n11;
        return this;
    }

    public MenuItem setIcon(int n10) {
        Drawable drawable2;
        this.mIconDrawable = drawable2 = ContextCompat.getDrawable(this.mContext, n10);
        this.applyIconTint();
        return this;
    }

    public MenuItem setIcon(Drawable drawable2) {
        this.mIconDrawable = drawable2;
        this.applyIconTint();
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.mIconTintList = colorStateList;
        this.mHasIconTint = true;
        this.applyIconTint();
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.mIconTintMode = mode;
        this.mHasIconTintMode = true;
        this.applyIconTint();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.mIntent = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c10) {
        this.mShortcutNumericChar = c10;
        return this;
    }

    public MenuItem setNumericShortcut(char c10, int n10) {
        this.mShortcutNumericChar = c10;
        c10 = (char)KeyEvent.normalizeMetaState((int)n10);
        this.mShortcutNumericModifiers = c10;
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mClickListener = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c10, char c11) {
        this.mShortcutNumericChar = c10;
        this.mShortcutAlphabeticChar = c10 = Character.toLowerCase(c11);
        return this;
    }

    public MenuItem setShortcut(char c10, char c11, int n10, int n11) {
        this.mShortcutNumericChar = c10;
        c10 = (char)KeyEvent.normalizeMetaState((int)n10);
        this.mShortcutNumericModifiers = c10;
        this.mShortcutAlphabeticChar = c10 = Character.toLowerCase(c11);
        c10 = (char)KeyEvent.normalizeMetaState((int)n11);
        this.mShortcutAlphabeticModifiers = c10;
        return this;
    }

    public void setShowAsAction(int n10) {
    }

    public SupportMenuItem setShowAsActionFlags(int n10) {
        this.setShowAsAction(n10);
        return this;
    }

    public SupportMenuItem setSupportActionProvider(androidx.core.view.ActionProvider object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public MenuItem setTitle(int n10) {
        String string2 = this.mContext.getResources().getString(n10);
        this.mTitle = string2;
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.mTitleCondensed = charSequence;
        return this;
    }

    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.mTooltipText = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean bl2) {
        int n10;
        int n11 = this.mFlags;
        int n12 = 8;
        n11 &= n12;
        if (bl2) {
            n12 = 0;
        }
        this.mFlags = n10 = n11 | n12;
        return this;
    }
}

