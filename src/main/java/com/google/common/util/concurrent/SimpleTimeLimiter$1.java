/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.SimpleTimeLimiter;
import com.google.common.util.concurrent.SimpleTimeLimiter$1$1;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SimpleTimeLimiter$1
implements InvocationHandler {
    public final /* synthetic */ SimpleTimeLimiter this$0;
    public final /* synthetic */ Set val$interruptibleMethods;
    public final /* synthetic */ Object val$target;
    public final /* synthetic */ long val$timeoutDuration;
    public final /* synthetic */ TimeUnit val$timeoutUnit;

    public SimpleTimeLimiter$1(SimpleTimeLimiter simpleTimeLimiter, Object object, long l10, TimeUnit timeUnit, Set set) {
        this.this$0 = simpleTimeLimiter;
        this.val$target = object;
        this.val$timeoutDuration = l10;
        this.val$timeoutUnit = timeUnit;
        this.val$interruptibleMethods = set;
    }

    public Object invoke(Object object, Method method, Object[] objectArray) {
        SimpleTimeLimiter$1$1 simpleTimeLimiter$1$1 = new SimpleTimeLimiter$1$1(this, method, objectArray);
        SimpleTimeLimiter simpleTimeLimiter = this.this$0;
        long l10 = this.val$timeoutDuration;
        TimeUnit timeUnit = this.val$timeoutUnit;
        boolean bl2 = this.val$interruptibleMethods.contains(method);
        return SimpleTimeLimiter.access$100(simpleTimeLimiter, simpleTimeLimiter$1$1, l10, timeUnit, bl2);
    }
}

