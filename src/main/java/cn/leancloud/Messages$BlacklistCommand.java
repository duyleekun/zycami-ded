/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$BlacklistCommand$1;
import cn.leancloud.Messages$BlacklistCommand$Builder;
import cn.leancloud.Messages$BlacklistCommandOrBuilder;
import cn.leancloud.Messages$ErrorCommand;
import cn.leancloud.Messages$ErrorCommandOrBuilder;
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
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class Messages$BlacklistCommand
extends GeneratedMessageV3
implements Messages$BlacklistCommandOrBuilder {
    public static final int ALLOWEDPIDS_FIELD_NUMBER = 10;
    public static final int BLOCKEDCIDS_FIELD_NUMBER = 9;
    public static final int BLOCKEDPIDS_FIELD_NUMBER = 8;
    private static final Messages$BlacklistCommand DEFAULT_INSTANCE;
    public static final int FAILEDPIDS_FIELD_NUMBER = 11;
    public static final int LIMIT_FIELD_NUMBER = 5;
    public static final int NEXT_FIELD_NUMBER = 6;
    public static final int N_FIELD_NUMBER = 13;
    public static final Parser PARSER;
    public static final int SRCCID_FIELD_NUMBER = 1;
    public static final int SRCPID_FIELD_NUMBER = 3;
    public static final int S_FIELD_NUMBER = 14;
    public static final int TOCIDS_FIELD_NUMBER = 4;
    public static final int TOPIDS_FIELD_NUMBER = 2;
    public static final int T_FIELD_NUMBER = 12;
    private static final long serialVersionUID;
    private LazyStringList allowedPids_;
    private int bitField0_;
    private LazyStringList blockedCids_;
    private LazyStringList blockedPids_;
    private List failedPids_;
    private int limit_;
    private byte memoizedIsInitialized;
    private volatile Object n_;
    private volatile Object next_;
    private volatile Object s_;
    private volatile Object srcCid_;
    private volatile Object srcPid_;
    private long t_;
    private LazyStringList toCids_;
    private LazyStringList toPids_;

    static {
        Object object = new Messages$BlacklistCommand();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$BlacklistCommand$1();
    }

    private Messages$BlacklistCommand() {
        List list;
        this.memoizedIsInitialized = (byte)-1;
        String string2 = "";
        this.srcCid_ = string2;
        this.toPids_ = list = LazyStringArrayList.EMPTY;
        this.srcPid_ = string2;
        this.toCids_ = list;
        this.limit_ = 0;
        this.next_ = string2;
        this.blockedPids_ = list;
        this.blockedCids_ = list;
        this.allowedPids_ = list;
        list = Collections.emptyList();
        this.failedPids_ = list;
        this.t_ = 0L;
        this.n_ = string2;
        this.s_ = string2;
    }

    /*
     * Exception decompiling
     */
    private Messages$BlacklistCommand(CodedInputStream var1_1, ExtensionRegistryLite var2_7) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 54[TRYBLOCK] [201 : 806->809)] java.lang.Throwable
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

    public /* synthetic */ Messages$BlacklistCommand(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$BlacklistCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ Messages$BlacklistCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$45400() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ Object access$45600(Messages$BlacklistCommand messages$BlacklistCommand) {
        return messages$BlacklistCommand.srcCid_;
    }

    public static /* synthetic */ Object access$45602(Messages$BlacklistCommand messages$BlacklistCommand, Object object) {
        messages$BlacklistCommand.srcCid_ = object;
        return object;
    }

    public static /* synthetic */ LazyStringList access$45700(Messages$BlacklistCommand messages$BlacklistCommand) {
        return messages$BlacklistCommand.toPids_;
    }

    public static /* synthetic */ LazyStringList access$45702(Messages$BlacklistCommand messages$BlacklistCommand, LazyStringList lazyStringList) {
        messages$BlacklistCommand.toPids_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ Object access$45800(Messages$BlacklistCommand messages$BlacklistCommand) {
        return messages$BlacklistCommand.srcPid_;
    }

    public static /* synthetic */ Object access$45802(Messages$BlacklistCommand messages$BlacklistCommand, Object object) {
        messages$BlacklistCommand.srcPid_ = object;
        return object;
    }

    public static /* synthetic */ LazyStringList access$45900(Messages$BlacklistCommand messages$BlacklistCommand) {
        return messages$BlacklistCommand.toCids_;
    }

    public static /* synthetic */ LazyStringList access$45902(Messages$BlacklistCommand messages$BlacklistCommand, LazyStringList lazyStringList) {
        messages$BlacklistCommand.toCids_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ int access$46002(Messages$BlacklistCommand messages$BlacklistCommand, int n10) {
        messages$BlacklistCommand.limit_ = n10;
        return n10;
    }

    public static /* synthetic */ Object access$46100(Messages$BlacklistCommand messages$BlacklistCommand) {
        return messages$BlacklistCommand.next_;
    }

    public static /* synthetic */ Object access$46102(Messages$BlacklistCommand messages$BlacklistCommand, Object object) {
        messages$BlacklistCommand.next_ = object;
        return object;
    }

    public static /* synthetic */ LazyStringList access$46200(Messages$BlacklistCommand messages$BlacklistCommand) {
        return messages$BlacklistCommand.blockedPids_;
    }

    public static /* synthetic */ LazyStringList access$46202(Messages$BlacklistCommand messages$BlacklistCommand, LazyStringList lazyStringList) {
        messages$BlacklistCommand.blockedPids_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ LazyStringList access$46300(Messages$BlacklistCommand messages$BlacklistCommand) {
        return messages$BlacklistCommand.blockedCids_;
    }

    public static /* synthetic */ LazyStringList access$46302(Messages$BlacklistCommand messages$BlacklistCommand, LazyStringList lazyStringList) {
        messages$BlacklistCommand.blockedCids_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ LazyStringList access$46400(Messages$BlacklistCommand messages$BlacklistCommand) {
        return messages$BlacklistCommand.allowedPids_;
    }

    public static /* synthetic */ LazyStringList access$46402(Messages$BlacklistCommand messages$BlacklistCommand, LazyStringList lazyStringList) {
        messages$BlacklistCommand.allowedPids_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ List access$46500(Messages$BlacklistCommand messages$BlacklistCommand) {
        return messages$BlacklistCommand.failedPids_;
    }

    public static /* synthetic */ List access$46502(Messages$BlacklistCommand messages$BlacklistCommand, List list) {
        messages$BlacklistCommand.failedPids_ = list;
        return list;
    }

    public static /* synthetic */ long access$46602(Messages$BlacklistCommand messages$BlacklistCommand, long l10) {
        messages$BlacklistCommand.t_ = l10;
        return l10;
    }

    public static /* synthetic */ Object access$46700(Messages$BlacklistCommand messages$BlacklistCommand) {
        return messages$BlacklistCommand.n_;
    }

    public static /* synthetic */ Object access$46702(Messages$BlacklistCommand messages$BlacklistCommand, Object object) {
        messages$BlacklistCommand.n_ = object;
        return object;
    }

    public static /* synthetic */ Object access$46800(Messages$BlacklistCommand messages$BlacklistCommand) {
        return messages$BlacklistCommand.s_;
    }

    public static /* synthetic */ Object access$46802(Messages$BlacklistCommand messages$BlacklistCommand, Object object) {
        messages$BlacklistCommand.s_ = object;
        return object;
    }

    public static /* synthetic */ int access$46902(Messages$BlacklistCommand messages$BlacklistCommand, int n10) {
        messages$BlacklistCommand.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ boolean access$47000() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ UnknownFieldSet access$47100(Messages$BlacklistCommand messages$BlacklistCommand) {
        return messages$BlacklistCommand.unknownFields;
    }

    public static Messages$BlacklistCommand getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$45000();
    }

    public static Messages$BlacklistCommand$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$BlacklistCommand$Builder newBuilder(Messages$BlacklistCommand messages$BlacklistCommand) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$BlacklistCommand);
    }

    public static Messages$BlacklistCommand parseDelimitedFrom(InputStream inputStream) {
        return (Messages$BlacklistCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$BlacklistCommand parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$BlacklistCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$BlacklistCommand parseFrom(ByteString byteString) {
        return (Messages$BlacklistCommand)PARSER.parseFrom(byteString);
    }

    public static Messages$BlacklistCommand parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$BlacklistCommand)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$BlacklistCommand parseFrom(CodedInputStream codedInputStream) {
        return (Messages$BlacklistCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$BlacklistCommand parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$BlacklistCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$BlacklistCommand parseFrom(InputStream inputStream) {
        return (Messages$BlacklistCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$BlacklistCommand parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$BlacklistCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$BlacklistCommand parseFrom(ByteBuffer byteBuffer) {
        return (Messages$BlacklistCommand)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$BlacklistCommand parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$BlacklistCommand)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$BlacklistCommand parseFrom(byte[] byArray) {
        return (Messages$BlacklistCommand)PARSER.parseFrom(byArray);
    }

    public static Messages$BlacklistCommand parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$BlacklistCommand)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2;
        Object object2;
        Object object3;
        int n10;
        int n11 = 1;
        if (object == this) {
            return n11;
        }
        int n12 = object instanceof Messages$BlacklistCommand;
        if (!n12) {
            return super.equals(object);
        }
        object = (Messages$BlacklistCommand)object;
        n12 = this.hasSrcCid();
        if (n12 == (n10 = ((Messages$BlacklistCommand)object).hasSrcCid())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasSrcCid();
        if (n10 != 0) {
            if (n12 && (n12 = ((String)(object3 = this.getSrcCid())).equals(object2 = ((Messages$BlacklistCommand)object).getSrcCid()))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (object3 = this.getToPidsList()).equals(object2 = ((Messages$BlacklistCommand)object).getToPidsList()))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        if (n12 && (n12 = this.hasSrcPid()) == (n10 = ((Messages$BlacklistCommand)object).hasSrcPid())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasSrcPid();
        if (n10 != 0) {
            if (n12 && (n12 = ((String)(object3 = this.getSrcPid())).equals(object2 = ((Messages$BlacklistCommand)object).getSrcPid()))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (object3 = this.getToCidsList()).equals(object2 = ((Messages$BlacklistCommand)object).getToCidsList()))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        if (n12 && (n12 = this.hasLimit()) == (n10 = ((Messages$BlacklistCommand)object).hasLimit())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasLimit();
        if (n10 != 0) {
            if (n12 && (n12 = this.getLimit()) == (n10 = ((Messages$BlacklistCommand)object).getLimit())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasNext() ? 1 : 0)) == (n10 = (int)(((Messages$BlacklistCommand)object).hasNext() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasNext() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((String)(object3 = this.getNext())).equals(object2 = ((Messages$BlacklistCommand)object).getNext()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)((object3 = this.getBlockedPidsList()).equals(object2 = ((Messages$BlacklistCommand)object).getBlockedPidsList()) ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        if (n12 && (n12 = (int)((object3 = this.getBlockedCidsList()).equals(object2 = ((Messages$BlacklistCommand)object).getBlockedCidsList()) ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        if (n12 && (n12 = (int)((object3 = this.getAllowedPidsList()).equals(object2 = ((Messages$BlacklistCommand)object).getAllowedPidsList()) ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        if (n12 && (n12 = (int)((object3 = this.getFailedPidsList()).equals(object2 = ((Messages$BlacklistCommand)object).getFailedPidsList()) ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        if (n12 && (n12 = (int)(this.hasT() ? 1 : 0)) == (n10 = (int)(((Messages$BlacklistCommand)object).hasT() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasT() ? 1 : 0);
        if (n10 != 0) {
            long l10;
            long l11;
            long l12;
            if (n12 && !(n12 = (int)((l12 = (l11 = this.getT()) - (l10 = ((Messages$BlacklistCommand)object).getT())) == 0L ? 0 : (l12 < 0L ? -1 : 1)))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasN() ? 1 : 0)) == (n10 = (int)(((Messages$BlacklistCommand)object).hasN() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasN() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((String)(object3 = this.getN())).equals(object2 = ((Messages$BlacklistCommand)object).getN()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasS() ? 1 : 0)) == (n10 = (int)(((Messages$BlacklistCommand)object).hasS() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasS() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = ((String)(object3 = this.getS())).equals(object2 = ((Messages$BlacklistCommand)object).getS()))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (!n12 || !(bl2 = ((UnknownFieldSet)(object3 = this.unknownFields)).equals(object = ((GeneratedMessageV3)object).unknownFields))) {
            n11 = 0;
        }
        return n11;
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
        return this.allowedPids_;
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
        return this.blockedCids_;
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
        return this.blockedPids_;
    }

    public Messages$BlacklistCommand getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Messages$ErrorCommand getFailedPids(int n10) {
        return (Messages$ErrorCommand)this.failedPids_.get(n10);
    }

    public int getFailedPidsCount() {
        return this.failedPids_.size();
    }

    public List getFailedPidsList() {
        return this.failedPids_;
    }

    public Messages$ErrorCommandOrBuilder getFailedPidsOrBuilder(int n10) {
        return (Messages$ErrorCommandOrBuilder)this.failedPids_.get(n10);
    }

    public List getFailedPidsOrBuilderList() {
        return this.failedPids_;
    }

    public int getLimit() {
        return this.limit_;
    }

    public String getN() {
        Object object = this.n_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.n_ = string2;
        }
        return string2;
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
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.next_ = string2;
        }
        return string2;
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

    public Parser getParserForType() {
        return PARSER;
    }

    public String getS() {
        Object object = this.s_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.s_ = string2;
        }
        return string2;
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

    public int getSerializedSize() {
        List list;
        Object object;
        int n10;
        int n11;
        Object object2;
        int n12 = this.memoizedSize;
        int n13 = -1;
        if (n12 != n13) {
            return n12;
        }
        n12 = this.bitField0_;
        n13 = 1;
        int n14 = 0;
        Object object3 = null;
        if ((n12 &= n13) == n13) {
            object2 = this.srcCid_;
            n12 = GeneratedMessageV3.computeStringSize(n13, object2) + 0;
        } else {
            n12 = 0;
            object2 = null;
        }
        Object object4 = null;
        int n15 = 0;
        Object object5 = null;
        for (n11 = 0; n11 < (n10 = (object = this.toPids_).size()); ++n11) {
            object = this.toPids_.getRaw(n11);
            n10 = GeneratedMessageV3.computeStringSizeNoTag(object);
            n15 += n10;
        }
        n12 += n15;
        object4 = this.getToPidsList();
        n11 = object4.size() * n13;
        n12 += n11;
        n11 = this.bitField0_;
        n15 = 2;
        if ((n11 &= n15) == n15) {
            object5 = this.srcPid_;
            n11 = GeneratedMessageV3.computeStringSize(3, object5);
            n12 += n11;
        }
        object4 = null;
        n15 = 0;
        object5 = null;
        for (n11 = 0; n11 < (n10 = (object = this.toCids_).size()); ++n11) {
            object = this.toCids_.getRaw(n11);
            n10 = GeneratedMessageV3.computeStringSizeNoTag(object);
            n15 += n10;
        }
        n12 += n15;
        object4 = this.getToCidsList();
        n11 = object4.size() * n13;
        n12 += n11;
        n11 = this.bitField0_;
        n15 = 4;
        if ((n11 &= n15) == n15) {
            n15 = this.limit_;
            n11 = CodedOutputStream.computeInt32Size(5, n15);
            n12 += n11;
        }
        n11 = this.bitField0_;
        n15 = 8;
        if ((n11 &= n15) == n15) {
            object5 = this.next_;
            n11 = GeneratedMessageV3.computeStringSize(6, object5);
            n12 += n11;
        }
        object4 = null;
        n15 = 0;
        object5 = null;
        for (n11 = 0; n11 < (n10 = (object = this.blockedPids_).size()); ++n11) {
            object = this.blockedPids_.getRaw(n11);
            n10 = GeneratedMessageV3.computeStringSizeNoTag(object);
            n15 += n10;
        }
        n12 += n15;
        n11 = this.getBlockedPidsList().size() * n13;
        n12 += n11;
        object4 = null;
        n15 = 0;
        object5 = null;
        for (n11 = 0; n11 < (n10 = (object = this.blockedCids_).size()); ++n11) {
            object = this.blockedCids_.getRaw(n11);
            n10 = GeneratedMessageV3.computeStringSizeNoTag(object);
            n15 += n10;
        }
        n12 += n15;
        n11 = this.getBlockedCidsList().size() * n13;
        n12 += n11;
        object4 = null;
        n15 = 0;
        object5 = null;
        for (n11 = 0; n11 < (n10 = (object = this.allowedPids_).size()); ++n11) {
            object = this.allowedPids_.getRaw(n11);
            n10 = GeneratedMessageV3.computeStringSizeNoTag(object);
            n15 += n10;
        }
        n12 += n15;
        object4 = this.getAllowedPidsList();
        n11 = object4.size() * n13;
        n12 += n11;
        while (n14 < (n13 = (list = this.failedPids_).size())) {
            object4 = (MessageLite)this.failedPids_.get(n14);
            n13 = CodedOutputStream.computeMessageSize(11, (MessageLite)object4);
            n12 += n13;
            ++n14;
        }
        n13 = this.bitField0_;
        n14 = 16;
        if ((n13 &= n14) == n14) {
            long l10 = this.t_;
            n13 = CodedOutputStream.computeInt64Size(12, l10);
            n12 += n13;
        }
        n13 = this.bitField0_;
        n14 = 32;
        if ((n13 &= n14) == n14) {
            object3 = this.n_;
            n13 = GeneratedMessageV3.computeStringSize(13, object3);
            n12 += n13;
        }
        n13 = this.bitField0_;
        n14 = 64;
        if ((n13 &= n14) == n14) {
            object3 = this.s_;
            n13 = GeneratedMessageV3.computeStringSize(14, object3);
            n12 += n13;
        }
        n13 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n12 += n13;
        return n12;
    }

    public String getSrcCid() {
        Object object = this.srcCid_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.srcCid_ = string2;
        }
        return string2;
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
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.srcPid_ = string2;
        }
        return string2;
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
        return this.toCids_;
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
        return this.toPids_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
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
    public boolean hasN() {
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
    public boolean hasNext() {
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
    public boolean hasS() {
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

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = Messages$BlacklistCommand.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasSrcCid() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getSrcCid();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = this.getToPidsCount()) > 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getToPidsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasSrcPid() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            object = this.getSrcPid();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = this.getToCidsCount()) > 0) {
            n10 = (n10 * 37 + 4) * 53;
            object = this.getToCidsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasLimit() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 5) * 53;
            n11 = this.getLimit();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasNext() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 6) * 53;
            object = this.getNext();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = this.getBlockedPidsCount()) > 0) {
            n10 = (n10 * 37 + 8) * 53;
            object = this.getBlockedPidsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = this.getBlockedCidsCount()) > 0) {
            n10 = (n10 * 37 + 9) * 53;
            object = this.getBlockedCidsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = this.getAllowedPidsCount()) > 0) {
            n10 = (n10 * 37 + 10) * 53;
            object = this.getAllowedPidsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = this.getFailedPidsCount()) > 0) {
            n10 = (n10 * 37 + 11) * 53;
            object = this.getFailedPidsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasT() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 12) * 53;
            long l10 = this.getT();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasN() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 13) * 53;
            object = this.getN();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasS() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 14) * 53;
            object = this.getS();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$45100().ensureFieldAccessorsInitialized(Messages$BlacklistCommand.class, Messages$BlacklistCommand$Builder.class);
    }

    public final boolean isInitialized() {
        int n10;
        int n11 = this.memoizedIsInitialized;
        int n12 = 1;
        if (n11 == n12) {
            return n12 != 0;
        }
        if (n11 == 0) {
            return false;
        }
        for (n11 = 0; n11 < (n10 = this.getFailedPidsCount()); ++n11) {
            Messages$ErrorCommand messages$ErrorCommand = this.getFailedPids(n11);
            n10 = messages$ErrorCommand.isInitialized();
            if (n10 != 0) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = (byte)n12;
        return n12 != 0;
    }

    public Messages$BlacklistCommand$Builder newBuilderForType() {
        return Messages$BlacklistCommand.newBuilder();
    }

    public Messages$BlacklistCommand$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$BlacklistCommand$Builder messages$BlacklistCommand$Builder = new Messages$BlacklistCommand$Builder(generatedMessageV3$BuilderParent, null);
        return messages$BlacklistCommand$Builder;
    }

    public Messages$BlacklistCommand$Builder toBuilder() {
        Messages$BlacklistCommandOrBuilder messages$BlacklistCommandOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$BlacklistCommandOrBuilder) {
            messages$BlacklistCommandOrBuilder = new Messages$BlacklistCommand$Builder(null);
        } else {
            messages$BlacklistCommandOrBuilder = new Messages$BlacklistCommand$Builder(null);
            messages$BlacklistCommandOrBuilder = ((Messages$BlacklistCommand$Builder)messages$BlacklistCommandOrBuilder).mergeFrom(this);
        }
        return messages$BlacklistCommandOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Object object;
        int n10;
        int n11;
        Object object2;
        Object object3;
        int n12 = this.bitField0_;
        int n13 = 1;
        if ((n12 &= n13) == n13) {
            object3 = this.srcCid_;
            GeneratedMessageV3.writeString(codedOutputStream, n13, object3);
        }
        n12 = 0;
        object3 = null;
        n13 = 0;
        Object object4 = null;
        while (true) {
            object2 = this.toPids_;
            n11 = object2.size();
            n10 = 2;
            if (n13 >= n11) break;
            object2 = this.toPids_.getRaw(n13);
            GeneratedMessageV3.writeString(codedOutputStream, n10, object2);
            ++n13;
        }
        n13 = this.bitField0_ & n10;
        if (n13 == n10) {
            n13 = 3;
            object2 = this.srcPid_;
            GeneratedMessageV3.writeString(codedOutputStream, n13, object2);
        }
        n13 = 0;
        object4 = null;
        while (true) {
            object2 = this.toCids_;
            n11 = object2.size();
            n10 = 4;
            if (n13 >= n11) break;
            object2 = this.toCids_.getRaw(n13);
            GeneratedMessageV3.writeString(codedOutputStream, n10, object2);
            ++n13;
        }
        n13 = this.bitField0_ & n10;
        if (n13 == n10) {
            n13 = 5;
            n11 = this.limit_;
            codedOutputStream.writeInt32(n13, n11);
        }
        n13 = this.bitField0_;
        n11 = 8;
        if ((n13 &= n11) == n11) {
            n13 = 6;
            object = this.next_;
            GeneratedMessageV3.writeString(codedOutputStream, n13, object);
        }
        object4 = null;
        for (n13 = 0; n13 < (n10 = (object = this.blockedPids_).size()); ++n13) {
            object = this.blockedPids_.getRaw(n13);
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        object4 = null;
        for (n13 = 0; n13 < (n11 = (object2 = this.blockedCids_).size()); ++n13) {
            n11 = 9;
            object = this.blockedCids_.getRaw(n13);
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        object4 = null;
        for (n13 = 0; n13 < (n11 = (object2 = this.allowedPids_).size()); ++n13) {
            n11 = 10;
            object = this.allowedPids_.getRaw(n13);
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        while (n12 < (n13 = (object4 = this.failedPids_).size())) {
            n13 = 11;
            object2 = (MessageLite)this.failedPids_.get(n12);
            codedOutputStream.writeMessage(n13, (MessageLite)object2);
            ++n12;
        }
        n12 = this.bitField0_;
        n13 = 16;
        if ((n12 &= n13) == n13) {
            n12 = 12;
            long l10 = this.t_;
            codedOutputStream.writeInt64(n12, l10);
        }
        n12 = this.bitField0_;
        n13 = 32;
        if ((n12 &= n13) == n13) {
            n12 = 13;
            object4 = this.n_;
            GeneratedMessageV3.writeString(codedOutputStream, n12, object4);
        }
        n12 = this.bitField0_;
        n13 = 64;
        if ((n12 &= n13) == n13) {
            n12 = 14;
            object4 = this.s_;
            GeneratedMessageV3.writeString(codedOutputStream, n12, object4);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

