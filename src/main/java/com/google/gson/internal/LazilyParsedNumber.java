/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import java.math.BigDecimal;

public final class LazilyParsedNumber
extends Number {
    private final String value;

    public LazilyParsedNumber(String string2) {
        this.value = string2;
    }

    private Object writeReplace() {
        String string2 = this.value;
        BigDecimal bigDecimal = new BigDecimal(string2);
        return bigDecimal;
    }

    public double doubleValue() {
        return Double.parseDouble(this.value);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        boolean bl3 = object instanceof LazilyParsedNumber;
        if (bl3) {
            boolean bl4;
            object = (LazilyParsedNumber)object;
            String string2 = this.value;
            object = ((LazilyParsedNumber)object).value;
            if (string2 != object && !(bl4 = string2.equals(object))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public float floatValue() {
        return Float.parseFloat(this.value);
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public int intValue() {
        Object object;
        try {
            object = this.value;
        }
        catch (NumberFormatException numberFormatException) {
            try {
                object = this.value;
            }
            catch (NumberFormatException numberFormatException2) {
                String string2 = this.value;
                object = new BigDecimal(string2);
                return ((BigDecimal)object).intValue();
            }
            return (int)Long.parseLong((String)object);
        }
        return Integer.parseInt((String)object);
    }

    public long longValue() {
        Object object;
        try {
            object = this.value;
        }
        catch (NumberFormatException numberFormatException) {
            String string2 = this.value;
            object = new BigDecimal(string2);
            return ((BigDecimal)object).longValue();
        }
        return Long.parseLong((String)object);
    }

    public String toString() {
        return this.value;
    }
}

