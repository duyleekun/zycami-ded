/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$ConvCommand$1;
import cn.leancloud.Messages$ConvCommand$Builder;
import cn.leancloud.Messages$ConvCommandOrBuilder;
import cn.leancloud.Messages$ConvMemberInfo;
import cn.leancloud.Messages$ConvMemberInfoOrBuilder;
import cn.leancloud.Messages$ErrorCommand;
import cn.leancloud.Messages$ErrorCommandOrBuilder;
import cn.leancloud.Messages$JsonObjectMessage;
import cn.leancloud.Messages$JsonObjectMessageOrBuilder;
import cn.leancloud.Messages$MaxReadTuple;
import cn.leancloud.Messages$MaxReadTupleOrBuilder;
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

public final class Messages$ConvCommand
extends GeneratedMessageV3
implements Messages$ConvCommandOrBuilder {
    public static final int ALLOWEDPIDS_FIELD_NUMBER = 30;
    public static final int ATTRMODIFIED_FIELD_NUMBER = 104;
    public static final int ATTR_FIELD_NUMBER = 103;
    public static final int CDATE_FIELD_NUMBER = 5;
    public static final int CIDS_FIELD_NUMBER = 25;
    public static final int CID_FIELD_NUMBER = 4;
    public static final int COUNT_FIELD_NUMBER = 11;
    private static final Messages$ConvCommand DEFAULT_INSTANCE;
    public static final int EXISTING_FIELD_NUMBER = 32;
    public static final int FAILEDPIDS_FIELD_NUMBER = 31;
    public static final int FLAG_FIELD_NUMBER = 10;
    public static final int INFO_FIELD_NUMBER = 26;
    public static final int INITBY_FIELD_NUMBER = 6;
    public static final int LIMIT_FIELD_NUMBER = 8;
    public static final int MAXACKTIMESTAMP_FIELD_NUMBER = 22;
    public static final int MAXREADTIMESTAMP_FIELD_NUMBER = 21;
    public static final int MAXREADTUPLES_FIELD_NUMBER = 24;
    public static final int M_FIELD_NUMBER = 1;
    public static final int NEXT_FIELD_NUMBER = 40;
    public static final int N_FIELD_NUMBER = 14;
    public static final Parser PARSER;
    public static final int QUERYALLMEMBERS_FIELD_NUMBER = 23;
    public static final int RESULTS_FIELD_NUMBER = 100;
    public static final int SKIP_FIELD_NUMBER = 9;
    public static final int SORT_FIELD_NUMBER = 7;
    public static final int STATUSPUB_FIELD_NUMBER = 17;
    public static final int STATUSSUB_FIELD_NUMBER = 16;
    public static final int STATUSTTL_FIELD_NUMBER = 18;
    public static final int S_FIELD_NUMBER = 15;
    public static final int TARGETCLIENTID_FIELD_NUMBER = 20;
    public static final int TEMPCONVIDS_FIELD_NUMBER = 29;
    public static final int TEMPCONVTTL_FIELD_NUMBER = 28;
    public static final int TEMPCONV_FIELD_NUMBER = 27;
    public static final int TRANSIENT_FIELD_NUMBER = 2;
    public static final int T_FIELD_NUMBER = 13;
    public static final int UDATE_FIELD_NUMBER = 12;
    public static final int UNIQUEID_FIELD_NUMBER = 19;
    public static final int UNIQUE_FIELD_NUMBER = 3;
    public static final int WHERE_FIELD_NUMBER = 101;
    private static final long serialVersionUID;
    private LazyStringList allowedPids_;
    private Messages$JsonObjectMessage attrModified_;
    private Messages$JsonObjectMessage attr_;
    private int bitField0_;
    private volatile Object cdate_;
    private volatile Object cid_;
    private LazyStringList cids_;
    private int count_;
    private boolean existing_;
    private List failedPids_;
    private int flag_;
    private Messages$ConvMemberInfo info_;
    private volatile Object initBy_;
    private int limit_;
    private LazyStringList m_;
    private long maxAckTimestamp_;
    private long maxReadTimestamp_;
    private List maxReadTuples_;
    private byte memoizedIsInitialized;
    private volatile Object n_;
    private volatile Object next_;
    private boolean queryAllMembers_;
    private Messages$JsonObjectMessage results_;
    private volatile Object s_;
    private int skip_;
    private volatile Object sort_;
    private boolean statusPub_;
    private boolean statusSub_;
    private int statusTTL_;
    private long t_;
    private volatile Object targetClientId_;
    private LazyStringList tempConvIds_;
    private int tempConvTTL_;
    private boolean tempConv_;
    private boolean transient_;
    private volatile Object udate_;
    private volatile Object uniqueId_;
    private boolean unique_;
    private Messages$JsonObjectMessage where_;

    static {
        Object object = new Messages$ConvCommand();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$ConvCommand$1();
    }

    private Messages$ConvCommand() {
        List list;
        long l10;
        List list2;
        this.memoizedIsInitialized = (byte)-1;
        this.m_ = list2 = LazyStringArrayList.EMPTY;
        this.transient_ = false;
        this.unique_ = false;
        String string2 = "";
        this.cid_ = string2;
        this.cdate_ = string2;
        this.initBy_ = string2;
        this.sort_ = string2;
        this.limit_ = 0;
        this.skip_ = 0;
        this.flag_ = 0;
        this.count_ = 0;
        this.udate_ = string2;
        this.t_ = l10 = 0L;
        this.n_ = string2;
        this.s_ = string2;
        this.statusSub_ = false;
        this.statusPub_ = false;
        this.statusTTL_ = 0;
        this.uniqueId_ = string2;
        this.targetClientId_ = string2;
        this.maxReadTimestamp_ = l10;
        this.maxAckTimestamp_ = l10;
        this.queryAllMembers_ = false;
        this.maxReadTuples_ = list = Collections.emptyList();
        this.cids_ = list2;
        this.tempConv_ = false;
        this.tempConvTTL_ = 0;
        this.tempConvIds_ = list2;
        this.allowedPids_ = list2;
        list2 = Collections.emptyList();
        this.failedPids_ = list2;
        this.existing_ = false;
        this.next_ = string2;
    }

    /*
     * Exception decompiling
     */
    private Messages$ConvCommand(CodedInputStream var1_1, ExtensionRegistryLite var2_7) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 144[TRYBLOCK] [612 : 2173->2176)] java.lang.Throwable
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

    public /* synthetic */ Messages$ConvCommand(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$ConvCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ Messages$ConvCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$24200() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ LazyStringList access$24400(Messages$ConvCommand messages$ConvCommand) {
        return messages$ConvCommand.m_;
    }

    public static /* synthetic */ LazyStringList access$24402(Messages$ConvCommand messages$ConvCommand, LazyStringList lazyStringList) {
        messages$ConvCommand.m_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ boolean access$24502(Messages$ConvCommand messages$ConvCommand, boolean bl2) {
        messages$ConvCommand.transient_ = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean access$24602(Messages$ConvCommand messages$ConvCommand, boolean bl2) {
        messages$ConvCommand.unique_ = bl2;
        return bl2;
    }

    public static /* synthetic */ Object access$24700(Messages$ConvCommand messages$ConvCommand) {
        return messages$ConvCommand.cid_;
    }

    public static /* synthetic */ Object access$24702(Messages$ConvCommand messages$ConvCommand, Object object) {
        messages$ConvCommand.cid_ = object;
        return object;
    }

    public static /* synthetic */ Object access$24800(Messages$ConvCommand messages$ConvCommand) {
        return messages$ConvCommand.cdate_;
    }

    public static /* synthetic */ Object access$24802(Messages$ConvCommand messages$ConvCommand, Object object) {
        messages$ConvCommand.cdate_ = object;
        return object;
    }

    public static /* synthetic */ Object access$24900(Messages$ConvCommand messages$ConvCommand) {
        return messages$ConvCommand.initBy_;
    }

    public static /* synthetic */ Object access$24902(Messages$ConvCommand messages$ConvCommand, Object object) {
        messages$ConvCommand.initBy_ = object;
        return object;
    }

    public static /* synthetic */ Object access$25000(Messages$ConvCommand messages$ConvCommand) {
        return messages$ConvCommand.sort_;
    }

    public static /* synthetic */ Object access$25002(Messages$ConvCommand messages$ConvCommand, Object object) {
        messages$ConvCommand.sort_ = object;
        return object;
    }

    public static /* synthetic */ int access$25102(Messages$ConvCommand messages$ConvCommand, int n10) {
        messages$ConvCommand.limit_ = n10;
        return n10;
    }

    public static /* synthetic */ int access$25202(Messages$ConvCommand messages$ConvCommand, int n10) {
        messages$ConvCommand.skip_ = n10;
        return n10;
    }

    public static /* synthetic */ int access$25302(Messages$ConvCommand messages$ConvCommand, int n10) {
        messages$ConvCommand.flag_ = n10;
        return n10;
    }

    public static /* synthetic */ int access$25402(Messages$ConvCommand messages$ConvCommand, int n10) {
        messages$ConvCommand.count_ = n10;
        return n10;
    }

    public static /* synthetic */ Object access$25500(Messages$ConvCommand messages$ConvCommand) {
        return messages$ConvCommand.udate_;
    }

    public static /* synthetic */ Object access$25502(Messages$ConvCommand messages$ConvCommand, Object object) {
        messages$ConvCommand.udate_ = object;
        return object;
    }

    public static /* synthetic */ long access$25602(Messages$ConvCommand messages$ConvCommand, long l10) {
        messages$ConvCommand.t_ = l10;
        return l10;
    }

    public static /* synthetic */ Object access$25700(Messages$ConvCommand messages$ConvCommand) {
        return messages$ConvCommand.n_;
    }

    public static /* synthetic */ Object access$25702(Messages$ConvCommand messages$ConvCommand, Object object) {
        messages$ConvCommand.n_ = object;
        return object;
    }

    public static /* synthetic */ Object access$25800(Messages$ConvCommand messages$ConvCommand) {
        return messages$ConvCommand.s_;
    }

    public static /* synthetic */ Object access$25802(Messages$ConvCommand messages$ConvCommand, Object object) {
        messages$ConvCommand.s_ = object;
        return object;
    }

    public static /* synthetic */ boolean access$25902(Messages$ConvCommand messages$ConvCommand, boolean bl2) {
        messages$ConvCommand.statusSub_ = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean access$26002(Messages$ConvCommand messages$ConvCommand, boolean bl2) {
        messages$ConvCommand.statusPub_ = bl2;
        return bl2;
    }

    public static /* synthetic */ int access$26102(Messages$ConvCommand messages$ConvCommand, int n10) {
        messages$ConvCommand.statusTTL_ = n10;
        return n10;
    }

    public static /* synthetic */ Object access$26200(Messages$ConvCommand messages$ConvCommand) {
        return messages$ConvCommand.uniqueId_;
    }

    public static /* synthetic */ Object access$26202(Messages$ConvCommand messages$ConvCommand, Object object) {
        messages$ConvCommand.uniqueId_ = object;
        return object;
    }

    public static /* synthetic */ Object access$26300(Messages$ConvCommand messages$ConvCommand) {
        return messages$ConvCommand.targetClientId_;
    }

    public static /* synthetic */ Object access$26302(Messages$ConvCommand messages$ConvCommand, Object object) {
        messages$ConvCommand.targetClientId_ = object;
        return object;
    }

    public static /* synthetic */ long access$26402(Messages$ConvCommand messages$ConvCommand, long l10) {
        messages$ConvCommand.maxReadTimestamp_ = l10;
        return l10;
    }

    public static /* synthetic */ long access$26502(Messages$ConvCommand messages$ConvCommand, long l10) {
        messages$ConvCommand.maxAckTimestamp_ = l10;
        return l10;
    }

    public static /* synthetic */ boolean access$26602(Messages$ConvCommand messages$ConvCommand, boolean bl2) {
        messages$ConvCommand.queryAllMembers_ = bl2;
        return bl2;
    }

    public static /* synthetic */ List access$26700(Messages$ConvCommand messages$ConvCommand) {
        return messages$ConvCommand.maxReadTuples_;
    }

    public static /* synthetic */ List access$26702(Messages$ConvCommand messages$ConvCommand, List list) {
        messages$ConvCommand.maxReadTuples_ = list;
        return list;
    }

    public static /* synthetic */ LazyStringList access$26800(Messages$ConvCommand messages$ConvCommand) {
        return messages$ConvCommand.cids_;
    }

    public static /* synthetic */ LazyStringList access$26802(Messages$ConvCommand messages$ConvCommand, LazyStringList lazyStringList) {
        messages$ConvCommand.cids_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ Messages$ConvMemberInfo access$26902(Messages$ConvCommand messages$ConvCommand, Messages$ConvMemberInfo messages$ConvMemberInfo) {
        messages$ConvCommand.info_ = messages$ConvMemberInfo;
        return messages$ConvMemberInfo;
    }

    public static /* synthetic */ boolean access$27002(Messages$ConvCommand messages$ConvCommand, boolean bl2) {
        messages$ConvCommand.tempConv_ = bl2;
        return bl2;
    }

    public static /* synthetic */ int access$27102(Messages$ConvCommand messages$ConvCommand, int n10) {
        messages$ConvCommand.tempConvTTL_ = n10;
        return n10;
    }

    public static /* synthetic */ LazyStringList access$27200(Messages$ConvCommand messages$ConvCommand) {
        return messages$ConvCommand.tempConvIds_;
    }

    public static /* synthetic */ LazyStringList access$27202(Messages$ConvCommand messages$ConvCommand, LazyStringList lazyStringList) {
        messages$ConvCommand.tempConvIds_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ LazyStringList access$27300(Messages$ConvCommand messages$ConvCommand) {
        return messages$ConvCommand.allowedPids_;
    }

    public static /* synthetic */ LazyStringList access$27302(Messages$ConvCommand messages$ConvCommand, LazyStringList lazyStringList) {
        messages$ConvCommand.allowedPids_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ List access$27400(Messages$ConvCommand messages$ConvCommand) {
        return messages$ConvCommand.failedPids_;
    }

    public static /* synthetic */ List access$27402(Messages$ConvCommand messages$ConvCommand, List list) {
        messages$ConvCommand.failedPids_ = list;
        return list;
    }

    public static /* synthetic */ boolean access$27502(Messages$ConvCommand messages$ConvCommand, boolean bl2) {
        messages$ConvCommand.existing_ = bl2;
        return bl2;
    }

    public static /* synthetic */ Object access$27600(Messages$ConvCommand messages$ConvCommand) {
        return messages$ConvCommand.next_;
    }

    public static /* synthetic */ Object access$27602(Messages$ConvCommand messages$ConvCommand, Object object) {
        messages$ConvCommand.next_ = object;
        return object;
    }

    public static /* synthetic */ Messages$JsonObjectMessage access$27702(Messages$ConvCommand messages$ConvCommand, Messages$JsonObjectMessage messages$JsonObjectMessage) {
        messages$ConvCommand.results_ = messages$JsonObjectMessage;
        return messages$JsonObjectMessage;
    }

    public static /* synthetic */ Messages$JsonObjectMessage access$27802(Messages$ConvCommand messages$ConvCommand, Messages$JsonObjectMessage messages$JsonObjectMessage) {
        messages$ConvCommand.where_ = messages$JsonObjectMessage;
        return messages$JsonObjectMessage;
    }

    public static /* synthetic */ Messages$JsonObjectMessage access$27902(Messages$ConvCommand messages$ConvCommand, Messages$JsonObjectMessage messages$JsonObjectMessage) {
        messages$ConvCommand.attr_ = messages$JsonObjectMessage;
        return messages$JsonObjectMessage;
    }

    public static /* synthetic */ Messages$JsonObjectMessage access$28002(Messages$ConvCommand messages$ConvCommand, Messages$JsonObjectMessage messages$JsonObjectMessage) {
        messages$ConvCommand.attrModified_ = messages$JsonObjectMessage;
        return messages$JsonObjectMessage;
    }

    public static /* synthetic */ int access$28102(Messages$ConvCommand messages$ConvCommand, int n10) {
        messages$ConvCommand.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ boolean access$28200() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ boolean access$28300() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ UnknownFieldSet access$28400(Messages$ConvCommand messages$ConvCommand) {
        return messages$ConvCommand.unknownFields;
    }

    public static Messages$ConvCommand getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$23800();
    }

    public static Messages$ConvCommand$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$ConvCommand$Builder newBuilder(Messages$ConvCommand messages$ConvCommand) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$ConvCommand);
    }

    public static Messages$ConvCommand parseDelimitedFrom(InputStream inputStream) {
        return (Messages$ConvCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$ConvCommand parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ConvCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$ConvCommand parseFrom(ByteString byteString) {
        return (Messages$ConvCommand)PARSER.parseFrom(byteString);
    }

    public static Messages$ConvCommand parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ConvCommand)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$ConvCommand parseFrom(CodedInputStream codedInputStream) {
        return (Messages$ConvCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$ConvCommand parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ConvCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$ConvCommand parseFrom(InputStream inputStream) {
        return (Messages$ConvCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$ConvCommand parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ConvCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$ConvCommand parseFrom(ByteBuffer byteBuffer) {
        return (Messages$ConvCommand)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$ConvCommand parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ConvCommand)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$ConvCommand parseFrom(byte[] byArray) {
        return (Messages$ConvCommand)PARSER.parseFrom(byArray);
    }

    public static Messages$ConvCommand parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$ConvCommand)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2;
        long l10;
        long l11;
        Object object2;
        int n10;
        int n11 = 1;
        if (object == this) {
            return n11;
        }
        int n12 = object instanceof Messages$ConvCommand;
        if (!n12) {
            return super.equals(object);
        }
        object = (Messages$ConvCommand)object;
        Object object3 = this.getMList();
        ProtocolStringList protocolStringList = ((Messages$ConvCommand)object).getMList();
        n12 = object3.equals(protocolStringList);
        protocolStringList = null;
        if (n12) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        if (n12 && (n12 = this.hasTransient()) == (n10 = ((Messages$ConvCommand)object).hasTransient())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasTransient();
        if (n10 != 0) {
            if (n12 && (n12 = this.getTransient()) == (n10 = ((Messages$ConvCommand)object).getTransient())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = this.hasUnique()) == (n10 = ((Messages$ConvCommand)object).hasUnique())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasUnique();
        if (n10 != 0) {
            if (n12 && (n12 = this.getUnique()) == (n10 = ((Messages$ConvCommand)object).getUnique())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = this.hasCid()) == (n10 = ((Messages$ConvCommand)object).hasCid())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasCid();
        if (n10 != 0) {
            if (n12 && (n12 = ((String)(object3 = this.getCid())).equals(object2 = ((Messages$ConvCommand)object).getCid()))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = this.hasCdate()) == (n10 = ((Messages$ConvCommand)object).hasCdate())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasCdate();
        if (n10 != 0) {
            if (n12 && (n12 = ((String)(object3 = this.getCdate())).equals(object2 = ((Messages$ConvCommand)object).getCdate()))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = this.hasInitBy()) == (n10 = ((Messages$ConvCommand)object).hasInitBy())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasInitBy();
        if (n10 != 0) {
            if (n12 && (n12 = ((String)(object3 = this.getInitBy())).equals(object2 = ((Messages$ConvCommand)object).getInitBy()))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = this.hasSort()) == (n10 = ((Messages$ConvCommand)object).hasSort())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasSort();
        if (n10 != 0) {
            if (n12 && (n12 = ((String)(object3 = this.getSort())).equals(object2 = ((Messages$ConvCommand)object).getSort()))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = this.hasLimit()) == (n10 = ((Messages$ConvCommand)object).hasLimit())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasLimit();
        if (n10 != 0) {
            if (n12 && (n12 = this.getLimit()) == (n10 = ((Messages$ConvCommand)object).getLimit())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasSkip() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).hasSkip() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasSkip() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = this.getSkip()) == (n10 = ((Messages$ConvCommand)object).getSkip())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasFlag() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).hasFlag() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasFlag() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = this.getFlag()) == (n10 = ((Messages$ConvCommand)object).getFlag())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasCount() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).hasCount() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasCount() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = this.getCount()) == (n10 = ((Messages$ConvCommand)object).getCount())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasUdate() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).hasUdate() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasUdate() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((String)(object3 = this.getUdate())).equals(object2 = ((Messages$ConvCommand)object).getUdate()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasT() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).hasT() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasT() ? 1 : 0);
        if (n10 != 0) {
            long l12;
            if (n12 && !(n12 = (int)((l12 = (l11 = this.getT()) - (l10 = ((Messages$ConvCommand)object).getT())) == 0L ? 0 : (l12 < 0L ? -1 : 1)))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasN() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).hasN() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasN() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((String)(object3 = this.getN())).equals(object2 = ((Messages$ConvCommand)object).getN()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasS() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).hasS() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasS() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((String)(object3 = this.getS())).equals(object2 = ((Messages$ConvCommand)object).getS()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasStatusSub() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).hasStatusSub() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasStatusSub() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(this.getStatusSub() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).getStatusSub() ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasStatusPub() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).hasStatusPub() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasStatusPub() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(this.getStatusPub() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).getStatusPub() ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasStatusTTL() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).hasStatusTTL() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasStatusTTL() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = this.getStatusTTL()) == (n10 = ((Messages$ConvCommand)object).getStatusTTL())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasUniqueId() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).hasUniqueId() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasUniqueId() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((String)(object3 = this.getUniqueId())).equals(object2 = ((Messages$ConvCommand)object).getUniqueId()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasTargetClientId() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).hasTargetClientId() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasTargetClientId() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((String)(object3 = this.getTargetClientId())).equals(object2 = ((Messages$ConvCommand)object).getTargetClientId()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasMaxReadTimestamp() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).hasMaxReadTimestamp() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasMaxReadTimestamp() ? 1 : 0);
        if (n10 != 0) {
            long l13;
            if (n12 && !(n12 = (int)((l13 = (l11 = this.getMaxReadTimestamp()) - (l10 = ((Messages$ConvCommand)object).getMaxReadTimestamp())) == 0L ? 0 : (l13 < 0L ? -1 : 1)))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasMaxAckTimestamp() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).hasMaxAckTimestamp() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasMaxAckTimestamp() ? 1 : 0);
        if (n10 != 0) {
            long l14;
            if (n12 && !(n12 = (int)((l14 = (l11 = this.getMaxAckTimestamp()) - (l10 = ((Messages$ConvCommand)object).getMaxAckTimestamp())) == 0L ? 0 : (l14 < 0L ? -1 : 1)))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasQueryAllMembers() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).hasQueryAllMembers() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasQueryAllMembers() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(this.getQueryAllMembers() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).getQueryAllMembers() ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)((object3 = this.getMaxReadTuplesList()).equals(object2 = ((Messages$ConvCommand)object).getMaxReadTuplesList()) ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        if (n12 && (n12 = (int)((object3 = this.getCidsList()).equals(object2 = ((Messages$ConvCommand)object).getCidsList()) ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        if (n12 && (n12 = (int)(this.hasInfo() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).hasInfo() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasInfo() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((Messages$ConvMemberInfo)(object3 = this.getInfo())).equals(object2 = ((Messages$ConvCommand)object).getInfo()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasTempConv() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).hasTempConv() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasTempConv() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(this.getTempConv() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).getTempConv() ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasTempConvTTL() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).hasTempConvTTL() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasTempConvTTL() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = this.getTempConvTTL()) == (n10 = ((Messages$ConvCommand)object).getTempConvTTL())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)((object3 = this.getTempConvIdsList()).equals(object2 = ((Messages$ConvCommand)object).getTempConvIdsList()) ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        if (n12 && (n12 = (int)((object3 = this.getAllowedPidsList()).equals(object2 = ((Messages$ConvCommand)object).getAllowedPidsList()) ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        if (n12 && (n12 = (int)((object3 = this.getFailedPidsList()).equals(object2 = ((Messages$ConvCommand)object).getFailedPidsList()) ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        if (n12 && (n12 = (int)(this.hasExisting() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).hasExisting() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasExisting() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(this.getExisting() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).getExisting() ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasNext() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).hasNext() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasNext() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((String)(object3 = this.getNext())).equals(object2 = ((Messages$ConvCommand)object).getNext()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasResults() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).hasResults() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasResults() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((Messages$JsonObjectMessage)(object3 = this.getResults())).equals(object2 = ((Messages$ConvCommand)object).getResults()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasWhere() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).hasWhere() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasWhere() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((Messages$JsonObjectMessage)(object3 = this.getWhere())).equals(object2 = ((Messages$ConvCommand)object).getWhere()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasAttr() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).hasAttr() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasAttr() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((Messages$JsonObjectMessage)(object3 = this.getAttr())).equals(object2 = ((Messages$ConvCommand)object).getAttr()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasAttrModified() ? 1 : 0)) == (n10 = (int)(((Messages$ConvCommand)object).hasAttrModified() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasAttrModified() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = ((Messages$JsonObjectMessage)(object3 = this.getAttrModified())).equals(object2 = ((Messages$ConvCommand)object).getAttrModified()))) {
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

    public Messages$JsonObjectMessage getAttr() {
        Messages$JsonObjectMessage messages$JsonObjectMessage = this.attr_;
        if (messages$JsonObjectMessage == null) {
            messages$JsonObjectMessage = Messages$JsonObjectMessage.getDefaultInstance();
        }
        return messages$JsonObjectMessage;
    }

    public Messages$JsonObjectMessage getAttrModified() {
        Messages$JsonObjectMessage messages$JsonObjectMessage = this.attrModified_;
        if (messages$JsonObjectMessage == null) {
            messages$JsonObjectMessage = Messages$JsonObjectMessage.getDefaultInstance();
        }
        return messages$JsonObjectMessage;
    }

    public Messages$JsonObjectMessageOrBuilder getAttrModifiedOrBuilder() {
        Messages$JsonObjectMessage messages$JsonObjectMessage = this.attrModified_;
        if (messages$JsonObjectMessage == null) {
            messages$JsonObjectMessage = Messages$JsonObjectMessage.getDefaultInstance();
        }
        return messages$JsonObjectMessage;
    }

    public Messages$JsonObjectMessageOrBuilder getAttrOrBuilder() {
        Messages$JsonObjectMessage messages$JsonObjectMessage = this.attr_;
        if (messages$JsonObjectMessage == null) {
            messages$JsonObjectMessage = Messages$JsonObjectMessage.getDefaultInstance();
        }
        return messages$JsonObjectMessage;
    }

    public String getCdate() {
        Object object = this.cdate_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.cdate_ = string2;
        }
        return string2;
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
        return this.cids_;
    }

    public int getCount() {
        return this.count_;
    }

    public Messages$ConvCommand getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public boolean getExisting() {
        return this.existing_;
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

    public int getFlag() {
        return this.flag_;
    }

    public Messages$ConvMemberInfo getInfo() {
        Messages$ConvMemberInfo messages$ConvMemberInfo = this.info_;
        if (messages$ConvMemberInfo == null) {
            messages$ConvMemberInfo = Messages$ConvMemberInfo.getDefaultInstance();
        }
        return messages$ConvMemberInfo;
    }

    public Messages$ConvMemberInfoOrBuilder getInfoOrBuilder() {
        Messages$ConvMemberInfo messages$ConvMemberInfo = this.info_;
        if (messages$ConvMemberInfo == null) {
            messages$ConvMemberInfo = Messages$ConvMemberInfo.getDefaultInstance();
        }
        return messages$ConvMemberInfo;
    }

    public String getInitBy() {
        Object object = this.initBy_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.initBy_ = string2;
        }
        return string2;
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
        return this.m_;
    }

    public long getMaxAckTimestamp() {
        return this.maxAckTimestamp_;
    }

    public long getMaxReadTimestamp() {
        return this.maxReadTimestamp_;
    }

    public Messages$MaxReadTuple getMaxReadTuples(int n10) {
        return (Messages$MaxReadTuple)this.maxReadTuples_.get(n10);
    }

    public int getMaxReadTuplesCount() {
        return this.maxReadTuples_.size();
    }

    public List getMaxReadTuplesList() {
        return this.maxReadTuples_;
    }

    public Messages$MaxReadTupleOrBuilder getMaxReadTuplesOrBuilder(int n10) {
        return (Messages$MaxReadTupleOrBuilder)this.maxReadTuples_.get(n10);
    }

    public List getMaxReadTuplesOrBuilderList() {
        return this.maxReadTuples_;
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

    public boolean getQueryAllMembers() {
        return this.queryAllMembers_;
    }

    public Messages$JsonObjectMessage getResults() {
        Messages$JsonObjectMessage messages$JsonObjectMessage = this.results_;
        if (messages$JsonObjectMessage == null) {
            messages$JsonObjectMessage = Messages$JsonObjectMessage.getDefaultInstance();
        }
        return messages$JsonObjectMessage;
    }

    public Messages$JsonObjectMessageOrBuilder getResultsOrBuilder() {
        Messages$JsonObjectMessage messages$JsonObjectMessage = this.results_;
        if (messages$JsonObjectMessage == null) {
            messages$JsonObjectMessage = Messages$JsonObjectMessage.getDefaultInstance();
        }
        return messages$JsonObjectMessage;
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
        long l10;
        Object object;
        Object object2;
        int n10;
        int n11 = this.memoizedSize;
        int n12 = -1;
        if (n11 != n12) {
            return n11;
        }
        n11 = 0;
        Object object3 = null;
        int n13 = 0;
        for (n12 = 0; n12 < (n10 = (object2 = this.m_).size()); ++n12) {
            object2 = this.m_.getRaw(n12);
            n10 = GeneratedMessageV3.computeStringSizeNoTag(object2);
            n13 += n10;
        }
        n13 += 0;
        object3 = this.getMList();
        n12 = object3.size();
        n10 = 1;
        n13 += (n12 *= n10);
        n12 = this.bitField0_ & n10;
        int n14 = 2;
        if (n12 == n10) {
            n12 = (int)(this.transient_ ? 1 : 0);
            n12 = CodedOutputStream.computeBoolSize(n14, n12 != 0);
            n13 += n12;
        }
        if ((n12 = this.bitField0_ & n14) == n14) {
            n10 = (int)(this.unique_ ? 1 : 0);
            n12 = CodedOutputStream.computeBoolSize(3, n10 != 0);
            n13 += n12;
        }
        n12 = this.bitField0_;
        n10 = 4;
        if ((n12 &= n10) == n10) {
            object3 = this.cid_;
            n12 = GeneratedMessageV3.computeStringSize(n10, object3);
            n13 += n12;
        }
        n12 = this.bitField0_;
        n10 = 8;
        if ((n12 &= n10) == n10) {
            object = this.cdate_;
            n12 = GeneratedMessageV3.computeStringSize(5, object);
            n13 += n12;
        }
        n12 = this.bitField0_;
        int n15 = 16;
        if ((n12 &= n15) == n15) {
            Object object4 = this.initBy_;
            n12 = GeneratedMessageV3.computeStringSize(6, object4);
            n13 += n12;
        }
        n12 = this.bitField0_;
        int n16 = 32;
        if ((n12 &= n16) == n16) {
            Object object5 = this.sort_;
            n12 = GeneratedMessageV3.computeStringSize(7, object5);
            n13 += n12;
        }
        n12 = this.bitField0_;
        int n17 = 64;
        if ((n12 &= n17) == n17) {
            n12 = this.limit_;
            n12 = CodedOutputStream.computeInt32Size(n10, n12);
            n13 += n12;
        }
        n12 = this.bitField0_;
        n10 = 128;
        if ((n12 &= n10) == n10) {
            n10 = this.skip_;
            n12 = CodedOutputStream.computeInt32Size(9, n10);
            n13 += n12;
        }
        n12 = this.bitField0_;
        n10 = 256;
        if ((n12 &= n10) == n10) {
            n10 = this.flag_;
            n12 = CodedOutputStream.computeInt32Size(10, n10);
            n13 += n12;
        }
        n12 = this.bitField0_;
        n10 = 512;
        if ((n12 &= n10) == n10) {
            n10 = this.count_;
            n12 = CodedOutputStream.computeInt32Size(11, n10);
            n13 += n12;
        }
        n12 = this.bitField0_;
        n10 = 1024;
        if ((n12 &= n10) == n10) {
            object2 = this.udate_;
            n12 = GeneratedMessageV3.computeStringSize(12, object2);
            n13 += n12;
        }
        n12 = this.bitField0_;
        n10 = 2048;
        if ((n12 &= n10) == n10) {
            l10 = this.t_;
            n12 = CodedOutputStream.computeInt64Size(13, l10);
            n13 += n12;
        }
        n12 = this.bitField0_;
        n10 = 4096;
        if ((n12 &= n10) == n10) {
            object2 = this.n_;
            n12 = GeneratedMessageV3.computeStringSize(14, object2);
            n13 += n12;
        }
        n12 = this.bitField0_;
        n10 = 8192;
        if ((n12 &= n10) == n10) {
            object2 = this.s_;
            n12 = GeneratedMessageV3.computeStringSize(15, object2);
            n13 += n12;
        }
        n12 = this.bitField0_;
        n10 = 16384;
        if ((n12 &= n10) == n10) {
            n12 = (int)(this.statusSub_ ? 1 : 0);
            n12 = CodedOutputStream.computeBoolSize(n15, n12 != 0);
            n13 += n12;
        }
        n12 = this.bitField0_;
        n10 = 32768;
        if ((n12 &= n10) == n10) {
            n10 = (int)(this.statusPub_ ? 1 : 0);
            n12 = CodedOutputStream.computeBoolSize(17, n10 != 0);
            n13 += n12;
        }
        n12 = this.bitField0_;
        n10 = 65536;
        if ((n12 &= n10) == n10) {
            n10 = this.statusTTL_;
            n12 = CodedOutputStream.computeInt32Size(18, n10);
            n13 += n12;
        }
        n12 = this.bitField0_;
        n10 = 131072;
        if ((n12 &= n10) == n10) {
            object2 = this.uniqueId_;
            n12 = GeneratedMessageV3.computeStringSize(19, object2);
            n13 += n12;
        }
        n12 = this.bitField0_;
        n10 = 262144;
        if ((n12 &= n10) == n10) {
            object2 = this.targetClientId_;
            n12 = GeneratedMessageV3.computeStringSize(20, object2);
            n13 += n12;
        }
        n12 = this.bitField0_;
        n10 = 524288;
        if ((n12 &= n10) == n10) {
            l10 = this.maxReadTimestamp_;
            n12 = CodedOutputStream.computeInt64Size(21, l10);
            n13 += n12;
        }
        n12 = this.bitField0_;
        n10 = 0x100000;
        if ((n12 &= n10) == n10) {
            l10 = this.maxAckTimestamp_;
            n12 = CodedOutputStream.computeInt64Size(22, l10);
            n13 += n12;
        }
        n12 = this.bitField0_;
        n10 = 0x200000;
        if ((n12 &= n10) == n10) {
            n10 = (int)(this.queryAllMembers_ ? 1 : 0);
            n12 = CodedOutputStream.computeBoolSize(23, n10 != 0);
            n13 += n12;
        }
        object3 = null;
        for (n12 = 0; n12 < (n10 = (object2 = this.maxReadTuples_).size()); ++n12) {
            object = (MessageLite)this.maxReadTuples_.get(n12);
            n10 = CodedOutputStream.computeMessageSize(24, (MessageLite)object);
            n13 += n10;
        }
        object3 = null;
        n10 = 0;
        object2 = null;
        for (n12 = 0; n12 < (n15 = (object = this.cids_).size()); ++n12) {
            object = this.cids_.getRaw(n12);
            n15 = GeneratedMessageV3.computeStringSizeNoTag(object);
            n10 += n15;
        }
        n13 += n10;
        object3 = this.getCidsList();
        n12 = object3.size() * n14;
        n13 += n12;
        n12 = this.bitField0_;
        n10 = 0x400000;
        if ((n12 &= n10) == n10) {
            object2 = this.getInfo();
            n12 = CodedOutputStream.computeMessageSize(26, (MessageLite)object2);
            n13 += n12;
        }
        n12 = this.bitField0_;
        n10 = 0x800000;
        if ((n12 &= n10) == n10) {
            n10 = (int)(this.tempConv_ ? 1 : 0);
            n12 = CodedOutputStream.computeBoolSize(27, n10 != 0);
            n13 += n12;
        }
        n12 = this.bitField0_;
        n10 = 0x1000000;
        if ((n12 &= n10) == n10) {
            n10 = this.tempConvTTL_;
            n12 = CodedOutputStream.computeInt32Size(28, n10);
            n13 += n12;
        }
        object3 = null;
        n10 = 0;
        object2 = null;
        for (n12 = 0; n12 < (n15 = (object = this.tempConvIds_).size()); ++n12) {
            object = this.tempConvIds_.getRaw(n12);
            n15 = GeneratedMessageV3.computeStringSizeNoTag(object);
            n10 += n15;
        }
        n13 += n10;
        n12 = this.getTempConvIdsList().size() * n14;
        n13 += n12;
        object3 = null;
        n10 = 0;
        object2 = null;
        for (n12 = 0; n12 < (n15 = (object = this.allowedPids_).size()); ++n12) {
            object = this.allowedPids_.getRaw(n12);
            n15 = GeneratedMessageV3.computeStringSizeNoTag(object);
            n10 += n15;
        }
        n13 += n10;
        object3 = this.getAllowedPidsList();
        n12 = object3.size() * n14;
        n13 += n12;
        while (n11 < (n12 = (object3 = this.failedPids_).size())) {
            object2 = (MessageLite)this.failedPids_.get(n11);
            n12 = CodedOutputStream.computeMessageSize(31, (MessageLite)object2);
            n13 += n12;
            ++n11;
        }
        n11 = this.bitField0_;
        n12 = 0x2000000;
        if ((n11 &= n12) == n12) {
            n11 = (int)(this.existing_ ? 1 : 0);
            n11 = CodedOutputStream.computeBoolSize(n16, n11 != 0);
            n13 += n11;
        }
        n11 = this.bitField0_;
        n12 = 0x4000000;
        if ((n11 &= n12) == n12) {
            object3 = this.next_;
            n11 = GeneratedMessageV3.computeStringSize(40, object3);
            n13 += n11;
        }
        n11 = this.bitField0_;
        n12 = 0x8000000;
        if ((n11 &= n12) == n12) {
            object3 = this.getResults();
            n11 = CodedOutputStream.computeMessageSize(100, (MessageLite)object3);
            n13 += n11;
        }
        n11 = this.bitField0_;
        n12 = 0x10000000;
        if ((n11 &= n12) == n12) {
            object3 = this.getWhere();
            n11 = CodedOutputStream.computeMessageSize(101, (MessageLite)object3);
            n13 += n11;
        }
        n11 = this.bitField0_;
        n12 = 0x20000000;
        if ((n11 &= n12) == n12) {
            object3 = this.getAttr();
            n11 = CodedOutputStream.computeMessageSize(103, (MessageLite)object3);
            n13 += n11;
        }
        n11 = this.bitField0_;
        n12 = 0x40000000;
        if ((n11 &= n12) == n12) {
            object3 = this.getAttrModified();
            n11 = CodedOutputStream.computeMessageSize(104, (MessageLite)object3);
            n13 += n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n13 += n11;
        return n13;
    }

    public int getSkip() {
        return this.skip_;
    }

    public String getSort() {
        Object object = this.sort_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.sort_ = string2;
        }
        return string2;
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
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.targetClientId_ = string2;
        }
        return string2;
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
        return this.tempConvIds_;
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
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.udate_ = string2;
        }
        return string2;
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
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.uniqueId_ = string2;
        }
        return string2;
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

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public Messages$JsonObjectMessage getWhere() {
        Messages$JsonObjectMessage messages$JsonObjectMessage = this.where_;
        if (messages$JsonObjectMessage == null) {
            messages$JsonObjectMessage = Messages$JsonObjectMessage.getDefaultInstance();
        }
        return messages$JsonObjectMessage;
    }

    public Messages$JsonObjectMessageOrBuilder getWhereOrBuilder() {
        Messages$JsonObjectMessage messages$JsonObjectMessage = this.where_;
        if (messages$JsonObjectMessage == null) {
            messages$JsonObjectMessage = Messages$JsonObjectMessage.getDefaultInstance();
        }
        return messages$JsonObjectMessage;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasAttr() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 0x20000000;
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
        int bl2 = this.bitField0_;
        int n10 = 0x40000000;
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
    public boolean hasCid() {
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
    public boolean hasCount() {
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
    public boolean hasExisting() {
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
    public boolean hasFlag() {
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
    public boolean hasInfo() {
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
    public boolean hasInitBy() {
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
    public boolean hasLimit() {
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
    public boolean hasMaxAckTimestamp() {
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
    public boolean hasMaxReadTimestamp() {
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
    public boolean hasN() {
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
    public boolean hasNext() {
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
    public boolean hasQueryAllMembers() {
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
    public boolean hasResults() {
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
    public boolean hasS() {
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

    /*
     * WARNING - void declaration
     */
    public boolean hasSkip() {
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
    public boolean hasSort() {
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
    public boolean hasStatusPub() {
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
    public boolean hasStatusSub() {
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
    public boolean hasStatusTTL() {
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
    public boolean hasT() {
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
    public boolean hasTargetClientId() {
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
    public boolean hasTempConv() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 0x800000;
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
        int n10 = 0x1000000;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    public boolean hasTransient() {
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
    public boolean hasUdate() {
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
    public boolean hasUnique() {
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
    public boolean hasUniqueId() {
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
    public boolean hasWhere() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 0x10000000;
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
        Object object = Messages$ConvCommand.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = this.getMCount();
        if (n11 > 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getMList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasTransient() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            n11 = Internal.hashBoolean(this.getTransient());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasUnique() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            n11 = Internal.hashBoolean(this.getUnique());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasCid() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 4) * 53;
            object = this.getCid();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasCdate() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 5) * 53;
            object = this.getCdate();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasInitBy() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 6) * 53;
            object = this.getInitBy();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasSort() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 7) * 53;
            object = this.getSort();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasLimit() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 8) * 53;
            n11 = this.getLimit();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasSkip() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 9) * 53;
            n11 = this.getSkip();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasFlag() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 10) * 53;
            n11 = this.getFlag();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasCount() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 11) * 53;
            n11 = this.getCount();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasUdate() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 12) * 53;
            object = this.getUdate();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasT() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 13) * 53;
            l10 = this.getT();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasN() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 14) * 53;
            object = this.getN();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasS() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 15) * 53;
            object = this.getS();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasStatusSub() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 16) * 53;
            n11 = Internal.hashBoolean(this.getStatusSub());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasStatusPub() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 17) * 53;
            n11 = Internal.hashBoolean(this.getStatusPub());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasStatusTTL() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 18) * 53;
            n11 = this.getStatusTTL();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasUniqueId() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 19) * 53;
            object = this.getUniqueId();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasTargetClientId() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 20) * 53;
            object = this.getTargetClientId();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasMaxReadTimestamp() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 21) * 53;
            l10 = this.getMaxReadTimestamp();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasMaxAckTimestamp() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 22) * 53;
            l10 = this.getMaxAckTimestamp();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasQueryAllMembers() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 23) * 53;
            n11 = Internal.hashBoolean(this.getQueryAllMembers());
            n10 += n11;
        }
        if ((n11 = this.getMaxReadTuplesCount()) > 0) {
            n10 = (n10 * 37 + 24) * 53;
            object = this.getMaxReadTuplesList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = this.getCidsCount()) > 0) {
            n10 = (n10 * 37 + 25) * 53;
            object = this.getCidsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasInfo() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 26) * 53;
            object = this.getInfo();
            n11 = ((Messages$ConvMemberInfo)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasTempConv() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 27) * 53;
            n11 = Internal.hashBoolean(this.getTempConv());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasTempConvTTL() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 28) * 53;
            n11 = this.getTempConvTTL();
            n10 += n11;
        }
        if ((n11 = this.getTempConvIdsCount()) > 0) {
            n10 = (n10 * 37 + 29) * 53;
            object = this.getTempConvIdsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = this.getAllowedPidsCount()) > 0) {
            n10 = (n10 * 37 + 30) * 53;
            object = this.getAllowedPidsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = this.getFailedPidsCount()) > 0) {
            n10 = (n10 * 37 + 31) * 53;
            object = this.getFailedPidsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasExisting() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 32) * 53;
            n11 = Internal.hashBoolean(this.getExisting());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasNext() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 40) * 53;
            object = this.getNext();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasResults() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 100) * 53;
            object = this.getResults();
            n11 = ((Messages$JsonObjectMessage)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasWhere() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 101) * 53;
            object = this.getWhere();
            n11 = ((Messages$JsonObjectMessage)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasAttr() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 103) * 53;
            object = this.getAttr();
            n11 = ((Messages$JsonObjectMessage)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasAttrModified() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 104) * 53;
            object = this.getAttrModified();
            n11 = ((Messages$JsonObjectMessage)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$23900().ensureFieldAccessorsInitialized(Messages$ConvCommand.class, Messages$ConvCommand$Builder.class);
    }

    public final boolean isInitialized() {
        byte by2;
        byte by3 = this.memoizedIsInitialized;
        byte by4 = 1;
        if (by3 == by4) {
            return by4 != 0;
        }
        if (!by3) {
            return false;
        }
        Messages$JsonObjectMessage messages$JsonObjectMessage = null;
        for (by3 = 0; by3 < (by2 = this.getFailedPidsCount()); by3 += 1) {
            Messages$ErrorCommand messages$ErrorCommand = this.getFailedPids(by3);
            by2 = (byte)(messages$ErrorCommand.isInitialized() ? 1 : 0);
            if (by2) continue;
            this.memoizedIsInitialized = 0;
            return false;
        }
        by3 = (byte)(this.hasResults() ? 1 : 0);
        if (by3 && !(by3 = (byte)((messages$JsonObjectMessage = this.getResults()).isInitialized() ? 1 : 0))) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        by3 = (byte)(this.hasWhere() ? 1 : 0);
        if (by3 && !(by3 = (byte)((messages$JsonObjectMessage = this.getWhere()).isInitialized() ? 1 : 0))) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        by3 = (byte)(this.hasAttr() ? 1 : 0);
        if (by3 && !(by3 = (byte)((messages$JsonObjectMessage = this.getAttr()).isInitialized() ? 1 : 0))) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        by3 = (byte)(this.hasAttrModified() ? 1 : 0);
        if (by3 && !(by3 = (messages$JsonObjectMessage = this.getAttrModified()).isInitialized())) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = by4;
        return by4 != 0;
    }

    public Messages$ConvCommand$Builder newBuilderForType() {
        return Messages$ConvCommand.newBuilder();
    }

    public Messages$ConvCommand$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$ConvCommand$Builder messages$ConvCommand$Builder = new Messages$ConvCommand$Builder(generatedMessageV3$BuilderParent, null);
        return messages$ConvCommand$Builder;
    }

    public Messages$ConvCommand$Builder toBuilder() {
        Messages$ConvCommandOrBuilder messages$ConvCommandOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$ConvCommandOrBuilder) {
            messages$ConvCommandOrBuilder = new Messages$ConvCommand$Builder(null);
        } else {
            messages$ConvCommandOrBuilder = new Messages$ConvCommand$Builder(null);
            messages$ConvCommandOrBuilder = ((Messages$ConvCommand$Builder)messages$ConvCommandOrBuilder).mergeFrom(this);
        }
        return messages$ConvCommandOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        long l10;
        Object object;
        int n10;
        int n11;
        Object object2;
        int n12 = 0;
        int n13 = 0;
        Object object3 = null;
        while (true) {
            object2 = this.m_;
            n11 = object2.size();
            n10 = 1;
            if (n13 >= n11) break;
            object2 = this.m_.getRaw(n13);
            GeneratedMessageV3.writeString(codedOutputStream, n10, object2);
            ++n13;
        }
        n13 = this.bitField0_ & n10;
        n11 = 2;
        if (n13 == n10) {
            n13 = (int)(this.transient_ ? 1 : 0);
            codedOutputStream.writeBool(n11, n13 != 0);
        }
        if ((n13 = this.bitField0_ & n11) == n11) {
            n13 = 3;
            n11 = (int)(this.unique_ ? 1 : 0);
            codedOutputStream.writeBool(n13, n11 != 0);
        }
        n13 = this.bitField0_;
        n11 = 4;
        if ((n13 &= n11) == n11) {
            object3 = this.cid_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object3);
        }
        n13 = this.bitField0_;
        n11 = 8;
        if ((n13 &= n11) == n11) {
            n13 = 5;
            object = this.cdate_;
            GeneratedMessageV3.writeString(codedOutputStream, n13, object);
        }
        n13 = this.bitField0_;
        n10 = 16;
        if ((n13 &= n10) == n10) {
            n13 = 6;
            Object object4 = this.initBy_;
            GeneratedMessageV3.writeString(codedOutputStream, n13, object4);
        }
        n13 = this.bitField0_;
        int n14 = 32;
        if ((n13 &= n14) == n14) {
            n13 = 7;
            Object object5 = this.sort_;
            GeneratedMessageV3.writeString(codedOutputStream, n13, object5);
        }
        n13 = this.bitField0_;
        int n15 = 64;
        if ((n13 &= n15) == n15) {
            n13 = this.limit_;
            codedOutputStream.writeInt32(n11, n13);
        }
        n13 = this.bitField0_;
        n11 = 128;
        if ((n13 &= n11) == n11) {
            n13 = 9;
            n11 = this.skip_;
            codedOutputStream.writeInt32(n13, n11);
        }
        n13 = this.bitField0_;
        n11 = 256;
        if ((n13 &= n11) == n11) {
            n13 = 10;
            n11 = this.flag_;
            codedOutputStream.writeInt32(n13, n11);
        }
        n13 = this.bitField0_;
        n11 = 512;
        if ((n13 &= n11) == n11) {
            n13 = 11;
            n11 = this.count_;
            codedOutputStream.writeInt32(n13, n11);
        }
        n13 = this.bitField0_;
        n11 = 1024;
        if ((n13 &= n11) == n11) {
            n13 = 12;
            object2 = this.udate_;
            GeneratedMessageV3.writeString(codedOutputStream, n13, object2);
        }
        n13 = this.bitField0_;
        n11 = 2048;
        if ((n13 &= n11) == n11) {
            n13 = 13;
            long l11 = this.t_;
            codedOutputStream.writeInt64(n13, l11);
        }
        n13 = this.bitField0_;
        n11 = 4096;
        if ((n13 &= n11) == n11) {
            n13 = 14;
            object2 = this.n_;
            GeneratedMessageV3.writeString(codedOutputStream, n13, object2);
        }
        n13 = this.bitField0_;
        n11 = 8192;
        if ((n13 &= n11) == n11) {
            n13 = 15;
            object2 = this.s_;
            GeneratedMessageV3.writeString(codedOutputStream, n13, object2);
        }
        n13 = this.bitField0_;
        n11 = 16384;
        if ((n13 &= n11) == n11) {
            n13 = (int)(this.statusSub_ ? 1 : 0);
            codedOutputStream.writeBool(n10, n13 != 0);
        }
        n13 = this.bitField0_;
        n11 = 32768;
        if ((n13 &= n11) == n11) {
            n13 = 17;
            n11 = (int)(this.statusPub_ ? 1 : 0);
            codedOutputStream.writeBool(n13, n11 != 0);
        }
        n13 = this.bitField0_;
        n11 = 65536;
        if ((n13 &= n11) == n11) {
            n13 = 18;
            n11 = this.statusTTL_;
            codedOutputStream.writeInt32(n13, n11);
        }
        n13 = this.bitField0_;
        n11 = 131072;
        if ((n13 &= n11) == n11) {
            n13 = 19;
            object2 = this.uniqueId_;
            GeneratedMessageV3.writeString(codedOutputStream, n13, object2);
        }
        n13 = this.bitField0_;
        n11 = 262144;
        if ((n13 &= n11) == n11) {
            n13 = 20;
            object2 = this.targetClientId_;
            GeneratedMessageV3.writeString(codedOutputStream, n13, object2);
        }
        n13 = this.bitField0_;
        n11 = 524288;
        if ((n13 &= n11) == n11) {
            n13 = 21;
            l10 = this.maxReadTimestamp_;
            codedOutputStream.writeInt64(n13, l10);
        }
        n13 = this.bitField0_;
        n11 = 0x100000;
        if ((n13 &= n11) == n11) {
            n13 = 22;
            l10 = this.maxAckTimestamp_;
            codedOutputStream.writeInt64(n13, l10);
        }
        n13 = this.bitField0_;
        n11 = 0x200000;
        if ((n13 &= n11) == n11) {
            n13 = 23;
            n11 = (int)(this.queryAllMembers_ ? 1 : 0);
            codedOutputStream.writeBool(n13, n11 != 0);
        }
        object3 = null;
        for (n13 = 0; n13 < (n11 = (object2 = this.maxReadTuples_).size()); ++n13) {
            n11 = 24;
            object = (MessageLite)this.maxReadTuples_.get(n13);
            codedOutputStream.writeMessage(n11, (MessageLite)object);
        }
        object3 = null;
        for (n13 = 0; n13 < (n11 = (object2 = this.cids_).size()); ++n13) {
            n11 = 25;
            object = this.cids_.getRaw(n13);
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        n13 = this.bitField0_;
        n11 = 0x400000;
        if ((n13 &= n11) == n11) {
            n13 = 26;
            object2 = this.getInfo();
            codedOutputStream.writeMessage(n13, (MessageLite)object2);
        }
        n13 = this.bitField0_;
        n11 = 0x800000;
        if ((n13 &= n11) == n11) {
            n13 = 27;
            n11 = (int)(this.tempConv_ ? 1 : 0);
            codedOutputStream.writeBool(n13, n11 != 0);
        }
        n13 = this.bitField0_;
        n11 = 0x1000000;
        if ((n13 &= n11) == n11) {
            n13 = 28;
            n11 = this.tempConvTTL_;
            codedOutputStream.writeInt32(n13, n11);
        }
        object3 = null;
        for (n13 = 0; n13 < (n11 = (object2 = this.tempConvIds_).size()); ++n13) {
            n11 = 29;
            object = this.tempConvIds_.getRaw(n13);
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        object3 = null;
        for (n13 = 0; n13 < (n11 = (object2 = this.allowedPids_).size()); ++n13) {
            n11 = 30;
            object = this.allowedPids_.getRaw(n13);
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        while (n12 < (n13 = (object3 = this.failedPids_).size())) {
            n13 = 31;
            object2 = (MessageLite)this.failedPids_.get(n12);
            codedOutputStream.writeMessage(n13, (MessageLite)object2);
            ++n12;
        }
        n12 = this.bitField0_;
        n13 = 0x2000000;
        if ((n12 &= n13) == n13) {
            n12 = (int)(this.existing_ ? 1 : 0);
            codedOutputStream.writeBool(n14, n12 != 0);
        }
        n12 = this.bitField0_;
        n13 = 0x4000000;
        if ((n12 &= n13) == n13) {
            n12 = 40;
            object3 = this.next_;
            GeneratedMessageV3.writeString(codedOutputStream, n12, object3);
        }
        n12 = this.bitField0_;
        n13 = 0x8000000;
        if ((n12 &= n13) == n13) {
            n12 = 100;
            object3 = this.getResults();
            codedOutputStream.writeMessage(n12, (MessageLite)object3);
        }
        n12 = this.bitField0_;
        n13 = 0x10000000;
        if ((n12 &= n13) == n13) {
            n12 = 101;
            object3 = this.getWhere();
            codedOutputStream.writeMessage(n12, (MessageLite)object3);
        }
        n12 = this.bitField0_;
        n13 = 0x20000000;
        if ((n12 &= n13) == n13) {
            n12 = 103;
            object3 = this.getAttr();
            codedOutputStream.writeMessage(n12, (MessageLite)object3);
        }
        n12 = this.bitField0_;
        n13 = 0x40000000;
        if ((n12 &= n13) == n13) {
            n12 = 104;
            object3 = this.getAttrModified();
            codedOutputStream.writeMessage(n12, (MessageLite)object3);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

