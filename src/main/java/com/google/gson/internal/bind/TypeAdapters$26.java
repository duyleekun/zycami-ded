/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.TypeAdapters$26$1;
import com.google.gson.reflect.TypeToken;
import java.sql.Timestamp;
import java.util.Date;

public class TypeAdapters$26
implements TypeAdapterFactory {
    public TypeAdapter create(Gson object, TypeToken object2) {
        Class<Timestamp> clazz;
        if ((object2 = ((TypeToken)object2).getRawType()) != (clazz = Timestamp.class)) {
            return null;
        }
        object = ((Gson)object).getAdapter(Date.class);
        object2 = new TypeAdapters$26$1(this, (TypeAdapter)object);
        return object2;
    }
}

