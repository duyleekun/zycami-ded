/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$JsonObjectMessage;
import cn.leancloud.Messages$JsonObjectMessage$Builder;
import cn.leancloud.Messages$JsonObjectMessageOrBuilder;
import cn.leancloud.Messages$PubsubCommand$1;
import cn.leancloud.Messages$PubsubCommand$Builder;
import cn.leancloud.Messages$PubsubCommandOrBuilder;
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

public final class Messages$PubsubCommand
extends GeneratedMessageV3
implements Messages$PubsubCommandOrBuilder {
    public static final int CIDS_FIELD_NUMBER = 2;
    public static final int CID_FIELD_NUMBER = 1;
    private static final Messages$PubsubCommand DEFAULT_INSTANCE;
    public static final Parser PARSER;
    public static final int RESULTS_FIELD_NUMBER = 7;
    public static final int SUBTOPICS_FIELD_NUMBER = 6;
    public static final int SUBTOPIC_FIELD_NUMBER = 4;
    public static final int TOPICS_FIELD_NUMBER = 5;
    public static final int TOPIC_FIELD_NUMBER = 3;
    private static final long serialVersionUID;
    private int bitField0_;
    private volatile Object cid_;
    private LazyStringList cids_;
    private byte memoizedIsInitialized;
    private Messages$JsonObjectMessage results_;
    private volatile Object subtopic_;
    private LazyStringList subtopics_;
    private volatile Object topic_;
    private LazyStringList topics_;

    static {
        Object object = new Messages$PubsubCommand();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$PubsubCommand$1();
    }

    private Messages$PubsubCommand() {
        LazyStringList lazyStringList;
        this.memoizedIsInitialized = (byte)-1;
        String string2 = "";
        this.cid_ = string2;
        this.cids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.topic_ = string2;
        this.subtopic_ = string2;
        this.topics_ = lazyStringList;
        this.subtopics_ = lazyStringList;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Messages$PubsubCommand(CodedInputStream object, ExtensionRegistryLite object2) {
        int n10;
        int n11;
        int n12;
        int n13;
        UnknownFieldSet$Builder unknownFieldSet$Builder;
        block26: {
            Throwable throwable2;
            this();
            unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
            int n14 = 0;
            n13 = 0;
            while (true) {
                n12 = 32;
                n11 = 16;
                n10 = 2;
                if (n14 != 0) break block26;
                try {
                    try {
                        int n15;
                        block27: {
                            int n16 = ((CodedInputStream)object).readTag();
                            n15 = 1;
                            if (n16 != 0) {
                                Object object3;
                                int n17 = 10;
                                if (n16 != n17) {
                                    Object object4;
                                    n17 = 18;
                                    if (n16 != n17) {
                                        n17 = 26;
                                        if (n16 != n17) {
                                            n17 = 34;
                                            if (n16 != n17) {
                                                n17 = 42;
                                                if (n16 != n17) {
                                                    n17 = 50;
                                                    if (n16 != n17) {
                                                        n17 = 58;
                                                        if (n16 != n17) {
                                                            n12 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n16) ? 1 : 0);
                                                            if (n12 != 0) continue;
                                                            break block27;
                                                        } else {
                                                            n16 = 0;
                                                            object3 = null;
                                                            n15 = this.bitField0_;
                                                            n17 = 8;
                                                            if ((n15 &= n17) == n17) {
                                                                object3 = this.results_;
                                                                object3 = ((Messages$JsonObjectMessage)object3).toBuilder();
                                                            }
                                                            object4 = Messages$JsonObjectMessage.PARSER;
                                                            object4 = ((CodedInputStream)object).readMessage((Parser)object4, (ExtensionRegistryLite)object2);
                                                            this.results_ = object4 = (Messages$JsonObjectMessage)object4;
                                                            if (object3 != null) {
                                                                ((Messages$JsonObjectMessage$Builder)object3).mergeFrom((Messages$JsonObjectMessage)object4);
                                                                this.results_ = object3 = ((Messages$JsonObjectMessage$Builder)object3).buildPartial();
                                                            }
                                                            this.bitField0_ = n16 = this.bitField0_ | n17;
                                                            continue;
                                                        }
                                                    }
                                                    object3 = ((CodedInputStream)object).readBytes();
                                                    n15 = n13 & 0x20;
                                                    if (n15 != n12) {
                                                        this.subtopics_ = object4;
                                                        n13 |= 0x20;
                                                    }
                                                    object4 = this.subtopics_;
                                                    object4.add((ByteString)object3);
                                                    continue;
                                                }
                                                object3 = ((CodedInputStream)object).readBytes();
                                                n15 = n13 & 0x10;
                                                if (n15 != n11) {
                                                    this.topics_ = object4;
                                                    n13 |= 0x10;
                                                }
                                                object4 = this.topics_;
                                                object4.add((ByteString)object3);
                                                continue;
                                            }
                                            object3 = ((CodedInputStream)object).readBytes();
                                            this.bitField0_ = n15 = this.bitField0_ | 4;
                                            this.subtopic_ = object3;
                                            continue;
                                        }
                                        object3 = ((CodedInputStream)object).readBytes();
                                        this.bitField0_ = n15 = this.bitField0_ | n10;
                                        this.topic_ = object3;
                                        continue;
                                    }
                                    object3 = ((CodedInputStream)object).readBytes();
                                    n15 = n13 & 2;
                                    if (n15 != n10) {
                                        object4 = new LazyStringArrayList();
                                        this.cids_ = object4;
                                        n13 |= 2;
                                    }
                                    object4 = this.cids_;
                                    object4.add((ByteString)object3);
                                    continue;
                                }
                                object3 = ((CodedInputStream)object).readBytes();
                                n17 = this.bitField0_;
                                this.bitField0_ = n15 |= n17;
                                this.cid_ = object3;
                                continue;
                            }
                        }
                        n14 = n15;
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
            int n18 = n13 & 2;
            if (n18 == n10) {
                this.cids_ = object2 = this.cids_.getUnmodifiableView();
            }
            if ((n18 = n13 & 0x10) == n11) {
                this.topics_ = object2 = this.topics_.getUnmodifiableView();
            }
            if ((n18 = n13 & 0x20) == n12) {
                this.subtopics_ = object2 = this.subtopics_.getUnmodifiableView();
            }
            this.unknownFields = object2 = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            throw throwable2;
        }
        int n19 = n13 & 2;
        if (n19 == n10) {
            this.cids_ = object = this.cids_.getUnmodifiableView();
        }
        if ((n19 = n13 & 0x10) == n11) {
            this.topics_ = object = this.topics_.getUnmodifiableView();
        }
        if ((n19 = n13 & 0x20) == n12) {
            this.subtopics_ = object = this.subtopics_.getUnmodifiableView();
        }
        this.unknownFields = object = unknownFieldSet$Builder.build();
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ Messages$PubsubCommand(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$PubsubCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ Messages$PubsubCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$43800() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ Object access$44000(Messages$PubsubCommand messages$PubsubCommand) {
        return messages$PubsubCommand.cid_;
    }

    public static /* synthetic */ Object access$44002(Messages$PubsubCommand messages$PubsubCommand, Object object) {
        messages$PubsubCommand.cid_ = object;
        return object;
    }

    public static /* synthetic */ LazyStringList access$44100(Messages$PubsubCommand messages$PubsubCommand) {
        return messages$PubsubCommand.cids_;
    }

    public static /* synthetic */ LazyStringList access$44102(Messages$PubsubCommand messages$PubsubCommand, LazyStringList lazyStringList) {
        messages$PubsubCommand.cids_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ Object access$44200(Messages$PubsubCommand messages$PubsubCommand) {
        return messages$PubsubCommand.topic_;
    }

    public static /* synthetic */ Object access$44202(Messages$PubsubCommand messages$PubsubCommand, Object object) {
        messages$PubsubCommand.topic_ = object;
        return object;
    }

    public static /* synthetic */ Object access$44300(Messages$PubsubCommand messages$PubsubCommand) {
        return messages$PubsubCommand.subtopic_;
    }

    public static /* synthetic */ Object access$44302(Messages$PubsubCommand messages$PubsubCommand, Object object) {
        messages$PubsubCommand.subtopic_ = object;
        return object;
    }

    public static /* synthetic */ LazyStringList access$44400(Messages$PubsubCommand messages$PubsubCommand) {
        return messages$PubsubCommand.topics_;
    }

    public static /* synthetic */ LazyStringList access$44402(Messages$PubsubCommand messages$PubsubCommand, LazyStringList lazyStringList) {
        messages$PubsubCommand.topics_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ LazyStringList access$44500(Messages$PubsubCommand messages$PubsubCommand) {
        return messages$PubsubCommand.subtopics_;
    }

    public static /* synthetic */ LazyStringList access$44502(Messages$PubsubCommand messages$PubsubCommand, LazyStringList lazyStringList) {
        messages$PubsubCommand.subtopics_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ Messages$JsonObjectMessage access$44602(Messages$PubsubCommand messages$PubsubCommand, Messages$JsonObjectMessage messages$JsonObjectMessage) {
        messages$PubsubCommand.results_ = messages$JsonObjectMessage;
        return messages$JsonObjectMessage;
    }

    public static /* synthetic */ int access$44702(Messages$PubsubCommand messages$PubsubCommand, int n10) {
        messages$PubsubCommand.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ UnknownFieldSet access$44800(Messages$PubsubCommand messages$PubsubCommand) {
        return messages$PubsubCommand.unknownFields;
    }

    public static Messages$PubsubCommand getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$43400();
    }

    public static Messages$PubsubCommand$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$PubsubCommand$Builder newBuilder(Messages$PubsubCommand messages$PubsubCommand) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$PubsubCommand);
    }

    public static Messages$PubsubCommand parseDelimitedFrom(InputStream inputStream) {
        return (Messages$PubsubCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$PubsubCommand parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$PubsubCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$PubsubCommand parseFrom(ByteString byteString) {
        return (Messages$PubsubCommand)PARSER.parseFrom(byteString);
    }

    public static Messages$PubsubCommand parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$PubsubCommand)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$PubsubCommand parseFrom(CodedInputStream codedInputStream) {
        return (Messages$PubsubCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$PubsubCommand parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$PubsubCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$PubsubCommand parseFrom(InputStream inputStream) {
        return (Messages$PubsubCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$PubsubCommand parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$PubsubCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$PubsubCommand parseFrom(ByteBuffer byteBuffer) {
        return (Messages$PubsubCommand)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$PubsubCommand parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$PubsubCommand)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$PubsubCommand parseFrom(byte[] byArray) {
        return (Messages$PubsubCommand)PARSER.parseFrom(byArray);
    }

    public static Messages$PubsubCommand parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$PubsubCommand)PARSER.parseFrom(byArray, extensionRegistryLite);
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
        boolean bl5 = object instanceof Messages$PubsubCommand;
        if (!bl5) {
            return super.equals(object);
        }
        object = (Messages$PubsubCommand)object;
        bl5 = this.hasCid();
        if (bl5 == (bl3 = ((Messages$PubsubCommand)object).hasCid())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        bl3 = this.hasCid();
        if (bl3) {
            if (bl5 && (bl5 = ((String)(object3 = this.getCid())).equals(object2 = ((Messages$PubsubCommand)object).getCid()))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object3 = null;
            }
        }
        if (bl5 && (bl5 = (object3 = this.getCidsList()).equals(object2 = ((Messages$PubsubCommand)object).getCidsList()))) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        if (bl5 && (bl5 = this.hasTopic()) == (bl3 = ((Messages$PubsubCommand)object).hasTopic())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        bl3 = this.hasTopic();
        if (bl3) {
            if (bl5 && (bl5 = ((String)(object3 = this.getTopic())).equals(object2 = ((Messages$PubsubCommand)object).getTopic()))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object3 = null;
            }
        }
        if (bl5 && (bl5 = this.hasSubtopic()) == (bl3 = ((Messages$PubsubCommand)object).hasSubtopic())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        bl3 = this.hasSubtopic();
        if (bl3) {
            if (bl5 && (bl5 = ((String)(object3 = this.getSubtopic())).equals(object2 = ((Messages$PubsubCommand)object).getSubtopic()))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object3 = null;
            }
        }
        if (bl5 && (bl5 = (object3 = this.getTopicsList()).equals(object2 = ((Messages$PubsubCommand)object).getTopicsList()))) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        if (bl5 && (bl5 = (object3 = this.getSubtopicsList()).equals(object2 = ((Messages$PubsubCommand)object).getSubtopicsList()))) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        if (bl5 && (bl5 = this.hasResults()) == (bl3 = ((Messages$PubsubCommand)object).hasResults())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        bl3 = this.hasResults();
        if (bl3) {
            if (bl5 && (bl5 = ((Messages$JsonObjectMessage)(object3 = this.getResults())).equals(object2 = ((Messages$PubsubCommand)object).getResults()))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object3 = null;
            }
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

    public Messages$PubsubCommand getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public Messages$JsonObjectMessage getResults() {
        Messages$JsonObjectMessage messages$JsonObjectMessage = this.results_;
        if (messages$JsonObjectMessage == null) {
            messages$JsonObjectMessage = Messages$JsonObjectMessage.getDefaultInstance();
        }
        return messages$JsonObjectMessage;
    }

    public Messages$JsonObjectMessageOrBuilder getResultsOrBuilder() {
        Messages$JsonObjectMessage messages$JsonObjectMessage = this.results_;
        if (messages$JsonObjectMessage == null) {
            messages$JsonObjectMessage = Messages$JsonObjectMessage.getDefaultInstance();
        }
        return messages$JsonObjectMessage;
    }

    public int getSerializedSize() {
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
        Object object3 = null;
        if ((n12 &= n13) == n13) {
            object2 = this.cid_;
            n12 = GeneratedMessageV3.computeStringSize(n13, object2) + 0;
        } else {
            n12 = 0;
            object2 = null;
        }
        Object object4 = null;
        int n15 = 0;
        Object object5 = null;
        for (n11 = 0; n11 < (n10 = (object = this.cids_).size()); ++n11) {
            object = this.cids_.getRaw(n11);
            n10 = GeneratedMessageV3.computeStringSizeNoTag(object);
            n15 += n10;
        }
        n12 += n15;
        object4 = this.getCidsList();
        n11 = object4.size() * n13;
        n12 += n11;
        n11 = this.bitField0_;
        n15 = 2;
        if ((n11 &= n15) == n15) {
            object5 = this.topic_;
            n11 = GeneratedMessageV3.computeStringSize(3, object5);
            n12 += n11;
        }
        n11 = this.bitField0_;
        n15 = 4;
        if ((n11 &= n15) == n15) {
            object4 = this.subtopic_;
            n11 = GeneratedMessageV3.computeStringSize(n15, object4);
            n12 += n11;
        }
        object4 = null;
        n15 = 0;
        object5 = null;
        for (n11 = 0; n11 < (n10 = (object = this.topics_).size()); ++n11) {
            object = this.topics_.getRaw(n11);
            n10 = GeneratedMessageV3.computeStringSizeNoTag(object);
            n15 += n10;
        }
        n12 += n15;
        n11 = this.getTopicsList().size() * n13;
        n12 += n11;
        n11 = 0;
        object4 = null;
        while (n14 < (n15 = (object5 = this.subtopics_).size())) {
            object5 = this.subtopics_.getRaw(n14);
            n15 = GeneratedMessageV3.computeStringSizeNoTag(object5);
            n11 += n15;
            ++n14;
        }
        n12 += n11;
        object3 = this.getSubtopicsList();
        n14 = object3.size() * n13;
        n12 += n14;
        n13 = this.bitField0_;
        n14 = 8;
        if ((n13 &= n14) == n14) {
            object3 = this.getResults();
            n13 = CodedOutputStream.computeMessageSize(7, (MessageLite)object3);
            n12 += n13;
        }
        n13 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n12 += n13;
        return n12;
    }

    public String getSubtopic() {
        Object object = this.subtopic_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.subtopic_ = string2;
        }
        return string2;
    }

    public ByteString getSubtopicBytes() {
        Object object = this.subtopic_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.subtopic_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getSubtopics(int n10) {
        return (String)this.subtopics_.get(n10);
    }

    public ByteString getSubtopicsBytes(int n10) {
        return this.subtopics_.getByteString(n10);
    }

    public int getSubtopicsCount() {
        return this.subtopics_.size();
    }

    public ProtocolStringList getSubtopicsList() {
        return this.subtopics_;
    }

    public String getTopic() {
        Object object = this.topic_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.topic_ = string2;
        }
        return string2;
    }

    public ByteString getTopicBytes() {
        Object object = this.topic_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.topic_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getTopics(int n10) {
        return (String)this.topics_.get(n10);
    }

    public ByteString getTopicsBytes(int n10) {
        return this.topics_.getByteString(n10);
    }

    public int getTopicsCount() {
        return this.topics_.size();
    }

    public ProtocolStringList getTopicsList() {
        return this.topics_;
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

    /*
     * WARNING - void declaration
     */
    public boolean hasResults() {
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
    public boolean hasSubtopic() {
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

    /*
     * WARNING - void declaration
     */
    public boolean hasTopic() {
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
        Object object = Messages$PubsubCommand.getDescriptor();
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
        if ((n11 = (int)(this.hasTopic() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            object = this.getTopic();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasSubtopic() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 4) * 53;
            object = this.getSubtopic();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = this.getTopicsCount()) > 0) {
            n10 = (n10 * 37 + 5) * 53;
            object = this.getTopicsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = this.getSubtopicsCount()) > 0) {
            n10 = (n10 * 37 + 6) * 53;
            object = this.getSubtopicsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasResults() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 7) * 53;
            object = this.getResults();
            n11 = ((Messages$JsonObjectMessage)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$43500().ensureFieldAccessorsInitialized(Messages$PubsubCommand.class, Messages$PubsubCommand$Builder.class);
    }

    public final boolean isInitialized() {
        Messages$JsonObjectMessage messages$JsonObjectMessage;
        byte by2 = this.memoizedIsInitialized;
        byte by3 = 1;
        if (by2 == by3) {
            return by3 != 0;
        }
        if (!by2) {
            return false;
        }
        by2 = this.hasResults();
        if (by2 && !(by2 = (messages$JsonObjectMessage = this.getResults()).isInitialized())) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = by3;
        return by3 != 0;
    }

    public Messages$PubsubCommand$Builder newBuilderForType() {
        return Messages$PubsubCommand.newBuilder();
    }

    public Messages$PubsubCommand$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$PubsubCommand$Builder messages$PubsubCommand$Builder = new Messages$PubsubCommand$Builder(generatedMessageV3$BuilderParent, null);
        return messages$PubsubCommand$Builder;
    }

    public Messages$PubsubCommand$Builder toBuilder() {
        Messages$PubsubCommandOrBuilder messages$PubsubCommandOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$PubsubCommandOrBuilder) {
            messages$PubsubCommandOrBuilder = new Messages$PubsubCommand$Builder(null);
        } else {
            messages$PubsubCommandOrBuilder = new Messages$PubsubCommand$Builder(null);
            messages$PubsubCommandOrBuilder = ((Messages$PubsubCommand$Builder)messages$PubsubCommandOrBuilder).mergeFrom(this);
        }
        return messages$PubsubCommandOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        int n10;
        int n11;
        Object object;
        Object object2;
        int n12 = this.bitField0_;
        int n13 = 1;
        if ((n12 &= n13) == n13) {
            object2 = this.cid_;
            GeneratedMessageV3.writeString(codedOutputStream, n13, object2);
        }
        n12 = 0;
        object2 = null;
        n13 = 0;
        Object object3 = null;
        while (true) {
            object = this.cids_;
            n11 = object.size();
            n10 = 2;
            if (n13 >= n11) break;
            object = this.cids_.getRaw(n13);
            GeneratedMessageV3.writeString(codedOutputStream, n10, object);
            ++n13;
        }
        n13 = this.bitField0_ & n10;
        if (n13 == n10) {
            n13 = 3;
            object = this.topic_;
            GeneratedMessageV3.writeString(codedOutputStream, n13, object);
        }
        n13 = this.bitField0_;
        n11 = 4;
        if ((n13 &= n11) == n11) {
            object3 = this.subtopic_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object3);
        }
        object3 = null;
        for (n13 = 0; n13 < (n11 = (object = this.topics_).size()); ++n13) {
            n11 = 5;
            Object object4 = this.topics_.getRaw(n13);
            GeneratedMessageV3.writeString(codedOutputStream, n11, object4);
        }
        while (n12 < (n13 = (object3 = this.subtopics_).size())) {
            n13 = 6;
            object = this.subtopics_.getRaw(n12);
            GeneratedMessageV3.writeString(codedOutputStream, n13, object);
            ++n12;
        }
        n12 = this.bitField0_;
        n13 = 8;
        if ((n12 &= n13) == n13) {
            n12 = 7;
            object3 = this.getResults();
            codedOutputStream.writeMessage(n12, (MessageLite)object3);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

