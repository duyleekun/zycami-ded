/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$PatchItem;
import cn.leancloud.Messages$PatchItemOrBuilder;
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

public final class Messages$PatchItem$Builder
extends GeneratedMessageV3$Builder
implements Messages$PatchItemOrBuilder {
    private ByteString binaryMsg_;
    private int bitField0_;
    private Object cid_;
    private Object data_;
    private Object from_;
    private boolean mentionAll_;
    private LazyStringList mentionPids_;
    private Object mid_;
    private long patchCode_;
    private Object patchReason_;
    private long patchTimestamp_;
    private boolean recall_;
    private long timestamp_;

    private Messages$PatchItem$Builder() {
        Iterable iterable;
        String string2 = "";
        this.cid_ = string2;
        this.mid_ = string2;
        this.data_ = string2;
        this.from_ = string2;
        this.binaryMsg_ = iterable = ByteString.EMPTY;
        iterable = LazyStringArrayList.EMPTY;
        this.mentionPids_ = iterable;
        this.patchReason_ = string2;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$PatchItem$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$PatchItem$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        Iterable iterable;
        this.cid_ = object = "";
        this.mid_ = object;
        this.data_ = object;
        this.from_ = object;
        this.binaryMsg_ = iterable = ByteString.EMPTY;
        iterable = LazyStringArrayList.EMPTY;
        this.mentionPids_ = iterable;
        this.patchReason_ = object;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$PatchItem$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureMentionPidsIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 512;
        if ((n10 &= n11) != n11) {
            LazyStringList lazyStringList = this.mentionPids_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.mentionPids_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$40100();
    }

    private void maybeForceBuilderInitialization() {
        Messages$PatchItem.access$40500();
    }

    public Messages$PatchItem$Builder addAllMentionPids(Iterable iterable) {
        this.ensureMentionPidsIsMutable();
        LazyStringList lazyStringList = this.mentionPids_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder addMentionPids(String string2) {
        Objects.requireNonNull(string2);
        this.ensureMentionPidsIsMutable();
        this.mentionPids_.add(string2);
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder addMentionPidsBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensureMentionPidsIsMutable();
        this.mentionPids_.add(byteString);
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$PatchItem$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Messages$PatchItem build() {
        Messages$PatchItem messages$PatchItem = this.buildPartial();
        boolean bl2 = messages$PatchItem.isInitialized();
        if (bl2) {
            return messages$PatchItem;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$PatchItem);
    }

    public Messages$PatchItem buildPartial() {
        Object object = null;
        Messages$PatchItem messages$PatchItem = new Messages$PatchItem(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        int n12 = 1;
        if (n11 != n12) {
            n12 = 0;
        }
        Object object2 = this.cid_;
        Messages$PatchItem.access$40702(messages$PatchItem, object2);
        n11 = n10 & 2;
        int n13 = 2;
        if (n11 == n13) {
            n12 |= 2;
        }
        object2 = this.mid_;
        Messages$PatchItem.access$40802(messages$PatchItem, object2);
        n11 = n10 & 4;
        n13 = 4;
        if (n11 == n13) {
            n12 |= 4;
        }
        long l10 = this.timestamp_;
        Messages$PatchItem.access$40902(messages$PatchItem, l10);
        n11 = n10 & 8;
        n13 = 8;
        if (n11 == n13) {
            n12 |= 8;
        }
        n11 = (int)(this.recall_ ? 1 : 0);
        Messages$PatchItem.access$41002(messages$PatchItem, n11 != 0);
        n11 = n10 & 0x10;
        n13 = 16;
        if (n11 == n13) {
            n12 |= 0x10;
        }
        object2 = this.data_;
        Messages$PatchItem.access$41102(messages$PatchItem, object2);
        n11 = n10 & 0x20;
        n13 = 32;
        if (n11 == n13) {
            n12 |= 0x20;
        }
        l10 = this.patchTimestamp_;
        Messages$PatchItem.access$41202(messages$PatchItem, l10);
        n11 = n10 & 0x40;
        n13 = 64;
        if (n11 == n13) {
            n12 |= 0x40;
        }
        object2 = this.from_;
        Messages$PatchItem.access$41302(messages$PatchItem, object2);
        n11 = n10 & 0x80;
        n13 = 128;
        if (n11 == n13) {
            n12 |= 0x80;
        }
        object2 = this.binaryMsg_;
        Messages$PatchItem.access$41402(messages$PatchItem, (ByteString)object2);
        n11 = n10 & 0x100;
        n13 = 256;
        if (n11 == n13) {
            n12 |= 0x100;
        }
        n11 = (int)(this.mentionAll_ ? 1 : 0);
        Messages$PatchItem.access$41502(messages$PatchItem, n11 != 0);
        n11 = this.bitField0_;
        n13 = 512;
        if ((n11 &= n13) == n13) {
            this.mentionPids_ = object2 = this.mentionPids_.getUnmodifiableView();
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFDFF;
        }
        object2 = this.mentionPids_;
        Messages$PatchItem.access$41602(messages$PatchItem, (LazyStringList)object2);
        n11 = n10 & 0x400;
        n13 = 1024;
        if (n11 == n13) {
            n12 |= 0x200;
        }
        l10 = this.patchCode_;
        Messages$PatchItem.access$41702(messages$PatchItem, l10);
        n11 = 2048;
        if ((n10 &= n11) == n11) {
            n12 |= 0x400;
        }
        object = this.patchReason_;
        Messages$PatchItem.access$41802(messages$PatchItem, object);
        Messages$PatchItem.access$41902(messages$PatchItem, n12);
        this.onBuilt();
        return messages$PatchItem;
    }

    public Messages$PatchItem$Builder clear() {
        int n10;
        LazyStringList lazyStringList;
        ByteString byteString;
        long l10;
        int n11;
        super.clear();
        String string2 = "";
        this.cid_ = string2;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        this.mid_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFFD;
        this.timestamp_ = l10 = 0L;
        this.bitField0_ = n11 &= 0xFFFFFFFB;
        this.recall_ = false;
        this.bitField0_ = n11 &= 0xFFFFFFF7;
        this.data_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFEF;
        this.patchTimestamp_ = l10;
        this.bitField0_ = n11 &= 0xFFFFFFDF;
        this.from_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFBF;
        this.binaryMsg_ = byteString = ByteString.EMPTY;
        this.bitField0_ = n11 &= 0xFFFFFF7F;
        this.mentionAll_ = false;
        this.bitField0_ = n11 &= 0xFFFFFEFF;
        this.mentionPids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n11 &= 0xFFFFFDFF;
        this.patchCode_ = l10;
        this.bitField0_ = n11 &= 0xFFFFFBFF;
        this.patchReason_ = string2;
        this.bitField0_ = n10 = n11 & 0xFFFFF7FF;
        return this;
    }

    public Messages$PatchItem$Builder clearBinaryMsg() {
        ByteString byteString;
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFF7F;
        this.binaryMsg_ = byteString = Messages$PatchItem.getDefaultInstance().getBinaryMsg();
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder clearCid() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = Messages$PatchItem.getDefaultInstance().getCid();
        this.cid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder clearData() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        String string2 = Messages$PatchItem.getDefaultInstance().getData();
        this.data_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Messages$PatchItem$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Messages$PatchItem$Builder clearFrom() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFBF;
        String string2 = Messages$PatchItem.getDefaultInstance().getFrom();
        this.from_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder clearMentionAll() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFEFF;
        this.mentionAll_ = false;
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder clearMentionPids() {
        int n10;
        LazyStringList lazyStringList;
        this.mentionPids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFDFF;
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder clearMid() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        String string2 = Messages$PatchItem.getDefaultInstance().getMid();
        this.mid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Messages$PatchItem$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Messages$PatchItem$Builder clearPatchCode() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFBFF;
        this.patchCode_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder clearPatchReason() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFF7FF;
        String string2 = Messages$PatchItem.getDefaultInstance().getPatchReason();
        this.patchReason_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder clearPatchTimestamp() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
        this.patchTimestamp_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder clearRecall() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        this.recall_ = false;
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder clearTimestamp() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        this.timestamp_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder clone() {
        return (Messages$PatchItem$Builder)super.clone();
    }

    public ByteString getBinaryMsg() {
        return this.binaryMsg_;
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

    public String getData() {
        Object object = this.data_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.data_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getDataBytes() {
        Object object = this.data_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.data_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Messages$PatchItem getDefaultInstanceForType() {
        return Messages$PatchItem.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$40100();
    }

    public String getFrom() {
        Object object = this.from_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.from_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getFromBytes() {
        Object object = this.from_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.from_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public boolean getMentionAll() {
        return this.mentionAll_;
    }

    public String getMentionPids(int n10) {
        return (String)this.mentionPids_.get(n10);
    }

    public ByteString getMentionPidsBytes(int n10) {
        return this.mentionPids_.getByteString(n10);
    }

    public int getMentionPidsCount() {
        return this.mentionPids_.size();
    }

    public ProtocolStringList getMentionPidsList() {
        return this.mentionPids_.getUnmodifiableView();
    }

    public String getMid() {
        Object object = this.mid_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.mid_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getMidBytes() {
        Object object = this.mid_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.mid_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public long getPatchCode() {
        return this.patchCode_;
    }

    public String getPatchReason() {
        Object object = this.patchReason_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.patchReason_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getPatchReasonBytes() {
        Object object = this.patchReason_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.patchReason_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public long getPatchTimestamp() {
        return this.patchTimestamp_;
    }

    public boolean getRecall() {
        return this.recall_;
    }

    public long getTimestamp() {
        return this.timestamp_;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasBinaryMsg() {
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
    public boolean hasData() {
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
    public boolean hasFrom() {
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
    public boolean hasMentionAll() {
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
    public boolean hasMid() {
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
    public boolean hasPatchCode() {
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

    /*
     * WARNING - void declaration
     */
    public boolean hasPatchReason() {
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
    public boolean hasPatchTimestamp() {
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
    public boolean hasRecall() {
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
    public boolean hasTimestamp() {
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
        return Messages.access$40200().ensureFieldAccessorsInitialized(Messages$PatchItem.class, Messages$PatchItem$Builder.class);
    }

    public final boolean isInitialized() {
        return true;
    }

    public Messages$PatchItem$Builder mergeFrom(Messages$PatchItem messageLite) {
        long l10;
        Object object = Messages$PatchItem.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasCid();
        if (n10 != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 1;
            this.cid_ = object = Messages$PatchItem.access$40700(messageLite);
            this.onChanged();
        }
        if ((n10 = messageLite.hasMid()) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 2;
            this.mid_ = object = Messages$PatchItem.access$40800(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasTimestamp() ? 1 : 0)) != 0) {
            l10 = messageLite.getTimestamp();
            this.setTimestamp(l10);
        }
        if ((n10 = (int)(messageLite.hasRecall() ? 1 : 0)) != 0) {
            n10 = (int)(messageLite.getRecall() ? 1 : 0);
            this.setRecall(n10 != 0);
        }
        if ((n10 = (int)(messageLite.hasData() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x10;
            this.data_ = object = Messages$PatchItem.access$41100(messageLite);
            this.onChanged();
        }
        if ((n10 = messageLite.hasPatchTimestamp()) != 0) {
            l10 = messageLite.getPatchTimestamp();
            this.setPatchTimestamp(l10);
        }
        if ((n10 = (int)(messageLite.hasFrom() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x40;
            this.from_ = object = Messages$PatchItem.access$41300(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasBinaryMsg() ? 1 : 0)) != 0) {
            object = messageLite.getBinaryMsg();
            this.setBinaryMsg((ByteString)object);
        }
        if ((n10 = (int)(messageLite.hasMentionAll() ? 1 : 0)) != 0) {
            n10 = (int)(messageLite.getMentionAll() ? 1 : 0);
            this.setMentionAll(n10 != 0);
        }
        if ((n10 = (object = Messages$PatchItem.access$41600(messageLite)).isEmpty()) == 0) {
            object = this.mentionPids_;
            n10 = object.isEmpty();
            if (n10 != 0) {
                this.mentionPids_ = object = Messages$PatchItem.access$41600(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFDFF;
            } else {
                this.ensureMentionPidsIsMutable();
                object = this.mentionPids_;
                LazyStringList lazyStringList = Messages$PatchItem.access$41600(messageLite);
                object.addAll(lazyStringList);
            }
            this.onChanged();
        }
        if ((n10 = messageLite.hasPatchCode()) != 0) {
            l10 = messageLite.getPatchCode();
            this.setPatchCode(l10);
        }
        if ((n10 = messageLite.hasPatchReason()) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x800;
            this.patchReason_ = object = Messages$PatchItem.access$41800(messageLite);
            this.onChanged();
        }
        messageLite = Messages$PatchItem.access$42000(messageLite);
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
    public Messages$PatchItem$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$PatchItem.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$PatchItem)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$PatchItem)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$PatchItem)object2;
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
            this.mergeFrom((Messages$PatchItem)object3);
        }
        throw var1_6;
    }

    public Messages$PatchItem$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$PatchItem;
        if (bl2) {
            message = (Messages$PatchItem)message;
            return this.mergeFrom((Messages$PatchItem)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Messages$PatchItem$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$PatchItem$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$PatchItem$Builder setBinaryMsg(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x80;
        this.binaryMsg_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder setCid(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.cid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder setCidBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.cid_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder setData(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x10;
        this.data_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder setDataBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x10;
        this.data_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$PatchItem$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Messages$PatchItem$Builder setFrom(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x40;
        this.from_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder setFromBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x40;
        this.from_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder setMentionAll(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x100;
        this.mentionAll_ = bl2;
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder setMentionPids(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureMentionPidsIsMutable();
        this.mentionPids_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder setMid(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.mid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder setMidBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.mid_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder setPatchCode(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x400;
        this.patchCode_ = l10;
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder setPatchReason(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x800;
        this.patchReason_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder setPatchReasonBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x800;
        this.patchReason_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder setPatchTimestamp(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x20;
        this.patchTimestamp_ = l10;
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder setRecall(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.recall_ = bl2;
        this.onChanged();
        return this;
    }

    public Messages$PatchItem$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Messages$PatchItem$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public Messages$PatchItem$Builder setTimestamp(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.timestamp_ = l10;
        this.onChanged();
        return this;
    }

    public final Messages$PatchItem$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$PatchItem$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

