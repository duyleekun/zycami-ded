/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.parser.AnimatablePathValueParser;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Options;

public class RectangleShapeParser {
    private static JsonReader$Options NAMES = JsonReader$Options.of("nm", "p", "s", "r", "hd");

    private RectangleShapeParser() {
    }

    public static RectangleShape parse(JsonReader object, LottieComposition lottieComposition) {
        int n10 = 0;
        JsonReader$Options jsonReader$Options = null;
        int n11 = 0;
        String string2 = null;
        AnimatableValue animatableValue = null;
        AnimatablePointValue animatablePointValue = null;
        AnimatableFloatValue animatableFloatValue = null;
        boolean bl2 = false;
        while ((n10 = ((JsonReader)object).hasNext()) != 0) {
            jsonReader$Options = NAMES;
            n10 = ((JsonReader)object).selectName(jsonReader$Options);
            if (n10 != 0) {
                n11 = 1;
                if (n10 != n11) {
                    n11 = 2;
                    if (n10 != n11) {
                        n11 = 3;
                        if (n10 != n11) {
                            n11 = 4;
                            if (n10 != n11) {
                                ((JsonReader)object).skipValue();
                                continue;
                            }
                            bl2 = ((JsonReader)object).nextBoolean();
                            continue;
                        }
                        animatableFloatValue = AnimatableValueParser.parseFloat((JsonReader)object, lottieComposition);
                        continue;
                    }
                    animatablePointValue = AnimatableValueParser.parsePoint((JsonReader)object, lottieComposition);
                    continue;
                }
                animatableValue = AnimatablePathValueParser.parseSplitPath((JsonReader)object, lottieComposition);
                continue;
            }
            string2 = ((JsonReader)object).nextString();
        }
        object = new RectangleShape(string2, animatableValue, animatablePointValue, animatableFloatValue, bl2);
        return object;
    }
}

