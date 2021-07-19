/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser.moshi;

import com.airbnb.lottie.parser.moshi.JsonReader;
import h.c0;
import h.m;
import h.n;
import java.io.IOException;
import okio.ByteString;

public final class JsonReader$Options {
    public final c0 doubleQuoteSuffix;
    public final String[] strings;

    private JsonReader$Options(String[] stringArray, c0 c02) {
        this.strings = stringArray;
        this.doubleQuoteSuffix = c02;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static JsonReader$Options of(String ... stringArray) {
        try {
            int n10 = stringArray.length;
            ByteString[] byteStringArray = new ByteString[n10];
            Object object = new m();
            int n11 = 0;
            while (true) {
                int n12;
                if (n11 >= (n12 = stringArray.length)) {
                    stringArray = stringArray.clone();
                    c0 c02 = c0.j(byteStringArray);
                    return new JsonReader$Options(stringArray, c02);
                }
                Object object2 = stringArray[n11];
                JsonReader.access$000((n)object, (String)object2);
                ((m)object).readByte();
                byteStringArray[n11] = object2 = ((m)object).b0();
                ++n11;
            }
        }
        catch (IOException iOException) {
            AssertionError assertionError = new AssertionError((Object)iOException);
            throw assertionError;
        }
    }
}

