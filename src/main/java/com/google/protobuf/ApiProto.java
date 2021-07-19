/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.SourceContextProto;
import com.google.protobuf.TypeProto;

public final class ApiProto {
    private static Descriptors$FileDescriptor descriptor;
    public static final Descriptors$Descriptor internal_static_google_protobuf_Api_descriptor;
    public static final GeneratedMessageV3$FieldAccessorTable internal_static_google_protobuf_Api_fieldAccessorTable;
    public static final Descriptors$Descriptor internal_static_google_protobuf_Method_descriptor;
    public static final GeneratedMessageV3$FieldAccessorTable internal_static_google_protobuf_Method_fieldAccessorTable;
    public static final Descriptors$Descriptor internal_static_google_protobuf_Mixin_descriptor;
    public static final GeneratedMessageV3$FieldAccessorTable internal_static_google_protobuf_Mixin_fieldAccessorTable;

    static {
        GeneratedMessageV3$FieldAccessorTable generatedMessageV3$FieldAccessorTable;
        Object object = new String[]{"\n\u0019google/protobuf/api.proto\u0012\u000fgoogle.protobuf\u001a$google/protobuf/source_context.proto\u001a\u001agoogle/protobuf/type.proto\"\u0081\u0002\n\u0003Api\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012(\n\u0007methods\u0018\u0002 \u0003(\u000b2\u0017.google.protobuf.Method\u0012(\n\u0007options\u0018\u0003 \u0003(\u000b2\u0017.google.protobuf.Option\u0012\u000f\n\u0007version\u0018\u0004 \u0001(\t\u00126\n\u000esource_context\u0018\u0005 \u0001(\u000b2\u001e.google.protobuf.SourceContext\u0012&\n\u0006mixins\u0018\u0006 \u0003(\u000b2\u0016.google.protobuf.Mixin\u0012'\n\u0006syntax\u0018\u0007 \u0001(\u000e2\u0017.google.protobuf.Syntax\"\u00d5\u0001\n\u0006Method\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u0018\n\u0010request_type_url\u0018\u0002 \u0001(\t\u0012\u0019\n\u0011request_streaming\u0018\u0003 \u0001(\b\u0012\u0019\n\u0011response_type_url\u0018\u0004 \u0001(\t\u0012\u001a\n\u0012response_streaming\u0018\u0005 \u0001(\b\u0012(\n\u0007options\u0018\u0006 \u0003(\u000b2\u0017.google.protobuf.Option\u0012'\n\u0006syntax\u0018\u0007 \u0001(\u000e2\u0017.google.protobuf.Syntax\"#\n\u0005Mixin\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\f\n\u0004root\u0018\u0002 \u0001(\tBu\n\u0013com.google.protobufB\bApiProtoP\u0001Z+google.golang.org/genproto/protobuf/api;api\u00a2\u0002\u0003GPB\u00aa\u0002\u001eGoogle.Protobuf.WellKnownTypesb\u0006proto3"};
        int n10 = 2;
        Object object2 = new Descriptors$FileDescriptor[n10];
        String[] stringArray = SourceContextProto.getDescriptor();
        object2[0] = stringArray;
        stringArray = TypeProto.getDescriptor();
        int n11 = 1;
        object2[n11] = stringArray;
        descriptor = Descriptors$FileDescriptor.internalBuildGeneratedFileFrom(object, object2);
        internal_static_google_protobuf_Api_descriptor = object = (Descriptors$Descriptor)ApiProto.getDescriptor().getMessageTypes().get(0);
        stringArray = new String[]{"Name", "Methods", "Options", "Version", "SourceContext", "Mixins", "Syntax"};
        internal_static_google_protobuf_Api_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, stringArray);
        internal_static_google_protobuf_Method_descriptor = object = (Descriptors$Descriptor)ApiProto.getDescriptor().getMessageTypes().get(n11);
        stringArray = new String[]{"Name", "RequestTypeUrl", "RequestStreaming", "ResponseTypeUrl", "ResponseStreaming", "Options", "Syntax"};
        internal_static_google_protobuf_Method_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, stringArray);
        internal_static_google_protobuf_Mixin_descriptor = object = (Descriptors$Descriptor)ApiProto.getDescriptor().getMessageTypes().get(n10);
        object2 = new String[]{"Name", "Root"};
        internal_static_google_protobuf_Mixin_fieldAccessorTable = generatedMessageV3$FieldAccessorTable = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, (String[])object2);
        SourceContextProto.getDescriptor();
        TypeProto.getDescriptor();
    }

    private ApiProto() {
    }

    public static Descriptors$FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        ApiProto.registerAllExtensions((ExtensionRegistryLite)extensionRegistry);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}

