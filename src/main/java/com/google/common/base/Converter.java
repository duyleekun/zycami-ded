/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Converter$1;
import com.google.common.base.Converter$ConverterComposition;
import com.google.common.base.Converter$FunctionBasedConverter;
import com.google.common.base.Converter$IdentityConverter;
import com.google.common.base.Converter$ReverseConverter;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;

public abstract class Converter
implements Function {
    private final boolean handleNullAutomatically;
    private transient Converter reverse;

    public Converter() {
        this(true);
    }

    public Converter(boolean bl2) {
        this.handleNullAutomatically = bl2;
    }

    public static Converter from(Function function, Function function2) {
        Converter$FunctionBasedConverter converter$FunctionBasedConverter = new Converter$FunctionBasedConverter(function, function2, null);
        return converter$FunctionBasedConverter;
    }

    public static Converter identity() {
        return Converter$IdentityConverter.INSTANCE;
    }

    public final Converter andThen(Converter converter) {
        return this.doAndThen(converter);
    }

    public final Object apply(Object object) {
        return this.convert(object);
    }

    public final Object convert(Object object) {
        return this.correctedDoForward(object);
    }

    public Iterable convertAll(Iterable iterable) {
        Preconditions.checkNotNull(iterable, "fromIterable");
        Converter$1 converter$1 = new Converter$1(this, iterable);
        return converter$1;
    }

    public Object correctedDoBackward(Object object) {
        boolean bl2 = this.handleNullAutomatically;
        if (bl2) {
            object = object == null ? null : Preconditions.checkNotNull(this.doBackward(object));
            return object;
        }
        return this.doBackward(object);
    }

    public Object correctedDoForward(Object object) {
        boolean bl2 = this.handleNullAutomatically;
        if (bl2) {
            object = object == null ? null : Preconditions.checkNotNull(this.doForward(object));
            return object;
        }
        return this.doForward(object);
    }

    public Converter doAndThen(Converter converter) {
        converter = (Converter)Preconditions.checkNotNull(converter);
        Converter$ConverterComposition converter$ConverterComposition = new Converter$ConverterComposition(this, converter);
        return converter$ConverterComposition;
    }

    public abstract Object doBackward(Object var1);

    public abstract Object doForward(Object var1);

    public boolean equals(Object object) {
        return super.equals(object);
    }

    public Converter reverse() {
        Converter converter = this.reverse;
        if (converter == null) {
            this.reverse = converter = new Converter$ReverseConverter(this);
        }
        return converter;
    }
}

