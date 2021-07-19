/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Options;

public class FontParser {
    private static final JsonReader$Options NAMES = JsonReader$Options.of("fFamily", "fName", "fStyle", "ascent");

    private FontParser() {
    }

    public static Font parse(JsonReader object) {
        int n10;
        ((JsonReader)object).beginObject();
        String string2 = null;
        String string3 = null;
        float f10 = 0.0f;
        String string4 = null;
        while ((n10 = ((JsonReader)object).hasNext()) != 0) {
            JsonReader$Options jsonReader$Options = NAMES;
            n10 = ((JsonReader)object).selectName(jsonReader$Options);
            if (n10 != 0) {
                int n11 = 1;
                if (n10 != n11) {
                    n11 = 2;
                    if (n10 != n11) {
                        n11 = 3;
                        if (n10 != n11) {
                            ((JsonReader)object).skipName();
                            ((JsonReader)object).skipValue();
                            continue;
                        }
                        double d10 = ((JsonReader)object).nextDouble();
                        f10 = (float)d10;
                        continue;
                    }
                    string3 = ((JsonReader)object).nextString();
                    continue;
                }
                string4 = ((JsonReader)object).nextString();
                continue;
            }
            string2 = ((JsonReader)object).nextString();
        }
        ((JsonReader)object).endObject();
        object = new Font(string2, string4, string3, f10);
        return object;
    }
}

