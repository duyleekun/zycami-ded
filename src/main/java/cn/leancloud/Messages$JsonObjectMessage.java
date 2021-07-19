/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$JsonObjectMessage$1;
import cn.leancloud.Messages$JsonObjectMessage$Builder;
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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Messages$JsonObjectMessage
extends GeneratedMessageV3
implements Messages$JsonObjectMessageOrBuilder {
    public static final int DATA_FIELD_NUMBER = 1;
    private static final Messages$JsonObjectMessage DEFAULT_INSTANCE;
    public static final Parser PARSER;
    private static final long serialVersionUID;
    private int bitField0_;
    private volatile Object data_;
    private byte memoizedIsInitialized = (byte)-1;

    static {
        Object object = new Messages$JsonObjectMessage();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$JsonObjectMessage$1();
    }

    private Messages$JsonObjectMessage() {
        this.data_ = "";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Messages$JsonObjectMessage(CodedInputStream object, ExtensionRegistryLite object2) {
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
                            ByteString byteString = ((CodedInputStream)object).readBytes();
                            n13 = this.bitField0_;
                            this.bitField0_ = n12 |= n13;
                            this.data_ = byteString;
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

    public /* synthetic */ Messages$JsonObjectMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$JsonObjectMessage(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
    }

    public /* synthetic */ Messages$JsonObjectMessage(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$4200() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ Object access$4400(Messages$JsonObjectMessage messages$JsonObjectMessage) {
        return messages$JsonObjectMessage.data_;
    }

    public static /* synthetic */ Object access$4402(Messages$JsonObjectMessage messages$JsonObjectMessage, Object object) {
        messages$JsonObjectMessage.data_ = object;
        return object;
    }

    public static /* synthetic */ int access$4502(Messages$JsonObjectMessage messages$JsonObjectMessage, int n10) {
        messages$JsonObjectMessage.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ UnknownFieldSet access$4600(Messages$JsonObjectMessage messages$JsonObjectMessage) {
        return messages$JsonObjectMessage.unknownFields;
    }

    public static Messages$JsonObjectMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$3800();
    }

    public static Messages$JsonObjectMessage$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$JsonObjectMessage$Builder newBuilder(Messages$JsonObjectMessage messages$JsonObjectMessage) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$JsonObjectMessage);
    }

    public static Messages$JsonObjectMessage parseDelimitedFrom(InputStream inputStream) {
        return (Messages$JsonObjectMessage)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$JsonObjectMessage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$JsonObjectMessage)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$JsonObjectMessage parseFrom(ByteString byteString) {
        return (Messages$JsonObjectMessage)PARSER.parseFrom(byteString);
    }

    public static Messages$JsonObjectMessage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$JsonObjectMessage)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$JsonObjectMessage parseFrom(CodedInputStream codedInputStream) {
        return (Messages$JsonObjectMessage)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$JsonObjectMessage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$JsonObjectMessage)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$JsonObjectMessage parseFrom(InputStream inputStream) {
        return (Messages$JsonObjectMessage)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$JsonObjectMessage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$JsonObjectMessage)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$JsonObjectMessage parseFrom(ByteBuffer byteBuffer) {
        return (Messages$JsonObjectMessage)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$JsonObjectMessage parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$JsonObjectMessage)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$JsonObjectMessage parseFrom(byte[] byArray) {
        return (Messages$JsonObjectMessage)PARSER.parseFrom(byArray);
    }

    public static Messages$JsonObjectMessage parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$JsonObjectMessage)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2;
        Object object2;
        boolean bl3;
        boolean bl4 = true;
        if (object == this) {
            return bl4;
        }
        boolean bl5 = object instanceof Messages$JsonObjectMessage;
        if (!bl5) {
            return super.equals(object);
        }
        object = (Messages$JsonObjectMessage)object;
        bl5 = this.hasData();
        if (bl5 == (bl3 = ((Messages$JsonObjectMessage)object).hasData())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object2 = null;
        }
        bl3 = this.hasData();
        if (bl3) {
            String string2;
            if (bl5 && (bl5 = ((String)(object2 = this.getData())).equals(string2 = ((Messages$JsonObjectMessage)object).getData()))) {
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

    public Messages$JsonObjectMessage getDefaultInstanceForType() {
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
            Object object = this.data_;
            n11 = GeneratedMessageV3.computeStringSize(n12, object);
            n10 = 0 + n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasData() {
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
        Object object = Messages$JsonObjectMessage.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasData() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
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
        return Messages.access$3900().ensureFieldAccessorsInitialized(Messages$JsonObjectMessage.class, Messages$JsonObjectMessage$Builder.class);
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
        by2 = this.hasData();
        if (!by2) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = by3;
        return by3 != 0;
    }

    public Messages$JsonObjectMessage$Builder newBuilderForType() {
        return Messages$JsonObjectMessage.newBuilder();
    }

    public Messages$JsonObjectMessage$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$JsonObjectMessage$Builder messages$JsonObjectMessage$Builder = new Messages$JsonObjectMessage$Builder(generatedMessageV3$BuilderParent, null);
        return messages$JsonObjectMessage$Builder;
    }

    public Messages$JsonObjectMessage$Builder toBuilder() {
        Messages$JsonObjectMessageOrBuilder messages$JsonObjectMessageOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$JsonObjectMessageOrBuilder) {
            messages$JsonObjectMessageOrBuilder = new Messages$JsonObjectMessage$Builder(null);
        } else {
            messages$JsonObjectMessageOrBuilder = new Messages$JsonObjectMessage$Builder(null);
            messages$JsonObjectMessageOrBuilder = ((Messages$JsonObjectMessage$Builder)messages$JsonObjectMessageOrBuilder).mergeFrom(this);
        }
        return messages$JsonObjectMessageOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == n11) {
            Object object = this.data_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

