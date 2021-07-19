/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Paint$FontMetrics
 *  android.graphics.Path
 *  android.graphics.PointF
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Typeface
 *  android.os.Build$VERSION
 *  android.text.Layout
 *  android.text.Layout$Alignment
 *  android.text.StaticLayout
 *  android.text.StaticLayout$Builder
 *  android.text.TextPaint
 *  android.util.Log
 */
package com.cdv.text;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.Log;
import com.cdv.text.NvAndroidTextLayout$GlyphInfo;
import com.cdv.text.NvAndroidTextLayout$InternalGlyphInfo;
import com.cdv.text.NvAndroidTextLayout$LineGlyphPositioner;
import com.cdv.text.NvAndroidTextLayout$VerticalLayoutContext;
import com.cdv.text.NvAndroidTextLayout$VerticalLayoutContext$LineInfo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

public class NvAndroidTextLayout {
    public static final int AlignBottom = 64;
    public static final int AlignHCenter = 4;
    public static final int AlignJustify = 8;
    public static final int AlignLeft = 1;
    public static final int AlignRight = 2;
    public static final int AlignTop = 32;
    public static final int AlignVCenter = 128;
    private static final String TAG = "NvAndroidTextLayout";
    private static final boolean m_verbose = false;
    private int m_align;
    private boolean m_glyphInfoPrepared;
    private ArrayList m_glyphLines;
    private RectF[] m_glyphLinesBounding;
    private float m_hozUnderlineInterval;
    private int m_innerAlign;
    private StaticLayout m_layout;
    private boolean m_measureBoundingOnly;
    private TextPaint m_paint;
    private String m_text;
    private RectF m_textBounding;
    private boolean m_underline;
    private float m_underlineWidth;
    private boolean m_verticalText;
    private float m_yOffset;

    public NvAndroidTextLayout(String string2, Typeface typeface, TextPaint textPaint, float f10, boolean bl2, float f11, int n10, int n11, boolean bl3, int n12, int n13, boolean bl4, boolean bl5, boolean bl6) {
        String string3 = string2;
        float f12 = 0.0f;
        Object object = null;
        this.m_verticalText = false;
        this.m_underline = false;
        this.m_measureBoundingOnly = false;
        this.m_align = 129;
        this.m_innerAlign = 1;
        String string4 = null;
        this.m_yOffset = 0.0f;
        this.m_glyphInfoPrepared = false;
        this.m_underlineWidth = 0.0f;
        this.m_hozUnderlineInterval = 0.0f;
        this.m_paint = textPaint;
        this.m_verticalText = bl4;
        this.m_underline = bl5;
        this.m_measureBoundingOnly = bl6;
        if (string2 == null) {
            return;
        }
        this.m_text = string2;
        this.m_align = n10;
        this.m_innerAlign = n11;
        float f13 = textPaint.getTextSize();
        f12 = 0.05f;
        f13 *= f12;
        this.m_underlineWidth = f13;
        string3 = "X";
        f13 = textPaint.measureText(string3) * f12;
        this.m_hozUnderlineInterval = f13;
        object = this;
        string4 = typeface;
        try {
            this.initLayout(typeface, textPaint, f10, bl2, f11, bl3, n12, n13);
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append("");
            string4 = exception.getMessage();
            ((StringBuilder)object).append(string4);
            object = ((StringBuilder)object).toString();
            string4 = TAG;
            Log.e((String)string4, (String)object);
            exception.printStackTrace();
        }
    }

    private void initLayout(Typeface typeface, TextPaint textPaint, float f10, boolean bl2, float f11, boolean bl3, int n10, int n11) {
        int n12;
        float f12;
        String string2;
        int n13;
        int n14;
        NvAndroidTextLayout nvAndroidTextLayout = this;
        Object object = textPaint;
        int n15 = n11;
        if (bl3 && (n14 = this.m_verticalText) == 0) {
            n13 = n10;
        } else {
            string2 = nvAndroidTextLayout.m_text;
            f12 = Layout.getDesiredWidth((CharSequence)string2, (TextPaint)object);
            double d10 = Math.ceil(f12);
            n13 = n14 = (int)d10;
        }
        string2 = Layout.Alignment.ALIGN_NORMAL;
        int n16 = nvAndroidTextLayout.m_align & 4;
        if (n16 != 0) {
            string2 = Layout.Alignment.ALIGN_CENTER;
        }
        String string3 = string2;
        n14 = Build.VERSION.SDK_INT;
        n16 = 23;
        float f13 = 3.2E-44f;
        if (n14 >= n16) {
            string2 = nvAndroidTextLayout.m_text;
            n16 = string2.length();
            n12 = 0;
            object = StaticLayout.Builder.obtain((CharSequence)string2, (int)0, (int)n16, (TextPaint)object, (int)n13);
            object.setAlignment((Layout.Alignment)string3);
            n14 = 1065353216;
            f12 = 1.0f;
            object.setLineSpacing(f11, f12);
            object.setIncludePad(false);
            object = object.build();
        } else {
            String string4 = nvAndroidTextLayout.m_text;
            float f14 = 1.0f;
            string2 = new StaticLayout((CharSequence)string4, textPaint, n13, (Layout.Alignment)string3, f14, f11, false);
            object = string2;
        }
        n14 = object.getHeight();
        f12 = n14;
        n16 = nvAndroidTextLayout.m_align;
        n12 = n16 & 0x40;
        if (n12 != 0) {
            nvAndroidTextLayout.m_yOffset = f13 = (float)n15 - f12;
        } else if ((n16 &= 0x80) != 0) {
            f13 = (float)n15 - f12;
            n14 = 0x40000000;
            f12 = 2.0f;
            nvAndroidTextLayout.m_yOffset = f13 /= f12;
        }
        nvAndroidTextLayout.m_layout = object;
        int n17 = nvAndroidTextLayout.m_verticalText;
        if (n17 != 0) {
            this.prepareGlyphLines();
            n17 = n10;
            float f15 = n10;
            float f16 = n15;
            NvAndroidTextLayout nvAndroidTextLayout2 = this;
            n14 = (int)(bl3 ? 1 : 0);
            f13 = f10;
            n12 = (int)(bl2 ? 1 : 0);
            try {
                this.layoutVertically(bl3, f10, bl2, f11, f15, f16);
            }
            catch (Exception exception) {
                object = new StringBuilder();
                ((StringBuilder)object).append("");
                string2 = exception.getMessage();
                ((StringBuilder)object).append(string2);
                object = ((StringBuilder)object).toString();
                string2 = TAG;
                Log.e((String)string2, (String)object);
                exception.printStackTrace();
            }
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void internalPrepareGlyphLines() {
        block49: {
            block48: {
                block45: {
                    var1_1 = this;
                    var2_2 = this.m_glyphInfoPrepared;
                    if (var2_2 != 0) {
                        return;
                    }
                    var2_2 = 1;
                    var3_3 = 1.4E-45f;
                    this.m_glyphInfoPrepared = var2_2;
                    var4_4 = this.m_layout;
                    if (var4_4 == null) {
                        return;
                    }
                    var4_4 = var4_4.getPaint().getFontMetrics();
                    var5_5 = var4_4.ascent;
                    var6_6 = var4_4.descent;
                    var7_7 = this.m_layout.getPaint().getTypeface();
                    var8_8 = 0;
                    var9_9 = 0.0f;
                    var10_10 = null;
                    if (var7_7 != null && (var11_11 = (var7_7 = this.m_layout.getPaint().getTypeface()).isItalic()) != 0 || (var11_11 = (cfr_temp_0 = (var12_12 = (var7_7 = var1_1.m_layout.getPaint()).getTextSkewX()) - 0.0f) == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1)) != 0) {
                        var11_11 = var2_2;
                        var12_12 = var3_3;
                    } else {
                        var11_11 = 0;
                        var12_12 = 0.0f;
                        var7_7 = null;
                    }
                    var13_13 = new RectF();
                    var1_1.m_textBounding = var13_13;
                    var13_13 = var1_1.m_layout;
                    var14_14 = var13_13.getLineCount();
                    var15_15 = new RectF[var14_14];
                    var1_1.m_glyphLinesBounding = var15_15;
                    var15_15 = new ArrayList();
                    var1_1.m_glyphLines = var15_15;
                    var16_16 = 0;
                    var17_17 = null;
                    var18_18 = 0.0f;
                    var19_19 = 0;
                    var20_20 = 0.0f;
                    var15_15 = null;
                    while (var19_19 < var14_14) {
                        block43: {
                            var21_21 = var1_1.m_glyphLinesBounding;
                            var21_21[var19_19] = var22_22 /* !! */  = new RectF();
                            var21_21 = new ArrayList();
                            var1_1.m_glyphLines.add(var21_21);
                            var22_22 /* !! */  = var1_1.m_layout;
                            var23_23 = var22_22 /* !! */ .getLineBaseline(var19_19);
                            var24_24 = var1_1.m_layout;
                            var25_25 = var24_24.getLineStart(var19_19);
                            var26_26 /* !! */  = var1_1.m_layout;
                            var27_27 = var26_26 /* !! */ .getLineEnd(var19_19);
                            var28_28 = var27_27 - var25_25;
                            var29_29 /* !! */  = new float[var28_28];
                            var30_30 = var1_1.m_layout.getPaint();
                            var10_10 = var1_1.m_text;
                            var2_2 = var30_30.getTextWidths((String)var10_10, var25_25, var27_27, var29_29 /* !! */ );
                            if (var2_2 != var28_28) {
                                var30_30 = "NvAndroidTextLayout";
                                var10_10 = "Paint.getTextWidths() return unexpected value!";
                                Log.w((String)var30_30, (String)var10_10);
                            }
                            var30_30 = new ArrayList();
                            var28_28 = var25_25;
                            var8_8 = 1;
                            var9_9 = 1.4E-45f;
                            while (var28_28 < var27_27) {
                                var31_31 = var28_28 + 1;
                                var32_32 = var14_14;
                                for (var14_14 = var31_31; var14_14 < var27_27; ++var14_14) {
                                    var31_31 = var14_14 - var25_25;
                                    var33_33 = var29_29 /* !! */ [var31_31];
                                    cfr_temp_1 = var33_33 - 0.0f;
                                    if ((var31_31 = (int)(cfr_temp_1 == 0.0f ? 0 : (cfr_temp_1 > 0.0f ? 1 : -1))) != 0) break;
                                }
                                var33_33 = var18_18;
                                var16_16 = var14_14 - var28_28;
                                var34_34 = var19_19;
                                var19_19 = 1;
                                var20_20 = 1.4E-45f;
                                if (var16_16 == var19_19) {
                                    var15_15 = var1_1.m_text;
                                    var19_19 = var15_15.charAt(var28_28);
                                    var16_16 = 10;
                                    var18_18 = 1.4E-44f;
                                    if (var19_19 == var16_16) break block43;
                                }
                                var15_15 = new NvAndroidTextLayout$InternalGlyphInfo(null);
                                var15_15.startCharIdx = var28_28;
                                var15_15.endCharIdx = var14_14;
                                var16_16 = var28_28 - var25_25;
                                var15_15.advance = var18_18 = var29_29 /* !! */ [var16_16];
                                var17_17 = var1_1.m_layout;
                                var16_16 = (int)var17_17.isRtlCharAt(var28_28);
                                var15_15.isRtl = var16_16;
                                if (var16_16 != 0) {
                                    var8_8 = 0;
                                    var9_9 = 0.0f;
                                    var10_10 = null;
                                }
                                var30_30.add(var15_15);
                                var28_28 = var14_14;
                                var18_18 = var33_33;
                                var14_14 = var32_32;
                                var19_19 = var34_34;
                            }
                            var32_32 = var14_14;
                            var34_34 = var19_19;
                            var33_33 = var18_18;
                        }
                        var13_13 = var30_30.iterator();
                        while ((var19_19 = (int)var13_13.hasNext()) != 0) {
                            var15_15 = (NvAndroidTextLayout$InternalGlyphInfo)var13_13.next();
                            var16_16 = (int)var1_1.m_measureBoundingOnly;
                            if (var16_16 == 0) {
                                var17_17 = var1_1.m_layout;
                                var28_28 = var15_15.startCharIdx;
                                var15_15.primaryHorizontal = var18_18 = var17_17.getPrimaryHorizontal(var28_28);
                                if (var8_8 != 0) continue;
                                var17_17 = var1_1.m_layout;
                                var28_28 = var15_15.startCharIdx;
                                var15_15.secondaryHorizontal = var18_18 = var17_17.getSecondaryHorizontal(var28_28);
                                continue;
                            }
                            var16_16 = 0;
                            var18_18 = 0.0f;
                            var17_17 = null;
                            var15_15.primaryHorizontal = 0.0f;
                        }
                        var13_13 = new NvAndroidTextLayout$LineGlyphPositioner((ArrayList)var30_30, (boolean)var8_8);
                        var8_8 = 0;
                        var9_9 = 0.0f;
                        var10_10 = null;
                        while (var8_8 < (var19_19 = var30_30.size())) {
                            var15_15 = (NvAndroidTextLayout$InternalGlyphInfo)var30_30.get(var8_8);
                            var16_16 = var15_15.startCharIdx;
                            var28_28 = var15_15.endCharIdx;
                            var35_35 = var30_30;
                            var30_30 = new NvAndroidTextLayout$GlyphInfo();
                            var30_30.startCharIdx = var16_16;
                            var30_30.endCharIdx = var28_28;
                            var30_30.lineStart = var25_25;
                            var30_30.lineEnd = var27_27;
                            var36_36 = var27_27;
                            var30_30.colorGlyph = false;
                            var26_26 /* !! */  = var1_1.m_text;
                            var27_27 = (int)var1_1.mayHaveContextualForm((String)var26_26 /* !! */ , var16_16, var28_28);
                            var30_30.mayHaveContextualForm = var27_27;
                            var19_19 = (int)var15_15.isRtl;
                            var30_30.isRtl = var19_19;
                            var20_20 = var13_13.nextGlyphPosition();
                            var37_37 = var13_13;
                            var38_38 = var23_23;
                            var39_39 = var23_23;
                            var40_40 = var1_1.m_yOffset;
                            var26_26 /* !! */  = new PointF(var20_20, var38_38 += var40_40);
                            var30_30.pos = var26_26 /* !! */ ;
                            var13_13 = new RectF();
                            var30_30.bounding = var13_13;
                            var13_13 = new RectF();
                            var30_30.typographicBounding = var13_13;
                            var13_13 = new Path();
                            var30_30.glyphPath = var13_13;
                            var41_41 = var1_1.m_layout.getPaint();
                            var13_13 = var1_1.m_text;
                            var22_22 /* !! */  = var30_30.pos;
                            var42_42 = var22_22 /* !! */ .x;
                            var40_40 = var22_22 /* !! */ .y;
                            var43_43 = var8_8;
                            var10_10 = var30_30.glyphPath;
                            var41_41.getTextPath((String)var13_13, var16_16, var28_28, var42_42, var40_40, (Path)var10_10);
                            var10_10 = var30_30.glyphPath;
                            var8_8 = (int)var10_10.isEmpty();
                            if (var8_8 == 0) {
                                var8_8 = (int)var30_30.mayHaveContextualForm;
                                if (var8_8 == 0) {
                                    var10_10 = var30_30.glyphPath;
                                    var13_13 = var30_30.bounding;
                                    var27_27 = 0;
                                    var42_42 = 0.0f;
                                    var26_26 /* !! */  = null;
                                    var10_10.computeBounds((RectF)var13_13, false);
                                } else {
                                    var27_27 = 0;
                                    var42_42 = 0.0f;
                                    var26_26 /* !! */  = null;
                                    var9_9 = var29_29 /* !! */ [var16_16 -= var25_25];
                                    var13_13 = var30_30.bounding;
                                    var13_13.left = var20_20;
                                    var13_13.right = var20_20 += var9_9;
                                    if (var11_11 != 0) {
                                        var16_16 = 1050253722;
                                        var18_18 = 0.3f;
                                        var8_8 = (int)(var9_9 * var18_18);
                                        var9_9 = var8_8;
                                        var13_13.right = var20_20 += var9_9;
                                    }
                                    var10_10 = var30_30.pos;
                                    var9_9 = var10_10.y;
                                    var13_13.top = var20_20 = var4_4.ascent + var9_9;
                                    var20_20 = var4_4.descent;
                                    var13_13.bottom = var9_9 += var20_20;
                                }
                            } else {
                                var27_27 = 0;
                                var42_42 = 0.0f;
                                var26_26 /* !! */  = null;
                                var10_10 = var1_1.m_text;
                                var8_8 = (int)var1_1.isSuspectableColorGlyph((String)var10_10, var16_16, var28_28);
                                if (var8_8 != 0) {
                                    var8_8 = 1;
                                    var9_9 = 1.4E-45f;
                                    var30_30.colorGlyph = var8_8;
                                }
                                var10_10 = new Rect();
                                var13_13 = var1_1.m_layout.getPaint();
                                var15_15 = var1_1.m_text;
                                var13_13.getTextBounds((String)var15_15, var16_16, var28_28, (Rect)var10_10);
                                var30_30.bounding.set((Rect)var10_10);
                                var10_10 = var30_30.bounding;
                                var13_13 = var30_30.pos;
                                var20_20 = var13_13.x;
                                var38_38 = var13_13.y;
                                var10_10.offset(var20_20, var38_38);
                                if (var11_11 != 0 && (var8_8 = (int)var30_30.colorGlyph) != 0) {
                                    var10_10 = var30_30.bounding;
                                    var38_38 = var10_10.right;
                                    var20_20 = var10_10.left;
                                    var20_20 = var38_38 - var20_20;
                                    var16_16 = 0x3DCCCCCD;
                                    var18_18 = 0.1f;
                                    var10_10.right = var38_38 += (var20_20 *= var18_18);
                                }
                            }
                            var8_8 = (int)var30_30.colorGlyph;
                            if (var8_8 == 0) {
                                var10_10 = var30_30.glyphPath;
                                var8_8 = (int)var10_10.isEmpty();
                                var30_30.noShape = var8_8;
                            }
                            var10_10 = var30_30.typographicBounding;
                            var13_13 = var30_30.bounding;
                            var10_10.set((RectF)var13_13);
                            var10_10 = var30_30.typographicBounding;
                            var38_38 = var30_30.pos.y;
                            var10_10.top = var20_20 = var38_38 + var5_5;
                            var10_10.bottom = var38_38 += var6_6;
                            var21_21.add(var30_30);
                            var8_8 = var43_43 + 1;
                            var30_30 = var35_35;
                            var27_27 = var36_36;
                            var13_13 = var37_37;
                            var23_23 = var39_39;
                        }
                        var39_39 = var23_23;
                        var27_27 = 0;
                        var42_42 = 0.0f;
                        var26_26 /* !! */  = null;
                        var30_30 = var1_1.m_glyphLinesBounding[var34_34];
                        var29_29 /* !! */  = (float[])var1_1.m_layout;
                        var8_8 = var34_34;
                        var30_30.left = var44_44 = var29_29 /* !! */ .getLineLeft(var34_34);
                        var30_30 = var1_1.m_glyphLinesBounding[var34_34];
                        var30_30.right = var44_44 = var1_1.m_layout.getLineRight(var34_34);
                        var30_30 = var1_1.m_glyphLinesBounding[var34_34];
                        var44_44 = var1_1.m_layout.getLineTop(var34_34);
                        var38_38 = var1_1.m_yOffset;
                        var30_30.top = var44_44 += var38_38;
                        var30_30 = var1_1.m_glyphLinesBounding[var34_34];
                        var29_29 /* !! */  = (float[])var1_1.m_layout;
                        var45_45 = var29_29 /* !! */ .getLineBottom(var34_34);
                        var44_44 = var45_45;
                        var38_38 = var1_1.m_yOffset;
                        var30_30.bottom = var44_44 += var38_38;
                        var30_30 = var1_1.m_glyphLinesBounding[var34_34];
                        var2_2 = (int)var30_30.isEmpty();
                        if (var2_2 == 0) {
                            var30_30 = var1_1.m_glyphLinesBounding[var34_34];
                            var3_3 = var30_30.width();
                            var44_44 = var33_33;
                            var18_18 = Math.max(var33_33, var3_3);
                        } else {
                            var44_44 = var33_33;
                            var30_30 = var1_1.m_glyphLinesBounding;
                            var13_13 = var30_30[var34_34];
                            var30_30 = var30_30[var34_34];
                            var3_3 = var30_30.left;
                            var19_19 = 1065353216;
                            var20_20 = 1.0f;
                            var13_13.right = var3_3 += var20_20;
                            var18_18 = var33_33;
                        }
                        var2_2 = (int)var1_1.m_underline;
                        if (var2_2 != 0 && (var2_2 = (int)var21_21.isEmpty()) == 0) {
                            var30_30 = var1_1.m_glyphLinesBounding;
                            var44_44 = var30_30[var8_8].left;
                            var3_3 = var30_30[var8_8].right;
                            var14_14 = var39_39;
                            var38_38 = (float)var39_39 + var6_6;
                            var20_20 = var1_1.m_yOffset;
                            var38_38 += var20_20;
                            var20_20 = var1_1.m_underlineWidth + var38_38;
                            var22_22 /* !! */  = new NvAndroidTextLayout$GlyphInfo();
                            var25_25 = 1;
                            var22_22 /* !! */ .decorativeGlyph = var25_25;
                            var24_24 = new PointF();
                            var22_22 /* !! */ .pos = var24_24;
                            var24_24 = new Path();
                            var22_22 /* !! */ .glyphPath = var24_24;
                            var24_24.moveTo(var44_44, var38_38);
                            var22_22 /* !! */ .glyphPath.lineTo(var3_3, var38_38);
                            var24_24 = var22_22 /* !! */ .glyphPath;
                            var24_24.lineTo(var3_3, var20_20);
                            var22_22 /* !! */ .glyphPath.lineTo(var44_44, var20_20);
                            var22_22 /* !! */ .glyphPath.lineTo(var44_44, var38_38);
                            var22_22 /* !! */ .glyphPath.close();
                            var30_30 = new RectF();
                            var22_22 /* !! */ .bounding = var30_30;
                            var29_29 /* !! */  = (float[])var22_22 /* !! */ .glyphPath;
                            var14_14 = 1;
                            var38_38 = 1.4E-45f;
                            var29_29 /* !! */ .computeBounds((RectF)var30_30, (boolean)var14_14);
                            var29_29 /* !! */  = (float[])var22_22 /* !! */ .bounding;
                            var30_30 = new RectF((RectF)var29_29 /* !! */ );
                            var22_22 /* !! */ .typographicBounding = var30_30;
                            var21_21.add(var22_22 /* !! */ );
                        }
                        var19_19 = var8_8 + 1;
                        var14_14 = var32_32;
                        var2_2 = 1;
                        var3_3 = 1.4E-45f;
                        var8_8 = 0;
                        var9_9 = 0.0f;
                        var10_10 = null;
                    }
                    var32_32 = var14_14;
                    var44_44 = var18_18;
                    var27_27 = 0;
                    var42_42 = 0.0f;
                    var26_26 /* !! */  = null;
                    var2_2 = var1_1.m_align & 3;
                    if (var2_2 == 0) break block45;
                    var30_30 = null;
                    var3_3 = 0.0f;
                    var46_46 = var14_14;
                    for (var2_2 = 0; var2_2 < var46_46; ++var2_2) {
                        block47: {
                            block46: {
                                var47_47 = var1_1.m_glyphLinesBounding[var2_2];
                                var48_48 = var47_47.isEmpty();
                                if (var48_48 != 0) continue;
                                var47_47 = var1_1.m_layout;
                                var48_48 = var47_47.getParagraphDirection(var2_2);
                                var49_49 = var1_1.m_layout;
                                var6_6 = var49_49.getLineLeft(var2_2);
                                var7_7 = var1_1.m_layout;
                                var12_12 = var7_7.getLineRight(var2_2) - var6_6;
                                var50_50 = var1_1.m_align;
                                var8_8 = var50_50 & 1;
                                if (var8_8 == 0) break block46;
                                var50_50 = -1;
                                var6_6 = 0.0f / 0.0f;
                                if (var48_48 != var50_50) ** GOTO lbl-1000
                                var47_47 = var1_1.m_layout;
                                var48_48 = var47_47.getWidth();
                                var5_5 = -((float)var48_48 - var12_12);
                                break block47;
                            }
                            if ((var50_50 &= 2) == 0) ** GOTO lbl-1000
                            var50_50 = 1;
                            var6_6 = 1.4E-45f;
                            if (var48_48 == var50_50) {
                                var47_47 = var1_1.m_layout;
                                var48_48 = var47_47.getWidth();
                                var5_5 = (float)var48_48 - var12_12;
                            } else lbl-1000:
                            // 3 sources

                            {
                                var48_48 = 0;
                                var5_5 = 0.0f;
                                var47_47 = null;
                            }
                        }
                        var50_50 = 0;
                        var6_6 = 0.0f;
                        var49_49 = null;
                        cfr_temp_2 = var5_5 - 0.0f;
                        var11_11 = (int)(cfr_temp_2 == 0.0f ? 0 : (cfr_temp_2 > 0.0f ? 1 : -1));
                        if (var11_11 == 0) continue;
                        var1_1.m_glyphLinesBounding[var2_2].offset(var5_5, 0.0f);
                        var7_7 = ((ArrayList)var1_1.m_glyphLines.get(var2_2)).iterator();
                        while ((var8_8 = (int)var7_7.hasNext()) != 0) {
                            var10_10 = (NvAndroidTextLayout$GlyphInfo)var7_7.next();
                            var10_10.pos.offset(var5_5, 0.0f);
                            var13_13 = var10_10.bounding;
                            var13_13.offset(var5_5, 0.0f);
                            var10_10 = var10_10.glyphPath;
                            if (var10_10 != null) {
                                var10_10.offset(var5_5, 0.0f);
                            }
                            var50_50 = 0;
                            var6_6 = 0.0f;
                            var49_49 = null;
                        }
                    }
                    break block48;
                }
                var46_46 = var14_14;
            }
            var30_30 = null;
            var3_3 = 0.0f;
            for (var2_2 = 0; var2_2 < var46_46; ++var2_2) {
                var47_47 = var1_1.m_textBounding;
                var48_48 = var47_47.isEmpty();
                if (var48_48 == 0) {
                    var47_47 = var1_1.m_glyphLinesBounding[var2_2];
                    var48_48 = (int)var47_47.isEmpty();
                    if (var48_48 != 0) continue;
                    var47_47 = var1_1.m_textBounding;
                    var49_49 = var1_1.m_glyphLinesBounding[var2_2];
                    var47_47.union(var49_49);
                    continue;
                }
                var47_47 = var1_1.m_textBounding;
                var49_49 = var1_1.m_glyphLinesBounding[var2_2];
                var47_47.set(var49_49);
            }
            var2_2 = (int)var1_1.m_underline;
            if (var2_2 != 0 && (var2_2 = (int)(var30_30 = var1_1.m_textBounding).isEmpty()) == 0) {
                var30_30 = var1_1.m_textBounding;
                var5_5 = var30_30.top;
                var6_6 = var1_1.m_underlineWidth;
                var30_30.top = var5_5 -= var6_6;
                var30_30.bottom = var5_5 = var30_30.bottom + var6_6;
            }
            if ((var2_2 = var1_1.m_align & 7) == (var48_48 = var1_1.m_innerAlign)) break block49;
            while (var27_27 < var46_46) {
                block51: {
                    block44: {
                        block55: {
                            block53: {
                                block54: {
                                    block52: {
                                        block50: {
                                            var30_30 = var1_1.m_glyphLinesBounding[var27_27];
                                            var2_2 = (int)var30_30.isEmpty();
                                            if (var2_2 == 0) break block50;
                                            var48_48 = 0;
                                            var5_5 = 0.0f;
                                            var47_47 = null;
                                            var50_50 = 1;
                                            var6_6 = 1.4E-45f;
                                            break block51;
                                        }
                                        var30_30 = var1_1.m_glyphLinesBounding[var27_27];
                                        var3_3 = var30_30.width();
                                        var48_48 = var1_1.m_align;
                                        var50_50 = var48_48 & 1;
                                        var11_11 = 4;
                                        var12_12 = 5.6E-45f;
                                        var8_8 = 0x40000000;
                                        var9_9 = 2.0f;
                                        var14_14 = 2;
                                        var38_38 = 2.8E-45f;
                                        if (var50_50 == 0) break block52;
                                        var48_48 = var1_1.m_innerAlign;
                                        if (var48_48 == var14_14) {
                                            var3_3 = var44_44 - var3_3;
lbl444:
                                            // 2 sources

                                            while (true) {
                                                var48_48 = 0;
                                                var5_5 = 0.0f;
                                                var47_47 = null;
                                                var50_50 = 1;
                                                var6_6 = 1.4E-45f;
                                                break block44;
                                                break;
                                            }
                                        }
                                        if (var48_48 == var11_11) {
                                            var18_18 = var44_44 - var3_3;
                                            var3_3 = var18_18 / var9_9;
                                            ** continue;
                                        }
                                        var50_50 = 1;
                                        var6_6 = 1.4E-45f;
                                        ** GOTO lbl-1000
                                    }
                                    if ((var48_48 &= 2) == 0) break block53;
                                    var48_48 = var1_1.m_innerAlign;
                                    var50_50 = 1;
                                    var6_6 = 1.4E-45f;
                                    if (var48_48 != var50_50) break block54;
                                    var18_18 = var44_44 - var3_3;
                                    var3_3 = -var18_18;
                                    break block55;
                                }
                                if (var48_48 != var11_11) ** GOTO lbl-1000
                                ** GOTO lbl-1000
                            }
                            var50_50 = 1;
                            var6_6 = 1.4E-45f;
                            var48_48 = var1_1.m_innerAlign;
                            if (var48_48 == var50_50) lbl-1000:
                            // 2 sources

                            {
                                var18_18 = var44_44 - var3_3;
                                var3_3 = -var18_18 / var9_9;
                            } else if (var48_48 == var14_14) {
                                var18_18 = var44_44 - var3_3;
                                var3_3 = var18_18 / var9_9;
                            } else lbl-1000:
                            // 3 sources

                            {
                                var2_2 = 0;
                                var3_3 = 0.0f;
                                var30_30 = null;
                            }
                        }
                        var48_48 = 0;
                        var5_5 = 0.0f;
                        var47_47 = null;
                    }
                    var11_11 = (int)((cfr_temp_3 = var3_3 - 0.0f) == 0.0f ? 0 : (cfr_temp_3 > 0.0f ? 1 : -1));
                    if (var11_11 != 0) {
                        var1_1.m_glyphLinesBounding[var27_27].offset(var3_3, 0.0f);
                        var7_7 = ((ArrayList)var1_1.m_glyphLines.get(var27_27)).iterator();
                        while ((var8_8 = (int)var7_7.hasNext()) != 0) {
                            var10_10 = (NvAndroidTextLayout$GlyphInfo)var7_7.next();
                            var10_10.pos.offset(var3_3, 0.0f);
                            var13_13 = var10_10.bounding;
                            var13_13.offset(var3_3, 0.0f);
                            var10_10 = var10_10.glyphPath;
                            if (var10_10 == null) continue;
                            var10_10.offset(var3_3, 0.0f);
                        }
                    }
                }
                ++var27_27;
            }
        }
    }

    private boolean isSuspectableColorGlyph(String string2, int n10, int n11) {
        int n12;
        while (true) {
            char c10;
            n12 = 1;
            if (n10 >= n11) break;
            int n13 = string2.charAt(n10);
            if (n13 != (c10 = 8205) && n13 != (c10 = '\u200c')) {
                c10 = (char)(Character.isHighSurrogate((char)n13) ? 1 : 0);
                if (c10 == '\u0000') {
                    c10 = (char)(Character.isISOControl((char)n13) ? 1 : 0);
                    if (c10 != '\u0000' || (n13 = (int)(Character.isSpaceChar((char)n13) ? 1 : 0)) != 0) {
                        return false;
                    }
                } else {
                    boolean bl2;
                    c10 = n11 + -1;
                    if (n10 >= c10) {
                        return false;
                    }
                    if (!(bl2 = Character.isLowSurrogate(c10 = (char)string2.charAt(++n10)))) {
                        return false;
                    }
                    if ((c10 = (char)(Character.isISOControl(n13 = Character.toCodePoint((char)n13, c10)) ? 1 : 0)) != '\u0000' || (n13 = (int)(Character.isSpaceChar(n13) ? 1 : 0)) != 0) {
                        return false;
                    }
                }
            }
            n10 += n12;
        }
        return n12 != 0;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void layoutVertically(boolean var1_1, float var2_2, boolean var3_3, float var4_4, float var5_5, float var6_6) {
        var7_7 = this;
        var8_8 = var4_4;
        var9_9 = var6_6;
        var10_10 = this.m_paint;
        var11_11 = "X";
        var12_12 = var10_10.measureText((String)var11_11);
        var13_13 = 0x40000000;
        var14_14 = 2.0f;
        var12_12 *= var14_14;
        var10_10 = var10_10.getFontMetrics();
        var15_15 = -var10_10.ascent;
        var16_16 = var10_10.descent;
        var15_15 += var16_16;
        var16_16 = 100.0f;
        var17_17 = 0;
        var18_18 = 0.0f;
        var19_19 = null;
        if (var3_3 && (var20_20 = (cfr_temp_0 = var2_2 - 0.0f) == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1)) != false || !var3_3 && (var20_20 = var2_2 == var16_16 ? 0 : (var2_2 > var16_16 ? 1 : -1)) != false) {
            if (var3_3) {
                var15_15 += var2_2;
            } else {
                var16_16 = var2_2 / var16_16;
                var15_15 *= var16_16;
            }
        }
        var22_22 = null;
        var21_21 = new NvAndroidTextLayout$VerticalLayoutContext(null);
        var20_20 = (float)true;
        var23_23 = 1.4E-45f;
        var21_21.firstLine = var20_20;
        var24_24 = 0;
        var25_25 = 0.0f;
        var26_26 = null;
        var21_21.currentGlyphCountInLine = 0;
        var21_21.currentLineHeight = 0.0f;
        var21_21.width = 0.0f;
        var21_21.height = 0.0f;
        var21_21.xOrigin = var27_27 = var5_5 - var12_12;
        var27_27 = var12_12 / var14_14;
        var21_21.xCenter = var27_27 = var5_5 - var27_27;
        var21_21.yOrigin = var27_27 = -var10_10.ascent;
        var28_28 = 1207959552 != 0;
        var27_27 = 131072.0f;
        if (var1_1) {
            var27_27 = Math.max(0.0f, var9_9);
        }
        var29_29 = new ArrayList();
        var30_30 = new ArrayList();
        var31_31 = var7_7.m_glyphLines.iterator();
        while (var32_32 = var31_31.hasNext()) {
            var33_33 = ((ArrayList)var31_31.next()).iterator();
            block1: while (var34_34 = var33_33.hasNext()) {
                var35_35 = var33_33.next();
                var19_19 = (NvAndroidTextLayout$GlyphInfo)var35_35;
                var19_19 = (NvAndroidTextLayout$GlyphInfo)var35_35;
                var24_24 = var19_19.decorativeGlyph;
                if (var24_24 != 0) {
                    var17_17 = 0;
                    var18_18 = 0.0f;
                    var19_19 = null;
lbl58:
                    // 2 sources

                    while (true) {
                        var24_24 = 0;
                        var25_25 = 0.0f;
                        var26_26 = null;
                        continue block1;
                        break;
                    }
                }
                if (var1_1 && (var24_24 = var21_21.currentGlyphCountInLine) != 0) {
                    var26_26 = var19_19.bounding;
                    var25_25 = var26_26.bottom;
                    var36_36 = var19_19.pos;
                    var14_14 = var36_36.y;
                    var25_25 -= var14_14;
                    var14_14 = var21_21.yOrigin;
                    cfr_temp_1 = (var25_25 += var14_14) - var27_27;
                    var13_13 = (int)(cfr_temp_1 == 0.0f ? 0 : (cfr_temp_1 > 0.0f ? 1 : -1));
                    if (var13_13 > 0) {
                        var21_21.moveToNextLine((Paint.FontMetrics)var10_10, var12_12, var8_8);
                        var29_29.add(var30_30);
                        var30_30 = var36_36 = new ArrayList();
                    }
                }
                var14_14 = var21_21.xCenter;
                var26_26 = var19_19.bounding;
                var25_25 = var26_26.centerX();
                var22_22 = var19_19.pos;
                var37_37 = var27_27;
                var27_27 = var22_22.x;
                var14_14 -= (var25_25 -= var27_27);
                var25_25 = var21_21.yOrigin;
                var27_27 = var14_14 - var27_27;
                var38_38 = var31_31;
                var39_39 = var22_22.y;
                var39_39 = var25_25 - var39_39;
                var22_22.x = var14_14;
                var22_22.y = var25_25;
                var19_19.bounding.offset(var27_27, var39_39);
                var36_36 = var19_19.typographicBounding;
                var22_22 = var19_19.bounding;
                var36_36.set((RectF)var22_22);
                var36_36 = var19_19.typographicBounding;
                var36_36.left = var23_23 = var21_21.xOrigin;
                var36_36.right = var23_23 += var12_12;
                var36_36 = var19_19.glyphPath;
                if (var36_36 != null) {
                    var36_36.offset(var27_27, var39_39);
                }
                var36_36 = var19_19.bounding;
                var21_21.currentLineHeight = var14_14 = var36_36.bottom;
                var21_21.yOrigin = var14_14 = var21_21.yOrigin + var15_15;
                var30_30.add(var19_19);
                var21_21.currentGlyphCountInLine = var13_13 = var21_21.currentGlyphCountInLine + 1;
                var27_27 = var37_37;
                var31_31 = var38_38;
                var13_13 = 0x40000000;
                var14_14 = 2.0f;
                var17_17 = 0;
                var18_18 = 0.0f;
                var19_19 = null;
                var20_20 = (float)true;
                var23_23 = 1.4E-45f;
                ** continue;
            }
            var37_37 = var27_27;
            var38_38 = var31_31;
            var21_21.moveToNextLine((Paint.FontMetrics)var10_10, var12_12, var8_8);
            var29_29.add(var30_30);
            var30_30 = new ArrayList();
            var13_13 = 0x40000000;
            var14_14 = 2.0f;
            var17_17 = 0;
            var18_18 = 0.0f;
            var19_19 = null;
            var20_20 = (float)true;
            var23_23 = 1.4E-45f;
            var24_24 = 0;
            var25_25 = 0.0f;
            var26_26 = null;
        }
        var7_7.m_glyphLines = var29_29;
        var40_40 = var7_7.m_align;
        var41_41 = var40_40 & 64;
        if (var41_41 != 0) {
            var42_42 = var21_21.width - var5_5;
        } else {
            var41_41 = var40_40 & 128;
            if (var41_41 != 0) {
                var42_42 = var21_21.width - var5_5;
                var43_43 = 0x40000000;
                var12_12 = 2.0f;
                var42_42 /= var12_12;
            } else {
                var41_41 = 0;
                var42_42 = 0.0f;
                var10_10 = null;
            }
        }
        var43_43 = var40_40 & 2;
        if (var43_43 != 0) {
            var8_8 = var21_21.height;
            var8_8 = var9_9 - var8_8;
        } else if ((var40_40 &= 4) != 0) {
            var8_8 = var21_21.height;
            var8_8 = var9_9 - var8_8;
            var43_43 = 0x40000000;
            var12_12 = 2.0f;
            var8_8 /= var12_12;
        } else {
            var40_40 = 0;
            var8_8 = 0.0f;
            var44_44 = null;
        }
        var11_11 = new RectF();
        var7_7.m_textBounding = var11_11;
        var11_11 = new RectF[var7_7.m_glyphLines.size()];
        var7_7.m_glyphLinesBounding = var11_11;
        var11_11 = var7_7.m_glyphLines;
        var43_43 = var11_11.size();
        var25_25 = 0.0f;
        var26_26 = null;
        for (var24_24 = 0; var24_24 < var43_43; ++var24_24) {
            var36_36 = (ArrayList)var7_7.m_glyphLines.get(var24_24);
            var45_45 = var36_36.isEmpty();
            if (var45_45 == 0) {
                var45_45 = var36_36.size();
                var17_17 = 1;
                var18_18 = 1.4E-45f;
                var46_46 = ((NvAndroidTextLayout$GlyphInfo)var36_36.get((int)(var45_45 -= var17_17))).bounding;
                var15_15 = var46_46.bottom;
            } else {
                var45_45 = 0;
                var15_15 = 0.0f;
                var46_46 = null;
            }
            var17_17 = var7_7.m_innerAlign;
            var20_20 = var17_17 & 2;
            if (var20_20 != false) {
                var18_18 = var21_21.height - var15_15;
lbl190:
                // 2 sources

                while (true) {
                    var18_18 += var8_8;
                    break;
                }
            } else {
                if ((var17_17 &= 4) != 0) {
                    var18_18 = var21_21.height - var15_15;
                    var45_45 = 0x40000000;
                    var15_15 = 2.0f;
                    var18_18 /= var15_15;
                    ** continue;
                }
                var18_18 = var8_8;
            }
            var46_46 = new RectF();
            var22_22 = var36_36.iterator();
            while (var28_28 = (boolean)var22_22.hasNext()) {
                var47_47 = (NvAndroidTextLayout$GlyphInfo)var22_22.next();
                var29_29 = var47_47.pos;
                var29_29.x = var48_48 = var29_29.x + var42_42;
                var29_29.y = var48_48 = var29_29.y + var18_18;
                var47_47.bounding.offset(var42_42, var18_18);
                var47_47.typographicBounding.offset(var42_42, var18_18);
                var29_29 = var47_47.glyphPath;
                if (var29_29 != null) {
                    var29_29.offset(var42_42, var18_18);
                }
                if (!(var49_49 = var46_46.isEmpty())) {
                    var47_47 = var47_47.typographicBounding;
                    var46_46.union((RectF)var47_47);
                    continue;
                }
                var47_47 = var47_47.typographicBounding;
                var46_46.set((RectF)var47_47);
            }
            var17_17 = (int)var7_7.m_underline;
            if (var17_17 != 0 && (var17_17 = (int)var36_36.isEmpty()) == 0) {
                var18_18 = var46_46.left;
                var23_23 = var7_7.m_hozUnderlineInterval;
                var18_18 -= var23_23;
                var23_23 = var7_7.m_underlineWidth;
                var23_23 = var18_18 - var23_23;
                var27_27 = var46_46.top;
                var50_50 = var46_46.bottom;
                var30_30 = new NvAndroidTextLayout$GlyphInfo();
                var51_51 = true;
                var39_39 = 1.4E-45f;
                var30_30.decorativeGlyph = var51_51;
                var30_30.pos = var31_31 = new PointF();
                var31_31 = new Path();
                var30_30.glyphPath = var31_31;
                var31_31.moveTo(var23_23, var27_27);
                var30_30.glyphPath.lineTo(var18_18, var27_27);
                var31_31 = var30_30.glyphPath;
                var31_31.lineTo(var18_18, var50_50);
                var30_30.glyphPath.lineTo(var23_23, var50_50);
                var30_30.glyphPath.lineTo(var23_23, var27_27);
                var30_30.glyphPath.close();
                var19_19 = new RectF();
                var30_30.bounding = var19_19;
                var22_22 = var30_30.glyphPath;
                var28_28 = true;
                var27_27 = 1.4E-45f;
                var22_22.computeBounds((RectF)var19_19, var28_28);
                var22_22 = var30_30.bounding;
                var19_19 = new RectF((RectF)var22_22);
                var30_30.typographicBounding = var19_19;
                var36_36.add(var30_30);
            } else {
                var28_28 = true;
                var27_27 = 1.4E-45f;
            }
            var13_13 = (int)var46_46.isEmpty();
            if (var13_13 != 0) {
                var46_46.left = var14_14 = ((NvAndroidTextLayout$VerticalLayoutContext$LineInfo)var21_21.lineInfoArray.get((int)var24_24)).lineLeft;
                var36_36 = (NvAndroidTextLayout$VerticalLayoutContext$LineInfo)var21_21.lineInfoArray.get(var24_24);
                var46_46.right = var14_14 = var36_36.lineRight;
                var13_13 = var7_7.m_align;
                var17_17 = var13_13 & 2;
                var20_20 = 1065353216;
                var23_23 = 1.0f;
                if (var17_17 != 0) {
                    var46_46.top = var14_14 = var9_9 - var23_23 + var8_8;
                    var13_13 = 0x40000000;
                    var14_14 = 2.0f;
                } else if ((var13_13 &= 4) != 0) {
                    var13_13 = 0x40000000;
                    var14_14 = 2.0f;
                    var46_46.top = var18_18 = var9_9 / var14_14 + var8_8;
                } else {
                    var13_13 = 0x40000000;
                    var14_14 = 2.0f;
                    var46_46.top = var8_8;
                }
                var46_46.bottom = var18_18 = var46_46.top + var23_23;
            } else {
                var13_13 = 0x40000000;
                var14_14 = 2.0f;
            }
            var7_7.m_glyphLinesBounding[var24_24] = var46_46;
            var19_19 = var7_7.m_textBounding;
            var17_17 = (int)var19_19.isEmpty();
            if (var17_17 == 0) {
                var19_19 = var7_7.m_textBounding;
                var19_19.union(var46_46);
                continue;
            }
            var19_19 = var7_7.m_textBounding;
            var19_19.set(var46_46);
        }
        var40_40 = (int)var7_7.m_underline;
        if (var40_40 != 0 && (var40_40 = (int)(var44_44 = var7_7.m_textBounding).isEmpty()) == 0) {
            var44_44 = var7_7.m_textBounding;
            var9_9 = var44_44.left;
            var42_42 = var7_7.m_underlineWidth;
            var44_44.left = var9_9 -= var42_42;
            var44_44.right = var9_9 = var44_44.right + var42_42;
        }
    }

    private boolean mayHaveContextualForm(String string2, int n10, int n11) {
        while (n10 < n11) {
            int n12;
            int n13 = string2.charAt(n10);
            if (n13 >= (n12 = 1536) && n13 <= (n12 = 1791)) {
                return true;
            }
            ++n10;
        }
        return false;
    }

    private void prepareGlyphLines() {
        this.internalPrepareGlyphLines();
        Object var1_1 = null;
        try {
            this.m_layout = null;
        }
        catch (Exception exception) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("");
            String string2 = exception.getMessage();
            charSequence.append(string2);
            charSequence = charSequence.toString();
            string2 = TAG;
            Log.e((String)string2, (String)charSequence);
            exception.printStackTrace();
        }
    }

    public ByteBuffer createLineInfoByteBuffer() {
        String string2;
        Object object;
        int n10;
        int n11 = 36;
        Object object2 = this.m_glyphLines;
        object2 = ((ArrayList)object2).iterator();
        int n12 = n10 = 4;
        while (true) {
            int n13 = object2.hasNext();
            if (n13 == 0) break;
            object = object2.next();
            object = (ArrayList)object;
            n12 = n12 + 16 + n10;
            n13 = ((ArrayList)object).size() * n11;
            n12 += n13;
            continue;
            break;
        }
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(n12);
        object2 = ByteOrder.LITTLE_ENDIAN;
        byteBuffer.order((ByteOrder)object2);
        object2 = this.m_glyphLines;
        int n14 = ((ArrayList)object2).size();
        try {
            byteBuffer.putInt(n14);
            n10 = 0;
            string2 = null;
        }
        catch (Exception exception) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("");
            string2 = exception.getMessage();
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            Log.e((String)TAG, (String)object2);
            exception.printStackTrace();
            return null;
        }
        block43: for (n12 = 0; n12 < n14; ++n12) {
            object = this.m_glyphLinesBounding;
            object = object[n12];
            float f10 = ((RectF)object).left;
            byteBuffer.putFloat(f10);
            f10 = ((RectF)object).top;
            byteBuffer.putFloat(f10);
            f10 = ((RectF)object).right;
            byteBuffer.putFloat(f10);
            float f11 = ((RectF)object).bottom;
            byteBuffer.putFloat(f11);
            object = this.m_glyphLines;
            object = ((ArrayList)object).get(n12);
            object = (ArrayList)object;
            int n15 = ((ArrayList)object).size();
            byteBuffer.putInt(n15);
            object = ((ArrayList)object).iterator();
            while (true) {
                int n16;
                block49: {
                    float f12;
                    int n17;
                    Object object3;
                    block48: {
                        float f13;
                        PointF pointF;
                        block47: {
                            n15 = (int)(object.hasNext() ? 1 : 0);
                            if (n15 == 0) continue block43;
                            object3 = object.next();
                            object3 = (NvAndroidTextLayout$GlyphInfo)object3;
                            pointF = ((NvAndroidTextLayout$GlyphInfo)object3).pos;
                            f13 = pointF.x;
                            byteBuffer.putFloat(f13);
                            pointF = ((NvAndroidTextLayout$GlyphInfo)object3).pos;
                            f13 = pointF.y;
                            byteBuffer.putFloat(f13);
                            pointF = ((NvAndroidTextLayout$GlyphInfo)object3).bounding;
                            f13 = pointF.left;
                            byteBuffer.putFloat(f13);
                            pointF = ((NvAndroidTextLayout$GlyphInfo)object3).bounding;
                            f13 = pointF.top;
                            byteBuffer.putFloat(f13);
                            pointF = ((NvAndroidTextLayout$GlyphInfo)object3).bounding;
                            f13 = pointF.right;
                            byteBuffer.putFloat(f13);
                            pointF = ((NvAndroidTextLayout$GlyphInfo)object3).bounding;
                            f13 = pointF.bottom;
                            byteBuffer.putFloat(f13);
                            n17 = ((NvAndroidTextLayout$GlyphInfo)object3).colorGlyph;
                            n16 = 1;
                            f12 = Float.MIN_VALUE;
                            if (n17 != 0) {
                                n17 = n16;
                                f13 = f12;
                                break block47;
                            }
                            n17 = 0;
                            pointF = null;
                            f13 = 0.0f;
                        }
                        byteBuffer.putInt(n17);
                        n17 = (int)(((NvAndroidTextLayout$GlyphInfo)object3).noShape ? 1 : 0);
                        if (n17 != 0) {
                            n17 = n16;
                            f13 = f12;
                            break block48;
                        }
                        n17 = 0;
                        pointF = null;
                        f13 = 0.0f;
                    }
                    byteBuffer.putInt(n17);
                    n15 = (int)(((NvAndroidTextLayout$GlyphInfo)object3).decorativeGlyph ? 1 : 0);
                    if (n15 != 0) break block49;
                    n16 = 0;
                    f12 = 0.0f;
                }
                byteBuffer.putInt(n16);
                continue;
                break;
            }
        }
        return byteBuffer;
    }

    public RectF getBoundingRect() {
        this.prepareGlyphLines();
        RectF rectF = this.m_textBounding;
        if (rectF != null) {
            return rectF;
        }
        rectF = new RectF();
        return rectF;
    }

    public RectF getBoundingRectAtLine(int n10) {
        RectF rectF;
        int n11;
        RectF[] rectFArray;
        this.prepareGlyphLines();
        if (n10 >= 0 && (rectFArray = this.m_glyphLinesBounding) != null && n10 < (n11 = rectFArray.length) && (rectF = rectFArray[n10]) != null) {
            return rectFArray[n10];
        }
        RectF rectF2 = new RectF();
        return rectF2;
    }

    public int getGlyphCountInLine(int n10) {
        int n11;
        ArrayList arrayList;
        this.prepareGlyphLines();
        if (n10 >= 0 && (arrayList = this.m_glyphLines) != null && n10 < (n11 = arrayList.size()) && (arrayList = this.m_glyphLines.get(n10)) != null) {
            return ((ArrayList)this.m_glyphLines.get(n10)).size();
        }
        return 0;
    }

    public NvAndroidTextLayout$GlyphInfo getGlyphInfo(int n10, int n11) {
        int n12;
        ArrayList arrayList;
        this.prepareGlyphLines();
        if (n10 >= 0 && (arrayList = this.m_glyphLines) != null && n10 < (n12 = arrayList.size()) && (arrayList = this.m_glyphLines.get(n10)) != null) {
            arrayList = this.m_glyphLines;
            ArrayList arrayList2 = (ArrayList)arrayList.get(n10);
            if (n11 >= 0 && n11 < (n12 = arrayList2.size())) {
                return (NvAndroidTextLayout$GlyphInfo)arrayList2.get(n11);
            }
        }
        return null;
    }

    public int getLineCount() {
        this.prepareGlyphLines();
        ArrayList arrayList = this.m_glyphLines;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public TextPaint getPaint() {
        return this.m_paint;
    }

    public String getText() {
        return this.m_text;
    }

    public boolean prepareDrawText() {
        this.prepareGlyphLines();
        return true;
    }
}

