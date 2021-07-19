/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.AnimatablePathValueParser;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Options;
import com.airbnb.lottie.parser.moshi.JsonReader$Token;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.ScaleXY;

public class AnimatableTransformParser {
    private static JsonReader$Options ANIMATABLE_NAMES;
    private static JsonReader$Options NAMES;

    static {
        NAMES = JsonReader$Options.of("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");
        ANIMATABLE_NAMES = JsonReader$Options.of("k");
    }

    private AnimatableTransformParser() {
    }

    private static boolean isAnchorPointIdentity(AnimatablePathValue animatablePathValue) {
        boolean bl2;
        block3: {
            block2: {
                bl2 = false;
                if (animatablePathValue == null) break block2;
                boolean bl3 = animatablePathValue.isStatic();
                if (!bl3) break block3;
                animatablePathValue = (PointF)((Keyframe)animatablePathValue.getKeyframes().get((int)0)).startValue;
                bl3 = false;
                boolean bl4 = animatablePathValue.equals(0.0f, 0.0f);
                if (!bl4) break block3;
            }
            bl2 = true;
        }
        return bl2;
    }

    private static boolean isPositionIdentity(AnimatableValue animatableValue) {
        boolean bl2;
        block3: {
            block2: {
                bl2 = false;
                if (animatableValue == null) break block2;
                boolean bl3 = animatableValue instanceof AnimatableSplitDimensionPathValue;
                if (bl3 || !(bl3 = animatableValue.isStatic())) break block3;
                animatableValue = (PointF)((Keyframe)animatableValue.getKeyframes().get((int)0)).startValue;
                bl3 = false;
                boolean bl4 = animatableValue.equals(0.0f, 0.0f);
                if (!bl4) break block3;
            }
            bl2 = true;
        }
        return bl2;
    }

    private static boolean isRotationIdentity(AnimatableFloatValue object) {
        boolean bl2;
        block3: {
            block2: {
                bl2 = false;
                if (object == null) break block2;
                boolean bl3 = ((AnimatableFloatValue)object).isStatic();
                if (!bl3) break block3;
                object = (Float)((Keyframe)object.getKeyframes().get((int)0)).startValue;
                float f10 = ((Float)object).floatValue();
                bl3 = false;
                float f11 = f10 - 0.0f;
                Object object2 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
                if (object2 != false) break block3;
            }
            bl2 = true;
        }
        return bl2;
    }

    private static boolean isScaleIdentity(AnimatableScaleValue object) {
        boolean bl2;
        block3: {
            block2: {
                bl2 = false;
                if (object == null) break block2;
                boolean n10 = ((AnimatableScaleValue)object).isStatic();
                if (!n10) break block3;
                object = (ScaleXY)((Keyframe)object.getKeyframes().get((int)0)).startValue;
                int n11 = 1065353216;
                float f10 = 1.0f;
                boolean bl3 = ((ScaleXY)object).equals(f10, f10);
                if (!bl3) break block3;
            }
            bl2 = true;
        }
        return bl2;
    }

    private static boolean isSkewAngleIdentity(AnimatableFloatValue object) {
        boolean bl2;
        block3: {
            block2: {
                bl2 = false;
                if (object == null) break block2;
                boolean bl3 = ((AnimatableFloatValue)object).isStatic();
                if (!bl3) break block3;
                object = (Float)((Keyframe)object.getKeyframes().get((int)0)).startValue;
                float f10 = ((Float)object).floatValue();
                bl3 = false;
                float f11 = f10 - 0.0f;
                Object object2 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
                if (object2 != false) break block3;
            }
            bl2 = true;
        }
        return bl2;
    }

    private static boolean isSkewIdentity(AnimatableFloatValue object) {
        boolean bl2;
        block3: {
            block2: {
                bl2 = false;
                if (object == null) break block2;
                boolean bl3 = ((AnimatableFloatValue)object).isStatic();
                if (!bl3) break block3;
                object = (Float)((Keyframe)object.getKeyframes().get((int)0)).startValue;
                float f10 = ((Float)object).floatValue();
                bl3 = false;
                float f11 = f10 - 0.0f;
                Object object2 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
                if (object2 != false) break block3;
            }
            bl2 = true;
        }
        return bl2;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static AnimatableTransform parse(JsonReader var0, LottieComposition var1_1) {
        var2_2 = var0;
        var3_3 = var1_1;
        var4_4 = var0.peek();
        var5_5 /* !! */  = JsonReader$Token.BEGIN_OBJECT;
        var6_6 = null;
        if (var4_4 == var5_5 /* !! */ ) {
            var7_7 = true;
            var8_8 = 1.4E-45f;
            var9_9 = var7_7;
        } else {
            var9_9 = false;
        }
        if (var9_9) {
            var0.beginObject();
        }
        var7_7 = false;
        var8_8 = 0.0f;
        var4_4 = null;
        var10_10 = null;
        var11_11 = null;
        var12_12 = null;
        var13_13 = null;
        var14_14 = null;
        var15_15 = null;
        var16_16 = null;
        var17_17 = null;
        block12: while ((var18_18 = var0.hasNext()) != 0) {
            var5_5 /* !! */  = AnimatableTransformParser.NAMES;
            var18_18 = var2_2.selectName((JsonReader$Options)var5_5 /* !! */ );
            switch (var18_18) {
                default: {
                    var18_18 = 0;
                    var5_5 /* !! */  = null;
                    var0.skipName();
                    var0.skipValue();
                    continue block12;
                }
                case 9: {
                    var14_14 = AnimatableValueParser.parseFloat((JsonReader)var2_2, var3_3, false);
                    continue block12;
                }
                case 8: {
                    var13_13 = AnimatableValueParser.parseFloat((JsonReader)var2_2, var3_3, false);
                    continue block12;
                }
                case 7: {
                    var17_17 = AnimatableValueParser.parseFloat((JsonReader)var2_2, var3_3, false);
                    continue block12;
                }
                case 6: {
                    var16_16 = AnimatableValueParser.parseFloat((JsonReader)var2_2, var3_3, false);
                    continue block12;
                }
                case 5: {
                    var15_15 = AnimatableValueParser.parseInteger(var0, var1_1);
                    continue block12;
                }
                case 3: {
                    var4_4 = "Lottie doesn't support 3D layers.";
                    var3_3.addWarning((String)var4_4);
                }
                case 4: {
                    var19_19 = AnimatableValueParser.parseFloat((JsonReader)var2_2, var3_3, false);
                    var4_4 = var19_19.getKeyframes();
                    var7_7 = var4_4.isEmpty();
                    var18_18 = 0;
                    var5_5 /* !! */  = null;
                    if (!var7_7) ** GOTO lbl76
                    var20_20 = var19_19.getKeyframes();
                    var22_22 = Float.valueOf(0.0f);
                    var23_23 = Float.valueOf(0.0f);
                    var24_24 = null;
                    var8_8 = var1_1.getEndFrame();
                    var25_25 = Float.valueOf(var8_8);
                    var4_4 = var21_21;
                    var5_5 /* !! */  = var1_1;
                    var26_26 = var21_21;
                    var21_21 = null;
                    var6_6 = var20_20;
                    var20_20 = var25_25;
                    var4_4(var1_1, var22_22, var23_23, null, 0.0f, (Float)var25_25);
                    var6_6.add(var4_4);
                    ** GOTO lbl-1000
lbl76:
                    // 1 sources

                    var4_4 = var19_19.getKeyframes();
                    var27_27 = 0;
                    var22_22 = null;
                    var4_4 = ((Keyframe)var4_4.get((int)0)).startValue;
                    if (var4_4 == null) {
                        var6_6 = var19_19.getKeyframes();
                        var22_22 = Float.valueOf(0.0f);
                        var23_23 = Float.valueOf(0.0f);
                        var21_21 = null;
                        var8_8 = var1_1.getEndFrame();
                        var20_20 = Float.valueOf(var8_8);
                        var4_4 = var26_26;
                        var5_5 /* !! */  = var1_1;
                        var26_26 = new Keyframe(var1_1, var22_22, var23_23, null, 0.0f, (Float)var20_20);
                        var18_18 = 0;
                        var5_5 /* !! */  = null;
                        var6_6.set(0, var26_26);
                    } else lbl-1000:
                    // 2 sources

                    {
                        var18_18 = 0;
                        var5_5 /* !! */  = null;
                    }
                    var6_6 = null;
                    var4_4 = var19_19;
                    continue block12;
                }
                case 2: {
                    var18_18 = 0;
                    var5_5 /* !! */  = null;
                    var12_12 = AnimatableValueParser.parseScale(var0, var1_1);
                    continue block12;
                }
                case 1: {
                    var18_18 = 0;
                    var5_5 /* !! */  = null;
                    var11_11 = AnimatablePathValueParser.parseSplitPath(var0, var1_1);
                    continue block12;
                }
                case 0: 
            }
            var18_18 = 0;
            var5_5 /* !! */  = null;
            var0.beginObject();
            while ((var27_27 = var0.hasNext()) != 0) {
                var22_22 = AnimatableTransformParser.ANIMATABLE_NAMES;
                var27_27 = var2_2.selectName((JsonReader$Options)var22_22);
                if (var27_27 != 0) {
                    var0.skipName();
                    var0.skipValue();
                    continue;
                }
                var10_10 = AnimatablePathValueParser.parse(var0, var1_1);
            }
            var0.endObject();
            var6_6 = null;
        }
        if (var9_9) {
            var0.endObject();
        }
        var24_24 = (var28_28 = AnimatableTransformParser.isAnchorPointIdentity(var10_10)) != false ? null : var10_10;
        var28_28 = AnimatableTransformParser.isPositionIdentity(var11_11);
        var25_25 = var28_28 != false ? null : var11_11;
        var28_28 = AnimatableTransformParser.isRotationIdentity((AnimatableFloatValue)var4_4);
        var29_29 = var28_28 != false ? null : var4_4;
        var28_28 = AnimatableTransformParser.isScaleIdentity(var12_12);
        if (var28_28) {
            var12_12 = null;
        }
        var30_30 = (var28_28 = AnimatableTransformParser.isSkewIdentity(var13_13)) != false ? null : var13_13;
        var28_28 = AnimatableTransformParser.isSkewAngleIdentity(var14_14);
        var31_31 = var28_28 != false ? null : var14_14;
        var19_19 = var2_2;
        var2_2 = new AnimatableTransform(var24_24, (AnimatableValue)var25_25, var12_12, (AnimatableFloatValue)var29_29, var15_15, var16_16, var17_17, var30_30, var31_31);
        return var2_2;
    }
}

