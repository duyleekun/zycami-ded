/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import java.lang.reflect.Type;

public class ConstructorConstructor$1
implements ObjectConstructor {
    public final /* synthetic */ ConstructorConstructor this$0;
    public final /* synthetic */ Type val$type;
    public final /* synthetic */ InstanceCreator val$typeCreator;

    public ConstructorConstructor$1(ConstructorConstructor constructorConstructor, InstanceCreator instanceCreator, Type type) {
        this.this$0 = constructorConstructor;
        this.val$typeCreator = instanceCreator;
        this.val$type = type;
    }

    public Object construct() {
        InstanceCreator instanceCreator = this.val$typeCreator;
        Type type = this.val$type;
        return instanceCreator.createInstance(type);
    }
}

