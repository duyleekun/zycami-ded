/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.UnsafeAllocator;
import java.io.Serializable;
import java.lang.reflect.Type;

public class ConstructorConstructor$14
implements ObjectConstructor {
    public final /* synthetic */ ConstructorConstructor this$0;
    private final UnsafeAllocator unsafeAllocator;
    public final /* synthetic */ Class val$rawType;
    public final /* synthetic */ Type val$type;

    public ConstructorConstructor$14(ConstructorConstructor object, Class clazz, Type type) {
        this.this$0 = object;
        this.val$rawType = clazz;
        this.val$type = type;
        this.unsafeAllocator = object = UnsafeAllocator.create();
    }

    public Object construct() {
        Serializable serializable;
        UnsafeAllocator unsafeAllocator;
        try {
            unsafeAllocator = this.unsafeAllocator;
        }
        catch (Exception exception) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Unable to invoke no-args constructor for ");
            Type type = this.val$type;
            charSequence.append(type);
            charSequence.append(". Registering an InstanceCreator with Gson for this type may fix this problem.");
            charSequence = charSequence.toString();
            serializable = new RuntimeException((String)charSequence, exception);
            throw serializable;
        }
        serializable = this.val$rawType;
        return unsafeAllocator.newInstance((Class)serializable);
    }
}

