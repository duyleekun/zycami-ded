/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$JsonObjectMessage;
import cn.leancloud.Messages$JsonObjectMessage$Builder;
import cn.leancloud.Messages$JsonObjectMessageOrBuilder;
import cn.leancloud.Messages$PubsubCommand;
import cn.leancloud.Messages$PubsubCommandOrBuilder;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.Objects;

public final class Messages$PubsubCommand$Builder
extends GeneratedMessageV3$Builder
implements Messages$PubsubCommandOrBuilder {
    private int bitField0_;
    private Object cid_;
    private LazyStringList cids_;
    private SingleFieldBuilderV3 resultsBuilder_;
    private Messages$JsonObjectMessage results_;
    private Object subtopic_;
    private LazyStringList subtopics_;
    private Object topic_;
    private LazyStringList topics_;

    private Messages$PubsubCommand$Builder() {
        LazyStringList lazyStringList;
        String string2 = "";
        this.cid_ = string2;
        this.cids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.topic_ = string2;
        this.subtopic_ = string2;
        this.topics_ = lazyStringList;
        this.subtopics_ = lazyStringList;
        this.results_ = null;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$PubsubCommand$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$PubsubCommand$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        LazyStringList lazyStringList;
        this.cid_ = object = "";
        this.cids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.topic_ = object;
        this.subtopic_ = object;
        this.topics_ = lazyStringList;
        this.subtopics_ = lazyStringList;
        this.results_ = null;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$PubsubCommand$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureCidsIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 2;
        if ((n10 &= n11) != n11) {
            LazyStringList lazyStringList = this.cids_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.cids_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    private void ensureSubtopicsIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 32;
        if ((n10 &= n11) != n11) {
            LazyStringList lazyStringList = this.subtopics_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.subtopics_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    private void ensureTopicsIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 16;
        if ((n10 &= n11) != n11) {
            LazyStringList lazyStringList = this.topics_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.topics_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$43400();
    }

    private SingleFieldBuilderV3 getResultsFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.resultsBuilder_;
        if (singleFieldBuilderV3 == null) {
            Messages$JsonObjectMessage messages$JsonObjectMessage = this.getResults();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.resultsBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(messages$JsonObjectMessage, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.results_ = null;
        }
        return this.resultsBuilder_;
    }

    private void maybeForceBuilderInitialization() {
        boolean bl2 = Messages$PubsubCommand.access$43800();
        if (bl2) {
            this.getResultsFieldBuilder();
        }
    }

    public Messages$PubsubCommand$Builder addAllCids(Iterable iterable) {
        this.ensureCidsIsMutable();
        LazyStringList lazyStringList = this.cids_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public Messages$PubsubCommand$Builder addAllSubtopics(Iterable iterable) {
        this.ensureSubtopicsIsMutable();
        LazyStringList lazyStringList = this.subtopics_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public Messages$PubsubCommand$Builder addAllTopics(Iterable iterable) {
        this.ensureTopicsIsMutable();
        LazyStringList lazyStringList = this.topics_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public Messages$PubsubCommand$Builder addCids(String string2) {
        Objects.requireNonNull(string2);
        this.ensureCidsIsMutable();
        this.cids_.add(string2);
        this.onChanged();
        return this;
    }

    public Messages$PubsubCommand$Builder addCidsBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensureCidsIsMutable();
        this.cids_.add(byteString);
        this.onChanged();
        return this;
    }

    public Messages$PubsubCommand$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$PubsubCommand$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Messages$PubsubCommand$Builder addSubtopics(String string2) {
        Objects.requireNonNull(string2);
        this.ensureSubtopicsIsMutable();
        this.subtopics_.add(string2);
        this.onChanged();
        return this;
    }

    public Messages$PubsubCommand$Builder addSubtopicsBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensureSubtopicsIsMutable();
        this.subtopics_.add(byteString);
        this.onChanged();
        return this;
    }

    public Messages$PubsubCommand$Builder addTopics(String string2) {
        Objects.requireNonNull(string2);
        this.ensureTopicsIsMutable();
        this.topics_.add(string2);
        this.onChanged();
        return this;
    }

    public Messages$PubsubCommand$Builder addTopicsBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensureTopicsIsMutable();
        this.topics_.add(byteString);
        this.onChanged();
        return this;
    }

    public Messages$PubsubCommand build() {
        Messages$PubsubCommand messages$PubsubCommand = this.buildPartial();
        boolean bl2 = messages$PubsubCommand.isInitialized();
        if (bl2) {
            return messages$PubsubCommand;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$PubsubCommand);
    }

    public Messages$PubsubCommand buildPartial() {
        Object object = null;
        Messages$PubsubCommand messages$PubsubCommand = new Messages$PubsubCommand(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        int n12 = 1;
        if (n11 != n12) {
            n12 = 0;
        }
        Object object2 = this.cid_;
        Messages$PubsubCommand.access$44002(messages$PubsubCommand, object2);
        n11 = this.bitField0_;
        int n13 = 2;
        if ((n11 &= n13) == n13) {
            this.cids_ = object2 = this.cids_.getUnmodifiableView();
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFD;
        }
        object2 = this.cids_;
        Messages$PubsubCommand.access$44102(messages$PubsubCommand, (LazyStringList)object2);
        n11 = n10 & 4;
        n13 = 4;
        if (n11 == n13) {
            n12 |= 2;
        }
        object2 = this.topic_;
        Messages$PubsubCommand.access$44202(messages$PubsubCommand, object2);
        n11 = n10 & 8;
        n13 = 8;
        if (n11 == n13) {
            n12 |= 4;
        }
        object2 = this.subtopic_;
        Messages$PubsubCommand.access$44302(messages$PubsubCommand, object2);
        n11 = this.bitField0_;
        n13 = 16;
        if ((n11 &= n13) == n13) {
            this.topics_ = object2 = this.topics_.getUnmodifiableView();
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFEF;
        }
        object2 = this.topics_;
        Messages$PubsubCommand.access$44402(messages$PubsubCommand, (LazyStringList)object2);
        n11 = this.bitField0_;
        n13 = 32;
        if ((n11 &= n13) == n13) {
            this.subtopics_ = object2 = this.subtopics_.getUnmodifiableView();
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFDF;
        }
        object2 = this.subtopics_;
        Messages$PubsubCommand.access$44502(messages$PubsubCommand, (LazyStringList)object2);
        n11 = 64;
        if ((n10 &= n11) == n11) {
            n12 |= 8;
        }
        if ((object = this.resultsBuilder_) == null) {
            object = this.results_;
            Messages$PubsubCommand.access$44602(messages$PubsubCommand, (Messages$JsonObjectMessage)object);
        } else {
            object = (Messages$JsonObjectMessage)((SingleFieldBuilderV3)object).build();
            Messages$PubsubCommand.access$44602(messages$PubsubCommand, (Messages$JsonObjectMessage)object);
        }
        Messages$PubsubCommand.access$44702(messages$PubsubCommand, n12);
        this.onBuilt();
        return messages$PubsubCommand;
    }

    public Messages$PubsubCommand$Builder clear() {
        int n10;
        LazyStringList lazyStringList;
        int n11;
        Object object;
        super.clear();
        this.cid_ = object = "";
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        this.cids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n11 &= 0xFFFFFFFD;
        this.topic_ = object;
        this.bitField0_ = n11 &= 0xFFFFFFFB;
        this.subtopic_ = object;
        this.bitField0_ = n10 = n11 & 0xFFFFFFF7;
        this.topics_ = lazyStringList;
        this.bitField0_ = n10 &= 0xFFFFFFEF;
        this.subtopics_ = lazyStringList;
        this.bitField0_ = n10 &= 0xFFFFFFDF;
        object = this.resultsBuilder_;
        if (object == null) {
            n10 = 0;
            object = null;
            this.results_ = null;
        } else {
            ((SingleFieldBuilderV3)object).clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFBF;
        return this;
    }

    public Messages$PubsubCommand$Builder clearCid() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = Messages$PubsubCommand.getDefaultInstance().getCid();
        this.cid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$PubsubCommand$Builder clearCids() {
        int n10;
        LazyStringList lazyStringList;
        this.cids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.onChanged();
        return this;
    }

    public Messages$PubsubCommand$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Messages$PubsubCommand$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Messages$PubsubCommand$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Messages$PubsubCommand$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Messages$PubsubCommand$Builder clearResults() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.resultsBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.results_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFBF;
        return this;
    }

    public Messages$PubsubCommand$Builder clearSubtopic() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        String string2 = Messages$PubsubCommand.getDefaultInstance().getSubtopic();
        this.subtopic_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$PubsubCommand$Builder clearSubtopics() {
        int n10;
        LazyStringList lazyStringList;
        this.subtopics_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
        this.onChanged();
        return this;
    }

    public Messages$PubsubCommand$Builder clearTopic() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        String string2 = Messages$PubsubCommand.getDefaultInstance().getTopic();
        this.topic_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$PubsubCommand$Builder clearTopics() {
        int n10;
        LazyStringList lazyStringList;
        this.topics_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        this.onChanged();
        return this;
    }

    public Messages$PubsubCommand$Builder clone() {
        return (Messages$PubsubCommand$Builder)super.clone();
    }

    public String getCid() {
        Object object = this.cid_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.cid_ = string2;
            }
            return string2;
        }
        return (String)object;
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
        return this.cids_.getUnmodifiableView();
    }

    public Messages$PubsubCommand getDefaultInstanceForType() {
        return Messages$PubsubCommand.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$43400();
    }

    public Messages$JsonObjectMessage getResults() {
        Object object = this.resultsBuilder_;
        if (object == null) {
            object = this.results_;
            if (object == null) {
                object = Messages$JsonObjectMessage.getDefaultInstance();
            }
            return object;
        }
        return (Messages$JsonObjectMessage)((SingleFieldBuilderV3)object).getMessage();
    }

    public Messages$JsonObjectMessage$Builder getResultsBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x40;
        this.onChanged();
        return (Messages$JsonObjectMessage$Builder)this.getResultsFieldBuilder().getBuilder();
    }

    public Messages$JsonObjectMessageOrBuilder getResultsOrBuilder() {
        Object object = this.resultsBuilder_;
        if (object != null) {
            return (Messages$JsonObjectMessageOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.results_;
        if (object == null) {
            object = Messages$JsonObjectMessage.getDefaultInstance();
        }
        return object;
    }

    public String getSubtopic() {
        Object object = this.subtopic_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.subtopic_ = string2;
            }
            return string2;
        }
        return (String)object;
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
        return this.subtopics_.getUnmodifiableView();
    }

    public String getTopic() {
        Object object = this.topic_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.topic_ = string2;
            }
            return string2;
        }
        return (String)object;
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
        return this.topics_.getUnmodifiableView();
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
        int n10 = 64;
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
    public boolean hasTopic() {
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

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$43500().ensureFieldAccessorsInitialized(Messages$PubsubCommand.class, Messages$PubsubCommand$Builder.class);
    }

    public final boolean isInitialized() {
        Messages$JsonObjectMessage messages$JsonObjectMessage;
        boolean bl2 = this.hasResults();
        return !bl2 || (bl2 = (messages$JsonObjectMessage = this.getResults()).isInitialized());
    }

    public Messages$PubsubCommand$Builder mergeFrom(Messages$PubsubCommand messageLite) {
        LazyStringList lazyStringList;
        Object object = Messages$PubsubCommand.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasCid();
        if (n10 != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 1;
            this.cid_ = object = Messages$PubsubCommand.access$44000(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)((object = Messages$PubsubCommand.access$44100(messageLite)).isEmpty() ? 1 : 0)) == 0) {
            object = this.cids_;
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 != 0) {
                this.cids_ = object = Messages$PubsubCommand.access$44100(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
            } else {
                this.ensureCidsIsMutable();
                object = this.cids_;
                lazyStringList = Messages$PubsubCommand.access$44100(messageLite);
                object.addAll(lazyStringList);
            }
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasTopic() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 4;
            this.topic_ = object = Messages$PubsubCommand.access$44200(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasSubtopic() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 8;
            this.subtopic_ = object = Messages$PubsubCommand.access$44300(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)((object = Messages$PubsubCommand.access$44400(messageLite)).isEmpty() ? 1 : 0)) == 0) {
            object = this.topics_;
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 != 0) {
                this.topics_ = object = Messages$PubsubCommand.access$44400(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
            } else {
                this.ensureTopicsIsMutable();
                object = this.topics_;
                lazyStringList = Messages$PubsubCommand.access$44400(messageLite);
                object.addAll(lazyStringList);
            }
            this.onChanged();
        }
        if ((n10 = (int)((object = Messages$PubsubCommand.access$44500(messageLite)).isEmpty() ? 1 : 0)) == 0) {
            object = this.subtopics_;
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 != 0) {
                this.subtopics_ = object = Messages$PubsubCommand.access$44500(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
            } else {
                this.ensureSubtopicsIsMutable();
                object = this.subtopics_;
                lazyStringList = Messages$PubsubCommand.access$44500(messageLite);
                object.addAll(lazyStringList);
            }
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasResults() ? 1 : 0)) != 0) {
            object = messageLite.getResults();
            this.mergeResults((Messages$JsonObjectMessage)object);
        }
        messageLite = Messages$PubsubCommand.access$44800(messageLite);
        this.mergeUnknownFields((UnknownFieldSet)messageLite);
        this.onChanged();
        return this;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Messages$PubsubCommand$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$PubsubCommand.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$PubsubCommand)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$PubsubCommand)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$PubsubCommand)object2;
            }
            try {
                IOException iOException = invalidProtocolBufferException.unwrapIOException();
                throw iOException;
            }
            catch (Throwable throwable) {
                object3 = object2;
            }
        }
        if (object3 != null) {
            this.mergeFrom((Messages$PubsubCommand)object3);
        }
        throw var1_6;
    }

    public Messages$PubsubCommand$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$PubsubCommand;
        if (bl2) {
            message = (Messages$PubsubCommand)message;
            return this.mergeFrom((Messages$PubsubCommand)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Messages$PubsubCommand$Builder mergeResults(Messages$JsonObjectMessage messages$JsonObjectMessage) {
        int n10;
        Object object = this.resultsBuilder_;
        int n11 = 64;
        if (object == null) {
            Messages$JsonObjectMessage messages$JsonObjectMessage2;
            int n12 = this.bitField0_ & n11;
            if (n12 == n11 && (object = this.results_) != null && object != (messages$JsonObjectMessage2 = Messages$JsonObjectMessage.getDefaultInstance())) {
                object = Messages$JsonObjectMessage.newBuilder(this.results_);
                this.results_ = messages$JsonObjectMessage = ((Messages$JsonObjectMessage$Builder)object).mergeFrom(messages$JsonObjectMessage).buildPartial();
            } else {
                this.results_ = messages$JsonObjectMessage;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(messages$JsonObjectMessage);
        }
        this.bitField0_ = n10 = this.bitField0_ | n11;
        return this;
    }

    public final Messages$PubsubCommand$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$PubsubCommand$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$PubsubCommand$Builder setCid(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.cid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$PubsubCommand$Builder setCidBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.cid_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$PubsubCommand$Builder setCids(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureCidsIsMutable();
        this.cids_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public Messages$PubsubCommand$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$PubsubCommand$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Messages$PubsubCommand$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Messages$PubsubCommand$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public Messages$PubsubCommand$Builder setResults(Messages$JsonObjectMessage$Builder messages$JsonObjectMessageOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.resultsBuilder_;
        if (singleFieldBuilderV3 == null) {
            messages$JsonObjectMessageOrBuilder = messages$JsonObjectMessageOrBuilder.build();
            this.results_ = messages$JsonObjectMessageOrBuilder;
            this.onChanged();
        } else {
            messages$JsonObjectMessageOrBuilder = messages$JsonObjectMessageOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)messages$JsonObjectMessageOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x40;
        return this;
    }

    public Messages$PubsubCommand$Builder setResults(Messages$JsonObjectMessage messages$JsonObjectMessage) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.resultsBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(messages$JsonObjectMessage);
            this.results_ = messages$JsonObjectMessage;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(messages$JsonObjectMessage);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x40;
        return this;
    }

    public Messages$PubsubCommand$Builder setSubtopic(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.subtopic_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$PubsubCommand$Builder setSubtopicBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.subtopic_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$PubsubCommand$Builder setSubtopics(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureSubtopicsIsMutable();
        this.subtopics_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public Messages$PubsubCommand$Builder setTopic(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.topic_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$PubsubCommand$Builder setTopicBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.topic_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$PubsubCommand$Builder setTopics(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureTopicsIsMutable();
        this.topics_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public final Messages$PubsubCommand$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$PubsubCommand$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

