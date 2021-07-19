/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.TypeAdapters$35$1;
import com.google.gson.reflect.TypeToken;

public class TypeAdapters$35
implements TypeAdapterFactory {
    public final /* synthetic */ Class val$clazz;
    public final /* synthetic */ TypeAdapter val$typeAdapter;

    public TypeAdapters$35(Class clazz, TypeAdapter typeAdapter) {
        this.val$clazz = clazz;
        this.val$typeAdapter = typeAdapter;
    }

    public TypeAdapter create(Gson object, TypeToken object2) {
        object2 = this.val$clazz;
        object = ((TypeToken)object2).getRawType();
        boolean bl2 = ((Class)object2).isAssignableFrom((Class<?>)object);
        if (!bl2) {
            return null;
        }
        object2 = new TypeAdapters$35$1(this, (Class)object);
        return object2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Factory[typeHierarchy=");
        Object object = this.val$clazz.getName();
        stringBuilder.append((String)object);
        stringBuilder.append(",adapter=");
        object = this.val$typeAdapter;
        stringBuilder.append(object);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

