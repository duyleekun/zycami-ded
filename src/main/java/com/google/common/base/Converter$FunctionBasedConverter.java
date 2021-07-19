/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Converter;
import com.google.common.base.Converter$1;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.Serializable;

public final class Converter$FunctionBasedConverter
extends Converter
implements Serializable {
    private final Function backwardFunction;
    private final Function forwardFunction;

    private Converter$FunctionBasedConverter(Function function, Function function2) {
        this.forwardFunction = function = (Function)Preconditions.checkNotNull(function);
        this.backwardFunction = function = (Function)Preconditions.checkNotNull(function2);
    }

    public /* synthetic */ Converter$FunctionBasedConverter(Function function, Function function2, Converter$1 converter$1) {
        this(function, function2);
    }

    public Object doBackward(Object object) {
        return this.backwardFunction.apply(object);
    }

    public Object doForward(Object object) {
        return this.forwardFunction.apply(object);
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Converter$FunctionBasedConverter;
        boolean bl3 = false;
        if (bl2) {
            boolean bl4;
            object = (Converter$FunctionBasedConverter)object;
            Function function = this.forwardFunction;
            Function function2 = ((Converter$FunctionBasedConverter)object).forwardFunction;
            bl2 = function.equals(function2);
            if (bl2 && (bl4 = (function = this.backwardFunction).equals(object = ((Converter$FunctionBasedConverter)object).backwardFunction))) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public int hashCode() {
        int n10 = this.forwardFunction.hashCode() * 31;
        int n11 = this.backwardFunction.hashCode();
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Converter.from(");
        Function function = this.forwardFunction;
        stringBuilder.append(function);
        stringBuilder.append(", ");
        function = this.backwardFunction;
        stringBuilder.append(function);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

