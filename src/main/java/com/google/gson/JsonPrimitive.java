/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson;

import com.google.gson.JsonElement;
import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class JsonPrimitive
extends JsonElement {
    private final Object value;

    public JsonPrimitive(Boolean object) {
        this.value = object = $Gson$Preconditions.checkNotNull(object);
    }

    public JsonPrimitive(Character object) {
        this.value = object = ((Character)$Gson$Preconditions.checkNotNull(object)).toString();
    }

    public JsonPrimitive(Number object) {
        this.value = object = $Gson$Preconditions.checkNotNull(object);
    }

    public JsonPrimitive(String object) {
        this.value = object = $Gson$Preconditions.checkNotNull(object);
    }

    private static boolean isIntegral(JsonPrimitive object) {
        boolean bl2;
        object = ((JsonPrimitive)object).value;
        boolean bl3 = object instanceof Number;
        boolean bl4 = false;
        if (bl3 && ((bl3 = (object = (Number)object) instanceof BigInteger) || (bl3 = object instanceof Long) || (bl3 = object instanceof Integer) || (bl3 = object instanceof Short) || (bl2 = object instanceof Byte))) {
            bl4 = true;
        }
        return bl4;
    }

    public JsonPrimitive deepCopy() {
        return this;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = JsonPrimitive.class) == (object2 = object.getClass())) {
            object = (JsonPrimitive)object;
            object3 = this.value;
            if (object3 == null) {
                object = ((JsonPrimitive)object).value;
                if (object != null) {
                    bl2 = false;
                }
                return bl2;
            }
            boolean bl3 = JsonPrimitive.isIntegral(this);
            if (bl3 && (bl3 = JsonPrimitive.isIntegral((JsonPrimitive)object))) {
                long l10;
                object3 = this.getAsNumber();
                long l11 = ((Number)object3).longValue();
                long l12 = l11 - (l10 = ((Number)(object = ((JsonPrimitive)object).getAsNumber())).longValue());
                Object object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object4 != false) {
                    bl2 = false;
                }
                return bl2;
            }
            object3 = this.value;
            boolean bl4 = object3 instanceof Number;
            if (bl4 && (bl4 = (object2 = ((JsonPrimitive)object).value) instanceof Number)) {
                double d10;
                object3 = this.getAsNumber();
                double d11 = ((Number)object3).doubleValue();
                double d12 = d11 - (d10 = ((Number)(object = ((JsonPrimitive)object).getAsNumber())).doubleValue());
                Object object5 = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
                if (object5 != false && ((object5 = (Object)Double.isNaN(d11)) == false || (object5 = (Object)Double.isNaN(d10)) == false)) {
                    bl2 = false;
                }
                return bl2;
            }
            object = ((JsonPrimitive)object).value;
            return object3.equals(object);
        }
        return false;
    }

    public BigDecimal getAsBigDecimal() {
        Object object = this.value;
        boolean bl2 = object instanceof BigDecimal;
        if (bl2) {
            object = (BigDecimal)object;
        } else {
            String string2 = this.value.toString();
            object = new BigDecimal(string2);
        }
        return object;
    }

    public BigInteger getAsBigInteger() {
        Object object = this.value;
        boolean bl2 = object instanceof BigInteger;
        if (bl2) {
            object = (BigInteger)object;
        } else {
            String string2 = this.value.toString();
            object = new BigInteger(string2);
        }
        return object;
    }

    public boolean getAsBoolean() {
        boolean bl2 = this.isBoolean();
        if (bl2) {
            return (Boolean)this.value;
        }
        return Boolean.parseBoolean(this.getAsString());
    }

    public byte getAsByte() {
        byte by2 = this.isNumber();
        if (by2 != 0) {
            Number number = this.getAsNumber();
            by2 = number.byteValue();
        } else {
            String string2 = this.getAsString();
            by2 = Byte.parseByte(string2);
        }
        return by2;
    }

    public char getAsCharacter() {
        return this.getAsString().charAt(0);
    }

    public double getAsDouble() {
        double d10;
        boolean bl2 = this.isNumber();
        if (bl2) {
            Number number = this.getAsNumber();
            d10 = number.doubleValue();
        } else {
            String string2 = this.getAsString();
            d10 = Double.parseDouble(string2);
        }
        return d10;
    }

    public float getAsFloat() {
        float f10;
        boolean bl2 = this.isNumber();
        if (bl2) {
            Number number = this.getAsNumber();
            f10 = number.floatValue();
        } else {
            String string2 = this.getAsString();
            f10 = Float.parseFloat(string2);
        }
        return f10;
    }

    public int getAsInt() {
        int n10 = this.isNumber();
        if (n10 != 0) {
            Number number = this.getAsNumber();
            n10 = number.intValue();
        } else {
            String string2 = this.getAsString();
            n10 = Integer.parseInt(string2);
        }
        return n10;
    }

    public long getAsLong() {
        long l10;
        boolean bl2 = this.isNumber();
        if (bl2) {
            Number number = this.getAsNumber();
            l10 = number.longValue();
        } else {
            String string2 = this.getAsString();
            l10 = Long.parseLong(string2);
        }
        return l10;
    }

    public Number getAsNumber() {
        Object object = this.value;
        boolean bl2 = object instanceof String;
        if (bl2) {
            String string2 = (String)this.value;
            object = new LazilyParsedNumber(string2);
        } else {
            object = (Number)object;
        }
        return object;
    }

    public short getAsShort() {
        short s10 = this.isNumber();
        if (s10 != 0) {
            Number number = this.getAsNumber();
            s10 = number.shortValue();
        } else {
            String string2 = this.getAsString();
            s10 = Short.parseShort(string2);
        }
        return s10;
    }

    public String getAsString() {
        boolean bl2 = this.isNumber();
        if (bl2) {
            return this.getAsNumber().toString();
        }
        bl2 = this.isBoolean();
        if (bl2) {
            return ((Boolean)this.value).toString();
        }
        return (String)this.value;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int hashCode() {
        long l10;
        Object object = this.value;
        if (object == null) {
            return 31;
        }
        boolean bl2 = JsonPrimitive.isIntegral(this);
        int n10 = 32;
        if (bl2) {
            object = this.getAsNumber();
            l10 = ((Number)object).longValue();
            return (int)(l10 >>> n10 ^ l10);
        }
        object = this.value;
        boolean bl3 = object instanceof Number;
        if (!bl3) return object.hashCode();
        object = this.getAsNumber();
        double d10 = ((Number)object).doubleValue();
        l10 = Double.doubleToLongBits(d10);
        return (int)(l10 >>> n10 ^ l10);
    }

    public boolean isBoolean() {
        return this.value instanceof Boolean;
    }

    public boolean isNumber() {
        return this.value instanceof Number;
    }

    public boolean isString() {
        return this.value instanceof String;
    }
}

