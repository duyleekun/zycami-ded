/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$ConvCommand;
import cn.leancloud.Messages$ConvCommandOrBuilder;
import cn.leancloud.Messages$ConvMemberInfo;
import cn.leancloud.Messages$ConvMemberInfo$Builder;
import cn.leancloud.Messages$ConvMemberInfoOrBuilder;
import cn.leancloud.Messages$ErrorCommand;
import cn.leancloud.Messages$ErrorCommand$Builder;
import cn.leancloud.Messages$ErrorCommandOrBuilder;
import cn.leancloud.Messages$JsonObjectMessage;
import cn.leancloud.Messages$JsonObjectMessage$Builder;
import cn.leancloud.Messages$JsonObjectMessageOrBuilder;
import cn.leancloud.Messages$MaxReadTuple;
import cn.leancloud.Messages$MaxReadTuple$Builder;
import cn.leancloud.Messages$MaxReadTupleOrBuilder;
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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Messages$ConvCommand$Builder
extends GeneratedMessageV3$Builder
implements Messages$ConvCommandOrBuilder {
    private LazyStringList allowedPids_;
    private SingleFieldBuilderV3 attrBuilder_;
    private SingleFieldBuilderV3 attrModifiedBuilder_;
    private Messages$JsonObjectMessage attrModified_;
    private Messages$JsonObjectMessage attr_;
    private int bitField0_;
    private int bitField1_;
    private Object cdate_;
    private Object cid_;
    private LazyStringList cids_;
    private int count_;
    private boolean existing_;
    private RepeatedFieldBuilderV3 failedPidsBuilder_;
    private List failedPids_;
    private int flag_;
    private SingleFieldBuilderV3 infoBuilder_;
    private Messages$ConvMemberInfo info_;
    private Object initBy_;
    private int limit_;
    private LazyStringList m_;
    private long maxAckTimestamp_;
    private long maxReadTimestamp_;
    private RepeatedFieldBuilderV3 maxReadTuplesBuilder_;
    private List maxReadTuples_;
    private Object n_;
    private Object next_;
    private boolean queryAllMembers_;
    private SingleFieldBuilderV3 resultsBuilder_;
    private Messages$JsonObjectMessage results_;
    private Object s_;
    private int skip_;
    private Object sort_;
    private boolean statusPub_;
    private boolean statusSub_;
    private int statusTTL_;
    private long t_;
    private Object targetClientId_;
    private LazyStringList tempConvIds_;
    private int tempConvTTL_;
    private boolean tempConv_;
    private boolean transient_;
    private Object udate_;
    private Object uniqueId_;
    private boolean unique_;
    private SingleFieldBuilderV3 whereBuilder_;
    private Messages$JsonObjectMessage where_;

    private Messages$ConvCommand$Builder() {
        List list;
        List list2;
        this.m_ = list2 = LazyStringArrayList.EMPTY;
        String string2 = "";
        this.cid_ = string2;
        this.cdate_ = string2;
        this.initBy_ = string2;
        this.sort_ = string2;
        this.udate_ = string2;
        this.n_ = string2;
        this.s_ = string2;
        this.uniqueId_ = string2;
        this.targetClientId_ = string2;
        this.maxReadTuples_ = list = Collections.emptyList();
        this.cids_ = list2;
        this.info_ = null;
        this.tempConvIds_ = list2;
        this.allowedPids_ = list2;
        list2 = Collections.emptyList();
        this.failedPids_ = list2;
        this.next_ = string2;
        this.results_ = null;
        this.where_ = null;
        this.attr_ = null;
        this.attrModified_ = null;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$ConvCommand$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$ConvCommand$Builder(GeneratedMessageV3$BuilderParent list) {
        super((GeneratedMessageV3$BuilderParent)((Object)list));
        List list2;
        list = LazyStringArrayList.EMPTY;
        this.m_ = list;
        String string2 = "";
        this.cid_ = string2;
        this.cdate_ = string2;
        this.initBy_ = string2;
        this.sort_ = string2;
        this.udate_ = string2;
        this.n_ = string2;
        this.s_ = string2;
        this.uniqueId_ = string2;
        this.targetClientId_ = string2;
        this.maxReadTuples_ = list2 = Collections.emptyList();
        this.cids_ = list;
        this.info_ = null;
        this.tempConvIds_ = list;
        this.allowedPids_ = list;
        this.failedPids_ = list = Collections.emptyList();
        this.next_ = string2;
        this.results_ = null;
        this.where_ = null;
        this.attr_ = null;
        this.attrModified_ = null;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$ConvCommand$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureAllowedPidsIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 0x20000000;
        if ((n10 &= n11) != n11) {
            LazyStringList lazyStringList = this.allowedPids_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.allowedPids_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    private void ensureCidsIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 0x1000000;
        if ((n10 &= n11) != n11) {
            LazyStringList lazyStringList = this.cids_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.cids_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    private void ensureFailedPidsIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 0x40000000;
        if ((n10 &= n11) != n11) {
            ArrayList arrayList;
            List list = this.failedPids_;
            this.failedPids_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    private void ensureMIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) != n11) {
            LazyStringList lazyStringList = this.m_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.m_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    private void ensureMaxReadTuplesIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 0x800000;
        if ((n10 &= n11) != n11) {
            ArrayList arrayList;
            List list = this.maxReadTuples_;
            this.maxReadTuples_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    private void ensureTempConvIdsIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 0x10000000;
        if ((n10 &= n11) != n11) {
            LazyStringList lazyStringList = this.tempConvIds_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.tempConvIds_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    private SingleFieldBuilderV3 getAttrFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.attrBuilder_;
        if (singleFieldBuilderV3 == null) {
            Messages$JsonObjectMessage messages$JsonObjectMessage = this.getAttr();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.attrBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(messages$JsonObjectMessage, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.attr_ = null;
        }
        return this.attrBuilder_;
    }

    private SingleFieldBuilderV3 getAttrModifiedFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.attrModifiedBuilder_;
        if (singleFieldBuilderV3 == null) {
            Messages$JsonObjectMessage messages$JsonObjectMessage = this.getAttrModified();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.attrModifiedBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(messages$JsonObjectMessage, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.attrModified_ = null;
        }
        return this.attrModifiedBuilder_;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$23800();
    }

    /*
     * WARNING - void declaration
     */
    private RepeatedFieldBuilderV3 getFailedPidsFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.failedPidsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            void var3_7;
            List list = this.failedPids_;
            int bl2 = this.bitField0_;
            int n10 = 0x40000000;
            int n11 = bl2 & n10;
            if (n11 == n10) {
                boolean bl3 = true;
            } else {
                boolean bl4 = false;
            }
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl5 = this.isClean();
            this.failedPidsBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, (boolean)var3_7, generatedMessageV3$BuilderParent, bl5);
            repeatedFieldBuilderV3 = null;
            this.failedPids_ = null;
        }
        return this.failedPidsBuilder_;
    }

    private SingleFieldBuilderV3 getInfoFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.infoBuilder_;
        if (singleFieldBuilderV3 == null) {
            Messages$ConvMemberInfo messages$ConvMemberInfo = this.getInfo();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.infoBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(messages$ConvMemberInfo, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.info_ = null;
        }
        return this.infoBuilder_;
    }

    /*
     * WARNING - void declaration
     */
    private RepeatedFieldBuilderV3 getMaxReadTuplesFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.maxReadTuplesBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            void var3_7;
            List list = this.maxReadTuples_;
            int bl2 = this.bitField0_;
            int n10 = 0x800000;
            int n11 = bl2 & n10;
            if (n11 == n10) {
                boolean bl3 = true;
            } else {
                boolean bl4 = false;
            }
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl5 = this.isClean();
            this.maxReadTuplesBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, (boolean)var3_7, generatedMessageV3$BuilderParent, bl5);
            repeatedFieldBuilderV3 = null;
            this.maxReadTuples_ = null;
        }
        return this.maxReadTuplesBuilder_;
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

    private SingleFieldBuilderV3 getWhereFieldBuilder() {
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.whereBuilder_;
        if (singleFieldBuilderV3 == null) {
            Messages$JsonObjectMessage messages$JsonObjectMessage = this.getWhere();
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl2 = this.isClean();
            this.whereBuilder_ = singleFieldBuilderV3 = new SingleFieldBuilderV3(messages$JsonObjectMessage, generatedMessageV3$BuilderParent, bl2);
            singleFieldBuilderV3 = null;
            this.where_ = null;
        }
        return this.whereBuilder_;
    }

    private void maybeForceBuilderInitialization() {
        boolean bl2 = Messages$ConvCommand.access$24200();
        if (bl2) {
            this.getMaxReadTuplesFieldBuilder();
            this.getInfoFieldBuilder();
            this.getFailedPidsFieldBuilder();
            this.getResultsFieldBuilder();
            this.getWhereFieldBuilder();
            this.getAttrFieldBuilder();
            this.getAttrModifiedFieldBuilder();
        }
    }

    public Messages$ConvCommand$Builder addAllAllowedPids(Iterable iterable) {
        this.ensureAllowedPidsIsMutable();
        LazyStringList lazyStringList = this.allowedPids_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder addAllCids(Iterable iterable) {
        this.ensureCidsIsMutable();
        LazyStringList lazyStringList = this.cids_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder addAllFailedPids(Iterable iterable) {
        Object object = this.failedPidsBuilder_;
        if (object == null) {
            this.ensureFailedPidsIsMutable();
            object = this.failedPids_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public Messages$ConvCommand$Builder addAllM(Iterable iterable) {
        this.ensureMIsMutable();
        LazyStringList lazyStringList = this.m_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder addAllMaxReadTuples(Iterable iterable) {
        Object object = this.maxReadTuplesBuilder_;
        if (object == null) {
            this.ensureMaxReadTuplesIsMutable();
            object = this.maxReadTuples_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public Messages$ConvCommand$Builder addAllTempConvIds(Iterable iterable) {
        this.ensureTempConvIdsIsMutable();
        LazyStringList lazyStringList = this.tempConvIds_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder addAllowedPids(String string2) {
        Objects.requireNonNull(string2);
        this.ensureAllowedPidsIsMutable();
        this.allowedPids_.add(string2);
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder addAllowedPidsBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensureAllowedPidsIsMutable();
        this.allowedPids_.add(byteString);
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder addCids(String string2) {
        Objects.requireNonNull(string2);
        this.ensureCidsIsMutable();
        this.cids_.add(string2);
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder addCidsBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensureCidsIsMutable();
        this.cids_.add(byteString);
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder addFailedPids(int n10, Messages$ErrorCommand$Builder messages$ErrorCommandOrBuilder) {
        Object object = this.failedPidsBuilder_;
        if (object == null) {
            this.ensureFailedPidsIsMutable();
            object = this.failedPids_;
            messages$ErrorCommandOrBuilder = ((Messages$ErrorCommand$Builder)messages$ErrorCommandOrBuilder).build();
            object.add(n10, messages$ErrorCommandOrBuilder);
            this.onChanged();
        } else {
            messages$ErrorCommandOrBuilder = ((Messages$ErrorCommand$Builder)messages$ErrorCommandOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)((Object)messages$ErrorCommandOrBuilder));
        }
        return this;
    }

    public Messages$ConvCommand$Builder addFailedPids(int n10, Messages$ErrorCommand messages$ErrorCommand) {
        Object object = this.failedPidsBuilder_;
        if (object == null) {
            Objects.requireNonNull(messages$ErrorCommand);
            this.ensureFailedPidsIsMutable();
            object = this.failedPids_;
            object.add(n10, messages$ErrorCommand);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, messages$ErrorCommand);
        }
        return this;
    }

    public Messages$ConvCommand$Builder addFailedPids(Messages$ErrorCommand$Builder messages$ErrorCommandOrBuilder) {
        Object object = this.failedPidsBuilder_;
        if (object == null) {
            this.ensureFailedPidsIsMutable();
            object = this.failedPids_;
            messages$ErrorCommandOrBuilder = ((Messages$ErrorCommand$Builder)messages$ErrorCommandOrBuilder).build();
            object.add(messages$ErrorCommandOrBuilder);
            this.onChanged();
        } else {
            messages$ErrorCommandOrBuilder = ((Messages$ErrorCommand$Builder)messages$ErrorCommandOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)((Object)messages$ErrorCommandOrBuilder));
        }
        return this;
    }

    public Messages$ConvCommand$Builder addFailedPids(Messages$ErrorCommand messages$ErrorCommand) {
        Object object = this.failedPidsBuilder_;
        if (object == null) {
            Objects.requireNonNull(messages$ErrorCommand);
            this.ensureFailedPidsIsMutable();
            object = this.failedPids_;
            object.add(messages$ErrorCommand);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(messages$ErrorCommand);
        }
        return this;
    }

    public Messages$ErrorCommand$Builder addFailedPidsBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getFailedPidsFieldBuilder();
        Messages$ErrorCommand messages$ErrorCommand = Messages$ErrorCommand.getDefaultInstance();
        return (Messages$ErrorCommand$Builder)repeatedFieldBuilderV3.addBuilder(messages$ErrorCommand);
    }

    public Messages$ErrorCommand$Builder addFailedPidsBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getFailedPidsFieldBuilder();
        Messages$ErrorCommand messages$ErrorCommand = Messages$ErrorCommand.getDefaultInstance();
        return (Messages$ErrorCommand$Builder)repeatedFieldBuilderV3.addBuilder(n10, messages$ErrorCommand);
    }

    public Messages$ConvCommand$Builder addM(String string2) {
        Objects.requireNonNull(string2);
        this.ensureMIsMutable();
        this.m_.add(string2);
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder addMBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensureMIsMutable();
        this.m_.add(byteString);
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder addMaxReadTuples(int n10, Messages$MaxReadTuple$Builder messages$MaxReadTupleOrBuilder) {
        Object object = this.maxReadTuplesBuilder_;
        if (object == null) {
            this.ensureMaxReadTuplesIsMutable();
            object = this.maxReadTuples_;
            messages$MaxReadTupleOrBuilder = ((Messages$MaxReadTuple$Builder)messages$MaxReadTupleOrBuilder).build();
            object.add(n10, messages$MaxReadTupleOrBuilder);
            this.onChanged();
        } else {
            messages$MaxReadTupleOrBuilder = ((Messages$MaxReadTuple$Builder)messages$MaxReadTupleOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)((Object)messages$MaxReadTupleOrBuilder));
        }
        return this;
    }

    public Messages$ConvCommand$Builder addMaxReadTuples(int n10, Messages$MaxReadTuple messages$MaxReadTuple) {
        Object object = this.maxReadTuplesBuilder_;
        if (object == null) {
            Objects.requireNonNull(messages$MaxReadTuple);
            this.ensureMaxReadTuplesIsMutable();
            object = this.maxReadTuples_;
            object.add(n10, messages$MaxReadTuple);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, messages$MaxReadTuple);
        }
        return this;
    }

    public Messages$ConvCommand$Builder addMaxReadTuples(Messages$MaxReadTuple$Builder messages$MaxReadTupleOrBuilder) {
        Object object = this.maxReadTuplesBuilder_;
        if (object == null) {
            this.ensureMaxReadTuplesIsMutable();
            object = this.maxReadTuples_;
            messages$MaxReadTupleOrBuilder = ((Messages$MaxReadTuple$Builder)messages$MaxReadTupleOrBuilder).build();
            object.add(messages$MaxReadTupleOrBuilder);
            this.onChanged();
        } else {
            messages$MaxReadTupleOrBuilder = ((Messages$MaxReadTuple$Builder)messages$MaxReadTupleOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)((Object)messages$MaxReadTupleOrBuilder));
        }
        return this;
    }

    public Messages$ConvCommand$Builder addMaxReadTuples(Messages$MaxReadTuple messages$MaxReadTuple) {
        Object object = this.maxReadTuplesBuilder_;
        if (object == null) {
            Objects.requireNonNull(messages$MaxReadTuple);
            this.ensureMaxReadTuplesIsMutable();
            object = this.maxReadTuples_;
            object.add(messages$MaxReadTuple);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(messages$MaxReadTuple);
        }
        return this;
    }

    public Messages$MaxReadTuple$Builder addMaxReadTuplesBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getMaxReadTuplesFieldBuilder();
        Messages$MaxReadTuple messages$MaxReadTuple = Messages$MaxReadTuple.getDefaultInstance();
        return (Messages$MaxReadTuple$Builder)repeatedFieldBuilderV3.addBuilder(messages$MaxReadTuple);
    }

    public Messages$MaxReadTuple$Builder addMaxReadTuplesBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getMaxReadTuplesFieldBuilder();
        Messages$MaxReadTuple messages$MaxReadTuple = Messages$MaxReadTuple.getDefaultInstance();
        return (Messages$MaxReadTuple$Builder)repeatedFieldBuilderV3.addBuilder(n10, messages$MaxReadTuple);
    }

    public Messages$ConvCommand$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$ConvCommand$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Messages$ConvCommand$Builder addTempConvIds(String string2) {
        Objects.requireNonNull(string2);
        this.ensureTempConvIdsIsMutable();
        this.tempConvIds_.add(string2);
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder addTempConvIdsBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensureTempConvIdsIsMutable();
        this.tempConvIds_.add(byteString);
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand build() {
        Messages$ConvCommand messages$ConvCommand = this.buildPartial();
        boolean bl2 = messages$ConvCommand.isInitialized();
        if (bl2) {
            return messages$ConvCommand;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$ConvCommand);
    }

    public Messages$ConvCommand buildPartial() {
        LazyStringList lazyStringList;
        Object object = null;
        Messages$ConvCommand messages$ConvCommand = new Messages$ConvCommand(this, null);
        int n10 = this.bitField0_;
        int n11 = this.bitField1_;
        int n12 = n10 & 1;
        int n13 = 1;
        if (n12 == n13) {
            this.m_ = lazyStringList = this.m_.getUnmodifiableView();
            this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFFFE;
        }
        lazyStringList = this.m_;
        Messages$ConvCommand.access$24402(messages$ConvCommand, lazyStringList);
        n12 = n10 & 2;
        int n14 = 2;
        if (n12 == n14) {
            n12 = n13;
        } else {
            n12 = 0;
            lazyStringList = null;
        }
        int n15 = this.transient_;
        Messages$ConvCommand.access$24502(messages$ConvCommand, n15 != 0);
        n15 = n10 & 4;
        int n16 = 4;
        if (n15 == n16) {
            n12 |= 2;
        }
        n15 = (int)(this.unique_ ? 1 : 0);
        Messages$ConvCommand.access$24602(messages$ConvCommand, n15 != 0);
        n15 = n10 & 8;
        int n17 = 8;
        if (n15 == n17) {
            n12 |= 4;
        }
        List list = this.cid_;
        Messages$ConvCommand.access$24702(messages$ConvCommand, list);
        n15 = n10 & 0x10;
        int n18 = 16;
        if (n15 == n18) {
            n12 |= 8;
        }
        list = this.cdate_;
        Messages$ConvCommand.access$24802(messages$ConvCommand, list);
        n15 = n10 & 0x20;
        int n19 = 32;
        if (n15 == n19) {
            n12 |= 0x10;
        }
        list = this.initBy_;
        Messages$ConvCommand.access$24902(messages$ConvCommand, list);
        n15 = n10 & 0x40;
        n19 = 64;
        if (n15 == n19) {
            n12 |= 0x20;
        }
        list = this.sort_;
        Messages$ConvCommand.access$25002(messages$ConvCommand, list);
        n15 = n10 & 0x80;
        n19 = 128;
        if (n15 == n19) {
            n12 |= 0x40;
        }
        n15 = this.limit_;
        Messages$ConvCommand.access$25102(messages$ConvCommand, n15);
        n15 = n10 & 0x100;
        n19 = 256;
        if (n15 == n19) {
            n12 |= 0x80;
        }
        n15 = this.skip_;
        Messages$ConvCommand.access$25202(messages$ConvCommand, n15);
        n15 = n10 & 0x200;
        n19 = 512;
        if (n15 == n19) {
            n12 |= 0x100;
        }
        n15 = this.flag_;
        Messages$ConvCommand.access$25302(messages$ConvCommand, n15);
        n15 = n10 & 0x400;
        n19 = 1024;
        if (n15 == n19) {
            n12 |= 0x200;
        }
        n15 = this.count_;
        Messages$ConvCommand.access$25402(messages$ConvCommand, n15);
        n15 = n10 & 0x800;
        n19 = 2048;
        if (n15 == n19) {
            n12 |= 0x400;
        }
        list = this.udate_;
        Messages$ConvCommand.access$25502(messages$ConvCommand, list);
        n15 = n10 & 0x1000;
        n19 = 4096;
        if (n15 == n19) {
            n12 |= 0x800;
        }
        long l10 = this.t_;
        Messages$ConvCommand.access$25602(messages$ConvCommand, l10);
        n15 = n10 & 0x2000;
        n19 = 8192;
        if (n15 == n19) {
            n12 |= 0x1000;
        }
        list = this.n_;
        Messages$ConvCommand.access$25702(messages$ConvCommand, list);
        n15 = n10 & 0x4000;
        n19 = 16384;
        if (n15 == n19) {
            n12 |= 0x2000;
        }
        list = this.s_;
        Messages$ConvCommand.access$25802(messages$ConvCommand, list);
        n15 = 32768;
        n19 = n10 & n15;
        if (n19 == n15) {
            n12 |= 0x4000;
        }
        n19 = (int)(this.statusSub_ ? 1 : 0);
        Messages$ConvCommand.access$25902(messages$ConvCommand, n19 != 0);
        n19 = 65536;
        int n20 = n10 & n19;
        if (n20 == n19) {
            n12 |= n15;
        }
        n15 = (int)(this.statusPub_ ? 1 : 0);
        Messages$ConvCommand.access$26002(messages$ConvCommand, n15 != 0);
        n15 = 131072;
        n20 = n10 & n15;
        if (n20 == n15) {
            n12 |= n19;
        }
        n19 = this.statusTTL_;
        Messages$ConvCommand.access$26102(messages$ConvCommand, n19);
        n19 = 262144;
        n20 = n10 & n19;
        if (n20 == n19) {
            n12 |= n15;
        }
        list = this.uniqueId_;
        Messages$ConvCommand.access$26202(messages$ConvCommand, list);
        n15 = 524288;
        n20 = n10 & n15;
        if (n20 == n15) {
            n12 |= n19;
        }
        Object object2 = this.targetClientId_;
        Messages$ConvCommand.access$26302(messages$ConvCommand, object2);
        n19 = 0x100000;
        n20 = n10 & n19;
        if (n20 == n19) {
            n12 |= n15;
        }
        long l11 = this.maxReadTimestamp_;
        Messages$ConvCommand.access$26402(messages$ConvCommand, l11);
        n15 = 0x200000;
        n20 = n10 & n15;
        if (n20 == n15) {
            n12 |= n19;
        }
        l10 = this.maxAckTimestamp_;
        Messages$ConvCommand.access$26502(messages$ConvCommand, l10);
        n19 = 0x400000 & n10;
        n20 = 0x400000;
        if (n19 == n20) {
            n12 |= n15;
        }
        n15 = (int)(this.queryAllMembers_ ? 1 : 0);
        Messages$ConvCommand.access$26602(messages$ConvCommand, n15 != 0);
        list = this.maxReadTuplesBuilder_;
        if (list == null) {
            n15 = this.bitField0_;
            n19 = 0x800000;
            if ((n15 &= n19) == n19) {
                list = Collections.unmodifiableList(this.maxReadTuples_);
                this.maxReadTuples_ = list;
                n15 = this.bitField0_;
                n19 = -8388609;
                this.bitField0_ = n15 &= n19;
            }
            list = this.maxReadTuples_;
            Messages$ConvCommand.access$26702(messages$ConvCommand, list);
        } else {
            list = ((RepeatedFieldBuilderV3)((Object)list)).build();
            Messages$ConvCommand.access$26702(messages$ConvCommand, list);
        }
        n15 = this.bitField0_;
        n19 = 0x1000000;
        if ((n15 &= n19) == n19) {
            list = this.cids_.getUnmodifiableView();
            this.cids_ = list;
            n15 = this.bitField0_;
            n19 = -16777217;
            this.bitField0_ = n15 &= n19;
        }
        list = this.cids_;
        Messages$ConvCommand.access$26802(messages$ConvCommand, (LazyStringList)list);
        n15 = 0x2000000 & n10;
        n19 = 0x2000000;
        if (n15 == n19) {
            n15 = 0x400000;
            n12 |= n15;
        }
        if ((list = this.infoBuilder_) == null) {
            list = this.info_;
            Messages$ConvCommand.access$26902(messages$ConvCommand, (Messages$ConvMemberInfo)((Object)list));
        } else {
            list = (Messages$ConvMemberInfo)((SingleFieldBuilderV3)((Object)list)).build();
            Messages$ConvCommand.access$26902(messages$ConvCommand, (Messages$ConvMemberInfo)((Object)list));
        }
        n15 = 0x4000000 & n10;
        n19 = 0x4000000;
        if (n15 == n19) {
            n15 = 0x800000;
            n12 |= n15;
        }
        n15 = (int)(this.tempConv_ ? 1 : 0);
        Messages$ConvCommand.access$27002(messages$ConvCommand, n15 != 0);
        n15 = 0x8000000 & n10;
        n19 = 0x8000000;
        if (n15 == n19) {
            n15 = 0x1000000;
            n12 |= n15;
        }
        n15 = this.tempConvTTL_;
        Messages$ConvCommand.access$27102(messages$ConvCommand, n15);
        n15 = this.bitField0_;
        n19 = 0x10000000;
        if ((n15 &= n19) == n19) {
            list = this.tempConvIds_.getUnmodifiableView();
            this.tempConvIds_ = list;
            n15 = this.bitField0_;
            n19 = -268435457;
            this.bitField0_ = n15 &= n19;
        }
        list = this.tempConvIds_;
        Messages$ConvCommand.access$27202(messages$ConvCommand, (LazyStringList)list);
        n15 = this.bitField0_;
        n19 = 0x20000000;
        if ((n15 &= n19) == n19) {
            list = this.allowedPids_.getUnmodifiableView();
            this.allowedPids_ = list;
            n15 = this.bitField0_;
            n19 = -536870913;
            this.bitField0_ = n15 &= n19;
        }
        list = this.allowedPids_;
        Messages$ConvCommand.access$27302(messages$ConvCommand, (LazyStringList)list);
        list = this.failedPidsBuilder_;
        if (list == null) {
            n15 = this.bitField0_;
            n19 = 0x40000000;
            if ((n15 &= n19) == n19) {
                this.failedPids_ = list = Collections.unmodifiableList(this.failedPids_);
                n15 = this.bitField0_;
                n19 = -1073741825;
                this.bitField0_ = n15 &= n19;
            }
            list = this.failedPids_;
            Messages$ConvCommand.access$27402(messages$ConvCommand, list);
        } else {
            list = ((RepeatedFieldBuilderV3)((Object)list)).build();
            Messages$ConvCommand.access$27402(messages$ConvCommand, list);
        }
        n15 = -1 << -1;
        if ((n10 &= n15) == n15) {
            n10 = 0x2000000;
            n12 |= n10;
        }
        n10 = (int)(this.existing_ ? 1 : 0);
        Messages$ConvCommand.access$27502(messages$ConvCommand, n10 != 0);
        n10 = n11 & 1;
        if (n10 == n13) {
            n10 = 0x4000000;
            n12 |= n10;
        }
        object = this.next_;
        Messages$ConvCommand.access$27602(messages$ConvCommand, object);
        n10 = n11 & 2;
        if (n10 == n14) {
            n10 = 0x8000000;
            n12 |= n10;
        }
        if ((object = this.resultsBuilder_) == null) {
            object = this.results_;
            Messages$ConvCommand.access$27702(messages$ConvCommand, (Messages$JsonObjectMessage)object);
        } else {
            object = (Messages$JsonObjectMessage)((SingleFieldBuilderV3)object).build();
            Messages$ConvCommand.access$27702(messages$ConvCommand, (Messages$JsonObjectMessage)object);
        }
        n10 = n11 & 4;
        if (n10 == n16) {
            n10 = 0x10000000;
            n12 |= n10;
        }
        if ((object = this.whereBuilder_) == null) {
            object = this.where_;
            Messages$ConvCommand.access$27802(messages$ConvCommand, (Messages$JsonObjectMessage)object);
        } else {
            object = (Messages$JsonObjectMessage)((SingleFieldBuilderV3)object).build();
            Messages$ConvCommand.access$27802(messages$ConvCommand, (Messages$JsonObjectMessage)object);
        }
        n10 = n11 & 8;
        if (n10 == n17) {
            n10 = 0x20000000;
            n12 |= n10;
        }
        if ((object = this.attrBuilder_) == null) {
            object = this.attr_;
            Messages$ConvCommand.access$27902(messages$ConvCommand, (Messages$JsonObjectMessage)object);
        } else {
            object = (Messages$JsonObjectMessage)((SingleFieldBuilderV3)object).build();
            Messages$ConvCommand.access$27902(messages$ConvCommand, (Messages$JsonObjectMessage)object);
        }
        n10 = n11 & 0x10;
        if (n10 == n18) {
            n10 = 0x40000000;
            n12 |= n10;
        }
        if ((object = this.attrModifiedBuilder_) == null) {
            object = this.attrModified_;
            Messages$ConvCommand.access$28002(messages$ConvCommand, (Messages$JsonObjectMessage)object);
        } else {
            object = (Messages$JsonObjectMessage)((SingleFieldBuilderV3)object).build();
            Messages$ConvCommand.access$28002(messages$ConvCommand, (Messages$JsonObjectMessage)object);
        }
        Messages$ConvCommand.access$28102(messages$ConvCommand, n12);
        this.onBuilt();
        return messages$ConvCommand;
    }

    public Messages$ConvCommand$Builder clear() {
        int n10;
        long l10;
        int n11;
        super.clear();
        Object object = LazyStringArrayList.EMPTY;
        this.m_ = object;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        this.transient_ = false;
        this.bitField0_ = n11 &= 0xFFFFFFFD;
        this.unique_ = false;
        this.bitField0_ = n11 &= 0xFFFFFFFB;
        String string2 = "";
        this.cid_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFF7;
        this.cdate_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFEF;
        this.initBy_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFDF;
        this.sort_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFBF;
        this.limit_ = 0;
        this.bitField0_ = n11 &= 0xFFFFFF7F;
        this.skip_ = 0;
        this.bitField0_ = n11 &= 0xFFFFFEFF;
        this.flag_ = 0;
        this.bitField0_ = n11 &= 0xFFFFFDFF;
        this.count_ = 0;
        this.bitField0_ = n11 &= 0xFFFFFBFF;
        this.udate_ = string2;
        this.bitField0_ = n11 &= 0xFFFFF7FF;
        this.t_ = l10 = 0L;
        this.bitField0_ = n11 &= 0xFFFFEFFF;
        this.n_ = string2;
        this.bitField0_ = n11 &= 0xFFFFDFFF;
        this.s_ = string2;
        this.bitField0_ = n11 &= 0xFFFFBFFF;
        this.statusSub_ = false;
        this.bitField0_ = n11 &= 0xFFFF7FFF;
        this.statusPub_ = false;
        this.bitField0_ = n11 &= 0xFFFEFFFF;
        this.statusTTL_ = 0;
        this.bitField0_ = n11 &= 0xFFFDFFFF;
        this.uniqueId_ = string2;
        this.bitField0_ = n11 &= 0xFFFBFFFF;
        this.targetClientId_ = string2;
        this.bitField0_ = n11 &= 0xFFF7FFFF;
        this.maxReadTimestamp_ = l10;
        int n12 = -1048577;
        this.bitField0_ = n11 &= n12;
        this.maxAckTimestamp_ = l10;
        this.bitField0_ = n11 &= 0xFFDFFFFF;
        this.queryAllMembers_ = false;
        int n13 = -4194305;
        this.bitField0_ = n11 &= n13;
        Object object2 = this.maxReadTuplesBuilder_;
        if (object2 == null) {
            this.maxReadTuples_ = object2 = Collections.emptyList();
            n11 = this.bitField0_;
            n13 = -8388609;
            this.bitField0_ = n11 &= n13;
        } else {
            ((RepeatedFieldBuilderV3)object2).clear();
        }
        this.cids_ = object;
        this.bitField0_ = n11 = this.bitField0_ & 0xFEFFFFFF;
        object2 = this.infoBuilder_;
        n13 = 0;
        if (object2 == null) {
            this.info_ = null;
        } else {
            ((SingleFieldBuilderV3)object2).clear();
        }
        this.bitField0_ = n11 = this.bitField0_ & 0xFDFFFFFF;
        this.tempConv_ = false;
        this.bitField0_ = n11 &= 0xFBFFFFFF;
        this.tempConvTTL_ = 0;
        this.bitField0_ = n11 &= 0xF7FFFFFF;
        this.tempConvIds_ = object;
        int n14 = -268435457;
        this.bitField0_ = n11 &= n14;
        this.allowedPids_ = object;
        this.bitField0_ = n10 = 0xDFFFFFFF & n11;
        object = this.failedPidsBuilder_;
        if (object == null) {
            object = Collections.emptyList();
            this.failedPids_ = object;
            n10 = this.bitField0_;
            n11 = -1073741825;
            this.bitField0_ = n10 &= n11;
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        this.existing_ = false;
        n10 = this.bitField0_;
        n11 = -1 >>> 1;
        this.bitField0_ = n10 &= n11;
        this.next_ = string2;
        this.bitField1_ = n10 = this.bitField1_ & 0xFFFFFFFE;
        object = this.resultsBuilder_;
        if (object == null) {
            this.results_ = null;
        } else {
            ((SingleFieldBuilderV3)object).clear();
        }
        this.bitField1_ = n10 = this.bitField1_ & 0xFFFFFFFD;
        object = this.whereBuilder_;
        if (object == null) {
            this.where_ = null;
        } else {
            ((SingleFieldBuilderV3)object).clear();
        }
        this.bitField1_ = n10 = this.bitField1_ & 0xFFFFFFFB;
        object = this.attrBuilder_;
        if (object == null) {
            this.attr_ = null;
        } else {
            ((SingleFieldBuilderV3)object).clear();
        }
        this.bitField1_ = n10 = this.bitField1_ & 0xFFFFFFF7;
        object = this.attrModifiedBuilder_;
        if (object == null) {
            this.attrModified_ = null;
        } else {
            ((SingleFieldBuilderV3)object).clear();
        }
        this.bitField1_ = n10 = this.bitField1_ & 0xFFFFFFEF;
        return this;
    }

    public Messages$ConvCommand$Builder clearAllowedPids() {
        int n10;
        LazyStringList lazyStringList;
        this.allowedPids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xDFFFFFFF;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearAttr() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.attrBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.attr_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField1_ = n10 = this.bitField1_ & 0xFFFFFFF7;
        return this;
    }

    public Messages$ConvCommand$Builder clearAttrModified() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.attrModifiedBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.attrModified_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField1_ = n10 = this.bitField1_ & 0xFFFFFFEF;
        return this;
    }

    public Messages$ConvCommand$Builder clearCdate() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        String string2 = Messages$ConvCommand.getDefaultInstance().getCdate();
        this.cdate_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearCid() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        String string2 = Messages$ConvCommand.getDefaultInstance().getCid();
        this.cid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearCids() {
        int n10;
        LazyStringList lazyStringList;
        this.cids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFEFFFFFF;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearCount() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFBFF;
        this.count_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearExisting() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & -1 >>> 1;
        this.existing_ = false;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearFailedPids() {
        Object object = this.failedPidsBuilder_;
        if (object == null) {
            this.failedPids_ = object = Collections.emptyList();
            int n10 = this.bitField0_;
            int n11 = -1073741825;
            this.bitField0_ = n10 &= n11;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public Messages$ConvCommand$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Messages$ConvCommand$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Messages$ConvCommand$Builder clearFlag() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFDFF;
        this.flag_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearInfo() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.infoBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.info_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField0_ = n10 = this.bitField0_ & 0xFDFFFFFF;
        return this;
    }

    public Messages$ConvCommand$Builder clearInitBy() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
        String string2 = Messages$ConvCommand.getDefaultInstance().getInitBy();
        this.initBy_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearLimit() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFF7F;
        this.limit_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearM() {
        int n10;
        LazyStringList lazyStringList;
        this.m_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearMaxAckTimestamp() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFDFFFFF;
        this.maxAckTimestamp_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearMaxReadTimestamp() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFEFFFFF;
        this.maxReadTimestamp_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearMaxReadTuples() {
        Object object = this.maxReadTuplesBuilder_;
        if (object == null) {
            this.maxReadTuples_ = object = Collections.emptyList();
            int n10 = this.bitField0_;
            int n11 = -8388609;
            this.bitField0_ = n10 &= n11;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public Messages$ConvCommand$Builder clearN() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFDFFF;
        String string2 = Messages$ConvCommand.getDefaultInstance().getN();
        this.n_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearNext() {
        int n10;
        this.bitField1_ = n10 = this.bitField1_ & 0xFFFFFFFE;
        String string2 = Messages$ConvCommand.getDefaultInstance().getNext();
        this.next_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Messages$ConvCommand$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Messages$ConvCommand$Builder clearQueryAllMembers() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFBFFFFF;
        this.queryAllMembers_ = false;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearResults() {
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
        this.bitField1_ = n10 = this.bitField1_ & 0xFFFFFFFD;
        return this;
    }

    public Messages$ConvCommand$Builder clearS() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFBFFF;
        String string2 = Messages$ConvCommand.getDefaultInstance().getS();
        this.s_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearSkip() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFEFF;
        this.skip_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearSort() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFBF;
        String string2 = Messages$ConvCommand.getDefaultInstance().getSort();
        this.sort_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearStatusPub() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFEFFFF;
        this.statusPub_ = false;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearStatusSub() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFF7FFF;
        this.statusSub_ = false;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearStatusTTL() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFDFFFF;
        this.statusTTL_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearT() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFEFFF;
        this.t_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearTargetClientId() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFF7FFFF;
        String string2 = Messages$ConvCommand.getDefaultInstance().getTargetClientId();
        this.targetClientId_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearTempConv() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFBFFFFFF;
        this.tempConv_ = false;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearTempConvIds() {
        int n10;
        LazyStringList lazyStringList;
        this.tempConvIds_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xEFFFFFFF;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearTempConvTTL() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xF7FFFFFF;
        this.tempConvTTL_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearTransient() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.transient_ = false;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearUdate() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFF7FF;
        String string2 = Messages$ConvCommand.getDefaultInstance().getUdate();
        this.udate_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearUnique() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        this.unique_ = false;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearUniqueId() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFBFFFF;
        String string2 = Messages$ConvCommand.getDefaultInstance().getUniqueId();
        this.uniqueId_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder clearWhere() {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.whereBuilder_;
        if (singleFieldBuilderV3 == null) {
            n10 = 0;
            singleFieldBuilderV3 = null;
            this.where_ = null;
            this.onChanged();
        } else {
            singleFieldBuilderV3.clear();
        }
        this.bitField1_ = n10 = this.bitField1_ & 0xFFFFFFFB;
        return this;
    }

    public Messages$ConvCommand$Builder clone() {
        return (Messages$ConvCommand$Builder)super.clone();
    }

    public String getAllowedPids(int n10) {
        return (String)this.allowedPids_.get(n10);
    }

    public ByteString getAllowedPidsBytes(int n10) {
        return this.allowedPids_.getByteString(n10);
    }

    public int getAllowedPidsCount() {
        return this.allowedPids_.size();
    }

    public ProtocolStringList getAllowedPidsList() {
        return this.allowedPids_.getUnmodifiableView();
    }

    public Messages$JsonObjectMessage getAttr() {
        Object object = this.attrBuilder_;
        if (object == null) {
            object = this.attr_;
            if (object == null) {
                object = Messages$JsonObjectMessage.getDefaultInstance();
            }
            return object;
        }
        return (Messages$JsonObjectMessage)((SingleFieldBuilderV3)object).getMessage();
    }

    public Messages$JsonObjectMessage$Builder getAttrBuilder() {
        int n10;
        this.bitField1_ = n10 = this.bitField1_ | 8;
        this.onChanged();
        return (Messages$JsonObjectMessage$Builder)this.getAttrFieldBuilder().getBuilder();
    }

    public Messages$JsonObjectMessage getAttrModified() {
        Object object = this.attrModifiedBuilder_;
        if (object == null) {
            object = this.attrModified_;
            if (object == null) {
                object = Messages$JsonObjectMessage.getDefaultInstance();
            }
            return object;
        }
        return (Messages$JsonObjectMessage)((SingleFieldBuilderV3)object).getMessage();
    }

    public Messages$JsonObjectMessage$Builder getAttrModifiedBuilder() {
        int n10;
        this.bitField1_ = n10 = this.bitField1_ | 0x10;
        this.onChanged();
        return (Messages$JsonObjectMessage$Builder)this.getAttrModifiedFieldBuilder().getBuilder();
    }

    public Messages$JsonObjectMessageOrBuilder getAttrModifiedOrBuilder() {
        Object object = this.attrModifiedBuilder_;
        if (object != null) {
            return (Messages$JsonObjectMessageOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.attrModified_;
        if (object == null) {
            object = Messages$JsonObjectMessage.getDefaultInstance();
        }
        return object;
    }

    public Messages$JsonObjectMessageOrBuilder getAttrOrBuilder() {
        Object object = this.attrBuilder_;
        if (object != null) {
            return (Messages$JsonObjectMessageOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.attr_;
        if (object == null) {
            object = Messages$JsonObjectMessage.getDefaultInstance();
        }
        return object;
    }

    public String getCdate() {
        Object object = this.cdate_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.cdate_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getCdateBytes() {
        Object object = this.cdate_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.cdate_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
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

    public int getCount() {
        return this.count_;
    }

    public Messages$ConvCommand getDefaultInstanceForType() {
        return Messages$ConvCommand.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$23800();
    }

    public boolean getExisting() {
        return this.existing_;
    }

    public Messages$ErrorCommand getFailedPids(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.failedPidsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (Messages$ErrorCommand)this.failedPids_.get(n10);
        }
        return (Messages$ErrorCommand)repeatedFieldBuilderV3.getMessage(n10);
    }

    public Messages$ErrorCommand$Builder getFailedPidsBuilder(int n10) {
        return (Messages$ErrorCommand$Builder)this.getFailedPidsFieldBuilder().getBuilder(n10);
    }

    public List getFailedPidsBuilderList() {
        return this.getFailedPidsFieldBuilder().getBuilderList();
    }

    public int getFailedPidsCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.failedPidsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.failedPids_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getFailedPidsList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.failedPidsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.failedPids_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public Messages$ErrorCommandOrBuilder getFailedPidsOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.failedPidsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (Messages$ErrorCommandOrBuilder)this.failedPids_.get(n10);
        }
        return (Messages$ErrorCommandOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getFailedPidsOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.failedPidsBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.failedPids_);
    }

    public int getFlag() {
        return this.flag_;
    }

    public Messages$ConvMemberInfo getInfo() {
        Object object = this.infoBuilder_;
        if (object == null) {
            object = this.info_;
            if (object == null) {
                object = Messages$ConvMemberInfo.getDefaultInstance();
            }
            return object;
        }
        return (Messages$ConvMemberInfo)((SingleFieldBuilderV3)object).getMessage();
    }

    public Messages$ConvMemberInfo$Builder getInfoBuilder() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x2000000;
        this.onChanged();
        return (Messages$ConvMemberInfo$Builder)this.getInfoFieldBuilder().getBuilder();
    }

    public Messages$ConvMemberInfoOrBuilder getInfoOrBuilder() {
        Object object = this.infoBuilder_;
        if (object != null) {
            return (Messages$ConvMemberInfoOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.info_;
        if (object == null) {
            object = Messages$ConvMemberInfo.getDefaultInstance();
        }
        return object;
    }

    public String getInitBy() {
        Object object = this.initBy_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.initBy_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getInitByBytes() {
        Object object = this.initBy_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.initBy_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public int getLimit() {
        return this.limit_;
    }

    public String getM(int n10) {
        return (String)this.m_.get(n10);
    }

    public ByteString getMBytes(int n10) {
        return this.m_.getByteString(n10);
    }

    public int getMCount() {
        return this.m_.size();
    }

    public ProtocolStringList getMList() {
        return this.m_.getUnmodifiableView();
    }

    public long getMaxAckTimestamp() {
        return this.maxAckTimestamp_;
    }

    public long getMaxReadTimestamp() {
        return this.maxReadTimestamp_;
    }

    public Messages$MaxReadTuple getMaxReadTuples(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.maxReadTuplesBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (Messages$MaxReadTuple)this.maxReadTuples_.get(n10);
        }
        return (Messages$MaxReadTuple)repeatedFieldBuilderV3.getMessage(n10);
    }

    public Messages$MaxReadTuple$Builder getMaxReadTuplesBuilder(int n10) {
        return (Messages$MaxReadTuple$Builder)this.getMaxReadTuplesFieldBuilder().getBuilder(n10);
    }

    public List getMaxReadTuplesBuilderList() {
        return this.getMaxReadTuplesFieldBuilder().getBuilderList();
    }

    public int getMaxReadTuplesCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.maxReadTuplesBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.maxReadTuples_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getMaxReadTuplesList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.maxReadTuplesBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.maxReadTuples_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public Messages$MaxReadTupleOrBuilder getMaxReadTuplesOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.maxReadTuplesBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (Messages$MaxReadTupleOrBuilder)this.maxReadTuples_.get(n10);
        }
        return (Messages$MaxReadTupleOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getMaxReadTuplesOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.maxReadTuplesBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.maxReadTuples_);
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

    public String getNext() {
        Object object = this.next_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.next_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getNextBytes() {
        Object object = this.next_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.next_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public boolean getQueryAllMembers() {
        return this.queryAllMembers_;
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
        this.bitField1_ = n10 = this.bitField1_ | 2;
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

    public int getSkip() {
        return this.skip_;
    }

    public String getSort() {
        Object object = this.sort_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.sort_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getSortBytes() {
        Object object = this.sort_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.sort_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public boolean getStatusPub() {
        return this.statusPub_;
    }

    public boolean getStatusSub() {
        return this.statusSub_;
    }

    public int getStatusTTL() {
        return this.statusTTL_;
    }

    public long getT() {
        return this.t_;
    }

    public String getTargetClientId() {
        Object object = this.targetClientId_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.targetClientId_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getTargetClientIdBytes() {
        Object object = this.targetClientId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.targetClientId_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public boolean getTempConv() {
        return this.tempConv_;
    }

    public String getTempConvIds(int n10) {
        return (String)this.tempConvIds_.get(n10);
    }

    public ByteString getTempConvIdsBytes(int n10) {
        return this.tempConvIds_.getByteString(n10);
    }

    public int getTempConvIdsCount() {
        return this.tempConvIds_.size();
    }

    public ProtocolStringList getTempConvIdsList() {
        return this.tempConvIds_.getUnmodifiableView();
    }

    public int getTempConvTTL() {
        return this.tempConvTTL_;
    }

    public boolean getTransient() {
        return this.transient_;
    }

    public String getUdate() {
        Object object = this.udate_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.udate_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getUdateBytes() {
        Object object = this.udate_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.udate_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public boolean getUnique() {
        return this.unique_;
    }

    public String getUniqueId() {
        Object object = this.uniqueId_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.uniqueId_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getUniqueIdBytes() {
        Object object = this.uniqueId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.uniqueId_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Messages$JsonObjectMessage getWhere() {
        Object object = this.whereBuilder_;
        if (object == null) {
            object = this.where_;
            if (object == null) {
                object = Messages$JsonObjectMessage.getDefaultInstance();
            }
            return object;
        }
        return (Messages$JsonObjectMessage)((SingleFieldBuilderV3)object).getMessage();
    }

    public Messages$JsonObjectMessage$Builder getWhereBuilder() {
        int n10;
        this.bitField1_ = n10 = this.bitField1_ | 4;
        this.onChanged();
        return (Messages$JsonObjectMessage$Builder)this.getWhereFieldBuilder().getBuilder();
    }

    public Messages$JsonObjectMessageOrBuilder getWhereOrBuilder() {
        Object object = this.whereBuilder_;
        if (object != null) {
            return (Messages$JsonObjectMessageOrBuilder)((SingleFieldBuilderV3)object).getMessageOrBuilder();
        }
        object = this.where_;
        if (object == null) {
            object = Messages$JsonObjectMessage.getDefaultInstance();
        }
        return object;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasAttr() {
        void var1_5;
        int bl2 = this.bitField1_;
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
    public boolean hasAttrModified() {
        void var1_5;
        int bl2 = this.bitField1_;
        int n10 = 16;
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
    public boolean hasCdate() {
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

    /*
     * WARNING - void declaration
     */
    public boolean hasCid() {
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
    public boolean hasCount() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 1024;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    public boolean hasExisting() {
        int n10 = this.bitField0_;
        int n11 = -1 << -1;
        n10 = (n10 &= n11) == n11 ? 1 : 0;
        return n10 != 0;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasFlag() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 512;
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
    public boolean hasInfo() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 0x2000000;
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
    public boolean hasInitBy() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 32;
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
    public boolean hasLimit() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 128;
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
    public boolean hasMaxAckTimestamp() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 0x200000;
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
    public boolean hasMaxReadTimestamp() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 0x100000;
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
        int n10 = 8192;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    public boolean hasNext() {
        int bl2 = this.bitField1_;
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
    public boolean hasQueryAllMembers() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 0x400000;
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
    public boolean hasResults() {
        void var1_5;
        int bl2 = this.bitField1_;
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
    public boolean hasS() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 16384;
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
    public boolean hasSkip() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 256;
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
    public boolean hasSort() {
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
    public boolean hasStatusPub() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 65536;
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
    public boolean hasStatusSub() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 32768;
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
    public boolean hasStatusTTL() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 131072;
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
        int n10 = 4096;
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
    public boolean hasTargetClientId() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 524288;
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
    public boolean hasTempConv() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 0x4000000;
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
    public boolean hasTempConvTTL() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 0x8000000;
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
    public boolean hasUdate() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 2048;
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
    public boolean hasUnique() {
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
    public boolean hasUniqueId() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 262144;
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
    public boolean hasWhere() {
        void var1_5;
        int bl2 = this.bitField1_;
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
        return Messages.access$23900().ensureFieldAccessorsInitialized(Messages$ConvCommand.class, Messages$ConvCommand$Builder.class);
    }

    public final boolean isInitialized() {
        int n10;
        int n11;
        Messages$JsonObjectMessage messages$JsonObjectMessage = null;
        for (n11 = 0; n11 < (n10 = this.getFailedPidsCount()); ++n11) {
            Messages$ErrorCommand messages$ErrorCommand = this.getFailedPids(n11);
            n10 = (int)(messages$ErrorCommand.isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        n11 = (int)(this.hasResults() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)((messages$JsonObjectMessage = this.getResults()).isInitialized() ? 1 : 0)) == 0) {
            return false;
        }
        n11 = (int)(this.hasWhere() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)((messages$JsonObjectMessage = this.getWhere()).isInitialized() ? 1 : 0)) == 0) {
            return false;
        }
        n11 = (int)(this.hasAttr() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)((messages$JsonObjectMessage = this.getAttr()).isInitialized() ? 1 : 0)) == 0) {
            return false;
        }
        n11 = (int)(this.hasAttrModified() ? 1 : 0);
        return n11 == 0 || (n11 = (int)((messages$JsonObjectMessage = this.getAttrModified()).isInitialized() ? 1 : 0)) != 0;
    }

    public Messages$ConvCommand$Builder mergeAttr(Messages$JsonObjectMessage messages$JsonObjectMessage) {
        int n10;
        Object object = this.attrBuilder_;
        int n11 = 8;
        if (object == null) {
            Messages$JsonObjectMessage messages$JsonObjectMessage2;
            int n12 = this.bitField1_ & n11;
            if (n12 == n11 && (object = this.attr_) != null && object != (messages$JsonObjectMessage2 = Messages$JsonObjectMessage.getDefaultInstance())) {
                object = Messages$JsonObjectMessage.newBuilder(this.attr_);
                this.attr_ = messages$JsonObjectMessage = ((Messages$JsonObjectMessage$Builder)object).mergeFrom(messages$JsonObjectMessage).buildPartial();
            } else {
                this.attr_ = messages$JsonObjectMessage;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(messages$JsonObjectMessage);
        }
        this.bitField1_ = n10 = this.bitField1_ | n11;
        return this;
    }

    public Messages$ConvCommand$Builder mergeAttrModified(Messages$JsonObjectMessage messages$JsonObjectMessage) {
        int n10;
        Object object = this.attrModifiedBuilder_;
        int n11 = 16;
        if (object == null) {
            Messages$JsonObjectMessage messages$JsonObjectMessage2;
            int n12 = this.bitField1_ & n11;
            if (n12 == n11 && (object = this.attrModified_) != null && object != (messages$JsonObjectMessage2 = Messages$JsonObjectMessage.getDefaultInstance())) {
                object = Messages$JsonObjectMessage.newBuilder(this.attrModified_);
                this.attrModified_ = messages$JsonObjectMessage = ((Messages$JsonObjectMessage$Builder)object).mergeFrom(messages$JsonObjectMessage).buildPartial();
            } else {
                this.attrModified_ = messages$JsonObjectMessage;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(messages$JsonObjectMessage);
        }
        this.bitField1_ = n10 = this.bitField1_ | n11;
        return this;
    }

    public Messages$ConvCommand$Builder mergeFrom(Messages$ConvCommand messageLite) {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        boolean bl5;
        boolean bl6;
        boolean bl7;
        boolean bl8;
        boolean bl9;
        boolean bl10;
        boolean bl11;
        boolean bl12;
        boolean bl13;
        boolean bl14;
        boolean bl15;
        boolean bl16;
        boolean bl17;
        int n10;
        boolean bl18;
        boolean bl19;
        boolean bl20;
        boolean bl21;
        boolean bl22;
        boolean bl23;
        long l10;
        boolean bl24;
        boolean bl25;
        boolean bl26;
        boolean bl27;
        boolean bl28;
        boolean bl29;
        boolean bl30;
        boolean bl31;
        boolean bl32;
        boolean bl33;
        boolean bl34;
        boolean bl35;
        List list;
        Object object = Messages$ConvCommand.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        object = Messages$ConvCommand.access$24400((Messages$ConvCommand)messageLite);
        boolean n11 = object.isEmpty();
        if (!n11) {
            object = this.m_;
            boolean bl36 = object.isEmpty();
            if (bl36) {
                int n12;
                this.m_ = object = Messages$ConvCommand.access$24400((Messages$ConvCommand)messageLite);
                this.bitField0_ = n12 = this.bitField0_ & 0xFFFFFFFE;
            } else {
                this.ensureMIsMutable();
                object = this.m_;
                list = Messages$ConvCommand.access$24400((Messages$ConvCommand)messageLite);
                object.addAll(list);
            }
            this.onChanged();
        }
        if (bl35 = ((Messages$ConvCommand)messageLite).hasTransient()) {
            boolean bl37 = ((Messages$ConvCommand)messageLite).getTransient();
            this.setTransient(bl37);
        }
        if (bl34 = ((Messages$ConvCommand)messageLite).hasUnique()) {
            boolean bl38 = ((Messages$ConvCommand)messageLite).getUnique();
            this.setUnique(bl38);
        }
        if (bl33 = ((Messages$ConvCommand)messageLite).hasCid()) {
            int n13;
            this.bitField0_ = n13 = this.bitField0_ | 8;
            this.cid_ = object = Messages$ConvCommand.access$24700((Messages$ConvCommand)messageLite);
            this.onChanged();
        }
        if (bl32 = ((Messages$ConvCommand)messageLite).hasCdate()) {
            int n14;
            this.bitField0_ = n14 = this.bitField0_ | 0x10;
            this.cdate_ = object = Messages$ConvCommand.access$24800((Messages$ConvCommand)messageLite);
            this.onChanged();
        }
        if (bl31 = ((Messages$ConvCommand)messageLite).hasInitBy()) {
            int n15;
            this.bitField0_ = n15 = this.bitField0_ | 0x20;
            this.initBy_ = object = Messages$ConvCommand.access$24900((Messages$ConvCommand)messageLite);
            this.onChanged();
        }
        if (bl30 = ((Messages$ConvCommand)messageLite).hasSort()) {
            int n16;
            this.bitField0_ = n16 = this.bitField0_ | 0x40;
            this.sort_ = object = Messages$ConvCommand.access$25000((Messages$ConvCommand)messageLite);
            this.onChanged();
        }
        if (bl29 = ((Messages$ConvCommand)messageLite).hasLimit()) {
            int n17 = ((Messages$ConvCommand)messageLite).getLimit();
            this.setLimit(n17);
        }
        if (bl28 = ((Messages$ConvCommand)messageLite).hasSkip()) {
            int n18 = ((Messages$ConvCommand)messageLite).getSkip();
            this.setSkip(n18);
        }
        if (bl27 = ((Messages$ConvCommand)messageLite).hasFlag()) {
            int n19 = ((Messages$ConvCommand)messageLite).getFlag();
            this.setFlag(n19);
        }
        if (bl26 = ((Messages$ConvCommand)messageLite).hasCount()) {
            int n20 = ((Messages$ConvCommand)messageLite).getCount();
            this.setCount(n20);
        }
        if (bl25 = ((Messages$ConvCommand)messageLite).hasUdate()) {
            int n21;
            this.bitField0_ = n21 = this.bitField0_ | 0x800;
            this.udate_ = object = Messages$ConvCommand.access$25500((Messages$ConvCommand)messageLite);
            this.onChanged();
        }
        if (bl24 = ((Messages$ConvCommand)messageLite).hasT()) {
            l10 = ((Messages$ConvCommand)messageLite).getT();
            this.setT(l10);
        }
        if (bl23 = ((Messages$ConvCommand)messageLite).hasN()) {
            int n22;
            this.bitField0_ = n22 = this.bitField0_ | 0x2000;
            this.n_ = object = Messages$ConvCommand.access$25700((Messages$ConvCommand)messageLite);
            this.onChanged();
        }
        if (bl22 = ((Messages$ConvCommand)messageLite).hasS()) {
            int n23;
            this.bitField0_ = n23 = this.bitField0_ | 0x4000;
            this.s_ = object = Messages$ConvCommand.access$25800((Messages$ConvCommand)messageLite);
            this.onChanged();
        }
        if (bl21 = ((Messages$ConvCommand)messageLite).hasStatusSub()) {
            boolean bl39 = ((Messages$ConvCommand)messageLite).getStatusSub();
            this.setStatusSub(bl39);
        }
        if (bl20 = ((Messages$ConvCommand)messageLite).hasStatusPub()) {
            boolean bl40 = ((Messages$ConvCommand)messageLite).getStatusPub();
            this.setStatusPub(bl40);
        }
        if (bl19 = ((Messages$ConvCommand)messageLite).hasStatusTTL()) {
            int n24 = ((Messages$ConvCommand)messageLite).getStatusTTL();
            this.setStatusTTL(n24);
        }
        if (bl18 = ((Messages$ConvCommand)messageLite).hasUniqueId()) {
            int n25;
            int n26 = this.bitField0_;
            n10 = 262144;
            this.bitField0_ = n25 = n26 | n10;
            this.uniqueId_ = object = Messages$ConvCommand.access$26200((Messages$ConvCommand)messageLite);
            this.onChanged();
        }
        if (bl17 = ((Messages$ConvCommand)messageLite).hasTargetClientId()) {
            int n27;
            int n28 = this.bitField0_;
            n10 = 524288;
            this.bitField0_ = n27 = n28 | n10;
            this.targetClientId_ = object = Messages$ConvCommand.access$26300((Messages$ConvCommand)messageLite);
            this.onChanged();
        }
        if (bl16 = ((Messages$ConvCommand)messageLite).hasMaxReadTimestamp()) {
            l10 = ((Messages$ConvCommand)messageLite).getMaxReadTimestamp();
            this.setMaxReadTimestamp(l10);
        }
        if (bl15 = ((Messages$ConvCommand)messageLite).hasMaxAckTimestamp()) {
            l10 = ((Messages$ConvCommand)messageLite).getMaxAckTimestamp();
            this.setMaxAckTimestamp(l10);
        }
        if (bl14 = ((Messages$ConvCommand)messageLite).hasQueryAllMembers()) {
            boolean bl41 = ((Messages$ConvCommand)messageLite).getQueryAllMembers();
            this.setQueryAllMembers(bl41);
        }
        object = this.maxReadTuplesBuilder_;
        n10 = -8388609;
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = null;
        if (object == null) {
            object = Messages$ConvCommand.access$26700((Messages$ConvCommand)messageLite);
            boolean bl42 = object.isEmpty();
            if (!bl42) {
                object = this.maxReadTuples_;
                boolean bl43 = object.isEmpty();
                if (bl43) {
                    int n29;
                    this.maxReadTuples_ = object = Messages$ConvCommand.access$26700((Messages$ConvCommand)messageLite);
                    this.bitField0_ = n29 = this.bitField0_ & n10;
                } else {
                    this.ensureMaxReadTuplesIsMutable();
                    object = this.maxReadTuples_;
                    list = Messages$ConvCommand.access$26700((Messages$ConvCommand)messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = Messages$ConvCommand.access$26700((Messages$ConvCommand)messageLite);
            boolean bl44 = object.isEmpty();
            if (!bl44) {
                object = this.maxReadTuplesBuilder_;
                boolean bl45 = ((RepeatedFieldBuilderV3)object).isEmpty();
                if (bl45) {
                    int n30;
                    this.maxReadTuplesBuilder_.dispose();
                    this.maxReadTuplesBuilder_ = null;
                    this.maxReadTuples_ = object = Messages$ConvCommand.access$26700((Messages$ConvCommand)messageLite);
                    this.bitField0_ = n30 = this.bitField0_ & n10;
                    boolean bl46 = Messages$ConvCommand.access$28200();
                    if (bl46) {
                        object = this.getMaxReadTuplesFieldBuilder();
                    } else {
                        boolean bl47 = false;
                        object = null;
                    }
                    this.maxReadTuplesBuilder_ = object;
                } else {
                    object = this.maxReadTuplesBuilder_;
                    list = Messages$ConvCommand.access$26700((Messages$ConvCommand)messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        if (!(bl13 = (object = Messages$ConvCommand.access$26800((Messages$ConvCommand)messageLite)).isEmpty())) {
            object = this.cids_;
            boolean bl48 = object.isEmpty();
            if (bl48) {
                int n31;
                this.cids_ = object = Messages$ConvCommand.access$26800((Messages$ConvCommand)messageLite);
                int n32 = this.bitField0_;
                n10 = -16777217;
                this.bitField0_ = n31 = n32 & n10;
            } else {
                this.ensureCidsIsMutable();
                object = this.cids_;
                list = Messages$ConvCommand.access$26800((Messages$ConvCommand)messageLite);
                object.addAll(list);
            }
            this.onChanged();
        }
        if (bl12 = ((Messages$ConvCommand)messageLite).hasInfo()) {
            object = ((Messages$ConvCommand)messageLite).getInfo();
            this.mergeInfo((Messages$ConvMemberInfo)object);
        }
        if (bl11 = ((Messages$ConvCommand)messageLite).hasTempConv()) {
            boolean bl49 = ((Messages$ConvCommand)messageLite).getTempConv();
            this.setTempConv(bl49);
        }
        if (bl10 = ((Messages$ConvCommand)messageLite).hasTempConvTTL()) {
            int n33 = ((Messages$ConvCommand)messageLite).getTempConvTTL();
            this.setTempConvTTL(n33);
        }
        if (!(bl9 = (object = Messages$ConvCommand.access$27200((Messages$ConvCommand)messageLite)).isEmpty())) {
            object = this.tempConvIds_;
            boolean bl50 = object.isEmpty();
            if (bl50) {
                int n34;
                this.tempConvIds_ = object = Messages$ConvCommand.access$27200((Messages$ConvCommand)messageLite);
                int n35 = this.bitField0_;
                n10 = -268435457;
                this.bitField0_ = n34 = n35 & n10;
            } else {
                this.ensureTempConvIdsIsMutable();
                object = this.tempConvIds_;
                list = Messages$ConvCommand.access$27200((Messages$ConvCommand)messageLite);
                object.addAll(list);
            }
            this.onChanged();
        }
        if (!(bl8 = (object = Messages$ConvCommand.access$27300((Messages$ConvCommand)messageLite)).isEmpty())) {
            object = this.allowedPids_;
            boolean bl51 = object.isEmpty();
            if (bl51) {
                int n36;
                this.allowedPids_ = object = Messages$ConvCommand.access$27300((Messages$ConvCommand)messageLite);
                int n37 = this.bitField0_;
                n10 = -536870913;
                this.bitField0_ = n36 = n37 & n10;
            } else {
                this.ensureAllowedPidsIsMutable();
                object = this.allowedPids_;
                list = Messages$ConvCommand.access$27300((Messages$ConvCommand)messageLite);
                object.addAll(list);
            }
            this.onChanged();
        }
        object = this.failedPidsBuilder_;
        n10 = -1073741825;
        if (object == null) {
            object = Messages$ConvCommand.access$27400((Messages$ConvCommand)messageLite);
            boolean bl52 = object.isEmpty();
            if (!bl52) {
                object = this.failedPids_;
                boolean bl53 = object.isEmpty();
                if (bl53) {
                    int n38;
                    this.failedPids_ = object = Messages$ConvCommand.access$27400((Messages$ConvCommand)messageLite);
                    this.bitField0_ = n38 = this.bitField0_ & n10;
                } else {
                    this.ensureFailedPidsIsMutable();
                    object = this.failedPids_;
                    list = Messages$ConvCommand.access$27400((Messages$ConvCommand)messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = Messages$ConvCommand.access$27400((Messages$ConvCommand)messageLite);
            boolean bl54 = object.isEmpty();
            if (!bl54) {
                object = this.failedPidsBuilder_;
                boolean bl55 = ((RepeatedFieldBuilderV3)object).isEmpty();
                if (bl55) {
                    int n39;
                    this.failedPidsBuilder_.dispose();
                    this.failedPidsBuilder_ = null;
                    this.failedPids_ = object = Messages$ConvCommand.access$27400((Messages$ConvCommand)messageLite);
                    this.bitField0_ = n39 = this.bitField0_ & n10;
                    boolean bl56 = Messages$ConvCommand.access$28300();
                    if (bl56) {
                        repeatedFieldBuilderV3 = this.getFailedPidsFieldBuilder();
                    }
                    this.failedPidsBuilder_ = repeatedFieldBuilderV3;
                } else {
                    object = this.failedPidsBuilder_;
                    list = Messages$ConvCommand.access$27400((Messages$ConvCommand)messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        if (bl7 = ((Messages$ConvCommand)messageLite).hasExisting()) {
            boolean bl57 = ((Messages$ConvCommand)messageLite).getExisting();
            this.setExisting(bl57);
        }
        if (bl6 = ((Messages$ConvCommand)messageLite).hasNext()) {
            int n40;
            this.bitField1_ = n40 = this.bitField1_ | 1;
            this.next_ = object = Messages$ConvCommand.access$27600((Messages$ConvCommand)messageLite);
            this.onChanged();
        }
        if (bl5 = ((Messages$ConvCommand)messageLite).hasResults()) {
            object = ((Messages$ConvCommand)messageLite).getResults();
            this.mergeResults((Messages$JsonObjectMessage)object);
        }
        if (bl4 = ((Messages$ConvCommand)messageLite).hasWhere()) {
            object = ((Messages$ConvCommand)messageLite).getWhere();
            this.mergeWhere((Messages$JsonObjectMessage)object);
        }
        if (bl3 = ((Messages$ConvCommand)messageLite).hasAttr()) {
            object = ((Messages$ConvCommand)messageLite).getAttr();
            this.mergeAttr((Messages$JsonObjectMessage)object);
        }
        if (bl2 = ((Messages$ConvCommand)messageLite).hasAttrModified()) {
            object = ((Messages$ConvCommand)messageLite).getAttrModified();
            this.mergeAttrModified((Messages$JsonObjectMessage)object);
        }
        messageLite = Messages$ConvCommand.access$28400((Messages$ConvCommand)messageLite);
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
    public Messages$ConvCommand$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$ConvCommand.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$ConvCommand)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$ConvCommand)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$ConvCommand)object2;
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
            this.mergeFrom((Messages$ConvCommand)object3);
        }
        throw var1_6;
    }

    public Messages$ConvCommand$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$ConvCommand;
        if (bl2) {
            message = (Messages$ConvCommand)message;
            return this.mergeFrom((Messages$ConvCommand)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Messages$ConvCommand$Builder mergeInfo(Messages$ConvMemberInfo messages$ConvMemberInfo) {
        int n10;
        Object object = this.infoBuilder_;
        int n11 = 0x2000000;
        if (object == null) {
            Messages$ConvMemberInfo messages$ConvMemberInfo2;
            int n12 = this.bitField0_ & n11;
            if (n12 == n11 && (object = this.info_) != null && object != (messages$ConvMemberInfo2 = Messages$ConvMemberInfo.getDefaultInstance())) {
                object = Messages$ConvMemberInfo.newBuilder(this.info_);
                this.info_ = messages$ConvMemberInfo = ((Messages$ConvMemberInfo$Builder)object).mergeFrom(messages$ConvMemberInfo).buildPartial();
            } else {
                this.info_ = messages$ConvMemberInfo;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(messages$ConvMemberInfo);
        }
        this.bitField0_ = n10 = this.bitField0_ | n11;
        return this;
    }

    public Messages$ConvCommand$Builder mergeResults(Messages$JsonObjectMessage messages$JsonObjectMessage) {
        int n10;
        Object object = this.resultsBuilder_;
        int n11 = 2;
        if (object == null) {
            Messages$JsonObjectMessage messages$JsonObjectMessage2;
            int n12 = this.bitField1_ & n11;
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
        this.bitField1_ = n10 = this.bitField1_ | n11;
        return this;
    }

    public final Messages$ConvCommand$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$ConvCommand$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$ConvCommand$Builder mergeWhere(Messages$JsonObjectMessage messages$JsonObjectMessage) {
        int n10;
        Object object = this.whereBuilder_;
        int n11 = 4;
        if (object == null) {
            Messages$JsonObjectMessage messages$JsonObjectMessage2;
            int n12 = this.bitField1_ & n11;
            if (n12 == n11 && (object = this.where_) != null && object != (messages$JsonObjectMessage2 = Messages$JsonObjectMessage.getDefaultInstance())) {
                object = Messages$JsonObjectMessage.newBuilder(this.where_);
                this.where_ = messages$JsonObjectMessage = ((Messages$JsonObjectMessage$Builder)object).mergeFrom(messages$JsonObjectMessage).buildPartial();
            } else {
                this.where_ = messages$JsonObjectMessage;
            }
            this.onChanged();
        } else {
            ((SingleFieldBuilderV3)object).mergeFrom(messages$JsonObjectMessage);
        }
        this.bitField1_ = n10 = this.bitField1_ | n11;
        return this;
    }

    public Messages$ConvCommand$Builder removeFailedPids(int n10) {
        Object object = this.failedPidsBuilder_;
        if (object == null) {
            this.ensureFailedPidsIsMutable();
            object = this.failedPids_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public Messages$ConvCommand$Builder removeMaxReadTuples(int n10) {
        Object object = this.maxReadTuplesBuilder_;
        if (object == null) {
            this.ensureMaxReadTuplesIsMutable();
            object = this.maxReadTuples_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public Messages$ConvCommand$Builder setAllowedPids(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureAllowedPidsIsMutable();
        this.allowedPids_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setAttr(Messages$JsonObjectMessage$Builder messages$JsonObjectMessageOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.attrBuilder_;
        if (singleFieldBuilderV3 == null) {
            messages$JsonObjectMessageOrBuilder = messages$JsonObjectMessageOrBuilder.build();
            this.attr_ = messages$JsonObjectMessageOrBuilder;
            this.onChanged();
        } else {
            messages$JsonObjectMessageOrBuilder = messages$JsonObjectMessageOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)messages$JsonObjectMessageOrBuilder));
        }
        this.bitField1_ = n10 = this.bitField1_ | 8;
        return this;
    }

    public Messages$ConvCommand$Builder setAttr(Messages$JsonObjectMessage messages$JsonObjectMessage) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.attrBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(messages$JsonObjectMessage);
            this.attr_ = messages$JsonObjectMessage;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(messages$JsonObjectMessage);
        }
        this.bitField1_ = n10 = this.bitField1_ | 8;
        return this;
    }

    public Messages$ConvCommand$Builder setAttrModified(Messages$JsonObjectMessage$Builder messages$JsonObjectMessageOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.attrModifiedBuilder_;
        if (singleFieldBuilderV3 == null) {
            messages$JsonObjectMessageOrBuilder = messages$JsonObjectMessageOrBuilder.build();
            this.attrModified_ = messages$JsonObjectMessageOrBuilder;
            this.onChanged();
        } else {
            messages$JsonObjectMessageOrBuilder = messages$JsonObjectMessageOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)messages$JsonObjectMessageOrBuilder));
        }
        this.bitField1_ = n10 = this.bitField1_ | 0x10;
        return this;
    }

    public Messages$ConvCommand$Builder setAttrModified(Messages$JsonObjectMessage messages$JsonObjectMessage) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.attrModifiedBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(messages$JsonObjectMessage);
            this.attrModified_ = messages$JsonObjectMessage;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(messages$JsonObjectMessage);
        }
        this.bitField1_ = n10 = this.bitField1_ | 0x10;
        return this;
    }

    public Messages$ConvCommand$Builder setCdate(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x10;
        this.cdate_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setCdateBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x10;
        this.cdate_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setCid(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.cid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setCidBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.cid_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setCids(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureCidsIsMutable();
        this.cids_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setCount(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 0x400;
        this.count_ = n10;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setExisting(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | -1 << -1;
        this.existing_ = bl2;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setFailedPids(int n10, Messages$ErrorCommand$Builder messages$ErrorCommandOrBuilder) {
        Object object = this.failedPidsBuilder_;
        if (object == null) {
            this.ensureFailedPidsIsMutable();
            object = this.failedPids_;
            messages$ErrorCommandOrBuilder = ((Messages$ErrorCommand$Builder)messages$ErrorCommandOrBuilder).build();
            object.set(n10, messages$ErrorCommandOrBuilder);
            this.onChanged();
        } else {
            messages$ErrorCommandOrBuilder = ((Messages$ErrorCommand$Builder)messages$ErrorCommandOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)((Object)messages$ErrorCommandOrBuilder));
        }
        return this;
    }

    public Messages$ConvCommand$Builder setFailedPids(int n10, Messages$ErrorCommand messages$ErrorCommand) {
        Object object = this.failedPidsBuilder_;
        if (object == null) {
            Objects.requireNonNull(messages$ErrorCommand);
            this.ensureFailedPidsIsMutable();
            object = this.failedPids_;
            object.set(n10, messages$ErrorCommand);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, messages$ErrorCommand);
        }
        return this;
    }

    public Messages$ConvCommand$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$ConvCommand$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Messages$ConvCommand$Builder setFlag(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 0x200;
        this.flag_ = n10;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setInfo(Messages$ConvMemberInfo$Builder messages$ConvMemberInfoOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.infoBuilder_;
        if (singleFieldBuilderV3 == null) {
            messages$ConvMemberInfoOrBuilder = messages$ConvMemberInfoOrBuilder.build();
            this.info_ = messages$ConvMemberInfoOrBuilder;
            this.onChanged();
        } else {
            messages$ConvMemberInfoOrBuilder = messages$ConvMemberInfoOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)messages$ConvMemberInfoOrBuilder));
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x2000000;
        return this;
    }

    public Messages$ConvCommand$Builder setInfo(Messages$ConvMemberInfo messages$ConvMemberInfo) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.infoBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(messages$ConvMemberInfo);
            this.info_ = messages$ConvMemberInfo;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(messages$ConvMemberInfo);
        }
        this.bitField0_ = n10 = this.bitField0_ | 0x2000000;
        return this;
    }

    public Messages$ConvCommand$Builder setInitBy(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x20;
        this.initBy_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setInitByBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x20;
        this.initBy_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setLimit(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 0x80;
        this.limit_ = n10;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setM(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureMIsMutable();
        this.m_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setMaxAckTimestamp(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x200000;
        this.maxAckTimestamp_ = l10;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setMaxReadTimestamp(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x100000;
        this.maxReadTimestamp_ = l10;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setMaxReadTuples(int n10, Messages$MaxReadTuple$Builder messages$MaxReadTupleOrBuilder) {
        Object object = this.maxReadTuplesBuilder_;
        if (object == null) {
            this.ensureMaxReadTuplesIsMutable();
            object = this.maxReadTuples_;
            messages$MaxReadTupleOrBuilder = ((Messages$MaxReadTuple$Builder)messages$MaxReadTupleOrBuilder).build();
            object.set(n10, messages$MaxReadTupleOrBuilder);
            this.onChanged();
        } else {
            messages$MaxReadTupleOrBuilder = ((Messages$MaxReadTuple$Builder)messages$MaxReadTupleOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)((Object)messages$MaxReadTupleOrBuilder));
        }
        return this;
    }

    public Messages$ConvCommand$Builder setMaxReadTuples(int n10, Messages$MaxReadTuple messages$MaxReadTuple) {
        Object object = this.maxReadTuplesBuilder_;
        if (object == null) {
            Objects.requireNonNull(messages$MaxReadTuple);
            this.ensureMaxReadTuplesIsMutable();
            object = this.maxReadTuples_;
            object.set(n10, messages$MaxReadTuple);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, messages$MaxReadTuple);
        }
        return this;
    }

    public Messages$ConvCommand$Builder setN(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x2000;
        this.n_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setNBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x2000;
        this.n_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setNext(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField1_ = n10 = this.bitField1_ | 1;
        this.next_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setNextBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField1_ = n10 = this.bitField1_ | 1;
        this.next_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setQueryAllMembers(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x400000;
        this.queryAllMembers_ = bl2;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Messages$ConvCommand$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public Messages$ConvCommand$Builder setResults(Messages$JsonObjectMessage$Builder messages$JsonObjectMessageOrBuilder) {
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
        this.bitField1_ = n10 = this.bitField1_ | 2;
        return this;
    }

    public Messages$ConvCommand$Builder setResults(Messages$JsonObjectMessage messages$JsonObjectMessage) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.resultsBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(messages$JsonObjectMessage);
            this.results_ = messages$JsonObjectMessage;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(messages$JsonObjectMessage);
        }
        this.bitField1_ = n10 = this.bitField1_ | 2;
        return this;
    }

    public Messages$ConvCommand$Builder setS(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x4000;
        this.s_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setSBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x4000;
        this.s_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setSkip(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 0x100;
        this.skip_ = n10;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setSort(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x40;
        this.sort_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setSortBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x40;
        this.sort_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setStatusPub(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x10000;
        this.statusPub_ = bl2;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setStatusSub(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x8000;
        this.statusSub_ = bl2;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setStatusTTL(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 0x20000;
        this.statusTTL_ = n10;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setT(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x1000;
        this.t_ = l10;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setTargetClientId(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x80000;
        this.targetClientId_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setTargetClientIdBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x80000;
        this.targetClientId_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setTempConv(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x4000000;
        this.tempConv_ = bl2;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setTempConvIds(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureTempConvIdsIsMutable();
        this.tempConvIds_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setTempConvTTL(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 0x8000000;
        this.tempConvTTL_ = n10;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setTransient(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.transient_ = bl2;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setUdate(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x800;
        this.udate_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setUdateBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x800;
        this.udate_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setUnique(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.unique_ = bl2;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setUniqueId(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x40000;
        this.uniqueId_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$ConvCommand$Builder setUniqueIdBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x40000;
        this.uniqueId_ = byteString;
        this.onChanged();
        return this;
    }

    public final Messages$ConvCommand$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$ConvCommand$Builder)super.setUnknownFields(unknownFieldSet);
    }

    public Messages$ConvCommand$Builder setWhere(Messages$JsonObjectMessage$Builder messages$JsonObjectMessageOrBuilder) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.whereBuilder_;
        if (singleFieldBuilderV3 == null) {
            messages$JsonObjectMessageOrBuilder = messages$JsonObjectMessageOrBuilder.build();
            this.where_ = messages$JsonObjectMessageOrBuilder;
            this.onChanged();
        } else {
            messages$JsonObjectMessageOrBuilder = messages$JsonObjectMessageOrBuilder.build();
            singleFieldBuilderV3.setMessage((AbstractMessage)((Object)messages$JsonObjectMessageOrBuilder));
        }
        this.bitField1_ = n10 = this.bitField1_ | 4;
        return this;
    }

    public Messages$ConvCommand$Builder setWhere(Messages$JsonObjectMessage messages$JsonObjectMessage) {
        int n10;
        SingleFieldBuilderV3 singleFieldBuilderV3 = this.whereBuilder_;
        if (singleFieldBuilderV3 == null) {
            Objects.requireNonNull(messages$JsonObjectMessage);
            this.where_ = messages$JsonObjectMessage;
            this.onChanged();
        } else {
            singleFieldBuilderV3.setMessage(messages$JsonObjectMessage);
        }
        this.bitField1_ = n10 = this.bitField1_ | 4;
        return this;
    }
}

