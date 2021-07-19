/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$UnusedPrivateParameter;
import com.google.protobuf.NewInstanceSchema;

public final class NewInstanceSchemaFull
implements NewInstanceSchema {
    public Object newInstance(Object object) {
        object = (GeneratedMessageV3)object;
        GeneratedMessageV3$UnusedPrivateParameter generatedMessageV3$UnusedPrivateParameter = GeneratedMessageV3$UnusedPrivateParameter.INSTANCE;
        return ((GeneratedMessageV3)object).newInstance(generatedMessageV3$UnusedPrivateParameter);
    }
}

