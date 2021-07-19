/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.bind.JsonTreeReader$1;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public final class JsonTreeReader
extends JsonReader {
    private static final Object SENTINEL_CLOSED;
    private static final Reader UNREADABLE_READER;
    private int[] pathIndices;
    private String[] pathNames;
    private Object[] stack;
    private int stackSize;

    static {
        Object object = new JsonTreeReader$1();
        UNREADABLE_READER = object;
        SENTINEL_CLOSED = object = new Object();
    }

    public JsonTreeReader(JsonElement jsonElement) {
        Object object = UNREADABLE_READER;
        super((Reader)object);
        int n10 = 32;
        Object[] objectArray = new Object[n10];
        this.stack = objectArray;
        this.stackSize = 0;
        objectArray = new String[n10];
        this.pathNames = objectArray;
        object = new int[n10];
        this.pathIndices = (int[])object;
        this.push(jsonElement);
    }

    private void expect(JsonToken object) {
        Object object2 = this.peek();
        if (object2 == object) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected ");
        stringBuilder.append(object);
        stringBuilder.append(" but was ");
        object = this.peek();
        stringBuilder.append(object);
        object = this.locationString();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }

    private String locationString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" at path ");
        String string2 = this.getPath();
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    private Object peekStack() {
        Object[] objectArray = this.stack;
        int n10 = this.stackSize + -1;
        return objectArray[n10];
    }

    private Object popStack() {
        int n10;
        Object[] objectArray = this.stack;
        this.stackSize = n10 = this.stackSize + -1;
        Object object = objectArray[n10];
        objectArray[n10] = null;
        return object;
    }

    private void push(Object object) {
        Object[] objectArray;
        int n10 = this.stackSize;
        Object[] objectArray2 = this.stack;
        int n11 = objectArray2.length;
        if (n10 == n11) {
            this.stack = objectArray2 = Arrays.copyOf(objectArray2, n10 *= 2);
            objectArray2 = Arrays.copyOf(this.pathIndices, n10);
            this.pathIndices = (int[])objectArray2;
            objectArray2 = this.pathNames;
            objectArray = (String[])Arrays.copyOf(objectArray2, n10);
            this.pathNames = objectArray;
        }
        objectArray = this.stack;
        int n12 = this.stackSize;
        this.stackSize = n11 = n12 + 1;
        objectArray[n12] = object;
    }

    public void beginArray() {
        Object object = JsonToken.BEGIN_ARRAY;
        this.expect((JsonToken)((Object)object));
        object = ((JsonArray)this.peekStack()).iterator();
        this.push(object);
        object = this.pathIndices;
        int n10 = this.stackSize + -1;
        object[n10] = (JsonToken)false;
    }

    public void beginObject() {
        Object object = JsonToken.BEGIN_OBJECT;
        this.expect((JsonToken)((Object)object));
        object = ((JsonObject)this.peekStack()).entrySet().iterator();
        this.push(object);
    }

    public void close() {
        Object object;
        int n10 = 1;
        Object[] objectArray = new Object[n10];
        objectArray[0] = object = SENTINEL_CLOSED;
        this.stack = objectArray;
        this.stackSize = n10;
    }

    public void endArray() {
        JsonToken jsonToken = JsonToken.END_ARRAY;
        this.expect(jsonToken);
        this.popStack();
        this.popStack();
        int n10 = this.stackSize;
        if (n10 > 0) {
            int n11;
            int[] nArray = this.pathIndices;
            nArray[n10 += -1] = n11 = nArray[n10] + 1;
        }
    }

    public void endObject() {
        JsonToken jsonToken = JsonToken.END_OBJECT;
        this.expect(jsonToken);
        this.popStack();
        this.popStack();
        int n10 = this.stackSize;
        if (n10 > 0) {
            int n11;
            int[] nArray = this.pathIndices;
            nArray[n10 += -1] = n11 = nArray[n10] + 1;
        }
    }

    public String getPath() {
        char c10;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('$');
        for (int i10 = 0; i10 < (c10 = this.stackSize); ++i10) {
            Object object = this.stack;
            Object object2 = object[i10];
            boolean bl2 = object2 instanceof JsonArray;
            if (bl2) {
                if ((c10 = (object = object[++i10]) instanceof Iterator) == 0) continue;
                stringBuilder.append('[');
                object = this.pathIndices;
                c10 = (char)object[i10];
                stringBuilder.append((int)c10);
                c10 = (char)93;
                stringBuilder.append(c10);
                continue;
            }
            object2 = object[i10];
            bl2 = object2 instanceof JsonObject;
            if (!bl2 || (c10 = (object = object[++i10]) instanceof Iterator) == 0) continue;
            c10 = '.';
            stringBuilder.append(c10);
            object = this.pathNames;
            object2 = object[i10];
            if (object2 == null) continue;
            object = object[i10];
            stringBuilder.append((String)object);
        }
        return stringBuilder.toString();
    }

    public boolean hasNext() {
        boolean bl2;
        JsonToken jsonToken;
        JsonToken jsonToken2 = this.peek();
        if (jsonToken2 != (jsonToken = JsonToken.END_OBJECT) && jsonToken2 != (jsonToken = JsonToken.END_ARRAY)) {
            bl2 = true;
        } else {
            bl2 = false;
            jsonToken2 = null;
        }
        return bl2;
    }

    public boolean nextBoolean() {
        Object object = JsonToken.BOOLEAN;
        this.expect((JsonToken)((Object)object));
        object = (JsonPrimitive)this.popStack();
        boolean bl2 = ((JsonPrimitive)object).getAsBoolean();
        int n10 = this.stackSize;
        if (n10 > 0) {
            int n11;
            int[] nArray = this.pathIndices;
            nArray[n10 += -1] = n11 = nArray[n10] + 1;
        }
        return bl2;
    }

    public double nextDouble() {
        Object object;
        JsonToken jsonToken;
        Object object2 = this.peek();
        if (object2 != (jsonToken = JsonToken.NUMBER) && object2 != (object = JsonToken.STRING)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected ");
            stringBuilder.append((Object)jsonToken);
            stringBuilder.append(" but was ");
            stringBuilder.append(object2);
            object2 = this.locationString();
            stringBuilder.append((String)object2);
            object2 = stringBuilder.toString();
            object = new IllegalStateException((String)object2);
            throw object;
        }
        object2 = (JsonPrimitive)this.peekStack();
        double d10 = ((JsonPrimitive)object2).getAsDouble();
        int n10 = this.isLenient();
        if (n10 == 0 && ((n10 = Double.isNaN(d10)) != 0 || (n10 = (int)(Double.isInfinite(d10) ? 1 : 0)) != 0)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("JSON forbids NaN and infinities: ");
            stringBuilder.append(d10);
            object2 = stringBuilder.toString();
            object = new NumberFormatException((String)object2);
            throw object;
        }
        this.popStack();
        n10 = this.stackSize;
        if (n10 > 0) {
            int n11;
            int[] nArray = this.pathIndices;
            nArray[n10 += -1] = n11 = nArray[n10] + 1;
        }
        return d10;
    }

    public int nextInt() {
        Object object;
        JsonToken jsonToken;
        Object object2 = this.peek();
        if (object2 != (jsonToken = JsonToken.NUMBER) && object2 != (object = JsonToken.STRING)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected ");
            stringBuilder.append((Object)jsonToken);
            stringBuilder.append(" but was ");
            stringBuilder.append(object2);
            object2 = this.locationString();
            stringBuilder.append((String)object2);
            object2 = stringBuilder.toString();
            object = new IllegalStateException((String)object2);
            throw object;
        }
        object2 = (JsonPrimitive)this.peekStack();
        int n10 = ((JsonPrimitive)object2).getAsInt();
        this.popStack();
        int n11 = this.stackSize;
        if (n11 > 0) {
            reference var7_7;
            object = this.pathIndices;
            object[n11 += -1] = var7_7 = object[n11] + true;
        }
        return n10;
    }

    public long nextLong() {
        Object object;
        JsonToken jsonToken;
        Object object2 = this.peek();
        if (object2 != (jsonToken = JsonToken.NUMBER) && object2 != (object = JsonToken.STRING)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected ");
            stringBuilder.append((Object)jsonToken);
            stringBuilder.append(" but was ");
            stringBuilder.append(object2);
            object2 = this.locationString();
            stringBuilder.append((String)object2);
            object2 = stringBuilder.toString();
            object = new IllegalStateException((String)object2);
            throw object;
        }
        object2 = (JsonPrimitive)this.peekStack();
        long l10 = ((JsonPrimitive)object2).getAsLong();
        this.popStack();
        int n10 = this.stackSize;
        if (n10 > 0) {
            int n11;
            int[] nArray = this.pathIndices;
            nArray[n10 += -1] = n11 = nArray[n10] + 1;
        }
        return l10;
    }

    public String nextName() {
        Object object = JsonToken.NAME;
        this.expect((JsonToken)((Object)object));
        object = (Map.Entry)((Iterator)this.peekStack()).next();
        String string2 = (String)object.getKey();
        String[] stringArray = this.pathNames;
        int n10 = this.stackSize + -1;
        stringArray[n10] = string2;
        object = object.getValue();
        this.push(object);
        return string2;
    }

    public void nextNull() {
        JsonToken jsonToken = JsonToken.NULL;
        this.expect(jsonToken);
        this.popStack();
        int n10 = this.stackSize;
        if (n10 > 0) {
            int n11;
            int[] nArray = this.pathIndices;
            nArray[n10 += -1] = n11 = nArray[n10] + 1;
        }
    }

    public String nextString() {
        Object object;
        JsonToken jsonToken;
        Object object2 = this.peek();
        if (object2 != (jsonToken = JsonToken.STRING) && object2 != (object = JsonToken.NUMBER)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected ");
            stringBuilder.append((Object)jsonToken);
            stringBuilder.append(" but was ");
            stringBuilder.append(object2);
            object2 = this.locationString();
            stringBuilder.append((String)object2);
            object2 = stringBuilder.toString();
            object = new IllegalStateException((String)object2);
            throw object;
        }
        object2 = ((JsonPrimitive)this.popStack()).getAsString();
        int n10 = this.stackSize;
        if (n10 > 0) {
            reference var6_6;
            object = this.pathIndices;
            object[n10 += -1] = var6_6 = object[n10] + true;
        }
        return object2;
    }

    public JsonToken peek() {
        int n10 = this.stackSize;
        if (n10 == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object object = this.peekStack();
        boolean bl2 = object instanceof Iterator;
        if (bl2) {
            Object object2 = this.stack;
            int n11 = this.stackSize + -2;
            object2 = object2[n11];
            bl2 = object2 instanceof JsonObject;
            n11 = (int)((object = (Iterator)object).hasNext() ? 1 : 0);
            if (n11 != 0) {
                if (bl2) {
                    return JsonToken.NAME;
                }
                object = object.next();
                this.push(object);
                return this.peek();
            }
            object = bl2 ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            return object;
        }
        bl2 = object instanceof JsonObject;
        if (bl2) {
            return JsonToken.BEGIN_OBJECT;
        }
        bl2 = object instanceof JsonArray;
        if (bl2) {
            return JsonToken.BEGIN_ARRAY;
        }
        bl2 = object instanceof JsonPrimitive;
        if (bl2) {
            bl2 = ((JsonPrimitive)(object = (JsonPrimitive)object)).isString();
            if (bl2) {
                return JsonToken.STRING;
            }
            bl2 = ((JsonPrimitive)object).isBoolean();
            if (bl2) {
                return JsonToken.BOOLEAN;
            }
            n10 = (int)(((JsonPrimitive)object).isNumber() ? 1 : 0);
            if (n10 != 0) {
                return JsonToken.NUMBER;
            }
            object = new AssertionError();
            throw object;
        }
        bl2 = object instanceof JsonNull;
        if (bl2) {
            return JsonToken.NULL;
        }
        Object object3 = SENTINEL_CLOSED;
        if (object == object3) {
            object = new IllegalStateException("JsonReader is closed");
            throw object;
        }
        object = new AssertionError();
        throw object;
    }

    public void promoteNameToValue() {
        Object object = JsonToken.NAME;
        this.expect((JsonToken)((Object)object));
        object = (Map.Entry)((Iterator)this.peekStack()).next();
        Object object2 = object.getValue();
        this.push(object2);
        object = (String)object.getKey();
        object2 = new Object((String)object);
        this.push(object2);
    }

    public void skipValue() {
        int n10;
        String[] stringArray = this.peek();
        Object[] objectArray = JsonToken.NAME;
        String string2 = "null";
        if (stringArray == objectArray) {
            this.nextName();
            stringArray = this.pathNames;
            int n11 = this.stackSize + -2;
            stringArray[n11] = string2;
        } else {
            this.popStack();
            n10 = this.stackSize;
            if (n10 > 0) {
                objectArray = this.pathNames;
                objectArray[n10 += -1] = string2;
            }
        }
        n10 = this.stackSize;
        if (n10 > 0) {
            reference var6_6;
            objectArray = this.pathIndices;
            objectArray[n10 += -1] = var6_6 = objectArray[n10] + true;
        }
    }

    public String toString() {
        return JsonTreeReader.class.getSimpleName();
    }
}

