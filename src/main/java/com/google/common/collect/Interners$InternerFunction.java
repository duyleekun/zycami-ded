/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Interner;

public class Interners$InternerFunction
implements Function {
    private final Interner interner;

    public Interners$InternerFunction(Interner interner) {
        this.interner = interner;
    }

    public Object apply(Object object) {
        return this.interner.intern(object);
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Interners$InternerFunction;
        if (bl2) {
            object = (Interners$InternerFunction)object;
            Interner interner = this.interner;
            object = ((Interners$InternerFunction)object).interner;
            return interner.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.interner.hashCode();
    }
}

