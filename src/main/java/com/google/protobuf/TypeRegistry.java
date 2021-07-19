/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.TypeRegistry$Builder;
import com.google.protobuf.TypeRegistry$EmptyTypeRegistryHolder;
import java.util.Map;
import java.util.logging.Logger;

public class TypeRegistry {
    private static final Logger logger = Logger.getLogger(TypeRegistry.class.getName());
    private final Map types;

    public TypeRegistry(Map map) {
        this.types = map;
    }

    public static /* synthetic */ Logger access$200() {
        return logger;
    }

    public static TypeRegistry getEmptyTypeRegistry() {
        return TypeRegistry$EmptyTypeRegistryHolder.access$000();
    }

    private static String getTypeName(String string2) {
        int n10;
        Object object = string2.split("/");
        int n11 = ((String[])object).length;
        if (n11 != (n10 = 1)) {
            int n12 = ((String[])object).length - n10;
            return object[n12];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid type url found: ");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new InvalidProtocolBufferException(string2);
        throw object;
    }

    public static TypeRegistry$Builder newBuilder() {
        TypeRegistry$Builder typeRegistry$Builder = new TypeRegistry$Builder(null);
        return typeRegistry$Builder;
    }

    public Descriptors$Descriptor find(String string2) {
        return (Descriptors$Descriptor)this.types.get(string2);
    }

    public final Descriptors$Descriptor getDescriptorForTypeUrl(String string2) {
        string2 = TypeRegistry.getTypeName(string2);
        return this.find(string2);
    }
}

