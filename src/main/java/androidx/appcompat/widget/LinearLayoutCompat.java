/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.LinearLayoutCompat$LayoutParams;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

public class LinearLayoutCompat
extends ViewGroup {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        float f10;
        int n11;
        int n12;
        boolean bl2;
        this.mBaselineAligned = bl2 = true;
        this.mBaselineAlignedChildIndex = n12 = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = n11 = 0x800033;
        int[] nArray = R$styleable.LinearLayoutCompat;
        TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(context, attributeSet, nArray, n10, 0);
        TypedArray typedArray = tintTypedArray.getWrappedTypeArray();
        ViewCompat.saveAttributeDataForStyleable((View)this, context, nArray, attributeSet, typedArray, n10, 0);
        int n13 = R$styleable.LinearLayoutCompat_android_orientation;
        n13 = tintTypedArray.getInt(n13, n12);
        if (n13 >= 0) {
            this.setOrientation(n13);
        }
        n13 = R$styleable.LinearLayoutCompat_android_gravity;
        if ((n13 = tintTypedArray.getInt(n13, n12)) >= 0) {
            this.setGravity(n13);
        }
        n13 = R$styleable.LinearLayoutCompat_android_baselineAligned;
        if ((n13 = (int)(tintTypedArray.getBoolean(n13, bl2) ? 1 : 0)) == 0) {
            this.setBaselineAligned(n13 != 0);
        }
        n13 = R$styleable.LinearLayoutCompat_android_weightSum;
        this.mWeightSum = f10 = tintTypedArray.getFloat(n13, -1.0f);
        n13 = R$styleable.LinearLayoutCompat_android_baselineAlignedChildIndex;
        this.mBaselineAlignedChildIndex = n13 = tintTypedArray.getInt(n13, n12);
        n13 = R$styleable.LinearLayoutCompat_measureWithLargestChild;
        n13 = tintTypedArray.getBoolean(n13, false) ? 1 : 0;
        this.mUseLargestChild = n13;
        n13 = R$styleable.LinearLayoutCompat_divider;
        context = tintTypedArray.getDrawable(n13);
        this.setDividerDrawable((Drawable)context);
        n13 = R$styleable.LinearLayoutCompat_showDividers;
        this.mShowDividers = n13 = tintTypedArray.getInt(n13, 0);
        n13 = R$styleable.LinearLayoutCompat_dividerPadding;
        this.mDividerPadding = n13 = tintTypedArray.getDimensionPixelSize(n13, 0);
        tintTypedArray.recycle();
    }

    private void forceUniformHeight(int n10, int n11) {
        int n12 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredHeight(), (int)0x40000000);
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object;
            int n13;
            View view = this.getVirtualChildAt(i10);
            int n14 = view.getVisibility();
            if (n14 == (n13 = 8)) continue;
            Object object2 = object = view.getLayoutParams();
            object2 = (LinearLayoutCompat$LayoutParams)((Object)object);
            n14 = object2.height;
            n13 = -1;
            if (n14 != n13) continue;
            int n15 = object2.width;
            object2.width = n14 = view.getMeasuredWidth();
            object = this;
            n13 = n11;
            this.measureChildWithMargins(view, n11, 0, n12, 0);
            object2.width = n15;
        }
    }

    private void forceUniformWidth(int n10, int n11) {
        int n12 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredWidth(), (int)0x40000000);
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object;
            int n13;
            View view = this.getVirtualChildAt(i10);
            int n14 = view.getVisibility();
            if (n14 == (n13 = 8)) continue;
            Object object2 = object = view.getLayoutParams();
            object2 = (LinearLayoutCompat$LayoutParams)((Object)object);
            n14 = object2.width;
            n13 = -1;
            if (n14 != n13) continue;
            int n15 = object2.height;
            object2.height = n14 = view.getMeasuredHeight();
            object = this;
            n13 = n12;
            this.measureChildWithMargins(view, n12, 0, n11, 0);
            object2.height = n15;
        }
    }

    private void setChildFrame(View view, int n10, int n11, int n12, int n13) {
        view.layout(n10, n11, n12 += n10, n13 += n11);
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LinearLayoutCompat$LayoutParams;
    }

    /*
     * Unable to fully structure code
     */
    public void drawDividersHorizontal(Canvas var1_1) {
        block5: {
            block8: {
                block6: {
                    block7: {
                        var2_2 = this.getVirtualChildCount();
                        var3_3 = ViewUtils.isLayoutRtl((View)this);
                        var5_5 = null;
                        for (var4_4 = 0; var4_4 < var2_2; ++var4_4) {
                            var6_6 = this.getVirtualChildAt(var4_4);
                            if (var6_6 == null || (var7_7 = var6_6.getVisibility()) == (var8_8 = 8) || (var7_7 = (int)this.hasDividerBeforeChildAt(var4_4)) == 0) continue;
                            var9_9 = (LinearLayoutCompat$LayoutParams)var6_6.getLayoutParams();
                            if (var3_3 != 0) {
                                var10_10 = var6_6.getRight();
                                var7_7 = var9_9.rightMargin;
                                var10_10 += var7_7;
                            } else {
                                var10_10 = var6_6.getLeft();
                                var7_7 = var9_9.leftMargin;
                                var10_10 -= var7_7;
                                var7_7 = this.mDividerWidth;
                                var10_10 -= var7_7;
                            }
                            this.drawVerticalDivider(var1_1, var10_10);
                        }
                        var4_4 = (int)this.hasDividerBeforeChildAt(var2_2);
                        if (var4_4 == 0) break block5;
                        var11_11 = this.getVirtualChildAt(var2_2 += -1);
                        if (var11_11 != null) break block6;
                        if (var3_3 == 0) break block7;
                        var2_2 = this.getPaddingLeft();
                        break block8;
                    }
                    var2_2 = this.getWidth();
                    var3_3 = this.getPaddingRight();
                    var2_2 -= var3_3;
                    var3_3 = this.mDividerWidth;
                    ** GOTO lbl40
                }
                var5_5 = (LinearLayoutCompat$LayoutParams)var11_11.getLayoutParams();
                if (var3_3 != 0) {
                    var2_2 = var11_11.getLeft();
                    var3_3 = var5_5.leftMargin;
                    var2_2 -= var3_3;
                    var3_3 = this.mDividerWidth;
lbl40:
                    // 2 sources

                    var2_2 -= var3_3;
                } else {
                    var2_2 = var11_11.getRight();
                    var3_3 = var5_5.rightMargin;
                    var2_2 += var3_3;
                }
            }
            this.drawVerticalDivider(var1_1, var2_2);
        }
    }

    public void drawDividersVertical(Canvas canvas) {
        int n10;
        int n11 = this.getVirtualChildCount();
        LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams = null;
        for (n10 = 0; n10 < n11; ++n10) {
            int n12;
            int n13;
            View view = this.getVirtualChildAt(n10);
            if (view == null || (n13 = view.getVisibility()) == (n12 = 8) || (n13 = (int)(this.hasDividerBeforeChildAt(n10) ? 1 : 0)) == 0) continue;
            LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams2 = (LinearLayoutCompat$LayoutParams)view.getLayoutParams();
            int n14 = view.getTop();
            n13 = linearLayoutCompat$LayoutParams2.topMargin;
            n14 -= n13;
            n13 = this.mDividerHeight;
            this.drawHorizontalDivider(canvas, n14 -= n13);
        }
        n10 = this.hasDividerBeforeChildAt(n11) ? 1 : 0;
        if (n10 != 0) {
            View view = this.getVirtualChildAt(n11 += -1);
            if (view == null) {
                n11 = this.getHeight();
                n10 = this.getPaddingBottom();
                n11 -= n10;
                n10 = this.mDividerHeight;
                n11 -= n10;
            } else {
                linearLayoutCompat$LayoutParams = (LinearLayoutCompat$LayoutParams)view.getLayoutParams();
                n11 = view.getBottom();
                n10 = linearLayoutCompat$LayoutParams.bottomMargin;
                n11 += n10;
            }
            this.drawHorizontalDivider(canvas, n11);
        }
    }

    public void drawHorizontalDivider(Canvas canvas, int n10) {
        Drawable drawable2 = this.mDivider;
        int n11 = this.getPaddingLeft();
        int n12 = this.mDividerPadding;
        n11 += n12;
        n12 = this.getWidth();
        int n13 = this.getPaddingRight();
        n12 -= n13;
        n13 = this.mDividerPadding;
        n12 -= n13;
        n13 = this.mDividerHeight + n10;
        drawable2.setBounds(n11, n10, n12, n13);
        this.mDivider.draw(canvas);
    }

    public void drawVerticalDivider(Canvas canvas, int n10) {
        Drawable drawable2 = this.mDivider;
        int n11 = this.getPaddingTop();
        int n12 = this.mDividerPadding;
        n11 += n12;
        n12 = this.mDividerWidth + n10;
        int n13 = this.getHeight();
        int n14 = this.getPaddingBottom();
        n13 -= n14;
        n14 = this.mDividerPadding;
        drawable2.setBounds(n10, n11, n12, n13 -= n14);
        this.mDivider.draw(canvas);
    }

    public LinearLayoutCompat$LayoutParams generateDefaultLayoutParams() {
        int n10 = this.mOrientation;
        int n11 = -2;
        if (n10 == 0) {
            LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams = new LinearLayoutCompat$LayoutParams(n11, n11);
            return linearLayoutCompat$LayoutParams;
        }
        int n12 = 1;
        if (n10 == n12) {
            LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams = new LinearLayoutCompat$LayoutParams(-1, n11);
            return linearLayoutCompat$LayoutParams;
        }
        return null;
    }

    public LinearLayoutCompat$LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = this.getContext();
        LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams = new LinearLayoutCompat$LayoutParams(context, attributeSet);
        return linearLayoutCompat$LayoutParams;
    }

    public LinearLayoutCompat$LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams = new LinearLayoutCompat$LayoutParams(layoutParams);
        return linearLayoutCompat$LayoutParams;
    }

    public int getBaseline() {
        int n10;
        int n11 = this.mBaselineAlignedChildIndex;
        if (n11 < 0) {
            return super.getBaseline();
        }
        n11 = this.getChildCount();
        if (n11 > (n10 = this.mBaselineAlignedChildIndex)) {
            int n12;
            Object object = this.getChildAt(n10);
            if ((n10 = object.getBaseline()) == (n12 = -1)) {
                n11 = this.mBaselineAlignedChildIndex;
                if (n11 == 0) {
                    return n12;
                }
                object = new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
                throw object;
            }
            n12 = this.mBaselineChildTop;
            int n13 = this.mOrientation;
            int n14 = 1;
            if (n13 == n14 && (n13 = this.mGravity & 0x70) != (n14 = 48)) {
                n14 = 16;
                if (n13 != n14) {
                    n14 = 80;
                    if (n13 == n14) {
                        n12 = this.getBottom();
                        n13 = this.getTop();
                        n12 -= n13;
                        n13 = this.getPaddingBottom();
                        n12 -= n13;
                        n13 = this.mTotalLength;
                        n12 -= n13;
                    }
                } else {
                    n13 = this.getBottom();
                    n14 = this.getTop();
                    n13 -= n14;
                    n14 = this.getPaddingTop();
                    n13 -= n14;
                    n14 = this.getPaddingBottom();
                    n13 -= n14;
                    n14 = this.mTotalLength;
                    n13 = (n13 - n14) / 2;
                    n12 += n13;
                }
            }
            n11 = ((LinearLayoutCompat$LayoutParams)object.getLayoutParams()).topMargin;
            return n12 + n11 + n10;
        }
        RuntimeException runtimeException = new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        throw runtimeException;
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    public int getChildrenSkipCount(View view, int n10) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    public int getLocationOffset(View view) {
        return 0;
    }

    public int getNextLocationOffset(View view) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public View getVirtualChildAt(int n10) {
        return this.getChildAt(n10);
    }

    public int getVirtualChildCount() {
        return this.getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    public boolean hasDividerBeforeChildAt(int n10) {
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = this.mShowDividers & n12;
            if (n10 != 0) {
                n11 = n12;
            }
            return n11 != 0;
        }
        int n13 = this.getChildCount();
        if (n10 == n13) {
            n10 = this.mShowDividers & 4;
            if (n10 != 0) {
                n11 = n12;
            }
            return n11 != 0;
        }
        n13 = this.mShowDividers & 2;
        if (n13 != 0) {
            n10 -= n12;
            while (n10 >= 0) {
                int n14;
                View view = this.getChildAt(n10);
                n13 = view.getVisibility();
                if (n13 != (n14 = 8)) {
                    n11 = n12;
                    break;
                }
                n10 += -1;
            }
        }
        return n11 != 0;
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void layoutHorizontal(int var1_1, int var2_2, int var3_3, int var4_4) {
        var5_5 = this;
        var6_6 = ViewUtils.isLayoutRtl((View)this);
        var7_7 = this.getPaddingTop();
        var8_8 = var4_4 - var2_2;
        var9_9 = this.getPaddingBottom();
        var10_10 = var8_8 - var9_9;
        var9_9 = this.getPaddingBottom();
        var11_11 = (var8_8 -= var7_7) - var9_9;
        var12_12 = this.getVirtualChildCount();
        var8_8 = this.mGravity;
        var9_9 = 0x800007 & var8_8;
        var13_13 = var8_8 & 112;
        var14_14 = this.mBaselineAligned;
        var15_15 = this.mMaxAscent;
        var16_16 = this.mMaxDescent;
        var8_8 = ViewCompat.getLayoutDirection((View)this);
        var8_8 = GravityCompat.getAbsoluteGravity(var9_9, var8_8);
        var17_17 = 2;
        var18_18 = 1;
        var19_19 = 1.4E-45f;
        if (var8_8 != var18_18) {
            var9_9 = 5;
            if (var8_8 != var9_9) {
                var8_8 = this.getPaddingLeft();
            } else {
                var8_8 = this.getPaddingLeft() + var3_3 - var1_1;
                var9_9 = this.mTotalLength;
                var8_8 -= var9_9;
            }
        } else {
            var8_8 = this.getPaddingLeft();
            var9_9 = var3_3 - var1_1;
            var20_20 = this.mTotalLength;
            var9_9 = (var9_9 - var20_20) / var17_17;
            var8_8 += var9_9;
        }
        var9_9 = 0;
        if (var6_6 != 0) {
            var21_21 = var6_6 = var12_12 + -1;
            var22_22 = -1;
        } else {
            var21_21 = 0;
            var22_22 = var18_18;
        }
        for (var20_20 = 0; var20_20 < var12_12; ++var20_20) {
            block12: {
                block13: {
                    block20: {
                        block17: {
                            block18: {
                                block19: {
                                    block16: {
                                        block15: {
                                            block14: {
                                                block11: {
                                                    var6_6 = var22_22 * var20_20;
                                                    var9_9 = var21_21 + var6_6;
                                                    var23_23 /* !! */  = var5_5.getVirtualChildAt(var9_9);
                                                    if (var23_23 /* !! */  != null) break block11;
                                                    var6_6 = var5_5.measureNullChild(var9_9);
                                                    var8_8 += var6_6;
                                                    var24_24 = var18_18;
                                                    var25_25 = var19_19;
                                                    var26_26 = var7_7;
                                                    var27_27 = var12_12;
                                                    var28_28 = var13_13;
                                                    break block12;
                                                }
                                                var18_18 = var23_23 /* !! */ .getVisibility();
                                                if (var18_18 == (var17_17 = 8)) break block13;
                                                var17_17 = var23_23 /* !! */ .getMeasuredWidth();
                                                var18_18 = var23_23 /* !! */ .getMeasuredHeight();
                                                var30_30 /* !! */  = var29_29 = var23_23 /* !! */ .getLayoutParams();
                                                var30_30 /* !! */  = (LinearLayoutCompat$LayoutParams)var29_29;
                                                var31_31 = var20_20;
                                                if (!var14_14) break block14;
                                                var20_20 = var30_30 /* !! */ .height;
                                                var27_27 = var12_12;
                                                var12_12 = -1;
                                                if (var20_20 == var12_12) break block15;
                                                var12_12 = var23_23 /* !! */ .getBaseline();
                                                break block16;
                                            }
                                            var27_27 = var12_12;
                                        }
                                        var12_12 = -1;
                                    }
                                    var20_20 = var30_30 /* !! */ .gravity;
                                    if (var20_20 < 0) {
                                        var20_20 = var13_13;
                                    }
                                    var28_28 = var13_13;
                                    var13_13 = 16;
                                    if ((var20_20 &= 112) == var13_13) break block17;
                                    var13_13 = 48;
                                    if (var20_20 == var13_13) break block18;
                                    var13_13 = 80;
                                    if (var20_20 == var13_13) break block19;
                                    var20_20 = var7_7;
                                    var13_13 = -1;
                                    ** GOTO lbl-1000
                                }
                                var20_20 = var10_10 - var18_18;
                                var13_13 = var30_30 /* !! */ .bottomMargin;
                                var20_20 -= var13_13;
                                var13_13 = -1;
                                if (var12_12 == var13_13) ** GOTO lbl-1000
                                var24_24 = var23_23 /* !! */ .getMeasuredHeight() - var12_12;
                                var12_12 = 2;
                                var26_26 = var16_16[var12_12] - var24_24;
                                var20_20 -= var26_26;
                                ** GOTO lbl-1000
                            }
                            var13_13 = -1;
                            var20_20 = var30_30 /* !! */ .topMargin + var7_7;
                            if (var12_12 != var13_13) {
                                var24_24 = 1;
                                var25_25 = 1.4E-45f;
                                var26_26 = var15_15[var24_24] - var12_12;
                                var20_20 += var26_26;
                            } else lbl-1000:
                            // 4 sources

                            {
                                var24_24 = 1;
                                var25_25 = 1.4E-45f;
                            }
                            break block20;
                        }
                        var13_13 = -1;
                        var24_24 = 1;
                        var25_25 = 1.4E-45f;
                        var20_20 = (var11_11 - var18_18) / 2 + var7_7;
                        var12_12 = var30_30 /* !! */ .topMargin;
                        var20_20 += var12_12;
                        var12_12 = var30_30 /* !! */ .bottomMargin;
                        var20_20 -= var12_12;
                    }
                    var12_12 = (int)var5_5.hasDividerBeforeChildAt(var9_9);
                    if (var12_12 != 0) {
                        var12_12 = var5_5.mDividerWidth;
                        var8_8 += var12_12;
                    }
                    var12_12 = var30_30 /* !! */ .leftMargin + var8_8;
                    var8_8 = var5_5.getLocationOffset(var23_23 /* !! */ );
                    var26_26 = var12_12 + var8_8;
                    var32_32 = var23_23 /* !! */ ;
                    var23_23 /* !! */  = this;
                    var13_13 = var9_9;
                    var9_9 = var26_26;
                    var26_26 = var7_7;
                    this.setChildFrame(var32_32, var9_9, var20_20, var17_17, var18_18);
                    var6_6 = var30_30 /* !! */ .rightMargin;
                    var17_17 += var6_6;
                    var23_23 /* !! */  = var32_32;
                    var8_8 = var5_5.getNextLocationOffset(var32_32);
                    var12_12 += (var17_17 += var8_8);
                    var6_6 = var5_5.getChildrenSkipCount(var32_32, var13_13);
                    var20_20 = var31_31 + var6_6;
                    var8_8 = var12_12;
                    break block12;
                }
                var31_31 = var20_20;
                var26_26 = var7_7;
                var27_27 = var12_12;
                var28_28 = var13_13;
                var24_24 = 1;
                var25_25 = 1.4E-45f;
            }
            var12_12 = var27_27;
            var13_13 = var28_28;
            var18_18 = var24_24;
            var19_19 = var25_25;
            var7_7 = var26_26;
            var17_17 = 2;
        }
    }

    public void layoutVertical(int n10, int n11, int n12, int n13) {
        LinearLayoutCompat linearLayoutCompat = this;
        int n14 = this.getPaddingLeft();
        int n15 = n12 - n10;
        int n16 = this.getPaddingRight();
        int n17 = n15 - n16;
        n16 = this.getPaddingRight();
        int n18 = (n15 -= n14) - n16;
        int n19 = this.getVirtualChildCount();
        n15 = this.mGravity;
        n16 = n15 & 0x70;
        int n20 = 0x800007;
        int n21 = n15 & n20;
        n15 = 16;
        if (n16 != n15) {
            n15 = 80;
            if (n16 != n15) {
                n15 = this.getPaddingTop();
            } else {
                n15 = this.getPaddingTop() + n13 - n11;
                n16 = this.mTotalLength;
                n15 -= n16;
            }
        } else {
            n15 = this.getPaddingTop();
            n16 = n13 - n11;
            n20 = this.mTotalLength;
            n16 = (n16 - n20) / 2;
            n15 += n16;
        }
        n16 = 0;
        ViewGroup.LayoutParams layoutParams = null;
        for (int i10 = 0; i10 < n19; i10 += n16) {
            int n22;
            block8: {
                Object object;
                int n23;
                int n24;
                View view;
                block11: {
                    block12: {
                        block9: {
                            block10: {
                                block7: {
                                    view = linearLayoutCompat.getVirtualChildAt(i10);
                                    n22 = 1;
                                    if (view != null) break block7;
                                    n16 = linearLayoutCompat.measureNullChild(i10);
                                    n15 += n16;
                                    break block8;
                                }
                                n16 = view.getVisibility();
                                if (n16 == (n20 = 8)) break block8;
                                n24 = view.getMeasuredWidth();
                                n23 = view.getMeasuredHeight();
                                object = layoutParams = view.getLayoutParams();
                                object = (LinearLayoutCompat$LayoutParams)layoutParams;
                                n16 = object.gravity;
                                if (n16 < 0) {
                                    n16 = n21;
                                }
                                if ((n16 = GravityCompat.getAbsoluteGravity(n16, n20 = ViewCompat.getLayoutDirection((View)this)) & 7) == n22) break block9;
                                n20 = 5;
                                if (n16 == n20) break block10;
                                n16 = object.leftMargin + n14;
                                break block11;
                            }
                            n16 = n17 - n24;
                            n20 = object.rightMargin;
                            break block12;
                        }
                        n16 = (n18 - n24) / 2 + n14;
                        n20 = object.leftMargin;
                        n16 += n20;
                        n20 = object.rightMargin;
                    }
                    n16 -= n20;
                }
                n20 = n16;
                n16 = linearLayoutCompat.hasDividerBeforeChildAt(i10) ? 1 : 0;
                if (n16 != 0) {
                    n16 = linearLayoutCompat.mDividerHeight;
                    n15 += n16;
                }
                n16 = object.topMargin;
                int n25 = n15 + n16;
                n15 = linearLayoutCompat.getLocationOffset(view);
                int n26 = n25 + n15;
                layoutParams = view;
                this.setChildFrame(view, n20, n26, n24, n23);
                n15 = object.bottomMargin;
                n23 += n15;
                n15 = linearLayoutCompat.getNextLocationOffset(view);
                n25 += (n23 += n15);
                n15 = linearLayoutCompat.getChildrenSkipCount(view, i10);
                i10 += n15;
                n15 = n25;
                n16 = 1;
                continue;
            }
            n16 = n22;
        }
    }

    public void measureChildBeforeLayout(View view, int n10, int n11, int n12, int n13, int n14) {
        this.measureChildWithMargins(view, n11, n12, n13, n14);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void measureHorizontal(int var1_1, int var2_2) {
        block73: {
            block72: {
                block61: {
                    block60: {
                        block58: {
                            var3_3 = this;
                            var4_4 = var1_1;
                            var5_5 = var2_2;
                            var6_6 = 0;
                            var7_7 /* !! */  = null;
                            this.mTotalLength = 0;
                            var8_8 = this.getVirtualChildCount();
                            var9_9 = View.MeasureSpec.getMode((int)var1_1);
                            var10_10 = View.MeasureSpec.getMode((int)var2_2);
                            var11_11 /* !! */  = this.mMaxAscent;
                            var12_12 = 4;
                            if (var11_11 /* !! */  == null || (var11_11 /* !! */  = this.mMaxDescent) == null) {
                                var3_3.mMaxAscent = var11_11 /* !! */  = new int[var12_12];
                                var11_11 /* !! */  = new int[var12_12];
                                var3_3.mMaxDescent = var11_11 /* !! */ ;
                            }
                            var13_13 = var3_3.mMaxAscent;
                            var14_14 /* !! */  = var3_3.mMaxDescent;
                            var15_15 = 3;
                            var16_16 = -1;
                            var17_17 = 0.0f / 0.0f;
                            var13_13[var15_15] = var16_16;
                            var18_18 = 2;
                            var13_13[var18_18] = var16_16;
                            var19_19 = 1;
                            var20_20 = 1.4E-45f;
                            var13_13[var19_19] = var16_16;
                            var13_13[0] = var16_16;
                            var14_14 /* !! */ [var15_15] = var16_16;
                            var14_14 /* !! */ [var18_18] = var16_16;
                            var14_14 /* !! */ [var19_19] = var16_16;
                            var14_14 /* !! */ [0] = var16_16;
                            var21_21 = var3_3.mBaselineAligned;
                            var22_22 = var3_3.mUseLargestChild;
                            var23_23 = 0x40000000;
                            var24_24 = 2.0f;
                            var25_25 = var9_9 == var23_23 ? var19_19 : 0;
                            var26_26 = 0;
                            var27_27 /* !! */  = null;
                            var28_28 = 0.0f;
                            var12_12 = 0;
                            var29_29 = null;
                            var30_30 = 0;
                            var31_31 = 0;
                            var32_32 = 0;
                            var33_33 = 0.0f;
                            var34_34 = 0;
                            var35_35 = 0;
                            var36_36 = 0;
                            var37_37 = var19_19;
                            var38_38 = 0;
                            var11_11 /* !! */  = null;
                            var39_39 = 0.0f;
                            while (true) {
                                block53: {
                                    block57: {
                                        block56: {
                                            block54: {
                                                block55: {
                                                    var40_40 = var14_14 /* !! */ ;
                                                    var16_16 = 8;
                                                    var17_17 = 1.1E-44f;
                                                    if (var26_26 >= var8_8) break;
                                                    var14_14 /* !! */  = (int[])var3_3.getVirtualChildAt(var26_26);
                                                    if (var14_14 /* !! */  == null) {
                                                        var16_16 = var3_3.mTotalLength;
                                                        var41_41 = var3_3.measureNullChild(var26_26);
                                                        var3_3.mTotalLength = var16_16 += var41_41;
lbl63:
                                                        // 2 sources

                                                        while (true) {
                                                            var42_42 = var22_22;
                                                            var43_43 = var21_21;
                                                            var44_44 = var23_23;
                                                            var23_23 = var26_26;
                                                            var26_26 = var44_44;
                                                            var28_28 = var24_24;
                                                            break block53;
                                                            break;
                                                        }
                                                    }
                                                    var6_6 = var14_14 /* !! */ .getVisibility();
                                                    if (var6_6 == var16_16) {
                                                        var16_16 = var3_3.getChildrenSkipCount((View)var14_14 /* !! */ , var26_26);
                                                        var26_26 += var16_16;
                                                        ** continue;
                                                    }
                                                    var16_16 = (int)var3_3.hasDividerBeforeChildAt(var26_26);
                                                    if (var16_16 != 0) {
                                                        var16_16 = var3_3.mTotalLength;
                                                        var6_6 = var3_3.mDividerWidth;
                                                        var3_3.mTotalLength = var16_16 += var6_6;
                                                    }
                                                    var7_7 /* !! */  = var45_45 /* !! */  = var14_14 /* !! */ .getLayoutParams();
                                                    var7_7 /* !! */  = (LinearLayoutCompat$LayoutParams)var45_45 /* !! */ ;
                                                    var17_17 = var7_7 /* !! */ .weight;
                                                    var46_46 = var39_39 + var17_17;
                                                    if (var9_9 != var23_23 || (var38_38 = var7_7 /* !! */ .width) != 0 || (var38_38 = (int)((cfr_temp_0 = var17_17 - 0.0f) == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1))) <= 0) break block54;
                                                    if (var25_25 != 0) {
                                                        var38_38 = var3_3.mTotalLength;
                                                        var16_16 = var7_7 /* !! */ .leftMargin;
                                                        var23_23 = var7_7 /* !! */ .rightMargin;
                                                        var3_3.mTotalLength = var38_38 += (var16_16 += var23_23);
                                                    } else {
                                                        var38_38 = var3_3.mTotalLength;
                                                        var23_23 = var7_7 /* !! */ .leftMargin + var38_38;
                                                        var16_16 = var7_7 /* !! */ .rightMargin;
                                                        var3_3.mTotalLength = var38_38 = Math.max(var38_38, var23_23 += var16_16);
                                                    }
                                                    if (var21_21 == 0) break block55;
                                                    var38_38 = 0;
                                                    var39_39 = 0.0f;
                                                    var11_11 /* !! */  = null;
                                                    var23_23 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
                                                    var14_14 /* !! */ .measure(var23_23, var23_23);
                                                    var47_47 = var26_26;
                                                    var42_42 = var22_22;
                                                    var43_43 = var21_21;
                                                    var48_48 /* !! */  = var14_14 /* !! */ ;
                                                    break block56;
                                                }
                                                var47_47 = var26_26;
                                                var42_42 = var22_22;
                                                var43_43 = var21_21;
                                                var48_48 /* !! */  = var14_14 /* !! */ ;
                                                var34_34 = var19_19;
                                                var26_26 = 0x40000000;
                                                var28_28 = 2.0f;
                                                break block57;
                                            }
                                            var38_38 = var7_7 /* !! */ .width;
                                            if (var38_38 == 0 && (var38_38 = (int)((cfr_temp_1 = var17_17 - 0.0f) == 0.0f ? 0 : (cfr_temp_1 > 0.0f ? 1 : -1))) > 0) {
                                                var16_16 = -2;
                                                var17_17 = 0.0f / 0.0f;
                                                var7_7 /* !! */ .width = var16_16;
                                                var23_23 = 0;
                                                var24_24 = 0.0f;
                                                var49_49 = null;
                                            } else {
                                                var16_16 = -2;
                                                var17_17 = 0.0f / 0.0f;
                                                var23_23 = -1 << -1;
                                                var24_24 = -0.0f;
                                            }
                                            var38_38 = (cfr_temp_2 = var46_46 - 0.0f) == 0.0f ? 0 : (cfr_temp_2 > 0.0f ? 1 : -1);
                                            if (var38_38 == 0) {
                                                var50_50 = var38_38 = var3_3.mTotalLength;
                                            } else {
                                                var50_50 = 0;
                                                var51_51 /* !! */  = null;
                                            }
                                            var11_11 /* !! */  = (int[])this;
                                            var47_47 = var26_26;
                                            var27_27 /* !! */  = var14_14 /* !! */ ;
                                            var52_52 = var23_23;
                                            var23_23 = var26_26;
                                            var42_42 = var22_22;
                                            var22_22 = var1_1;
                                            var43_43 = var21_21;
                                            var21_21 = var50_50;
                                            var50_50 = var16_16;
                                            var16_16 = var2_2;
                                            var5_5 = -1 << -1;
                                            var51_51 /* !! */  = var14_14 /* !! */ ;
                                            var41_41 = 0;
                                            var14_14 /* !! */  = null;
                                            this.measureChildBeforeLayout((View)var27_27 /* !! */ , var26_26, var1_1, var21_21, var2_2, 0);
                                            var38_38 = var52_52;
                                            var39_39 = var24_24;
                                            if (var52_52 != var5_5) {
                                                var7_7 /* !! */ .width = var52_52;
                                            }
                                            var38_38 = var51_51 /* !! */ .getMeasuredWidth();
                                            if (var25_25 != 0) {
                                                var26_26 = var3_3.mTotalLength;
                                                var23_23 = var7_7 /* !! */ .leftMargin + var38_38;
                                                var22_22 = var7_7 /* !! */ .rightMargin;
                                                var23_23 += var22_22;
                                                var48_48 /* !! */  = var51_51 /* !! */ ;
                                                var21_21 = var3_3.getNextLocationOffset((View)var51_51 /* !! */ );
                                                var3_3.mTotalLength = var26_26 += (var23_23 += var21_21);
                                            } else {
                                                var48_48 /* !! */  = var51_51 /* !! */ ;
                                                var26_26 = var3_3.mTotalLength;
                                                var23_23 = var26_26 + var38_38;
                                                var21_21 = var7_7 /* !! */ .leftMargin;
                                                var23_23 += var21_21;
                                                var21_21 = var7_7 /* !! */ .rightMargin;
                                                var23_23 += var21_21;
                                                var21_21 = var3_3.getNextLocationOffset((View)var51_51 /* !! */ );
                                                var3_3.mTotalLength = var26_26 = Math.max(var26_26, var23_23 += var21_21);
                                            }
                                            if (var42_42 != 0) {
                                                var12_12 = Math.max(var38_38, var12_12);
                                            }
                                        }
                                        var26_26 = 0x40000000;
                                        var28_28 = 2.0f;
                                    }
                                    if (var10_10 == var26_26) ** GOTO lbl-1000
                                    var38_38 = var7_7 /* !! */ .height;
                                    var23_23 = -1;
                                    var24_24 = 0.0f / 0.0f;
                                    if (var38_38 == var23_23) {
                                        var38_38 = var19_19;
                                        var39_39 = var20_20;
                                        var36_36 = var19_19;
                                    } else lbl-1000:
                                    // 2 sources

                                    {
                                        var38_38 = 0;
                                        var39_39 = 0.0f;
                                        var11_11 /* !! */  = null;
                                    }
                                    var23_23 = var7_7 /* !! */ .topMargin;
                                    var21_21 = var7_7 /* !! */ .bottomMargin;
                                    var23_23 += var21_21;
                                    var21_21 = var48_48 /* !! */ .getMeasuredHeight() + var23_23;
                                    var16_16 = var48_48 /* !! */ .getMeasuredState();
                                    var41_41 = var35_35;
                                    var35_35 = View.combineMeasuredStates((int)var35_35, (int)var16_16);
                                    if (var43_43 != 0 && (var16_16 = var48_48 /* !! */ .getBaseline()) != (var41_41 = -1)) {
                                        var41_41 = var7_7 /* !! */ .gravity;
                                        if (var41_41 < 0) {
                                            var41_41 = var3_3.mGravity;
                                        }
                                        var41_41 = ((var41_41 & 112) >> 4 & -2) >> 1;
                                        var13_13[var41_41] = var5_5 = Math.max(var13_13[var41_41], var16_16);
                                        var5_5 = var40_40[var41_41];
                                        var16_16 = var21_21 - var16_16;
                                        var40_40[var41_41] = var16_16 = Math.max(var5_5, var16_16);
                                    }
                                    var16_16 = var30_30;
                                    var30_30 = Math.max(var30_30, var21_21);
                                    var37_37 = var37_37 != 0 && (var16_16 = var7_7 /* !! */ .height) == (var41_41 = -1) ? var19_19 : 0;
                                    var17_17 = var7_7 /* !! */ .weight;
                                    cfr_temp_3 = var17_17 - 0.0f;
                                    var16_16 = cfr_temp_3 == 0.0f ? 0 : (cfr_temp_3 > 0.0f ? 1 : -1);
                                    if (var16_16 > 0) {
                                        if (var38_38 == 0) {
                                            var23_23 = var21_21;
                                        }
                                        var6_6 = var32_32;
                                        var32_32 = Math.max(var32_32, var23_23);
                                    } else {
                                        var6_6 = var32_32;
                                        if (var38_38 == 0) {
                                            var23_23 = var21_21;
                                        }
                                        var21_21 = var31_31;
                                        var31_31 = Math.max(var31_31, var23_23);
                                        var32_32 = var6_6;
                                    }
                                    var6_6 = var47_47;
                                    var23_23 = var38_38 = var3_3.getChildrenSkipCount((View)var48_48 /* !! */ , var47_47) + var47_47;
                                    var39_39 = var46_46;
                                }
                                var5_5 = var2_2;
                                var14_14 /* !! */  = var40_40;
                                var22_22 = var42_42;
                                var21_21 = var43_43;
                                var16_16 = -1;
                                var17_17 = 0.0f / 0.0f;
                                var6_6 = 0;
                                var7_7 /* !! */  = null;
                                var44_44 = ++var23_23;
                                var23_23 = var26_26;
                                var24_24 = var28_28;
                                var26_26 = var44_44;
                            }
                            var26_26 = var23_23;
                            var28_28 = var24_24;
                            var42_42 = var22_22;
                            var43_43 = var21_21;
                            var23_23 = var30_30;
                            var21_21 = var31_31;
                            var6_6 = var32_32;
                            var41_41 = var35_35;
                            var5_5 = -1 << -1;
                            var22_22 = var3_3.mTotalLength;
                            if (var22_22 > 0 && (var22_22 = (int)var3_3.hasDividerBeforeChildAt(var8_8)) != 0) {
                                var22_22 = var3_3.mTotalLength;
                                var26_26 = var3_3.mDividerWidth;
                                var3_3.mTotalLength = var22_22 += var26_26;
                            }
                            var26_26 = var13_13[var19_19];
                            var22_22 = -1;
                            var53_53 = 0.0f / 0.0f;
                            if (var26_26 != var22_22) ** GOTO lbl-1000
                            var26_26 = 0;
                            var28_28 = 0.0f;
                            var27_27 /* !! */  = null;
                            var16_16 = var13_13[0];
                            if (var16_16 == var22_22 && (var26_26 = var13_13[var18_18]) == var22_22 && (var26_26 = var13_13[var15_15]) == var22_22) {
                                var26_26 = var23_23;
                                var32_32 = var41_41;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var26_26 = var13_13[var15_15];
                                var53_53 = 0.0f;
                                var48_48 /* !! */  = null;
                                var16_16 = var13_13[0];
                                var5_5 = var13_13[var19_19];
                                var22_22 = var13_13[var18_18];
                                var22_22 = Math.max(var5_5, var22_22);
                                var22_22 = Math.max(var16_16, var22_22);
                                var26_26 = Math.max(var26_26, var22_22);
                                var22_22 = var40_40[var15_15];
                                var17_17 = 0.0f;
                                var45_45 /* !! */  = null;
                                var5_5 = var40_40[0];
                                var16_16 = var40_40[var19_19];
                                var32_32 = var41_41;
                                var41_41 = var40_40[var18_18];
                                var16_16 = Math.max(var16_16, var41_41);
                                var16_16 = Math.max(var5_5, var16_16);
                                var22_22 = Math.max(var22_22, var16_16);
                                var26_26 += var22_22;
                                var26_26 = Math.max(var23_23, var26_26);
                            }
                            if (var42_42 == 0) break block58;
                            var23_23 = -1 << -1;
                            var24_24 = -0.0f;
                            if (var9_9 != var23_23 && var9_9 != 0) break block58;
                            var3_3.mTotalLength = 0;
                            var24_24 = 0.0f;
                            var49_49 = null;
                            for (var23_23 = 0; var23_23 < var8_8; ++var23_23) {
                                block59: {
                                    var48_48 /* !! */  = (int[])var3_3.getVirtualChildAt(var23_23);
                                    if (var48_48 /* !! */  != null) break block59;
                                    var22_22 = var3_3.mTotalLength;
                                    var16_16 = var3_3.measureNullChild(var23_23);
                                    var3_3.mTotalLength = var22_22 += var16_16;
                                    ** GOTO lbl310
                                }
                                var16_16 = var48_48 /* !! */ .getVisibility();
                                if (var16_16 == (var41_41 = 8)) {
                                    var22_22 = var3_3.getChildrenSkipCount((View)var48_48 /* !! */ , var23_23);
                                    var23_23 += var22_22;
lbl310:
                                    // 3 sources

                                    while (true) {
                                        var31_31 = var26_26;
                                        break;
                                    }
                                } else {
                                    var45_45 /* !! */  = (LinearLayoutCompat$LayoutParams)var48_48 /* !! */ .getLayoutParams();
                                    if (var25_25 != 0) {
                                        var41_41 = var3_3.mTotalLength;
                                        var5_5 = var45_45 /* !! */ .leftMargin + var12_12;
                                        var16_16 = var45_45 /* !! */ .rightMargin;
                                        var5_5 += var16_16;
                                        var22_22 = var3_3.getNextLocationOffset((View)var48_48 /* !! */ );
                                        var3_3.mTotalLength = var41_41 += (var5_5 += var22_22);
                                        ** continue;
                                    }
                                    var41_41 = var3_3.mTotalLength;
                                    var5_5 = var41_41 + var12_12;
                                    var31_31 = var26_26;
                                    var26_26 = var45_45 /* !! */ .leftMargin;
                                    var5_5 += var26_26;
                                    var26_26 = var45_45 /* !! */ .rightMargin;
                                    var5_5 += var26_26;
                                    var26_26 = var3_3.getNextLocationOffset((View)var48_48 /* !! */ );
                                    var5_5 += var26_26;
                                    var3_3.mTotalLength = var26_26 = Math.max(var41_41, var5_5);
                                }
                                var26_26 = var31_31;
                            }
                        }
                        var31_31 = var26_26;
                        var26_26 = var3_3.mTotalLength;
                        var23_23 = this.getPaddingLeft();
                        var22_22 = this.getPaddingRight();
                        var3_3.mTotalLength = var26_26 += (var23_23 += var22_22);
                        var23_23 = this.getSuggestedMinimumWidth();
                        var26_26 = Math.max(var26_26, var23_23);
                        var49_49 = null;
                        var26_26 = View.resolveSizeAndState((int)var26_26, (int)var4_4, (int)0);
                        var24_24 = 2.3509886E-38f;
                        var23_23 = 0xFFFFFF & var26_26;
                        var22_22 = var3_3.mTotalLength;
                        if (var34_34 != 0 || (var23_23 -= var22_22) != 0 && (var16_16 = (int)((cfr_temp_4 = var39_39 - 0.0f) == 0.0f ? 0 : (cfr_temp_4 > 0.0f ? 1 : -1))) > 0) break block60;
                        var38_38 = Math.max(var21_21, var6_6);
                        if (var42_42 != 0) {
                            var23_23 = 0x40000000;
                            var24_24 = 2.0f;
                            if (var9_9 != var23_23) {
                                var7_7 /* !! */  = null;
                                for (var6_6 = 0; var6_6 < var8_8; ++var6_6) {
                                    var49_49 = var3_3.getVirtualChildAt(var6_6);
                                    if (var49_49 == null) continue;
                                    var21_21 = var49_49.getVisibility();
                                    var16_16 = 8;
                                    var17_17 = 1.1E-44f;
                                    if (var21_21 == var16_16) continue;
                                    var54_54 = (LinearLayoutCompat$LayoutParams)var49_49.getLayoutParams();
                                    var55_55 = var54_54.weight;
                                    cfr_temp_5 = var55_55 - 0.0f;
                                    var21_21 = cfr_temp_5 == 0.0f ? 0 : (cfr_temp_5 > 0.0f ? 1 : -1);
                                    if (var21_21 <= 0) continue;
                                    var21_21 = 0x40000000;
                                    var55_55 = 2.0f;
                                    var16_16 = View.MeasureSpec.makeMeasureSpec((int)var12_12, (int)var21_21);
                                    var41_41 = View.MeasureSpec.makeMeasureSpec((int)var49_49.getMeasuredHeight(), (int)var21_21);
                                    var49_49.measure(var16_16, var41_41);
                                }
                            }
                        }
                        var23_23 = var2_2;
                        var35_35 = var8_8;
                        var22_22 = var31_31;
                        break block61;
                    }
                    var17_17 = var3_3.mWeightSum;
                    cfr_temp_6 = var17_17 - 0.0f;
                    var41_41 = cfr_temp_6 == 0.0f ? 0 : (cfr_temp_6 > 0.0f ? 1 : -1);
                    if (var41_41 > 0) {
                        var39_39 = var17_17;
                    }
                    var16_16 = -1;
                    var17_17 = 0.0f / 0.0f;
                    var13_13[var15_15] = var16_16;
                    var13_13[var18_18] = var16_16;
                    var13_13[var19_19] = var16_16;
                    var14_14 /* !! */  = null;
                    var13_13[0] = var16_16;
                    var40_40[var15_15] = var16_16;
                    var40_40[var18_18] = var16_16;
                    var40_40[var19_19] = var16_16;
                    var40_40[0] = var16_16;
                    var3_3.mTotalLength = 0;
                    var41_41 = var21_21;
                    var21_21 = var16_16;
                    var55_55 = var17_17;
                    var5_5 = var32_32;
                    var7_7 /* !! */  = null;
                    for (var6_6 = 0; var6_6 < var8_8; ++var6_6) {
                        block71: {
                            block62: {
                                block70: {
                                    block69: {
                                        block68: {
                                            block67: {
                                                block63: {
                                                    block66: {
                                                        block65: {
                                                            block64: {
                                                                var29_29 = var3_3.getVirtualChildAt(var6_6);
                                                                if (var29_29 == null) break block62;
                                                                var16_16 = var29_29.getVisibility();
                                                                var22_22 = 8;
                                                                var53_53 = 1.1E-44f;
                                                                if (var16_16 == var22_22) break block62;
                                                                var45_45 /* !! */  = (LinearLayoutCompat$LayoutParams)var29_29.getLayoutParams();
                                                                var53_53 = var45_45 /* !! */ .weight;
                                                                cfr_temp_7 = var53_53 - 0.0f;
                                                                var32_32 = cfr_temp_7 == 0.0f ? 0 : (cfr_temp_7 > 0.0f ? 1 : -1);
                                                                if (var32_32 <= 0) break block63;
                                                                var56_56 = (float)var23_23 * var53_53 / var39_39;
                                                                var4_4 = (int)var56_56;
                                                                var22_22 = this.getPaddingTop();
                                                                var32_32 = this.getPaddingBottom();
                                                                var22_22 += var32_32;
                                                                var33_33 = var39_39 -= var53_53;
                                                                var38_38 = var45_45 /* !! */ .topMargin;
                                                                var22_22 += var38_38;
                                                                var38_38 = var45_45 /* !! */ .bottomMargin;
                                                                var22_22 += var38_38;
                                                                var38_38 = var45_45 /* !! */ .height;
                                                                var34_34 = var23_23 -= var4_4;
                                                                var35_35 = var8_8;
                                                                var8_8 = -1;
                                                                var23_23 = var2_2;
                                                                var38_38 = ViewGroup.getChildMeasureSpec((int)var2_2, (int)var22_22, (int)var38_38);
                                                                var22_22 = var45_45 /* !! */ .width;
                                                                if (var22_22 != 0) break block64;
                                                                var22_22 = 0x40000000;
                                                                var53_53 = 2.0f;
                                                                if (var9_9 != var22_22) break block65;
                                                                if (var4_4 <= 0) {
                                                                    var4_4 = 0;
                                                                    var56_56 = 0.0f;
                                                                }
                                                                var4_4 = View.MeasureSpec.makeMeasureSpec((int)var4_4, (int)var22_22);
                                                                var29_29.measure(var4_4, var38_38);
                                                                break block66;
                                                            }
                                                            var22_22 = 0x40000000;
                                                            var53_53 = 2.0f;
                                                        }
                                                        if ((var4_4 = (var50_50 = var29_29.getMeasuredWidth()) + var4_4) < 0) {
                                                            var4_4 = 0;
                                                            var56_56 = 0.0f;
                                                        }
                                                        var4_4 = View.MeasureSpec.makeMeasureSpec((int)var4_4, (int)var22_22);
                                                        var29_29.measure(var4_4, var38_38);
                                                    }
                                                    var38_38 = var29_29.getMeasuredState();
                                                    var53_53 = -1.7014118E38f;
                                                    var5_5 = View.combineMeasuredStates((int)var5_5, (int)(var38_38 &= -16777216));
                                                    var39_39 = var33_33;
                                                    var22_22 = var34_34;
                                                    break block67;
                                                }
                                                var22_22 = var23_23;
                                                var35_35 = var8_8;
                                                var8_8 = -1;
                                                var23_23 = var2_2;
                                            }
                                            if (var25_25 != 0) {
                                                var4_4 = var3_3.mTotalLength;
                                                var32_32 = var29_29.getMeasuredWidth();
                                                var8_8 = var45_45 /* !! */ .leftMargin;
                                                var32_32 += var8_8;
                                                var8_8 = var45_45 /* !! */ .rightMargin;
                                                var32_32 += var8_8;
                                                var8_8 = var3_3.getNextLocationOffset(var29_29);
                                                var3_3.mTotalLength = var4_4 += (var32_32 += var8_8);
                                                var33_33 = var39_39;
                                            } else {
                                                var4_4 = var3_3.mTotalLength;
                                                var8_8 = var29_29.getMeasuredWidth() + var4_4;
                                                var33_33 = var39_39;
                                                var38_38 = var45_45 /* !! */ .leftMargin;
                                                var8_8 += var38_38;
                                                var38_38 = var45_45 /* !! */ .rightMargin;
                                                var8_8 += var38_38;
                                                var38_38 = var3_3.getNextLocationOffset(var29_29);
                                                var8_8 += var38_38;
                                                var3_3.mTotalLength = var38_38 = Math.max(var4_4, var8_8);
                                            }
                                            var38_38 = 0x40000000;
                                            var39_39 = 2.0f;
                                            if (var10_10 == var38_38) ** GOTO lbl-1000
                                            var38_38 = var45_45 /* !! */ .height;
                                            var4_4 = -1;
                                            var56_56 = 0.0f / 0.0f;
                                            if (var38_38 == var4_4) {
                                                var38_38 = var19_19;
                                                var39_39 = var20_20;
                                            } else lbl-1000:
                                            // 2 sources

                                            {
                                                var38_38 = 0;
                                                var39_39 = 0.0f;
                                                var11_11 /* !! */  = null;
                                            }
                                            var4_4 = var45_45 /* !! */ .topMargin;
                                            var8_8 = var45_45 /* !! */ .bottomMargin;
                                            var4_4 += var8_8;
                                            var8_8 = var29_29.getMeasuredHeight() + var4_4;
                                            var21_21 = Math.max(var21_21, var8_8);
                                            if (var38_38 == 0) {
                                                var4_4 = var8_8;
                                            }
                                            var38_38 = Math.max(var41_41, var4_4);
                                            if (var37_37 == 0) break block68;
                                            var41_41 = var45_45 /* !! */ .height;
                                            var4_4 = -1;
                                            var56_56 = 0.0f / 0.0f;
                                            if (var41_41 != var4_4) break block69;
                                            var41_41 = var19_19;
                                            break block70;
                                        }
                                        var4_4 = -1;
                                        var56_56 = 0.0f / 0.0f;
                                    }
                                    var41_41 = 0;
                                    var14_14 /* !! */  = null;
                                }
                                if (var43_43 != 0 && (var12_12 = var29_29.getBaseline()) != var4_4) {
                                    var16_16 = var45_45 /* !! */ .gravity;
                                    if (var16_16 < 0) {
                                        var16_16 = var3_3.mGravity;
                                    }
                                    var16_16 &= 112;
                                    var56_56 = 5.6E-45f;
                                    var16_16 = (var16_16 >> 4 & -2) >> 1;
                                    var13_13[var16_16] = var4_4 = Math.max(var13_13[var16_16], var12_12);
                                    var4_4 = var40_40[var16_16];
                                    var40_40[var16_16] = var4_4 = Math.max(var4_4, var8_8 -= var12_12);
                                }
                                var37_37 = var41_41;
                                var41_41 = var38_38;
                                var39_39 = var33_33;
                                break block71;
                            }
                            var22_22 = var23_23;
                            var35_35 = var8_8;
                            var23_23 = var2_2;
                        }
                        var4_4 = var1_1;
                        var23_23 = var22_22;
                        var8_8 = var35_35;
                        var16_16 = -1;
                        var17_17 = 0.0f / 0.0f;
                    }
                    var23_23 = var2_2;
                    var35_35 = var8_8;
                    var38_38 = var3_3.mTotalLength;
                    var22_22 = this.getPaddingLeft();
                    var16_16 = this.getPaddingRight();
                    var3_3.mTotalLength = var38_38 += (var22_22 += var16_16);
                    var38_38 = var13_13[var19_19];
                    var22_22 = -1;
                    var53_53 = 0.0f / 0.0f;
                    if (var38_38 != var22_22) ** GOTO lbl-1000
                    var38_38 = 0;
                    var39_39 = 0.0f;
                    var11_11 /* !! */  = null;
                    var16_16 = var13_13[0];
                    if (var16_16 == var22_22 && (var38_38 = var13_13[var18_18]) == var22_22 && (var38_38 = var13_13[var15_15]) == var22_22) {
                        var38_38 = var21_21;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var38_38 = var13_13[var15_15];
                        var53_53 = 0.0f;
                        var48_48 /* !! */  = null;
                        var16_16 = var13_13[0];
                        var4_4 = var13_13[var19_19];
                        var6_6 = var13_13[var18_18];
                        var4_4 = Math.max(var4_4, var6_6);
                        var16_16 = Math.max(var16_16, var4_4);
                        var38_38 = Math.max(var38_38, var16_16);
                        var16_16 = var40_40[var15_15];
                        var22_22 = var40_40[0];
                        var4_4 = var40_40[var19_19];
                        var6_6 = var40_40[var18_18];
                        var4_4 = Math.max(var4_4, var6_6);
                        var22_22 = Math.max(var22_22, var4_4);
                        var22_22 = Math.max(var16_16, var22_22);
                        var38_38 += var22_22;
                        var38_38 = Math.max(var21_21, var38_38);
                    }
                    var22_22 = var38_38;
                    var38_38 = var41_41;
                    var32_32 = var5_5;
                }
                if (var37_37 != 0) break block72;
                var21_21 = 0x40000000;
                var55_55 = 2.0f;
                if (var10_10 != var21_21) break block73;
            }
            var38_38 = var22_22;
        }
        var22_22 = this.getPaddingTop();
        var21_21 = this.getPaddingBottom();
        var38_38 += (var22_22 += var21_21);
        var22_22 = this.getSuggestedMinimumHeight();
        var38_38 = Math.max(var38_38, var22_22);
        var53_53 = -1.7014118E38f;
        var22_22 = var32_32 & -16777216;
        var26_26 |= var22_22;
        var22_22 = var32_32 << 16;
        var38_38 = View.resolveSizeAndState((int)var38_38, (int)var23_23, (int)var22_22);
        var3_3.setMeasuredDimension(var26_26, var38_38);
        if (var36_36 != 0) {
            var38_38 = var1_1;
            var26_26 = var35_35;
            var3_3.forceUniformHeight(var35_35, var1_1);
        }
    }

    public int measureNullChild(int n10) {
        return 0;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void measureVertical(int var1_1, int var2_2) {
        block42: {
            block41: {
                var3_3 = this;
                var4_4 = var1_1;
                var5_5 = var2_2;
                var6_6 = 0;
                var7_7 = 0.0f;
                var8_8 /* !! */  = null;
                this.mTotalLength = 0;
                var9_9 = this.getVirtualChildCount();
                var10_10 = View.MeasureSpec.getMode((int)var1_1);
                var11_11 = View.MeasureSpec.getMode((int)var2_2);
                var12_12 = this.mBaselineAlignedChildIndex;
                var13_13 = this.mUseLargestChild;
                var14_14 = 1;
                var15_15 = 1.4E-45f;
                var16_16 = 0;
                var17_17 = null;
                var18_18 = 0.0f;
                var19_19 = 0;
                var20_20 = 0.0f;
                var21_21 = 0;
                var22_22 = null;
                var23_23 = 0;
                var24_24 = null;
                var25_25 = 0;
                var26_26 = 0;
                var27_27 = null;
                var28_28 = 0;
                var29_29 = 0.0f;
                var30_30 = 0;
                var31_31 = 0;
                var32_32 /* !! */  = null;
                var33_33 = 0.0f;
                var34_34 = var14_14;
                while (true) {
                    block39: {
                        block40: {
                            block38: {
                                var6_6 = 8;
                                var7_7 = 1.1E-44f;
                                var35_35 = var23_23;
                                if (var26_26 >= var9_9) break;
                                var24_24 = var3_3.getVirtualChildAt(var26_26);
                                if (var24_24 != null) break block38;
                                var23_23 = var3_3.mTotalLength;
                                var6_6 = var3_3.measureNullChild(var26_26);
                                var3_3.mTotalLength = var23_23 += var6_6;
                                var36_36 = var9_9;
                                var37_37 = var11_11;
                                var23_23 = var35_35;
                                break block39;
                            }
                            var37_37 = var16_16;
                            var16_16 = var24_24.getVisibility();
                            if (var16_16 != var6_6) break block40;
                            var16_16 = var3_3.getChildrenSkipCount(var24_24, var26_26);
                            var26_26 += var16_16;
                            var36_36 = var9_9;
                            var16_16 = var37_37;
                            var37_37 = var11_11;
                            break block39;
                        }
                        var16_16 = (int)var3_3.hasDividerBeforeChildAt(var26_26);
                        if (var16_16 != 0) {
                            var16_16 = var3_3.mTotalLength;
                            var6_6 = var3_3.mDividerHeight;
                            var3_3.mTotalLength = var16_16 += var6_6;
                        }
                        var8_8 /* !! */  = var17_17 = var24_24.getLayoutParams();
                        var8_8 /* !! */  = (LinearLayoutCompat$LayoutParams)var17_17;
                        var18_18 = var8_8 /* !! */ .weight;
                        var38_38 = var33_33 + var18_18;
                        var31_31 = 0x40000000;
                        var33_33 = 2.0f;
                        if (var11_11 == var31_31 && (var31_31 = var8_8 /* !! */ .height) == 0 && (var31_31 = (int)((cfr_temp_0 = var18_18 - 0.0f) == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1))) > 0) {
                            var31_31 = var3_3.mTotalLength;
                            var16_16 = var8_8 /* !! */ .topMargin + var31_31;
                            var36_36 = var19_19;
                            var19_19 = var8_8 /* !! */ .bottomMargin;
                            var3_3.mTotalLength = var31_31 = Math.max(var31_31, var16_16 += var19_19);
                            var31_31 = var21_21;
                            var22_22 = var24_24;
                            var39_39 = var25_25;
                            var28_28 = var14_14;
                            var29_29 = var15_15;
                            var4_4 = var37_37;
                            var40_40 = var36_36;
                            var36_36 = var9_9;
                            var37_37 = var11_11;
                            var11_11 = var35_35;
                            var9_9 = var26_26;
                        } else {
                            var36_36 = var19_19;
                            var31_31 = var8_8 /* !! */ .height;
                            if (var31_31 == 0 && (var31_31 = (int)((cfr_temp_1 = var18_18 - 0.0f) == 0.0f ? 0 : (cfr_temp_1 > 0.0f ? 1 : -1))) > 0) {
                                var31_31 = -2;
                                var33_33 = 0.0f / 0.0f;
                                var8_8 /* !! */ .height = var31_31;
                                var19_19 = 0;
                                var20_20 = 0.0f;
                            } else {
                                var19_19 = -1 << -1;
                                var20_20 = -0.0f;
                            }
                            var31_31 = (cfr_temp_2 = var38_38 - 0.0f) == 0.0f ? 0 : (cfr_temp_2 > 0.0f ? 1 : -1);
                            var41_41 = var31_31 == 0 ? (var31_31 = var3_3.mTotalLength) : 0;
                            var42_42 = 0x40000000;
                            var32_32 /* !! */  = this;
                            var4_4 = var37_37;
                            var17_17 = var24_24;
                            var43_43 = var19_19;
                            var40_40 = var36_36;
                            var19_19 = var26_26;
                            var5_5 = var21_21;
                            var21_21 = var1_1;
                            var36_36 = var9_9;
                            var37_37 = var11_11;
                            var11_11 = var35_35;
                            var9_9 = var42_42;
                            var44_44 = var24_24;
                            var23_23 = 0;
                            var24_24 = null;
                            var39_39 = var25_25;
                            var25_25 = var2_2;
                            var9_9 = var26_26;
                            var26_26 = var41_41;
                            this.measureChildBeforeLayout((View)var17_17, var19_19, var1_1, 0, var2_2, var41_41);
                            var31_31 = var43_43;
                            var33_33 = var20_20;
                            var16_16 = -1 << -1;
                            var18_18 = -0.0f;
                            if (var43_43 != var16_16) {
                                var8_8 /* !! */ .height = var43_43;
                            }
                            var31_31 = var44_44.getMeasuredHeight();
                            var16_16 = var3_3.mTotalLength;
                            var19_19 = var16_16 + var31_31;
                            var21_21 = var8_8 /* !! */ .topMargin;
                            var19_19 += var21_21;
                            var21_21 = var8_8 /* !! */ .bottomMargin;
                            var19_19 += var21_21;
                            var22_22 = var44_44;
                            var23_23 = var3_3.getNextLocationOffset(var44_44);
                            var3_3.mTotalLength = var16_16 = Math.max(var16_16, var19_19 += var23_23);
                            var31_31 = var13_13 != 0 ? Math.max(var31_31, var5_5) : var5_5;
                        }
                        if (var12_12 >= 0 && var12_12 == (var26_26 = var9_9 + 1)) {
                            var3_3.mBaselineChildTop = var16_16 = var3_3.mTotalLength;
                        }
                        if (var9_9 < var12_12 && (var16_16 = (int)((cfr_temp_3 = (var18_18 = var8_8 /* !! */ .weight) - 0.0f) == 0.0f ? 0 : (cfr_temp_3 > 0.0f ? 1 : -1))) > 0) {
                            var32_32 /* !! */  = new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                            throw var32_32 /* !! */ ;
                        }
                        var16_16 = 0x40000000;
                        var18_18 = 2.0f;
                        if (var10_10 == var16_16) ** GOTO lbl-1000
                        var16_16 = var8_8 /* !! */ .width;
                        var19_19 = -1;
                        var20_20 = 0.0f / 0.0f;
                        if (var16_16 == var19_19) {
                            var16_16 = var14_14;
                            var18_18 = var15_15;
                            var30_30 = var14_14;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var16_16 = 0;
                            var18_18 = 0.0f;
                            var17_17 = null;
                        }
                        var19_19 = var8_8 /* !! */ .leftMargin;
                        var23_23 = var8_8 /* !! */ .rightMargin;
                        var19_19 += var23_23;
                        var23_23 = var22_22.getMeasuredWidth() + var19_19;
                        var25_25 = var40_40;
                        var25_25 = Math.max(var40_40, var23_23);
                        var26_26 = var22_22.getMeasuredState();
                        var26_26 = View.combineMeasuredStates((int)var4_4, (int)var26_26);
                        if (var34_34 == 0) ** GOTO lbl-1000
                        var4_4 = var8_8 /* !! */ .width;
                        var5_5 = -1;
                        var45_45 = 0.0f / 0.0f;
                        if (var4_4 == var5_5) {
                            var34_34 = var14_14;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var34_34 = 0;
                        }
                        var46_46 = var8_8 /* !! */ .weight;
                        cfr_temp_4 = var46_46 - 0.0f;
                        var4_4 = cfr_temp_4 == 0.0f ? 0 : (cfr_temp_4 > 0.0f ? 1 : -1);
                        if (var4_4 > 0) {
                            if (var16_16 == 0) {
                                var19_19 = var23_23;
                            }
                            var23_23 = Math.max(var11_11, var19_19);
                            var16_16 = var39_39;
                        } else {
                            if (var16_16 == 0) {
                                var19_19 = var23_23;
                            }
                            var16_16 = var39_39;
                            var16_16 = Math.max(var39_39, var19_19);
                            var23_23 = var11_11;
                        }
                        var19_19 = var3_3.getChildrenSkipCount(var22_22, var9_9) + var9_9;
                        var21_21 = var31_31;
                        var33_33 = var38_38;
                        var47_47 = var25_25;
                        var25_25 = var16_16;
                        var16_16 = var26_26;
                        var26_26 = var19_19;
                        var19_19 = var47_47;
                    }
                    ++var26_26;
                    var4_4 = var1_1;
                    var5_5 = var2_2;
                    var11_11 = var37_37;
                    var9_9 = var36_36;
                }
                var4_4 = var16_16;
                var5_5 = var21_21;
                var16_16 = var25_25;
                var36_36 = var9_9;
                var37_37 = var11_11;
                var11_11 = var23_23;
                var25_25 = var19_19;
                var19_19 = var3_3.mTotalLength;
                if (var19_19 > 0) {
                    var19_19 = var9_9;
                    var21_21 = (int)var3_3.hasDividerBeforeChildAt(var9_9);
                    if (var21_21 != 0) {
                        var21_21 = var3_3.mTotalLength;
                        var23_23 = var3_3.mDividerHeight;
                        var3_3.mTotalLength = var21_21 += var23_23;
                    }
                } else {
                    var19_19 = var9_9;
                }
                var21_21 = var37_37;
                if (var13_13 != 0 && (var37_37 == (var23_23 = -1 << -1) || var37_37 == 0)) {
                    var3_3.mTotalLength = 0;
                    var24_24 = null;
                    for (var23_23 = 0; var23_23 < var19_19; ++var23_23) {
                        var27_27 = var3_3.getVirtualChildAt(var23_23);
                        if (var27_27 == null) {
                            var26_26 = var3_3.mTotalLength;
                            var9_9 = var3_3.measureNullChild(var23_23);
                            var3_3.mTotalLength = var26_26 += var9_9;
                        } else {
                            var9_9 = var27_27.getVisibility();
                            if (var9_9 == var6_6) {
                                var26_26 = var3_3.getChildrenSkipCount(var27_27, var23_23);
                                var23_23 += var26_26;
                            } else {
                                var48_48 = (LinearLayoutCompat$LayoutParams)var27_27.getLayoutParams();
                                var12_12 = var3_3.mTotalLength;
                                var49_49 = var12_12 + var5_5;
                                var6_6 = var48_48.topMargin;
                                var49_49 += var6_6;
                                var6_6 = var48_48.bottomMargin;
                                var26_26 = var3_3.getNextLocationOffset(var27_27);
                                var26_26 = (var49_49 += var6_6) + var26_26;
                                var3_3.mTotalLength = var26_26 = Math.max(var12_12, var26_26);
                            }
                        }
                        var6_6 = 8;
                        var7_7 = 1.1E-44f;
                    }
                }
                var23_23 = var3_3.mTotalLength;
                var26_26 = this.getPaddingTop();
                var6_6 = this.getPaddingBottom();
                var3_3.mTotalLength = var23_23 += (var26_26 += var6_6);
                var26_26 = this.getSuggestedMinimumHeight();
                var23_23 = Math.max(var23_23, var26_26);
                var26_26 = var2_2;
                var6_6 = var5_5;
                var50_50 = null;
                var23_23 = View.resolveSizeAndState((int)var23_23, (int)var2_2, (int)0);
                var45_45 = 2.3509886E-38f;
                var5_5 = 0xFFFFFF & var23_23;
                var9_9 = var3_3.mTotalLength;
                var5_5 -= var9_9;
                if (var28_28 != 0 || var5_5 != 0 && (var9_9 = (int)((cfr_temp_5 = var33_33 - 0.0f) == 0.0f ? 0 : (cfr_temp_5 > 0.0f ? 1 : -1))) > 0) break block41;
                var31_31 = Math.max(var16_16, var11_11);
                if (var13_13 != 0) {
                    var16_16 = 0x40000000;
                    var18_18 = 2.0f;
                    if (var21_21 != var16_16) {
                        var18_18 = 0.0f;
                        var17_17 = null;
                        for (var16_16 = 0; var16_16 < var19_19; ++var16_16) {
                            var22_22 = var3_3.getVirtualChildAt(var16_16);
                            if (var22_22 == null || (var5_5 = var22_22.getVisibility()) == (var9_9 = 8)) continue;
                            var50_50 = (LinearLayoutCompat$LayoutParams)var22_22.getLayoutParams();
                            var45_45 = var50_50.weight;
                            cfr_temp_6 = var45_45 - 0.0f;
                            var5_5 = cfr_temp_6 == 0.0f ? 0 : (cfr_temp_6 > 0.0f ? 1 : -1);
                            if (var5_5 <= 0) continue;
                            var5_5 = var22_22.getMeasuredWidth();
                            var9_9 = 0x40000000;
                            var5_5 = View.MeasureSpec.makeMeasureSpec((int)var5_5, (int)var9_9);
                            var11_11 = View.MeasureSpec.makeMeasureSpec((int)var6_6, (int)var9_9);
                            var22_22.measure(var5_5, var11_11);
                        }
                    }
                }
                var9_9 = var1_1;
                var16_16 = var4_4;
                break block42;
            }
            var7_7 = var3_3.mWeightSum;
            cfr_temp_7 = var7_7 - 0.0f;
            var9_9 = cfr_temp_7 == 0.0f ? 0 : (cfr_temp_7 > 0.0f ? 1 : -1);
            if (var9_9 > 0) {
                var33_33 = var7_7;
            }
            var6_6 = 0;
            var7_7 = 0.0f;
            var8_8 /* !! */  = null;
            var3_3.mTotalLength = 0;
            var9_9 = var5_5;
            var5_5 = var16_16;
            var16_16 = var4_4;
            var46_46 = 0.0f;
            for (var4_4 = 0; var4_4 < var19_19; ++var4_4) {
                block44: {
                    block52: {
                        block51: {
                            block50: {
                                block49: {
                                    block45: {
                                        block48: {
                                            block47: {
                                                block46: {
                                                    block43: {
                                                        var51_51 = var3_3.getVirtualChildAt(var4_4);
                                                        var12_12 = var51_51.getVisibility();
                                                        var13_13 = 8;
                                                        var52_52 = 1.1E-44f;
                                                        if (var12_12 != var13_13) break block43;
                                                        var49_49 = var9_9;
                                                        var9_9 = var1_1;
                                                        break block44;
                                                    }
                                                    var53_53 = (LinearLayoutCompat$LayoutParams)var51_51.getLayoutParams();
                                                    var7_7 = var53_53.weight;
                                                    cfr_temp_8 = var7_7 - 0.0f;
                                                    var28_28 = cfr_temp_8 == 0.0f ? 0 : (cfr_temp_8 > 0.0f ? 1 : -1);
                                                    if (var28_28 <= 0) break block45;
                                                    var52_52 = (float)var9_9 * var7_7 / var33_33;
                                                    var13_13 = (int)var52_52;
                                                    var6_6 = this.getPaddingLeft();
                                                    var28_28 = this.getPaddingRight();
                                                    var6_6 += var28_28;
                                                    var29_29 = var33_33 -= var7_7;
                                                    var31_31 = var53_53.leftMargin;
                                                    var6_6 += var31_31;
                                                    var31_31 = var53_53.rightMargin;
                                                    var6_6 += var31_31;
                                                    var31_31 = var53_53.width;
                                                    var49_49 = var9_9 -= var13_13;
                                                    var9_9 = var1_1;
                                                    var31_31 = ViewGroup.getChildMeasureSpec((int)var1_1, (int)var6_6, (int)var31_31);
                                                    var6_6 = var53_53.height;
                                                    if (var6_6 != 0) break block46;
                                                    var6_6 = 0x40000000;
                                                    var7_7 = 2.0f;
                                                    if (var21_21 != var6_6) break block47;
                                                    if (var13_13 <= 0) {
                                                        var13_13 = 0;
                                                        var52_52 = 0.0f;
                                                    }
                                                    var13_13 = View.MeasureSpec.makeMeasureSpec((int)var13_13, (int)var6_6);
                                                    var51_51.measure(var31_31, var13_13);
                                                    break block48;
                                                }
                                                var6_6 = 0x40000000;
                                                var7_7 = 2.0f;
                                            }
                                            if ((var13_13 = (var41_41 = var51_51.getMeasuredHeight()) + var13_13) < 0) {
                                                var13_13 = 0;
                                                var52_52 = 0.0f;
                                            }
                                            var13_13 = View.MeasureSpec.makeMeasureSpec((int)var13_13, (int)var6_6);
                                            var51_51.measure(var31_31, var13_13);
                                        }
                                        var31_31 = var51_51.getMeasuredState() & -256;
                                        var16_16 = View.combineMeasuredStates((int)var16_16, (int)var31_31);
                                        var33_33 = var29_29;
                                        break block49;
                                    }
                                    var6_6 = var9_9;
                                    var9_9 = var1_1;
                                    var49_49 = var6_6;
                                }
                                var6_6 = var53_53.leftMargin;
                                var13_13 = var53_53.rightMargin;
                                var6_6 += var13_13;
                                var13_13 = var51_51.getMeasuredWidth() + var6_6;
                                var25_25 = Math.max(var25_25, var13_13);
                                var29_29 = var33_33;
                                var31_31 = 0x40000000;
                                var33_33 = 2.0f;
                                if (var10_10 == var31_31) break block50;
                                var31_31 = var53_53.width;
                                var41_41 = var16_16;
                                var16_16 = -1;
                                var18_18 = 0.0f / 0.0f;
                                if (var31_31 != var16_16) break block51;
                                var31_31 = var14_14;
                                var33_33 = var15_15;
                                break block52;
                            }
                            var41_41 = var16_16;
                            var16_16 = -1;
                            var18_18 = 0.0f / 0.0f;
                        }
                        var31_31 = 0;
                        var33_33 = 0.0f;
                        var32_32 /* !! */  = null;
                    }
                    if (var31_31 == 0) {
                        var6_6 = var13_13;
                    }
                    var31_31 = Math.max(var5_5, var6_6);
                    if (var34_34 != 0 && (var5_5 = var53_53.width) == var16_16) {
                        var5_5 = var14_14;
                        var45_45 = var15_15;
                    } else {
                        var5_5 = 0;
                        var45_45 = 0.0f;
                        var50_50 = null;
                    }
                    var6_6 = var3_3.mTotalLength;
                    var13_13 = var51_51.getMeasuredHeight() + var6_6;
                    var16_16 = var53_53.topMargin;
                    var13_13 += var16_16;
                    var16_16 = var53_53.bottomMargin;
                    var13_13 += var16_16;
                    var16_16 = var3_3.getNextLocationOffset(var51_51);
                    var13_13 += var16_16;
                    var3_3.mTotalLength = var16_16 = Math.max(var6_6, var13_13);
                    var34_34 = var5_5;
                    var16_16 = var41_41;
                    var5_5 = var31_31;
                    var33_33 = var29_29;
                }
                var9_9 = var49_49;
                var6_6 = 0;
                var7_7 = 0.0f;
                var8_8 /* !! */  = null;
            }
            var9_9 = var1_1;
            var31_31 = var3_3.mTotalLength;
            var21_21 = this.getPaddingTop();
            var4_4 = this.getPaddingBottom();
            var3_3.mTotalLength = var31_31 += (var21_21 += var4_4);
            var31_31 = var5_5;
        }
        if (var34_34 != 0 || var10_10 == (var21_21 = 0x40000000)) {
            var31_31 = var25_25;
        }
        var21_21 = this.getPaddingLeft();
        var25_25 = this.getPaddingRight();
        var31_31 += (var21_21 += var25_25);
        var21_21 = this.getSuggestedMinimumWidth();
        var31_31 = View.resolveSizeAndState((int)Math.max(var31_31, var21_21), (int)var9_9, (int)var16_16);
        var3_3.setMeasuredDimension(var31_31, var23_23);
        if (var30_30 != 0) {
            var3_3.forceUniformWidth(var19_19, var26_26);
        }
    }

    public void onDraw(Canvas canvas) {
        Drawable drawable2 = this.mDivider;
        if (drawable2 == null) {
            return;
        }
        int n10 = this.mOrientation;
        int n11 = 1;
        if (n10 == n11) {
            this.drawDividersVertical(canvas);
        } else {
            this.drawDividersHorizontal(canvas);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)ACCESSIBILITY_CLASS_NAME);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((CharSequence)ACCESSIBILITY_CLASS_NAME);
    }

    /*
     * WARNING - void declaration
     */
    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        void var5_6;
        void var4_5;
        void var3_4;
        void var2_3;
        int n14 = this.mOrientation;
        int n15 = 1;
        if (n14 == n15) {
            this.layoutVertical((int)var2_3, (int)var3_4, (int)var4_5, (int)var5_6);
        } else {
            this.layoutHorizontal((int)var2_3, (int)var3_4, (int)var4_5, (int)var5_6);
        }
    }

    public void onMeasure(int n10, int n11) {
        int n12 = this.mOrientation;
        int n13 = 1;
        if (n12 == n13) {
            this.measureVertical(n10, n11);
        } else {
            this.measureHorizontal(n10, n11);
        }
    }

    public void setBaselineAligned(boolean bl2) {
        this.mBaselineAligned = bl2;
    }

    public void setBaselineAlignedChildIndex(int n10) {
        int n11;
        if (n10 >= 0 && n10 < (n11 = this.getChildCount())) {
            this.mBaselineAlignedChildIndex = n10;
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("base aligned child index out of range (0, ");
        int n12 = this.getChildCount();
        charSequence.append(n12);
        charSequence.append(")");
        charSequence = charSequence.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
        throw illegalArgumentException;
    }

    public void setDividerDrawable(Drawable drawable2) {
        Drawable drawable3 = this.mDivider;
        if (drawable2 == drawable3) {
            return;
        }
        this.mDivider = drawable2;
        boolean bl2 = false;
        drawable3 = null;
        if (drawable2 != null) {
            int n10;
            this.mDividerWidth = n10 = drawable2.getIntrinsicWidth();
            this.mDividerHeight = n10 = drawable2.getIntrinsicHeight();
        } else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }
        if (drawable2 == null) {
            bl2 = true;
        }
        this.setWillNotDraw(bl2);
        this.requestLayout();
    }

    public void setDividerPadding(int n10) {
        this.mDividerPadding = n10;
    }

    public void setGravity(int n10) {
        int n11 = this.mGravity;
        if (n11 != n10) {
            n11 = 0x800007 & n10;
            if (n11 == 0) {
                n11 = 0x800003;
                n10 |= n11;
            }
            if ((n11 = n10 & 0x70) == 0) {
                n10 |= 0x30;
            }
            this.mGravity = n10;
            this.requestLayout();
        }
    }

    public void setHorizontalGravity(int n10) {
        int n11 = 0x800007;
        int n12 = this.mGravity;
        if ((n11 &= n12) != (n10 &= n11)) {
            n11 = 0xFF7FFFF8 & n12;
            this.mGravity = n10 |= n11;
            this.requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean bl2) {
        this.mUseLargestChild = bl2;
    }

    public void setOrientation(int n10) {
        int n11 = this.mOrientation;
        if (n11 != n10) {
            this.mOrientation = n10;
            this.requestLayout();
        }
    }

    public void setShowDividers(int n10) {
        int n11 = this.mShowDividers;
        if (n10 != n11) {
            this.requestLayout();
        }
        this.mShowDividers = n10;
    }

    public void setVerticalGravity(int n10) {
        int n11 = this.mGravity;
        int n12 = n11 & 0x70;
        if (n12 != (n10 &= 0x70)) {
            this.mGravity = n10 |= (n11 &= 0xFFFFFF8F);
            this.requestLayout();
        }
    }

    public void setWeightSum(float f10) {
        this.mWeightSum = f10 = Math.max(0.0f, f10);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}

