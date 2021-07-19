/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.escape;

import com.google.common.base.Preconditions;
import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers$1;
import com.google.common.escape.Escapers$Builder$1;
import java.util.HashMap;
import java.util.Map;

public final class Escapers$Builder {
    private final Map replacementMap;
    private char safeMax;
    private char safeMin;
    private String unsafeReplacement;

    private Escapers$Builder() {
        HashMap hashMap;
        this.replacementMap = hashMap = new HashMap();
        this.safeMin = '\u0000';
        this.safeMax = (char)-1;
        this.unsafeReplacement = null;
    }

    public /* synthetic */ Escapers$Builder(Escapers.1 var1_1) {
        this();
    }

    public static /* synthetic */ String access$100(Escapers$Builder escapers$Builder) {
        return escapers$Builder.unsafeReplacement;
    }

    public Escapers$Builder addEscape(char c10, String string2) {
        Preconditions.checkNotNull(string2);
        Map map = this.replacementMap;
        Character c11 = Character.valueOf(c10);
        map.put(c11, string2);
        return this;
    }

    public Escaper build() {
        Map map = this.replacementMap;
        char c10 = this.safeMin;
        char c11 = this.safeMax;
        Escapers$Builder$1 escapers$Builder$1 = new Escapers$Builder$1(this, map, c10, c11);
        return escapers$Builder$1;
    }

    public Escapers$Builder setSafeRange(char c10, char c11) {
        this.safeMin = c10;
        this.safeMax = c11;
        return this;
    }

    public Escapers$Builder setUnsafeReplacement(String string2) {
        this.unsafeReplacement = string2;
        return this;
    }
}

