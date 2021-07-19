/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;

public final class TimestampProto {
    private static Descriptors$FileDescriptor descriptor;
    public static final Descriptors$Descriptor internal_static_google_protobuf_Timestamp_descriptor;
    public static final GeneratedMessageV3$FieldAccessorTable internal_static_google_protobuf_Timestamp_fieldAccessorTable;

    static {
        GeneratedMessageV3$FieldAccessorTable generatedMessageV3$FieldAccessorTable;
        Object object = new String[]{"\n\u001fgoogle/protobuf/timestamp.proto\u0012\u000fgoogle.protobuf\"+\n\tTimestamp\u0012\u000f\n\u0007seconds\u0018\u0001 \u0001(\u0003\u0012\r\n\u0005nanos\u0018\u0002 \u0001(\u0005B~\n\u0013com.google.protobufB\u000eTimestampProtoP\u0001Z+github.com/golang/protobuf/ptypes/timestamp\u00f8\u0001\u0001\u00a2\u0002\u0003GPB\u00aa\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"};
        Object[] objectArray = new Descriptors$FileDescriptor[]{};
        descriptor = Descriptors$FileDescriptor.internalBuildGeneratedFileFrom(object, (Descriptors$FileDescriptor[])objectArray);
        internal_static_google_protobuf_Timestamp_descriptor = object = (Descriptors$Descriptor)TimestampProto.getDescriptor().getMessageTypes().get(0);
        objectArray = new String[]{"Seconds", "Nanos"};
        internal_static_google_protobuf_Timestamp_fieldAccessorTable = generatedMessageV3$FieldAccessorTable = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, (String[])objectArray);
    }

    private TimestampProto() {
    }

    public static Descriptors$FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        TimestampProto.registerAllExtensions((ExtensionRegistryLite)extensionRegistry);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}

