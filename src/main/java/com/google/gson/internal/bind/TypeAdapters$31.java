/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

public class TypeAdapters$31
implements TypeAdapterFactory {
    public final /* synthetic */ TypeToken val$type;
    public final /* synthetic */ TypeAdapter val$typeAdapter;

    public TypeAdapters$31(TypeToken typeToken, TypeAdapter typeAdapter) {
        this.val$type = typeToken;
        this.val$typeAdapter = typeAdapter;
    }

    public TypeAdapter create(Gson object, TypeToken typeToken) {
        object = this.val$type;
        boolean bl2 = typeToken.equals(object);
        if (bl2) {
            object = this.val$typeAdapter;
        } else {
            bl2 = false;
            object = null;
        }
        return object;
    }
}

