/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$BlacklistCommand;
import cn.leancloud.Messages$BlacklistCommandOrBuilder;
import cn.leancloud.Messages$ErrorCommand;
import cn.leancloud.Messages$ErrorCommand$Builder;
import cn.leancloud.Messages$ErrorCommandOrBuilder;
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

public final class Messages$BlacklistCommand$Builder
extends GeneratedMessageV3$Builder
implements Messages$BlacklistCommandOrBuilder {
    private LazyStringList allowedPids_;
    private int bitField0_;
    private LazyStringList blockedCids_;
    private LazyStringList blockedPids_;
    private RepeatedFieldBuilderV3 failedPidsBuilder_;
    private List failedPids_;
    private int limit_;
    private Object n_;
    private Object next_;
    private Object s_;
    private Object srcCid_;
    private Object srcPid_;
    private long t_;
    private LazyStringList toCids_;
    private LazyStringList toPids_;

    private Messages$BlacklistCommand$Builder() {
        List list;
        String string2 = "";
        this.srcCid_ = string2;
        this.toPids_ = list = LazyStringArrayList.EMPTY;
        this.srcPid_ = string2;
        this.toCids_ = list;
        this.next_ = string2;
        this.blockedPids_ = list;
        this.blockedCids_ = list;
        this.allowedPids_ = list;
        list = Collections.emptyList();
        this.failedPids_ = list;
        this.n_ = string2;
        this.s_ = string2;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$BlacklistCommand$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$BlacklistCommand$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        List list;
        this.srcCid_ = object = "";
        this.toPids_ = list = LazyStringArrayList.EMPTY;
        this.srcPid_ = object;
        this.toCids_ = list;
        this.next_ = object;
        this.blockedPids_ = list;
        this.blockedCids_ = list;
        this.allowedPids_ = list;
        list = Collections.emptyList();
        this.failedPids_ = list;
        this.n_ = object;
        this.s_ = object;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$BlacklistCommand$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureAllowedPidsIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 256;
        if ((n10 &= n11) != n11) {
            LazyStringList lazyStringList = this.allowedPids_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.allowedPids_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    private void ensureBlockedCidsIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 128;
        if ((n10 &= n11) != n11) {
            LazyStringList lazyStringList = this.blockedCids_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.blockedCids_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    private void ensureBlockedPidsIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 64;
        if ((n10 &= n11) != n11) {
            LazyStringList lazyStringList = this.blockedPids_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.blockedPids_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    private void ensureFailedPidsIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 512;
        if ((n10 &= n11) != n11) {
            ArrayList arrayList;
            List list = this.failedPids_;
            this.failedPids_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    private void ensureToCidsIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 8;
        if ((n10 &= n11) != n11) {
            LazyStringList lazyStringList = this.toCids_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.toCids_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    private void ensureToPidsIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 2;
        if ((n10 &= n11) != n11) {
            LazyStringList lazyStringList = this.toPids_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.toPids_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$45000();
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
            int n10 = 512;
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

    private void maybeForceBuilderInitialization() {
        boolean bl2 = Messages$BlacklistCommand.access$45400();
        if (bl2) {
            this.getFailedPidsFieldBuilder();
        }
    }

    public Messages$BlacklistCommand$Builder addAllAllowedPids(Iterable iterable) {
        this.ensureAllowedPidsIsMutable();
        LazyStringList lazyStringList = this.allowedPids_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder addAllBlockedCids(Iterable iterable) {
        this.ensureBlockedCidsIsMutable();
        LazyStringList lazyStringList = this.blockedCids_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder addAllBlockedPids(Iterable iterable) {
        this.ensureBlockedPidsIsMutable();
        LazyStringList lazyStringList = this.blockedPids_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder addAllFailedPids(Iterable iterable) {
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

    public Messages$BlacklistCommand$Builder addAllToCids(Iterable iterable) {
        this.ensureToCidsIsMutable();
        LazyStringList lazyStringList = this.toCids_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder addAllToPids(Iterable iterable) {
        this.ensureToPidsIsMutable();
        LazyStringList lazyStringList = this.toPids_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder addAllowedPids(String string2) {
        Objects.requireNonNull(string2);
        this.ensureAllowedPidsIsMutable();
        this.allowedPids_.add(string2);
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder addAllowedPidsBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensureAllowedPidsIsMutable();
        this.allowedPids_.add(byteString);
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder addBlockedCids(String string2) {
        Objects.requireNonNull(string2);
        this.ensureBlockedCidsIsMutable();
        this.blockedCids_.add(string2);
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder addBlockedCidsBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensureBlockedCidsIsMutable();
        this.blockedCids_.add(byteString);
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder addBlockedPids(String string2) {
        Objects.requireNonNull(string2);
        this.ensureBlockedPidsIsMutable();
        this.blockedPids_.add(string2);
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder addBlockedPidsBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensureBlockedPidsIsMutable();
        this.blockedPids_.add(byteString);
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder addFailedPids(int n10, Messages$ErrorCommand$Builder messages$ErrorCommandOrBuilder) {
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

    public Messages$BlacklistCommand$Builder addFailedPids(int n10, Messages$ErrorCommand messages$ErrorCommand) {
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

    public Messages$BlacklistCommand$Builder addFailedPids(Messages$ErrorCommand$Builder messages$ErrorCommandOrBuilder) {
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

    public Messages$BlacklistCommand$Builder addFailedPids(Messages$ErrorCommand messages$ErrorCommand) {
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

    public Messages$BlacklistCommand$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$BlacklistCommand$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Messages$BlacklistCommand$Builder addToCids(String string2) {
        Objects.requireNonNull(string2);
        this.ensureToCidsIsMutable();
        this.toCids_.add(string2);
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder addToCidsBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensureToCidsIsMutable();
        this.toCids_.add(byteString);
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder addToPids(String string2) {
        Objects.requireNonNull(string2);
        this.ensureToPidsIsMutable();
        this.toPids_.add(string2);
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder addToPidsBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensureToPidsIsMutable();
        this.toPids_.add(byteString);
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand build() {
        Messages$BlacklistCommand messages$BlacklistCommand = this.buildPartial();
        boolean bl2 = messages$BlacklistCommand.isInitialized();
        if (bl2) {
            return messages$BlacklistCommand;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$BlacklistCommand);
    }

    public Messages$BlacklistCommand buildPartial() {
        Object object = null;
        Messages$BlacklistCommand messages$BlacklistCommand = new Messages$BlacklistCommand(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        int n12 = 1;
        if (n11 != n12) {
            n12 = 0;
        }
        Object object2 = this.srcCid_;
        Messages$BlacklistCommand.access$45602(messages$BlacklistCommand, object2);
        n11 = this.bitField0_;
        int n13 = 2;
        if ((n11 &= n13) == n13) {
            this.toPids_ = object2 = this.toPids_.getUnmodifiableView();
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFD;
        }
        object2 = this.toPids_;
        Messages$BlacklistCommand.access$45702(messages$BlacklistCommand, (LazyStringList)object2);
        n11 = n10 & 4;
        n13 = 4;
        if (n11 == n13) {
            n12 |= 2;
        }
        object2 = this.srcPid_;
        Messages$BlacklistCommand.access$45802(messages$BlacklistCommand, object2);
        n11 = this.bitField0_;
        n13 = 8;
        if ((n11 &= n13) == n13) {
            this.toCids_ = object2 = this.toCids_.getUnmodifiableView();
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFF7;
        }
        object2 = this.toCids_;
        Messages$BlacklistCommand.access$45902(messages$BlacklistCommand, (LazyStringList)object2);
        n11 = n10 & 0x10;
        n13 = 16;
        if (n11 == n13) {
            n12 |= 4;
        }
        n11 = this.limit_;
        Messages$BlacklistCommand.access$46002(messages$BlacklistCommand, n11);
        n11 = n10 & 0x20;
        n13 = 32;
        if (n11 == n13) {
            n12 |= 8;
        }
        object2 = this.next_;
        Messages$BlacklistCommand.access$46102(messages$BlacklistCommand, object2);
        n11 = this.bitField0_;
        n13 = 64;
        if ((n11 &= n13) == n13) {
            this.blockedPids_ = object2 = this.blockedPids_.getUnmodifiableView();
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFBF;
        }
        object2 = this.blockedPids_;
        Messages$BlacklistCommand.access$46202(messages$BlacklistCommand, (LazyStringList)object2);
        n11 = this.bitField0_;
        n13 = 128;
        if ((n11 &= n13) == n13) {
            this.blockedCids_ = object2 = this.blockedCids_.getUnmodifiableView();
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFF7F;
        }
        object2 = this.blockedCids_;
        Messages$BlacklistCommand.access$46302(messages$BlacklistCommand, (LazyStringList)object2);
        n11 = this.bitField0_;
        n13 = 256;
        if ((n11 &= n13) == n13) {
            this.allowedPids_ = object2 = this.allowedPids_.getUnmodifiableView();
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFEFF;
        }
        object2 = this.allowedPids_;
        Messages$BlacklistCommand.access$46402(messages$BlacklistCommand, (LazyStringList)object2);
        object2 = this.failedPidsBuilder_;
        if (object2 == null) {
            n11 = this.bitField0_;
            n13 = 512;
            if ((n11 &= n13) == n13) {
                object2 = Collections.unmodifiableList(this.failedPids_);
                this.failedPids_ = object2;
                this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFDFF;
            }
            object2 = this.failedPids_;
            Messages$BlacklistCommand.access$46502(messages$BlacklistCommand, object2);
        } else {
            object2 = ((RepeatedFieldBuilderV3)object2).build();
            Messages$BlacklistCommand.access$46502(messages$BlacklistCommand, (List)object2);
        }
        n11 = n10 & 0x400;
        n13 = 1024;
        if (n11 == n13) {
            n12 |= 0x10;
        }
        long l10 = this.t_;
        Messages$BlacklistCommand.access$46602(messages$BlacklistCommand, l10);
        n11 = n10 & 0x800;
        n13 = 2048;
        if (n11 == n13) {
            n12 |= 0x20;
        }
        object2 = this.n_;
        Messages$BlacklistCommand.access$46702(messages$BlacklistCommand, object2);
        n11 = 4096;
        if ((n10 &= n11) == n11) {
            n12 |= 0x40;
        }
        object = this.s_;
        Messages$BlacklistCommand.access$46802(messages$BlacklistCommand, object);
        Messages$BlacklistCommand.access$46902(messages$BlacklistCommand, n12);
        this.onBuilt();
        return messages$BlacklistCommand;
    }

    public Messages$BlacklistCommand$Builder clear() {
        int n10;
        LazyStringList lazyStringList;
        int n11;
        super.clear();
        String string2 = "";
        this.srcCid_ = string2;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        this.toPids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n11 &= 0xFFFFFFFD;
        this.srcPid_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFFB;
        this.toCids_ = lazyStringList;
        this.bitField0_ = n11 &= 0xFFFFFFF7;
        this.limit_ = 0;
        this.bitField0_ = n11 &= 0xFFFFFFEF;
        this.next_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFDF;
        this.blockedPids_ = lazyStringList;
        this.bitField0_ = n11 &= 0xFFFFFFBF;
        this.blockedCids_ = lazyStringList;
        this.bitField0_ = n11 &= 0xFFFFFF7F;
        this.allowedPids_ = lazyStringList;
        this.bitField0_ = n11 &= 0xFFFFFEFF;
        Object object = this.failedPidsBuilder_;
        if (object == null) {
            this.failedPids_ = object = Collections.emptyList();
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFDFF;
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        this.t_ = 0L;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFBFF;
        this.n_ = string2;
        this.bitField0_ = n11 &= 0xFFFFF7FF;
        this.s_ = string2;
        this.bitField0_ = n10 = n11 & 0xFFFFEFFF;
        return this;
    }

    public Messages$BlacklistCommand$Builder clearAllowedPids() {
        int n10;
        LazyStringList lazyStringList;
        this.allowedPids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFEFF;
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder clearBlockedCids() {
        int n10;
        LazyStringList lazyStringList;
        this.blockedCids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFF7F;
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder clearBlockedPids() {
        int n10;
        LazyStringList lazyStringList;
        this.blockedPids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFBF;
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder clearFailedPids() {
        Object object = this.failedPidsBuilder_;
        if (object == null) {
            int n10;
            this.failedPids_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFDFF;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public Messages$BlacklistCommand$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Messages$BlacklistCommand$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Messages$BlacklistCommand$Builder clearLimit() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        this.limit_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder clearN() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFF7FF;
        String string2 = Messages$BlacklistCommand.getDefaultInstance().getN();
        this.n_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder clearNext() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
        String string2 = Messages$BlacklistCommand.getDefaultInstance().getNext();
        this.next_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Messages$BlacklistCommand$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Messages$BlacklistCommand$Builder clearS() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFEFFF;
        String string2 = Messages$BlacklistCommand.getDefaultInstance().getS();
        this.s_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder clearSrcCid() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = Messages$BlacklistCommand.getDefaultInstance().getSrcCid();
        this.srcCid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder clearSrcPid() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        String string2 = Messages$BlacklistCommand.getDefaultInstance().getSrcPid();
        this.srcPid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder clearT() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFBFF;
        this.t_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder clearToCids() {
        int n10;
        LazyStringList lazyStringList;
        this.toCids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder clearToPids() {
        int n10;
        LazyStringList lazyStringList;
        this.toPids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder clone() {
        return (Messages$BlacklistCommand$Builder)super.clone();
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

    public String getBlockedCids(int n10) {
        return (String)this.blockedCids_.get(n10);
    }

    public ByteString getBlockedCidsBytes(int n10) {
        return this.blockedCids_.getByteString(n10);
    }

    public int getBlockedCidsCount() {
        return this.blockedCids_.size();
    }

    public ProtocolStringList getBlockedCidsList() {
        return this.blockedCids_.getUnmodifiableView();
    }

    public String getBlockedPids(int n10) {
        return (String)this.blockedPids_.get(n10);
    }

    public ByteString getBlockedPidsBytes(int n10) {
        return this.blockedPids_.getByteString(n10);
    }

    public int getBlockedPidsCount() {
        return this.blockedPids_.size();
    }

    public ProtocolStringList getBlockedPidsList() {
        return this.blockedPids_.getUnmodifiableView();
    }

    public Messages$BlacklistCommand getDefaultInstanceForType() {
        return Messages$BlacklistCommand.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$45000();
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

    public int getLimit() {
        return this.limit_;
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

    public String getSrcCid() {
        Object object = this.srcCid_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.srcCid_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getSrcCidBytes() {
        Object object = this.srcCid_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.srcCid_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getSrcPid() {
        Object object = this.srcPid_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.srcPid_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getSrcPidBytes() {
        Object object = this.srcPid_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.srcPid_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public long getT() {
        return this.t_;
    }

    public String getToCids(int n10) {
        return (String)this.toCids_.get(n10);
    }

    public ByteString getToCidsBytes(int n10) {
        return this.toCids_.getByteString(n10);
    }

    public int getToCidsCount() {
        return this.toCids_.size();
    }

    public ProtocolStringList getToCidsList() {
        return this.toCids_.getUnmodifiableView();
    }

    public String getToPids(int n10) {
        return (String)this.toPids_.get(n10);
    }

    public ByteString getToPidsBytes(int n10) {
        return this.toPids_.getByteString(n10);
    }

    public int getToPidsCount() {
        return this.toPids_.size();
    }

    public ProtocolStringList getToPidsList() {
        return this.toPids_.getUnmodifiableView();
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasLimit() {
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
    public boolean hasN() {
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
    public boolean hasNext() {
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
    public boolean hasS() {
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

    public boolean hasSrcCid() {
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
    public boolean hasSrcPid() {
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
    public boolean hasT() {
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

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$45100().ensureFieldAccessorsInitialized(Messages$BlacklistCommand.class, Messages$BlacklistCommand$Builder.class);
    }

    public final boolean isInitialized() {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.getFailedPidsCount()); ++i10) {
            Messages$ErrorCommand messages$ErrorCommand = this.getFailedPids(i10);
            n10 = (int)(messages$ErrorCommand.isInitialized() ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        return true;
    }

    public Messages$BlacklistCommand$Builder mergeFrom(Messages$BlacklistCommand messageLite) {
        List list;
        Object object = Messages$BlacklistCommand.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasSrcCid();
        if (n10 != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 1;
            this.srcCid_ = object = Messages$BlacklistCommand.access$45600(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)((object = Messages$BlacklistCommand.access$45700(messageLite)).isEmpty() ? 1 : 0)) == 0) {
            object = this.toPids_;
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 != 0) {
                this.toPids_ = object = Messages$BlacklistCommand.access$45700(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
            } else {
                this.ensureToPidsIsMutable();
                object = this.toPids_;
                list = Messages$BlacklistCommand.access$45700(messageLite);
                object.addAll(list);
            }
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasSrcPid() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 4;
            this.srcPid_ = object = Messages$BlacklistCommand.access$45800(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)((object = Messages$BlacklistCommand.access$45900(messageLite)).isEmpty() ? 1 : 0)) == 0) {
            object = this.toCids_;
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 != 0) {
                this.toCids_ = object = Messages$BlacklistCommand.access$45900(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
            } else {
                this.ensureToCidsIsMutable();
                object = this.toCids_;
                list = Messages$BlacklistCommand.access$45900(messageLite);
                object.addAll(list);
            }
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasLimit() ? 1 : 0)) != 0) {
            n10 = messageLite.getLimit();
            this.setLimit(n10);
        }
        if ((n10 = (int)(messageLite.hasNext() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x20;
            this.next_ = object = Messages$BlacklistCommand.access$46100(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)((object = Messages$BlacklistCommand.access$46200(messageLite)).isEmpty() ? 1 : 0)) == 0) {
            object = this.blockedPids_;
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 != 0) {
                this.blockedPids_ = object = Messages$BlacklistCommand.access$46200(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFBF;
            } else {
                this.ensureBlockedPidsIsMutable();
                object = this.blockedPids_;
                list = Messages$BlacklistCommand.access$46200(messageLite);
                object.addAll(list);
            }
            this.onChanged();
        }
        if ((n10 = (int)((object = Messages$BlacklistCommand.access$46300(messageLite)).isEmpty() ? 1 : 0)) == 0) {
            object = this.blockedCids_;
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 != 0) {
                this.blockedCids_ = object = Messages$BlacklistCommand.access$46300(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFF7F;
            } else {
                this.ensureBlockedCidsIsMutable();
                object = this.blockedCids_;
                list = Messages$BlacklistCommand.access$46300(messageLite);
                object.addAll(list);
            }
            this.onChanged();
        }
        if ((n10 = (int)((object = Messages$BlacklistCommand.access$46400(messageLite)).isEmpty() ? 1 : 0)) == 0) {
            object = this.allowedPids_;
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 != 0) {
                this.allowedPids_ = object = Messages$BlacklistCommand.access$46400(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFEFF;
            } else {
                this.ensureAllowedPidsIsMutable();
                object = this.allowedPids_;
                list = Messages$BlacklistCommand.access$46400(messageLite);
                object.addAll(list);
            }
            this.onChanged();
        }
        if ((object = this.failedPidsBuilder_) == null) {
            object = Messages$BlacklistCommand.access$46500(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.failedPids_;
                n10 = (int)(object.isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.failedPids_ = object = Messages$BlacklistCommand.access$46500(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFDFF;
                } else {
                    this.ensureFailedPidsIsMutable();
                    object = this.failedPids_;
                    list = Messages$BlacklistCommand.access$46500(messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = Messages$BlacklistCommand.access$46500(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.failedPidsBuilder_;
                n10 = (int)(((RepeatedFieldBuilderV3)object).isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    int n11;
                    this.failedPidsBuilder_.dispose();
                    n10 = 0;
                    object = null;
                    this.failedPidsBuilder_ = null;
                    list = Messages$BlacklistCommand.access$46500(messageLite);
                    this.failedPids_ = list;
                    this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFDFF;
                    n11 = (int)(Messages$BlacklistCommand.access$47000() ? 1 : 0);
                    if (n11 != 0) {
                        object = this.getFailedPidsFieldBuilder();
                    }
                    this.failedPidsBuilder_ = object;
                } else {
                    object = this.failedPidsBuilder_;
                    list = Messages$BlacklistCommand.access$46500(messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        if ((n10 = (int)(messageLite.hasT() ? 1 : 0)) != 0) {
            long l10 = messageLite.getT();
            this.setT(l10);
        }
        if ((n10 = (int)(messageLite.hasN() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x800;
            this.n_ = object = Messages$BlacklistCommand.access$46700(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasS() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x1000;
            this.s_ = object = Messages$BlacklistCommand.access$46800(messageLite);
            this.onChanged();
        }
        messageLite = Messages$BlacklistCommand.access$47100(messageLite);
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
    public Messages$BlacklistCommand$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$BlacklistCommand.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$BlacklistCommand)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$BlacklistCommand)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$BlacklistCommand)object2;
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
            this.mergeFrom((Messages$BlacklistCommand)object3);
        }
        throw var1_6;
    }

    public Messages$BlacklistCommand$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$BlacklistCommand;
        if (bl2) {
            message = (Messages$BlacklistCommand)message;
            return this.mergeFrom((Messages$BlacklistCommand)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Messages$BlacklistCommand$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$BlacklistCommand$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$BlacklistCommand$Builder removeFailedPids(int n10) {
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

    public Messages$BlacklistCommand$Builder setAllowedPids(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureAllowedPidsIsMutable();
        this.allowedPids_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder setBlockedCids(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureBlockedCidsIsMutable();
        this.blockedCids_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder setBlockedPids(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureBlockedPidsIsMutable();
        this.blockedPids_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder setFailedPids(int n10, Messages$ErrorCommand$Builder messages$ErrorCommandOrBuilder) {
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

    public Messages$BlacklistCommand$Builder setFailedPids(int n10, Messages$ErrorCommand messages$ErrorCommand) {
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

    public Messages$BlacklistCommand$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$BlacklistCommand$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Messages$BlacklistCommand$Builder setLimit(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 0x10;
        this.limit_ = n10;
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder setN(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x800;
        this.n_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder setNBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x800;
        this.n_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder setNext(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x20;
        this.next_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder setNextBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x20;
        this.next_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Messages$BlacklistCommand$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public Messages$BlacklistCommand$Builder setS(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x1000;
        this.s_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder setSBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x1000;
        this.s_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder setSrcCid(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.srcCid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder setSrcCidBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.srcCid_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder setSrcPid(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.srcPid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder setSrcPidBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.srcPid_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder setT(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x400;
        this.t_ = l10;
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder setToCids(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureToCidsIsMutable();
        this.toCids_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public Messages$BlacklistCommand$Builder setToPids(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureToPidsIsMutable();
        this.toPids_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public final Messages$BlacklistCommand$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$BlacklistCommand$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

