/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View$MeasureSpec
 *  android.widget.FrameLayout
 */
package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout$AspectRatioListener;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout$AspectRatioUpdateDispatcher;
import com.google.android.exoplayer2.ui.R$styleable;

public final class AspectRatioFrameLayout
extends FrameLayout {
    private static final float MAX_ASPECT_RATIO_DEFORMATION_FRACTION = 0.01f;
    public static final int RESIZE_MODE_FILL = 3;
    public static final int RESIZE_MODE_FIT = 0;
    public static final int RESIZE_MODE_FIXED_HEIGHT = 2;
    public static final int RESIZE_MODE_FIXED_WIDTH = 1;
    public static final int RESIZE_MODE_ZOOM = 4;
    private AspectRatioFrameLayout$AspectRatioListener aspectRatioListener;
    private final AspectRatioFrameLayout$AspectRatioUpdateDispatcher aspectRatioUpdateDispatcher;
    private int resizeMode = 0;
    private float videoAspectRatio;

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public AspectRatioFrameLayout(Context object, AttributeSet attributeSet) {
        super(object, attributeSet);
        if (attributeSet != null) {
            object = object.getTheme();
            int[] nArray = R$styleable.AspectRatioFrameLayout;
            object = object.obtainStyledAttributes(attributeSet, nArray, 0, 0);
            try {
                int n10 = R$styleable.AspectRatioFrameLayout_resize_mode;
                this.resizeMode = n10 = object.getInt(n10, 0);
            }
            finally {
                object.recycle();
            }
        }
        super(this, null);
        this.aspectRatioUpdateDispatcher = object;
    }

    public static /* synthetic */ AspectRatioFrameLayout$AspectRatioListener access$100(AspectRatioFrameLayout aspectRatioFrameLayout) {
        return aspectRatioFrameLayout.aspectRatioListener;
    }

    public int getResizeMode() {
        return this.resizeMode;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void onMeasure(int var1_1, int var2_2) {
        block5: {
            block6: {
                block11: {
                    block7: {
                        block10: {
                            block8: {
                                block9: {
                                    super.onMeasure(var1_1, var2_2);
                                    var3_3 = this.videoAspectRatio;
                                    var2_2 = 0;
                                    var4_4 = 0.0f;
                                    var5_5 = null;
                                    cfr_temp_0 = var3_3 - 0.0f;
                                    var1_1 = (int)(cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 < 0.0f ? -1 : 1));
                                    if (var1_1 <= 0) {
                                        return;
                                    }
                                    var1_1 = this.getMeasuredWidth();
                                    var6_6 = this.getMeasuredHeight();
                                    var7_7 = var1_1;
                                    var8_8 = var6_6;
                                    var9_9 = var7_7 / var8_8;
                                    var10_10 = this.videoAspectRatio / var9_9 - 1.0f;
                                    var11_11 = Math.abs(var10_10);
                                    var12_12 = 1008981770 != 0;
                                    var13_13 = 0.01f;
                                    cfr_temp_1 = var11_11 - var13_13;
                                    var14_14 /* !! */  = (float)(cfr_temp_1 == 0.0f ? 0 : (cfr_temp_1 < 0.0f ? -1 : 1));
                                    if (var14_14 /* !! */  <= 0) {
                                        var15_15 = this.aspectRatioUpdateDispatcher;
                                        var4_4 = this.videoAspectRatio;
                                        var15_15.scheduleUpdate(var4_4, var9_9, false);
                                        return;
                                    }
                                    var14_14 /* !! */  = this.resizeMode;
                                    var12_12 = true;
                                    var13_13 = 1.4E-45f;
                                    if (var14_14 /* !! */  == false) break block6;
                                    if (var14_14 /* !! */  == var12_12) break block7;
                                    var16_16 = 2;
                                    if (var14_14 /* !! */  == var16_16) break block8;
                                    var16_16 = 4;
                                    if (var14_14 /* !! */  != var16_16) break block5;
                                    cfr_temp_2 = var10_10 - 0.0f;
                                    var2_2 = (int)(cfr_temp_2 == 0.0f ? 0 : (cfr_temp_2 > 0.0f ? 1 : -1));
                                    if (var2_2 <= 0) break block9;
                                    var3_3 = this.videoAspectRatio;
                                    break block10;
                                }
                                var4_4 = this.videoAspectRatio;
                                break block11;
                            }
                            var3_3 = this.videoAspectRatio;
                        }
lbl46:
                        // 2 sources

                        while (true) {
                            var1_1 = (int)(var8_8 *= var3_3);
                            break block5;
                            break;
                        }
                    }
                    var4_4 = this.videoAspectRatio;
                }
lbl52:
                // 2 sources

                while (true) {
                    var6_6 = (int)(var7_7 /= var4_4);
                    break block5;
                    break;
                }
            }
            cfr_temp_3 = var10_10 - 0.0f;
            var2_2 = (int)(cfr_temp_3 == 0.0f ? 0 : (cfr_temp_3 > 0.0f ? 1 : -1));
            if (var2_2 > 0) {
                var4_4 = this.videoAspectRatio;
                ** continue;
            }
            var3_3 = this.videoAspectRatio;
            ** while (true)
        }
        var5_5 = this.aspectRatioUpdateDispatcher;
        var7_7 = this.videoAspectRatio;
        var5_5.scheduleUpdate(var7_7, var9_9, var12_12);
        var2_2 = 0x40000000;
        var1_1 = View.MeasureSpec.makeMeasureSpec((int)var1_1, (int)var2_2);
        var2_2 = View.MeasureSpec.makeMeasureSpec((int)var6_6, (int)var2_2);
        super.onMeasure(var1_1, var2_2);
    }

    public void setAspectRatio(float f10) {
        float f11 = this.videoAspectRatio;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.videoAspectRatio = f10;
            this.requestLayout();
        }
    }

    public void setAspectRatioListener(AspectRatioFrameLayout$AspectRatioListener aspectRatioFrameLayout$AspectRatioListener) {
        this.aspectRatioListener = aspectRatioFrameLayout$AspectRatioListener;
    }

    public void setResizeMode(int n10) {
        int n11 = this.resizeMode;
        if (n11 != n10) {
            this.resizeMode = n10;
            this.requestLayout();
        }
    }
}

