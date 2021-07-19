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
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp$1;
import com.google.protobuf.Timestamp$Builder;
import com.google.protobuf.TimestampOrBuilder;
import com.google.protobuf.TimestampProto;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class Timestamp
extends GeneratedMessageV3
implements TimestampOrBuilder {
    private static final Timestamp DEFAULT_INSTANCE;
    public static final int NANOS_FIELD_NUMBER = 2;
    private static final Parser PARSER;
    public static final int SECONDS_FIELD_NUMBER = 1;
    private static final long serialVersionUID;
    private byte memoizedIsInitialized = (byte)-1;
    private int nanos_;
    private long seconds_;

    static {
        Object object = new Timestamp();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Timestamp$1();
    }

    private Timestamp() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Timestamp(CodedInputStream object, ExtensionRegistryLite object2) {
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
                    boolean bl3;
                    block11: {
                        int n10 = ((CodedInputStream)object).readTag();
                        bl3 = true;
                        if (n10 != 0) {
                            long l10;
                            int n11 = 8;
                            if (n10 != n11) {
                                n11 = 16;
                                if (n10 != n11) {
                                    if ((n10 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n10) ? 1 : 0)) != 0) continue;
                                    break block11;
                                } else {
                                    this.nanos_ = n10 = ((CodedInputStream)object).readInt32();
                                    continue;
                                }
                            }
                            this.seconds_ = l10 = ((CodedInputStream)object).readInt64();
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

    public /* synthetic */ Timestamp(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Timestamp$1 timestamp$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Timestamp(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ Timestamp(GeneratedMessageV3$Builder generatedMessageV3$Builder, Timestamp$1 timestamp$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ long access$302(Timestamp timestamp, long l10) {
        timestamp.seconds_ = l10;
        return l10;
    }

    public static /* synthetic */ int access$402(Timestamp timestamp, int n10) {
        timestamp.nanos_ = n10;
        return n10;
    }

    public static /* synthetic */ Parser access$500() {
        return PARSER;
    }

    public static Timestamp getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return TimestampProto.internal_static_google_protobuf_Timestamp_descriptor;
    }

    public static Timestamp$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Timestamp$Builder newBuilder(Timestamp timestamp) {
        return ((Timestamp$Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(timestamp);
    }

    public static Timestamp parseDelimitedFrom(InputStream inputStream) {
        return (Timestamp)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Timestamp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Timestamp)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Timestamp parseFrom(ByteString byteString) {
        return (Timestamp)PARSER.parseFrom(byteString);
    }

    public static Timestamp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Timestamp)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Timestamp parseFrom(CodedInputStream codedInputStream) {
        return (Timestamp)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Timestamp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Timestamp)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Timestamp parseFrom(InputStream inputStream) {
        return (Timestamp)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Timestamp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Timestamp)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Timestamp parseFrom(ByteBuffer byteBuffer) {
        return (Timestamp)PARSER.parseFrom(byteBuffer);
    }

    public static Timestamp parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Timestamp)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Timestamp parseFrom(byte[] byArray) {
        return (Timestamp)PARSER.parseFrom(byArray);
    }

    public static Timestamp parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Timestamp)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        int n10;
        long l10;
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        Object object2 = object instanceof Timestamp;
        if (object2 == 0) {
            return super.equals(object);
        }
        object = (Timestamp)object;
        long l11 = this.getSeconds();
        long l12 = l11 - (l10 = ((Timestamp)object).getSeconds());
        object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 != 0) {
            return false;
        }
        object2 = this.getNanos();
        if (object2 != (n10 = ((Timestamp)object).getNanos())) {
            return false;
        }
        UnknownFieldSet unknownFieldSet = this.unknownFields;
        object = ((GeneratedMessageV3)object).unknownFields;
        boolean bl3 = unknownFieldSet.equals(object);
        if (!bl3) {
            return false;
        }
        return bl2;
    }

    public Timestamp getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public int getNanos() {
        return this.nanos_;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public long getSeconds() {
        return this.seconds_;
    }

    public int getSerializedSize() {
        int n10 = this.memoizedSize;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n10 = 0;
        long l10 = this.seconds_;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            object = 1;
            n11 = CodedOutputStream.computeInt64Size((int)object, l10);
            n10 = 0 + n11;
        }
        if ((n11 = this.nanos_) != 0) {
            int n12 = 2;
            n11 = CodedOutputStream.computeInt32Size(n12, n11);
            n10 += n11;
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
        int n11 = Timestamp.getDescriptor().hashCode();
        n10 = ((779 + n11) * 37 + 1) * 53;
        n11 = Internal.hashLong(this.getSeconds());
        n10 = ((n10 + n11) * 37 + 2) * 53;
        n11 = this.getNanos();
        n10 = (n10 + n11) * 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return TimestampProto.internal_static_google_protobuf_Timestamp_fieldAccessorTable.ensureFieldAccessorsInitialized(Timestamp.class, Timestamp$Builder.class);
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

    public Timestamp$Builder newBuilderForType() {
        return Timestamp.newBuilder();
    }

    public Timestamp$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Timestamp$Builder timestamp$Builder = new Timestamp$Builder(generatedMessageV3$BuilderParent, null);
        return timestamp$Builder;
    }

    public Object newInstance(GeneratedMessageV3$UnusedPrivateParameter object) {
        object = new Timestamp();
        return object;
    }

    public Timestamp$Builder toBuilder() {
        TimestampOrBuilder timestampOrBuilder = DEFAULT_INSTANCE;
        if (this == timestampOrBuilder) {
            timestampOrBuilder = new Timestamp$Builder(null);
        } else {
            timestampOrBuilder = new Timestamp$Builder(null);
            timestampOrBuilder = ((Timestamp$Builder)timestampOrBuilder).mergeFrom(this);
        }
        return timestampOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        int n10;
        long l10 = this.seconds_;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            object = 1;
            codedOutputStream.writeInt64((int)object, l10);
        }
        if ((n10 = this.nanos_) != 0) {
            int n11 = 2;
            codedOutputStream.writeInt32(n11, n10);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

