/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$AckCommand;
import cn.leancloud.Messages$AckCommandOrBuilder;
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

public final class Messages$AckCommand$Builder
extends GeneratedMessageV3$Builder
implements Messages$AckCommandOrBuilder {
    private int appCode_;
    private Object appMsg_;
    private int bitField0_;
    private Object cid_;
    private int code_;
    private long fromts_;
    private LazyStringList ids_;
    private Object mid_;
    private Object reason_;
    private long t_;
    private long tots_;
    private Object type_;
    private Object uid_;

    private Messages$AckCommand$Builder() {
        LazyStringList lazyStringList;
        String string2 = "";
        this.reason_ = string2;
        this.mid_ = string2;
        this.cid_ = string2;
        this.uid_ = string2;
        this.type_ = string2;
        this.ids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.appMsg_ = string2;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$AckCommand$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$AckCommand$Builder(GeneratedMessageV3$BuilderParent object) {
        super((GeneratedMessageV3$BuilderParent)object);
        LazyStringList lazyStringList;
        this.reason_ = object = "";
        this.mid_ = object;
        this.cid_ = object;
        this.uid_ = object;
        this.type_ = object;
        this.ids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.appMsg_ = object;
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$AckCommand$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureIdsIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 512;
        if ((n10 &= n11) != n11) {
            LazyStringList lazyStringList = this.ids_;
            LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(lazyStringList);
            this.ids_ = lazyStringArrayList;
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$20500();
    }

    private void maybeForceBuilderInitialization() {
        Messages$AckCommand.access$20900();
    }

    public Messages$AckCommand$Builder addAllIds(Iterable iterable) {
        this.ensureIdsIsMutable();
        LazyStringList lazyStringList = this.ids_;
        AbstractMessageLite$Builder.addAll(iterable, lazyStringList);
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder addIds(String string2) {
        Objects.requireNonNull(string2);
        this.ensureIdsIsMutable();
        this.ids_.add(string2);
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder addIdsBytes(ByteString byteString) {
        Objects.requireNonNull(byteString);
        this.ensureIdsIsMutable();
        this.ids_.add(byteString);
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object object) {
        return (Messages$AckCommand$Builder)super.addRepeatedField(fieldDescriptor, object);
    }

    public Messages$AckCommand build() {
        Messages$AckCommand messages$AckCommand = this.buildPartial();
        boolean bl2 = messages$AckCommand.isInitialized();
        if (bl2) {
            return messages$AckCommand;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$AckCommand);
    }

    public Messages$AckCommand buildPartial() {
        Object object = null;
        Messages$AckCommand messages$AckCommand = new Messages$AckCommand(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        int n12 = 1;
        if (n11 != n12) {
            n12 = 0;
        }
        n11 = this.code_;
        Messages$AckCommand.access$21102(messages$AckCommand, n11);
        n11 = n10 & 2;
        int n13 = 2;
        if (n11 == n13) {
            n12 |= 2;
        }
        Object object2 = this.reason_;
        Messages$AckCommand.access$21202(messages$AckCommand, object2);
        n11 = n10 & 4;
        n13 = 4;
        if (n11 == n13) {
            n12 |= 4;
        }
        object2 = this.mid_;
        Messages$AckCommand.access$21302(messages$AckCommand, object2);
        n11 = n10 & 8;
        n13 = 8;
        if (n11 == n13) {
            n12 |= 8;
        }
        object2 = this.cid_;
        Messages$AckCommand.access$21402(messages$AckCommand, object2);
        n11 = n10 & 0x10;
        n13 = 16;
        if (n11 == n13) {
            n12 |= 0x10;
        }
        long l10 = this.t_;
        Messages$AckCommand.access$21502(messages$AckCommand, l10);
        n11 = n10 & 0x20;
        n13 = 32;
        if (n11 == n13) {
            n12 |= 0x20;
        }
        object2 = this.uid_;
        Messages$AckCommand.access$21602(messages$AckCommand, object2);
        n11 = n10 & 0x40;
        n13 = 64;
        if (n11 == n13) {
            n12 |= 0x40;
        }
        l10 = this.fromts_;
        Messages$AckCommand.access$21702(messages$AckCommand, l10);
        n11 = n10 & 0x80;
        n13 = 128;
        if (n11 == n13) {
            n12 |= 0x80;
        }
        l10 = this.tots_;
        Messages$AckCommand.access$21802(messages$AckCommand, l10);
        n11 = n10 & 0x100;
        n13 = 256;
        if (n11 == n13) {
            n12 |= 0x100;
        }
        object2 = this.type_;
        Messages$AckCommand.access$21902(messages$AckCommand, object2);
        n11 = this.bitField0_;
        n13 = 512;
        if ((n11 &= n13) == n13) {
            this.ids_ = object2 = this.ids_.getUnmodifiableView();
            this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFDFF;
        }
        object2 = this.ids_;
        Messages$AckCommand.access$22002(messages$AckCommand, (LazyStringList)object2);
        n11 = n10 & 0x400;
        n13 = 1024;
        if (n11 == n13) {
            n12 |= 0x200;
        }
        n11 = this.appCode_;
        Messages$AckCommand.access$22102(messages$AckCommand, n11);
        n11 = 2048;
        if ((n10 &= n11) == n11) {
            n12 |= 0x400;
        }
        object = this.appMsg_;
        Messages$AckCommand.access$22202(messages$AckCommand, object);
        Messages$AckCommand.access$22302(messages$AckCommand, n12);
        this.onBuilt();
        return messages$AckCommand;
    }

    public Messages$AckCommand$Builder clear() {
        int n10;
        LazyStringList lazyStringList;
        long l10;
        int n11;
        super.clear();
        this.code_ = 0;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = "";
        this.reason_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFFD;
        this.mid_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFFB;
        this.cid_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFF7;
        this.t_ = l10 = 0L;
        this.bitField0_ = n11 &= 0xFFFFFFEF;
        this.uid_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFFDF;
        this.fromts_ = l10;
        this.bitField0_ = n11 &= 0xFFFFFFBF;
        this.tots_ = l10;
        this.bitField0_ = n11 &= 0xFFFFFF7F;
        this.type_ = string2;
        this.bitField0_ = n11 &= 0xFFFFFEFF;
        this.ids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n11 &= 0xFFFFFDFF;
        this.appCode_ = 0;
        this.bitField0_ = n10 = n11 & 0xFFFFFBFF;
        this.appMsg_ = string2;
        this.bitField0_ = n10 &= 0xFFFFF7FF;
        return this;
    }

    public Messages$AckCommand$Builder clearAppCode() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFBFF;
        this.appCode_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder clearAppMsg() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFF7FF;
        String string2 = Messages$AckCommand.getDefaultInstance().getAppMsg();
        this.appMsg_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder clearCid() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        String string2 = Messages$AckCommand.getDefaultInstance().getCid();
        this.cid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder clearCode() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        this.code_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
        return (Messages$AckCommand$Builder)super.clearField(fieldDescriptor);
    }

    public Messages$AckCommand$Builder clearFromts() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFBF;
        this.fromts_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder clearIds() {
        int n10;
        LazyStringList lazyStringList;
        this.ids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFDFF;
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder clearMid() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        String string2 = Messages$AckCommand.getDefaultInstance().getMid();
        this.mid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
        return (Messages$AckCommand$Builder)super.clearOneof(oneofDescriptor);
    }

    public Messages$AckCommand$Builder clearReason() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        String string2 = Messages$AckCommand.getDefaultInstance().getReason();
        this.reason_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder clearT() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        this.t_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder clearTots() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFF7F;
        this.tots_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder clearType() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFEFF;
        String string2 = Messages$AckCommand.getDefaultInstance().getType();
        this.type_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder clearUid() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
        String string2 = Messages$AckCommand.getDefaultInstance().getUid();
        this.uid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder clone() {
        return (Messages$AckCommand$Builder)super.clone();
    }

    public int getAppCode() {
        return this.appCode_;
    }

    public String getAppMsg() {
        Object object = this.appMsg_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.appMsg_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getAppMsgBytes() {
        Object object = this.appMsg_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.appMsg_ = object = ByteString.copyFromUtf8((String)object);
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

    public int getCode() {
        return this.code_;
    }

    public Messages$AckCommand getDefaultInstanceForType() {
        return Messages$AckCommand.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$20500();
    }

    public long getFromts() {
        return this.fromts_;
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

    public String getReason() {
        Object object = this.reason_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.reason_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getReasonBytes() {
        Object object = this.reason_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.reason_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public long getT() {
        return this.t_;
    }

    public long getTots() {
        return this.tots_;
    }

    public String getType() {
        Object object = this.type_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.type_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getTypeBytes() {
        Object object = this.type_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.type_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getUid() {
        Object object = this.uid_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.uid_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getUidBytes() {
        Object object = this.uid_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.uid_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasAppCode() {
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
    public boolean hasAppMsg() {
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

    public boolean hasCode() {
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
    public boolean hasFromts() {
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
    public boolean hasMid() {
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
    public boolean hasReason() {
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
    public boolean hasTots() {
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
    public boolean hasType() {
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
    public boolean hasUid() {
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

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$20600().ensureFieldAccessorsInitialized(Messages$AckCommand.class, Messages$AckCommand$Builder.class);
    }

    public final boolean isInitialized() {
        return true;
    }

    public Messages$AckCommand$Builder mergeFrom(Messages$AckCommand messageLite) {
        long l10;
        Object object = Messages$AckCommand.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasCode();
        if (n10 != 0) {
            n10 = messageLite.getCode();
            this.setCode(n10);
        }
        if ((n10 = (int)(messageLite.hasReason() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 2;
            this.reason_ = object = Messages$AckCommand.access$21200(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasMid() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 4;
            this.mid_ = object = Messages$AckCommand.access$21300(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasCid() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 8;
            this.cid_ = object = Messages$AckCommand.access$21400(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasT() ? 1 : 0)) != 0) {
            l10 = messageLite.getT();
            this.setT(l10);
        }
        if ((n10 = (int)(messageLite.hasUid() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x20;
            this.uid_ = object = Messages$AckCommand.access$21600(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasFromts() ? 1 : 0)) != 0) {
            l10 = messageLite.getFromts();
            this.setFromts(l10);
        }
        if ((n10 = (int)(messageLite.hasTots() ? 1 : 0)) != 0) {
            l10 = messageLite.getTots();
            this.setTots(l10);
        }
        if ((n10 = (int)(messageLite.hasType() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x100;
            this.type_ = object = Messages$AckCommand.access$21900(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)((object = Messages$AckCommand.access$22000(messageLite)).isEmpty() ? 1 : 0)) == 0) {
            object = this.ids_;
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 != 0) {
                this.ids_ = object = Messages$AckCommand.access$22000(messageLite);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFDFF;
            } else {
                this.ensureIdsIsMutable();
                object = this.ids_;
                LazyStringList lazyStringList = Messages$AckCommand.access$22000(messageLite);
                object.addAll(lazyStringList);
            }
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasAppCode() ? 1 : 0)) != 0) {
            n10 = messageLite.getAppCode();
            this.setAppCode(n10);
        }
        if ((n10 = (int)(messageLite.hasAppMsg() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x800;
            this.appMsg_ = object = Messages$AckCommand.access$22200(messageLite);
            this.onChanged();
        }
        messageLite = Messages$AckCommand.access$22400(messageLite);
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
    public Messages$AckCommand$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$AckCommand.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$AckCommand)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$AckCommand)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$AckCommand)object2;
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
            this.mergeFrom((Messages$AckCommand)object3);
        }
        throw var1_6;
    }

    public Messages$AckCommand$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$AckCommand;
        if (bl2) {
            message = (Messages$AckCommand)message;
            return this.mergeFrom((Messages$AckCommand)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Messages$AckCommand$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$AckCommand$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$AckCommand$Builder setAppCode(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 0x400;
        this.appCode_ = n10;
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder setAppMsg(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x800;
        this.appMsg_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder setAppMsgBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x800;
        this.appMsg_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder setCid(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.cid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder setCidBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.cid_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder setCode(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 1;
        this.code_ = n10;
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object object) {
        return (Messages$AckCommand$Builder)super.setField(fieldDescriptor, object);
    }

    public Messages$AckCommand$Builder setFromts(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x40;
        this.fromts_ = l10;
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder setIds(int n10, String string2) {
        Objects.requireNonNull(string2);
        this.ensureIdsIsMutable();
        this.ids_.set(n10, string2);
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder setMid(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.mid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder setMidBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 4;
        this.mid_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder setReason(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.reason_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder setReasonBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 2;
        this.reason_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int n10, Object object) {
        return (Messages$AckCommand$Builder)super.setRepeatedField(fieldDescriptor, n10, object);
    }

    public Messages$AckCommand$Builder setT(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x10;
        this.t_ = l10;
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder setTots(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x80;
        this.tots_ = l10;
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder setType(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x100;
        this.type_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder setTypeBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x100;
        this.type_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder setUid(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x20;
        this.uid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$AckCommand$Builder setUidBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x20;
        this.uid_ = byteString;
        this.onChanged();
        return this;
    }

    public final Messages$AckCommand$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$AckCommand$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

