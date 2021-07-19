/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$SessionCommand$1;
import cn.leancloud.Messages$SessionCommand$Builder;
import cn.leancloud.Messages$SessionCommandOrBuilder;
import cn.leancloud.Messages$SystemInfo;
import cn.leancloud.Messages$SystemInfoOrBuilder;
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

public final class Messages$SessionCommand
extends GeneratedMessageV3
implements Messages$SessionCommandOrBuilder {
    public static final int CODE_FIELD_NUMBER = 12;
    public static final int CONFIGBITMAP_FIELD_NUMBER = 19;
    private static final Messages$SessionCommand DEFAULT_INSTANCE;
    public static final int DETAIL_FIELD_NUMBER = 16;
    public static final int DEVICEID_FIELD_NUMBER = 7;
    public static final int DEVICETOKEN_FIELD_NUMBER = 14;
    public static final int LASTPATCHTIME_FIELD_NUMBER = 18;
    public static final int LASTUNREADNOTIFTIME_FIELD_NUMBER = 17;
    public static final int N_FIELD_NUMBER = 2;
    public static final int ONLINESESSIONPEERIDS_FIELD_NUMBER = 9;
    public static final Parser PARSER;
    public static final int REASON_FIELD_NUMBER = 13;
    public static final int R_FIELD_NUMBER = 5;
    public static final int SESSIONPEERIDS_FIELD_NUMBER = 8;
    public static final int SP_FIELD_NUMBER = 15;
    public static final int STTTL_FIELD_NUMBER = 11;
    public static final int ST_FIELD_NUMBER = 10;
    public static final int SYSTEMINFO_FIELD_NUMBER = 20;
    public static final int S_FIELD_NUMBER = 3;
    public static final int TAG_FIELD_NUMBER = 6;
    public static final int T_FIELD_NUMBER = 1;
    public static final int UA_FIELD_NUMBER = 4;
    private static final long serialVersionUID;
    private int bitField0_;
    private int code_;
    private long configBitmap_;
    private volatile Object detail_;
    private volatile Object deviceId_;
    private volatile Object deviceToken_;
    private long lastPatchTime_;
    private long lastUnreadNotifTime_;
    private byte memoizedIsInitialized;
    private volatile Object n_;
    private LazyStringList onlineSessionPeerIds_;
    private boolean r_;
    private volatile Object reason_;
    private volatile Object s_;
    private LazyStringList sessionPeerIds_;
    private boolean sp_;
    private int stTtl_;
    private volatile Object st_;
    private Messages$SystemInfo systemInfo_;
    private long t_;
    private volatile Object tag_;
    private volatile Object ua_;

    static {
        Object object = new Messages$SessionCommand();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$SessionCommand$1();
    }

    private Messages$SessionCommand() {
        LazyStringList lazyStringList;
        long l10;
        this.memoizedIsInitialized = (byte)-1;
        this.t_ = l10 = 0L;
        String string2 = "";
        this.n_ = string2;
        this.s_ = string2;
        this.ua_ = string2;
        this.r_ = false;
        this.tag_ = string2;
        this.deviceId_ = string2;
        this.sessionPeerIds_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.onlineSessionPeerIds_ = lazyStringList;
        this.st_ = string2;
        this.stTtl_ = 0;
        this.code_ = 0;
        this.reason_ = string2;
        this.deviceToken_ = string2;
        this.sp_ = false;
        this.detail_ = string2;
        this.lastUnreadNotifTime_ = l10;
        this.lastPatchTime_ = l10;
        this.configBitmap_ = l10;
    }

    /*
     * Exception decompiling
     */
    private Messages$SessionCommand(CodedInputStream var1_1, ExtensionRegistryLite var2_7) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 65[TRYBLOCK] [282 : 1024->1027)] java.lang.Throwable
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

    public /* synthetic */ Messages$SessionCommand(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$SessionCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ Messages$SessionCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$13600() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ long access$13802(Messages$SessionCommand messages$SessionCommand, long l10) {
        messages$SessionCommand.t_ = l10;
        return l10;
    }

    public static /* synthetic */ Object access$13900(Messages$SessionCommand messages$SessionCommand) {
        return messages$SessionCommand.n_;
    }

    public static /* synthetic */ Object access$13902(Messages$SessionCommand messages$SessionCommand, Object object) {
        messages$SessionCommand.n_ = object;
        return object;
    }

    public static /* synthetic */ Object access$14000(Messages$SessionCommand messages$SessionCommand) {
        return messages$SessionCommand.s_;
    }

    public static /* synthetic */ Object access$14002(Messages$SessionCommand messages$SessionCommand, Object object) {
        messages$SessionCommand.s_ = object;
        return object;
    }

    public static /* synthetic */ Object access$14100(Messages$SessionCommand messages$SessionCommand) {
        return messages$SessionCommand.ua_;
    }

    public static /* synthetic */ Object access$14102(Messages$SessionCommand messages$SessionCommand, Object object) {
        messages$SessionCommand.ua_ = object;
        return object;
    }

    public static /* synthetic */ boolean access$14202(Messages$SessionCommand messages$SessionCommand, boolean bl2) {
        messages$SessionCommand.r_ = bl2;
        return bl2;
    }

    public static /* synthetic */ Object access$14300(Messages$SessionCommand messages$SessionCommand) {
        return messages$SessionCommand.tag_;
    }

    public static /* synthetic */ Object access$14302(Messages$SessionCommand messages$SessionCommand, Object object) {
        messages$SessionCommand.tag_ = object;
        return object;
    }

    public static /* synthetic */ Object access$14400(Messages$SessionCommand messages$SessionCommand) {
        return messages$SessionCommand.deviceId_;
    }

    public static /* synthetic */ Object access$14402(Messages$SessionCommand messages$SessionCommand, Object object) {
        messages$SessionCommand.deviceId_ = object;
        return object;
    }

    public static /* synthetic */ LazyStringList access$14500(Messages$SessionCommand messages$SessionCommand) {
        return messages$SessionCommand.sessionPeerIds_;
    }

    public static /* synthetic */ LazyStringList access$14502(Messages$SessionCommand messages$SessionCommand, LazyStringList lazyStringList) {
        messages$SessionCommand.sessionPeerIds_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ LazyStringList access$14600(Messages$SessionCommand messages$SessionCommand) {
        return messages$SessionCommand.onlineSessionPeerIds_;
    }

    public static /* synthetic */ LazyStringList access$14602(Messages$SessionCommand messages$SessionCommand, LazyStringList lazyStringList) {
        messages$SessionCommand.onlineSessionPeerIds_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ Object access$14700(Messages$SessionCommand messages$SessionCommand) {
        return messages$SessionCommand.st_;
    }

    public static /* synthetic */ Object access$14702(Messages$SessionCommand messages$SessionCommand, Object object) {
        messages$SessionCommand.st_ = object;
        return object;
    }

    public static /* synthetic */ int access$14802(Messages$SessionCommand messages$SessionCommand, int n10) {
        messages$SessionCommand.stTtl_ = n10;
        return n10;
    }

    public static /* synthetic */ int access$14902(Messages$SessionCommand messages$SessionCommand, int n10) {
        messages$SessionCommand.code_ = n10;
        return n10;
    }

    public static /* synthetic */ Object access$15000(Messages$SessionCommand messages$SessionCommand) {
        return messages$SessionCommand.reason_;
    }

    public static /* synthetic */ Object access$15002(Messages$SessionCommand messages$SessionCommand, Object object) {
        messages$SessionCommand.reason_ = object;
        return object;
    }

    public static /* synthetic */ Object access$15100(Messages$SessionCommand messages$SessionCommand) {
        return messages$SessionCommand.deviceToken_;
    }

    public static /* synthetic */ Object access$15102(Messages$SessionCommand messages$SessionCommand, Object object) {
        messages$SessionCommand.deviceToken_ = object;
        return object;
    }

    public static /* synthetic */ boolean access$15202(Messages$SessionCommand messages$SessionCommand, boolean bl2) {
        messages$SessionCommand.sp_ = bl2;
        return bl2;
    }

    public static /* synthetic */ Object access$15300(Messages$SessionCommand messages$SessionCommand) {
        return messages$SessionCommand.detail_;
    }

    public static /* synthetic */ Object access$15302(Messages$SessionCommand messages$SessionCommand, Object object) {
        messages$SessionCommand.detail_ = object;
        return object;
    }

    public static /* synthetic */ long access$15402(Messages$SessionCommand messages$SessionCommand, long l10) {
        messages$SessionCommand.lastUnreadNotifTime_ = l10;
        return l10;
    }

    public static /* synthetic */ long access$15502(Messages$SessionCommand messages$SessionCommand, long l10) {
        messages$SessionCommand.lastPatchTime_ = l10;
        return l10;
    }

    public static /* synthetic */ long access$15602(Messages$SessionCommand messages$SessionCommand, long l10) {
        messages$SessionCommand.configBitmap_ = l10;
        return l10;
    }

    public static /* synthetic */ Messages$SystemInfo access$15702(Messages$SessionCommand messages$SessionCommand, Messages$SystemInfo messages$SystemInfo) {
        messages$SessionCommand.systemInfo_ = messages$SystemInfo;
        return messages$SystemInfo;
    }

    public static /* synthetic */ int access$15802(Messages$SessionCommand messages$SessionCommand, int n10) {
        messages$SessionCommand.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ UnknownFieldSet access$15900(Messages$SessionCommand messages$SessionCommand) {
        return messages$SessionCommand.unknownFields;
    }

    public static Messages$SessionCommand getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$13200();
    }

    public static Messages$SessionCommand$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$SessionCommand$Builder newBuilder(Messages$SessionCommand messages$SessionCommand) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$SessionCommand);
    }

    public static Messages$SessionCommand parseDelimitedFrom(InputStream inputStream) {
        return (Messages$SessionCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$SessionCommand parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$SessionCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$SessionCommand parseFrom(ByteString byteString) {
        return (Messages$SessionCommand)PARSER.parseFrom(byteString);
    }

    public static Messages$SessionCommand parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$SessionCommand)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$SessionCommand parseFrom(CodedInputStream codedInputStream) {
        return (Messages$SessionCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$SessionCommand parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$SessionCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$SessionCommand parseFrom(InputStream inputStream) {
        return (Messages$SessionCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$SessionCommand parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$SessionCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$SessionCommand parseFrom(ByteBuffer byteBuffer) {
        return (Messages$SessionCommand)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$SessionCommand parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$SessionCommand)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$SessionCommand parseFrom(byte[] byArray) {
        return (Messages$SessionCommand)PARSER.parseFrom(byArray);
    }

    public static Messages$SessionCommand parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$SessionCommand)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2;
        Object object2;
        long l10;
        long l11;
        Object object3;
        int n10;
        int n11 = 1;
        if (object == this) {
            return n11;
        }
        int n12 = object instanceof Messages$SessionCommand;
        if (!n12) {
            return super.equals(object);
        }
        object = (Messages$SessionCommand)object;
        n12 = this.hasT();
        if (n12 == (n10 = ((Messages$SessionCommand)object).hasT())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasT();
        if (n10 != 0) {
            long l12;
            if (n12 && !(n12 = (l12 = (l11 = this.getT()) - (l10 = ((Messages$SessionCommand)object).getT())) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = this.hasN()) == (n10 = ((Messages$SessionCommand)object).hasN())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasN();
        if (n10 != 0) {
            if (n12 && (n12 = ((String)(object3 = this.getN())).equals(object2 = ((Messages$SessionCommand)object).getN()))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = this.hasS()) == (n10 = ((Messages$SessionCommand)object).hasS())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasS();
        if (n10 != 0) {
            if (n12 && (n12 = ((String)(object3 = this.getS())).equals(object2 = ((Messages$SessionCommand)object).getS()))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = this.hasUa()) == (n10 = ((Messages$SessionCommand)object).hasUa())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasUa();
        if (n10 != 0) {
            if (n12 && (n12 = ((String)(object3 = this.getUa())).equals(object2 = ((Messages$SessionCommand)object).getUa()))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = this.hasR()) == (n10 = ((Messages$SessionCommand)object).hasR())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasR();
        if (n10 != 0) {
            if (n12 && (n12 = this.getR()) == (n10 = ((Messages$SessionCommand)object).getR())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = this.hasTag()) == (n10 = ((Messages$SessionCommand)object).hasTag())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasTag();
        if (n10 != 0) {
            if (n12 && (n12 = ((String)(object3 = this.getTag())).equals(object2 = ((Messages$SessionCommand)object).getTag()))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = this.hasDeviceId()) == (n10 = ((Messages$SessionCommand)object).hasDeviceId())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasDeviceId();
        if (n10 != 0) {
            if (n12 && (n12 = ((String)(object3 = this.getDeviceId())).equals(object2 = ((Messages$SessionCommand)object).getDeviceId()))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (object3 = this.getSessionPeerIdsList()).equals(object2 = ((Messages$SessionCommand)object).getSessionPeerIdsList()))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        if (n12 && (n12 = (object3 = this.getOnlineSessionPeerIdsList()).equals(object2 = ((Messages$SessionCommand)object).getOnlineSessionPeerIdsList()))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        if (n12 && (n12 = this.hasSt()) == (n10 = ((Messages$SessionCommand)object).hasSt())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasSt();
        if (n10 != 0) {
            if (n12 && (n12 = ((String)(object3 = this.getSt())).equals(object2 = ((Messages$SessionCommand)object).getSt()))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = this.hasStTtl()) == (n10 = ((Messages$SessionCommand)object).hasStTtl())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasStTtl();
        if (n10 != 0) {
            if (n12 && (n12 = this.getStTtl()) == (n10 = ((Messages$SessionCommand)object).getStTtl())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasCode() ? 1 : 0)) == (n10 = (int)(((Messages$SessionCommand)object).hasCode() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasCode() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = this.getCode()) == (n10 = ((Messages$SessionCommand)object).getCode())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasReason() ? 1 : 0)) == (n10 = (int)(((Messages$SessionCommand)object).hasReason() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasReason() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((String)(object3 = this.getReason())).equals(object2 = ((Messages$SessionCommand)object).getReason()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasDeviceToken() ? 1 : 0)) == (n10 = (int)(((Messages$SessionCommand)object).hasDeviceToken() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasDeviceToken() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((String)(object3 = this.getDeviceToken())).equals(object2 = ((Messages$SessionCommand)object).getDeviceToken()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasSp() ? 1 : 0)) == (n10 = (int)(((Messages$SessionCommand)object).hasSp() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasSp() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(this.getSp() ? 1 : 0)) == (n10 = (int)(((Messages$SessionCommand)object).getSp() ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasDetail() ? 1 : 0)) == (n10 = (int)(((Messages$SessionCommand)object).hasDetail() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasDetail() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((String)(object3 = this.getDetail())).equals(object2 = ((Messages$SessionCommand)object).getDetail()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasLastUnreadNotifTime() ? 1 : 0)) == (n10 = (int)(((Messages$SessionCommand)object).hasLastUnreadNotifTime() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasLastUnreadNotifTime() ? 1 : 0);
        if (n10 != 0) {
            long l13;
            if (n12 && !(n12 = (int)((l13 = (l11 = this.getLastUnreadNotifTime()) - (l10 = ((Messages$SessionCommand)object).getLastUnreadNotifTime())) == 0L ? 0 : (l13 < 0L ? -1 : 1)))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasLastPatchTime() ? 1 : 0)) == (n10 = (int)(((Messages$SessionCommand)object).hasLastPatchTime() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasLastPatchTime() ? 1 : 0);
        if (n10 != 0) {
            long l14;
            if (n12 && !(n12 = (int)((l14 = (l11 = this.getLastPatchTime()) - (l10 = ((Messages$SessionCommand)object).getLastPatchTime())) == 0L ? 0 : (l14 < 0L ? -1 : 1)))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasConfigBitmap() ? 1 : 0)) == (n10 = (int)(((Messages$SessionCommand)object).hasConfigBitmap() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasConfigBitmap() ? 1 : 0);
        if (n10 != 0) {
            long l15;
            if (n12 && !(n12 = (int)((l15 = (l11 = this.getConfigBitmap()) - (l10 = ((Messages$SessionCommand)object).getConfigBitmap())) == 0L ? 0 : (l15 < 0L ? -1 : 1)))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasSystemInfo() ? 1 : 0)) == (n10 = (int)(((Messages$SessionCommand)object).hasSystemInfo() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasSystemInfo() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = ((Messages$SystemInfo)(object3 = this.getSystemInfo())).equals(object2 = ((Messages$SessionCommand)object).getSystemInfo()))) {
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

    public int getCode() {
        return this.code_;
    }

    public long getConfigBitmap() {
        return this.configBitmap_;
    }

    public Messages$SessionCommand getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public String getDetail() {
        Object object = this.detail_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.detail_ = string2;
        }
        return string2;
    }

    public ByteString getDetailBytes() {
        Object object = this.detail_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.detail_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getDeviceId() {
        Object object = this.deviceId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.deviceId_ = string2;
        }
        return string2;
    }

    public ByteString getDeviceIdBytes() {
        Object object = this.deviceId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.deviceId_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getDeviceToken() {
        Object object = this.deviceToken_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.deviceToken_ = string2;
        }
        return string2;
    }

    public ByteString getDeviceTokenBytes() {
        Object object = this.deviceToken_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.deviceToken_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public long getLastPatchTime() {
        return this.lastPatchTime_;
    }

    public long getLastUnreadNotifTime() {
        return this.lastUnreadNotifTime_;
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

    public String getOnlineSessionPeerIds(int n10) {
        return (String)this.onlineSessionPeerIds_.get(n10);
    }

    public ByteString getOnlineSessionPeerIdsBytes(int n10) {
        return this.onlineSessionPeerIds_.getByteString(n10);
    }

    public int getOnlineSessionPeerIdsCount() {
        return this.onlineSessionPeerIds_.size();
    }

    public ProtocolStringList getOnlineSessionPeerIdsList() {
        return this.onlineSessionPeerIds_;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public boolean getR() {
        return this.r_;
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
        int n10;
        Object object2;
        Object object3;
        int n11 = this.memoizedSize;
        int n12 = -1;
        if (n11 != n12) {
            return n11;
        }
        n11 = this.bitField0_;
        n12 = 1;
        int n13 = 0;
        Object object4 = null;
        if ((n11 &= n12) == n12) {
            long l11 = this.t_;
            n11 = CodedOutputStream.computeInt64Size(n12, l11) + 0;
        } else {
            n11 = 0;
        }
        int n14 = this.bitField0_;
        int n15 = 2;
        if ((n14 &= n15) == n15) {
            object3 = this.n_;
            n14 = GeneratedMessageV3.computeStringSize(n15, object3);
            n11 += n14;
        }
        n14 = this.bitField0_;
        n15 = 4;
        if ((n14 &= n15) == n15) {
            object2 = this.s_;
            n14 = GeneratedMessageV3.computeStringSize(3, object2);
            n11 += n14;
        }
        n14 = this.bitField0_;
        int n16 = 8;
        if ((n14 &= n16) == n16) {
            object3 = this.ua_;
            n14 = GeneratedMessageV3.computeStringSize(n15, object3);
            n11 += n14;
        }
        n14 = this.bitField0_;
        n15 = 16;
        if ((n14 &= n15) == n15) {
            n16 = (int)(this.r_ ? 1 : 0);
            n14 = CodedOutputStream.computeBoolSize(5, n16 != 0);
            n11 += n14;
        }
        n14 = this.bitField0_;
        n16 = 32;
        if ((n14 &= n16) == n16) {
            object2 = this.tag_;
            n14 = GeneratedMessageV3.computeStringSize(6, object2);
            n11 += n14;
        }
        n14 = this.bitField0_;
        n16 = 64;
        if ((n14 &= n16) == n16) {
            object2 = this.deviceId_;
            n14 = GeneratedMessageV3.computeStringSize(7, object2);
            n11 += n14;
        }
        object3 = null;
        n16 = 0;
        object2 = null;
        for (n14 = 0; n14 < (n10 = (object = this.sessionPeerIds_).size()); ++n14) {
            object = this.sessionPeerIds_.getRaw(n14);
            n10 = GeneratedMessageV3.computeStringSizeNoTag(object);
            n16 += n10;
        }
        n11 += n16;
        n14 = this.getSessionPeerIdsList().size() * n12;
        n11 += n14;
        n14 = 0;
        object3 = null;
        while (n13 < (n16 = (object2 = this.onlineSessionPeerIds_).size())) {
            object2 = this.onlineSessionPeerIds_.getRaw(n13);
            n16 = GeneratedMessageV3.computeStringSizeNoTag(object2);
            n14 += n16;
            ++n13;
        }
        n11 += n14;
        object4 = this.getOnlineSessionPeerIdsList();
        n13 = object4.size() * n12;
        n11 += n13;
        n12 = this.bitField0_;
        n13 = 128;
        if ((n12 &= n13) == n13) {
            object4 = this.st_;
            n12 = GeneratedMessageV3.computeStringSize(10, object4);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n13 = 256;
        if ((n12 &= n13) == n13) {
            n13 = this.stTtl_;
            n12 = CodedOutputStream.computeInt32Size(11, n13);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n13 = 512;
        if ((n12 &= n13) == n13) {
            n13 = this.code_;
            n12 = CodedOutputStream.computeInt32Size(12, n13);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n13 = 1024;
        if ((n12 &= n13) == n13) {
            object4 = this.reason_;
            n12 = GeneratedMessageV3.computeStringSize(13, object4);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n13 = 2048;
        if ((n12 &= n13) == n13) {
            object4 = this.deviceToken_;
            n12 = GeneratedMessageV3.computeStringSize(14, object4);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n13 = 4096;
        if ((n12 &= n13) == n13) {
            n13 = (int)(this.sp_ ? 1 : 0);
            n12 = CodedOutputStream.computeBoolSize(15, n13 != 0);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n13 = 8192;
        if ((n12 &= n13) == n13) {
            Object object5 = this.detail_;
            n12 = GeneratedMessageV3.computeStringSize(n15, object5);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n13 = 16384;
        if ((n12 &= n13) == n13) {
            l10 = this.lastUnreadNotifTime_;
            n12 = CodedOutputStream.computeInt64Size(17, l10);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n13 = 32768;
        if ((n12 &= n13) == n13) {
            l10 = this.lastPatchTime_;
            n12 = CodedOutputStream.computeInt64Size(18, l10);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n13 = 65536;
        if ((n12 &= n13) == n13) {
            l10 = this.configBitmap_;
            n12 = CodedOutputStream.computeInt64Size(19, l10);
            n11 += n12;
        }
        n12 = this.bitField0_;
        n13 = 131072;
        if ((n12 &= n13) == n13) {
            object4 = this.getSystemInfo();
            n12 = CodedOutputStream.computeMessageSize(20, (MessageLite)object4);
            n11 += n12;
        }
        n12 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n11 += n12;
        return n11;
    }

    public String getSessionPeerIds(int n10) {
        return (String)this.sessionPeerIds_.get(n10);
    }

    public ByteString getSessionPeerIdsBytes(int n10) {
        return this.sessionPeerIds_.getByteString(n10);
    }

    public int getSessionPeerIdsCount() {
        return this.sessionPeerIds_.size();
    }

    public ProtocolStringList getSessionPeerIdsList() {
        return this.sessionPeerIds_;
    }

    public boolean getSp() {
        return this.sp_;
    }

    public String getSt() {
        Object object = this.st_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.st_ = string2;
        }
        return string2;
    }

    public ByteString getStBytes() {
        Object object = this.st_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.st_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public int getStTtl() {
        return this.stTtl_;
    }

    public Messages$SystemInfo getSystemInfo() {
        Messages$SystemInfo messages$SystemInfo = this.systemInfo_;
        if (messages$SystemInfo == null) {
            messages$SystemInfo = Messages$SystemInfo.getDefaultInstance();
        }
        return messages$SystemInfo;
    }

    public Messages$SystemInfoOrBuilder getSystemInfoOrBuilder() {
        Messages$SystemInfo messages$SystemInfo = this.systemInfo_;
        if (messages$SystemInfo == null) {
            messages$SystemInfo = Messages$SystemInfo.getDefaultInstance();
        }
        return messages$SystemInfo;
    }

    public long getT() {
        return this.t_;
    }

    public String getTag() {
        Object object = this.tag_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.tag_ = string2;
        }
        return string2;
    }

    public ByteString getTagBytes() {
        Object object = this.tag_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.tag_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getUa() {
        Object object = this.ua_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.ua_ = string2;
        }
        return string2;
    }

    public ByteString getUaBytes() {
        Object object = this.ua_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.ua_ = object = ByteString.copyFromUtf8((String)object);
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
    public boolean hasCode() {
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
    public boolean hasConfigBitmap() {
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
    public boolean hasDetail() {
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
    public boolean hasDeviceId() {
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
    public boolean hasDeviceToken() {
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
    public boolean hasLastPatchTime() {
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
    public boolean hasLastUnreadNotifTime() {
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
    public boolean hasN() {
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
    public boolean hasR() {
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
    public boolean hasReason() {
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
    public boolean hasS() {
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
    public boolean hasSp() {
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
    public boolean hasSt() {
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
    public boolean hasStTtl() {
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
    public boolean hasSystemInfo() {
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

    public boolean hasT() {
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
    public boolean hasTag() {
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
    public boolean hasUa() {
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

    public int hashCode() {
        long l10;
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = Messages$SessionCommand.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasT() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            l10 = this.getT();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasN() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getN();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasS() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            object = this.getS();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasUa() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 4) * 53;
            object = this.getUa();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasR() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 5) * 53;
            n11 = Internal.hashBoolean(this.getR());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasTag() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 6) * 53;
            object = this.getTag();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasDeviceId() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 7) * 53;
            object = this.getDeviceId();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = this.getSessionPeerIdsCount()) > 0) {
            n10 = (n10 * 37 + 8) * 53;
            object = this.getSessionPeerIdsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = this.getOnlineSessionPeerIdsCount()) > 0) {
            n10 = (n10 * 37 + 9) * 53;
            object = this.getOnlineSessionPeerIdsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasSt() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 10) * 53;
            object = this.getSt();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasStTtl() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 11) * 53;
            n11 = this.getStTtl();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasCode() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 12) * 53;
            n11 = this.getCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasReason() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 13) * 53;
            object = this.getReason();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasDeviceToken() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 14) * 53;
            object = this.getDeviceToken();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasSp() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 15) * 53;
            n11 = Internal.hashBoolean(this.getSp());
            n10 += n11;
        }
        if ((n11 = (int)(this.hasDetail() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 16) * 53;
            object = this.getDetail();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasLastUnreadNotifTime() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 17) * 53;
            l10 = this.getLastUnreadNotifTime();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasLastPatchTime() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 18) * 53;
            l10 = this.getLastPatchTime();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasConfigBitmap() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 19) * 53;
            l10 = this.getConfigBitmap();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasSystemInfo() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 20) * 53;
            object = this.getSystemInfo();
            n11 = ((Messages$SystemInfo)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$13300().ensureFieldAccessorsInitialized(Messages$SessionCommand.class, Messages$SessionCommand$Builder.class);
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

    public Messages$SessionCommand$Builder newBuilderForType() {
        return Messages$SessionCommand.newBuilder();
    }

    public Messages$SessionCommand$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$SessionCommand$Builder messages$SessionCommand$Builder = new Messages$SessionCommand$Builder(generatedMessageV3$BuilderParent, null);
        return messages$SessionCommand$Builder;
    }

    public Messages$SessionCommand$Builder toBuilder() {
        Messages$SessionCommandOrBuilder messages$SessionCommandOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$SessionCommandOrBuilder) {
            messages$SessionCommandOrBuilder = new Messages$SessionCommand$Builder(null);
        } else {
            messages$SessionCommandOrBuilder = new Messages$SessionCommand$Builder(null);
            messages$SessionCommandOrBuilder = ((Messages$SessionCommand$Builder)messages$SessionCommandOrBuilder).mergeFrom(this);
        }
        return messages$SessionCommandOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        long l10;
        Object object;
        int n10;
        Object object2;
        int n11;
        Object object3;
        Object object4;
        int n12 = this.bitField0_;
        int n13 = 1;
        if ((n12 &= n13) == n13) {
            long l11 = this.t_;
            codedOutputStream.writeInt64(n13, l11);
        }
        n12 = this.bitField0_;
        n13 = 2;
        if ((n12 &= n13) == n13) {
            object4 = this.n_;
            GeneratedMessageV3.writeString(codedOutputStream, n13, object4);
        }
        n12 = this.bitField0_;
        n13 = 4;
        if ((n12 &= n13) == n13) {
            n12 = 3;
            object3 = this.s_;
            GeneratedMessageV3.writeString(codedOutputStream, n12, object3);
        }
        n12 = this.bitField0_;
        int n14 = 8;
        if ((n12 &= n14) == n14) {
            object4 = this.ua_;
            GeneratedMessageV3.writeString(codedOutputStream, n13, object4);
        }
        n12 = this.bitField0_;
        n13 = 16;
        if ((n12 &= n13) == n13) {
            n12 = 5;
            n11 = this.r_;
            codedOutputStream.writeBool(n12, n11 != 0);
        }
        n12 = this.bitField0_;
        n11 = 32;
        if ((n12 &= n11) == n11) {
            n12 = 6;
            object2 = this.tag_;
            GeneratedMessageV3.writeString(codedOutputStream, n12, object2);
        }
        n12 = this.bitField0_;
        n11 = 64;
        if ((n12 &= n11) == n11) {
            n12 = 7;
            object2 = this.deviceId_;
            GeneratedMessageV3.writeString(codedOutputStream, n12, object2);
        }
        n12 = 0;
        object4 = null;
        object2 = null;
        for (n11 = 0; n11 < (n10 = (object = this.sessionPeerIds_).size()); ++n11) {
            object = this.sessionPeerIds_.getRaw(n11);
            GeneratedMessageV3.writeString(codedOutputStream, n14, object);
        }
        while (n12 < (n14 = (object3 = this.onlineSessionPeerIds_).size())) {
            n14 = 9;
            object2 = this.onlineSessionPeerIds_.getRaw(n12);
            GeneratedMessageV3.writeString(codedOutputStream, n14, object2);
            ++n12;
        }
        n12 = this.bitField0_;
        n14 = 128;
        if ((n12 &= n14) == n14) {
            n12 = 10;
            object3 = this.st_;
            GeneratedMessageV3.writeString(codedOutputStream, n12, object3);
        }
        n12 = this.bitField0_;
        n14 = 256;
        if ((n12 &= n14) == n14) {
            n12 = 11;
            n14 = this.stTtl_;
            codedOutputStream.writeInt32(n12, n14);
        }
        n12 = this.bitField0_;
        n14 = 512;
        if ((n12 &= n14) == n14) {
            n12 = 12;
            n14 = this.code_;
            codedOutputStream.writeInt32(n12, n14);
        }
        n12 = this.bitField0_;
        n14 = 1024;
        if ((n12 &= n14) == n14) {
            n12 = 13;
            object3 = this.reason_;
            GeneratedMessageV3.writeString(codedOutputStream, n12, object3);
        }
        n12 = this.bitField0_;
        n14 = 2048;
        if ((n12 &= n14) == n14) {
            n12 = 14;
            object3 = this.deviceToken_;
            GeneratedMessageV3.writeString(codedOutputStream, n12, object3);
        }
        n12 = this.bitField0_;
        n14 = 4096;
        if ((n12 &= n14) == n14) {
            n12 = 15;
            n14 = (int)(this.sp_ ? 1 : 0);
            codedOutputStream.writeBool(n12, n14 != 0);
        }
        n12 = this.bitField0_;
        n14 = 8192;
        if ((n12 &= n14) == n14) {
            object4 = this.detail_;
            GeneratedMessageV3.writeString(codedOutputStream, n13, object4);
        }
        n12 = this.bitField0_;
        n13 = 16384;
        if ((n12 &= n13) == n13) {
            n12 = 17;
            l10 = this.lastUnreadNotifTime_;
            codedOutputStream.writeInt64(n12, l10);
        }
        n12 = this.bitField0_;
        n13 = 32768;
        if ((n12 &= n13) == n13) {
            n12 = 18;
            l10 = this.lastPatchTime_;
            codedOutputStream.writeInt64(n12, l10);
        }
        n12 = this.bitField0_;
        n13 = 65536;
        if ((n12 &= n13) == n13) {
            n12 = 19;
            l10 = this.configBitmap_;
            codedOutputStream.writeInt64(n12, l10);
        }
        n12 = this.bitField0_;
        n13 = 131072;
        if ((n12 &= n13) == n13) {
            n12 = 20;
            Messages$SystemInfo messages$SystemInfo = this.getSystemInfo();
            codedOutputStream.writeMessage(n12, messages$SystemInfo);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

