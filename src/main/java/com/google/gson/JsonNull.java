/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson;

import com.google.gson.JsonElement;

public final class JsonNull
extends JsonElement {
    public static final JsonNull INSTANCE;

    static {
        JsonNull jsonNull;
        INSTANCE = jsonNull = new JsonNull();
    }

    public JsonNull deepCopy() {
        return INSTANCE;
    }

    public boolean equals(Object object) {
        boolean bl2;
        if (this != object && !(bl2 = object instanceof JsonNull)) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public int hashCode() {
        return JsonNull.class.hashCode();
    }
}

