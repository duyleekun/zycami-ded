/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.JsonUtils;
import com.airbnb.lottie.parser.ValueParser;
import com.airbnb.lottie.parser.moshi.JsonReader;

public class PathParser
implements ValueParser {
    public static final PathParser INSTANCE;

    static {
        PathParser pathParser;
        INSTANCE = pathParser = new PathParser();
    }

    private PathParser() {
    }

    public PointF parse(JsonReader jsonReader, float f10) {
        return JsonUtils.jsonToPoint(jsonReader, f10);
    }
}

