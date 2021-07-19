/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class JsonArray
extends JsonElement
implements Iterable {
    private final List elements;

    public JsonArray() {
        ArrayList arrayList;
        this.elements = arrayList = new ArrayList();
    }

    public JsonArray(int n10) {
        ArrayList arrayList;
        this.elements = arrayList = new ArrayList(n10);
    }

    public void add(JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = JsonNull.INSTANCE;
        }
        this.elements.add(jsonElement);
    }

    public void add(Boolean object) {
        List list = this.elements;
        if (object == null) {
            object = JsonNull.INSTANCE;
        } else {
            JsonPrimitive jsonPrimitive = new JsonPrimitive((Boolean)object);
            object = jsonPrimitive;
        }
        list.add(object);
    }

    public void add(Character object) {
        List list = this.elements;
        if (object == null) {
            object = JsonNull.INSTANCE;
        } else {
            JsonPrimitive jsonPrimitive = new JsonPrimitive((Character)object);
            object = jsonPrimitive;
        }
        list.add(object);
    }

    public void add(Number object) {
        List list = this.elements;
        if (object == null) {
            object = JsonNull.INSTANCE;
        } else {
            JsonPrimitive jsonPrimitive = new JsonPrimitive((Number)object);
            object = jsonPrimitive;
        }
        list.add(object);
    }

    public void add(String object) {
        List list = this.elements;
        if (object == null) {
            object = JsonNull.INSTANCE;
        } else {
            JsonPrimitive jsonPrimitive = new JsonPrimitive((String)object);
            object = jsonPrimitive;
        }
        list.add(object);
    }

    public void addAll(JsonArray iterable) {
        List list = this.elements;
        iterable = iterable.elements;
        list.addAll(iterable);
    }

    public boolean contains(JsonElement jsonElement) {
        return this.elements.contains(jsonElement);
    }

    public JsonArray deepCopy() {
        Iterable iterable = this.elements;
        boolean bl2 = iterable.isEmpty();
        if (!bl2) {
            boolean bl3;
            int n10 = this.elements.size();
            iterable = new Iterable(n10);
            Iterator iterator2 = this.elements.iterator();
            while (bl3 = iterator2.hasNext()) {
                JsonElement jsonElement = ((JsonElement)iterator2.next()).deepCopy();
                ((JsonArray)iterable).add(jsonElement);
            }
            return iterable;
        }
        iterable = new Iterable();
        return iterable;
    }

    public boolean equals(Object object) {
        List list;
        boolean bl2;
        boolean bl3;
        if (!(object == this || (bl3 = object instanceof JsonArray) && (bl2 = (object = ((JsonArray)object).elements).equals(list = this.elements)))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public JsonElement get(int n10) {
        return (JsonElement)this.elements.get(n10);
    }

    public BigDecimal getAsBigDecimal() {
        int n10;
        Object object = this.elements;
        int n11 = object.size();
        if (n11 == (n10 = 1)) {
            return ((JsonElement)this.elements.get(0)).getAsBigDecimal();
        }
        object = new IllegalStateException();
        throw object;
    }

    public BigInteger getAsBigInteger() {
        int n10;
        Object object = this.elements;
        int n11 = object.size();
        if (n11 == (n10 = 1)) {
            return ((JsonElement)this.elements.get(0)).getAsBigInteger();
        }
        object = new IllegalStateException();
        throw object;
    }

    public boolean getAsBoolean() {
        int n10;
        Object object = this.elements;
        int n11 = object.size();
        if (n11 == (n10 = 1)) {
            return ((JsonElement)this.elements.get(0)).getAsBoolean();
        }
        object = new IllegalStateException();
        throw object;
    }

    public byte getAsByte() {
        int n10;
        Object object = this.elements;
        int n11 = object.size();
        if (n11 == (n10 = 1)) {
            return ((JsonElement)this.elements.get(0)).getAsByte();
        }
        object = new IllegalStateException();
        throw object;
    }

    public char getAsCharacter() {
        int n10;
        Object object = this.elements;
        int n11 = object.size();
        if (n11 == (n10 = 1)) {
            return ((JsonElement)this.elements.get(0)).getAsCharacter();
        }
        object = new IllegalStateException();
        throw object;
    }

    public double getAsDouble() {
        int n10;
        Object object = this.elements;
        int n11 = object.size();
        if (n11 == (n10 = 1)) {
            return ((JsonElement)this.elements.get(0)).getAsDouble();
        }
        object = new IllegalStateException();
        throw object;
    }

    public float getAsFloat() {
        int n10;
        Object object = this.elements;
        int n11 = object.size();
        if (n11 == (n10 = 1)) {
            return ((JsonElement)this.elements.get(0)).getAsFloat();
        }
        object = new IllegalStateException();
        throw object;
    }

    public int getAsInt() {
        int n10;
        Object object = this.elements;
        int n11 = object.size();
        if (n11 == (n10 = 1)) {
            return ((JsonElement)this.elements.get(0)).getAsInt();
        }
        object = new IllegalStateException();
        throw object;
    }

    public long getAsLong() {
        int n10;
        Object object = this.elements;
        int n11 = object.size();
        if (n11 == (n10 = 1)) {
            return ((JsonElement)this.elements.get(0)).getAsLong();
        }
        object = new IllegalStateException();
        throw object;
    }

    public Number getAsNumber() {
        int n10;
        Object object = this.elements;
        int n11 = object.size();
        if (n11 == (n10 = 1)) {
            return ((JsonElement)this.elements.get(0)).getAsNumber();
        }
        object = new IllegalStateException();
        throw object;
    }

    public short getAsShort() {
        int n10;
        Object object = this.elements;
        int n11 = object.size();
        if (n11 == (n10 = 1)) {
            return ((JsonElement)this.elements.get(0)).getAsShort();
        }
        object = new IllegalStateException();
        throw object;
    }

    public String getAsString() {
        int n10;
        Object object = this.elements;
        int n11 = object.size();
        if (n11 == (n10 = 1)) {
            return ((JsonElement)this.elements.get(0)).getAsString();
        }
        object = new IllegalStateException();
        throw object;
    }

    public int hashCode() {
        return this.elements.hashCode();
    }

    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    public Iterator iterator() {
        return this.elements.iterator();
    }

    public JsonElement remove(int n10) {
        return (JsonElement)this.elements.remove(n10);
    }

    public boolean remove(JsonElement jsonElement) {
        return this.elements.remove(jsonElement);
    }

    public JsonElement set(int n10, JsonElement jsonElement) {
        return this.elements.set(n10, jsonElement);
    }

    public int size() {
        return this.elements.size();
    }
}

