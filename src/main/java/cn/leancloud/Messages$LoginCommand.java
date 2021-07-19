/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$LoginCommand$1;
import cn.leancloud.Messages$LoginCommand$Builder;
import cn.leancloud.Messages$LoginCommandOrBuilder;
import cn.leancloud.Messages$SystemInfo;
import cn.leancloud.Messages$SystemInfo$Builder;
import cn.leancloud.Messages$SystemInfoOrBuilder;
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
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Messages$LoginCommand
extends GeneratedMessageV3
implements Messages$LoginCommandOrBuilder {
    private static final Messages$LoginCommand DEFAULT_INSTANCE;
    public static final Parser PARSER;
    public static final int SYSTEMINFO_FIELD_NUMBER = 1;
    private static final long serialVersionUID;
    private int bitField0_;
    private byte memoizedIsInitialized = (byte)-1;
    private Messages$SystemInfo systemInfo_;

    static {
        Object object = new Messages$LoginCommand();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$LoginCommand$1();
    }

    private Messages$LoginCommand() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Messages$LoginCommand(CodedInputStream object, ExtensionRegistryLite object2) {
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
                    int n11 = ((CodedInputStream)object).readTag();
                    int n12 = 1;
                    if (n11 != 0) {
                        int n13 = 10;
                        if (n11 != n13) {
                            if ((n11 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n11) ? 1 : 0)) != 0) continue;
                        } else {
                            n11 = 0;
                            Messages$SystemInfoOrBuilder messages$SystemInfoOrBuilder = null;
                            n13 = this.bitField0_ & n12;
                            if (n13 == n12) {
                                messages$SystemInfoOrBuilder = this.systemInfo_;
                                messages$SystemInfoOrBuilder = ((Messages$SystemInfo)messages$SystemInfoOrBuilder).toBuilder();
                            }
                            Object object3 = Messages$SystemInfo.PARSER;
                            object3 = ((CodedInputStream)object).readMessage((Parser)object3, (ExtensionRegistryLite)object2);
                            this.systemInfo_ = object3 = (Messages$SystemInfo)object3;
                            if (messages$SystemInfoOrBuilder != null) {
                                ((Messages$SystemInfo$Builder)messages$SystemInfoOrBuilder).mergeFrom((Messages$SystemInfo)object3);
                                messages$SystemInfoOrBuilder = ((Messages$SystemInfo$Builder)messages$SystemInfoOrBuilder).buildPartial();
                                this.systemInfo_ = messages$SystemInfoOrBuilder;
                            }
                            this.bitField0_ = n11 = this.bitField0_ | n12;
                            continue;
                        }
                    }
                    n10 = n12;
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

    public /* synthetic */ Messages$LoginCommand(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$LoginCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ Messages$LoginCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$10300() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ Messages$SystemInfo access$10502(Messages$LoginCommand messages$LoginCommand, Messages$SystemInfo messages$SystemInfo) {
        messages$LoginCommand.systemInfo_ = messages$SystemInfo;
        return messages$SystemInfo;
    }

    public static /* synthetic */ int access$10602(Messages$LoginCommand messages$LoginCommand, int n10) {
        messages$LoginCommand.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ UnknownFieldSet access$10700(Messages$LoginCommand messages$LoginCommand) {
        return messages$LoginCommand.unknownFields;
    }

    public static Messages$LoginCommand getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$9900();
    }

    public static Messages$LoginCommand$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$LoginCommand$Builder newBuilder(Messages$LoginCommand messages$LoginCommand) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$LoginCommand);
    }

    public static Messages$LoginCommand parseDelimitedFrom(InputStream inputStream) {
        return (Messages$LoginCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$LoginCommand parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$LoginCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$LoginCommand parseFrom(ByteString byteString) {
        return (Messages$LoginCommand)PARSER.parseFrom(byteString);
    }

    public static Messages$LoginCommand parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$LoginCommand)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$LoginCommand parseFrom(CodedInputStream codedInputStream) {
        return (Messages$LoginCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$LoginCommand parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$LoginCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$LoginCommand parseFrom(InputStream inputStream) {
        return (Messages$LoginCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$LoginCommand parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$LoginCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$LoginCommand parseFrom(ByteBuffer byteBuffer) {
        return (Messages$LoginCommand)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$LoginCommand parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$LoginCommand)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$LoginCommand parseFrom(byte[] byArray) {
        return (Messages$LoginCommand)PARSER.parseFrom(byArray);
    }

    public static Messages$LoginCommand parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$LoginCommand)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2;
        MessageLite messageLite;
        boolean bl3;
        boolean bl4 = true;
        if (object == this) {
            return bl4;
        }
        boolean bl5 = object instanceof Messages$LoginCommand;
        if (!bl5) {
            return super.equals(object);
        }
        object = (Messages$LoginCommand)object;
        bl5 = this.hasSystemInfo();
        if (bl5 == (bl3 = ((Messages$LoginCommand)object).hasSystemInfo())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            messageLite = null;
        }
        bl3 = this.hasSystemInfo();
        if (bl3) {
            Messages$SystemInfo messages$SystemInfo;
            if (bl5 && (bl5 = ((Messages$SystemInfo)(messageLite = this.getSystemInfo())).equals(messages$SystemInfo = ((Messages$LoginCommand)object).getSystemInfo()))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                messageLite = null;
            }
        }
        if (!bl5 || !(bl2 = ((UnknownFieldSet)(messageLite = this.unknownFields)).equals(object = ((GeneratedMessageV3)object).unknownFields))) {
            bl4 = false;
        }
        return bl4;
    }

    public Messages$LoginCommand getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
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
            Messages$SystemInfo messages$SystemInfo = this.getSystemInfo();
            n11 = CodedOutputStream.computeMessageSize(n12, messages$SystemInfo);
            n10 = 0 + n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public Messages$SystemInfo getSystemInfo() {
        Messages$SystemInfo messages$SystemInfo = this.systemInfo_;
        if (messages$SystemInfo == null) {
            messages$SystemInfo = Messages$SystemInfo.getDefaultInstance();
        }
        return messages$SystemInfo;
    }

    public Messages$SystemInfoOrBuilder getSystemInfoOrBuilder() {
        Messages$SystemInfo messages$SystemInfo = this.systemInfo_;
        if (messages$SystemInfo == null) {
            messages$SystemInfo = Messages$SystemInfo.getDefaultInstance();
        }
        return messages$SystemInfo;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasSystemInfo() {
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
        Object object = Messages$LoginCommand.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasSystemInfo() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getSystemInfo();
            n11 = ((Messages$SystemInfo)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$10000().ensureFieldAccessorsInitialized(Messages$LoginCommand.class, Messages$LoginCommand$Builder.class);
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

    public Messages$LoginCommand$Builder newBuilderForType() {
        return Messages$LoginCommand.newBuilder();
    }

    public Messages$LoginCommand$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$LoginCommand$Builder messages$LoginCommand$Builder = new Messages$LoginCommand$Builder(generatedMessageV3$BuilderParent, null);
        return messages$LoginCommand$Builder;
    }

    public Messages$LoginCommand$Builder toBuilder() {
        Messages$LoginCommandOrBuilder messages$LoginCommandOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$LoginCommandOrBuilder) {
            messages$LoginCommandOrBuilder = new Messages$LoginCommand$Builder(null);
        } else {
            messages$LoginCommandOrBuilder = new Messages$LoginCommand$Builder(null);
            messages$LoginCommandOrBuilder = ((Messages$LoginCommand$Builder)messages$LoginCommandOrBuilder).mergeFrom(this);
        }
        return messages$LoginCommandOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == n11) {
            Messages$SystemInfo messages$SystemInfo = this.getSystemInfo();
            codedOutputStream.writeMessage(n11, messages$SystemInfo);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

