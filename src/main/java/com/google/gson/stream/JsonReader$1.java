/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

public class JsonReader$1
extends JsonReaderInternalAccess {
    public void promoteNameToValue(JsonReader object) {
        block8: {
            block6: {
                int n10;
                int n11;
                block7: {
                    block5: {
                        n11 = object instanceof JsonTreeReader;
                        if (n11 != 0) {
                            ((JsonTreeReader)object).promoteNameToValue();
                            return;
                        }
                        n11 = ((JsonReader)object).peeked;
                        if (n11 == 0) {
                            n11 = ((JsonReader)object).doPeek();
                        }
                        if (n11 != (n10 = 13)) break block5;
                        ((JsonReader)object).peeked = n11 = 9;
                        break block6;
                    }
                    n10 = 12;
                    if (n11 != n10) break block7;
                    ((JsonReader)object).peeked = n11 = 8;
                    break block6;
                }
                n10 = 14;
                if (n11 != n10) break block8;
                ((JsonReader)object).peeked = n11 = 10;
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a name but was ");
        JsonToken jsonToken = ((JsonReader)object).peek();
        stringBuilder.append((Object)jsonToken);
        object = ((JsonReader)object).locationString();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }
}

