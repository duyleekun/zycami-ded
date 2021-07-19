/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.AbsListView$SelectionBoundsAdjuster
 *  android.widget.CheckBox
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.RadioButton
 *  android.widget.TextView
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView$ItemView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;

public class ListMenuItemView
extends LinearLayout
implements MenuView$ItemView,
AbsListView.SelectionBoundsAdjuster {
    private static final String TAG = "ListMenuItemView";
    private Drawable mBackground;
    private CheckBox mCheckBox;
    private LinearLayout mContent;
    private boolean mForceShowIcon;
    private ImageView mGroupDivider;
    private boolean mHasListDivider;
    private ImageView mIconView;
    private LayoutInflater mInflater;
    private MenuItemImpl mItemData;
    private boolean mPreserveIconSpacing;
    private RadioButton mRadioButton;
    private TextView mShortcutView;
    private Drawable mSubMenuArrow;
    private ImageView mSubMenuArrowView;
    private int mTextAppearance;
    private Context mTextAppearanceContext;
    private TextView mTitleView;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.listMenuViewStyle;
        this(context, attributeSet, n10);
    }

    public ListMenuItemView(Context context, AttributeSet object, int n10) {
        super(context, (AttributeSet)object);
        Object object2;
        Context context2 = this.getContext();
        int[] nArray = R$styleable.MenuView;
        object = TintTypedArray.obtainStyledAttributes(context2, (AttributeSet)object, nArray, n10, 0);
        n10 = R$styleable.MenuView_android_itemBackground;
        this.mBackground = object2 = ((TintTypedArray)object).getDrawable(n10);
        n10 = R$styleable.MenuView_android_itemTextAppearance;
        this.mTextAppearance = n10 = ((TintTypedArray)object).getResourceId(n10, -1);
        n10 = R$styleable.MenuView_preserveIconSpacing;
        n10 = (int)(((TintTypedArray)object).getBoolean(n10, false) ? 1 : 0);
        this.mPreserveIconSpacing = n10;
        this.mTextAppearanceContext = context;
        n10 = R$styleable.MenuView_subMenuArrow;
        this.mSubMenuArrow = object2 = ((TintTypedArray)object).getDrawable(n10);
        context = context.getTheme();
        object2 = new int[1];
        object2[0] = (Drawable)16843049;
        int n11 = R$attr.dropDownListViewStyle;
        context = context.obtainStyledAttributes(null, (int[])object2, n11, 0);
        n10 = (int)(context.hasValue(0) ? 1 : 0);
        this.mHasListDivider = n10;
        ((TintTypedArray)object).recycle();
        context.recycle();
    }

    private void addContentView(View view) {
        this.addContentView(view, -1);
    }

    private void addContentView(View view, int n10) {
        LinearLayout linearLayout = this.mContent;
        if (linearLayout != null) {
            linearLayout.addView(view, n10);
        } else {
            this.addView(view, n10);
        }
    }

    private LayoutInflater getInflater() {
        LayoutInflater layoutInflater = this.mInflater;
        if (layoutInflater == null) {
            this.mInflater = layoutInflater = LayoutInflater.from((Context)this.getContext());
        }
        return this.mInflater;
    }

    private void insertCheckBox() {
        LayoutInflater layoutInflater = this.getInflater();
        int n10 = R$layout.abc_list_menu_item_checkbox;
        layoutInflater = (CheckBox)layoutInflater.inflate(n10, (ViewGroup)this, false);
        this.mCheckBox = layoutInflater;
        this.addContentView((View)layoutInflater);
    }

    private void insertIconView() {
        LayoutInflater layoutInflater = this.getInflater();
        int n10 = R$layout.abc_list_menu_item_icon;
        layoutInflater = (ImageView)layoutInflater.inflate(n10, (ViewGroup)this, false);
        this.mIconView = layoutInflater;
        this.addContentView((View)layoutInflater, 0);
    }

    private void insertRadioButton() {
        LayoutInflater layoutInflater = this.getInflater();
        int n10 = R$layout.abc_list_menu_item_radio;
        layoutInflater = (RadioButton)layoutInflater.inflate(n10, (ViewGroup)this, false);
        this.mRadioButton = layoutInflater;
        this.addContentView((View)layoutInflater);
    }

    private void setSubMenuArrowVisible(boolean n10) {
        ImageView imageView = this.mSubMenuArrowView;
        if (imageView != null) {
            n10 = n10 != 0 ? 0 : 8;
            imageView.setVisibility(n10);
        }
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        int n10;
        ImageView imageView = this.mGroupDivider;
        if (imageView != null && (n10 = imageView.getVisibility()) == 0) {
            imageView = (LinearLayout.LayoutParams)this.mGroupDivider.getLayoutParams();
            int n11 = rect.top;
            ImageView imageView2 = this.mGroupDivider;
            int n12 = imageView2.getHeight();
            int n13 = imageView.topMargin;
            n12 += n13;
            n10 = imageView.bottomMargin;
            rect.top = n11 += (n12 += n10);
        }
    }

    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

    public void initialize(MenuItemImpl object, int n10) {
        CharSequence charSequence;
        this.mItemData = object;
        n10 = (int)(((MenuItemImpl)object).isVisible() ? 1 : 0);
        if (n10 != 0) {
            n10 = 0;
            charSequence = null;
        } else {
            n10 = 8;
        }
        this.setVisibility(n10);
        charSequence = ((MenuItemImpl)object).getTitleForItemView(this);
        this.setTitle(charSequence);
        n10 = (int)(((MenuItemImpl)object).isCheckable() ? 1 : 0);
        this.setCheckable(n10 != 0);
        n10 = (int)(((MenuItemImpl)object).shouldShowShortcut() ? 1 : 0);
        char c10 = ((MenuItemImpl)object).getShortcut();
        this.setShortcut(n10 != 0, c10);
        charSequence = ((MenuItemImpl)object).getIcon();
        this.setIcon((Drawable)charSequence);
        n10 = (int)(((MenuItemImpl)object).isEnabled() ? 1 : 0);
        this.setEnabled(n10 != 0);
        n10 = (int)(((MenuItemImpl)object).hasSubMenu() ? 1 : 0);
        this.setSubMenuArrowVisible(n10 != 0);
        object = ((MenuItemImpl)object).getContentDescription();
        this.setContentDescription((CharSequence)object);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        Drawable drawable2 = this.mBackground;
        ViewCompat.setBackground((View)this, drawable2);
        int n10 = R$id.title;
        drawable2 = (TextView)this.findViewById(n10);
        this.mTitleView = drawable2;
        int n11 = this.mTextAppearance;
        int n12 = -1;
        if (n11 != n12) {
            Context context = this.mTextAppearanceContext;
            drawable2.setTextAppearance(context, n11);
        }
        n10 = R$id.shortcut;
        drawable2 = (TextView)this.findViewById(n10);
        this.mShortcutView = drawable2;
        n10 = R$id.submenuarrow;
        drawable2 = (ImageView)this.findViewById(n10);
        this.mSubMenuArrowView = drawable2;
        if (drawable2 != null) {
            Drawable drawable3 = this.mSubMenuArrow;
            drawable2.setImageDrawable(drawable3);
        }
        n10 = R$id.group_divider;
        drawable2 = (ImageView)this.findViewById(n10);
        this.mGroupDivider = drawable2;
        n10 = R$id.content;
        drawable2 = (LinearLayout)this.findViewById(n10);
        this.mContent = drawable2;
    }

    public void onMeasure(int n10, int n11) {
        int n12;
        ImageView imageView = this.mIconView;
        if (imageView != null && (n12 = this.mPreserveIconSpacing) != 0) {
            int n13;
            imageView = this.getLayoutParams();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.mIconView.getLayoutParams();
            n12 = imageView.height;
            if (n12 > 0 && (n13 = layoutParams.width) <= 0) {
                layoutParams.width = n12;
            }
        }
        super.onMeasure(n10, n11);
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setCheckable(boolean n10) {
        CheckBox checkBox;
        Object object;
        if (n10 == 0 && (object = this.mRadioButton) == null && (object = this.mCheckBox) == null) {
            return;
        }
        object = this.mItemData;
        boolean bl2 = ((MenuItemImpl)object).isExclusiveCheckable();
        if (bl2) {
            object = this.mRadioButton;
            if (object == null) {
                this.insertRadioButton();
            }
            object = this.mRadioButton;
            checkBox = this.mCheckBox;
        } else {
            object = this.mCheckBox;
            if (object == null) {
                this.insertCheckBox();
            }
            object = this.mCheckBox;
            checkBox = this.mRadioButton;
        }
        int n11 = 8;
        if (n10 != 0) {
            MenuItemImpl menuItemImpl = this.mItemData;
            n10 = menuItemImpl.isChecked();
            object.setChecked(n10 != 0);
            n10 = object.getVisibility();
            if (n10 != 0) {
                n10 = 0;
                menuItemImpl = null;
                object.setVisibility(0);
            }
            if (checkBox != null && (n10 = checkBox.getVisibility()) != n11) {
                checkBox.setVisibility(n11);
            }
        } else {
            CheckBox checkBox2 = this.mCheckBox;
            if (checkBox2 != null) {
                checkBox2.setVisibility(n11);
            }
            if ((checkBox2 = this.mRadioButton) != null) {
                checkBox2.setVisibility(n11);
            }
        }
    }

    public void setChecked(boolean bl2) {
        MenuItemImpl menuItemImpl = this.mItemData;
        boolean bl3 = menuItemImpl.isExclusiveCheckable();
        if (bl3) {
            menuItemImpl = this.mRadioButton;
            if (menuItemImpl == null) {
                this.insertRadioButton();
            }
            menuItemImpl = this.mRadioButton;
        } else {
            menuItemImpl = this.mCheckBox;
            if (menuItemImpl == null) {
                this.insertCheckBox();
            }
            menuItemImpl = this.mCheckBox;
        }
        menuItemImpl.setChecked(bl2);
    }

    public void setForceShowIcon(boolean bl2) {
        this.mForceShowIcon = bl2;
        this.mPreserveIconSpacing = bl2;
    }

    public void setGroupDividerEnabled(boolean n10) {
        ImageView imageView = this.mGroupDivider;
        if (imageView != null) {
            boolean bl2 = this.mHasListDivider;
            n10 = !bl2 && n10 != 0 ? 0 : 8;
            imageView.setVisibility(n10);
        }
    }

    public void setIcon(Drawable drawable2) {
        boolean bl2;
        boolean bl3;
        MenuItemImpl menuItemImpl = this.mItemData;
        int n10 = menuItemImpl.shouldShowIcon();
        if (n10 == 0 && (n10 = this.mForceShowIcon) == 0) {
            n10 = 0;
            menuItemImpl = null;
        } else {
            n10 = 1;
        }
        if (n10 == 0 && !(bl3 = this.mPreserveIconSpacing)) {
            return;
        }
        ImageView imageView = this.mIconView;
        if (imageView == null && drawable2 == null && !(bl2 = this.mPreserveIconSpacing)) {
            return;
        }
        if (imageView == null) {
            this.insertIconView();
        }
        if (drawable2 == null && !(bl3 = this.mPreserveIconSpacing)) {
            drawable2 = this.mIconView;
            n10 = 8;
            drawable2.setVisibility(n10);
        } else {
            int n11;
            imageView = this.mIconView;
            if (n10 == 0) {
                n11 = 0;
                drawable2 = null;
            }
            imageView.setImageDrawable(drawable2);
            drawable2 = this.mIconView;
            n11 = drawable2.getVisibility();
            if (n11 != 0) {
                drawable2 = this.mIconView;
                drawable2.setVisibility(0);
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    public void setShortcut(boolean c10, char c11) {
        int n10;
        TextView textView;
        void var1_5;
        MenuItemImpl menuItemImpl;
        boolean bl2;
        if (c10 != '\u0000' && (bl2 = (menuItemImpl = this.mItemData).shouldShowShortcut())) {
            boolean bl3 = false;
            menuItemImpl = null;
        } else {
            int n11 = 8;
        }
        if (var1_5 == false) {
            textView = this.mShortcutView;
            String string2 = this.mItemData.getShortcutLabel();
            textView.setText((CharSequence)string2);
        }
        if ((n10 = (textView = this.mShortcutView).getVisibility()) != var1_5) {
            textView = this.mShortcutView;
            textView.setVisibility((int)var1_5);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            TextView textView = this.mTitleView;
            textView.setText(charSequence);
            charSequence = this.mTitleView;
            int n10 = charSequence.getVisibility();
            if (n10 != 0) {
                charSequence = this.mTitleView;
                boolean bl2 = false;
                textView = null;
                charSequence.setVisibility(0);
            }
        } else {
            int n11;
            charSequence = this.mTitleView;
            int n12 = charSequence.getVisibility();
            if (n12 != (n11 = 8)) {
                charSequence = this.mTitleView;
                charSequence.setVisibility(n11);
            }
        }
    }

    public boolean showsIcon() {
        return this.mForceShowIcon;
    }
}

