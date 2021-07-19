/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$PatchCommand$1;
import cn.leancloud.Messages$PatchCommand$Builder;
import cn.leancloud.Messages$PatchCommandOrBuilder;
import cn.leancloud.Messages$PatchItem;
import cn.leancloud.Messages$PatchItemOrBuilder;
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

public final class Messages$PatchCommand
extends GeneratedMessageV3
implements Messages$PatchCommandOrBuilder {
    private static final Messages$PatchCommand DEFAULT_INSTANCE;
    public static final int LASTPATCHTIME_FIELD_NUMBER = 2;
    public static final Parser PARSER;
    public static final int PATCHES_FIELD_NUMBER = 1;
    private static final long serialVersionUID;
    private int bitField0_;
    private long lastPatchTime_;
    private byte memoizedIsInitialized;
    private List patches_;

    static {
        Object object = new Messages$PatchCommand();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$PatchCommand$1();
    }

    private Messages$PatchCommand() {
        List list;
        this.memoizedIsInitialized = (byte)-1;
        this.patches_ = list = Collections.emptyList();
        this.lastPatchTime_ = 0L;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Messages$PatchCommand(CodedInputStream list, ExtensionRegistryLite list2) {
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
                                        this.lastPatchTime_ = l10 = ((CodedInputStream)((Object)list)).readInt64();
                                        continue;
                                    }
                                }
                                n13 = n11 & 1;
                                if (n13 != n10) {
                                    this.patches_ = list3 = new List<Object>();
                                    n11 |= 1;
                                }
                                list3 = this.patches_;
                                Object object = Messages$PatchItem.PARSER;
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
                this.patches_ = list2 = Collections.unmodifiableList(this.patches_);
            }
            list2 = unknownFieldSet$Builder.build();
            this.unknownFields = list2;
            this.makeExtensionsImmutable();
            throw throwable2;
        }
        int n16 = n11 & 1;
        if (n16 == n10) {
            this.patches_ = list = Collections.unmodifiableList(this.patches_);
        }
        list = unknownFieldSet$Builder.build();
        this.unknownFields = list;
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ Messages$PatchCommand(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$PatchCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ Messages$PatchCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$42600() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ List access$42800(Messages$PatchCommand messages$PatchCommand) {
        return messages$PatchCommand.patches_;
    }

    public static /* synthetic */ List access$42802(Messages$PatchCommand messages$PatchCommand, List list) {
        messages$PatchCommand.patches_ = list;
        return list;
    }

    public static /* synthetic */ long access$42902(Messages$PatchCommand messages$PatchCommand, long l10) {
        messages$PatchCommand.lastPatchTime_ = l10;
        return l10;
    }

    public static /* synthetic */ int access$43002(Messages$PatchCommand messages$PatchCommand, int n10) {
        messages$PatchCommand.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ boolean access$43100() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ UnknownFieldSet access$43200(Messages$PatchCommand messages$PatchCommand) {
        return messages$PatchCommand.unknownFields;
    }

    public static Messages$PatchCommand getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$42200();
    }

    public static Messages$PatchCommand$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$PatchCommand$Builder newBuilder(Messages$PatchCommand messages$PatchCommand) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$PatchCommand);
    }

    public static Messages$PatchCommand parseDelimitedFrom(InputStream inputStream) {
        return (Messages$PatchCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$PatchCommand parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$PatchCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$PatchCommand parseFrom(ByteString byteString) {
        return (Messages$PatchCommand)PARSER.parseFrom(byteString);
    }

    public static Messages$PatchCommand parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$PatchCommand)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$PatchCommand parseFrom(CodedInputStream codedInputStream) {
        return (Messages$PatchCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$PatchCommand parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$PatchCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$PatchCommand parseFrom(InputStream inputStream) {
        return (Messages$PatchCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$PatchCommand parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$PatchCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$PatchCommand parseFrom(ByteBuffer byteBuffer) {
        return (Messages$PatchCommand)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$PatchCommand parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$PatchCommand)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$PatchCommand parseFrom(byte[] byArray) {
        return (Messages$PatchCommand)PARSER.parseFrom(byArray);
    }

    public static Messages$PatchCommand parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$PatchCommand)PARSER.parseFrom(byArray, extensionRegistryLite);
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
        boolean bl5 = object instanceof Messages$PatchCommand;
        if (!bl5) {
            return super.equals(object);
        }
        object = (Messages$PatchCommand)object;
        Object object2 = this.getPatchesList();
        List list = ((Messages$PatchCommand)object).getPatchesList();
        bl5 = object2.equals(list);
        list = null;
        if (bl5) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object2 = null;
        }
        if (bl5 && (bl5 = this.hasLastPatchTime()) == (bl3 = ((Messages$PatchCommand)object).hasLastPatchTime())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object2 = null;
        }
        bl3 = this.hasLastPatchTime();
        if (bl3) {
            long l10;
            long l11;
            long l12;
            if (bl5 && !(bl5 = (l12 = (l11 = this.getLastPatchTime()) - (l10 = ((Messages$PatchCommand)object).getLastPatchTime())) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
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

    public Messages$PatchCommand getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public long getLastPatchTime() {
        return this.lastPatchTime_;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public Messages$PatchItem getPatches(int n10) {
        return (Messages$PatchItem)this.patches_.get(n10);
    }

    public int getPatchesCount() {
        return this.patches_.size();
    }

    public List getPatchesList() {
        return this.patches_;
    }

    public Messages$PatchItemOrBuilder getPatchesOrBuilder(int n10) {
        return (Messages$PatchItemOrBuilder)this.patches_.get(n10);
    }

    public List getPatchesOrBuilderList() {
        return this.patches_;
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
            Object object = this.patches_;
            int n13 = object.size();
            n10 = 1;
            if (n11 >= n13) break;
            object = (MessageLite)this.patches_.get(n11);
            n13 = CodedOutputStream.computeMessageSize(n10, (MessageLite)object);
            n12 += n13;
            ++n11;
        }
        n11 = this.bitField0_ & n10;
        if (n11 == n10) {
            long l10 = this.lastPatchTime_;
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

    public boolean hasLastPatchTime() {
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
        Object object = Messages$PatchCommand.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = this.getPatchesCount();
        if (n11 > 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getPatchesList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasLastPatchTime() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            long l10 = this.getLastPatchTime();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$42300().ensureFieldAccessorsInitialized(Messages$PatchCommand.class, Messages$PatchCommand$Builder.class);
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

    public Messages$PatchCommand$Builder newBuilderForType() {
        return Messages$PatchCommand.newBuilder();
    }

    public Messages$PatchCommand$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$PatchCommand$Builder messages$PatchCommand$Builder = new Messages$PatchCommand$Builder(generatedMessageV3$BuilderParent, null);
        return messages$PatchCommand$Builder;
    }

    public Messages$PatchCommand$Builder toBuilder() {
        Messages$PatchCommandOrBuilder messages$PatchCommandOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$PatchCommandOrBuilder) {
            messages$PatchCommandOrBuilder = new Messages$PatchCommand$Builder(null);
        } else {
            messages$PatchCommandOrBuilder = new Messages$PatchCommand$Builder(null);
            messages$PatchCommandOrBuilder = ((Messages$PatchCommand$Builder)messages$PatchCommandOrBuilder).mergeFrom(this);
        }
        return messages$PatchCommandOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        int n10;
        int n11 = 0;
        while (true) {
            Object object = this.patches_;
            int n12 = object.size();
            n10 = 1;
            if (n11 >= n12) break;
            object = (MessageLite)this.patches_.get(n11);
            codedOutputStream.writeMessage(n10, (MessageLite)object);
            ++n11;
        }
        n11 = this.bitField0_ & n10;
        if (n11 == n10) {
            n11 = 2;
            long l10 = this.lastPatchTime_;
            codedOutputStream.writeInt64(n11, l10);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

