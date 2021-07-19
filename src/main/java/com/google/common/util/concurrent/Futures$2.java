/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Function;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class Futures$2
implements Future {
    public final /* synthetic */ Function val$function;
    public final /* synthetic */ Future val$input;

    public Futures$2(Future future, Function function) {
        this.val$input = future;
        this.val$function = function;
    }

    private Object applyTransformation(Object object) {
        Object object2;
        try {
            object2 = this.val$function;
        }
        catch (Throwable throwable) {
            object2 = new ExecutionException(throwable);
            throw object2;
        }
        return object2.apply(object);
    }

    public boolean cancel(boolean bl2) {
        return this.val$input.cancel(bl2);
    }

    public Object get() {
        Object v10 = this.val$input.get();
        return this.applyTransformation(v10);
    }

    public Object get(long l10, TimeUnit timeUnit) {
        Object v10 = this.val$input.get(l10, timeUnit);
        return this.applyTransformation(v10);
    }

    public boolean isCancelled() {
        return this.val$input.isCancelled();
    }

    public boolean isDone() {
        return this.val$input.isDone();
    }
}

