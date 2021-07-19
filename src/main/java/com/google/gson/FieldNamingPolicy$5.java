/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson;

import com.google.gson.FieldNamingPolicy;
import java.lang.reflect.Field;
import java.util.Locale;

public final class FieldNamingPolicy$5
extends FieldNamingPolicy {
    public String translateName(Field object) {
        object = FieldNamingPolicy.separateCamelCase(((Field)object).getName(), "-");
        Locale locale = Locale.ENGLISH;
        return ((String)object).toLowerCase(locale);
    }
}

