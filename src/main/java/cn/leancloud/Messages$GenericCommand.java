/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$AckCommand;
import cn.leancloud.Messages$AckCommandOrBuilder;
import cn.leancloud.Messages$BlacklistCommand;
import cn.leancloud.Messages$BlacklistCommandOrBuilder;
import cn.leancloud.Messages$CommandType;
import cn.leancloud.Messages$ConvCommand;
import cn.leancloud.Messages$ConvCommandOrBuilder;
import cn.leancloud.Messages$DataCommand;
import cn.leancloud.Messages$DataCommandOrBuilder;
import cn.leancloud.Messages$DirectCommand;
import cn.leancloud.Messages$DirectCommandOrBuilder;
import cn.leancloud.Messages$ErrorCommand;
import cn.leancloud.Messages$ErrorCommandOrBuilder;
import cn.leancloud.Messages$GenericCommand$1;
import cn.leancloud.Messages$GenericCommand$Builder;
import cn.leancloud.Messages$GenericCommandOrBuilder;
import cn.leancloud.Messages$LoggedinCommand;
import cn.leancloud.Messages$LoggedinCommandOrBuilder;
import cn.leancloud.Messages$LoginCommand;
import cn.leancloud.Messages$LoginCommandOrBuilder;
import cn.leancloud.Messages$LogsCommand;
import cn.leancloud.Messages$LogsCommandOrBuilder;
import cn.leancloud.Messages$OpType;
import cn.leancloud.Messages$PatchCommand;
import cn.leancloud.Messages$PatchCommandOrBuilder;
import cn.leancloud.Messages$PresenceCommand;
import cn.leancloud.Messages$PresenceCommandOrBuilder;
import cn.leancloud.Messages$PubsubCommand;
import cn.leancloud.Messages$PubsubCommandOrBuilder;
import cn.leancloud.Messages$RcpCommand;
import cn.leancloud.Messages$RcpCommandOrBuilder;
import cn.leancloud.Messages$ReadCommand;
import cn.leancloud.Messages$ReadCommandOrBuilder;
import cn.leancloud.Messages$ReportCommand;
import cn.leancloud.Messages$ReportCommandOrBuilder;
import cn.leancloud.Messages$RoomCommand;
import cn.leancloud.Messages$RoomCommandOrBuilder;
import cn.leancloud.Messages$SessionCommand;
import cn.leancloud.Messages$SessionCommandOrBuilder;
import cn.leancloud.Messages$UnreadCommand;
import cn.leancloud.Messages$UnreadCommandOrBuilder;
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

public final class Messages$GenericCommand
extends GeneratedMessageV3
implements Messages$GenericCommandOrBuilder {
    public static final int ACKMESSAGE_FIELD_NUMBER = 105;
    public static final int APPID_FIELD_NUMBER = 3;
    public static final int BLACKLISTMESSAGE_FIELD_NUMBER = 116;
    public static final int CLIENTTS_FIELD_NUMBER = 10;
    public static final int CMD_FIELD_NUMBER = 1;
    public static final int CONVMESSAGE_FIELD_NUMBER = 110;
    public static final int DATAMESSAGE_FIELD_NUMBER = 101;
    private static final Messages$GenericCommand DEFAULT_INSTANCE;
    public static final int DIRECTMESSAGE_FIELD_NUMBER = 104;
    public static final int ERRORMESSAGE_FIELD_NUMBER = 103;
    public static final int INSTALLATIONID_FIELD_NUMBER = 6;
    public static final int I_FIELD_NUMBER = 5;
    public static final int LOGGEDINMESSAGE_FIELD_NUMBER = 117;
    public static final int LOGINMESSAGE_FIELD_NUMBER = 100;
    public static final int LOGSMESSAGE_FIELD_NUMBER = 109;
    public static final int NOTIFICATIONTYPE_FIELD_NUMBER = 11;
    public static final int OP_FIELD_NUMBER = 2;
    public static final Parser PARSER;
    public static final int PATCHMESSAGE_FIELD_NUMBER = 114;
    public static final int PEERID_FIELD_NUMBER = 4;
    public static final int PRESENCEMESSAGE_FIELD_NUMBER = 112;
    public static final int PRIORITY_FIELD_NUMBER = 7;
    public static final int PUBSUBMESSAGE_FIELD_NUMBER = 115;
    public static final int RCPMESSAGE_FIELD_NUMBER = 108;
    public static final int READMESSAGE_FIELD_NUMBER = 107;
    public static final int REPORTMESSAGE_FIELD_NUMBER = 113;
    public static final int ROOMMESSAGE_FIELD_NUMBER = 111;
    public static final int SERVERTS_FIELD_NUMBER = 9;
    public static final int SERVICE_FIELD_NUMBER = 8;
    public static final int SESSIONMESSAGE_FIELD_NUMBER = 102;
    public static final int UNREADMESSAGE_FIELD_NUMBER = 106;
    private static final long serialVersionUID;
    private Messages$AckCommand ackMessage_;
    private volatile Object appId_;
    private int bitField0_;
    private Messages$BlacklistCommand blacklistMessage_;
    private long clientTs_;
    private int cmd_;
    private Messages$ConvCommand convMessage_;
    private Messages$DataCommand dataMessage_;
    private Messages$DirectCommand directMessage_;
    private Messages$ErrorCommand errorMessage_;
    private int i_;
    private volatile Object installationId_;
    private Messages$LoggedinCommand loggedinMessage_;
    private Messages$LoginCommand loginMessage_;
    private Messages$LogsCommand logsMessage_;
    private byte memoizedIsInitialized;
    private int notificationType_;
    private int op_;
    private Messages$PatchCommand patchMessage_;
    private volatile Object peerId_;
    private Messages$PresenceCommand presenceMessage_;
    private int priority_;
    private Messages$PubsubCommand pubsubMessage_;
    private Messages$RcpCommand rcpMessage_;
    private Messages$ReadCommand readMessage_;
    private Messages$ReportCommand reportMessage_;
    private Messages$RoomCommand roomMessage_;
    private long serverTs_;
    private int service_;
    private Messages$SessionCommand sessionMessage_;
    private Messages$UnreadCommand unreadMessage_;

    static {
        Object object = new Messages$GenericCommand();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$GenericCommand$1();
    }

    private Messages$GenericCommand() {
        long l10;
        this.memoizedIsInitialized = (byte)-1;
        this.cmd_ = 0;
        this.op_ = 1;
        String string2 = "";
        this.appId_ = string2;
        this.peerId_ = string2;
        this.i_ = 0;
        this.installationId_ = string2;
        this.priority_ = 0;
        this.service_ = 0;
        this.serverTs_ = l10 = 0L;
        this.clientTs_ = l10;
        this.notificationType_ = 0;
    }

    /*
     * Exception decompiling
     */
    private Messages$GenericCommand(CodedInputStream var1_1, ExtensionRegistryLite var2_7) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 194[TRYBLOCK] [798 : 2664->2667)] java.lang.Throwable
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

    public /* synthetic */ Messages$GenericCommand(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$GenericCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ Messages$GenericCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$47700() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ int access$47902(Messages$GenericCommand messages$GenericCommand, int n10) {
        messages$GenericCommand.cmd_ = n10;
        return n10;
    }

    public static /* synthetic */ int access$48002(Messages$GenericCommand messages$GenericCommand, int n10) {
        messages$GenericCommand.op_ = n10;
        return n10;
    }

    public static /* synthetic */ Object access$48100(Messages$GenericCommand messages$GenericCommand) {
        return messages$GenericCommand.appId_;
    }

    public static /* synthetic */ Object access$48102(Messages$GenericCommand messages$GenericCommand, Object object) {
        messages$GenericCommand.appId_ = object;
        return object;
    }

    public static /* synthetic */ Object access$48200(Messages$GenericCommand messages$GenericCommand) {
        return messages$GenericCommand.peerId_;
    }

    public static /* synthetic */ Object access$48202(Messages$GenericCommand messages$GenericCommand, Object object) {
        messages$GenericCommand.peerId_ = object;
        return object;
    }

    public static /* synthetic */ int access$48302(Messages$GenericCommand messages$GenericCommand, int n10) {
        messages$GenericCommand.i_ = n10;
        return n10;
    }

    public static /* synthetic */ Object access$48400(Messages$GenericCommand messages$GenericCommand) {
        return messages$GenericCommand.installationId_;
    }

    public static /* synthetic */ Object access$48402(Messages$GenericCommand messages$GenericCommand, Object object) {
        messages$GenericCommand.installationId_ = object;
        return object;
    }

    public static /* synthetic */ int access$48502(Messages$GenericCommand messages$GenericCommand, int n10) {
        messages$GenericCommand.priority_ = n10;
        return n10;
    }

    public static /* synthetic */ int access$48602(Messages$GenericCommand messages$GenericCommand, int n10) {
        messages$GenericCommand.service_ = n10;
        return n10;
    }

    public static /* synthetic */ long access$48702(Messages$GenericCommand messages$GenericCommand, long l10) {
        messages$GenericCommand.serverTs_ = l10;
        return l10;
    }

    public static /* synthetic */ long access$48802(Messages$GenericCommand messages$GenericCommand, long l10) {
        messages$GenericCommand.clientTs_ = l10;
        return l10;
    }

    public static /* synthetic */ int access$48902(Messages$GenericCommand messages$GenericCommand, int n10) {
        messages$GenericCommand.notificationType_ = n10;
        return n10;
    }

    public static /* synthetic */ Messages$LoginCommand access$49002(Messages$GenericCommand messages$GenericCommand, Messages$LoginCommand messages$LoginCommand) {
        messages$GenericCommand.loginMessage_ = messages$LoginCommand;
        return messages$LoginCommand;
    }

    public static /* synthetic */ Messages$DataCommand access$49102(Messages$GenericCommand messages$GenericCommand, Messages$DataCommand messages$DataCommand) {
        messages$GenericCommand.dataMessage_ = messages$DataCommand;
        return messages$DataCommand;
    }

    public static /* synthetic */ Messages$SessionCommand access$49202(Messages$GenericCommand messages$GenericCommand, Messages$SessionCommand messages$SessionCommand) {
        messages$GenericCommand.sessionMessage_ = messages$SessionCommand;
        return messages$SessionCommand;
    }

    public static /* synthetic */ Messages$ErrorCommand access$49302(Messages$GenericCommand messages$GenericCommand, Messages$ErrorCommand messages$ErrorCommand) {
        messages$GenericCommand.errorMessage_ = messages$ErrorCommand;
        return messages$ErrorCommand;
    }

    public static /* synthetic */ Messages$DirectCommand access$49402(Messages$GenericCommand messages$GenericCommand, Messages$DirectCommand messages$DirectCommand) {
        messages$GenericCommand.directMessage_ = messages$DirectCommand;
        return messages$DirectCommand;
    }

    public static /* synthetic */ Messages$AckCommand access$49502(Messages$GenericCommand messages$GenericCommand, Messages$AckCommand messages$AckCommand) {
        messages$GenericCommand.ackMessage_ = messages$AckCommand;
        return messages$AckCommand;
    }

    public static /* synthetic */ Messages$UnreadCommand access$49602(Messages$GenericCommand messages$GenericCommand, Messages$UnreadCommand messages$UnreadCommand) {
        messages$GenericCommand.unreadMessage_ = messages$UnreadCommand;
        return messages$UnreadCommand;
    }

    public static /* synthetic */ Messages$ReadCommand access$49702(Messages$GenericCommand messages$GenericCommand, Messages$ReadCommand messages$ReadCommand) {
        messages$GenericCommand.readMessage_ = messages$ReadCommand;
        return messages$ReadCommand;
    }

    public static /* synthetic */ Messages$RcpCommand access$49802(Messages$GenericCommand messages$GenericCommand, Messages$RcpCommand messages$RcpCommand) {
        messages$GenericCommand.rcpMessage_ = messages$RcpCommand;
        return messages$RcpCommand;
    }

    public static /* synthetic */ Messages$LogsCommand access$49902(Messages$GenericCommand messages$GenericCommand, Messages$LogsCommand messages$LogsCommand) {
        messages$GenericCommand.logsMessage_ = messages$LogsCommand;
        return messages$LogsCommand;
    }

    public static /* synthetic */ Messages$ConvCommand access$50002(Messages$GenericCommand messages$GenericCommand, Messages$ConvCommand messages$ConvCommand) {
        messages$GenericCommand.convMessage_ = messages$ConvCommand;
        return messages$ConvCommand;
    }

    public static /* synthetic */ Messages$RoomCommand access$50102(Messages$GenericCommand messages$GenericCommand, Messages$RoomCommand messages$RoomCommand) {
        messages$GenericCommand.roomMessage_ = messages$RoomCommand;
        return messages$RoomCommand;
    }

    public static /* synthetic */ Messages$PresenceCommand access$50202(Messages$GenericCommand messages$GenericCommand, Messages$PresenceCommand messages$PresenceCommand) {
        messages$GenericCommand.presenceMessage_ = messages$PresenceCommand;
        return messages$PresenceCommand;
    }

    public static /* synthetic */ Messages$ReportCommand access$50302(Messages$GenericCommand messages$GenericCommand, Messages$ReportCommand messages$ReportCommand) {
        messages$GenericCommand.reportMessage_ = messages$ReportCommand;
        return messages$ReportCommand;
    }

    public static /* synthetic */ Messages$PatchCommand access$50402(Messages$GenericCommand messages$GenericCommand, Messages$PatchCommand messages$PatchCommand) {
        messages$GenericCommand.patchMessage_ = messages$PatchCommand;
        return messages$PatchCommand;
    }

    public static /* synthetic */ Messages$PubsubCommand access$50502(Messages$GenericCommand messages$GenericCommand, Messages$PubsubCommand messages$PubsubCommand) {
        messages$GenericCommand.pubsubMessage_ = messages$PubsubCommand;
        return messages$PubsubCommand;
    }

    public static /* synthetic */ Messages$BlacklistCommand access$50602(Messages$GenericCommand messages$GenericCommand, Messages$BlacklistCommand messages$BlacklistCommand) {
        messages$GenericCommand.blacklistMessage_ = messages$BlacklistCommand;
        return messages$BlacklistCommand;
    }

    public static /* synthetic */ Messages$LoggedinCommand access$50702(Messages$GenericCommand messages$GenericCommand, Messages$LoggedinCommand messages$LoggedinCommand) {
        messages$GenericCommand.loggedinMessage_ = messages$LoggedinCommand;
        return messages$LoggedinCommand;
    }

    public static /* synthetic */ int access$50802(Messages$GenericCommand messages$GenericCommand, int n10) {
        messages$GenericCommand.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ UnknownFieldSet access$50900(Messages$GenericCommand messages$GenericCommand) {
        return messages$GenericCommand.unknownFields;
    }

    public static Messages$GenericCommand getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$47300();
    }

    public static Messages$GenericCommand$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$GenericCommand$Builder newBuilder(Messages$GenericCommand messages$GenericCommand) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$GenericCommand);
    }

    public static Messages$GenericCommand parseDelimitedFrom(InputStream inputStream) {
        return (Messages$GenericCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$GenericCommand parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$GenericCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$GenericCommand parseFrom(ByteString byteString) {
        return (Messages$GenericCommand)PARSER.parseFrom(byteString);
    }

    public static Messages$GenericCommand parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$GenericCommand)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$GenericCommand parseFrom(CodedInputStream codedInputStream) {
        return (Messages$GenericCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$GenericCommand parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$GenericCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$GenericCommand parseFrom(InputStream inputStream) {
        return (Messages$GenericCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$GenericCommand parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$GenericCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$GenericCommand parseFrom(ByteBuffer byteBuffer) {
        return (Messages$GenericCommand)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$GenericCommand parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$GenericCommand)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$GenericCommand parseFrom(byte[] byArray) {
        return (Messages$GenericCommand)PARSER.parseFrom(byArray);
    }

    public static Messages$GenericCommand parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$GenericCommand)PARSER.parseFrom(byArray, extensionRegistryLite);
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
        int n12 = object instanceof Messages$GenericCommand;
        if (!n12) {
            return super.equals(object);
        }
        object = (Messages$GenericCommand)object;
        n12 = this.hasCmd();
        if (n12 == (n10 = ((Messages$GenericCommand)object).hasCmd())) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = this.hasCmd();
        if (n10 != 0) {
            if (n12 && (n12 = this.cmd_) == (n10 = ((Messages$GenericCommand)object).cmd_)) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasOp() ? 1 : 0)) == (n10 = (int)(((Messages$GenericCommand)object).hasOp() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasOp() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = this.op_) == (n10 = ((Messages$GenericCommand)object).op_)) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasAppId() ? 1 : 0)) == (n10 = (int)(((Messages$GenericCommand)object).hasAppId() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasAppId() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((String)(object3 = this.getAppId())).equals(object2 = ((Messages$GenericCommand)object).getAppId()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasPeerId() ? 1 : 0)) == (n10 = (int)(((Messages$GenericCommand)object).hasPeerId() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasPeerId() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((String)(object3 = this.getPeerId())).equals(object2 = ((Messages$GenericCommand)object).getPeerId()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasI() ? 1 : 0)) == (n10 = (int)(((Messages$GenericCommand)object).hasI() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasI() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = this.getI()) == (n10 = ((Messages$GenericCommand)object).getI())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasInstallationId() ? 1 : 0)) == (n10 = (int)(((Messages$GenericCommand)object).hasInstallationId() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasInstallationId() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((String)(object3 = this.getInstallationId())).equals(object2 = ((Messages$GenericCommand)object).getInstallationId()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasPriority() ? 1 : 0)) == (n10 = (int)(((Messages$GenericCommand)object).hasPriority() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasPriority() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = this.getPriority()) == (n10 = ((Messages$GenericCommand)object).getPriority())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasService() ? 1 : 0)) == (n10 = (int)(((Messages$GenericCommand)object).hasService() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasService() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = this.getService()) == (n10 = ((Messages$GenericCommand)object).getService())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasServerTs() ? 1 : 0)) == (n10 = (int)(((Messages$GenericCommand)object).hasServerTs() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasServerTs() ? 1 : 0);
        if (n10 != 0) {
            long l12;
            if (n12 && !(n12 = (int)((l12 = (l11 = this.getServerTs()) - (l10 = ((Messages$GenericCommand)object).getServerTs())) == 0L ? 0 : (l12 < 0L ? -1 : 1)))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasClientTs() ? 1 : 0)) == (n10 = (int)(((Messages$GenericCommand)object).hasClientTs() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasClientTs() ? 1 : 0);
        if (n10 != 0) {
            long l13;
            if (n12 && !(n12 = (int)((l13 = (l11 = this.getClientTs()) - (l10 = ((Messages$GenericCommand)object).getClientTs())) == 0L ? 0 : (l13 < 0L ? -1 : 1)))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasNotificationType() ? 1 : 0)) == (n10 = (int)(((Messages$GenericCommand)object).hasNotificationType() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasNotificationType() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = this.getNotificationType()) == (n10 = ((Messages$GenericCommand)object).getNotificationType())) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasLoginMessage() ? 1 : 0)) == (n10 = (int)(((Messages$GenericCommand)object).hasLoginMessage() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasLoginMessage() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((Messages$LoginCommand)(object3 = this.getLoginMessage())).equals(object2 = ((Messages$GenericCommand)object).getLoginMessage()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasDataMessage() ? 1 : 0)) == (n10 = (int)(((Messages$GenericCommand)object).hasDataMessage() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasDataMessage() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((Messages$DataCommand)(object3 = this.getDataMessage())).equals(object2 = ((Messages$GenericCommand)object).getDataMessage()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasSessionMessage() ? 1 : 0)) == (n10 = (int)(((Messages$GenericCommand)object).hasSessionMessage() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasSessionMessage() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((Messages$SessionCommand)(object3 = this.getSessionMessage())).equals(object2 = ((Messages$GenericCommand)object).getSessionMessage()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasErrorMessage() ? 1 : 0)) == (n10 = (int)(((Messages$GenericCommand)object).hasErrorMessage() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasErrorMessage() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((Messages$ErrorCommand)(object3 = this.getErrorMessage())).equals(object2 = ((Messages$GenericCommand)object).getErrorMessage()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasDirectMessage() ? 1 : 0)) == (n10 = (int)(((Messages$GenericCommand)object).hasDirectMessage() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasDirectMessage() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((Messages$DirectCommand)(object3 = this.getDirectMessage())).equals(object2 = ((Messages$GenericCommand)object).getDirectMessage()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasAckMessage() ? 1 : 0)) == (n10 = (int)(((Messages$GenericCommand)object).hasAckMessage() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasAckMessage() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((Messages$AckCommand)(object3 = this.getAckMessage())).equals(object2 = ((Messages$GenericCommand)object).getAckMessage()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasUnreadMessage() ? 1 : 0)) == (n10 = (int)(((Messages$GenericCommand)object).hasUnreadMessage() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasUnreadMessage() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((Messages$UnreadCommand)(object3 = this.getUnreadMessage())).equals(object2 = ((Messages$GenericCommand)object).getUnreadMessage()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasReadMessage() ? 1 : 0)) == (n10 = (int)(((Messages$GenericCommand)object).hasReadMessage() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasReadMessage() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((Messages$ReadCommand)(object3 = this.getReadMessage())).equals(object2 = ((Messages$GenericCommand)object).getReadMessage()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasRcpMessage() ? 1 : 0)) == (n10 = (int)(((Messages$GenericCommand)object).hasRcpMessage() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasRcpMessage() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((Messages$RcpCommand)(object3 = this.getRcpMessage())).equals(object2 = ((Messages$GenericCommand)object).getRcpMessage()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasLogsMessage() ? 1 : 0)) == (n10 = (int)(((Messages$GenericCommand)object).hasLogsMessage() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasLogsMessage() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((Messages$LogsCommand)(object3 = this.getLogsMessage())).equals(object2 = ((Messages$GenericCommand)object).getLogsMessage()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasConvMessage() ? 1 : 0)) == (n10 = (int)(((Messages$GenericCommand)object).hasConvMessage() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasConvMessage() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((Messages$ConvCommand)(object3 = this.getConvMessage())).equals(object2 = ((Messages$GenericCommand)object).getConvMessage()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasRoomMessage() ? 1 : 0)) == (n10 = (int)(((Messages$GenericCommand)object).hasRoomMessage() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasRoomMessage() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((Messages$RoomCommand)(object3 = this.getRoomMessage())).equals(object2 = ((Messages$GenericCommand)object).getRoomMessage()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasPresenceMessage() ? 1 : 0)) == (n10 = (int)(((Messages$GenericCommand)object).hasPresenceMessage() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasPresenceMessage() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((Messages$PresenceCommand)(object3 = this.getPresenceMessage())).equals(object2 = ((Messages$GenericCommand)object).getPresenceMessage()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasReportMessage() ? 1 : 0)) == (n10 = (int)(((Messages$GenericCommand)object).hasReportMessage() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasReportMessage() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((Messages$ReportCommand)(object3 = this.getReportMessage())).equals(object2 = ((Messages$GenericCommand)object).getReportMessage()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasPatchMessage() ? 1 : 0)) == (n10 = (int)(((Messages$GenericCommand)object).hasPatchMessage() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasPatchMessage() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((Messages$PatchCommand)(object3 = this.getPatchMessage())).equals(object2 = ((Messages$GenericCommand)object).getPatchMessage()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasPubsubMessage() ? 1 : 0)) == (n10 = (int)(((Messages$GenericCommand)object).hasPubsubMessage() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasPubsubMessage() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((Messages$PubsubCommand)(object3 = this.getPubsubMessage())).equals(object2 = ((Messages$GenericCommand)object).getPubsubMessage()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasBlacklistMessage() ? 1 : 0)) == (n10 = (int)(((Messages$GenericCommand)object).hasBlacklistMessage() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasBlacklistMessage() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = (int)(((Messages$BlacklistCommand)(object3 = this.getBlacklistMessage())).equals(object2 = ((Messages$GenericCommand)object).getBlacklistMessage()) ? 1 : 0))) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        if (n12 && (n12 = (int)(this.hasLoggedinMessage() ? 1 : 0)) == (n10 = (int)(((Messages$GenericCommand)object).hasLoggedinMessage() ? 1 : 0))) {
            n12 = n11;
        } else {
            n12 = 0;
            object3 = null;
        }
        n10 = (int)(this.hasLoggedinMessage() ? 1 : 0);
        if (n10 != 0) {
            if (n12 && (n12 = ((Messages$LoggedinCommand)(object3 = this.getLoggedinMessage())).equals(object2 = ((Messages$GenericCommand)object).getLoggedinMessage()))) {
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

    public Messages$AckCommand getAckMessage() {
        Messages$AckCommand messages$AckCommand = this.ackMessage_;
        if (messages$AckCommand == null) {
            messages$AckCommand = Messages$AckCommand.getDefaultInstance();
        }
        return messages$AckCommand;
    }

    public Messages$AckCommandOrBuilder getAckMessageOrBuilder() {
        Messages$AckCommand messages$AckCommand = this.ackMessage_;
        if (messages$AckCommand == null) {
            messages$AckCommand = Messages$AckCommand.getDefaultInstance();
        }
        return messages$AckCommand;
    }

    public String getAppId() {
        Object object = this.appId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.appId_ = string2;
        }
        return string2;
    }

    public ByteString getAppIdBytes() {
        Object object = this.appId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.appId_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Messages$BlacklistCommand getBlacklistMessage() {
        Messages$BlacklistCommand messages$BlacklistCommand = this.blacklistMessage_;
        if (messages$BlacklistCommand == null) {
            messages$BlacklistCommand = Messages$BlacklistCommand.getDefaultInstance();
        }
        return messages$BlacklistCommand;
    }

    public Messages$BlacklistCommandOrBuilder getBlacklistMessageOrBuilder() {
        Messages$BlacklistCommand messages$BlacklistCommand = this.blacklistMessage_;
        if (messages$BlacklistCommand == null) {
            messages$BlacklistCommand = Messages$BlacklistCommand.getDefaultInstance();
        }
        return messages$BlacklistCommand;
    }

    public long getClientTs() {
        return this.clientTs_;
    }

    public Messages$CommandType getCmd() {
        int n10 = this.cmd_;
        Messages$CommandType messages$CommandType = Messages$CommandType.valueOf(n10);
        if (messages$CommandType == null) {
            messages$CommandType = Messages$CommandType.session;
        }
        return messages$CommandType;
    }

    public Messages$ConvCommand getConvMessage() {
        Messages$ConvCommand messages$ConvCommand = this.convMessage_;
        if (messages$ConvCommand == null) {
            messages$ConvCommand = Messages$ConvCommand.getDefaultInstance();
        }
        return messages$ConvCommand;
    }

    public Messages$ConvCommandOrBuilder getConvMessageOrBuilder() {
        Messages$ConvCommand messages$ConvCommand = this.convMessage_;
        if (messages$ConvCommand == null) {
            messages$ConvCommand = Messages$ConvCommand.getDefaultInstance();
        }
        return messages$ConvCommand;
    }

    public Messages$DataCommand getDataMessage() {
        Messages$DataCommand messages$DataCommand = this.dataMessage_;
        if (messages$DataCommand == null) {
            messages$DataCommand = Messages$DataCommand.getDefaultInstance();
        }
        return messages$DataCommand;
    }

    public Messages$DataCommandOrBuilder getDataMessageOrBuilder() {
        Messages$DataCommand messages$DataCommand = this.dataMessage_;
        if (messages$DataCommand == null) {
            messages$DataCommand = Messages$DataCommand.getDefaultInstance();
        }
        return messages$DataCommand;
    }

    public Messages$GenericCommand getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Messages$DirectCommand getDirectMessage() {
        Messages$DirectCommand messages$DirectCommand = this.directMessage_;
        if (messages$DirectCommand == null) {
            messages$DirectCommand = Messages$DirectCommand.getDefaultInstance();
        }
        return messages$DirectCommand;
    }

    public Messages$DirectCommandOrBuilder getDirectMessageOrBuilder() {
        Messages$DirectCommand messages$DirectCommand = this.directMessage_;
        if (messages$DirectCommand == null) {
            messages$DirectCommand = Messages$DirectCommand.getDefaultInstance();
        }
        return messages$DirectCommand;
    }

    public Messages$ErrorCommand getErrorMessage() {
        Messages$ErrorCommand messages$ErrorCommand = this.errorMessage_;
        if (messages$ErrorCommand == null) {
            messages$ErrorCommand = Messages$ErrorCommand.getDefaultInstance();
        }
        return messages$ErrorCommand;
    }

    public Messages$ErrorCommandOrBuilder getErrorMessageOrBuilder() {
        Messages$ErrorCommand messages$ErrorCommand = this.errorMessage_;
        if (messages$ErrorCommand == null) {
            messages$ErrorCommand = Messages$ErrorCommand.getDefaultInstance();
        }
        return messages$ErrorCommand;
    }

    public int getI() {
        return this.i_;
    }

    public String getInstallationId() {
        Object object = this.installationId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.installationId_ = string2;
        }
        return string2;
    }

    public ByteString getInstallationIdBytes() {
        Object object = this.installationId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.installationId_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Messages$LoggedinCommand getLoggedinMessage() {
        Messages$LoggedinCommand messages$LoggedinCommand = this.loggedinMessage_;
        if (messages$LoggedinCommand == null) {
            messages$LoggedinCommand = Messages$LoggedinCommand.getDefaultInstance();
        }
        return messages$LoggedinCommand;
    }

    public Messages$LoggedinCommandOrBuilder getLoggedinMessageOrBuilder() {
        Messages$LoggedinCommand messages$LoggedinCommand = this.loggedinMessage_;
        if (messages$LoggedinCommand == null) {
            messages$LoggedinCommand = Messages$LoggedinCommand.getDefaultInstance();
        }
        return messages$LoggedinCommand;
    }

    public Messages$LoginCommand getLoginMessage() {
        Messages$LoginCommand messages$LoginCommand = this.loginMessage_;
        if (messages$LoginCommand == null) {
            messages$LoginCommand = Messages$LoginCommand.getDefaultInstance();
        }
        return messages$LoginCommand;
    }

    public Messages$LoginCommandOrBuilder getLoginMessageOrBuilder() {
        Messages$LoginCommand messages$LoginCommand = this.loginMessage_;
        if (messages$LoginCommand == null) {
            messages$LoginCommand = Messages$LoginCommand.getDefaultInstance();
        }
        return messages$LoginCommand;
    }

    public Messages$LogsCommand getLogsMessage() {
        Messages$LogsCommand messages$LogsCommand = this.logsMessage_;
        if (messages$LogsCommand == null) {
            messages$LogsCommand = Messages$LogsCommand.getDefaultInstance();
        }
        return messages$LogsCommand;
    }

    public Messages$LogsCommandOrBuilder getLogsMessageOrBuilder() {
        Messages$LogsCommand messages$LogsCommand = this.logsMessage_;
        if (messages$LogsCommand == null) {
            messages$LogsCommand = Messages$LogsCommand.getDefaultInstance();
        }
        return messages$LogsCommand;
    }

    public int getNotificationType() {
        return this.notificationType_;
    }

    public Messages$OpType getOp() {
        int n10 = this.op_;
        Messages$OpType messages$OpType = Messages$OpType.valueOf(n10);
        if (messages$OpType == null) {
            messages$OpType = Messages$OpType.open;
        }
        return messages$OpType;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public Messages$PatchCommand getPatchMessage() {
        Messages$PatchCommand messages$PatchCommand = this.patchMessage_;
        if (messages$PatchCommand == null) {
            messages$PatchCommand = Messages$PatchCommand.getDefaultInstance();
        }
        return messages$PatchCommand;
    }

    public Messages$PatchCommandOrBuilder getPatchMessageOrBuilder() {
        Messages$PatchCommand messages$PatchCommand = this.patchMessage_;
        if (messages$PatchCommand == null) {
            messages$PatchCommand = Messages$PatchCommand.getDefaultInstance();
        }
        return messages$PatchCommand;
    }

    public String getPeerId() {
        Object object = this.peerId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.peerId_ = string2;
        }
        return string2;
    }

    public ByteString getPeerIdBytes() {
        Object object = this.peerId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.peerId_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Messages$PresenceCommand getPresenceMessage() {
        Messages$PresenceCommand messages$PresenceCommand = this.presenceMessage_;
        if (messages$PresenceCommand == null) {
            messages$PresenceCommand = Messages$PresenceCommand.getDefaultInstance();
        }
        return messages$PresenceCommand;
    }

    public Messages$PresenceCommandOrBuilder getPresenceMessageOrBuilder() {
        Messages$PresenceCommand messages$PresenceCommand = this.presenceMessage_;
        if (messages$PresenceCommand == null) {
            messages$PresenceCommand = Messages$PresenceCommand.getDefaultInstance();
        }
        return messages$PresenceCommand;
    }

    public int getPriority() {
        return this.priority_;
    }

    public Messages$PubsubCommand getPubsubMessage() {
        Messages$PubsubCommand messages$PubsubCommand = this.pubsubMessage_;
        if (messages$PubsubCommand == null) {
            messages$PubsubCommand = Messages$PubsubCommand.getDefaultInstance();
        }
        return messages$PubsubCommand;
    }

    public Messages$PubsubCommandOrBuilder getPubsubMessageOrBuilder() {
        Messages$PubsubCommand messages$PubsubCommand = this.pubsubMessage_;
        if (messages$PubsubCommand == null) {
            messages$PubsubCommand = Messages$PubsubCommand.getDefaultInstance();
        }
        return messages$PubsubCommand;
    }

    public Messages$RcpCommand getRcpMessage() {
        Messages$RcpCommand messages$RcpCommand = this.rcpMessage_;
        if (messages$RcpCommand == null) {
            messages$RcpCommand = Messages$RcpCommand.getDefaultInstance();
        }
        return messages$RcpCommand;
    }

    public Messages$RcpCommandOrBuilder getRcpMessageOrBuilder() {
        Messages$RcpCommand messages$RcpCommand = this.rcpMessage_;
        if (messages$RcpCommand == null) {
            messages$RcpCommand = Messages$RcpCommand.getDefaultInstance();
        }
        return messages$RcpCommand;
    }

    public Messages$ReadCommand getReadMessage() {
        Messages$ReadCommand messages$ReadCommand = this.readMessage_;
        if (messages$ReadCommand == null) {
            messages$ReadCommand = Messages$ReadCommand.getDefaultInstance();
        }
        return messages$ReadCommand;
    }

    public Messages$ReadCommandOrBuilder getReadMessageOrBuilder() {
        Messages$ReadCommand messages$ReadCommand = this.readMessage_;
        if (messages$ReadCommand == null) {
            messages$ReadCommand = Messages$ReadCommand.getDefaultInstance();
        }
        return messages$ReadCommand;
    }

    public Messages$ReportCommand getReportMessage() {
        Messages$ReportCommand messages$ReportCommand = this.reportMessage_;
        if (messages$ReportCommand == null) {
            messages$ReportCommand = Messages$ReportCommand.getDefaultInstance();
        }
        return messages$ReportCommand;
    }

    public Messages$ReportCommandOrBuilder getReportMessageOrBuilder() {
        Messages$ReportCommand messages$ReportCommand = this.reportMessage_;
        if (messages$ReportCommand == null) {
            messages$ReportCommand = Messages$ReportCommand.getDefaultInstance();
        }
        return messages$ReportCommand;
    }

    public Messages$RoomCommand getRoomMessage() {
        Messages$RoomCommand messages$RoomCommand = this.roomMessage_;
        if (messages$RoomCommand == null) {
            messages$RoomCommand = Messages$RoomCommand.getDefaultInstance();
        }
        return messages$RoomCommand;
    }

    public Messages$RoomCommandOrBuilder getRoomMessageOrBuilder() {
        Messages$RoomCommand messages$RoomCommand = this.roomMessage_;
        if (messages$RoomCommand == null) {
            messages$RoomCommand = Messages$RoomCommand.getDefaultInstance();
        }
        return messages$RoomCommand;
    }

    public int getSerializedSize() {
        long l10;
        Object object;
        int n10 = this.memoizedSize;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n10 = 0;
        n11 = this.bitField0_;
        int n12 = 1;
        if ((n11 &= n12) == n12) {
            n11 = this.cmd_;
            n11 = CodedOutputStream.computeEnumSize(n12, n11);
            n10 = 0 + n11;
        }
        n11 = this.bitField0_;
        n12 = 2;
        if ((n11 &= n12) == n12) {
            n11 = this.op_;
            n11 = CodedOutputStream.computeEnumSize(n12, n11);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 4;
        if ((n11 &= n12) == n12) {
            Object object2 = this.appId_;
            n11 = GeneratedMessageV3.computeStringSize(3, object2);
            n10 += n11;
        }
        n11 = this.bitField0_;
        int n13 = 8;
        if ((n11 &= n13) == n13) {
            Object object3 = this.peerId_;
            n11 = GeneratedMessageV3.computeStringSize(n12, object3);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 16;
        if ((n11 &= n12) == n12) {
            n12 = this.i_;
            n11 = CodedOutputStream.computeInt32Size(5, n12);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 32;
        if ((n11 &= n12) == n12) {
            object = this.installationId_;
            n11 = GeneratedMessageV3.computeStringSize(6, object);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 64;
        if ((n11 &= n12) == n12) {
            n12 = this.priority_;
            n11 = CodedOutputStream.computeInt32Size(7, n12);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 128;
        if ((n11 &= n12) == n12) {
            n11 = this.service_;
            n11 = CodedOutputStream.computeInt32Size(n13, n11);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 256;
        if ((n11 &= n12) == n12) {
            l10 = this.serverTs_;
            n11 = CodedOutputStream.computeInt64Size(9, l10);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 512;
        if ((n11 &= n12) == n12) {
            l10 = this.clientTs_;
            n11 = CodedOutputStream.computeInt64Size(10, l10);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 1024;
        if ((n11 &= n12) == n12) {
            n12 = this.notificationType_;
            n11 = CodedOutputStream.computeInt32Size(11, n12);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 2048;
        if ((n11 &= n12) == n12) {
            object = this.getLoginMessage();
            n11 = CodedOutputStream.computeMessageSize(100, (MessageLite)object);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 4096;
        if ((n11 &= n12) == n12) {
            object = this.getDataMessage();
            n11 = CodedOutputStream.computeMessageSize(101, (MessageLite)object);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 8192;
        if ((n11 &= n12) == n12) {
            object = this.getSessionMessage();
            n11 = CodedOutputStream.computeMessageSize(102, (MessageLite)object);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 16384;
        if ((n11 &= n12) == n12) {
            object = this.getErrorMessage();
            n11 = CodedOutputStream.computeMessageSize(103, (MessageLite)object);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 32768;
        if ((n11 &= n12) == n12) {
            object = this.getDirectMessage();
            n11 = CodedOutputStream.computeMessageSize(104, (MessageLite)object);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 65536;
        if ((n11 &= n12) == n12) {
            object = this.getAckMessage();
            n11 = CodedOutputStream.computeMessageSize(105, (MessageLite)object);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 131072;
        if ((n11 &= n12) == n12) {
            object = this.getUnreadMessage();
            n11 = CodedOutputStream.computeMessageSize(106, (MessageLite)object);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 262144;
        if ((n11 &= n12) == n12) {
            object = this.getReadMessage();
            n11 = CodedOutputStream.computeMessageSize(107, (MessageLite)object);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 524288;
        if ((n11 &= n12) == n12) {
            object = this.getRcpMessage();
            n11 = CodedOutputStream.computeMessageSize(108, (MessageLite)object);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 0x100000;
        if ((n11 &= n12) == n12) {
            object = this.getLogsMessage();
            n11 = CodedOutputStream.computeMessageSize(109, (MessageLite)object);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 0x200000;
        if ((n11 &= n12) == n12) {
            object = this.getConvMessage();
            n11 = CodedOutputStream.computeMessageSize(110, (MessageLite)object);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 0x400000;
        if ((n11 &= n12) == n12) {
            object = this.getRoomMessage();
            n11 = CodedOutputStream.computeMessageSize(111, (MessageLite)object);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 0x800000;
        if ((n11 &= n12) == n12) {
            object = this.getPresenceMessage();
            n11 = CodedOutputStream.computeMessageSize(112, (MessageLite)object);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 0x1000000;
        if ((n11 &= n12) == n12) {
            object = this.getReportMessage();
            n11 = CodedOutputStream.computeMessageSize(113, (MessageLite)object);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 0x2000000;
        if ((n11 &= n12) == n12) {
            object = this.getPatchMessage();
            n11 = CodedOutputStream.computeMessageSize(114, (MessageLite)object);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 0x4000000;
        if ((n11 &= n12) == n12) {
            object = this.getPubsubMessage();
            n11 = CodedOutputStream.computeMessageSize(115, (MessageLite)object);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 0x8000000;
        if ((n11 &= n12) == n12) {
            object = this.getBlacklistMessage();
            n11 = CodedOutputStream.computeMessageSize(116, (MessageLite)object);
            n10 += n11;
        }
        n11 = this.bitField0_;
        n12 = 0x10000000;
        if ((n11 &= n12) == n12) {
            object = this.getLoggedinMessage();
            n11 = CodedOutputStream.computeMessageSize(117, (MessageLite)object);
            n10 += n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public long getServerTs() {
        return this.serverTs_;
    }

    public int getService() {
        return this.service_;
    }

    public Messages$SessionCommand getSessionMessage() {
        Messages$SessionCommand messages$SessionCommand = this.sessionMessage_;
        if (messages$SessionCommand == null) {
            messages$SessionCommand = Messages$SessionCommand.getDefaultInstance();
        }
        return messages$SessionCommand;
    }

    public Messages$SessionCommandOrBuilder getSessionMessageOrBuilder() {
        Messages$SessionCommand messages$SessionCommand = this.sessionMessage_;
        if (messages$SessionCommand == null) {
            messages$SessionCommand = Messages$SessionCommand.getDefaultInstance();
        }
        return messages$SessionCommand;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public Messages$UnreadCommand getUnreadMessage() {
        Messages$UnreadCommand messages$UnreadCommand = this.unreadMessage_;
        if (messages$UnreadCommand == null) {
            messages$UnreadCommand = Messages$UnreadCommand.getDefaultInstance();
        }
        return messages$UnreadCommand;
    }

    public Messages$UnreadCommandOrBuilder getUnreadMessageOrBuilder() {
        Messages$UnreadCommand messages$UnreadCommand = this.unreadMessage_;
        if (messages$UnreadCommand == null) {
            messages$UnreadCommand = Messages$UnreadCommand.getDefaultInstance();
        }
        return messages$UnreadCommand;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasAckMessage() {
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
    public boolean hasAppId() {
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
    public boolean hasBlacklistMessage() {
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
    public boolean hasClientTs() {
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

    public boolean hasCmd() {
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
    public boolean hasConvMessage() {
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
    public boolean hasDataMessage() {
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
    public boolean hasDirectMessage() {
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
    public boolean hasErrorMessage() {
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
    public boolean hasI() {
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
    public boolean hasInstallationId() {
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
    public boolean hasLoggedinMessage() {
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

    /*
     * WARNING - void declaration
     */
    public boolean hasLoginMessage() {
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
    public boolean hasLogsMessage() {
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
    public boolean hasNotificationType() {
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
    public boolean hasOp() {
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
    public boolean hasPatchMessage() {
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
    public boolean hasPeerId() {
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
    public boolean hasPresenceMessage() {
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
    public boolean hasPriority() {
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
    public boolean hasPubsubMessage() {
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
    public boolean hasRcpMessage() {
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
    public boolean hasReadMessage() {
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
    public boolean hasReportMessage() {
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

    /*
     * WARNING - void declaration
     */
    public boolean hasRoomMessage() {
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
    public boolean hasServerTs() {
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
    public boolean hasService() {
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
    public boolean hasSessionMessage() {
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
    public boolean hasUnreadMessage() {
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

    public int hashCode() {
        long l10;
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = Messages$GenericCommand.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasCmd() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            n11 = this.cmd_;
            n10 += n11;
        }
        if ((n11 = (int)(this.hasOp() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            n11 = this.op_;
            n10 += n11;
        }
        if ((n11 = (int)(this.hasAppId() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            object = this.getAppId();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasPeerId() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 4) * 53;
            object = this.getPeerId();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasI() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 5) * 53;
            n11 = this.getI();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasInstallationId() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 6) * 53;
            object = this.getInstallationId();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasPriority() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 7) * 53;
            n11 = this.getPriority();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasService() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 8) * 53;
            n11 = this.getService();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasServerTs() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 9) * 53;
            l10 = this.getServerTs();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasClientTs() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 10) * 53;
            l10 = this.getClientTs();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasNotificationType() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 11) * 53;
            n11 = this.getNotificationType();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasLoginMessage() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 100) * 53;
            object = this.getLoginMessage();
            n11 = ((Messages$LoginCommand)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasDataMessage() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 101) * 53;
            object = this.getDataMessage();
            n11 = ((Messages$DataCommand)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasSessionMessage() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 102) * 53;
            object = this.getSessionMessage();
            n11 = ((Messages$SessionCommand)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasErrorMessage() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 103) * 53;
            object = this.getErrorMessage();
            n11 = ((Messages$ErrorCommand)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasDirectMessage() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 104) * 53;
            object = this.getDirectMessage();
            n11 = ((Messages$DirectCommand)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasAckMessage() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 105) * 53;
            object = this.getAckMessage();
            n11 = ((Messages$AckCommand)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasUnreadMessage() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 106) * 53;
            object = this.getUnreadMessage();
            n11 = ((Messages$UnreadCommand)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasReadMessage() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 107) * 53;
            object = this.getReadMessage();
            n11 = ((Messages$ReadCommand)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasRcpMessage() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 108) * 53;
            object = this.getRcpMessage();
            n11 = ((Messages$RcpCommand)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasLogsMessage() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 109) * 53;
            object = this.getLogsMessage();
            n11 = ((Messages$LogsCommand)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasConvMessage() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 110) * 53;
            object = this.getConvMessage();
            n11 = ((Messages$ConvCommand)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasRoomMessage() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 111) * 53;
            object = this.getRoomMessage();
            n11 = ((Messages$RoomCommand)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasPresenceMessage() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 112) * 53;
            object = this.getPresenceMessage();
            n11 = ((Messages$PresenceCommand)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasReportMessage() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 113) * 53;
            object = this.getReportMessage();
            n11 = ((Messages$ReportCommand)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasPatchMessage() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 114) * 53;
            object = this.getPatchMessage();
            n11 = ((Messages$PatchCommand)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasPubsubMessage() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 115) * 53;
            object = this.getPubsubMessage();
            n11 = ((Messages$PubsubCommand)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasBlacklistMessage() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 116) * 53;
            object = this.getBlacklistMessage();
            n11 = ((Messages$BlacklistCommand)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasLoggedinMessage() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 117) * 53;
            object = this.getLoggedinMessage();
            n11 = ((Messages$LoggedinCommand)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$47400().ensureFieldAccessorsInitialized(Messages$GenericCommand.class, Messages$GenericCommand$Builder.class);
    }

    public final boolean isInitialized() {
        GeneratedMessageV3 generatedMessageV3;
        byte by2 = this.memoizedIsInitialized;
        byte by3 = 1;
        if (by2 == by3) {
            return by3 != 0;
        }
        if (!by2) {
            return false;
        }
        by2 = this.hasDataMessage();
        if (by2 && !(by2 = ((Messages$DataCommand)(generatedMessageV3 = this.getDataMessage())).isInitialized())) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        by2 = this.hasErrorMessage();
        if (by2 && !(by2 = ((Messages$ErrorCommand)(generatedMessageV3 = this.getErrorMessage())).isInitialized())) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        by2 = this.hasUnreadMessage();
        if (by2 && !(by2 = ((Messages$UnreadCommand)(generatedMessageV3 = this.getUnreadMessage())).isInitialized())) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        by2 = this.hasReadMessage();
        if (by2 && !(by2 = ((Messages$ReadCommand)(generatedMessageV3 = this.getReadMessage())).isInitialized())) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        by2 = this.hasConvMessage();
        if (by2 && !(by2 = ((Messages$ConvCommand)(generatedMessageV3 = this.getConvMessage())).isInitialized())) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        by2 = this.hasPubsubMessage();
        if (by2 && !(by2 = ((Messages$PubsubCommand)(generatedMessageV3 = this.getPubsubMessage())).isInitialized())) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        by2 = this.hasBlacklistMessage();
        if (by2 && !(by2 = ((Messages$BlacklistCommand)(generatedMessageV3 = this.getBlacklistMessage())).isInitialized())) {
            this.memoizedIsInitialized = 0;
            return false;
        }
        this.memoizedIsInitialized = by3;
        return by3 != 0;
    }

    public Messages$GenericCommand$Builder newBuilderForType() {
        return Messages$GenericCommand.newBuilder();
    }

    public Messages$GenericCommand$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$GenericCommand$Builder messages$GenericCommand$Builder = new Messages$GenericCommand$Builder(generatedMessageV3$BuilderParent, null);
        return messages$GenericCommand$Builder;
    }

    public Messages$GenericCommand$Builder toBuilder() {
        Messages$GenericCommandOrBuilder messages$GenericCommandOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$GenericCommandOrBuilder) {
            messages$GenericCommandOrBuilder = new Messages$GenericCommand$Builder(null);
        } else {
            messages$GenericCommandOrBuilder = new Messages$GenericCommand$Builder(null);
            messages$GenericCommandOrBuilder = ((Messages$GenericCommand$Builder)messages$GenericCommandOrBuilder).mergeFrom(this);
        }
        return messages$GenericCommandOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        long l10;
        Object object;
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == n11) {
            n10 = this.cmd_;
            codedOutputStream.writeEnum(n11, n10);
        }
        n10 = this.bitField0_;
        n11 = 2;
        if ((n10 &= n11) == n11) {
            n10 = this.op_;
            codedOutputStream.writeEnum(n11, n10);
        }
        n10 = this.bitField0_;
        n11 = 4;
        if ((n10 &= n11) == n11) {
            n10 = 3;
            Object object2 = this.appId_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object2);
        }
        n10 = this.bitField0_;
        int n12 = 8;
        if ((n10 &= n12) == n12) {
            Object object3 = this.peerId_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object3);
        }
        n10 = this.bitField0_;
        n11 = 16;
        if ((n10 &= n11) == n11) {
            n10 = 5;
            n11 = this.i_;
            codedOutputStream.writeInt32(n10, n11);
        }
        n10 = this.bitField0_;
        n11 = 32;
        if ((n10 &= n11) == n11) {
            n10 = 6;
            object = this.installationId_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object);
        }
        n10 = this.bitField0_;
        n11 = 64;
        if ((n10 &= n11) == n11) {
            n10 = 7;
            n11 = this.priority_;
            codedOutputStream.writeInt32(n10, n11);
        }
        n10 = this.bitField0_;
        n11 = 128;
        if ((n10 &= n11) == n11) {
            n10 = this.service_;
            codedOutputStream.writeInt32(n12, n10);
        }
        n10 = this.bitField0_;
        n11 = 256;
        if ((n10 &= n11) == n11) {
            n10 = 9;
            l10 = this.serverTs_;
            codedOutputStream.writeInt64(n10, l10);
        }
        n10 = this.bitField0_;
        n11 = 512;
        if ((n10 &= n11) == n11) {
            n10 = 10;
            l10 = this.clientTs_;
            codedOutputStream.writeInt64(n10, l10);
        }
        n10 = this.bitField0_;
        n11 = 1024;
        if ((n10 &= n11) == n11) {
            n10 = 11;
            n11 = this.notificationType_;
            codedOutputStream.writeInt32(n10, n11);
        }
        n10 = this.bitField0_;
        n11 = 2048;
        if ((n10 &= n11) == n11) {
            n10 = 100;
            object = this.getLoginMessage();
            codedOutputStream.writeMessage(n10, (MessageLite)object);
        }
        n10 = this.bitField0_;
        n11 = 4096;
        if ((n10 &= n11) == n11) {
            n10 = 101;
            object = this.getDataMessage();
            codedOutputStream.writeMessage(n10, (MessageLite)object);
        }
        n10 = this.bitField0_;
        n11 = 8192;
        if ((n10 &= n11) == n11) {
            n10 = 102;
            object = this.getSessionMessage();
            codedOutputStream.writeMessage(n10, (MessageLite)object);
        }
        n10 = this.bitField0_;
        n11 = 16384;
        if ((n10 &= n11) == n11) {
            n10 = 103;
            object = this.getErrorMessage();
            codedOutputStream.writeMessage(n10, (MessageLite)object);
        }
        n10 = this.bitField0_;
        n11 = 32768;
        if ((n10 &= n11) == n11) {
            n10 = 104;
            object = this.getDirectMessage();
            codedOutputStream.writeMessage(n10, (MessageLite)object);
        }
        n10 = this.bitField0_;
        n11 = 65536;
        if ((n10 &= n11) == n11) {
            n10 = 105;
            object = this.getAckMessage();
            codedOutputStream.writeMessage(n10, (MessageLite)object);
        }
        n10 = this.bitField0_;
        n11 = 131072;
        if ((n10 &= n11) == n11) {
            n10 = 106;
            object = this.getUnreadMessage();
            codedOutputStream.writeMessage(n10, (MessageLite)object);
        }
        n10 = this.bitField0_;
        n11 = 262144;
        if ((n10 &= n11) == n11) {
            n10 = 107;
            object = this.getReadMessage();
            codedOutputStream.writeMessage(n10, (MessageLite)object);
        }
        n10 = this.bitField0_;
        n11 = 524288;
        if ((n10 &= n11) == n11) {
            n10 = 108;
            object = this.getRcpMessage();
            codedOutputStream.writeMessage(n10, (MessageLite)object);
        }
        n10 = this.bitField0_;
        n11 = 0x100000;
        if ((n10 &= n11) == n11) {
            n10 = 109;
            object = this.getLogsMessage();
            codedOutputStream.writeMessage(n10, (MessageLite)object);
        }
        n10 = this.bitField0_;
        n11 = 0x200000;
        if ((n10 &= n11) == n11) {
            n10 = 110;
            object = this.getConvMessage();
            codedOutputStream.writeMessage(n10, (MessageLite)object);
        }
        n10 = this.bitField0_;
        n11 = 0x400000;
        if ((n10 &= n11) == n11) {
            n10 = 111;
            object = this.getRoomMessage();
            codedOutputStream.writeMessage(n10, (MessageLite)object);
        }
        n10 = this.bitField0_;
        n11 = 0x800000;
        if ((n10 &= n11) == n11) {
            n10 = 112;
            object = this.getPresenceMessage();
            codedOutputStream.writeMessage(n10, (MessageLite)object);
        }
        n10 = this.bitField0_;
        n11 = 0x1000000;
        if ((n10 &= n11) == n11) {
            n10 = 113;
            object = this.getReportMessage();
            codedOutputStream.writeMessage(n10, (MessageLite)object);
        }
        n10 = this.bitField0_;
        n11 = 0x2000000;
        if ((n10 &= n11) == n11) {
            n10 = 114;
            object = this.getPatchMessage();
            codedOutputStream.writeMessage(n10, (MessageLite)object);
        }
        n10 = this.bitField0_;
        n11 = 0x4000000;
        if ((n10 &= n11) == n11) {
            n10 = 115;
            object = this.getPubsubMessage();
            codedOutputStream.writeMessage(n10, (MessageLite)object);
        }
        n10 = this.bitField0_;
        n11 = 0x8000000;
        if ((n10 &= n11) == n11) {
            n10 = 116;
            object = this.getBlacklistMessage();
            codedOutputStream.writeMessage(n10, (MessageLite)object);
        }
        n10 = this.bitField0_;
        n11 = 0x10000000;
        if ((n10 &= n11) == n11) {
            n10 = 117;
            object = this.getLoggedinMessage();
            codedOutputStream.writeMessage(n10, (MessageLite)object);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

