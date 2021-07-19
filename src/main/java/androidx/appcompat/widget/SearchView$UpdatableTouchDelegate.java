/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.view.MotionEvent
 *  android.view.TouchDelegate
 *  android.view.View
 *  android.view.ViewConfiguration
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

public class SearchView$UpdatableTouchDelegate
extends TouchDelegate {
    private final Rect mActualBounds;
    private boolean mDelegateTargeted;
    private final View mDelegateView;
    private final int mSlop;
    private final Rect mSlopBounds;
    private final Rect mTargetBounds;

    public SearchView$UpdatableTouchDelegate(Rect rect, Rect rect2, View view) {
        super(rect, view);
        Rect rect3;
        int n10;
        this.mSlop = n10 = ViewConfiguration.get((Context)view.getContext()).getScaledTouchSlop();
        this.mTargetBounds = rect3 = new Rect();
        this.mSlopBounds = rect3 = new Rect();
        this.mActualBounds = rect3 = new Rect();
        this.setBounds(rect, rect2);
        this.mDelegateView = view;
    }

    /*
     * Unable to fully structure code
     */
    public boolean onTouchEvent(MotionEvent var1_1) {
        block9: {
            block7: {
                block8: {
                    var2_2 = var1_1.getX();
                    var3_3 = (int)var2_2;
                    var4_4 = var1_1.getY();
                    var5_5 = (int)var4_4;
                    var6_6 = var1_1.getAction();
                    var7_7 = 2;
                    var8_8 = 1;
                    var9_9 = false;
                    if (var6_6 == 0) break block7;
                    if (var6_6 == var8_8 || var6_6 == var7_7) break block8;
                    var10_10 = 3;
                    if (var6_6 != var10_10) ** GOTO lbl-1000
                    var6_6 = (int)this.mDelegateTargeted;
                    this.mDelegateTargeted = false;
                    ** GOTO lbl-1000
                }
                var6_6 = (int)this.mDelegateTargeted;
                if (var6_6 != 0 && !(var10_11 = (var11_12 = this.mSlopBounds).contains(var3_3, var5_5))) {
                    var8_8 = var6_6;
                    var6_6 = 0;
                    var12_13 = null;
                } else lbl-1000:
                // 2 sources

                {
                    var13_14 = var8_8;
                    var8_8 = var6_6;
                    var6_6 = var13_14;
                }
                break block9;
            }
            var12_13 = this.mTargetBounds;
            var6_6 = (int)var12_13.contains(var3_3, var5_5);
            if (var6_6 != 0) {
                this.mDelegateTargeted = var8_8;
                var6_6 = var8_8;
            } else lbl-1000:
            // 2 sources

            {
                var6_6 = var8_8;
                var8_8 = 0;
            }
        }
        if (var8_8 != 0) {
            if (var6_6 != 0 && (var6_6 = (int)(var12_13 = this.mActualBounds).contains(var3_3, var5_5)) == 0) {
                var14_15 = this.mDelegateView;
                var3_3 = var14_15.getWidth() / var7_7;
                var2_2 = var3_3;
                var15_16 = this.mDelegateView;
                var5_5 = var15_16.getHeight() / var7_7;
                var4_4 = var5_5;
                var1_1.setLocation(var2_2, var4_4);
            } else {
                var12_13 = this.mActualBounds;
                var7_7 = var12_13.left;
                var2_2 = var3_3 -= var7_7;
                var6_6 = var12_13.top;
                var4_4 = var5_5 -= var6_6;
                var1_1.setLocation(var2_2, var4_4);
            }
            var14_15 = this.mDelegateView;
            var9_9 = var14_15.dispatchTouchEvent(var1_1);
        }
        return var9_9;
    }

    public void setBounds(Rect rect, Rect rect2) {
        this.mTargetBounds.set(rect);
        this.mSlopBounds.set(rect);
        rect = this.mSlopBounds;
        int n10 = this.mSlop;
        int n11 = -n10;
        n10 = -n10;
        rect.inset(n11, n10);
        this.mActualBounds.set(rect2);
    }
}

