/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.command;

import cn.leancloud.Messages$GenericCommand$Builder;
import cn.leancloud.Messages$OpType;
import cn.leancloud.Messages$SessionCommand;
import cn.leancloud.Messages$SessionCommand$Builder;
import cn.leancloud.command.PeerBasedCommandPacket;
import cn.leancloud.core.AppConfiguration;
import cn.leancloud.im.Signature;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.utils.StringUtil;
import java.util.Collection;
import java.util.List;

public class SessionControlPacket
extends PeerBasedCommandPacket {
    private static final long PATCH_FLAG = 1L;
    private static final long PATCH_FLAG_ACK_4_GROUPCHAT = 64L;
    private static final long PATCH_FLAG_ACK_4_TRANSIENT_MSG = 8L;
    private static final long PATCH_FLAG_BIND_INSTALLATION_TO_SESSION = 4L;
    private static final long PATCH_FLAG_OMIT_PEER_ID = 128L;
    private static final long PATCH_FLAG_SUPPORT_CONVMEMBER_INFO = 32L;
    private static final long PATCH_FLAG_SUPPORT_RELIABLE_NOTIFICATION = 16L;
    private static final long PATCH_FLAG_TEMPORARY_CONV = 2L;
    public static final String SESSION_COMMAND = "session";
    public String deviceId;
    private long lastPatchTime;
    private long lastUnreadNotifyTime;
    private String nonce;
    private String op;
    private boolean reconnectionRequest = false;
    private long sessionConfig;
    private Collection sessionPeerIds;
    public String sessionToken;
    private String signature;
    public String tag;
    private long timestamp;

    public SessionControlPacket() {
        long l10;
        this.lastUnreadNotifyTime = l10 = 0L;
        this.lastPatchTime = l10;
        this.sessionConfig = l10;
        this.setCmd(SESSION_COMMAND);
    }

    public static SessionControlPacket genSessionCommand(String string2, String string3, List list, String string4, Signature signature, long l10, long l11, Integer n10) {
        long l12;
        String string5;
        boolean bl2;
        SessionControlPacket sessionControlPacket = new SessionControlPacket();
        String string6 = "open";
        if (signature != null && ((bl2 = string4.equals(string6)) || (bl2 = string4.equals(string5 = "add")))) {
            long l13;
            sessionControlPacket.signature = string5 = signature.getSignature();
            sessionControlPacket.nonce = string5 = signature.getNonce();
            sessionControlPacket.timestamp = l13 = signature.getTimestamp();
        }
        sessionControlPacket.op = string4;
        sessionControlPacket.sessionPeerIds = list;
        sessionControlPacket.lastUnreadNotifyTime = l10;
        sessionControlPacket.lastPatchTime = l11;
        sessionControlPacket.sessionConfig = l12 = sessionControlPacket.sessionConfig | (long)11;
        long l14 = 160L;
        sessionControlPacket.sessionConfig = l12 |= l14;
        sessionControlPacket.setDeviceId(string2);
        string2 = "refresh";
        int n11 = string4.equals(string2);
        if (n11 != 0) {
            sessionControlPacket.setPeerId(string3);
        } else {
            n11 = string4.equals(string6);
            if (n11 != 0) {
                long l15 = sessionControlPacket.sessionConfig;
                l12 = 4;
                sessionControlPacket.sessionConfig = l15 |= l12;
                sessionControlPacket.setPeerId(string3);
            } else {
                int n12;
                n11 = AVIMClient.getClientsCount();
                if (n11 > (n12 = 1)) {
                    sessionControlPacket.setPeerId(string3);
                }
            }
        }
        if (n10 == null) {
            n11 = -65537;
            sessionControlPacket.setRequestId(n11);
        } else {
            n11 = n10;
            sessionControlPacket.setRequestId(n11);
        }
        return sessionControlPacket;
    }

    public static SessionControlPacket genSessionCommand(String string2, String string3, List list, String string4, Signature signature, Integer n10) {
        return SessionControlPacket.genSessionCommand(string2, string3, list, string4, signature, 0L, 0L, n10);
    }

    private Messages$SessionCommand getSessionCommand() {
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        long l15;
        long l16;
        String string2;
        boolean bl2;
        Messages$SessionCommand$Builder messages$SessionCommand$Builder = Messages$SessionCommand.newBuilder();
        Object object = this.sessionPeerIds;
        if (object != null && !(bl2 = object.isEmpty())) {
            object = this.sessionPeerIds;
            messages$SessionCommand$Builder.addAllSessionPeerIds((Iterable)object);
        }
        if (bl2 = ((String)(object = this.op)).equals(string2 = "open")) {
            object = AppConfiguration.getUserAgent();
            messages$SessionCommand$Builder.setUa((String)object);
            object = this.tag;
            bl2 = StringUtil.isEmpty((String)object);
            if (!bl2) {
                object = this.tag;
                messages$SessionCommand$Builder.setTag((String)object);
            }
        }
        if (((bl2 = ((String)(object = this.op)).equals(string2)) || (bl2 = ((String)(object = this.op)).equals(string2 = "close"))) && !(bl2 = StringUtil.isEmpty((String)(object = this.deviceId)))) {
            object = this.deviceId;
            messages$SessionCommand$Builder.setDeviceId((String)object);
        }
        if (!(bl2 = StringUtil.isEmpty((String)(object = this.signature)))) {
            object = this.signature;
            messages$SessionCommand$Builder.setS((String)object);
            l16 = this.timestamp;
            messages$SessionCommand$Builder.setT(l16);
            object = this.nonce;
            messages$SessionCommand$Builder.setN((String)object);
        }
        if (bl2 = this.reconnectionRequest) {
            bl2 = true;
            messages$SessionCommand$Builder.setR(bl2);
        }
        if ((l15 = (l14 = (l16 = this.lastUnreadNotifyTime) - (l13 = 0L)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) > 0) {
            messages$SessionCommand$Builder.setLastUnreadNotifTime(l16);
        }
        if ((l15 = (l12 = (l16 = this.lastPatchTime) - l13) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            messages$SessionCommand$Builder.setLastPatchTime(l16);
        }
        if (!(bl2 = StringUtil.isEmpty((String)(object = this.sessionToken)))) {
            object = this.sessionToken;
            messages$SessionCommand$Builder.setSt((String)object);
        }
        if ((l11 = (l10 = l13 - (l16 = this.sessionConfig)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            messages$SessionCommand$Builder.setConfigBitmap(l16);
        }
        return messages$SessionCommand$Builder.build();
    }

    public Messages$GenericCommand$Builder getGenericCommandBuilder() {
        Messages$GenericCommand$Builder messages$GenericCommand$Builder = super.getGenericCommandBuilder();
        Object object = Messages$OpType.valueOf(this.op);
        messages$GenericCommand$Builder.setOp((Messages$OpType)object);
        object = this.getSessionCommand();
        messages$GenericCommand$Builder.setSessionMessage((Messages$SessionCommand)object);
        return messages$GenericCommand$Builder;
    }

    public boolean isReconnectionRequest() {
        return this.reconnectionRequest;
    }

    public void setDeviceId(String string2) {
        this.deviceId = string2;
    }

    public void setReconnectionRequest(boolean bl2) {
        this.reconnectionRequest = bl2;
    }

    public void setSessionToken(String string2) {
        this.sessionToken = string2;
    }

    public void setTag(String string2) {
        this.tag = string2;
    }
}

