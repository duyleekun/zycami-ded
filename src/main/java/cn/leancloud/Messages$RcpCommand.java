/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$RcpCommand$1;
import cn.leancloud.Messages$RcpCommand$Builder;
import cn.leancloud.Messages$RcpCommandOrBuilder;
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

public final class Messages$RcpCommand
extends GeneratedMessageV3
implements Messages$RcpCommandOrBuilder {
    public static final int CID_FIELD_NUMBER = 2;
    private static final Messages$RcpCommand DEFAULT_INSTANCE;
    public static final int FROM_FIELD_NUMBER = 5;
    public static final int ID_FIELD_NUMBER = 1;
    public static final Parser PARSER;
    public static final int READ_FIELD_NUMBER = 4;
    public static final int T_FIELD_NUMBER = 3;
    private static final long serialVersionUID;
    private int bitField0_;
    private volatile Object cid_;
    private volatile Object from_;
    private volatile Object id_;
    private byte memoizedIsInitialized = (byte)-1;
    private boolean read_;
    private long t_;

    static {
        Object object = new Messages$RcpCommand();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$RcpCommand$1();
    }

    private Messages$RcpCommand() {
        String string2 = "";
        this.id_ = string2;
        this.cid_ = string2;
        this.t_ = 0L;
        this.read_ = false;
        this.from_ = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Messages$RcpCommand(CodedInputStream object, ExtensionRegistryLite object2) {
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
                    block14: {
                        int n12 = ((CodedInputStream)object).readTag();
                        n11 = 1;
                        if (n12 != 0) {
                            ByteString byteString;
                            int n13 = 10;
                            if (n12 != n13) {
                                n13 = 18;
                                if (n12 != n13) {
                                    long l10;
                                    n13 = 24;
                                    if (n12 != n13) {
                                        n13 = 32;
                                        if (n12 != n13) {
                                            n13 = 42;
                                            if (n12 != n13) {
                                                if ((n12 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n12) ? 1 : 0)) != 0) continue;
                                                break block14;
                                            } else {
                                                byteString = ((CodedInputStream)object).readBytes();
                                                this.bitField0_ = n11 = this.bitField0_ | 0x10;
                                                this.from_ = byteString;
                                                continue;
                                            }
                                        }
                                        this.bitField0_ = n12 = this.bitField0_ | 8;
                                        n12 = (int)(((CodedInputStream)object).readBool() ? 1 : 0);
                                        this.read_ = n12;
                                        continue;
                                    }
                                    this.bitField0_ = n12 = this.bitField0_ | 4;
                                    this.t_ = l10 = ((CodedInputStream)object).readInt64();
                                    continue;
                                }
                                byteString = ((CodedInputStream)object).readBytes();
                                this.bitField0_ = n11 = this.bitField0_ | 2;
                                this.cid_ = byteString;
                                continue;
                            }
                            byteString = ((CodedInputStream)object).readBytes();
                            n13 = this.bitField0_;
                            this.bitField0_ = n11 |= n13;
                            this.id_ = byteString;
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

    public /* synthetic */ Messages$RcpCommand(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$RcpCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ Messages$RcpCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$33000() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ Object access$33200(Messages$RcpCommand messages$RcpCommand) {
        return messages$RcpCommand.id_;
    }

    public static /* synthetic */ Object access$33202(Messages$RcpCommand messages$RcpCommand, Object object) {
        messages$RcpCommand.id_ = object;
        return object;
    }

    public static /* synthetic */ Object access$33300(Messages$RcpCommand messages$RcpCommand) {
        return messages$RcpCommand.cid_;
    }

    public static /* synthetic */ Object access$33302(Messages$RcpCommand messages$RcpCommand, Object object) {
        messages$RcpCommand.cid_ = object;
        return object;
    }

    public static /* synthetic */ long access$33402(Messages$RcpCommand messages$RcpCommand, long l10) {
        messages$RcpCommand.t_ = l10;
        return l10;
    }

    public static /* synthetic */ boolean access$33502(Messages$RcpCommand messages$RcpCommand, boolean bl2) {
        messages$RcpCommand.read_ = bl2;
        return bl2;
    }

    public static /* synthetic */ Object access$33600(Messages$RcpCommand messages$RcpCommand) {
        return messages$RcpCommand.from_;
    }

    public static /* synthetic */ Object access$33602(Messages$RcpCommand messages$RcpCommand, Object object) {
        messages$RcpCommand.from_ = object;
        return object;
    }

    public static /* synthetic */ int access$33702(Messages$RcpCommand messages$RcpCommand, int n10) {
        messages$RcpCommand.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ UnknownFieldSet access$33800(Messages$RcpCommand messages$RcpCommand) {
        return messages$RcpCommand.unknownFields;
    }

    public static Messages$RcpCommand getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$32600();
    }

    public static Messages$RcpCommand$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$RcpCommand$Builder newBuilder(Messages$RcpCommand messages$RcpCommand) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$RcpCommand);
    }

    public static Messages$RcpCommand parseDelimitedFrom(InputStream inputStream) {
        return (Messages$RcpCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$RcpCommand parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$RcpCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$RcpCommand parseFrom(ByteString byteString) {
        return (Messages$RcpCommand)PARSER.parseFrom(byteString);
    }

    public static Messages$RcpCommand parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$RcpCommand)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$RcpCommand parseFrom(CodedInputStream codedInputStream) {
        return (Messages$RcpCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$RcpCommand parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$RcpCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$RcpCommand parseFrom(InputStream inputStream) {
        return (Messages$RcpCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$RcpCommand parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$RcpCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$RcpCommand parseFrom(ByteBuffer byteBuffer) {
        return (Messages$RcpCommand)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$RcpCommand parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$RcpCommand)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$RcpCommand parseFrom(byte[] byArray) {
        return (Messages$RcpCommand)PARSER.parseFrom(byArray);
    }

    public static Messages$RcpCommand parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$RcpCommand)PARSER.parseFrom(byArray, extensionRegistryLite);
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
        boolean bl5 = object instanceof Messages$RcpCommand;
        if (!bl5) {
            return super.equals(object);
        }
        object = (Messages$RcpCommand)object;
        bl5 = this.hasId();
        if (bl5 == (bl3 = ((Messages$RcpCommand)object).hasId())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object2 = null;
        }
        bl3 = this.hasId();
        if (bl3) {
            if (bl5 && (bl5 = ((String)(object2 = this.getId())).equals(string2 = ((Messages$RcpCommand)object).getId()))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object2 = null;
            }
        }
        if (bl5 && (bl5 = this.hasCid()) == (bl3 = ((Messages$RcpCommand)object).hasCid())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object2 = null;
        }
        bl3 = this.hasCid();
        if (bl3) {
            if (bl5 && (bl5 = ((String)(object2 = this.getCid())).equals(string2 = ((Messages$RcpCommand)object).getCid()))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object2 = null;
            }
        }
        if (bl5 && (bl5 = this.hasT()) == (bl3 = ((Messages$RcpCommand)object).hasT())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object2 = null;
        }
        bl3 = this.hasT();
        if (bl3) {
            long l10;
            long l11;
            long l12;
            if (bl5 && !(bl5 = (l12 = (l11 = this.getT()) - (l10 = ((Messages$RcpCommand)object).getT())) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object2 = null;
            }
        }
        if (bl5 && (bl5 = this.hasRead()) == (bl3 = ((Messages$RcpCommand)object).hasRead())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object2 = null;
        }
        bl3 = this.hasRead();
        if (bl3) {
            if (bl5 && (bl5 = this.getRead()) == (bl3 = ((Messages$RcpCommand)object).getRead())) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object2 = null;
            }
        }
        if (bl5 && (bl5 = this.hasFrom()) == (bl3 = ((Messages$RcpCommand)object).hasFrom())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object2 = null;
        }
        bl3 = this.hasFrom();
        if (bl3) {
            if (bl5 && (bl5 = ((String)(object2 = this.getFrom())).equals(string2 = ((Messages$RcpCommand)object).getFrom()))) {
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

    public Messages$RcpCommand getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public String getFrom() {
        Object object = this.from_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.from_ = string2;
        }
        return string2;
    }

    public ByteString getFromBytes() {
        Object object = this.from_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.from_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getId() {
        Object object = this.id_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.id_ = string2;
        }
        return string2;
    }

    public ByteString getIdBytes() {
        Object object = this.id_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.id_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public boolean getRead() {
        return this.read_;
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
        if ((n11 &= n12) == n12) {
            object = this.id_;
            n11 = GeneratedMessageV3.computeStringSize(n12, object);
            n10 = 0 + n11;
        }
        n11 = this.bitField0_;
        n12 = 2;
        if ((n11 &= n12) == n12) {
            object = this.cid_;
            n11 = GeneratedMessageV3.computeStringSize(n12, object);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 4;
        if ((n11 &= n12) == n12) {
            long l10 = this.t_;
            n11 = CodedOutputStream.computeInt64Size(3, l10);
            n10 += n11;
        }
        n11 = this.bitField0_;
        int n13 = 8;
        if ((n11 &= n13) == n13) {
            n11 = (int)(this.read_ ? 1 : 0);
            n11 = CodedOutputStream.computeBoolSize(n12, n11 != 0);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 16;
        if ((n11 &= n12) == n12) {
            Object object2 = this.from_;
            n11 = GeneratedMessageV3.computeStringSize(5, object2);
            n10 += n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public long getT() {
        return this.t_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasCid() {
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
    public boolean hasFrom() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 16;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    public boolean hasId() {
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
    public boolean hasRead() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 8;
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
    public boolean hasT() {
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

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = Messages$RcpCommand.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasId() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getId();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasCid() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getCid();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasT() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            long l10 = this.getT();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasRead() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 4) * 53;
            n11 = Internal.hashBoolean(this.getRead());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasFrom() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 5) * 53;
            object = this.getFrom();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$32700().ensureFieldAccessorsInitialized(Messages$RcpCommand.class, Messages$RcpCommand$Builder.class);
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

    public Messages$RcpCommand$Builder newBuilderForType() {
        return Messages$RcpCommand.newBuilder();
    }

    public Messages$RcpCommand$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$RcpCommand$Builder messages$RcpCommand$Builder = new Messages$RcpCommand$Builder(generatedMessageV3$BuilderParent, null);
        return messages$RcpCommand$Builder;
    }

    public Messages$RcpCommand$Builder toBuilder() {
        Messages$RcpCommandOrBuilder messages$RcpCommandOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$RcpCommandOrBuilder) {
            messages$RcpCommandOrBuilder = new Messages$RcpCommand$Builder(null);
        } else {
            messages$RcpCommandOrBuilder = new Messages$RcpCommand$Builder(null);
            messages$RcpCommandOrBuilder = ((Messages$RcpCommand$Builder)messages$RcpCommandOrBuilder).mergeFrom(this);
        }
        return messages$RcpCommandOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Object object;
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == n11) {
            object = this.id_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        n10 = this.bitField0_;
        n11 = 2;
        if ((n10 &= n11) == n11) {
            object = this.cid_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        n10 = this.bitField0_;
        n11 = 4;
        if ((n10 &= n11) == n11) {
            n10 = 3;
            long l10 = this.t_;
            codedOutputStream.writeInt64(n10, l10);
        }
        n10 = this.bitField0_;
        int n12 = 8;
        if ((n10 &= n12) == n12) {
            n10 = (int)(this.read_ ? 1 : 0);
            codedOutputStream.writeBool(n11, n10 != 0);
        }
        n10 = this.bitField0_;
        n11 = 16;
        if ((n10 &= n11) == n11) {
            n10 = 5;
            Object object2 = this.from_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object2);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

