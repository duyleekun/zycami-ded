/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$MaxReadTuple$1;
import cn.leancloud.Messages$MaxReadTuple$Builder;
import cn.leancloud.Messages$MaxReadTupleOrBuilder;
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

public final class Messages$MaxReadTuple
extends GeneratedMessageV3
implements Messages$MaxReadTupleOrBuilder {
    private static final Messages$MaxReadTuple DEFAULT_INSTANCE;
    public static final int MAXACKTIMESTAMP_FIELD_NUMBER = 2;
    public static final int MAXREADTIMESTAMP_FIELD_NUMBER = 3;
    public static final Parser PARSER;
    public static final int PID_FIELD_NUMBER = 1;
    private static final long serialVersionUID;
    private int bitField0_;
    private long maxAckTimestamp_;
    private long maxReadTimestamp_;
    private byte memoizedIsInitialized = (byte)-1;
    private volatile Object pid_;

    static {
        Object object = new Messages$MaxReadTuple();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$MaxReadTuple$1();
    }

    private Messages$MaxReadTuple() {
        long l10;
        this.pid_ = "";
        this.maxAckTimestamp_ = l10 = 0L;
        this.maxReadTimestamp_ = l10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Messages$MaxReadTuple(CodedInputStream object, ExtensionRegistryLite object2) {
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
                            int n13 = 10;
                            if (n12 != n13) {
                                long l10;
                                n13 = 16;
                                if (n12 != n13) {
                                    n13 = 24;
                                    if (n12 != n13) {
                                        if ((n12 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n12) ? 1 : 0)) != 0) continue;
                                        break block12;
                                    } else {
                                        this.bitField0_ = n12 = this.bitField0_ | 4;
                                        this.maxReadTimestamp_ = l10 = ((CodedInputStream)object).readInt64();
                                        continue;
                                    }
                                }
                                this.bitField0_ = n12 = this.bitField0_ | 2;
                                this.maxAckTimestamp_ = l10 = ((CodedInputStream)object).readInt64();
                                continue;
                            }
                            ByteString byteString = ((CodedInputStream)object).readBytes();
                            n13 = this.bitField0_;
                            this.bitField0_ = n11 |= n13;
                            this.pid_ = byteString;
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

    public /* synthetic */ Messages$MaxReadTuple(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$MaxReadTuple(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ Messages$MaxReadTuple(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$35600() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ Object access$35800(Messages$MaxReadTuple messages$MaxReadTuple) {
        return messages$MaxReadTuple.pid_;
    }

    public static /* synthetic */ Object access$35802(Messages$MaxReadTuple messages$MaxReadTuple, Object object) {
        messages$MaxReadTuple.pid_ = object;
        return object;
    }

    public static /* synthetic */ long access$35902(Messages$MaxReadTuple messages$MaxReadTuple, long l10) {
        messages$MaxReadTuple.maxAckTimestamp_ = l10;
        return l10;
    }

    public static /* synthetic */ long access$36002(Messages$MaxReadTuple messages$MaxReadTuple, long l10) {
        messages$MaxReadTuple.maxReadTimestamp_ = l10;
        return l10;
    }

    public static /* synthetic */ int access$36102(Messages$MaxReadTuple messages$MaxReadTuple, int n10) {
        messages$MaxReadTuple.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ UnknownFieldSet access$36200(Messages$MaxReadTuple messages$MaxReadTuple) {
        return messages$MaxReadTuple.unknownFields;
    }

    public static Messages$MaxReadTuple getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$35200();
    }

    public static Messages$MaxReadTuple$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$MaxReadTuple$Builder newBuilder(Messages$MaxReadTuple messages$MaxReadTuple) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$MaxReadTuple);
    }

    public static Messages$MaxReadTuple parseDelimitedFrom(InputStream inputStream) {
        return (Messages$MaxReadTuple)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$MaxReadTuple parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$MaxReadTuple)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$MaxReadTuple parseFrom(ByteString byteString) {
        return (Messages$MaxReadTuple)PARSER.parseFrom(byteString);
    }

    public static Messages$MaxReadTuple parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$MaxReadTuple)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$MaxReadTuple parseFrom(CodedInputStream codedInputStream) {
        return (Messages$MaxReadTuple)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$MaxReadTuple parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$MaxReadTuple)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$MaxReadTuple parseFrom(InputStream inputStream) {
        return (Messages$MaxReadTuple)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$MaxReadTuple parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$MaxReadTuple)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$MaxReadTuple parseFrom(ByteBuffer byteBuffer) {
        return (Messages$MaxReadTuple)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$MaxReadTuple parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$MaxReadTuple)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$MaxReadTuple parseFrom(byte[] byArray) {
        return (Messages$MaxReadTuple)PARSER.parseFrom(byArray);
    }

    public static Messages$MaxReadTuple parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$MaxReadTuple)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2;
        long l10;
        long l11;
        Object object2;
        boolean bl3;
        boolean bl4 = true;
        if (object == this) {
            return bl4;
        }
        boolean bl5 = object instanceof Messages$MaxReadTuple;
        if (!bl5) {
            return super.equals(object);
        }
        object = (Messages$MaxReadTuple)object;
        bl5 = this.hasPid();
        if (bl5 == (bl3 = ((Messages$MaxReadTuple)object).hasPid())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object2 = null;
        }
        bl3 = this.hasPid();
        if (bl3) {
            String string2;
            if (bl5 && (bl5 = ((String)(object2 = this.getPid())).equals(string2 = ((Messages$MaxReadTuple)object).getPid()))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object2 = null;
            }
        }
        if (bl5 && (bl5 = this.hasMaxAckTimestamp()) == (bl3 = ((Messages$MaxReadTuple)object).hasMaxAckTimestamp())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object2 = null;
        }
        bl3 = this.hasMaxAckTimestamp();
        if (bl3) {
            long l12;
            if (bl5 && !(bl5 = (l12 = (l11 = this.getMaxAckTimestamp()) - (l10 = ((Messages$MaxReadTuple)object).getMaxAckTimestamp())) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object2 = null;
            }
        }
        if (bl5 && (bl5 = this.hasMaxReadTimestamp()) == (bl3 = ((Messages$MaxReadTuple)object).hasMaxReadTimestamp())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object2 = null;
        }
        bl3 = this.hasMaxReadTimestamp();
        if (bl3) {
            long l13;
            if (bl5 && !(bl5 = (l13 = (l11 = this.getMaxReadTimestamp()) - (l10 = ((Messages$MaxReadTuple)object).getMaxReadTimestamp())) == 0L ? 0 : (l13 < 0L ? -1 : 1))) {
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

    public Messages$MaxReadTuple getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public long getMaxAckTimestamp() {
        return this.maxAckTimestamp_;
    }

    public long getMaxReadTimestamp() {
        return this.maxReadTimestamp_;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public String getPid() {
        Object object = this.pid_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.pid_ = string2;
        }
        return string2;
    }

    public ByteString getPidBytes() {
        Object object = this.pid_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.pid_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
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
            Object object = this.pid_;
            n11 = GeneratedMessageV3.computeStringSize(n12, object);
            n10 = 0 + n11;
        }
        n11 = this.bitField0_;
        n12 = 2;
        if ((n11 &= n12) == n12) {
            long l10 = this.maxAckTimestamp_;
            n11 = CodedOutputStream.computeInt64Size(n12, l10);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 4;
        if ((n11 &= n12) == n12) {
            long l11 = this.maxReadTimestamp_;
            n11 = CodedOutputStream.computeInt64Size(3, l11);
            n10 += n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasMaxAckTimestamp() {
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

    /*
     * WARNING - void declaration
     */
    public boolean hasMaxReadTimestamp() {
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

    public boolean hasPid() {
        int bl2 = this.bitField0_;
        int n10 = 1;
        int n11 = bl2 & n10;
        if (n11 != n10) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public int hashCode() {
        long l10;
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = Messages$MaxReadTuple.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasPid() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getPid();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasMaxAckTimestamp() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            l10 = this.getMaxAckTimestamp();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasMaxReadTimestamp() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            l10 = this.getMaxReadTimestamp();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$35300().ensureFieldAccessorsInitialized(Messages$MaxReadTuple.class, Messages$MaxReadTuple$Builder.class);
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

    public Messages$MaxReadTuple$Builder newBuilderForType() {
        return Messages$MaxReadTuple.newBuilder();
    }

    public Messages$MaxReadTuple$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$MaxReadTuple$Builder messages$MaxReadTuple$Builder = new Messages$MaxReadTuple$Builder(generatedMessageV3$BuilderParent, null);
        return messages$MaxReadTuple$Builder;
    }

    public Messages$MaxReadTuple$Builder toBuilder() {
        Messages$MaxReadTupleOrBuilder messages$MaxReadTupleOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$MaxReadTupleOrBuilder) {
            messages$MaxReadTupleOrBuilder = new Messages$MaxReadTuple$Builder(null);
        } else {
            messages$MaxReadTupleOrBuilder = new Messages$MaxReadTuple$Builder(null);
            messages$MaxReadTupleOrBuilder = ((Messages$MaxReadTuple$Builder)messages$MaxReadTupleOrBuilder).mergeFrom(this);
        }
        return messages$MaxReadTupleOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == n11) {
            Object object = this.pid_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        n10 = this.bitField0_;
        n11 = 2;
        if ((n10 &= n11) == n11) {
            long l10 = this.maxAckTimestamp_;
            codedOutputStream.writeInt64(n11, l10);
        }
        n10 = this.bitField0_;
        n11 = 4;
        if ((n10 &= n11) == n11) {
            n10 = 3;
            long l11 = this.maxReadTimestamp_;
            codedOutputStream.writeInt64(n10, l11);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

