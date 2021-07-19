/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.gson;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.util.HashMap;
import java.util.Map;

public class GeneralObjectAdapter
extends TypeAdapter {
    private TypeAdapter typeAdapter = null;

    public GeneralObjectAdapter(FieldNamingPolicy object, TypeToken typeToken) {
        Object object2 = new HashMap();
        ConstructorConstructor constructorConstructor = new ConstructorConstructor((Map)object2);
        object2 = new JsonAdapterAnnotationTypeAdapterFactory(constructorConstructor);
        Excluder excluder = Excluder.DEFAULT;
        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory = new ReflectiveTypeAdapterFactory(constructorConstructor, (FieldNamingStrategy)object, excluder, (JsonAdapterAnnotationTypeAdapterFactory)object2);
        object = new GsonBuilder();
        object = ((GsonBuilder)object).create();
        this.typeAdapter = object = reflectiveTypeAdapterFactory.create((Gson)object, typeToken);
    }

    public Object read(JsonReader jsonReader) {
        return this.typeAdapter.read(jsonReader);
    }

    public void write(JsonWriter jsonWriter, Object object) {
        this.typeAdapter.write(jsonWriter, object);
    }
}

