/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$PresenceCommand$1;
import cn.leancloud.Messages$PresenceCommand$Builder;
import cn.leancloud.Messages$PresenceCommandOrBuilder;
import cn.leancloud.Messages$StatusType;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Messages$PresenceCommand
extends GeneratedMessageV3
implements Messages$PresenceCommandOrBuilder {
    public static final int CID_FIELD_NUMBER = 3;
    private static final Messages$PresenceCommand DEFAULT_INSTANCE;
    public static final Parser PARSER;
    public static final int SESSIONPEERIDS_FIELD_NUMBER = 2;
    public static final int STATUS_FIELD_NUMBER = 1;
    private static final long serialVersionUID;
    private int bitField0_;
    private volatile Object cid_;
    private byte memoizedIsInitialized;
    private LazyStringList sessionPeerIds_;
    private int status_;

    static {
        Object object = new Messages$PresenceCommand();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$PresenceCommand$1();
    }

    private Messages$PresenceCommand() {
        LazyStringList lazyStringList;
        this.memoizedIsInitialized = (byte)-1;
        this.status_ = 1;
        this.sessionPeerIds_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.cid_ = "";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Messages$PresenceCommand(CodedInputStream object, ExtensionRegistryLite object2) {
        int n10;
        int n11;
        UnknownFieldSet$Builder unknownFieldSet$Builder;
        block15: {
            Throwable throwable2;
            this();
            unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
            int n12 = 0;
            n11 = 0;
            while (true) {
                n10 = 2;
                if (n12 != 0) break block15;
                try {
                    try {
                        int n13;
                        block16: {
                            int n14 = ((CodedInputStream)object).readTag();
                            n13 = 1;
                            if (n14 != 0) {
                                int n15 = 8;
                                if (n14 != n15) {
                                    LazyStringList lazyStringList;
                                    ByteString byteString;
                                    n15 = 18;
                                    if (n14 != n15) {
                                        n15 = 26;
                                        if (n14 != n15) {
                                            n10 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n14) ? 1 : 0);
                                            if (n10 != 0) continue;
                                            break block16;
                                        } else {
                                            byteString = ((CodedInputStream)object).readBytes();
                                            this.bitField0_ = n13 = this.bitField0_ | n10;
                                            this.cid_ = byteString;
                                            continue;
                                        }
                                    }
                                    byteString = ((CodedInputStream)object).readBytes();
                                    n13 = n11 & 2;
                                    if (n13 != n10) {
                                        this.sessionPeerIds_ = lazyStringList = new LazyStringArrayList();
                                        n11 |= 2;
                                    }
                                    lazyStringList = this.sessionPeerIds_;
                                    lazyStringList.add(byteString);
                                    continue;
                                }
                                n14 = ((CodedInputStream)object).readEnum();
                                Messages$StatusType messages$StatusType = Messages$StatusType.valueOf(n14);
                                if (messages$StatusType == null) {
                                    unknownFieldSet$Builder.mergeVarintField(n13, n14);
                                    continue;
                                }
                                n15 = this.bitField0_;
                                this.bitField0_ = n13 |= n15;
                                this.status_ = n14;
                                continue;
                            }
                        }
                        n12 = n13;
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
            int n16 = n11 & 2;
            if (n16 == n10) {
                this.sessionPeerIds_ = object2 = this.sessionPeerIds_.getUnmodifiableView();
            }
            this.unknownFields = object2 = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            throw throwable2;
        }
        int n17 = n11 & 2;
        if (n17 == n10) {
            this.sessionPeerIds_ = object = this.sessionPeerIds_.getUnmodifiableView();
        }
        this.unknownFields = object = unknownFieldSet$Builder.build();
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ Messages$PresenceCommand(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$PresenceCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ Messages$PresenceCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$38100() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ int access$38302(Messages$PresenceCommand messages$PresenceCommand, int n10) {
        messages$PresenceCommand.status_ = n10;
        return n10;
    }

    public static /* synthetic */ LazyStringList access$38400(Messages$PresenceCommand messages$PresenceCommand) {
        return messages$PresenceCommand.sessionPeerIds_;
    }

    public static /* synthetic */ LazyStringList access$38402(Messages$PresenceCommand messages$PresenceCommand, LazyStringList lazyStringList) {
        messages$PresenceCommand.sessionPeerIds_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ Object access$38500(Messages$PresenceCommand messages$PresenceCommand) {
        return messages$PresenceCommand.cid_;
    }

    public static /* synthetic */ Object access$38502(Messages$PresenceCommand messages$PresenceCommand, Object object) {
        messages$PresenceCommand.cid_ = object;
        return object;
    }

    public static /* synthetic */ int access$38602(Messages$PresenceCommand messages$PresenceCommand, int n10) {
        messages$PresenceCommand.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ UnknownFieldSet access$38700(Messages$PresenceCommand messages$PresenceCommand) {
        return messages$PresenceCommand.unknownFields;
    }

    public static Messages$PresenceCommand getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$37700();
    }

    public static Messages$PresenceCommand$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$PresenceCommand$Builder newBuilder(Messages$PresenceCommand messages$PresenceCommand) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$PresenceCommand);
    }

    public static Messages$PresenceCommand parseDelimitedFrom(InputStream inputStream) {
        return (Messages$PresenceCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$PresenceCommand parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$PresenceCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$PresenceCommand parseFrom(ByteString byteString) {
        return (Messages$PresenceCommand)PARSER.parseFrom(byteString);
    }

    public static Messages$PresenceCommand parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$PresenceCommand)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$PresenceCommand parseFrom(CodedInputStream codedInputStream) {
        return (Messages$PresenceCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$PresenceCommand parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$PresenceCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$PresenceCommand parseFrom(InputStream inputStream) {
        return (Messages$PresenceCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$PresenceCommand parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$PresenceCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$PresenceCommand parseFrom(ByteBuffer byteBuffer) {
        return (Messages$PresenceCommand)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$PresenceCommand parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$PresenceCommand)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$PresenceCommand parseFrom(byte[] byArray) {
        return (Messages$PresenceCommand)PARSER.parseFrom(byArray);
    }

    public static Messages$PresenceCommand parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$PresenceCommand)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2;
        Object object2;
        Object object3;
        int n10;
        int n11 = 1;
        if (object == this) {
            return n11;
        }
        int n12 = object instanceof Messages$PresenceCommand;
        if (!n12) {
            return super.equals(object);
        }
        object = (Messages$PresenceCommand)object;
        n12 = this.hasStatus();
        if (n12 == (n10 = ((Messages$PresenceCommand)object).hasStatus())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasStatus();
        if (n10 != 0) {
            if (n12 && (n12 = this.status_) == (n10 = ((Messages$PresenceCommand)object).status_)) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)((object3 = this.getSessionPeerIdsList()).equals(object2 = ((Messages$PresenceCommand)object).getSessionPeerIdsList()) ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        if (n12 && (n12 = (int)(this.hasCid() ? 1 : 0)) == (n10 = (int)(((Messages$PresenceCommand)object).hasCid() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasCid() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = ((String)(object3 = this.getCid())).equals(object2 = ((Messages$PresenceCommand)object).getCid()))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (!n12 || !(bl2 = ((UnknownFieldSet)(object3 = this.unknownFields)).equals(object = ((GeneratedMessageV3)object).unknownFields))) {
            n11 = 0;
        }
        return n11;
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

    public Messages$PresenceCommand getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        Object object;
        int n10;
        int n11 = this.memoizedSize;
        int n12 = -1;
        if (n11 != n12) {
            return n11;
        }
        n11 = this.bitField0_;
        n12 = 1;
        int n13 = 0;
        Object object2 = null;
        if ((n11 &= n12) == n12) {
            n11 = this.status_;
            n11 = CodedOutputStream.computeEnumSize(n12, n11) + 0;
        } else {
            n11 = 0;
        }
        int n14 = 0;
        while (n13 < (n10 = (object = this.sessionPeerIds_).size())) {
            object = this.sessionPeerIds_.getRaw(n13);
            n10 = GeneratedMessageV3.computeStringSizeNoTag(object);
            n14 += n10;
            ++n13;
        }
        n11 += n14;
        object2 = this.getSessionPeerIdsList();
        n13 = object2.size() * n12;
        n11 += n13;
        n12 = this.bitField0_;
        n13 = 2;
        if ((n12 &= n13) == n13) {
            object2 = this.cid_;
            n12 = GeneratedMessageV3.computeStringSize(3, object2);
            n11 += n12;
        }
        n12 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n11 += n12;
        return n11;
    }

    public String getSessionPeerIds(int n10) {
        return (String)this.sessionPeerIds_.get(n10);
    }

    public ByteString getSessionPeerIdsBytes(int n10) {
        return this.sessionPeerIds_.getByteString(n10);
    }

    public int getSessionPeerIdsCount() {
        return this.sessionPeerIds_.size();
    }

    public ProtocolStringList getSessionPeerIdsList() {
        return this.sessionPeerIds_;
    }

    public Messages$StatusType getStatus() {
        int n10 = this.status_;
        Messages$StatusType messages$StatusType = Messages$StatusType.valueOf(n10);
        if (messages$StatusType == null) {
            messages$StatusType = Messages$StatusType.on;
        }
        return messages$StatusType;
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

    public boolean hasStatus() {
        int bl2 = this.bitField0_;
        int n10 = 1;
        int n11 = bl2 & n10;
        if (n11 != n10) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = Messages$PresenceCommand.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasStatus() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            n11 = this.status_;
            n10 += n11;
        }
        if ((n11 = this.getSessionPeerIdsCount()) > 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getSessionPeerIdsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasCid() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            object = this.getCid();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$37800().ensureFieldAccessorsInitialized(Messages$PresenceCommand.class, Messages$PresenceCommand$Builder.class);
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

    public Messages$PresenceCommand$Builder newBuilderForType() {
        return Messages$PresenceCommand.newBuilder();
    }

    public Messages$PresenceCommand$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$PresenceCommand$Builder messages$PresenceCommand$Builder = new Messages$PresenceCommand$Builder(generatedMessageV3$BuilderParent, null);
        return messages$PresenceCommand$Builder;
    }

    public Messages$PresenceCommand$Builder toBuilder() {
        Messages$PresenceCommandOrBuilder messages$PresenceCommandOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$PresenceCommandOrBuilder) {
            messages$PresenceCommandOrBuilder = new Messages$PresenceCommand$Builder(null);
        } else {
            messages$PresenceCommandOrBuilder = new Messages$PresenceCommand$Builder(null);
            messages$PresenceCommandOrBuilder = ((Messages$PresenceCommand$Builder)messages$PresenceCommandOrBuilder).mergeFrom(this);
        }
        return messages$PresenceCommandOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        int n10;
        Object object;
        int n11 = this.bitField0_;
        int n12 = 1;
        if ((n11 &= n12) == n12) {
            n11 = this.status_;
            codedOutputStream.writeEnum(n12, n11);
        }
        n11 = 0;
        while (true) {
            object = this.sessionPeerIds_;
            n12 = object.size();
            n10 = 2;
            if (n11 >= n12) break;
            object = this.sessionPeerIds_.getRaw(n11);
            GeneratedMessageV3.writeString(codedOutputStream, n10, object);
            ++n11;
        }
        n11 = this.bitField0_ & n10;
        if (n11 == n10) {
            n11 = 3;
            object = this.cid_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

