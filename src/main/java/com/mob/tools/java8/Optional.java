/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Closure;
import com.mob.tools.java8.Closure$IClosureV;
import com.mob.tools.java8.Consumer;

public class Optional {
    private Object value;

    public Optional(Object object) {
        this.value = object;
    }

    public Object get() {
        return this.value;
    }

    public Optional ifPresent(Consumer consumer) {
        Object object = this.value;
        if (object != null) {
            consumer.test(object);
        }
        return this;
    }

    public Object orElse(Object object) {
        Object object2 = this.value;
        if (object2 != null) {
            object = object2;
        }
        return object;
    }

    public void orElse(Closure$IClosureV closure$IClosureV) {
        Object object = this.value;
        if (object == null) {
            Closure.uncheck(closure$IClosureV);
        }
    }
}

