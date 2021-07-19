/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$PresenceCommand;
import cn.leancloud.Messages$PresenceCommandOrBuilder;
import cn.leancloud.Messages$StatusType;
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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.Objects;

public final class Messages$PresenceCommand$Builder
extends GeneratedMessageV3$Builder
implements Messages$PresenceCommandOrBuilder {
    private int bitField0_;
    private Object cid_;
    private LazyStringList sessionPeerIds_;
    private int status_ = 1;

    private Messages$PresenceCommand$Builder() {
        LazyStringList lazyStringList;
        this.sessionPeerIds_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.cid_ = "";
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$PresenceCommand$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$PresenceCommand$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.sessionPeerIds_ = object = LazyStringArrayList.EMPTY;
        this.cid_ = "";
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$PresenceCommand$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureSessionPeerIdsIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 2;
        if ((n10 &= n11) != n11) {
            LazyStringList lazyStringList = this.sessionPeerIds_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.sessionPeerIds_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$37700();
    }

    private void maybeForceBuilderInitialization() {
        Messages$PresenceCommand.access$38100();
    }

    public Messages$PresenceCommand$Builder addAllSessionPeerIds(Iterable iterable) {
        this.ensureSessionPeerIdsIsMutable();
        LazyStringList lazyStringList = this.sessionPeerIds_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public Messages$PresenceCommand$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$PresenceCommand$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Messages$PresenceCommand$Builder addSessionPeerIds(String string2) {
        Objects.requireNonNull(string2);
        this.ensureSessionPeerIdsIsMutable();
        this.sessionPeerIds_.add(string2);
        this.onChanged();
        return this;
    }

    public Messages$PresenceCommand$Builder addSessionPeerIdsBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensureSessionPeerIdsIsMutable();
        this.sessionPeerIds_.add(byteString);
        this.onChanged();
        return this;
    }

    public Messages$PresenceCommand build() {
        Messages$PresenceCommand messages$PresenceCommand = this.buildPartial();
        boolean bl2 = messages$PresenceCommand.isInitialized();
        if (bl2) {
            return messages$PresenceCommand;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$PresenceCommand);
    }

    public Messages$PresenceCommand buildPartial() {
        LazyStringList lazyStringList;
        Object object = null;
        Messages$PresenceCommand messages$PresenceCommand = new Messages$PresenceCommand(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        int n12 = 1;
        if (n11 != n12) {
            n12 = 0;
        }
        n11 = this.status_;
        Messages$PresenceCommand.access$38302(messages$PresenceCommand, n11);
        n11 = this.bitField0_;
        int n13 = 2;
        if ((n11 &= n13) == n13) {
            this.sessionPeerIds_ = lazyStringList = this.sessionPeerIds_.getUnmodifiableView();
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFD;
        }
        lazyStringList = this.sessionPeerIds_;
        Messages$PresenceCommand.access$38402(messages$PresenceCommand, lazyStringList);
        n11 = 4;
        if ((n10 &= n11) == n11) {
            n12 |= 2;
        }
        object = this.cid_;
        Messages$PresenceCommand.access$38502(messages$PresenceCommand, object);
        Messages$PresenceCommand.access$38602(messages$PresenceCommand, n12);
        this.onBuilt();
        return messages$PresenceCommand;
    }

    public Messages$PresenceCommand$Builder clear() {
        LazyStringList lazyStringList;
        int n10;
        super.clear();
        this.status_ = 1;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.sessionPeerIds_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 &= 0xFFFFFFFD;
        this.cid_ = "";
        this.bitField0_ = n10 &= 0xFFFFFFFB;
        return this;
    }

    public Messages$PresenceCommand$Builder clearCid() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        String string2 = Messages$PresenceCommand.getDefaultInstance().getCid();
        this.cid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$PresenceCommand$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Messages$PresenceCommand$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Messages$PresenceCommand$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Messages$PresenceCommand$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Messages$PresenceCommand$Builder clearSessionPeerIds() {
        int n10;
        LazyStringList lazyStringList;
        this.sessionPeerIds_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.onChanged();
        return this;
    }

    public Messages$PresenceCommand$Builder clearStatus() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.status_ = 1;
        this.onChanged();
        return this;
    }

    public Messages$PresenceCommand$Builder clone() {
        return (Messages$PresenceCommand$Builder)super.clone();
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

    public Messages$PresenceCommand getDefaultInstanceForType() {
        return Messages$PresenceCommand.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$37700();
    }

    public String getSessionPeerIds(int n10) {
        return (String)this.sessionPeerIds_.get(n10);
    }

    public ByteString getSessionPeerIdsBytes(int n10) {
        return this.sessionPeerIds_.getByteString(n10);
    }

    public int getSessionPeerIdsCount() {
        return this.sessionPeerIds_.size();
    }

    public ProtocolStringList getSessionPeerIdsList() {
        return this.sessionPeerIds_.getUnmodifiableView();
    }

    public Messages$StatusType getStatus() {
        int n10 = this.status_;
        Messages$StatusType messages$StatusType = Messages$StatusType.valueOf(n10);
        if (messages$StatusType == null) {
            messages$StatusType = Messages$StatusType.on;
        }
        return messages$StatusType;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasCid() {
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

    public boolean hasStatus() {
        int bl2 = this.bitField0_;
        int n10 = 1;
        int n11 = bl2 & n10;
        if (n11 != n10) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$37800().ensureFieldAccessorsInitialized(Messages$PresenceCommand.class, Messages$PresenceCommand$Builder.class);
    }

    public final boolean isInitialized() {
        return true;
    }

    public Messages$PresenceCommand$Builder mergeFrom(Messages$PresenceCommand messageLite) {
        Object object = Messages$PresenceCommand.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasStatus();
        if (n10 != 0) {
            object = messageLite.getStatus();
            this.setStatus((Messages$StatusType)object);
        }
        if ((n10 = (object = Messages$PresenceCommand.access$38400(messageLite)).isEmpty()) == 0) {
            object = this.sessionPeerIds_;
            n10 = object.isEmpty();
            if (n10 != 0) {
                this.sessionPeerIds_ = object = Messages$PresenceCommand.access$38400(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
            } else {
                this.ensureSessionPeerIdsIsMutable();
                object = this.sessionPeerIds_;
                LazyStringList lazyStringList = Messages$PresenceCommand.access$38400(messageLite);
                object.addAll(lazyStringList);
            }
            this.onChanged();
        }
        if ((n10 = messageLite.hasCid()) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 4;
            this.cid_ = object = Messages$PresenceCommand.access$38500(messageLite);
            this.onChanged();
        }
        messageLite = Messages$PresenceCommand.access$38700(messageLite);
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
    public Messages$PresenceCommand$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$PresenceCommand.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$PresenceCommand)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$PresenceCommand)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$PresenceCommand)object2;
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
            this.mergeFrom((Messages$PresenceCommand)object3);
        }
        throw var1_6;
    }

    public Messages$PresenceCommand$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$PresenceCommand;
        if (bl2) {
            message = (Messages$PresenceCommand)message;
            return this.mergeFrom((Messages$PresenceCommand)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Messages$PresenceCommand$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$PresenceCommand$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$PresenceCommand$Builder setCid(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.cid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$PresenceCommand$Builder setCidBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.cid_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$PresenceCommand$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$PresenceCommand$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Messages$PresenceCommand$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Messages$PresenceCommand$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public Messages$PresenceCommand$Builder setSessionPeerIds(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureSessionPeerIdsIsMutable();
        this.sessionPeerIds_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public Messages$PresenceCommand$Builder setStatus(Messages$StatusType messages$StatusType) {
        int n10;
        int n11;
        Objects.requireNonNull(messages$StatusType);
        this.bitField0_ = n11 = this.bitField0_ | 1;
        this.status_ = n10 = messages$StatusType.getNumber();
        this.onChanged();
        return this;
    }

    public final Messages$PresenceCommand$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$PresenceCommand$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

