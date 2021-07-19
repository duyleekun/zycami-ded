/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.Html
 *  android.text.Spanned
 *  android.text.style.AbsoluteSizeSpan
 *  android.text.style.BackgroundColorSpan
 *  android.text.style.ForegroundColorSpan
 *  android.text.style.RelativeSizeSpan
 *  android.text.style.StrikethroughSpan
 *  android.text.style.StyleSpan
 *  android.text.style.TypefaceSpan
 *  android.text.style.UnderlineSpan
 *  android.util.SparseArray
 */
package com.google.android.exoplayer2.ui;

import android.text.Html;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.SparseArray;
import com.google.android.exoplayer2.text.span.HorizontalTextInVerticalContextSpan;
import com.google.android.exoplayer2.text.span.RubySpan;
import com.google.android.exoplayer2.ui.HtmlUtils;
import com.google.android.exoplayer2.ui.SpannedToHtmlConverter$HtmlAndCss;
import com.google.android.exoplayer2.ui.SpannedToHtmlConverter$SpanInfo;
import com.google.android.exoplayer2.ui.SpannedToHtmlConverter$Transition;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

public final class SpannedToHtmlConverter {
    private static final Pattern NEWLINE_PATTERN = Pattern.compile("(&#13;)?&#10;");

    private SpannedToHtmlConverter() {
    }

    public static SpannedToHtmlConverter$HtmlAndCss convert(CharSequence object, float f10) {
        Object object2;
        int n10;
        int n11;
        if (object == null) {
            ImmutableMap immutableMap = ImmutableMap.of();
            object = new SpannedToHtmlConverter$HtmlAndCss("", immutableMap, null);
            return object;
        }
        boolean bl2 = object instanceof Spanned;
        if (!bl2) {
            object = SpannedToHtmlConverter.escapeHtml((CharSequence)object);
            ImmutableMap immutableMap = ImmutableMap.of();
            SpannedToHtmlConverter$HtmlAndCss spannedToHtmlConverter$HtmlAndCss = new SpannedToHtmlConverter$HtmlAndCss((String)object, immutableMap, null);
            return spannedToHtmlConverter$HtmlAndCss;
        }
        object = (Spanned)object;
        Object object3 = new HashSet();
        int n12 = object.length();
        Iterator iterator2 = BackgroundColorSpan.class;
        int n13 = 0;
        Object object4 = (BackgroundColorSpan[])object.getSpans(0, n12, iterator2);
        int n14 = ((BackgroundColorSpan[])object4).length;
        String string2 = null;
        for (n11 = 0; n11 < n14; ++n11) {
            n10 = object4[n11].getBackgroundColor();
            object2 = n10;
            object3.add(object2);
        }
        object4 = new HashMap();
        object3 = object3.iterator();
        while ((n14 = (int)(object3.hasNext() ? 1 : 0)) != 0) {
            n14 = (Integer)object3.next();
            n11 = 14;
            object2 = new StringBuilder(n11);
            ((StringBuilder)object2).append("bg_");
            ((StringBuilder)object2).append(n14);
            string2 = HtmlUtils.cssAllClassDescendantsSelector(((StringBuilder)object2).toString());
            n10 = 1;
            object2 = new Object[n10];
            iterator2 = HtmlUtils.toCssRgba(n14);
            object2[0] = iterator2;
            iterator2 = Util.formatInvariant("background-color:%s;", object2);
            ((HashMap)object4).put(string2, iterator2);
        }
        Object object5 = SpannedToHtmlConverter.findSpanTransitions((Spanned)object, f10);
        n14 = object.length();
        object3 = new StringBuilder(n14);
        n14 = 0;
        iterator2 = null;
        while (n13 < (n11 = object5.size())) {
            boolean bl3;
            n11 = object5.keyAt(n13);
            iterator2 = SpannedToHtmlConverter.escapeHtml(object.subSequence(n14, n11));
            ((StringBuilder)object3).append((String)((Object)iterator2));
            iterator2 = (SpannedToHtmlConverter$Transition)object5.get(n11);
            object2 = SpannedToHtmlConverter$Transition.access$100((SpannedToHtmlConverter$Transition)((Object)iterator2));
            Object object6 = SpannedToHtmlConverter$SpanInfo.access$200();
            Collections.sort(object2, object6);
            object2 = SpannedToHtmlConverter$Transition.access$100((SpannedToHtmlConverter$Transition)((Object)iterator2)).iterator();
            while (bl3 = object2.hasNext()) {
                object6 = ((SpannedToHtmlConverter$SpanInfo)object2.next()).closingTag;
                ((StringBuilder)object3).append((String)object6);
            }
            object2 = SpannedToHtmlConverter$Transition.access$300((SpannedToHtmlConverter$Transition)((Object)iterator2));
            object6 = SpannedToHtmlConverter$SpanInfo.access$400();
            Collections.sort(object2, object6);
            iterator2 = SpannedToHtmlConverter$Transition.access$300((SpannedToHtmlConverter$Transition)((Object)iterator2)).iterator();
            while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                object2 = ((SpannedToHtmlConverter$SpanInfo)iterator2.next()).openingTag;
                ((StringBuilder)object3).append((String)object2);
            }
            ++n13;
            n14 = n11;
        }
        int n15 = object.length();
        object = SpannedToHtmlConverter.escapeHtml(object.subSequence(n14, n15));
        ((StringBuilder)object3).append((String)object);
        object5 = ((StringBuilder)object3).toString();
        object = new SpannedToHtmlConverter$HtmlAndCss((String)object5, (Map)object4, null);
        return object;
    }

    private static String escapeHtml(CharSequence charSequence) {
        charSequence = Html.escapeHtml((CharSequence)charSequence);
        return NEWLINE_PATTERN.matcher(charSequence).replaceAll("<br>");
    }

    private static SparseArray findSpanTransitions(Spanned spanned, float f10) {
        SparseArray sparseArray = new SparseArray();
        int n10 = spanned.length();
        Class<Object> clazz = Object.class;
        for (Object object : spanned.getSpans(0, n10, clazz)) {
            SpannedToHtmlConverter$SpanInfo spannedToHtmlConverter$SpanInfo;
            String string2 = SpannedToHtmlConverter.getOpeningTag(object, f10);
            String string3 = SpannedToHtmlConverter.getClosingTag(object);
            int n11 = spanned.getSpanStart(object);
            int n12 = spanned.getSpanEnd(object);
            if (string2 == null) continue;
            Assertions.checkNotNull(string3);
            Object object2 = spannedToHtmlConverter$SpanInfo;
            spannedToHtmlConverter$SpanInfo = new SpannedToHtmlConverter$SpanInfo(n11, n12, string2, string3, null);
            object2 = SpannedToHtmlConverter$Transition.access$300(SpannedToHtmlConverter.getOrCreate(sparseArray, n11));
            object2.add(spannedToHtmlConverter$SpanInfo);
            object = SpannedToHtmlConverter$Transition.access$100(SpannedToHtmlConverter.getOrCreate(sparseArray, n12));
            object.add(spannedToHtmlConverter$SpanInfo);
        }
        return sparseArray;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static String getClosingTag(Object object) {
        int n10 = object instanceof StrikethroughSpan;
        CharSequence charSequence = "</span>";
        if (n10 != 0) return charSequence;
        n10 = object instanceof ForegroundColorSpan;
        if (n10 != 0) return charSequence;
        n10 = object instanceof BackgroundColorSpan;
        if (n10 != 0) return charSequence;
        n10 = object instanceof HorizontalTextInVerticalContextSpan;
        if (n10 != 0) return charSequence;
        n10 = object instanceof AbsoluteSizeSpan;
        if (n10 != 0) return charSequence;
        n10 = object instanceof RelativeSizeSpan;
        if (n10 != 0) return charSequence;
        n10 = object instanceof TypefaceSpan;
        if (n10 != 0) {
            if ((object = ((TypefaceSpan)object).getFamily()) == null) return null;
            return charSequence;
        }
        n10 = object instanceof StyleSpan;
        if (n10 == 0) {
            n10 = object instanceof RubySpan;
            if (n10 != 0) {
                object = SpannedToHtmlConverter.escapeHtml(((RubySpan)object).rubyText);
                n10 = String.valueOf(object).length() + 16;
                charSequence = new StringBuilder(n10);
                ((StringBuilder)charSequence).append("<rt>");
                ((StringBuilder)charSequence).append((String)object);
                ((StringBuilder)charSequence).append("</rt></ruby>");
                return ((StringBuilder)charSequence).toString();
            }
            boolean bl2 = object instanceof UnderlineSpan;
            if (!bl2) return null;
            return "</u>";
        }
        int n11 = (object = (StyleSpan)object).getStyle();
        if (n11 == (n10 = 1)) return "</b>";
        n10 = 2;
        if (n11 == n10) return "</i>";
        n10 = 3;
        if (n11 == n10) return "</i></b>";
        return null;
    }

    private static String getOpeningTag(Object object, float f10) {
        boolean bl2 = object instanceof StrikethroughSpan;
        if (bl2) {
            return "<span style='text-decoration:line-through;'>";
        }
        bl2 = object instanceof ForegroundColorSpan;
        int n10 = 0;
        int n11 = 1;
        if (bl2) {
            object = (ForegroundColorSpan)object;
            Object[] objectArray = new Object[n11];
            objectArray[0] = object = HtmlUtils.toCssRgba(object.getForegroundColor());
            return Util.formatInvariant("<span style='color:%s;'>", objectArray);
        }
        bl2 = object instanceof BackgroundColorSpan;
        if (bl2) {
            object = (BackgroundColorSpan)object;
            Object[] objectArray = new Object[n11];
            objectArray[0] = object = Integer.valueOf(object.getBackgroundColor());
            return Util.formatInvariant("<span class='bg_%s'>", objectArray);
        }
        bl2 = object instanceof HorizontalTextInVerticalContextSpan;
        if (bl2) {
            return "<span style='text-combine-upright:all;'>";
        }
        bl2 = object instanceof AbsoluteSizeSpan;
        if (bl2) {
            float f11;
            bl2 = (object = (AbsoluteSizeSpan)object).getDip();
            if (bl2) {
                int n12 = object.getSize();
                f11 = n12;
            } else {
                int n13 = object.getSize();
                f11 = (float)n13 / f10;
            }
            Object[] objectArray = new Object[n11];
            objectArray[0] = object = Float.valueOf(f11);
            return Util.formatInvariant("<span style='font-size:%.2fpx;'>", objectArray);
        }
        int n14 = object instanceof RelativeSizeSpan;
        if (n14 != 0) {
            Object[] objectArray = new Object[n11];
            objectArray[0] = object = Float.valueOf(((RelativeSizeSpan)object).getSizeChange() * 100.0f);
            return Util.formatInvariant("<span style='font-size:%.2f%%;'>", objectArray);
        }
        n14 = object instanceof TypefaceSpan;
        bl2 = false;
        String string2 = null;
        if (n14 != 0) {
            if ((object = ((TypefaceSpan)object).getFamily()) != null) {
                Object[] objectArray = new Object[n11];
                objectArray[0] = object;
                object = "<span style='font-family:\"%s\";'>";
                string2 = Util.formatInvariant((String)object, objectArray);
            }
            return string2;
        }
        n14 = object instanceof StyleSpan;
        n10 = 2;
        if (n14 != 0) {
            int n15 = (object = (StyleSpan)object).getStyle();
            if (n15 != n11) {
                if (n15 != n10) {
                    n14 = 3;
                    f10 = 4.2E-45f;
                    if (n15 != n14) {
                        return null;
                    }
                    return "<b><i>";
                }
                return "<i>";
            }
            return "<b>";
        }
        n14 = object instanceof RubySpan;
        if (n14 != 0) {
            object = (RubySpan)object;
            int n16 = ((RubySpan)object).position;
            n14 = -1;
            f10 = 0.0f / 0.0f;
            if (n16 != n14) {
                if (n16 != n11) {
                    if (n16 != n10) {
                        return null;
                    }
                    return "<ruby style='ruby-position:under;'>";
                }
                return "<ruby style='ruby-position:over;'>";
            }
            return "<ruby style='ruby-position:unset;'>";
        }
        boolean bl3 = object instanceof UnderlineSpan;
        if (bl3) {
            return "<u>";
        }
        return null;
    }

    private static SpannedToHtmlConverter$Transition getOrCreate(SparseArray sparseArray, int n10) {
        SpannedToHtmlConverter$Transition spannedToHtmlConverter$Transition = (SpannedToHtmlConverter$Transition)sparseArray.get(n10);
        if (spannedToHtmlConverter$Transition == null) {
            spannedToHtmlConverter$Transition = new SpannedToHtmlConverter$Transition();
            sparseArray.put(n10, (Object)spannedToHtmlConverter$Transition);
        }
        return spannedToHtmlConverter$Transition;
    }
}

