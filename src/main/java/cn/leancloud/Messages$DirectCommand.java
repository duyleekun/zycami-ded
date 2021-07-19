/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$DirectCommand$1;
import cn.leancloud.Messages$DirectCommand$Builder;
import cn.leancloud.Messages$DirectCommandOrBuilder;
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

public final class Messages$DirectCommand
extends GeneratedMessageV3
implements Messages$DirectCommandOrBuilder {
    public static final int BINARYMSG_FIELD_NUMBER = 19;
    public static final int CID_FIELD_NUMBER = 11;
    public static final int CONVTYPE_FIELD_NUMBER = 22;
    private static final Messages$DirectCommand DEFAULT_INSTANCE;
    public static final int DT_FIELD_NUMBER = 14;
    public static final int FROMPEERID_FIELD_NUMBER = 3;
    public static final int HASMORE_FIELD_NUMBER = 6;
    public static final int ID_FIELD_NUMBER = 12;
    public static final int MENTIONALL_FIELD_NUMBER = 21;
    public static final int MENTIONPIDS_FIELD_NUMBER = 20;
    public static final int MSG_FIELD_NUMBER = 1;
    public static final int OFFLINE_FIELD_NUMBER = 5;
    public static final Parser PARSER;
    public static final int PATCHTIMESTAMP_FIELD_NUMBER = 18;
    public static final int PUSHDATA_FIELD_NUMBER = 16;
    public static final int ROOMID_FIELD_NUMBER = 15;
    public static final int R_FIELD_NUMBER = 10;
    public static final int TIMESTAMP_FIELD_NUMBER = 4;
    public static final int TOPEERIDS_FIELD_NUMBER = 7;
    public static final int TRANSIENT_FIELD_NUMBER = 13;
    public static final int UID_FIELD_NUMBER = 2;
    public static final int WILL_FIELD_NUMBER = 17;
    private static final long serialVersionUID;
    private ByteString binaryMsg_;
    private int bitField0_;
    private volatile Object cid_;
    private int convType_;
    private volatile Object dt_;
    private volatile Object fromPeerId_;
    private boolean hasMore_;
    private volatile Object id_;
    private byte memoizedIsInitialized;
    private boolean mentionAll_;
    private LazyStringList mentionPids_;
    private volatile Object msg_;
    private boolean offline_;
    private long patchTimestamp_;
    private volatile Object pushData_;
    private boolean r_;
    private volatile Object roomId_;
    private long timestamp_;
    private LazyStringList toPeerIds_;
    private boolean transient_;
    private volatile Object uid_;
    private boolean will_;

    static {
        Object object = new Messages$DirectCommand();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$DirectCommand$1();
    }

    private Messages$DirectCommand() {
        LazyStringList lazyStringList;
        long l10;
        Object object;
        this.memoizedIsInitialized = (byte)-1;
        this.msg_ = object = "";
        this.uid_ = object;
        this.fromPeerId_ = object;
        this.timestamp_ = l10 = 0L;
        this.offline_ = false;
        this.hasMore_ = false;
        this.toPeerIds_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.r_ = false;
        this.cid_ = object;
        this.id_ = object;
        this.transient_ = false;
        this.dt_ = object;
        this.roomId_ = object;
        this.pushData_ = object;
        this.will_ = false;
        this.patchTimestamp_ = l10;
        this.binaryMsg_ = object = ByteString.EMPTY;
        this.mentionPids_ = lazyStringList;
        this.mentionAll_ = false;
        this.convType_ = 0;
    }

    /*
     * Exception decompiling
     */
    private Messages$DirectCommand(CodedInputStream var1_1, ExtensionRegistryLite var2_7) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 57[TRYBLOCK] [258 : 938->941)] java.lang.Throwable
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

    public /* synthetic */ Messages$DirectCommand(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$DirectCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ Messages$DirectCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$18000() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ Object access$18200(Messages$DirectCommand messages$DirectCommand) {
        return messages$DirectCommand.msg_;
    }

    public static /* synthetic */ Object access$18202(Messages$DirectCommand messages$DirectCommand, Object object) {
        messages$DirectCommand.msg_ = object;
        return object;
    }

    public static /* synthetic */ Object access$18300(Messages$DirectCommand messages$DirectCommand) {
        return messages$DirectCommand.uid_;
    }

    public static /* synthetic */ Object access$18302(Messages$DirectCommand messages$DirectCommand, Object object) {
        messages$DirectCommand.uid_ = object;
        return object;
    }

    public static /* synthetic */ Object access$18400(Messages$DirectCommand messages$DirectCommand) {
        return messages$DirectCommand.fromPeerId_;
    }

    public static /* synthetic */ Object access$18402(Messages$DirectCommand messages$DirectCommand, Object object) {
        messages$DirectCommand.fromPeerId_ = object;
        return object;
    }

    public static /* synthetic */ long access$18502(Messages$DirectCommand messages$DirectCommand, long l10) {
        messages$DirectCommand.timestamp_ = l10;
        return l10;
    }

    public static /* synthetic */ boolean access$18602(Messages$DirectCommand messages$DirectCommand, boolean bl2) {
        messages$DirectCommand.offline_ = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean access$18702(Messages$DirectCommand messages$DirectCommand, boolean bl2) {
        messages$DirectCommand.hasMore_ = bl2;
        return bl2;
    }

    public static /* synthetic */ LazyStringList access$18800(Messages$DirectCommand messages$DirectCommand) {
        return messages$DirectCommand.toPeerIds_;
    }

    public static /* synthetic */ LazyStringList access$18802(Messages$DirectCommand messages$DirectCommand, LazyStringList lazyStringList) {
        messages$DirectCommand.toPeerIds_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ boolean access$18902(Messages$DirectCommand messages$DirectCommand, boolean bl2) {
        messages$DirectCommand.r_ = bl2;
        return bl2;
    }

    public static /* synthetic */ Object access$19000(Messages$DirectCommand messages$DirectCommand) {
        return messages$DirectCommand.cid_;
    }

    public static /* synthetic */ Object access$19002(Messages$DirectCommand messages$DirectCommand, Object object) {
        messages$DirectCommand.cid_ = object;
        return object;
    }

    public static /* synthetic */ Object access$19100(Messages$DirectCommand messages$DirectCommand) {
        return messages$DirectCommand.id_;
    }

    public static /* synthetic */ Object access$19102(Messages$DirectCommand messages$DirectCommand, Object object) {
        messages$DirectCommand.id_ = object;
        return object;
    }

    public static /* synthetic */ boolean access$19202(Messages$DirectCommand messages$DirectCommand, boolean bl2) {
        messages$DirectCommand.transient_ = bl2;
        return bl2;
    }

    public static /* synthetic */ Object access$19300(Messages$DirectCommand messages$DirectCommand) {
        return messages$DirectCommand.dt_;
    }

    public static /* synthetic */ Object access$19302(Messages$DirectCommand messages$DirectCommand, Object object) {
        messages$DirectCommand.dt_ = object;
        return object;
    }

    public static /* synthetic */ Object access$19400(Messages$DirectCommand messages$DirectCommand) {
        return messages$DirectCommand.roomId_;
    }

    public static /* synthetic */ Object access$19402(Messages$DirectCommand messages$DirectCommand, Object object) {
        messages$DirectCommand.roomId_ = object;
        return object;
    }

    public static /* synthetic */ Object access$19500(Messages$DirectCommand messages$DirectCommand) {
        return messages$DirectCommand.pushData_;
    }

    public static /* synthetic */ Object access$19502(Messages$DirectCommand messages$DirectCommand, Object object) {
        messages$DirectCommand.pushData_ = object;
        return object;
    }

    public static /* synthetic */ boolean access$19602(Messages$DirectCommand messages$DirectCommand, boolean bl2) {
        messages$DirectCommand.will_ = bl2;
        return bl2;
    }

    public static /* synthetic */ long access$19702(Messages$DirectCommand messages$DirectCommand, long l10) {
        messages$DirectCommand.patchTimestamp_ = l10;
        return l10;
    }

    public static /* synthetic */ ByteString access$19802(Messages$DirectCommand messages$DirectCommand, ByteString byteString) {
        messages$DirectCommand.binaryMsg_ = byteString;
        return byteString;
    }

    public static /* synthetic */ LazyStringList access$19900(Messages$DirectCommand messages$DirectCommand) {
        return messages$DirectCommand.mentionPids_;
    }

    public static /* synthetic */ LazyStringList access$19902(Messages$DirectCommand messages$DirectCommand, LazyStringList lazyStringList) {
        messages$DirectCommand.mentionPids_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ boolean access$20002(Messages$DirectCommand messages$DirectCommand, boolean bl2) {
        messages$DirectCommand.mentionAll_ = bl2;
        return bl2;
    }

    public static /* synthetic */ int access$20102(Messages$DirectCommand messages$DirectCommand, int n10) {
        messages$DirectCommand.convType_ = n10;
        return n10;
    }

    public static /* synthetic */ int access$20202(Messages$DirectCommand messages$DirectCommand, int n10) {
        messages$DirectCommand.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ UnknownFieldSet access$20300(Messages$DirectCommand messages$DirectCommand) {
        return messages$DirectCommand.unknownFields;
    }

    public static Messages$DirectCommand getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$17600();
    }

    public static Messages$DirectCommand$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$DirectCommand$Builder newBuilder(Messages$DirectCommand messages$DirectCommand) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$DirectCommand);
    }

    public static Messages$DirectCommand parseDelimitedFrom(InputStream inputStream) {
        return (Messages$DirectCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$DirectCommand parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$DirectCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$DirectCommand parseFrom(ByteString byteString) {
        return (Messages$DirectCommand)PARSER.parseFrom(byteString);
    }

    public static Messages$DirectCommand parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$DirectCommand)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$DirectCommand parseFrom(CodedInputStream codedInputStream) {
        return (Messages$DirectCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$DirectCommand parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$DirectCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$DirectCommand parseFrom(InputStream inputStream) {
        return (Messages$DirectCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$DirectCommand parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$DirectCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$DirectCommand parseFrom(ByteBuffer byteBuffer) {
        return (Messages$DirectCommand)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$DirectCommand parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$DirectCommand)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$DirectCommand parseFrom(byte[] byArray) {
        return (Messages$DirectCommand)PARSER.parseFrom(byArray);
    }

    public static Messages$DirectCommand parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$DirectCommand)PARSER.parseFrom(byArray, extensionRegistryLite);
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
        int n12 = object instanceof Messages$DirectCommand;
        if (n12 == 0) {
            return super.equals(object);
        }
        object = (Messages$DirectCommand)object;
        n12 = this.hasMsg();
        if (n12 == (n10 = ((Messages$DirectCommand)object).hasMsg())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasMsg();
        if (n10 != 0) {
            if (n12 != 0 && (n12 = ((String)(object3 = this.getMsg())).equals(object2 = ((Messages$DirectCommand)object).getMsg())) != 0) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = this.hasUid()) == (n10 = ((Messages$DirectCommand)object).hasUid())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasUid();
        if (n10 != 0) {
            if (n12 != 0 && (n12 = ((String)(object3 = this.getUid())).equals(object2 = ((Messages$DirectCommand)object).getUid())) != 0) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = this.hasFromPeerId()) == (n10 = ((Messages$DirectCommand)object).hasFromPeerId())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasFromPeerId();
        if (n10 != 0) {
            if (n12 != 0 && (n12 = ((String)(object3 = this.getFromPeerId())).equals(object2 = ((Messages$DirectCommand)object).getFromPeerId())) != 0) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = this.hasTimestamp()) == (n10 = ((Messages$DirectCommand)object).hasTimestamp())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasTimestamp();
        if (n10 != 0) {
            long l12;
            if (n12 != 0 && (n12 = (l12 = (l11 = this.getTimestamp()) - (l10 = ((Messages$DirectCommand)object).getTimestamp())) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == 0) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = this.hasOffline()) == (n10 = ((Messages$DirectCommand)object).hasOffline())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasOffline();
        if (n10 != 0) {
            if (n12 != 0 && (n12 = this.getOffline()) == (n10 = ((Messages$DirectCommand)object).getOffline())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = this.hasHasMore()) == (n10 = ((Messages$DirectCommand)object).hasHasMore())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasHasMore();
        if (n10 != 0) {
            if (n12 != 0 && (n12 = this.getHasMore()) == (n10 = ((Messages$DirectCommand)object).getHasMore())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = (object3 = this.getToPeerIdsList()).equals(object2 = ((Messages$DirectCommand)object).getToPeerIdsList())) != 0) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        if (n12 != 0 && (n12 = this.hasR()) == (n10 = ((Messages$DirectCommand)object).hasR())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasR();
        if (n10 != 0) {
            if (n12 != 0 && (n12 = this.getR()) == (n10 = ((Messages$DirectCommand)object).getR())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = this.hasCid()) == (n10 = ((Messages$DirectCommand)object).hasCid())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasCid();
        if (n10 != 0) {
            if (n12 != 0 && (n12 = ((String)(object3 = this.getCid())).equals(object2 = ((Messages$DirectCommand)object).getCid())) != 0) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = this.hasId()) == (n10 = ((Messages$DirectCommand)object).hasId())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasId();
        if (n10 != 0) {
            if (n12 != 0 && (n12 = ((String)(object3 = this.getId())).equals(object2 = ((Messages$DirectCommand)object).getId())) != 0) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = this.hasTransient()) == (n10 = ((Messages$DirectCommand)object).hasTransient())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasTransient();
        if (n10 != 0) {
            if (n12 != 0 && (n12 = this.getTransient()) == (n10 = ((Messages$DirectCommand)object).getTransient())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = this.hasDt()) == (n10 = ((Messages$DirectCommand)object).hasDt())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasDt();
        if (n10 != 0) {
            if (n12 != 0 && (n12 = ((String)(object3 = this.getDt())).equals(object2 = ((Messages$DirectCommand)object).getDt())) != 0) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = this.hasRoomId()) == (n10 = ((Messages$DirectCommand)object).hasRoomId())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasRoomId();
        if (n10 != 0) {
            if (n12 != 0 && (n12 = ((String)(object3 = this.getRoomId())).equals(object2 = ((Messages$DirectCommand)object).getRoomId())) != 0) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = this.hasPushData()) == (n10 = ((Messages$DirectCommand)object).hasPushData())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasPushData();
        if (n10 != 0) {
            if (n12 != 0 && (n12 = ((String)(object3 = this.getPushData())).equals(object2 = ((Messages$DirectCommand)object).getPushData())) != 0) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = this.hasWill()) == (n10 = ((Messages$DirectCommand)object).hasWill())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasWill();
        if (n10 != 0) {
            if (n12 != 0 && (n12 = this.getWill()) == (n10 = ((Messages$DirectCommand)object).getWill())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = this.hasPatchTimestamp()) == (n10 = ((Messages$DirectCommand)object).hasPatchTimestamp())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasPatchTimestamp();
        if (n10 != 0) {
            long l13;
            if (n12 != 0 && (n12 = (l13 = (l11 = this.getPatchTimestamp()) - (l10 = ((Messages$DirectCommand)object).getPatchTimestamp())) == 0L ? 0 : (l13 < 0L ? -1 : 1)) == 0) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = this.hasBinaryMsg()) == (n10 = ((Messages$DirectCommand)object).hasBinaryMsg())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasBinaryMsg();
        if (n10 != 0) {
            if (n12 != 0 && (n12 = ((ByteString)(object3 = this.getBinaryMsg())).equals(object2 = ((Messages$DirectCommand)object).getBinaryMsg())) != 0) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = (object3 = this.getMentionPidsList()).equals(object2 = ((Messages$DirectCommand)object).getMentionPidsList())) != 0) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        if (n12 != 0 && (n12 = this.hasMentionAll()) == (n10 = ((Messages$DirectCommand)object).hasMentionAll())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasMentionAll();
        if (n10 != 0) {
            if (n12 != 0 && (n12 = this.getMentionAll()) == (n10 = ((Messages$DirectCommand)object).getMentionAll())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 != 0 && (n12 = this.hasConvType()) == (n10 = ((Messages$DirectCommand)object).hasConvType())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasConvType();
        if (n10 != 0) {
            if (n12 != 0 && (n12 = this.getConvType()) == (n10 = ((Messages$DirectCommand)object).getConvType())) {
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

    public Messages$DirectCommand getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public String getDt() {
        Object object = this.dt_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.dt_ = string2;
        }
        return string2;
    }

    public ByteString getDtBytes() {
        Object object = this.dt_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.dt_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getFromPeerId() {
        Object object = this.fromPeerId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.fromPeerId_ = string2;
        }
        return string2;
    }

    public ByteString getFromPeerIdBytes() {
        Object object = this.fromPeerId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.fromPeerId_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public boolean getHasMore() {
        return this.hasMore_;
    }

    public String getId() {
        Object object = this.id_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.id_ = string2;
        }
        return string2;
    }

    public ByteString getIdBytes() {
        Object object = this.id_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.id_ = object = ByteString.copyFromUtf8((String)object);
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

    public String getMsg() {
        Object object = this.msg_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.msg_ = string2;
        }
        return string2;
    }

    public ByteString getMsgBytes() {
        Object object = this.msg_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.msg_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public boolean getOffline() {
        return this.offline_;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public long getPatchTimestamp() {
        return this.patchTimestamp_;
    }

    public String getPushData() {
        Object object = this.pushData_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.pushData_ = string2;
        }
        return string2;
    }

    public ByteString getPushDataBytes() {
        Object object = this.pushData_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.pushData_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public boolean getR() {
        return this.r_;
    }

    public String getRoomId() {
        Object object = this.roomId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.roomId_ = string2;
        }
        return string2;
    }

    public ByteString getRoomIdBytes() {
        Object object = this.roomId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.roomId_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public int getSerializedSize() {
        Object object;
        Object object2;
        int n10;
        Object object3;
        Object object4;
        Object object5;
        int n11 = this.memoizedSize;
        int n12 = -1;
        if (n11 != n12) {
            return n11;
        }
        n11 = this.bitField0_;
        n12 = 1;
        int n13 = 0;
        if ((n11 &= n12) == n12) {
            object5 = this.msg_;
            n11 = GeneratedMessageV3.computeStringSize(n12, object5) + 0;
        } else {
            n11 = 0;
            object5 = null;
        }
        int n14 = this.bitField0_;
        int n15 = 2;
        if ((n14 &= n15) == n15) {
            object4 = this.uid_;
            n14 = GeneratedMessageV3.computeStringSize(n15, object4);
            n11 += n14;
        }
        n14 = this.bitField0_;
        int n16 = 4;
        if ((n14 &= n16) == n16) {
            object3 = this.fromPeerId_;
            n14 = GeneratedMessageV3.computeStringSize(3, object3);
            n11 += n14;
        }
        n14 = this.bitField0_;
        int n17 = 8;
        if ((n14 &= n17) == n17) {
            long l10 = this.timestamp_;
            n14 = CodedOutputStream.computeInt64Size(n16, l10);
            n11 += n14;
        }
        n14 = this.bitField0_;
        n16 = 16;
        if ((n14 &= n16) == n16) {
            n17 = (int)(this.offline_ ? 1 : 0);
            n14 = CodedOutputStream.computeBoolSize(5, n17 != 0);
            n11 += n14;
        }
        n14 = this.bitField0_;
        n17 = 32;
        if ((n14 &= n17) == n17) {
            n17 = (int)(this.hasMore_ ? 1 : 0);
            n14 = CodedOutputStream.computeBoolSize(6, n17 != 0);
            n11 += n14;
        }
        object4 = null;
        n17 = 0;
        object3 = null;
        for (n14 = 0; n14 < (n10 = (object2 = this.toPeerIds_).size()); ++n14) {
            object2 = this.toPeerIds_.getRaw(n14);
            n10 = GeneratedMessageV3.computeStringSizeNoTag(object2);
            n17 += n10;
        }
        n11 += n17;
        object4 = this.getToPeerIdsList();
        n14 = object4.size() * n12;
        n11 += n14;
        n12 = this.bitField0_;
        n14 = 64;
        if ((n12 &= n14) == n14) {
            n14 = (int)(this.r_ ? 1 : 0);
            n12 = CodedOutputStream.computeBoolSize(10, n14 != 0);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n14 = 128;
        if ((n12 &= n14) == n14) {
            object4 = this.cid_;
            n12 = GeneratedMessageV3.computeStringSize(11, object4);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n14 = 256;
        if ((n12 &= n14) == n14) {
            object4 = this.id_;
            n12 = GeneratedMessageV3.computeStringSize(12, object4);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n14 = 512;
        if ((n12 &= n14) == n14) {
            n14 = (int)(this.transient_ ? 1 : 0);
            n12 = CodedOutputStream.computeBoolSize(13, n14 != 0);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n14 = 1024;
        if ((n12 &= n14) == n14) {
            object4 = this.dt_;
            n12 = GeneratedMessageV3.computeStringSize(14, object4);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n14 = 2048;
        if ((n12 &= n14) == n14) {
            object4 = this.roomId_;
            n12 = GeneratedMessageV3.computeStringSize(15, object4);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n14 = 4096;
        if ((n12 &= n14) == n14) {
            object = this.pushData_;
            n12 = GeneratedMessageV3.computeStringSize(n16, object);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n14 = 8192;
        if ((n12 &= n14) == n14) {
            n14 = (int)(this.will_ ? 1 : 0);
            n12 = CodedOutputStream.computeBoolSize(17, n14 != 0);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n14 = 16384;
        if ((n12 &= n14) == n14) {
            long l11 = this.patchTimestamp_;
            n12 = CodedOutputStream.computeInt64Size(18, l11);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n14 = 32768;
        if ((n12 &= n14) == n14) {
            object4 = this.binaryMsg_;
            n12 = CodedOutputStream.computeBytesSize(19, (ByteString)object4);
            n11 += n12;
        }
        n12 = 0;
        object = null;
        while (n13 < (n14 = (object4 = this.mentionPids_).size())) {
            object4 = this.mentionPids_.getRaw(n13);
            n14 = GeneratedMessageV3.computeStringSizeNoTag(object4);
            n12 += n14;
            ++n13;
        }
        n11 += n12;
        object = this.getMentionPidsList();
        n12 = object.size() * n15;
        n11 += n12;
        n12 = this.bitField0_;
        n13 = 65536;
        if ((n12 &= n13) == n13) {
            n13 = (int)(this.mentionAll_ ? 1 : 0);
            n12 = CodedOutputStream.computeBoolSize(21, n13 != 0);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n13 = 131072;
        if ((n12 &= n13) == n13) {
            n13 = this.convType_;
            n12 = CodedOutputStream.computeInt32Size(22, n13);
            n11 += n12;
        }
        n12 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n11 += n12;
        return n11;
    }

    public long getTimestamp() {
        return this.timestamp_;
    }

    public String getToPeerIds(int n10) {
        return (String)this.toPeerIds_.get(n10);
    }

    public ByteString getToPeerIdsBytes(int n10) {
        return this.toPeerIds_.getByteString(n10);
    }

    public int getToPeerIdsCount() {
        return this.toPeerIds_.size();
    }

    public ProtocolStringList getToPeerIdsList() {
        return this.toPeerIds_;
    }

    public boolean getTransient() {
        return this.transient_;
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

    public boolean getWill() {
        return this.will_;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasBinaryMsg() {
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
    public boolean hasCid() {
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
    public boolean hasConvType() {
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
    public boolean hasDt() {
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
    public boolean hasFromPeerId() {
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
    public boolean hasHasMore() {
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
    public boolean hasId() {
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
    public boolean hasMentionAll() {
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

    public boolean hasMsg() {
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
    public boolean hasOffline() {
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
    public boolean hasPatchTimestamp() {
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
    public boolean hasPushData() {
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
    public boolean hasR() {
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
    public boolean hasRoomId() {
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
    public boolean hasTransient() {
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
    public boolean hasUid() {
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
    public boolean hasWill() {
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

    public int hashCode() {
        long l10;
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = Messages$DirectCommand.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasMsg() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getMsg();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasUid() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getUid();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasFromPeerId() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            object = this.getFromPeerId();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasTimestamp() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 4) * 53;
            l10 = this.getTimestamp();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasOffline() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 5) * 53;
            n11 = Internal.hashBoolean(this.getOffline());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasHasMore() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 6) * 53;
            n11 = Internal.hashBoolean(this.getHasMore());
            n10 += n11;
        }
        if ((n11 = this.getToPeerIdsCount()) > 0) {
            n10 = (n10 * 37 + 7) * 53;
            object = this.getToPeerIdsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasR() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 10) * 53;
            n11 = Internal.hashBoolean(this.getR());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasCid() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 11) * 53;
            object = this.getCid();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasId() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 12) * 53;
            object = this.getId();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasTransient() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 13) * 53;
            n11 = Internal.hashBoolean(this.getTransient());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasDt() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 14) * 53;
            object = this.getDt();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasRoomId() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 15) * 53;
            object = this.getRoomId();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasPushData() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 16) * 53;
            object = this.getPushData();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasWill() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 17) * 53;
            n11 = Internal.hashBoolean(this.getWill());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasPatchTimestamp() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 18) * 53;
            l10 = this.getPatchTimestamp();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasBinaryMsg() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 19) * 53;
            object = this.getBinaryMsg();
            n11 = ((ByteString)object).hashCode();
            n10 += n11;
        }
        if ((n11 = this.getMentionPidsCount()) > 0) {
            n10 = (n10 * 37 + 20) * 53;
            object = this.getMentionPidsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasMentionAll() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 21) * 53;
            n11 = Internal.hashBoolean(this.getMentionAll());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasConvType() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 22) * 53;
            n11 = this.getConvType();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$17700().ensureFieldAccessorsInitialized(Messages$DirectCommand.class, Messages$DirectCommand$Builder.class);
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

    public Messages$DirectCommand$Builder newBuilderForType() {
        return Messages$DirectCommand.newBuilder();
    }

    public Messages$DirectCommand$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$DirectCommand$Builder messages$DirectCommand$Builder = new Messages$DirectCommand$Builder(generatedMessageV3$BuilderParent, null);
        return messages$DirectCommand$Builder;
    }

    public Messages$DirectCommand$Builder toBuilder() {
        Messages$DirectCommandOrBuilder messages$DirectCommandOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$DirectCommandOrBuilder) {
            messages$DirectCommandOrBuilder = new Messages$DirectCommand$Builder(null);
        } else {
            messages$DirectCommandOrBuilder = new Messages$DirectCommand$Builder(null);
            messages$DirectCommandOrBuilder = ((Messages$DirectCommand$Builder)messages$DirectCommandOrBuilder).mergeFrom(this);
        }
        return messages$DirectCommandOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        LazyStringList lazyStringList;
        Object object;
        int n10;
        long l10;
        Object object2;
        Object object3;
        int n11 = this.bitField0_;
        int n12 = 1;
        if ((n11 &= n12) == n12) {
            object3 = this.msg_;
            GeneratedMessageV3.writeString(codedOutputStream, n12, object3);
        }
        n11 = this.bitField0_;
        n12 = 2;
        if ((n11 &= n12) == n12) {
            object3 = this.uid_;
            GeneratedMessageV3.writeString(codedOutputStream, n12, object3);
        }
        n11 = this.bitField0_;
        n12 = 4;
        if ((n11 &= n12) == n12) {
            n11 = 3;
            object2 = this.fromPeerId_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object2);
        }
        n11 = this.bitField0_;
        int n13 = 8;
        if ((n11 &= n13) == n13) {
            l10 = this.timestamp_;
            codedOutputStream.writeInt64(n12, l10);
        }
        n11 = this.bitField0_;
        n12 = 16;
        if ((n11 &= n12) == n12) {
            n11 = 5;
            n13 = (int)(this.offline_ ? 1 : 0);
            codedOutputStream.writeBool(n11, n13 != 0);
        }
        n11 = this.bitField0_;
        n13 = 32;
        if ((n11 &= n13) == n13) {
            n11 = 6;
            n13 = (int)(this.hasMore_ ? 1 : 0);
            codedOutputStream.writeBool(n11, n13 != 0);
        }
        n11 = 0;
        object3 = null;
        object2 = null;
        for (n13 = 0; n13 < (n10 = (object = this.toPeerIds_).size()); ++n13) {
            n10 = 7;
            Object object4 = this.toPeerIds_.getRaw(n13);
            GeneratedMessageV3.writeString(codedOutputStream, n10, object4);
        }
        n13 = this.bitField0_;
        n10 = 64;
        if ((n13 &= n10) == n10) {
            n13 = 10;
            n10 = (int)(this.r_ ? 1 : 0);
            codedOutputStream.writeBool(n13, n10 != 0);
        }
        n13 = this.bitField0_;
        n10 = 128;
        if ((n13 &= n10) == n10) {
            n13 = 11;
            object = this.cid_;
            GeneratedMessageV3.writeString(codedOutputStream, n13, object);
        }
        n13 = this.bitField0_;
        n10 = 256;
        if ((n13 &= n10) == n10) {
            n13 = 12;
            object = this.id_;
            GeneratedMessageV3.writeString(codedOutputStream, n13, object);
        }
        n13 = this.bitField0_;
        n10 = 512;
        if ((n13 &= n10) == n10) {
            n13 = 13;
            n10 = (int)(this.transient_ ? 1 : 0);
            codedOutputStream.writeBool(n13, n10 != 0);
        }
        n13 = this.bitField0_;
        n10 = 1024;
        if ((n13 &= n10) == n10) {
            n13 = 14;
            object = this.dt_;
            GeneratedMessageV3.writeString(codedOutputStream, n13, object);
        }
        n13 = this.bitField0_;
        n10 = 2048;
        if ((n13 &= n10) == n10) {
            n13 = 15;
            object = this.roomId_;
            GeneratedMessageV3.writeString(codedOutputStream, n13, object);
        }
        n13 = this.bitField0_;
        n10 = 4096;
        if ((n13 &= n10) == n10) {
            object2 = this.pushData_;
            GeneratedMessageV3.writeString(codedOutputStream, n12, object2);
        }
        n12 = this.bitField0_;
        n13 = 8192;
        if ((n12 &= n13) == n13) {
            n12 = 17;
            n13 = (int)(this.will_ ? 1 : 0);
            codedOutputStream.writeBool(n12, n13 != 0);
        }
        n12 = this.bitField0_;
        n13 = 16384;
        if ((n12 &= n13) == n13) {
            n12 = 18;
            l10 = this.patchTimestamp_;
            codedOutputStream.writeInt64(n12, l10);
        }
        n12 = this.bitField0_;
        n13 = 32768;
        if ((n12 &= n13) == n13) {
            n12 = 19;
            object2 = this.binaryMsg_;
            codedOutputStream.writeBytes(n12, (ByteString)object2);
        }
        while (n11 < (n12 = (lazyStringList = this.mentionPids_).size())) {
            n12 = 20;
            object2 = this.mentionPids_.getRaw(n11);
            GeneratedMessageV3.writeString(codedOutputStream, n12, object2);
            ++n11;
        }
        n11 = this.bitField0_;
        n12 = 65536;
        if ((n11 &= n12) == n12) {
            n11 = 21;
            n12 = (int)(this.mentionAll_ ? 1 : 0);
            codedOutputStream.writeBool(n11, n12 != 0);
        }
        n11 = this.bitField0_;
        n12 = 131072;
        if ((n11 &= n12) == n12) {
            n11 = 22;
            n12 = this.convType_;
            codedOutputStream.writeInt32(n11, n12);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

