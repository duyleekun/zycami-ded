/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Interner;
import com.google.common.collect.Interners$InternerBuilder;
import com.google.common.collect.Interners$InternerFunction;

public final class Interners {
    private Interners() {
    }

    public static Function asFunction(Interner interner) {
        interner = (Interner)Preconditions.checkNotNull(interner);
        Interners$InternerFunction interners$InternerFunction = new Interners$InternerFunction(interner);
        return interners$InternerFunction;
    }

    public static Interners$InternerBuilder newBuilder() {
        Interners$InternerBuilder interners$InternerBuilder = new Interners$InternerBuilder(null);
        return interners$InternerBuilder;
    }

    public static Interner newStrongInterner() {
        return Interners.newBuilder().strong().build();
    }

    public static Interner newWeakInterner() {
        return Interners.newBuilder().weak().build();
    }
}

