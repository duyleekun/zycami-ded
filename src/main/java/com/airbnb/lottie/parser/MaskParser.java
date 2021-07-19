/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.Mask$MaskMode;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;

public class MaskParser {
    private MaskParser() {
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static Mask parse(JsonReader var0, LottieComposition var1_1) {
        var0.beginObject();
        var2_2 = false;
        var3_3 /* !! */  = null;
        var4_4 = false;
        var5_5 = null;
        var6_6 = null;
        block24: while (var7_7 = var0.hasNext()) {
            var8_8 = var0.nextName();
            var8_8.hashCode();
            var9_9 = var8_8.hashCode();
            var10_10 = 3;
            var11_11 = 2;
            var12_12 = 2.8E-45f;
            var13_13 = 1;
            var14_14 = 1.4E-45f;
            var15_15 = -1;
            var16_16 = 0.0f / 0.0f;
            switch (var9_9) lbl-1000:
            // 5 sources

            {
                default: {
                    var9_9 = var15_15;
                    break;
                }
                case 0x3339A3: {
                    var17_17 = "mode";
                    var9_9 = (int)var8_8.equals(var17_17);
                    if (var9_9 == 0) ** GOTO lbl-1000
                    var9_9 = var10_10;
                    break;
                }
                case 104433: {
                    var17_17 = "inv";
                    var9_9 = (int)var8_8.equals(var17_17);
                    if (var9_9 == 0) ** GOTO lbl-1000
                    var9_9 = var11_11;
                    break;
                }
                case 3588: {
                    var17_17 = "pt";
                    var9_9 = (int)var8_8.equals(var17_17);
                    if (var9_9 == 0) ** GOTO lbl-1000
                    var9_9 = var13_13;
                    break;
                }
                case 111: {
                    var17_17 = "o";
                    var9_9 = (int)var8_8.equals(var17_17);
                    if (var9_9 == 0) ** GOTO lbl-1000
                    var9_9 = 0;
                    var17_17 = null;
                }
            }
            switch (var9_9) {
                default: {
                    var0.skipValue();
                    continue block24;
                }
                case 3: {
                    var3_3 /* !! */  = var0.nextString();
                    var3_3 /* !! */ .hashCode();
                    var9_9 = var3_3 /* !! */ .hashCode();
                    switch (var9_9) lbl-1000:
                    // 5 sources

                    {
                        default: {
                            var10_10 = var15_15;
                            break;
                        }
                        case 115: {
                            var17_17 = "s";
                            var2_2 = var3_3 /* !! */ .equals(var17_17);
                            if (var2_2) break;
                            ** GOTO lbl-1000
                        }
                        case 110: {
                            var17_17 = "n";
                            var2_2 = var3_3 /* !! */ .equals(var17_17);
                            if (!var2_2) ** GOTO lbl-1000
                            var10_10 = var11_11;
                            break;
                        }
                        case 105: {
                            var17_17 = "i";
                            var2_2 = var3_3 /* !! */ .equals(var17_17);
                            if (!var2_2) ** GOTO lbl-1000
                            var10_10 = var13_13;
                            break;
                        }
                        case 97: {
                            var17_17 = "a";
                            var2_2 = var3_3 /* !! */ .equals(var17_17);
                            if (!var2_2) ** GOTO lbl-1000
                            var10_10 = 0;
                        }
                    }
                    switch (var10_10) {
                        default: {
                            var3_3 /* !! */  = new StringBuilder();
                            var17_17 = "Unknown mask mode ";
                            var3_3 /* !! */ .append(var17_17);
                            var3_3 /* !! */ .append(var8_8);
                            var8_8 = ". Defaulting to Add.";
                            var3_3 /* !! */ .append(var8_8);
                            Logger.warning(var3_3 /* !! */ .toString());
                            var3_3 /* !! */  = Mask$MaskMode.MASK_MODE_ADD;
                            continue block24;
                        }
                        case 3: {
                            var3_3 /* !! */  = Mask$MaskMode.MASK_MODE_SUBTRACT;
                            continue block24;
                        }
                        case 2: {
                            var3_3 /* !! */  = Mask$MaskMode.MASK_MODE_NONE;
                            continue block24;
                        }
                        case 1: {
                            var1_1.addWarning("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            var3_3 /* !! */  = Mask$MaskMode.MASK_MODE_INTERSECT;
                            continue block24;
                        }
                        case 0: 
                    }
                    var3_3 /* !! */  = Mask$MaskMode.MASK_MODE_ADD;
                    continue block24;
                }
                case 2: {
                    var4_4 = var0.nextBoolean();
                    continue block24;
                }
                case 1: {
                    var5_5 = AnimatableValueParser.parseShapeData((JsonReader)var0, var1_1);
                    continue block24;
                }
                case 0: 
            }
            var6_6 = AnimatableValueParser.parseInteger((JsonReader)var0, var1_1);
        }
        var0.endObject();
        var0 = new Mask((Mask$MaskMode)var3_3 /* !! */ , var5_5, var6_6, var4_4);
        return var0;
    }
}

