/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$ReadTuple$1;
import cn.leancloud.Messages$ReadTuple$Builder;
import cn.leancloud.Messages$ReadTupleOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Messages$ReadTuple
extends GeneratedMessageV3
implements Messages$ReadTupleOrBuilder {
    public static final int CID_FIELD_NUMBER = 1;
    private static final Messages$ReadTuple DEFAULT_INSTANCE;
    public static final int MID_FIELD_NUMBER = 3;
    public static final Parser PARSER;
    public static final int TIMESTAMP_FIELD_NUMBER = 2;
    private static final long serialVersionUID;
    private int bitField0_;
    private volatile Object cid_;
    private byte memoizedIsInitialized = (byte)-1;
    private volatile Object mid_;
    private long timestamp_;

    static {
        Object object = new Messages$ReadTuple();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$ReadTuple$1();
    }

    private Messages$ReadTuple() {
        String string2 = "";
        this.cid_ = string2;
        this.timestamp_ = 0L;
        this.mid_ = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Messages$ReadTuple(CodedInputStream object, ExtensionRegistryLite object2) {
        this();
        Throwable throwable2;
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
                                long l10;
                                n13 = 16;
                                if (n12 != n13) {
                                    n13 = 26;
                                    if (n12 != n13) {
                                        if ((n12 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n12) ? 1 : 0)) != 0) continue;
                                        break block12;
                                    } else {
                                        byteString = ((CodedInputStream)object).readBytes();
                                        this.bitField0_ = n11 = this.bitField0_ | 4;
                                        this.mid_ = byteString;
                                        continue;
                                    }
                                }
                                this.bitField0_ = n12 = this.bitField0_ | 2;
                                this.timestamp_ = l10 = ((CodedInputStream)object).readInt64();
                                continue;
                            }
                            byteString = ((CodedInputStream)object).readBytes();
                            n13 = this.bitField0_;
                            this.bitField0_ = n11 |= n13;
                            this.cid_ = byteString;
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

    public /* synthetic */ Messages$ReadTuple(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$ReadTuple(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ Messages$ReadTuple(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$34400() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ Object access$34600(Messages$ReadTuple messages$ReadTuple) {
        return messages$ReadTuple.cid_;
    }

    public static /* synthetic */ Object access$34602(Messages$ReadTuple messages$ReadTuple, Object object) {
        messages$ReadTuple.cid_ = object;
        return object;
    }

    public static /* synthetic */ long access$34702(Messages$ReadTuple messages$ReadTuple, long l10) {
        messages$ReadTuple.timestamp_ = l10;
        return l10;
    }

    public static /* synthetic */ Object access$34800(Messages$ReadTuple messages$ReadTuple) {
        return messages$ReadTuple.mid_;
    }

    public static /* synthetic */ Object access$34802(Messages$ReadTuple messages$ReadTuple, Object object) {
        messages$ReadTuple.mid_ = object;
        return object;
    }

    public static /* synthetic */ int access$34902(Messages$ReadTuple messages$ReadTuple, int n10) {
        messages$ReadTuple.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ UnknownFieldSet access$35000(Messages$ReadTuple messages$ReadTuple) {
        return messages$ReadTuple.unknownFields;
    }

    public static Messages$ReadTuple getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$34000();
    }

    public static Messages$ReadTuple$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$ReadTuple$Builder newBuilder(Messages$ReadTuple messages$ReadTuple) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$ReadTuple);
    }

    public static Messages$ReadTuple parseDelimitedFrom(InputStream inputStream) {
        return (Messages$ReadTuple)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$ReadTuple parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ReadTuple)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$ReadTuple parseFrom(ByteString byteString) {
        return (Messages$ReadTuple)PARSER.parseFrom(byteString);
    }

    public static Messages$ReadTuple parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ReadTuple)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$ReadTuple parseFrom(CodedInputStream codedInputStream) {
        return (Messages$ReadTuple)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$ReadTuple parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ReadTuple)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$ReadTuple parseFrom(InputStream inputStream) {
        return (Messages$ReadTuple)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$ReadTuple parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ReadTuple)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$ReadTuple parseFrom(ByteBuffer byteBuffer) {
        return (Messages$ReadTuple)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$ReadTuple parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ReadTuple)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$ReadTuple parseFrom(byte[] byArray) {
        return (Messages$ReadTuple)PARSER.parseFrom(byArray);
    }

    public static Messages$ReadTuple parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ReadTuple)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2;
        String string2;
        Object object2;
        boolean bl3;
        boolean bl4 = true;
        if (object == this) {
            return bl4;
        }
        boolean bl5 = object instanceof Messages$ReadTuple;
        if (!bl5) {
            return super.equals(object);
        }
        object = (Messages$ReadTuple)object;
        bl5 = this.hasCid();
        if (bl5 == (bl3 = ((Messages$ReadTuple)object).hasCid())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object2 = null;
        }
        bl3 = this.hasCid();
        if (bl3) {
            if (bl5 && (bl5 = ((String)(object2 = this.getCid())).equals(string2 = ((Messages$ReadTuple)object).getCid()))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object2 = null;
            }
        }
        if (bl5 && (bl5 = this.hasTimestamp()) == (bl3 = ((Messages$ReadTuple)object).hasTimestamp())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object2 = null;
        }
        bl3 = this.hasTimestamp();
        if (bl3) {
            long l10;
            long l11;
            long l12;
            if (bl5 && !(bl5 = (l12 = (l11 = this.getTimestamp()) - (l10 = ((Messages$ReadTuple)object).getTimestamp())) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object2 = null;
            }
        }
        if (bl5 && (bl5 = this.hasMid()) == (bl3 = ((Messages$ReadTuple)object).hasMid())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object2 = null;
        }
        bl3 = this.hasMid();
        if (bl3) {
            if (bl5 && (bl5 = ((String)(object2 = this.getMid())).equals(string2 = ((Messages$ReadTuple)object).getMid()))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object2 = null;
            }
        }
        if (!bl5 || !(bl2 = ((UnknownFieldSet)(object2 = this.unknownFields)).equals(object = ((GeneratedMessageV3)object).unknownFields))) {
            bl4 = false;
        }
        return bl4;
    }

    public String getCid() {
        Object object = this.cid_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.cid_ = string2;
        }
        return string2;
    }

    public ByteString getCidBytes() {
        Object object = this.cid_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.cid_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Messages$ReadTuple getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public String getMid() {
        Object object = this.mid_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.mid_ = string2;
        }
        return string2;
    }

    public ByteString getMidBytes() {
        Object object = this.mid_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.mid_ = object = ByteString.copyFromUtf8((String)object);
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
        n11 = this.bitField0_;
        int n12 = 1;
        if ((n11 &= n12) == n12) {
            Object object = this.cid_;
            n11 = GeneratedMessageV3.computeStringSize(n12, object);
            n10 = 0 + n11;
        }
        n11 = this.bitField0_;
        n12 = 2;
        if ((n11 &= n12) == n12) {
            long l10 = this.timestamp_;
            n11 = CodedOutputStream.computeInt64Size(n12, l10);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 4;
        if ((n11 &= n12) == n12) {
            Object object = this.mid_;
            n11 = GeneratedMessageV3.computeStringSize(3, object);
            n10 += n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public long getTimestamp() {
        return this.timestamp_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasCid() {
        int bl2 = this.bitField0_;
        int n10 = 1;
        int n11 = bl2 & n10;
        if (n11 != n10) {
            n10 = 0;
        }
        return n10 != 0;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasMid() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 4;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasTimestamp() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 2;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = Messages$ReadTuple.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasCid() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getCid();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasTimestamp() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            long l10 = this.getTimestamp();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasMid() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            object = this.getMid();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$34100().ensureFieldAccessorsInitialized(Messages$ReadTuple.class, Messages$ReadTuple$Builder.class);
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
        by2 = this.hasCid();
        if (!by2) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = by3;
        return by3 != 0;
    }

    public Messages$ReadTuple$Builder newBuilderForType() {
        return Messages$ReadTuple.newBuilder();
    }

    public Messages$ReadTuple$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$ReadTuple$Builder messages$ReadTuple$Builder = new Messages$ReadTuple$Builder(generatedMessageV3$BuilderParent, null);
        return messages$ReadTuple$Builder;
    }

    public Messages$ReadTuple$Builder toBuilder() {
        Messages$ReadTupleOrBuilder messages$ReadTupleOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$ReadTupleOrBuilder) {
            messages$ReadTupleOrBuilder = new Messages$ReadTuple$Builder(null);
        } else {
            messages$ReadTupleOrBuilder = new Messages$ReadTuple$Builder(null);
            messages$ReadTupleOrBuilder = ((Messages$ReadTuple$Builder)messages$ReadTupleOrBuilder).mergeFrom(this);
        }
        return messages$ReadTupleOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == n11) {
            Object object = this.cid_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        n10 = this.bitField0_;
        n11 = 2;
        if ((n10 &= n11) == n11) {
            long l10 = this.timestamp_;
            codedOutputStream.writeInt64(n11, l10);
        }
        n10 = this.bitField0_;
        n11 = 4;
        if ((n10 &= n11) == n11) {
            n10 = 3;
            Object object = this.mid_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

