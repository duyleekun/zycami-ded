/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import java.lang.reflect.Type;

public class ConstructorConstructor$2
implements ObjectConstructor {
    public final /* synthetic */ ConstructorConstructor this$0;
    public final /* synthetic */ InstanceCreator val$rawTypeCreator;
    public final /* synthetic */ Type val$type;

    public ConstructorConstructor$2(ConstructorConstructor constructorConstructor, InstanceCreator instanceCreator, Type type) {
        this.this$0 = constructorConstructor;
        this.val$rawTypeCreator = instanceCreator;
        this.val$type = type;
    }

    public Object construct() {
        InstanceCreator instanceCreator = this.val$rawTypeCreator;
        Type type = this.val$type;
        return instanceCreator.createInstance(type);
    }
}

