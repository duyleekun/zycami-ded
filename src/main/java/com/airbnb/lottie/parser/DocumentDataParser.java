/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.DocumentData$Justification;
import com.airbnb.lottie.parser.JsonUtils;
import com.airbnb.lottie.parser.ValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Options;

public class DocumentDataParser
implements ValueParser {
    public static final DocumentDataParser INSTANCE;
    private static final JsonReader$Options NAMES;

    static {
        DocumentDataParser documentDataParser;
        INSTANCE = documentDataParser = new DocumentDataParser();
        NAMES = JsonReader$Options.of("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");
    }

    private DocumentDataParser() {
    }

    public DocumentData parse(JsonReader jsonReader, float f10) {
        int n10;
        Object object = DocumentData$Justification.CENTER;
        jsonReader.beginObject();
        int n11 = 0;
        DocumentData$Justification[] documentData$JustificationArray = null;
        boolean bl2 = true;
        DocumentData$Justification documentData$Justification = object;
        String string2 = null;
        String string3 = null;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        boolean bl3 = bl2;
        block13: while ((n10 = jsonReader.hasNext()) != 0) {
            object = NAMES;
            n10 = jsonReader.selectName((JsonReader$Options)object);
            switch (n10) {
                default: {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    continue block13;
                }
                case 10: {
                    bl3 = jsonReader.nextBoolean();
                    continue block13;
                }
                case 9: {
                    double d10 = jsonReader.nextDouble();
                    f14 = (float)d10;
                    continue block13;
                }
                case 8: {
                    n14 = JsonUtils.jsonToColor(jsonReader);
                    continue block13;
                }
                case 7: {
                    n13 = JsonUtils.jsonToColor(jsonReader);
                    continue block13;
                }
                case 6: {
                    double d10 = jsonReader.nextDouble();
                    f13 = (float)d10;
                    continue block13;
                }
                case 5: {
                    double d10 = jsonReader.nextDouble();
                    f12 = (float)d10;
                    continue block13;
                }
                case 4: {
                    n12 = jsonReader.nextInt();
                    continue block13;
                }
                case 3: {
                    n10 = jsonReader.nextInt();
                    if (n10 > (n11 = (documentData$Justification = DocumentData$Justification.CENTER).ordinal()) || n10 < 0) continue block13;
                    documentData$JustificationArray = DocumentData$Justification.values();
                    documentData$Justification = documentData$JustificationArray[n10];
                    continue block13;
                }
                case 2: {
                    double d10 = jsonReader.nextDouble();
                    f11 = (float)d10;
                    continue block13;
                }
                case 1: {
                    string3 = jsonReader.nextString();
                    continue block13;
                }
                case 0: 
            }
            string2 = jsonReader.nextString();
        }
        jsonReader.endObject();
        object = new DocumentData(string2, string3, f11, documentData$Justification, n12, f12, f13, n13, n14, f14, bl3);
        return object;
    }
}

