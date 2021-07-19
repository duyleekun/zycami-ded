/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.content.ShapeStroke$LineCapType;
import com.airbnb.lottie.model.content.ShapeStroke$LineJoinType;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Options;
import com.airbnb.lottie.value.Keyframe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShapeStrokeParser {
    private static final JsonReader$Options DASH_PATTERN_NAMES;
    private static JsonReader$Options NAMES;

    static {
        NAMES = JsonReader$Options.of("nm", "c", "w", "o", "lc", "lj", "ml", "hd", "d");
        DASH_PATTERN_NAMES = JsonReader$Options.of("n", "v");
    }

    private ShapeStrokeParser() {
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static ShapeStroke parse(JsonReader var0, LottieComposition var1_1) {
        var2_2 = var0;
        var3_3 = new ArrayList<Object>();
        var4_4 = null;
        var5_5 = false;
        var6_6 = 0.0f;
        var7_7 = null;
        var8_8 = null;
        var9_9 = null;
        var10_10 = null;
        var11_11 /* !! */  = null;
        var12_12 /* !! */  = null;
        var13_13 = null;
        block20: while ((var14_14 = var0.hasNext()) != 0) {
            var15_15 = ShapeStrokeParser.NAMES;
            var14_14 = var2_2.selectName((JsonReader$Options)var15_15);
            var16_16 = 1;
            switch (var14_14) {
                default: {
                    var17_17 = var1_1;
                    var0.skipValue();
                    continue block20;
                }
                case 8: {
                    var0.beginArray();
                    block21: while ((var14_14 = (int)var0.hasNext()) != 0) {
                        var0.beginObject();
                        var14_14 = 0;
                        var15_15 = null;
                        var18_18 = null;
                        while (var19_19 = var0.hasNext()) {
                            var17_17 = ShapeStrokeParser.DASH_PATTERN_NAMES;
                            var20_20 = var2_2.selectName((JsonReader$Options)var17_17);
                            if (var20_20 != 0) {
                                if (var20_20 != var16_16) {
                                    var0.skipName();
                                    var0.skipValue();
                                    continue;
                                }
                                var18_18 = AnimatableValueParser.parseFloat(var0, var1_1);
                                continue;
                            }
                            var15_15 = var0.nextString();
                        }
                        var0.endObject();
                        var15_15.hashCode();
                        var21_21 = var15_15.hashCode();
                        switch (var21_21) lbl-1000:
                        // 4 sources

                        {
                            default: {
                                var20_20 = -1;
                                break;
                            }
                            case 111: {
                                var17_17 = "o";
                                var20_20 = (int)var15_15.equals(var17_17);
                                if (var20_20 == 0) ** GOTO lbl-1000
                                var20_20 = 2;
                                break;
                            }
                            case 103: {
                                var17_17 = "g";
                                var20_20 = (int)var15_15.equals(var17_17);
                                if (var20_20 == 0) ** GOTO lbl-1000
                                var20_20 = var16_16;
                                break;
                            }
                            case 100: {
                                var17_17 = "d";
                                var20_20 = (int)var15_15.equals(var17_17);
                                if (var20_20 == 0) ** GOTO lbl-1000
                                var20_20 = 0;
                                var17_17 = null;
                            }
                        }
                        switch (var20_20) {
                            default: {
                                var17_17 = var1_1;
                                continue block21;
                            }
                            case 2: {
                                var17_17 = var1_1;
                                var8_8 = var18_18;
                                continue block21;
                            }
                            case 0: 
                            case 1: 
                        }
                        var17_17 = var1_1;
                        var1_1.setHasDashPattern((boolean)var16_16);
                        var3_3.add(var18_18);
                    }
                    var17_17 = var1_1;
                    var0.endArray();
                    var14_14 = var3_3.size();
                    if (var14_14 != var16_16) continue block20;
                    var15_15 = var3_3.get(0);
                    var3_3.add(var15_15);
                    continue block20;
                }
                case 7: {
                    var17_17 = var1_1;
                    var5_5 = var0.nextBoolean();
                    continue block20;
                }
                case 6: {
                    var17_17 = var1_1;
                    var22_22 = var0.nextDouble();
                    var6_6 = (float)var22_22;
                    continue block20;
                }
                case 5: {
                    var17_17 = var1_1;
                    var12_12 /* !! */  = ShapeStroke$LineJoinType.values();
                    var14_14 = var0.nextInt() - var16_16;
                    var12_12 /* !! */  = var12_12 /* !! */ [var14_14];
                    continue block20;
                }
                case 4: {
                    var17_17 = var1_1;
                    var11_11 /* !! */  = ShapeStroke$LineCapType.values();
                    var14_14 = var0.nextInt() - var16_16;
                    var11_11 /* !! */  = var11_11 /* !! */ [var14_14];
                    continue block20;
                }
                case 3: {
                    var17_17 = var1_1;
                    var13_13 = AnimatableValueParser.parseInteger(var0, var1_1);
                    continue block20;
                }
                case 2: {
                    var17_17 = var1_1;
                    var10_10 = AnimatableValueParser.parseFloat(var0, var1_1);
                    continue block20;
                }
                case 1: {
                    var17_17 = var1_1;
                    var9_9 = AnimatableValueParser.parseColor(var0, var1_1);
                    continue block20;
                }
                case 0: 
            }
            var17_17 = var1_1;
            var7_7 = var0.nextString();
        }
        if (var13_13 == null) {
            var20_20 = 100;
            var17_17 = var20_20;
            var4_4 = new Keyframe(var17_17);
            var4_4 = Collections.singletonList(var4_4);
            var13_13 = var2_2 = new AnimatableIntegerValue((List)var4_4);
        }
        var2_2 = var15_15;
        var4_4 = var7_7;
        var17_17 = var8_8;
        var7_7 = var9_9;
        var8_8 = var13_13;
        var9_9 = var10_10;
        var10_10 = var11_11 /* !! */ ;
        var11_11 /* !! */  = var12_12 /* !! */ ;
        var15_15 = new ShapeStroke((String)var4_4, (AnimatableFloatValue)var17_17, var3_3, (AnimatableColorValue)var7_7, (AnimatableIntegerValue)var13_13, (AnimatableFloatValue)var9_9, (ShapeStroke$LineCapType)var10_10, (ShapeStroke$LineJoinType)var12_12 /* !! */ , var6_6, var5_5);
        return var15_15;
    }
}

