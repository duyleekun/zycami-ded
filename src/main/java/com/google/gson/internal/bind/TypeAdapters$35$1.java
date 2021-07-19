/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.TypeAdapters$35;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class TypeAdapters$35$1
extends TypeAdapter {
    public final /* synthetic */ TypeAdapters$35 this$0;
    public final /* synthetic */ Class val$requestedType;

    public TypeAdapters$35$1(TypeAdapters$35 typeAdapters$35, Class clazz) {
        this.this$0 = typeAdapters$35;
        this.val$requestedType = clazz;
    }

    public Object read(JsonReader object) {
        boolean bl2;
        Object object2 = this.this$0.val$typeAdapter;
        if ((object = ((TypeAdapter)object2).read((JsonReader)object)) != null && !(bl2 = ((Class)(object2 = this.val$requestedType)).isInstance(object))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected a ");
            String string2 = this.val$requestedType.getName();
            stringBuilder.append(string2);
            stringBuilder.append(" but was ");
            object = object.getClass().getName();
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            object2 = new JsonSyntaxException((String)object);
            throw object2;
        }
        return object;
    }

    public void write(JsonWriter jsonWriter, Object object) {
        this.this$0.val$typeAdapter.write(jsonWriter, object);
    }
}

