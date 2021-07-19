/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Path$FillType
 */
package com.airbnb.lottie.parser;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Options;
import java.util.Collections;
import java.util.List;

public class GradientFillParser {
    private static final JsonReader$Options GRADIENT_NAMES;
    private static final JsonReader$Options NAMES;

    static {
        NAMES = JsonReader$Options.of("nm", "g", "o", "t", "s", "e", "r", "hd");
        GRADIENT_NAMES = JsonReader$Options.of("p", "k");
    }

    private GradientFillParser() {
    }

    public static GradientFill parse(JsonReader object, LottieComposition list) {
        Object object2;
        Object object3;
        int n10;
        Object object4 = Path.FillType.WINDING;
        AnimatableIntegerValue animatableIntegerValue = null;
        int n11 = 0;
        Path.FillType fillType = object4;
        String string2 = null;
        Object object5 = null;
        AnimatableGradientColorValue animatableGradientColorValue = null;
        AnimatablePointValue animatablePointValue = null;
        AnimatablePointValue animatablePointValue2 = null;
        boolean bl2 = false;
        block10: while ((n10 = ((JsonReader)object).hasNext()) != 0) {
            object4 = NAMES;
            n10 = ((JsonReader)object).selectName((JsonReader$Options)object4);
            n11 = 1;
            switch (n10) {
                default: {
                    ((JsonReader)object).skipName();
                    ((JsonReader)object).skipValue();
                    continue block10;
                }
                case 7: {
                    bl2 = ((JsonReader)object).nextBoolean();
                    continue block10;
                }
                case 6: {
                    n10 = ((JsonReader)object).nextInt();
                    object4 = n10 == n11 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    fillType = object4;
                    continue block10;
                }
                case 5: {
                    animatablePointValue2 = AnimatableValueParser.parsePoint((JsonReader)object, (LottieComposition)((Object)list));
                    continue block10;
                }
                case 4: {
                    animatablePointValue = AnimatableValueParser.parsePoint((JsonReader)object, (LottieComposition)((Object)list));
                    continue block10;
                }
                case 3: {
                    n10 = ((JsonReader)object).nextInt();
                    object4 = n10 == n11 ? GradientType.LINEAR : GradientType.RADIAL;
                    object5 = object4;
                    continue block10;
                }
                case 2: {
                    animatableIntegerValue = AnimatableValueParser.parseInteger((JsonReader)object, (LottieComposition)((Object)list));
                    continue block10;
                }
                case 1: {
                    int n12;
                    n10 = -1;
                    ((JsonReader)object).beginObject();
                    while ((n12 = ((JsonReader)object).hasNext()) != 0) {
                        object3 = GRADIENT_NAMES;
                        n12 = ((JsonReader)object).selectName((JsonReader$Options)object3);
                        if (n12 != 0) {
                            if (n12 != n11) {
                                ((JsonReader)object).skipName();
                                ((JsonReader)object).skipValue();
                                continue;
                            }
                            animatableGradientColorValue = AnimatableValueParser.parseGradientColor((JsonReader)object, list, n10);
                            continue;
                        }
                        n10 = ((JsonReader)object).nextInt();
                    }
                    ((JsonReader)object).endObject();
                    continue block10;
                }
                case 0: 
            }
            string2 = ((JsonReader)object).nextString();
        }
        if (animatableIntegerValue == null) {
            n10 = 100;
            object4 = n10;
            list = new List<Object>(object4);
            list = Collections.singletonList(list);
            object2 = object = new AnimatableIntegerValue(list);
        } else {
            object2 = animatableIntegerValue;
        }
        object3 = object;
        object = new GradientFill(string2, (GradientType)((Object)object5), fillType, animatableGradientColorValue, (AnimatableIntegerValue)object2, animatablePointValue, animatablePointValue2, null, null, bl2);
        return object;
    }
}

