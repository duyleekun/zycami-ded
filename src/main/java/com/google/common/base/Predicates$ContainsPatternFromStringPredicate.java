/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CommonPattern;
import com.google.common.base.Platform;
import com.google.common.base.Predicates$ContainsPatternPredicate;

public class Predicates$ContainsPatternFromStringPredicate
extends Predicates$ContainsPatternPredicate {
    private static final long serialVersionUID;

    public Predicates$ContainsPatternFromStringPredicate(String object) {
        object = Platform.compilePattern((String)object);
        super((CommonPattern)object);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Predicates.containsPattern(");
        String string2 = this.pattern.pattern();
        stringBuilder.append(string2);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

