/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.PolystarShape$Type;
import com.airbnb.lottie.parser.AnimatablePathValueParser;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Options;

public class PolystarShapeParser {
    private static final JsonReader$Options NAMES = JsonReader$Options.of("nm", "sy", "pt", "p", "r", "or", "os", "ir", "is", "hd");

    private PolystarShapeParser() {
    }

    public static PolystarShape parse(JsonReader object, LottieComposition lottieComposition) {
        int n10 = 0;
        JsonReader$Options jsonReader$Options = null;
        boolean bl2 = false;
        String string2 = null;
        PolystarShape$Type polystarShape$Type = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableValue animatableValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableFloatValue animatableFloatValue3 = null;
        AnimatableFloatValue animatableFloatValue4 = null;
        AnimatableFloatValue animatableFloatValue5 = null;
        AnimatableFloatValue animatableFloatValue6 = null;
        block12: while ((n10 = ((JsonReader)object).hasNext()) != 0) {
            jsonReader$Options = NAMES;
            n10 = ((JsonReader)object).selectName(jsonReader$Options);
            switch (n10) {
                default: {
                    ((JsonReader)object).skipName();
                    ((JsonReader)object).skipValue();
                    continue block12;
                }
                case 9: {
                    bl2 = ((JsonReader)object).nextBoolean();
                    continue block12;
                }
                case 8: {
                    animatableFloatValue5 = AnimatableValueParser.parseFloat((JsonReader)object, lottieComposition, false);
                    continue block12;
                }
                case 7: {
                    animatableFloatValue3 = AnimatableValueParser.parseFloat((JsonReader)object, lottieComposition);
                    continue block12;
                }
                case 6: {
                    animatableFloatValue6 = AnimatableValueParser.parseFloat((JsonReader)object, lottieComposition, false);
                    continue block12;
                }
                case 5: {
                    animatableFloatValue4 = AnimatableValueParser.parseFloat((JsonReader)object, lottieComposition);
                    continue block12;
                }
                case 4: {
                    animatableFloatValue2 = AnimatableValueParser.parseFloat((JsonReader)object, lottieComposition, false);
                    continue block12;
                }
                case 3: {
                    animatableValue = AnimatablePathValueParser.parseSplitPath((JsonReader)object, lottieComposition);
                    continue block12;
                }
                case 2: {
                    animatableFloatValue = AnimatableValueParser.parseFloat((JsonReader)object, lottieComposition, false);
                    continue block12;
                }
                case 1: {
                    n10 = ((JsonReader)object).nextInt();
                    polystarShape$Type = PolystarShape$Type.forValue(n10);
                    continue block12;
                }
                case 0: 
            }
            string2 = ((JsonReader)object).nextString();
        }
        object = new PolystarShape(string2, polystarShape$Type, animatableFloatValue, animatableValue, animatableFloatValue2, animatableFloatValue3, animatableFloatValue4, animatableFloatValue5, animatableFloatValue6, bl2);
        return object;
    }
}

