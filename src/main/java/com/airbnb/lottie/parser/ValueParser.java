/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;

public interface ValueParser {
    public Object parse(JsonReader var1, float var2);
}

