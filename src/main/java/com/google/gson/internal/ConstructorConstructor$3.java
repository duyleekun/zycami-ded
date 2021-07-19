/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorConstructor$3
implements ObjectConstructor {
    public final /* synthetic */ ConstructorConstructor this$0;
    public final /* synthetic */ Constructor val$constructor;

    public ConstructorConstructor$3(ConstructorConstructor constructorConstructor, Constructor constructor) {
        this.this$0 = constructorConstructor;
        this.val$constructor = constructor;
    }

    public Object construct() {
        String string2 = " with no args";
        Object object = "Failed to invoke ";
        Object var3_4 = null;
        Object object2 = this.val$constructor;
        try {
            return ((Constructor)object2).newInstance(null);
        }
        catch (IllegalAccessException illegalAccessException) {
            object = new AssertionError((Object)illegalAccessException);
            throw object;
        }
        catch (InvocationTargetException invocationTargetException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            object = this.val$constructor;
            stringBuilder.append(object);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            object = invocationTargetException.getTargetException();
            object2 = new RuntimeException(string2, (Throwable)object);
            throw object2;
        }
        catch (InstantiationException instantiationException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            object = this.val$constructor;
            stringBuilder.append(object);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            object2 = new RuntimeException(string2, instantiationException);
            throw object2;
        }
    }
}

