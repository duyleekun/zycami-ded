/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.sql.Time;

public class TimeTypeAdapter$1
implements TypeAdapterFactory {
    public TypeAdapter create(Gson object, TypeToken object2) {
        object = ((TypeToken)object2).getRawType();
        object = object == (object2 = Time.class) ? new TimeTypeAdapter() : null;
        return object;
    }
}

