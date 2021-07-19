/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$DataCommand;
import cn.leancloud.Messages$DataCommandOrBuilder;
import cn.leancloud.Messages$JsonObjectMessage;
import cn.leancloud.Messages$JsonObjectMessage$Builder;
import cn.leancloud.Messages$JsonObjectMessageOrBuilder;
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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Messages$DataCommand$Builder
extends GeneratedMessageV3$Builder
implements Messages$DataCommandOrBuilder {
    private int bitField0_;
    private LazyStringList ids_;
    private RepeatedFieldBuilderV3 msgBuilder_;
    private List msg_;
    private boolean offline_;

    private Messages$DataCommand$Builder() {
        List list;
        this.ids_ = list = LazyStringArrayList.EMPTY;
        list = Collections.emptyList();
        this.msg_ = list;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$DataCommand$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$DataCommand$Builder(GeneratedMessageV3$BuilderParent list) {
        super((GeneratedMessageV3$BuilderParent)((Object)list));
        list = LazyStringArrayList.EMPTY;
        this.ids_ = list;
        this.msg_ = list = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$DataCommand$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureIdsIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) != n11) {
            LazyStringList lazyStringList = this.ids_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.ids_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    private void ensureMsgIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 2;
        if ((n10 &= n11) != n11) {
            ArrayList arrayList;
            List list = this.msg_;
            this.msg_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$11900();
    }

    /*
     * WARNING - void declaration
     */
    private RepeatedFieldBuilderV3 getMsgFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.msgBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            void var3_7;
            List list = this.msg_;
            int bl2 = this.bitField0_;
            int n10 = 2;
            int n11 = bl2 & n10;
            if (n11 == n10) {
                boolean bl3 = true;
            } else {
                boolean bl4 = false;
            }
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl5 = this.isClean();
            this.msgBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, (boolean)var3_7, generatedMessageV3$BuilderParent, bl5);
            repeatedFieldBuilderV3 = null;
            this.msg_ = null;
        }
        return this.msgBuilder_;
    }

    private void maybeForceBuilderInitialization() {
        boolean bl2 = Messages$DataCommand.access$12300();
        if (bl2) {
            this.getMsgFieldBuilder();
        }
    }

    public Messages$DataCommand$Builder addAllIds(Iterable iterable) {
        this.ensureIdsIsMutable();
        LazyStringList lazyStringList = this.ids_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public Messages$DataCommand$Builder addAllMsg(Iterable iterable) {
        Object object = this.msgBuilder_;
        if (object == null) {
            this.ensureMsgIsMutable();
            object = this.msg_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public Messages$DataCommand$Builder addIds(String string2) {
        Objects.requireNonNull(string2);
        this.ensureIdsIsMutable();
        this.ids_.add(string2);
        this.onChanged();
        return this;
    }

    public Messages$DataCommand$Builder addIdsBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensureIdsIsMutable();
        this.ids_.add(byteString);
        this.onChanged();
        return this;
    }

    public Messages$DataCommand$Builder addMsg(int n10, Messages$JsonObjectMessage$Builder messages$JsonObjectMessageOrBuilder) {
        Object object = this.msgBuilder_;
        if (object == null) {
            this.ensureMsgIsMutable();
            object = this.msg_;
            messages$JsonObjectMessageOrBuilder = ((Messages$JsonObjectMessage$Builder)messages$JsonObjectMessageOrBuilder).build();
            object.add(n10, messages$JsonObjectMessageOrBuilder);
            this.onChanged();
        } else {
            messages$JsonObjectMessageOrBuilder = ((Messages$JsonObjectMessage$Builder)messages$JsonObjectMessageOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)((Object)messages$JsonObjectMessageOrBuilder));
        }
        return this;
    }

    public Messages$DataCommand$Builder addMsg(int n10, Messages$JsonObjectMessage messages$JsonObjectMessage) {
        Object object = this.msgBuilder_;
        if (object == null) {
            Objects.requireNonNull(messages$JsonObjectMessage);
            this.ensureMsgIsMutable();
            object = this.msg_;
            object.add(n10, messages$JsonObjectMessage);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, messages$JsonObjectMessage);
        }
        return this;
    }

    public Messages$DataCommand$Builder addMsg(Messages$JsonObjectMessage$Builder messages$JsonObjectMessageOrBuilder) {
        Object object = this.msgBuilder_;
        if (object == null) {
            this.ensureMsgIsMutable();
            object = this.msg_;
            messages$JsonObjectMessageOrBuilder = ((Messages$JsonObjectMessage$Builder)messages$JsonObjectMessageOrBuilder).build();
            object.add(messages$JsonObjectMessageOrBuilder);
            this.onChanged();
        } else {
            messages$JsonObjectMessageOrBuilder = ((Messages$JsonObjectMessage$Builder)messages$JsonObjectMessageOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)((Object)messages$JsonObjectMessageOrBuilder));
        }
        return this;
    }

    public Messages$DataCommand$Builder addMsg(Messages$JsonObjectMessage messages$JsonObjectMessage) {
        Object object = this.msgBuilder_;
        if (object == null) {
            Objects.requireNonNull(messages$JsonObjectMessage);
            this.ensureMsgIsMutable();
            object = this.msg_;
            object.add(messages$JsonObjectMessage);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(messages$JsonObjectMessage);
        }
        return this;
    }

    public Messages$JsonObjectMessage$Builder addMsgBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getMsgFieldBuilder();
        Messages$JsonObjectMessage messages$JsonObjectMessage = Messages$JsonObjectMessage.getDefaultInstance();
        return (Messages$JsonObjectMessage$Builder)repeatedFieldBuilderV3.addBuilder(messages$JsonObjectMessage);
    }

    public Messages$JsonObjectMessage$Builder addMsgBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getMsgFieldBuilder();
        Messages$JsonObjectMessage messages$JsonObjectMessage = Messages$JsonObjectMessage.getDefaultInstance();
        return (Messages$JsonObjectMessage$Builder)repeatedFieldBuilderV3.addBuilder(n10, messages$JsonObjectMessage);
    }

    public Messages$DataCommand$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$DataCommand$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Messages$DataCommand build() {
        Messages$DataCommand messages$DataCommand = this.buildPartial();
        boolean bl2 = messages$DataCommand.isInitialized();
        if (bl2) {
            return messages$DataCommand;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$DataCommand);
    }

    public Messages$DataCommand buildPartial() {
        List list;
        Messages$DataCommand messages$DataCommand = new Messages$DataCommand(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        int n12 = 1;
        if (n11 == n12) {
            list = this.ids_.getUnmodifiableView();
            this.ids_ = list;
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        }
        list = this.ids_;
        Messages$DataCommand.access$12502(messages$DataCommand, (LazyStringList)list);
        list = this.msgBuilder_;
        if (list == null) {
            n11 = this.bitField0_;
            int n13 = 2;
            if ((n11 &= n13) == n13) {
                this.msg_ = list = Collections.unmodifiableList(this.msg_);
                this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFD;
            }
            list = this.msg_;
            Messages$DataCommand.access$12602(messages$DataCommand, list);
        } else {
            list = ((RepeatedFieldBuilderV3)((Object)list)).build();
            Messages$DataCommand.access$12602(messages$DataCommand, list);
        }
        n11 = 4;
        if ((n10 &= n11) != n11) {
            n12 = 0;
        }
        n10 = (int)(this.offline_ ? 1 : 0);
        Messages$DataCommand.access$12702(messages$DataCommand, n10 != 0);
        Messages$DataCommand.access$12802(messages$DataCommand, n12);
        this.onBuilt();
        return messages$DataCommand;
    }

    public Messages$DataCommand$Builder clear() {
        int n10;
        super.clear();
        List list = LazyStringArrayList.EMPTY;
        this.ids_ = list;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        list = this.msgBuilder_;
        if (list == null) {
            this.msg_ = list = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        } else {
            ((RepeatedFieldBuilderV3)((Object)list)).clear();
        }
        this.offline_ = false;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        return this;
    }

    public Messages$DataCommand$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Messages$DataCommand$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Messages$DataCommand$Builder clearIds() {
        int n10;
        LazyStringList lazyStringList;
        this.ids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.onChanged();
        return this;
    }

    public Messages$DataCommand$Builder clearMsg() {
        Object object = this.msgBuilder_;
        if (object == null) {
            int n10;
            this.msg_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public Messages$DataCommand$Builder clearOffline() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        this.offline_ = false;
        this.onChanged();
        return this;
    }

    public Messages$DataCommand$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Messages$DataCommand$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Messages$DataCommand$Builder clone() {
        return (Messages$DataCommand$Builder)super.clone();
    }

    public Messages$DataCommand getDefaultInstanceForType() {
        return Messages$DataCommand.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$11900();
    }

    public String getIds(int n10) {
        return (String)this.ids_.get(n10);
    }

    public ByteString getIdsBytes(int n10) {
        return this.ids_.getByteString(n10);
    }

    public int getIdsCount() {
        return this.ids_.size();
    }

    public ProtocolStringList getIdsList() {
        return this.ids_.getUnmodifiableView();
    }

    public Messages$JsonObjectMessage getMsg(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.msgBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (Messages$JsonObjectMessage)this.msg_.get(n10);
        }
        return (Messages$JsonObjectMessage)repeatedFieldBuilderV3.getMessage(n10);
    }

    public Messages$JsonObjectMessage$Builder getMsgBuilder(int n10) {
        return (Messages$JsonObjectMessage$Builder)this.getMsgFieldBuilder().getBuilder(n10);
    }

    public List getMsgBuilderList() {
        return this.getMsgFieldBuilder().getBuilderList();
    }

    public int getMsgCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.msgBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.msg_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getMsgList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.msgBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.msg_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public Messages$JsonObjectMessageOrBuilder getMsgOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.msgBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (Messages$JsonObjectMessageOrBuilder)this.msg_.get(n10);
        }
        return (Messages$JsonObjectMessageOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getMsgOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.msgBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.msg_);
    }

    public boolean getOffline() {
        return this.offline_;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasOffline() {
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
        return Messages.access$12000().ensureFieldAccessorsInitialized(Messages$DataCommand.class, Messages$DataCommand$Builder.class);
    }

    public final boolean isInitialized() {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.getMsgCount()); ++i10) {
            Messages$JsonObjectMessage messages$JsonObjectMessage = this.getMsg(i10);
            n10 = (int)(messages$JsonObjectMessage.isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        return true;
    }

    public Messages$DataCommand$Builder mergeFrom(Messages$DataCommand messageLite) {
        List list;
        Object object = Messages$DataCommand.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        object = Messages$DataCommand.access$12500(messageLite);
        int n10 = object.isEmpty();
        if (n10 == 0) {
            object = this.ids_;
            n10 = object.isEmpty();
            if (n10 != 0) {
                this.ids_ = object = Messages$DataCommand.access$12500(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            } else {
                this.ensureIdsIsMutable();
                object = this.ids_;
                list = Messages$DataCommand.access$12500(messageLite);
                object.addAll(list);
            }
            this.onChanged();
        }
        if ((object = this.msgBuilder_) == null) {
            object = Messages$DataCommand.access$12600(messageLite);
            n10 = object.isEmpty();
            if (n10 == 0) {
                object = this.msg_;
                n10 = (int)(object.isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.msg_ = object = Messages$DataCommand.access$12600(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
                } else {
                    this.ensureMsgIsMutable();
                    object = this.msg_;
                    list = Messages$DataCommand.access$12600(messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = Messages$DataCommand.access$12600(messageLite);
            n10 = object.isEmpty();
            if (n10 == 0) {
                object = this.msgBuilder_;
                n10 = (int)(((RepeatedFieldBuilderV3)object).isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    int n11;
                    this.msgBuilder_.dispose();
                    n10 = 0;
                    object = null;
                    this.msgBuilder_ = null;
                    list = Messages$DataCommand.access$12600(messageLite);
                    this.msg_ = list;
                    this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFD;
                    n11 = (int)(Messages$DataCommand.access$12900() ? 1 : 0);
                    if (n11 != 0) {
                        object = this.getMsgFieldBuilder();
                    }
                    this.msgBuilder_ = object;
                } else {
                    object = this.msgBuilder_;
                    list = Messages$DataCommand.access$12600(messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        if ((n10 = messageLite.hasOffline()) != 0) {
            n10 = (int)(messageLite.getOffline() ? 1 : 0);
            this.setOffline(n10 != 0);
        }
        messageLite = Messages$DataCommand.access$13000(messageLite);
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
    public Messages$DataCommand$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$DataCommand.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$DataCommand)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$DataCommand)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$DataCommand)object2;
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
            this.mergeFrom((Messages$DataCommand)object3);
        }
        throw var1_6;
    }

    public Messages$DataCommand$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$DataCommand;
        if (bl2) {
            message = (Messages$DataCommand)message;
            return this.mergeFrom((Messages$DataCommand)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Messages$DataCommand$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$DataCommand$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$DataCommand$Builder removeMsg(int n10) {
        Object object = this.msgBuilder_;
        if (object == null) {
            this.ensureMsgIsMutable();
            object = this.msg_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public Messages$DataCommand$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$DataCommand$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Messages$DataCommand$Builder setIds(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureIdsIsMutable();
        this.ids_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public Messages$DataCommand$Builder setMsg(int n10, Messages$JsonObjectMessage$Builder messages$JsonObjectMessageOrBuilder) {
        Object object = this.msgBuilder_;
        if (object == null) {
            this.ensureMsgIsMutable();
            object = this.msg_;
            messages$JsonObjectMessageOrBuilder = ((Messages$JsonObjectMessage$Builder)messages$JsonObjectMessageOrBuilder).build();
            object.set(n10, messages$JsonObjectMessageOrBuilder);
            this.onChanged();
        } else {
            messages$JsonObjectMessageOrBuilder = ((Messages$JsonObjectMessage$Builder)messages$JsonObjectMessageOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)((Object)messages$JsonObjectMessageOrBuilder));
        }
        return this;
    }

    public Messages$DataCommand$Builder setMsg(int n10, Messages$JsonObjectMessage messages$JsonObjectMessage) {
        Object object = this.msgBuilder_;
        if (object == null) {
            Objects.requireNonNull(messages$JsonObjectMessage);
            this.ensureMsgIsMutable();
            object = this.msg_;
            object.set(n10, messages$JsonObjectMessage);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, messages$JsonObjectMessage);
        }
        return this;
    }

    public Messages$DataCommand$Builder setOffline(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.offline_ = bl2;
        this.onChanged();
        return this;
    }

    public Messages$DataCommand$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Messages$DataCommand$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final Messages$DataCommand$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$DataCommand$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

