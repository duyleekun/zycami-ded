/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;

public final class FieldMaskProto {
    private static Descriptors$FileDescriptor descriptor;
    public static final Descriptors$Descriptor internal_static_google_protobuf_FieldMask_descriptor;
    public static final GeneratedMessageV3$FieldAccessorTable internal_static_google_protobuf_FieldMask_fieldAccessorTable;

    static {
        GeneratedMessageV3$FieldAccessorTable generatedMessageV3$FieldAccessorTable;
        Object object = new String[]{"\n google/protobuf/field_mask.proto\u0012\u000fgoogle.protobuf\"\u001a\n\tFieldMask\u0012\r\n\u0005paths\u0018\u0001 \u0003(\tB\u008c\u0001\n\u0013com.google.protobufB\u000eFieldMaskProtoP\u0001Z9google.golang.org/genproto/protobuf/field_mask;field_mask\u00f8\u0001\u0001\u00a2\u0002\u0003GPB\u00aa\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"};
        Object[] objectArray = new Descriptors$FileDescriptor[]{};
        descriptor = Descriptors$FileDescriptor.internalBuildGeneratedFileFrom(object, (Descriptors$FileDescriptor[])objectArray);
        internal_static_google_protobuf_FieldMask_descriptor = object = (Descriptors$Descriptor)FieldMaskProto.getDescriptor().getMessageTypes().get(0);
        objectArray = new String[]{"Paths"};
        internal_static_google_protobuf_FieldMask_fieldAccessorTable = generatedMessageV3$FieldAccessorTable = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, (String[])objectArray);
    }

    private FieldMaskProto() {
    }

    public static Descriptors$FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        FieldMaskProto.registerAllExtensions((ExtensionRegistryLite)extensionRegistry);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}

