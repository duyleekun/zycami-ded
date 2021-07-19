/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$UnreadCommand$1;
import cn.leancloud.Messages$UnreadCommand$Builder;
import cn.leancloud.Messages$UnreadCommandOrBuilder;
import cn.leancloud.Messages$UnreadTuple;
import cn.leancloud.Messages$UnreadTupleOrBuilder;
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
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class Messages$UnreadCommand
extends GeneratedMessageV3
implements Messages$UnreadCommandOrBuilder {
    public static final int CONVS_FIELD_NUMBER = 1;
    private static final Messages$UnreadCommand DEFAULT_INSTANCE;
    public static final int NOTIFTIME_FIELD_NUMBER = 2;
    public static final Parser PARSER;
    private static final long serialVersionUID;
    private int bitField0_;
    private List convs_;
    private byte memoizedIsInitialized;
    private long notifTime_;

    static {
        Object object = new Messages$UnreadCommand();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$UnreadCommand$1();
    }

    private Messages$UnreadCommand() {
        List list;
        this.memoizedIsInitialized = (byte)-1;
        this.convs_ = list = Collections.emptyList();
        this.notifTime_ = 0L;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Messages$UnreadCommand(CodedInputStream list, ExtensionRegistryLite list2) {
        int n10;
        int n11;
        UnknownFieldSet$Builder unknownFieldSet$Builder;
        block13: {
            Throwable throwable2;
            this();
            unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
            int n12 = 0;
            n11 = 0;
            while (true) {
                n10 = 1;
                if (n12 != 0) break block13;
                try {
                    try {
                        block14: {
                            int n13 = ((CodedInputStream)((Object)list)).readTag();
                            if (n13 != 0) {
                                List<Object> list3;
                                int n14 = 10;
                                if (n13 != n14) {
                                    n14 = 16;
                                    if (n13 != n14) {
                                        if ((n13 = (int)(this.parseUnknownField((CodedInputStream)((Object)list), unknownFieldSet$Builder, (ExtensionRegistryLite)((Object)list2), n13) ? 1 : 0)) != 0) continue;
                                        break block14;
                                    } else {
                                        long l10;
                                        this.bitField0_ = n13 = this.bitField0_ | n10;
                                        this.notifTime_ = l10 = ((CodedInputStream)((Object)list)).readInt64();
                                        continue;
                                    }
                                }
                                n13 = n11 & 1;
                                if (n13 != n10) {
                                    this.convs_ = list3 = new List<Object>();
                                    n11 |= 1;
                                }
                                list3 = this.convs_;
                                Object object = Messages$UnreadTuple.PARSER;
                                object = ((CodedInputStream)((Object)list)).readMessage((Parser)object, (ExtensionRegistryLite)((Object)list2));
                                list3.add(object);
                                continue;
                            }
                        }
                        n12 = n10;
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
                catch (Throwable throwable2) {}
                break;
            }
            int n15 = n11 & 1;
            if (n15 == n10) {
                this.convs_ = list2 = Collections.unmodifiableList(this.convs_);
            }
            list2 = unknownFieldSet$Builder.build();
            this.unknownFields = list2;
            this.makeExtensionsImmutable();
            throw throwable2;
        }
        int n16 = n11 & 1;
        if (n16 == n10) {
            this.convs_ = list = Collections.unmodifiableList(this.convs_);
        }
        list = unknownFieldSet$Builder.build();
        this.unknownFields = list;
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ Messages$UnreadCommand(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$UnreadCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ Messages$UnreadCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$23000() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ List access$23200(Messages$UnreadCommand messages$UnreadCommand) {
        return messages$UnreadCommand.convs_;
    }

    public static /* synthetic */ List access$23202(Messages$UnreadCommand messages$UnreadCommand, List list) {
        messages$UnreadCommand.convs_ = list;
        return list;
    }

    public static /* synthetic */ long access$23302(Messages$UnreadCommand messages$UnreadCommand, long l10) {
        messages$UnreadCommand.notifTime_ = l10;
        return l10;
    }

    public static /* synthetic */ int access$23402(Messages$UnreadCommand messages$UnreadCommand, int n10) {
        messages$UnreadCommand.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ boolean access$23500() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ UnknownFieldSet access$23600(Messages$UnreadCommand messages$UnreadCommand) {
        return messages$UnreadCommand.unknownFields;
    }

    public static Messages$UnreadCommand getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$22600();
    }

    public static Messages$UnreadCommand$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$UnreadCommand$Builder newBuilder(Messages$UnreadCommand messages$UnreadCommand) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$UnreadCommand);
    }

    public static Messages$UnreadCommand parseDelimitedFrom(InputStream inputStream) {
        return (Messages$UnreadCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$UnreadCommand parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$UnreadCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$UnreadCommand parseFrom(ByteString byteString) {
        return (Messages$UnreadCommand)PARSER.parseFrom(byteString);
    }

    public static Messages$UnreadCommand parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$UnreadCommand)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$UnreadCommand parseFrom(CodedInputStream codedInputStream) {
        return (Messages$UnreadCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$UnreadCommand parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$UnreadCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$UnreadCommand parseFrom(InputStream inputStream) {
        return (Messages$UnreadCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$UnreadCommand parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$UnreadCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$UnreadCommand parseFrom(ByteBuffer byteBuffer) {
        return (Messages$UnreadCommand)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$UnreadCommand parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$UnreadCommand)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$UnreadCommand parseFrom(byte[] byArray) {
        return (Messages$UnreadCommand)PARSER.parseFrom(byArray);
    }

    public static Messages$UnreadCommand parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$UnreadCommand)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3;
        boolean bl4 = true;
        if (object == this) {
            return bl4;
        }
        boolean bl5 = object instanceof Messages$UnreadCommand;
        if (!bl5) {
            return super.equals(object);
        }
        object = (Messages$UnreadCommand)object;
        Object object2 = this.getConvsList();
        List list = ((Messages$UnreadCommand)object).getConvsList();
        bl5 = object2.equals(list);
        list = null;
        if (bl5) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object2 = null;
        }
        if (bl5 && (bl5 = this.hasNotifTime()) == (bl3 = ((Messages$UnreadCommand)object).hasNotifTime())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object2 = null;
        }
        bl3 = this.hasNotifTime();
        if (bl3) {
            long l10;
            long l11;
            long l12;
            if (bl5 && !(bl5 = (l12 = (l11 = this.getNotifTime()) - (l10 = ((Messages$UnreadCommand)object).getNotifTime())) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
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

    public Messages$UnreadTuple getConvs(int n10) {
        return (Messages$UnreadTuple)this.convs_.get(n10);
    }

    public int getConvsCount() {
        return this.convs_.size();
    }

    public List getConvsList() {
        return this.convs_;
    }

    public Messages$UnreadTupleOrBuilder getConvsOrBuilder(int n10) {
        return (Messages$UnreadTupleOrBuilder)this.convs_.get(n10);
    }

    public List getConvsOrBuilderList() {
        return this.convs_;
    }

    public Messages$UnreadCommand getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public long getNotifTime() {
        return this.notifTime_;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int n10;
        int n11 = this.memoizedSize;
        int n12 = -1;
        if (n11 != n12) {
            return n11;
        }
        n11 = 0;
        n12 = 0;
        while (true) {
            Object object = this.convs_;
            int n13 = object.size();
            n10 = 1;
            if (n11 >= n13) break;
            object = (MessageLite)this.convs_.get(n11);
            n13 = CodedOutputStream.computeMessageSize(n10, (MessageLite)object);
            n12 += n13;
            ++n11;
        }
        n11 = this.bitField0_ & n10;
        if (n11 == n10) {
            long l10 = this.notifTime_;
            n11 = CodedOutputStream.computeInt64Size(2, l10);
            n12 += n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n12 += n11;
        return n12;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasNotifTime() {
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
        Object object = Messages$UnreadCommand.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = this.getConvsCount();
        if (n11 > 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getConvsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasNotifTime() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            long l10 = this.getNotifTime();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$22700().ensureFieldAccessorsInitialized(Messages$UnreadCommand.class, Messages$UnreadCommand$Builder.class);
    }

    public final boolean isInitialized() {
        int n10;
        int n11 = this.memoizedIsInitialized;
        int n12 = 1;
        if (n11 == n12) {
            return n12 != 0;
        }
        if (n11 == 0) {
            return false;
        }
        for (n11 = 0; n11 < (n10 = this.getConvsCount()); ++n11) {
            Messages$UnreadTuple messages$UnreadTuple = this.getConvs(n11);
            n10 = messages$UnreadTuple.isInitialized();
            if (n10 != 0) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = (byte)n12;
        return n12 != 0;
    }

    public Messages$UnreadCommand$Builder newBuilderForType() {
        return Messages$UnreadCommand.newBuilder();
    }

    public Messages$UnreadCommand$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$UnreadCommand$Builder messages$UnreadCommand$Builder = new Messages$UnreadCommand$Builder(generatedMessageV3$BuilderParent, null);
        return messages$UnreadCommand$Builder;
    }

    public Messages$UnreadCommand$Builder toBuilder() {
        Messages$UnreadCommandOrBuilder messages$UnreadCommandOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$UnreadCommandOrBuilder) {
            messages$UnreadCommandOrBuilder = new Messages$UnreadCommand$Builder(null);
        } else {
            messages$UnreadCommandOrBuilder = new Messages$UnreadCommand$Builder(null);
            messages$UnreadCommandOrBuilder = ((Messages$UnreadCommand$Builder)messages$UnreadCommandOrBuilder).mergeFrom(this);
        }
        return messages$UnreadCommandOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        int n10;
        int n11 = 0;
        while (true) {
            Object object = this.convs_;
            int n12 = object.size();
            n10 = 1;
            if (n11 >= n12) break;
            object = (MessageLite)this.convs_.get(n11);
            codedOutputStream.writeMessage(n10, (MessageLite)object);
            ++n11;
        }
        n11 = this.bitField0_ & n10;
        if (n11 == n10) {
            n11 = 2;
            long l10 = this.notifTime_;
            codedOutputStream.writeInt64(n11, l10);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

