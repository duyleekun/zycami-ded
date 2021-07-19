/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos$MessageOptions;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.DynamicMessage$1;
import com.google.protobuf.DynamicMessage$Builder;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FieldSet;
import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

public final class DynamicMessage
extends AbstractMessage {
    private final FieldSet fields;
    private int memoizedSize = -1;
    private final Descriptors$FieldDescriptor[] oneofCases;
    private final Descriptors$Descriptor type;
    private final UnknownFieldSet unknownFields;

    public DynamicMessage(Descriptors$Descriptor descriptors$Descriptor, FieldSet fieldSet, Descriptors$FieldDescriptor[] descriptors$FieldDescriptorArray, UnknownFieldSet unknownFieldSet) {
        this.type = descriptors$Descriptor;
        this.fields = fieldSet;
        this.oneofCases = descriptors$FieldDescriptorArray;
        this.unknownFields = unknownFieldSet;
    }

    public static /* synthetic */ Descriptors$Descriptor access$200(DynamicMessage dynamicMessage) {
        return dynamicMessage.type;
    }

    public static /* synthetic */ FieldSet access$300(DynamicMessage dynamicMessage) {
        return dynamicMessage.fields;
    }

    public static /* synthetic */ UnknownFieldSet access$400(DynamicMessage dynamicMessage) {
        return dynamicMessage.unknownFields;
    }

    public static /* synthetic */ Descriptors$FieldDescriptor[] access$500(DynamicMessage dynamicMessage) {
        return dynamicMessage.oneofCases;
    }

    public static DynamicMessage getDefaultInstance(Descriptors$Descriptor descriptors$Descriptor) {
        Descriptors$FieldDescriptor[] descriptors$FieldDescriptorArray = new Descriptors$FieldDescriptor[descriptors$Descriptor.toProto().getOneofDeclCount()];
        FieldSet fieldSet = FieldSet.emptySet();
        UnknownFieldSet unknownFieldSet = UnknownFieldSet.getDefaultInstance();
        DynamicMessage dynamicMessage = new DynamicMessage(descriptors$Descriptor, fieldSet, descriptors$FieldDescriptorArray, unknownFieldSet);
        return dynamicMessage;
    }

    public static boolean isInitialized(Descriptors$Descriptor object, FieldSet fieldSet) {
        boolean bl2;
        object = ((Descriptors$Descriptor)object).getFields().iterator();
        while (bl2 = object.hasNext()) {
            Descriptors$FieldDescriptor descriptors$FieldDescriptor = (Descriptors$FieldDescriptor)object.next();
            boolean bl3 = descriptors$FieldDescriptor.isRequired();
            if (!bl3 || (bl2 = fieldSet.hasField(descriptors$FieldDescriptor))) continue;
            return false;
        }
        return fieldSet.isInitialized();
    }

    public static DynamicMessage$Builder newBuilder(Descriptors$Descriptor descriptors$Descriptor) {
        DynamicMessage$Builder dynamicMessage$Builder = new DynamicMessage$Builder(descriptors$Descriptor, null);
        return dynamicMessage$Builder;
    }

    public static DynamicMessage$Builder newBuilder(Message message) {
        Descriptors$Descriptor descriptors$Descriptor = message.getDescriptorForType();
        DynamicMessage$Builder dynamicMessage$Builder = new DynamicMessage$Builder(descriptors$Descriptor, null);
        return dynamicMessage$Builder.mergeFrom(message);
    }

    public static DynamicMessage parseFrom(Descriptors$Descriptor descriptors$Descriptor, ByteString byteString) {
        return DynamicMessage$Builder.access$000((DynamicMessage$Builder)DynamicMessage.newBuilder(descriptors$Descriptor).mergeFrom(byteString));
    }

    public static DynamicMessage parseFrom(Descriptors$Descriptor descriptors$Descriptor, ByteString byteString, ExtensionRegistry extensionRegistry) {
        return DynamicMessage$Builder.access$000((DynamicMessage$Builder)DynamicMessage.newBuilder(descriptors$Descriptor).mergeFrom(byteString, (ExtensionRegistryLite)extensionRegistry));
    }

    public static DynamicMessage parseFrom(Descriptors$Descriptor descriptors$Descriptor, CodedInputStream codedInputStream) {
        return DynamicMessage$Builder.access$000((DynamicMessage$Builder)DynamicMessage.newBuilder(descriptors$Descriptor).mergeFrom(codedInputStream));
    }

    public static DynamicMessage parseFrom(Descriptors$Descriptor descriptors$Descriptor, CodedInputStream codedInputStream, ExtensionRegistry extensionRegistry) {
        return DynamicMessage$Builder.access$000((DynamicMessage$Builder)DynamicMessage.newBuilder(descriptors$Descriptor).mergeFrom(codedInputStream, (ExtensionRegistryLite)extensionRegistry));
    }

    public static DynamicMessage parseFrom(Descriptors$Descriptor descriptors$Descriptor, InputStream inputStream) {
        return DynamicMessage$Builder.access$000((DynamicMessage$Builder)DynamicMessage.newBuilder(descriptors$Descriptor).mergeFrom(inputStream));
    }

    public static DynamicMessage parseFrom(Descriptors$Descriptor descriptors$Descriptor, InputStream inputStream, ExtensionRegistry extensionRegistry) {
        return DynamicMessage$Builder.access$000((DynamicMessage$Builder)DynamicMessage.newBuilder(descriptors$Descriptor).mergeFrom(inputStream, (ExtensionRegistryLite)extensionRegistry));
    }

    public static DynamicMessage parseFrom(Descriptors$Descriptor descriptors$Descriptor, byte[] byArray) {
        return DynamicMessage$Builder.access$000((DynamicMessage$Builder)DynamicMessage.newBuilder(descriptors$Descriptor).mergeFrom(byArray));
    }

    public static DynamicMessage parseFrom(Descriptors$Descriptor descriptors$Descriptor, byte[] byArray, ExtensionRegistry extensionRegistry) {
        return DynamicMessage$Builder.access$000((DynamicMessage$Builder)DynamicMessage.newBuilder(descriptors$Descriptor).mergeFrom(byArray, (ExtensionRegistryLite)extensionRegistry));
    }

    private void verifyContainingType(Descriptors$FieldDescriptor object) {
        Descriptors$Descriptor descriptors$Descriptor;
        if ((object = ((Descriptors$FieldDescriptor)object).getContainingType()) == (descriptors$Descriptor = this.type)) {
            return;
        }
        object = new IllegalArgumentException("FieldDescriptor does not match message type.");
        throw object;
    }

    private void verifyOneofContainingType(Descriptors$OneofDescriptor object) {
        Descriptors$Descriptor descriptors$Descriptor;
        if ((object = ((Descriptors$OneofDescriptor)object).getContainingType()) == (descriptors$Descriptor = this.type)) {
            return;
        }
        object = new IllegalArgumentException("OneofDescriptor does not match message type.");
        throw object;
    }

    public Map getAllFields() {
        return this.fields.getAllFields();
    }

    public DynamicMessage getDefaultInstanceForType() {
        return DynamicMessage.getDefaultInstance(this.type);
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return this.type;
    }

    public Object getField(Descriptors$FieldDescriptor descriptors$GenericDescriptor) {
        this.verifyContainingType((Descriptors$FieldDescriptor)descriptors$GenericDescriptor);
        Object object = this.fields.getField((FieldSet$FieldDescriptorLite)((Object)descriptors$GenericDescriptor));
        if (object == null) {
            boolean bl2 = descriptors$GenericDescriptor.isRepeated();
            if (bl2) {
                object = Collections.emptyList();
            } else {
                Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType;
                object = descriptors$GenericDescriptor.getJavaType();
                if (object == (descriptors$FieldDescriptor$JavaType = Descriptors$FieldDescriptor$JavaType.MESSAGE)) {
                    descriptors$GenericDescriptor = descriptors$GenericDescriptor.getMessageType();
                    object = DynamicMessage.getDefaultInstance((Descriptors$Descriptor)descriptors$GenericDescriptor);
                } else {
                    object = descriptors$GenericDescriptor.getDefaultValue();
                }
            }
        }
        return object;
    }

    public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        this.verifyOneofContainingType(descriptors$OneofDescriptor);
        Descriptors$FieldDescriptor[] descriptors$FieldDescriptorArray = this.oneofCases;
        int n10 = descriptors$OneofDescriptor.getIndex();
        return descriptors$FieldDescriptorArray[n10];
    }

    public Parser getParserForType() {
        DynamicMessage$1 dynamicMessage$1 = new DynamicMessage$1(this);
        return dynamicMessage$1;
    }

    public Object getRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        return this.fields.getRepeatedField(descriptors$FieldDescriptor, n10);
    }

    public int getRepeatedFieldCount(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        return this.fields.getRepeatedFieldCount(descriptors$FieldDescriptor);
    }

    public int getSerializedSize() {
        int n10 = this.memoizedSize;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        Object object = this.type.getOptions();
        n10 = (int)(((DescriptorProtos$MessageOptions)object).getMessageSetWireFormat() ? 1 : 0);
        if (n10 != 0) {
            object = this.fields;
            n10 = ((FieldSet)object).getMessageSetSerializedSize();
            UnknownFieldSet unknownFieldSet = this.unknownFields;
            n11 = unknownFieldSet.getSerializedSizeAsMessageSet();
        } else {
            object = this.fields;
            n10 = ((FieldSet)object).getSerializedSize();
            UnknownFieldSet unknownFieldSet = this.unknownFields;
            n11 = unknownFieldSet.getSerializedSize();
        }
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        this.verifyContainingType(descriptors$FieldDescriptor);
        return this.fields.hasField(descriptors$FieldDescriptor);
    }

    public boolean hasOneof(Descriptors$OneofDescriptor descriptors$GenericDescriptor) {
        this.verifyOneofContainingType((Descriptors$OneofDescriptor)descriptors$GenericDescriptor);
        Descriptors$FieldDescriptor[] descriptors$FieldDescriptorArray = this.oneofCases;
        int n10 = descriptors$GenericDescriptor.getIndex();
        descriptors$GenericDescriptor = descriptors$FieldDescriptorArray[n10];
        return descriptors$GenericDescriptor != null;
    }

    public boolean isInitialized() {
        Descriptors$Descriptor descriptors$Descriptor = this.type;
        FieldSet fieldSet = this.fields;
        return DynamicMessage.isInitialized(descriptors$Descriptor, fieldSet);
    }

    public DynamicMessage$Builder newBuilderForType() {
        Descriptors$Descriptor descriptors$Descriptor = this.type;
        DynamicMessage$Builder dynamicMessage$Builder = new DynamicMessage$Builder(descriptors$Descriptor, null);
        return dynamicMessage$Builder;
    }

    public DynamicMessage$Builder toBuilder() {
        return this.newBuilderForType().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        MessageLite messageLite = this.type.getOptions();
        boolean bl2 = ((DescriptorProtos$MessageOptions)messageLite).getMessageSetWireFormat();
        if (bl2) {
            this.fields.writeMessageSetTo(codedOutputStream);
            messageLite = this.unknownFields;
            ((UnknownFieldSet)messageLite).writeAsMessageSetTo(codedOutputStream);
        } else {
            this.fields.writeTo(codedOutputStream);
            messageLite = this.unknownFields;
            ((UnknownFieldSet)messageLite).writeTo(codedOutputStream);
        }
    }
}

