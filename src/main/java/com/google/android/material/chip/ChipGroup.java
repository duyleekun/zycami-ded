/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$OnHierarchyChangeListener
 */
package com.google.android.material.chip;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup$CheckedStateTracker;
import com.google.android.material.chip.ChipGroup$LayoutParams;
import com.google.android.material.chip.ChipGroup$OnCheckedChangeListener;
import com.google.android.material.chip.ChipGroup$PassThroughHierarchyChangeListener;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.ThemeEnforcement;

public class ChipGroup
extends FlowLayout {
    private int checkedId;
    private final ChipGroup$CheckedStateTracker checkedStateTracker;
    private int chipSpacingHorizontal;
    private int chipSpacingVertical;
    private ChipGroup$OnCheckedChangeListener onCheckedChangeListener;
    private ChipGroup$PassThroughHierarchyChangeListener passThroughListener;
    private boolean protectFromCheckedChange;
    private boolean singleSelection;

    public ChipGroup(Context context) {
        this(context, null);
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.chipGroupStyle;
        this(context, attributeSet, n10);
    }

    public ChipGroup(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        int n11;
        Object object2 = new ChipGroup$CheckedStateTracker(this, null);
        this.checkedStateTracker = object2;
        this.passThroughListener = object2 = new ChipGroup$PassThroughHierarchyChangeListener(this, null);
        this.checkedId = n11 = -1;
        this.protectFromCheckedChange = false;
        int[] nArray = R$styleable.ChipGroup;
        int n12 = R$style.Widget_MaterialComponents_ChipGroup;
        int[] nArray2 = new int[]{};
        object = ThemeEnforcement.obtainStyledAttributes(object, attributeSet, nArray, n10, n12, nArray2);
        int n13 = R$styleable.ChipGroup_chipSpacing;
        n13 = object.getDimensionPixelOffset(n13, 0);
        n10 = R$styleable.ChipGroup_chipSpacingHorizontal;
        n10 = object.getDimensionPixelOffset(n10, n13);
        this.setChipSpacingHorizontal(n10);
        n10 = R$styleable.ChipGroup_chipSpacingVertical;
        n13 = object.getDimensionPixelOffset(n10, n13);
        this.setChipSpacingVertical(n13);
        n13 = R$styleable.ChipGroup_singleLine;
        n13 = (int)(object.getBoolean(n13, false) ? 1 : 0);
        this.setSingleLine(n13 != 0);
        n13 = R$styleable.ChipGroup_singleSelection;
        n13 = (int)(object.getBoolean(n13, false) ? 1 : 0);
        this.setSingleSelection(n13 != 0);
        n13 = R$styleable.ChipGroup_checkedChip;
        n13 = object.getResourceId(n13, n11);
        if (n13 != n11) {
            this.checkedId = n13;
        }
        object.recycle();
        object = this.passThroughListener;
        super.setOnHierarchyChangeListener((ViewGroup.OnHierarchyChangeListener)object);
    }

    public static /* synthetic */ boolean access$300(ChipGroup chipGroup) {
        return chipGroup.protectFromCheckedChange;
    }

    public static /* synthetic */ int access$400(ChipGroup chipGroup) {
        return chipGroup.checkedId;
    }

    public static /* synthetic */ boolean access$500(ChipGroup chipGroup) {
        return chipGroup.singleSelection;
    }

    public static /* synthetic */ void access$600(ChipGroup chipGroup, int n10, boolean bl2) {
        chipGroup.setCheckedStateForView(n10, bl2);
    }

    public static /* synthetic */ void access$700(ChipGroup chipGroup, int n10) {
        chipGroup.setCheckedId(n10);
    }

    public static /* synthetic */ ChipGroup$CheckedStateTracker access$800(ChipGroup chipGroup) {
        return chipGroup.checkedStateTracker;
    }

    private void setCheckedId(int n10) {
        boolean bl2;
        this.checkedId = n10;
        ChipGroup$OnCheckedChangeListener chipGroup$OnCheckedChangeListener = this.onCheckedChangeListener;
        if (chipGroup$OnCheckedChangeListener != null && (bl2 = this.singleSelection)) {
            chipGroup$OnCheckedChangeListener.onCheckedChanged(this, n10);
        }
    }

    private void setCheckedStateForView(int n10, boolean bl2) {
        View view = this.findViewById(n10);
        boolean bl3 = view instanceof Chip;
        if (bl3) {
            this.protectFromCheckedChange = bl3 = true;
            ((Chip)view).setChecked(bl2);
            n10 = 0;
            view = null;
            this.protectFromCheckedChange = false;
        }
    }

    public void addView(View view, int n10, ViewGroup.LayoutParams layoutParams) {
        int n11 = view instanceof Chip;
        if (n11 != 0) {
            Object object = view;
            object = (Chip)view;
            int n12 = object.isChecked();
            if (n12 != 0) {
                n12 = this.checkedId;
                int n13 = -1;
                if (n12 != n13 && (n13 = (int)(this.singleSelection ? 1 : 0)) != 0) {
                    n13 = 0;
                    this.setCheckedStateForView(n12, false);
                }
                n11 = object.getId();
                this.setCheckedId(n11);
            }
        }
        super.addView(view, n10, layoutParams);
    }

    public void check(int n10) {
        boolean bl2;
        int n11 = this.checkedId;
        if (n10 == n11) {
            return;
        }
        int n12 = -1;
        if (n11 != n12 && (bl2 = this.singleSelection)) {
            bl2 = false;
            this.setCheckedStateForView(n11, false);
        }
        if (n10 != n12) {
            n11 = 1;
            this.setCheckedStateForView(n10, n11 != 0);
        }
        this.setCheckedId(n10);
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        boolean bl2;
        boolean bl3 = super.checkLayoutParams(layoutParams);
        if (bl3 && (bl2 = layoutParams instanceof ChipGroup$LayoutParams)) {
            bl2 = true;
        } else {
            bl2 = false;
            layoutParams = null;
        }
        return bl2;
    }

    public void clearCheck() {
        int n10;
        this.protectFromCheckedChange = true;
        for (int i10 = 0; i10 < (n10 = this.getChildCount()); ++i10) {
            Object object = this.getChildAt(i10);
            boolean bl2 = object instanceof Chip;
            if (!bl2) continue;
            object = (Chip)object;
            ((Chip)object).setChecked(false);
        }
        this.protectFromCheckedChange = false;
        this.setCheckedId(-1);
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        int n10 = -2;
        ChipGroup$LayoutParams chipGroup$LayoutParams = new ChipGroup$LayoutParams(n10, n10);
        return chipGroup$LayoutParams;
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = this.getContext();
        ChipGroup$LayoutParams chipGroup$LayoutParams = new ChipGroup$LayoutParams(context, attributeSet);
        return chipGroup$LayoutParams;
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        ChipGroup$LayoutParams chipGroup$LayoutParams = new ChipGroup$LayoutParams(layoutParams);
        return chipGroup$LayoutParams;
    }

    public int getCheckedChipId() {
        int n10 = this.singleSelection;
        n10 = n10 != 0 ? this.checkedId : -1;
        return n10;
    }

    public int getChipSpacingHorizontal() {
        return this.chipSpacingHorizontal;
    }

    public int getChipSpacingVertical() {
        return this.chipSpacingVertical;
    }

    public boolean isSingleSelection() {
        return this.singleSelection;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        int n10 = this.checkedId;
        int n11 = -1;
        if (n10 != n11) {
            n11 = 1;
            this.setCheckedStateForView(n10, n11 != 0);
            n10 = this.checkedId;
            this.setCheckedId(n10);
        }
    }

    public void setChipSpacing(int n10) {
        this.setChipSpacingHorizontal(n10);
        this.setChipSpacingVertical(n10);
    }

    public void setChipSpacingHorizontal(int n10) {
        int n11 = this.chipSpacingHorizontal;
        if (n11 != n10) {
            this.chipSpacingHorizontal = n10;
            this.setItemSpacing(n10);
            this.requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int n10) {
        n10 = this.getResources().getDimensionPixelOffset(n10);
        this.setChipSpacingHorizontal(n10);
    }

    public void setChipSpacingResource(int n10) {
        n10 = this.getResources().getDimensionPixelOffset(n10);
        this.setChipSpacing(n10);
    }

    public void setChipSpacingVertical(int n10) {
        int n11 = this.chipSpacingVertical;
        if (n11 != n10) {
            this.chipSpacingVertical = n10;
            this.setLineSpacing(n10);
            this.requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int n10) {
        n10 = this.getResources().getDimensionPixelOffset(n10);
        this.setChipSpacingVertical(n10);
    }

    public void setDividerDrawableHorizontal(Drawable object) {
        object = new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
        throw object;
    }

    public void setDividerDrawableVertical(Drawable object) {
        object = new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
        throw object;
    }

    public void setFlexWrap(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
        throw unsupportedOperationException;
    }

    public void setOnCheckedChangeListener(ChipGroup$OnCheckedChangeListener chipGroup$OnCheckedChangeListener) {
        this.onCheckedChangeListener = chipGroup$OnCheckedChangeListener;
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        ChipGroup$PassThroughHierarchyChangeListener.access$202(this.passThroughListener, onHierarchyChangeListener);
    }

    public void setShowDividerHorizontal(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
        throw unsupportedOperationException;
    }

    public void setShowDividerVertical(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
        throw unsupportedOperationException;
    }

    public void setSingleLine(int n10) {
        n10 = (int)(this.getResources().getBoolean(n10) ? 1 : 0);
        this.setSingleLine(n10 != 0);
    }

    public void setSingleSelection(int n10) {
        n10 = (int)(this.getResources().getBoolean(n10) ? 1 : 0);
        this.setSingleSelection(n10 != 0);
    }

    public void setSingleSelection(boolean bl2) {
        boolean bl3 = this.singleSelection;
        if (bl3 != bl2) {
            this.singleSelection = bl2;
            this.clearCheck();
        }
    }
}

