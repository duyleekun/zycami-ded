/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$BoundField;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.Iterator;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory$Adapter
extends TypeAdapter {
    private final Map boundFields;
    private final ObjectConstructor constructor;

    public ReflectiveTypeAdapterFactory$Adapter(ObjectConstructor objectConstructor, Map map) {
        this.constructor = objectConstructor;
        this.boundFields = map;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object read(JsonReader jsonReader) {
        Object object;
        JsonToken jsonToken = jsonReader.peek();
        if (jsonToken == (object = JsonToken.NULL)) {
            jsonReader.nextNull();
            return null;
        }
        Object object2 = this.constructor.construct();
        try {
            boolean bl2;
            jsonReader.beginObject();
            while (bl2 = jsonReader.hasNext()) {
                boolean bl3;
                object = jsonReader.nextName();
                Map map = this.boundFields;
                object = map.get(object);
                if ((object = (ReflectiveTypeAdapterFactory$BoundField)object) != null && (bl3 = ((ReflectiveTypeAdapterFactory$BoundField)object).deserialized)) {
                    ((ReflectiveTypeAdapterFactory$BoundField)object).read(jsonReader, object2);
                    continue;
                }
                jsonReader.skipValue();
            }
        }
        catch (IllegalAccessException illegalAccessException) {
            AssertionError assertionError = new AssertionError((Object)illegalAccessException);
            throw assertionError;
        }
        catch (IllegalStateException illegalStateException) {
            JsonSyntaxException jsonSyntaxException = new JsonSyntaxException(illegalStateException);
            throw jsonSyntaxException;
        }
        jsonReader.endObject();
        return object2;
    }

    public void write(JsonWriter jsonWriter, Object object) {
        if (object == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginObject();
        Iterator iterator2 = this.boundFields;
        iterator2 = iterator2.values();
        try {
            iterator2 = iterator2.iterator();
        }
        catch (IllegalAccessException illegalAccessException) {
            object = new AssertionError((Object)illegalAccessException);
            throw object;
        }
        while (true) {
            boolean bl2 = iterator2.hasNext();
            if (!bl2) break;
            Object object2 = iterator2.next();
            object2 = (ReflectiveTypeAdapterFactory$BoundField)object2;
            boolean bl3 = ((ReflectiveTypeAdapterFactory$BoundField)object2).writeField(object);
            if (!bl3) continue;
            String string2 = ((ReflectiveTypeAdapterFactory$BoundField)object2).name;
            jsonWriter.name(string2);
            ((ReflectiveTypeAdapterFactory$BoundField)object2).write(jsonWriter, object);
            continue;
            break;
        }
        jsonWriter.endObject();
        return;
    }
}

