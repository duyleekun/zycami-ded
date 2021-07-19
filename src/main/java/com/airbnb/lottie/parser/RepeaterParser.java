/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.parser.AnimatableTransformParser;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Options;

public class RepeaterParser {
    private static JsonReader$Options NAMES = JsonReader$Options.of("nm", "c", "o", "tr", "hd");

    private RepeaterParser() {
    }

    public static Repeater parse(JsonReader object, LottieComposition lottieComposition) {
        int n10 = 0;
        JsonReader$Options jsonReader$Options = null;
        boolean bl2 = false;
        String string2 = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableTransform animatableTransform = null;
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
                                ((JsonReader)object).skipValue();
                                continue;
                            }
                            bl2 = ((JsonReader)object).nextBoolean();
                            continue;
                        }
                        animatableTransform = AnimatableTransformParser.parse((JsonReader)object, lottieComposition);
                        continue;
                    }
                    animatableFloatValue2 = AnimatableValueParser.parseFloat((JsonReader)object, lottieComposition, false);
                    continue;
                }
                animatableFloatValue = AnimatableValueParser.parseFloat((JsonReader)object, lottieComposition, false);
                continue;
            }
            string2 = ((JsonReader)object).nextString();
        }
        object = new Repeater(string2, animatableFloatValue, animatableFloatValue2, animatableTransform, bl2);
        return object;
    }
}

