/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.Serializable;

public class Functions$FunctionComposition
implements Function,
Serializable {
    private static final long serialVersionUID;
    private final Function f;
    private final Function g;

    public Functions$FunctionComposition(Function function, Function function2) {
        this.g = function = (Function)Preconditions.checkNotNull(function);
        this.f = function = (Function)Preconditions.checkNotNull(function2);
    }

    public Object apply(Object object) {
        Function function = this.g;
        object = this.f.apply(object);
        return function.apply(object);
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Functions$FunctionComposition;
        boolean bl3 = false;
        if (bl2) {
            boolean bl4;
            object = (Functions$FunctionComposition)object;
            Function function = this.f;
            Function function2 = ((Functions$FunctionComposition)object).f;
            bl2 = function.equals(function2);
            if (bl2 && (bl4 = (function = this.g).equals(object = ((Functions$FunctionComposition)object).g))) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public int hashCode() {
        int n10 = this.f.hashCode();
        int n11 = this.g.hashCode();
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Function function = this.g;
        stringBuilder.append(function);
        stringBuilder.append("(");
        function = this.f;
        stringBuilder.append(function);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

