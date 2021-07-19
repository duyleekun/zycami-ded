/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.encoders;

import com.google.firebase.encoders.FieldDescriptor;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class FieldDescriptor$Builder {
    private final String name;
    private Map properties = null;

    public FieldDescriptor$Builder(String string2) {
        this.name = string2;
    }

    public FieldDescriptor build() {
        String string2 = this.name;
        Map map = this.properties;
        if (map == null) {
            map = Collections.emptyMap();
        } else {
            Map map2 = this.properties;
            map = new Map(map2);
            map = Collections.unmodifiableMap(map);
        }
        FieldDescriptor fieldDescriptor = new FieldDescriptor(string2, map, null);
        return fieldDescriptor;
    }

    public FieldDescriptor$Builder withProperty(Annotation annotation) {
        HashMap<Class<? extends Annotation>, Annotation> hashMap = this.properties;
        if (hashMap == null) {
            this.properties = hashMap = new HashMap<Class<? extends Annotation>, Annotation>();
        }
        hashMap = this.properties;
        Class<? extends Annotation> clazz = annotation.annotationType();
        hashMap.put(clazz, annotation);
        return this;
    }
}

