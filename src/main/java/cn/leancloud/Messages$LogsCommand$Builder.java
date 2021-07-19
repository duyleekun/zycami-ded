/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$LogItem;
import cn.leancloud.Messages$LogItem$Builder;
import cn.leancloud.Messages$LogItemOrBuilder;
import cn.leancloud.Messages$LogsCommand;
import cn.leancloud.Messages$LogsCommand$QueryDirection;
import cn.leancloud.Messages$LogsCommandOrBuilder;
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
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Messages$LogsCommand$Builder
extends GeneratedMessageV3$Builder
implements Messages$LogsCommandOrBuilder {
    private int bitField0_;
    private Object checksum_;
    private Object cid_;
    private int direction_;
    private int l_;
    private int lctype_;
    private int limit_;
    private RepeatedFieldBuilderV3 logsBuilder_;
    private List logs_;
    private Object mid_;
    private boolean stored_;
    private boolean tIncluded_;
    private long t_;
    private Object tmid_;
    private boolean ttIncluded_;
    private long tt_;

    private Messages$LogsCommand$Builder() {
        Object object;
        this.cid_ = object = "";
        this.tmid_ = object;
        this.mid_ = object;
        this.checksum_ = object;
        this.direction_ = 1;
        this.logs_ = object = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$LogsCommand$Builder(Messages$1 messages$1) {
        this();
    }

    private Messages$LogsCommand$Builder(GeneratedMessageV3$BuilderParent list) {
        super((GeneratedMessageV3$BuilderParent)((Object)list));
        list = "";
        this.cid_ = list;
        this.tmid_ = list;
        this.mid_ = list;
        this.checksum_ = list;
        this.direction_ = 1;
        this.logs_ = list = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }

    public /* synthetic */ Messages$LogsCommand$Builder(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent, Messages$1 messages$1) {
        this(generatedMessageV3$BuilderParent);
    }

    private void ensureLogsIsMutable() {
        int n10 = this.bitField0_;
        int n11 = 8192;
        if ((n10 &= n11) != n11) {
            ArrayList arrayList;
            List list = this.logs_;
            this.logs_ = arrayList = new ArrayList(list);
            this.bitField0_ = n10 = this.bitField0_ | n11;
        }
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$30200();
    }

    /*
     * WARNING - void declaration
     */
    private RepeatedFieldBuilderV3 getLogsFieldBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.logsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            void var3_7;
            List list = this.logs_;
            int bl2 = this.bitField0_;
            int n10 = 8192;
            int n11 = bl2 & n10;
            if (n11 == n10) {
                boolean bl3 = true;
            } else {
                boolean bl4 = false;
            }
            GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent = this.getParentForChildren();
            boolean bl5 = this.isClean();
            this.logsBuilder_ = repeatedFieldBuilderV3 = new RepeatedFieldBuilderV3(list, (boolean)var3_7, generatedMessageV3$BuilderParent, bl5);
            repeatedFieldBuilderV3 = null;
            this.logs_ = null;
        }
        return this.logsBuilder_;
    }

    private void maybeForceBuilderInitialization() {
        boolean bl2 = Messages$LogsCommand.access$30600();
        if (bl2) {
            this.getLogsFieldBuilder();
        }
    }

    public Messages$LogsCommand$Builder addAllLogs(Iterable iterable) {
        Object object = this.logsBuilder_;
        if (object == null) {
            this.ensureLogsIsMutable();
            object = this.logs_;
            AbstractMessageLite$Builder.addAll(iterable, (List)object);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addAllMessages(iterable);
        }
        return this;
    }

    public Messages$LogsCommand$Builder addLogs(int n10, Messages$LogItem$Builder messages$LogItemOrBuilder) {
        Object object = this.logsBuilder_;
        if (object == null) {
            this.ensureLogsIsMutable();
            object = this.logs_;
            messages$LogItemOrBuilder = ((Messages$LogItem$Builder)messages$LogItemOrBuilder).build();
            object.add(n10, messages$LogItemOrBuilder);
            this.onChanged();
        } else {
            messages$LogItemOrBuilder = ((Messages$LogItem$Builder)messages$LogItemOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage(n10, (AbstractMessage)((Object)messages$LogItemOrBuilder));
        }
        return this;
    }

    public Messages$LogsCommand$Builder addLogs(int n10, Messages$LogItem messages$LogItem) {
        Object object = this.logsBuilder_;
        if (object == null) {
            Objects.requireNonNull(messages$LogItem);
            this.ensureLogsIsMutable();
            object = this.logs_;
            object.add(n10, messages$LogItem);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(n10, messages$LogItem);
        }
        return this;
    }

    public Messages$LogsCommand$Builder addLogs(Messages$LogItem$Builder messages$LogItemOrBuilder) {
        Object object = this.logsBuilder_;
        if (object == null) {
            this.ensureLogsIsMutable();
            object = this.logs_;
            messages$LogItemOrBuilder = ((Messages$LogItem$Builder)messages$LogItemOrBuilder).build();
            object.add(messages$LogItemOrBuilder);
            this.onChanged();
        } else {
            messages$LogItemOrBuilder = ((Messages$LogItem$Builder)messages$LogItemOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).addMessage((AbstractMessage)((Object)messages$LogItemOrBuilder));
        }
        return this;
    }

    public Messages$LogsCommand$Builder addLogs(Messages$LogItem messages$LogItem) {
        Object object = this.logsBuilder_;
        if (object == null) {
            Objects.requireNonNull(messages$LogItem);
            this.ensureLogsIsMutable();
            object = this.logs_;
            object.add(messages$LogItem);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).addMessage(messages$LogItem);
        }
        return this;
    }

    public Messages$LogItem$Builder addLogsBuilder() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getLogsFieldBuilder();
        Messages$LogItem messages$LogItem = Messages$LogItem.getDefaultInstance();
        return (Messages$LogItem$Builder)repeatedFieldBuilderV3.addBuilder(messages$LogItem);
    }

    public Messages$LogItem$Builder addLogsBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.getLogsFieldBuilder();
        Messages$LogItem messages$LogItem = Messages$LogItem.getDefaultInstance();
        return (Messages$LogItem$Builder)repeatedFieldBuilderV3.addBuilder(n10, messages$LogItem);
    }

    public Messages$LogsCommand$Builder addRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$LogsCommand$Builder)super.addRepeatedField(descriptors$FieldDescriptor, object);
    }

    public Messages$LogsCommand build() {
        Messages$LogsCommand messages$LogsCommand = this.buildPartial();
        boolean bl2 = messages$LogsCommand.isInitialized();
        if (bl2) {
            return messages$LogsCommand;
        }
        throw AbstractMessage$Builder.newUninitializedMessageException(messages$LogsCommand);
    }

    public Messages$LogsCommand buildPartial() {
        List list = null;
        Messages$LogsCommand messages$LogsCommand = new Messages$LogsCommand(this, null);
        int n10 = this.bitField0_;
        int n11 = n10 & 1;
        int n12 = 1;
        if (n11 != n12) {
            n12 = 0;
        }
        Object object = this.cid_;
        Messages$LogsCommand.access$30802(messages$LogsCommand, object);
        n11 = n10 & 2;
        int n13 = 2;
        if (n11 == n13) {
            n12 |= 2;
        }
        n11 = this.l_;
        Messages$LogsCommand.access$30902(messages$LogsCommand, n11);
        n11 = n10 & 4;
        n13 = 4;
        if (n11 == n13) {
            n12 |= 4;
        }
        n11 = this.limit_;
        Messages$LogsCommand.access$31002(messages$LogsCommand, n11);
        n11 = n10 & 8;
        n13 = 8;
        if (n11 == n13) {
            n12 |= 8;
        }
        long l10 = this.t_;
        Messages$LogsCommand.access$31102(messages$LogsCommand, l10);
        n11 = n10 & 0x10;
        n13 = 16;
        if (n11 == n13) {
            n12 |= 0x10;
        }
        l10 = this.tt_;
        Messages$LogsCommand.access$31202(messages$LogsCommand, l10);
        n11 = n10 & 0x20;
        n13 = 32;
        if (n11 == n13) {
            n12 |= 0x20;
        }
        object = this.tmid_;
        Messages$LogsCommand.access$31302(messages$LogsCommand, object);
        n11 = n10 & 0x40;
        n13 = 64;
        if (n11 == n13) {
            n12 |= 0x40;
        }
        object = this.mid_;
        Messages$LogsCommand.access$31402(messages$LogsCommand, object);
        n11 = n10 & 0x80;
        n13 = 128;
        if (n11 == n13) {
            n12 |= 0x80;
        }
        object = this.checksum_;
        Messages$LogsCommand.access$31502(messages$LogsCommand, object);
        n11 = n10 & 0x100;
        n13 = 256;
        if (n11 == n13) {
            n12 |= 0x100;
        }
        n11 = (int)(this.stored_ ? 1 : 0);
        Messages$LogsCommand.access$31602(messages$LogsCommand, n11 != 0);
        n11 = n10 & 0x200;
        n13 = 512;
        if (n11 == n13) {
            n12 |= 0x200;
        }
        n11 = this.direction_;
        Messages$LogsCommand.access$31702(messages$LogsCommand, n11);
        n11 = n10 & 0x400;
        n13 = 1024;
        if (n11 == n13) {
            n12 |= 0x400;
        }
        n11 = (int)(this.tIncluded_ ? 1 : 0);
        Messages$LogsCommand.access$31802(messages$LogsCommand, n11 != 0);
        n11 = n10 & 0x800;
        n13 = 2048;
        if (n11 == n13) {
            n12 |= 0x800;
        }
        n11 = (int)(this.ttIncluded_ ? 1 : 0);
        Messages$LogsCommand.access$31902(messages$LogsCommand, n11 != 0);
        n11 = 4096;
        if ((n10 &= n11) == n11) {
            n12 |= 0x1000;
        }
        n10 = this.lctype_;
        Messages$LogsCommand.access$32002(messages$LogsCommand, n10);
        list = this.logsBuilder_;
        if (list == null) {
            n10 = this.bitField0_;
            n11 = 8192;
            if ((n10 &= n11) == n11) {
                this.logs_ = list = Collections.unmodifiableList(this.logs_);
                this.bitField0_ = n10 = this.bitField0_ & 0xFFFFDFFF;
            }
            list = this.logs_;
            Messages$LogsCommand.access$32102(messages$LogsCommand, list);
        } else {
            list = ((RepeatedFieldBuilderV3)((Object)list)).build();
            Messages$LogsCommand.access$32102(messages$LogsCommand, list);
        }
        Messages$LogsCommand.access$32202(messages$LogsCommand, n12);
        this.onBuilt();
        return messages$LogsCommand;
    }

    public Messages$LogsCommand$Builder clear() {
        int n10;
        long l10;
        int n11;
        super.clear();
        List list = "";
        this.cid_ = list;
        this.bitField0_ = n11 = this.bitField0_ & 0xFFFFFFFE;
        this.l_ = 0;
        this.bitField0_ = n11 &= 0xFFFFFFFD;
        this.limit_ = 0;
        this.bitField0_ = n11 &= 0xFFFFFFFB;
        this.t_ = l10 = 0L;
        this.bitField0_ = n11 &= 0xFFFFFFF7;
        this.tt_ = l10;
        this.bitField0_ = n11 &= 0xFFFFFFEF;
        this.tmid_ = list;
        this.bitField0_ = n11 &= 0xFFFFFFDF;
        this.mid_ = list;
        this.bitField0_ = n11 &= 0xFFFFFFBF;
        this.checksum_ = list;
        this.bitField0_ = n10 = n11 & 0xFFFFFF7F;
        this.stored_ = false;
        this.bitField0_ = n10 &= 0xFFFFFEFF;
        this.direction_ = n11 = 1;
        this.bitField0_ = n10 &= 0xFFFFFDFF;
        this.tIncluded_ = false;
        this.bitField0_ = n10 &= 0xFFFFFBFF;
        this.ttIncluded_ = false;
        this.bitField0_ = n10 &= 0xFFFFF7FF;
        this.lctype_ = 0;
        this.bitField0_ = n10 &= 0xFFFFEFFF;
        list = this.logsBuilder_;
        if (list == null) {
            this.logs_ = list = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFDFFF;
        } else {
            ((RepeatedFieldBuilderV3)((Object)list)).clear();
        }
        return this;
    }

    public Messages$LogsCommand$Builder clearChecksum() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFF7F;
        String string2 = Messages$LogsCommand.getDefaultInstance().getChecksum();
        this.checksum_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder clearCid() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFE;
        String string2 = Messages$LogsCommand.getDefaultInstance().getCid();
        this.cid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder clearDirection() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFDFF;
        this.direction_ = 1;
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder clearField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return (Messages$LogsCommand$Builder)super.clearField(descriptors$FieldDescriptor);
    }

    public Messages$LogsCommand$Builder clearL() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFD;
        this.l_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder clearLctype() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFEFFF;
        this.lctype_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder clearLimit() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFFB;
        this.limit_ = 0;
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder clearLogs() {
        Object object = this.logsBuilder_;
        if (object == null) {
            int n10;
            this.logs_ = object = Collections.emptyList();
            this.bitField0_ = n10 = this.bitField0_ & 0xFFFFDFFF;
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).clear();
        }
        return this;
    }

    public Messages$LogsCommand$Builder clearMid() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFBF;
        String string2 = Messages$LogsCommand.getDefaultInstance().getMid();
        this.mid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder clearOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return (Messages$LogsCommand$Builder)super.clearOneof(descriptors$OneofDescriptor);
    }

    public Messages$LogsCommand$Builder clearStored() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFEFF;
        this.stored_ = false;
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder clearT() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFF7;
        this.t_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder clearTIncluded() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFBFF;
        this.tIncluded_ = false;
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder clearTmid() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFDF;
        String string2 = Messages$LogsCommand.getDefaultInstance().getTmid();
        this.tmid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder clearTt() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFFFEF;
        this.tt_ = 0L;
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder clearTtIncluded() {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ & 0xFFFFF7FF;
        this.ttIncluded_ = false;
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder clone() {
        return (Messages$LogsCommand$Builder)super.clone();
    }

    public String getChecksum() {
        Object object = this.checksum_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.checksum_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getChecksumBytes() {
        Object object = this.checksum_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.checksum_ = object = ByteString.copyFromUtf8((String)object);
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

    public Messages$LogsCommand getDefaultInstanceForType() {
        return Messages$LogsCommand.getDefaultInstance();
    }

    public Descriptors$Descriptor getDescriptorForType() {
        return Messages.access$30200();
    }

    public Messages$LogsCommand$QueryDirection getDirection() {
        int n10 = this.direction_;
        Messages$LogsCommand$QueryDirection messages$LogsCommand$QueryDirection = Messages$LogsCommand$QueryDirection.valueOf(n10);
        if (messages$LogsCommand$QueryDirection == null) {
            messages$LogsCommand$QueryDirection = Messages$LogsCommand$QueryDirection.OLD;
        }
        return messages$LogsCommand$QueryDirection;
    }

    public int getL() {
        return this.l_;
    }

    public int getLctype() {
        return this.lctype_;
    }

    public int getLimit() {
        return this.limit_;
    }

    public Messages$LogItem getLogs(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.logsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (Messages$LogItem)this.logs_.get(n10);
        }
        return (Messages$LogItem)repeatedFieldBuilderV3.getMessage(n10);
    }

    public Messages$LogItem$Builder getLogsBuilder(int n10) {
        return (Messages$LogItem$Builder)this.getLogsFieldBuilder().getBuilder(n10);
    }

    public List getLogsBuilderList() {
        return this.getLogsFieldBuilder().getBuilderList();
    }

    public int getLogsCount() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.logsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return this.logs_.size();
        }
        return repeatedFieldBuilderV3.getCount();
    }

    public List getLogsList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.logsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return Collections.unmodifiableList(this.logs_);
        }
        return repeatedFieldBuilderV3.getMessageList();
    }

    public Messages$LogItemOrBuilder getLogsOrBuilder(int n10) {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.logsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
            return (Messages$LogItemOrBuilder)this.logs_.get(n10);
        }
        return (Messages$LogItemOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(n10);
    }

    public List getLogsOrBuilderList() {
        RepeatedFieldBuilderV3 repeatedFieldBuilderV3 = this.logsBuilder_;
        if (repeatedFieldBuilderV3 != null) {
            return repeatedFieldBuilderV3.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList(this.logs_);
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

    public boolean getStored() {
        return this.stored_;
    }

    public long getT() {
        return this.t_;
    }

    public boolean getTIncluded() {
        return this.tIncluded_;
    }

    public String getTmid() {
        Object object = this.tmid_;
        boolean bl2 = object instanceof String;
        if (!bl2) {
            object = (ByteString)object;
            String string2 = ((ByteString)object).toStringUtf8();
            boolean bl3 = ((ByteString)object).isValidUtf8();
            if (bl3) {
                this.tmid_ = string2;
            }
            return string2;
        }
        return (String)object;
    }

    public ByteString getTmidBytes() {
        Object object = this.tmid_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.tmid_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public long getTt() {
        return this.tt_;
    }

    public boolean getTtIncluded() {
        return this.ttIncluded_;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasChecksum() {
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
    public boolean hasDirection() {
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
    public boolean hasL() {
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
    public boolean hasLctype() {
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
    public boolean hasLimit() {
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
    public boolean hasMid() {
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
    public boolean hasStored() {
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
    public boolean hasT() {
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
    public boolean hasTIncluded() {
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
    public boolean hasTmid() {
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
    public boolean hasTt() {
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
    public boolean hasTtIncluded() {
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

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$30300().ensureFieldAccessorsInitialized(Messages$LogsCommand.class, Messages$LogsCommand$Builder.class);
    }

    public final boolean isInitialized() {
        return true;
    }

    public Messages$LogsCommand$Builder mergeFrom(Messages$LogsCommand messageLite) {
        long l10;
        Object object = Messages$LogsCommand.getDefaultInstance();
        if (messageLite == object) {
            return this;
        }
        int n10 = messageLite.hasCid();
        if (n10 != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 1;
            this.cid_ = object = Messages$LogsCommand.access$30800(messageLite);
            this.onChanged();
        }
        if ((n10 = messageLite.hasL()) != 0) {
            n10 = messageLite.getL();
            this.setL(n10);
        }
        if ((n10 = (int)(messageLite.hasLimit() ? 1 : 0)) != 0) {
            n10 = messageLite.getLimit();
            this.setLimit(n10);
        }
        if ((n10 = (int)(messageLite.hasT() ? 1 : 0)) != 0) {
            l10 = messageLite.getT();
            this.setT(l10);
        }
        if ((n10 = (int)(messageLite.hasTt() ? 1 : 0)) != 0) {
            l10 = messageLite.getTt();
            this.setTt(l10);
        }
        if ((n10 = (int)(messageLite.hasTmid() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x20;
            this.tmid_ = object = Messages$LogsCommand.access$31300(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasMid() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x40;
            this.mid_ = object = Messages$LogsCommand.access$31400(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasChecksum() ? 1 : 0)) != 0) {
            this.bitField0_ = n10 = this.bitField0_ | 0x80;
            this.checksum_ = object = Messages$LogsCommand.access$31500(messageLite);
            this.onChanged();
        }
        if ((n10 = (int)(messageLite.hasStored() ? 1 : 0)) != 0) {
            n10 = (int)(messageLite.getStored() ? 1 : 0);
            this.setStored(n10 != 0);
        }
        if ((n10 = (int)(messageLite.hasDirection() ? 1 : 0)) != 0) {
            object = messageLite.getDirection();
            this.setDirection((Messages$LogsCommand$QueryDirection)object);
        }
        if ((n10 = messageLite.hasTIncluded()) != 0) {
            n10 = messageLite.getTIncluded();
            this.setTIncluded(n10 != 0);
        }
        if ((n10 = messageLite.hasTtIncluded()) != 0) {
            n10 = messageLite.getTtIncluded();
            this.setTtIncluded(n10 != 0);
        }
        if ((n10 = messageLite.hasLctype()) != 0) {
            n10 = messageLite.getLctype();
            this.setLctype(n10);
        }
        if ((object = this.logsBuilder_) == null) {
            object = Messages$LogsCommand.access$32100(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.logs_;
                n10 = (int)(object.isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    this.logs_ = object = Messages$LogsCommand.access$32100(messageLite);
                    this.bitField0_ = n10 = this.bitField0_ & 0xFFFFDFFF;
                } else {
                    this.ensureLogsIsMutable();
                    object = this.logs_;
                    List list = Messages$LogsCommand.access$32100(messageLite);
                    object.addAll(list);
                }
                this.onChanged();
            }
        } else {
            object = Messages$LogsCommand.access$32100(messageLite);
            n10 = (int)(object.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                object = this.logsBuilder_;
                n10 = (int)(((RepeatedFieldBuilderV3)object).isEmpty() ? 1 : 0);
                if (n10 != 0) {
                    int n11;
                    List list;
                    this.logsBuilder_.dispose();
                    n10 = 0;
                    object = null;
                    this.logsBuilder_ = null;
                    this.logs_ = list = Messages$LogsCommand.access$32100(messageLite);
                    this.bitField0_ = n11 = this.bitField0_ & 0xFFFFDFFF;
                    n11 = (int)(Messages$LogsCommand.access$32300() ? 1 : 0);
                    if (n11 != 0) {
                        object = this.getLogsFieldBuilder();
                    }
                    this.logsBuilder_ = object;
                } else {
                    object = this.logsBuilder_;
                    List list = Messages$LogsCommand.access$32100(messageLite);
                    ((RepeatedFieldBuilderV3)object).addAllMessages(list);
                }
            }
        }
        messageLite = Messages$LogsCommand.access$32400(messageLite);
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
    public Messages$LogsCommand$Builder mergeFrom(CodedInputStream object, ExtensionRegistryLite object2) {
        void var1_6;
        Object object3;
        block7: {
            object3 = null;
            Parser parser = Messages$LogsCommand.PARSER;
            object = parser.parsePartialFrom((CodedInputStream)object, (ExtensionRegistryLite)object2);
            object = (Messages$LogsCommand)object;
            if (object == null) break block7;
            this.mergeFrom((Messages$LogsCommand)object);
        }
        return this;
        {
            catch (Throwable throwable) {
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {}
            {
                object2 = invalidProtocolBufferException.getUnfinishedMessage();
                object2 = (Messages$LogsCommand)object2;
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
            this.mergeFrom((Messages$LogsCommand)object3);
        }
        throw var1_6;
    }

    public Messages$LogsCommand$Builder mergeFrom(Message message) {
        boolean bl2 = message instanceof Messages$LogsCommand;
        if (bl2) {
            message = (Messages$LogsCommand)message;
            return this.mergeFrom((Messages$LogsCommand)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public final Messages$LogsCommand$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$LogsCommand$Builder)super.mergeUnknownFields(unknownFieldSet);
    }

    public Messages$LogsCommand$Builder removeLogs(int n10) {
        Object object = this.logsBuilder_;
        if (object == null) {
            this.ensureLogsIsMutable();
            object = this.logs_;
            object.remove(n10);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).remove(n10);
        }
        return this;
    }

    public Messages$LogsCommand$Builder setChecksum(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x80;
        this.checksum_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder setChecksumBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x80;
        this.checksum_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder setCid(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.cid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder setCidBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 1;
        this.cid_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder setDirection(Messages$LogsCommand$QueryDirection messages$LogsCommand$QueryDirection) {
        int n10;
        int n11;
        Objects.requireNonNull(messages$LogsCommand$QueryDirection);
        this.bitField0_ = n11 = this.bitField0_ | 0x200;
        this.direction_ = n10 = messages$LogsCommand$QueryDirection.getNumber();
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder setField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        return (Messages$LogsCommand$Builder)super.setField(descriptors$FieldDescriptor, object);
    }

    public Messages$LogsCommand$Builder setL(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 2;
        this.l_ = n10;
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder setLctype(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 0x1000;
        this.lctype_ = n10;
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder setLimit(int n10) {
        int n11;
        this.bitField0_ = n11 = this.bitField0_ | 4;
        this.limit_ = n10;
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder setLogs(int n10, Messages$LogItem$Builder messages$LogItemOrBuilder) {
        Object object = this.logsBuilder_;
        if (object == null) {
            this.ensureLogsIsMutable();
            object = this.logs_;
            messages$LogItemOrBuilder = ((Messages$LogItem$Builder)messages$LogItemOrBuilder).build();
            object.set(n10, messages$LogItemOrBuilder);
            this.onChanged();
        } else {
            messages$LogItemOrBuilder = ((Messages$LogItem$Builder)messages$LogItemOrBuilder).build();
            ((RepeatedFieldBuilderV3)object).setMessage(n10, (AbstractMessage)((Object)messages$LogItemOrBuilder));
        }
        return this;
    }

    public Messages$LogsCommand$Builder setLogs(int n10, Messages$LogItem messages$LogItem) {
        Object object = this.logsBuilder_;
        if (object == null) {
            Objects.requireNonNull(messages$LogItem);
            this.ensureLogsIsMutable();
            object = this.logs_;
            object.set(n10, messages$LogItem);
            this.onChanged();
        } else {
            ((RepeatedFieldBuilderV3)object).setMessage(n10, messages$LogItem);
        }
        return this;
    }

    public Messages$LogsCommand$Builder setMid(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x40;
        this.mid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder setMidBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x40;
        this.mid_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder setRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n10, Object object) {
        return (Messages$LogsCommand$Builder)super.setRepeatedField(descriptors$FieldDescriptor, n10, object);
    }

    public Messages$LogsCommand$Builder setStored(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x100;
        this.stored_ = bl2;
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder setT(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 8;
        this.t_ = l10;
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder setTIncluded(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x400;
        this.tIncluded_ = bl2;
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder setTmid(String string2) {
        int n10;
        Objects.requireNonNull(string2);
        this.bitField0_ = n10 = this.bitField0_ | 0x20;
        this.tmid_ = string2;
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder setTmidBytes(ByteString byteString) {
        int n10;
        Objects.requireNonNull(byteString);
        this.bitField0_ = n10 = this.bitField0_ | 0x20;
        this.tmid_ = byteString;
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder setTt(long l10) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x10;
        this.tt_ = l10;
        this.onChanged();
        return this;
    }

    public Messages$LogsCommand$Builder setTtIncluded(boolean bl2) {
        int n10;
        this.bitField0_ = n10 = this.bitField0_ | 0x800;
        this.ttIncluded_ = bl2;
        this.onChanged();
        return this;
    }

    public final Messages$LogsCommand$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return (Messages$LogsCommand$Builder)super.setUnknownFields(unknownFieldSet);
    }
}

