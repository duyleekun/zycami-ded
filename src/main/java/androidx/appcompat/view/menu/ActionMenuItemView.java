/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.ActionMenuItemView$ActionMenuItemForwardingListener;
import androidx.appcompat.view.menu.ActionMenuItemView$PopupCallback;
import androidx.appcompat.view.menu.MenuBuilder$ItemInvoker;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView$ItemView;
import androidx.appcompat.widget.ActionMenuView$ActionMenuChildView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.TooltipCompat;

public class ActionMenuItemView
extends AppCompatTextView
implements MenuView$ItemView,
View.OnClickListener,
ActionMenuView$ActionMenuChildView {
    private static final int MAX_ICON_SIZE = 32;
    private static final String TAG = "ActionMenuItemView";
    private boolean mAllowTextWithIcon;
    private boolean mExpandedFormat;
    private ForwardingListener mForwardingListener;
    private Drawable mIcon;
    public MenuItemImpl mItemData;
    public MenuBuilder$ItemInvoker mItemInvoker;
    private int mMaxIconSize;
    private int mMinWidth;
    public ActionMenuItemView$PopupCallback mPopupCallback;
    private int mSavedPaddingLeft;
    private CharSequence mTitle;

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        int n11;
        boolean bl2;
        Resources resources = context.getResources();
        this.mAllowTextWithIcon = bl2 = this.shouldAllowTextWithIcon();
        int[] nArray = R$styleable.ActionMenuItemView;
        context = context.obtainStyledAttributes(attributeSet, nArray, n10, 0);
        int n12 = R$styleable.ActionMenuItemView_android_minWidth;
        this.mMinWidth = n12 = context.getDimensionPixelSize(n12, 0);
        context.recycle();
        this.mMaxIconSize = n11 = (int)(resources.getDisplayMetrics().density * 32.0f + 0.5f);
        this.setOnClickListener(this);
        this.mSavedPaddingLeft = -1;
        this.setSaveEnabled(false);
    }

    private boolean shouldAllowTextWithIcon() {
        int n10;
        int n11;
        Configuration configuration = this.getContext().getResources().getConfiguration();
        int n12 = configuration.screenWidthDp;
        int n13 = configuration.screenHeightDp;
        int n14 = 480;
        if (n12 < n14 && (n12 < (n11 = 640) || n13 < n14) && (n10 = configuration.orientation) != (n12 = 2)) {
            n10 = 0;
            configuration = null;
        } else {
            n10 = 1;
        }
        return n10 != 0;
    }

    private void updateTextButtonVisibility() {
        CharSequence charSequence;
        boolean bl2;
        Object object = this.mTitle;
        boolean bl3 = TextUtils.isEmpty((CharSequence)object);
        boolean bl4 = true;
        bl3 ^= bl4;
        Object object2 = this.mIcon;
        if (!(object2 == null || (bl2 = ((MenuItemImpl)(object2 = this.mItemData)).showsTextAsAction()) && ((bl2 = this.mAllowTextWithIcon) || (bl2 = this.mExpandedFormat)))) {
            bl4 = false;
            charSequence = null;
        }
        bl3 &= bl4;
        bl4 = false;
        charSequence = null;
        if (bl3) {
            object2 = this.mTitle;
        } else {
            bl2 = false;
            object2 = null;
        }
        this.setText((CharSequence)object2);
        object2 = this.mItemData.getContentDescription();
        boolean bl5 = TextUtils.isEmpty((CharSequence)object2);
        if (bl5) {
            if (bl3) {
                bl2 = false;
                object2 = null;
            } else {
                object2 = this.mItemData.getTitle();
            }
            this.setContentDescription((CharSequence)object2);
        } else {
            this.setContentDescription((CharSequence)object2);
        }
        object2 = this.mItemData.getTooltipText();
        bl5 = TextUtils.isEmpty((CharSequence)object2);
        if (bl5) {
            if (!bl3) {
                object = this.mItemData;
                charSequence = ((MenuItemImpl)object).getTitle();
            }
            TooltipCompat.setTooltipText((View)this, charSequence);
        } else {
            TooltipCompat.setTooltipText((View)this, (CharSequence)object2);
        }
    }

    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

    public boolean hasText() {
        return TextUtils.isEmpty((CharSequence)this.getText()) ^ true;
    }

    public void initialize(MenuItemImpl object, int n10) {
        this.mItemData = object;
        Object object2 = ((MenuItemImpl)object).getIcon();
        this.setIcon((Drawable)object2);
        object2 = ((MenuItemImpl)object).getTitleForItemView(this);
        this.setTitle((CharSequence)object2);
        n10 = ((MenuItemImpl)object).getItemId();
        this.setId(n10);
        n10 = (int)(((MenuItemImpl)object).isVisible() ? 1 : 0);
        if (n10 != 0) {
            n10 = 0;
            object2 = null;
        } else {
            n10 = 8;
        }
        this.setVisibility(n10);
        n10 = (int)(((MenuItemImpl)object).isEnabled() ? 1 : 0);
        this.setEnabled(n10 != 0);
        boolean bl2 = ((MenuItemImpl)object).hasSubMenu();
        if (bl2 && (object = this.mForwardingListener) == null) {
            this.mForwardingListener = object = new ActionMenuItemView$ActionMenuItemForwardingListener(this);
        }
    }

    public boolean needsDividerAfter() {
        return this.hasText();
    }

    public boolean needsDividerBefore() {
        Drawable drawable2;
        boolean bl2 = this.hasText();
        if (bl2 && (drawable2 = this.mItemData.getIcon()) == null) {
            bl2 = true;
        } else {
            bl2 = false;
            drawable2 = null;
        }
        return bl2;
    }

    public void onClick(View object) {
        object = this.mItemInvoker;
        if (object != null) {
            MenuItemImpl menuItemImpl = this.mItemData;
            object.invokeItem(menuItemImpl);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        boolean bl2;
        super.onConfigurationChanged(configuration);
        this.mAllowTextWithIcon = bl2 = this.shouldAllowTextWithIcon();
        this.updateTextButtonVisibility();
    }

    public void onMeasure(int n10, int n11) {
        Drawable drawable2;
        int n12;
        int n13;
        int n14;
        int n15 = this.hasText();
        if (n15 != 0 && (n14 = this.mSavedPaddingLeft) >= 0) {
            n13 = this.getPaddingTop();
            n12 = this.getPaddingRight();
            int n16 = this.getPaddingBottom();
            super.setPadding(n14, n13, n12, n16);
        }
        super.onMeasure(n10, n11);
        n14 = View.MeasureSpec.getMode((int)n10);
        n10 = View.MeasureSpec.getSize((int)n10);
        n13 = this.getMeasuredWidth();
        n12 = -1 << -1;
        if (n14 == n12) {
            n12 = this.mMinWidth;
            n10 = Math.min(n10, n12);
        } else {
            n10 = this.mMinWidth;
        }
        n12 = 0x40000000;
        if (n14 != n12 && (n14 = this.mMinWidth) > 0 && n13 < n10) {
            n10 = View.MeasureSpec.makeMeasureSpec((int)n10, (int)n12);
            super.onMeasure(n10, n11);
        }
        if (n15 == 0 && (drawable2 = this.mIcon) != null) {
            n10 = this.getMeasuredWidth();
            Rect rect = this.mIcon.getBounds();
            n11 = rect.width();
            n10 = (n10 - n11) / 2;
            n11 = this.getPaddingTop();
            n15 = this.getPaddingRight();
            n14 = this.getPaddingBottom();
            super.setPadding(n10, n11, n15, n14);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Object object = this.mItemData;
        boolean bl2 = ((MenuItemImpl)object).hasSubMenu();
        if (bl2 && (object = this.mForwardingListener) != null && (bl2 = ((ForwardingListener)object).onTouch((View)this, motionEvent))) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setCheckable(boolean bl2) {
    }

    public void setChecked(boolean bl2) {
    }

    public void setExpandedFormat(boolean bl2) {
        boolean bl3 = this.mExpandedFormat;
        if (bl3 != bl2) {
            this.mExpandedFormat = bl2;
            MenuItemImpl menuItemImpl = this.mItemData;
            if (menuItemImpl != null) {
                menuItemImpl.actionFormatChanged();
            }
        }
    }

    public void setIcon(Drawable drawable2) {
        this.mIcon = drawable2;
        if (drawable2 != null) {
            float f10;
            float f11;
            float f12;
            int n10 = drawable2.getIntrinsicWidth();
            int n11 = drawable2.getIntrinsicHeight();
            int n12 = this.mMaxIconSize;
            if (n10 > n12) {
                f12 = n12;
                f11 = n10;
                f12 /= f11;
                f11 = (float)n11 * f12;
                n11 = (int)f11;
                n10 = n12;
            }
            if (n11 > n12) {
                f12 = n12;
                f10 = n11;
                f11 = (float)n10 * (f12 /= f10);
                n10 = (int)f11;
            } else {
                n12 = n11;
            }
            n11 = 0;
            f10 = 0.0f;
            drawable2.setBounds(0, 0, n10, n12);
        }
        this.setCompoundDrawables(drawable2, null, null, null);
        this.updateTextButtonVisibility();
    }

    public void setItemInvoker(MenuBuilder$ItemInvoker menuBuilder$ItemInvoker) {
        this.mItemInvoker = menuBuilder$ItemInvoker;
    }

    public void setPadding(int n10, int n11, int n12, int n13) {
        this.mSavedPaddingLeft = n10;
        super.setPadding(n10, n11, n12, n13);
    }

    public void setPopupCallback(ActionMenuItemView$PopupCallback actionMenuItemView$PopupCallback) {
        this.mPopupCallback = actionMenuItemView$PopupCallback;
    }

    public void setShortcut(boolean bl2, char c10) {
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        this.updateTextButtonVisibility();
    }

    public boolean showsIcon() {
        return true;
    }
}

