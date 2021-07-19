/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.MessageInfo;
import com.google.protobuf.MessageInfoFactory;

public final class ManifestSchemaFactory$1
implements MessageInfoFactory {
    public boolean isSupported(Class clazz) {
        return false;
    }

    public MessageInfo messageInfoFor(Class serializable) {
        serializable = new IllegalStateException("This should never be called.");
        throw serializable;
    }
}

