/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.content.ShapeTrimPath$Type;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Options;

public class ShapeTrimPathParser {
    private static JsonReader$Options NAMES = JsonReader$Options.of("s", "e", "o", "nm", "m", "hd");

    private ShapeTrimPathParser() {
    }

    public static ShapeTrimPath parse(JsonReader object, LottieComposition lottieComposition) {
        int n10 = 0;
        JsonReader$Options jsonReader$Options = null;
        boolean bl2 = false;
        String string2 = null;
        ShapeTrimPath$Type shapeTrimPath$Type = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableFloatValue animatableFloatValue3 = null;
        while ((n10 = ((JsonReader)object).hasNext()) != 0) {
            jsonReader$Options = NAMES;
            n10 = ((JsonReader)object).selectName(jsonReader$Options);
            if (n10 != 0) {
                int n11 = 1;
                if (n10 != n11) {
                    n11 = 2;
                    if (n10 != n11) {
                        n11 = 3;
                        if (n10 != n11) {
                            n11 = 4;
                            if (n10 != n11) {
                                n11 = 5;
                                if (n10 != n11) {
                                    ((JsonReader)object).skipValue();
                                    continue;
                                }
                                bl2 = ((JsonReader)object).nextBoolean();
                                continue;
                            }
                            n10 = ((JsonReader)object).nextInt();
                            shapeTrimPath$Type = ShapeTrimPath$Type.forId(n10);
                            continue;
                        }
                        string2 = ((JsonReader)object).nextString();
                        continue;
                    }
                    animatableFloatValue3 = AnimatableValueParser.parseFloat((JsonReader)object, lottieComposition, false);
                    continue;
                }
                animatableFloatValue2 = AnimatableValueParser.parseFloat((JsonReader)object, lottieComposition, false);
                continue;
            }
            animatableFloatValue = AnimatableValueParser.parseFloat((JsonReader)object, lottieComposition, false);
        }
        object = new ShapeTrimPath(string2, shapeTrimPath$Type, animatableFloatValue, animatableFloatValue2, animatableFloatValue3, bl2);
        return object;
    }
}

