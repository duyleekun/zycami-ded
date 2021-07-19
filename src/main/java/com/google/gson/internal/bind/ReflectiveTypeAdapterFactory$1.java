/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$BoundField;
import com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

public class ReflectiveTypeAdapterFactory$1
extends ReflectiveTypeAdapterFactory$BoundField {
    public final /* synthetic */ ReflectiveTypeAdapterFactory this$0;
    public final /* synthetic */ Gson val$context;
    public final /* synthetic */ Field val$field;
    public final /* synthetic */ TypeToken val$fieldType;
    public final /* synthetic */ boolean val$isPrimitive;
    public final /* synthetic */ boolean val$jsonAdapterPresent;
    public final /* synthetic */ TypeAdapter val$typeAdapter;

    public ReflectiveTypeAdapterFactory$1(ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory, String string2, boolean bl2, boolean bl3, Field field, boolean bl4, TypeAdapter typeAdapter, Gson gson, TypeToken typeToken, boolean bl5) {
        this.this$0 = reflectiveTypeAdapterFactory;
        this.val$field = field;
        this.val$jsonAdapterPresent = bl4;
        this.val$typeAdapter = typeAdapter;
        this.val$context = gson;
        this.val$fieldType = typeToken;
        this.val$isPrimitive = bl5;
        super(string2, bl2, bl3);
    }

    public void read(JsonReader object, Object object2) {
        boolean bl2;
        Object object3 = this.val$typeAdapter;
        if ((object = ((TypeAdapter)object3).read((JsonReader)object)) != null || !(bl2 = this.val$isPrimitive)) {
            object3 = this.val$field;
            ((Field)object3).set(object2, object);
        }
    }

    public void write(JsonWriter jsonWriter, Object object) {
        Object object2 = this.val$field;
        object = ((Field)object2).get(object);
        boolean bl2 = this.val$jsonAdapterPresent;
        if (bl2) {
            object2 = this.val$typeAdapter;
        } else {
            Gson gson = this.val$context;
            TypeAdapter typeAdapter = this.val$typeAdapter;
            Type type = this.val$fieldType.getType();
            object2 = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
        }
        ((TypeAdapter)object2).write(jsonWriter, object);
    }

    public boolean writeField(Object object) {
        boolean bl2 = this.serialized;
        boolean bl3 = false;
        if (!bl2) {
            return false;
        }
        Object object2 = this.val$field.get(object);
        if (object2 != object) {
            bl3 = true;
        }
        return bl3;
    }
}

