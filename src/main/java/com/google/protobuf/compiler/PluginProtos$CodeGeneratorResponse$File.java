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
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import com.google.protobuf.compiler.PluginProtos;
import com.google.protobuf.compiler.PluginProtos$1;
import com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$File$1;
import com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$File$Builder;
import com.google.protobuf.compiler.PluginProtos$CodeGeneratorResponse$FileOrBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class PluginProtos$CodeGeneratorResponse$File
extends GeneratedMessageV3
implements PluginProtos$CodeGeneratorResponse$FileOrBuilder {
    public static final int CONTENT_FIELD_NUMBER = 15;
    private static final PluginProtos$CodeGeneratorResponse$File DEFAULT_INSTANCE;
    public static final int INSERTION_POINT_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final Parser PARSER;
    private static final long serialVersionUID;
    private int bitField0_;
    private volatile Object content_;
    private volatile Object insertionPoint_;
    private byte memoizedIsInitialized = (byte)-1;
    private volatile Object name_;

    static {
        Object object = new PluginProtos$CodeGeneratorResponse$File();
        DEFAULT_INSTANCE = object;
        PARSER = object = new PluginProtos$CodeGeneratorResponse$File$1();
    }

    private PluginProtos$CodeGeneratorResponse$File() {
        String string2 = "";
        this.name_ = string2;
        this.insertionPoint_ = string2;
        this.content_ = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private PluginProtos$CodeGeneratorResponse$File(CodedInputStream object, ExtensionRegistryLite object2) {
        this();
        Throwable throwable2;
        Objects.requireNonNull(object2);
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        int n10 = 0;
        while (true) {
            if (n10 != 0) {
                this.unknownFields = object = unknownFieldSet$Builder.build();
                this.makeExtensionsImmutable();
                return;
            }
            try {
                try {
                    int n11;
                    block12: {
                        int n12 = ((CodedInputStream)object).readTag();
                        n11 = 1;
                        if (n12 != 0) {
                            ByteString byteString;
                            int n13 = 10;
                            if (n12 != n13) {
                                n13 = 18;
                                if (n12 != n13) {
                                    n13 = 122;
                                    if (n12 != n13) {
                                        if ((n12 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n12) ? 1 : 0)) != 0) continue;
                                        break block12;
                                    } else {
                                        byteString = ((CodedInputStream)object).readBytes();
                                        this.bitField0_ = n11 = this.bitField0_ | 4;
                                        this.content_ = byteString;
                                        continue;
                                    }
                                }
                                byteString = ((CodedInputStream)object).readBytes();
                                this.bitField0_ = n11 = this.bitField0_ | 2;
                                this.insertionPoint_ = byteString;
                                continue;
                            }
                            byteString = ((CodedInputStream)object).readBytes();
                            n13 = this.bitField0_;
                            this.bitField0_ = n11 |= n13;
                            this.name_ = byteString;
                            continue;
                        }
                    }
                    n10 = n11;
                    continue;
                }
                catch (IOException iOException) {
                    object2 = new InvalidProtocolBufferException(iOException);
                    InvalidProtocolBufferException invalidProtocolBufferException = ((InvalidProtocolBufferException)object2).setUnfinishedMessage(this);
                    throw invalidProtocolBufferException;
                }
                catch (InvalidProtocolBufferException invalidProtocolBufferException) {
                    InvalidProtocolBufferException invalidProtocolBufferException2 = invalidProtocolBufferException.setUnfinishedMessage(this);
                    throw invalidProtocolBufferException2;
                }
            }
            catch (Throwable throwable2) {}
            break;
        }
        this.unknownFields = object2 = unknownFieldSet$Builder.build();
        this.makeExtensionsImmutable();
        throw throwable2;
    }

    public /* synthetic */ PluginProtos$CodeGeneratorResponse$File(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, PluginProtos$1 pluginProtos$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private PluginProtos$CodeGeneratorResponse$File(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ PluginProtos$CodeGeneratorResponse$File(GeneratedMessageV3$Builder generatedMessageV3$Builder, PluginProtos$1 pluginProtos$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$3300() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ Object access$3500(PluginProtos$CodeGeneratorResponse$File pluginProtos$CodeGeneratorResponse$File) {
        return pluginProtos$CodeGeneratorResponse$File.name_;
    }

    public static /* synthetic */ Object access$3502(PluginProtos$CodeGeneratorResponse$File pluginProtos$CodeGeneratorResponse$File, Object object) {
        pluginProtos$CodeGeneratorResponse$File.name_ = object;
        return object;
    }

    public static /* synthetic */ Object access$3600(PluginProtos$CodeGeneratorResponse$File pluginProtos$CodeGeneratorResponse$File) {
        return pluginProtos$CodeGeneratorResponse$File.insertionPoint_;
    }

    public static /* synthetic */ Object access$3602(PluginProtos$CodeGeneratorResponse$File pluginProtos$CodeGeneratorResponse$File, Object object) {
        pluginProtos$CodeGeneratorResponse$File.insertionPoint_ = object;
        return object;
    }

    public static /* synthetic */ Object access$3700(PluginProtos$CodeGeneratorResponse$File pluginProtos$CodeGeneratorResponse$File) {
        return pluginProtos$CodeGeneratorResponse$File.content_;
    }

    public static /* synthetic */ Object access$3702(PluginProtos$CodeGeneratorResponse$File pluginProtos$CodeGeneratorResponse$File, Object object) {
        pluginProtos$CodeGeneratorResponse$File.content_ = object;
        return object;
    }

    public static /* synthetic */ int access$3802(PluginProtos$CodeGeneratorResponse$File pluginProtos$CodeGeneratorResponse$File, int n10) {
        pluginProtos$CodeGeneratorResponse$File.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ UnknownFieldSet access$3900(PluginProtos$CodeGeneratorResponse$File pluginProtos$CodeGeneratorResponse$File) {
        return pluginProtos$CodeGeneratorResponse$File.unknownFields;
    }

    public static PluginProtos$CodeGeneratorResponse$File getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return PluginProtos.access$2900();
    }

    public static PluginProtos$CodeGeneratorResponse$File$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static PluginProtos$CodeGeneratorResponse$File$Builder newBuilder(PluginProtos$CodeGeneratorResponse$File pluginProtos$CodeGeneratorResponse$File) {
        return ((PluginProtos$CodeGeneratorResponse$File$Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(pluginProtos$CodeGeneratorResponse$File);
    }

    public static PluginProtos$CodeGeneratorResponse$File parseDelimitedFrom(InputStream inputStream) {
        return (PluginProtos$CodeGeneratorResponse$File)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PluginProtos$CodeGeneratorResponse$File parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PluginProtos$CodeGeneratorResponse$File)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PluginProtos$CodeGeneratorResponse$File parseFrom(ByteString byteString) {
        return (PluginProtos$CodeGeneratorResponse$File)PARSER.parseFrom(byteString);
    }

    public static PluginProtos$CodeGeneratorResponse$File parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PluginProtos$CodeGeneratorResponse$File)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PluginProtos$CodeGeneratorResponse$File parseFrom(CodedInputStream codedInputStream) {
        return (PluginProtos$CodeGeneratorResponse$File)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static PluginProtos$CodeGeneratorResponse$File parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PluginProtos$CodeGeneratorResponse$File)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static PluginProtos$CodeGeneratorResponse$File parseFrom(InputStream inputStream) {
        return (PluginProtos$CodeGeneratorResponse$File)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static PluginProtos$CodeGeneratorResponse$File parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PluginProtos$CodeGeneratorResponse$File)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PluginProtos$CodeGeneratorResponse$File parseFrom(ByteBuffer byteBuffer) {
        return (PluginProtos$CodeGeneratorResponse$File)PARSER.parseFrom(byteBuffer);
    }

    public static PluginProtos$CodeGeneratorResponse$File parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PluginProtos$CodeGeneratorResponse$File)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PluginProtos$CodeGeneratorResponse$File parseFrom(byte[] byArray) {
        return (PluginProtos$CodeGeneratorResponse$File)PARSER.parseFrom(byArray);
    }

    public static PluginProtos$CodeGeneratorResponse$File parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (PluginProtos$CodeGeneratorResponse$File)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        String string2;
        Object object2;
        boolean bl2;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        boolean bl4 = object instanceof PluginProtos$CodeGeneratorResponse$File;
        if (!bl4) {
            return super.equals(object);
        }
        object = (PluginProtos$CodeGeneratorResponse$File)object;
        bl4 = this.hasName();
        if (bl4 != (bl2 = ((PluginProtos$CodeGeneratorResponse$File)object).hasName())) {
            return false;
        }
        bl4 = this.hasName();
        if (bl4 && !(bl4 = ((String)(object2 = this.getName())).equals(string2 = ((PluginProtos$CodeGeneratorResponse$File)object).getName()))) {
            return false;
        }
        bl4 = this.hasInsertionPoint();
        if (bl4 != (bl2 = ((PluginProtos$CodeGeneratorResponse$File)object).hasInsertionPoint())) {
            return false;
        }
        bl4 = this.hasInsertionPoint();
        if (bl4 && !(bl4 = ((String)(object2 = this.getInsertionPoint())).equals(string2 = ((PluginProtos$CodeGeneratorResponse$File)object).getInsertionPoint()))) {
            return false;
        }
        bl4 = this.hasContent();
        if (bl4 != (bl2 = ((PluginProtos$CodeGeneratorResponse$File)object).hasContent())) {
            return false;
        }
        bl4 = this.hasContent();
        if (bl4 && !(bl4 = ((String)(object2 = this.getContent())).equals(string2 = ((PluginProtos$CodeGeneratorResponse$File)object).getContent()))) {
            return false;
        }
        object2 = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl5 = ((UnknownFieldSet)object2).equals(object);
        if (!bl5) {
            return false;
        }
        return bl3;
    }

    public String getContent() {
        Object object = this.content_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.content_ = string2;
        }
        return string2;
    }

    public ByteString getContentBytes() {
        Object object = this.content_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.content_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public PluginProtos$CodeGeneratorResponse$File getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public String getInsertionPoint() {
        Object object = this.insertionPoint_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.insertionPoint_ = string2;
        }
        return string2;
    }

    public ByteString getInsertionPointBytes() {
        Object object = this.insertionPoint_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.insertionPoint_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getName() {
        Object object = this.name_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.name_ = string2;
        }
        return string2;
    }

    public ByteString getNameBytes() {
        Object object = this.name_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.name_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        Object object;
        int n10 = this.memoizedSize;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n10 = 0;
        n11 = this.bitField0_;
        int n12 = 1;
        if ((n11 &= n12) != 0) {
            object = this.name_;
            n11 = GeneratedMessageV3.computeStringSize(n12, object);
            n10 = 0 + n11;
        }
        n11 = this.bitField0_;
        n12 = 2;
        if ((n11 &= n12) != 0) {
            object = this.insertionPoint_;
            n11 = GeneratedMessageV3.computeStringSize(n12, object);
            n10 += n11;
        }
        if ((n11 = this.bitField0_ & 4) != 0) {
            Object object2 = this.content_;
            n11 = GeneratedMessageV3.computeStringSize(15, object2);
            n10 += n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasContent() {
        int n10 = this.bitField0_ & 4;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasInsertionPoint() {
        int n10 = this.bitField0_ & 2;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasName() {
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
        Object object = PluginProtos$CodeGeneratorResponse$File.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasName() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getName();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasInsertionPoint() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getInsertionPoint();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasContent() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 15) * 53;
            object = this.getContent();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return PluginProtos.access$3000().ensureFieldAccessorsInitialized(PluginProtos$CodeGeneratorResponse$File.class, PluginProtos$CodeGeneratorResponse$File$Builder.class);
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

    public PluginProtos$CodeGeneratorResponse$File$Builder newBuilderForType() {
        return PluginProtos$CodeGeneratorResponse$File.newBuilder();
    }

    public PluginProtos$CodeGeneratorResponse$File$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        PluginProtos$CodeGeneratorResponse$File$Builder pluginProtos$CodeGeneratorResponse$File$Builder = new PluginProtos$CodeGeneratorResponse$File$Builder(generatedMessageV3$BuilderParent, null);
        return pluginProtos$CodeGeneratorResponse$File$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new PluginProtos$CodeGeneratorResponse$File();
        return object;
    }

    public PluginProtos$CodeGeneratorResponse$File$Builder toBuilder() {
        PluginProtos$CodeGeneratorResponse$FileOrBuilder pluginProtos$CodeGeneratorResponse$FileOrBuilder = DEFAULT_INSTANCE;
        if (this == pluginProtos$CodeGeneratorResponse$FileOrBuilder) {
            pluginProtos$CodeGeneratorResponse$FileOrBuilder = new PluginProtos$CodeGeneratorResponse$File$Builder(null);
        } else {
            pluginProtos$CodeGeneratorResponse$FileOrBuilder = new PluginProtos$CodeGeneratorResponse$File$Builder(null);
            pluginProtos$CodeGeneratorResponse$FileOrBuilder = ((PluginProtos$CodeGeneratorResponse$File$Builder)pluginProtos$CodeGeneratorResponse$FileOrBuilder).mergeFrom(this);
        }
        return pluginProtos$CodeGeneratorResponse$FileOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Object object;
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) != 0) {
            object = this.name_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        n10 = this.bitField0_;
        n11 = 2;
        if ((n10 &= n11) != 0) {
            object = this.insertionPoint_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        if ((n10 = this.bitField0_ & 4) != 0) {
            n10 = 15;
            Object object2 = this.content_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object2);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

