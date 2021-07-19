/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.AVException;
import cn.leancloud.AVInstallation;
import cn.leancloud.AVLogger;
import cn.leancloud.AVObject;
import cn.leancloud.AVUser;
import cn.leancloud.im.InternalConfiguration;
import cn.leancloud.im.OperationTube;
import cn.leancloud.im.v2.AVIMChatRoom;
import cn.leancloud.im.v2.AVIMClient$1;
import cn.leancloud.im.v2.AVIMClient$2;
import cn.leancloud.im.v2.AVIMClient$3;
import cn.leancloud.im.v2.AVIMClient$4;
import cn.leancloud.im.v2.AVIMClientEventHandler;
import cn.leancloud.im.v2.AVIMClientOpenOption;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMConversationsQuery;
import cn.leancloud.im.v2.AVIMMessageStorage;
import cn.leancloud.im.v2.AVIMServiceConversation;
import cn.leancloud.im.v2.AVIMTemporaryConversation;
import cn.leancloud.im.v2.callback.AVIMClientCallback;
import cn.leancloud.im.v2.callback.AVIMClientStatusCallback;
import cn.leancloud.im.v2.callback.AVIMConversationCreatedCallback;
import cn.leancloud.im.v2.callback.AVIMConversationMemberQueryCallback;
import cn.leancloud.im.v2.callback.AVIMOnlineClientsCallback;
import cn.leancloud.query.QueryConditions;
import cn.leancloud.service.RealtimeClient;
import cn.leancloud.session.AVConnectionManager;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import e.a.g0;
import e.a.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class AVIMClient {
    private static final AVLogger LOGGER;
    private static AVIMClientEventHandler clientEventHandler;
    private static ConcurrentMap clients;
    private String clientId = null;
    private AVConnectionManager connectionManager;
    private ConcurrentMap conversationCache;
    private AVInstallation currentInstallation;
    private String realtimeSessionToken = null;
    private long realtimeSessionTokenExpired = 0L;
    private AVIMMessageStorage storage;
    private String tag = null;
    private String userSessionToken = null;

    static {
        ConcurrentHashMap concurrentHashMap;
        LOGGER = LogUtil.getLogger(AVIMClient.class);
        clients = concurrentHashMap = new ConcurrentHashMap();
    }

    private AVIMClient(AVConnectionManager aVConnectionManager, String object, AVInstallation aVInstallation) {
        ConcurrentHashMap concurrentHashMap;
        this.conversationCache = concurrentHashMap = new ConcurrentHashMap();
        this.clientId = object;
        this.storage = object = AVIMMessageStorage.getInstance((String)object);
        this.connectionManager = aVConnectionManager;
        this.currentInstallation = aVInstallation;
    }

    public static /* synthetic */ String access$000(AVIMClient aVIMClient) {
        return aVIMClient.clientId;
    }

    public static /* synthetic */ AVIMMessageStorage access$100(AVIMClient aVIMClient) {
        return aVIMClient.storage;
    }

    public static /* synthetic */ void access$200(AVIMClient aVIMClient, QueryConditions queryConditions, AVIMConversationMemberQueryCallback aVIMConversationMemberQueryCallback) {
        aVIMClient.queryConvMemberThroughNetwork(queryConditions, aVIMConversationMemberQueryCallback);
    }

    private void createConversation(List list, String string2, Map map, boolean bl2, boolean bl3, boolean bl4, int n10, AVIMConversationCreatedCallback aVIMConversationCreatedCallback) {
        AVIMClient$1 aVIMClient$1;
        boolean bl5;
        int n11;
        Object object;
        boolean bl6;
        AVIMClient aVIMClient = this;
        Object object2 = list;
        Object object3 = new HashMap();
        if (map != null) {
            ((HashMap)object3).putAll(map);
        }
        if (!(bl6 = StringUtil.isEmpty(string2))) {
            object = "name";
            ((HashMap)object3).put(object, string2);
        }
        bl6 = false;
        object = null;
        int n12 = ((HashMap)object3).size();
        if (n12 > 0) {
            bl6 = true;
            object = AVIMConversation.processAttributes(object3, bl6);
        }
        String string3 = object;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        if (object2 != null && (n11 = list.size()) > 0) {
            arrayList.addAll((Collection<Object>)object2);
        }
        if (!(bl5 = arrayList.contains(object2 = aVIMClient.clientId))) {
            object2 = aVIMClient.clientId;
            arrayList.add(object2);
        }
        object2 = aVIMClient$1;
        object3 = this;
        bl6 = bl2;
        n12 = (int)(bl4 ? 1 : 0);
        aVIMClient$1 = new AVIMClient$1(this, bl2, bl4, arrayList, map, string2, n10, aVIMConversationCreatedCallback);
        OperationTube operationTube = InternalConfiguration.getOperationTube();
        AVConnectionManager aVConnectionManager = aVIMClient.connectionManager;
        String string4 = this.getClientId();
        operationTube.createConversation(aVConnectionManager, string4, arrayList, (Map)((Object)string3), bl2, bl3, bl4, n10, aVIMClient$1);
    }

    private void createServiceConversation(String object, Map map, AVIMConversationCreatedCallback aVIMConversationCreatedCallback) {
        object = new UnsupportedOperationException("can't invoke createServiceConversation within SDK.");
        throw object;
    }

    public static AVIMClientEventHandler getClientEventHandler() {
        return clientEventHandler;
    }

    public static int getClientsCount() {
        return clients.size();
    }

    private AVIMConversation getConversation(String object, boolean bl2, boolean bl3, boolean bl4) {
        Object object2;
        boolean bl5 = StringUtil.isEmpty((String)object);
        if (bl5) {
            return null;
        }
        AVIMConversation aVIMConversation = (AVIMConversation)this.conversationCache.get(object);
        if (aVIMConversation != null) {
            return aVIMConversation;
        }
        Object object3 = bl4 ? new AVIMServiceConversation(this, (String)object) : (!bl3 && !(bl3 = ((String)object).startsWith((String)(object2 = "_tmp:"))) ? (bl2 ? new AVIMChatRoom(this, (String)object) : new AVIMConversation(this, (String)object)) : new AVIMTemporaryConversation(this, (String)object));
        object2 = this.conversationCache;
        object = object2.putIfAbsent(object, object3);
        if (object != null) {
            object3 = object;
        }
        return object3;
    }

    public static String getDefaultClient() {
        int n10;
        int n11 = AVIMClient.getClientsCount();
        if (n11 == (n10 = 1)) {
            return (String)clients.keySet().iterator().next();
        }
        return "";
    }

    public static AVIMClient getInstance(AVUser object) {
        AVIMClient aVIMClient = null;
        if (object == null) {
            return null;
        }
        String string2 = ((AVObject)object).getObjectId();
        object = ((AVUser)object).getSessionToken();
        boolean bl2 = StringUtil.isEmpty(string2);
        if (!bl2 && !(bl2 = StringUtil.isEmpty((String)object))) {
            aVIMClient = AVIMClient.getInstance(string2);
            aVIMClient.userSessionToken = object;
        }
        return aVIMClient;
    }

    public static AVIMClient getInstance(AVUser object, String string2) {
        object = AVIMClient.getInstance((AVUser)object);
        ((AVIMClient)object).tag = string2;
        return object;
    }

    public static AVIMClient getInstance(AVConnectionManager object, String string2, AVInstallation aVInstallation) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            return null;
        }
        Object object2 = (AVIMClient)clients.get(string2);
        if (object2 == null && (object = clients.putIfAbsent(string2, object2 = new AVIMClient((AVConnectionManager)object, string2, aVInstallation))) != null) {
            object2 = object;
        }
        return object2;
    }

    public static AVIMClient getInstance(String string2) {
        AVConnectionManager aVConnectionManager = AVConnectionManager.getInstance();
        AVInstallation aVInstallation = AVInstallation.getCurrentInstallation();
        return AVIMClient.getInstance(aVConnectionManager, string2, aVInstallation);
    }

    public static AVIMClient getInstance(String object, String string2) {
        object = AVIMClient.getInstance((String)object);
        ((AVIMClient)object).tag = string2;
        return object;
    }

    private AVIMConversationsQuery getTemporaryConversationQuery() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("only conversationId query is allowed, please invoke #getTemporaryConversaton with conversationId.");
        throw unsupportedOperationException;
    }

    public static AVIMClient peekInstance(String string2) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            return null;
        }
        return (AVIMClient)clients.get(string2);
    }

    private void queryConvMemberThroughNetwork(QueryConditions object, AVIMConversationMemberQueryCallback aVIMConversationMemberQueryCallback) {
        if (aVIMConversationMemberQueryCallback != null && object != null) {
            ((QueryConditions)object).assembleParameters();
            object = ((QueryConditions)object).getParameters();
            Object object2 = this.clientId;
            object.put("client_id", object2);
            object2 = RealtimeClient.getInstance();
            String string2 = this.realtimeSessionToken;
            object = ((RealtimeClient)object2).queryMemberInfo((Map)object, string2);
            object2 = new AVIMClient$4(this, aVIMConversationMemberQueryCallback);
            ((z)object).subscribe((g0)object2);
        }
    }

    private boolean realtimeSessionTokenExpired() {
        long l10;
        long l11 = System.currentTimeMillis() / 1000L + 300L;
        long l12 = l11 - (l10 = this.realtimeSessionTokenExpired);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object >= 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public static void setClientEventHandler(AVIMClientEventHandler aVIMClientEventHandler) {
        clientEventHandler = aVIMClientEventHandler;
    }

    public void close(AVIMClientCallback object) {
        AVIMClient$2 aVIMClient$2 = new AVIMClient$2(this, (AVIMClientCallback)object);
        object = InternalConfiguration.getOperationTube();
        AVConnectionManager aVConnectionManager = this.connectionManager;
        String string2 = this.clientId;
        object.closeClient(aVConnectionManager, string2, aVIMClient$2);
    }

    public void createChatRoom(String string2, Map map, AVIMConversationCreatedCallback aVIMConversationCreatedCallback) {
        this.createConversation(null, string2, map, true, false, aVIMConversationCreatedCallback);
    }

    public void createChatRoom(List list, String string2, Map map, boolean bl2, AVIMConversationCreatedCallback aVIMConversationCreatedCallback) {
        this.createConversation(list, string2, map, true, false, aVIMConversationCreatedCallback);
    }

    public void createConversation(List list, String string2, Map map, AVIMConversationCreatedCallback aVIMConversationCreatedCallback) {
        this.createConversation(list, string2, map, false, aVIMConversationCreatedCallback);
    }

    public void createConversation(List list, String string2, Map map, boolean bl2, AVIMConversationCreatedCallback aVIMConversationCreatedCallback) {
        boolean bl3 = bl2 ^ true;
        this.createConversation(list, string2, map, bl2, bl3, aVIMConversationCreatedCallback);
    }

    public void createConversation(List list, String string2, Map map, boolean bl2, boolean bl3, AVIMConversationCreatedCallback aVIMConversationCreatedCallback) {
        this.createConversation(list, string2, map, bl2, bl3, false, 0, aVIMConversationCreatedCallback);
    }

    public void createConversation(List list, Map map, AVIMConversationCreatedCallback aVIMConversationCreatedCallback) {
        this.createConversation(list, null, map, false, aVIMConversationCreatedCallback);
    }

    public void createTemporaryConversation(List list, int n10, AVIMConversationCreatedCallback aVIMConversationCreatedCallback) {
        this.createConversation(list, null, null, false, true, true, n10, aVIMConversationCreatedCallback);
    }

    public void createTemporaryConversation(List list, AVIMConversationCreatedCallback aVIMConversationCreatedCallback) {
        this.createTemporaryConversation(list, 259200, aVIMConversationCreatedCallback);
    }

    public AVIMConversation getChatRoom(String string2) {
        return this.getConversation(string2, true, false);
    }

    public AVIMConversationsQuery getChatRoomQuery() {
        AVIMConversationsQuery aVIMConversationsQuery = new AVIMConversationsQuery(this);
        Boolean bl2 = Boolean.TRUE;
        aVIMConversationsQuery.whereEqualTo("tr", bl2);
        return aVIMConversationsQuery;
    }

    public String getClientId() {
        return this.clientId;
    }

    public void getClientStatus(AVIMClientStatusCallback aVIMClientStatusCallback) {
        OperationTube operationTube = InternalConfiguration.getOperationTube();
        AVConnectionManager aVConnectionManager = this.connectionManager;
        String string2 = this.clientId;
        operationTube.queryClientStatus(aVConnectionManager, string2, aVIMClientStatusCallback);
    }

    public AVConnectionManager getConnectionManager() {
        return this.connectionManager;
    }

    public AVIMConversation getConversation(String string2) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            return null;
        }
        boolean bl3 = string2.startsWith("_tmp:");
        return this.getConversation(string2, false, bl3);
    }

    public AVIMConversation getConversation(String object, int n10) {
        int n11 = 2;
        object = n10 != n11 ? (n10 != (n11 = 3) ? (n10 != (n11 = 4) ? this.getConversation((String)object) : this.getTemporaryConversation((String)object)) : this.getServiceConversation((String)object)) : this.getChatRoom((String)object);
        return object;
    }

    public AVIMConversation getConversation(String string2, boolean bl2, boolean bl3) {
        return this.getConversation(string2, bl2, bl3, false);
    }

    public AVIMConversationsQuery getConversationsQuery() {
        AVIMConversationsQuery aVIMConversationsQuery = new AVIMConversationsQuery(this);
        return aVIMConversationsQuery;
    }

    public String getInstallationId() {
        AVInstallation aVInstallation = this.currentInstallation;
        if (aVInstallation == null) {
            return null;
        }
        return aVInstallation.getInstallationId();
    }

    public void getOnlineClients(List list, AVIMOnlineClientsCallback aVIMOnlineClientsCallback) {
        OperationTube operationTube = InternalConfiguration.getOperationTube();
        AVConnectionManager aVConnectionManager = this.connectionManager;
        String string2 = this.clientId;
        operationTube.queryOnlineClients(aVConnectionManager, string2, list, aVIMOnlineClientsCallback);
    }

    public AVIMConversation getServiceConversation(String string2) {
        return this.getConversation(string2, false, false, true);
    }

    public AVIMConversationsQuery getServiceConversationQuery() {
        AVIMConversationsQuery aVIMConversationsQuery = new AVIMConversationsQuery(this);
        Boolean bl2 = Boolean.TRUE;
        aVIMConversationsQuery.whereEqualTo("sys", bl2);
        return aVIMConversationsQuery;
    }

    public AVIMMessageStorage getStorage() {
        return this.storage;
    }

    public AVIMConversation getTemporaryConversation(String string2) {
        return this.getConversation(string2, false, true);
    }

    public void localClose() {
        ConcurrentMap concurrentMap = clients;
        String string2 = this.clientId;
        concurrentMap.remove(string2);
        this.conversationCache.clear();
        this.storage.deleteClientData();
    }

    public AVIMConversation mergeConversationCache(AVIMConversation aVIMConversation, boolean bl2, Map map) {
        String string2;
        boolean bl3;
        if (aVIMConversation != null && !(bl3 = StringUtil.isEmpty(string2 = aVIMConversation.getConversationId()))) {
            string2 = aVIMConversation.getConversationId();
            if (bl2) {
                this.conversationCache.put(string2, aVIMConversation);
                return aVIMConversation;
            }
            Object object = (AVIMConversation)this.conversationCache.get(string2);
            if (object == null) {
                object = this.conversationCache;
                object.put(string2, aVIMConversation);
            } else {
                aVIMConversation = AVIMConversation.updateConversation((AVIMConversation)object, map);
            }
            return aVIMConversation;
        }
        return null;
    }

    public void open(AVIMClientOpenOption aVIMClientOpenOption, AVIMClientCallback aVIMClientCallback) {
        boolean bl2;
        if (aVIMClientOpenOption == null) {
            bl2 = false;
            aVIMClientOpenOption = null;
        } else {
            bl2 = aVIMClientOpenOption.isReconnect();
        }
        OperationTube operationTube = InternalConfiguration.getOperationTube();
        AVConnectionManager aVConnectionManager = this.connectionManager;
        String string2 = this.clientId;
        String string3 = this.tag;
        String string4 = this.userSessionToken;
        operationTube.openClient(aVConnectionManager, string2, string3, string4, bl2, aVIMClientCallback);
    }

    public void open(AVIMClientCallback aVIMClientCallback) {
        this.open(null, aVIMClientCallback);
    }

    public void queryConversationMemberInfo(QueryConditions queryConditions, AVIMConversationMemberQueryCallback aVIMConversationMemberQueryCallback) {
        if (queryConditions != null && aVIMConversationMemberQueryCallback != null) {
            boolean bl2 = this.realtimeSessionTokenExpired();
            if (!bl2) {
                this.queryConvMemberThroughNetwork(queryConditions, aVIMConversationMemberQueryCallback);
            } else {
                LOGGER.d("realtime session token expired, start to refresh...");
                Object object = InternalConfiguration.getOperationTube();
                AVConnectionManager aVConnectionManager = this.connectionManager;
                String string2 = this.getClientId();
                AVIMClient$3 aVIMClient$3 = new AVIMClient$3(this, aVIMConversationMemberQueryCallback, queryConditions);
                boolean bl3 = object.renewSessionToken(aVConnectionManager, string2, aVIMClient$3);
                if (!bl3) {
                    bl3 = false;
                    queryConditions = null;
                    int n10 = 119;
                    string2 = "couldn't start service in background.";
                    object = new AVException(n10, string2);
                    aVIMConversationMemberQueryCallback.internalDone(null, (AVException)object);
                }
            }
        }
    }

    public void updateRealtimeSessionToken(String string2, long l10) {
        this.realtimeSessionToken = string2;
        this.realtimeSessionTokenExpired = l10;
    }
}

