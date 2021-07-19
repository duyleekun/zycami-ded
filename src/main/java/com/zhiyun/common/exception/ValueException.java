/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.common.exception;

import com.zhiyun.common.exception.ValueException$b;
import java.io.Serializable;
import java.util.Objects;

public class ValueException
extends Exception {
    public ValueException$b mValue;

    private ValueException() {
    }

    private ValueException(String string2) {
        super(string2);
    }

    private ValueException(String string2, Throwable throwable) {
        super(string2, throwable);
    }

    private ValueException(Throwable throwable) {
        super(throwable);
    }

    public static ValueException create(ValueException valueException, Object object) {
        return ValueException.createValue(valueException, object).a();
    }

    public static ValueException create(String string2, Object object) {
        return ValueException.createValue(string2, object).a();
    }

    public static ValueException create(String string2, Throwable throwable, Object object) {
        return ValueException.createValue(string2, throwable, object).a();
    }

    public static ValueException create(Throwable throwable, Object object) {
        return ValueException.createValue(throwable, object).a();
    }

    public static ValueException$b createValue(ValueException valueException, Object object) {
        Objects.requireNonNull(valueException);
        Objects.requireNonNull(valueException);
        ValueException$b valueException$b = new ValueException$b(valueException, object, null);
        return valueException$b;
    }

    public static ValueException$b createValue(String string2, Object object) {
        ValueException valueException = new ValueException(string2);
        return ValueException.createValue(valueException, object);
    }

    public static ValueException$b createValue(String string2, Throwable throwable, Object object) {
        ValueException valueException = string2 != null && throwable != null ? new ValueException(string2, throwable) : (string2 == null && throwable == null ? new ValueException() : (string2 == null ? new ValueException(throwable) : (throwable == null ? new ValueException(string2) : null)));
        return ValueException.createValue(valueException, object);
    }

    public static ValueException$b createValue(Throwable throwable, Object object) {
        ValueException valueException = new ValueException(throwable);
        return ValueException.createValue(valueException, object);
    }

    public Object getValue(Class clazz) {
        Object object = this.mValue.a;
        boolean bl2 = clazz.isInstance(object);
        if (bl2) {
            return object;
        }
        return null;
    }

    public String toString() {
        Serializable serializable = this.getCause();
        if (serializable != null) {
            ((Throwable)serializable).printStackTrace();
        }
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("ValueException{,message=");
        Object object = this.getMessage();
        ((StringBuilder)serializable).append((String)object);
        ((StringBuilder)serializable).append(",mValue=");
        object = this.mValue;
        ((StringBuilder)serializable).append(object);
        ((StringBuilder)serializable).append('}');
        return ((StringBuilder)serializable).toString();
    }
}

