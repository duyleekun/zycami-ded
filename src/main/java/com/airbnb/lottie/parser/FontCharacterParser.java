/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.ContentModelParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Options;
import java.util.ArrayList;

public class FontCharacterParser {
    private static final JsonReader$Options DATA_NAMES;
    private static final JsonReader$Options NAMES;

    static {
        NAMES = JsonReader$Options.of("ch", "size", "w", "style", "fFamily", "data");
        DATA_NAMES = JsonReader$Options.of("shapes");
    }

    private FontCharacterParser() {
    }

    public static FontCharacter parse(JsonReader object, LottieComposition lottieComposition) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        ((JsonReader)object).beginObject();
        int n10 = 0;
        Object object2 = null;
        double d10 = 0.0;
        String string2 = null;
        String string3 = null;
        double d11 = d10;
        double d12 = d10;
        char c10 = '\u0000';
        while ((n10 = ((JsonReader)object).hasNext()) != 0) {
            object2 = NAMES;
            n10 = ((JsonReader)object).selectName((JsonReader$Options)object2);
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
                                    ((JsonReader)object).skipName();
                                    ((JsonReader)object).skipValue();
                                    continue;
                                }
                                ((JsonReader)object).beginObject();
                                while ((n10 = (int)(((JsonReader)object).hasNext() ? 1 : 0)) != 0) {
                                    object2 = DATA_NAMES;
                                    n10 = ((JsonReader)object).selectName((JsonReader$Options)object2);
                                    if (n10 != 0) {
                                        ((JsonReader)object).skipName();
                                        ((JsonReader)object).skipValue();
                                        continue;
                                    }
                                    ((JsonReader)object).beginArray();
                                    while ((n10 = (int)(((JsonReader)object).hasNext() ? 1 : 0)) != 0) {
                                        object2 = (ShapeGroup)ContentModelParser.parse((JsonReader)object, lottieComposition);
                                        arrayList.add(object2);
                                    }
                                    ((JsonReader)object).endArray();
                                }
                                ((JsonReader)object).endObject();
                                continue;
                            }
                            string3 = ((JsonReader)object).nextString();
                            continue;
                        }
                        string2 = ((JsonReader)object).nextString();
                        continue;
                    }
                    d12 = ((JsonReader)object).nextDouble();
                    continue;
                }
                d11 = ((JsonReader)object).nextDouble();
                continue;
            }
            object2 = ((JsonReader)object).nextString();
            c10 = ((String)object2).charAt(0);
        }
        ((JsonReader)object).endObject();
        object2 = object;
        double d13 = d11;
        d11 = d12;
        object = new FontCharacter(arrayList, c10, d13, d12, string2, string3);
        return object;
    }
}

