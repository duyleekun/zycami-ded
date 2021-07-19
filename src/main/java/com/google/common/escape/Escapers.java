/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.escape;

import com.google.common.base.Preconditions;
import com.google.common.escape.CharEscaper;
import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers$1;
import com.google.common.escape.Escapers$2;
import com.google.common.escape.Escapers$Builder;
import com.google.common.escape.UnicodeEscaper;

public final class Escapers {
    private static final Escaper NULL_ESCAPER;

    static {
        Escapers$1 escapers$1 = new Escapers$1();
        NULL_ESCAPER = escapers$1;
    }

    private Escapers() {
    }

    public static UnicodeEscaper asUnicodeEscaper(Escaper object) {
        Preconditions.checkNotNull(object);
        boolean bl2 = object instanceof UnicodeEscaper;
        if (bl2) {
            return (UnicodeEscaper)object;
        }
        bl2 = object instanceof CharEscaper;
        if (bl2) {
            return Escapers.wrap((CharEscaper)object);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot create a UnicodeEscaper from: ");
        object = object.getClass().getName();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static Escapers$Builder builder() {
        Escapers$Builder escapers$Builder = new Escapers$Builder(null);
        return escapers$Builder;
    }

    public static String computeReplacement(CharEscaper charEscaper, char c10) {
        return Escapers.stringOrNull(charEscaper.escape(c10));
    }

    public static String computeReplacement(UnicodeEscaper unicodeEscaper, int n10) {
        return Escapers.stringOrNull(unicodeEscaper.escape(n10));
    }

    public static Escaper nullEscaper() {
        return NULL_ESCAPER;
    }

    private static String stringOrNull(char[] object) {
        if (object == null) {
            object = null;
        } else {
            String string2 = new String((char[])object);
            object = string2;
        }
        return object;
    }

    private static UnicodeEscaper wrap(CharEscaper charEscaper) {
        Escapers$2 escapers$2 = new Escapers$2(charEscaper);
        return escapers$2;
    }
}

