/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.model.content.MergePaths$MergePathsMode;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Options;

public class MergePathsParser {
    private static final JsonReader$Options NAMES = JsonReader$Options.of("nm", "mm", "hd");

    private MergePathsParser() {
    }

    public static MergePaths parse(JsonReader object) {
        int n10;
        String string2 = null;
        boolean bl2 = false;
        int n11 = 0;
        MergePaths$MergePathsMode mergePaths$MergePathsMode = null;
        while ((n10 = ((JsonReader)object).hasNext()) != 0) {
            JsonReader$Options jsonReader$Options = NAMES;
            n10 = ((JsonReader)object).selectName(jsonReader$Options);
            if (n10 != 0) {
                int n12 = 1;
                if (n10 != n12) {
                    n12 = 2;
                    if (n10 != n12) {
                        ((JsonReader)object).skipName();
                        ((JsonReader)object).skipValue();
                        continue;
                    }
                    bl2 = ((JsonReader)object).nextBoolean();
                    continue;
                }
                n11 = ((JsonReader)object).nextInt();
                mergePaths$MergePathsMode = MergePaths$MergePathsMode.forId(n11);
                continue;
            }
            string2 = ((JsonReader)object).nextString();
        }
        object = new MergePaths(string2, mergePaths$MergePathsMode, bl2);
        return object;
    }
}

