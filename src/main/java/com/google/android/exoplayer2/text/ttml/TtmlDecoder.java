/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.Layout$Alignment
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 *  org.xmlpull.v1.XmlPullParserFactory
 */
package com.google.android.exoplayer2.text.ttml;

import android.text.Layout;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.ttml.TtmlDecoder$CellResolution;
import com.google.android.exoplayer2.text.ttml.TtmlDecoder$FrameAndTickRate;
import com.google.android.exoplayer2.text.ttml.TtmlDecoder$TtsExtent;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.exoplayer2.text.ttml.TtmlRegion;
import com.google.android.exoplayer2.text.ttml.TtmlStyle;
import com.google.android.exoplayer2.text.ttml.TtmlSubtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ColorParser;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class TtmlDecoder
extends SimpleSubtitleDecoder {
    private static final String ATTR_BEGIN = "begin";
    private static final String ATTR_DURATION = "dur";
    private static final String ATTR_END = "end";
    private static final String ATTR_IMAGE = "backgroundImage";
    private static final String ATTR_REGION = "region";
    private static final String ATTR_STYLE = "style";
    private static final Pattern CELL_RESOLUTION;
    private static final Pattern CLOCK_TIME;
    private static final TtmlDecoder$CellResolution DEFAULT_CELL_RESOLUTION;
    private static final TtmlDecoder$FrameAndTickRate DEFAULT_FRAME_AND_TICK_RATE;
    private static final int DEFAULT_FRAME_RATE = 30;
    private static final Pattern FONT_SIZE;
    private static final Pattern OFFSET_TIME;
    private static final Pattern PERCENTAGE_COORDINATES;
    private static final Pattern PIXEL_COORDINATES;
    private static final String TAG = "TtmlDecoder";
    private static final String TTP = "http://www.w3.org/ns/ttml#parameter";
    private final XmlPullParserFactory xmlParserFactory;

    static {
        CLOCK_TIME = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
        OFFSET_TIME = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
        FONT_SIZE = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
        PERCENTAGE_COORDINATES = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
        PIXEL_COORDINATES = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
        CELL_RESOLUTION = Pattern.compile("^(\\d+) (\\d+)$");
        int n10 = 1;
        Object object = new TtmlDecoder$FrameAndTickRate(30.0f, n10, n10);
        DEFAULT_FRAME_AND_TICK_RATE = object;
        DEFAULT_CELL_RESOLUTION = object = new TtmlDecoder$CellResolution(32, 15);
    }

    public TtmlDecoder() {
        String string2 = TAG;
        super(string2);
        try {
            string2 = XmlPullParserFactory.newInstance();
        }
        catch (XmlPullParserException xmlPullParserException) {
            RuntimeException runtimeException = new RuntimeException("Couldn't create XmlPullParserFactory instance", xmlPullParserException);
            throw runtimeException;
        }
        this.xmlParserFactory = string2;
        boolean bl2 = true;
        string2.setNamespaceAware(bl2);
    }

    private static TtmlStyle createIfNull(TtmlStyle ttmlStyle) {
        if (ttmlStyle == null) {
            ttmlStyle = new TtmlStyle();
        }
        return ttmlStyle;
    }

    private static boolean isSupportedTag(String string2) {
        boolean bl2;
        String string3 = "tt";
        boolean bl3 = string2.equals(string3);
        if (!(bl3 || (bl3 = string2.equals(string3 = "head")) || (bl3 = string2.equals(string3 = "body")) || (bl3 = string2.equals(string3 = "div")) || (bl3 = string2.equals(string3 = "p")) || (bl3 = string2.equals(string3 = "span")) || (bl3 = string2.equals(string3 = "br")) || (bl3 = string2.equals(string3 = ATTR_STYLE)) || (bl3 = string2.equals(string3 = "styling")) || (bl3 = string2.equals(string3 = "layout")) || (bl3 = string2.equals(string3 = ATTR_REGION)) || (bl3 = string2.equals(string3 = "metadata")) || (bl3 = string2.equals(string3 = "image")) || (bl3 = string2.equals(string3 = "data")) || (bl2 = string2.equals(string3 = "information")))) {
            bl2 = false;
            string2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static TtmlDecoder$CellResolution parseCellResolution(XmlPullParser object, TtmlDecoder$CellResolution ttmlDecoder$CellResolution) {
        Object object2 = TTP;
        Object object3 = "cellResolution";
        if ((object = object.getAttributeValue((String)object2, (String)object3)) == null) {
            return ttmlDecoder$CellResolution;
        }
        object2 = CELL_RESOLUTION.matcher((CharSequence)object);
        boolean bl2 = ((Matcher)object2).matches();
        String string2 = "Ignoring malformed cell resolution: ";
        String string3 = TAG;
        if (!bl2) {
            int n10 = ((String)(object = String.valueOf(object))).length();
            object = n10 != 0 ? string2.concat((String)object) : new String(string2);
            Log.w(string3, (String)object);
            return ttmlDecoder$CellResolution;
        }
        int n11 = 1;
        try {
            object3 = ((Matcher)object2).group(n11);
            object3 = Assertions.checkNotNull(object3);
            object3 = (String)object3;
            int n12 = Integer.parseInt((String)object3);
            int n13 = 2;
            object2 = ((Matcher)object2).group(n13);
            object2 = Assertions.checkNotNull(object2);
            object2 = (String)object2;
            int n14 = Integer.parseInt((String)object2);
            if (n12 != 0 && n14 != 0) {
                return new TtmlDecoder$CellResolution(n12, n14);
            }
            int n15 = 47;
            StringBuilder stringBuilder = new StringBuilder(n15);
            String string4 = "Invalid cell resolution ";
            stringBuilder.append(string4);
            stringBuilder.append(n12);
            object3 = " ";
            stringBuilder.append((String)object3);
            stringBuilder.append(n14);
            object2 = stringBuilder.toString();
            SubtitleDecoderException subtitleDecoderException = new SubtitleDecoderException((String)object2);
            throw subtitleDecoderException;
        }
        catch (NumberFormatException numberFormatException) {}
        object = String.valueOf(object);
        int n16 = ((String)object).length();
        object = n16 != 0 ? string2.concat((String)object) : new String(string2);
        Log.w(string3, (String)object);
        return ttmlDecoder$CellResolution;
    }

    private static void parseFontSize(String object, TtmlStyle object2) {
        Object object3;
        block16: {
            String string2;
            Object object4;
            int n10;
            int n11;
            int n12;
            block15: {
                block14: {
                    object3 = Util.split((String)object, "\\s+");
                    n12 = ((String[])object3).length;
                    n11 = 2;
                    n10 = 1;
                    if (n12 != n10) break block14;
                    object3 = FONT_SIZE.matcher((CharSequence)object);
                    break block15;
                }
                n12 = ((String[])object3).length;
                if (n12 != n11) break block16;
                object4 = FONT_SIZE;
                object3 = object3[n10];
                object3 = ((Pattern)object4).matcher((CharSequence)object3);
                object4 = TAG;
                string2 = "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.";
                Log.w((String)object4, string2);
            }
            n12 = (int)(((Matcher)object3).matches() ? 1 : 0);
            string2 = "'.";
            if (n12 != 0) {
                int n13 = 3;
                float f10 = 4.2E-45f;
                object4 = (String)Assertions.checkNotNull(((Matcher)object3).group(n13));
                ((String)object4).hashCode();
                int n14 = -1;
                int n15 = ((String)object4).hashCode();
                switch (n15) {
                    default: {
                        break;
                    }
                    case 3592: {
                        String string3 = "px";
                        n15 = (int)(((String)object4).equals(string3) ? 1 : 0);
                        if (n15 == 0) break;
                        n14 = n11;
                        break;
                    }
                    case 3240: {
                        String string4 = "em";
                        n15 = (int)(((String)object4).equals(string4) ? 1 : 0);
                        if (n15 == 0) break;
                        n14 = n10;
                        break;
                    }
                    case 37: {
                        String string5 = "%";
                        n15 = (int)(((String)object4).equals(string5) ? 1 : 0);
                        if (n15 == 0) break;
                        n14 = 0;
                    }
                }
                switch (n14) {
                    default: {
                        int n16 = String.valueOf(object4).length() + 30;
                        object3 = new StringBuilder(n16);
                        ((StringBuilder)object3).append("Invalid unit for fontSize: '");
                        ((StringBuilder)object3).append((String)object4);
                        ((StringBuilder)object3).append(string2);
                        object2 = ((StringBuilder)object3).toString();
                        object = new SubtitleDecoderException((String)object2);
                        throw object;
                    }
                    case 2: {
                        ((TtmlStyle)object2).setFontSizeUnit(n10);
                        break;
                    }
                    case 1: {
                        ((TtmlStyle)object2).setFontSizeUnit(n11);
                        break;
                    }
                    case 0: {
                        ((TtmlStyle)object2).setFontSizeUnit(n13);
                    }
                }
                f10 = Float.parseFloat((String)Assertions.checkNotNull(((Matcher)object3).group(n10)));
                ((TtmlStyle)object2).setFontSize(f10);
                return;
            }
            int n17 = String.valueOf(object).length() + 36;
            object4 = new StringBuilder(n17);
            ((StringBuilder)object4).append("Invalid expression for fontSize: '");
            ((StringBuilder)object4).append((String)object);
            ((StringBuilder)object4).append(string2);
            object = ((StringBuilder)object4).toString();
            object2 = new SubtitleDecoderException((String)object);
            throw object2;
        }
        int n18 = ((Object)object3).length;
        StringBuilder stringBuilder = new StringBuilder(52);
        stringBuilder.append("Invalid number of entries for fontSize: ");
        stringBuilder.append(n18);
        stringBuilder.append(".");
        object2 = stringBuilder.toString();
        object = new SubtitleDecoderException((String)object2);
        throw object;
    }

    private static TtmlDecoder$FrameAndTickRate parseFrameAndTickRates(XmlPullParser object) {
        int n10;
        int n11;
        String string2 = TTP;
        String string3 = object.getAttributeValue(string2, "frameRate");
        int n12 = string3 != null ? Integer.parseInt(string3) : 30;
        int n13 = 1065353216;
        float f10 = 1.0f;
        Object object2 = object.getAttributeValue(string2, "frameRateMultiplier");
        if (object2 != null) {
            Object object3 = Util.split((String)object2, " ");
            n11 = ((String[])object3).length;
            if (n11 == (n10 = 2)) {
                object2 = object3[0];
                n11 = Integer.parseInt((String)object2);
                float f11 = n11;
                n10 = 1;
                object3 = object3[n10];
                n13 = Integer.parseInt((String)object3);
                f10 = n13;
                f10 = f11 / f10;
            } else {
                object = new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
                throw object;
            }
        }
        object2 = DEFAULT_FRAME_AND_TICK_RATE;
        n10 = ((TtmlDecoder$FrameAndTickRate)object2).subFrameRate;
        String string4 = object.getAttributeValue(string2, "subFrameRate");
        if (string4 != null) {
            n10 = Integer.parseInt(string4);
        }
        n11 = ((TtmlDecoder$FrameAndTickRate)object2).tickRate;
        string4 = "tickRate";
        if ((object = object.getAttributeValue(string2, string4)) != null) {
            n11 = Integer.parseInt((String)object);
        }
        float f12 = (float)n12 * f10;
        object = new TtmlDecoder$FrameAndTickRate(f12, n10, n11);
        return object;
    }

    private static Map parseHeader(XmlPullParser xmlPullParser, Map map, TtmlDecoder$CellResolution ttmlDecoder$CellResolution, TtmlDecoder$TtsExtent ttmlDecoder$TtsExtent, Map map2, Map map3) {
        Object object;
        boolean bl2;
        do {
            Object object2;
            xmlPullParser.next();
            object = ATTR_STYLE;
            boolean bl3 = XmlPullParserUtil.isStartTag(xmlPullParser, (String)object);
            if (bl3) {
                object = XmlPullParserUtil.getAttributeValue(xmlPullParser, (String)object);
                object2 = new TtmlStyle();
                object2 = TtmlDecoder.parseStyleAttributes(xmlPullParser, (TtmlStyle)object2);
                if (object != null) {
                    object = TtmlDecoder.parseStyleIds((String)object);
                    int n10 = ((String[])object).length;
                    for (int i10 = 0; i10 < n10; ++i10) {
                        Object object3 = object[i10];
                        object3 = (TtmlStyle)map.get(object3);
                        ((TtmlStyle)object2).chain((TtmlStyle)object3);
                    }
                }
                if ((object = ((TtmlStyle)object2).getId()) == null) continue;
                map.put(object, object2);
                continue;
            }
            object = ATTR_REGION;
            bl2 = XmlPullParserUtil.isStartTag(xmlPullParser, (String)object);
            if (bl2) {
                object = TtmlDecoder.parseRegionAttributes(xmlPullParser, ttmlDecoder$CellResolution, ttmlDecoder$TtsExtent);
                if (object == null) continue;
                object2 = object.id;
                map2.put(object2, object);
                continue;
            }
            object = "metadata";
            bl2 = XmlPullParserUtil.isStartTag(xmlPullParser, (String)object);
            if (!bl2) continue;
            TtmlDecoder.parseMetadata(xmlPullParser, map3);
        } while (!(bl2 = XmlPullParserUtil.isEndTag(xmlPullParser, (String)(object = "head"))));
        return map;
    }

    private static void parseMetadata(XmlPullParser xmlPullParser, Map map) {
        String string2;
        boolean bl2;
        do {
            xmlPullParser.next();
            string2 = "image";
            bl2 = XmlPullParserUtil.isStartTag(xmlPullParser, string2);
            if (!bl2 || (string2 = XmlPullParserUtil.getAttributeValue(xmlPullParser, "id")) == null) continue;
            String string3 = xmlPullParser.nextText();
            map.put(string2, string3);
        } while (!(bl2 = XmlPullParserUtil.isEndTag(xmlPullParser, string2 = "metadata")));
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static TtmlNode parseNode(XmlPullParser var0, TtmlNode var1_1, Map var2_2, TtmlDecoder$FrameAndTickRate var3_3) {
        var4_4 /* !! */  = var0;
        var5_5 = var1_1;
        var6_6 = var3_3;
        var7_7 = var0.getAttributeCount();
        var8_8 = TtmlDecoder.parseStyleAttributes(var0, null);
        var9_9 /* !! */  = null;
        var10_10 = "";
        var11_11 = -9223372036854775807L;
        var13_12 = -9223372036854775807L;
        var15_13 = -9223372036854775807L;
        var17_14 = null;
        block16: for (var18_15 = 0; var18_15 < var7_7; ++var18_15) {
            var19_16 = var4_4 /* !! */ .getAttributeName(var18_15);
            var20_17 = var4_4 /* !! */ .getAttributeValue(var18_15);
            var19_16.hashCode();
            var21_18 = var19_16.hashCode();
            switch (var21_18) lbl-1000:
            // 7 sources

            {
                default: {
                    var22_19 = -1;
                    break;
                }
                case 1292595405: {
                    var23_20 = "backgroundImage";
                    var24_21 = var19_16.equals(var23_20);
                    if (var24_21 == 0) ** GOTO lbl-1000
                    var22_19 = 5;
                    break;
                }
                case 109780401: {
                    var23_20 = "style";
                    var24_21 = var19_16.equals(var23_20);
                    if (var24_21 == 0) ** GOTO lbl-1000
                    var22_19 = 4;
                    break;
                }
                case 93616297: {
                    var23_20 = "begin";
                    var24_21 = var19_16.equals(var23_20);
                    if (var24_21 == 0) ** GOTO lbl-1000
                    var22_19 = 3;
                    break;
                }
                case 100571: {
                    var23_20 = "end";
                    var24_21 = var19_16.equals(var23_20);
                    if (var24_21 == 0) ** GOTO lbl-1000
                    var22_19 = 2;
                    break;
                }
                case 99841: {
                    var23_20 = "dur";
                    var24_21 = var19_16.equals(var23_20);
                    if (var24_21 == 0) ** GOTO lbl-1000
                    var22_19 = 1;
                    break;
                }
                case -934795532: {
                    var23_20 = "region";
                    var24_21 = var19_16.equals(var23_20);
                    if (var24_21 == 0) ** GOTO lbl-1000
                    var22_19 = 0;
                    var23_20 = null;
                }
            }
            switch (var22_19) {
                default: {
                    ** GOTO lbl76
                }
                case 5: {
                    var19_16 = "#";
                    var24_21 = var20_17.startsWith((String)var19_16);
                    if (var24_21 != 0) {
                        var24_21 = 1;
                        var9_9 /* !! */  = var20_17.substring(var24_21);
                    }
                    ** GOTO lbl76
                }
                case 4: {
                    var19_16 = TtmlDecoder.parseStyleIds(var20_17);
                    var25_22 /* !! */  = var19_16.length;
                    if (var25_22 /* !! */  > 0) {
                        var17_14 = var19_16;
                    }
                    ** GOTO lbl76
                }
                case 3: {
                    var11_11 = TtmlDecoder.parseTimeExpression(var20_17, var6_6);
lbl76:
                    // 6 sources

                    while (true) {
                        var19_16 = var2_2;
                        continue block16;
                        break;
                    }
                }
                case 2: {
                    var13_12 = TtmlDecoder.parseTimeExpression(var20_17, var6_6);
                    ** GOTO lbl76
                }
                case 1: {
                    var15_13 = TtmlDecoder.parseTimeExpression(var20_17, var6_6);
                    ** continue;
                }
                case 0: 
            }
            var19_16 = var2_2;
            var22_19 = (int)var2_2.containsKey(var20_17);
            if (var22_19 == 0) continue;
            var10_10 = var20_17;
        }
        if (var5_5 != null) {
            var26_23 = var5_5.startTimeUs;
            var28_24 = -9223372036854775807L;
            cfr_temp_0 = var26_23 - var28_24;
            var25_22 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
            if (var25_22 /* !! */  != false) {
                var25_22 /* !! */  = (long)(var11_11 == var28_24 ? 0 : (var11_11 < var28_24 ? -1 : 1));
                if (var25_22 /* !! */  != false) {
                    var11_11 += var26_23;
                }
                if ((var25_22 /* !! */  = var13_12 == var28_24 ? 0 : (var13_12 < var28_24 ? -1 : 1)) != false) {
                    var13_12 += var26_23;
                }
            }
        } else {
            var28_24 = -9223372036854775807L;
        }
        var26_23 = var11_11;
        var25_22 /* !! */  = (long)(var13_12 == var28_24 ? 0 : (var13_12 < var28_24 ? -1 : 1));
        if (var25_22 /* !! */  != false) ** GOTO lbl-1000
        var25_22 /* !! */  = (long)(var15_13 == var28_24 ? 0 : (var15_13 < var28_24 ? -1 : 1));
        if (var25_22 /* !! */  != false) {
            var28_24 = var15_13 = var11_11 + var15_13;
        } else if (var5_5 != null && (var18_15 = (int)((cfr_temp_1 = (var30_25 = var5_5.endTimeUs) - var28_24) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1))) != 0) {
            var28_24 = var30_25;
        } else lbl-1000:
        // 2 sources

        {
            var28_24 = var13_12;
        }
        var4_4 /* !! */  = var0.getName();
        var20_17 = var17_14;
        var23_20 = var10_10;
        var17_14 = var9_9 /* !! */ ;
        var5_5 = var1_1;
        return TtmlNode.buildNode((String)var4_4 /* !! */ , var26_23, var28_24, var8_8, (String[])var20_17, var10_10, (String)var9_9 /* !! */ , var1_1);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static TtmlRegion parseRegionAttributes(XmlPullParser xmlPullParser, TtmlDecoder$CellResolution ttmlDecoder$CellResolution, TtmlDecoder$TtsExtent ttmlDecoder$TtsExtent) {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        block30: {
            String string2;
            block31: {
                float f10;
                float f11;
                float f12;
                int n10;
                float f13;
                float f14;
                float f15;
                float f16;
                int n11;
                String string3;
                block37: {
                    float f17;
                    float f18;
                    int n12;
                    block35: {
                        int n13;
                        float f19;
                        int n14;
                        float f20;
                        int n15;
                        block36: {
                            int n16;
                            int n17;
                            Object object5;
                            block34: {
                                float f21;
                                Object object6;
                                block32: {
                                    block33: {
                                        object4 = xmlPullParser;
                                        object3 = ttmlDecoder$TtsExtent;
                                        string3 = XmlPullParserUtil.getAttributeValue(xmlPullParser, "id");
                                        n12 = 0;
                                        f18 = 0.0f;
                                        String string4 = null;
                                        if (string3 == null) {
                                            return null;
                                        }
                                        object2 = XmlPullParserUtil.getAttributeValue(xmlPullParser, "origin");
                                        object = TAG;
                                        if (object2 == null) {
                                            Log.w((String)object, "Ignoring region without an origin");
                                            return null;
                                        }
                                        Object object7 = PERCENTAGE_COORDINATES;
                                        Object object8 = ((Pattern)object7).matcher((CharSequence)object2);
                                        object6 = PIXEL_COORDINATES;
                                        object5 = ((Pattern)object6).matcher((CharSequence)object2);
                                        int n18 = ((Matcher)object8).matches();
                                        string2 = "Ignoring region with malformed origin: ";
                                        String string5 = "Ignoring region with missing tts:extent: ";
                                        n11 = 1120403456;
                                        f17 = 100.0f;
                                        n15 = 2;
                                        f20 = 2.8E-45f;
                                        n14 = 1;
                                        f19 = Float.MIN_VALUE;
                                        if (n18 != 0) {
                                            try {
                                                object5 = ((Matcher)object8).group(n14);
                                                object5 = Assertions.checkNotNull(object5);
                                                object5 = (String)object5;
                                                f16 = Float.parseFloat((String)object5) / f17;
                                                object8 = ((Matcher)object8).group(n15);
                                                object8 = Assertions.checkNotNull(object8);
                                                object8 = (String)object8;
                                                f15 = Float.parseFloat((String)object8) / f17;
                                                float f22 = f16;
                                                f16 = f15;
                                                f15 = f22;
                                            }
                                            catch (NumberFormatException numberFormatException) {
                                                object4 = String.valueOf(object2);
                                                int n19 = ((String)object4).length();
                                                object4 = n19 != 0 ? string2.concat((String)object4) : new String(string2);
                                                Log.w((String)object, (String)object4);
                                                return null;
                                            }
                                        }
                                        int n20 = ((Matcher)object5).matches();
                                        if (n20 == 0) break block30;
                                        if (ttmlDecoder$TtsExtent == null) {
                                            object4 = String.valueOf(object2);
                                            int n21 = ((String)object4).length();
                                            object4 = n21 != 0 ? string5.concat((String)object4) : new String(string5);
                                            Log.w((String)object, (String)object4);
                                            return null;
                                        }
                                        object8 = ((Matcher)object5).group(n14);
                                        object8 = Assertions.checkNotNull(object8);
                                        object8 = (String)object8;
                                        n20 = Integer.parseInt((String)object8);
                                        object5 = ((Matcher)object5).group(n15);
                                        object5 = Assertions.checkNotNull(object5);
                                        object5 = (String)object5;
                                        n17 = Integer.parseInt((String)object5);
                                        f15 = n20;
                                        n18 = ttmlDecoder$TtsExtent.width;
                                        f14 = n18;
                                        f15 /= f14;
                                        f16 = n17;
                                        n18 = ttmlDecoder$TtsExtent.height;
                                        f14 = n18;
                                        f16 /= f14;
                                        String string6 = XmlPullParserUtil.getAttributeValue((XmlPullParser)object4, "extent");
                                        if (string6 == null) {
                                            Log.w((String)object, "Ignoring region without an extent");
                                            return null;
                                        }
                                        object7 = ((Pattern)object7).matcher(string6);
                                        object6 = ((Pattern)object6).matcher(string6);
                                        n18 = (int)(((Matcher)object7).matches() ? 1 : 0);
                                        string2 = "Ignoring region with malformed extent: ";
                                        if (n18 != 0) {
                                            try {
                                                object3 = ((Matcher)object7).group(n14);
                                                object3 = Assertions.checkNotNull(object3);
                                                object3 = (String)object3;
                                                f13 = Float.parseFloat((String)object3) / f17;
                                                object7 = ((Matcher)object7).group(n15);
                                                object7 = Assertions.checkNotNull(object7);
                                                object7 = (String)object7;
                                                f14 = f18 = Float.parseFloat((String)object7) / f17;
                                            }
                                            catch (NumberFormatException numberFormatException) {
                                                object4 = String.valueOf(object2);
                                                int n22 = ((String)object4).length();
                                                object4 = n22 != 0 ? string2.concat((String)object4) : new String(string2);
                                                Log.w((String)object, (String)object4);
                                                return null;
                                            }
                                        }
                                        int n23 = ((Matcher)object6).matches();
                                        if (n23 == 0) break block31;
                                        if (object3 == null) {
                                            object4 = String.valueOf(object2);
                                            int n24 = ((String)object4).length();
                                            object4 = n24 != 0 ? string5.concat((String)object4) : new String(string5);
                                            Log.w((String)object, (String)object4);
                                            return null;
                                        }
                                        try {
                                            object7 = ((Matcher)object6).group(n14);
                                            object7 = Assertions.checkNotNull(object7);
                                            object7 = (String)object7;
                                            n23 = Integer.parseInt((String)object7);
                                            object6 = ((Matcher)object6).group(n15);
                                            object6 = Assertions.checkNotNull(object6);
                                            object6 = (String)object6;
                                            n10 = Integer.parseInt((String)object6);
                                        }
                                        catch (NumberFormatException numberFormatException) {
                                            object4 = String.valueOf(object2);
                                            int n25 = ((String)object4).length();
                                            object4 = n25 != 0 ? string2.concat((String)object4) : new String(string2);
                                            Log.w((String)object, (String)object4);
                                            return null;
                                        }
                                        f12 = n23;
                                        n18 = ((TtmlDecoder$TtsExtent)object3).width;
                                        f14 = n18;
                                        f12 /= f14;
                                        f21 = n10;
                                        int n26 = ((TtmlDecoder$TtsExtent)object3).height;
                                        f13 = n26;
                                        f21 /= f13;
                                        f13 = f12;
                                        f14 = f21;
                                        string4 = XmlPullParserUtil.getAttributeValue((XmlPullParser)object4, "displayAlign");
                                        n13 = 0;
                                        object2 = null;
                                        if (string4 == null) break block32;
                                        string4 = Util.toLowerInvariant(string4);
                                        string4.hashCode();
                                        object = "center";
                                        n16 = string4.equals(object);
                                        if (n16 != 0) break block33;
                                        object = "after";
                                        n12 = (int)(string4.equals(object) ? 1 : 0);
                                        if (n12 == 0) break block32;
                                        f12 = f16 += f14;
                                        n10 = n15;
                                        f21 = f20;
                                        break block34;
                                    }
                                    n12 = 0x40000000;
                                    f18 = f14 / 2.0f;
                                    f12 = f16 += f18;
                                    n10 = n14;
                                    f21 = f19;
                                    break block34;
                                }
                                n10 = 0;
                                object6 = null;
                                f21 = 0.0f;
                                f12 = f16;
                            }
                            object = ttmlDecoder$CellResolution;
                            n16 = ttmlDecoder$CellResolution.rows;
                            f11 = n16;
                            f10 = 1.0f / f11;
                            n12 = -1 << -1;
                            f18 = -0.0f;
                            object = "writingMode";
                            object4 = XmlPullParserUtil.getAttributeValue((XmlPullParser)object4, (String)object);
                            if (object4 == null) break block35;
                            object4 = Util.toLowerInvariant((String)object4);
                            ((String)object4).hashCode();
                            n16 = -1;
                            f11 = 0.0f / 0.0f;
                            n17 = ((String)object4).hashCode();
                            switch (n17) {
                                case 3553576: {
                                    object2 = "tbrl";
                                    boolean bl2 = ((String)object4).equals(object2);
                                    if (!bl2) break;
                                    n13 = n15;
                                    break block36;
                                }
                                case 3553396: {
                                    object2 = "tblr";
                                    boolean bl3 = ((String)object4).equals(object2);
                                    if (!bl3) break;
                                    n13 = n14;
                                    break block36;
                                }
                                case 3694: {
                                    object5 = "tb";
                                    boolean bl4 = ((String)object4).equals(object5);
                                    if (bl4) break block36;
                                }
                            }
                            n13 = n16;
                        }
                        switch (n13) {
                            default: {
                                break;
                            }
                            case 2: {
                                n11 = n14;
                                f17 = f19;
                                break block37;
                            }
                            case 0: 
                            case 1: {
                                n11 = n15;
                                f17 = f20;
                                break block37;
                            }
                        }
                    }
                    n11 = n12;
                    f17 = f18;
                }
                object2 = object4;
                f11 = f15;
                f16 = f13;
                return new TtmlRegion(string3, f15, f12, 0, n10, f13, f14, 1, f10, n11);
            }
            object4 = "Ignoring region with unsupported extent: ";
            object3 = String.valueOf(object2);
            int n27 = ((String)object3).length();
            object4 = n27 != 0 ? ((String)object4).concat((String)object3) : (object3 = new String((String)object4));
            Log.w((String)object, (String)object4);
            return null;
            catch (NumberFormatException numberFormatException) {
                object4 = String.valueOf(object2);
                int n28 = ((String)object4).length();
                object4 = n28 != 0 ? string2.concat((String)object4) : new String(string2);
                Log.w((String)object, (String)object4);
                return null;
            }
        }
        object4 = "Ignoring region with unsupported origin: ";
        object3 = String.valueOf(object2);
        int n29 = ((String)object3).length();
        object4 = n29 != 0 ? ((String)object4).concat((String)object3) : (object3 = new String((String)object4));
        Log.w((String)object, (String)object4);
        return null;
    }

    /*
     * Unable to fully structure code
     */
    private static TtmlStyle parseStyleAttributes(XmlPullParser var0, TtmlStyle var1_1) {
        var2_2 = var0.getAttributeCount();
        block75: for (var3_3 = 0; var3_3 < var2_2; ++var3_3) {
            var4_4 = var0.getAttributeValue(var3_3);
            var5_5 = var0.getAttributeName(var3_3);
            var5_5.hashCode();
            var6_6 = var5_5.hashCode();
            var7_7 = 5;
            var8_8 = 4;
            var9_9 = 5.6E-45f;
            var10_10 = -1;
            var11_11 = 0.0f / 0.0f;
            var12_12 = 3;
            var13_13 = 4.2E-45f;
            var14_14 = 2;
            var15_15 = 2.8E-45f;
            var16_16 = 1;
            var17_17 = 1.4E-45f;
            switch (var6_6) lbl-1000:
            // 13 sources

            {
                default: {
                    var18_18 = var10_10;
                    break;
                }
                case 1287124693: {
                    var19_19 = "backgroundColor";
                    var18_18 = (int)var5_5.equals(var19_19);
                    if (var18_18 == 0) ** GOTO lbl-1000
                    var18_18 = 11;
                    break;
                }
                case 1115953443: {
                    var19_19 = "rubyPosition";
                    var18_18 = (int)var5_5.equals(var19_19);
                    if (var18_18 == 0) ** GOTO lbl-1000
                    var18_18 = 10;
                    break;
                }
                case 365601008: {
                    var19_19 = "fontSize";
                    var18_18 = (int)var5_5.equals(var19_19);
                    if (var18_18 == 0) ** GOTO lbl-1000
                    var18_18 = 9;
                    break;
                }
                case 110138194: {
                    var19_19 = "textCombine";
                    var18_18 = (int)var5_5.equals(var19_19);
                    if (var18_18 == 0) ** GOTO lbl-1000
                    var18_18 = 8;
                    break;
                }
                case 94842723: {
                    var19_19 = "color";
                    var18_18 = (int)var5_5.equals(var19_19);
                    if (var18_18 == 0) ** GOTO lbl-1000
                    var18_18 = 7;
                    break;
                }
                case 3511770: {
                    var19_19 = "ruby";
                    var18_18 = (int)var5_5.equals(var19_19);
                    if (var18_18 == 0) ** GOTO lbl-1000
                    var18_18 = 6;
                    break;
                }
                case 3355: {
                    var19_19 = "id";
                    var18_18 = (int)var5_5.equals(var19_19);
                    if (var18_18 == 0) ** GOTO lbl-1000
                    var18_18 = var7_7;
                    break;
                }
                case -734428249: {
                    var19_19 = "fontWeight";
                    var18_18 = (int)var5_5.equals(var19_19);
                    if (var18_18 == 0) ** GOTO lbl-1000
                    var18_18 = var8_8;
                    break;
                }
                case -879295043: {
                    var19_19 = "textDecoration";
                    var18_18 = (int)var5_5.equals(var19_19);
                    if (var18_18 == 0) ** GOTO lbl-1000
                    var18_18 = var12_12;
                    break;
                }
                case -1065511464: {
                    var19_19 = "textAlign";
                    var18_18 = (int)var5_5.equals(var19_19);
                    if (var18_18 == 0) ** GOTO lbl-1000
                    var18_18 = var14_14;
                    break;
                }
                case -1224696685: {
                    var19_19 = "fontFamily";
                    var18_18 = (int)var5_5.equals(var19_19);
                    if (var18_18 == 0) ** GOTO lbl-1000
                    var18_18 = var16_16;
                    break;
                }
                case -1550943582: {
                    var19_19 = "fontStyle";
                    var18_18 = (int)var5_5.equals(var19_19);
                    if (var18_18 == 0) ** GOTO lbl-1000
                    var18_18 = 0;
                    var5_5 = null;
                }
            }
            var19_19 = "TtmlDecoder";
            switch (var18_18) {
                default: {
                    continue block75;
                }
                case 11: {
                    var1_1 = TtmlDecoder.createIfNull(var1_1);
                    var18_18 = ColorParser.parseTtmlColor(var4_4);
                    try {
                        var1_1.setBackgroundColor(var18_18);
                    }
                    catch (IllegalArgumentException v0) {
                        var5_5 = "Failed parsing background value: ";
                        var4_4 = String.valueOf(var4_4);
                        var7_7 = var4_4.length();
                        var4_4 = var7_7 != 0 ? var5_5.concat(var4_4) : new String(var5_5);
                        Log.w(var19_19, var4_4);
                    }
                    continue block75;
                }
                case 10: {
                    var4_4 = Util.toLowerInvariant(var4_4);
                    var4_4.hashCode();
                    var5_5 = "before";
                    var18_18 = (int)var4_4.equals(var5_5);
                    if (var18_18 == 0) {
                        var5_5 = "after";
                        var20_20 = var4_4.equals(var5_5);
                        if (!var20_20) continue block75;
                        var1_1 = TtmlDecoder.createIfNull(var1_1).setRubyPosition(var14_14);
                        continue block75;
                    }
                    var1_1 = TtmlDecoder.createIfNull(var1_1).setRubyPosition(var16_16);
                    continue block75;
                }
                case 9: {
                    var1_1 = TtmlDecoder.createIfNull(var1_1);
                    try {
                        TtmlDecoder.parseFontSize(var4_4, var1_1);
                    }
                    catch (SubtitleDecoderException v1) {
                        var5_5 = "Failed parsing fontSize value: ";
                        var4_4 = String.valueOf(var4_4);
                        var7_7 = var4_4.length();
                        var4_4 = var7_7 != 0 ? var5_5.concat(var4_4) : new String(var5_5);
                        Log.w(var19_19, var4_4);
                    }
                    continue block75;
                }
                case 8: {
                    var4_4 = Util.toLowerInvariant(var4_4);
                    var4_4.hashCode();
                    var5_5 = "all";
                    var18_18 = (int)var4_4.equals(var5_5);
                    if (var18_18 == 0) {
                        var5_5 = "none";
                        var20_20 = var4_4.equals(var5_5);
                        if (!var20_20) continue block75;
                        var1_1 = TtmlDecoder.createIfNull(var1_1).setTextCombine(false);
                        continue block75;
                    }
                    var1_1 = TtmlDecoder.createIfNull(var1_1).setTextCombine((boolean)var16_16);
                    continue block75;
                }
                case 7: {
                    var1_1 = TtmlDecoder.createIfNull(var1_1);
                    var18_18 = ColorParser.parseTtmlColor(var4_4);
                    try {
                        var1_1.setFontColor(var18_18);
                    }
                    catch (IllegalArgumentException v2) {
                        var5_5 = "Failed parsing color value: ";
                        var4_4 = String.valueOf(var4_4);
                        var7_7 = var4_4.length();
                        var4_4 = var7_7 != 0 ? var5_5.concat(var4_4) : new String(var5_5);
                        Log.w(var19_19, var4_4);
                    }
                    continue block75;
                }
                case 6: {
                    var4_4 = Util.toLowerInvariant(var4_4);
                    var4_4.hashCode();
                    var18_18 = var4_4.hashCode();
                    switch (var18_18) lbl-1000:
                    // 7 sources

                    {
                        default: {
                            var7_7 = var10_10;
                            break;
                        }
                        case 3556653: {
                            var5_5 = "text";
                            var20_20 = var4_4.equals(var5_5);
                            if (var20_20) break;
                            ** GOTO lbl-1000
                        }
                        case 3016401: {
                            var5_5 = "base";
                            var20_20 = var4_4.equals(var5_5);
                            if (!var20_20) ** GOTO lbl-1000
                            var7_7 = var8_8;
                            break;
                        }
                        case -136074796: {
                            var5_5 = "textContainer";
                            var20_20 = var4_4.equals(var5_5);
                            if (!var20_20) ** GOTO lbl-1000
                            var7_7 = var12_12;
                            break;
                        }
                        case -250518009: {
                            var5_5 = "delimiter";
                            var20_20 = var4_4.equals(var5_5);
                            if (!var20_20) ** GOTO lbl-1000
                            var7_7 = var14_14;
                            break;
                        }
                        case -410956671: {
                            var5_5 = "container";
                            var20_20 = var4_4.equals(var5_5);
                            if (!var20_20) ** GOTO lbl-1000
                            var7_7 = var16_16;
                            break;
                        }
                        case -618561360: {
                            var5_5 = "baseContainer";
                            var20_20 = var4_4.equals(var5_5);
                            if (!var20_20) ** GOTO lbl-1000
                            var7_7 = 0;
                        }
                    }
                    switch (var7_7) {
                        default: {
                            continue block75;
                        }
                        case 3: 
                        case 5: {
                            var1_1 = TtmlDecoder.createIfNull(var1_1).setRubyType(var12_12);
                            continue block75;
                        }
                        case 2: {
                            var1_1 = TtmlDecoder.createIfNull(var1_1).setRubyType(var8_8);
                            continue block75;
                        }
                        case 1: {
                            var1_1 = TtmlDecoder.createIfNull(var1_1).setRubyType(var16_16);
                            continue block75;
                        }
                        case 0: 
                        case 4: 
                    }
                    var1_1 = TtmlDecoder.createIfNull(var1_1).setRubyType(var14_14);
                    continue block75;
                }
                case 5: {
                    var5_5 = var0.getName();
                    var19_19 = "style";
                    var18_18 = (int)var19_19.equals(var5_5);
                    if (var18_18 == 0) continue block75;
                    var1_1 = TtmlDecoder.createIfNull(var1_1).setId(var4_4);
                    continue block75;
                }
                case 4: {
                    var1_1 = TtmlDecoder.createIfNull(var1_1);
                    var5_5 = "bold";
                    var20_20 = var5_5.equalsIgnoreCase(var4_4);
                    var1_1 = var1_1.setBold(var20_20);
                    continue block75;
                }
                case 3: {
                    var4_4 = Util.toLowerInvariant(var4_4);
                    var4_4.hashCode();
                    var18_18 = var4_4.hashCode();
                    switch (var18_18) {
                        default: {
                            break;
                        }
                        case 1679736913: {
                            var5_5 = "linethrough";
                            var20_20 = var4_4.equals(var5_5);
                            if (!var20_20) break;
                            var10_10 = var12_12;
                            var11_11 = var13_13;
                            break;
                        }
                        case 913457136: {
                            var5_5 = "nolinethrough";
                            var20_20 = var4_4.equals(var5_5);
                            if (!var20_20) break;
                            var10_10 = var14_14;
                            var11_11 = var15_15;
                            break;
                        }
                        case -1026963764: {
                            var5_5 = "underline";
                            var20_20 = var4_4.equals(var5_5);
                            if (!var20_20) break;
                            var10_10 = var16_16;
                            var11_11 = var17_17;
                            break;
                        }
                        case -1461280213: {
                            var5_5 = "nounderline";
                            var20_20 = var4_4.equals(var5_5);
                            if (!var20_20) break;
                            var10_10 = 0;
                            var11_11 = 0.0f;
                        }
                    }
                    switch (var10_10) {
                        default: {
                            continue block75;
                        }
                        case 3: {
                            var1_1 = TtmlDecoder.createIfNull(var1_1).setLinethrough((boolean)var16_16);
                            continue block75;
                        }
                        case 2: {
                            var1_1 = TtmlDecoder.createIfNull(var1_1).setLinethrough(false);
                            continue block75;
                        }
                        case 1: {
                            var1_1 = TtmlDecoder.createIfNull(var1_1).setUnderline((boolean)var16_16);
                            continue block75;
                        }
                        case 0: 
                    }
                    var1_1 = TtmlDecoder.createIfNull(var1_1).setUnderline(false);
                    continue block75;
                }
                case 2: {
                    var4_4 = Util.toLowerInvariant(var4_4);
                    var4_4.hashCode();
                    var18_18 = var4_4.hashCode();
                    switch (var18_18) lbl-1000:
                    // 6 sources

                    {
                        default: {
                            var8_8 = var10_10;
                            var9_9 = var11_11;
                            break;
                        }
                        case 109757538: {
                            var5_5 = "start";
                            var20_20 = var4_4.equals(var5_5);
                            if (var20_20) break;
                            ** GOTO lbl-1000
                        }
                        case 108511772: {
                            var5_5 = "right";
                            var20_20 = var4_4.equals(var5_5);
                            if (!var20_20) ** GOTO lbl-1000
                            var8_8 = var12_12;
                            var9_9 = var13_13;
                            break;
                        }
                        case 3317767: {
                            var5_5 = "left";
                            var20_20 = var4_4.equals(var5_5);
                            if (!var20_20) ** GOTO lbl-1000
                            var8_8 = var14_14;
                            var9_9 = var15_15;
                            break;
                        }
                        case 100571: {
                            var5_5 = "end";
                            var20_20 = var4_4.equals(var5_5);
                            if (!var20_20) ** GOTO lbl-1000
                            var8_8 = var16_16;
                            var9_9 = var17_17;
                            break;
                        }
                        case -1364013995: {
                            var5_5 = "center";
                            var20_20 = var4_4.equals(var5_5);
                            if (!var20_20) ** GOTO lbl-1000
                            var8_8 = 0;
                            var9_9 = 0.0f;
                        }
                    }
                    switch (var8_8) {
                        default: {
                            continue block75;
                        }
                        case 2: 
                        case 4: {
                            var1_1 = TtmlDecoder.createIfNull(var1_1);
                            var4_4 = Layout.Alignment.ALIGN_NORMAL;
                            var1_1 = var1_1.setTextAlign((Layout.Alignment)var4_4);
                            continue block75;
                        }
                        case 1: 
                        case 3: {
                            var1_1 = TtmlDecoder.createIfNull(var1_1);
                            var4_4 = Layout.Alignment.ALIGN_OPPOSITE;
                            var1_1 = var1_1.setTextAlign((Layout.Alignment)var4_4);
                            continue block75;
                        }
                        case 0: 
                    }
                    var1_1 = TtmlDecoder.createIfNull(var1_1);
                    var4_4 = Layout.Alignment.ALIGN_CENTER;
                    var1_1 = var1_1.setTextAlign((Layout.Alignment)var4_4);
                    continue block75;
                }
                case 1: {
                    var1_1 = TtmlDecoder.createIfNull(var1_1).setFontFamily(var4_4);
                    continue block75;
                }
                case 0: {
                    var1_1 = TtmlDecoder.createIfNull(var1_1);
                    var5_5 = "italic";
                    var20_20 = var5_5.equalsIgnoreCase(var4_4);
                    var1_1 = var1_1.setItalic(var20_20);
                }
            }
        }
        return var1_1;
    }

    private static String[] parseStyleIds(String stringArray) {
        boolean bl2 = (stringArray = stringArray.trim()).isEmpty();
        if (bl2) {
            stringArray = new String[]{};
        } else {
            String string2 = "\\s+";
            stringArray = Util.split((String)stringArray, string2);
        }
        return stringArray;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static long parseTimeExpression(String string2, TtmlDecoder$FrameAndTickRate object) {
        int n10;
        Object object2;
        block20: {
            double d10;
            int n11;
            double d11;
            int n12;
            double d12;
            block21: {
                block22: {
                    object2 = CLOCK_TIME.matcher(string2);
                    n10 = ((Matcher)object2).matches();
                    d12 = 1000000.0;
                    n12 = 4;
                    int n13 = 3;
                    int n14 = 2;
                    int n15 = 1;
                    if (n10 != 0) {
                        long l10 = Long.parseLong((String)Assertions.checkNotNull(((Matcher)object2).group(n15))) * 3600L;
                        double d13 = l10;
                        long l11 = Long.parseLong((String)Assertions.checkNotNull(((Matcher)object2).group(n14)));
                        long l12 = 60;
                        double d14 = l11 *= l12;
                        d13 += d14;
                        long l13 = Long.parseLong((String)Assertions.checkNotNull(((Matcher)object2).group(n13)));
                        double d15 = l13;
                        d13 += d15;
                        string2 = ((Matcher)object2).group(n12);
                        long l14 = 0L;
                        double d16 = 0.0;
                        if (string2 != null) {
                            d14 = Double.parseDouble(string2);
                        } else {
                            l11 = l14;
                            d14 = d16;
                        }
                        d13 += d14;
                        int n16 = 5;
                        float f10 = 7.0E-45f;
                        string2 = ((Matcher)object2).group(n16);
                        if (string2 != null) {
                            l11 = Long.parseLong(string2);
                            f10 = l11;
                            float f11 = ((TtmlDecoder$FrameAndTickRate)object).effectiveFrameRate;
                            d14 = f10 /= f11;
                        } else {
                            l11 = l14;
                            d14 = d16;
                        }
                        n16 = 6;
                        f10 = 8.4E-45f;
                        string2 = ((Matcher)object2).group(n16);
                        if (string2 == null) return (long)(((d13 += d14) + d16) * d12);
                        long l15 = Long.parseLong(string2);
                        double d17 = l15;
                        n16 = ((TtmlDecoder$FrameAndTickRate)object).subFrameRate;
                        d16 = n16;
                        d17 /= d16;
                        f10 = ((TtmlDecoder$FrameAndTickRate)object).effectiveFrameRate;
                        double d18 = f10;
                        d16 = d17 / d18;
                        return (long)(((d13 += d14) + d16) * d12);
                    }
                    object2 = OFFSET_TIME.matcher(string2);
                    n10 = ((Matcher)object2).matches();
                    if (n10 == 0) break block20;
                    d11 = Double.parseDouble((String)Assertions.checkNotNull(((Matcher)object2).group(n15)));
                    string2 = (String)Assertions.checkNotNull(((Matcher)object2).group(n14));
                    string2.hashCode();
                    int n17 = -1;
                    n10 = string2.hashCode();
                    switch (n10) {
                        case 3494: {
                            String string3 = "ms";
                            n11 = string2.equals(string3);
                            if (n11 == 0) {
                                break;
                            }
                            break block21;
                        }
                        case 116: {
                            String string4 = "t";
                            n11 = string2.equals(string4);
                            if (n11 == 0) break;
                            n12 = n13;
                            break block21;
                        }
                        case 109: {
                            String string5 = "m";
                            n11 = string2.equals(string5);
                            if (n11 == 0) break;
                            n12 = n14;
                            break block21;
                        }
                        case 104: {
                            String string6 = "h";
                            n11 = string2.equals(string6);
                            if (n11 == 0) break;
                            n12 = n15;
                            break block21;
                        }
                        case 102: {
                            String string7 = "f";
                            n11 = string2.equals(string7);
                            if (n11 != 0) break block22;
                        }
                    }
                    n12 = n17;
                    break block21;
                }
                n12 = 0;
            }
            switch (n12) {
                default: {
                    return (long)(d11 * d12);
                }
                case 4: {
                    d10 = 1000.0;
                    return (long)((d11 /= d10) * d12);
                }
                case 3: {
                    n11 = ((TtmlDecoder$FrameAndTickRate)object).tickRate;
                    d10 = n11;
                    return (long)((d11 /= d10) * d12);
                }
                case 2: {
                    double d19 = 60.0;
                    return (long)((d11 *= d19) * d12);
                }
                case 1: {
                    double d19 = 3600.0;
                    return (long)((d11 *= d19) * d12);
                }
                case 0: 
            }
            float f12 = ((TtmlDecoder$FrameAndTickRate)object).effectiveFrameRate;
            d10 = f12;
            return (long)((d11 /= d10) * d12);
        }
        object2 = "Malformed time expression: ";
        n10 = (string2 = String.valueOf(string2)).length();
        string2 = n10 != 0 ? ((String)object2).concat(string2) : new String((String)object2);
        object = new SubtitleDecoderException(string2);
        throw object;
    }

    private static TtmlDecoder$TtsExtent parseTtsExtent(XmlPullParser object) {
        Object object2;
        if ((object = XmlPullParserUtil.getAttributeValue((XmlPullParser)object, "extent")) == null) {
            return null;
        }
        Object object3 = PIXEL_COORDINATES.matcher((CharSequence)object);
        boolean n10 = ((Matcher)object3).matches();
        String string2 = TAG;
        if (!n10) {
            object3 = "Ignoring non-pixel tts extent: ";
            int n11 = ((String)(object = String.valueOf(object))).length();
            object = n11 != 0 ? ((String)object3).concat((String)object) : new String((String)object3);
            Log.w(string2, (String)object);
            return null;
        }
        int n12 = 1;
        try {
            object2 = ((Matcher)object3).group(n12);
        }
        catch (NumberFormatException numberFormatException) {
            object3 = "Ignoring malformed tts extent: ";
            object = String.valueOf(object);
            int n13 = ((String)object).length();
            object = n13 != 0 ? ((String)object3).concat((String)object) : new String((String)object3);
            Log.w(string2, (String)object);
            return null;
        }
        object2 = Assertions.checkNotNull(object2);
        object2 = (String)object2;
        int n14 = Integer.parseInt((String)object2);
        int n15 = 2;
        object3 = ((Matcher)object3).group(n15);
        object3 = Assertions.checkNotNull(object3);
        object3 = (String)object3;
        int n16 = Integer.parseInt((String)object3);
        TtmlDecoder$TtsExtent ttmlDecoder$TtsExtent = new TtmlDecoder$TtsExtent(n14, n16);
        return ttmlDecoder$TtsExtent;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Subtitle decode(byte[] byArray, int n10, boolean bl2) {
        Object object = "";
        try {
            XmlPullParserFactory xmlPullParserFactory = this.xmlParserFactory;
            XmlPullParser xmlPullParser = xmlPullParserFactory.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap<String, TtmlRegion> hashMap2 = new HashMap<String, TtmlRegion>();
            HashMap hashMap3 = new HashMap();
            Object object2 = new TtmlRegion((String)object);
            hashMap2.put((String)object, (TtmlRegion)object2);
            int n11 = 0;
            object2 = null;
            byte[] byArray2 = byArray;
            int n12 = n10;
            object = new ByteArrayInputStream(byArray, 0, n10);
            Object var11_19 = null;
            xmlPullParser.setInput((InputStream)object, null);
            ArrayDeque<Object> arrayDeque = new ArrayDeque<Object>();
            int n13 = xmlPullParser.getEventType();
            Object object3 = DEFAULT_FRAME_AND_TICK_RATE;
            TtmlDecoder$CellResolution ttmlDecoder$CellResolution = DEFAULT_CELL_RESOLUTION;
            int n14 = 0;
            TtmlSubtitle ttmlSubtitle = null;
            while (n13 != (n11 = 1)) {
                block22: {
                    int n15;
                    block20: {
                        Object object4;
                        block21: {
                            void var11_22;
                            object2 = arrayDeque.peek();
                            object2 = (TtmlNode)object2;
                            n15 = 2;
                            if (n14 != 0) break block20;
                            Object object5 = xmlPullParser.getName();
                            object4 = "tt";
                            if (n13 != n15) break block21;
                            n13 = (int)(((String)object4).equals(object5) ? 1 : 0);
                            if (n13 != 0) {
                                object3 = TtmlDecoder.parseFrameAndTickRates(xmlPullParser);
                                object = DEFAULT_CELL_RESOLUTION;
                                ttmlDecoder$CellResolution = TtmlDecoder.parseCellResolution(xmlPullParser, (TtmlDecoder$CellResolution)object);
                                TtmlDecoder$TtsExtent ttmlDecoder$TtsExtent = TtmlDecoder.parseTtsExtent(xmlPullParser);
                            }
                            void var22_37 = var11_22;
                            Object object6 = object3;
                            TtmlDecoder$CellResolution ttmlDecoder$CellResolution2 = ttmlDecoder$CellResolution;
                            n13 = (int)(TtmlDecoder.isSupportedTag((String)object5) ? 1 : 0);
                            String string2 = TAG;
                            if (n13 == 0) {
                                object = "Ignoring unsupported tag: ";
                                object2 = xmlPullParser.getName();
                                n12 = ((String)(object2 = String.valueOf(object2))).length();
                                object = n12 != 0 ? ((String)object).concat((String)object2) : (object2 = new String((String)object));
                                Log.i(string2, (String)object);
                                ++n14;
                                object3 = object6;
                            } else {
                                object = "head";
                                n13 = (int)(((String)object).equals(object5) ? 1 : 0);
                                if (n13 != 0) {
                                    object2 = xmlPullParser;
                                    HashMap hashMap4 = hashMap;
                                    object3 = ttmlDecoder$CellResolution;
                                    ttmlDecoder$CellResolution = var22_37;
                                    object4 = hashMap2;
                                    object5 = object6;
                                    object6 = hashMap3;
                                    TtmlDecoder.parseHeader(xmlPullParser, hashMap, ttmlDecoder$CellResolution2, (TtmlDecoder$TtsExtent)var22_37, hashMap2, hashMap3);
                                } else {
                                    object5 = object3;
                                    try {
                                        object = TtmlDecoder.parseNode(xmlPullParser, (TtmlNode)object2, hashMap2, (TtmlDecoder$FrameAndTickRate)object3);
                                        arrayDeque.push(object);
                                        if (object2 != null) {
                                            ((TtmlNode)object2).addChild((TtmlNode)object);
                                        }
                                    }
                                    catch (SubtitleDecoderException subtitleDecoderException) {
                                        object2 = "Suppressing parser error";
                                        Log.w(string2, (String)object2, subtitleDecoderException);
                                        ++n14;
                                    }
                                }
                                object3 = object5;
                            }
                            void var11_26 = var22_37;
                            ttmlDecoder$CellResolution = ttmlDecoder$CellResolution2;
                            break block22;
                        }
                        n15 = 4;
                        if (n13 == n15) {
                            object = Assertions.checkNotNull(object2);
                            object = (TtmlNode)object;
                            object2 = xmlPullParser.getText();
                            object2 = TtmlNode.buildTextNode((String)object2);
                            ((TtmlNode)object).addChild((TtmlNode)object2);
                            break block22;
                        } else {
                            n11 = 3;
                            if (n13 == n11) {
                                object = xmlPullParser.getName();
                                n13 = (int)(((String)object).equals(object4) ? 1 : 0);
                                if (n13 != 0) {
                                    object = arrayDeque.peek();
                                    object = (TtmlNode)object;
                                    object = Assertions.checkNotNull(object);
                                    object = (TtmlNode)object;
                                    ttmlSubtitle = new TtmlSubtitle((TtmlNode)object, hashMap, hashMap2, hashMap3);
                                }
                                arrayDeque.pop();
                            }
                        }
                        break block22;
                    }
                    if (n13 == n15) {
                        ++n14;
                    } else {
                        n11 = 3;
                        if (n13 == n11) {
                            n14 += -1;
                        }
                    }
                }
                xmlPullParser.next();
                n13 = xmlPullParser.getEventType();
            }
            if (ttmlSubtitle != null) {
                return ttmlSubtitle;
            }
            String string3 = "No TTML subtitles found";
            object = new SubtitleDecoderException(string3);
            throw object;
        }
        catch (IOException iOException) {
            IllegalStateException illegalStateException = new IllegalStateException("Unexpected error when reading input.", iOException);
            throw illegalStateException;
        }
        catch (XmlPullParserException xmlPullParserException) {
            SubtitleDecoderException subtitleDecoderException = new SubtitleDecoderException("Unable to decode source", xmlPullParserException);
            throw subtitleDecoderException;
        }
    }
}

