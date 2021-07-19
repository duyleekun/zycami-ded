/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$RoomCommand;
import cn.leancloud.Messages$RoomCommandOrBuilder;
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

public final class Messages$RoomCommand$Builder
extends GeneratedMessageV3$Builder
implements Messages$RoomCommandOrBuilder {
    private int bitField0_;
    private Object byPeerId_;
    private Object n_;
    private Object roomId_;
    private LazyStringList roomPeerIds_;
    private Object s_;
    private long t_;
    private boolean transient_;

    private Messages$RoomCommand$Builder() {
        LazyStringList lazyStringList;
        String string2 = "";
        this.roomId_ = string2;
        this.s_ = string2;
        this.n_ = string2;
        this.roomPeerIds_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.byPeerId_ = string2;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$RoomCommand$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$RoomCommand$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        LazyStringList lazyStringList;
        this.roomId_ = object = "";
        this.s_ = object;
        this.n_ = object;
        this.roomPeerIds_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.byPeerId_ = object;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$RoomCommand$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureRoomPeerIdsIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 32;
        if ((n10 &= n11) != n11) {
            LazyStringList lazyStringList = this.roomPeerIds_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.roomPeerIds_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$28600();
    }

    private void maybeForceBuilderInitialization() {
        Messages$RoomCommand.access$29000();
    }

    public Messages$RoomCommand$Builder addAllRoomPeerIds(Iterable iterable) {
        this.ensureRoomPeerIdsIsMutable();
        LazyStringList lazyStringList = this.roomPeerIds_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public Messages$RoomCommand$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$RoomCommand$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Messages$RoomCommand$Builder addRoomPeerIds(String string2) {
        Objects.requireNonNull(string2);
        this.ensureRoomPeerIdsIsMutable();
        this.roomPeerIds_.add(string2);
        this.onChanged();
        return this;
    }

    public Messages$RoomCommand$Builder addRoomPeerIdsBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensureRoomPeerIdsIsMutable();
        this.roomPeerIds_.add(byteString);
        this.onChanged();
        return this;
    }

    public Messages$RoomCommand build() {
        Messages$RoomCommand messages$RoomCommand = this.buildPartial();
        boolean bl2 = messages$RoomCommand.isInitialized();
        if (bl2) {
            return messages$RoomCommand;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$RoomCommand);
    }

    public Messages$RoomCommand buildPartial() {
        Object object = null;
        Messages$RoomCommand messages$RoomCommand = new Messages$RoomCommand(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        int n12 = 1;
        if (n11 != n12) {
            n12 = 0;
        }
        Object object2 = this.roomId_;
        Messages$RoomCommand.access$29202(messages$RoomCommand, object2);
        n11 = n10 & 2;
        int n13 = 2;
        if (n11 == n13) {
            n12 |= 2;
        }
        object2 = this.s_;
        Messages$RoomCommand.access$29302(messages$RoomCommand, object2);
        n11 = n10 & 4;
        n13 = 4;
        if (n11 == n13) {
            n12 |= 4;
        }
        long l10 = this.t_;
        Messages$RoomCommand.access$29402(messages$RoomCommand, l10);
        n11 = n10 & 8;
        n13 = 8;
        if (n11 == n13) {
            n12 |= 8;
        }
        object2 = this.n_;
        Messages$RoomCommand.access$29502(messages$RoomCommand, object2);
        n11 = n10 & 0x10;
        n13 = 16;
        if (n11 == n13) {
            n12 |= 0x10;
        }
        n11 = (int)(this.transient_ ? 1 : 0);
        Messages$RoomCommand.access$29602(messages$RoomCommand, n11 != 0);
        n11 = this.bitField0_;
        n13 = 32;
        if ((n11 &= n13) == n13) {
            this.roomPeerIds_ = object2 = this.roomPeerIds_.getUnmodifiableView();
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFDF;
        }
        object2 = this.roomPeerIds_;
        Messages$RoomCommand.access$29702(messages$RoomCommand, (LazyStringList)object2);
        n11 = 64;
        if ((n10 &= n11) == n11) {
            n12 |= 0x20;
        }
        object = this.byPeerId_;
        Messages$RoomCommand.access$29802(messages$RoomCommand, object);
        Messages$RoomCommand.access$29902(messages$RoomCommand, n12);
        this.onBuilt();
        return messages$RoomCommand;
    }

    public Messages$RoomCommand$Builder clear() {
        int n10;
        LazyStringList lazyStringList;
        int n11;
        super.clear();
        String string2 = "";
        this.roomId_ = string2;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        this.s_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFFD;
        this.t_ = 0L;
        this.bitField0_ = n11 &= 0xFFFFFFFB;
        this.n_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFF7;
        this.transient_ = false;
        this.bitField0_ = n11 &= 0xFFFFFFEF;
        this.roomPeerIds_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n11 &= 0xFFFFFFDF;
        this.byPeerId_ = string2;
        this.bitField0_ = n10 = n11 & 0xFFFFFFBF;
        return this;
    }

    public Messages$RoomCommand$Builder clearByPeerId() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFBF;
        String string2 = Messages$RoomCommand.getDefaultInstance().getByPeerId();
        this.byPeerId_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$RoomCommand$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Messages$RoomCommand$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Messages$RoomCommand$Builder clearN() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        String string2 = Messages$RoomCommand.getDefaultInstance().getN();
        this.n_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$RoomCommand$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Messages$RoomCommand$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Messages$RoomCommand$Builder clearRoomId() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = Messages$RoomCommand.getDefaultInstance().getRoomId();
        this.roomId_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$RoomCommand$Builder clearRoomPeerIds() {
        int n10;
        LazyStringList lazyStringList;
        this.roomPeerIds_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
        this.onChanged();
        return this;
    }

    public Messages$RoomCommand$Builder clearS() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        String string2 = Messages$RoomCommand.getDefaultInstance().getS();
        this.s_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$RoomCommand$Builder clearT() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        this.t_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$RoomCommand$Builder clearTransient() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        this.transient_ = false;
        this.onChanged();
        return this;
    }

    public Messages$RoomCommand$Builder clone() {
        return (Messages$RoomCommand$Builder)super.clone();
    }

    public String getByPeerId() {
        Object object = this.byPeerId_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.byPeerId_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getByPeerIdBytes() {
        Object object = this.byPeerId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.byPeerId_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Messages$RoomCommand getDefaultInstanceForType() {
        return Messages$RoomCommand.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$28600();
    }

    public String getN() {
        Object object = this.n_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.n_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getNBytes() {
        Object object = this.n_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.n_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getRoomId() {
        Object object = this.roomId_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.roomId_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getRoomIdBytes() {
        Object object = this.roomId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.roomId_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getRoomPeerIds(int n10) {
        return (String)this.roomPeerIds_.get(n10);
    }

    public ByteString getRoomPeerIdsBytes(int n10) {
        return this.roomPeerIds_.getByteString(n10);
    }

    public int getRoomPeerIdsCount() {
        return this.roomPeerIds_.size();
    }

    public ProtocolStringList getRoomPeerIdsList() {
        return this.roomPeerIds_.getUnmodifiableView();
    }

    public String getS() {
        Object object = this.s_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.s_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getSBytes() {
        Object object = this.s_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.s_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public long getT() {
        return this.t_;
    }

    public boolean getTransient() {
        return this.transient_;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasByPeerId() {
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
    public boolean hasN() {
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

    public boolean hasRoomId() {
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
    public boolean hasS() {
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

    /*
     * WARNING - void declaration
     */
    public boolean hasT() {
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
    public boolean hasTransient() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 16;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$28700().ensureFieldAccessorsInitialized(Messages$RoomCommand.class, Messages$RoomCommand$Builder.class);
    }

    public final boolean isInitialized() {
        return true;
    }

    public Messages$RoomCommand$Builder mergeFrom(Messages$RoomCommand messageLite) {
        Object object = Messages$RoomCommand.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasRoomId();
        if (n10 != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 1;
            this.roomId_ = object = Messages$RoomCommand.access$29200(messageLite);
            this.onChanged();
        }
        if ((n10 = messageLite.hasS()) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 2;
            this.s_ = object = Messages$RoomCommand.access$29300(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasT() ? 1 : 0)) != 0) {
            long l10 = messageLite.getT();
            this.setT(l10);
        }
        if ((n10 = (int)(messageLite.hasN() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 8;
            this.n_ = object = Messages$RoomCommand.access$29500(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasTransient() ? 1 : 0)) != 0) {
            n10 = (int)(messageLite.getTransient() ? 1 : 0);
            this.setTransient(n10 != 0);
        }
        if ((n10 = (object = Messages$RoomCommand.access$29700(messageLite)).isEmpty()) == 0) {
            object = this.roomPeerIds_;
            n10 = object.isEmpty();
            if (n10 != 0) {
                this.roomPeerIds_ = object = Messages$RoomCommand.access$29700(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
            } else {
                this.ensureRoomPeerIdsIsMutable();
                object = this.roomPeerIds_;
                LazyStringList lazyStringList = Messages$RoomCommand.access$29700(messageLite);
                object.addAll(lazyStringList);
            }
            this.onChanged();
        }
        if ((n10 = messageLite.hasByPeerId()) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x40;
            this.byPeerId_ = object = Messages$RoomCommand.access$29800(messageLite);
            this.onChanged();
        }
        messageLite = Messages$RoomCommand.access$30000(messageLite);
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
    public Messages$RoomCommand$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$RoomCommand.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$RoomCommand)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$RoomCommand)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$RoomCommand)object2;
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
            this.mergeFrom((Messages$RoomCommand)object3);
        }
        throw var1_6;
    }

    public Messages$RoomCommand$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$RoomCommand;
        if (bl2) {
            message = (Messages$RoomCommand)message;
            return this.mergeFrom((Messages$RoomCommand)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Messages$RoomCommand$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$RoomCommand$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$RoomCommand$Builder setByPeerId(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x40;
        this.byPeerId_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$RoomCommand$Builder setByPeerIdBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x40;
        this.byPeerId_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$RoomCommand$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$RoomCommand$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Messages$RoomCommand$Builder setN(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.n_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$RoomCommand$Builder setNBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.n_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$RoomCommand$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Messages$RoomCommand$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public Messages$RoomCommand$Builder setRoomId(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.roomId_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$RoomCommand$Builder setRoomIdBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.roomId_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$RoomCommand$Builder setRoomPeerIds(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureRoomPeerIdsIsMutable();
        this.roomPeerIds_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public Messages$RoomCommand$Builder setS(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.s_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$RoomCommand$Builder setSBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.s_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$RoomCommand$Builder setT(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.t_ = l10;
        this.onChanged();
        return this;
    }

    public Messages$RoomCommand$Builder setTransient(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x10;
        this.transient_ = bl2;
        this.onChanged();
        return this;
    }

    public final Messages$RoomCommand$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$RoomCommand$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

