/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.stabilizer.exception;

import com.zhiyun.protocol.constants.Model;

public class UnsupportedException
extends UnsupportedOperationException {
    public UnsupportedException() {
        super("This operation is not supported!");
    }

    public UnsupportedException(Model object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The ");
        object = object.toString();
        stringBuilder.append((String)object);
        stringBuilder.append(" does not support this operation!");
        object = stringBuilder.toString();
        super((String)object);
    }
}

