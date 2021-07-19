/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.common.exception;

import com.zhiyun.common.exception.ValueException;
import com.zhiyun.common.exception.ValueException$a;

public class ValueException$b {
    public Object a;
    public final /* synthetic */ ValueException b;

    private ValueException$b(ValueException valueException, Object object) {
        this.b = valueException;
        this.a = object;
        valueException.mValue = this;
    }

    public /* synthetic */ ValueException$b(ValueException valueException, Object object, ValueException$a valueException$a) {
        this(valueException, object);
    }

    public ValueException a() {
        return this.b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Value{value=");
        Object object = this.a;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

