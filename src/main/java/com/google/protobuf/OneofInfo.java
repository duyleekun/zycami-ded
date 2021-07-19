/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import java.lang.reflect.Field;

public final class OneofInfo {
    private final Field caseField;
    private final int id;
    private final Field valueField;

    public OneofInfo(int n10, Field field, Field field2) {
        this.id = n10;
        this.caseField = field;
        this.valueField = field2;
    }

    public Field getCaseField() {
        return this.caseField;
    }

    public int getId() {
        return this.id;
    }

    public Field getValueField() {
        return this.valueField;
    }
}

