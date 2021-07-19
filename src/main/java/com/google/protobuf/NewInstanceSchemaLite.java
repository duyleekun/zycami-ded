/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.NewInstanceSchema;

public final class NewInstanceSchemaLite
implements NewInstanceSchema {
    public Object newInstance(Object object) {
        object = (GeneratedMessageLite)object;
        GeneratedMessageLite$MethodToInvoke generatedMessageLite$MethodToInvoke = GeneratedMessageLite$MethodToInvoke.NEW_MUTABLE_INSTANCE;
        return ((GeneratedMessageLite)object).dynamicMethod(generatedMessageLite$MethodToInvoke);
    }
}

