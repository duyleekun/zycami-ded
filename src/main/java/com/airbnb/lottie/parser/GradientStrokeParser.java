/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke$LineCapType;
import com.airbnb.lottie.model.content.ShapeStroke$LineJoinType;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Options;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GradientStrokeParser {
    private static final JsonReader$Options DASH_PATTERN_NAMES;
    private static final JsonReader$Options GRADIENT_NAMES;
    private static JsonReader$Options NAMES;

    static {
        NAMES = JsonReader$Options.of("nm", "g", "o", "t", "s", "e", "w", "lc", "lj", "ml", "hd", "d");
        GRADIENT_NAMES = JsonReader$Options.of("p", "k");
        DASH_PATTERN_NAMES = JsonReader$Options.of("n", "v");
    }

    private GradientStrokeParser() {
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static GradientStroke parse(JsonReader var0, LottieComposition var1_1) {
        var2_2 = var0;
        var3_3 = var1_1;
        var4_4 = new ArrayList<ShapeStroke$LineCapType[]>();
        var5_5 = 0.0f;
        var6_6 = null;
        var7_7 /* !! */  = null;
        var8_8 = 0;
        var9_9 /* !! */  = null;
        var10_10 /* !! */  = null;
        var11_11 /* !! */  = null;
        var12_12 /* !! */  = null;
        var13_13 = 0;
        var14_14 = null;
        var15_15 = 0;
        var16_16 = null;
        var17_17 = 0;
        var18_18 = null;
        var19_19 = false;
        var20_20 = null;
        block14: while (var21_21 = var0.hasNext()) {
            var22_22 = GradientStrokeParser.NAMES;
            var23_23 = var2_2.selectName((JsonReader$Options)var22_22);
            switch (var23_23) {
                default: {
                    var0.skipName();
                    var0.skipValue();
                    continue block14;
                }
                case 11: {
                    var0.beginArray();
                    while ((var23_23 = (int)var0.hasNext()) != 0) {
                        var0.beginObject();
                        var23_23 = 0;
                        var22_22 = null;
                        var24_24 /* !! */  = null;
                        while (var25_25 = var0.hasNext()) {
                            var26_26 /* !! */  = GradientStrokeParser.DASH_PATTERN_NAMES;
                            var27_27 = var2_2.selectName((JsonReader$Options)var26_26 /* !! */ );
                            if (var27_27 != 0) {
                                var28_28 = var18_18;
                                var17_17 = 1;
                                if (var27_27 != var17_17) {
                                    var0.skipName();
                                    var0.skipValue();
                                } else {
                                    var24_24 /* !! */  = AnimatableValueParser.parseFloat(var0, var1_1);
                                }
                                var18_18 = var28_28;
                                continue;
                            }
                            var28_28 = var18_18;
                            var22_22 = var0.nextString();
                        }
                        var28_28 = var18_18;
                        var0.endObject();
                        var26_26 /* !! */  = "o";
                        var27_27 = (int)var22_22.equals(var26_26 /* !! */ );
                        if (var27_27 != 0) {
                            var18_18 = var24_24 /* !! */ ;
                            var27_27 = 1;
                            continue;
                        }
                        var26_26 /* !! */  = "d";
                        var27_27 = (int)var22_22.equals(var26_26 /* !! */ );
                        if (var27_27 == 0 && (var27_27 = var22_22.equals(var26_26 /* !! */  = "g")) == 0) {
                            var27_27 = 1;
                        } else {
                            var27_27 = 1;
                            var3_3.setHasDashPattern((boolean)var27_27);
                            var22_22 = var24_24 /* !! */ ;
                            var4_4.add(var24_24 /* !! */ );
                        }
                        var18_18 = var28_28;
                    }
                    var28_28 = var18_18;
                    var27_27 = 1;
                    var0.endArray();
                    var23_23 = var4_4.size();
                    if (var23_23 == var27_27) {
                        var27_27 = 0;
                        var26_26 /* !! */  = null;
                        var22_22 = var4_4.get(0);
                        var4_4.add((ShapeStroke$LineCapType[])var22_22);
                    } else {
                        var27_27 = 0;
                        var26_26 /* !! */  = null;
                    }
                    var18_18 = var28_28;
                    continue block14;
                }
                case 10: {
                    var27_27 = 0;
                    var26_26 /* !! */  = null;
                    var19_19 = var0.nextBoolean();
                    continue block14;
                }
                case 9: {
                    var29_29 = var0.nextDouble();
                    var5_5 = (float)var29_29;
                    continue block14;
                }
                case 8: {
                    var26_26 /* !! */  = ShapeStroke$LineJoinType.values();
                    var23_23 = var0.nextInt();
                    var15_15 = 1;
                    var16_16 = var26_26 /* !! */ [var23_23 -= var15_15];
                    continue block14;
                }
                case 7: {
                    var27_27 = 1;
                    var22_22 = ShapeStroke$LineCapType.values();
                    var13_13 = var0.nextInt() - var27_27;
                    var14_14 = var22_22[var13_13];
                    continue block14;
                }
                case 6: {
                    var12_12 /* !! */  = AnimatableValueParser.parseFloat(var0, var1_1);
                    continue block14;
                }
                case 5: {
                    var11_11 /* !! */  = AnimatableValueParser.parsePoint(var0, var1_1);
                    continue block14;
                }
                case 4: {
                    var10_10 /* !! */  = AnimatableValueParser.parsePoint(var0, var1_1);
                    continue block14;
                }
                case 3: {
                    var27_27 = 1;
                    var23_23 = var0.nextInt();
                    var26_26 /* !! */  = var23_23 == var27_27 ? GradientType.LINEAR : GradientType.RADIAL;
                    var7_7 /* !! */  = var26_26 /* !! */ ;
                    continue block14;
                }
                case 2: {
                    var20_20 = AnimatableValueParser.parseInteger(var0, var1_1);
                    continue block14;
                }
                case 1: {
                    var27_27 = -1;
                    var0.beginObject();
                    while ((var23_23 = (int)var0.hasNext()) != 0) {
                        var22_22 = GradientStrokeParser.GRADIENT_NAMES;
                        var23_23 = var2_2.selectName((JsonReader$Options)var22_22);
                        if (var23_23 == 0) ** GOTO lbl141
                        var24_24 /* !! */  = var9_9 /* !! */ ;
                        var8_8 = 1;
                        if (var23_23 != var8_8) {
                            var0.skipName();
                            var0.skipValue();
                        } else {
                            var22_22 = AnimatableValueParser.parseGradientColor((JsonReader)var2_2, var3_3, var27_27);
                            var9_9 /* !! */  = var22_22;
                            continue;
lbl141:
                            // 1 sources

                            var24_24 /* !! */  = var9_9 /* !! */ ;
                            var8_8 = 1;
                            var27_27 = var0.nextInt();
                        }
                        var9_9 /* !! */  = var24_24 /* !! */ ;
                    }
                    var24_24 /* !! */  = var9_9 /* !! */ ;
                    var0.endObject();
                    continue block14;
                }
                case 0: 
            }
            var6_6 = var0.nextString();
        }
        if (var20_20 == null) {
            var27_27 = 100;
            var26_26 /* !! */  = var27_27;
            var3_3 = new List<Object>((Object)var26_26 /* !! */ );
            var3_3 = Collections.singletonList(var3_3);
            var20_20 = var2_2 = new AnimatableIntegerValue(var3_3);
        }
        var2_2 = var31_30;
        var3_3 = var6_6;
        var26_26 /* !! */  = var7_7 /* !! */ ;
        var22_22 = var9_9 /* !! */ ;
        var6_6 = var20_20;
        var7_7 /* !! */  = var10_10 /* !! */ ;
        var9_9 /* !! */  = var11_11 /* !! */ ;
        var10_10 /* !! */  = var12_12 /* !! */ ;
        var11_11 /* !! */  = var14_14;
        var12_12 /* !! */  = var16_16;
        var16_16 = var18_18;
        var31_30 = new GradientStroke((String)var3_3, (GradientType)var26_26 /* !! */ , (AnimatableGradientColorValue)var22_22, (AnimatableIntegerValue)var20_20, (AnimatablePointValue)var7_7 /* !! */ , (AnimatablePointValue)var9_9 /* !! */ , (AnimatableFloatValue)var10_10 /* !! */ , var14_14, (ShapeStroke$LineJoinType)var12_12 /* !! */ , var5_5, var4_4, (AnimatableFloatValue)var18_18, var19_19);
        return var31_30;
    }
}

