/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ExtensionSchema;
import com.google.protobuf.ExtensionSchemaLite;
import java.lang.reflect.Constructor;

public final class ExtensionSchemas {
    private static final ExtensionSchema FULL_SCHEMA;
    private static final ExtensionSchema LITE_SCHEMA;

    static {
        ExtensionSchemaLite extensionSchemaLite = new ExtensionSchemaLite();
        LITE_SCHEMA = extensionSchemaLite;
        FULL_SCHEMA = ExtensionSchemas.loadSchemaForFullRuntime();
    }

    public static ExtensionSchema full() {
        Object object = FULL_SCHEMA;
        if (object != null) {
            return object;
        }
        object = new IllegalStateException("Protobuf runtime is not correctly loaded.");
        throw object;
    }

    public static ExtensionSchema lite() {
        return LITE_SCHEMA;
    }

    private static ExtensionSchema loadSchemaForFullRuntime() {
        Object[] objectArray;
        Constructor constructor = "com.google.protobuf.ExtensionSchemaFull";
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
        return (ExtensionSchema)((Object)constructor);
    }
}

