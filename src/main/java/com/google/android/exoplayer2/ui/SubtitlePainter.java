/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.Paint$Join
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.graphics.Typeface
 *  android.text.Layout$Alignment
 *  android.text.SpannableStringBuilder
 *  android.text.StaticLayout
 *  android.text.TextPaint
 *  android.text.TextUtils
 *  android.text.style.AbsoluteSizeSpan
 *  android.text.style.BackgroundColorSpan
 *  android.text.style.ForegroundColorSpan
 */
package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import com.google.android.exoplayer2.text.CaptionStyleCompat;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;

public final class SubtitlePainter {
    private static final float INNER_PADDING_RATIO = 0.125f;
    private static final String TAG = "SubtitlePainter";
    private int backgroundColor;
    private final Paint bitmapPaint;
    private Rect bitmapRect;
    private float bottomPaddingFraction;
    private Bitmap cueBitmap;
    private float cueBitmapHeight;
    private float cueLine;
    private int cueLineAnchor;
    private int cueLineType;
    private float cuePosition;
    private int cuePositionAnchor;
    private float cueSize;
    private CharSequence cueText;
    private Layout.Alignment cueTextAlignment;
    private float cueTextSizePx;
    private float defaultTextSizePx;
    private int edgeColor;
    private StaticLayout edgeLayout;
    private int edgeType;
    private int foregroundColor;
    private final float outlineWidth;
    private int parentBottom;
    private int parentLeft;
    private int parentRight;
    private int parentTop;
    private final float shadowOffset;
    private final float shadowRadius;
    private final float spacingAdd;
    private final float spacingMult;
    private StaticLayout textLayout;
    private int textLeft;
    private int textPaddingX;
    private final TextPaint textPaint;
    private int textTop;
    private int windowColor;
    private final Paint windowPaint;

    public SubtitlePainter(Context context) {
        float f10;
        float f11;
        float f12;
        Object object = new int[]{16843287, 16843288};
        object = context.obtainStyledAttributes(null, object, 0, 0);
        this.spacingAdd = f12 = (float)object.getDimensionPixelSize(0, 0);
        boolean bl2 = true;
        this.spacingMult = f11 = object.getFloat((int)(bl2 ? 1 : 0), 1.0f);
        object.recycle();
        this.outlineWidth = f10 = (float)Math.round((float)context.getResources().getDisplayMetrics().densityDpi * 2.0f / 160.0f);
        this.shadowRadius = f10;
        this.shadowOffset = f10;
        this.textPaint = context;
        context.setAntiAlias(bl2);
        context.setSubpixelText(bl2);
        super();
        this.windowPaint = context;
        context.setAntiAlias(bl2);
        object = Paint.Style.FILL;
        context.setStyle((Paint.Style)object);
        super();
        this.bitmapPaint = context;
        context.setAntiAlias(bl2);
        context.setFilterBitmap(bl2);
    }

    private static boolean areCharSequencesEqual(CharSequence charSequence, CharSequence charSequence2) {
        boolean bl2;
        if (!(charSequence == charSequence2 || charSequence != null && (bl2 = charSequence.equals(charSequence2)))) {
            bl2 = false;
            charSequence = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private void drawBitmapLayout(Canvas canvas) {
        Bitmap bitmap = this.cueBitmap;
        Rect rect = this.bitmapRect;
        Paint paint = this.bitmapPaint;
        canvas.drawBitmap(bitmap, null, rect, paint);
    }

    private void drawLayout(Canvas canvas, boolean bl2) {
        if (bl2) {
            this.drawTextLayout(canvas);
        } else {
            Assertions.checkNotNull(this.bitmapRect);
            Bitmap bitmap = this.cueBitmap;
            Assertions.checkNotNull(bitmap);
            this.drawBitmapLayout(canvas);
        }
    }

    private void drawTextLayout(Canvas canvas) {
        block8: {
            Paint paint;
            int n10;
            int n11;
            StaticLayout staticLayout;
            StaticLayout staticLayout2;
            block10: {
                int n12;
                int n13;
                float f10;
                float f11;
                float f12;
                int n14;
                float f13;
                float f14;
                block12: {
                    block11: {
                        block9: {
                            staticLayout2 = this.textLayout;
                            staticLayout = this.edgeLayout;
                            if (staticLayout2 == null || staticLayout == null) break block8;
                            n11 = canvas.save();
                            f14 = this.textLeft;
                            int n15 = this.textTop;
                            float f15 = n15;
                            canvas.translate(f14, f15);
                            n10 = Color.alpha((int)this.windowColor);
                            if (n10 > 0) {
                                paint = this.windowPaint;
                                n15 = this.windowColor;
                                paint.setColor(n15);
                                f13 = -this.textPaddingX;
                                n14 = 0;
                                f12 = 0.0f;
                                n10 = staticLayout2.getWidth();
                                n15 = this.textPaddingX;
                                f11 = n10 + n15;
                                n10 = staticLayout2.getHeight();
                                f10 = n10;
                                Paint paint2 = this.windowPaint;
                                canvas.drawRect(f13, 0.0f, f11, f10, paint2);
                            }
                            n10 = this.edgeType;
                            n15 = 0;
                            f15 = 0.0f;
                            n13 = 1;
                            f13 = Float.MIN_VALUE;
                            if (n10 != n13) break block9;
                            paint = this.textPaint;
                            Paint.Join join = Paint.Join.ROUND;
                            paint.setStrokeJoin(join);
                            paint = this.textPaint;
                            f13 = this.outlineWidth;
                            paint.setStrokeWidth(f13);
                            paint = this.textPaint;
                            n13 = this.edgeColor;
                            paint.setColor(n13);
                            paint = this.textPaint;
                            join = Paint.Style.FILL_AND_STROKE;
                            paint.setStyle((Paint.Style)join);
                            staticLayout.draw(canvas);
                            break block10;
                        }
                        n14 = 2;
                        f12 = 2.8E-45f;
                        if (n10 != n14) break block11;
                        staticLayout = this.textPaint;
                        f14 = this.shadowRadius;
                        f13 = this.shadowOffset;
                        n14 = this.edgeColor;
                        staticLayout.setShadowLayer(f14, f13, f13, n14);
                        break block10;
                    }
                    n14 = 3;
                    f12 = 4.2E-45f;
                    if (n10 == n14) break block12;
                    n12 = 4;
                    f11 = 5.6E-45f;
                    if (n10 != n12) break block10;
                }
                if (n10 != n14) {
                    n13 = 0;
                    Object var17_18 = null;
                    f13 = 0.0f;
                }
                n10 = -1;
                f14 = 0.0f / 0.0f;
                if (n13 != 0) {
                    n14 = n10;
                    f12 = f14;
                } else {
                    n14 = this.edgeColor;
                }
                if (n13 != 0) {
                    n10 = this.edgeColor;
                }
                f13 = this.shadowRadius;
                n12 = 0x40000000;
                f11 = 2.0f;
                TextPaint textPaint = this.textPaint;
                int n16 = this.foregroundColor;
                textPaint.setColor(n16);
                textPaint = this.textPaint;
                Paint.Style style2 = Paint.Style.FILL;
                textPaint.setStyle(style2);
                textPaint = this.textPaint;
                f10 = this.shadowRadius;
                float f16 = -(f13 /= f11);
                textPaint.setShadowLayer(f10, f16, f16, n14);
                staticLayout.draw(canvas);
                staticLayout = this.textPaint;
                f12 = this.shadowRadius;
                staticLayout.setShadowLayer(f12, f13, f13, n10);
            }
            staticLayout = this.textPaint;
            n10 = this.foregroundColor;
            staticLayout.setColor(n10);
            staticLayout = this.textPaint;
            paint = Paint.Style.FILL;
            staticLayout.setStyle((Paint.Style)paint);
            staticLayout2.draw(canvas);
            staticLayout2 = this.textPaint;
            staticLayout = null;
            staticLayout2.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            canvas.restoreToCount(n11);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void setupBitmapLayout() {
        Rect rect;
        float f10;
        int n10;
        int n11;
        block13: {
            float f11;
            block12: {
                int n12;
                int n13;
                block11: {
                    int n14;
                    float f12;
                    block10: {
                        block9: {
                            int n15;
                            block8: {
                                Bitmap bitmap = this.cueBitmap;
                                n15 = this.parentRight;
                                n11 = this.parentLeft;
                                n10 = this.parentBottom;
                                int n16 = this.parentTop;
                                f12 = n11;
                                float f13 = n15 -= n11;
                                float f14 = this.cuePosition * f13;
                                f12 += f14;
                                f10 = n16;
                                f11 = n10 -= n16;
                                f14 = this.cueLine * f11;
                                f10 += f14;
                                f14 = this.cueSize;
                                n15 = Math.round(f13 *= f14);
                                f14 = this.cueBitmapHeight;
                                float f15 = -3.4028235E38f;
                                float f16 = f14 - f15;
                                Object object = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
                                if (object != false) {
                                    n13 = Math.round(f11 *= f14);
                                } else {
                                    f11 = n15;
                                    n12 = bitmap.getHeight();
                                    f14 = n12;
                                    float f17 = bitmap.getWidth();
                                    n13 = Math.round(f11 *= (f14 /= f17));
                                }
                                n10 = this.cuePositionAnchor;
                                n12 = 1;
                                f14 = Float.MIN_VALUE;
                                n14 = 2;
                                f15 = 2.8E-45f;
                                if (n10 != n14) break block8;
                                f11 = n15;
                                break block9;
                            }
                            if (n10 != n12) break block10;
                            n10 = n15 / 2;
                            f11 = n10;
                        }
                        f12 -= f11;
                    }
                    n11 = Math.round(f12);
                    n10 = this.cueLineAnchor;
                    if (n10 != n14) break block11;
                    f11 = n13;
                    break block12;
                }
                if (n10 != n12) break block13;
                n10 = n13 / 2;
                f11 = n10;
            }
            f10 -= f11;
        }
        n10 = Math.round(f10);
        this.bitmapRect = rect = new Rect(n11, n10, n15 += n11, n13 += n10);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void setupTextLayout() {
        block27: {
            block26: {
                block22: {
                    block25: {
                        block24: {
                            block23: {
                                var1_1 = this;
                                var2_2 = this.cueText;
                                var3_3 = var2_2 instanceof SpannableStringBuilder;
                                if (var3_3 != 0) {
                                    var2_2 = (SpannableStringBuilder)var2_2;
                                } else {
                                    var4_4 = this.cueText;
                                    var2_2 = new SpannableStringBuilder(var4_4);
                                }
                                var3_3 = var1_1.parentRight;
                                var5_5 = var1_1.parentLeft;
                                var3_3 -= var5_5;
                                var5_5 = var1_1.parentBottom;
                                var6_6 = var1_1.parentTop;
                                var7_7 = var5_5 - var6_6;
                                var8_8 /* !! */  = var1_1.textPaint;
                                var9_9 = var1_1.defaultTextSizePx;
                                var8_8 /* !! */ .setTextSize(var9_9);
                                var10_10 = var1_1.defaultTextSizePx * 0.125f;
                                var6_6 = 0x3F000000;
                                var11_11 = (int)(var10_10 += 0.5f);
                                var12_12 = var11_11 * 2;
                                var5_5 = var3_3 - var12_12;
                                var9_9 = var1_1.cueSize;
                                var13_13 = -3.4028235E38f;
                                var14_14 /* !! */  = var9_9 == var13_13 ? 0 : (var9_9 > var13_13 ? 1 : -1);
                                if (var14_14 /* !! */  != false) {
                                    var10_10 = (float)var5_5 * var9_9;
                                    var5_5 = (int)var10_10;
                                }
                                var15_15 = var5_5;
                                var16_16 = "SubtitlePainter";
                                if (var5_5 <= 0) {
                                    Log.w(var16_16, "Skipped drawing subtitle cue (insufficient space)");
                                    return;
                                }
                                var10_10 = var1_1.cueTextSizePx;
                                cfr_temp_0 = var10_10 - 0.0f;
                                var5_5 = (int)(cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1));
                                var6_6 = 0xFF0000;
                                var9_9 = 2.3418052E-38f;
                                var17_17 = 0;
                                var18_18 = 0.0f;
                                if (var5_5 > 0) {
                                    var19_19 = var1_1.cueTextSizePx;
                                    var14_14 /* !! */  = (int)var19_19;
                                    var8_8 /* !! */  = new AbsoluteSizeSpan((int)var14_14 /* !! */ );
                                    var14_14 /* !! */  = var2_2.length();
                                    var2_2.setSpan(var8_8 /* !! */ , 0, (int)var14_14 /* !! */ , var6_6);
                                }
                                var20_20 = new SpannableStringBuilder(var2_2);
                                var5_5 = var1_1.edgeType;
                                var21_21 = 1;
                                if (var5_5 == var21_21) {
                                    var5_5 = var20_20.length();
                                    var22_22 = ForegroundColorSpan.class;
                                    var8_8 /* !! */  = (BackgroundColorSpan)var20_20.getSpans(0, var5_5, var22_22);
                                    var14_14 /* !! */  = ((ForegroundColorSpan[])var8_8 /* !! */ ).length;
                                    var24_24 = null;
                                    var25_25 = 0.0f;
                                    for (var23_23 = 0; var23_23 < var14_14 /* !! */ ; ++var23_23) {
                                        var26_26 = var8_8 /* !! */ [var23_23];
                                        var20_20.removeSpan((Object)var26_26);
                                        var21_21 = 1;
                                    }
                                }
                                var5_5 = Color.alpha((int)var1_1.backgroundColor);
                                var21_21 = 2;
                                if (var5_5 > 0) {
                                    var5_5 = var1_1.edgeType;
                                    if (var5_5 != 0 && var5_5 != var21_21) {
                                        var14_14 /* !! */  = var1_1.backgroundColor;
                                        var8_8 /* !! */  = new BackgroundColorSpan((int)var14_14 /* !! */ );
                                        var14_14 /* !! */  = var20_20.length();
                                        var20_20.setSpan((Object)var8_8 /* !! */ , 0, (int)var14_14 /* !! */ , var6_6);
                                    } else {
                                        var14_14 /* !! */  = var1_1.backgroundColor;
                                        var8_8 /* !! */  = new BackgroundColorSpan((int)var14_14 /* !! */ );
                                        var14_14 /* !! */  = var2_2.length();
                                        var2_2.setSpan(var8_8 /* !! */ , 0, (int)var14_14 /* !! */ , var6_6);
                                    }
                                }
                                if ((var8_8 /* !! */  = var1_1.cueTextAlignment) == null) {
                                    var8_8 /* !! */  = Layout.Alignment.ALIGN_CENTER;
                                }
                                var27_27 = var8_8 /* !! */ ;
                                var22_22 = var1_1.textPaint;
                                var9_9 = var1_1.spacingMult;
                                var10_10 = var1_1.spacingAdd;
                                var28_28 = true;
                                var8_8 /* !! */  = var24_24;
                                var29_29 = var2_2;
                                var23_23 = var15_15;
                                var26_26 = var27_27;
                                var30_30 = var20_20;
                                var31_31 = var9_9;
                                var32_32 = var11_11;
                                var11_11 = 0;
                                var18_18 = var10_10;
                                var33_33 = var16_16;
                                var1_1.textLayout = var24_24 = new StaticLayout(var2_2, var22_22, var15_15, (Layout.Alignment)var27_27, var9_9, var10_10, var28_28);
                                var5_5 = var24_24.getHeight();
                                var29_29 = var1_1.textLayout;
                                var6_6 = var29_29.getLineCount();
                                var14_14 /* !! */  = (float)false;
                                var19_19 = 0.0f;
                                var22_22 = null;
                                var18_18 = 0.0f;
                                for (var17_17 = 0; var17_17 < var6_6; ++var17_17) {
                                    var24_24 = var1_1.textLayout;
                                    var25_25 = var24_24.getLineWidth(var17_17);
                                    var34_34 = Math.ceil(var25_25);
                                    var23_23 = (int)var34_34;
                                    var14_14 /* !! */  = Math.max(var23_23, (int)var14_14 /* !! */ );
                                }
                                var9_9 = var1_1.cueSize;
                                var23_23 = -8388609;
                                var25_25 = -3.4028235E38f;
                                cfr_temp_1 = var9_9 - var25_25;
                                var6_6 = (int)(cfr_temp_1 == 0.0f ? 0 : (cfr_temp_1 > 0.0f ? 1 : -1));
                                if (var6_6 == 0 || var14_14 /* !! */  >= var15_15) {
                                    var15_15 = (int)var14_14 /* !! */ ;
                                }
                                var15_15 += var12_12;
                                var9_9 = var1_1.cuePosition;
                                var14_14 /* !! */  = var9_9 == var25_25 ? 0 : (var9_9 > var25_25 ? 1 : -1);
                                if (var14_14 /* !! */  != false) {
                                    var36_35 = (float)var3_3 * var9_9;
                                    var3_3 = Math.round(var36_35);
                                    var6_6 = var1_1.parentLeft;
                                    var3_3 += var6_6;
                                    var14_14 /* !! */  = var1_1.cuePositionAnchor;
                                    var23_23 = 1;
                                    var25_25 = 1.4E-45f;
                                    if (var14_14 /* !! */  != var23_23) {
                                        var21_21 = 2;
                                        if (var14_14 /* !! */  == var21_21) {
                                            var3_3 -= var15_15;
                                        }
                                    } else {
                                        var21_21 = 2;
                                        var3_3 = (var3_3 * 2 - var15_15) / var21_21;
                                    }
                                    var3_3 = Math.max(var3_3, var6_6);
                                    var6_6 = var1_1.parentRight;
                                    var6_6 = Math.min(var15_15 += var3_3, var6_6);
                                } else {
                                    var23_23 = 1;
                                    var25_25 = 1.4E-45f;
                                    var21_21 = 2;
                                    var3_3 = (var3_3 - var15_15) / var21_21;
                                    var6_6 = var1_1.parentLeft;
                                    var3_3 += var6_6;
                                    var6_6 = var3_3 + var15_15;
                                }
                                var37_36 = var6_6 - var3_3;
                                if (var37_36 <= 0) {
                                    Log.w(var33_33, "Skipped drawing subtitle cue (invalid horizontal positioning)");
                                    return;
                                }
                                var9_9 = var1_1.cueLine;
                                var19_19 = -3.4028235E38f;
                                cfr_temp_2 = var9_9 - var19_19;
                                var14_14 /* !! */  = (float)(cfr_temp_2 == 0.0f ? 0 : (cfr_temp_2 > 0.0f ? 1 : -1));
                                if (var14_14 /* !! */  == false) break block22;
                                var14_14 /* !! */  = var1_1.cueLineType;
                                if (var14_14 /* !! */  != false) break block23;
                                var19_19 = (float)var7_7 * var9_9;
                                var6_6 = Math.round(var19_19);
                                var14_14 /* !! */  = var1_1.parentTop;
                                var6_6 += var14_14 /* !! */ ;
                                var14_14 /* !! */  = var1_1.cueLineAnchor;
                                if (var14_14 /* !! */  == var21_21) ** GOTO lbl187
                                if (var14_14 /* !! */  == var23_23) {
                                    var6_6 = (var6_6 * 2 - var5_5) / var21_21;
                                }
                                break block24;
                            }
                            var29_29 = var1_1.textLayout;
                            var22_22 = null;
                            var6_6 = var29_29.getLineBottom(0);
                            var24_24 = var1_1.textLayout;
                            var14_14 /* !! */  = var24_24.getLineTop(0);
                            var6_6 -= var14_14 /* !! */ ;
                            var19_19 = var1_1.cueLine;
                            cfr_temp_3 = var19_19 - 0.0f;
                            var23_23 = (int)(cfr_temp_3 == 0.0f ? 0 : (cfr_temp_3 > 0.0f ? 1 : -1));
                            if (var23_23 >= 0) {
                                var9_9 = var6_6;
                                var6_6 = Math.round(var19_19 *= var9_9);
                                var14_14 /* !! */  = var1_1.parentTop;
                                var6_6 += var14_14 /* !! */ ;
                            } else {
                                var23_23 = 1065353216;
                                var25_25 = 1.0f;
                                var19_19 += var25_25;
                                var9_9 = var6_6;
                                var6_6 = Math.round(var19_19 *= var9_9);
                                var14_14 /* !! */  = var1_1.parentBottom;
                                var6_6 += var14_14 /* !! */ ;
lbl187:
                                // 2 sources

                                var6_6 -= var5_5;
                            }
                        }
                        if ((var14_14 /* !! */  = (float)(var6_6 + var5_5)) <= (var23_23 = var1_1.parentBottom)) break block25;
                        var6_6 = var23_23 - var5_5;
                        break block26;
                    }
                    var5_5 = var1_1.parentTop;
                    if (var6_6 >= var5_5) break block26;
                    var7_7 = var5_5;
                    break block27;
                }
                var6_6 = var1_1.parentBottom - var5_5;
                var10_10 = var7_7;
                var19_19 = var1_1.bottomPaddingFraction;
                var5_5 = (int)(var10_10 *= var19_19);
                var6_6 -= var5_5;
            }
            var7_7 = var6_6;
        }
        var22_22 = var1_1.textPaint;
        var31_31 = var1_1.spacingMult;
        var18_18 = var1_1.spacingAdd;
        var8_8 /* !! */  = var33_33;
        var29_29 = var2_2;
        var23_23 = var37_36;
        var26_26 = var27_27;
        var33_33 = new StaticLayout(var2_2, var22_22, var37_36, (Layout.Alignment)var27_27, var31_31, var18_18, true);
        var1_1.textLayout = var33_33;
        var8_8 /* !! */  = var1_1.textPaint;
        var9_9 = var1_1.spacingMult;
        var19_19 = var1_1.spacingAdd;
        var2_2 = new StaticLayout((CharSequence)var30_30, (TextPaint)var8_8 /* !! */ , var37_36, (Layout.Alignment)var27_27, var9_9, var19_19, true);
        var1_1.edgeLayout = var2_2;
        var1_1.textLeft = var3_3;
        var1_1.textTop = var7_7;
        var1_1.textPaddingX = var32_32;
    }

    public void draw(Cue object, CaptionStyleCompat captionStyleCompat, float f10, float f11, float f12, Canvas canvas, int n10, int n11, int n12, int n13) {
        int n14;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        int n15;
        float f20;
        float f21;
        float f22;
        Object object2;
        Object object3;
        int n16;
        boolean bl2;
        Bitmap bitmap = ((Cue)object).bitmap;
        if (bitmap == null) {
            bl2 = true;
        } else {
            bl2 = false;
            bitmap = null;
        }
        int n17 = -16777216;
        if (bl2) {
            CharSequence charSequence = ((Cue)object).text;
            n17 = (int)(TextUtils.isEmpty((CharSequence)charSequence) ? 1 : 0);
            if (n17 != 0) {
                return;
            }
            n17 = (int)(((Cue)object).windowColorSet ? 1 : 0);
            n17 = n17 != 0 ? ((Cue)object).windowColor : captionStyleCompat.windowColor;
        }
        if ((n16 = SubtitlePainter.areCharSequencesEqual((CharSequence)(object3 = this.cueText), (CharSequence)(object2 = ((Cue)object).text))) != 0 && (n16 = Util.areEqual(object3 = this.cueTextAlignment, object2 = ((Cue)object).textAlignment)) != 0 && (object3 = this.cueBitmap) == (object2 = ((Cue)object).bitmap) && (n16 = (int)((f22 = (f21 = this.cueLine) - (f20 = ((Cue)object).line)) == 0.0f ? 0 : (f22 > 0.0f ? 1 : -1))) == 0 && (n16 = this.cueLineType) == (n15 = ((Cue)object).lineType) && (n16 = (int)(Util.areEqual(object3 = Integer.valueOf(this.cueLineAnchor), object2 = Integer.valueOf(n15 = ((Cue)object).lineAnchor)) ? 1 : 0)) != 0 && (n16 = (int)((f19 = (f21 = this.cuePosition) - (f20 = ((Cue)object).position)) == 0.0f ? 0 : (f19 > 0.0f ? 1 : -1))) == 0 && (n16 = (int)(Util.areEqual(object3 = Integer.valueOf(this.cuePositionAnchor), object2 = Integer.valueOf(n15 = ((Cue)object).positionAnchor)) ? 1 : 0)) != 0 && (n16 = (int)((f18 = (f21 = this.cueSize) - (f20 = ((Cue)object).size)) == 0.0f ? 0 : (f18 > 0.0f ? 1 : -1))) == 0 && (n16 = (int)((f17 = (f21 = this.cueBitmapHeight) - (f20 = ((Cue)object).bitmapHeight)) == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1))) == 0 && (n16 = this.foregroundColor) == (n15 = captionStyleCompat.foregroundColor) && (n16 = this.backgroundColor) == (n15 = captionStyleCompat.backgroundColor) && (n16 = this.windowColor) == n17 && (n16 = this.edgeType) == (n15 = captionStyleCompat.edgeType) && (n16 = this.edgeColor) == (n15 = captionStyleCompat.edgeColor) && (n16 = (int)(Util.areEqual(object3 = this.textPaint.getTypeface(), object2 = captionStyleCompat.typeface) ? 1 : 0)) != 0 && (n16 = (int)((f16 = (f21 = this.defaultTextSizePx) - f10) == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1))) == 0 && (n16 = (int)((f15 = (f21 = this.cueTextSizePx) - f11) == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1))) == 0 && (n16 = (int)((f14 = (f21 = this.bottomPaddingFraction) - f12) == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1))) == 0 && (n16 = this.parentLeft) == n10 && (n16 = this.parentTop) == n11 && (n16 = this.parentRight) == n12 && (n16 = this.parentBottom) == n13) {
            this.drawLayout(canvas, bl2);
            return;
        }
        object3 = ((Cue)object).text;
        this.cueText = object3;
        object3 = ((Cue)object).textAlignment;
        this.cueTextAlignment = object3;
        object3 = ((Cue)object).bitmap;
        this.cueBitmap = object3;
        this.cueLine = f21 = ((Cue)object).line;
        this.cueLineType = n16 = ((Cue)object).lineType;
        this.cueLineAnchor = n16 = ((Cue)object).lineAnchor;
        this.cuePosition = f21 = ((Cue)object).position;
        this.cuePositionAnchor = n16 = ((Cue)object).positionAnchor;
        this.cueSize = f21 = ((Cue)object).size;
        this.cueBitmapHeight = f13 = ((Cue)object).bitmapHeight;
        this.foregroundColor = n14 = captionStyleCompat.foregroundColor;
        this.backgroundColor = n14 = captionStyleCompat.backgroundColor;
        this.windowColor = n17;
        this.edgeType = n14 = captionStyleCompat.edgeType;
        this.edgeColor = n14 = captionStyleCompat.edgeColor;
        object = this.textPaint;
        captionStyleCompat = captionStyleCompat.typeface;
        object.setTypeface((Typeface)captionStyleCompat);
        this.defaultTextSizePx = f10;
        this.cueTextSizePx = f11;
        this.bottomPaddingFraction = f12;
        this.parentLeft = n10;
        this.parentTop = n11;
        this.parentRight = n12;
        this.parentBottom = n13;
        if (bl2) {
            object = this.cueText;
            Assertions.checkNotNull(object);
            this.setupTextLayout();
        } else {
            object = this.cueBitmap;
            Assertions.checkNotNull(object);
            this.setupBitmapLayout();
        }
        this.drawLayout(canvas, bl2);
    }
}

