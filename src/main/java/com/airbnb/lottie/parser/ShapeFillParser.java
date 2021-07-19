/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Path$FillType
 */
package com.airbnb.lottie.parser;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.parser.AnimatableValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Options;
import java.util.Collections;
import java.util.List;

public class ShapeFillParser {
    private static final JsonReader$Options NAMES = JsonReader$Options.of("nm", "c", "o", "fillEnabled", "r", "hd");

    private ShapeFillParser() {
    }

    public static ShapeFill parse(JsonReader object, LottieComposition list) {
        Object object2;
        Object object3;
        int n10;
        int n11 = 1;
        int n12 = 0;
        Object object4 = null;
        boolean bl2 = false;
        boolean bl3 = false;
        int n13 = n11;
        String string2 = null;
        AnimatableColorValue animatableColorValue = null;
        while ((n10 = ((JsonReader)object).hasNext()) != 0) {
            object3 = NAMES;
            n10 = ((JsonReader)object).selectName((JsonReader$Options)object3);
            if (n10 != 0) {
                if (n10 != n11) {
                    int n14 = 2;
                    if (n10 != n14) {
                        n14 = 3;
                        if (n10 != n14) {
                            n14 = 4;
                            if (n10 != n14) {
                                n14 = 5;
                                if (n10 != n14) {
                                    ((JsonReader)object).skipName();
                                    ((JsonReader)object).skipValue();
                                    continue;
                                }
                                bl3 = ((JsonReader)object).nextBoolean();
                                continue;
                            }
                            n13 = ((JsonReader)object).nextInt();
                            continue;
                        }
                        bl2 = ((JsonReader)object).nextBoolean();
                        continue;
                    }
                    object4 = AnimatableValueParser.parseInteger((JsonReader)object, list);
                    continue;
                }
                animatableColorValue = AnimatableValueParser.parseColor((JsonReader)object, (LottieComposition)((Object)list));
                continue;
            }
            string2 = ((JsonReader)object).nextString();
        }
        if (object4 == null) {
            n12 = 100;
            object4 = n12;
            list = new List<Object>(object4);
            list = Collections.singletonList(list);
            object2 = object = new AnimatableIntegerValue(list);
        } else {
            object2 = object4;
        }
        object = n13 == n11 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
        Object object5 = object;
        object3 = object;
        object = new ShapeFill(string2, bl2, (Path.FillType)object5, animatableColorValue, (AnimatableIntegerValue)object2, bl3);
        return object;
    }
}

