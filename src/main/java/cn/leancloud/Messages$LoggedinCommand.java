/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$LoggedinCommand$1;
import cn.leancloud.Messages$LoggedinCommand$Builder;
import cn.leancloud.Messages$LoggedinCommandOrBuilder;
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

public final class Messages$LoggedinCommand
extends GeneratedMessageV3
implements Messages$LoggedinCommandOrBuilder {
    private static final Messages$LoggedinCommand DEFAULT_INSTANCE;
    public static final Parser PARSER;
    public static final int PUSHDISABLED_FIELD_NUMBER = 1;
    private static final long serialVersionUID;
    private int bitField0_;
    private byte memoizedIsInitialized = (byte)-1;
    private boolean pushDisabled_;

    static {
        Object object = new Messages$LoggedinCommand();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$LoggedinCommand$1();
    }

    private Messages$LoggedinCommand() {
        this.pushDisabled_ = false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Messages$LoggedinCommand(CodedInputStream object, ExtensionRegistryLite object2) {
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
                        int n13 = 8;
                        if (n11 != n13) {
                            if ((n11 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n11) ? 1 : 0)) != 0) continue;
                        } else {
                            this.bitField0_ = n11 = this.bitField0_ | n12;
                            n11 = (int)(((CodedInputStream)object).readBool() ? 1 : 0);
                            this.pushDisabled_ = n11;
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

    public /* synthetic */ Messages$LoggedinCommand(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$LoggedinCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ Messages$LoggedinCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$11300() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ boolean access$11502(Messages$LoggedinCommand messages$LoggedinCommand, boolean bl2) {
        messages$LoggedinCommand.pushDisabled_ = bl2;
        return bl2;
    }

    public static /* synthetic */ int access$11602(Messages$LoggedinCommand messages$LoggedinCommand, int n10) {
        messages$LoggedinCommand.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ UnknownFieldSet access$11700(Messages$LoggedinCommand messages$LoggedinCommand) {
        return messages$LoggedinCommand.unknownFields;
    }

    public static Messages$LoggedinCommand getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$10900();
    }

    public static Messages$LoggedinCommand$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$LoggedinCommand$Builder newBuilder(Messages$LoggedinCommand messages$LoggedinCommand) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$LoggedinCommand);
    }

    public static Messages$LoggedinCommand parseDelimitedFrom(InputStream inputStream) {
        return (Messages$LoggedinCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$LoggedinCommand parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$LoggedinCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$LoggedinCommand parseFrom(ByteString byteString) {
        return (Messages$LoggedinCommand)PARSER.parseFrom(byteString);
    }

    public static Messages$LoggedinCommand parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$LoggedinCommand)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$LoggedinCommand parseFrom(CodedInputStream codedInputStream) {
        return (Messages$LoggedinCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$LoggedinCommand parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$LoggedinCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$LoggedinCommand parseFrom(InputStream inputStream) {
        return (Messages$LoggedinCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$LoggedinCommand parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$LoggedinCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$LoggedinCommand parseFrom(ByteBuffer byteBuffer) {
        return (Messages$LoggedinCommand)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$LoggedinCommand parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$LoggedinCommand)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$LoggedinCommand parseFrom(byte[] byArray) {
        return (Messages$LoggedinCommand)PARSER.parseFrom(byArray);
    }

    public static Messages$LoggedinCommand parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$LoggedinCommand)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2;
        UnknownFieldSet unknownFieldSet;
        boolean bl3;
        boolean bl4 = true;
        if (object == this) {
            return bl4;
        }
        boolean bl5 = object instanceof Messages$LoggedinCommand;
        if (!bl5) {
            return super.equals(object);
        }
        object = (Messages$LoggedinCommand)object;
        bl5 = this.hasPushDisabled();
        if (bl5 == (bl3 = ((Messages$LoggedinCommand)object).hasPushDisabled())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            unknownFieldSet = null;
        }
        bl3 = this.hasPushDisabled();
        if (bl3) {
            if (bl5 && (bl5 = this.getPushDisabled()) == (bl3 = ((Messages$LoggedinCommand)object).getPushDisabled())) {
                bl5 = bl4;
            } else {
                bl5 = false;
                unknownFieldSet = null;
            }
        }
        if (!bl5 || !(bl2 = (unknownFieldSet = this.unknownFields).equals(object = ((GeneratedMessageV3)object).unknownFields))) {
            bl4 = false;
        }
        return bl4;
    }

    public Messages$LoggedinCommand getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public boolean getPushDisabled() {
        return this.pushDisabled_;
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
            n11 = (int)(this.pushDisabled_ ? 1 : 0);
            n11 = CodedOutputStream.computeBoolSize(n12, n11 != 0);
            n10 = 0 + n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasPushDisabled() {
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
        Descriptors$Descriptor descriptors$Descriptor = Messages$LoggedinCommand.getDescriptor();
        int n11 = descriptors$Descriptor.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasPushDisabled() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            n11 = Internal.hashBoolean(this.getPushDisabled());
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$11000().ensureFieldAccessorsInitialized(Messages$LoggedinCommand.class, Messages$LoggedinCommand$Builder.class);
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

    public Messages$LoggedinCommand$Builder newBuilderForType() {
        return Messages$LoggedinCommand.newBuilder();
    }

    public Messages$LoggedinCommand$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$LoggedinCommand$Builder messages$LoggedinCommand$Builder = new Messages$LoggedinCommand$Builder(generatedMessageV3$BuilderParent, null);
        return messages$LoggedinCommand$Builder;
    }

    public Messages$LoggedinCommand$Builder toBuilder() {
        Messages$LoggedinCommandOrBuilder messages$LoggedinCommandOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$LoggedinCommandOrBuilder) {
            messages$LoggedinCommandOrBuilder = new Messages$LoggedinCommand$Builder(null);
        } else {
            messages$LoggedinCommandOrBuilder = new Messages$LoggedinCommand$Builder(null);
            messages$LoggedinCommandOrBuilder = ((Messages$LoggedinCommand$Builder)messages$LoggedinCommandOrBuilder).mergeFrom(this);
        }
        return messages$LoggedinCommandOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        int bl2 = this.bitField0_;
        int n10 = 1;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = this.pushDisabled_;
            codedOutputStream.writeBool(n10, bl3);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

