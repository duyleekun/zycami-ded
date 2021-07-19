/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson;

import com.google.gson.internal.$Gson$Preconditions;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

public final class FieldAttributes {
    private final Field field;

    public FieldAttributes(Field field) {
        $Gson$Preconditions.checkNotNull(field);
        this.field = field;
    }

    public Object get(Object object) {
        return this.field.get(object);
    }

    public Annotation getAnnotation(Class clazz) {
        return this.field.getAnnotation(clazz);
    }

    public Collection getAnnotations() {
        return Arrays.asList(this.field.getAnnotations());
    }

    public Class getDeclaredClass() {
        return this.field.getType();
    }

    public Type getDeclaredType() {
        return this.field.getGenericType();
    }

    public Class getDeclaringClass() {
        return this.field.getDeclaringClass();
    }

    public String getName() {
        return this.field.getName();
    }

    public boolean hasModifier(int n10) {
        Field field = this.field;
        int n11 = field.getModifiers();
        n10 = (n10 &= n11) != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isSynthetic() {
        return this.field.isSynthetic();
    }
}

