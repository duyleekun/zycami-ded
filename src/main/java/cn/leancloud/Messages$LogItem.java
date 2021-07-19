/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$LogItem$1;
import cn.leancloud.Messages$LogItem$Builder;
import cn.leancloud.Messages$LogItemOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Messages$LogItem
extends GeneratedMessageV3
implements Messages$LogItemOrBuilder {
    public static final int ACKAT_FIELD_NUMBER = 5;
    public static final int BIN_FIELD_NUMBER = 10;
    public static final int CONVTYPE_FIELD_NUMBER = 11;
    public static final int DATA_FIELD_NUMBER = 2;
    private static final Messages$LogItem DEFAULT_INSTANCE;
    public static final int FROM_FIELD_NUMBER = 1;
    public static final int MENTIONALL_FIELD_NUMBER = 8;
    public static final int MENTIONPIDS_FIELD_NUMBER = 9;
    public static final int MSGID_FIELD_NUMBER = 4;
    public static final Parser PARSER;
    public static final int PATCHTIMESTAMP_FIELD_NUMBER = 7;
    public static final int READAT_FIELD_NUMBER = 6;
    public static final int TIMESTAMP_FIELD_NUMBER = 3;
    private static final long serialVersionUID;
    private long ackAt_;
    private boolean bin_;
    private int bitField0_;
    private int convType_;
    private volatile Object data_;
    private volatile Object from_;
    private byte memoizedIsInitialized;
    private boolean mentionAll_;
    private LazyStringList mentionPids_;
    private volatile Object msgId_;
    private long patchTimestamp_;
    private long readAt_;
    private long timestamp_;

    static {
        Object object = new Messages$LogItem();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$LogItem$1();
    }

    private Messages$LogItem() {
        LazyStringList lazyStringList;
        long l10;
        this.memoizedIsInitialized = (byte)-1;
        String string2 = "";
        this.from_ = string2;
        this.data_ = string2;
        this.timestamp_ = l10 = 0L;
        this.msgId_ = string2;
        this.ackAt_ = l10;
        this.readAt_ = l10;
        this.patchTimestamp_ = l10;
        this.mentionAll_ = false;
        this.mentionPids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.bin_ = false;
        this.convType_ = 0;
    }

    /*
     * Exception decompiling
     */
    private Messages$LogItem(CodedInputStream var1_1, ExtensionRegistryLite var2_7) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 31[TRYBLOCK] [144 : 541->544)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public /* synthetic */ Messages$LogItem(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$LogItem(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ Messages$LogItem(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$7100() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ Object access$7300(Messages$LogItem messages$LogItem) {
        return messages$LogItem.from_;
    }

    public static /* synthetic */ Object access$7302(Messages$LogItem messages$LogItem, Object object) {
        messages$LogItem.from_ = object;
        return object;
    }

    public static /* synthetic */ Object access$7400(Messages$LogItem messages$LogItem) {
        return messages$LogItem.data_;
    }

    public static /* synthetic */ Object access$7402(Messages$LogItem messages$LogItem, Object object) {
        messages$LogItem.data_ = object;
        return object;
    }

    public static /* synthetic */ long access$7502(Messages$LogItem messages$LogItem, long l10) {
        messages$LogItem.timestamp_ = l10;
        return l10;
    }

    public static /* synthetic */ Object access$7600(Messages$LogItem messages$LogItem) {
        return messages$LogItem.msgId_;
    }

    public static /* synthetic */ Object access$7602(Messages$LogItem messages$LogItem, Object object) {
        messages$LogItem.msgId_ = object;
        return object;
    }

    public static /* synthetic */ long access$7702(Messages$LogItem messages$LogItem, long l10) {
        messages$LogItem.ackAt_ = l10;
        return l10;
    }

    public static /* synthetic */ long access$7802(Messages$LogItem messages$LogItem, long l10) {
        messages$LogItem.readAt_ = l10;
        return l10;
    }

    public static /* synthetic */ long access$7902(Messages$LogItem messages$LogItem, long l10) {
        messages$LogItem.patchTimestamp_ = l10;
        return l10;
    }

    public static /* synthetic */ boolean access$8002(Messages$LogItem messages$LogItem, boolean bl2) {
        messages$LogItem.mentionAll_ = bl2;
        return bl2;
    }

    public static /* synthetic */ LazyStringList access$8100(Messages$LogItem messages$LogItem) {
        return messages$LogItem.mentionPids_;
    }

    public static /* synthetic */ LazyStringList access$8102(Messages$LogItem messages$LogItem, LazyStringList lazyStringList) {
        messages$LogItem.mentionPids_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ boolean access$8202(Messages$LogItem messages$LogItem, boolean bl2) {
        messages$LogItem.bin_ = bl2;
        return bl2;
    }

    public static /* synthetic */ int access$8302(Messages$LogItem messages$LogItem, int n10) {
        messages$LogItem.convType_ = n10;
        return n10;
    }

    public static /* synthetic */ int access$8402(Messages$LogItem messages$LogItem, int n10) {
        messages$LogItem.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ UnknownFieldSet access$8500(Messages$LogItem messages$LogItem) {
        return messages$LogItem.unknownFields;
    }

    public static Messages$LogItem getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$6700();
    }

    public static Messages$LogItem$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$LogItem$Builder newBuilder(Messages$LogItem messages$LogItem) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$LogItem);
    }

    public static Messages$LogItem parseDelimitedFrom(InputStream inputStream) {
        return (Messages$LogItem)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$LogItem parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$LogItem)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$LogItem parseFrom(ByteString byteString) {
        return (Messages$LogItem)PARSER.parseFrom(byteString);
    }

    public static Messages$LogItem parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$LogItem)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$LogItem parseFrom(CodedInputStream codedInputStream) {
        return (Messages$LogItem)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$LogItem parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$LogItem)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$LogItem parseFrom(InputStream inputStream) {
        return (Messages$LogItem)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$LogItem parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$LogItem)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$LogItem parseFrom(ByteBuffer byteBuffer) {
        return (Messages$LogItem)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$LogItem parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$LogItem)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$LogItem parseFrom(byte[] byArray) {
        return (Messages$LogItem)PARSER.parseFrom(byArray);
    }

    public static Messages$LogItem parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$LogItem)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2;
        long l10;
        long l11;
        Object object2;
        Object object3;
        int n10;
        int n11 = 1;
        if (object == this) {
            return n11 != 0;
        }
        int n12 = object instanceof Messages$LogItem;
        if (n12 == 0) {
            return super.equals(object);
        }
        object = (Messages$LogItem)object;
        n12 = this.hasFrom();
        if (n12 == (n10 = ((Messages$LogItem)object).hasFrom())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasFrom();
        if (n10 != 0) {
            if (n12 != 0 && (n12 = ((String)(object3 = this.getFrom())).equals(object2 = ((Messages$LogItem)object).getFrom())) != 0) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = this.hasData()) == (n10 = ((Messages$LogItem)object).hasData())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasData();
        if (n10 != 0) {
            if (n12 != 0 && (n12 = ((String)(object3 = this.getData())).equals(object2 = ((Messages$LogItem)object).getData())) != 0) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = this.hasTimestamp()) == (n10 = ((Messages$LogItem)object).hasTimestamp())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasTimestamp();
        if (n10 != 0) {
            long l12;
            if (n12 != 0 && (n12 = (l12 = (l11 = this.getTimestamp()) - (l10 = ((Messages$LogItem)object).getTimestamp())) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == 0) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = this.hasMsgId()) == (n10 = ((Messages$LogItem)object).hasMsgId())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasMsgId();
        if (n10 != 0) {
            if (n12 != 0 && (n12 = ((String)(object3 = this.getMsgId())).equals(object2 = ((Messages$LogItem)object).getMsgId())) != 0) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = this.hasAckAt()) == (n10 = ((Messages$LogItem)object).hasAckAt())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasAckAt();
        if (n10 != 0) {
            long l13;
            if (n12 != 0 && (n12 = (l13 = (l11 = this.getAckAt()) - (l10 = ((Messages$LogItem)object).getAckAt())) == 0L ? 0 : (l13 < 0L ? -1 : 1)) == 0) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = this.hasReadAt()) == (n10 = ((Messages$LogItem)object).hasReadAt())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasReadAt();
        if (n10 != 0) {
            long l14;
            if (n12 != 0 && (n12 = (l14 = (l11 = this.getReadAt()) - (l10 = ((Messages$LogItem)object).getReadAt())) == 0L ? 0 : (l14 < 0L ? -1 : 1)) == 0) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = this.hasPatchTimestamp()) == (n10 = ((Messages$LogItem)object).hasPatchTimestamp())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasPatchTimestamp();
        if (n10 != 0) {
            long l15;
            if (n12 != 0 && (n12 = (l15 = (l11 = this.getPatchTimestamp()) - (l10 = ((Messages$LogItem)object).getPatchTimestamp())) == 0L ? 0 : (l15 < 0L ? -1 : 1)) == 0) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = this.hasMentionAll()) == (n10 = ((Messages$LogItem)object).hasMentionAll())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasMentionAll();
        if (n10 != 0) {
            if (n12 != 0 && (n12 = this.getMentionAll()) == (n10 = ((Messages$LogItem)object).getMentionAll())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = (object3 = this.getMentionPidsList()).equals(object2 = ((Messages$LogItem)object).getMentionPidsList())) != 0) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        if (n12 != 0 && (n12 = this.hasBin()) == (n10 = ((Messages$LogItem)object).hasBin())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasBin();
        if (n10 != 0) {
            if (n12 != 0 && (n12 = this.getBin()) == (n10 = ((Messages$LogItem)object).getBin())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = this.hasConvType()) == (n10 = ((Messages$LogItem)object).hasConvType())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasConvType();
        if (n10 != 0) {
            if (n12 != 0 && (n12 = this.getConvType()) == (n10 = ((Messages$LogItem)object).getConvType())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 == 0 || !(bl2 = ((UnknownFieldSet)(object3 = this.unknownFields)).equals(object = ((GeneratedMessageV3)object).unknownFields))) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public long getAckAt() {
        return this.ackAt_;
    }

    public boolean getBin() {
        return this.bin_;
    }

    public int getConvType() {
        return this.convType_;
    }

    public String getData() {
        Object object = this.data_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.data_ = string2;
        }
        return string2;
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

    public Messages$LogItem getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public String getFrom() {
        Object object = this.from_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.from_ = string2;
        }
        return string2;
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
        return this.mentionPids_;
    }

    public String getMsgId() {
        Object object = this.msgId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.msgId_ = string2;
        }
        return string2;
    }

    public ByteString getMsgIdBytes() {
        Object object = this.msgId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.msgId_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public long getPatchTimestamp() {
        return this.patchTimestamp_;
    }

    public long getReadAt() {
        return this.readAt_;
    }

    public int getSerializedSize() {
        Object object;
        long l10;
        Object object2;
        Object object3;
        int n10 = this.memoizedSize;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n10 = this.bitField0_;
        n11 = 1;
        int n12 = 0;
        ProtocolStringList protocolStringList = null;
        if ((n10 &= n11) == n11) {
            object3 = this.from_;
            n10 = GeneratedMessageV3.computeStringSize(n11, object3) + 0;
        } else {
            n10 = 0;
            object3 = null;
        }
        int n13 = this.bitField0_;
        int n14 = 2;
        if ((n13 &= n14) == n14) {
            object2 = this.data_;
            n13 = GeneratedMessageV3.computeStringSize(n14, object2);
            n10 += n13;
        }
        n13 = this.bitField0_;
        n14 = 4;
        if ((n13 &= n14) == n14) {
            long l11 = this.timestamp_;
            n13 = CodedOutputStream.computeInt64Size(3, l11);
            n10 += n13;
        }
        n13 = this.bitField0_;
        int n15 = 8;
        if ((n13 &= n15) == n15) {
            object2 = this.msgId_;
            n13 = GeneratedMessageV3.computeStringSize(n14, object2);
            n10 += n13;
        }
        n13 = this.bitField0_;
        n14 = 16;
        if ((n13 &= n14) == n14) {
            l10 = this.ackAt_;
            n13 = CodedOutputStream.computeInt64Size(5, l10);
            n10 += n13;
        }
        n13 = this.bitField0_;
        n14 = 32;
        if ((n13 &= n14) == n14) {
            l10 = this.readAt_;
            n13 = CodedOutputStream.computeInt64Size(6, l10);
            n10 += n13;
        }
        n13 = this.bitField0_;
        n14 = 64;
        if ((n13 &= n14) == n14) {
            l10 = this.patchTimestamp_;
            n13 = CodedOutputStream.computeInt64Size(7, l10);
            n10 += n13;
        }
        n13 = this.bitField0_;
        n14 = 128;
        if ((n13 &= n14) == n14) {
            n13 = (int)(this.mentionAll_ ? 1 : 0);
            n13 = CodedOutputStream.computeBoolSize(n15, n13 != 0);
            n10 += n13;
        }
        n13 = 0;
        object2 = null;
        while (n12 < (n14 = (object = this.mentionPids_).size())) {
            object = this.mentionPids_.getRaw(n12);
            n14 = GeneratedMessageV3.computeStringSizeNoTag(object);
            n13 += n14;
            ++n12;
        }
        n10 += n13;
        protocolStringList = this.getMentionPidsList();
        n12 = protocolStringList.size() * n11;
        n10 += n12;
        n11 = this.bitField0_;
        n12 = 256;
        if ((n11 &= n12) == n12) {
            n12 = (int)(this.bin_ ? 1 : 0);
            n11 = CodedOutputStream.computeBoolSize(10, n12 != 0);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 512;
        if ((n11 &= n12) == n12) {
            n12 = this.convType_;
            n11 = CodedOutputStream.computeInt32Size(11, n12);
            n10 += n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public long getTimestamp() {
        return this.timestamp_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasAckAt() {
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
    public boolean hasBin() {
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
    public boolean hasConvType() {
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
    public boolean hasData() {
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

    public boolean hasFrom() {
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
    public boolean hasMentionAll() {
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
    public boolean hasMsgId() {
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
    public boolean hasPatchTimestamp() {
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
    public boolean hasReadAt() {
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

    public int hashCode() {
        long l10;
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = Messages$LogItem.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasFrom() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getFrom();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasData() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getData();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasTimestamp() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            l10 = this.getTimestamp();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasMsgId() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 4) * 53;
            object = this.getMsgId();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasAckAt() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 5) * 53;
            l10 = this.getAckAt();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasReadAt() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 6) * 53;
            l10 = this.getReadAt();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasPatchTimestamp() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 7) * 53;
            l10 = this.getPatchTimestamp();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasMentionAll() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 8) * 53;
            n11 = Internal.hashBoolean(this.getMentionAll());
            n10 += n11;
        }
        if ((n11 = this.getMentionPidsCount()) > 0) {
            n10 = (n10 * 37 + 9) * 53;
            object = this.getMentionPidsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasBin() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 10) * 53;
            n11 = Internal.hashBoolean(this.getBin());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasConvType() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 11) * 53;
            n11 = this.getConvType();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$6800().ensureFieldAccessorsInitialized(Messages$LogItem.class, Messages$LogItem$Builder.class);
    }

    public final boolean isInitialized() {
        byte by2 = this.memoizedIsInitialized;
        byte by3 = 1;
        if (by2 == by3) {
            return by3 != 0;
        }
        if (!by2) {
            return false;
        }
        this.memoizedIsInitialized = by3;
        return by3 != 0;
    }

    public Messages$LogItem$Builder newBuilderForType() {
        return Messages$LogItem.newBuilder();
    }

    public Messages$LogItem$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$LogItem$Builder messages$LogItem$Builder = new Messages$LogItem$Builder(generatedMessageV3$BuilderParent, null);
        return messages$LogItem$Builder;
    }

    public Messages$LogItem$Builder toBuilder() {
        Messages$LogItemOrBuilder messages$LogItemOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$LogItemOrBuilder) {
            messages$LogItemOrBuilder = new Messages$LogItem$Builder(null);
        } else {
            messages$LogItemOrBuilder = new Messages$LogItem$Builder(null);
            messages$LogItemOrBuilder = ((Messages$LogItem$Builder)messages$LogItemOrBuilder).mergeFrom(this);
        }
        return messages$LogItemOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        LazyStringList lazyStringList;
        long l10;
        Object object;
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == n11) {
            object = this.from_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        n10 = this.bitField0_;
        n11 = 2;
        if ((n10 &= n11) == n11) {
            object = this.data_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        n10 = this.bitField0_;
        n11 = 4;
        if ((n10 &= n11) == n11) {
            n10 = 3;
            long l11 = this.timestamp_;
            codedOutputStream.writeInt64(n10, l11);
        }
        n10 = this.bitField0_;
        int n12 = 8;
        if ((n10 &= n12) == n12) {
            object = this.msgId_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        n10 = this.bitField0_;
        n11 = 16;
        if ((n10 &= n11) == n11) {
            n10 = 5;
            l10 = this.ackAt_;
            codedOutputStream.writeInt64(n10, l10);
        }
        n10 = this.bitField0_;
        n11 = 32;
        if ((n10 &= n11) == n11) {
            n10 = 6;
            l10 = this.readAt_;
            codedOutputStream.writeInt64(n10, l10);
        }
        n10 = this.bitField0_;
        n11 = 64;
        if ((n10 &= n11) == n11) {
            n10 = 7;
            l10 = this.patchTimestamp_;
            codedOutputStream.writeInt64(n10, l10);
        }
        n10 = this.bitField0_;
        n11 = 128;
        if ((n10 &= n11) == n11) {
            n10 = (int)(this.mentionAll_ ? 1 : 0);
            codedOutputStream.writeBool(n12, n10 != 0);
        }
        object = null;
        for (n10 = 0; n10 < (n11 = (lazyStringList = this.mentionPids_).size()); ++n10) {
            n11 = 9;
            Object object2 = this.mentionPids_.getRaw(n10);
            GeneratedMessageV3.writeString(codedOutputStream, n11, object2);
        }
        n10 = this.bitField0_;
        n11 = 256;
        if ((n10 &= n11) == n11) {
            n10 = 10;
            n11 = (int)(this.bin_ ? 1 : 0);
            codedOutputStream.writeBool(n10, n11 != 0);
        }
        n10 = this.bitField0_;
        n11 = 512;
        if ((n10 &= n11) == n11) {
            n10 = 11;
            n11 = this.convType_;
            codedOutputStream.writeInt32(n10, n11);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

