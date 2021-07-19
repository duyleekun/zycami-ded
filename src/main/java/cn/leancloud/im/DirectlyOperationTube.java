/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im;

import cn.leancloud.AVException;
import cn.leancloud.AVLogger;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.codec.MDFive;
import cn.leancloud.im.DirectlyOperationTube$1;
import cn.leancloud.im.OperationTube;
import cn.leancloud.im.RequestCache;
import cn.leancloud.im.WindTalker;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMClient$AVIMClientStatus;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.AVIMMessage;
import cn.leancloud.im.v2.AVIMMessageOption;
import cn.leancloud.im.v2.Conversation$AVIMOperation;
import cn.leancloud.im.v2.callback.AVIMClientCallback;
import cn.leancloud.im.v2.callback.AVIMClientStatusCallback;
import cn.leancloud.im.v2.callback.AVIMCommonJsonCallback;
import cn.leancloud.im.v2.callback.AVIMConversationCallback;
import cn.leancloud.im.v2.callback.AVIMConversationIterableResult;
import cn.leancloud.im.v2.callback.AVIMConversationIterableResultCallback;
import cn.leancloud.im.v2.callback.AVIMMessagesQueryCallback;
import cn.leancloud.im.v2.callback.AVIMOnlineClientsCallback;
import cn.leancloud.json.JSON;
import cn.leancloud.livequery.AVLiveQuerySubscribeCallback;
import cn.leancloud.livequery.LiveQueryOperationDelegate;
import cn.leancloud.session.AVConnectionManager;
import cn.leancloud.session.AVConversationHolder;
import cn.leancloud.session.AVSession;
import cn.leancloud.session.AVSession$Status;
import cn.leancloud.session.AVSessionManager;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectlyOperationTube
implements OperationTube {
    private static final AVLogger LOGGER = LogUtil.getLogger(DirectlyOperationTube.class);
    private final boolean needCacheRequestKey;

    public DirectlyOperationTube(boolean bl2) {
        this.needCacheRequestKey = bl2;
    }

    private AVCallback getCachedCallback(String string2, String string3, int n10, Conversation$AVIMOperation conversation$AVIMOperation) {
        return RequestCache.getInstance().getRequestCallback(string2, null, n10);
    }

    private String getInstallationId(String object) {
        if ((object = AVIMClient.peekInstance((String)object)) != null) {
            return ((AVIMClient)object).getInstallationId();
        }
        return null;
    }

    public boolean closeClient(AVConnectionManager aVConnectionManager, String string2, AVIMClientCallback aVIMClientCallback) {
        AVLogger aVLogger = LOGGER;
        Object object = "closeClient...";
        aVLogger.d((String)object);
        int n10 = WindTalker.getNextIMRequestId();
        boolean bl2 = this.needCacheRequestKey;
        if (bl2) {
            object = RequestCache.getInstance();
            ((RequestCache)object).addRequestCallback(string2, null, n10, aVIMClientCallback);
        }
        return this.closeClientDirectly(aVConnectionManager, string2, n10);
    }

    public boolean closeClientDirectly(AVConnectionManager aVConnectionManager, String string2, int n10) {
        String string3 = this.getInstallationId(string2);
        AVSessionManager.getInstance().getOrCreateSession(string2, string3, aVConnectionManager).close(n10);
        return true;
    }

    public boolean createConversation(AVConnectionManager aVConnectionManager, String string2, List list, Map map, boolean bl2, boolean bl3, boolean bl4, int n10, AVIMCommonJsonCallback aVIMCommonJsonCallback) {
        int n11;
        block0: {
            Object object = LOGGER;
            Object object2 = "createConversation...";
            ((AVLogger)object).d((String)object2);
            n11 = WindTalker.getNextIMRequestId();
            object = this;
            boolean bl5 = this.needCacheRequestKey;
            if (!bl5) break block0;
            object2 = RequestCache.getInstance();
            ((RequestCache)object2).addRequestCallback(string2, null, n11, aVIMCommonJsonCallback);
        }
        return this.createConversationDirectly(aVConnectionManager, string2, list, map, bl2, bl3, bl4, n10, n11);
    }

    public boolean createConversationDirectly(AVConnectionManager aVConnectionManager, String string2, List list, Map map, boolean bl2, boolean bl3, boolean bl4, int n10, int n11) {
        String string3 = this.getInstallationId(string2);
        AVSessionManager aVSessionManager = AVSessionManager.getInstance();
        aVSessionManager.getOrCreateSession(string2, string3, aVConnectionManager).createConversation(list, map, bl2, bl3, bl4, n10, false, n11);
        return true;
    }

    public boolean fetchReceiptTimestamps(AVConnectionManager aVConnectionManager, String string2, String string3, int n10, Conversation$AVIMOperation conversation$AVIMOperation, AVIMCommonJsonCallback aVIMCommonJsonCallback) {
        Object object = LOGGER;
        String string4 = "fetchReceiptTimestamps...";
        ((AVLogger)object).d(string4);
        int n11 = WindTalker.getNextIMRequestId();
        boolean bl2 = this.needCacheRequestKey;
        if (bl2) {
            object = RequestCache.getInstance();
            string4 = null;
            ((RequestCache)object).addRequestCallback(string2, null, n11, aVIMCommonJsonCallback);
        }
        return this.fetchReceiptTimestampsDirectly(aVConnectionManager, string2, string3, n10, conversation$AVIMOperation, n11);
    }

    public boolean fetchReceiptTimestampsDirectly(AVConnectionManager aVConnectionManager, String string2, String string3, int n10, Conversation$AVIMOperation object, int n11) {
        object = this.getInstallationId(string2);
        AVSessionManager.getInstance().getOrCreateSession(string2, (String)object, aVConnectionManager).getConversationHolder(string3, n10).getReceiptTime(n11);
        return true;
    }

    public boolean loginLiveQuery(AVConnectionManager aVConnectionManager, String string2, AVLiveQuerySubscribeCallback object) {
        Object object2 = LOGGER;
        String string3 = "loginLiveQuery...";
        ((AVLogger)object2).d(string3);
        int n10 = WindTalker.getNextIMRequestId();
        boolean bl2 = this.needCacheRequestKey;
        if (bl2) {
            object2 = RequestCache.getInstance();
            bl2 = false;
            String string4 = "leancloud_livequery_default_id";
            ((RequestCache)object2).addRequestCallback(string4, null, n10, (AVCallback)object);
        } else {
            object = "don't cache livequery login request.";
            ((AVLogger)object2).d((String)object);
        }
        return this.loginLiveQueryDirectly(aVConnectionManager, string2, n10);
    }

    public boolean loginLiveQueryDirectly(AVConnectionManager aVConnectionManager, String string2, int n10) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            return false;
        }
        LiveQueryOperationDelegate.getInstance().login(string2, n10);
        return true;
    }

    public boolean markConversationRead(AVConnectionManager aVConnectionManager, String string2, String string3, int n10, Map map) {
        LOGGER.d("markConversationRead...");
        int n11 = WindTalker.getNextIMRequestId();
        return this.markConversationReadDirectly(aVConnectionManager, string2, string3, n10, map, n11);
    }

    public boolean markConversationReadDirectly(AVConnectionManager object, String object2, String string2, int n10, Map map, int n11) {
        String string3 = this.getInstallationId((String)object2);
        object = AVSessionManager.getInstance().getOrCreateSession((String)object2, string3, (AVConnectionManager)object).getConversationHolder(string2, n10);
        object2 = Conversation$AVIMOperation.CONVERSATION_READ;
        ((AVConversationHolder)object).processConversationCommandFromClient((Conversation$AVIMOperation)((Object)object2), map, n11);
        return true;
    }

    public void onLiveQueryCompleted(int n10, Throwable object) {
        String string2 = "leancloud_livequery_default_id";
        Object object2 = this.getCachedCallback(string2, null, n10, null);
        if (object2 != null) {
            Object object3 = LOGGER;
            CharSequence charSequence = new StringBuilder();
            String string3 = "call livequery login callback with exception:";
            charSequence.append(string3);
            charSequence.append(object);
            charSequence = charSequence.toString();
            ((AVLogger)object3).d((String)charSequence);
            object3 = object == null ? null : new AVException((Throwable)object);
            ((AVCallback)object2).internalDone((AVException)object3);
        } else {
            object = LOGGER;
            object2 = "no callback found for livequery login request.";
            ((AVLogger)object).d((String)object2);
        }
        RequestCache.getInstance().cleanRequestCallback(string2, null, n10);
    }

    public void onOperationCompleted(String string2, String string3, int n10, Conversation$AVIMOperation object, Throwable object2) {
        Object object3 = this.getCachedCallback(string2, string3, n10, (Conversation$AVIMOperation)((Object)object));
        Object object4 = ", operation=";
        String string4 = ", requestId=";
        String string5 = ", convId=";
        if (object3 == null) {
            object2 = LOGGER;
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("onOperationCompleted encounter illegal response, ignore it: clientId=");
            ((StringBuilder)object3).append(string2);
            ((StringBuilder)object3).append(string5);
            ((StringBuilder)object3).append(string3);
            ((StringBuilder)object3).append(string4);
            ((StringBuilder)object3).append(n10);
            ((StringBuilder)object3).append((String)object4);
            ((StringBuilder)object3).append(object);
            string2 = ((StringBuilder)object3).toString();
            ((AVLogger)object2).w(string2);
            return;
        }
        AVLogger aVLogger = LOGGER;
        StringBuilder stringBuilder = new StringBuilder();
        String string6 = "enter onOperationCompleted with clientId=";
        stringBuilder.append(string6);
        stringBuilder.append(string2);
        stringBuilder.append(string5);
        stringBuilder.append(string3);
        stringBuilder.append(string4);
        stringBuilder.append(n10);
        stringBuilder.append((String)object4);
        stringBuilder.append(object);
        object4 = stringBuilder.toString();
        aVLogger.d((String)object4);
        object4 = DirectlyOperationTube$1.$SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
        Object object5 = object.ordinal();
        object5 = object4[object5];
        Object object6 = 1;
        if (object5 != object6 && object5 != (object6 = 2) && object5 != (object6 = 3)) {
            object = AVIMException.wrapperAVException((Throwable)object2);
            ((AVCallback)object3).internalDone((AVException)object);
        } else {
            object = AVIMClient.getInstance(string2);
            object2 = AVIMException.wrapperAVException((Throwable)object2);
            ((AVCallback)object3).internalDone(object, (AVException)object2);
        }
        RequestCache.getInstance().cleanRequestCallback(string2, string3, n10);
    }

    public void onOperationCompletedEx(String string2, String string3, int n10, Conversation$AVIMOperation object, HashMap object2) {
        Object object3 = this.getCachedCallback(string2, string3, n10, (Conversation$AVIMOperation)((Object)object));
        Object object4 = ", resultData=";
        Object object5 = ", operation=";
        String string4 = ", requestId=";
        String string5 = ", convId=";
        if (object3 == null) {
            object3 = LOGGER;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onOperationCompletedEx encounter illegal response, ignore it: clientId=");
            stringBuilder.append(string2);
            stringBuilder.append(string5);
            stringBuilder.append(string3);
            stringBuilder.append(string4);
            stringBuilder.append(n10);
            stringBuilder.append((String)object5);
            stringBuilder.append(object);
            stringBuilder.append((String)object4);
            string2 = ((AbstractMap)object2).toString();
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            ((AVLogger)object3).w(string2);
            return;
        }
        AVLogger aVLogger = LOGGER;
        StringBuilder stringBuilder = new StringBuilder();
        String string6 = "enter onOperationCompletedEx with clientId=";
        stringBuilder.append(string6);
        stringBuilder.append(string2);
        stringBuilder.append(string5);
        stringBuilder.append(string3);
        stringBuilder.append(string4);
        stringBuilder.append(n10);
        stringBuilder.append((String)object5);
        stringBuilder.append(object);
        stringBuilder.append((String)object4);
        object4 = ((AbstractMap)object2).toString();
        stringBuilder.append((String)object4);
        object4 = stringBuilder.toString();
        aVLogger.d((String)object4);
        object4 = DirectlyOperationTube$1.$SwitchMap$cn$leancloud$im$v2$Conversation$AVIMOperation;
        Object object6 = object.ordinal();
        object6 = object4[object6];
        object4 = null;
        switch (object6) {
            default: {
                ((AVCallback)object3).internalDone(object2, null);
                break;
            }
            case 13: {
                object = ((HashMap)object2).get("callbackMemberCount");
                ((AVCallback)object3).internalDone(object, null);
                break;
            }
            case 12: {
                object = ((HashMap)object2).get("callbackHistoryMessages");
                ((AVCallback)object3).internalDone(object, null);
                break;
            }
            case 10: 
            case 11: {
                object = (String[])((HashMap)object2).get("callbackData");
                object5 = "callbackNext";
                boolean bl2 = ((HashMap)object2).containsKey(object5);
                object2 = bl2 ? (String)((HashMap)object2).get(object5) : null;
                boolean bl3 = object3 instanceof AVIMConversationIterableResultCallback;
                if (bl3) {
                    object5 = new AVIMConversationIterableResult();
                    ((AVIMConversationIterableResult)object5).setNext((String)object2);
                    object = Arrays.asList(object);
                    ((AVIMConversationIterableResult)object5).setMembers((List)object);
                    ((AVCallback)object3).internalDone(object5, null);
                    break;
                }
                object = Arrays.asList(object);
                ((AVCallback)object3).internalDone(object, null);
                break;
            }
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                ((AVCallback)object3).internalDone(object2, null);
                break;
            }
            case 4: {
                object = (List)((HashMap)object2).get("callbackOnlineClient");
                ((AVCallback)object3).internalDone(object, null);
            }
        }
        RequestCache.getInstance().cleanRequestCallback(string2, string3, n10);
    }

    public boolean openClient(AVConnectionManager aVConnectionManager, String string2, String string3, String string4, boolean bl2, AVIMClientCallback aVIMClientCallback) {
        Object object = LOGGER;
        String string5 = "openClient...";
        ((AVLogger)object).d(string5);
        int n10 = WindTalker.getNextIMRequestId();
        boolean bl3 = this.needCacheRequestKey;
        if (bl3) {
            object = RequestCache.getInstance();
            string5 = null;
            ((RequestCache)object).addRequestCallback(string2, null, n10, aVIMClientCallback);
        }
        return this.openClientDirectly(aVConnectionManager, string2, string3, string4, bl2, n10);
    }

    public boolean openClientDirectly(AVConnectionManager aVConnectionManager, String string2, String string3, String string4, boolean bl2, int n10) {
        String string5 = this.getInstallationId(string2);
        AVSessionManager.getInstance().getOrCreateSession(string2, string5, aVConnectionManager).open(string3, string4, bl2, n10);
        return true;
    }

    public boolean participateConversation(AVConnectionManager aVConnectionManager, String string2, String string3, int n10, Map map, Conversation$AVIMOperation conversation$AVIMOperation, AVIMConversationCallback aVIMConversationCallback) {
        int n11;
        block0: {
            Object object = LOGGER;
            Object object2 = "participateConversation...";
            ((AVLogger)object).d((String)object2);
            n11 = WindTalker.getNextIMRequestId();
            object = this;
            boolean bl2 = this.needCacheRequestKey;
            if (!bl2) break block0;
            object2 = RequestCache.getInstance();
            ((RequestCache)object2).addRequestCallback(string2, null, n11, aVIMConversationCallback);
        }
        return this.participateConversationDirectly(aVConnectionManager, string2, string3, n10, map, conversation$AVIMOperation, n11);
    }

    public boolean participateConversationDirectly(AVConnectionManager aVConnectionManager, String string2, String string3, int n10, Map map, Conversation$AVIMOperation conversation$AVIMOperation, int n11) {
        String string4 = this.getInstallationId(string2);
        AVSessionManager.getInstance().getOrCreateSession(string2, string4, aVConnectionManager).getConversationHolder(string3, n10).processConversationCommandFromClient(conversation$AVIMOperation, map, n11);
        return true;
    }

    public boolean processMembers(AVConnectionManager aVConnectionManager, String string2, String string3, int n10, String string4, Conversation$AVIMOperation conversation$AVIMOperation, AVCallback aVCallback) {
        int n11;
        block0: {
            Object object = LOGGER;
            Object object2 = "processMembers...";
            ((AVLogger)object).d((String)object2);
            n11 = WindTalker.getNextIMRequestId();
            object = this;
            boolean bl2 = this.needCacheRequestKey;
            if (!bl2) break block0;
            object2 = RequestCache.getInstance();
            ((RequestCache)object2).addRequestCallback(string2, null, n11, aVCallback);
        }
        return this.processMembersDirectly(aVConnectionManager, string2, string3, n10, string4, conversation$AVIMOperation, n11);
    }

    public boolean processMembersDirectly(AVConnectionManager object, String object2, String string2, int n10, String string3, Conversation$AVIMOperation conversation$AVIMOperation, int n11) {
        String string4 = this.getInstallationId((String)object2);
        object = AVSessionManager.getInstance().getOrCreateSession((String)object2, string4, (AVConnectionManager)object).getConversationHolder(string2, n10);
        object2 = (Map)JSON.parseObject(string3, Map.class);
        ((AVConversationHolder)object).processConversationCommandFromClient(conversation$AVIMOperation, (Map)object2, n11);
        return true;
    }

    public boolean queryClientStatus(AVConnectionManager object, String object2, AVIMClientStatusCallback aVIMClientStatusCallback) {
        LOGGER.d("queryClientStatus...");
        String string2 = this.getInstallationId((String)object2);
        Object object3 = AVIMClient$AVIMClientStatus.AVIMClientStatusNone;
        object3 = AVSessionManager.getInstance();
        object = ((AVSessionManager)object3).getOrCreateSession((String)object2, string2, (AVConnectionManager)object);
        object2 = AVSession$Status.Opened;
        object = ((AVSession)object).getCurrentStatus();
        object = object2 == object ? AVIMClient$AVIMClientStatus.AVIMClientStatusOpened : AVIMClient$AVIMClientStatus.AVIMClientStatusPaused;
        if (aVIMClientStatusCallback != null) {
            object2 = null;
            aVIMClientStatusCallback.internalDone(object, null);
        }
        return true;
    }

    public boolean queryConversations(AVConnectionManager aVConnectionManager, String string2, String string3, AVIMCommonJsonCallback aVIMCommonJsonCallback) {
        return this.queryConversationsInternally(aVConnectionManager, string2, string3, aVIMCommonJsonCallback);
    }

    public boolean queryConversationsDirectly(AVConnectionManager object, String object2, String string2, int n10) {
        String string3 = this.getInstallationId((String)object2);
        object = AVSessionManager.getInstance().getOrCreateSession((String)object2, string3, (AVConnectionManager)object);
        object2 = new HashMap();
        object2 = object2.getClass();
        object2 = (Map)JSON.parseObject(string2, object2);
        string2 = MDFive.computeMD5(string2);
        ((AVSession)object).queryConversations((Map)object2, n10, string2);
        return true;
    }

    public boolean queryConversationsInternally(AVConnectionManager aVConnectionManager, String string2, String string3, AVIMCommonJsonCallback aVIMCommonJsonCallback) {
        AVLogger aVLogger = LOGGER;
        Object object = "queryConversationsInternally...";
        aVLogger.d((String)object);
        int n10 = WindTalker.getNextIMRequestId();
        boolean bl2 = this.needCacheRequestKey;
        if (bl2) {
            object = RequestCache.getInstance();
            ((RequestCache)object).addRequestCallback(string2, null, n10, aVIMCommonJsonCallback);
        }
        return this.queryConversationsDirectly(aVConnectionManager, string2, string3, n10);
    }

    public boolean queryMessages(AVConnectionManager aVConnectionManager, String string2, String string3, int n10, String string4, Conversation$AVIMOperation conversation$AVIMOperation, AVIMMessagesQueryCallback aVIMMessagesQueryCallback) {
        int n11;
        block0: {
            Object object = LOGGER;
            Object object2 = "queryMessages...";
            ((AVLogger)object).d((String)object2);
            n11 = WindTalker.getNextIMRequestId();
            object = this;
            boolean bl2 = this.needCacheRequestKey;
            if (!bl2) break block0;
            object2 = RequestCache.getInstance();
            ((RequestCache)object2).addRequestCallback(string2, null, n11, aVIMMessagesQueryCallback);
        }
        return this.queryMessagesDirectly(aVConnectionManager, string2, string3, n10, string4, conversation$AVIMOperation, n11);
    }

    public boolean queryMessagesDirectly(AVConnectionManager object, String object2, String string2, int n10, String string3, Conversation$AVIMOperation conversation$AVIMOperation, int n11) {
        String string4 = this.getInstallationId((String)object2);
        object = AVSessionManager.getInstance().getOrCreateSession((String)object2, string4, (AVConnectionManager)object).getConversationHolder(string2, n10);
        object2 = (Map)JSON.parseObject(string3, Map.class);
        ((AVConversationHolder)object).processConversationCommandFromClient(conversation$AVIMOperation, (Map)object2, n11);
        return true;
    }

    public boolean queryOnlineClients(AVConnectionManager aVConnectionManager, String string2, List list, AVIMOnlineClientsCallback aVIMOnlineClientsCallback) {
        AVLogger aVLogger = LOGGER;
        Object object = "queryOnlineClients...";
        aVLogger.d((String)object);
        int n10 = WindTalker.getNextIMRequestId();
        boolean bl2 = this.needCacheRequestKey;
        if (bl2) {
            object = RequestCache.getInstance();
            ((RequestCache)object).addRequestCallback(string2, null, n10, aVIMOnlineClientsCallback);
        }
        return this.queryOnlineClientsDirectly(aVConnectionManager, string2, list, n10);
    }

    public boolean queryOnlineClientsDirectly(AVConnectionManager aVConnectionManager, String string2, List list, int n10) {
        String string3 = this.getInstallationId(string2);
        AVSessionManager.getInstance().getOrCreateSession(string2, string3, aVConnectionManager).queryOnlinePeers(list, n10);
        return true;
    }

    public boolean recallMessage(AVConnectionManager aVConnectionManager, String string2, int n10, AVIMMessage aVIMMessage, AVIMCommonJsonCallback aVIMCommonJsonCallback) {
        Object object = LOGGER;
        String string3 = "recallMessage...";
        ((AVLogger)object).d(string3);
        int n11 = WindTalker.getNextIMRequestId();
        boolean bl2 = this.needCacheRequestKey;
        if (bl2) {
            object = RequestCache.getInstance();
            string3 = null;
            ((RequestCache)object).addRequestCallback(string2, null, n11, aVIMCommonJsonCallback);
        }
        return this.recallMessageDirectly(aVConnectionManager, string2, n10, aVIMMessage, n11);
    }

    public boolean recallMessageDirectly(AVConnectionManager object, String string2, int n10, AVIMMessage aVIMMessage, int n11) {
        Object object2 = this.getInstallationId(string2);
        object = AVSessionManager.getInstance().getOrCreateSession(string2, (String)object2, (AVConnectionManager)object);
        string2 = aVIMMessage.getConversationId();
        object2 = ((AVSession)object).getConversationHolder(string2, n10);
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_RECALL_MESSAGE;
        ((AVConversationHolder)object2).patchMessage(null, null, aVIMMessage, conversation$AVIMOperation, n11);
        return true;
    }

    public boolean renewSessionToken(AVConnectionManager aVConnectionManager, String string2, AVIMClientCallback aVIMClientCallback) {
        AVLogger aVLogger = LOGGER;
        Object object = "renewSessionToken...";
        aVLogger.d((String)object);
        int n10 = WindTalker.getNextIMRequestId();
        boolean bl2 = this.needCacheRequestKey;
        if (bl2) {
            object = RequestCache.getInstance();
            ((RequestCache)object).addRequestCallback(string2, null, n10, aVIMClientCallback);
        }
        return this.renewSessionTokenDirectly(aVConnectionManager, string2, n10);
    }

    public boolean renewSessionTokenDirectly(AVConnectionManager aVConnectionManager, String string2, int n10) {
        String string3 = this.getInstallationId(string2);
        AVSessionManager.getInstance().getOrCreateSession(string2, string3, aVConnectionManager).renewRealtimeSesionToken(n10);
        return true;
    }

    public boolean sendMessage(AVConnectionManager aVConnectionManager, String string2, String string3, int n10, AVIMMessage aVIMMessage, AVIMMessageOption aVIMMessageOption, AVIMCommonJsonCallback aVIMCommonJsonCallback) {
        int n11;
        block0: {
            Object object = LOGGER;
            Object object2 = "sendMessage...";
            ((AVLogger)object).d((String)object2);
            n11 = WindTalker.getNextIMRequestId();
            object = this;
            boolean bl2 = this.needCacheRequestKey;
            if (!bl2) break block0;
            object2 = RequestCache.getInstance();
            ((RequestCache)object2).addRequestCallback(string2, null, n11, aVIMCommonJsonCallback);
        }
        return this.sendMessageDirectly(aVConnectionManager, string2, string3, n10, aVIMMessage, aVIMMessageOption, n11);
    }

    public boolean sendMessageDirectly(AVConnectionManager object, String string2, String string3, int n10, AVIMMessage aVIMMessage, AVIMMessageOption aVIMMessageOption, int n11) {
        String string4 = this.getInstallationId(string2);
        AVSessionManager aVSessionManager = AVSessionManager.getInstance();
        object = aVSessionManager.getOrCreateSession(string2, string4, (AVConnectionManager)object).getConversationHolder(string3, n10);
        aVIMMessage.setFrom(string2);
        if (aVIMMessageOption == null) {
            aVIMMessageOption = new AVIMMessageOption();
        }
        ((AVConversationHolder)object).sendMessage(aVIMMessage, n11, aVIMMessageOption);
        return true;
    }

    public boolean updateConversation(AVConnectionManager aVConnectionManager, String string2, String string3, int n10, Map map, AVIMCommonJsonCallback aVIMCommonJsonCallback) {
        Object object = LOGGER;
        String string4 = "updateConversation...";
        ((AVLogger)object).d(string4);
        int n11 = WindTalker.getNextIMRequestId();
        boolean bl2 = this.needCacheRequestKey;
        if (bl2) {
            object = RequestCache.getInstance();
            string4 = null;
            ((RequestCache)object).addRequestCallback(string2, null, n11, aVIMCommonJsonCallback);
        }
        return this.updateConversationDirectly(aVConnectionManager, string2, string3, n10, map, n11);
    }

    public boolean updateConversationDirectly(AVConnectionManager aVConnectionManager, String string2, String string3, int n10, Map map, int n11) {
        String string4 = this.getInstallationId(string2);
        AVSessionManager.getInstance().getOrCreateSession(string2, string4, aVConnectionManager).getConversationHolder(string3, n10).updateInfo(map, n11);
        return true;
    }

    public boolean updateMessage(AVConnectionManager aVConnectionManager, String string2, int n10, AVIMMessage aVIMMessage, AVIMMessage aVIMMessage2, AVIMCommonJsonCallback aVIMCommonJsonCallback) {
        Object object = LOGGER;
        String string3 = "updateMessage...";
        ((AVLogger)object).d(string3);
        int n11 = WindTalker.getNextIMRequestId();
        boolean bl2 = this.needCacheRequestKey;
        if (bl2) {
            object = RequestCache.getInstance();
            string3 = null;
            ((RequestCache)object).addRequestCallback(string2, null, n11, aVIMCommonJsonCallback);
        }
        return this.updateMessageDirectly(aVConnectionManager, string2, n10, aVIMMessage, aVIMMessage2, n11);
    }

    public boolean updateMessageDirectly(AVConnectionManager object, String string2, int n10, AVIMMessage aVIMMessage, AVIMMessage aVIMMessage2, int n11) {
        Object object2 = this.getInstallationId(string2);
        object = AVSessionManager.getInstance().getOrCreateSession(string2, (String)object2, (AVConnectionManager)object);
        string2 = aVIMMessage.getConversationId();
        object2 = ((AVSession)object).getConversationHolder(string2, n10);
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_UPDATE_MESSAGE;
        ((AVConversationHolder)object2).patchMessage(aVIMMessage, aVIMMessage2, null, conversation$AVIMOperation, n11);
        return true;
    }
}

