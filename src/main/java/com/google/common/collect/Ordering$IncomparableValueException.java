/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

public class Ordering$IncomparableValueException
extends ClassCastException {
    private static final long serialVersionUID;
    public final Object value;

    public Ordering$IncomparableValueException(Object object) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Cannot compare value: ");
        charSequence.append(object);
        charSequence = charSequence.toString();
        super((String)charSequence);
        this.value = object;
    }
}

