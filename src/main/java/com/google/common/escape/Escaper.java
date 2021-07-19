/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.escape;

import com.google.common.base.Function;
import com.google.common.escape.Escaper$1;

public abstract class Escaper {
    private final Function asFunction;

    public Escaper() {
        Escaper$1 escaper$1 = new Escaper$1(this);
        this.asFunction = escaper$1;
    }

    public final Function asFunction() {
        return this.asFunction;
    }

    public abstract String escape(String var1);
}

