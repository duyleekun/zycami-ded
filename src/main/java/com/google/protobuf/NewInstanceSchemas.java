/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.NewInstanceSchema;
import com.google.protobuf.NewInstanceSchemaLite;
import java.lang.reflect.Constructor;

public final class NewInstanceSchemas {
    private static final NewInstanceSchema FULL_SCHEMA = NewInstanceSchemas.loadSchemaForFullRuntime();
    private static final NewInstanceSchema LITE_SCHEMA;

    static {
        NewInstanceSchemaLite newInstanceSchemaLite = new NewInstanceSchemaLite();
        LITE_SCHEMA = newInstanceSchemaLite;
    }

    public static NewInstanceSchema full() {
        return FULL_SCHEMA;
    }

    public static NewInstanceSchema lite() {
        return LITE_SCHEMA;
    }

    private static NewInstanceSchema loadSchemaForFullRuntime() {
        Object[] objectArray;
        Constructor constructor = "com.google.protobuf.NewInstanceSchemaFull";
        try {
            constructor = Class.forName((String)((Object)constructor));
            objectArray = null;
        }
        catch (Exception exception) {
            return null;
        }
        Class[] classArray = new Class[]{};
        constructor = ((Class)((Object)constructor)).getDeclaredConstructor(classArray);
        objectArray = new Object[]{};
        constructor = constructor.newInstance(objectArray);
        return (NewInstanceSchema)((Object)constructor);
    }
}

