/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;

public final class SourceContextProto {
    private static Descriptors$FileDescriptor descriptor;
    public static final Descriptors$Descriptor internal_static_google_protobuf_SourceContext_descriptor;
    public static final GeneratedMessageV3$FieldAccessorTable internal_static_google_protobuf_SourceContext_fieldAccessorTable;

    static {
        GeneratedMessageV3$FieldAccessorTable generatedMessageV3$FieldAccessorTable;
        Object object = new String[]{"\n$google/protobuf/source_context.proto\u0012\u000fgoogle.protobuf\"\"\n\rSourceContext\u0012\u0011\n\tfile_name\u0018\u0001 \u0001(\tB\u0095\u0001\n\u0013com.google.protobufB\u0012SourceContextProtoP\u0001ZAgoogle.golang.org/genproto/protobuf/source_context;source_context\u00a2\u0002\u0003GPB\u00aa\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"};
        Object[] objectArray = new Descriptors$FileDescriptor[]{};
        descriptor = Descriptors$FileDescriptor.internalBuildGeneratedFileFrom(object, (Descriptors$FileDescriptor[])objectArray);
        internal_static_google_protobuf_SourceContext_descriptor = object = (Descriptors$Descriptor)SourceContextProto.getDescriptor().getMessageTypes().get(0);
        objectArray = new String[]{"FileName"};
        internal_static_google_protobuf_SourceContext_fieldAccessorTable = generatedMessageV3$FieldAccessorTable = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, (String[])objectArray);
    }

    private SourceContextProto() {
    }

    public static Descriptors$FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        SourceContextProto.registerAllExtensions((ExtensionRegistryLite)extensionRegistry);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}

