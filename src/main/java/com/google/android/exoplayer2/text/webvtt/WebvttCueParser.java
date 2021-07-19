/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 *  android.text.Spannable
 *  android.text.SpannableStringBuilder
 *  android.text.SpannedString
 *  android.text.TextUtils
 *  android.text.style.AbsoluteSizeSpan
 *  android.text.style.BackgroundColorSpan
 *  android.text.style.ForegroundColorSpan
 *  android.text.style.RelativeSizeSpan
 *  android.text.style.StrikethroughSpan
 *  android.text.style.StyleSpan
 *  android.text.style.TypefaceSpan
 *  android.text.style.UnderlineSpan
 */
package com.google.android.exoplayer2.text.webvtt;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Cue$Builder;
import com.google.android.exoplayer2.text.span.HorizontalTextInVerticalContextSpan;
import com.google.android.exoplayer2.text.span.RubySpan;
import com.google.android.exoplayer2.text.span.SpanUtil;
import com.google.android.exoplayer2.text.webvtt.WebvttCssStyle;
import com.google.android.exoplayer2.text.webvtt.WebvttCueInfo;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser$Element;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser$StartTag;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser$StyleMatch;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser$WebvttCueInfoBuilder;
import com.google.android.exoplayer2.text.webvtt.WebvttParserUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WebvttCueParser {
    private static final char CHAR_AMPERSAND = '&';
    private static final char CHAR_GREATER_THAN = '>';
    private static final char CHAR_LESS_THAN = '<';
    private static final char CHAR_SEMI_COLON = ';';
    private static final char CHAR_SLASH = '/';
    private static final char CHAR_SPACE = ' ';
    public static final Pattern CUE_HEADER_PATTERN = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    private static final Pattern CUE_SETTING_PATTERN = Pattern.compile("(\\S+?):(\\S+)");
    private static final Map DEFAULT_BACKGROUND_COLORS;
    public static final float DEFAULT_POSITION = 0.5f;
    private static final Map DEFAULT_TEXT_COLORS;
    private static final String ENTITY_AMPERSAND = "amp";
    private static final String ENTITY_GREATER_THAN = "gt";
    private static final String ENTITY_LESS_THAN = "lt";
    private static final String ENTITY_NON_BREAK_SPACE = "nbsp";
    private static final int STYLE_BOLD = 1;
    private static final int STYLE_ITALIC = 2;
    private static final String TAG = "WebvttCueParser";
    private static final String TAG_BOLD = "b";
    private static final String TAG_CLASS = "c";
    private static final String TAG_ITALIC = "i";
    private static final String TAG_LANG = "lang";
    private static final String TAG_RUBY = "ruby";
    private static final String TAG_RUBY_TEXT = "rt";
    private static final String TAG_UNDERLINE = "u";
    private static final String TAG_VOICE = "v";
    private static final int TEXT_ALIGNMENT_CENTER = 2;
    private static final int TEXT_ALIGNMENT_END = 3;
    private static final int TEXT_ALIGNMENT_LEFT = 4;
    private static final int TEXT_ALIGNMENT_RIGHT = 5;
    private static final int TEXT_ALIGNMENT_START = 1;

    static {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        int n10 = 255;
        Integer n11 = Color.rgb((int)n10, (int)n10, (int)n10);
        hashMap.put("white", n11);
        Integer n12 = Color.rgb((int)0, (int)n10, (int)0);
        hashMap.put("lime", n12);
        n12 = Color.rgb((int)0, (int)n10, (int)n10);
        hashMap.put("cyan", n12);
        n12 = Color.rgb((int)n10, (int)0, (int)0);
        hashMap.put("red", n12);
        n12 = Color.rgb((int)n10, (int)n10, (int)0);
        hashMap.put("yellow", n12);
        n12 = Color.rgb((int)n10, (int)0, (int)n10);
        hashMap.put("magenta", n12);
        n12 = Color.rgb((int)0, (int)0, (int)n10);
        hashMap.put("blue", n12);
        n12 = Color.rgb((int)0, (int)0, (int)0);
        hashMap.put("black", n12);
        DEFAULT_TEXT_COLORS = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap<String, Integer>();
        n12 = Color.rgb((int)n10, (int)n10, (int)n10);
        hashMap.put("bg_white", n12);
        n12 = Color.rgb((int)0, (int)n10, (int)0);
        hashMap.put("bg_lime", n12);
        n12 = Color.rgb((int)0, (int)n10, (int)n10);
        hashMap.put("bg_cyan", n12);
        n12 = Color.rgb((int)n10, (int)0, (int)0);
        hashMap.put("bg_red", n12);
        n12 = Color.rgb((int)n10, (int)n10, (int)0);
        hashMap.put("bg_yellow", n12);
        n12 = Color.rgb((int)n10, (int)0, (int)n10);
        hashMap.put("bg_magenta", n12);
        Integer n13 = Color.rgb((int)0, (int)0, (int)n10);
        hashMap.put("bg_blue", n13);
        n13 = Color.rgb((int)0, (int)0, (int)0);
        hashMap.put("bg_black", n13);
        DEFAULT_BACKGROUND_COLORS = Collections.unmodifiableMap(hashMap);
    }

    private static void applyDefaultColors(SpannableStringBuilder spannableStringBuilder, Set object, int n10, int n11) {
        int n12;
        object = object.iterator();
        while ((n12 = object.hasNext()) != 0) {
            Object object2 = (String)object.next();
            Map map = DEFAULT_TEXT_COLORS;
            boolean bl2 = map.containsKey(object2);
            int n13 = 33;
            if (bl2) {
                object2 = (Integer)map.get(object2);
                n12 = (Integer)object2;
                map = new ForegroundColorSpan(n12);
                spannableStringBuilder.setSpan((Object)map, n10, n11, n13);
                continue;
            }
            map = DEFAULT_BACKGROUND_COLORS;
            bl2 = map.containsKey(object2);
            if (!bl2) continue;
            object2 = (Integer)map.get(object2);
            n12 = (Integer)object2;
            map = new BackgroundColorSpan(n12);
            spannableStringBuilder.setSpan((Object)map, n10, n11, n13);
        }
    }

    private static void applyEntity(String string2, SpannableStringBuilder object) {
        CharSequence charSequence;
        string2.hashCode();
        int n10 = string2.hashCode();
        int n11 = -1;
        switch (n10) {
            default: {
                break;
            }
            case 3374865: {
                charSequence = ENTITY_NON_BREAK_SPACE;
                n10 = (int)(string2.equals(charSequence) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 3;
                break;
            }
            case 96708: {
                charSequence = ENTITY_AMPERSAND;
                n10 = (int)(string2.equals(charSequence) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 2;
                break;
            }
            case 3464: {
                charSequence = ENTITY_LESS_THAN;
                n10 = (int)(string2.equals(charSequence) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 1;
                break;
            }
            case 3309: {
                charSequence = ENTITY_GREATER_THAN;
                n10 = (int)(string2.equals(charSequence) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 0;
            }
        }
        switch (n11) {
            default: {
                int n12 = String.valueOf(string2).length() + 33;
                charSequence = new StringBuilder(n12);
                ((StringBuilder)charSequence).append("ignoring unsupported entity: '&");
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append(";'");
                string2 = ((StringBuilder)charSequence).toString();
                object = TAG;
                Log.w((String)object, string2);
                break;
            }
            case 3: {
                char c10 = ' ';
                object.append(c10);
                break;
            }
            case 2: {
                char c11 = '&';
                object.append(c11);
                break;
            }
            case 1: {
                char c12 = '<';
                object.append(c12);
                break;
            }
            case 0: {
                char c13 = '>';
                object.append(c13);
            }
        }
    }

    private static void applyRubySpans(SpannableStringBuilder spannableStringBuilder, String string2, WebvttCueParser$StartTag webvttCueParser$StartTag, List object, List list) {
        int n10;
        int n11 = WebvttCueParser.getRubyPosition(list, string2, webvttCueParser$StartTag);
        int n12 = object.size();
        ArrayList arrayList = new ArrayList(n12);
        arrayList.addAll(object);
        object = WebvttCueParser$Element.access$100();
        Collections.sort(arrayList, object);
        int n13 = webvttCueParser$StartTag.position;
        object = null;
        n12 = 0;
        for (int i10 = 0; i10 < (n10 = arrayList.size()); ++i10) {
            Object object2 = TAG_RUBY_TEXT;
            Object object3 = WebvttCueParser$Element.access$200((WebvttCueParser$Element)((WebvttCueParser$Element)arrayList.get((int)i10))).name;
            n10 = (int)(((String)object2).equals(object3) ? 1 : 0);
            if (n10 == 0) continue;
            object3 = (WebvttCueParser$Element)arrayList.get(i10);
            object2 = WebvttCueParser$Element.access$200((WebvttCueParser$Element)object3);
            int n14 = WebvttCueParser.firstKnownRubyPosition(WebvttCueParser.getRubyPosition(list, string2, (WebvttCueParser$StartTag)object2), n11, 1);
            WebvttCueParser$StartTag webvttCueParser$StartTag2 = WebvttCueParser$Element.access$200((WebvttCueParser$Element)object3);
            int n15 = webvttCueParser$StartTag2.position - n12;
            n10 = WebvttCueParser$Element.access$300((WebvttCueParser$Element)object3) - n12;
            CharSequence charSequence = spannableStringBuilder.subSequence(n15, n10);
            spannableStringBuilder.delete(n15, n10);
            String string3 = charSequence.toString();
            object3 = new RubySpan(string3, n14);
            n14 = 33;
            spannableStringBuilder.setSpan(object3, n13, n15, n14);
            n13 = charSequence.length();
            n12 += n13;
            n13 = n15;
        }
    }

    private static void applySpansForTag(String object, WebvttCueParser$StartTag object2, List collection, SpannableStringBuilder spannableStringBuilder, List list) {
        int n10;
        int n11;
        int n12 = ((WebvttCueParser$StartTag)object2).position;
        int n13 = spannableStringBuilder.length();
        String string2 = ((WebvttCueParser$StartTag)object2).name;
        string2.hashCode();
        int n14 = string2.hashCode();
        int n15 = 2;
        int n16 = 0;
        int n17 = 1;
        int n18 = -1;
        switch (n14) {
            default: {
                break;
            }
            case 3511770: {
                String string3 = TAG_RUBY;
                n11 = (int)(string2.equals(string3) ? 1 : 0);
                if (n11 == 0) break;
                n18 = 7;
                break;
            }
            case 3314158: {
                String string3 = TAG_LANG;
                n11 = (int)(string2.equals(string3) ? 1 : 0);
                if (n11 == 0) break;
                n18 = 6;
                break;
            }
            case 118: {
                String string3 = TAG_VOICE;
                n11 = (int)(string2.equals(string3) ? 1 : 0);
                if (n11 == 0) break;
                n18 = 5;
                break;
            }
            case 117: {
                String string3 = TAG_UNDERLINE;
                n11 = (int)(string2.equals(string3) ? 1 : 0);
                if (n11 == 0) break;
                n18 = 4;
                break;
            }
            case 105: {
                String string3 = TAG_ITALIC;
                n11 = (int)(string2.equals(string3) ? 1 : 0);
                if (n11 == 0) break;
                n18 = 3;
                break;
            }
            case 99: {
                String string3 = TAG_CLASS;
                n11 = (int)(string2.equals(string3) ? 1 : 0);
                if (n11 == 0) break;
                n18 = n15;
                break;
            }
            case 98: {
                String string3 = TAG_BOLD;
                n11 = (int)(string2.equals(string3) ? 1 : 0);
                if (n11 == 0) break;
                n18 = n17;
                break;
            }
            case 0: {
                String string3 = "";
                n11 = (int)(string2.equals(string3) ? 1 : 0);
                if (n11 == 0) break;
                n18 = 0;
            }
        }
        n11 = 33;
        switch (n18) {
            default: {
                return;
            }
            case 7: {
                WebvttCueParser.applyRubySpans(spannableStringBuilder, (String)object, (WebvttCueParser$StartTag)object2, collection, list);
                break;
            }
            case 4: {
                collection = new UnderlineSpan();
                spannableStringBuilder.setSpan((Object)collection, n12, n13, n11);
                break;
            }
            case 3: {
                collection = new StyleSpan(n15);
                spannableStringBuilder.setSpan((Object)collection, n12, n13, n11);
                break;
            }
            case 2: {
                collection = ((WebvttCueParser$StartTag)object2).classes;
                WebvttCueParser.applyDefaultColors(spannableStringBuilder, (Set)collection, n12, n13);
                break;
            }
            case 1: {
                collection = new StyleSpan(n17);
                spannableStringBuilder.setSpan((Object)collection, n12, n13, n11);
            }
            case 0: 
            case 5: 
            case 6: 
        }
        object = WebvttCueParser.getApplicableStyles(list, (String)object, (WebvttCueParser$StartTag)object2);
        while (n16 < (n10 = object.size())) {
            object2 = ((WebvttCueParser$StyleMatch)object.get((int)n16)).style;
            WebvttCueParser.applyStyleToText(spannableStringBuilder, (WebvttCssStyle)object2, n12, n13);
            ++n16;
        }
    }

    private static void applyStyleToText(SpannableStringBuilder spannableStringBuilder, WebvttCssStyle object, int n10, int n11) {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        boolean bl5;
        Object object2;
        if (object == null) {
            return;
        }
        int bl22 = ((WebvttCssStyle)object).getStyle();
        int n12 = -1;
        float f10 = 0.0f / 0.0f;
        int n13 = 33;
        if (bl22 != n12) {
            int n14 = ((WebvttCssStyle)object).getStyle();
            object2 = new StyleSpan(n14);
            SpanUtil.addOrReplaceSpan((Spannable)spannableStringBuilder, object2, n10, n11, n13);
        }
        if (bl5 = ((WebvttCssStyle)object).isLinethrough()) {
            object2 = new StrikethroughSpan();
            spannableStringBuilder.setSpan(object2, n10, n11, n13);
        }
        if (bl4 = ((WebvttCssStyle)object).isUnderline()) {
            object2 = new UnderlineSpan();
            spannableStringBuilder.setSpan(object2, n10, n11, n13);
        }
        if (bl3 = ((WebvttCssStyle)object).hasFontColor()) {
            int n15 = ((WebvttCssStyle)object).getFontColor();
            object2 = new ForegroundColorSpan(n15);
            SpanUtil.addOrReplaceSpan((Spannable)spannableStringBuilder, object2, n10, n11, n13);
        }
        if (bl2 = ((WebvttCssStyle)object).hasBackgroundColor()) {
            int n16 = ((WebvttCssStyle)object).getBackgroundColor();
            object2 = new BackgroundColorSpan(n16);
            SpanUtil.addOrReplaceSpan((Spannable)spannableStringBuilder, object2, n10, n11, n13);
        }
        if ((object2 = ((WebvttCssStyle)object).getFontFamily()) != null) {
            String string2 = ((WebvttCssStyle)object).getFontFamily();
            object2 = new TypefaceSpan(string2);
            SpanUtil.addOrReplaceSpan((Spannable)spannableStringBuilder, object2, n10, n11, n13);
        }
        int n17 = ((WebvttCssStyle)object).getFontSizeUnit();
        int n18 = 1;
        f10 = Float.MIN_VALUE;
        if (n17 != n18) {
            int n19 = 2;
            f10 = 2.8E-45f;
            if (n17 != n19) {
                int n20 = 3;
                f10 = 4.2E-45f;
                if (n17 == n20) {
                    f10 = ((WebvttCssStyle)object).getFontSize();
                    int n21 = 1120403456;
                    float f11 = 100.0f;
                    object2 = new RelativeSizeSpan(f10 /= f11);
                    SpanUtil.addOrReplaceSpan((Spannable)spannableStringBuilder, object2, n10, n11, n13);
                }
            } else {
                f10 = ((WebvttCssStyle)object).getFontSize();
                object2 = new RelativeSizeSpan(f10);
                SpanUtil.addOrReplaceSpan((Spannable)spannableStringBuilder, object2, n10, n11, n13);
            }
        } else {
            float f12 = ((WebvttCssStyle)object).getFontSize();
            int n22 = (int)f12;
            object2 = new AbsoluteSizeSpan(n22, n18 != 0);
            SpanUtil.addOrReplaceSpan((Spannable)spannableStringBuilder, object2, n10, n11, n13);
        }
        boolean bl6 = ((WebvttCssStyle)object).getCombineUpright();
        if (bl6) {
            object = new HorizontalTextInVerticalContextSpan();
            spannableStringBuilder.setSpan(object, n10, n11, n13);
        }
    }

    private static int findEndOfTag(String string2, int n10) {
        int n11;
        int n12 = (n10 = string2.indexOf(62, n10)) == (n11 = -1) ? string2.length() : n10 + 1;
        return n12;
    }

    private static int firstKnownRubyPosition(int n10, int n11, int n12) {
        int n13 = -1;
        if (n10 != n13) {
            return n10;
        }
        if (n11 != n13) {
            return n11;
        }
        if (n12 != n13) {
            return n12;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    private static List getApplicableStyles(List list, String string2, WebvttCueParser$StartTag webvttCueParser$StartTag) {
        int n10;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            String string3;
            Object object;
            String string4;
            WebvttCssStyle webvttCssStyle = (WebvttCssStyle)list.get(i10);
            int n11 = webvttCssStyle.getSpecificityScore(string2, string4 = webvttCueParser$StartTag.name, (Set)(object = webvttCueParser$StartTag.classes), string3 = webvttCueParser$StartTag.voice);
            if (n11 <= 0) continue;
            object = new WebvttCueParser$StyleMatch(n11, webvttCssStyle);
            arrayList.add(object);
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static int getRubyPosition(List list, String string2, WebvttCueParser$StartTag object) {
        int n10;
        list = WebvttCueParser.getApplicableStyles(list, string2, (WebvttCueParser$StartTag)object);
        int n11 = 0;
        string2 = null;
        while (true) {
            int n12 = list.size();
            n10 = -1;
            if (n11 >= n12) break;
            object = ((WebvttCueParser$StyleMatch)list.get((int)n11)).style;
            int n13 = ((WebvttCssStyle)object).getRubyPosition();
            if (n13 != n10) {
                return ((WebvttCssStyle)object).getRubyPosition();
            }
            ++n11;
        }
        return n10;
    }

    private static String getTagName(String string2) {
        string2 = string2.trim();
        Assertions.checkArgument(string2.isEmpty() ^ true);
        return Util.splitAtFirst(string2, "[ \\.]")[0];
    }

    private static boolean isSupportedTag(String string2) {
        string2.hashCode();
        int n10 = string2.hashCode();
        int n11 = 1;
        int n12 = -1;
        switch (n10) {
            default: {
                break;
            }
            case 3511770: {
                String string3 = TAG_RUBY;
                boolean bl2 = string2.equals(string3);
                if (!bl2) break;
                n12 = 7;
                break;
            }
            case 3314158: {
                String string4 = TAG_LANG;
                boolean bl3 = string2.equals(string4);
                if (!bl3) break;
                n12 = 6;
                break;
            }
            case 3650: {
                String string5 = TAG_RUBY_TEXT;
                boolean bl4 = string2.equals(string5);
                if (!bl4) break;
                n12 = 5;
                break;
            }
            case 118: {
                String string6 = TAG_VOICE;
                boolean bl5 = string2.equals(string6);
                if (!bl5) break;
                n12 = 4;
                break;
            }
            case 117: {
                String string7 = TAG_UNDERLINE;
                boolean bl6 = string2.equals(string7);
                if (!bl6) break;
                n12 = 3;
                break;
            }
            case 105: {
                String string8 = TAG_ITALIC;
                boolean bl7 = string2.equals(string8);
                if (!bl7) break;
                n12 = 2;
                break;
            }
            case 99: {
                String string9 = TAG_CLASS;
                boolean bl8 = string2.equals(string9);
                if (!bl8) break;
                n12 = n11;
                break;
            }
            case 98: {
                String string10 = TAG_BOLD;
                boolean bl9 = string2.equals(string10);
                if (!bl9) break;
                n12 = 0;
            }
        }
        switch (n12) {
            default: {
                return false;
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
        }
        return n11 != 0;
    }

    public static Cue newCueForText(CharSequence charSequence) {
        WebvttCueParser$WebvttCueInfoBuilder webvttCueParser$WebvttCueInfoBuilder = new WebvttCueParser$WebvttCueInfoBuilder();
        webvttCueParser$WebvttCueInfoBuilder.text = charSequence;
        return webvttCueParser$WebvttCueInfoBuilder.toCueBuilder().build();
    }

    public static WebvttCueInfo parseCue(ParsableByteArray parsableByteArray, List list) {
        String string2 = parsableByteArray.readLine();
        if (string2 == null) {
            return null;
        }
        Object object = CUE_HEADER_PATTERN;
        Object object2 = ((Pattern)object).matcher(string2);
        boolean bl2 = ((Matcher)object2).matches();
        if (bl2) {
            return WebvttCueParser.parseCue(null, (Matcher)object2, parsableByteArray, list);
        }
        object2 = parsableByteArray.readLine();
        if (object2 == null) {
            return null;
        }
        boolean bl3 = ((Matcher)(object = ((Pattern)object).matcher((CharSequence)object2))).matches();
        if (bl3) {
            return WebvttCueParser.parseCue(string2.trim(), (Matcher)object, parsableByteArray, list);
        }
        return null;
    }

    private static WebvttCueInfo parseCue(String object, Matcher object2, ParsableByteArray parsableByteArray, List list) {
        int n10;
        WebvttCueParser$WebvttCueInfoBuilder webvttCueParser$WebvttCueInfoBuilder = new WebvttCueParser$WebvttCueInfoBuilder();
        int n11 = 1;
        Object object3 = ((Matcher)object2).group(n11);
        object3 = Assertions.checkNotNull(object3);
        object3 = (String)object3;
        long l10 = WebvttParserUtil.parseTimestampUs((String)object3);
        webvttCueParser$WebvttCueInfoBuilder.startTimeUs = l10;
        n11 = 2;
        object3 = ((Matcher)object2).group(n11);
        object3 = Assertions.checkNotNull(object3);
        object3 = (String)object3;
        l10 = WebvttParserUtil.parseTimestampUs((String)object3);
        try {
            webvttCueParser$WebvttCueInfoBuilder.endTimeUs = l10;
            n11 = 3;
        }
        catch (NumberFormatException numberFormatException) {
            object = "Skipping cue with bad header: ";
            object2 = String.valueOf(((Matcher)object2).group());
            int n12 = ((String)object2).length();
            object = n12 != 0 ? ((String)object).concat((String)object2) : (object2 = new String((String)object));
            Log.w(TAG, (String)object);
            return null;
        }
        WebvttCueParser.parseCueSettingsList((String)Assertions.checkNotNull(((Matcher)object2).group(n11)), webvttCueParser$WebvttCueInfoBuilder);
        object2 = new StringBuilder();
        object3 = parsableByteArray.readLine();
        while ((n10 = TextUtils.isEmpty((CharSequence)object3)) == 0) {
            n10 = ((StringBuilder)object2).length();
            if (n10 > 0) {
                String string2 = "\n";
                ((StringBuilder)object2).append(string2);
            }
            object3 = ((String)object3).trim();
            ((StringBuilder)object2).append((String)object3);
            object3 = parsableByteArray.readLine();
        }
        object2 = ((StringBuilder)object2).toString();
        webvttCueParser$WebvttCueInfoBuilder.text = object = WebvttCueParser.parseCueText((String)object, (String)object2, list);
        return webvttCueParser$WebvttCueInfoBuilder.build();
    }

    public static Cue$Builder parseCueSettingsList(String string2) {
        WebvttCueParser$WebvttCueInfoBuilder webvttCueParser$WebvttCueInfoBuilder = new WebvttCueParser$WebvttCueInfoBuilder();
        WebvttCueParser.parseCueSettingsList(string2, webvttCueParser$WebvttCueInfoBuilder);
        return webvttCueParser$WebvttCueInfoBuilder.toCueBuilder();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void parseCueSettingsList(String object, WebvttCueParser$WebvttCueInfoBuilder webvttCueParser$WebvttCueInfoBuilder) {
        String string2 = TAG;
        Object object2 = CUE_SETTING_PATTERN;
        object = ((Pattern)object2).matcher((CharSequence)object);
        int n10;
        while ((n10 = ((Matcher)object).find()) != 0) {
            int n11;
            n10 = 1;
            float f10 = Float.MIN_VALUE;
            object2 = (String)Assertions.checkNotNull(((Matcher)object).group(n10));
            int n12 = 2;
            String string3 = (String)Assertions.checkNotNull(((Matcher)object).group(n12));
            String string4 = "line";
            try {
                n11 = string4.equals(object2);
                if (n11 != 0) {
                    WebvttCueParser.parseLineAttribute(string3, webvttCueParser$WebvttCueInfoBuilder);
                    continue;
                }
                string4 = "align";
                n11 = string4.equals(object2);
                if (n11 != 0) {
                    webvttCueParser$WebvttCueInfoBuilder.textAlignment = n10 = WebvttCueParser.parseTextAlignment(string3);
                    continue;
                }
                string4 = "position";
                n11 = (int)(string4.equals(object2) ? 1 : 0);
                if (n11 != 0) {
                    WebvttCueParser.parsePositionAttribute(string3, webvttCueParser$WebvttCueInfoBuilder);
                    continue;
                }
                string4 = "size";
                n11 = (int)(string4.equals(object2) ? 1 : 0);
                if (n11 != 0) {
                    webvttCueParser$WebvttCueInfoBuilder.size = f10 = WebvttParserUtil.parsePercentage(string3);
                    continue;
                }
                string4 = "vertical";
                n11 = (int)(string4.equals(object2) ? 1 : 0);
                if (n11 != 0) {
                    webvttCueParser$WebvttCueInfoBuilder.verticalType = n10 = WebvttCueParser.parseVerticalAttribute(string3);
                    continue;
                }
                string4 = String.valueOf(object2);
                n11 = string4.length() + 21;
                CharSequence charSequence = String.valueOf(string3);
                int n13 = ((String)charSequence).length();
                charSequence = new StringBuilder(n11 += n13);
                string4 = "Unknown cue setting ";
                ((StringBuilder)charSequence).append(string4);
                ((StringBuilder)charSequence).append((String)object2);
                object2 = ":";
                ((StringBuilder)charSequence).append((String)object2);
                ((StringBuilder)charSequence).append(string3);
                object2 = ((StringBuilder)charSequence).toString();
                Log.w(string2, (String)object2);
            }
            catch (NumberFormatException numberFormatException) {
                object2 = "Skipping bad cue setting: ";
                string3 = String.valueOf(((Matcher)object).group());
                n11 = string3.length();
                if (n11 != 0) {
                    object2 = ((String)object2).concat(string3);
                } else {
                    string3 = new String((String)object2);
                    object2 = string3;
                }
                Log.w(string2, (String)object2);
                continue;
            }
            break;
        }
        return;
    }

    /*
     * Unable to fully structure code
     */
    public static SpannedString parseCueText(String var0, String var1_1, List var2_2) {
        var3_3 = new SpannableStringBuilder();
        var4_4 = new Collection<Object>();
        var5_5 = new ArrayList<WebvttCueParser$Element>();
        var6_6 = 0;
        var7_7 = null;
        block0: while (var6_6 < (var8_8 = var1_1.length())) {
            block19: {
                block22: {
                    block21: {
                        block20: {
                            var8_8 = var1_1.charAt(var6_6);
                            if (var8_8 == (var9_9 = 38)) break block19;
                            var9_9 = 60;
                            if (var8_8 != var9_9) {
                                var3_3.append((char)var8_8);
                                ++var6_6;
                                continue;
                            }
                            var8_8 = var6_6 + '\u0001';
                            var9_9 = var1_1.length();
                            if (var8_8 >= var9_9) break block20;
                            var9_9 = var1_1.charAt(var8_8);
                            var10_10 = 47;
                            var11_11 = 1;
                            if (var9_9 == var10_10) {
                                var9_9 = var11_11;
                            } else {
                                var9_9 = 0;
                                var12_12 = null;
                            }
                            var8_8 = WebvttCueParser.findEndOfTag((String)var1_1, var8_8);
                            var13_13 = var8_8 + -2;
                            var14_14 = var1_1.charAt(var13_13);
                            var10_10 = var14_14 == var10_10 ? var11_11 : 0;
                            if (var9_9 != 0) {
                                var11_11 = 2;
                            }
                            var6_6 += var11_11;
                            if (var10_10 == 0) {
                                var13_13 = var8_8 + -1;
                            }
                            var7_7 = var1_1.substring(var6_6, var13_13);
                            var15_15 = var7_7.trim();
                            var11_11 = (int)var15_15.isEmpty();
                            if (var11_11 == 0 && (var13_13 = (int)WebvttCueParser.isSupportedTag(var15_15 = WebvttCueParser.getTagName((String)var7_7))) != 0) break block21;
                        }
lbl40:
                        // 5 sources

                        while (true) {
                            var6_6 = var8_8;
                            continue block0;
                            break;
                        }
                    }
                    if (var9_9 == 0) break block22;
                    do {
                        if ((var6_6 = (int)var4_4.isEmpty()) != 0) ** GOTO lbl40
                        var7_7 = (WebvttCueParser$StartTag)var4_4.pop();
                        WebvttCueParser.applySpansForTag(var0, (WebvttCueParser$StartTag)var7_7, var5_5, var3_3, var2_2);
                        var9_9 = (int)var4_4.isEmpty();
                        if (var9_9 == 0) {
                            var10_10 = var3_3.length();
                            var13_13 = 0;
                            var12_12 = new WebvttCueParser$Element((WebvttCueParser$StartTag)var7_7, var10_10, null);
                            var5_5.add(var12_12);
                            continue;
                        }
                        var5_5.clear();
                    } while ((var6_6 = (int)(var7_7 = var7_7.name).equals(var15_15)) == 0);
                    ** GOTO lbl40
                }
                if (var10_10 != 0) ** GOTO lbl40
                var9_9 = var3_3.length();
                var7_7 = WebvttCueParser$StartTag.buildStartTag((String)var7_7, var9_9);
                var4_4.push(var7_7);
                ** continue;
            }
            var9_9 = var1_1.indexOf(59, ++var6_6);
            var10_10 = var1_1.indexOf(32, var6_6);
            var11_11 = -1;
            if (var9_9 == var11_11) {
                var9_9 = var10_10;
            } else if (var10_10 != var11_11) {
                var9_9 = Math.min(var9_9, var10_10);
            }
            if (var9_9 != var11_11) {
                var7_7 = var1_1.substring(var6_6, var9_9);
                WebvttCueParser.applyEntity((String)var7_7, var3_3);
                if (var9_9 == var10_10) {
                    var7_7 = " ";
                    var3_3.append((CharSequence)var7_7);
                }
                var6_6 = ++var9_9;
                continue;
            }
            var3_3.append((char)var8_8);
        }
        while (!(var16_16 = var4_4.isEmpty())) {
            var1_1 = (WebvttCueParser$StartTag)var4_4.pop();
            WebvttCueParser.applySpansForTag(var0, (WebvttCueParser$StartTag)var1_1, var5_5, var3_3, var2_2);
        }
        var1_1 = WebvttCueParser$StartTag.buildWholeCueVirtualTag();
        var4_4 = Collections.emptyList();
        WebvttCueParser.applySpansForTag(var0, (WebvttCueParser$StartTag)var1_1, var4_4, var3_3, var2_2);
        return SpannedString.valueOf((CharSequence)var3_3);
    }

    private static int parseLineAnchor(String string2) {
        String string3;
        string2.hashCode();
        int n10 = string2.hashCode();
        int n11 = 2;
        int n12 = 1;
        int n13 = -1;
        switch (n10) {
            default: {
                break;
            }
            case 109757538: {
                string3 = "start";
                n10 = (int)(string2.equals(string3) ? 1 : 0);
                if (n10 == 0) break;
                n13 = 3;
                break;
            }
            case 100571: {
                string3 = "end";
                n10 = (int)(string2.equals(string3) ? 1 : 0);
                if (n10 == 0) break;
                n13 = n11;
                break;
            }
            case -1074341483: {
                string3 = "middle";
                n10 = (int)(string2.equals(string3) ? 1 : 0);
                if (n10 == 0) break;
                n13 = n12;
                break;
            }
            case -1364013995: {
                string3 = "center";
                n10 = (int)(string2.equals(string3) ? 1 : 0);
                if (n10 == 0) break;
                n13 = 0;
            }
        }
        switch (n13) {
            default: {
                string3 = "Invalid anchor value: ";
                string2 = String.valueOf(string2);
                n11 = string2.length();
                string2 = n11 != 0 ? string3.concat(string2) : new String(string3);
                Log.w(TAG, string2);
                return -1 << -1;
            }
            case 3: {
                return 0;
            }
            case 2: {
                return n11;
            }
            case 0: 
            case 1: 
        }
        return n12;
    }

    private static void parseLineAttribute(String string2, WebvttCueParser$WebvttCueInfoBuilder webvttCueParser$WebvttCueInfoBuilder) {
        String string3;
        int n10;
        int n11 = string2.indexOf(44);
        if (n11 != (n10 = -1)) {
            n10 = n11 + 1;
            String string4 = string2.substring(n10);
            webvttCueParser$WebvttCueInfoBuilder.lineAnchor = n10 = WebvttCueParser.parseLineAnchor(string4);
            string2 = string2.substring(0, n11);
        }
        if ((n11 = (int)(string2.endsWith(string3 = "%") ? 1 : 0)) != 0) {
            float f10;
            webvttCueParser$WebvttCueInfoBuilder.line = f10 = WebvttParserUtil.parsePercentage(string2);
            webvttCueParser$WebvttCueInfoBuilder.lineType = 0;
        } else {
            float f11;
            webvttCueParser$WebvttCueInfoBuilder.line = f11 = (float)Integer.parseInt(string2);
            int n12 = 1;
            f11 = Float.MIN_VALUE;
            webvttCueParser$WebvttCueInfoBuilder.lineType = n12;
        }
    }

    private static int parsePositionAnchor(String string2) {
        String string3;
        string2.hashCode();
        int n10 = string2.hashCode();
        int n11 = 2;
        int n12 = 1;
        int n13 = -1;
        switch (n10) {
            default: {
                break;
            }
            case 109757538: {
                string3 = "start";
                n10 = (int)(string2.equals(string3) ? 1 : 0);
                if (n10 == 0) break;
                n13 = 5;
                break;
            }
            case 100571: {
                string3 = "end";
                n10 = (int)(string2.equals(string3) ? 1 : 0);
                if (n10 == 0) break;
                n13 = 4;
                break;
            }
            case -1074341483: {
                string3 = "middle";
                n10 = (int)(string2.equals(string3) ? 1 : 0);
                if (n10 == 0) break;
                n13 = 3;
                break;
            }
            case -1276788989: {
                string3 = "line-right";
                n10 = (int)(string2.equals(string3) ? 1 : 0);
                if (n10 == 0) break;
                n13 = n11;
                break;
            }
            case -1364013995: {
                string3 = "center";
                n10 = (int)(string2.equals(string3) ? 1 : 0);
                if (n10 == 0) break;
                n13 = n12;
                break;
            }
            case -1842484672: {
                string3 = "line-left";
                n10 = (int)(string2.equals(string3) ? 1 : 0);
                if (n10 == 0) break;
                n13 = 0;
            }
        }
        switch (n13) {
            default: {
                string3 = "Invalid anchor value: ";
                string2 = String.valueOf(string2);
                n11 = string2.length();
                string2 = n11 != 0 ? string3.concat(string2) : new String(string3);
                Log.w(TAG, string2);
                return -1 << -1;
            }
            case 2: 
            case 4: {
                return n11;
            }
            case 1: 
            case 3: {
                return n12;
            }
            case 0: 
            case 5: 
        }
        return 0;
    }

    private static void parsePositionAttribute(String string2, WebvttCueParser$WebvttCueInfoBuilder webvttCueParser$WebvttCueInfoBuilder) {
        float f10;
        int n10;
        int n11 = string2.indexOf(44);
        if (n11 != (n10 = -1)) {
            n10 = n11 + 1;
            webvttCueParser$WebvttCueInfoBuilder.positionAnchor = n10 = WebvttCueParser.parsePositionAnchor(string2.substring(n10));
            n10 = 0;
            string2 = string2.substring(0, n11);
        }
        webvttCueParser$WebvttCueInfoBuilder.position = f10 = WebvttParserUtil.parsePercentage(string2);
    }

    private static int parseTextAlignment(String string2) {
        String string3;
        string2.hashCode();
        int n10 = string2.hashCode();
        int n11 = 5;
        int n12 = 4;
        int n13 = 3;
        int n14 = 1;
        int n15 = 2;
        int n16 = -1;
        switch (n10) {
            default: {
                break;
            }
            case 109757538: {
                string3 = "start";
                n10 = (int)(string2.equals(string3) ? 1 : 0);
                if (n10 == 0) break;
                n16 = n11;
                break;
            }
            case 108511772: {
                string3 = "right";
                n10 = (int)(string2.equals(string3) ? 1 : 0);
                if (n10 == 0) break;
                n16 = n12;
                break;
            }
            case 3317767: {
                string3 = "left";
                n10 = (int)(string2.equals(string3) ? 1 : 0);
                if (n10 == 0) break;
                n16 = n13;
                break;
            }
            case 100571: {
                string3 = "end";
                n10 = (int)(string2.equals(string3) ? 1 : 0);
                if (n10 == 0) break;
                n16 = n15;
                break;
            }
            case -1074341483: {
                string3 = "middle";
                n10 = (int)(string2.equals(string3) ? 1 : 0);
                if (n10 == 0) break;
                n16 = n14;
                break;
            }
            case -1364013995: {
                string3 = "center";
                n10 = (int)(string2.equals(string3) ? 1 : 0);
                if (n10 == 0) break;
                n16 = 0;
            }
        }
        switch (n16) {
            default: {
                string3 = "Invalid alignment value: ";
                string2 = String.valueOf(string2);
                n11 = string2.length();
                string2 = n11 != 0 ? string3.concat(string2) : new String(string3);
                Log.w(TAG, string2);
                return n15;
            }
            case 5: {
                return n14;
            }
            case 4: {
                return n11;
            }
            case 3: {
                return n12;
            }
            case 2: {
                return n13;
            }
            case 0: 
            case 1: 
        }
        return n15;
    }

    private static int parseVerticalAttribute(String string2) {
        string2.hashCode();
        String string3 = "lr";
        boolean bl2 = string2.equals(string3);
        if (!bl2) {
            string3 = "rl";
            bl2 = string2.equals(string3);
            if (!bl2) {
                string3 = "Invalid 'vertical' value: ";
                int n10 = (string2 = String.valueOf(string2)).length();
                string2 = n10 != 0 ? string3.concat(string2) : new String(string3);
                Log.w(TAG, string2);
                return -1 << -1;
            }
            return 1;
        }
        return 2;
    }
}

