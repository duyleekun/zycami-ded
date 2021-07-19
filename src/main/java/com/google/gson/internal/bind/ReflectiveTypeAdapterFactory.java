/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$1;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$Adapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$BoundField;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory
implements TypeAdapterFactory {
    private final ReflectionAccessor accessor;
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        ReflectionAccessor reflectionAccessor;
        this.accessor = reflectionAccessor = ReflectionAccessor.getInstance();
        this.constructorConstructor = constructorConstructor;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = excluder;
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
    }

    private ReflectiveTypeAdapterFactory$BoundField createBoundField(Gson gson, Field field, String string2, TypeToken typeToken, boolean bl2, boolean bl3) {
        ReflectiveTypeAdapterFactory$1 reflectiveTypeAdapterFactory$1;
        boolean bl4;
        Object object;
        TypeAdapterFactory typeAdapterFactory;
        TypeToken typeToken2 = typeToken;
        boolean bl5 = Primitives.isPrimitive(typeToken.getRawType());
        Object object2 = field.getAnnotation(JsonAdapter.class);
        if (object2 != null) {
            typeAdapterFactory = this.jsonAdapterFactory;
            object = this.constructorConstructor;
            object2 = typeAdapterFactory.getTypeAdapter((ConstructorConstructor)object, gson, typeToken, (JsonAdapter)object2);
        } else {
            object2 = null;
        }
        if (object2 != null) {
            bl4 = true;
        } else {
            bl4 = false;
            typeAdapterFactory = null;
        }
        boolean bl6 = bl4;
        if (object2 == null) {
            object2 = gson.getAdapter(typeToken2);
        }
        JsonAdapter jsonAdapter = object2;
        object2 = reflectiveTypeAdapterFactory$1;
        typeAdapterFactory = this;
        object = string2;
        typeToken2 = typeToken;
        reflectiveTypeAdapterFactory$1 = new ReflectiveTypeAdapterFactory$1(this, string2, bl2, bl3, field, bl6, (TypeAdapter)((Object)jsonAdapter), gson, typeToken, bl5);
        return reflectiveTypeAdapterFactory$1;
    }

    public static boolean excludeField(Field field, boolean bl2, Excluder excluder) {
        boolean bl3;
        Class<?> clazz = field.getType();
        boolean bl4 = excluder.excludeClass(clazz, bl2);
        if (!bl4 && !(bl3 = excluder.excludeField(field, bl2))) {
            bl3 = true;
        } else {
            bl3 = false;
            field = null;
        }
        return bl3;
    }

    private Map getBoundFields(Gson gson, TypeToken object, Class clazz) {
        Object object2;
        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory = this;
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        boolean bl2 = clazz.isInterface();
        if (bl2) {
            return linkedHashMap;
        }
        Type type = ((TypeToken)object).getType();
        TypeToken typeToken = object;
        Class clazz2 = clazz;
        while (clazz2 != (object2 = Object.class)) {
            Object object3;
            Field[] fieldArray = clazz2.getDeclaredFields();
            int n10 = fieldArray.length;
            Object object4 = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                Object object5;
                Object object6;
                block8: {
                    block7: {
                        Field field = fieldArray[i10];
                        bl2 = reflectiveTypeAdapterFactory.excludeField(field, true);
                        boolean bl3 = reflectiveTypeAdapterFactory.excludeField(field, false);
                        if (!bl2 && !bl3) break block7;
                        reflectiveTypeAdapterFactory.accessor.makeAccessible(field);
                        object3 = typeToken.getType();
                        object6 = field.getGenericType();
                        Type type2 = $Gson$Types.resolve((Type)object3, clazz2, (Type)object6);
                        Object object7 = reflectiveTypeAdapterFactory.getFieldNames(field);
                        object3 = null;
                        int n11 = object7.size();
                        object5 = null;
                        int n12 = 0;
                        object6 = null;
                        while (n12 < n11) {
                            object3 = (String)object7.get(n12);
                            boolean bl4 = n12 != 0 ? false : bl2;
                            Object object8 = TypeToken.get(type2);
                            object2 = this;
                            object = object3;
                            object3 = gson;
                            int n13 = n12;
                            object6 = field;
                            object4 = object5;
                            object5 = object;
                            int n14 = n11;
                            TypeToken typeToken2 = object8;
                            object8 = object7;
                            Field field2 = field;
                            object2 = this.createBoundField(gson, field, (String)object, typeToken2, bl4, bl3);
                            object3 = object;
                            object2 = (ReflectiveTypeAdapterFactory$BoundField)linkedHashMap.put(object, object2);
                            object5 = object4 == null ? object2 : object4;
                            n12 = n13 + 1;
                            bl2 = bl4;
                            object7 = object8;
                            n11 = n14;
                            field = field2;
                            object4 = null;
                        }
                        object4 = object5;
                        if (object5 != null) break block8;
                    }
                    object4 = null;
                    continue;
                }
                object3 = new StringBuilder();
                ((StringBuilder)object3).append(type);
                ((StringBuilder)object3).append(" declares multiple JSON fields named ");
                object6 = ((ReflectiveTypeAdapterFactory$BoundField)object5).name;
                ((StringBuilder)object3).append((String)object6);
                object3 = ((StringBuilder)object3).toString();
                object2 = new IllegalArgumentException((String)object3);
                throw object2;
            }
            object2 = typeToken.getType();
            object3 = clazz2.getGenericSuperclass();
            object2 = $Gson$Types.resolve((Type)object2, clazz2, (Type)object3);
            typeToken = TypeToken.get((Type)object2);
            clazz2 = typeToken.getRawType();
        }
        return linkedHashMap;
    }

    private List getFieldNames(Field object) {
        String[] stringArray = ((Field)object).getAnnotation(SerializedName.class);
        if (stringArray == null) {
            return Collections.singletonList(this.fieldNamingPolicy.translateName((Field)object));
        }
        object = stringArray.value();
        int n10 = (stringArray = stringArray.alternate()).length;
        if (n10 == 0) {
            return Collections.singletonList(object);
        }
        int n11 = stringArray.length + 1;
        ArrayList<Object> arrayList = new ArrayList<Object>(n11);
        arrayList.add(object);
        for (String string2 : stringArray) {
            arrayList.add(string2);
        }
        return arrayList;
    }

    public TypeAdapter create(Gson object, TypeToken typeToken) {
        Class<Object> clazz = Object.class;
        Class clazz2 = typeToken.getRawType();
        boolean bl2 = clazz.isAssignableFrom(clazz2);
        if (!bl2) {
            return null;
        }
        clazz = this.constructorConstructor.get(typeToken);
        object = this.getBoundFields((Gson)object, typeToken, clazz2);
        ReflectiveTypeAdapterFactory$Adapter reflectiveTypeAdapterFactory$Adapter = new ReflectiveTypeAdapterFactory$Adapter((ObjectConstructor)((Object)clazz), (Map)object);
        return reflectiveTypeAdapterFactory$Adapter;
    }

    public boolean excludeField(Field field, boolean bl2) {
        Excluder excluder = this.excluder;
        return ReflectiveTypeAdapterFactory.excludeField(field, bl2, excluder);
    }
}

