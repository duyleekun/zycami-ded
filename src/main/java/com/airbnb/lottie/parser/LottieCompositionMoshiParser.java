/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 */
package com.airbnb.lottie.parser;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.model.layer.Layer$LayerType;
import com.airbnb.lottie.parser.FontCharacterParser;
import com.airbnb.lottie.parser.FontParser;
import com.airbnb.lottie.parser.LayerParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Options;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottieCompositionMoshiParser {
    public static JsonReader$Options ASSETS_NAMES;
    private static final JsonReader$Options FONT_NAMES;
    private static final JsonReader$Options MARKER_NAMES;
    private static final JsonReader$Options NAMES;

    static {
        NAMES = JsonReader$Options.of("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");
        ASSETS_NAMES = JsonReader$Options.of("id", "layers", "w", "h", "p", "u");
        FONT_NAMES = JsonReader$Options.of("list");
        MARKER_NAMES = JsonReader$Options.of("cm", "tm", "dr");
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static LottieComposition parse(JsonReader var0) {
        var1_1 /* !! */  = var0;
        var2_2 = Utils.dpScale();
        var3_3 = new LongSparseArray();
        var4_4 = new ArrayList<E>();
        var5_5 = new HashMap<K, V>();
        var6_6 = new HashMap<K, V>();
        var7_7 = new HashMap();
        var8_8 = new ArrayList();
        var9_9 = new SparseArrayCompat();
        var10_10 = new LottieComposition();
        var0.beginObject();
        var11_11 = 0.0f;
        var12_12 = 0.0f;
        var13_13 = 0.0f;
        var14_14 = 0;
        var15_15 = 0;
        while (var16_16 = var0.hasNext()) {
            block15: {
                var17_17 = LottieCompositionMoshiParser.NAMES;
                var18_18 = var1_1 /* !! */ .selectName((JsonReader$Options)var17_17);
                switch (var18_18) {
                    default: {
                        var1_1 /* !! */  = var7_7;
                        var19_19 = var8_8;
                        var0.skipName();
                        var0.skipValue();
                        ** GOTO lbl73
                    }
                    case 10: {
                        LottieCompositionMoshiParser.parseMarkers(var1_1 /* !! */ , var10_10, var8_8);
                        ** GOTO lbl58
                    }
                    case 9: {
                        LottieCompositionMoshiParser.parseChars(var1_1 /* !! */ , var10_10, var9_9);
                        ** GOTO lbl58
                    }
                    case 8: {
                        LottieCompositionMoshiParser.parseFonts(var1_1 /* !! */ , var7_7);
                        ** GOTO lbl58
                    }
                    case 7: {
                        LottieCompositionMoshiParser.parseAssets(var1_1 /* !! */ , var10_10, var5_5, var6_6);
                        ** GOTO lbl58
                    }
                    case 6: {
                        LottieCompositionMoshiParser.parseLayers(var1_1 /* !! */ , var10_10, var4_4, var3_3);
                        ** GOTO lbl58
                    }
                    case 5: {
                        var1_1 /* !! */  = var0.nextString().split("\\.");
                        var19_19 = var1_1 /* !! */ [0];
                        var20_20 = Integer.parseInt((String)var19_19);
                        var17_17 = var1_1 /* !! */ [1];
                        var21_21 = Integer.parseInt((String)var17_17);
                        var18_18 = 2;
                        var22_22 = 2.8E-45f;
                        var1_1 /* !! */  = var1_1 /* !! */ [var18_18];
                        var23_23 = Integer.parseInt((String)var1_1 /* !! */ );
                        var24_24 = 4;
                        var25_25 = 4;
                        var26_26 = Utils.isAtLeastVersion(var20_20, var21_21, var23_23, var24_24, var25_25, 0);
                        if (!var26_26) {
                            var1_1 /* !! */  = "Lottie only supports bodymovin >= 4.4.0";
                            var10_10.addWarning((String)var1_1 /* !! */ );
                        }
lbl58:
                        // 8 sources

                        var1_1 /* !! */  = var7_7;
                        var19_19 = var8_8;
                        ** GOTO lbl73
                    }
                    case 4: {
                        var1_1 /* !! */  = var7_7;
                        var19_19 = var8_8;
                        var27_27 = var0.nextDouble();
                        var13_13 = (float)var27_27;
                        ** GOTO lbl73
                    }
                    case 3: {
                        var1_1 /* !! */  = var7_7;
                        var19_19 = var8_8;
                        var27_27 = var0.nextDouble();
                        var22_22 = (float)var27_27;
                        var12_12 = var22_22 - 0.01f;
lbl73:
                        // 4 sources

                        var7_7 = var1_1 /* !! */ ;
                        var8_8 = var19_19;
                        break block15;
                    }
                    case 2: {
                        var1_1 /* !! */  = var7_7;
                        var19_19 = var8_8;
                        var29_28 = var0.nextDouble();
                        var11_11 = (float)var29_28;
                        break block15;
                    }
                    case 1: {
                        var1_1 /* !! */  = var7_7;
                        var19_19 = var8_8;
                        var15_15 = var0.nextInt();
                        break block15;
                    }
                    case 0: 
                }
                var1_1 /* !! */  = var7_7;
                var19_19 = var8_8;
                var14_14 = var0.nextInt();
            }
            var1_1 /* !! */  = var0;
        }
        var1_1 /* !! */  = var7_7;
        var19_19 = var8_8;
        var14_14 = (int)((float)var14_14 * var2_2);
        var31_29 = (int)((float)var15_15 * var2_2);
        var17_17 = new Rect(0, 0, var14_14, var31_29);
        var10_10.init((Rect)var17_17, var11_11, var12_12, var13_13, var4_4, var3_3, var5_5, var6_6, var9_9, (Map)var7_7, (List)var8_8);
        return var10_10;
    }

    private static void parseAssets(JsonReader jsonReader, LottieComposition lottieComposition, Map map, Map map2) {
        boolean bl2;
        jsonReader.beginArray();
        while (bl2 = jsonReader.hasNext()) {
            Object object = new ArrayList();
            Object object2 = new LongSparseArray();
            jsonReader.beginObject();
            int n10 = 0;
            Object object3 = null;
            int n11 = 0;
            int n12 = 0;
            int n13 = 0;
            String string2 = null;
            String string3 = null;
            String string4 = null;
            while ((n10 = jsonReader.hasNext()) != 0) {
                object3 = ASSETS_NAMES;
                n10 = jsonReader.selectName((JsonReader$Options)object3);
                if (n10 != 0) {
                    n11 = 1;
                    if (n10 != n11) {
                        n11 = 2;
                        if (n10 != n11) {
                            n11 = 3;
                            if (n10 != n11) {
                                n11 = 4;
                                if (n10 != n11) {
                                    n11 = 5;
                                    if (n10 != n11) {
                                        jsonReader.skipName();
                                        jsonReader.skipValue();
                                        continue;
                                    }
                                    string4 = jsonReader.nextString();
                                    continue;
                                }
                                string3 = jsonReader.nextString();
                                continue;
                            }
                            n13 = jsonReader.nextInt();
                            continue;
                        }
                        n12 = jsonReader.nextInt();
                        continue;
                    }
                    jsonReader.beginArray();
                    while ((n10 = (int)(jsonReader.hasNext() ? 1 : 0)) != 0) {
                        object3 = LayerParser.parse(jsonReader, lottieComposition);
                        long l10 = ((Layer)object3).getId();
                        ((LongSparseArray)object2).put(l10, object3);
                        object.add(object3);
                    }
                    jsonReader.endArray();
                    continue;
                }
                string2 = jsonReader.nextString();
            }
            jsonReader.endObject();
            if (string3 != null) {
                object = new LottieImageAsset(n12, n13, string2, string3, string4);
                object2 = ((LottieImageAsset)object).getId();
                map2.put(object2, object);
                continue;
            }
            map.put(string2, object);
        }
        jsonReader.endArray();
    }

    private static void parseChars(JsonReader jsonReader, LottieComposition lottieComposition, SparseArrayCompat sparseArrayCompat) {
        boolean bl2;
        jsonReader.beginArray();
        while (bl2 = jsonReader.hasNext()) {
            FontCharacter fontCharacter = FontCharacterParser.parse(jsonReader, lottieComposition);
            int n10 = fontCharacter.hashCode();
            sparseArrayCompat.put(n10, fontCharacter);
        }
        jsonReader.endArray();
    }

    private static void parseFonts(JsonReader jsonReader, Map map) {
        int n10;
        jsonReader.beginObject();
        while ((n10 = jsonReader.hasNext()) != 0) {
            Object object = FONT_NAMES;
            n10 = jsonReader.selectName((JsonReader$Options)object);
            if (n10 != 0) {
                jsonReader.skipName();
                jsonReader.skipValue();
                continue;
            }
            jsonReader.beginArray();
            while ((n10 = (int)(jsonReader.hasNext() ? 1 : 0)) != 0) {
                object = FontParser.parse(jsonReader);
                String string2 = ((Font)object).getName();
                map.put(string2, object);
            }
            jsonReader.endArray();
        }
        jsonReader.endObject();
    }

    private static void parseLayers(JsonReader jsonReader, LottieComposition lottieComposition, List list, LongSparseArray longSparseArray) {
        int n10;
        jsonReader.beginArray();
        int n11 = 0;
        while ((n10 = jsonReader.hasNext()) != 0) {
            Layer$LayerType layer$LayerType;
            Object object = LayerParser.parse(jsonReader, lottieComposition);
            Object object2 = ((Layer)object).getLayerType();
            if (object2 == (layer$LayerType = Layer$LayerType.IMAGE)) {
                ++n11;
            }
            list.add(object);
            long l10 = ((Layer)object).getId();
            longSparseArray.put(l10, object);
            n10 = 4;
            if (n11 <= n10) continue;
            object = new StringBuilder();
            ((StringBuilder)object).append("You have ");
            ((StringBuilder)object).append(n11);
            object2 = " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.";
            ((StringBuilder)object).append((String)object2);
            object = ((StringBuilder)object).toString();
            Logger.warning((String)object);
        }
        jsonReader.endArray();
    }

    private static void parseMarkers(JsonReader jsonReader, LottieComposition object, List list) {
        boolean bl2;
        jsonReader.beginArray();
        while (bl2 = jsonReader.hasNext()) {
            Object object2;
            int n10;
            bl2 = false;
            object = null;
            jsonReader.beginObject();
            float f10 = 0.0f;
            float f11 = 0.0f;
            while ((n10 = jsonReader.hasNext()) != 0) {
                object2 = MARKER_NAMES;
                n10 = jsonReader.selectName((JsonReader$Options)object2);
                if (n10 != 0) {
                    int n11 = 1;
                    if (n10 != n11) {
                        n11 = 2;
                        if (n10 != n11) {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                            continue;
                        }
                        double d10 = jsonReader.nextDouble();
                        f11 = (float)d10;
                        continue;
                    }
                    double d11 = jsonReader.nextDouble();
                    f10 = (float)d11;
                    continue;
                }
                object = jsonReader.nextString();
            }
            jsonReader.endObject();
            object2 = new Marker((String)object, f10, f11);
            list.add(object2);
        }
        jsonReader.endArray();
    }
}

