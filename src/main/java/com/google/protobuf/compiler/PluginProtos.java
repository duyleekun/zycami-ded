/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf.compiler;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;

public final class PluginProtos {
    private static Descriptors$FileDescriptor descriptor;
    private static final Descriptors$Descriptor internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable;
    private static final Descriptors$Descriptor internal_static_google_protobuf_compiler_Version_descriptor;
    private static final GeneratedMessageV3$FieldAccessorTable internal_static_google_protobuf_compiler_Version_fieldAccessorTable;

    static {
        GeneratedMessageV3$FieldAccessorTable generatedMessageV3$FieldAccessorTable;
        Object object = new String[]{"\n%google/protobuf/compiler/plugin.proto\u0012\u0018google.protobuf.compiler\u001a google/protobuf/descriptor.proto\"F\n\u0007Version\u0012\r\n\u0005major\u0018\u0001 \u0001(\u0005\u0012\r\n\u0005minor\u0018\u0002 \u0001(\u0005\u0012\r\n\u0005patch\u0018\u0003 \u0001(\u0005\u0012\u000e\n\u0006suffix\u0018\u0004 \u0001(\t\"\u00ba\u0001\n\u0014CodeGeneratorRequest\u0012\u0018\n\u0010file_to_generate\u0018\u0001 \u0003(\t\u0012\u0011\n\tparameter\u0018\u0002 \u0001(\t\u00128\n\nproto_file\u0018\u000f \u0003(\u000b2$.google.protobuf.FileDescriptorProto\u0012;\n\u0010compiler_version\u0018\u0003 \u0001(\u000b2!.google.protobuf.compiler.Version\"\u00aa\u0001\n\u0015CodeGeneratorResponse\u0012\r\n\u0005error\u0018\u0001 \u0001(\t\u0012B\n\u0004file\u0018\u000f \u0003(\u000b24.google.protobuf.compiler.CodeGeneratorResponse.File\u001a>\n\u0004File\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u0017\n\u000finsertion_point\u0018\u0002 \u0001(\t\u0012\u000f\n\u0007content\u0018\u000f \u0001(\tBg\n\u001ccom.google.protobuf.compilerB\fPluginProtosZ9github.com/golang/protobuf/protoc-gen-go/plugin;plugin_go"};
        int n10 = 1;
        Object object2 = new Descriptors$FileDescriptor[n10];
        String[] stringArray = DescriptorProtos.getDescriptor();
        object2[0] = stringArray;
        descriptor = Descriptors$FileDescriptor.internalBuildGeneratedFileFrom((String[])object, object2);
        object = (Descriptors$Descriptor)PluginProtos.getDescriptor().getMessageTypes().get(0);
        internal_static_google_protobuf_compiler_Version_descriptor = object;
        stringArray = new String[]{"Major", "Minor", "Patch", "Suffix"};
        internal_static_google_protobuf_compiler_Version_fieldAccessorTable = object2 = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, stringArray);
        object = (Descriptors$Descriptor)PluginProtos.getDescriptor().getMessageTypes().get(n10);
        internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor = object;
        object2 = new String[]{"FileToGenerate", "Parameter", "ProtoFile", "CompilerVersion"};
        internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable = generatedMessageV3$FieldAccessorTable = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, (String[])object2);
        internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor = object = (Descriptors$Descriptor)PluginProtos.getDescriptor().getMessageTypes().get(2);
        object2 = new String[]{"Error", "File"};
        internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable = generatedMessageV3$FieldAccessorTable = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, (String[])object2);
        internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor = object = (Descriptors$Descriptor)((Descriptors$Descriptor)object).getNestedTypes().get(0);
        object2 = new String[]{"Name", "InsertionPoint", "Content"};
        internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable = generatedMessageV3$FieldAccessorTable = new GeneratedMessageV3$FieldAccessorTable((Descriptors$Descriptor)object, (String[])object2);
        DescriptorProtos.getDescriptor();
    }

    private PluginProtos() {
    }

    public static /* synthetic */ Descriptors$Descriptor access$000() {
        return internal_static_google_protobuf_compiler_Version_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$100() {
        return internal_static_google_protobuf_compiler_Version_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$1300() {
        return internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$1400() {
        return internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$2700() {
        return internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$2800() {
        return internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors$Descriptor access$2900() {
        return internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3$FieldAccessorTable access$3000() {
        return internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable;
    }

    public static Descriptors$FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        PluginProtos.registerAllExtensions((ExtensionRegistryLite)extensionRegistry);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}

