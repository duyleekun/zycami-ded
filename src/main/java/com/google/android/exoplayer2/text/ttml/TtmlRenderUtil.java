/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.Spannable
 *  android.text.SpannableStringBuilder
 *  android.text.style.AbsoluteSizeSpan
 *  android.text.style.BackgroundColorSpan
 *  android.text.style.ForegroundColorSpan
 *  android.text.style.RelativeSizeSpan
 *  android.text.style.StrikethroughSpan
 *  android.text.style.StyleSpan
 *  android.text.style.TypefaceSpan
 *  android.text.style.UnderlineSpan
 */
package com.google.android.exoplayer2.text.ttml;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.span.HorizontalTextInVerticalContextSpan;
import com.google.android.exoplayer2.text.span.RubySpan;
import com.google.android.exoplayer2.text.span.SpanUtil;
import com.google.android.exoplayer2.text.ttml.DeleteTextSpan;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.exoplayer2.text.ttml.TtmlStyle;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.Map;

public final class TtmlRenderUtil {
    private static final String TAG = "TtmlRenderUtil";

    private TtmlRenderUtil() {
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static void applyStylesToSpan(Spannable var0, int var1_1, int var2_2, TtmlStyle var3_3, TtmlNode var4_4, Map var5_5) {
        block17: {
            block16: {
                var6_6 = var3_3.getStyle();
                var7_7 = -1;
                var8_8 = 33;
                if (var6_6 != var7_7) {
                    var10_10 = var3_3.getStyle();
                    var9_9 /* !! */  = new StyleSpan(var10_10);
                    var0.setSpan((Object)var9_9 /* !! */ , var1_1, var2_2, var8_8);
                }
                if ((var6_6 = (int)var3_3.isLinethrough()) != 0) {
                    var9_9 /* !! */  = new StrikethroughSpan();
                    var0.setSpan((Object)var9_9 /* !! */ , var1_1, var2_2, var8_8);
                }
                if ((var6_6 = (int)var3_3.isUnderline()) != 0) {
                    var9_9 /* !! */  = new UnderlineSpan();
                    var0.setSpan((Object)var9_9 /* !! */ , var1_1, var2_2, var8_8);
                }
                if ((var6_6 = (int)var3_3.hasFontColor()) != 0) {
                    var10_10 = var3_3.getFontColor();
                    var9_9 /* !! */  = new ForegroundColorSpan(var10_10);
                    SpanUtil.addOrReplaceSpan(var0, var9_9 /* !! */ , var1_1, var2_2, var8_8);
                }
                if ((var6_6 = (int)var3_3.hasBackgroundColor()) != 0) {
                    var10_10 = var3_3.getBackgroundColor();
                    var9_9 /* !! */  = new BackgroundColorSpan(var10_10);
                    SpanUtil.addOrReplaceSpan(var0, var9_9 /* !! */ , var1_1, var2_2, var8_8);
                }
                if ((var9_9 /* !! */  = var3_3.getFontFamily()) != null) {
                    var11_11 = var3_3.getFontFamily();
                    var9_9 /* !! */  = new TypefaceSpan(var11_11);
                    SpanUtil.addOrReplaceSpan(var0, var9_9 /* !! */ , var1_1, var2_2, var8_8);
                }
                var6_6 = var3_3.getRubyType();
                var10_10 = 3;
                var12_12 = 2;
                var13_13 = 1;
                if (var6_6 == var12_12) break block16;
                if (var6_6 == var10_10 || var6_6 == (var14_14 = 4)) {
                    var4_4 = new DeleteTextSpan();
                    var0.setSpan(var4_4, var1_1, var2_2, var8_8);
                }
                break block17;
            }
            if ((var4_4 = TtmlRenderUtil.findRubyContainerNode((TtmlNode)var4_4, (Map)var5_5)) == null || (var5_5 = TtmlRenderUtil.findRubyTextNode((TtmlNode)var4_4, (Map)var5_5)) == null) break block17;
            var6_6 = var5_5.getChildCount();
            if (var6_6 != var13_13) ** GOTO lbl-1000
            var6_6 = 0;
            var9_9 /* !! */  = null;
            var15_15 = var5_5.getChild((int)0).text;
            if (var15_15 != null) {
                var5_5 = (String)Util.castNonNull(var5_5.getChild((int)0).text);
                var4_4 = var4_4.style;
                if (var4_4 != null) {
                    var7_7 = var4_4.getRubyPosition();
                }
                var4_4 = new RubySpan((String)var5_5, var7_7);
                var0.setSpan(var4_4, var1_1, var2_2, var8_8);
            } else lbl-1000:
            // 2 sources

            {
                var4_4 = "TtmlRenderUtil";
                var5_5 = "Skipping rubyText node without exactly one text child.";
                Log.i((String)var4_4, (String)var5_5);
            }
        }
        var14_14 = (int)var3_3.getTextCombine();
        if (var14_14 != 0) {
            var4_4 = new HorizontalTextInVerticalContextSpan();
            SpanUtil.addOrReplaceSpan(var0, var4_4, var1_1, var2_2, var8_8);
        }
        if ((var14_14 = var3_3.getFontSizeUnit()) != var13_13) {
            if (var14_14 != var12_12) {
                if (var14_14 == var10_10) {
                    var16_16 = var3_3.getFontSize();
                    var17_19 = 100.0f;
                    var4_4 = new RelativeSizeSpan(var16_16 /= var17_19);
                    SpanUtil.addOrReplaceSpan(var0, var4_4, var1_1, var2_2, var8_8);
                }
            } else {
                var16_17 = var3_3.getFontSize();
                var4_4 = new RelativeSizeSpan(var16_17);
                SpanUtil.addOrReplaceSpan(var0, var4_4, var1_1, var2_2, var8_8);
            }
        } else {
            var16_18 = var3_3.getFontSize();
            var18_20 = (int)var16_18;
            var4_4 = new AbsoluteSizeSpan(var18_20, (boolean)var13_13);
            SpanUtil.addOrReplaceSpan(var0, var4_4, var1_1, var2_2, var8_8);
        }
    }

    public static String applyTextElementSpacePolicy(String string2) {
        String string3 = "\n";
        string2 = string2.replaceAll("\r\n", string3).replaceAll(" *\n *", string3);
        String string4 = " ";
        return string2.replaceAll(string3, string4).replaceAll("[ \t\\x0B\f\r]+", string4);
    }

    /*
     * WARNING - void declaration
     */
    public static void endParagraph(SpannableStringBuilder spannableStringBuilder) {
        char c10;
        char c11;
        void var1_2;
        char c12;
        int c122 = spannableStringBuilder.length() + -1;
        while ((var1_2 += -1) >= 0 && (c12 = spannableStringBuilder.charAt((int)var1_2)) == (c11 = ' ')) {
        }
        if (var1_2 >= 0 && (c10 = spannableStringBuilder.charAt((int)var1_2)) != (c12 = '\n')) {
            spannableStringBuilder.append(c12);
        }
    }

    private static TtmlNode findRubyContainerNode(TtmlNode ttmlNode, Map map) {
        while (ttmlNode != null) {
            int n10;
            int n11;
            TtmlStyle ttmlStyle = ttmlNode.style;
            String[] stringArray = ttmlNode.getStyleIds();
            if ((ttmlStyle = TtmlRenderUtil.resolveStyle(ttmlStyle, stringArray, map)) != null && (n11 = ttmlStyle.getRubyType()) == (n10 = 1)) {
                return ttmlNode;
            }
            ttmlNode = ttmlNode.parent;
        }
        return null;
    }

    private static TtmlNode findRubyTextNode(TtmlNode ttmlNode, Map map) {
        boolean bl2;
        ArrayDeque<Object> arrayDeque = new ArrayDeque<Object>();
        arrayDeque.push(ttmlNode);
        while (!(bl2 = arrayDeque.isEmpty())) {
            int n10;
            int n11;
            ttmlNode = (TtmlNode)arrayDeque.pop();
            TtmlStyle ttmlStyle = ttmlNode.style;
            Object object = ttmlNode.getStyleIds();
            if ((ttmlStyle = TtmlRenderUtil.resolveStyle(ttmlStyle, object, map)) != null && (n11 = ttmlStyle.getRubyType()) == (n10 = 3)) {
                return ttmlNode;
            }
            for (n11 = ttmlNode.getChildCount() + -1; n11 >= 0; n11 += -1) {
                object = ttmlNode.getChild(n11);
                arrayDeque.push(object);
            }
        }
        return null;
    }

    /*
     * WARNING - void declaration
     */
    public static TtmlStyle resolveStyle(TtmlStyle object, String[] object2, Map map) {
        void var2_4;
        int n10 = 1;
        if (object == null) {
            if (object2 == null) {
                return null;
            }
            int n11 = ((Object)object2).length;
            if (n11 == n10) {
                object = object2[0];
                return (TtmlStyle)var2_4.get(object);
            }
            n11 = ((Object)object2).length;
            if (n11 > n10) {
                object = new TtmlStyle();
                for (Object object3 : object2) {
                    TtmlStyle ttmlStyle = (TtmlStyle)var2_4.get(object3);
                    ((TtmlStyle)object).chain(ttmlStyle);
                }
                return object;
            }
        } else {
            int n12;
            if (object2 != null && (n12 = ((Object)object2).length) == n10) {
                Object object4 = object2[0];
                TtmlStyle ttmlStyle = (TtmlStyle)var2_4.get(object4);
                return ((TtmlStyle)object).chain(ttmlStyle);
            }
            if (object2 != null && (n12 = ((Object)object2).length) > n10) {
                int n13;
                n10 = ((Object)object2).length;
                while (n13 < n10) {
                    Object object5 = object2[n13];
                    TtmlStyle ttmlStyle = (TtmlStyle)var2_4.get(object5);
                    ((TtmlStyle)object).chain(ttmlStyle);
                    ++n13;
                }
            }
        }
        return object;
    }
}

