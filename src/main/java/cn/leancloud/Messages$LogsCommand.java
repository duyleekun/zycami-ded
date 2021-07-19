/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$LogItem;
import cn.leancloud.Messages$LogItemOrBuilder;
import cn.leancloud.Messages$LogsCommand$1;
import cn.leancloud.Messages$LogsCommand$Builder;
import cn.leancloud.Messages$LogsCommand$QueryDirection;
import cn.leancloud.Messages$LogsCommandOrBuilder;
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
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class Messages$LogsCommand
extends GeneratedMessageV3
implements Messages$LogsCommandOrBuilder {
    public static final int CHECKSUM_FIELD_NUMBER = 8;
    public static final int CID_FIELD_NUMBER = 1;
    private static final Messages$LogsCommand DEFAULT_INSTANCE;
    public static final int DIRECTION_FIELD_NUMBER = 10;
    public static final int LCTYPE_FIELD_NUMBER = 13;
    public static final int LIMIT_FIELD_NUMBER = 3;
    public static final int LOGS_FIELD_NUMBER = 105;
    public static final int L_FIELD_NUMBER = 2;
    public static final int MID_FIELD_NUMBER = 7;
    public static final Parser PARSER;
    public static final int STORED_FIELD_NUMBER = 9;
    public static final int TINCLUDED_FIELD_NUMBER = 11;
    public static final int TMID_FIELD_NUMBER = 6;
    public static final int TTINCLUDED_FIELD_NUMBER = 12;
    public static final int TT_FIELD_NUMBER = 5;
    public static final int T_FIELD_NUMBER = 4;
    private static final long serialVersionUID;
    private int bitField0_;
    private volatile Object checksum_;
    private volatile Object cid_;
    private int direction_;
    private int l_;
    private int lctype_;
    private int limit_;
    private List logs_;
    private byte memoizedIsInitialized;
    private volatile Object mid_;
    private boolean stored_;
    private boolean tIncluded_;
    private long t_;
    private volatile Object tmid_;
    private boolean ttIncluded_;
    private long tt_;

    static {
        Object object = new Messages$LogsCommand();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$LogsCommand$1();
    }

    private Messages$LogsCommand() {
        long l10;
        Object object;
        this.memoizedIsInitialized = (byte)-1;
        this.cid_ = object = "";
        this.l_ = 0;
        this.limit_ = 0;
        this.t_ = l10 = 0L;
        this.tt_ = l10;
        this.tmid_ = object;
        this.mid_ = object;
        this.checksum_ = object;
        this.stored_ = false;
        this.direction_ = 1;
        this.tIncluded_ = false;
        this.ttIncluded_ = false;
        this.lctype_ = 0;
        this.logs_ = object = Collections.emptyList();
    }

    /*
     * Exception decompiling
     */
    private Messages$LogsCommand(CodedInputStream var1_1, ExtensionRegistryLite var2_7) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 41[TRYBLOCK] [189 : 696->699)] java.lang.Throwable
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

    public /* synthetic */ Messages$LogsCommand(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$LogsCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ Messages$LogsCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$30600() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ Object access$30800(Messages$LogsCommand messages$LogsCommand) {
        return messages$LogsCommand.cid_;
    }

    public static /* synthetic */ Object access$30802(Messages$LogsCommand messages$LogsCommand, Object object) {
        messages$LogsCommand.cid_ = object;
        return object;
    }

    public static /* synthetic */ int access$30902(Messages$LogsCommand messages$LogsCommand, int n10) {
        messages$LogsCommand.l_ = n10;
        return n10;
    }

    public static /* synthetic */ int access$31002(Messages$LogsCommand messages$LogsCommand, int n10) {
        messages$LogsCommand.limit_ = n10;
        return n10;
    }

    public static /* synthetic */ long access$31102(Messages$LogsCommand messages$LogsCommand, long l10) {
        messages$LogsCommand.t_ = l10;
        return l10;
    }

    public static /* synthetic */ long access$31202(Messages$LogsCommand messages$LogsCommand, long l10) {
        messages$LogsCommand.tt_ = l10;
        return l10;
    }

    public static /* synthetic */ Object access$31300(Messages$LogsCommand messages$LogsCommand) {
        return messages$LogsCommand.tmid_;
    }

    public static /* synthetic */ Object access$31302(Messages$LogsCommand messages$LogsCommand, Object object) {
        messages$LogsCommand.tmid_ = object;
        return object;
    }

    public static /* synthetic */ Object access$31400(Messages$LogsCommand messages$LogsCommand) {
        return messages$LogsCommand.mid_;
    }

    public static /* synthetic */ Object access$31402(Messages$LogsCommand messages$LogsCommand, Object object) {
        messages$LogsCommand.mid_ = object;
        return object;
    }

    public static /* synthetic */ Object access$31500(Messages$LogsCommand messages$LogsCommand) {
        return messages$LogsCommand.checksum_;
    }

    public static /* synthetic */ Object access$31502(Messages$LogsCommand messages$LogsCommand, Object object) {
        messages$LogsCommand.checksum_ = object;
        return object;
    }

    public static /* synthetic */ boolean access$31602(Messages$LogsCommand messages$LogsCommand, boolean bl2) {
        messages$LogsCommand.stored_ = bl2;
        return bl2;
    }

    public static /* synthetic */ int access$31702(Messages$LogsCommand messages$LogsCommand, int n10) {
        messages$LogsCommand.direction_ = n10;
        return n10;
    }

    public static /* synthetic */ boolean access$31802(Messages$LogsCommand messages$LogsCommand, boolean bl2) {
        messages$LogsCommand.tIncluded_ = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean access$31902(Messages$LogsCommand messages$LogsCommand, boolean bl2) {
        messages$LogsCommand.ttIncluded_ = bl2;
        return bl2;
    }

    public static /* synthetic */ int access$32002(Messages$LogsCommand messages$LogsCommand, int n10) {
        messages$LogsCommand.lctype_ = n10;
        return n10;
    }

    public static /* synthetic */ List access$32100(Messages$LogsCommand messages$LogsCommand) {
        return messages$LogsCommand.logs_;
    }

    public static /* synthetic */ List access$32102(Messages$LogsCommand messages$LogsCommand, List list) {
        messages$LogsCommand.logs_ = list;
        return list;
    }

    public static /* synthetic */ int access$32202(Messages$LogsCommand messages$LogsCommand, int n10) {
        messages$LogsCommand.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ boolean access$32300() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ UnknownFieldSet access$32400(Messages$LogsCommand messages$LogsCommand) {
        return messages$LogsCommand.unknownFields;
    }

    public static Messages$LogsCommand getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$30200();
    }

    public static Messages$LogsCommand$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$LogsCommand$Builder newBuilder(Messages$LogsCommand messages$LogsCommand) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$LogsCommand);
    }

    public static Messages$LogsCommand parseDelimitedFrom(InputStream inputStream) {
        return (Messages$LogsCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$LogsCommand parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$LogsCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$LogsCommand parseFrom(ByteString byteString) {
        return (Messages$LogsCommand)PARSER.parseFrom(byteString);
    }

    public static Messages$LogsCommand parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$LogsCommand)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$LogsCommand parseFrom(CodedInputStream codedInputStream) {
        return (Messages$LogsCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$LogsCommand parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$LogsCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$LogsCommand parseFrom(InputStream inputStream) {
        return (Messages$LogsCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$LogsCommand parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$LogsCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$LogsCommand parseFrom(ByteBuffer byteBuffer) {
        return (Messages$LogsCommand)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$LogsCommand parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$LogsCommand)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$LogsCommand parseFrom(byte[] byArray) {
        return (Messages$LogsCommand)PARSER.parseFrom(byArray);
    }

    public static Messages$LogsCommand parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$LogsCommand)PARSER.parseFrom(byArray, extensionRegistryLite);
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
            return n11;
        }
        int n12 = object instanceof Messages$LogsCommand;
        if (!n12) {
            return super.equals(object);
        }
        object = (Messages$LogsCommand)object;
        n12 = this.hasCid();
        if (n12 == (n10 = ((Messages$LogsCommand)object).hasCid())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasCid();
        if (n10 != 0) {
            if (n12 && (n12 = ((String)(object3 = this.getCid())).equals(object2 = ((Messages$LogsCommand)object).getCid()))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = this.hasL()) == (n10 = ((Messages$LogsCommand)object).hasL())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasL();
        if (n10 != 0) {
            if (n12 && (n12 = this.getL()) == (n10 = ((Messages$LogsCommand)object).getL())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasLimit() ? 1 : 0)) == (n10 = (int)(((Messages$LogsCommand)object).hasLimit() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasLimit() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = this.getLimit()) == (n10 = ((Messages$LogsCommand)object).getLimit())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasT() ? 1 : 0)) == (n10 = (int)(((Messages$LogsCommand)object).hasT() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasT() ? 1 : 0);
        if (n10 != 0) {
            long l12;
            if (n12 && !(n12 = (int)((l12 = (l11 = this.getT()) - (l10 = ((Messages$LogsCommand)object).getT())) == 0L ? 0 : (l12 < 0L ? -1 : 1)))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasTt() ? 1 : 0)) == (n10 = (int)(((Messages$LogsCommand)object).hasTt() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasTt() ? 1 : 0);
        if (n10 != 0) {
            long l13;
            if (n12 && !(n12 = (int)((l13 = (l11 = this.getTt()) - (l10 = ((Messages$LogsCommand)object).getTt())) == 0L ? 0 : (l13 < 0L ? -1 : 1)))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasTmid() ? 1 : 0)) == (n10 = (int)(((Messages$LogsCommand)object).hasTmid() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasTmid() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((String)(object3 = this.getTmid())).equals(object2 = ((Messages$LogsCommand)object).getTmid()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasMid() ? 1 : 0)) == (n10 = (int)(((Messages$LogsCommand)object).hasMid() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasMid() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((String)(object3 = this.getMid())).equals(object2 = ((Messages$LogsCommand)object).getMid()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasChecksum() ? 1 : 0)) == (n10 = (int)(((Messages$LogsCommand)object).hasChecksum() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasChecksum() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((String)(object3 = this.getChecksum())).equals(object2 = ((Messages$LogsCommand)object).getChecksum()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasStored() ? 1 : 0)) == (n10 = (int)(((Messages$LogsCommand)object).hasStored() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasStored() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(this.getStored() ? 1 : 0)) == (n10 = (int)(((Messages$LogsCommand)object).getStored() ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasDirection() ? 1 : 0)) == (n10 = (int)(((Messages$LogsCommand)object).hasDirection() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasDirection() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = this.direction_) == (n10 = ((Messages$LogsCommand)object).direction_)) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasTIncluded() ? 1 : 0)) == (n10 = (int)(((Messages$LogsCommand)object).hasTIncluded() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasTIncluded() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(this.getTIncluded() ? 1 : 0)) == (n10 = (int)(((Messages$LogsCommand)object).getTIncluded() ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasTtIncluded() ? 1 : 0)) == (n10 = (int)(((Messages$LogsCommand)object).hasTtIncluded() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasTtIncluded() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(this.getTtIncluded() ? 1 : 0)) == (n10 = (int)(((Messages$LogsCommand)object).getTtIncluded() ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasLctype() ? 1 : 0)) == (n10 = (int)(((Messages$LogsCommand)object).hasLctype() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasLctype() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = this.getLctype()) == (n10 = ((Messages$LogsCommand)object).getLctype())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)((object3 = this.getLogsList()).equals(object2 = ((Messages$LogsCommand)object).getLogsList()) ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        if (!n12 || !(bl2 = ((UnknownFieldSet)(object3 = this.unknownFields)).equals(object = ((GeneratedMessageV3)object).unknownFields))) {
            n11 = 0;
        }
        return n11;
    }

    public String getChecksum() {
        Object object = this.checksum_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.checksum_ = string2;
        }
        return string2;
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

    public Messages$LogsCommand getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
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
        return (Messages$LogItem)this.logs_.get(n10);
    }

    public int getLogsCount() {
        return this.logs_.size();
    }

    public List getLogsList() {
        return this.logs_;
    }

    public Messages$LogItemOrBuilder getLogsOrBuilder(int n10) {
        return (Messages$LogItemOrBuilder)this.logs_.get(n10);
    }

    public List getLogsOrBuilderList() {
        return this.logs_;
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

    public int getSerializedSize() {
        Object object;
        Object object2;
        long l10;
        int n10;
        Object object3;
        int n11 = this.memoizedSize;
        int n12 = -1;
        if (n11 != n12) {
            return n11;
        }
        n11 = this.bitField0_;
        n12 = 1;
        int n13 = 0;
        if ((n11 &= n12) == n12) {
            object3 = this.cid_;
            n11 = GeneratedMessageV3.computeStringSize(n12, object3) + 0;
        } else {
            n11 = 0;
            object3 = null;
        }
        n12 = this.bitField0_;
        int n14 = 2;
        if ((n12 &= n14) == n14) {
            n12 = this.l_;
            n12 = CodedOutputStream.computeInt32Size(n14, n12);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n14 = 4;
        if ((n12 &= n14) == n14) {
            n10 = this.limit_;
            n12 = CodedOutputStream.computeInt32Size(3, n10);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n10 = 8;
        if ((n12 &= n10) == n10) {
            l10 = this.t_;
            n12 = CodedOutputStream.computeInt64Size(n14, l10);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n14 = 16;
        if ((n12 &= n14) == n14) {
            l10 = this.tt_;
            n12 = CodedOutputStream.computeInt64Size(5, l10);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n14 = 32;
        if ((n12 &= n14) == n14) {
            object2 = this.tmid_;
            n12 = GeneratedMessageV3.computeStringSize(6, object2);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n14 = 64;
        if ((n12 &= n14) == n14) {
            object2 = this.mid_;
            n12 = GeneratedMessageV3.computeStringSize(7, object2);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n14 = 128;
        if ((n12 &= n14) == n14) {
            object = this.checksum_;
            n12 = GeneratedMessageV3.computeStringSize(n10, object);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n14 = 256;
        if ((n12 &= n14) == n14) {
            n14 = (int)(this.stored_ ? 1 : 0);
            n12 = CodedOutputStream.computeBoolSize(9, n14 != 0);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n14 = 512;
        if ((n12 &= n14) == n14) {
            n14 = this.direction_;
            n12 = CodedOutputStream.computeEnumSize(10, n14);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n14 = 1024;
        if ((n12 &= n14) == n14) {
            n14 = (int)(this.tIncluded_ ? 1 : 0);
            n12 = CodedOutputStream.computeBoolSize(11, n14 != 0);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n14 = 2048;
        if ((n12 &= n14) == n14) {
            n14 = (int)(this.ttIncluded_ ? 1 : 0);
            n12 = CodedOutputStream.computeBoolSize(12, n14 != 0);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n14 = 4096;
        if ((n12 &= n14) == n14) {
            n14 = this.lctype_;
            n12 = CodedOutputStream.computeInt32Size(13, n14);
            n11 += n12;
        }
        while (n13 < (n12 = (object = this.logs_).size())) {
            object2 = (MessageLite)this.logs_.get(n13);
            n12 = CodedOutputStream.computeMessageSize(105, (MessageLite)object2);
            n11 += n12;
            ++n13;
        }
        n12 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n11 += n12;
        return n11;
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
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.tmid_ = string2;
        }
        return string2;
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

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
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

    public int hashCode() {
        long l10;
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = Messages$LogsCommand.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasCid() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getCid();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasL() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            n11 = this.getL();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasLimit() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            n11 = this.getLimit();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasT() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 4) * 53;
            l10 = this.getT();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasTt() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 5) * 53;
            l10 = this.getTt();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasTmid() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 6) * 53;
            object = this.getTmid();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasMid() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 7) * 53;
            object = this.getMid();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasChecksum() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 8) * 53;
            object = this.getChecksum();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasStored() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 9) * 53;
            n11 = Internal.hashBoolean(this.getStored());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasDirection() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 10) * 53;
            n11 = this.direction_;
            n10 += n11;
        }
        if ((n11 = (int)(this.hasTIncluded() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 11) * 53;
            n11 = Internal.hashBoolean(this.getTIncluded());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasTtIncluded() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 12) * 53;
            n11 = Internal.hashBoolean(this.getTtIncluded());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasLctype() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 13) * 53;
            n11 = this.getLctype();
            n10 += n11;
        }
        if ((n11 = this.getLogsCount()) > 0) {
            n10 = (n10 * 37 + 105) * 53;
            object = this.getLogsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$30300().ensureFieldAccessorsInitialized(Messages$LogsCommand.class, Messages$LogsCommand$Builder.class);
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

    public Messages$LogsCommand$Builder newBuilderForType() {
        return Messages$LogsCommand.newBuilder();
    }

    public Messages$LogsCommand$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$LogsCommand$Builder messages$LogsCommand$Builder = new Messages$LogsCommand$Builder(generatedMessageV3$BuilderParent, null);
        return messages$LogsCommand$Builder;
    }

    public Messages$LogsCommand$Builder toBuilder() {
        Messages$LogsCommandOrBuilder messages$LogsCommandOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$LogsCommandOrBuilder) {
            messages$LogsCommandOrBuilder = new Messages$LogsCommand$Builder(null);
        } else {
            messages$LogsCommandOrBuilder = new Messages$LogsCommand$Builder(null);
            messages$LogsCommandOrBuilder = ((Messages$LogsCommand$Builder)messages$LogsCommandOrBuilder).mergeFrom(this);
        }
        return messages$LogsCommandOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Object object;
        long l10;
        int n10;
        Object object2;
        int n11 = this.bitField0_;
        int n12 = 1;
        if ((n11 &= n12) == n12) {
            object2 = this.cid_;
            GeneratedMessageV3.writeString(codedOutputStream, n12, object2);
        }
        n11 = this.bitField0_;
        n12 = 2;
        if ((n11 &= n12) == n12) {
            n11 = this.l_;
            codedOutputStream.writeInt32(n12, n11);
        }
        n11 = this.bitField0_;
        n12 = 4;
        if ((n11 &= n12) == n12) {
            n11 = 3;
            n10 = this.limit_;
            codedOutputStream.writeInt32(n11, n10);
        }
        n11 = this.bitField0_;
        n10 = 8;
        if ((n11 &= n10) == n10) {
            l10 = this.t_;
            codedOutputStream.writeInt64(n12, l10);
        }
        n11 = this.bitField0_;
        n12 = 16;
        if ((n11 &= n12) == n12) {
            n11 = 5;
            l10 = this.tt_;
            codedOutputStream.writeInt64(n11, l10);
        }
        n11 = this.bitField0_;
        n12 = 32;
        if ((n11 &= n12) == n12) {
            n11 = 6;
            object = this.tmid_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        n11 = this.bitField0_;
        n12 = 64;
        if ((n11 &= n12) == n12) {
            n11 = 7;
            object = this.mid_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object);
        }
        n11 = this.bitField0_;
        n12 = 128;
        if ((n11 &= n12) == n12) {
            object2 = this.checksum_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object2);
        }
        n11 = this.bitField0_;
        n12 = 256;
        if ((n11 &= n12) == n12) {
            n11 = 9;
            n12 = (int)(this.stored_ ? 1 : 0);
            codedOutputStream.writeBool(n11, n12 != 0);
        }
        n11 = this.bitField0_;
        n12 = 512;
        if ((n11 &= n12) == n12) {
            n11 = 10;
            n12 = this.direction_;
            codedOutputStream.writeEnum(n11, n12);
        }
        n11 = this.bitField0_;
        n12 = 1024;
        if ((n11 &= n12) == n12) {
            n11 = 11;
            n12 = (int)(this.tIncluded_ ? 1 : 0);
            codedOutputStream.writeBool(n11, n12 != 0);
        }
        n11 = this.bitField0_;
        n12 = 2048;
        if ((n11 &= n12) == n12) {
            n11 = 12;
            n12 = (int)(this.ttIncluded_ ? 1 : 0);
            codedOutputStream.writeBool(n11, n12 != 0);
        }
        n11 = this.bitField0_;
        n12 = 4096;
        if ((n11 &= n12) == n12) {
            n11 = 13;
            n12 = this.lctype_;
            codedOutputStream.writeInt32(n11, n12);
        }
        object2 = null;
        for (n11 = 0; n11 < (n12 = (object = this.logs_).size()); ++n11) {
            n12 = 105;
            MessageLite messageLite = (MessageLite)this.logs_.get(n11);
            codedOutputStream.writeMessage(n12, messageLite);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

