/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.ContentModelParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Options;
import java.util.ArrayList;

public class ShapeGroupParser {
    private static JsonReader$Options NAMES = JsonReader$Options.of("nm", "hd", "it");

    private ShapeGroupParser() {
    }

    public static ShapeGroup parse(JsonReader object, LottieComposition lottieComposition) {
        int n10;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        String string2 = null;
        boolean bl2 = false;
        while ((n10 = ((JsonReader)object).hasNext()) != 0) {
            Object object2 = NAMES;
            n10 = ((JsonReader)object).selectName((JsonReader$Options)object2);
            if (n10 != 0) {
                int n11 = 1;
                if (n10 != n11) {
                    n11 = 2;
                    if (n10 != n11) {
                        ((JsonReader)object).skipValue();
                        continue;
                    }
                    ((JsonReader)object).beginArray();
                    while ((n10 = (int)(((JsonReader)object).hasNext() ? 1 : 0)) != 0) {
                        object2 = ContentModelParser.parse((JsonReader)object, lottieComposition);
                        if (object2 == null) continue;
                        arrayList.add(object2);
                    }
                    ((JsonReader)object).endArray();
                    continue;
                }
                bl2 = ((JsonReader)object).nextBoolean();
                continue;
            }
            string2 = ((JsonReader)object).nextString();
        }
        object = new ShapeGroup(string2, arrayList, bl2);
        return object;
    }
}

