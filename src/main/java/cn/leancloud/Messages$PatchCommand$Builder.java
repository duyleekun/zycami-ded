/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$PatchCommand;
import cn.leancloud.Messages$PatchCommandOrBuilder;
import cn.leancloud.Messages$PatchItem;
import cn.leancloud.Messages$PatchItem$Builder;
import cn.leancloud.Messages$PatchItemOrBuilder;
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

public final class Messages$PatchCommand$Builder
extends GeneratedMessageV3$Builder
implements Messages$PatchCommandOrBuilder {
    private int bitField0_;
    private long lastPatchTime_;
    private RepeatedFieldBuilderV3 patchesBuilder_;
    private List patches_;

    private Messages$PatchCommand$Builder() {
        List list;
        this.patches_ = list = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$PatchCommand$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$PatchCommand$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        this.patches_ = object = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$PatchCommand$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensurePatchesIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) != n11) {
            ArrayList arrayList;
            List list = this.patches_;
            this.patches_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$42200();
    }

    private RepeatedFieldBuilderV3 getPatchesFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.patchesBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            List list = this.patches_;
            int bl2 = this.bitField0_;
            int n10 = 1;
            int n11 = bl2 & n10;
            if (n11 != n10) {
                n10 = 0;
            }
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl3 = this.isClean();
            this.patchesBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, n10 != 0, generatedMessageV3$BuilderParent, bl3);
            repeatedFieldBuilderV3 = null;
            this.patches_ = null;
        }
        return this.patchesBuilder_;
    }

    private void maybeForceBuilderInitialization() {
        boolean bl2 = Messages$PatchCommand.access$42600();
        if (bl2) {
            this.getPatchesFieldBuilder();
        }
    }

    public Messages$PatchCommand$Builder addAllPatches(Iterable iterable) {
        Object object = this.patchesBuilder_;
        if (object == null) {
            this.ensurePatchesIsMutable();
            object = this.patches_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public Messages$PatchCommand$Builder addPatches(int n10, Messages$PatchItem$Builder messages$PatchItemOrBuilder) {
        Object object = this.patchesBuilder_;
        if (object == null) {
            this.ensurePatchesIsMutable();
            object = this.patches_;
            messages$PatchItemOrBuilder = ((Messages$PatchItem$Builder)messages$PatchItemOrBuilder).build();
            object.add(n10, messages$PatchItemOrBuilder);
            this.onChanged();
        } else {
            messages$PatchItemOrBuilder = ((Messages$PatchItem$Builder)messages$PatchItemOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)((Object)messages$PatchItemOrBuilder));
        }
        return this;
    }

    public Messages$PatchCommand$Builder addPatches(int n10, Messages$PatchItem messages$PatchItem) {
        Object object = this.patchesBuilder_;
        if (object == null) {
            Objects.requireNonNull(messages$PatchItem);
            this.ensurePatchesIsMutable();
            object = this.patches_;
            object.add(n10, messages$PatchItem);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, messages$PatchItem);
        }
        return this;
    }

    public Messages$PatchCommand$Builder addPatches(Messages$PatchItem$Builder messages$PatchItemOrBuilder) {
        Object object = this.patchesBuilder_;
        if (object == null) {
            this.ensurePatchesIsMutable();
            object = this.patches_;
            messages$PatchItemOrBuilder = ((Messages$PatchItem$Builder)messages$PatchItemOrBuilder).build();
            object.add(messages$PatchItemOrBuilder);
            this.onChanged();
        } else {
            messages$PatchItemOrBuilder = ((Messages$PatchItem$Builder)messages$PatchItemOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)((Object)messages$PatchItemOrBuilder));
        }
        return this;
    }

    public Messages$PatchCommand$Builder addPatches(Messages$PatchItem messages$PatchItem) {
        Object object = this.patchesBuilder_;
        if (object == null) {
            Objects.requireNonNull(messages$PatchItem);
            this.ensurePatchesIsMutable();
            object = this.patches_;
            object.add(messages$PatchItem);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(messages$PatchItem);
        }
        return this;
    }

    public Messages$PatchItem$Builder addPatchesBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getPatchesFieldBuilder();
        Messages$PatchItem messages$PatchItem = Messages$PatchItem.getDefaultInstance();
        return (Messages$PatchItem$Builder)repeatedFieldBuilderV3.addBuilder(messages$PatchItem);
    }

    public Messages$PatchItem$Builder addPatchesBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getPatchesFieldBuilder();
        Messages$PatchItem messages$PatchItem = Messages$PatchItem.getDefaultInstance();
        return (Messages$PatchItem$Builder)repeatedFieldBuilderV3.addBuilder(n10, messages$PatchItem);
    }

    public Messages$PatchCommand$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$PatchCommand$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Messages$PatchCommand build() {
        Messages$PatchCommand messages$PatchCommand = this.buildPartial();
        boolean bl2 = messages$PatchCommand.isInitialized();
        if (bl2) {
            return messages$PatchCommand;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$PatchCommand);
    }

    public Messages$PatchCommand buildPartial() {
        int n10;
        Messages$PatchCommand messages$PatchCommand = new Messages$PatchCommand(this, null);
        int n11 = this.bitField0_;
        List list = this.patchesBuilder_;
        int n12 = 1;
        if (list == null) {
            n10 = n11 & 1;
            if (n10 == n12) {
                this.patches_ = list = Collections.unmodifiableList(this.patches_);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            }
            list = this.patches_;
            Messages$PatchCommand.access$42802(messages$PatchCommand, list);
        } else {
            list = ((RepeatedFieldBuilderV3)((Object)list)).build();
            Messages$PatchCommand.access$42802(messages$PatchCommand, list);
        }
        n10 = 2;
        if ((n11 &= n10) != n10) {
            n12 = 0;
        }
        long l10 = this.lastPatchTime_;
        Messages$PatchCommand.access$42902(messages$PatchCommand, l10);
        Messages$PatchCommand.access$43002(messages$PatchCommand, n12);
        this.onBuilt();
        return messages$PatchCommand;
    }

    public Messages$PatchCommand$Builder clear() {
        int n10;
        super.clear();
        Object object = this.patchesBuilder_;
        if (object == null) {
            this.patches_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        this.lastPatchTime_ = 0L;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        return this;
    }

    public Messages$PatchCommand$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Messages$PatchCommand$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Messages$PatchCommand$Builder clearLastPatchTime() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.lastPatchTime_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$PatchCommand$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Messages$PatchCommand$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Messages$PatchCommand$Builder clearPatches() {
        Object object = this.patchesBuilder_;
        if (object == null) {
            int n10;
            this.patches_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public Messages$PatchCommand$Builder clone() {
        return (Messages$PatchCommand$Builder)super.clone();
    }

    public Messages$PatchCommand getDefaultInstanceForType() {
        return Messages$PatchCommand.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$42200();
    }

    public long getLastPatchTime() {
        return this.lastPatchTime_;
    }

    public Messages$PatchItem getPatches(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.patchesBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (Messages$PatchItem)this.patches_.get(n10);
        }
        return (Messages$PatchItem)repeatedFieldBuilderV3.getMessage(n10);
    }

    public Messages$PatchItem$Builder getPatchesBuilder(int n10) {
        return (Messages$PatchItem$Builder)this.getPatchesFieldBuilder().getBuilder(n10);
    }

    public List getPatchesBuilderList() {
        return this.getPatchesFieldBuilder().getBuilderList();
    }

    public int getPatchesCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.patchesBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.patches_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getPatchesList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.patchesBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.patches_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public Messages$PatchItemOrBuilder getPatchesOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.patchesBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (Messages$PatchItemOrBuilder)this.patches_.get(n10);
        }
        return (Messages$PatchItemOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getPatchesOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.patchesBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.patches_);
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasLastPatchTime() {
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
        return Messages.access$42300().ensureFieldAccessorsInitialized(Messages$PatchCommand.class, Messages$PatchCommand$Builder.class);
    }

    public final boolean isInitialized() {
        return true;
    }

    public Messages$PatchCommand$Builder mergeFrom(Messages$PatchCommand messageLite) {
        boolean bl2;
        Object object = Messages$PatchCommand.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        object = this.patchesBuilder_;
        if (object == null) {
            object = Messages$PatchCommand.access$42800((Messages$PatchCommand)messageLite);
            boolean n10 = object.isEmpty();
            if (!n10) {
                object = this.patches_;
                boolean bl3 = object.isEmpty();
                if (bl3) {
                    int n11;
                    this.patches_ = object = Messages$PatchCommand.access$42800((Messages$PatchCommand)messageLite);
                    this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
                } else {
                    this.ensurePatchesIsMutable();
                    object = this.patches_;
                    List list = Messages$PatchCommand.access$42800((Messages$PatchCommand)messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = Messages$PatchCommand.access$42800((Messages$PatchCommand)messageLite);
            boolean bl4 = object.isEmpty();
            if (!bl4) {
                object = this.patchesBuilder_;
                boolean bl5 = ((RepeatedFieldBuilderV3)object).isEmpty();
                if (bl5) {
                    int n12;
                    List list;
                    this.patchesBuilder_.dispose();
                    boolean bl6 = false;
                    object = null;
                    this.patchesBuilder_ = null;
                    this.patches_ = list = Messages$PatchCommand.access$42800((Messages$PatchCommand)messageLite);
                    this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFFFE;
                    n12 = (int)(Messages$PatchCommand.access$43100() ? 1 : 0);
                    if (n12 != 0) {
                        object = this.getPatchesFieldBuilder();
                    }
                    this.patchesBuilder_ = object;
                } else {
                    object = this.patchesBuilder_;
                    List list = Messages$PatchCommand.access$42800((Messages$PatchCommand)messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        if (bl2 = ((Messages$PatchCommand)messageLite).hasLastPatchTime()) {
            long l10 = ((Messages$PatchCommand)messageLite).getLastPatchTime();
            this.setLastPatchTime(l10);
        }
        messageLite = Messages$PatchCommand.access$43200((Messages$PatchCommand)messageLite);
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
    public Messages$PatchCommand$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$PatchCommand.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$PatchCommand)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$PatchCommand)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$PatchCommand)object2;
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
            this.mergeFrom((Messages$PatchCommand)object3);
        }
        throw var1_6;
    }

    public Messages$PatchCommand$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$PatchCommand;
        if (bl2) {
            message = (Messages$PatchCommand)message;
            return this.mergeFrom((Messages$PatchCommand)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Messages$PatchCommand$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$PatchCommand$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$PatchCommand$Builder removePatches(int n10) {
        Object object = this.patchesBuilder_;
        if (object == null) {
            this.ensurePatchesIsMutable();
            object = this.patches_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public Messages$PatchCommand$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$PatchCommand$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Messages$PatchCommand$Builder setLastPatchTime(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.lastPatchTime_ = l10;
        this.onChanged();
        return this;
    }

    public Messages$PatchCommand$Builder setPatches(int n10, Messages$PatchItem$Builder messages$PatchItemOrBuilder) {
        Object object = this.patchesBuilder_;
        if (object == null) {
            this.ensurePatchesIsMutable();
            object = this.patches_;
            messages$PatchItemOrBuilder = ((Messages$PatchItem$Builder)messages$PatchItemOrBuilder).build();
            object.set(n10, messages$PatchItemOrBuilder);
            this.onChanged();
        } else {
            messages$PatchItemOrBuilder = ((Messages$PatchItem$Builder)messages$PatchItemOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)((Object)messages$PatchItemOrBuilder));
        }
        return this;
    }

    public Messages$PatchCommand$Builder setPatches(int n10, Messages$PatchItem messages$PatchItem) {
        Object object = this.patchesBuilder_;
        if (object == null) {
            Objects.requireNonNull(messages$PatchItem);
            this.ensurePatchesIsMutable();
            object = this.patches_;
            object.set(n10, messages$PatchItem);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, messages$PatchItem);
        }
        return this;
    }

    public Messages$PatchCommand$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Messages$PatchCommand$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final Messages$PatchCommand$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$PatchCommand$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

