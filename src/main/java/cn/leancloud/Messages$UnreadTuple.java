/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$UnreadTuple$1;
import cn.leancloud.Messages$UnreadTuple$Builder;
import cn.leancloud.Messages$UnreadTupleOrBuilder;
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
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Messages$UnreadTuple
extends GeneratedMessageV3
implements Messages$UnreadTupleOrBuilder {
    public static final int BINARYMSG_FIELD_NUMBER = 9;
    public static final int CID_FIELD_NUMBER = 1;
    public static final int CONVTYPE_FIELD_NUMBER = 10;
    public static final int DATA_FIELD_NUMBER = 6;
    private static final Messages$UnreadTuple DEFAULT_INSTANCE;
    public static final int FROM_FIELD_NUMBER = 5;
    public static final int MENTIONED_FIELD_NUMBER = 8;
    public static final int MID_FIELD_NUMBER = 3;
    public static final Parser PARSER;
    public static final int PATCHTIMESTAMP_FIELD_NUMBER = 7;
    public static final int TIMESTAMP_FIELD_NUMBER = 4;
    public static final int UNREAD_FIELD_NUMBER = 2;
    private static final long serialVersionUID;
    private ByteString binaryMsg_;
    private int bitField0_;
    private volatile Object cid_;
    private int convType_;
    private volatile Object data_;
    private volatile Object from_;
    private byte memoizedIsInitialized;
    private boolean mentioned_;
    private volatile Object mid_;
    private long patchTimestamp_;
    private long timestamp_;
    private int unread_;

    static {
        Object object = new Messages$UnreadTuple();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$UnreadTuple$1();
    }

    private Messages$UnreadTuple() {
        long l10;
        Object object;
        this.memoizedIsInitialized = (byte)-1;
        this.cid_ = object = "";
        this.unread_ = 0;
        this.mid_ = object;
        this.timestamp_ = l10 = 0L;
        this.from_ = object;
        this.data_ = object;
        this.patchTimestamp_ = l10;
        this.mentioned_ = false;
        this.binaryMsg_ = object = ByteString.EMPTY;
        this.convType_ = 0;
    }

    /*
     * Exception decompiling
     */
    private Messages$UnreadTuple(CodedInputStream var1_1, ExtensionRegistryLite var2_7) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 27[TRYBLOCK] [126 : 463->466)] java.lang.Throwable
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

    public /* synthetic */ Messages$UnreadTuple(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$UnreadTuple(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ Messages$UnreadTuple(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$5200() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ Object access$5400(Messages$UnreadTuple messages$UnreadTuple) {
        return messages$UnreadTuple.cid_;
    }

    public static /* synthetic */ Object access$5402(Messages$UnreadTuple messages$UnreadTuple, Object object) {
        messages$UnreadTuple.cid_ = object;
        return object;
    }

    public static /* synthetic */ int access$5502(Messages$UnreadTuple messages$UnreadTuple, int n10) {
        messages$UnreadTuple.unread_ = n10;
        return n10;
    }

    public static /* synthetic */ Object access$5600(Messages$UnreadTuple messages$UnreadTuple) {
        return messages$UnreadTuple.mid_;
    }

    public static /* synthetic */ Object access$5602(Messages$UnreadTuple messages$UnreadTuple, Object object) {
        messages$UnreadTuple.mid_ = object;
        return object;
    }

    public static /* synthetic */ long access$5702(Messages$UnreadTuple messages$UnreadTuple, long l10) {
        messages$UnreadTuple.timestamp_ = l10;
        return l10;
    }

    public static /* synthetic */ Object access$5800(Messages$UnreadTuple messages$UnreadTuple) {
        return messages$UnreadTuple.from_;
    }

    public static /* synthetic */ Object access$5802(Messages$UnreadTuple messages$UnreadTuple, Object object) {
        messages$UnreadTuple.from_ = object;
        return object;
    }

    public static /* synthetic */ Object access$5900(Messages$UnreadTuple messages$UnreadTuple) {
        return messages$UnreadTuple.data_;
    }

    public static /* synthetic */ Object access$5902(Messages$UnreadTuple messages$UnreadTuple, Object object) {
        messages$UnreadTuple.data_ = object;
        return object;
    }

    public static /* synthetic */ long access$6002(Messages$UnreadTuple messages$UnreadTuple, long l10) {
        messages$UnreadTuple.patchTimestamp_ = l10;
        return l10;
    }

    public static /* synthetic */ boolean access$6102(Messages$UnreadTuple messages$UnreadTuple, boolean bl2) {
        messages$UnreadTuple.mentioned_ = bl2;
        return bl2;
    }

    public static /* synthetic */ ByteString access$6202(Messages$UnreadTuple messages$UnreadTuple, ByteString byteString) {
        messages$UnreadTuple.binaryMsg_ = byteString;
        return byteString;
    }

    public static /* synthetic */ int access$6302(Messages$UnreadTuple messages$UnreadTuple, int n10) {
        messages$UnreadTuple.convType_ = n10;
        return n10;
    }

    public static /* synthetic */ int access$6402(Messages$UnreadTuple messages$UnreadTuple, int n10) {
        messages$UnreadTuple.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ UnknownFieldSet access$6500(Messages$UnreadTuple messages$UnreadTuple) {
        return messages$UnreadTuple.unknownFields;
    }

    public static Messages$UnreadTuple getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$4800();
    }

    public static Messages$UnreadTuple$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$UnreadTuple$Builder newBuilder(Messages$UnreadTuple messages$UnreadTuple) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$UnreadTuple);
    }

    public static Messages$UnreadTuple parseDelimitedFrom(InputStream inputStream) {
        return (Messages$UnreadTuple)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$UnreadTuple parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$UnreadTuple)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$UnreadTuple parseFrom(ByteString byteString) {
        return (Messages$UnreadTuple)PARSER.parseFrom(byteString);
    }

    public static Messages$UnreadTuple parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$UnreadTuple)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$UnreadTuple parseFrom(CodedInputStream codedInputStream) {
        return (Messages$UnreadTuple)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$UnreadTuple parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$UnreadTuple)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$UnreadTuple parseFrom(InputStream inputStream) {
        return (Messages$UnreadTuple)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$UnreadTuple parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$UnreadTuple)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$UnreadTuple parseFrom(ByteBuffer byteBuffer) {
        return (Messages$UnreadTuple)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$UnreadTuple parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$UnreadTuple)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$UnreadTuple parseFrom(byte[] byArray) {
        return (Messages$UnreadTuple)PARSER.parseFrom(byArray);
    }

    public static Messages$UnreadTuple parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$UnreadTuple)PARSER.parseFrom(byArray, extensionRegistryLite);
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
        int n12 = object instanceof Messages$UnreadTuple;
        if (n12 == 0) {
            return super.equals(object);
        }
        object = (Messages$UnreadTuple)object;
        n12 = this.hasCid();
        if (n12 == (n10 = ((Messages$UnreadTuple)object).hasCid())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasCid();
        if (n10 != 0) {
            if (n12 != 0 && (n12 = ((String)(object3 = this.getCid())).equals(object2 = ((Messages$UnreadTuple)object).getCid())) != 0) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = this.hasUnread()) == (n10 = ((Messages$UnreadTuple)object).hasUnread())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasUnread();
        if (n10 != 0) {
            if (n12 != 0 && (n12 = this.getUnread()) == (n10 = ((Messages$UnreadTuple)object).getUnread())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = (int)(this.hasMid() ? 1 : 0)) == (n10 = (int)(((Messages$UnreadTuple)object).hasMid() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasMid() ? 1 : 0);
        if (n10 != 0) {
            if (n12 != 0 && (n12 = (int)(((String)(object3 = this.getMid())).equals(object2 = ((Messages$UnreadTuple)object).getMid()) ? 1 : 0)) != 0) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = (int)(this.hasTimestamp() ? 1 : 0)) == (n10 = (int)(((Messages$UnreadTuple)object).hasTimestamp() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasTimestamp() ? 1 : 0);
        if (n10 != 0) {
            long l12;
            if (n12 != 0 && (n12 = (int)((l12 = (l11 = this.getTimestamp()) - (l10 = ((Messages$UnreadTuple)object).getTimestamp())) == 0L ? 0 : (l12 < 0L ? -1 : 1))) == 0) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = (int)(this.hasFrom() ? 1 : 0)) == (n10 = (int)(((Messages$UnreadTuple)object).hasFrom() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasFrom() ? 1 : 0);
        if (n10 != 0) {
            if (n12 != 0 && (n12 = (int)(((String)(object3 = this.getFrom())).equals(object2 = ((Messages$UnreadTuple)object).getFrom()) ? 1 : 0)) != 0) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = (int)(this.hasData() ? 1 : 0)) == (n10 = (int)(((Messages$UnreadTuple)object).hasData() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasData() ? 1 : 0);
        if (n10 != 0) {
            if (n12 != 0 && (n12 = (int)(((String)(object3 = this.getData())).equals(object2 = ((Messages$UnreadTuple)object).getData()) ? 1 : 0)) != 0) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = (int)(this.hasPatchTimestamp() ? 1 : 0)) == (n10 = (int)(((Messages$UnreadTuple)object).hasPatchTimestamp() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasPatchTimestamp() ? 1 : 0);
        if (n10 != 0) {
            long l13;
            if (n12 != 0 && (n12 = (int)((l13 = (l11 = this.getPatchTimestamp()) - (l10 = ((Messages$UnreadTuple)object).getPatchTimestamp())) == 0L ? 0 : (l13 < 0L ? -1 : 1))) == 0) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = (int)(this.hasMentioned() ? 1 : 0)) == (n10 = (int)(((Messages$UnreadTuple)object).hasMentioned() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasMentioned() ? 1 : 0);
        if (n10 != 0) {
            if (n12 != 0 && (n12 = (int)(this.getMentioned() ? 1 : 0)) == (n10 = (int)(((Messages$UnreadTuple)object).getMentioned() ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = (int)(this.hasBinaryMsg() ? 1 : 0)) == (n10 = (int)(((Messages$UnreadTuple)object).hasBinaryMsg() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasBinaryMsg() ? 1 : 0);
        if (n10 != 0) {
            if (n12 != 0 && (n12 = (int)(((ByteString)(object3 = this.getBinaryMsg())).equals(object2 = ((Messages$UnreadTuple)object).getBinaryMsg()) ? 1 : 0)) != 0) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = (int)(this.hasConvType() ? 1 : 0)) == (n10 = (int)(((Messages$UnreadTuple)object).hasConvType() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasConvType() ? 1 : 0);
        if (n10 != 0) {
            if (n12 != 0 && (n12 = this.getConvType()) == (n10 = ((Messages$UnreadTuple)object).getConvType())) {
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

    public Messages$UnreadTuple getDefaultInstanceForType() {
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

    public boolean getMentioned() {
        return this.mentioned_;
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

    public long getPatchTimestamp() {
        return this.patchTimestamp_;
    }

    public int getSerializedSize() {
        Object object;
        long l10;
        int n10 = this.memoizedSize;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n10 = 0;
        n11 = this.bitField0_;
        int n12 = 1;
        if ((n11 &= n12) == n12) {
            Object object2 = this.cid_;
            n11 = GeneratedMessageV3.computeStringSize(n12, object2);
            n10 = 0 + n11;
        }
        n11 = this.bitField0_;
        n12 = 2;
        if ((n11 &= n12) == n12) {
            n11 = this.unread_;
            n11 = CodedOutputStream.computeInt32Size(n12, n11);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 4;
        if ((n11 &= n12) == n12) {
            Object object3 = this.mid_;
            n11 = GeneratedMessageV3.computeStringSize(3, object3);
            n10 += n11;
        }
        n11 = this.bitField0_;
        int n13 = 8;
        if ((n11 &= n13) == n13) {
            l10 = this.timestamp_;
            n11 = CodedOutputStream.computeInt64Size(n12, l10);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 16;
        if ((n11 &= n12) == n12) {
            object = this.from_;
            n11 = GeneratedMessageV3.computeStringSize(5, object);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 32;
        if ((n11 &= n12) == n12) {
            object = this.data_;
            n11 = GeneratedMessageV3.computeStringSize(6, object);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 64;
        if ((n11 &= n12) == n12) {
            l10 = this.patchTimestamp_;
            n11 = CodedOutputStream.computeInt64Size(7, l10);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 128;
        if ((n11 &= n12) == n12) {
            n11 = (int)(this.mentioned_ ? 1 : 0);
            n11 = CodedOutputStream.computeBoolSize(n13, n11 != 0);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 256;
        if ((n11 &= n12) == n12) {
            object = this.binaryMsg_;
            n11 = CodedOutputStream.computeBytesSize(9, (ByteString)object);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 512;
        if ((n11 &= n12) == n12) {
            n12 = this.convType_;
            n11 = CodedOutputStream.computeInt32Size(10, n12);
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

    public int getUnread() {
        return this.unread_;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasBinaryMsg() {
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
    public boolean hasFrom() {
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
    public boolean hasMentioned() {
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
    public boolean hasTimestamp() {
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
    public boolean hasUnread() {
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

    public int hashCode() {
        long l10;
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = Messages$UnreadTuple.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasCid() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getCid();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasUnread() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            n11 = this.getUnread();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasMid() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            object = this.getMid();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasTimestamp() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 4) * 53;
            l10 = this.getTimestamp();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasFrom() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 5) * 53;
            object = this.getFrom();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasData() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 6) * 53;
            object = this.getData();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasPatchTimestamp() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 7) * 53;
            l10 = this.getPatchTimestamp();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasMentioned() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 8) * 53;
            n11 = Internal.hashBoolean(this.getMentioned());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasBinaryMsg() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 9) * 53;
            object = this.getBinaryMsg();
            n11 = ((ByteString)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasConvType() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 10) * 53;
            n11 = this.getConvType();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$4900().ensureFieldAccessorsInitialized(Messages$UnreadTuple.class, Messages$UnreadTuple$Builder.class);
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
        by2 = this.hasCid();
        if (!by2) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        by2 = this.hasUnread();
        if (!by2) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = by3;
        return by3 != 0;
    }

    public Messages$UnreadTuple$Builder newBuilderForType() {
        return Messages$UnreadTuple.newBuilder();
    }

    public Messages$UnreadTuple$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$UnreadTuple$Builder messages$UnreadTuple$Builder = new Messages$UnreadTuple$Builder(generatedMessageV3$BuilderParent, null);
        return messages$UnreadTuple$Builder;
    }

    public Messages$UnreadTuple$Builder toBuilder() {
        Messages$UnreadTupleOrBuilder messages$UnreadTupleOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$UnreadTupleOrBuilder) {
            messages$UnreadTupleOrBuilder = new Messages$UnreadTuple$Builder(null);
        } else {
            messages$UnreadTupleOrBuilder = new Messages$UnreadTuple$Builder(null);
            messages$UnreadTupleOrBuilder = ((Messages$UnreadTuple$Builder)messages$UnreadTupleOrBuilder).mergeFrom(this);
        }
        return messages$UnreadTupleOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Object object;
        long l10;
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == n11) {
            Object object2 = this.cid_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object2);
        }
        n10 = this.bitField0_;
        n11 = 2;
        if ((n10 &= n11) == n11) {
            n10 = this.unread_;
            codedOutputStream.writeInt32(n11, n10);
        }
        n10 = this.bitField0_;
        n11 = 4;
        if ((n10 &= n11) == n11) {
            n10 = 3;
            Object object3 = this.mid_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object3);
        }
        n10 = this.bitField0_;
        int n12 = 8;
        if ((n10 &= n12) == n12) {
            l10 = this.timestamp_;
            codedOutputStream.writeInt64(n11, l10);
        }
        n10 = this.bitField0_;
        n11 = 16;
        if ((n10 &= n11) == n11) {
            n10 = 5;
            object = this.from_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object);
        }
        n10 = this.bitField0_;
        n11 = 32;
        if ((n10 &= n11) == n11) {
            n10 = 6;
            object = this.data_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object);
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
            n10 = (int)(this.mentioned_ ? 1 : 0);
            codedOutputStream.writeBool(n12, n10 != 0);
        }
        n10 = this.bitField0_;
        n11 = 256;
        if ((n10 &= n11) == n11) {
            n10 = 9;
            object = this.binaryMsg_;
            codedOutputStream.writeBytes(n10, (ByteString)object);
        }
        n10 = this.bitField0_;
        n11 = 512;
        if ((n10 &= n11) == n11) {
            n10 = 10;
            n11 = this.convType_;
            codedOutputStream.writeInt32(n10, n11);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

