/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.SimpleTimeLimiter;
import com.google.common.util.concurrent.SimpleTimeLimiter$1;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public class SimpleTimeLimiter$1$1
implements Callable {
    public final /* synthetic */ SimpleTimeLimiter$1 this$1;
    public final /* synthetic */ Object[] val$args;
    public final /* synthetic */ Method val$method;

    public SimpleTimeLimiter$1$1(SimpleTimeLimiter$1 var1_1, Method method, Object[] objectArray) {
        this.this$1 = var1_1;
        this.val$method = method;
        this.val$args = objectArray;
    }

    public Object call() {
        Method method;
        try {
            method = this.val$method;
        }
        catch (InvocationTargetException invocationTargetException) {
            throw SimpleTimeLimiter.access$000(invocationTargetException, false);
        }
        Object object = this.this$1;
        object = ((SimpleTimeLimiter$1)object).val$target;
        Object[] objectArray = this.val$args;
        return method.invoke(object, objectArray);
    }
}

