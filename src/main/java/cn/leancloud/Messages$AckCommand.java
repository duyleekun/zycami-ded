/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$AckCommand$1;
import cn.leancloud.Messages$AckCommand$Builder;
import cn.leancloud.Messages$AckCommandOrBuilder;
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

public final class Messages$AckCommand
extends GeneratedMessageV3
implements Messages$AckCommandOrBuilder {
    public static final int APPCODE_FIELD_NUMBER = 11;
    public static final int APPMSG_FIELD_NUMBER = 12;
    public static final int CID_FIELD_NUMBER = 4;
    public static final int CODE_FIELD_NUMBER = 1;
    private static final Messages$AckCommand DEFAULT_INSTANCE;
    public static final int FROMTS_FIELD_NUMBER = 7;
    public static final int IDS_FIELD_NUMBER = 10;
    public static final int MID_FIELD_NUMBER = 3;
    public static final Parser PARSER;
    public static final int REASON_FIELD_NUMBER = 2;
    public static final int TOTS_FIELD_NUMBER = 8;
    public static final int TYPE_FIELD_NUMBER = 9;
    public static final int T_FIELD_NUMBER = 5;
    public static final int UID_FIELD_NUMBER = 6;
    private static final long serialVersionUID;
    private int appCode_;
    private volatile Object appMsg_;
    private int bitField0_;
    private volatile Object cid_;
    private int code_;
    private long fromts_;
    private LazyStringList ids_;
    private byte memoizedIsInitialized;
    private volatile Object mid_;
    private volatile Object reason_;
    private long t_;
    private long tots_;
    private volatile Object type_;
    private volatile Object uid_;

    static {
        Object object = new Messages$AckCommand();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$AckCommand$1();
    }

    private Messages$AckCommand() {
        LazyStringList lazyStringList;
        long l10;
        this.memoizedIsInitialized = (byte)-1;
        this.code_ = 0;
        String string2 = "";
        this.reason_ = string2;
        this.mid_ = string2;
        this.cid_ = string2;
        this.t_ = l10 = 0L;
        this.uid_ = string2;
        this.fromts_ = l10;
        this.tots_ = l10;
        this.type_ = string2;
        this.ids_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.appCode_ = 0;
        this.appMsg_ = string2;
    }

    /*
     * Exception decompiling
     */
    private Messages$AckCommand(CodedInputStream var1_1, ExtensionRegistryLite var2_7) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 36[TRYBLOCK] [156 : 576->579)] java.lang.Throwable
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

    public /* synthetic */ Messages$AckCommand(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$AckCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ Messages$AckCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$20900() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ int access$21102(Messages$AckCommand messages$AckCommand, int n10) {
        messages$AckCommand.code_ = n10;
        return n10;
    }

    public static /* synthetic */ Object access$21200(Messages$AckCommand messages$AckCommand) {
        return messages$AckCommand.reason_;
    }

    public static /* synthetic */ Object access$21202(Messages$AckCommand messages$AckCommand, Object object) {
        messages$AckCommand.reason_ = object;
        return object;
    }

    public static /* synthetic */ Object access$21300(Messages$AckCommand messages$AckCommand) {
        return messages$AckCommand.mid_;
    }

    public static /* synthetic */ Object access$21302(Messages$AckCommand messages$AckCommand, Object object) {
        messages$AckCommand.mid_ = object;
        return object;
    }

    public static /* synthetic */ Object access$21400(Messages$AckCommand messages$AckCommand) {
        return messages$AckCommand.cid_;
    }

    public static /* synthetic */ Object access$21402(Messages$AckCommand messages$AckCommand, Object object) {
        messages$AckCommand.cid_ = object;
        return object;
    }

    public static /* synthetic */ long access$21502(Messages$AckCommand messages$AckCommand, long l10) {
        messages$AckCommand.t_ = l10;
        return l10;
    }

    public static /* synthetic */ Object access$21600(Messages$AckCommand messages$AckCommand) {
        return messages$AckCommand.uid_;
    }

    public static /* synthetic */ Object access$21602(Messages$AckCommand messages$AckCommand, Object object) {
        messages$AckCommand.uid_ = object;
        return object;
    }

    public static /* synthetic */ long access$21702(Messages$AckCommand messages$AckCommand, long l10) {
        messages$AckCommand.fromts_ = l10;
        return l10;
    }

    public static /* synthetic */ long access$21802(Messages$AckCommand messages$AckCommand, long l10) {
        messages$AckCommand.tots_ = l10;
        return l10;
    }

    public static /* synthetic */ Object access$21900(Messages$AckCommand messages$AckCommand) {
        return messages$AckCommand.type_;
    }

    public static /* synthetic */ Object access$21902(Messages$AckCommand messages$AckCommand, Object object) {
        messages$AckCommand.type_ = object;
        return object;
    }

    public static /* synthetic */ LazyStringList access$22000(Messages$AckCommand messages$AckCommand) {
        return messages$AckCommand.ids_;
    }

    public static /* synthetic */ LazyStringList access$22002(Messages$AckCommand messages$AckCommand, LazyStringList lazyStringList) {
        messages$AckCommand.ids_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ int access$22102(Messages$AckCommand messages$AckCommand, int n10) {
        messages$AckCommand.appCode_ = n10;
        return n10;
    }

    public static /* synthetic */ Object access$22200(Messages$AckCommand messages$AckCommand) {
        return messages$AckCommand.appMsg_;
    }

    public static /* synthetic */ Object access$22202(Messages$AckCommand messages$AckCommand, Object object) {
        messages$AckCommand.appMsg_ = object;
        return object;
    }

    public static /* synthetic */ int access$22302(Messages$AckCommand messages$AckCommand, int n10) {
        messages$AckCommand.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ UnknownFieldSet access$22400(Messages$AckCommand messages$AckCommand) {
        return messages$AckCommand.unknownFields;
    }

    public static Messages$AckCommand getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$20500();
    }

    public static Messages$AckCommand$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$AckCommand$Builder newBuilder(Messages$AckCommand messages$AckCommand) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$AckCommand);
    }

    public static Messages$AckCommand parseDelimitedFrom(InputStream inputStream) {
        return (Messages$AckCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$AckCommand parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$AckCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$AckCommand parseFrom(ByteString byteString) {
        return (Messages$AckCommand)PARSER.parseFrom(byteString);
    }

    public static Messages$AckCommand parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$AckCommand)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$AckCommand parseFrom(CodedInputStream codedInputStream) {
        return (Messages$AckCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$AckCommand parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$AckCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$AckCommand parseFrom(InputStream inputStream) {
        return (Messages$AckCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$AckCommand parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$AckCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$AckCommand parseFrom(ByteBuffer byteBuffer) {
        return (Messages$AckCommand)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$AckCommand parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$AckCommand)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$AckCommand parseFrom(byte[] byArray) {
        return (Messages$AckCommand)PARSER.parseFrom(byArray);
    }

    public static Messages$AckCommand parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$AckCommand)PARSER.parseFrom(byArray, extensionRegistryLite);
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
        int n12 = object instanceof Messages$AckCommand;
        if (!n12) {
            return super.equals(object);
        }
        object = (Messages$AckCommand)object;
        n12 = this.hasCode();
        if (n12 == (n10 = ((Messages$AckCommand)object).hasCode())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasCode();
        if (n10 != 0) {
            if (n12 && (n12 = this.getCode()) == (n10 = ((Messages$AckCommand)object).getCode())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasReason() ? 1 : 0)) == (n10 = (int)(((Messages$AckCommand)object).hasReason() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasReason() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((String)(object3 = this.getReason())).equals(object2 = ((Messages$AckCommand)object).getReason()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasMid() ? 1 : 0)) == (n10 = (int)(((Messages$AckCommand)object).hasMid() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasMid() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((String)(object3 = this.getMid())).equals(object2 = ((Messages$AckCommand)object).getMid()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasCid() ? 1 : 0)) == (n10 = (int)(((Messages$AckCommand)object).hasCid() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasCid() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((String)(object3 = this.getCid())).equals(object2 = ((Messages$AckCommand)object).getCid()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasT() ? 1 : 0)) == (n10 = (int)(((Messages$AckCommand)object).hasT() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasT() ? 1 : 0);
        if (n10 != 0) {
            long l12;
            if (n12 && !(n12 = (int)((l12 = (l11 = this.getT()) - (l10 = ((Messages$AckCommand)object).getT())) == 0L ? 0 : (l12 < 0L ? -1 : 1)))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasUid() ? 1 : 0)) == (n10 = (int)(((Messages$AckCommand)object).hasUid() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasUid() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((String)(object3 = this.getUid())).equals(object2 = ((Messages$AckCommand)object).getUid()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasFromts() ? 1 : 0)) == (n10 = (int)(((Messages$AckCommand)object).hasFromts() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasFromts() ? 1 : 0);
        if (n10 != 0) {
            long l13;
            if (n12 && !(n12 = (int)((l13 = (l11 = this.getFromts()) - (l10 = ((Messages$AckCommand)object).getFromts())) == 0L ? 0 : (l13 < 0L ? -1 : 1)))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasTots() ? 1 : 0)) == (n10 = (int)(((Messages$AckCommand)object).hasTots() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasTots() ? 1 : 0);
        if (n10 != 0) {
            long l14;
            if (n12 && !(n12 = (int)((l14 = (l11 = this.getTots()) - (l10 = ((Messages$AckCommand)object).getTots())) == 0L ? 0 : (l14 < 0L ? -1 : 1)))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasType() ? 1 : 0)) == (n10 = (int)(((Messages$AckCommand)object).hasType() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasType() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((String)(object3 = this.getType())).equals(object2 = ((Messages$AckCommand)object).getType()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)((object3 = this.getIdsList()).equals(object2 = ((Messages$AckCommand)object).getIdsList()) ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        if (n12 && (n12 = (int)(this.hasAppCode() ? 1 : 0)) == (n10 = (int)(((Messages$AckCommand)object).hasAppCode() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasAppCode() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = this.getAppCode()) == (n10 = ((Messages$AckCommand)object).getAppCode())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasAppMsg() ? 1 : 0)) == (n10 = (int)(((Messages$AckCommand)object).hasAppMsg() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasAppMsg() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = ((String)(object3 = this.getAppMsg())).equals(object2 = ((Messages$AckCommand)object).getAppMsg()))) {
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

    public int getAppCode() {
        return this.appCode_;
    }

    public String getAppMsg() {
        Object object = this.appMsg_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.appMsg_ = string2;
        }
        return string2;
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

    public int getCode() {
        return this.code_;
    }

    public Messages$AckCommand getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
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
        return this.ids_;
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

    public String getReason() {
        Object object = this.reason_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.reason_ = string2;
        }
        return string2;
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

    public int getSerializedSize() {
        Object object;
        long l10;
        Object object2;
        int n10 = this.memoizedSize;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n10 = this.bitField0_;
        n11 = 1;
        int n12 = 0;
        Object object3 = null;
        if ((n10 &= n11) == n11) {
            n10 = this.code_;
            n10 = CodedOutputStream.computeInt32Size(n11, n10) + 0;
        } else {
            n10 = 0;
        }
        int n13 = this.bitField0_;
        int n14 = 2;
        if ((n13 &= n14) == n14) {
            object2 = this.reason_;
            n13 = GeneratedMessageV3.computeStringSize(n14, object2);
            n10 += n13;
        }
        n13 = this.bitField0_;
        n14 = 4;
        if ((n13 &= n14) == n14) {
            Object object4 = this.mid_;
            n13 = GeneratedMessageV3.computeStringSize(3, object4);
            n10 += n13;
        }
        n13 = this.bitField0_;
        int n15 = 8;
        if ((n13 &= n15) == n15) {
            object2 = this.cid_;
            n13 = GeneratedMessageV3.computeStringSize(n14, object2);
            n10 += n13;
        }
        n13 = this.bitField0_;
        n14 = 16;
        if ((n13 &= n14) == n14) {
            l10 = this.t_;
            n13 = CodedOutputStream.computeInt64Size(5, l10);
            n10 += n13;
        }
        n13 = this.bitField0_;
        n14 = 32;
        if ((n13 &= n14) == n14) {
            object = this.uid_;
            n13 = GeneratedMessageV3.computeStringSize(6, object);
            n10 += n13;
        }
        n13 = this.bitField0_;
        n14 = 64;
        if ((n13 &= n14) == n14) {
            l10 = this.fromts_;
            n13 = CodedOutputStream.computeInt64Size(7, l10);
            n10 += n13;
        }
        n13 = this.bitField0_;
        n14 = 128;
        if ((n13 &= n14) == n14) {
            long l11 = this.tots_;
            n13 = CodedOutputStream.computeInt64Size(n15, l11);
            n10 += n13;
        }
        n13 = this.bitField0_;
        n14 = 256;
        if ((n13 &= n14) == n14) {
            object = this.type_;
            n13 = GeneratedMessageV3.computeStringSize(9, object);
            n10 += n13;
        }
        n13 = 0;
        object2 = null;
        while (n12 < (n14 = (object = this.ids_).size())) {
            object = this.ids_.getRaw(n12);
            n14 = GeneratedMessageV3.computeStringSizeNoTag(object);
            n13 += n14;
            ++n12;
        }
        n10 += n13;
        object3 = this.getIdsList();
        n12 = object3.size() * n11;
        n10 += n12;
        n11 = this.bitField0_;
        n12 = 512;
        if ((n11 &= n12) == n12) {
            n12 = this.appCode_;
            n11 = CodedOutputStream.computeInt32Size(11, n12);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 1024;
        if ((n11 &= n12) == n12) {
            object3 = this.appMsg_;
            n11 = GeneratedMessageV3.computeStringSize(12, object3);
            n10 += n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
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
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.type_ = string2;
        }
        return string2;
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
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.uid_ = string2;
        }
        return string2;
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

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasAppCode() {
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
    public boolean hasAppMsg() {
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

    public int hashCode() {
        long l10;
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = Messages$AckCommand.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasCode() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            n11 = this.getCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasReason() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getReason();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasMid() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            object = this.getMid();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasCid() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 4) * 53;
            object = this.getCid();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasT() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 5) * 53;
            l10 = this.getT();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasUid() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 6) * 53;
            object = this.getUid();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasFromts() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 7) * 53;
            l10 = this.getFromts();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasTots() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 8) * 53;
            l10 = this.getTots();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasType() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 9) * 53;
            object = this.getType();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = this.getIdsCount()) > 0) {
            n10 = (n10 * 37 + 10) * 53;
            object = this.getIdsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasAppCode() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 11) * 53;
            n11 = this.getAppCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasAppMsg() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 12) * 53;
            object = this.getAppMsg();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$20600().ensureFieldAccessorsInitialized(Messages$AckCommand.class, Messages$AckCommand$Builder.class);
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

    public Messages$AckCommand$Builder newBuilderForType() {
        return Messages$AckCommand.newBuilder();
    }

    public Messages$AckCommand$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$AckCommand$Builder messages$AckCommand$Builder = new Messages$AckCommand$Builder(generatedMessageV3$BuilderParent, null);
        return messages$AckCommand$Builder;
    }

    public Messages$AckCommand$Builder toBuilder() {
        Messages$AckCommandOrBuilder messages$AckCommandOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$AckCommandOrBuilder) {
            messages$AckCommandOrBuilder = new Messages$AckCommand$Builder(null);
        } else {
            messages$AckCommandOrBuilder = new Messages$AckCommand$Builder(null);
            messages$AckCommandOrBuilder = ((Messages$AckCommand$Builder)messages$AckCommandOrBuilder).mergeFrom(this);
        }
        return messages$AckCommandOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Object object;
        long l10;
        Object object2;
        Object object3;
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == n11) {
            n10 = this.code_;
            codedOutputStream.writeInt32(n11, n10);
        }
        n10 = this.bitField0_;
        n11 = 2;
        if ((n10 &= n11) == n11) {
            object3 = this.reason_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object3);
        }
        n10 = this.bitField0_;
        n11 = 4;
        if ((n10 &= n11) == n11) {
            n10 = 3;
            object2 = this.mid_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object2);
        }
        n10 = this.bitField0_;
        int n12 = 8;
        if ((n10 &= n12) == n12) {
            object3 = this.cid_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object3);
        }
        n10 = this.bitField0_;
        n11 = 16;
        if ((n10 &= n11) == n11) {
            n10 = 5;
            l10 = this.t_;
            codedOutputStream.writeInt64(n10, l10);
        }
        n10 = this.bitField0_;
        n11 = 32;
        if ((n10 &= n11) == n11) {
            n10 = 6;
            object = this.uid_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object);
        }
        n10 = this.bitField0_;
        n11 = 64;
        if ((n10 &= n11) == n11) {
            n10 = 7;
            l10 = this.fromts_;
            codedOutputStream.writeInt64(n10, l10);
        }
        n10 = this.bitField0_;
        n11 = 128;
        if ((n10 &= n11) == n11) {
            long l11 = this.tots_;
            codedOutputStream.writeInt64(n12, l11);
        }
        n10 = this.bitField0_;
        n11 = 256;
        if ((n10 &= n11) == n11) {
            n10 = 9;
            object = this.type_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object);
        }
        object3 = null;
        for (n10 = 0; n10 < (n11 = (object = this.ids_).size()); ++n10) {
            n11 = 10;
            object2 = this.ids_.getRaw(n10);
            GeneratedMessageV3.writeString(codedOutputStream, n11, object2);
        }
        n10 = this.bitField0_;
        n11 = 512;
        if ((n10 &= n11) == n11) {
            n10 = 11;
            n11 = this.appCode_;
            codedOutputStream.writeInt32(n10, n11);
        }
        n10 = this.bitField0_;
        n11 = 1024;
        if ((n10 &= n11) == n11) {
            n10 = 12;
            object = this.appMsg_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

