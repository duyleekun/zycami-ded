/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.net.URI;
import java.net.URISyntaxException;

public class TypeAdapters$22
extends TypeAdapter {
    public URI read(JsonReader object) {
        URI uRI;
        block6: {
            Object object2 = ((JsonReader)object).peek();
            JsonToken jsonToken = JsonToken.NULL;
            uRI = null;
            if (object2 == jsonToken) {
                ((JsonReader)object).nextNull();
                return null;
            }
            try {
                object = ((JsonReader)object).nextString();
                object2 = "null";
            }
            catch (URISyntaxException uRISyntaxException) {
                object2 = new JsonIOException(uRISyntaxException);
                throw object2;
            }
            boolean bl2 = ((String)object2).equals(object);
            if (bl2) break block6;
            uRI = new URI((String)object);
        }
        return uRI;
    }

    public void write(JsonWriter jsonWriter, URI object) {
        object = object == null ? null : ((URI)object).toASCIIString();
        jsonWriter.value((String)object);
    }
}

