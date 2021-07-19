/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf.compiler;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.GeneratedMessageV3$UnusedPrivateParameter;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import com.google.protobuf.compiler.PluginProtos;
import com.google.protobuf.compiler.PluginProtos$1;
import com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$1;
import com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$Builder;
import com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$File;
import com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$FileOrBuilder;
import com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponseOrBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class PluginProtos$CodeGeneratorResponse
extends GeneratedMessageV3
implements PluginProtos$CodeGeneratorResponseOrBuilder {
    private static final PluginProtos$CodeGeneratorResponse DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 1;
    public static final int FILE_FIELD_NUMBER = 15;
    public static final Parser PARSER;
    private static final long serialVersionUID;
    private int bitField0_;
    private volatile Object error_;
    private List file_;
    private byte memoizedIsInitialized = (byte)-1;

    static {
        Object object = new PluginProtos$CodeGeneratorResponse();
        DEFAULT_INSTANCE = object;
        PARSER = object = new PluginProtos$CodeGeneratorResponse$1();
    }

    private PluginProtos$CodeGeneratorResponse() {
        List list;
        this.error_ = "";
        this.file_ = list = Collections.emptyList();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private PluginProtos$CodeGeneratorResponse(CodedInputStream list, ExtensionRegistryLite list2) {
        this();
        Objects.requireNonNull(list2);
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        int n10 = 0;
        int n11 = 0;
        while (n10 == 0) {
            try {
                try {
                    int n12;
                    block13: {
                        int n13 = ((CodedInputStream)((Object)list)).readTag();
                        n12 = 1;
                        if (n13 != 0) {
                            Iterable iterable;
                            int n14 = 10;
                            if (n13 != n14) {
                                n14 = 122;
                                if (n13 != n14) {
                                    if ((n13 = (int)(this.parseUnknownField((CodedInputStream)((Object)list), unknownFieldSet$Builder, (ExtensionRegistryLite)((Object)list2), n13) ? 1 : 0)) != 0) continue;
                                    break block13;
                                } else {
                                    n13 = n11 & 2;
                                    if (n13 == 0) {
                                        this.file_ = iterable;
                                        n11 |= 2;
                                    }
                                    iterable = this.file_;
                                    Object object = PluginProtos$CodeGeneratorResponse$File.PARSER;
                                    object = ((CodedInputStream)((Object)list)).readMessage((Parser)object, (ExtensionRegistryLite)((Object)list2));
                                    iterable.add(object);
                                    continue;
                                }
                            }
                            iterable = ((CodedInputStream)((Object)list)).readBytes();
                            n14 = this.bitField0_;
                            this.bitField0_ = n12 |= n14;
                            this.error_ = iterable;
                            continue;
                        }
                    }
                    n10 = n12;
                    continue;
                }
                catch (IOException iOException) {
                    list2 = new List(iOException);
                    InvalidProtocolBufferException invalidProtocolBufferException = ((InvalidProtocolBufferException)((Object)list2)).setUnfinishedMessage(this);
                    throw invalidProtocolBufferException;
                }
                catch (InvalidProtocolBufferException invalidProtocolBufferException) {
                    InvalidProtocolBufferException invalidProtocolBufferException2 = invalidProtocolBufferException.setUnfinishedMessage(this);
                    throw invalidProtocolBufferException2;
                }
            }
            catch (Throwable throwable) {}
            int n15 = n11 & 2;
            if (n15 != 0) {
                this.file_ = list2 = Collections.unmodifiableList(this.file_);
            }
            list2 = unknownFieldSet$Builder.build();
            this.unknownFields = list2;
            this.makeExtensionsImmutable();
            throw throwable;
        }
        int n16 = n11 & 2;
        if (n16 != 0) {
            this.file_ = list = Collections.unmodifiableList(this.file_);
        }
        list = unknownFieldSet$Builder.build();
        this.unknownFields = list;
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ PluginProtos$CodeGeneratorResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, PluginProtos$1 pluginProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private PluginProtos$CodeGeneratorResponse(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ PluginProtos$CodeGeneratorResponse(GeneratedMessageV3$Builder generatedMessageV3$Builder, PluginProtos$1 pluginProtos$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$4300() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ Object access$4500(PluginProtos$CodeGeneratorResponse pluginProtos$CodeGeneratorResponse) {
        return pluginProtos$CodeGeneratorResponse.error_;
    }

    public static /* synthetic */ Object access$4502(PluginProtos$CodeGeneratorResponse pluginProtos$CodeGeneratorResponse, Object object) {
        pluginProtos$CodeGeneratorResponse.error_ = object;
        return object;
    }

    public static /* synthetic */ List access$4600(PluginProtos$CodeGeneratorResponse pluginProtos$CodeGeneratorResponse) {
        return pluginProtos$CodeGeneratorResponse.file_;
    }

    public static /* synthetic */ List access$4602(PluginProtos$CodeGeneratorResponse pluginProtos$CodeGeneratorResponse, List list) {
        pluginProtos$CodeGeneratorResponse.file_ = list;
        return list;
    }

    public static /* synthetic */ int access$4702(PluginProtos$CodeGeneratorResponse pluginProtos$CodeGeneratorResponse, int n10) {
        pluginProtos$CodeGeneratorResponse.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ boolean access$4800() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ UnknownFieldSet access$4900(PluginProtos$CodeGeneratorResponse pluginProtos$CodeGeneratorResponse) {
        return pluginProtos$CodeGeneratorResponse.unknownFields;
    }

    public static PluginProtos$CodeGeneratorResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return PluginProtos.access$2700();
    }

    public static PluginProtos$CodeGeneratorResponse$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static PluginProtos$CodeGeneratorResponse$Builder newBuilder(PluginProtos$CodeGeneratorResponse pluginProtos$CodeGeneratorResponse) {
        return ((PluginProtos$CodeGeneratorResponse$Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(pluginProtos$CodeGeneratorResponse);
    }

    public static PluginProtos$CodeGeneratorResponse parseDelimitedFrom(InputStream inputStream) {
        return (PluginProtos$CodeGeneratorResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PluginProtos$CodeGeneratorResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PluginProtos$CodeGeneratorResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PluginProtos$CodeGeneratorResponse parseFrom(ByteString byteString) {
        return (PluginProtos$CodeGeneratorResponse)PARSER.parseFrom(byteString);
    }

    public static PluginProtos$CodeGeneratorResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PluginProtos$CodeGeneratorResponse)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PluginProtos$CodeGeneratorResponse parseFrom(CodedInputStream codedInputStream) {
        return (PluginProtos$CodeGeneratorResponse)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static PluginProtos$CodeGeneratorResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PluginProtos$CodeGeneratorResponse)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static PluginProtos$CodeGeneratorResponse parseFrom(InputStream inputStream) {
        return (PluginProtos$CodeGeneratorResponse)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static PluginProtos$CodeGeneratorResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PluginProtos$CodeGeneratorResponse)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PluginProtos$CodeGeneratorResponse parseFrom(ByteBuffer byteBuffer) {
        return (PluginProtos$CodeGeneratorResponse)PARSER.parseFrom(byteBuffer);
    }

    public static PluginProtos$CodeGeneratorResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PluginProtos$CodeGeneratorResponse)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PluginProtos$CodeGeneratorResponse parseFrom(byte[] byArray) {
        return (PluginProtos$CodeGeneratorResponse)PARSER.parseFrom(byArray);
    }

    public static PluginProtos$CodeGeneratorResponse parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (PluginProtos$CodeGeneratorResponse)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        boolean bl4 = object instanceof PluginProtos$CodeGeneratorResponse;
        if (!bl4) {
            return super.equals(object);
        }
        object = (PluginProtos$CodeGeneratorResponse)object;
        bl4 = this.hasError();
        if (bl4 != (bl2 = ((PluginProtos$CodeGeneratorResponse)object).hasError())) {
            return false;
        }
        bl4 = this.hasError();
        if (bl4 && !(bl4 = ((String)(object3 = this.getError())).equals(object2 = ((PluginProtos$CodeGeneratorResponse)object).getError()))) {
            return false;
        }
        object3 = this.getFileList();
        bl4 = object3.equals(object2 = ((PluginProtos$CodeGeneratorResponse)object).getFileList());
        if (!bl4) {
            return false;
        }
        object3 = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl5 = ((UnknownFieldSet)object3).equals(object);
        if (!bl5) {
            return false;
        }
        return bl3;
    }

    public PluginProtos$CodeGeneratorResponse getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public String getError() {
        Object object = this.error_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.error_ = string2;
        }
        return string2;
    }

    public ByteString getErrorBytes() {
        Object object = this.error_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.error_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public PluginProtos$CodeGeneratorResponse$File getFile(int n10) {
        return (PluginProtos$CodeGeneratorResponse$File)this.file_.get(n10);
    }

    public int getFileCount() {
        return this.file_.size();
    }

    public List getFileList() {
        return this.file_;
    }

    public PluginProtos$CodeGeneratorResponse$FileOrBuilder getFileOrBuilder(int n10) {
        return (PluginProtos$CodeGeneratorResponse$FileOrBuilder)this.file_.get(n10);
    }

    public List getFileOrBuilderList() {
        return this.file_;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        List list;
        Object object;
        int n10 = this.memoizedSize;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n10 = this.bitField0_;
        n11 = 1;
        int n12 = 0;
        if ((n10 &= n11) != 0) {
            object = this.error_;
            n10 = GeneratedMessageV3.computeStringSize(n11, object) + 0;
        } else {
            n10 = 0;
            object = null;
        }
        while (n12 < (n11 = (list = this.file_).size())) {
            MessageLite messageLite = (MessageLite)this.file_.get(n12);
            n11 = CodedOutputStream.computeMessageSize(15, messageLite);
            n10 += n11;
            ++n12;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasError() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = PluginProtos$CodeGeneratorResponse.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasError() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getError();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = this.getFileCount()) > 0) {
            n10 = (n10 * 37 + 15) * 53;
            object = this.getFileList();
            n11 = object.hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return PluginProtos.access$2800().ensureFieldAccessorsInitialized(PluginProtos$CodeGeneratorResponse.class, PluginProtos$CodeGeneratorResponse$Builder.class);
    }

    public final boolean isInitialized() {
        byte by2 = this.memoizedIsInitialized;
        byte by3 = 1;
        if (by2 == by3) {
            return by3 != 0;
        }
        if (!by2) {
            return false;
        }
        this.memoizedIsInitialized = by3;
        return by3 != 0;
    }

    public PluginProtos$CodeGeneratorResponse$Builder newBuilderForType() {
        return PluginProtos$CodeGeneratorResponse.newBuilder();
    }

    public PluginProtos$CodeGeneratorResponse$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        PluginProtos$CodeGeneratorResponse$Builder pluginProtos$CodeGeneratorResponse$Builder = new PluginProtos$CodeGeneratorResponse$Builder(generatedMessageV3$BuilderParent, null);
        return pluginProtos$CodeGeneratorResponse$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new PluginProtos$CodeGeneratorResponse();
        return object;
    }

    public PluginProtos$CodeGeneratorResponse$Builder toBuilder() {
        PluginProtos$CodeGeneratorResponseOrBuilder pluginProtos$CodeGeneratorResponseOrBuilder = DEFAULT_INSTANCE;
        if (this == pluginProtos$CodeGeneratorResponseOrBuilder) {
            pluginProtos$CodeGeneratorResponseOrBuilder = new PluginProtos$CodeGeneratorResponse$Builder(null);
        } else {
            pluginProtos$CodeGeneratorResponseOrBuilder = new PluginProtos$CodeGeneratorResponse$Builder(null);
            pluginProtos$CodeGeneratorResponseOrBuilder = ((PluginProtos$CodeGeneratorResponse$Builder)pluginProtos$CodeGeneratorResponseOrBuilder).mergeFrom(this);
        }
        return pluginProtos$CodeGeneratorResponseOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        List list;
        Object object;
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) != 0) {
            object = this.error_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        object = null;
        for (n10 = 0; n10 < (n11 = (list = this.file_).size()); ++n10) {
            n11 = 15;
            MessageLite messageLite = (MessageLite)this.file_.get(n10);
            codedOutputStream.writeMessage(n11, messageLite);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

