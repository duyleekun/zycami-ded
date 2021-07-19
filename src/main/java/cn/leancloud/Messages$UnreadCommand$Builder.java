/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$UnreadCommand;
import cn.leancloud.Messages$UnreadCommandOrBuilder;
import cn.leancloud.Messages$UnreadTuple;
import cn.leancloud.Messages$UnreadTuple$Builder;
import cn.leancloud.Messages$UnreadTupleOrBuilder;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Messages$UnreadCommand$Builder
extends GeneratedMessageV3$Builder
implements Messages$UnreadCommandOrBuilder {
    private int bitField0_;
    private RepeatedFieldBuilderV3 convsBuilder_;
    private List convs_;
    private long notifTime_;

    private Messages$UnreadCommand$Builder() {
        List list;
        this.convs_ = list = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$UnreadCommand$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$UnreadCommand$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.convs_ = object = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$UnreadCommand$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureConvsIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) != n11) {
            ArrayList arrayList;
            List list = this.convs_;
            this.convs_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    private RepeatedFieldBuilderV3 getConvsFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.convsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.convs_;
            int bl2 = this.bitField0_;
            int n10 = 1;
            int n11 = bl2 & n10;
            if (n11 != n10) {
                n10 = 0;
            }
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl3 = this.isClean();
            this.convsBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n10 != 0, generatedMessageV3$BuilderParent, bl3);
            repeatedFieldBuilderV3 = null;
            this.convs_ = null;
        }
        return this.convsBuilder_;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$22600();
    }

    private void maybeForceBuilderInitialization() {
        boolean bl2 = Messages$UnreadCommand.access$23000();
        if (bl2) {
            this.getConvsFieldBuilder();
        }
    }

    public Messages$UnreadCommand$Builder addAllConvs(Iterable iterable) {
        Object object = this.convsBuilder_;
        if (object == null) {
            this.ensureConvsIsMutable();
            object = this.convs_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public Messages$UnreadCommand$Builder addConvs(int n10, Messages$UnreadTuple$Builder messages$UnreadTupleOrBuilder) {
        Object object = this.convsBuilder_;
        if (object == null) {
            this.ensureConvsIsMutable();
            object = this.convs_;
            messages$UnreadTupleOrBuilder = ((Messages$UnreadTuple$Builder)messages$UnreadTupleOrBuilder).build();
            object.add(n10, messages$UnreadTupleOrBuilder);
            this.onChanged();
        } else {
            messages$UnreadTupleOrBuilder = ((Messages$UnreadTuple$Builder)messages$UnreadTupleOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)((Object)messages$UnreadTupleOrBuilder));
        }
        return this;
    }

    public Messages$UnreadCommand$Builder addConvs(int n10, Messages$UnreadTuple messages$UnreadTuple) {
        Object object = this.convsBuilder_;
        if (object == null) {
            Objects.requireNonNull(messages$UnreadTuple);
            this.ensureConvsIsMutable();
            object = this.convs_;
            object.add(n10, messages$UnreadTuple);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, messages$UnreadTuple);
        }
        return this;
    }

    public Messages$UnreadCommand$Builder addConvs(Messages$UnreadTuple$Builder messages$UnreadTupleOrBuilder) {
        Object object = this.convsBuilder_;
        if (object == null) {
            this.ensureConvsIsMutable();
            object = this.convs_;
            messages$UnreadTupleOrBuilder = ((Messages$UnreadTuple$Builder)messages$UnreadTupleOrBuilder).build();
            object.add(messages$UnreadTupleOrBuilder);
            this.onChanged();
        } else {
            messages$UnreadTupleOrBuilder = ((Messages$UnreadTuple$Builder)messages$UnreadTupleOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)((Object)messages$UnreadTupleOrBuilder));
        }
        return this;
    }

    public Messages$UnreadCommand$Builder addConvs(Messages$UnreadTuple messages$UnreadTuple) {
        Object object = this.convsBuilder_;
        if (object == null) {
            Objects.requireNonNull(messages$UnreadTuple);
            this.ensureConvsIsMutable();
            object = this.convs_;
            object.add(messages$UnreadTuple);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(messages$UnreadTuple);
        }
        return this;
    }

    public Messages$UnreadTuple$Builder addConvsBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getConvsFieldBuilder();
        Messages$UnreadTuple messages$UnreadTuple = Messages$UnreadTuple.getDefaultInstance();
        return (Messages$UnreadTuple$Builder)repeatedFieldBuilderV3.addBuilder(messages$UnreadTuple);
    }

    public Messages$UnreadTuple$Builder addConvsBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getConvsFieldBuilder();
        Messages$UnreadTuple messages$UnreadTuple = Messages$UnreadTuple.getDefaultInstance();
        return (Messages$UnreadTuple$Builder)repeatedFieldBuilderV3.addBuilder(n10, messages$UnreadTuple);
    }

    public Messages$UnreadCommand$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$UnreadCommand$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Messages$UnreadCommand build() {
        Messages$UnreadCommand messages$UnreadCommand = this.buildPartial();
        boolean bl2 = messages$UnreadCommand.isInitialized();
        if (bl2) {
            return messages$UnreadCommand;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$UnreadCommand);
    }

    public Messages$UnreadCommand buildPartial() {
        int n10;
        Messages$UnreadCommand messages$UnreadCommand = new Messages$UnreadCommand(this, null);
        int n11 = this.bitField0_;
        List list = this.convsBuilder_;
        int n12 = 1;
        if (list == null) {
            n10 = n11 & 1;
            if (n10 == n12) {
                this.convs_ = list = Collections.unmodifiableList(this.convs_);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            }
            list = this.convs_;
            Messages$UnreadCommand.access$23202(messages$UnreadCommand, list);
        } else {
            list = ((RepeatedFieldBuilderV3)((Object)list)).build();
            Messages$UnreadCommand.access$23202(messages$UnreadCommand, list);
        }
        n10 = 2;
        if ((n11 &= n10) != n10) {
            n12 = 0;
        }
        long l10 = this.notifTime_;
        Messages$UnreadCommand.access$23302(messages$UnreadCommand, l10);
        Messages$UnreadCommand.access$23402(messages$UnreadCommand, n12);
        this.onBuilt();
        return messages$UnreadCommand;
    }

    public Messages$UnreadCommand$Builder clear() {
        int n10;
        super.clear();
        Object object = this.convsBuilder_;
        if (object == null) {
            this.convs_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        this.notifTime_ = 0L;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        return this;
    }

    public Messages$UnreadCommand$Builder clearConvs() {
        Object object = this.convsBuilder_;
        if (object == null) {
            int n10;
            this.convs_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public Messages$UnreadCommand$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Messages$UnreadCommand$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Messages$UnreadCommand$Builder clearNotifTime() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.notifTime_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$UnreadCommand$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Messages$UnreadCommand$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Messages$UnreadCommand$Builder clone() {
        return (Messages$UnreadCommand$Builder)super.clone();
    }

    public Messages$UnreadTuple getConvs(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.convsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (Messages$UnreadTuple)this.convs_.get(n10);
        }
        return (Messages$UnreadTuple)repeatedFieldBuilderV3.getMessage(n10);
    }

    public Messages$UnreadTuple$Builder getConvsBuilder(int n10) {
        return (Messages$UnreadTuple$Builder)this.getConvsFieldBuilder().getBuilder(n10);
    }

    public List getConvsBuilderList() {
        return this.getConvsFieldBuilder().getBuilderList();
    }

    public int getConvsCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.convsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.convs_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getConvsList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.convsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.convs_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public Messages$UnreadTupleOrBuilder getConvsOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.convsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (Messages$UnreadTupleOrBuilder)this.convs_.get(n10);
        }
        return (Messages$UnreadTupleOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getConvsOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.convsBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.convs_);
    }

    public Messages$UnreadCommand getDefaultInstanceForType() {
        return Messages$UnreadCommand.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$22600();
    }

    public long getNotifTime() {
        return this.notifTime_;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasNotifTime() {
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

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$22700().ensureFieldAccessorsInitialized(Messages$UnreadCommand.class, Messages$UnreadCommand$Builder.class);
    }

    public final boolean isInitialized() {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.getConvsCount()); ++i10) {
            Messages$UnreadTuple messages$UnreadTuple = this.getConvs(i10);
            n10 = (int)(messages$UnreadTuple.isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        return true;
    }

    public Messages$UnreadCommand$Builder mergeFrom(Messages$UnreadCommand messageLite) {
        boolean bl2;
        Object object = Messages$UnreadCommand.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        object = this.convsBuilder_;
        if (object == null) {
            object = Messages$UnreadCommand.access$23200((Messages$UnreadCommand)messageLite);
            boolean n10 = object.isEmpty();
            if (!n10) {
                object = this.convs_;
                boolean bl3 = object.isEmpty();
                if (bl3) {
                    int n11;
                    this.convs_ = object = Messages$UnreadCommand.access$23200((Messages$UnreadCommand)messageLite);
                    this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
                } else {
                    this.ensureConvsIsMutable();
                    object = this.convs_;
                    List list = Messages$UnreadCommand.access$23200((Messages$UnreadCommand)messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = Messages$UnreadCommand.access$23200((Messages$UnreadCommand)messageLite);
            boolean bl4 = object.isEmpty();
            if (!bl4) {
                object = this.convsBuilder_;
                boolean bl5 = ((RepeatedFieldBuilderV3)object).isEmpty();
                if (bl5) {
                    int n12;
                    List list;
                    this.convsBuilder_.dispose();
                    boolean bl6 = false;
                    object = null;
                    this.convsBuilder_ = null;
                    this.convs_ = list = Messages$UnreadCommand.access$23200((Messages$UnreadCommand)messageLite);
                    this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFFFE;
                    n12 = (int)(Messages$UnreadCommand.access$23500() ? 1 : 0);
                    if (n12 != 0) {
                        object = this.getConvsFieldBuilder();
                    }
                    this.convsBuilder_ = object;
                } else {
                    object = this.convsBuilder_;
                    List list = Messages$UnreadCommand.access$23200((Messages$UnreadCommand)messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        if (bl2 = ((Messages$UnreadCommand)messageLite).hasNotifTime()) {
            long l10 = ((Messages$UnreadCommand)messageLite).getNotifTime();
            this.setNotifTime(l10);
        }
        messageLite = Messages$UnreadCommand.access$23600((Messages$UnreadCommand)messageLite);
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
    public Messages$UnreadCommand$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$UnreadCommand.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$UnreadCommand)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$UnreadCommand)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$UnreadCommand)object2;
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
            this.mergeFrom((Messages$UnreadCommand)object3);
        }
        throw var1_6;
    }

    public Messages$UnreadCommand$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$UnreadCommand;
        if (bl2) {
            message = (Messages$UnreadCommand)message;
            return this.mergeFrom((Messages$UnreadCommand)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Messages$UnreadCommand$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$UnreadCommand$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$UnreadCommand$Builder removeConvs(int n10) {
        Object object = this.convsBuilder_;
        if (object == null) {
            this.ensureConvsIsMutable();
            object = this.convs_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public Messages$UnreadCommand$Builder setConvs(int n10, Messages$UnreadTuple$Builder messages$UnreadTupleOrBuilder) {
        Object object = this.convsBuilder_;
        if (object == null) {
            this.ensureConvsIsMutable();
            object = this.convs_;
            messages$UnreadTupleOrBuilder = ((Messages$UnreadTuple$Builder)messages$UnreadTupleOrBuilder).build();
            object.set(n10, messages$UnreadTupleOrBuilder);
            this.onChanged();
        } else {
            messages$UnreadTupleOrBuilder = ((Messages$UnreadTuple$Builder)messages$UnreadTupleOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)((Object)messages$UnreadTupleOrBuilder));
        }
        return this;
    }

    public Messages$UnreadCommand$Builder setConvs(int n10, Messages$UnreadTuple messages$UnreadTuple) {
        Object object = this.convsBuilder_;
        if (object == null) {
            Objects.requireNonNull(messages$UnreadTuple);
            this.ensureConvsIsMutable();
            object = this.convs_;
            object.set(n10, messages$UnreadTuple);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, messages$UnreadTuple);
        }
        return this;
    }

    public Messages$UnreadCommand$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$UnreadCommand$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Messages$UnreadCommand$Builder setNotifTime(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.notifTime_ = l10;
        this.onChanged();
        return this;
    }

    public Messages$UnreadCommand$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Messages$UnreadCommand$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final Messages$UnreadCommand$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$UnreadCommand$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

