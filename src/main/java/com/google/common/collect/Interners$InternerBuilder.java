/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Interner;
import com.google.common.collect.Interners$1;
import com.google.common.collect.Interners$InternerImpl;
import com.google.common.collect.MapMaker;

public class Interners$InternerBuilder {
    private final MapMaker mapMaker;
    private boolean strong;

    private Interners$InternerBuilder() {
        MapMaker mapMaker;
        this.mapMaker = mapMaker = new MapMaker();
        this.strong = true;
    }

    public /* synthetic */ Interners$InternerBuilder(Interners$1 interners$1) {
        this();
    }

    public Interner build() {
        Object object;
        boolean bl2 = this.strong;
        if (!bl2) {
            object = this.mapMaker;
            ((MapMaker)object).weakKeys();
        }
        MapMaker mapMaker = this.mapMaker;
        object = new Interners$InternerImpl(mapMaker, null);
        return object;
    }

    public Interners$InternerBuilder concurrencyLevel(int n10) {
        this.mapMaker.concurrencyLevel(n10);
        return this;
    }

    public Interners$InternerBuilder strong() {
        this.strong = true;
        return this;
    }

    public Interners$InternerBuilder weak() {
        this.strong = false;
        return this;
    }
}

