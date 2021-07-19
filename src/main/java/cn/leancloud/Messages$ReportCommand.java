/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$ReportCommand$1;
import cn.leancloud.Messages$ReportCommand$Builder;
import cn.leancloud.Messages$ReportCommandOrBuilder;
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

public final class Messages$ReportCommand
extends GeneratedMessageV3
implements Messages$ReportCommandOrBuilder {
    public static final int DATA_FIELD_NUMBER = 3;
    private static final Messages$ReportCommand DEFAULT_INSTANCE;
    public static final int INITIATIVE_FIELD_NUMBER = 1;
    public static final Parser PARSER;
    public static final int TYPE_FIELD_NUMBER = 2;
    private static final long serialVersionUID;
    private int bitField0_;
    private volatile Object data_;
    private boolean initiative_;
    private byte memoizedIsInitialized = (byte)-1;
    private volatile Object type_;

    static {
        Object object = new Messages$ReportCommand();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$ReportCommand$1();
    }

    private Messages$ReportCommand() {
        this.initiative_ = false;
        String string2 = "";
        this.type_ = string2;
        this.data_ = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Messages$ReportCommand(CodedInputStream object, ExtensionRegistryLite object2) {
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
                            int n13 = 8;
                            if (n12 != n13) {
                                ByteString byteString;
                                n13 = 18;
                                if (n12 != n13) {
                                    n13 = 26;
                                    if (n12 != n13) {
                                        if ((n12 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n12) ? 1 : 0)) != 0) continue;
                                        break block12;
                                    } else {
                                        byteString = ((CodedInputStream)object).readBytes();
                                        this.bitField0_ = n11 = this.bitField0_ | 4;
                                        this.data_ = byteString;
                                        continue;
                                    }
                                }
                                byteString = ((CodedInputStream)object).readBytes();
                                this.bitField0_ = n11 = this.bitField0_ | 2;
                                this.type_ = byteString;
                                continue;
                            }
                            this.bitField0_ = n12 = this.bitField0_ | n11;
                            n12 = (int)(((CodedInputStream)object).readBool() ? 1 : 0);
                            this.initiative_ = n12;
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

    public /* synthetic */ Messages$ReportCommand(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$ReportCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ Messages$ReportCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$39300() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ boolean access$39502(Messages$ReportCommand messages$ReportCommand, boolean bl2) {
        messages$ReportCommand.initiative_ = bl2;
        return bl2;
    }

    public static /* synthetic */ Object access$39600(Messages$ReportCommand messages$ReportCommand) {
        return messages$ReportCommand.type_;
    }

    public static /* synthetic */ Object access$39602(Messages$ReportCommand messages$ReportCommand, Object object) {
        messages$ReportCommand.type_ = object;
        return object;
    }

    public static /* synthetic */ Object access$39700(Messages$ReportCommand messages$ReportCommand) {
        return messages$ReportCommand.data_;
    }

    public static /* synthetic */ Object access$39702(Messages$ReportCommand messages$ReportCommand, Object object) {
        messages$ReportCommand.data_ = object;
        return object;
    }

    public static /* synthetic */ int access$39802(Messages$ReportCommand messages$ReportCommand, int n10) {
        messages$ReportCommand.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ UnknownFieldSet access$39900(Messages$ReportCommand messages$ReportCommand) {
        return messages$ReportCommand.unknownFields;
    }

    public static Messages$ReportCommand getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$38900();
    }

    public static Messages$ReportCommand$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$ReportCommand$Builder newBuilder(Messages$ReportCommand messages$ReportCommand) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$ReportCommand);
    }

    public static Messages$ReportCommand parseDelimitedFrom(InputStream inputStream) {
        return (Messages$ReportCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$ReportCommand parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ReportCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$ReportCommand parseFrom(ByteString byteString) {
        return (Messages$ReportCommand)PARSER.parseFrom(byteString);
    }

    public static Messages$ReportCommand parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ReportCommand)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$ReportCommand parseFrom(CodedInputStream codedInputStream) {
        return (Messages$ReportCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$ReportCommand parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ReportCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$ReportCommand parseFrom(InputStream inputStream) {
        return (Messages$ReportCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$ReportCommand parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ReportCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$ReportCommand parseFrom(ByteBuffer byteBuffer) {
        return (Messages$ReportCommand)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$ReportCommand parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ReportCommand)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$ReportCommand parseFrom(byte[] byArray) {
        return (Messages$ReportCommand)PARSER.parseFrom(byArray);
    }

    public static Messages$ReportCommand parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ReportCommand)PARSER.parseFrom(byArray, extensionRegistryLite);
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
        boolean bl5 = object instanceof Messages$ReportCommand;
        if (!bl5) {
            return super.equals(object);
        }
        object = (Messages$ReportCommand)object;
        bl5 = this.hasInitiative();
        if (bl5 == (bl3 = ((Messages$ReportCommand)object).hasInitiative())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object2 = null;
        }
        bl3 = this.hasInitiative();
        if (bl3) {
            if (bl5 && (bl5 = this.getInitiative()) == (bl3 = ((Messages$ReportCommand)object).getInitiative())) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object2 = null;
            }
        }
        if (bl5 && (bl5 = this.hasType()) == (bl3 = ((Messages$ReportCommand)object).hasType())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object2 = null;
        }
        bl3 = this.hasType();
        if (bl3) {
            if (bl5 && (bl5 = ((String)(object2 = this.getType())).equals(string2 = ((Messages$ReportCommand)object).getType()))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object2 = null;
            }
        }
        if (bl5 && (bl5 = this.hasData()) == (bl3 = ((Messages$ReportCommand)object).hasData())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object2 = null;
        }
        bl3 = this.hasData();
        if (bl3) {
            if (bl5 && (bl5 = ((String)(object2 = this.getData())).equals(string2 = ((Messages$ReportCommand)object).getData()))) {
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

    public String getData() {
        Object object = this.data_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.data_ = string2;
        }
        return string2;
    }

    public ByteString getDataBytes() {
        Object object = this.data_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.data_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Messages$ReportCommand getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public boolean getInitiative() {
        return this.initiative_;
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
            n11 = (int)(this.initiative_ ? 1 : 0);
            n11 = CodedOutputStream.computeBoolSize(n12, n11 != 0);
            n10 = 0 + n11;
        }
        n11 = this.bitField0_;
        n12 = 2;
        if ((n11 &= n12) == n12) {
            Object object = this.type_;
            n11 = GeneratedMessageV3.computeStringSize(n12, object);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 4;
        if ((n11 &= n12) == n12) {
            Object object = this.data_;
            n11 = GeneratedMessageV3.computeStringSize(3, object);
            n10 += n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public String getType() {
        Object object = this.type_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.type_ = string2;
        }
        return string2;
    }

    public ByteString getTypeBytes() {
        Object object = this.type_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.type_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasData() {
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

    public boolean hasInitiative() {
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
    public boolean hasType() {
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
        Object object = Messages$ReportCommand.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasInitiative() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            n11 = Internal.hashBoolean(this.getInitiative());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasType() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getType();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasData() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            object = this.getData();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$39000().ensureFieldAccessorsInitialized(Messages$ReportCommand.class, Messages$ReportCommand$Builder.class);
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

    public Messages$ReportCommand$Builder newBuilderForType() {
        return Messages$ReportCommand.newBuilder();
    }

    public Messages$ReportCommand$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$ReportCommand$Builder messages$ReportCommand$Builder = new Messages$ReportCommand$Builder(generatedMessageV3$BuilderParent, null);
        return messages$ReportCommand$Builder;
    }

    public Messages$ReportCommand$Builder toBuilder() {
        Messages$ReportCommandOrBuilder messages$ReportCommandOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$ReportCommandOrBuilder) {
            messages$ReportCommandOrBuilder = new Messages$ReportCommand$Builder(null);
        } else {
            messages$ReportCommandOrBuilder = new Messages$ReportCommand$Builder(null);
            messages$ReportCommandOrBuilder = ((Messages$ReportCommand$Builder)messages$ReportCommandOrBuilder).mergeFrom(this);
        }
        return messages$ReportCommandOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == n11) {
            n10 = (int)(this.initiative_ ? 1 : 0);
            codedOutputStream.writeBool(n11, n10 != 0);
        }
        n10 = this.bitField0_;
        n11 = 2;
        if ((n10 &= n11) == n11) {
            Object object = this.type_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        n10 = this.bitField0_;
        n11 = 4;
        if ((n10 &= n11) == n11) {
            n10 = 3;
            Object object = this.data_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

