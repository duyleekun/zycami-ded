/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.ContextThemeWrapper
 *  android.view.Menu
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.accessibility.AccessibilityEvent
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder$Callback;
import androidx.appcompat.view.menu.MenuBuilder$ItemInvoker;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuPresenter$Callback;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView$ActionMenuChildView;
import androidx.appcompat.widget.ActionMenuView$ActionMenuPresenterCallback;
import androidx.appcompat.widget.ActionMenuView$LayoutParams;
import androidx.appcompat.widget.ActionMenuView$MenuBuilderCallback;
import androidx.appcompat.widget.ActionMenuView$OnMenuItemClickListener;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.ViewUtils;

public class ActionMenuView
extends LinearLayoutCompat
implements MenuBuilder$ItemInvoker,
MenuView {
    public static final int GENERATED_ITEM_PADDING = 4;
    public static final int MIN_CELL_SIZE = 56;
    private static final String TAG = "ActionMenuView";
    private MenuPresenter$Callback mActionMenuPresenterCallback;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private MenuBuilder mMenu;
    public MenuBuilder$Callback mMenuBuilderCallback;
    private int mMinCellSize;
    public ActionMenuView$OnMenuItemClickListener mOnMenuItemClickListener;
    private Context mPopupContext;
    private int mPopupTheme;
    private ActionMenuPresenter mPresenter;
    private boolean mReserveOverflow;

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int n10;
        int n11;
        this.setBaselineAligned(false);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.mMinCellSize = n11 = (int)(56.0f * f10);
        this.mGeneratedItemPadding = n10 = (int)(f10 * 4.0f);
        this.mPopupContext = context;
        this.mPopupTheme = 0;
    }

    public static int measureChildForCells(View view, int n10, int n11, int n12, int n13) {
        Object object;
        ActionMenuView$LayoutParams actionMenuView$LayoutParams = (ActionMenuView$LayoutParams)view.getLayoutParams();
        int n14 = View.MeasureSpec.getSize((int)n12) - n13;
        n12 = View.MeasureSpec.getMode((int)n12);
        n12 = View.MeasureSpec.makeMeasureSpec((int)n14, (int)n12);
        n13 = view instanceof ActionMenuItemView;
        if (n13 != 0) {
            object = view;
            object = (ActionMenuItemView)view;
        } else {
            n13 = 0;
            object = null;
        }
        n14 = 1;
        if (object != null && (n13 = (int)(((ActionMenuItemView)object).hasText() ? 1 : 0)) != 0) {
            n13 = n14;
        } else {
            n13 = 0;
            object = null;
        }
        int n15 = 2;
        if (n11 > 0 && (n13 == 0 || n11 >= n15)) {
            n11 = View.MeasureSpec.makeMeasureSpec((int)(n11 * n10), (int)(-1 << -1));
            view.measure(n11, n12);
            n11 = view.getMeasuredWidth();
            int n16 = n11 / n10;
            if ((n11 %= n10) != 0) {
                ++n16;
            }
            if (n13 == 0 || n16 >= n15) {
                n15 = n16;
            }
        } else {
            n15 = 0;
        }
        n11 = (int)(actionMenuView$LayoutParams.isOverflowButton ? 1 : 0);
        if (n11 != 0 || n13 == 0) {
            n14 = 0;
        }
        actionMenuView$LayoutParams.expandable = n14;
        actionMenuView$LayoutParams.cellsUsed = n15;
        n10 = View.MeasureSpec.makeMeasureSpec((int)(n10 * n15), (int)0x40000000);
        view.measure(n10, n12);
        return n15;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void onMeasureExactFormat(int var1_1, int var2_2) {
        block46: {
            var3_3 = this;
            var4_4 = View.MeasureSpec.getMode((int)var2_2);
            var5_5 = View.MeasureSpec.getSize((int)var1_1);
            var6_6 = View.MeasureSpec.getSize((int)var2_2);
            var7_7 = this.getPaddingLeft();
            var8_8 = this.getPaddingRight();
            var7_7 += var8_8;
            var8_8 = this.getPaddingTop();
            var9_9 = this.getPaddingBottom();
            var8_8 += var9_9;
            var10_10 = var2_2;
            var9_9 = ViewGroup.getChildMeasureSpec((int)var2_2, (int)var8_8, (int)-2);
            var5_5 -= var7_7;
            var7_7 = this.mMinCellSize;
            var10_10 = var5_5 / var7_7;
            var11_11 = var5_5 % var7_7;
            var12_12 = 0;
            var13_13 = 0.0f;
            var14_14 = null;
            if (var10_10 == 0) {
                this.setMeasuredDimension(var5_5, 0);
                return;
            }
            var7_7 += (var11_11 /= var10_10);
            var11_11 = this.getChildCount();
            var15_15 = 0;
            var16_16 = null;
            var18_18 = false;
            var19_19 = 0;
            var20_20 = 0;
            var21_21 = 0;
            var22_22 = 0L;
            for (var17_17 = 0; var17_17 < var11_11; ++var17_17) {
                block47: {
                    var24_23 = var3_3.getChildAt(var17_17);
                    var12_12 = var24_23.getVisibility();
                    var25_24 = var6_6;
                    var6_6 = 8;
                    var26_25 = 1.1E-44f;
                    if (var12_12 == var6_6) break block47;
                    var6_6 = var24_23 instanceof ActionMenuItemView;
                    ++var19_19;
                    if (var6_6 != 0) {
                        var12_12 = var3_3.mGeneratedItemPadding;
                        var27_26 = var19_19;
                        var19_19 = 0;
                        var24_23.setPadding(var12_12, 0, var12_12, 0);
                    } else {
                        var27_26 = var19_19;
                        var19_19 = 0;
                    }
                    var14_14 = (ActionMenuView$LayoutParams)var24_23.getLayoutParams();
                    var14_14.expanded = false;
                    var14_14.extraPixels = 0;
                    var14_14.cellsUsed = 0;
                    var14_14.expandable = false;
                    var14_14.leftMargin = 0;
                    var14_14.rightMargin = 0;
                    if (var6_6 == 0) ** GOTO lbl-1000
                    var28_27 /* !! */  = var24_23;
                    var28_27 /* !! */  = (ActionMenuItemView)var24_23;
                    var6_6 = (int)var28_27 /* !! */ .hasText();
                    if (var6_6 != 0) {
                        var6_6 = 1;
                        var26_25 = 1.4E-45f;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var6_6 = 0;
                        var26_25 = 0.0f;
                        var28_27 /* !! */  = null;
                    }
                    var14_14.preventEdgeOffset = var6_6;
                    var6_6 = (int)var14_14.isOverflowButton;
                    if (var6_6 != 0) {
                        var6_6 = 1;
                        var26_25 = 1.4E-45f;
                    } else {
                        var6_6 = var10_10;
                    }
                    var6_6 = ActionMenuView.measureChildForCells(var24_23, var7_7, var6_6, var9_9, var8_8);
                    var20_20 = Math.max(var20_20, var6_6);
                    var19_19 = (int)var14_14.expandable;
                    if (var19_19 != 0) {
                        ++var21_21;
                    }
                    if ((var12_12 = (int)var14_14.isOverflowButton) != 0) {
                        var18_18 = true;
                    }
                    var10_10 -= var6_6;
                    var12_12 = var24_23.getMeasuredHeight();
                    var15_15 = Math.max(var15_15, var12_12);
                    var12_12 = 1;
                    var13_13 = 1.4E-45f;
                    if (var6_6 == var12_12) {
                        var6_6 = var12_12 << var17_17;
                        var29_28 = var15_15;
                        var30_29 = var6_6;
                        var22_22 = var30_29 = var22_22 | var30_29;
                    } else {
                        var29_28 = var15_15;
                    }
                    var19_19 = var27_26;
                }
                var6_6 = var25_24;
                var12_12 = 0;
                var13_13 = 0.0f;
                var14_14 = null;
            }
            var25_24 = var6_6;
            var6_6 = 2;
            var26_25 = 2.8E-45f;
            if (var18_18 && var19_19 == var6_6) {
                var8_8 = 1;
                var32_30 = 1.4E-45f;
            } else {
                var8_8 = 0;
                var32_30 = 0.0f;
                var33_31 = null;
            }
            var12_12 = 0;
            var13_13 = 0.0f;
            var14_14 = null;
            while (var21_21 > 0 && var10_10 > 0) {
                var17_17 = var27_26 = -1 >>> 1;
                var6_6 = 0;
                var26_25 = 0.0f;
                var28_27 /* !! */  = null;
                var24_23 = null;
                var34_32 = 0L;
                for (var29_28 = 0; var29_28 < var11_11; ++var29_28) {
                    var36_33 = var3_3.getChildAt(var29_28).getLayoutParams();
                    var37_34 = var12_12;
                    var38_35 = var13_13;
                    var14_14 = var36_33;
                    var14_14 = (ActionMenuView$LayoutParams)var36_33;
                    var39_36 = var15_15;
                    var15_15 = (int)var14_14.expandable;
                    if (var15_15 != 0) {
                        var12_12 = var14_14.cellsUsed;
                        if (var12_12 < var17_17) {
                            var40_37 = 1L;
                            var34_32 = var40_37 << var29_28;
                            var17_17 = var12_12;
                            var6_6 = 1;
                            var26_25 = 1.4E-45f;
                        } else {
                            var40_37 = 1L;
                            if (var12_12 == var17_17) {
                                var30_29 = var40_37 << var29_28;
                                var30_29 = var34_32 | var30_29;
                                ++var6_6;
                                var34_32 = var30_29;
                            }
                        }
                    }
                    var15_15 = var39_36;
                    var12_12 = var37_34;
                    var13_13 = var38_35;
                }
                var37_34 = var12_12;
                var38_35 = var13_13;
                var39_36 = var15_15;
                var22_22 |= var34_32;
                if (var6_6 > var10_10) {
                    var29_28 = var4_4;
                    var42_38 = var5_5;
                    break block46;
                }
                ++var17_17;
                var26_25 = 0.0f;
                var28_27 /* !! */  = null;
                for (var6_6 = 0; var6_6 < var11_11; ++var6_6) {
                    block49: {
                        block48: {
                            var14_14 = var3_3.getChildAt(var6_6);
                            var16_16 = (ActionMenuView$LayoutParams)var14_14.getLayoutParams();
                            var42_38 = var5_5;
                            var5_5 = 1 << var6_6;
                            var29_28 = var4_4;
                            var43_39 = var5_5;
                            var40_37 = var34_32 & var43_39;
                            var45_40 = 0L;
                            cfr_temp_0 = var40_37 - var45_40;
                            var47_41 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                            if (var47_41 /* !! */  != false) break block48;
                            var12_12 = var16_16.cellsUsed;
                            if (var12_12 == var17_17) {
                                var22_22 |= var43_39;
                            }
                            var48_42 = var8_8;
                            var49_43 = var32_30;
                            break block49;
                        }
                        if (var8_8 == 0 || (var4_4 = (int)var16_16.preventEdgeOffset) == 0) ** GOTO lbl-1000
                        var4_4 = 1;
                        var50_44 = 1.4E-45f;
                        if (var10_10 == var4_4) {
                            var5_5 = var3_3.mGeneratedItemPadding;
                            var4_4 = var5_5 + var7_7;
                            var48_42 = var8_8;
                            var49_43 = var32_30;
                            var8_8 = 0;
                            var32_30 = 0.0f;
                            var33_31 = null;
                            var14_14.setPadding(var4_4, 0, var5_5, 0);
                        } else lbl-1000:
                        // 2 sources

                        {
                            var48_42 = var8_8;
                            var49_43 = var32_30;
                        }
                        var4_4 = var16_16.cellsUsed;
                        var5_5 = 1;
                        var51_45 = 1.4E-45f;
                        var16_16.cellsUsed = var4_4 += var5_5;
                        var16_16.expanded = var5_5;
                        var10_10 += -1;
                    }
                    var4_4 = var29_28;
                    var5_5 = var42_38;
                    var8_8 = var48_42;
                    var32_30 = var49_43;
                }
                var15_15 = var39_36;
                var6_6 = 2;
                var26_25 = 2.8E-45f;
                var12_12 = 1;
                var13_13 = 1.4E-45f;
            }
            var29_28 = var4_4;
            var42_38 = var5_5;
            var37_34 = var12_12;
            var38_35 = var13_13;
            var39_36 = var15_15;
        }
        var4_4 = 1;
        var50_44 = 1.4E-45f;
        if (!var18_18 && var19_19 == var4_4) {
            var5_5 = var4_4;
            var51_45 = var50_44;
        } else {
            var5_5 = 0;
            var51_45 = 0.0f;
            var52_46 /* !! */  = null;
        }
        if (var10_10 > 0 && (var6_6 = (int)((cfr_temp_1 = var22_22 - (var30_29 = 0L)) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1))) != 0 && (var10_10 < (var19_19 -= var4_4) || var5_5 != 0 || var20_20 > var4_4)) {
            var4_4 = Long.bitCount(var22_22);
            var50_44 = var4_4;
            if (var5_5 == 0) {
                var53_47 = var22_22 & 1L;
                var30_29 = 0L;
                var5_5 = (int)(var53_47 == var30_29 ? 0 : (var53_47 < var30_29 ? -1 : 1));
                var6_6 = 0x3F000000;
                var26_25 = 0.5f;
                var19_19 = 0;
                if (var5_5 != 0) {
                    var52_46 /* !! */  = (ActionMenuView$LayoutParams)var3_3.getChildAt(0).getLayoutParams();
                    var5_5 = (int)var52_46 /* !! */ .preventEdgeOffset;
                    if (var5_5 == 0) {
                        var50_44 -= var26_25;
                    }
                }
                var5_5 = var11_11 + -1;
                var32_30 = 1.4E-45f;
                var12_12 = 1 << var5_5;
                var30_29 = var12_12;
                var55_48 = 0L;
                cfr_temp_2 = (var30_29 = var22_22 & var30_29) - var55_48;
                var8_8 = (int)(cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1));
                if (var8_8 != 0) {
                    var52_46 /* !! */  = (ActionMenuView$LayoutParams)var3_3.getChildAt(var5_5).getLayoutParams();
                    var5_5 = (int)var52_46 /* !! */ .preventEdgeOffset;
                    if (var5_5 == 0) {
                        var50_44 -= var26_25;
                    }
                }
            } else {
                var19_19 = 0;
            }
            var51_45 = 0.0f;
            var52_46 /* !! */  = null;
            cfr_temp_3 = var50_44 - 0.0f;
            var5_5 = (int)(cfr_temp_3 == 0.0f ? 0 : (cfr_temp_3 > 0.0f ? 1 : -1));
            if (var5_5 > 0) {
                var51_45 = (float)(var10_10 *= var7_7) / var50_44;
                var4_4 = (int)var51_45;
            } else {
                var4_4 = 0;
                var50_44 = 0.0f;
            }
            var52_46 /* !! */  = null;
            var51_45 = 0.0f;
            var12_12 = var37_34;
            var13_13 = var38_35;
            for (var5_5 = 0; var5_5 < var11_11; ++var5_5) {
                var26_25 = 1.4E-45f;
                var8_8 = 1 << var5_5;
                var55_48 = var8_8;
                var57_49 = 0L;
                cfr_temp_4 = (var55_48 = var22_22 & var55_48) - var57_49;
                var6_6 = (int)(cfr_temp_4 == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1));
                if (var6_6 == 0) {
                    var6_6 = 1;
                    var26_25 = 1.4E-45f;
                    var10_10 = 2;
                    continue;
                }
                var28_27 /* !! */  = var3_3.getChildAt(var5_5);
                var33_31 = (ActionMenuView$LayoutParams)var28_27 /* !! */ .getLayoutParams();
                var6_6 = var28_27 /* !! */  instanceof ActionMenuItemView;
                if (var6_6 != 0) {
                    var33_31.extraPixels = var4_4;
                    var6_6 = 1;
                    var26_25 = 1.4E-45f;
                    var33_31.expanded = var6_6;
                    if (var5_5 == 0 && (var6_6 = (int)var33_31.preventEdgeOffset) == 0) {
                        var6_6 = -var4_4;
                        var10_10 = 2;
                        var33_31.leftMargin = var6_6 /= var10_10;
                    } else {
                        var10_10 = 2;
                    }
                    var6_6 = 1;
                    var26_25 = 1.4E-45f;
                    var12_12 = 1;
                    var13_13 = 1.4E-45f;
                    continue;
                }
                var10_10 = 2;
                var6_6 = (int)var33_31.isOverflowButton;
                if (var6_6 != 0) {
                    var33_31.extraPixels = var4_4;
                    var6_6 = 1;
                    var26_25 = 1.4E-45f;
                    var33_31.expanded = var6_6;
                    var33_31.rightMargin = var12_12 = -var4_4 / var10_10;
                    var12_12 = var6_6;
                    var13_13 = var26_25;
                    continue;
                }
                var6_6 = 1;
                var26_25 = 1.4E-45f;
                if (var5_5 != 0) {
                    var33_31.leftMargin = var15_15 = var4_4 / 2;
                }
                if (var5_5 == (var15_15 = var11_11 + -1)) continue;
                var33_31.rightMargin = var15_15 = var4_4 / 2;
            }
        } else {
            var19_19 = 0;
            var12_12 = var37_34;
            var13_13 = var38_35;
        }
        var4_4 = 0x40000000;
        var50_44 = 2.0f;
        if (var12_12 != 0) {
            var14_14 = null;
            var13_13 = 0.0f;
            for (var12_12 = 0; var12_12 < var11_11; ++var12_12) {
                var52_46 /* !! */  = var3_3.getChildAt(var12_12);
                var28_27 /* !! */  = (ActionMenuView$LayoutParams)var52_46 /* !! */ .getLayoutParams();
                var8_8 = (int)var28_27 /* !! */ .expanded;
                if (var8_8 == 0) continue;
                var8_8 = var28_27 /* !! */ .cellsUsed * var7_7;
                var6_6 = var28_27 /* !! */ .extraPixels;
                var8_8 += var6_6;
                var6_6 = View.MeasureSpec.makeMeasureSpec((int)var8_8, (int)var4_4);
                var52_46 /* !! */ .measure(var6_6, var9_9);
            }
        }
        var6_6 = var29_28 != var4_4 ? var39_36 : var25_24;
        var5_5 = var42_38;
        var3_3.setMeasuredDimension(var42_38, var6_6);
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ActionMenuView$LayoutParams;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.dismissPopupMenus();
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public ActionMenuView$LayoutParams generateDefaultLayoutParams() {
        int n10 = -2;
        ActionMenuView$LayoutParams actionMenuView$LayoutParams = new ActionMenuView$LayoutParams(n10, n10);
        actionMenuView$LayoutParams.gravity = 16;
        return actionMenuView$LayoutParams;
    }

    public ActionMenuView$LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = this.getContext();
        ActionMenuView$LayoutParams actionMenuView$LayoutParams = new ActionMenuView$LayoutParams(context, attributeSet);
        return actionMenuView$LayoutParams;
    }

    public ActionMenuView$LayoutParams generateLayoutParams(ViewGroup.LayoutParams object) {
        if (object != null) {
            ActionMenuView$LayoutParams actionMenuView$LayoutParams;
            boolean bl2 = object instanceof ActionMenuView$LayoutParams;
            if (bl2) {
                object = (ActionMenuView$LayoutParams)((Object)object);
                actionMenuView$LayoutParams = new ActionMenuView$LayoutParams((ActionMenuView$LayoutParams)((Object)object));
            } else {
                actionMenuView$LayoutParams = new ActionMenuView$LayoutParams((ViewGroup.LayoutParams)object);
            }
            int n10 = actionMenuView$LayoutParams.gravity;
            if (n10 <= 0) {
                actionMenuView$LayoutParams.gravity = n10 = 16;
            }
            return actionMenuView$LayoutParams;
        }
        return this.generateDefaultLayoutParams();
    }

    public ActionMenuView$LayoutParams generateOverflowButtonLayoutParams() {
        ActionMenuView$LayoutParams actionMenuView$LayoutParams = this.generateDefaultLayoutParams();
        actionMenuView$LayoutParams.isOverflowButton = true;
        return actionMenuView$LayoutParams;
    }

    public Menu getMenu() {
        Object object = this.mMenu;
        if (object == null) {
            object = this.getContext();
            Object object2 = new MenuBuilder((Context)object);
            this.mMenu = object2;
            ActionMenuView$MenuBuilderCallback actionMenuView$MenuBuilderCallback = new ActionMenuView$MenuBuilderCallback(this);
            ((MenuBuilder)object2).setCallback(actionMenuView$MenuBuilderCallback);
            this.mPresenter = object2 = new ActionMenuPresenter((Context)object);
            boolean bl2 = true;
            ((ActionMenuPresenter)object2).setReserveOverflow(bl2);
            object = this.mPresenter;
            object2 = this.mActionMenuPresenterCallback;
            if (object2 == null) {
                object2 = new ActionMenuView$ActionMenuPresenterCallback();
            }
            ((BaseMenuPresenter)object).setCallback((MenuPresenter$Callback)object2);
            object = this.mMenu;
            object2 = this.mPresenter;
            actionMenuView$MenuBuilderCallback = this.mPopupContext;
            ((MenuBuilder)object).addMenuPresenter((MenuPresenter)object2, (Context)actionMenuView$MenuBuilderCallback);
            object = this.mPresenter;
            ((ActionMenuPresenter)object).setMenuView(this);
        }
        return this.mMenu;
    }

    public Drawable getOverflowIcon() {
        this.getMenu();
        return this.mPresenter.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public boolean hasSupportDividerBeforeChildAt(int n10) {
        int n11 = 0;
        if (n10 == 0) {
            return false;
        }
        int n12 = n10 + -1;
        Object object = this.getChildAt(n12);
        Object object2 = this.getChildAt(n10);
        int n13 = this.getChildCount();
        if (n10 < n13 && (n13 = object instanceof ActionMenuView$ActionMenuChildView) != 0) {
            object = (ActionMenuView$ActionMenuChildView)object;
            n12 = (int)(object.needsDividerAfter() ? 1 : 0);
            n11 = 0 | n12;
        }
        if (n10 > 0 && (n10 = object2 instanceof ActionMenuView$ActionMenuChildView) != 0) {
            object2 = (ActionMenuView$ActionMenuChildView)object2;
            n10 = (int)(object2.needsDividerBefore() ? 1 : 0);
            n11 |= n10;
        }
        return n11 != 0;
    }

    public boolean hideOverflowMenu() {
        boolean bl2;
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null && (bl2 = actionMenuPresenter.hideOverflowMenu())) {
            bl2 = true;
        } else {
            bl2 = false;
            actionMenuPresenter = null;
        }
        return bl2;
    }

    public void initialize(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
    }

    public boolean invokeItem(MenuItemImpl menuItemImpl) {
        return this.mMenu.performItemAction(menuItemImpl, 0);
    }

    public boolean isOverflowMenuShowPending() {
        boolean bl2;
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null && (bl2 = actionMenuPresenter.isOverflowMenuShowPending())) {
            bl2 = true;
        } else {
            bl2 = false;
            actionMenuPresenter = null;
        }
        return bl2;
    }

    public boolean isOverflowMenuShowing() {
        boolean bl2;
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null && (bl2 = actionMenuPresenter.isOverflowMenuShowing())) {
            bl2 = true;
        } else {
            bl2 = false;
            actionMenuPresenter = null;
        }
        return bl2;
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    public void onConfigurationChanged(Configuration object) {
        super.onConfigurationChanged((Configuration)object);
        object = this.mPresenter;
        if (object != null) {
            ((ActionMenuPresenter)object).updateMenuView(false);
            object = this.mPresenter;
            boolean bl2 = ((ActionMenuPresenter)object).isOverflowMenuShowing();
            if (bl2) {
                this.mPresenter.hideOverflowMenu();
                object = this.mPresenter;
                ((ActionMenuPresenter)object).showOverflowMenu();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.dismissPopupMenus();
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        int n14;
        int n15;
        int n16;
        ActionMenuView actionMenuView = this;
        int n17 = this.mFormatItems;
        if (n17 == 0) {
            super.onLayout(bl2, n10, n11, n12, n13);
            return;
        }
        n17 = this.getChildCount();
        int n18 = (n13 - n11) / 2;
        int n19 = this.getDividerWidth();
        int n20 = n12 - n10;
        int n21 = this.getPaddingRight();
        n21 = n20 - n21;
        int n22 = this.getPaddingLeft();
        n21 -= n22;
        n22 = (int)(ViewUtils.isLayoutRtl((View)this) ? 1 : 0);
        int n23 = 0;
        int n24 = 0;
        int n25 = 0;
        while (true) {
            n16 = 8;
            n15 = 1;
            if (n23 >= n17) break;
            View view = actionMenuView.getChildAt(n23);
            int n26 = view.getVisibility();
            if (n26 != n16) {
                ActionMenuView$LayoutParams actionMenuView$LayoutParams = (ActionMenuView$LayoutParams)view.getLayoutParams();
                n26 = (int)(actionMenuView$LayoutParams.isOverflowButton ? 1 : 0);
                if (n26 != 0) {
                    int n27;
                    int n28;
                    n24 = view.getMeasuredWidth();
                    n26 = (int)(actionMenuView.hasSupportDividerBeforeChildAt(n23) ? 1 : 0);
                    if (n26 != 0) {
                        n24 += n19;
                    }
                    n26 = view.getMeasuredHeight();
                    if (n22 != 0) {
                        n28 = this.getPaddingLeft();
                        n16 = actionMenuView$LayoutParams.leftMargin;
                        n28 += n16;
                        n16 = n28 + n24;
                    } else {
                        n28 = this.getWidth();
                        n27 = this.getPaddingRight();
                        n16 = actionMenuView$LayoutParams.rightMargin;
                        n16 = (n28 -= n27) - n16;
                        n28 = n16 - n24;
                    }
                    n27 = n26 / 2;
                    n14 = n18 - n27;
                    view.layout(n28, n14, n16, n26 += n14);
                    n21 -= n24;
                    n24 = n15;
                } else {
                    n14 = view.getMeasuredWidth();
                    n15 = actionMenuView$LayoutParams.leftMargin;
                    n14 += n15;
                    n16 = actionMenuView$LayoutParams.rightMargin;
                    n21 -= (n14 += n16);
                    actionMenuView.hasSupportDividerBeforeChildAt(n23);
                    ++n25;
                }
            }
            ++n23;
        }
        if (n17 == n15 && n24 == 0) {
            View view = actionMenuView.getChildAt(0);
            n19 = view.getMeasuredWidth();
            n21 = view.getMeasuredHeight();
            n20 /= 2;
            n22 = n19 / 2;
            n20 -= n22;
            n22 = n21 / 2;
            view.layout(n20, n18, n19 += n20, n21 += (n18 -= n22));
            return;
        }
        n19 = n24 ^ 1;
        n19 = (n25 -= n19) > 0 ? n21 / n25 : 0;
        n20 = 0;
        View view = null;
        n19 = Math.max(0, n19);
        if (n22 != 0) {
            n21 = this.getWidth();
            n22 = this.getPaddingRight();
            n21 -= n22;
            for (n14 = 0; n14 < n17; ++n14) {
                view = actionMenuView.getChildAt(n14);
                ActionMenuView$LayoutParams actionMenuView$LayoutParams = (ActionMenuView$LayoutParams)view.getLayoutParams();
                n23 = view.getVisibility();
                if (n23 == n16 || (n23 = (int)(actionMenuView$LayoutParams.isOverflowButton ? 1 : 0)) != 0) continue;
                n23 = actionMenuView$LayoutParams.rightMargin;
                n21 -= n23;
                n23 = view.getMeasuredWidth();
                n24 = view.getMeasuredHeight();
                n25 = n24 / 2;
                n25 = n18 - n25;
                n15 = n21 - n23;
                view.layout(n15, n25, n21, n24 += n25);
                n20 = actionMenuView$LayoutParams.leftMargin;
                n23 = n23 + n20 + n19;
                n21 -= n23;
            }
        } else {
            n21 = this.getPaddingLeft();
            for (n14 = 0; n14 < n17; ++n14) {
                view = actionMenuView.getChildAt(n14);
                ActionMenuView$LayoutParams actionMenuView$LayoutParams = (ActionMenuView$LayoutParams)view.getLayoutParams();
                n23 = view.getVisibility();
                if (n23 == n16 || (n23 = (int)(actionMenuView$LayoutParams.isOverflowButton ? 1 : 0)) != 0) continue;
                n23 = actionMenuView$LayoutParams.leftMargin;
                n21 += n23;
                n23 = view.getMeasuredWidth();
                n24 = view.getMeasuredHeight();
                n25 = n24 / 2;
                n25 = n18 - n25;
                n15 = n21 + n23;
                view.layout(n21, n25, n15, n24 += n25);
                n20 = actionMenuView$LayoutParams.rightMargin;
                n23 = n23 + n20 + n19;
                n21 += n23;
            }
        }
    }

    public void onMeasure(int n10, int n11) {
        MenuBuilder menuBuilder;
        int n12 = this.mFormatItems;
        int n13 = View.MeasureSpec.getMode((int)n10);
        int n14 = 1;
        int n15 = 0x40000000;
        if (n13 == n15) {
            n13 = n14;
        } else {
            n13 = 0;
            menuBuilder = null;
        }
        this.mFormatItems = n13;
        if (n12 != n13) {
            this.mFormatItemsWidth = 0;
        }
        n12 = View.MeasureSpec.getSize((int)n10);
        n13 = (int)(this.mFormatItems ? 1 : 0);
        if (n13 != 0 && (menuBuilder = this.mMenu) != null && n12 != (n15 = this.mFormatItemsWidth)) {
            this.mFormatItemsWidth = n12;
            menuBuilder.onItemsChanged(n14 != 0);
        }
        n12 = this.getChildCount();
        n13 = (int)(this.mFormatItems ? 1 : 0);
        if (n13 != 0 && n12 > 0) {
            this.onMeasureExactFormat(n10, n11);
        } else {
            menuBuilder = null;
            for (n13 = 0; n13 < n12; ++n13) {
                ActionMenuView$LayoutParams actionMenuView$LayoutParams = (ActionMenuView$LayoutParams)this.getChildAt(n13).getLayoutParams();
                actionMenuView$LayoutParams.rightMargin = 0;
                actionMenuView$LayoutParams.leftMargin = 0;
            }
            super.onMeasure(n10, n11);
        }
    }

    public MenuBuilder peekMenu() {
        return this.mMenu;
    }

    public void setExpandedActionViewsExclusive(boolean bl2) {
        this.mPresenter.setExpandedActionViewsExclusive(bl2);
    }

    public void setMenuCallbacks(MenuPresenter$Callback menuPresenter$Callback, MenuBuilder$Callback menuBuilder$Callback) {
        this.mActionMenuPresenterCallback = menuPresenter$Callback;
        this.mMenuBuilderCallback = menuBuilder$Callback;
    }

    public void setOnMenuItemClickListener(ActionMenuView$OnMenuItemClickListener actionMenuView$OnMenuItemClickListener) {
        this.mOnMenuItemClickListener = actionMenuView$OnMenuItemClickListener;
    }

    public void setOverflowIcon(Drawable drawable2) {
        this.getMenu();
        this.mPresenter.setOverflowIcon(drawable2);
    }

    public void setOverflowReserved(boolean bl2) {
        this.mReserveOverflow = bl2;
    }

    public void setPopupTheme(int n10) {
        int n11 = this.mPopupTheme;
        if (n11 != n10) {
            this.mPopupTheme = n10;
            if (n10 == 0) {
                Context context;
                this.mPopupContext = context = this.getContext();
            } else {
                Context context = this.getContext();
                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, n10);
                this.mPopupContext = contextThemeWrapper;
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.mPresenter = actionMenuPresenter;
        actionMenuPresenter.setMenuView(this);
    }

    public boolean showOverflowMenu() {
        boolean bl2;
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter != null && (bl2 = actionMenuPresenter.showOverflowMenu())) {
            bl2 = true;
        } else {
            bl2 = false;
            actionMenuPresenter = null;
        }
        return bl2;
    }
}

