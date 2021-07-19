/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.util.TypedValue
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 */
package com.google.android.material.bottomnavigation;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools$Pool;
import androidx.core.view.ViewCompat;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.R$dimen;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationPresenter;
import java.util.ArrayList;

public class BottomNavigationMenuView
extends ViewGroup
implements MenuView {
    private static final long ACTIVE_ANIMATION_DURATION_MS = 115L;
    private static final int[] CHECKED_STATE_SET;
    private static final int[] DISABLED_STATE_SET;
    private final int activeItemMaxWidth;
    private final int activeItemMinWidth;
    private BottomNavigationItemView[] buttons;
    private final int inactiveItemMaxWidth;
    private final int inactiveItemMinWidth;
    private Drawable itemBackground;
    private int itemBackgroundRes;
    private final int itemHeight;
    private boolean itemHorizontalTranslationEnabled;
    private int itemIconSize;
    private ColorStateList itemIconTint;
    private final Pools$Pool itemPool;
    private int itemTextAppearanceActive;
    private int itemTextAppearanceInactive;
    private final ColorStateList itemTextColorDefault;
    private ColorStateList itemTextColorFromUser;
    private int labelVisibilityMode;
    private MenuBuilder menu;
    private final View.OnClickListener onClickListener;
    private BottomNavigationPresenter presenter;
    private int selectedItemId;
    private int selectedItemPosition;
    private final TransitionSet set;
    private int[] tempChildWidths;

    static {
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = 0x10100A0;
        CHECKED_STATE_SET = nArray;
        int[] nArray2 = new int[n10];
        nArray2[0] = -16842910;
        DISABLED_STATE_SET = nArray2;
    }

    public BottomNavigationMenuView(Context context) {
        this(context, null);
    }

    public BottomNavigationMenuView(Context object, AttributeSet attributeSet) {
        super(object, attributeSet);
        int n10;
        int n11 = 5;
        super(n11);
        this.itemPool = object;
        this.selectedItemId = 0;
        this.selectedItemPosition = 0;
        Object object2 = this.getResources();
        int n12 = R$dimen.design_bottom_navigation_item_max_width;
        this.inactiveItemMaxWidth = n12 = object2.getDimensionPixelSize(n12);
        n12 = R$dimen.design_bottom_navigation_item_min_width;
        this.inactiveItemMinWidth = n12 = object2.getDimensionPixelSize(n12);
        n12 = R$dimen.design_bottom_navigation_active_item_max_width;
        this.activeItemMaxWidth = n12 = object2.getDimensionPixelSize(n12);
        n12 = R$dimen.design_bottom_navigation_active_item_min_width;
        this.activeItemMinWidth = n12 = object2.getDimensionPixelSize(n12);
        n12 = R$dimen.design_bottom_navigation_height;
        this.itemHeight = n10 = object2.getDimensionPixelSize(n12);
        object2 = this.createDefaultColorStateList(16842808);
        this.itemTextColorDefault = object2;
        super();
        this.set = object2;
        ((TransitionSet)object2).setOrdering(0);
        ((TransitionSet)object2).setDuration(115);
        super();
        ((TransitionSet)object2).setInterpolator((TimeInterpolator)object);
        super();
        ((TransitionSet)object2).addTransition((Transition)object);
        super(this);
        this.onClickListener = object;
        object = new int[n11];
        this.tempChildWidths = (int[])object;
    }

    public static /* synthetic */ BottomNavigationPresenter access$000(BottomNavigationMenuView bottomNavigationMenuView) {
        return bottomNavigationMenuView.presenter;
    }

    public static /* synthetic */ MenuBuilder access$100(BottomNavigationMenuView bottomNavigationMenuView) {
        return bottomNavigationMenuView.menu;
    }

    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView bottomNavigationItemView = (BottomNavigationItemView)this.itemPool.acquire();
        if (bottomNavigationItemView == null) {
            Context context = this.getContext();
            bottomNavigationItemView = new BottomNavigationItemView(context);
        }
        return bottomNavigationItemView;
    }

    private boolean isShifting(int n10, int n11) {
        boolean bl2 = true;
        int n12 = -1;
        if (!(n10 == n12 ? n11 > (n10 = 3) : n10 == 0)) {
            bl2 = false;
        }
        return bl2;
    }

    public void buildMenuView() {
        int n10;
        int n11;
        int bl2;
        Object object;
        int n112;
        Object object2;
        int n12;
        this.removeAllViews();
        Object object3 = this.buttons;
        int n13 = 0;
        if (object3 != null) {
            n12 = ((BottomNavigationItemView[])object3).length;
            object2 = null;
            for (n112 = 0; n112 < n12; ++n112) {
                object = object3[n112];
                if (object == null) continue;
                Pools$Pool pools$Pool = this.itemPool;
                pools$Pool.release(object);
            }
        }
        if ((bl2 = ((MenuBuilder)(object3 = this.menu)).size()) == 0) {
            this.selectedItemId = 0;
            this.selectedItemPosition = 0;
            this.buttons = null;
            return;
        }
        object3 = new BottomNavigationItemView[this.menu.size()];
        this.buttons = object3;
        int n14 = this.labelVisibilityMode;
        n12 = this.menu.getVisibleItems().size();
        boolean bl3 = this.isShifting(n14, n12);
        n12 = 0;
        while (true) {
            object2 = this.menu;
            n112 = ((MenuBuilder)object2).size();
            n11 = 1;
            if (n12 >= n112) break;
            this.presenter.setUpdateSuspended(n11 != 0);
            this.menu.getItem(n12).setCheckable(n11 != 0);
            this.presenter.setUpdateSuspended(false);
            this.buttons[n12] = object2 = this.getNewItem();
            object = this.itemIconTint;
            ((BottomNavigationItemView)object2).setIconTintList((ColorStateList)object);
            n11 = this.itemIconSize;
            ((BottomNavigationItemView)object2).setIconSize(n11);
            object = this.itemTextColorDefault;
            ((BottomNavigationItemView)object2).setTextColor((ColorStateList)object);
            n11 = this.itemTextAppearanceInactive;
            ((BottomNavigationItemView)object2).setTextAppearanceInactive(n11);
            n11 = this.itemTextAppearanceActive;
            ((BottomNavigationItemView)object2).setTextAppearanceActive(n11);
            object = this.itemTextColorFromUser;
            ((BottomNavigationItemView)object2).setTextColor((ColorStateList)object);
            object = this.itemBackground;
            if (object != null) {
                ((BottomNavigationItemView)object2).setItemBackground((Drawable)object);
            } else {
                n11 = this.itemBackgroundRes;
                ((BottomNavigationItemView)object2).setItemBackground(n11);
            }
            ((BottomNavigationItemView)object2).setShifting(bl3);
            n11 = this.labelVisibilityMode;
            ((BottomNavigationItemView)object2).setLabelVisibilityMode(n11);
            object = (MenuItemImpl)this.menu.getItem(n12);
            ((BottomNavigationItemView)object2).initialize((MenuItemImpl)object, 0);
            ((BottomNavigationItemView)object2).setItemPosition(n12);
            object = this.onClickListener;
            object2.setOnClickListener((View.OnClickListener)object);
            this.addView((View)object2);
            ++n12;
        }
        int n15 = this.menu.size() - n11;
        n13 = this.selectedItemPosition;
        this.selectedItemPosition = n10 = Math.min(n15, n13);
        this.menu.getItem(n10).setChecked(n11 != 0);
    }

    public ColorStateList createDefaultColorStateList(int n10) {
        int n11;
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = this.getContext().getTheme();
        int n12 = 1;
        n10 = (int)(theme.resolveAttribute(n10, typedValue, n12 != 0) ? 1 : 0);
        int n13 = 0;
        theme = null;
        if (n10 == 0) {
            return null;
        }
        Context context = this.getContext();
        int n14 = typedValue.resourceId;
        context = AppCompatResources.getColorStateList(context, n14);
        Resources.Theme theme2 = this.getContext().getTheme();
        n14 = (int)(theme2.resolveAttribute(n11 = R$attr.colorPrimary, typedValue, n12 != 0) ? 1 : 0);
        if (n14 == 0) {
            return null;
        }
        int n15 = typedValue.data;
        n13 = context.getDefaultColor();
        n11 = 3;
        int[][] nArrayArray = new int[n11][];
        int[] nArray = DISABLED_STATE_SET;
        nArrayArray[0] = nArray;
        int[] nArray2 = CHECKED_STATE_SET;
        nArrayArray[n12] = nArray2;
        nArray2 = ViewGroup.EMPTY_STATE_SET;
        int n16 = 2;
        nArrayArray[n16] = nArray2;
        int[] nArray3 = new int[n11];
        nArray3[0] = n10 = context.getColorForState(nArray, n13);
        nArray3[n12] = n15;
        nArray3[n16] = n13;
        theme2 = new ColorStateList((int[][])nArrayArray, nArray3);
        return theme2;
    }

    public ColorStateList getIconTintList() {
        return this.itemIconTint;
    }

    public Drawable getItemBackground() {
        int n10;
        BottomNavigationItemView[] bottomNavigationItemViewArray = this.buttons;
        if (bottomNavigationItemViewArray != null && (n10 = bottomNavigationItemViewArray.length) > 0) {
            return bottomNavigationItemViewArray[0].getBackground();
        }
        return this.itemBackground;
    }

    public int getItemBackgroundRes() {
        return this.itemBackgroundRes;
    }

    public int getItemIconSize() {
        return this.itemIconSize;
    }

    public int getItemTextAppearanceActive() {
        return this.itemTextAppearanceActive;
    }

    public int getItemTextAppearanceInactive() {
        return this.itemTextAppearanceInactive;
    }

    public ColorStateList getItemTextColor() {
        return this.itemTextColorFromUser;
    }

    public int getLabelVisibilityMode() {
        return this.labelVisibilityMode;
    }

    public int getSelectedItemId() {
        return this.selectedItemId;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void initialize(MenuBuilder menuBuilder) {
        this.menu = menuBuilder;
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.itemHorizontalTranslationEnabled;
    }

    public void onLayout(boolean n10, int n11, int n12, int n13, int n14) {
        n10 = this.getChildCount();
        n13 -= n11;
        n14 -= n12;
        n11 = 0;
        int n15 = 0;
        for (n12 = 0; n12 < n10; ++n12) {
            int n16;
            View view = this.getChildAt(n12);
            int n17 = view.getVisibility();
            if (n17 == (n16 = 8)) continue;
            n17 = ViewCompat.getLayoutDirection((View)this);
            if (n17 == (n16 = 1)) {
                n17 = n13 - n15;
                n16 = view.getMeasuredWidth();
                n16 = n17 - n16;
                view.layout(n16, 0, n17, n14);
            } else {
                n17 = view.getMeasuredWidth() + n15;
                view.layout(n15, 0, n17, n14);
            }
            int n18 = view.getMeasuredWidth();
            n15 += n18;
        }
    }

    public void onMeasure(int n10, int n11) {
        Object object;
        int n12;
        View view;
        n10 = View.MeasureSpec.getSize((int)n10);
        ArrayList arrayList = this.menu.getVisibleItems();
        n11 = arrayList.size();
        int n13 = this.getChildCount();
        int n14 = this.itemHeight;
        int n15 = 0x40000000;
        n14 = View.MeasureSpec.makeMeasureSpec((int)n14, (int)n15);
        int n16 = this.labelVisibilityMode;
        n16 = (int)(this.isShifting(n16, n11) ? 1 : 0);
        int n17 = 8;
        int n18 = 1;
        if (n16 != 0 && (n16 = (int)(this.itemHorizontalTranslationEnabled ? 1 : 0)) != 0) {
            Object object2;
            n16 = this.selectedItemPosition;
            view = this.getChildAt(n16);
            n12 = this.activeItemMinWidth;
            object = view.getVisibility();
            if (object != n17) {
                object = this.activeItemMaxWidth;
                object2 = -1 << -1;
                object = View.MeasureSpec.makeMeasureSpec((int)object, (int)object2);
                view.measure(object, n14);
                object = view.getMeasuredWidth();
                n12 = Math.max(n12, object);
            }
            if ((n16 = view.getVisibility()) != n17) {
                n16 = n18;
            } else {
                n16 = 0;
                view = null;
            }
            n11 -= n16;
            n16 = this.inactiveItemMinWidth * n11;
            n16 = n10 - n16;
            object = this.activeItemMaxWidth;
            n12 = Math.min(n12, object);
            n16 = Math.min(n16, n12);
            n12 = n11 == 0 ? n18 : n11;
            n12 = (n10 -= n16) / n12;
            object = this.inactiveItemMaxWidth;
            n12 = Math.min(n12, object);
            n10 -= (n11 *= n12);
            arrayList = null;
            for (n11 = 0; n11 < n13; ++n11) {
                Object object3 = this.getChildAt(n11);
                object = object3.getVisibility();
                if (object != n17) {
                    object3 = this.tempChildWidths;
                    object2 = this.selectedItemPosition;
                    object2 = n11 == object2 ? n16 : n12;
                    object3[n11] = (View)object2;
                    if (n10 <= 0) continue;
                    object2 = object3[n11] + n18;
                    object3[n11] = (View)object2;
                    n10 += -1;
                    continue;
                }
                object3 = this.tempChildWidths;
                object3[n11] = (View)false;
            }
        } else {
            n16 = n11 == 0 ? n18 : n11;
            n16 = n10 / n16;
            n12 = this.activeItemMaxWidth;
            n16 = Math.min(n16, n12);
            n10 -= (n11 *= n16);
            arrayList = null;
            for (n11 = 0; n11 < n13; ++n11) {
                Object object4 = this.getChildAt(n11);
                n12 = object4.getVisibility();
                if (n12 != n17) {
                    object4 = this.tempChildWidths;
                    object4[n11] = (View)n16;
                    if (n10 <= 0) continue;
                    object = object4[n11] + n18;
                    object4[n11] = (View)object;
                    n10 += -1;
                    continue;
                }
                object4 = this.tempChildWidths;
                object4[n11] = (View)false;
            }
        }
        n11 = 0;
        arrayList = null;
        for (n10 = 0; n10 < n13; ++n10) {
            view = this.getChildAt(n10);
            n18 = view.getVisibility();
            if (n18 == n17) continue;
            n18 = View.MeasureSpec.makeMeasureSpec((int)this.tempChildWidths[n10], (int)n15);
            view.measure(n18, n14);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = n12 = view.getMeasuredWidth();
            n16 = view.getMeasuredWidth();
            n11 += n16;
        }
        n10 = View.MeasureSpec.makeMeasureSpec((int)n11, (int)n15);
        n10 = View.resolveSizeAndState((int)n11, (int)n10, (int)0);
        n11 = View.resolveSizeAndState((int)this.itemHeight, (int)n14, (int)0);
        this.setMeasuredDimension(n10, n11);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.itemIconTint = colorStateList;
        BottomNavigationItemView[] bottomNavigationItemViewArray = this.buttons;
        if (bottomNavigationItemViewArray != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArray) {
                bottomNavigationItemView.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemBackground(Drawable drawable2) {
        this.itemBackground = drawable2;
        BottomNavigationItemView[] bottomNavigationItemViewArray = this.buttons;
        if (bottomNavigationItemViewArray != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArray) {
                bottomNavigationItemView.setItemBackground(drawable2);
            }
        }
    }

    public void setItemBackgroundRes(int n10) {
        this.itemBackgroundRes = n10;
        BottomNavigationItemView[] bottomNavigationItemViewArray = this.buttons;
        if (bottomNavigationItemViewArray != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArray) {
                bottomNavigationItemView.setItemBackground(n10);
            }
        }
    }

    public void setItemHorizontalTranslationEnabled(boolean bl2) {
        this.itemHorizontalTranslationEnabled = bl2;
    }

    public void setItemIconSize(int n10) {
        this.itemIconSize = n10;
        BottomNavigationItemView[] bottomNavigationItemViewArray = this.buttons;
        if (bottomNavigationItemViewArray != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArray) {
                bottomNavigationItemView.setIconSize(n10);
            }
        }
    }

    public void setItemTextAppearanceActive(int n10) {
        this.itemTextAppearanceActive = n10;
        BottomNavigationItemView[] bottomNavigationItemViewArray = this.buttons;
        if (bottomNavigationItemViewArray != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArray) {
                bottomNavigationItemView.setTextAppearanceActive(n10);
                ColorStateList colorStateList = this.itemTextColorFromUser;
                if (colorStateList == null) continue;
                bottomNavigationItemView.setTextColor(colorStateList);
            }
        }
    }

    public void setItemTextAppearanceInactive(int n10) {
        this.itemTextAppearanceInactive = n10;
        BottomNavigationItemView[] bottomNavigationItemViewArray = this.buttons;
        if (bottomNavigationItemViewArray != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArray) {
                bottomNavigationItemView.setTextAppearanceInactive(n10);
                ColorStateList colorStateList = this.itemTextColorFromUser;
                if (colorStateList == null) continue;
                bottomNavigationItemView.setTextColor(colorStateList);
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.itemTextColorFromUser = colorStateList;
        BottomNavigationItemView[] bottomNavigationItemViewArray = this.buttons;
        if (bottomNavigationItemViewArray != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArray) {
                bottomNavigationItemView.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int n10) {
        this.labelVisibilityMode = n10;
    }

    public void setPresenter(BottomNavigationPresenter bottomNavigationPresenter) {
        this.presenter = bottomNavigationPresenter;
    }

    public void tryRestoreSelectedItemId(int n10) {
        MenuBuilder menuBuilder = this.menu;
        int n11 = menuBuilder.size();
        for (int i10 = 0; i10 < n11; ++i10) {
            MenuItem menuItem = this.menu.getItem(i10);
            int n12 = menuItem.getItemId();
            if (n10 != n12) continue;
            this.selectedItemId = n10;
            this.selectedItemPosition = i10;
            n10 = 1;
            menuItem.setChecked(n10 != 0);
            break;
        }
    }

    public void updateMenuView() {
        Object object;
        MenuBuilder menuBuilder = this.menu;
        if (menuBuilder != null && (object = this.buttons) != null) {
            int n10;
            Object object2;
            int n11;
            int n12;
            int n13 = menuBuilder.size();
            if (n13 != (n12 = ((BottomNavigationItemView[])(object = this.buttons)).length)) {
                this.buildMenuView();
                return;
            }
            n12 = this.selectedItemId;
            for (n11 = 0; n11 < n13; ++n11) {
                int n14;
                object2 = this.menu.getItem(n11);
                n10 = object2.isChecked();
                if (n10 == 0) continue;
                this.selectedItemId = n14 = object2.getItemId();
                this.selectedItemPosition = n11;
            }
            n11 = this.selectedItemId;
            if (n12 != n11) {
                object = this.set;
                TransitionManager.beginDelayedTransition(this, (Transition)object);
            }
            n12 = this.labelVisibilityMode;
            n11 = this.menu.getVisibleItems().size();
            n12 = (int)(this.isShifting(n12, n11) ? 1 : 0);
            for (n11 = 0; n11 < n13; ++n11) {
                this.presenter.setUpdateSuspended(true);
                object2 = this.buttons[n11];
                n10 = this.labelVisibilityMode;
                ((BottomNavigationItemView)object2).setLabelVisibilityMode(n10);
                this.buttons[n11].setShifting(n12 != 0);
                object2 = this.buttons[n11];
                MenuItemImpl menuItemImpl = (MenuItemImpl)this.menu.getItem(n11);
                ((BottomNavigationItemView)object2).initialize(menuItemImpl, 0);
                object2 = this.presenter;
                ((BottomNavigationPresenter)object2).setUpdateSuspended(false);
            }
        }
    }
}

