/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 *  android.text.TextUtils
 */
package com.google.android.exoplayer2.util;

import android.graphics.Color;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ColorParser {
    private static final Map COLOR_MAP;
    private static final String RGB = "rgb";
    private static final String RGBA = "rgba";
    private static final Pattern RGBA_PATTERN_FLOAT_ALPHA;
    private static final Pattern RGBA_PATTERN_INT_ALPHA;
    private static final Pattern RGB_PATTERN;

    static {
        HashMap<String, Integer> hashMap;
        RGB_PATTERN = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        RGBA_PATTERN_INT_ALPHA = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        RGBA_PATTERN_FLOAT_ALPHA = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
        COLOR_MAP = hashMap = new HashMap<String, Integer>();
        Integer n10 = -984833;
        hashMap.put("aliceblue", n10);
        n10 = -332841;
        hashMap.put("antiquewhite", n10);
        n10 = -16711681;
        hashMap.put("aqua", n10);
        Integer n11 = -8388652;
        hashMap.put("aquamarine", n11);
        n11 = -983041;
        hashMap.put("azure", n11);
        n11 = -657956;
        hashMap.put("beige", n11);
        n11 = -6972;
        hashMap.put("bisque", n11);
        n11 = -16777216;
        hashMap.put("black", n11);
        n11 = -5171;
        hashMap.put("blanchedalmond", n11);
        n11 = -16776961;
        hashMap.put("blue", n11);
        n11 = -7722014;
        hashMap.put("blueviolet", n11);
        n11 = -5952982;
        hashMap.put("brown", n11);
        n11 = -2180985;
        hashMap.put("burlywood", n11);
        n11 = -10510688;
        hashMap.put("cadetblue", n11);
        n11 = -8388864;
        hashMap.put("chartreuse", n11);
        n11 = -2987746;
        hashMap.put("chocolate", n11);
        n11 = -32944;
        hashMap.put("coral", n11);
        n11 = -10185235;
        hashMap.put("cornflowerblue", n11);
        n11 = -1828;
        hashMap.put("cornsilk", n11);
        n11 = -2354116;
        hashMap.put("crimson", n11);
        hashMap.put("cyan", n10);
        n10 = -16777077;
        hashMap.put("darkblue", n10);
        n10 = -16741493;
        hashMap.put("darkcyan", n10);
        n10 = -4684277;
        hashMap.put("darkgoldenrod", n10);
        n10 = -5658199;
        hashMap.put("darkgray", n10);
        n11 = -16751616;
        hashMap.put("darkgreen", n11);
        hashMap.put("darkgrey", n10);
        n10 = -4343957;
        hashMap.put("darkkhaki", n10);
        n10 = -7667573;
        hashMap.put("darkmagenta", n10);
        n10 = -11179217;
        hashMap.put("darkolivegreen", n10);
        n10 = -29696;
        hashMap.put("darkorange", n10);
        n10 = -6737204;
        hashMap.put("darkorchid", n10);
        n10 = -7667712;
        hashMap.put("darkred", n10);
        n10 = -1468806;
        hashMap.put("darksalmon", n10);
        n10 = -7357297;
        hashMap.put("darkseagreen", n10);
        n10 = -12042869;
        hashMap.put("darkslateblue", n10);
        n10 = -13676721;
        hashMap.put("darkslategray", n10);
        hashMap.put("darkslategrey", n10);
        n10 = -16724271;
        hashMap.put("darkturquoise", n10);
        n10 = -7077677;
        hashMap.put("darkviolet", n10);
        n10 = -60269;
        hashMap.put("deeppink", n10);
        n10 = -16728065;
        hashMap.put("deepskyblue", n10);
        n10 = -9868951;
        hashMap.put("dimgray", n10);
        hashMap.put("dimgrey", n10);
        n10 = -14774017;
        hashMap.put("dodgerblue", n10);
        n10 = -5103070;
        hashMap.put("firebrick", n10);
        n10 = -1296;
        hashMap.put("floralwhite", n10);
        n10 = -14513374;
        hashMap.put("forestgreen", n10);
        n10 = -65281;
        hashMap.put("fuchsia", n10);
        n11 = -2302756;
        hashMap.put("gainsboro", n11);
        n11 = -460545;
        hashMap.put("ghostwhite", n11);
        n11 = -10496;
        hashMap.put("gold", n11);
        n11 = -2448096;
        hashMap.put("goldenrod", n11);
        n11 = -8355712;
        hashMap.put("gray", n11);
        Integer n12 = -16744448;
        hashMap.put("green", n12);
        n12 = -5374161;
        hashMap.put("greenyellow", n12);
        hashMap.put("grey", n11);
        n11 = -983056;
        hashMap.put("honeydew", n11);
        n11 = -38476;
        hashMap.put("hotpink", n11);
        n11 = -3318692;
        hashMap.put("indianred", n11);
        n11 = -11861886;
        hashMap.put("indigo", n11);
        n11 = -16;
        hashMap.put("ivory", n11);
        n11 = -989556;
        hashMap.put("khaki", n11);
        n11 = -1644806;
        hashMap.put("lavender", n11);
        n11 = -3851;
        hashMap.put("lavenderblush", n11);
        n11 = -8586240;
        hashMap.put("lawngreen", n11);
        n11 = -1331;
        hashMap.put("lemonchiffon", n11);
        n11 = -5383962;
        hashMap.put("lightblue", n11);
        n11 = -1015680;
        hashMap.put("lightcoral", n11);
        n11 = -2031617;
        hashMap.put("lightcyan", n11);
        n11 = -329006;
        hashMap.put("lightgoldenrodyellow", n11);
        n11 = -2894893;
        hashMap.put("lightgray", n11);
        n12 = -7278960;
        hashMap.put("lightgreen", n12);
        hashMap.put("lightgrey", n11);
        n11 = -18751;
        hashMap.put("lightpink", n11);
        n11 = -24454;
        hashMap.put("lightsalmon", n11);
        n11 = -14634326;
        hashMap.put("lightseagreen", n11);
        n11 = -7876870;
        hashMap.put("lightskyblue", n11);
        n11 = -8943463;
        hashMap.put("lightslategray", n11);
        hashMap.put("lightslategrey", n11);
        n11 = -5192482;
        hashMap.put("lightsteelblue", n11);
        n11 = -32;
        hashMap.put("lightyellow", n11);
        n11 = -16711936;
        hashMap.put("lime", n11);
        n11 = -13447886;
        hashMap.put("limegreen", n11);
        n11 = -331546;
        hashMap.put("linen", n11);
        hashMap.put("magenta", n10);
        n10 = -8388608;
        hashMap.put("maroon", n10);
        n10 = -10039894;
        hashMap.put("mediumaquamarine", n10);
        n10 = -16777011;
        hashMap.put("mediumblue", n10);
        n10 = -4565549;
        hashMap.put("mediumorchid", n10);
        n10 = -7114533;
        hashMap.put("mediumpurple", n10);
        n10 = -12799119;
        hashMap.put("mediumseagreen", n10);
        n10 = -8689426;
        hashMap.put("mediumslateblue", n10);
        n10 = -16713062;
        hashMap.put("mediumspringgreen", n10);
        n10 = -12004916;
        hashMap.put("mediumturquoise", n10);
        n10 = -3730043;
        hashMap.put("mediumvioletred", n10);
        n10 = -15132304;
        hashMap.put("midnightblue", n10);
        n10 = -655366;
        hashMap.put("mintcream", n10);
        n10 = -6943;
        hashMap.put("mistyrose", n10);
        n10 = -6987;
        hashMap.put("moccasin", n10);
        n10 = -8531;
        hashMap.put("navajowhite", n10);
        n10 = -16777088;
        hashMap.put("navy", n10);
        n10 = -133658;
        hashMap.put("oldlace", n10);
        n10 = -8355840;
        hashMap.put("olive", n10);
        n10 = -9728477;
        hashMap.put("olivedrab", n10);
        n10 = -23296;
        hashMap.put("orange", n10);
        n10 = -47872;
        hashMap.put("orangered", n10);
        n10 = -2461482;
        hashMap.put("orchid", n10);
        n10 = -1120086;
        hashMap.put("palegoldenrod", n10);
        n10 = -6751336;
        hashMap.put("palegreen", n10);
        n10 = -5247250;
        hashMap.put("paleturquoise", n10);
        n10 = -2396013;
        hashMap.put("palevioletred", n10);
        n10 = -4139;
        hashMap.put("papayawhip", n10);
        n10 = -9543;
        hashMap.put("peachpuff", n10);
        n10 = -3308225;
        hashMap.put("peru", n10);
        n10 = -16181;
        hashMap.put("pink", n10);
        n10 = -2252579;
        hashMap.put("plum", n10);
        n10 = -5185306;
        hashMap.put("powderblue", n10);
        n10 = -8388480;
        hashMap.put("purple", n10);
        n10 = -10079335;
        hashMap.put("rebeccapurple", n10);
        n10 = -65536;
        hashMap.put("red", n10);
        n10 = -4419697;
        hashMap.put("rosybrown", n10);
        n10 = -12490271;
        hashMap.put("royalblue", n10);
        n10 = -7650029;
        hashMap.put("saddlebrown", n10);
        n10 = -360334;
        hashMap.put("salmon", n10);
        n10 = -744352;
        hashMap.put("sandybrown", n10);
        n10 = -13726889;
        hashMap.put("seagreen", n10);
        n10 = -2578;
        hashMap.put("seashell", n10);
        n10 = -6270419;
        hashMap.put("sienna", n10);
        n10 = -4144960;
        hashMap.put("silver", n10);
        n10 = -7876885;
        hashMap.put("skyblue", n10);
        n10 = -9807155;
        hashMap.put("slateblue", n10);
        n10 = -9404272;
        hashMap.put("slategray", n10);
        hashMap.put("slategrey", n10);
        n10 = -1286;
        hashMap.put("snow", n10);
        n10 = -16711809;
        hashMap.put("springgreen", n10);
        n10 = -12156236;
        hashMap.put("steelblue", n10);
        n10 = -2968436;
        hashMap.put("tan", n10);
        n10 = -16744320;
        hashMap.put("teal", n10);
        n10 = -2572328;
        hashMap.put("thistle", n10);
        n10 = -40121;
        hashMap.put("tomato", n10);
        n10 = 0;
        hashMap.put("transparent", n10);
        n10 = -12525360;
        hashMap.put("turquoise", n10);
        n10 = -1146130;
        hashMap.put("violet", n10);
        n10 = -663885;
        hashMap.put("wheat", n10);
        n10 = -1;
        hashMap.put("white", n10);
        n10 = -657931;
        hashMap.put("whitesmoke", n10);
        n10 = -256;
        hashMap.put("yellow", n10);
        n10 = -6632142;
        hashMap.put("yellowgreen", n10);
    }

    private ColorParser() {
    }

    /*
     * WARNING - void declaration
     */
    private static int parseColorInternal(String object, boolean bl2) {
        int n10;
        Object object2;
        float f10;
        int n11;
        int n12;
        block13: {
            block16: {
                int n13;
                block15: {
                    int n14;
                    block14: {
                        n12 = TextUtils.isEmpty((CharSequence)object);
                        n11 = 1;
                        Assertions.checkArgument(n12 ^ n11);
                        String string2 = "";
                        object = ((String)object).replace(" ", string2);
                        f10 = 0.0f;
                        object2 = null;
                        n12 = ((String)object).charAt(0);
                        n10 = 35;
                        if (n12 != n10) break block13;
                        String string3 = ((String)object).substring(n11);
                        f10 = 2.24E-44f;
                        long l10 = Long.parseLong(string3, 16);
                        n14 = (int)l10;
                        n12 = ((String)object).length();
                        if (n12 != (n11 = 7)) break block14;
                        n13 = 0xFF000000 | n14;
                        break block15;
                    }
                    n13 = ((String)object).length();
                    n12 = 9;
                    f10 = 1.3E-44f;
                    if (n13 != n12) break block16;
                    n13 = (n14 & 0xFF) << 24;
                    int n15 = n14 >>> 8;
                    n13 |= n15;
                }
                return n13;
            }
            object = new IllegalArgumentException();
            throw object;
        }
        object2 = RGBA;
        n12 = (int)(((String)object).startsWith((String)object2) ? 1 : 0);
        n10 = 3;
        int n16 = 2;
        int n17 = 10;
        if (n12 != 0) {
            object2 = bl2 ? RGBA_PATTERN_FLOAT_ALPHA : RGBA_PATTERN_INT_ALPHA;
            object = ((Pattern)object2).matcher((CharSequence)object);
            n12 = (int)(((Matcher)object).matches() ? 1 : 0);
            if (n12 != 0) {
                void var1_6;
                n12 = 4;
                f10 = 5.6E-45f;
                if (bl2) {
                    float f11 = 255.0f;
                    object2 = (String)Assertions.checkNotNull(((Matcher)object).group(n12));
                    f10 = Float.parseFloat((String)object2) * f11;
                    int n18 = (int)f10;
                } else {
                    String string4 = (String)Assertions.checkNotNull(((Matcher)object).group(n12));
                    int n19 = Integer.parseInt(string4, n17);
                }
                n12 = Integer.parseInt((String)Assertions.checkNotNull(((Matcher)object).group(n11)), n17);
                n11 = Integer.parseInt((String)Assertions.checkNotNull(((Matcher)object).group(n16)), n17);
                int n20 = Integer.parseInt((String)Assertions.checkNotNull(((Matcher)object).group(n10)), n17);
                return Color.argb((int)var1_6, (int)n12, (int)n11, (int)n20);
            }
        } else {
            Object object3 = RGB;
            boolean bl3 = ((String)object).startsWith((String)object3);
            if (bl3) {
                object3 = RGB_PATTERN;
                boolean bl4 = ((Matcher)(object = ((Pattern)object3).matcher((CharSequence)object))).matches();
                if (bl4) {
                    int n21 = Integer.parseInt((String)Assertions.checkNotNull(((Matcher)object).group(n11)), n17);
                    n12 = Integer.parseInt((String)Assertions.checkNotNull(((Matcher)object).group(n16)), n17);
                    int n22 = Integer.parseInt((String)Assertions.checkNotNull(((Matcher)object).group(n10)), n17);
                    return Color.rgb((int)n21, (int)n12, (int)n22);
                }
            } else {
                object3 = COLOR_MAP;
                object = Util.toLowerInvariant((String)object);
                if ((object = (Integer)object3.get(object)) != null) {
                    return (Integer)object;
                }
            }
        }
        object = new IllegalArgumentException();
        throw object;
    }

    public static int parseCssColor(String string2) {
        return ColorParser.parseColorInternal(string2, true);
    }

    public static int parseTtmlColor(String string2) {
        return ColorParser.parseColorInternal(string2, false);
    }
}

