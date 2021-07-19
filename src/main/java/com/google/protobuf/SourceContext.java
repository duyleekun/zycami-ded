/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

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
import com.google.protobuf.SourceContext$1;
import com.google.protobuf.SourceContext$Builder;
import com.google.protobuf.SourceContextOrBuilder;
import com.google.protobuf.SourceContextProto;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class SourceContext
extends GeneratedMessageV3
implements SourceContextOrBuilder {
    private static final SourceContext DEFAULT_INSTANCE;
    public static final int FILE_NAME_FIELD_NUMBER = 1;
    private static final Parser PARSER;
    private static final long serialVersionUID;
    private volatile Object fileName_;
    private byte memoizedIsInitialized = (byte)-1;

    static {
        Object object = new SourceContext();
        DEFAULT_INSTANCE = object;
        PARSER = object = new SourceContext$1();
    }

    private SourceContext() {
        this.fileName_ = "";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private SourceContext(CodedInputStream object, ExtensionRegistryLite object2) {
        this();
        Throwable throwable2;
        Objects.requireNonNull(object2);
        UnknownFieldSet$Builder unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
        boolean bl2 = false;
        while (true) {
            if (bl2) {
                this.unknownFields = object = unknownFieldSet$Builder.build();
                this.makeExtensionsImmutable();
                return;
            }
            try {
                try {
                    int n10 = ((CodedInputStream)object).readTag();
                    boolean bl3 = true;
                    if (n10 != 0) {
                        int n11 = 10;
                        if (n10 != n11) {
                            if ((n10 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n10) ? 1 : 0)) != 0) continue;
                        } else {
                            String string2 = ((CodedInputStream)object).readStringRequireUtf8();
                            this.fileName_ = string2;
                            continue;
                        }
                    }
                    bl2 = bl3;
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

    public /* synthetic */ SourceContext(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, SourceContext$1 sourceContext$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private SourceContext(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ SourceContext(GeneratedMessageV3$Builder generatedMessageV3$Builder, SourceContext$1 sourceContext$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ Object access$300(SourceContext sourceContext) {
        return sourceContext.fileName_;
    }

    public static /* synthetic */ Object access$302(SourceContext sourceContext, Object object) {
        sourceContext.fileName_ = object;
        return object;
    }

    public static /* synthetic */ Parser access$400() {
        return PARSER;
    }

    public static SourceContext getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return SourceContextProto.internal_static_google_protobuf_SourceContext_descriptor;
    }

    public static SourceContext$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static SourceContext$Builder newBuilder(SourceContext sourceContext) {
        return ((SourceContext$Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(sourceContext);
    }

    public static SourceContext parseDelimitedFrom(InputStream inputStream) {
        return (SourceContext)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static SourceContext parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SourceContext)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static SourceContext parseFrom(ByteString byteString) {
        return (SourceContext)PARSER.parseFrom(byteString);
    }

    public static SourceContext parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (SourceContext)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static SourceContext parseFrom(CodedInputStream codedInputStream) {
        return (SourceContext)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static SourceContext parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SourceContext)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static SourceContext parseFrom(InputStream inputStream) {
        return (SourceContext)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static SourceContext parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SourceContext)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static SourceContext parseFrom(ByteBuffer byteBuffer) {
        return (SourceContext)PARSER.parseFrom(byteBuffer);
    }

    public static SourceContext parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (SourceContext)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static SourceContext parseFrom(byte[] byArray) {
        return (SourceContext)PARSER.parseFrom(byArray);
    }

    public static SourceContext parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (SourceContext)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof SourceContext;
        if (!bl3) {
            return super.equals(object);
        }
        object = (SourceContext)object;
        Object object2 = this.getFileName();
        String string2 = ((SourceContext)object).getFileName();
        bl3 = ((String)object2).equals(string2);
        string2 = null;
        if (!bl3) {
            return false;
        }
        object2 = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl4 = ((UnknownFieldSet)object2).equals(object);
        if (!bl4) {
            return false;
        }
        return bl2;
    }

    public SourceContext getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public String getFileName() {
        Object object = this.fileName_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        this.fileName_ = object = ((ByteString)object).toStringUtf8();
        return object;
    }

    public ByteString getFileNameBytes() {
        Object object = this.fileName_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.fileName_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int n10 = this.memoizedSize;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n10 = 0;
        ByteString byteString = this.getFileNameBytes();
        n11 = (int)(byteString.isEmpty() ? 1 : 0);
        if (n11 == 0) {
            Object object = this.fileName_;
            n11 = GeneratedMessageV3.computeStringSize(1, object);
            n10 = 0 + n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        int n11 = SourceContext.getDescriptor().hashCode();
        n10 = ((779 + n11) * 37 + 1) * 53;
        n11 = this.getFileName().hashCode();
        n10 = (n10 + n11) * 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return SourceContextProto.internal_static_google_protobuf_SourceContext_fieldAccessorTable.ensureFieldAccessorsInitialized(SourceContext.class, SourceContext$Builder.class);
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

    public SourceContext$Builder newBuilderForType() {
        return SourceContext.newBuilder();
    }

    public SourceContext$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        SourceContext$Builder sourceContext$Builder = new SourceContext$Builder(generatedMessageV3$BuilderParent, null);
        return sourceContext$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new SourceContext();
        return object;
    }

    public SourceContext$Builder toBuilder() {
        SourceContextOrBuilder sourceContextOrBuilder = DEFAULT_INSTANCE;
        if (this == sourceContextOrBuilder) {
            sourceContextOrBuilder = new SourceContext$Builder(null);
        } else {
            sourceContextOrBuilder = new SourceContext$Builder(null);
            sourceContextOrBuilder = ((SourceContext$Builder)sourceContextOrBuilder).mergeFrom(this);
        }
        return sourceContextOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        ByteString byteString = this.getFileNameBytes();
        int n10 = (int)(byteString.isEmpty() ? 1 : 0);
        if (n10 == 0) {
            n10 = 1;
            Object object = this.fileName_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

