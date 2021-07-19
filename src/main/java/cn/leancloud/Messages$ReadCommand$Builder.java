/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$ReadCommand;
import cn.leancloud.Messages$ReadCommandOrBuilder;
import cn.leancloud.Messages$ReadTuple;
import cn.leancloud.Messages$ReadTuple$Builder;
import cn.leancloud.Messages$ReadTupleOrBuilder;
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

public final class Messages$ReadCommand$Builder
extends GeneratedMessageV3$Builder
implements Messages$ReadCommandOrBuilder {
    private int bitField0_;
    private Object cid_ = "";
    private LazyStringList cids_;
    private RepeatedFieldBuilderV3 convsBuilder_;
    private List convs_;

    private Messages$ReadCommand$Builder() {
        List list;
        this.cids_ = list = LazyStringArrayList.EMPTY;
        list = Collections.emptyList();
        this.convs_ = list;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$ReadCommand$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$ReadCommand$Builder(GeneratedMessageV3$BuilderParent list) {
        super((GeneratedMessageV3$BuilderParent)((Object)list));
        list = LazyStringArrayList.EMPTY;
        this.cids_ = list;
        this.convs_ = list = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$ReadCommand$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
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

    private void ensureConvsIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 4;
        if ((n10 &= n11) != n11) {
            ArrayList arrayList;
            List list = this.convs_;
            this.convs_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    /*
     * WARNING - void declaration
     */
    private RepeatedFieldBuilderV3 getConvsFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.convsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            void var3_7;
            List list = this.convs_;
            int bl2 = this.bitField0_;
            int n10 = 4;
            int n11 = bl2 & n10;
            if (n11 == n10) {
                boolean bl3 = true;
            } else {
                boolean bl4 = false;
            }
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl5 = this.isClean();
            this.convsBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, (boolean)var3_7, generatedMessageV3$BuilderParent, bl5);
            repeatedFieldBuilderV3 = null;
            this.convs_ = null;
        }
        return this.convsBuilder_;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$36400();
    }

    private void maybeForceBuilderInitialization() {
        boolean bl2 = Messages$ReadCommand.access$36800();
        if (bl2) {
            this.getConvsFieldBuilder();
        }
    }

    public Messages$ReadCommand$Builder addAllCids(Iterable iterable) {
        this.ensureCidsIsMutable();
        LazyStringList lazyStringList = this.cids_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public Messages$ReadCommand$Builder addAllConvs(Iterable iterable) {
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

    public Messages$ReadCommand$Builder addCids(String string2) {
        Objects.requireNonNull(string2);
        this.ensureCidsIsMutable();
        this.cids_.add(string2);
        this.onChanged();
        return this;
    }

    public Messages$ReadCommand$Builder addCidsBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensureCidsIsMutable();
        this.cids_.add(byteString);
        this.onChanged();
        return this;
    }

    public Messages$ReadCommand$Builder addConvs(int n10, Messages$ReadTuple$Builder messages$ReadTupleOrBuilder) {
        Object object = this.convsBuilder_;
        if (object == null) {
            this.ensureConvsIsMutable();
            object = this.convs_;
            messages$ReadTupleOrBuilder = ((Messages$ReadTuple$Builder)messages$ReadTupleOrBuilder).build();
            object.add(n10, messages$ReadTupleOrBuilder);
            this.onChanged();
        } else {
            messages$ReadTupleOrBuilder = ((Messages$ReadTuple$Builder)messages$ReadTupleOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)((Object)messages$ReadTupleOrBuilder));
        }
        return this;
    }

    public Messages$ReadCommand$Builder addConvs(int n10, Messages$ReadTuple messages$ReadTuple) {
        Object object = this.convsBuilder_;
        if (object == null) {
            Objects.requireNonNull(messages$ReadTuple);
            this.ensureConvsIsMutable();
            object = this.convs_;
            object.add(n10, messages$ReadTuple);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, messages$ReadTuple);
        }
        return this;
    }

    public Messages$ReadCommand$Builder addConvs(Messages$ReadTuple$Builder messages$ReadTupleOrBuilder) {
        Object object = this.convsBuilder_;
        if (object == null) {
            this.ensureConvsIsMutable();
            object = this.convs_;
            messages$ReadTupleOrBuilder = ((Messages$ReadTuple$Builder)messages$ReadTupleOrBuilder).build();
            object.add(messages$ReadTupleOrBuilder);
            this.onChanged();
        } else {
            messages$ReadTupleOrBuilder = ((Messages$ReadTuple$Builder)messages$ReadTupleOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)((Object)messages$ReadTupleOrBuilder));
        }
        return this;
    }

    public Messages$ReadCommand$Builder addConvs(Messages$ReadTuple messages$ReadTuple) {
        Object object = this.convsBuilder_;
        if (object == null) {
            Objects.requireNonNull(messages$ReadTuple);
            this.ensureConvsIsMutable();
            object = this.convs_;
            object.add(messages$ReadTuple);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(messages$ReadTuple);
        }
        return this;
    }

    public Messages$ReadTuple$Builder addConvsBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getConvsFieldBuilder();
        Messages$ReadTuple messages$ReadTuple = Messages$ReadTuple.getDefaultInstance();
        return (Messages$ReadTuple$Builder)repeatedFieldBuilderV3.addBuilder(messages$ReadTuple);
    }

    public Messages$ReadTuple$Builder addConvsBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getConvsFieldBuilder();
        Messages$ReadTuple messages$ReadTuple = Messages$ReadTuple.getDefaultInstance();
        return (Messages$ReadTuple$Builder)repeatedFieldBuilderV3.addBuilder(n10, messages$ReadTuple);
    }

    public Messages$ReadCommand$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$ReadCommand$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Messages$ReadCommand build() {
        Messages$ReadCommand messages$ReadCommand = this.buildPartial();
        boolean bl2 = messages$ReadCommand.isInitialized();
        if (bl2) {
            return messages$ReadCommand;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$ReadCommand);
    }

    public Messages$ReadCommand buildPartial() {
        List list = null;
        Messages$ReadCommand messages$ReadCommand = new Messages$ReadCommand(this, null);
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) != n11) {
            n11 = 0;
        }
        list = this.cid_;
        Messages$ReadCommand.access$37002(messages$ReadCommand, list);
        n10 = this.bitField0_;
        int n12 = 2;
        if ((n10 &= n12) == n12) {
            list = this.cids_.getUnmodifiableView();
            this.cids_ = list;
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        }
        list = this.cids_;
        Messages$ReadCommand.access$37102(messages$ReadCommand, (LazyStringList)list);
        list = this.convsBuilder_;
        if (list == null) {
            n10 = this.bitField0_;
            n12 = 4;
            if ((n10 &= n12) == n12) {
                this.convs_ = list = Collections.unmodifiableList(this.convs_);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
            }
            list = this.convs_;
            Messages$ReadCommand.access$37202(messages$ReadCommand, list);
        } else {
            list = ((RepeatedFieldBuilderV3)((Object)list)).build();
            Messages$ReadCommand.access$37202(messages$ReadCommand, list);
        }
        Messages$ReadCommand.access$37302(messages$ReadCommand, n11);
        this.onBuilt();
        return messages$ReadCommand;
    }

    public Messages$ReadCommand$Builder clear() {
        LazyStringList lazyStringList;
        int n10;
        super.clear();
        this.cid_ = "";
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.cids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 &= 0xFFFFFFFD;
        Object object = this.convsBuilder_;
        if (object == null) {
            this.convs_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public Messages$ReadCommand$Builder clearCid() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = Messages$ReadCommand.getDefaultInstance().getCid();
        this.cid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ReadCommand$Builder clearCids() {
        int n10;
        LazyStringList lazyStringList;
        this.cids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.onChanged();
        return this;
    }

    public Messages$ReadCommand$Builder clearConvs() {
        Object object = this.convsBuilder_;
        if (object == null) {
            int n10;
            this.convs_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public Messages$ReadCommand$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Messages$ReadCommand$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Messages$ReadCommand$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Messages$ReadCommand$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Messages$ReadCommand$Builder clone() {
        return (Messages$ReadCommand$Builder)super.clone();
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

    public Messages$ReadTuple getConvs(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.convsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (Messages$ReadTuple)this.convs_.get(n10);
        }
        return (Messages$ReadTuple)repeatedFieldBuilderV3.getMessage(n10);
    }

    public Messages$ReadTuple$Builder getConvsBuilder(int n10) {
        return (Messages$ReadTuple$Builder)this.getConvsFieldBuilder().getBuilder(n10);
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

    public Messages$ReadTupleOrBuilder getConvsOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.convsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (Messages$ReadTupleOrBuilder)this.convs_.get(n10);
        }
        return (Messages$ReadTupleOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getConvsOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.convsBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.convs_);
    }

    public Messages$ReadCommand getDefaultInstanceForType() {
        return Messages$ReadCommand.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$36400();
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

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$36500().ensureFieldAccessorsInitialized(Messages$ReadCommand.class, Messages$ReadCommand$Builder.class);
    }

    public final boolean isInitialized() {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.getConvsCount()); ++i10) {
            Messages$ReadTuple messages$ReadTuple = this.getConvs(i10);
            n10 = (int)(messages$ReadTuple.isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        return true;
    }

    public Messages$ReadCommand$Builder mergeFrom(Messages$ReadCommand messageLite) {
        List list;
        Object object = Messages$ReadCommand.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasCid();
        if (n10 != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 1;
            this.cid_ = object = Messages$ReadCommand.access$37000(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)((object = Messages$ReadCommand.access$37100(messageLite)).isEmpty() ? 1 : 0)) == 0) {
            object = this.cids_;
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 != 0) {
                this.cids_ = object = Messages$ReadCommand.access$37100(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
            } else {
                this.ensureCidsIsMutable();
                object = this.cids_;
                list = Messages$ReadCommand.access$37100(messageLite);
                object.addAll(list);
            }
            this.onChanged();
        }
        if ((object = this.convsBuilder_) == null) {
            object = Messages$ReadCommand.access$37200(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.convs_;
                n10 = (int)(object.isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.convs_ = object = Messages$ReadCommand.access$37200(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
                } else {
                    this.ensureConvsIsMutable();
                    object = this.convs_;
                    list = Messages$ReadCommand.access$37200(messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = Messages$ReadCommand.access$37200(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.convsBuilder_;
                n10 = (int)(((RepeatedFieldBuilderV3)object).isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    int n11;
                    this.convsBuilder_.dispose();
                    n10 = 0;
                    object = null;
                    this.convsBuilder_ = null;
                    list = Messages$ReadCommand.access$37200(messageLite);
                    this.convs_ = list;
                    this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFB;
                    n11 = (int)(Messages$ReadCommand.access$37400() ? 1 : 0);
                    if (n11 != 0) {
                        object = this.getConvsFieldBuilder();
                    }
                    this.convsBuilder_ = object;
                } else {
                    object = this.convsBuilder_;
                    list = Messages$ReadCommand.access$37200(messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        messageLite = Messages$ReadCommand.access$37500(messageLite);
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
    public Messages$ReadCommand$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$ReadCommand.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$ReadCommand)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$ReadCommand)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$ReadCommand)object2;
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
            this.mergeFrom((Messages$ReadCommand)object3);
        }
        throw var1_6;
    }

    public Messages$ReadCommand$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$ReadCommand;
        if (bl2) {
            message = (Messages$ReadCommand)message;
            return this.mergeFrom((Messages$ReadCommand)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Messages$ReadCommand$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$ReadCommand$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$ReadCommand$Builder removeConvs(int n10) {
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

    public Messages$ReadCommand$Builder setCid(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.cid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ReadCommand$Builder setCidBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.cid_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$ReadCommand$Builder setCids(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureCidsIsMutable();
        this.cids_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public Messages$ReadCommand$Builder setConvs(int n10, Messages$ReadTuple$Builder messages$ReadTupleOrBuilder) {
        Object object = this.convsBuilder_;
        if (object == null) {
            this.ensureConvsIsMutable();
            object = this.convs_;
            messages$ReadTupleOrBuilder = ((Messages$ReadTuple$Builder)messages$ReadTupleOrBuilder).build();
            object.set(n10, messages$ReadTupleOrBuilder);
            this.onChanged();
        } else {
            messages$ReadTupleOrBuilder = ((Messages$ReadTuple$Builder)messages$ReadTupleOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)((Object)messages$ReadTupleOrBuilder));
        }
        return this;
    }

    public Messages$ReadCommand$Builder setConvs(int n10, Messages$ReadTuple messages$ReadTuple) {
        Object object = this.convsBuilder_;
        if (object == null) {
            Objects.requireNonNull(messages$ReadTuple);
            this.ensureConvsIsMutable();
            object = this.convs_;
            object.set(n10, messages$ReadTuple);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, messages$ReadTuple);
        }
        return this;
    }

    public Messages$ReadCommand$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$ReadCommand$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Messages$ReadCommand$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Messages$ReadCommand$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public final Messages$ReadCommand$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$ReadCommand$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

