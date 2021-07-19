/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;

public final class EmptyProto {
    private static Descriptors$FileDescriptor descriptor;
    public static final Descriptors$Descriptor internal_static_google_protobuf_Empty_descriptor;
    public static final GeneratedMessageV3$FieldAccessorTable internal_static_google_protobuf_Empty_fieldAccessorTable;

    static {
        Object object = new String[]{"\n\u001bgoogle/protobuf/empty.proto\u0012\u000fgoogle.protobuf\"\u0007\n\u0005EmptyBv\n\u0013com.google.protobufB\nEmptyProtoP\u0001Z'github.com/golang/protobuf/ptypes/empty\u00f8\u0001\u0001\u00a2\u0002\u0003GPB\u00aa\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"};
        Object object2 = new Descriptors$FileDescriptor[]{};
        descriptor = Descriptors$FileDescriptor.internalBuildGeneratedFileFrom(object, object2);
        internal_static_google_protobuf_Empty_descriptor = object = (Descriptors$Descriptor)EmptyProto.getDescriptor().getMessageTypes().get(0);
        String[] stringArray = new String[]{};
        internal_static_google_protobuf_Empty_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, stringArray);
    }

    private EmptyProto() {
    }

    public static Descriptors$FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        EmptyProto.registerAllExtensions((ExtensionRegistryLite)extensionRegistry);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}

