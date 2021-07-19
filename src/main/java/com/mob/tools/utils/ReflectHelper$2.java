/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.utils;

import com.mob.tools.utils.ReflectHelper$ReflectRunnable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public final class ReflectHelper$2
implements InvocationHandler {
    public final /* synthetic */ Map val$proxyHandler;

    public ReflectHelper$2(Map map) {
        this.val$proxyHandler = map;
    }

    public Object invoke(Object object, Method object2, Object[] objectArray) {
        object = this.val$proxyHandler;
        if ((object = (ReflectHelper$ReflectRunnable)object.get(object2 = ((Method)object2).getName())) != null) {
            return object.run(objectArray);
        }
        object = new NoSuchMethodException();
        throw object;
    }
}

