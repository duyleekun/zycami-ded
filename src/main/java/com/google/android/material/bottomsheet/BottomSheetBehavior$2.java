/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper$Callback;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetBehavior$SettleRunnable;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior$2
extends ViewDragHelper$Callback {
    public final /* synthetic */ BottomSheetBehavior this$0;

    public BottomSheetBehavior$2(BottomSheetBehavior bottomSheetBehavior) {
        this.this$0 = bottomSheetBehavior;
    }

    public int clampViewPositionHorizontal(View view, int n10, int n11) {
        return view.getLeft();
    }

    public int clampViewPositionVertical(View object, int n10, int n11) {
        object = this.this$0;
        int n12 = BottomSheetBehavior.access$100((BottomSheetBehavior)object);
        BottomSheetBehavior bottomSheetBehavior = this.this$0;
        boolean bl2 = bottomSheetBehavior.hideable;
        n11 = bl2 ? bottomSheetBehavior.parentHeight : bottomSheetBehavior.collapsedOffset;
        return MathUtils.clamp(n10, n12, n11);
    }

    public int getViewVerticalDragRange(View object) {
        object = this.this$0;
        boolean bl2 = object.hideable;
        if (bl2) {
            return object.parentHeight;
        }
        return object.collapsedOffset;
    }

    public void onViewDragStateChanged(int n10) {
        int n11 = 1;
        if (n10 == n11) {
            BottomSheetBehavior bottomSheetBehavior = this.this$0;
            bottomSheetBehavior.setStateInternal(n11);
        }
    }

    public void onViewPositionChanged(View view, int n10, int n11, int n12, int n13) {
        this.this$0.dispatchOnSlide(n11);
    }

    /*
     * Unable to fully structure code
     */
    public void onViewReleased(View var1_1, float var2_2, float var3_3) {
        block6: {
            block14: {
                block12: {
                    block13: {
                        block11: {
                            block10: {
                                block7: {
                                    block9: {
                                        block8: {
                                            var4_4 = 0;
                                            var5_5 = null;
                                            cfr_temp_0 = var3_3 - 0.0f;
                                            var6_6 = cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 < 0.0f ? -1 : 1);
                                            var7_7 = 0;
                                            var8_8 = 4;
                                            var9_9 = 6;
                                            var10_10 = 3;
                                            if (var6_6 >= 0) break block7;
                                            var11_11 = this.this$0;
                                            var12_12 = BottomSheetBehavior.access$000((BottomSheetBehavior)var11_11);
                                            if (var12_12 == 0) break block8;
                                            var11_11 = this.this$0;
                                            var12_12 = var11_11.fitToContentsOffset;
                                            var8_8 = var10_10;
                                            break block6;
                                        }
                                        var12_12 = var1_1.getTop();
                                        var13_13 = this.this$0;
                                        var14_14 = var13_13.halfExpandedOffset;
                                        if (var12_12 <= var14_14) break block9;
                                        var7_7 = var14_14;
lbl23:
                                        // 3 sources

                                        while (true) {
                                            var8_8 = var9_9;
                                            ** GOTO lbl29
                                            break;
                                        }
                                    }
lbl27:
                                    // 3 sources

                                    while (true) {
                                        var8_8 = var10_10;
lbl29:
                                        // 4 sources

                                        while (true) {
                                            var12_12 = var7_7;
                                            break block6;
                                            break;
                                        }
                                        break;
                                    }
                                }
                                var15_15 = this.this$0;
                                var16_16 = var15_15.hideable;
                                if (var16_16 == 0 || (var6_6 = (float)var15_15.shouldHide((View)var1_1, var3_3)) == false) break block10;
                                var6_6 = var1_1.getTop();
                                var17_17 = this.this$0;
                                var16_16 = var17_17.collapsedOffset;
                                if (var6_6 <= var16_16 && (var6_6 = (cfr_temp_1 = (var18_18 = Math.abs(var2_2)) - (var19_19 = Math.abs(var3_3))) == 0.0f ? 0 : (cfr_temp_1 < 0.0f ? -1 : 1)) >= 0) break block10;
                                var11_11 = this.this$0;
                                var12_12 = var11_11.parentHeight;
                                var8_8 = 5;
                                break block6;
                            }
                            if ((var4_4 = (cfr_temp_2 = var3_3 - 0.0f) == 0.0f ? 0 : (cfr_temp_2 > 0.0f ? 1 : -1)) == 0 || (var12_12 = (int)((cfr_temp_3 = (var2_2 = Math.abs(var2_2)) - (var3_3 = Math.abs(var3_3))) == 0.0f ? 0 : (cfr_temp_3 > 0.0f ? 1 : -1))) > 0) break block11;
                            var11_11 = this.this$0;
                            var12_12 = var11_11.collapsedOffset;
                            break block6;
                        }
                        var12_12 = var1_1.getTop();
                        var13_13 = this.this$0;
                        var14_14 = (int)BottomSheetBehavior.access$000((BottomSheetBehavior)var13_13);
                        if (var14_14 == 0) break block12;
                        var13_13 = this.this$0;
                        var14_14 = var13_13.fitToContentsOffset;
                        var14_14 = Math.abs(var12_12 - var14_14);
                        var5_5 = this.this$0;
                        var4_4 = var5_5.collapsedOffset;
                        if (var14_14 >= (var12_12 = Math.abs(var12_12 - var4_4))) break block13;
                        var11_11 = this.this$0;
                        var7_7 = var11_11.fitToContentsOffset;
                        ** GOTO lbl27
                    }
                    var11_11 = this.this$0;
                    var7_7 = var11_11.collapsedOffset;
                    ** GOTO lbl29
                }
                var13_13 = this.this$0;
                var4_4 = var13_13.halfExpandedOffset;
                if (var12_12 >= var4_4) break block14;
                var14_14 = var13_13.collapsedOffset;
                if (var12_12 >= (var14_14 = Math.abs(var12_12 - var14_14))) ** break;
                ** while (true)
                var11_11 = this.this$0;
                var7_7 = var11_11.halfExpandedOffset;
                ** GOTO lbl23
            }
            var14_14 = Math.abs(var12_12 - var4_4);
            var5_5 = this.this$0;
            var4_4 = var5_5.collapsedOffset;
            if (var14_14 < (var12_12 = Math.abs(var12_12 - var4_4))) {
                var11_11 = this.this$0;
                var7_7 = var11_11.halfExpandedOffset;
                ** continue;
            }
            var11_11 = this.this$0;
            var7_7 = var11_11.collapsedOffset;
            ** while (true)
        }
        var13_13 = this.this$0.viewDragHelper;
        var4_4 = var1_1.getLeft();
        var12_12 = (int)var13_13.settleCapturedViewAt(var4_4, var12_12);
        if (var12_12 != 0) {
            var11_11 = this.this$0;
            var14_14 = 2;
            var3_3 = 2.8E-45f;
            var11_11.setStateInternal(var14_14);
            var13_13 = this.this$0;
            var11_11 = new BottomSheetBehavior$SettleRunnable((BottomSheetBehavior)var13_13, (View)var1_1, var8_8);
            ViewCompat.postOnAnimation((View)var1_1, (Runnable)var11_11);
        } else {
            var1_1 = this.this$0;
            var1_1.setStateInternal(var8_8);
        }
    }

    public boolean tryCaptureView(View view, int n10) {
        int n11;
        WeakReference weakReference;
        BottomSheetBehavior bottomSheetBehavior = this.this$0;
        int n12 = bottomSheetBehavior.state;
        int n13 = 1;
        if (n12 == n13) {
            return false;
        }
        int n14 = bottomSheetBehavior.touchingScrollingChild;
        if (n14) {
            return false;
        }
        n14 = 3;
        if (n12 == n14 && (n12 = bottomSheetBehavior.activePointerId) == n10 && (weakReference = (View)bottomSheetBehavior.nestedScrollingChildRef.get()) != null && (n10 = (int)(weakReference.canScrollVertically(n11 = -1) ? 1 : 0)) != 0) {
            return false;
        }
        weakReference = this.this$0.viewRef;
        if (weakReference == null || (weakReference = weakReference.get()) != view) {
            n13 = 0;
        }
        return n13 != 0;
    }
}

