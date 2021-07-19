/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;

public final class AnyProto {
    private static Descriptors$FileDescriptor descriptor;
    public static final Descriptors$Descriptor internal_static_google_protobuf_Any_descriptor;
    public static final GeneratedMessageV3$FieldAccessorTable internal_static_google_protobuf_Any_fieldAccessorTable;

    static {
        GeneratedMessageV3$FieldAccessorTable generatedMessageV3$FieldAccessorTable;
        Object object = new String[]{"\n\u0019google/protobuf/any.proto\u0012\u000fgoogle.protobuf\"&\n\u0003Any\u0012\u0010\n\btype_url\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\fBo\n\u0013com.google.protobufB\bAnyProtoP\u0001Z%github.com/golang/protobuf/ptypes/any\u00a2\u0002\u0003GPB\u00aa\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"};
        Object[] objectArray = new Descriptors$FileDescriptor[]{};
        descriptor = Descriptors$FileDescriptor.internalBuildGeneratedFileFrom(object, (Descriptors$FileDescriptor[])objectArray);
        internal_static_google_protobuf_Any_descriptor = object = (Descriptors$Descriptor)AnyProto.getDescriptor().getMessageTypes().get(0);
        objectArray = new String[]{"TypeUrl", "Value"};
        internal_static_google_protobuf_Any_fieldAccessorTable = generatedMessageV3$FieldAccessorTable = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, (String[])objectArray);
    }

    private AnyProto() {
    }

    public static Descriptors$FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        AnyProto.registerAllExtensions((ExtensionRegistryLite)extensionRegistry);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}

