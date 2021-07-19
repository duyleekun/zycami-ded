/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$PatchItem$1;
import cn.leancloud.Messages$PatchItem$Builder;
import cn.leancloud.Messages$PatchItemOrBuilder;
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

public final class Messages$PatchItem
extends GeneratedMessageV3
implements Messages$PatchItemOrBuilder {
    public static final int BINARYMSG_FIELD_NUMBER = 8;
    public static final int CID_FIELD_NUMBER = 1;
    public static final int DATA_FIELD_NUMBER = 5;
    private static final Messages$PatchItem DEFAULT_INSTANCE;
    public static final int FROM_FIELD_NUMBER = 7;
    public static final int MENTIONALL_FIELD_NUMBER = 9;
    public static final int MENTIONPIDS_FIELD_NUMBER = 10;
    public static final int MID_FIELD_NUMBER = 2;
    public static final Parser PARSER;
    public static final int PATCHCODE_FIELD_NUMBER = 11;
    public static final int PATCHREASON_FIELD_NUMBER = 12;
    public static final int PATCHTIMESTAMP_FIELD_NUMBER = 6;
    public static final int RECALL_FIELD_NUMBER = 4;
    public static final int TIMESTAMP_FIELD_NUMBER = 3;
    private static final long serialVersionUID;
    private ByteString binaryMsg_;
    private int bitField0_;
    private volatile Object cid_;
    private volatile Object data_;
    private volatile Object from_;
    private byte memoizedIsInitialized;
    private boolean mentionAll_;
    private LazyStringList mentionPids_;
    private volatile Object mid_;
    private long patchCode_;
    private volatile Object patchReason_;
    private long patchTimestamp_;
    private boolean recall_;
    private long timestamp_;

    static {
        Object object = new Messages$PatchItem();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$PatchItem$1();
    }

    private Messages$PatchItem() {
        LazyStringList lazyStringList;
        ByteString byteString;
        long l10;
        this.memoizedIsInitialized = (byte)-1;
        String string2 = "";
        this.cid_ = string2;
        this.mid_ = string2;
        this.timestamp_ = l10 = 0L;
        this.recall_ = false;
        this.data_ = string2;
        this.patchTimestamp_ = l10;
        this.from_ = string2;
        this.binaryMsg_ = byteString = ByteString.EMPTY;
        this.mentionAll_ = false;
        this.mentionPids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.patchCode_ = l10;
        this.patchReason_ = string2;
    }

    /*
     * Exception decompiling
     */
    private Messages$PatchItem(CodedInputStream var1_1, ExtensionRegistryLite var2_7) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 35[TRYBLOCK] [156 : 580->583)] java.lang.Throwable
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

    public /* synthetic */ Messages$PatchItem(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$PatchItem(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ Messages$PatchItem(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$40500() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ Object access$40700(Messages$PatchItem messages$PatchItem) {
        return messages$PatchItem.cid_;
    }

    public static /* synthetic */ Object access$40702(Messages$PatchItem messages$PatchItem, Object object) {
        messages$PatchItem.cid_ = object;
        return object;
    }

    public static /* synthetic */ Object access$40800(Messages$PatchItem messages$PatchItem) {
        return messages$PatchItem.mid_;
    }

    public static /* synthetic */ Object access$40802(Messages$PatchItem messages$PatchItem, Object object) {
        messages$PatchItem.mid_ = object;
        return object;
    }

    public static /* synthetic */ long access$40902(Messages$PatchItem messages$PatchItem, long l10) {
        messages$PatchItem.timestamp_ = l10;
        return l10;
    }

    public static /* synthetic */ boolean access$41002(Messages$PatchItem messages$PatchItem, boolean bl2) {
        messages$PatchItem.recall_ = bl2;
        return bl2;
    }

    public static /* synthetic */ Object access$41100(Messages$PatchItem messages$PatchItem) {
        return messages$PatchItem.data_;
    }

    public static /* synthetic */ Object access$41102(Messages$PatchItem messages$PatchItem, Object object) {
        messages$PatchItem.data_ = object;
        return object;
    }

    public static /* synthetic */ long access$41202(Messages$PatchItem messages$PatchItem, long l10) {
        messages$PatchItem.patchTimestamp_ = l10;
        return l10;
    }

    public static /* synthetic */ Object access$41300(Messages$PatchItem messages$PatchItem) {
        return messages$PatchItem.from_;
    }

    public static /* synthetic */ Object access$41302(Messages$PatchItem messages$PatchItem, Object object) {
        messages$PatchItem.from_ = object;
        return object;
    }

    public static /* synthetic */ ByteString access$41402(Messages$PatchItem messages$PatchItem, ByteString byteString) {
        messages$PatchItem.binaryMsg_ = byteString;
        return byteString;
    }

    public static /* synthetic */ boolean access$41502(Messages$PatchItem messages$PatchItem, boolean bl2) {
        messages$PatchItem.mentionAll_ = bl2;
        return bl2;
    }

    public static /* synthetic */ LazyStringList access$41600(Messages$PatchItem messages$PatchItem) {
        return messages$PatchItem.mentionPids_;
    }

    public static /* synthetic */ LazyStringList access$41602(Messages$PatchItem messages$PatchItem, LazyStringList lazyStringList) {
        messages$PatchItem.mentionPids_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ long access$41702(Messages$PatchItem messages$PatchItem, long l10) {
        messages$PatchItem.patchCode_ = l10;
        return l10;
    }

    public static /* synthetic */ Object access$41800(Messages$PatchItem messages$PatchItem) {
        return messages$PatchItem.patchReason_;
    }

    public static /* synthetic */ Object access$41802(Messages$PatchItem messages$PatchItem, Object object) {
        messages$PatchItem.patchReason_ = object;
        return object;
    }

    public static /* synthetic */ int access$41902(Messages$PatchItem messages$PatchItem, int n10) {
        messages$PatchItem.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ UnknownFieldSet access$42000(Messages$PatchItem messages$PatchItem) {
        return messages$PatchItem.unknownFields;
    }

    public static Messages$PatchItem getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$40100();
    }

    public static Messages$PatchItem$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$PatchItem$Builder newBuilder(Messages$PatchItem messages$PatchItem) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$PatchItem);
    }

    public static Messages$PatchItem parseDelimitedFrom(InputStream inputStream) {
        return (Messages$PatchItem)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$PatchItem parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$PatchItem)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$PatchItem parseFrom(ByteString byteString) {
        return (Messages$PatchItem)PARSER.parseFrom(byteString);
    }

    public static Messages$PatchItem parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$PatchItem)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$PatchItem parseFrom(CodedInputStream codedInputStream) {
        return (Messages$PatchItem)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$PatchItem parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$PatchItem)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$PatchItem parseFrom(InputStream inputStream) {
        return (Messages$PatchItem)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$PatchItem parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$PatchItem)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$PatchItem parseFrom(ByteBuffer byteBuffer) {
        return (Messages$PatchItem)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$PatchItem parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$PatchItem)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$PatchItem parseFrom(byte[] byArray) {
        return (Messages$PatchItem)PARSER.parseFrom(byArray);
    }

    public static Messages$PatchItem parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$PatchItem)PARSER.parseFrom(byArray, extensionRegistryLite);
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
        boolean bl3;
        boolean bl4 = true;
        if (object == this) {
            return bl4;
        }
        boolean bl5 = object instanceof Messages$PatchItem;
        if (!bl5) {
            return super.equals(object);
        }
        object = (Messages$PatchItem)object;
        bl5 = this.hasCid();
        if (bl5 == (bl3 = ((Messages$PatchItem)object).hasCid())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        bl3 = this.hasCid();
        if (bl3) {
            if (bl5 && (bl5 = ((String)(object3 = this.getCid())).equals(object2 = ((Messages$PatchItem)object).getCid()))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object3 = null;
            }
        }
        if (bl5 && (bl5 = this.hasMid()) == (bl3 = ((Messages$PatchItem)object).hasMid())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        bl3 = this.hasMid();
        if (bl3) {
            if (bl5 && (bl5 = ((String)(object3 = this.getMid())).equals(object2 = ((Messages$PatchItem)object).getMid()))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object3 = null;
            }
        }
        if (bl5 && (bl5 = this.hasTimestamp()) == (bl3 = ((Messages$PatchItem)object).hasTimestamp())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        bl3 = this.hasTimestamp();
        if (bl3) {
            long l12;
            if (bl5 && !(bl5 = (l12 = (l11 = this.getTimestamp()) - (l10 = ((Messages$PatchItem)object).getTimestamp())) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object3 = null;
            }
        }
        if (bl5 && (bl5 = this.hasRecall()) == (bl3 = ((Messages$PatchItem)object).hasRecall())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        bl3 = this.hasRecall();
        if (bl3) {
            if (bl5 && (bl5 = this.getRecall()) == (bl3 = ((Messages$PatchItem)object).getRecall())) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object3 = null;
            }
        }
        if (bl5 && (bl5 = this.hasData()) == (bl3 = ((Messages$PatchItem)object).hasData())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        bl3 = this.hasData();
        if (bl3) {
            if (bl5 && (bl5 = ((String)(object3 = this.getData())).equals(object2 = ((Messages$PatchItem)object).getData()))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object3 = null;
            }
        }
        if (bl5 && (bl5 = this.hasPatchTimestamp()) == (bl3 = ((Messages$PatchItem)object).hasPatchTimestamp())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        bl3 = this.hasPatchTimestamp();
        if (bl3) {
            long l13;
            if (bl5 && !(bl5 = (l13 = (l11 = this.getPatchTimestamp()) - (l10 = ((Messages$PatchItem)object).getPatchTimestamp())) == 0L ? 0 : (l13 < 0L ? -1 : 1))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object3 = null;
            }
        }
        if (bl5 && (bl5 = this.hasFrom()) == (bl3 = ((Messages$PatchItem)object).hasFrom())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        bl3 = this.hasFrom();
        if (bl3) {
            if (bl5 && (bl5 = ((String)(object3 = this.getFrom())).equals(object2 = ((Messages$PatchItem)object).getFrom()))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object3 = null;
            }
        }
        if (bl5 && (bl5 = this.hasBinaryMsg()) == (bl3 = ((Messages$PatchItem)object).hasBinaryMsg())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        bl3 = this.hasBinaryMsg();
        if (bl3) {
            if (bl5 && (bl5 = ((ByteString)(object3 = this.getBinaryMsg())).equals(object2 = ((Messages$PatchItem)object).getBinaryMsg()))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object3 = null;
            }
        }
        if (bl5 && (bl5 = this.hasMentionAll()) == (bl3 = ((Messages$PatchItem)object).hasMentionAll())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        bl3 = this.hasMentionAll();
        if (bl3) {
            if (bl5 && (bl5 = this.getMentionAll()) == (bl3 = ((Messages$PatchItem)object).getMentionAll())) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object3 = null;
            }
        }
        if (bl5 && (bl5 = (object3 = this.getMentionPidsList()).equals(object2 = ((Messages$PatchItem)object).getMentionPidsList()))) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        if (bl5 && (bl5 = this.hasPatchCode()) == (bl3 = ((Messages$PatchItem)object).hasPatchCode())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        bl3 = this.hasPatchCode();
        if (bl3) {
            long l14;
            if (bl5 && !(bl5 = (l14 = (l11 = this.getPatchCode()) - (l10 = ((Messages$PatchItem)object).getPatchCode())) == 0L ? 0 : (l14 < 0L ? -1 : 1))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object3 = null;
            }
        }
        if (bl5 && (bl5 = this.hasPatchReason()) == (bl3 = ((Messages$PatchItem)object).hasPatchReason())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        bl3 = this.hasPatchReason();
        if (bl3) {
            if (bl5 && (bl5 = ((String)(object3 = this.getPatchReason())).equals(object2 = ((Messages$PatchItem)object).getPatchReason()))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object3 = null;
            }
        }
        if (!bl5 || !(bl2 = ((UnknownFieldSet)(object3 = this.unknownFields)).equals(object = ((GeneratedMessageV3)object).unknownFields))) {
            bl4 = false;
        }
        return bl4;
    }

    public ByteString getBinaryMsg() {
        return this.binaryMsg_;
    }

    public String getCid() {
        Object object = this.cid_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.cid_ = string2;
        }
        return string2;
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

    public Messages$PatchItem getDefaultInstanceForType() {
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

    public String getMid() {
        Object object = this.mid_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.mid_ = string2;
        }
        return string2;
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

    public Parser getParserForType() {
        return PARSER;
    }

    public long getPatchCode() {
        return this.patchCode_;
    }

    public String getPatchReason() {
        Object object = this.patchReason_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.patchReason_ = string2;
        }
        return string2;
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

    public int getSerializedSize() {
        Object object;
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
        Object object4 = null;
        if ((n10 &= n11) == n11) {
            object3 = this.cid_;
            n10 = GeneratedMessageV3.computeStringSize(n11, object3) + 0;
        } else {
            n10 = 0;
            object3 = null;
        }
        int n13 = this.bitField0_;
        int n14 = 2;
        if ((n13 &= n14) == n14) {
            object2 = this.mid_;
            n13 = GeneratedMessageV3.computeStringSize(n14, object2);
            n10 += n13;
        }
        n13 = this.bitField0_;
        n14 = 4;
        if ((n13 &= n14) == n14) {
            long l10 = this.timestamp_;
            n13 = CodedOutputStream.computeInt64Size(3, l10);
            n10 += n13;
        }
        n13 = this.bitField0_;
        int n15 = 8;
        if ((n13 &= n15) == n15) {
            n13 = (int)(this.recall_ ? 1 : 0);
            n13 = CodedOutputStream.computeBoolSize(n14, n13 != 0);
            n10 += n13;
        }
        n13 = this.bitField0_;
        n14 = 16;
        if ((n13 &= n14) == n14) {
            object = this.data_;
            n13 = GeneratedMessageV3.computeStringSize(5, object);
            n10 += n13;
        }
        n13 = this.bitField0_;
        n14 = 32;
        if ((n13 &= n14) == n14) {
            long l11 = this.patchTimestamp_;
            n13 = CodedOutputStream.computeInt64Size(6, l11);
            n10 += n13;
        }
        n13 = this.bitField0_;
        n14 = 64;
        if ((n13 &= n14) == n14) {
            object = this.from_;
            n13 = GeneratedMessageV3.computeStringSize(7, object);
            n10 += n13;
        }
        n13 = this.bitField0_;
        n14 = 128;
        if ((n13 &= n14) == n14) {
            object2 = this.binaryMsg_;
            n13 = CodedOutputStream.computeBytesSize(n15, (ByteString)object2);
            n10 += n13;
        }
        n13 = this.bitField0_;
        n14 = 256;
        if ((n13 &= n14) == n14) {
            n14 = (int)(this.mentionAll_ ? 1 : 0);
            n13 = CodedOutputStream.computeBoolSize(9, n14 != 0);
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
        object4 = this.getMentionPidsList();
        n12 = object4.size() * n11;
        n10 += n12;
        n11 = this.bitField0_;
        n12 = 512;
        if ((n11 &= n12) == n12) {
            long l12 = this.patchCode_;
            n11 = CodedOutputStream.computeInt64Size(11, l12);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 1024;
        if ((n11 &= n12) == n12) {
            object4 = this.patchReason_;
            n11 = GeneratedMessageV3.computeStringSize(12, object4);
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
    public boolean hasPatchReason() {
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

    public int hashCode() {
        long l10;
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = Messages$PatchItem.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasCid() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getCid();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasMid() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getMid();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasTimestamp() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            l10 = this.getTimestamp();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasRecall() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 4) * 53;
            n11 = Internal.hashBoolean(this.getRecall());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasData() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 5) * 53;
            object = this.getData();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasPatchTimestamp() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 6) * 53;
            l10 = this.getPatchTimestamp();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasFrom() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 7) * 53;
            object = this.getFrom();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasBinaryMsg() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 8) * 53;
            object = this.getBinaryMsg();
            n11 = ((ByteString)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasMentionAll() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 9) * 53;
            n11 = Internal.hashBoolean(this.getMentionAll());
            n10 += n11;
        }
        if ((n11 = this.getMentionPidsCount()) > 0) {
            n10 = (n10 * 37 + 10) * 53;
            object = this.getMentionPidsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasPatchCode() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 11) * 53;
            l10 = this.getPatchCode();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasPatchReason() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 12) * 53;
            object = this.getPatchReason();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$40200().ensureFieldAccessorsInitialized(Messages$PatchItem.class, Messages$PatchItem$Builder.class);
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

    public Messages$PatchItem$Builder newBuilderForType() {
        return Messages$PatchItem.newBuilder();
    }

    public Messages$PatchItem$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$PatchItem$Builder messages$PatchItem$Builder = new Messages$PatchItem$Builder(generatedMessageV3$BuilderParent, null);
        return messages$PatchItem$Builder;
    }

    public Messages$PatchItem$Builder toBuilder() {
        Messages$PatchItemOrBuilder messages$PatchItemOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$PatchItemOrBuilder) {
            messages$PatchItemOrBuilder = new Messages$PatchItem$Builder(null);
        } else {
            messages$PatchItemOrBuilder = new Messages$PatchItem$Builder(null);
            messages$PatchItemOrBuilder = ((Messages$PatchItem$Builder)messages$PatchItemOrBuilder).mergeFrom(this);
        }
        return messages$PatchItemOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Object object;
        Object object2;
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == n11) {
            object2 = this.cid_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object2);
        }
        n10 = this.bitField0_;
        n11 = 2;
        if ((n10 &= n11) == n11) {
            object2 = this.mid_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object2);
        }
        n10 = this.bitField0_;
        n11 = 4;
        if ((n10 &= n11) == n11) {
            n10 = 3;
            long l10 = this.timestamp_;
            codedOutputStream.writeInt64(n10, l10);
        }
        n10 = this.bitField0_;
        int n12 = 8;
        if ((n10 &= n12) == n12) {
            n10 = (int)(this.recall_ ? 1 : 0);
            codedOutputStream.writeBool(n11, n10 != 0);
        }
        n10 = this.bitField0_;
        n11 = 16;
        if ((n10 &= n11) == n11) {
            n10 = 5;
            object = this.data_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object);
        }
        n10 = this.bitField0_;
        n11 = 32;
        if ((n10 &= n11) == n11) {
            n10 = 6;
            long l11 = this.patchTimestamp_;
            codedOutputStream.writeInt64(n10, l11);
        }
        n10 = this.bitField0_;
        n11 = 64;
        if ((n10 &= n11) == n11) {
            n10 = 7;
            object = this.from_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object);
        }
        n10 = this.bitField0_;
        n11 = 128;
        if ((n10 &= n11) == n11) {
            object2 = this.binaryMsg_;
            codedOutputStream.writeBytes(n12, (ByteString)object2);
        }
        n10 = this.bitField0_;
        n11 = 256;
        if ((n10 &= n11) == n11) {
            n10 = 9;
            n11 = (int)(this.mentionAll_ ? 1 : 0);
            codedOutputStream.writeBool(n10, n11 != 0);
        }
        object2 = null;
        for (n10 = 0; n10 < (n11 = (object = this.mentionPids_).size()); ++n10) {
            n11 = 10;
            Object object3 = this.mentionPids_.getRaw(n10);
            GeneratedMessageV3.writeString(codedOutputStream, n11, object3);
        }
        n10 = this.bitField0_;
        n11 = 512;
        if ((n10 &= n11) == n11) {
            n10 = 11;
            long l12 = this.patchCode_;
            codedOutputStream.writeInt64(n10, l12);
        }
        n10 = this.bitField0_;
        n11 = 1024;
        if ((n10 &= n11) == n11) {
            n10 = 12;
            object = this.patchReason_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

