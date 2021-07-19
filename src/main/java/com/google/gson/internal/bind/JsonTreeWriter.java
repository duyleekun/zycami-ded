/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.bind.JsonTreeWriter$1;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class JsonTreeWriter
extends JsonWriter {
    private static final JsonPrimitive SENTINEL_CLOSED;
    private static final Writer UNWRITABLE_WRITER;
    private String pendingName;
    private JsonElement product;
    private final List stack;

    static {
        Object object = new JsonTreeWriter$1();
        UNWRITABLE_WRITER = object;
        SENTINEL_CLOSED = object = new JsonPrimitive("closed");
    }

    public JsonTreeWriter() {
        Object object = UNWRITABLE_WRITER;
        super((Writer)object);
        object = new ArrayList();
        this.stack = object;
        this.product = object = JsonNull.INSTANCE;
    }

    private JsonElement peek() {
        List list = this.stack;
        int n10 = list.size() + -1;
        return (JsonElement)list.get(n10);
    }

    private void put(JsonElement object) {
        block7: {
            block5: {
                Object object2;
                block6: {
                    block4: {
                        object2 = this.pendingName;
                        if (object2 == null) break block4;
                        boolean bl2 = ((JsonElement)object).isJsonNull();
                        if (!bl2 || (bl2 = this.getSerializeNulls())) {
                            object2 = (JsonObject)this.peek();
                            String string2 = this.pendingName;
                            ((JsonObject)object2).add(string2, (JsonElement)object);
                        }
                        object = null;
                        this.pendingName = null;
                        break block5;
                    }
                    object2 = this.stack;
                    boolean bl3 = object2.isEmpty();
                    if (!bl3) break block6;
                    this.product = object;
                    break block5;
                }
                object2 = this.peek();
                boolean bl4 = object2 instanceof JsonArray;
                if (!bl4) break block7;
                object2 = (JsonArray)object2;
                ((JsonArray)object2).add((JsonElement)object);
            }
            return;
        }
        object = new IllegalStateException();
        throw object;
    }

    public JsonWriter beginArray() {
        JsonArray jsonArray = new JsonArray();
        this.put(jsonArray);
        this.stack.add(jsonArray);
        return this;
    }

    public JsonWriter beginObject() {
        JsonObject jsonObject = new JsonObject();
        this.put(jsonObject);
        this.stack.add(jsonObject);
        return this;
    }

    public void close() {
        Object object = this.stack;
        boolean bl2 = object.isEmpty();
        if (bl2) {
            object = this.stack;
            JsonPrimitive jsonPrimitive = SENTINEL_CLOSED;
            object.add(jsonPrimitive);
            return;
        }
        object = new IOException("Incomplete document");
        throw object;
    }

    public JsonWriter endArray() {
        Object object = this.stack;
        boolean bl2 = object.isEmpty();
        if (!bl2 && (object = this.pendingName) == null) {
            object = this.peek();
            bl2 = object instanceof JsonArray;
            if (bl2) {
                object = this.stack;
                int n10 = object.size() + -1;
                object.remove(n10);
                return this;
            }
            object = new IllegalStateException();
            throw object;
        }
        object = new IllegalStateException();
        throw object;
    }

    public JsonWriter endObject() {
        Object object = this.stack;
        boolean bl2 = object.isEmpty();
        if (!bl2 && (object = this.pendingName) == null) {
            object = this.peek();
            bl2 = object instanceof JsonObject;
            if (bl2) {
                object = this.stack;
                int n10 = object.size() + -1;
                object.remove(n10);
                return this;
            }
            object = new IllegalStateException();
            throw object;
        }
        object = new IllegalStateException();
        throw object;
    }

    public void flush() {
    }

    public JsonElement get() {
        Object object = this.stack;
        boolean bl2 = object.isEmpty();
        if (bl2) {
            return this.product;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Expected one JSON element but was ");
        List list = this.stack;
        charSequence.append(list);
        charSequence = charSequence.toString();
        object = new IllegalStateException((String)charSequence);
        throw object;
    }

    public JsonWriter name(String object) {
        Objects.requireNonNull(object, "name == null");
        Object object2 = this.stack;
        boolean bl2 = object2.isEmpty();
        if (!bl2 && (object2 = this.pendingName) == null) {
            object2 = this.peek();
            bl2 = object2 instanceof JsonObject;
            if (bl2) {
                this.pendingName = object;
                return this;
            }
            object = new IllegalStateException();
            throw object;
        }
        object = new IllegalStateException();
        throw object;
    }

    public JsonWriter nullValue() {
        JsonNull jsonNull = JsonNull.INSTANCE;
        this.put(jsonNull);
        return this;
    }

    public JsonWriter value(double d10) {
        boolean bl2 = this.isLenient();
        if (!bl2 && ((bl2 = Double.isNaN(d10)) || (bl2 = Double.isInfinite(d10)))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("JSON forbids NaN and infinities: ");
            stringBuilder.append(d10);
            String string2 = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
            throw illegalArgumentException;
        }
        Double d11 = d10;
        JsonPrimitive jsonPrimitive = new JsonPrimitive(d11);
        this.put(jsonPrimitive);
        return this;
    }

    public JsonWriter value(long l10) {
        Long l11 = l10;
        JsonPrimitive jsonPrimitive = new JsonPrimitive(l11);
        this.put(jsonPrimitive);
        return this;
    }

    public JsonWriter value(Boolean bl2) {
        if (bl2 == null) {
            return this.nullValue();
        }
        JsonPrimitive jsonPrimitive = new JsonPrimitive(bl2);
        this.put(jsonPrimitive);
        return this;
    }

    public JsonWriter value(Number object) {
        double d10;
        boolean bl2;
        if (object == null) {
            return this.nullValue();
        }
        boolean bl3 = this.isLenient();
        if (!bl3 && ((bl2 = Double.isNaN(d10 = ((Number)object).doubleValue())) || (bl3 = Double.isInfinite(d10)))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("JSON forbids NaN and infinities: ");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
        JsonPrimitive jsonPrimitive = new JsonPrimitive((Number)object);
        this.put(jsonPrimitive);
        return this;
    }

    public JsonWriter value(String string2) {
        if (string2 == null) {
            return this.nullValue();
        }
        JsonPrimitive jsonPrimitive = new JsonPrimitive(string2);
        this.put(jsonPrimitive);
        return this;
    }

    public JsonWriter value(boolean bl2) {
        Boolean bl3 = bl2;
        JsonPrimitive jsonPrimitive = new JsonPrimitive(bl3);
        this.put(jsonPrimitive);
        return this;
    }
}

