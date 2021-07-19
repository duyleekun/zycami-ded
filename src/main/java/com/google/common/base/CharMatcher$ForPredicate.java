/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;

public final class CharMatcher$ForPredicate
extends CharMatcher {
    private final Predicate predicate;

    public CharMatcher$ForPredicate(Predicate predicate) {
        this.predicate = predicate = (Predicate)Preconditions.checkNotNull(predicate);
    }

    public boolean apply(Character object) {
        Predicate predicate = this.predicate;
        object = Preconditions.checkNotNull(object);
        return predicate.apply(object);
    }

    public boolean matches(char c10) {
        Predicate predicate = this.predicate;
        Character c11 = Character.valueOf(c10);
        return predicate.apply(c11);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CharMatcher.forPredicate(");
        Predicate predicate = this.predicate;
        stringBuilder.append(predicate);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

