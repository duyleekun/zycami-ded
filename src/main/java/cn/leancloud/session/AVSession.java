/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.AVException;
import cn.leancloud.AVLogger;
import cn.leancloud.cache.SystemSetting;
import cn.leancloud.command.CommandPacket;
import cn.leancloud.command.ConversationAckPacket;
import cn.leancloud.command.ConversationQueryPacket;
import cn.leancloud.command.SessionControlPacket;
import cn.leancloud.core.AppConfiguration;
import cn.leancloud.im.AVIMOptions;
import cn.leancloud.im.InternalConfiguration;
import cn.leancloud.im.OperationTube;
import cn.leancloud.im.SignatureTask;
import cn.leancloud.im.WindTalker;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMMessage;
import cn.leancloud.im.v2.Conversation$AVIMOperation;
import cn.leancloud.session.AVConnectionListener;
import cn.leancloud.session.AVConnectionManager;
import cn.leancloud.session.AVConversationHolder;
import cn.leancloud.session.AVDefaultConnectionListener;
import cn.leancloud.session.AVIMOperationQueue;
import cn.leancloud.session.AVIMOperationQueue$Operation;
import cn.leancloud.session.AVSession$1;
import cn.leancloud.session.AVSession$2;
import cn.leancloud.session.AVSession$3;
import cn.leancloud.session.AVSession$Status;
import cn.leancloud.session.AVSessionCacheHelper;
import cn.leancloud.session.AVSessionCacheHelper$IMSessionTokenCache;
import cn.leancloud.session.AVSessionCacheHelper$SessionTagCache;
import cn.leancloud.session.AVSessionListener;
import cn.leancloud.session.MessageReceiptCache;
import cn.leancloud.session.PendingMessageCache;
import cn.leancloud.session.PendingMessageCache$Message;
import cn.leancloud.session.PersistentQueue$HasId;
import cn.leancloud.session.RequestStormSuppression;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class AVSession {
    private static final String CREATE_CONV = "create";
    private static final String ERROR_INVALID_SESSION_ID = "Null id in session id list.";
    private static final AVLogger LOGGER = LogUtil.getLogger(AVSession.class);
    public static final int OPERATION_CLOSE_SESSION = 10005;
    public static final int OPERATION_OPEN_SESSION = 10004;
    public static final int OPERATION_UNKNOW = 255;
    public static final int REALTIME_TOKEN_WINDOW_INSECONDS = 300;
    private final String AVUSER_SESSION_TOKEN;
    private final String LAST_NOTIFY_TIME;
    private final String LAST_PATCH_TIME;
    public final AVConnectionManager connectionManager;
    private final ConcurrentMap conversationHolderCache;
    public AVIMOperationQueue conversationOperationCache;
    private volatile AVSession$Status currentStatus;
    private final String installationId;
    private long lastNotifyTime;
    private long lastPatchTime;
    private final AtomicLong lastServerAckReceived;
    public PendingMessageCache pendingMessages;
    private String realtimeSessionToken = null;
    private long realtimeSessionTokenExpired;
    private final String selfId;
    public final AVSessionListener sessionListener;
    private final AtomicBoolean sessionResume;
    private String tag;
    private String userSessionToken = null;
    private final AVConnectionListener websocketListener;

    public AVSession(AVConnectionManager aVConnectionManager, String object, String object2, AVSessionListener aVSessionListener) {
        ConcurrentHashMap concurrentHashMap;
        Object object3;
        long l10;
        this.LAST_NOTIFY_TIME = "lastNotifyTime";
        this.LAST_PATCH_TIME = "lastPatchTime";
        this.AVUSER_SESSION_TOKEN = "avuserSessionToken";
        this.realtimeSessionTokenExpired = l10 = 0L;
        this.lastNotifyTime = l10;
        this.lastPatchTime = l10;
        this.currentStatus = object3 = AVSession$Status.Closed;
        super(false);
        this.sessionResume = object3;
        super(l10);
        this.lastServerAckReceived = object3;
        this.conversationHolderCache = concurrentHashMap = new ConcurrentHashMap();
        this.selfId = object;
        this.installationId = object2;
        this.sessionListener = aVSessionListener;
        this.pendingMessages = object2 = new PendingMessageCache((String)object, PendingMessageCache$Message.class);
        this.conversationOperationCache = object2 = new AVIMOperationQueue((String)object);
        this.websocketListener = object = new AVDefaultConnectionListener(this);
        this.connectionManager = aVConnectionManager;
    }

    public static /* synthetic */ AVLogger access$000() {
        return LOGGER;
    }

    public static /* synthetic */ String access$100(AVSession aVSession) {
        return aVSession.installationId;
    }

    public static /* synthetic */ String access$200(AVSession aVSession) {
        return aVSession.tag;
    }

    public static /* synthetic */ String access$300(AVSession aVSession) {
        return aVSession.realtimeSessionToken;
    }

    public static /* synthetic */ String access$400(AVSession aVSession) {
        return aVSession.selfId;
    }

    private void openWithSessionToken(String object) {
        WindTalker windTalker = WindTalker.getInstance();
        String string2 = this.installationId;
        String string3 = this.getSelfPeerId();
        String string4 = this.tag;
        long l10 = this.getLastNotifyTime();
        long l11 = this.getLastPatchTime();
        object = windTalker.assembleSessionOpenPacket(string2, string3, string4, (String)object, l10, l11, true, null);
        this.connectionManager.sendPacket((CommandPacket)object);
    }

    private void openWithSignature(int n10, boolean bl2, boolean bl3) {
        AVSession$2 aVSession$2 = new AVSession$2(this, bl3, n10, bl2);
        String string2 = this.getSelfPeerId();
        SignatureTask signatureTask = new SignatureTask(aVSession$2, string2);
        signatureTask.start();
    }

    public AVException checkSessionStatus() {
        Object object = AVSession$Status.Closed;
        Object object2 = this.currentStatus;
        if (object == object2) {
            object = new AVException(119, "Please call AVIMClient.open() first");
            return object;
        }
        object = AVSession$Status.Resuming;
        object2 = this.currentStatus;
        if (object == object2) {
            object2 = new RuntimeException("Connecting to server");
            object = new AVException((Throwable)object2);
            return object;
        }
        object = this.connectionManager;
        boolean bl2 = ((AVConnectionManager)object).isConnectionEstablished();
        if (!bl2) {
            object2 = new RuntimeException("Connection Lost");
            object = new AVException((Throwable)object2);
            return object;
        }
        return null;
    }

    public void cleanUp() {
        this.updateRealtimeSessionToken("", 0);
        Object object = this.pendingMessages;
        if (object != null) {
            ((PendingMessageCache)object).clear();
        }
        if ((object = this.conversationOperationCache) != null) {
            ((AVIMOperationQueue)object).clear();
        }
        this.conversationHolderCache.clear();
        MessageReceiptCache.clean(this.getSelfPeerId());
    }

    public void close() {
        this.close(-65537);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close(int n10) {
        Object object;
        try {
            Object object2 = AVSessionCacheHelper.getTagCacheInstance();
            object = this.getSelfPeerId();
            ((AVSessionCacheHelper$SessionTagCache)object2).removeSession((String)object);
            object2 = this.getSelfPeerId();
            AVSessionCacheHelper$IMSessionTokenCache.removeIMSessionToken((String)object2);
            this.cleanUp();
            object2 = AVSession$Status.Closed;
            object = this.currentStatus;
            if (object2 == object) {
                object2 = this.sessionListener;
                ((AVSessionListener)object2).onSessionClose(this, n10);
                return;
            }
            object2 = this.connectionManager;
            boolean bl2 = ((AVConnectionManager)object2).isConnectionEstablished();
            if (bl2) {
                object2 = this.conversationOperationCache;
                object = Conversation$AVIMOperation.CLIENT_DISCONNECT;
                int n11 = ((Conversation$AVIMOperation)((Object)object)).getCode();
                Object object3 = this.selfId;
                String string2 = null;
                object = AVIMOperationQueue$Operation.getOperation(n11, (String)object3, null, n10);
                ((AVIMOperationQueue)object2).offer((AVIMOperationQueue$Operation)object);
                object3 = WindTalker.getInstance();
                string2 = this.installationId;
                String string3 = this.selfId;
                String string4 = "close";
                Integer n12 = n10;
                object2 = ((WindTalker)object3).assembleSessionPacket(string2, string3, null, string4, null, n12);
                object = this.connectionManager;
                ((AVConnectionManager)object).sendPacket((CommandPacket)object2);
                return;
            }
            object2 = this.sessionListener;
            ((AVSessionListener)object2).onSessionClose(this, n10);
            return;
        }
        catch (Exception exception) {
            object = this.sessionListener;
            int n13 = 10005;
            ((AVSessionListener)object).onError(this, exception, n13, n10);
        }
    }

    public void createConversation(List list, Map map, boolean bl2, boolean bl3, boolean bl4, int n10, boolean bl5, int n11) {
        AVSession$3 aVSession$3;
        Object object = this.connectionManager;
        boolean bl6 = ((AVConnectionManager)object).isConnectionEstablished();
        if (!bl6) {
            object = new RuntimeException("Connection Lost");
            AVSessionListener aVSessionListener = this.sessionListener;
            int n12 = Conversation$AVIMOperation.CONVERSATION_CREATION.getCode();
            aVSessionListener.onError(this, (Throwable)object, n12, n11);
            return;
        }
        object = aVSession$3;
        Object object2 = this;
        aVSession$3 = new AVSession$3(this, list, n11, map, bl2, bl3, bl4, n10, bl5);
        object2 = this.getSelfPeerId();
        object = new SignatureTask(aVSession$3, (String)object2);
        ((SignatureTask)object).start();
    }

    public AVConnectionManager getConnectionManager() {
        return this.connectionManager;
    }

    public AVConversationHolder getConversationHolder(String object, int n10) {
        Object object2 = (AVConversationHolder)this.conversationHolderCache.get(object);
        if (object2 != null) {
            return object2;
        }
        ConcurrentMap concurrentMap = this.conversationHolderCache;
        object2 = new AVConversationHolder((String)object, this, n10);
        if ((object = concurrentMap.putIfAbsent(object, object2)) != null) {
            object2 = object;
        }
        return object2;
    }

    public AVSession$Status getCurrentStatus() {
        return this.currentStatus;
    }

    public long getLastNotifyTime() {
        long l10 = this.lastNotifyTime;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            SystemSetting systemSetting = AppConfiguration.getDefaultSetting();
            String string2 = this.selfId;
            String string3 = "lastNotifyTime";
            this.lastNotifyTime = l10 = systemSetting.getLong(string2, string3, l11);
        }
        return this.lastNotifyTime;
    }

    public long getLastPatchTime() {
        long l10;
        long l11;
        SystemSetting systemSetting;
        long l12 = this.lastPatchTime;
        long l13 = 0L;
        long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        String string2 = "lastPatchTime";
        if (l14 <= 0) {
            systemSetting = AppConfiguration.getDefaultSetting();
            String string3 = this.selfId;
            this.lastPatchTime = l11 = systemSetting.getLong(string3, string2, l13);
        }
        if ((l14 = (l10 = (l11 = this.lastPatchTime) - l13) == 0L ? 0 : (l10 < 0L ? -1 : 1)) <= 0) {
            this.lastPatchTime = l13 = System.currentTimeMillis();
            systemSetting = AppConfiguration.getDefaultSetting();
            String string4 = this.selfId;
            long l15 = this.lastPatchTime;
            systemSetting.saveLong(string4, string2, l15);
        }
        return this.lastPatchTime;
    }

    public String getSelfPeerId() {
        return this.selfId;
    }

    public String getTag() {
        return this.tag;
    }

    public String getUserSessionToken() {
        Object object = this.userSessionToken;
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (bl2) {
            object = AppConfiguration.getDefaultSetting();
            String string2 = this.selfId;
            String string3 = "avuserSessionToken";
            String string4 = "";
            this.userSessionToken = object = object.getString(string2, string3, string4);
        }
        return this.userSessionToken;
    }

    public AVConnectionListener getWebSocketListener() {
        return this.websocketListener;
    }

    public boolean isResume() {
        return this.sessionResume.get();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void open(String string2, String object, boolean bl2, int n10) {
        this.tag = string2;
        this.updateUserSessionToken((String)object);
        int n11 = 10004;
        try {
            object = this.connectionManager;
            boolean bl3 = ((AVConnectionManager)object).isConnectionEstablished();
            if (!bl3) {
                object = this.sessionListener;
                String string3 = "Connection Lost";
                IllegalStateException illegalStateException = new IllegalStateException(string3);
                ((AVSessionListener)object).onError(this, illegalStateException, n11, n10);
                return;
            }
            object = AVSession$Status.Opened;
            AVSession$Status aVSession$Status = this.currentStatus;
            if (object == aVSession$Status) {
                object = this.sessionListener;
                ((AVSessionListener)object).onSessionOpen(this, n10);
                return;
            }
            bl3 = true;
            this.openWithSignature(n10, bl2, bl3);
            return;
        }
        catch (Exception exception) {
            AVSessionListener aVSessionListener = this.sessionListener;
            aVSessionListener.onError(this, exception, n11, n10);
        }
    }

    public void queryConversations(Map object, int n10, String object2) {
        Object object3 = AVSession$Status.Closed;
        Object object4 = this.currentStatus;
        if (object3 == object4) {
            RuntimeException runtimeException = new RuntimeException("Connection Lost");
            OperationTube operationTube = InternalConfiguration.getOperationTube();
            String string2 = this.getSelfPeerId();
            Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_QUERY;
            operationTube.onOperationCompleted(string2, null, n10, conversation$AVIMOperation, runtimeException);
            return;
        }
        int n11 = Conversation$AVIMOperation.CONVERSATION_QUERY.getCode();
        object4 = this.selfId;
        String string3 = null;
        object3 = AVIMOperationQueue$Operation.getOperation(n11, (String)object4, null, n10);
        ((AVIMOperationQueue$Operation)object3).setIdentifier((String)object2);
        this.conversationOperationCache.offer((AVIMOperationQueue$Operation)object3);
        object2 = RequestStormSuppression.getInstance();
        boolean bl2 = ((RequestStormSuppression)object2).postpone((AVIMOperationQueue$Operation)object3);
        object3 = ", selfId=";
        if (!bl2) {
            object2 = LOGGER;
            object4 = new StringBuilder();
            string3 = "[RequestSuppression] offer operation with requestId=";
            ((StringBuilder)object4).append(string3);
            ((StringBuilder)object4).append(n10);
            ((StringBuilder)object4).append((String)object3);
            object3 = this.selfId;
            ((StringBuilder)object4).append((String)object3);
            object3 = ((StringBuilder)object4).toString();
            ((AVLogger)object2).d((String)object3);
            object2 = this.getSelfPeerId();
            object = ConversationQueryPacket.getConversationQueryPacket((String)object2, (Map)object, n10);
            AVConnectionManager aVConnectionManager = this.connectionManager;
            aVConnectionManager.sendPacket((CommandPacket)object);
        } else {
            object = LOGGER;
            object2 = new StringBuilder();
            object4 = "[RequestSuppression] other request is running, pending current request(requestId=";
            ((StringBuilder)object2).append((String)object4);
            ((StringBuilder)object2).append(n10);
            ((StringBuilder)object2).append((String)object3);
            String string4 = this.selfId;
            ((StringBuilder)object2).append(string4);
            ((StringBuilder)object2).append(")");
            string4 = ((StringBuilder)object2).toString();
            ((AVLogger)object).d(string4);
        }
    }

    public void queryOnlinePeers(List object, int n10) {
        String string2 = this.installationId;
        String string3 = this.selfId;
        Integer n11 = n10;
        object = SessionControlPacket.genSessionCommand(string2, string3, (List)object, "query", null, n11);
        this.connectionManager.sendPacket((CommandPacket)object);
    }

    public boolean realtimeSessionTokenExpired() {
        long l10;
        long l11 = System.currentTimeMillis() / 1000L + 300L;
        long l12 = l11 - (l10 = this.realtimeSessionTokenExpired);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object >= 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public void removeConversation(String string2) {
        this.conversationHolderCache.remove(string2);
    }

    public void renewRealtimeSesionToken(int n10) {
        AVSession$1 aVSession$1 = new AVSession$1(this, n10);
        String string2 = this.getSelfPeerId();
        SignatureTask signatureTask = new SignatureTask(aVSession$1, string2);
        signatureTask.start();
    }

    public void reopen() {
        String string2 = AVSessionCacheHelper$IMSessionTokenCache.getIMSessionToken(this.getSelfPeerId());
        boolean bl2 = StringUtil.isEmpty(string2);
        if (!bl2) {
            this.openWithSessionToken(string2);
        } else {
            int n10 = WindTalker.getNextIMRequestId();
            bl2 = true;
            this.openWithSignature(n10, bl2, false);
        }
    }

    public void sendPacket(CommandPacket commandPacket) {
        this.connectionManager.sendPacket(commandPacket);
    }

    public void sendUnreadMessagesAck(ArrayList object, String object2) {
        int n10;
        Object object3 = AVIMOptions.getGlobalOptions();
        boolean n102 = ((AVIMOptions)object3).isOnlyPushCount();
        if (n102 && object != null && (n10 = ((ArrayList)object).size()) > 0) {
            Object object4;
            boolean bl2;
            long l10 = 0L;
            object3 = l10;
            object = ((ArrayList)object).iterator();
            while (bl2 = object.hasNext()) {
                long l11;
                object4 = (AVIMMessage)object.next();
                long l12 = (Long)object3;
                long l13 = l12 - (l11 = ((AVIMMessage)object4).getTimestamp());
                Object object5 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                if (object5 >= 0) continue;
                l10 = ((AVIMMessage)object4).getTimestamp();
                object3 = l10;
            }
            object = this.connectionManager;
            object4 = this.getSelfPeerId();
            object2 = ConversationAckPacket.getConversationAckPacket((String)object4, (String)object2, (Long)object3);
            ((AVConnectionManager)object).sendPacket((CommandPacket)object2);
        }
    }

    public void setServerAckReceived(long l10) {
        this.lastServerAckReceived.set(l10);
    }

    public boolean setSessionResume(boolean bl2) {
        return this.sessionResume.getAndSet(bl2);
    }

    public void setSessionStatus(AVSession$Status aVSession$Status) {
        this.currentStatus = aVSession$Status;
    }

    public void setTag(String string2) {
        this.tag = string2;
    }

    public void storeMessage(PendingMessageCache$Message object, int n10) {
        this.pendingMessages.offer((PersistentQueue$HasId)object);
        AVIMOperationQueue aVIMOperationQueue = this.conversationOperationCache;
        int n11 = Conversation$AVIMOperation.CONVERSATION_SEND_MESSAGE.getCode();
        String string2 = this.getSelfPeerId();
        object = ((PendingMessageCache$Message)object).cid;
        object = AVIMOperationQueue$Operation.getOperation(n11, string2, (String)object, n10);
        aVIMOperationQueue.offer((AVIMOperationQueue$Operation)object);
    }

    public void updateLastNotifyTime(long l10) {
        long l11 = this.getLastNotifyTime();
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            this.lastNotifyTime = l10;
            Object object2 = AVIMOptions.getGlobalOptions();
            object = ((AVIMOptions)object2).isAlwaysRetrieveAllNotification();
            if (object == false) {
                object2 = AppConfiguration.getDefaultSetting();
                String string2 = this.selfId;
                String string3 = "lastNotifyTime";
                object2.saveLong(string2, string3, l10);
            }
        }
    }

    public void updateLastPatchTime(long l10) {
        this.updateLastPatchTime(l10, false);
    }

    public void updateLastPatchTime(long l10, boolean object) {
        String string2 = "lastPatchTime";
        if (object != 0) {
            this.lastPatchTime = l10;
            SystemSetting systemSetting = AppConfiguration.getDefaultSetting();
            String string3 = this.selfId;
            systemSetting.saveLong(string3, string2, l10);
        } else {
            long l11 = this.getLastPatchTime();
            long l12 = l10 - l11;
            object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object > 0) {
                this.lastPatchTime = l10;
                SystemSetting systemSetting = AppConfiguration.getDefaultSetting();
                String string4 = this.selfId;
                systemSetting.saveLong(string4, string2, l10);
            }
        }
    }

    public void updateRealtimeSessionToken(String string2, int n10) {
        this.realtimeSessionToken = string2;
        long l10 = System.currentTimeMillis();
        long l11 = n10 * 1000;
        this.realtimeSessionTokenExpired = l10 += l11;
        Object object = AVIMClient.getInstance(this.getSelfPeerId());
        l10 = this.realtimeSessionTokenExpired;
        l11 = 1000L;
        ((AVIMClient)object).updateRealtimeSessionToken(string2, l10 /= l11);
        n10 = (int)(StringUtil.isEmpty(string2) ? 1 : 0);
        if (n10 != 0) {
            string2 = this.getSelfPeerId();
            AVSessionCacheHelper$IMSessionTokenCache.removeIMSessionToken(string2);
        } else {
            object = this.getSelfPeerId();
            l10 = this.realtimeSessionTokenExpired;
            AVSessionCacheHelper$IMSessionTokenCache.addIMSessionToken((String)object, string2, l10);
        }
    }

    public void updateUserSessionToken(String object) {
        this.userSessionToken = object;
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2) {
            object = AppConfiguration.getDefaultSetting();
            String string2 = this.selfId;
            String string3 = this.userSessionToken;
            String string4 = "avuserSessionToken";
            object.saveString(string2, string4, string3);
        }
    }
}

