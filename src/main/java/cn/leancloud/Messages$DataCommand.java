/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$DataCommand$1;
import cn.leancloud.Messages$DataCommand$Builder;
import cn.leancloud.Messages$DataCommandOrBuilder;
import cn.leancloud.Messages$JsonObjectMessage;
import cn.leancloud.Messages$JsonObjectMessageOrBuilder;
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
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class Messages$DataCommand
extends GeneratedMessageV3
implements Messages$DataCommandOrBuilder {
    private static final Messages$DataCommand DEFAULT_INSTANCE;
    public static final int IDS_FIELD_NUMBER = 1;
    public static final int MSG_FIELD_NUMBER = 2;
    public static final int OFFLINE_FIELD_NUMBER = 3;
    public static final Parser PARSER;
    private static final long serialVersionUID;
    private int bitField0_;
    private LazyStringList ids_;
    private byte memoizedIsInitialized;
    private List msg_;
    private boolean offline_;

    static {
        Object object = new Messages$DataCommand();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$DataCommand$1();
    }

    private Messages$DataCommand() {
        List list;
        this.memoizedIsInitialized = (byte)-1;
        this.ids_ = list = LazyStringArrayList.EMPTY;
        list = Collections.emptyList();
        this.msg_ = list;
        this.offline_ = false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Messages$DataCommand(CodedInputStream list, ExtensionRegistryLite list2) {
        int n10;
        int n11;
        int n12;
        UnknownFieldSet$Builder unknownFieldSet$Builder;
        block17: {
            Throwable throwable2;
            this();
            unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
            int n13 = 0;
            n12 = 0;
            while (true) {
                n11 = 2;
                n10 = 1;
                if (n13 != 0) break block17;
                try {
                    try {
                        block18: {
                            int n14 = ((CodedInputStream)((Object)list)).readTag();
                            if (n14 != 0) {
                                Object object;
                                Iterable iterable;
                                int n15 = 10;
                                if (n14 != n15) {
                                    n15 = 18;
                                    if (n14 != n15) {
                                        n15 = 24;
                                        if (n14 != n15) {
                                            n11 = (int)(this.parseUnknownField((CodedInputStream)((Object)list), unknownFieldSet$Builder, (ExtensionRegistryLite)((Object)list2), n14) ? 1 : 0);
                                            if (n11 != 0) continue;
                                            break block18;
                                        } else {
                                            this.bitField0_ = n14 = this.bitField0_ | n10;
                                            n14 = (int)(((CodedInputStream)((Object)list)).readBool() ? 1 : 0);
                                            this.offline_ = n14;
                                            continue;
                                        }
                                    }
                                    n14 = n12 & 2;
                                    if (n14 != n11) {
                                        this.msg_ = iterable;
                                        n12 |= 2;
                                    }
                                    iterable = this.msg_;
                                    object = Messages$JsonObjectMessage.PARSER;
                                    object = ((CodedInputStream)((Object)list)).readMessage((Parser)object, (ExtensionRegistryLite)((Object)list2));
                                    iterable.add(object);
                                    continue;
                                }
                                iterable = ((CodedInputStream)((Object)list)).readBytes();
                                n15 = n12 & 1;
                                if (n15 != n10) {
                                    object = new LazyStringArrayList();
                                    this.ids_ = object;
                                    n12 |= 1;
                                }
                                object = this.ids_;
                                object.add((ByteString)iterable);
                                continue;
                            }
                        }
                        n13 = n10;
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
            int n16 = n12 & 1;
            if (n16 == n10) {
                list2 = this.ids_.getUnmodifiableView();
                this.ids_ = list2;
            }
            if ((n16 = n12 & 2) == n11) {
                this.msg_ = list2 = Collections.unmodifiableList(this.msg_);
            }
            list2 = unknownFieldSet$Builder.build();
            this.unknownFields = list2;
            this.makeExtensionsImmutable();
            throw throwable2;
        }
        int n17 = n12 & 1;
        if (n17 == n10) {
            list = this.ids_.getUnmodifiableView();
            this.ids_ = list;
        }
        if ((n17 = n12 & 2) == n11) {
            this.msg_ = list = Collections.unmodifiableList(this.msg_);
        }
        list = unknownFieldSet$Builder.build();
        this.unknownFields = list;
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ Messages$DataCommand(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$DataCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ Messages$DataCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$12300() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ LazyStringList access$12500(Messages$DataCommand messages$DataCommand) {
        return messages$DataCommand.ids_;
    }

    public static /* synthetic */ LazyStringList access$12502(Messages$DataCommand messages$DataCommand, LazyStringList lazyStringList) {
        messages$DataCommand.ids_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ List access$12600(Messages$DataCommand messages$DataCommand) {
        return messages$DataCommand.msg_;
    }

    public static /* synthetic */ List access$12602(Messages$DataCommand messages$DataCommand, List list) {
        messages$DataCommand.msg_ = list;
        return list;
    }

    public static /* synthetic */ boolean access$12702(Messages$DataCommand messages$DataCommand, boolean bl2) {
        messages$DataCommand.offline_ = bl2;
        return bl2;
    }

    public static /* synthetic */ int access$12802(Messages$DataCommand messages$DataCommand, int n10) {
        messages$DataCommand.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ boolean access$12900() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ UnknownFieldSet access$13000(Messages$DataCommand messages$DataCommand) {
        return messages$DataCommand.unknownFields;
    }

    public static Messages$DataCommand getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$11900();
    }

    public static Messages$DataCommand$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$DataCommand$Builder newBuilder(Messages$DataCommand messages$DataCommand) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$DataCommand);
    }

    public static Messages$DataCommand parseDelimitedFrom(InputStream inputStream) {
        return (Messages$DataCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$DataCommand parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$DataCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$DataCommand parseFrom(ByteString byteString) {
        return (Messages$DataCommand)PARSER.parseFrom(byteString);
    }

    public static Messages$DataCommand parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$DataCommand)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$DataCommand parseFrom(CodedInputStream codedInputStream) {
        return (Messages$DataCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$DataCommand parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$DataCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$DataCommand parseFrom(InputStream inputStream) {
        return (Messages$DataCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$DataCommand parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$DataCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$DataCommand parseFrom(ByteBuffer byteBuffer) {
        return (Messages$DataCommand)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$DataCommand parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$DataCommand)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$DataCommand parseFrom(byte[] byArray) {
        return (Messages$DataCommand)PARSER.parseFrom(byArray);
    }

    public static Messages$DataCommand parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$DataCommand)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3;
        List list;
        boolean bl4 = true;
        if (object == this) {
            return bl4;
        }
        boolean bl5 = object instanceof Messages$DataCommand;
        if (!bl5) {
            return super.equals(object);
        }
        object = (Messages$DataCommand)object;
        Object object2 = this.getIdsList();
        ProtocolStringList protocolStringList = ((Messages$DataCommand)object).getIdsList();
        bl5 = object2.equals(protocolStringList);
        protocolStringList = null;
        if (bl5) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object2 = null;
        }
        if (bl5 && (bl5 = (object2 = this.getMsgList()).equals(list = ((Messages$DataCommand)object).getMsgList()))) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object2 = null;
        }
        if (bl5 && (bl5 = this.hasOffline()) == (bl3 = ((Messages$DataCommand)object).hasOffline())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object2 = null;
        }
        bl3 = this.hasOffline();
        if (bl3) {
            if (bl5 && (bl5 = this.getOffline()) == (bl3 = ((Messages$DataCommand)object).getOffline())) {
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

    public Messages$DataCommand getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public String getIds(int n10) {
        return (String)this.ids_.get(n10);
    }

    public ByteString getIdsBytes(int n10) {
        return this.ids_.getByteString(n10);
    }

    public int getIdsCount() {
        return this.ids_.size();
    }

    public ProtocolStringList getIdsList() {
        return this.ids_;
    }

    public Messages$JsonObjectMessage getMsg(int n10) {
        return (Messages$JsonObjectMessage)this.msg_.get(n10);
    }

    public int getMsgCount() {
        return this.msg_.size();
    }

    public List getMsgList() {
        return this.msg_;
    }

    public Messages$JsonObjectMessageOrBuilder getMsgOrBuilder(int n10) {
        return (Messages$JsonObjectMessageOrBuilder)this.msg_.get(n10);
    }

    public List getMsgOrBuilderList() {
        return this.msg_;
    }

    public boolean getOffline() {
        return this.offline_;
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
        n11 = 0;
        List list = null;
        int n13 = 0;
        for (n12 = 0; n12 < (n10 = (object = this.ids_).size()); ++n12) {
            object = this.ids_.getRaw(n12);
            n10 = GeneratedMessageV3.computeStringSizeNoTag(object);
            n13 += n10;
        }
        n13 += 0;
        list = this.getIdsList();
        n12 = list.size();
        n10 = 1;
        n13 += (n12 *= n10);
        while (n11 < (n12 = (list = this.msg_).size())) {
            MessageLite messageLite = (MessageLite)this.msg_.get(n11);
            n12 = CodedOutputStream.computeMessageSize(2, messageLite);
            n13 += n12;
            ++n11;
        }
        n11 = this.bitField0_ & n10;
        if (n11 == n10) {
            n12 = (int)(this.offline_ ? 1 : 0);
            n11 = CodedOutputStream.computeBoolSize(3, n12 != 0);
            n13 += n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n13 += n11;
        return n13;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasOffline() {
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
        Object object = Messages$DataCommand.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = this.getIdsCount();
        if (n11 > 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getIdsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = this.getMsgCount()) > 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getMsgList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasOffline() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            n11 = Internal.hashBoolean(this.getOffline());
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$12000().ensureFieldAccessorsInitialized(Messages$DataCommand.class, Messages$DataCommand$Builder.class);
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
        for (n11 = 0; n11 < (n10 = this.getMsgCount()); ++n11) {
            Messages$JsonObjectMessage messages$JsonObjectMessage = this.getMsg(n11);
            n10 = messages$JsonObjectMessage.isInitialized();
            if (n10 != 0) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = (byte)n12;
        return n12 != 0;
    }

    public Messages$DataCommand$Builder newBuilderForType() {
        return Messages$DataCommand.newBuilder();
    }

    public Messages$DataCommand$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$DataCommand$Builder messages$DataCommand$Builder = new Messages$DataCommand$Builder(generatedMessageV3$BuilderParent, null);
        return messages$DataCommand$Builder;
    }

    public Messages$DataCommand$Builder toBuilder() {
        Messages$DataCommandOrBuilder messages$DataCommandOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$DataCommandOrBuilder) {
            messages$DataCommandOrBuilder = new Messages$DataCommand$Builder(null);
        } else {
            messages$DataCommandOrBuilder = new Messages$DataCommand$Builder(null);
            messages$DataCommandOrBuilder = ((Messages$DataCommand$Builder)messages$DataCommandOrBuilder).mergeFrom(this);
        }
        return messages$DataCommandOrBuilder;
    }

    /*
     * WARNING - void declaration
     */
    public void writeTo(CodedOutputStream codedOutputStream) {
        int n10;
        void var2_3;
        int n11;
        Object object;
        boolean bl3 = false;
        boolean bl2 = false;
        List list = null;
        while (true) {
            void var3_7;
            object = this.ids_;
            int n12 = object.size();
            n11 = 1;
            if (++var3_7 >= n12) break;
            object = this.ids_.getRaw((int)var3_7);
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        while (++var2_3 < (n10 = (list = this.msg_).size())) {
            n10 = 2;
            object = (MessageLite)this.msg_.get((int)var2_3);
            codedOutputStream.writeMessage(n10, (MessageLite)object);
        }
        int n13 = this.bitField0_ & n11;
        if (n13 == n11) {
            int n14 = 3;
            boolean bl4 = this.offline_;
            codedOutputStream.writeBool(n14, bl4);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

