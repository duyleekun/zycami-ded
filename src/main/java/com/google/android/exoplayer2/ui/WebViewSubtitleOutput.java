/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.text.Layout$Alignment
 *  android.util.AttributeSet
 *  android.util.Base64
 *  android.view.View
 *  android.webkit.WebView
 *  android.widget.FrameLayout
 */
package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.text.CaptionStyleCompat;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.ui.CanvasSubtitleOutput;
import com.google.android.exoplayer2.ui.HtmlUtils;
import com.google.android.exoplayer2.ui.SpannedToHtmlConverter;
import com.google.android.exoplayer2.ui.SubtitleView$Output;
import com.google.android.exoplayer2.ui.SubtitleViewUtils;
import com.google.android.exoplayer2.ui.WebViewSubtitleOutput$1;
import com.google.android.exoplayer2.ui.WebViewSubtitleOutput$2;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Charsets;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public final class WebViewSubtitleOutput
extends FrameLayout
implements SubtitleView$Output {
    private static final float CSS_LINE_HEIGHT = 1.2f;
    private static final String DEFAULT_BACKGROUND_CSS_CLASS = "default_bg";
    private float bottomPaddingFraction;
    private final CanvasSubtitleOutput canvasSubtitleOutput;
    private float defaultTextSize;
    private int defaultTextSizeType;
    private CaptionStyleCompat style;
    private List textCues;
    private final WebView webView;

    public WebViewSubtitleOutput(Context context) {
        this(context, null);
    }

    public WebViewSubtitleOutput(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        CanvasSubtitleOutput canvasSubtitleOutput;
        Object object = Collections.emptyList();
        this.textCues = object;
        this.style = object = CaptionStyleCompat.DEFAULT;
        this.defaultTextSize = 0.0533f;
        this.defaultTextSizeType = 0;
        this.bottomPaddingFraction = 0.08f;
        this.canvasSubtitleOutput = canvasSubtitleOutput = new CanvasSubtitleOutput(context, attributeSet);
        WebViewSubtitleOutput$1 webViewSubtitleOutput$1 = new WebViewSubtitleOutput$1(this, context, attributeSet);
        this.webView = webViewSubtitleOutput$1;
        webViewSubtitleOutput$1.setBackgroundColor(0);
        this.addView(canvasSubtitleOutput);
        this.addView((View)webViewSubtitleOutput$1);
    }

    private static int anchorTypeToTranslatePercent(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                return 0;
            }
            return -100;
        }
        return -50;
    }

    private static String convertAlignmentToCss(Layout.Alignment alignment) {
        String string2 = "center";
        if (alignment == null) {
            return string2;
        }
        int[] nArray = WebViewSubtitleOutput$2.$SwitchMap$android$text$Layout$Alignment;
        int n10 = alignment.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 2;
            if (n10 != n11) {
                return string2;
            }
            return "end";
        }
        return "start";
    }

    private static String convertCaptionStyleToCssTextShadow(CaptionStyleCompat object) {
        int n10 = ((CaptionStyleCompat)object).edgeType;
        int n11 = 1;
        if (n10 != n11) {
            int n12 = 2;
            if (n10 != n12) {
                n12 = 3;
                if (n10 != n12) {
                    n12 = 4;
                    if (n10 != n12) {
                        return "unset";
                    }
                    Object[] objectArray = new Object[n11];
                    objectArray[0] = object = HtmlUtils.toCssRgba(((CaptionStyleCompat)object).edgeColor);
                    return Util.formatInvariant("-0.05em -0.05em 0.15em %s", objectArray);
                }
                Object[] objectArray = new Object[n11];
                objectArray[0] = object = HtmlUtils.toCssRgba(((CaptionStyleCompat)object).edgeColor);
                return Util.formatInvariant("0.06em 0.08em 0.15em %s", objectArray);
            }
            Object[] objectArray = new Object[n11];
            objectArray[0] = object = HtmlUtils.toCssRgba(((CaptionStyleCompat)object).edgeColor);
            return Util.formatInvariant("0.1em 0.12em 0.15em %s", objectArray);
        }
        Object[] objectArray = new Object[n11];
        objectArray[0] = object = HtmlUtils.toCssRgba(((CaptionStyleCompat)object).edgeColor);
        return Util.formatInvariant("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", objectArray);
    }

    private String convertTextSizeToCss(int n10, float f10) {
        int n11 = this.getHeight();
        int n12 = this.getHeight();
        int n13 = this.getPaddingTop();
        n12 -= n13;
        n13 = this.getPaddingBottom();
        float f11 = SubtitleViewUtils.resolveTextSize(n10, f10, n11, n12 -= n13);
        float f12 = f11 - (f10 = -3.4028235E38f);
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            return "unset";
        }
        f10 = this.getContext().getResources().getDisplayMetrics().density;
        Object[] objectArray = new Object[1];
        Float f13 = Float.valueOf(f11 /= f10);
        objectArray[0] = f13;
        return Util.formatInvariant("%.2fpx", objectArray);
    }

    private static String convertVerticalTypeToCss(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                return "horizontal-tb";
            }
            return "vertical-lr";
        }
        return "vertical-rl";
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void updateWebView() {
        var1_1 /* !! */  = this;
        var2_2 = new StringBuilder();
        var3_3 = 4;
        var4_4 = 5.6E-45f;
        var5_5 = new Object[var3_3];
        var6_6 = HtmlUtils.toCssRgba(this.style.foregroundColor);
        var7_7 /* !! */  = null;
        var5_5[0] = var6_6;
        var8_8 = this.defaultTextSizeType;
        var9_9 = this.defaultTextSize;
        var6_6 = this.convertTextSizeToCss(var8_8, var9_9);
        var10_10 = 1;
        var9_9 = 1.4E-45f;
        var5_5[var10_10] = var6_6;
        var8_8 = 1067030938;
        var11_11 = 1.2f;
        var12_12 = Float.valueOf(var11_11);
        var13_13 = 2;
        var14_14 = 2.8E-45f;
        var5_5[var13_13] = var12_12;
        var12_12 = WebViewSubtitleOutput.convertCaptionStyleToCssTextShadow(this.style);
        var15_15 = 3;
        var5_5[var15_15] = var12_12;
        var5_5 = Util.formatInvariant("<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2fem;text-shadow:%s;'>", (Object[])var5_5);
        var2_2.append((String)var5_5);
        var5_5 = new HashMap();
        var12_12 = "default_bg";
        var16_16 = HtmlUtils.cssAllClassDescendantsSelector((String)var12_12);
        var17_17 = new Object[var10_10];
        var18_18 = this.style.backgroundColor;
        var17_17[0] = var19_19 = HtmlUtils.toCssRgba(var18_18);
        var19_19 = "background-color:%s;";
        var17_17 = Util.formatInvariant((String)var19_19, (Object[])var17_17);
        var5_5.put(var16_16, var17_17);
        var16_16 = null;
        for (var20_20 = 0; var20_20 < (var21_21 = (var17_17 = var1_1 /* !! */ .textCues).size()); ++var20_20) {
            block25: {
                block27: {
                    block26: {
                        block23: {
                            block24: {
                                block22: {
                                    block21: {
                                        block19: {
                                            block20: {
                                                var17_17 = (Cue)var1_1 /* !! */ .textCues.get(var20_20);
                                                var22_22 = var17_17.position;
                                                var23_23 = -8388609;
                                                var24_24 = -3.4028235E38f;
                                                var25_25 = var22_22 == var24_24 ? 0 : (var22_22 > var24_24 ? 1 : -1);
                                                var26_26 = 1120403456;
                                                var27_27 = 100.0f;
                                                if (var25_25 != false) {
                                                    var22_22 *= var27_27;
                                                } else {
                                                    var18_18 = 1112014848;
                                                    var22_22 = 50.0f;
                                                }
                                                var25_25 = WebViewSubtitleOutput.anchorTypeToTranslatePercent(var17_17.positionAnchor);
                                                var4_4 = var17_17.line;
                                                var28_28 = var4_4 == var24_24 ? 0 : (var4_4 > var24_24 ? 1 : -1);
                                                var29_29 = 1.0f;
                                                var30_30 = "%.2f%%";
                                                if (var28_28 == false) break block19;
                                                var13_13 = var17_17.lineType;
                                                if (var13_13 == var10_10) break block20;
                                                var31_31 /* !! */  = new Object[var10_10];
                                                var32_32 /* !! */  = Float.valueOf(var4_4 *= var27_27);
                                                var31_31 /* !! */ [0] = var32_32 /* !! */ ;
                                                var32_32 /* !! */  = Util.formatInvariant(var30_30, var31_31 /* !! */ );
                                                var13_13 = var17_17.verticalType;
                                                var13_13 = var13_13 == var10_10 ? -WebViewSubtitleOutput.anchorTypeToTranslatePercent(var17_17.lineAnchor) : WebViewSubtitleOutput.anchorTypeToTranslatePercent(var17_17.lineAnchor);
                                                break block21;
                                            }
                                            var14_14 = 0.0f;
                                            var31_31 /* !! */  = null;
                                            cfr_temp_0 = var4_4 - 0.0f;
                                            var13_13 = (int)(cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1));
                                            var33_33 = "%.2fem";
                                            if (var13_13 >= 0) {
                                                var31_31 /* !! */  = new Object[var10_10];
                                                var31_31 /* !! */ [0] = var32_32 /* !! */  = Float.valueOf(var4_4 *= var11_11);
                                                var32_32 /* !! */  = Util.formatInvariant((String)var33_33, var31_31 /* !! */ );
                                                var13_13 = 0;
                                                var31_31 /* !! */  = null;
                                                var14_14 = 0.0f;
                                                var23_23 = 0;
                                                var33_33 = null;
                                                var24_24 = 0.0f;
                                            } else {
                                                var31_31 /* !! */  = new Object[var10_10];
                                                var4_4 = (-var4_4 - var29_29) * var11_11;
                                                var31_31 /* !! */ [0] = var32_32 /* !! */  = Float.valueOf(var4_4);
                                                var32_32 /* !! */  = Util.formatInvariant((String)var33_33, var31_31 /* !! */ );
                                                var13_13 = 0;
                                                var31_31 /* !! */  = null;
                                                var14_14 = 0.0f;
                                                var23_23 = var10_10;
                                                var24_24 = var9_9;
                                            }
                                            break block22;
                                        }
                                        var32_32 /* !! */  = new Object[var10_10];
                                        var14_14 = var1_1 /* !! */ .bottomPaddingFraction;
                                        var29_29 = (var29_29 - var14_14) * var27_27;
                                        var31_31 /* !! */  = Float.valueOf(var29_29);
                                        var32_32 /* !! */ [0] = var31_31 /* !! */ ;
                                        var32_32 /* !! */  = Util.formatInvariant(var30_30, var32_32 /* !! */ );
                                        var13_13 = -100;
                                        var14_14 = 0.0f / 0.0f;
                                    }
                                    var23_23 = 0;
                                    var33_33 = null;
                                    var24_24 = 0.0f;
                                }
                                var11_11 = var17_17.size;
                                var34_34 = -3.4028235E38f;
                                var35_35 = var11_11 == var34_34 ? 0 : (var11_11 > var34_34 ? 1 : -1);
                                if (var35_35 != false) {
                                    var7_7 /* !! */  = new Object[var10_10];
                                    var6_6 = Float.valueOf(var11_11 *= var27_27);
                                    var26_26 = 0;
                                    var27_27 = 0.0f;
                                    var36_36 = null;
                                    var7_7 /* !! */ [0] = var6_6;
                                    var6_6 = Util.formatInvariant(var30_30, var7_7 /* !! */ );
                                } else {
                                    var6_6 = "fit-content";
                                }
                                var7_7 /* !! */  = WebViewSubtitleOutput.convertAlignmentToCss(var17_17.textAlignment);
                                var15_15 = var17_17.verticalType;
                                var30_30 = WebViewSubtitleOutput.convertVerticalTypeToCss(var15_15);
                                var26_26 = var17_17.textSizeType;
                                var9_9 = var17_17.textSize;
                                var37_37 = super.convertTextSizeToCss(var26_26, var9_9);
                                var26_26 = (int)var17_17.windowColorSet;
                                if (var26_26 != 0) {
                                    var26_26 = var17_17.windowColor;
                                } else {
                                    var36_36 = var1_1 /* !! */ .style;
                                    var26_26 = var36_36.windowColor;
                                }
                                var36_36 = HtmlUtils.toCssRgba(var26_26);
                                var38_38 = var13_13;
                                var13_13 = var17_17.verticalType;
                                var39_39 /* !! */  = "right";
                                var40_40 = "left";
                                var41_41 = "top";
                                var42_42 = var25_25;
                                var25_25 = (float)true;
                                if (var13_13 == var25_25) break block23;
                                var25_25 = 2;
                                if (var13_13 == var25_25) break block24;
                                if (var23_23 != 0) {
                                    var41_41 = "bottom";
                                }
                                var23_23 = 2;
                                var24_24 = 2.8E-45f;
                                break block25;
                            }
                            if (var23_23 == 0) break block26;
                            break block27;
                        }
                        if (var23_23 == 0) break block27;
                    }
                    var39_39 /* !! */  = var40_40;
                }
                var40_40 = var41_41;
                var23_23 = 2;
                var24_24 = 2.8E-45f;
                var41_41 = var39_39 /* !! */ ;
            }
            if (var13_13 == var23_23) ** GOTO lbl-1000
            var23_23 = 1;
            var24_24 = 1.4E-45f;
            if (var13_13 != var23_23) {
                var31_31 /* !! */  = "width";
                var25_25 = var42_42;
            } else lbl-1000:
            // 2 sources

            {
                var31_31 /* !! */  = "height";
                var25_25 = var38_38;
                var38_38 = (int)var42_42;
            }
            var17_17 = var17_17.text;
            var24_24 = this.getContext().getResources().getDisplayMetrics().density;
            var17_17 = SpannedToHtmlConverter.convert((CharSequence)var17_17, var24_24);
            var33_33 = var5_5.keySet().iterator();
            while (var43_43 = var33_33.hasNext()) {
                var39_39 /* !! */  = var33_33.next();
                var44_44 = var33_33;
                var33_33 = var39_39 /* !! */ ;
                var33_33 = var39_39 /* !! */ ;
                var39_39 /* !! */  = var5_5.get(var33_33);
                var1_1 /* !! */  = var39_39 /* !! */ ;
                var1_1 /* !! */  = var39_39 /* !! */ ;
                if ((var1_1 /* !! */  = (String)var5_5.put(var33_33, var1_1 /* !! */ )) != null && !(var45_45 = var1_1 /* !! */ .equals(var33_33 = var5_5.get(var33_33)))) {
                    var45_45 = false;
                    var1_1 /* !! */  = null;
                } else {
                    var45_45 = true;
                }
                Assertions.checkState(var45_45);
                var1_1 /* !! */  = this;
                var33_33 = var44_44;
            }
            var1_1 /* !! */  = new Object[12];
            var33_33 = null;
            var1_1 /* !! */ [0] = var40_40;
            var1_1 /* !! */ [1] = var19_19 = Float.valueOf(var22_22);
            var18_18 = 2;
            var22_22 = 2.8E-45f;
            var1_1 /* !! */ [var18_18] = var41_41;
            var23_23 = 3;
            var24_24 = 4.2E-45f;
            var1_1 /* !! */ [var23_23] = var32_32 /* !! */ ;
            var3_3 = 4;
            var4_4 = 5.6E-45f;
            var1_1 /* !! */ [var3_3] = var31_31 /* !! */ ;
            var1_1 /* !! */ [5] = var6_6;
            var1_1 /* !! */ [6] = var7_7 /* !! */ ;
            var1_1 /* !! */ [7] = var30_30;
            var1_1 /* !! */ [8] = var37_37;
            var1_1 /* !! */ [9] = var36_36;
            var1_1 /* !! */ [10] = var7_7 /* !! */  = Integer.valueOf((int)var25_25);
            var1_1 /* !! */ [11] = var7_7 /* !! */  = Integer.valueOf(var38_38);
            var1_1 /* !! */  = Util.formatInvariant("<div style='position:absolute;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%);'>", var1_1 /* !! */ );
            var2_2.append((String)var1_1 /* !! */ );
            var6_6 = new Object[1];
            var45_45 = false;
            var6_6[0] = var12_12;
            var1_1 /* !! */  = Util.formatInvariant("<span class='%s'>", var6_6);
            var2_2.append((String)var1_1 /* !! */ );
            var1_1 /* !! */  = var17_17.html;
            var2_2.append((String)var1_1 /* !! */ );
            var2_2.append("</span>");
            var2_2.append("</div>");
            var8_8 = 1067030938;
            var11_11 = 1.2f;
            var7_7 /* !! */  = null;
            var1_1 /* !! */  = this;
            var13_13 = var18_18;
            var14_14 = var22_22;
            var15_15 = var23_23;
            var10_10 = 1;
            var9_9 = 1.4E-45f;
        }
        var2_2.append("</div></body></html>");
        var1_1 /* !! */  = new StringBuilder();
        var1_1 /* !! */ .append("<html><head><style>");
        var32_32 /* !! */  = var5_5.keySet().iterator();
        while ((var8_8 = (int)var32_32 /* !! */ .hasNext()) != 0) {
            var6_6 = (String)var32_32 /* !! */ .next();
            var1_1 /* !! */ .append((String)var6_6);
            var7_7 /* !! */  = "{";
            var1_1 /* !! */ .append((String)var7_7 /* !! */ );
            var6_6 = (String)var5_5.get(var6_6);
            var1_1 /* !! */ .append((String)var6_6);
            var6_6 = "}";
            var1_1 /* !! */ .append((String)var6_6);
        }
        var1_1 /* !! */ .append("</style></head>");
        var1_1 /* !! */  = var1_1 /* !! */ .toString();
        var2_2.insert(0, (String)var1_1 /* !! */ );
        var1_1 /* !! */  = this;
        var32_32 /* !! */  = this.webView;
        var2_2 = var2_2.toString();
        var5_5 = Charsets.UTF_8;
        var2_2 = Base64.encodeToString((byte[])var2_2.getBytes((Charset)var5_5), (int)1);
        var32_32 /* !! */ .loadData((String)var2_2, "text/html", "base64");
    }

    public void destroy() {
        this.webView.destroy();
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        List list;
        super.onLayout(bl2, n10, n11, n12, n13);
        if (bl2 && !(bl2 = (list = this.textCues).isEmpty())) {
            this.updateWebView();
        }
    }

    public void update(List list, CaptionStyleCompat captionStyleCompat, float f10, int n10, float f11) {
        int n11;
        this.style = captionStyleCompat;
        this.defaultTextSize = f10;
        this.defaultTextSizeType = n10;
        this.bottomPaddingFraction = f11;
        ArrayList<Cue> arrayList = new ArrayList<Cue>();
        ArrayList<Cue> arrayList2 = new ArrayList<Cue>();
        for (int i10 = 0; i10 < (n11 = list.size()); ++i10) {
            Cue cue = (Cue)list.get(i10);
            Bitmap bitmap = cue.bitmap;
            if (bitmap != null) {
                arrayList.add(cue);
                continue;
            }
            arrayList2.add(cue);
        }
        list = this.textCues;
        boolean bl2 = list.isEmpty();
        if (!bl2 || !(bl2 = arrayList2.isEmpty())) {
            this.textCues = arrayList2;
            this.updateWebView();
        }
        this.canvasSubtitleOutput.update(arrayList, captionStyleCompat, f10, n10, f11);
        this.invalidate();
    }
}

