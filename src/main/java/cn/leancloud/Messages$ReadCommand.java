/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$ReadCommand$1;
import cn.leancloud.Messages$ReadCommand$Builder;
import cn.leancloud.Messages$ReadCommandOrBuilder;
import cn.leancloud.Messages$ReadTuple;
import cn.leancloud.Messages$ReadTupleOrBuilder;
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

public final class Messages$ReadCommand
extends GeneratedMessageV3
implements Messages$ReadCommandOrBuilder {
    public static final int CIDS_FIELD_NUMBER = 2;
    public static final int CID_FIELD_NUMBER = 1;
    public static final int CONVS_FIELD_NUMBER = 3;
    private static final Messages$ReadCommand DEFAULT_INSTANCE;
    public static final Parser PARSER;
    private static final long serialVersionUID;
    private int bitField0_;
    private volatile Object cid_;
    private LazyStringList cids_;
    private List convs_;
    private byte memoizedIsInitialized;

    static {
        Object object = new Messages$ReadCommand();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$ReadCommand$1();
    }

    private Messages$ReadCommand() {
        List list;
        this.memoizedIsInitialized = (byte)-1;
        this.cid_ = "";
        this.cids_ = list = LazyStringArrayList.EMPTY;
        list = Collections.emptyList();
        this.convs_ = list;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Messages$ReadCommand(CodedInputStream list, ExtensionRegistryLite list2) {
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
                n11 = 4;
                n10 = 2;
                if (n13 != 0) break block17;
                try {
                    try {
                        int n14;
                        block18: {
                            int n15 = ((CodedInputStream)((Object)list)).readTag();
                            n14 = 1;
                            if (n15 != 0) {
                                Iterable iterable;
                                int n16 = 10;
                                if (n15 != n16) {
                                    Object object;
                                    n16 = 18;
                                    if (n15 != n16) {
                                        n16 = 26;
                                        if (n15 != n16) {
                                            n11 = (int)(this.parseUnknownField((CodedInputStream)((Object)list), unknownFieldSet$Builder, (ExtensionRegistryLite)((Object)list2), n15) ? 1 : 0);
                                            if (n11 != 0) continue;
                                            break block18;
                                        } else {
                                            n15 = n12 & 4;
                                            if (n15 != n11) {
                                                this.convs_ = iterable;
                                                n12 |= 4;
                                            }
                                            iterable = this.convs_;
                                            object = Messages$ReadTuple.PARSER;
                                            object = ((CodedInputStream)((Object)list)).readMessage((Parser)object, (ExtensionRegistryLite)((Object)list2));
                                            iterable.add(object);
                                            continue;
                                        }
                                    }
                                    iterable = ((CodedInputStream)((Object)list)).readBytes();
                                    n14 = n12 & 2;
                                    if (n14 != n10) {
                                        object = new LazyStringArrayList();
                                        this.cids_ = object;
                                        n12 |= 2;
                                    }
                                    object = this.cids_;
                                    object.add((ByteString)iterable);
                                    continue;
                                }
                                iterable = ((CodedInputStream)((Object)list)).readBytes();
                                n16 = this.bitField0_;
                                this.bitField0_ = n14 |= n16;
                                this.cid_ = iterable;
                                continue;
                            }
                        }
                        n13 = n14;
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
            int n17 = n12 & 2;
            if (n17 == n10) {
                list2 = this.cids_.getUnmodifiableView();
                this.cids_ = list2;
            }
            if ((n17 = n12 & 4) == n11) {
                this.convs_ = list2 = Collections.unmodifiableList(this.convs_);
            }
            list2 = unknownFieldSet$Builder.build();
            this.unknownFields = list2;
            this.makeExtensionsImmutable();
            throw throwable2;
        }
        int n18 = n12 & 2;
        if (n18 == n10) {
            list = this.cids_.getUnmodifiableView();
            this.cids_ = list;
        }
        if ((n18 = n12 & 4) == n11) {
            this.convs_ = list = Collections.unmodifiableList(this.convs_);
        }
        list = unknownFieldSet$Builder.build();
        this.unknownFields = list;
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ Messages$ReadCommand(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$ReadCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ Messages$ReadCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$36800() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ Object access$37000(Messages$ReadCommand messages$ReadCommand) {
        return messages$ReadCommand.cid_;
    }

    public static /* synthetic */ Object access$37002(Messages$ReadCommand messages$ReadCommand, Object object) {
        messages$ReadCommand.cid_ = object;
        return object;
    }

    public static /* synthetic */ LazyStringList access$37100(Messages$ReadCommand messages$ReadCommand) {
        return messages$ReadCommand.cids_;
    }

    public static /* synthetic */ LazyStringList access$37102(Messages$ReadCommand messages$ReadCommand, LazyStringList lazyStringList) {
        messages$ReadCommand.cids_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ List access$37200(Messages$ReadCommand messages$ReadCommand) {
        return messages$ReadCommand.convs_;
    }

    public static /* synthetic */ List access$37202(Messages$ReadCommand messages$ReadCommand, List list) {
        messages$ReadCommand.convs_ = list;
        return list;
    }

    public static /* synthetic */ int access$37302(Messages$ReadCommand messages$ReadCommand, int n10) {
        messages$ReadCommand.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ boolean access$37400() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ UnknownFieldSet access$37500(Messages$ReadCommand messages$ReadCommand) {
        return messages$ReadCommand.unknownFields;
    }

    public static Messages$ReadCommand getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$36400();
    }

    public static Messages$ReadCommand$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$ReadCommand$Builder newBuilder(Messages$ReadCommand messages$ReadCommand) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$ReadCommand);
    }

    public static Messages$ReadCommand parseDelimitedFrom(InputStream inputStream) {
        return (Messages$ReadCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$ReadCommand parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ReadCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$ReadCommand parseFrom(ByteString byteString) {
        return (Messages$ReadCommand)PARSER.parseFrom(byteString);
    }

    public static Messages$ReadCommand parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ReadCommand)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$ReadCommand parseFrom(CodedInputStream codedInputStream) {
        return (Messages$ReadCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$ReadCommand parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ReadCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$ReadCommand parseFrom(InputStream inputStream) {
        return (Messages$ReadCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$ReadCommand parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ReadCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$ReadCommand parseFrom(ByteBuffer byteBuffer) {
        return (Messages$ReadCommand)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$ReadCommand parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ReadCommand)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$ReadCommand parseFrom(byte[] byArray) {
        return (Messages$ReadCommand)PARSER.parseFrom(byArray);
    }

    public static Messages$ReadCommand parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ReadCommand)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2;
        Object object2;
        Object object3;
        boolean bl3;
        boolean bl4 = true;
        if (object == this) {
            return bl4;
        }
        boolean bl5 = object instanceof Messages$ReadCommand;
        if (!bl5) {
            return super.equals(object);
        }
        object = (Messages$ReadCommand)object;
        bl5 = this.hasCid();
        if (bl5 == (bl3 = ((Messages$ReadCommand)object).hasCid())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        bl3 = this.hasCid();
        if (bl3) {
            if (bl5 && (bl5 = ((String)(object3 = this.getCid())).equals(object2 = ((Messages$ReadCommand)object).getCid()))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object3 = null;
            }
        }
        if (bl5 && (bl5 = (object3 = this.getCidsList()).equals(object2 = ((Messages$ReadCommand)object).getCidsList()))) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        if (bl5 && (bl5 = (object3 = this.getConvsList()).equals(object2 = ((Messages$ReadCommand)object).getConvsList()))) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        if (!bl5 || !(bl2 = ((UnknownFieldSet)(object3 = this.unknownFields)).equals(object = ((GeneratedMessageV3)object).unknownFields))) {
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

    public String getCids(int n10) {
        return (String)this.cids_.get(n10);
    }

    public ByteString getCidsBytes(int n10) {
        return this.cids_.getByteString(n10);
    }

    public int getCidsCount() {
        return this.cids_.size();
    }

    public ProtocolStringList getCidsList() {
        return this.cids_;
    }

    public Messages$ReadTuple getConvs(int n10) {
        return (Messages$ReadTuple)this.convs_.get(n10);
    }

    public int getConvsCount() {
        return this.convs_.size();
    }

    public List getConvsList() {
        return this.convs_;
    }

    public Messages$ReadTupleOrBuilder getConvsOrBuilder(int n10) {
        return (Messages$ReadTupleOrBuilder)this.convs_.get(n10);
    }

    public List getConvsOrBuilderList() {
        return this.convs_;
    }

    public Messages$ReadCommand getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        List list;
        Object object;
        int n10;
        int n11;
        Object object2;
        int n12 = this.memoizedSize;
        int n13 = -1;
        if (n12 != n13) {
            return n12;
        }
        n12 = this.bitField0_;
        n13 = 1;
        int n14 = 0;
        if ((n12 &= n13) == n13) {
            object2 = this.cid_;
            n12 = GeneratedMessageV3.computeStringSize(n13, object2) + 0;
        } else {
            n12 = 0;
            object2 = null;
        }
        Object object3 = null;
        int n15 = 0;
        for (n11 = 0; n11 < (n10 = (object = this.cids_).size()); ++n11) {
            object = this.cids_.getRaw(n11);
            n10 = GeneratedMessageV3.computeStringSizeNoTag(object);
            n15 += n10;
        }
        n12 += n15;
        object3 = this.getCidsList();
        n11 = object3.size() * n13;
        n12 += n11;
        while (n14 < (n13 = (list = this.convs_).size())) {
            object3 = (MessageLite)this.convs_.get(n14);
            n13 = CodedOutputStream.computeMessageSize(3, (MessageLite)object3);
            n12 += n13;
            ++n14;
        }
        n13 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n12 += n13;
        return n12;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public boolean hasCid() {
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
        Object object = Messages$ReadCommand.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasCid() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getCid();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = this.getCidsCount()) > 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getCidsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = this.getConvsCount()) > 0) {
            n10 = (n10 * 37 + 3) * 53;
            object = this.getConvsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$36500().ensureFieldAccessorsInitialized(Messages$ReadCommand.class, Messages$ReadCommand$Builder.class);
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
            Messages$ReadTuple messages$ReadTuple = this.getConvs(n11);
            n10 = messages$ReadTuple.isInitialized();
            if (n10 != 0) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = (byte)n12;
        return n12 != 0;
    }

    public Messages$ReadCommand$Builder newBuilderForType() {
        return Messages$ReadCommand.newBuilder();
    }

    public Messages$ReadCommand$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$ReadCommand$Builder messages$ReadCommand$Builder = new Messages$ReadCommand$Builder(generatedMessageV3$BuilderParent, null);
        return messages$ReadCommand$Builder;
    }

    public Messages$ReadCommand$Builder toBuilder() {
        Messages$ReadCommandOrBuilder messages$ReadCommandOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$ReadCommandOrBuilder) {
            messages$ReadCommandOrBuilder = new Messages$ReadCommand$Builder(null);
        } else {
            messages$ReadCommandOrBuilder = new Messages$ReadCommand$Builder(null);
            messages$ReadCommandOrBuilder = ((Messages$ReadCommand$Builder)messages$ReadCommandOrBuilder).mergeFrom(this);
        }
        return messages$ReadCommandOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Object object;
        int n10;
        Object object2;
        int n11 = this.bitField0_;
        int n12 = 1;
        if ((n11 &= n12) == n12) {
            object2 = this.cid_;
            GeneratedMessageV3.writeString(codedOutputStream, n12, object2);
        }
        n11 = 0;
        object2 = null;
        List list = null;
        for (n12 = 0; n12 < (n10 = (object = this.cids_).size()); ++n12) {
            n10 = 2;
            Object object3 = this.cids_.getRaw(n12);
            GeneratedMessageV3.writeString(codedOutputStream, n10, object3);
        }
        while (n11 < (n12 = (list = this.convs_).size())) {
            n12 = 3;
            object = (MessageLite)this.convs_.get(n11);
            codedOutputStream.writeMessage(n12, (MessageLite)object);
            ++n11;
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

