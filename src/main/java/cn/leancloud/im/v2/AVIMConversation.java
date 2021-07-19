/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.AVException;
import cn.leancloud.AVLogger;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.core.AppConfiguration;
import cn.leancloud.im.AVIMOptions;
import cn.leancloud.im.InternalConfiguration;
import cn.leancloud.im.OperationTube;
import cn.leancloud.im.v2.AVIMChatRoom;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMConversation$1;
import cn.leancloud.im.v2.AVIMConversation$10;
import cn.leancloud.im.v2.AVIMConversation$11;
import cn.leancloud.im.v2.AVIMConversation$12;
import cn.leancloud.im.v2.AVIMConversation$13;
import cn.leancloud.im.v2.AVIMConversation$14;
import cn.leancloud.im.v2.AVIMConversation$15;
import cn.leancloud.im.v2.AVIMConversation$16;
import cn.leancloud.im.v2.AVIMConversation$2;
import cn.leancloud.im.v2.AVIMConversation$3;
import cn.leancloud.im.v2.AVIMConversation$4;
import cn.leancloud.im.v2.AVIMConversation$5;
import cn.leancloud.im.v2.AVIMConversation$6;
import cn.leancloud.im.v2.AVIMConversation$7;
import cn.leancloud.im.v2.AVIMConversation$8;
import cn.leancloud.im.v2.AVIMConversation$9;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.AVIMMessage;
import cn.leancloud.im.v2.AVIMMessage$AVIMMessageIOType;
import cn.leancloud.im.v2.AVIMMessage$AVIMMessageStatus;
import cn.leancloud.im.v2.AVIMMessageInterval;
import cn.leancloud.im.v2.AVIMMessageInterval$AVIMMessageIntervalBound;
import cn.leancloud.im.v2.AVIMMessageOption;
import cn.leancloud.im.v2.AVIMMessageQueryDirection;
import cn.leancloud.im.v2.AVIMMessageStorage;
import cn.leancloud.im.v2.AVIMServiceConversation;
import cn.leancloud.im.v2.AVIMTemporaryConversation;
import cn.leancloud.im.v2.AVIMTypedMessage;
import cn.leancloud.im.v2.Conversation;
import cn.leancloud.im.v2.Conversation$AVIMOperation;
import cn.leancloud.im.v2.callback.AVIMCommonJsonCallback;
import cn.leancloud.im.v2.callback.AVIMConversationCallback;
import cn.leancloud.im.v2.callback.AVIMConversationIterableResultCallback;
import cn.leancloud.im.v2.callback.AVIMConversationMemberCountCallback;
import cn.leancloud.im.v2.callback.AVIMConversationMemberQueryCallback;
import cn.leancloud.im.v2.callback.AVIMConversationSimpleResultCallback;
import cn.leancloud.im.v2.callback.AVIMMessageRecalledCallback;
import cn.leancloud.im.v2.callback.AVIMMessageUpdatedCallback;
import cn.leancloud.im.v2.callback.AVIMMessagesQueryCallback;
import cn.leancloud.im.v2.callback.AVIMOperationPartiallySucceededCallback;
import cn.leancloud.im.v2.conversation.AVIMConversationMemberInfo;
import cn.leancloud.im.v2.conversation.ConversationMemberRole;
import cn.leancloud.im.v2.messages.AVIMFileMessage;
import cn.leancloud.im.v2.messages.AVIMFileMessageAccessor;
import cn.leancloud.json.JSON;
import cn.leancloud.json.JSONObject;
import cn.leancloud.json.JSONObject$Builder;
import cn.leancloud.ops.ObjectFieldOperation;
import cn.leancloud.ops.OperationBuilder;
import cn.leancloud.ops.OperationBuilder$OperationType;
import cn.leancloud.ops.Utils;
import cn.leancloud.query.QueryConditions;
import cn.leancloud.session.AVConnectionManager;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public class AVIMConversation {
    private static final String ATTR_PERFIX = "attr.";
    private static final AVLogger LOGGER = LogUtil.getLogger(AVIMConversation.class);
    public static Comparator messageComparator;
    public int FETCH_TIME_INTERVEL;
    public AVIMClient client;
    public Map instanceData;
    private boolean isSyncLastMessage;
    public long lastDeliveredAt;
    public AVIMMessage lastMessage;
    public Date lastMessageAt;
    public long lastReadAt;
    public long latestConversationFetch;
    public ConcurrentMap operations;
    public AVIMMessageStorage storage;
    public int unreadMessagesCount;
    public boolean unreadMessagesMentioned;

    static {
        AVIMConversation$16 aVIMConversation$16 = new AVIMConversation$16();
        messageComparator = aVIMConversation$16;
    }

    public AVIMConversation(AVIMClient aVIMClient, String string2) {
        this(aVIMClient, null, null, false);
        this.setConversationId(string2);
    }

    public AVIMConversation(AVIMClient object, List list, Map map, boolean bl2) {
        AbstractMap abstractMap;
        this.instanceData = abstractMap = new AbstractMap();
        this.operations = abstractMap;
        this.isSyncLastMessage = false;
        this.unreadMessagesCount = 0;
        this.unreadMessagesMentioned = false;
        this.FETCH_TIME_INTERVEL = 3600000;
        this.latestConversationFetch = 0L;
        this.client = object;
        this.storage = object = ((AVIMClient)object).getStorage();
        this.setMembers(list);
        this.setAttributesForInit(map);
        this.setTransientForInit(bl2);
    }

    public static /* synthetic */ AVLogger access$000() {
        return LOGGER;
    }

    public static /* synthetic */ void access$100(AVIMConversation aVIMConversation, AVIMMessage aVIMMessage, AVIMMessage aVIMMessage2) {
        aVIMConversation.copyMessageWithoutContent(aVIMMessage, aVIMMessage2);
    }

    public static /* synthetic */ void access$200(AVIMConversation aVIMConversation, List list) {
        aVIMConversation.processContinuousMessages(list);
    }

    public static /* synthetic */ void access$300(AVIMConversation aVIMConversation, String string2, long l10, int n10, AVIMMessagesQueryCallback aVIMMessagesQueryCallback) {
        aVIMConversation.queryMessagesFromCache(string2, l10, n10, aVIMMessagesQueryCallback);
    }

    public static /* synthetic */ void access$400(AVIMConversation aVIMConversation, String string2, long l10, int n10, String string3, long l11, AVIMMessagesQueryCallback aVIMMessagesQueryCallback) {
        aVIMConversation.queryMessagesFromServer(string2, l10, n10, string3, l11, aVIMMessagesQueryCallback);
    }

    public static /* synthetic */ void access$500(AVIMConversation aVIMConversation, List list, List list2, String string2, long l10, int n10, AVIMMessagesQueryCallback aVIMMessagesQueryCallback) {
        aVIMConversation.processStorageQueryResult(list, list2, string2, l10, n10, aVIMMessagesQueryCallback);
    }

    private void copyMessageWithoutContent(AVIMMessage object, AVIMMessage aVIMMessage) {
        Object object2 = object.getMessageId();
        aVIMMessage.setMessageId((String)object2);
        object2 = object.getConversationId();
        aVIMMessage.setConversationId((String)object2);
        object2 = object.getFrom();
        aVIMMessage.setFrom((String)object2);
        long l10 = object.getDeliveredAt();
        aVIMMessage.setDeliveredAt(l10);
        l10 = object.getReadAt();
        aVIMMessage.setReadAt(l10);
        l10 = object.getTimestamp();
        aVIMMessage.setTimestamp(l10);
        object2 = object.getMessageStatus();
        aVIMMessage.setMessageStatus((AVIMMessage$AVIMMessageStatus)((Object)object2));
        object = object.getMessageIOType();
        aVIMMessage.setMessageIOType((AVIMMessage$AVIMMessageIOType)((Object)object));
    }

    private AVIMMessage getLastMessageFromLocal() {
        Object object = AVIMOptions.getGlobalOptions();
        boolean bl2 = ((AVIMOptions)object).isMessageQueryCacheEnabled();
        if (bl2) {
            object = this.storage;
            String string2 = this.getConversationId();
            object = ((AVIMMessageStorage)object).getLatestMessage(string2);
            this.isSyncLastMessage = true;
            return object;
        }
        return null;
    }

    public static AVIMConversation parseFromJson(AVIMClient aVIMClient, Map map) {
        boolean bl2 = false;
        Object object = null;
        if (map != null && aVIMClient != null) {
            String string2 = (String)map.get("objectId");
            boolean bl3 = StringUtil.isEmpty(string2);
            if (bl3) {
                return null;
            }
            object = "sys";
            bl3 = map.containsKey(object);
            boolean bl4 = false;
            Boolean bl5 = null;
            if (bl3) {
                object = (Boolean)map.get(object);
                bl2 = (Boolean)object;
            } else {
                bl2 = false;
                object = null;
            }
            Object object2 = "tr";
            boolean bl6 = map.containsKey(object2);
            if (bl6) {
                object2 = (Boolean)map.get(object2);
                bl3 = (Boolean)object2;
            } else {
                bl3 = false;
                object2 = null;
            }
            String string3 = "temp";
            boolean bl7 = map.containsKey(string3);
            if (bl7) {
                bl5 = (Boolean)map.get(string3);
                bl4 = bl5;
            }
            object = bl2 ? new AVIMServiceConversation(aVIMClient, string2) : (bl4 ? new AVIMTemporaryConversation(aVIMClient, string2) : (bl3 ? new AVIMChatRoom(aVIMClient, string2) : new AVIMConversation(aVIMClient, string2)));
            long l10 = System.currentTimeMillis();
            ((AVIMConversation)object).updateFetchTimestamp(l10);
            return AVIMConversation.updateConversation((AVIMConversation)object, map);
        }
        return null;
    }

    public static Map processAttributes(Map map, boolean bl2) {
        if (bl2) {
            return AVIMConversation.processAttributesForCovering(map);
        }
        return AVIMConversation.processAttributesForIncremental(map);
    }

    public static JSONObject processAttributesForCovering(Map object) {
        Object object2;
        HashMap hashMap = new HashMap();
        Object object3 = "name";
        boolean bl2 = object.containsKey(object3);
        if (bl2) {
            object2 = object.get(object3);
            hashMap.put(object3, object2);
        }
        object3 = new Object();
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Map.Entry)object.next();
            String string2 = (String)object2.getKey();
            List<String> list = Arrays.asList(Conversation.CONVERSATION_COLUMNS);
            boolean bl3 = list.contains(string2);
            if (bl3) continue;
            object2 = object2.getValue();
            object3.put(string2, object2);
        }
        boolean bl4 = object3.isEmpty();
        if (!bl4) {
            object = "attr";
            hashMap.put(object, object3);
        }
        if (bl4 = hashMap.isEmpty()) {
            return null;
        }
        return JSONObject$Builder.create(hashMap);
    }

    public static Map processAttributesForIncremental(Map object) {
        boolean bl2;
        Object object2;
        HashMap hashMap = new HashMap();
        Object object3 = "name";
        boolean bl3 = object.containsKey(object3);
        if (bl3) {
            object2 = object.get(object3);
            hashMap.put(object3, object2);
        }
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            object3 = (Map.Entry)object.next();
            object2 = (String)object3.getKey();
            List<String> list = Arrays.asList(Conversation.CONVERSATION_COLUMNS);
            boolean bl4 = list.contains(object2);
            if (bl4) continue;
            list = new StringBuilder();
            String string2 = ATTR_PERFIX;
            ((StringBuilder)((Object)list)).append(string2);
            ((StringBuilder)((Object)list)).append((String)object2);
            object2 = ((StringBuilder)((Object)list)).toString();
            object3 = object3.getValue();
            hashMap.put(object2, object3);
        }
        boolean bl5 = hashMap.isEmpty();
        if (bl5) {
            return null;
        }
        return hashMap;
    }

    private void processContinuousMessages(List list) {
        int n10;
        if (list != null && (n10 = list.isEmpty()) == 0) {
            Object object = messageComparator;
            Collections.sort(list, object);
            n10 = list.size() + -1;
            object = (AVIMMessage)list.get(n10);
            this.setLastMessage((AVIMMessage)object);
            object = this.getConversationId();
            AVIMMessageStorage aVIMMessageStorage = this.storage;
            aVIMMessageStorage.insertContinuousMessages(list, (String)object);
        }
    }

    private void processStorageQueryResult(List list, List list2, String string2, long l10, int n10, AVIMMessagesQueryCallback aVIMMessagesQueryCallback) {
        Object object;
        Object object2;
        Object object3;
        int n11;
        int n12;
        int n13 = n10;
        AVIMMessagesQueryCallback aVIMMessagesQueryCallback2 = aVIMMessagesQueryCallback;
        ArrayList arrayList = new ArrayList();
        Object object4 = null;
        for (n12 = 0; n12 < (n11 = list.size()); ++n12) {
            object3 = list2;
            object2 = (Boolean)list2.get(n12);
            boolean bl2 = (Boolean)object2;
            if (bl2) break;
            object2 = list;
            object = list.get(n12);
            arrayList.add(object);
        }
        object4 = AppConfiguration.getGlobalNetworkingDetector();
        n12 = (int)(object4.isConnected() ? 1 : 0);
        n11 = 0;
        object3 = null;
        if (n12 != 0 && (n12 = arrayList.size()) < n13) {
            long l11;
            Object object5;
            n12 = (int)(arrayList.isEmpty() ? 1 : 0);
            if (n12 == 0) {
                n12 = arrayList.size();
                n13 -= n12;
                n12 = arrayList.size() + -1;
                object3 = object4 = arrayList.get(n12);
                object3 = (AVIMMessage)object4;
            }
            int n14 = n13;
            if (object3 == null) {
                object = string2;
            } else {
                object5 = ((AVIMMessage)object3).messageId;
                object = object5;
            }
            long l12 = object3 == null ? l10 : (l11 = ((AVIMMessage)object3).timestamp);
            long l13 = 0L;
            object5 = this;
            AVIMConversation$13 aVIMConversation$13 = new AVIMConversation$13(this, arrayList, aVIMMessagesQueryCallback2);
            object2 = this;
            this.queryMessagesFromServer((String)object, l12, n14, null, l13, aVIMConversation$13);
        } else {
            AVIMConversation aVIMConversation = this;
            object4 = messageComparator;
            Collections.sort(arrayList, object4);
            aVIMMessagesQueryCallback2.internalDone(arrayList, null);
        }
    }

    private void queryMemberInfo(QueryConditions queryConditions, AVIMConversationMemberQueryCallback aVIMConversationMemberQueryCallback) {
        if (queryConditions != null && aVIMConversationMemberQueryCallback != null) {
            AVIMClient aVIMClient = this.client;
            aVIMClient.queryConversationMemberInfo(queryConditions, aVIMConversationMemberQueryCallback);
        }
    }

    private void queryMessagesFromCache(String string2, long l10, int n10, AVIMMessagesQueryCallback aVIMMessagesQueryCallback) {
        if (aVIMMessagesQueryCallback != null) {
            String string3 = this.getConversationId();
            AVIMMessageStorage aVIMMessageStorage = this.storage;
            AVIMConversation$8 aVIMConversation$8 = new AVIMConversation$8(this, aVIMMessagesQueryCallback);
            aVIMMessageStorage.getMessages(string2, l10, n10, string3, aVIMConversation$8);
        }
    }

    private void queryMessagesFromServer(String string2, long l10, int n10, String string3, long l11, AVIMMessagesQueryCallback aVIMMessagesQueryCallback) {
        AVIMMessageQueryDirection aVIMMessageQueryDirection = AVIMMessageQueryDirection.AVIMMessageQueryDirectionFromNewToOld;
        this.queryMessagesFromServer(string2, l10, false, string3, l11, false, aVIMMessageQueryDirection, n10, aVIMMessagesQueryCallback);
    }

    private void queryMessagesFromServer(String object, long l10, boolean bl2, String string2, long l11, boolean bl3, AVIMMessageQueryDirection enum_, int n10, AVIMMessagesQueryCallback aVIMMessagesQueryCallback) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        String string3 = "mid";
        hashMap.put(string3, object);
        object = l10;
        hashMap.put("ts", object);
        object = bl2;
        hashMap.put("sinc", object);
        hashMap.put("tmid", string2);
        object = l11;
        hashMap.put("tt", object);
        object = bl3;
        hashMap.put("tinc", object);
        object = ((AVIMMessageQueryDirection)enum_).getCode();
        hashMap.put("direct", object);
        object = n10;
        hashMap.put("limit", object);
        object = 0;
        Object object2 = "type";
        hashMap.put((String)object2, object);
        OperationTube operationTube = InternalConfiguration.getOperationTube();
        Object object3 = this.client.getConnectionManager();
        object = this.client;
        string2 = ((AVIMClient)object).getClientId();
        String string4 = this.getConversationId();
        int n11 = this.getType();
        String string5 = JSON.toJSONString(hashMap);
        enum_ = Conversation$AVIMOperation.CONVERSATION_MESSAGE_QUERY;
        boolean bl4 = operationTube.queryMessages((AVConnectionManager)object3, string2, string4, n11, string5, (Conversation$AVIMOperation)enum_, aVIMMessagesQueryCallback);
        if (!bl4 && aVIMMessagesQueryCallback != null) {
            bl4 = false;
            object = null;
            int n12 = 119;
            object3 = "couldn't start service in background.";
            object2 = new AVException(n12, (String)object3);
            aVIMMessagesQueryCallback.internalDone(null, (AVException)object2);
        }
    }

    public static void recurDeleteData(Map map, String string2) {
        int n10;
        if (map != null && (n10 = StringUtil.isEmpty(string2)) == 0) {
            String string3 = ".";
            n10 = string2.indexOf(string3);
            if (n10 < 0) {
                map.remove(string2);
            } else {
                String string4 = string2.substring(0, n10);
                string2 = string2.substring(++n10);
                map = (Map)map.get(string4);
                AVIMConversation.recurDeleteData(map, string2);
            }
        }
    }

    public static Object recurGetData(Map map, String string2) {
        int n10;
        if (map != null && (n10 = StringUtil.isEmpty(string2)) == 0) {
            String string3 = ".";
            n10 = string2.indexOf(string3);
            if (n10 < 0) {
                return map.get(string2);
            }
            String string4 = string2.substring(0, n10);
            string2 = string2.substring(++n10);
            return AVIMConversation.recurGetData((Map)map.get(string4), string2);
        }
        return null;
    }

    public static void recurSetData(Map map, String string2, Object object) {
        int n10;
        if (map != null && (n10 = StringUtil.isEmpty(string2)) == 0) {
            String string3 = ".";
            n10 = string2.indexOf(string3);
            if (n10 < 0) {
                map.put(string2, object);
            } else {
                String string4 = string2.substring(0, n10);
                string2 = string2.substring(++n10);
                map = (Map)map.get(string4);
                AVIMConversation.recurSetData(map, string2, object);
            }
        }
    }

    public static AVIMConversation updateConversation(AVIMConversation aVIMConversation, Map object) {
        if (object != null && aVIMConversation != null) {
            boolean bl2;
            Object object2 = (String)object.get("objectId");
            Object object3 = (List)object.get("m");
            aVIMConversation.setMembers((List)object3);
            object3 = (String)object.get("c");
            aVIMConversation.setCreator((String)object3);
            object3 = new HashMap();
            Object object4 = "attr";
            boolean bl3 = object.containsKey(object4);
            if (bl3 && (object4 = (Map)object.get(object4)) != null) {
                ((HashMap)object3).putAll(object4);
            }
            aVIMConversation.setAttributesForInit((Map)object3);
            aVIMConversation.instanceData.clear();
            object3 = object.entrySet().iterator();
            while (bl2 = object3.hasNext()) {
                object4 = (Map.Entry)object3.next();
                String string2 = (String)object4.getKey();
                Map map = aVIMConversation.instanceData;
                object4 = object4.getValue();
                map.put(string2, object4);
            }
            object2 = AVIMTypedMessage.parseMessage((String)object2, (Map)object);
            aVIMConversation.setLastMessage((AVIMMessage)object2);
            object2 = "lm";
            boolean bl4 = object.containsKey(object2);
            if (bl4) {
                object = Utils.dateFromMap((Map)object.get(object2));
                aVIMConversation.setLastMessageAt((Date)object);
            }
        }
        return aVIMConversation;
    }

    public void addMembers(List object, AVIMOperationPartiallySucceededCallback aVIMOperationPartiallySucceededCallback) {
        int n10;
        int n11;
        if (object != null && (n11 = object.size()) >= (n10 = 1)) {
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            String string2 = "conversation.member";
            hashMap.put(string2, object);
            OperationTube operationTube = InternalConfiguration.getOperationTube();
            AVConnectionManager aVConnectionManager = this.client.getConnectionManager();
            object = this.client;
            String string3 = ((AVIMClient)object).getClientId();
            String string4 = this.getConversationId();
            int n12 = this.getType();
            String string5 = JSON.toJSONString(hashMap);
            Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_ADD_MEMBER;
            boolean bl2 = operationTube.processMembers(aVConnectionManager, string3, string4, n12, string5, conversation$AVIMOperation, aVIMOperationPartiallySucceededCallback);
            if (!bl2 && aVIMOperationPartiallySucceededCallback != null) {
                n11 = 119;
                string2 = "couldn't start service in background.";
                object = new AVException(n11, string2);
                aVIMOperationPartiallySucceededCallback.internalDone(null, (AVException)object);
            }
            return;
        }
        if (aVIMOperationPartiallySucceededCallback != null) {
            String string6 = "memberIds is null";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string6);
            object = new AVIMException(illegalArgumentException);
            aVIMOperationPartiallySucceededCallback.done((AVIMException)object, null, null);
        }
    }

    public void addNewOperation(ObjectFieldOperation objectFieldOperation) {
        if (objectFieldOperation == null) {
            return;
        }
        Object object = null;
        Object object2 = this.operations;
        String string2 = objectFieldOperation.getField();
        boolean bl2 = object2.containsKey(string2);
        if (bl2) {
            object = this.operations;
            object2 = objectFieldOperation.getField();
            object = (ObjectFieldOperation)object.get(object2);
        }
        object2 = this.operations;
        string2 = objectFieldOperation.getField();
        objectFieldOperation = objectFieldOperation.merge((ObjectFieldOperation)object);
        object2.put(string2, objectFieldOperation);
    }

    public void addToLocalCache(AVIMMessage aVIMMessage) {
        this.storage.insertLocalMessage(aVIMMessage);
    }

    public void blockMembers(List object, AVIMOperationPartiallySucceededCallback aVIMOperationPartiallySucceededCallback) {
        int n10;
        int n11;
        if (object != null && (n11 = object.size()) >= (n10 = 1)) {
            String string2 = this.getConversationId();
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            String string3 = "conversation.member";
            hashMap.put(string3, object);
            OperationTube operationTube = InternalConfiguration.getOperationTube();
            AVConnectionManager aVConnectionManager = this.client.getConnectionManager();
            object = this.client;
            String string4 = ((AVIMClient)object).getClientId();
            int n12 = this.getType();
            String string5 = JSON.toJSONString(hashMap);
            Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_BLOCK_MEMBER;
            boolean bl2 = operationTube.processMembers(aVConnectionManager, string4, string2, n12, string5, conversation$AVIMOperation, aVIMOperationPartiallySucceededCallback);
            if (!bl2 && aVIMOperationPartiallySucceededCallback != null) {
                n11 = 119;
                string3 = "couldn't start service in background.";
                object = new AVException(n11, string3);
                aVIMOperationPartiallySucceededCallback.internalDone((AVException)object);
            }
            return;
        }
        if (aVIMOperationPartiallySucceededCallback != null) {
            String string6 = "memberIds is null";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string6);
            object = new AVIMException(illegalArgumentException);
            n11 = 0;
            illegalArgumentException = null;
            aVIMOperationPartiallySucceededCallback.done((AVIMException)object, null, null);
        }
    }

    public Map dumpRawData() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Object object = this.instanceData;
        hashMap.putAll((Map<String, Object>)object);
        int n10 = this.getType();
        object = n10;
        String string2 = "conv_type";
        hashMap.put(string2, object);
        object = this.lastMessage;
        if (object != null) {
            object = ((AVIMMessage)object).dumpRawData();
            string2 = "msg";
            hashMap.put(string2, object);
        }
        return hashMap;
    }

    public void fetchInfoInBackground(AVIMConversationCallback object) {
        Object object2 = this.getConversationId();
        boolean bl2 = StringUtil.isEmpty((String)object2);
        if (bl2) {
            object2 = "ConversationId is empty";
            if (object != null) {
                int n10 = 102;
                AVException aVException = new AVException(n10, (String)object2);
                ((AVCallback)object).internalDone(aVException);
            } else {
                object = LOGGER;
                ((AVLogger)object).w((String)object2);
            }
            return;
        }
        object2 = this.getFetchRequestParams();
        OperationTube operationTube = InternalConfiguration.getOperationTube();
        AVConnectionManager aVConnectionManager = this.client.getConnectionManager();
        String string2 = this.client.getClientId();
        object2 = JSON.toJSONString(object2);
        AVIMConversation$15 aVIMConversation$15 = new AVIMConversation$15(this, (AVIMConversationCallback)object);
        operationTube.queryConversations(aVConnectionManager, string2, (String)object2, aVIMConversation$15);
    }

    public void fetchReceiptTimestamps(AVIMConversationCallback aVIMConversationCallback) {
        boolean bl2 = this.isSystem();
        int n10 = 119;
        if (!bl2 && !(bl2 = this.isTransient())) {
            Conversation$AVIMOperation conversation$AVIMOperation;
            int n11;
            String string2;
            Object object;
            String string3;
            AVConnectionManager aVConnectionManager;
            AVIMConversation$6 aVIMConversation$6 = new AVIMConversation$6(this, aVIMConversationCallback);
            Object object2 = InternalConfiguration.getOperationTube();
            bl2 = object2.fetchReceiptTimestamps(aVConnectionManager = this.client.getConnectionManager(), string3 = ((AVIMClient)(object = this.client)).getClientId(), string2 = this.getConversationId(), n11 = this.getType(), conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_FETCH_RECEIPT_TIME, aVIMConversation$6);
            if (!bl2 && aVIMConversationCallback != null) {
                object2 = "couldn't send request in background.";
                object = new AVException(n10, (String)object2);
                aVIMConversationCallback.internalDone((AVException)object);
            }
            return;
        }
        Object object = LOGGER;
        String string4 = "system or transient conversation doesn't support fetchReceiptTimestamp command.";
        ((AVLogger)object).w(string4);
        if (aVIMConversationCallback != null) {
            object = new AVException(n10, string4);
            aVIMConversationCallback.internalDone((AVException)object);
        }
    }

    public Object get(String object) {
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (bl2) {
            return null;
        }
        Object object2 = AVIMConversation.recurGetData(this.instanceData, (String)object);
        ConcurrentMap concurrentMap = this.operations;
        if ((object = (ObjectFieldOperation)concurrentMap.get(object)) != null) {
            object2 = object.apply(object2);
        }
        return object2;
    }

    public void getAllMemberInfo(int n10, int n11, AVIMConversationMemberQueryCallback aVIMConversationMemberQueryCallback) {
        QueryConditions queryConditions = new QueryConditions();
        String string2 = this.getConversationId();
        queryConditions.addWhereItem("cid", "__eq", string2);
        queryConditions.setSkip(n10);
        queryConditions.setLimit(n11);
        this.queryMemberInfo(queryConditions, aVIMConversationMemberQueryCallback);
    }

    public Object getAttribute(String string2) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            return null;
        }
        String string3 = "name";
        bl2 = string3.equals(string2);
        if (bl2) {
            return this.get(string2);
        }
        string3 = ATTR_PERFIX;
        boolean bl3 = string2.startsWith(string3);
        if (!bl3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
        }
        return this.get(string2);
    }

    public Map getAttributes() {
        Map map = (Map)this.get("attr");
        if (map != null) {
            map = Collections.unmodifiableMap(map);
        }
        return map;
    }

    public String getConversationId() {
        return (String)this.get("objectId");
    }

    public Date getCreatedAt() {
        return StringUtil.dateFromString((String)this.instanceData.get("createdAt"));
    }

    public String getCreator() {
        return (String)this.instanceData.get("c");
    }

    public Map getFetchRequestParams() {
        HashMap<String, String> hashMap;
        HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
        String string2 = this.getConversationId();
        boolean bl2 = string2.startsWith((String)((Object)(hashMap = "_tmp:")));
        if (bl2) {
            hashMap = "temp_id";
            hashMap2.put(hashMap, string2);
        } else {
            hashMap = new HashMap<String, String>();
            String string3 = "objectId";
            hashMap.put(string3, string2);
            string2 = "where";
            hashMap2.put(string2, hashMap);
        }
        return hashMap2;
    }

    public long getLastDeliveredAt() {
        long l10 = this.lastReadAt;
        long l11 = this.lastDeliveredAt;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            return l10;
        }
        return l11;
    }

    public AVIMMessage getLastMessage() {
        Object object = AVIMOptions.getGlobalOptions();
        boolean bl2 = ((AVIMOptions)object).isMessageQueryCacheEnabled();
        if (bl2 && !(bl2 = this.isSyncLastMessage)) {
            object = this.getLastMessageFromLocal();
            this.setLastMessage((AVIMMessage)object);
        }
        return this.lastMessage;
    }

    public Date getLastMessageAt() {
        AVIMMessage aVIMMessage = this.getLastMessage();
        if (aVIMMessage != null) {
            long l10 = aVIMMessage.getDeliveredAt();
            Date date = new Date(l10);
            this.setLastMessageAt(date);
        }
        return this.lastMessageAt;
    }

    public long getLastReadAt() {
        return this.lastReadAt;
    }

    public void getMemberCount(AVIMConversationMemberCountCallback object) {
        String string2 = this.getConversationId();
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            string2 = "ConversationId is empty";
            if (object != null) {
                int n10 = 102;
                AVException aVException = new AVException(n10, string2);
                ((AVCallback)object).internalDone(aVException);
            } else {
                object = LOGGER;
                ((AVLogger)object).w(string2);
            }
            return;
        }
        OperationTube operationTube = InternalConfiguration.getOperationTube();
        AVConnectionManager aVConnectionManager = this.client.getConnectionManager();
        String string3 = this.client.getClientId();
        String string4 = this.getConversationId();
        int n11 = this.getType();
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_MEMBER_COUNT_QUERY;
        operationTube.processMembers(aVConnectionManager, string3, string4, n11, null, conversation$AVIMOperation, (AVCallback)object);
    }

    public void getMemberInfo(String string2, AVIMConversationMemberQueryCallback aVIMConversationMemberQueryCallback) {
        QueryConditions queryConditions = new QueryConditions();
        String string3 = this.getConversationId();
        String string4 = "__eq";
        queryConditions.addWhereItem("cid", string4, string3);
        queryConditions.addWhereItem("peerId", string4, string2);
        this.queryMemberInfo(queryConditions, aVIMConversationMemberQueryCallback);
    }

    public List getMembers() {
        Object object = this.instanceData;
        Object object2 = "m";
        if ((object = (List)object.get(object2)) == null) {
            object = new ArrayList();
            return object;
        }
        int n10 = object.size();
        object2 = new Object(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            String string2 = (String)object.next();
            object2.add(string2);
        }
        return object2;
    }

    public String getName() {
        return (String)this.get("name");
    }

    public int getTemporaryExpiredat() {
        Map map = this.instanceData;
        String string2 = "ttl";
        boolean bl2 = map.containsKey(string2);
        if (bl2) {
            map = this.instanceData.get(string2);
            bl2 = map instanceof Long;
            if (bl2) {
                return Long.valueOf((Long)this.instanceData.get(string2)).intValue();
            }
            map = this.instanceData.get(string2);
            bl2 = map instanceof Double;
            if (bl2) {
                return Double.valueOf((Double)this.instanceData.get(string2)).intValue();
            }
            return (Integer)this.instanceData.get(string2);
        }
        return 0;
    }

    public int getType() {
        boolean bl2 = this.isSystem();
        if (bl2) {
            return 3;
        }
        bl2 = this.isTransient();
        if (bl2) {
            return 2;
        }
        bl2 = this.isTemporary();
        if (bl2) {
            return 4;
        }
        return 1;
    }

    public String getUniqueId() {
        Map map = this.instanceData;
        String string2 = "uniqueId";
        boolean bl2 = map.containsKey(string2);
        if (bl2) {
            return (String)this.instanceData.get(string2);
        }
        return null;
    }

    public int getUnreadMessagesCount() {
        return this.unreadMessagesCount;
    }

    public Date getUpdatedAt() {
        return StringUtil.dateFromString((String)this.instanceData.get("updatedAt"));
    }

    public void increaseUnreadCount(int n10, boolean bl2) {
        int n11;
        this.unreadMessagesCount = n11 = this.getUnreadMessagesCount() + n10;
        if (bl2) {
            this.unreadMessagesMentioned = bl2;
        }
    }

    public void internalMergeMembers(List collection) {
        int n10;
        int n11;
        if (collection != null && (n11 = collection.size()) >= (n10 = 1)) {
            ArrayList arrayList = this.instanceData;
            String string2 = "m";
            if ((arrayList = (List)arrayList.get(string2)) == null) {
                arrayList = new ArrayList();
            }
            arrayList.addAll(collection);
            collection = new Collection();
            collection.addAll(arrayList);
            arrayList.clear();
            arrayList.addAll(collection);
            this.setMembers(arrayList);
        }
    }

    public void internalRemoveMembers(List object) {
        int n10;
        int n11;
        if (object != null && (n11 = object.size()) >= (n10 = 1)) {
            Object object2 = this.instanceData;
            Object object3 = "m";
            if ((object2 = (List)object2.get(object3)) != null) {
                boolean bl2;
                object3 = new Object();
                object3.addAll(object2);
                object = object.iterator();
                while (bl2 = object.hasNext()) {
                    String string2 = (String)object.next();
                    object3.remove(string2);
                }
                object2.clear();
                object2.addAll(object3);
                this.setMembers((List)object2);
            }
        }
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isShouldFetch() {
        void var7_8;
        Date date = this.getCreatedAt();
        if (date != null) {
            long l10 = System.currentTimeMillis();
            long l11 = this.latestConversationFetch;
            int n10 = this.FETCH_TIME_INTERVEL;
            long l12 = (l10 -= l11) - (l11 = (long)n10);
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object <= 0) {
                return (boolean)var7_8;
            }
        }
        boolean bl2 = true;
        return (boolean)var7_8;
    }

    public boolean isSystem() {
        Map map = this.instanceData;
        String string2 = "sys";
        boolean bl2 = map.containsKey(string2);
        if (bl2) {
            return (Boolean)this.instanceData.get(string2);
        }
        return false;
    }

    public boolean isTemporary() {
        Map map = this.instanceData;
        String string2 = "temp";
        boolean bl2 = map.containsKey(string2);
        if (bl2) {
            return (Boolean)this.instanceData.get(string2);
        }
        return false;
    }

    public boolean isTransient() {
        Map map = this.instanceData;
        String string2 = "tr";
        boolean bl2 = map.containsKey(string2);
        if (!bl2) {
            return false;
        }
        return (Boolean)this.get(string2);
    }

    public boolean isUnique() {
        int n10 = 1;
        int n11 = this.getType();
        if (n10 != n11) {
            return false;
        }
        return (StringUtil.isEmpty(this.getUniqueId()) ^ n10) != 0;
    }

    public void join(AVIMConversationCallback object) {
        String string2 = this.getConversationId();
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            string2 = "ConversationId is empty";
            if (object != null) {
                int n10 = 102;
                AVException aVException = new AVException(n10, string2);
                ((AVCallback)object).internalDone(aVException);
            } else {
                object = LOGGER;
                ((AVLogger)object).w(string2);
            }
            return;
        }
        OperationTube operationTube = InternalConfiguration.getOperationTube();
        AVConnectionManager aVConnectionManager = this.client.getConnectionManager();
        String string3 = this.client.getClientId();
        String string4 = this.getConversationId();
        int n11 = this.getType();
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_JOIN;
        operationTube.participateConversation(aVConnectionManager, string3, string4, n11, null, conversation$AVIMOperation, (AVIMConversationCallback)object);
    }

    public void kickMembers(List object, AVIMOperationPartiallySucceededCallback aVIMOperationPartiallySucceededCallback) {
        int n10;
        int n11;
        if (object != null && (n11 = object.size()) >= (n10 = 1)) {
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            String string2 = "conversation.member";
            hashMap.put(string2, object);
            OperationTube operationTube = InternalConfiguration.getOperationTube();
            AVConnectionManager aVConnectionManager = this.client.getConnectionManager();
            object = this.client;
            String string3 = ((AVIMClient)object).getClientId();
            String string4 = this.getConversationId();
            int n12 = this.getType();
            String string5 = JSON.toJSONString(hashMap);
            Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_RM_MEMBER;
            boolean bl2 = operationTube.processMembers(aVConnectionManager, string3, string4, n12, string5, conversation$AVIMOperation, aVIMOperationPartiallySucceededCallback);
            if (!bl2 && aVIMOperationPartiallySucceededCallback != null) {
                n11 = 119;
                string2 = "couldn't start service in background.";
                object = new AVException(n11, string2);
                aVIMOperationPartiallySucceededCallback.internalDone(null, (AVException)object);
            }
            return;
        }
        if (aVIMOperationPartiallySucceededCallback != null) {
            String string6 = "memberIds is null";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string6);
            object = new AVIMException(illegalArgumentException);
            aVIMOperationPartiallySucceededCallback.done((AVIMException)object, null, null);
        }
    }

    public void mute(AVIMConversationCallback object) {
        String string2 = this.getConversationId();
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            string2 = "ConversationId is empty";
            if (object != null) {
                int n10 = 102;
                AVException aVException = new AVException(n10, string2);
                ((AVCallback)object).internalDone(aVException);
            } else {
                object = LOGGER;
                ((AVLogger)object).w(string2);
            }
            return;
        }
        OperationTube operationTube = InternalConfiguration.getOperationTube();
        AVConnectionManager aVConnectionManager = this.client.getConnectionManager();
        String string3 = this.client.getClientId();
        String string4 = this.getConversationId();
        int n11 = this.getType();
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_MUTE;
        operationTube.participateConversation(aVConnectionManager, string3, string4, n11, null, conversation$AVIMOperation, (AVIMConversationCallback)object);
    }

    public void muteMembers(List object, AVIMOperationPartiallySucceededCallback aVIMOperationPartiallySucceededCallback) {
        int n10;
        int n11;
        if (object != null && (n11 = object.size()) >= (n10 = 1)) {
            String string2 = this.getConversationId();
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            String string3 = "conversation.member";
            hashMap.put(string3, object);
            OperationTube operationTube = InternalConfiguration.getOperationTube();
            AVConnectionManager aVConnectionManager = this.client.getConnectionManager();
            object = this.client;
            String string4 = ((AVIMClient)object).getClientId();
            int n12 = this.getType();
            String string5 = JSON.toJSONString(hashMap);
            Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_MUTE_MEMBER;
            boolean bl2 = operationTube.processMembers(aVConnectionManager, string4, string2, n12, string5, conversation$AVIMOperation, aVIMOperationPartiallySucceededCallback);
            if (!bl2 && aVIMOperationPartiallySucceededCallback != null) {
                n11 = 119;
                string3 = "couldn't start service in background.";
                object = new AVException(n11, string3);
                aVIMOperationPartiallySucceededCallback.internalDone(null, (AVException)object);
            }
            return;
        }
        if (aVIMOperationPartiallySucceededCallback != null) {
            String string6 = "memberIds is null";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string6);
            object = new AVIMException(illegalArgumentException);
            aVIMOperationPartiallySucceededCallback.done((AVIMException)object, null, null);
        }
    }

    public AVIMException processQueryResult(String object) {
        Object object2 = "Conversation not found";
        int n10 = 9100;
        if (object != null) {
            block16: {
                AVIMConversation[] aVIMConversationArray;
                try {
                    object = String.valueOf(object);
                    aVIMConversationArray = List.class;
                }
                catch (Exception exception) {
                    return AVIMException.wrapperAVException(exception);
                }
                object = JSON.parseObject((String)object, aVIMConversationArray);
                object = (List)object;
                if (object == null) break block16;
                boolean n11 = object.isEmpty();
                if (n11) break block16;
                object2 = null;
                object = object.get(0);
                object = (Map)object;
                AVIMConversation.updateConversation(this, (Map)object);
                object = this.client;
                n10 = 0;
                int n12 = 1;
                ((AVIMClient)object).mergeConversationCache(this, n12 != 0, null);
                object = this.storage;
                aVIMConversationArray = new AVIMConversation[n12];
                aVIMConversationArray[0] = this;
                object2 = Arrays.asList(aVIMConversationArray);
                ((AVIMMessageStorage)object).insertConversations((List)object2);
                long l10 = System.currentTimeMillis();
                this.latestConversationFetch = l10;
                return null;
            }
            object = new AVIMException(n10, (String)object2);
            return object;
        }
        object = new AVIMException(n10, (String)object2);
        return object;
    }

    public void queryBlockedMembers(int n10, int n11, AVIMConversationSimpleResultCallback aVIMConversationSimpleResultCallback) {
        int n12;
        if (aVIMConversationSimpleResultCallback == null) {
            return;
        }
        if (n10 >= 0 && n11 <= (n12 = 100)) {
            String string2 = this.getConversationId();
            Object object = new HashMap();
            Object object2 = n11;
            object.put("limit", object2);
            Object object3 = n10;
            object2 = "skip";
            object.put(object2, object3);
            OperationTube operationTube = InternalConfiguration.getOperationTube();
            AVConnectionManager aVConnectionManager = this.client.getConnectionManager();
            object3 = this.client;
            String string3 = ((AVIMClient)object3).getClientId();
            int n13 = this.getType();
            String string4 = JSON.toJSONString(object);
            Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_BLOCKED_MEMBER_QUERY;
            n10 = (int)(operationTube.processMembers(aVConnectionManager, string3, string2, n13, string4, conversation$AVIMOperation, aVIMConversationSimpleResultCallback) ? 1 : 0);
            if (n10 == 0) {
                n11 = 119;
                object = "couldn't start service in background.";
                object3 = new AVException(n11, (String)object);
                aVIMConversationSimpleResultCallback.internalDone(null, (AVException)object3);
            }
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("offset/limit is illegal.");
        AVIMException aVIMException = new AVIMException(illegalArgumentException);
        aVIMConversationSimpleResultCallback.internalDone(null, aVIMException);
    }

    public void queryBlockedMembers(int n10, String hashMap, AVIMConversationIterableResultCallback aVIMConversationIterableResultCallback) {
        if (aVIMConversationIterableResultCallback == null) {
            return;
        }
        int n11 = 100;
        if (n10 > n11) {
            hashMap = new HashMap<String, Integer>("limit is illegal.");
            AVIMException aVIMException = new AVIMException((Throwable)((Object)hashMap));
            aVIMConversationIterableResultCallback.internalDone(null, aVIMException);
            return;
        }
        n11 = 0;
        String string2 = null;
        boolean bl2 = StringUtil.isEmpty((String)((Object)hashMap));
        if (!bl2) {
            try {
                hashMap = Integer.valueOf((String)((Object)hashMap));
            }
            catch (NumberFormatException numberFormatException) {
                hashMap = new HashMap<String, Integer>("next is illegal.");
                AVIMException aVIMException = new AVIMException((Throwable)((Object)hashMap));
                aVIMConversationIterableResultCallback.internalDone(null, aVIMException);
                return;
            }
            n11 = (Integer)((Object)hashMap);
        }
        String string3 = this.getConversationId();
        hashMap = new HashMap<String, Integer>();
        Object object = n10;
        hashMap.put("limit", (Integer)object);
        object = n11;
        string2 = "skip";
        hashMap.put(string2, (Integer)object);
        OperationTube operationTube = InternalConfiguration.getOperationTube();
        AVConnectionManager aVConnectionManager = this.client.getConnectionManager();
        object = this.client;
        String string4 = ((AVIMClient)object).getClientId();
        int n12 = this.getType();
        String string5 = JSON.toJSONString(hashMap);
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_BLOCKED_MEMBER_QUERY;
        n10 = (int)(operationTube.processMembers(aVConnectionManager, string4, string3, n12, string5, conversation$AVIMOperation, aVIMConversationIterableResultCallback) ? 1 : 0);
        if (n10 == 0) {
            int n13 = 119;
            string2 = "couldn't start service in background.";
            object = new AVException(n13, string2);
            aVIMConversationIterableResultCallback.internalDone(null, (AVException)object);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void queryMessages(int var1_1, AVIMMessagesQueryCallback var2_2) {
        block5: {
            block4: {
                var3_3 = null;
                if ((var1_1 <= 0 || var1_1 > (var4_4 = 1000)) && var2_2 != null) {
                    var7_7 = "limit should be in [1, 1000]";
                    var6_6 = new IllegalArgumentException(var7_7);
                    var5_5 = new AVException((Throwable)var6_6);
                    var2_2.internalDone(null, (AVException)var5_5);
                }
                var5_5 = this.getConversationId();
                var6_6 = AVIMOptions.getGlobalOptions();
                var8_8 /* !! */  = var6_6.isMessageQueryCacheEnabled();
                if (var8_8 /* !! */  == 0) {
                    var9_9 = new AVIMConversation$9(this, var2_2);
                    var3_3 = this;
                    var10_11 = 0L;
                    this.queryMessagesFromServer(null, 0L, var1_1, null, var10_11, var9_9);
                    return;
                }
                var6_6 = AppConfiguration.getGlobalNetworkingDetector();
                var8_8 /* !! */  = var6_6.isConnected();
                if (var8_8 /* !! */  != 0) break block4;
                var4_4 = 0;
                var5_5 = null;
                var12_13 = 0L;
                var3_3 = this;
                this.queryMessagesFromCache(null, var12_13, var1_1, var2_2);
                break block5;
            }
            var6_6 = this.storage;
            var12_14 = var6_6.getMessageCount((String)var5_5);
            var10_12 = 0L;
            var14_15 = var1_1;
            cfr_temp_0 = var12_14 - var14_15;
            var8_8 /* !! */  = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
            if (var8_8 /* !! */  < 0) ** GOTO lbl-1000
            var6_6 = this.storage;
            var7_7 = null;
            if ((var5_5 = var6_6.getLatestMessageWithBreakpoint((String)var5_5, false)) != null) {
                var3_3 = var5_5.getMessageId();
                var16_16 = var5_5.getTimestamp();
                var18_17 = var3_3;
                var19_18 = var16_16;
            } else lbl-1000:
            // 2 sources

            {
                var19_18 = var10_12;
                var18_17 = null;
            }
            var4_4 = 0;
            var5_5 = null;
            var12_14 = 0L;
            var9_10 = new AVIMConversation$10(this, var1_1, var2_2);
            var3_3 = this;
            var10_12 = var19_18;
            this.queryMessagesFromServer(null, var12_14, var1_1, (String)var18_17, var19_18, var9_10);
        }
    }

    /*
     * WARNING - void declaration
     */
    public void queryMessages(AVIMMessageInterval aVIMMessageInterval, AVIMMessageQueryDirection aVIMMessageQueryDirection, int n10, AVIMMessagesQueryCallback aVIMMessagesQueryCallback) {
        Object object = aVIMMessageInterval;
        AVIMMessagesQueryCallback aVIMMessagesQueryCallback2 = aVIMMessagesQueryCallback;
        String string2 = null;
        if (aVIMMessageInterval != null && n10 >= 0) {
            void var20_21;
            long l10;
            String string3;
            long l11;
            boolean bl3;
            long l12;
            String string4;
            AVIMMessageInterval$AVIMMessageIntervalBound aVIMMessageInterval$AVIMMessageIntervalBound = aVIMMessageInterval.startIntervalBound;
            Object var9_10 = null;
            long l13 = 0L;
            if (aVIMMessageInterval$AVIMMessageIntervalBound != null) {
                boolean bl4;
                string4 = aVIMMessageInterval$AVIMMessageIntervalBound.messageId;
                l12 = aVIMMessageInterval$AVIMMessageIntervalBound.timestamp;
                bl3 = bl4 = aVIMMessageInterval$AVIMMessageIntervalBound.closed;
            } else {
                string4 = null;
                bl3 = false;
                l12 = l13;
            }
            object = ((AVIMMessageInterval)object).endIntervalBound;
            if (object != null) {
                boolean bl5;
                string2 = ((AVIMMessageInterval$AVIMMessageIntervalBound)object).messageId;
                l11 = ((AVIMMessageInterval$AVIMMessageIntervalBound)object).timestamp;
                boolean bl2 = bl5 = ((AVIMMessageInterval$AVIMMessageIntervalBound)object).closed;
                string3 = string2;
                l10 = l11;
            } else {
                boolean bl2 = false;
                l10 = l13;
                string3 = null;
            }
            object = this;
            string2 = string4;
            l11 = l12;
            void var24_25 = var20_21;
            int n11 = n10;
            aVIMMessagesQueryCallback2 = aVIMMessagesQueryCallback;
            this.queryMessagesFromServer(string4, l12, bl3, string3, l10, (boolean)var24_25, aVIMMessageQueryDirection, n10, aVIMMessagesQueryCallback);
            return;
        }
        if (aVIMMessagesQueryCallback2 != null) {
            String string5 = "interval must not null, or limit must great than 0.";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string5);
            object = new AVException(illegalArgumentException);
            aVIMMessagesQueryCallback2.internalDone(null, (AVException)object);
        }
    }

    public void queryMessages(AVIMMessagesQueryCallback aVIMMessagesQueryCallback) {
        this.queryMessages(20, aVIMMessagesQueryCallback);
    }

    public void queryMessages(String string2, long l10, int n10, AVIMMessagesQueryCallback aVIMMessagesQueryCallback) {
        AVIMConversation$12 aVIMConversation$12;
        long l11;
        long l12;
        AVIMConversation aVIMConversation = this;
        Object object = aVIMMessagesQueryCallback;
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2 && !(bl2 = (l12 = l10 - (l11 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
            this.queryMessages(n10, aVIMMessagesQueryCallback);
            return;
        }
        Object object2 = AVIMOptions.getGlobalOptions();
        bl2 = ((AVIMOptions)object2).isMessageQueryCacheEnabled();
        if (!bl2) {
            AVIMConversation$11 aVIMConversation$11 = new AVIMConversation$11(this, (AVIMMessagesQueryCallback)object);
            object2 = this;
            long l13 = 0L;
            this.queryMessagesFromServer(string2, l10, n10, null, l13, aVIMConversation$11);
            return;
        }
        String string3 = this.getConversationId();
        AVIMMessageStorage aVIMMessageStorage = aVIMConversation.storage;
        object2 = aVIMConversation$12;
        object = aVIMMessagesQueryCallback;
        aVIMConversation$12 = new AVIMConversation$12(this, string2, l10, n10, aVIMMessagesQueryCallback, string3);
        object = string3;
        aVIMMessageStorage.getMessage(string2, l10, string3, aVIMConversation$12);
    }

    public void queryMessagesByType(int n10, int n11, AVIMMessagesQueryCallback aVIMMessagesQueryCallback) {
        this.queryMessagesByType(n10, null, 0L, n11, aVIMMessagesQueryCallback);
    }

    public void queryMessagesByType(int n10, String object, long l10, int n11, AVIMMessagesQueryCallback aVIMMessagesQueryCallback) {
        if (aVIMMessagesQueryCallback == null) {
            return;
        }
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        hashMap.put("mid", object);
        object = l10;
        hashMap.put("ts", object);
        object = Boolean.FALSE;
        hashMap.put("sinc", object);
        hashMap.put("tmid", "");
        Object object2 = 0;
        String string2 = "tt";
        hashMap.put(string2, object2);
        hashMap.put("tinc", object);
        int n12 = AVIMMessageQueryDirection.AVIMMessageQueryDirectionFromNewToOld.getCode();
        object = n12;
        hashMap.put("direct", object);
        object = n11;
        object2 = "limit";
        hashMap.put(object2, object);
        Object object3 = n10;
        object = "type";
        hashMap.put(object, object3);
        OperationTube operationTube = InternalConfiguration.getOperationTube();
        AVConnectionManager aVConnectionManager = this.client.getConnectionManager();
        object3 = this.client;
        String string3 = ((AVIMClient)object3).getClientId();
        String string4 = this.getConversationId();
        int n13 = this.getType();
        String string5 = JSON.toJSONString(hashMap);
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_MESSAGE_QUERY;
        n10 = (int)(operationTube.queryMessages(aVConnectionManager, string3, string4, n13, string5, conversation$AVIMOperation, aVIMMessagesQueryCallback) ? 1 : 0);
        if (n10 == 0) {
            n12 = 119;
            object2 = "couldn't send request in background.";
            object3 = new AVException(n12, (String)object2);
            aVIMMessagesQueryCallback.internalDone((AVException)object3);
        }
    }

    public void queryMessagesFromCache(int n10, AVIMMessagesQueryCallback aVIMMessagesQueryCallback) {
        this.queryMessagesFromCache(null, 0L, n10, aVIMMessagesQueryCallback);
    }

    public void queryMessagesFromServer(int n10, AVIMMessagesQueryCallback aVIMMessagesQueryCallback) {
        AVIMConversation$7 aVIMConversation$7 = new AVIMConversation$7(this, aVIMMessagesQueryCallback);
        this.queryMessagesFromServer(null, 0L, n10, null, 0L, aVIMConversation$7);
    }

    public void queryMutedMembers(int n10, int n11, AVIMConversationSimpleResultCallback aVIMConversationSimpleResultCallback) {
        int n12;
        if (aVIMConversationSimpleResultCallback == null) {
            return;
        }
        if (n10 >= 0 && n11 <= (n12 = 100)) {
            String string2 = this.getConversationId();
            Object object = new HashMap();
            Object object2 = n11;
            object.put("limit", object2);
            Object object3 = n10;
            object2 = "skip";
            object.put(object2, object3);
            OperationTube operationTube = InternalConfiguration.getOperationTube();
            AVConnectionManager aVConnectionManager = this.client.getConnectionManager();
            object3 = this.client;
            String string3 = ((AVIMClient)object3).getClientId();
            int n13 = this.getType();
            String string4 = JSON.toJSONString(object);
            Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_MUTED_MEMBER_QUERY;
            n10 = (int)(operationTube.processMembers(aVConnectionManager, string3, string2, n13, string4, conversation$AVIMOperation, aVIMConversationSimpleResultCallback) ? 1 : 0);
            if (n10 == 0) {
                n11 = 119;
                object = "couldn't start service in background.";
                object3 = new AVException(n11, (String)object);
                aVIMConversationSimpleResultCallback.internalDone(null, (AVException)object3);
            }
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("offset/limit is illegal.");
        AVIMException aVIMException = new AVIMException(illegalArgumentException);
        aVIMConversationSimpleResultCallback.internalDone(null, aVIMException);
    }

    public void queryMutedMembers(int n10, String hashMap, AVIMConversationIterableResultCallback aVIMConversationIterableResultCallback) {
        if (aVIMConversationIterableResultCallback == null) {
            return;
        }
        int n11 = 100;
        if (n10 > n11) {
            hashMap = new HashMap<String, Integer>("limit is illegal.");
            AVIMException aVIMException = new AVIMException((Throwable)((Object)hashMap));
            aVIMConversationIterableResultCallback.internalDone(null, aVIMException);
            return;
        }
        n11 = 0;
        String string2 = null;
        boolean bl2 = StringUtil.isEmpty((String)((Object)hashMap));
        if (!bl2) {
            try {
                hashMap = Integer.valueOf((String)((Object)hashMap));
            }
            catch (NumberFormatException numberFormatException) {
                hashMap = new HashMap<String, Integer>("next is illegal.");
                AVIMException aVIMException = new AVIMException((Throwable)((Object)hashMap));
                aVIMConversationIterableResultCallback.internalDone(null, aVIMException);
                return;
            }
            n11 = (Integer)((Object)hashMap);
        }
        String string3 = this.getConversationId();
        hashMap = new HashMap<String, Integer>();
        Object object = n10;
        hashMap.put("limit", (Integer)object);
        object = n11;
        string2 = "skip";
        hashMap.put(string2, (Integer)object);
        OperationTube operationTube = InternalConfiguration.getOperationTube();
        AVConnectionManager aVConnectionManager = this.client.getConnectionManager();
        object = this.client;
        String string4 = ((AVIMClient)object).getClientId();
        int n12 = this.getType();
        String string5 = JSON.toJSONString(hashMap);
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_MUTED_MEMBER_QUERY;
        n10 = (int)(operationTube.processMembers(aVConnectionManager, string4, string3, n12, string5, conversation$AVIMOperation, aVIMConversationIterableResultCallback) ? 1 : 0);
        if (n10 == 0) {
            int n13 = 119;
            string2 = "couldn't start service in background.";
            object = new AVException(n13, string2);
            aVIMConversationIterableResultCallback.internalDone(null, (AVException)object);
        }
    }

    public void quit(AVIMConversationCallback object) {
        String string2 = this.getConversationId();
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            string2 = "ConversationId is empty";
            if (object != null) {
                int n10 = 102;
                AVException aVException = new AVException(n10, string2);
                ((AVCallback)object).internalDone(aVException);
            } else {
                object = LOGGER;
                ((AVLogger)object).w(string2);
            }
            return;
        }
        OperationTube operationTube = InternalConfiguration.getOperationTube();
        AVConnectionManager aVConnectionManager = this.client.getConnectionManager();
        String string3 = this.client.getClientId();
        String string4 = this.getConversationId();
        int n11 = this.getType();
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_QUIT;
        operationTube.participateConversation(aVConnectionManager, string3, string4, n11, null, conversation$AVIMOperation, (AVIMConversationCallback)object);
    }

    public void read() {
        boolean bl2 = this.isTransient();
        if (!bl2) {
            Object object;
            Object object2;
            Object object3 = this.getLastMessage();
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            if (object3 != null) {
                object2 = ((AVIMMessage)object3).getMessageId();
                object = "mid";
                hashMap.put(object, object2);
                long l10 = ((AVIMMessage)object3).getTimestamp();
                object3 = l10;
                object2 = "ts";
                hashMap.put(object2, object3);
            }
            object2 = InternalConfiguration.getOperationTube();
            object = this.client.getConnectionManager();
            object3 = this.client;
            String string2 = ((AVIMClient)object3).getClientId();
            String string3 = this.getConversationId();
            int n10 = this.getType();
            object2.markConversationRead((AVConnectionManager)object, string2, string3, n10, hashMap);
        } else {
            AVLogger aVLogger = LOGGER;
            String string4 = "transient conversation/chatroom doesn't support read command.";
            aVLogger.w(string4);
        }
    }

    public void recallMessage(AVIMMessage object, AVIMMessageRecalledCallback aVIMMessageRecalledCallback) {
        if (object == null) {
            if (aVIMMessageRecalledCallback != null) {
                String string2 = "message shouldn't be null";
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
                object = new AVException(illegalArgumentException);
                aVIMMessageRecalledCallback.internalDone((AVException)object);
            }
            return;
        }
        AVIMConversation$5 aVIMConversation$5 = new AVIMConversation$5(this, aVIMMessageRecalledCallback, (AVIMMessage)object);
        OperationTube operationTube = InternalConfiguration.getOperationTube();
        AVConnectionManager aVConnectionManager = this.client.getConnectionManager();
        String string3 = this.client.getClientId();
        int n10 = this.getType();
        operationTube.recallMessage(aVConnectionManager, string3, n10, (AVIMMessage)object, aVIMConversation$5);
    }

    public void remove(String object) {
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2) {
            OperationBuilder operationBuilder = OperationBuilder.gBuilder;
            OperationBuilder$OperationType operationBuilder$OperationType = OperationBuilder$OperationType.Delete;
            object = operationBuilder.create(operationBuilder$OperationType, (String)object, null);
            this.addNewOperation((ObjectFieldOperation)object);
        }
    }

    public void removeFromLocalCache(AVIMMessage aVIMMessage) {
        this.storage.removeLocalMessage(aVIMMessage);
    }

    public void sendMessage(AVIMMessage object, AVIMMessageOption object2, AVIMConversationCallback object3) {
        Object object4 = this.getConversationId();
        ((AVIMMessage)object).setConversationId((String)object4);
        object4 = this.client.getClientId();
        ((AVIMMessage)object).setFrom((String)object4);
        ((AVIMMessage)object).generateUniqueToken();
        long l10 = System.currentTimeMillis();
        ((AVIMMessage)object).setTimestamp(l10);
        object4 = AppConfiguration.getGlobalNetworkingDetector();
        boolean bl2 = object4.isConnected();
        if (!bl2) {
            object2 = AVIMMessage$AVIMMessageStatus.AVIMMessageStatusFailed;
            ((AVIMMessage)object).setMessageStatus((AVIMMessage$AVIMMessageStatus)((Object)object2));
            if (object3 != null) {
                int n10 = 100;
                object4 = "Connection lost";
                object = new AVException(n10, (String)object4);
                ((AVCallback)object3).internalDone((AVException)object);
            }
            return;
        }
        AVIMConversation$1 aVIMConversation$1 = new AVIMConversation$1(this, (AVIMMessage)object, (AVIMMessageOption)object2, (AVIMConversationCallback)object3);
        object4 = AVIMMessage$AVIMMessageStatus.AVIMMessageStatusSending;
        ((AVIMMessage)object).setMessageStatus((AVIMMessage$AVIMMessageStatus)((Object)object4));
        object4 = AVIMFileMessage.class;
        Object object5 = object.getClass();
        bl2 = ((Class)object4).isAssignableFrom((Class<?>)object5);
        if (bl2) {
            AVIMConversation$2 aVIMConversation$2;
            object4 = object;
            object4 = (AVIMFileMessage)object;
            object5 = aVIMConversation$2;
            AVIMConversation aVIMConversation = this;
            Object object6 = object;
            Object object7 = object3;
            aVIMConversation$2 = new AVIMConversation$2(this, (AVIMMessage)object, (AVIMConversationCallback)object3, (AVIMMessageOption)object2, aVIMConversation$1);
            AVIMFileMessageAccessor.upload((AVIMFileMessage)object4, aVIMConversation$2);
        } else {
            object5 = InternalConfiguration.getOperationTube();
            AVConnectionManager aVConnectionManager = this.client.getConnectionManager();
            object3 = this.client;
            String string2 = ((AVIMClient)object3).getClientId();
            String string3 = this.getConversationId();
            int n11 = this.getType();
            Object object8 = object2;
            object5.sendMessage(aVConnectionManager, string2, string3, n11, (AVIMMessage)object, (AVIMMessageOption)object2, aVIMConversation$1);
        }
    }

    public void sendMessage(AVIMMessage aVIMMessage, AVIMConversationCallback aVIMConversationCallback) {
        this.sendMessage(aVIMMessage, null, aVIMConversationCallback);
    }

    public void set(String object, Object object2) {
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2 && object2 != null) {
            OperationBuilder operationBuilder = OperationBuilder.gBuilder;
            OperationBuilder$OperationType operationBuilder$OperationType = OperationBuilder$OperationType.Set;
            object = operationBuilder.create(operationBuilder$OperationType, (String)object, object2);
            this.addNewOperation((ObjectFieldOperation)object);
        }
    }

    public void setAttribute(String string2, Object object) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (!bl2) {
            String string3 = "name";
            bl2 = string3.equals(string2);
            if (bl2) {
                this.set(string2, object);
            } else {
                string3 = ATTR_PERFIX;
                boolean bl3 = string2.startsWith(string3);
                if (!bl3) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string3);
                    stringBuilder.append(string2);
                    string2 = stringBuilder.toString();
                }
                this.set(string2, object);
            }
        }
    }

    public void setAttributes(Map object) {
        if (object != null) {
            boolean bl2;
            object = object.entrySet().iterator();
            while (bl2 = object.hasNext()) {
                Map.Entry entry = (Map.Entry)object.next();
                String string2 = (String)entry.getKey();
                entry = entry.getValue();
                this.setAttribute(string2, entry);
            }
        }
    }

    public void setAttributesForInit(Map map) {
        this.instanceData.put("attr", map);
    }

    public void setConversationId(String string2) {
        this.instanceData.put("objectId", string2);
    }

    public void setCreatedAt(String string2) {
        this.instanceData.put("createdAt", string2);
    }

    public void setCreator(String string2) {
        this.instanceData.put("c", string2);
    }

    public void setLastDeliveredAt(long l10, boolean bl2) {
        long l11 = this.lastDeliveredAt;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            this.lastDeliveredAt = l10;
            if (bl2) {
                AVIMMessageStorage aVIMMessageStorage = this.storage;
                aVIMMessageStorage.updateConversationTimes(this);
            }
        }
    }

    public void setLastMessage(AVIMMessage aVIMMessage) {
        if (aVIMMessage != null) {
            AVIMMessage aVIMMessage2 = this.lastMessage;
            if (aVIMMessage2 == null) {
                this.lastMessage = aVIMMessage;
            } else {
                long l10;
                long l11 = aVIMMessage2.getTimestamp();
                long l12 = l11 - (l10 = aVIMMessage.getTimestamp());
                Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object <= 0) {
                    this.lastMessage = aVIMMessage;
                }
            }
        }
    }

    public void setLastMessageAt(Date date) {
        boolean bl2;
        Date date2;
        if (date != null && ((date2 = this.lastMessageAt) == null || (bl2 = date.after(date2)))) {
            this.lastMessageAt = date;
        }
    }

    public void setLastReadAt(long l10, boolean bl2) {
        long l11 = this.lastReadAt;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            this.lastReadAt = l10;
            if (bl2) {
                AVIMMessageStorage aVIMMessageStorage = this.storage;
                aVIMMessageStorage.updateConversationTimes(this);
            }
        }
    }

    public void setMembers(List list) {
        this.instanceData.put("m", list);
    }

    public void setMustFetch() {
        this.latestConversationFetch = 0L;
    }

    public void setName(String string2) {
        this.set("name", string2);
    }

    public void setNameForInit(String string2) {
        this.instanceData.put("name", string2);
    }

    public void setSystem(boolean bl2) {
        Map map = this.instanceData;
        Boolean bl3 = bl2;
        map.put("sys", bl3);
    }

    public void setTemporary(boolean bl2) {
        Map map = this.instanceData;
        Boolean bl3 = bl2;
        map.put("temp", bl3);
    }

    public void setTemporaryExpiredat(long l10) {
        boolean bl2 = this.isTemporary();
        if (bl2) {
            Map map = this.instanceData;
            Long l11 = l10;
            String string2 = "ttl";
            map.put(string2, l11);
        }
    }

    public void setTransientForInit(boolean bl2) {
        Map map = this.instanceData;
        Boolean bl3 = bl2;
        map.put("tr", bl3);
    }

    public void setUniqueId(String object) {
        String string2 = "uniqueId";
        if (object != null) {
            Map map = this.instanceData;
            map.put(string2, object);
        } else {
            object = this.instanceData;
            object.remove(string2);
        }
    }

    public void setUpdatedAt(String string2) {
        this.instanceData.put("updatedAt", string2);
    }

    public String toJSONString() {
        return JSON.toJSONString(this.dumpRawData());
    }

    public String toString() {
        return this.toJSONString();
    }

    public void unblockMembers(List object, AVIMOperationPartiallySucceededCallback aVIMOperationPartiallySucceededCallback) {
        int n10;
        int n11;
        if (object != null && (n11 = object.size()) >= (n10 = 1)) {
            String string2 = this.getConversationId();
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            String string3 = "conversation.member";
            hashMap.put(string3, object);
            OperationTube operationTube = InternalConfiguration.getOperationTube();
            AVConnectionManager aVConnectionManager = this.client.getConnectionManager();
            object = this.client;
            String string4 = ((AVIMClient)object).getClientId();
            int n12 = this.getType();
            String string5 = JSON.toJSONString(hashMap);
            Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_UNBLOCK_MEMBER;
            boolean bl2 = operationTube.processMembers(aVConnectionManager, string4, string2, n12, string5, conversation$AVIMOperation, aVIMOperationPartiallySucceededCallback);
            if (!bl2 && aVIMOperationPartiallySucceededCallback != null) {
                n11 = 119;
                string3 = "couldn't start service in background.";
                object = new AVException(n11, string3);
                aVIMOperationPartiallySucceededCallback.internalDone((AVException)object);
            }
            return;
        }
        if (aVIMOperationPartiallySucceededCallback != null) {
            String string6 = "memberIds is null";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string6);
            object = new AVIMException(illegalArgumentException);
            n11 = 0;
            illegalArgumentException = null;
            aVIMOperationPartiallySucceededCallback.done((AVIMException)object, null, null);
        }
    }

    public void unmute(AVIMConversationCallback object) {
        String string2 = this.getConversationId();
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            string2 = "ConversationId is empty";
            if (object != null) {
                int n10 = 102;
                AVException aVException = new AVException(n10, string2);
                ((AVCallback)object).internalDone(aVException);
            } else {
                object = LOGGER;
                ((AVLogger)object).w(string2);
            }
            return;
        }
        OperationTube operationTube = InternalConfiguration.getOperationTube();
        AVConnectionManager aVConnectionManager = this.client.getConnectionManager();
        String string3 = this.client.getClientId();
        String string4 = this.getConversationId();
        int n11 = this.getType();
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_UNMUTE;
        operationTube.participateConversation(aVConnectionManager, string3, string4, n11, null, conversation$AVIMOperation, (AVIMConversationCallback)object);
    }

    public void unmuteMembers(List object, AVIMOperationPartiallySucceededCallback aVIMOperationPartiallySucceededCallback) {
        int n10;
        int n11;
        if (object != null && (n11 = object.size()) >= (n10 = 1)) {
            String string2 = this.getConversationId();
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            String string3 = "conversation.member";
            hashMap.put(string3, object);
            OperationTube operationTube = InternalConfiguration.getOperationTube();
            AVConnectionManager aVConnectionManager = this.client.getConnectionManager();
            object = this.client;
            String string4 = ((AVIMClient)object).getClientId();
            int n12 = this.getType();
            String string5 = JSON.toJSONString(hashMap);
            Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_UNMUTE_MEMBER;
            boolean bl2 = operationTube.processMembers(aVConnectionManager, string4, string2, n12, string5, conversation$AVIMOperation, aVIMOperationPartiallySucceededCallback);
            if (!bl2 && aVIMOperationPartiallySucceededCallback != null) {
                n11 = 119;
                string3 = "couldn't start service in background.";
                object = new AVException(n11, string3);
                aVIMOperationPartiallySucceededCallback.internalDone(null, (AVException)object);
            }
            return;
        }
        if (aVIMOperationPartiallySucceededCallback != null) {
            String string6 = "memberIds is null";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string6);
            object = new AVIMException(illegalArgumentException);
            aVIMOperationPartiallySucceededCallback.done((AVIMException)object, null, null);
        }
    }

    public boolean unreadMessagesMentioned() {
        return this.unreadMessagesMentioned;
    }

    public void updateFetchTimestamp(long l10) {
        this.latestConversationFetch = l10;
    }

    public void updateInfoInBackground(AVIMConversationCallback object) {
        Object object2 = this.operations;
        boolean bl2 = object2.isEmpty();
        if (!bl2) {
            Object object3;
            boolean bl3;
            HashMap hashMap = new HashMap();
            object2 = this.operations.entrySet().iterator();
            while (bl3 = object2.hasNext()) {
                object3 = ((ObjectFieldOperation)((Map.Entry)object2.next()).getValue()).encode();
                hashMap.putAll(object3);
            }
            AVIMConversation$14 aVIMConversation$14 = new AVIMConversation$14(this, (AVIMConversationCallback)object);
            object3 = InternalConfiguration.getOperationTube();
            AVConnectionManager aVConnectionManager = this.client.getConnectionManager();
            object = this.client;
            String string2 = ((AVIMClient)object).getClientId();
            String string3 = this.getConversationId();
            int n10 = this.getType();
            object3.updateConversation(aVConnectionManager, string2, string3, n10, hashMap, aVIMConversation$14);
        } else if (object != null) {
            bl2 = false;
            object2 = null;
            ((AVCallback)object).internalDone(null);
        }
    }

    public void updateLocalMessage(AVIMMessage aVIMMessage) {
        this.storage.updateMessageForPatch(aVIMMessage);
    }

    public void updateMemberRole(String serializable, ConversationMemberRole object, AVIMConversationCallback aVIMConversationCallback) {
        String string2 = this.getConversationId();
        Object object2 = new AVIMConversationMemberInfo(string2, (String)((Object)serializable), (ConversationMemberRole)((Object)object));
        serializable = new Serializable();
        object = ((AVIMConversationMemberInfo)object2).getUpdateAttrs();
        serializable.put("conversation.memberDetails", (ConversationMemberRole)((Object)object));
        object2 = InternalConfiguration.getOperationTube();
        AVConnectionManager aVConnectionManager = this.client.getConnectionManager();
        object = this.client;
        String string3 = ((AVIMClient)object).getClientId();
        int n10 = this.getType();
        String string4 = JSON.toJSONString(serializable);
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_PROMOTE_MEMBER;
        boolean bl2 = object2.processMembers(aVConnectionManager, string3, string2, n10, string4, conversation$AVIMOperation, aVIMConversationCallback);
        if (!bl2 && aVIMConversationCallback != null) {
            int n11 = 119;
            object2 = "couldn't start service in background.";
            serializable = new Serializable(n11, (String)object2);
            aVIMConversationCallback.internalDone((AVException)serializable);
        }
    }

    public void updateMessage(AVIMMessage object, AVIMMessage object2, AVIMMessageUpdatedCallback object3) {
        if (object != null && object2 != null) {
            AVIMConversation$3 aVIMConversation$3 = new AVIMConversation$3(this, (AVIMMessageUpdatedCallback)object3, (AVIMMessage)object, (AVIMMessage)object2);
            Class<AVIMFileMessage> clazz = AVIMFileMessage.class;
            Class<?> clazz2 = object2.getClass();
            boolean bl2 = clazz.isAssignableFrom(clazz2);
            if (bl2) {
                AVIMConversation$4 aVIMConversation$4;
                Object object4 = object2;
                object4 = (AVIMFileMessage)object2;
                clazz = aVIMConversation$4;
                clazz2 = this;
                Object object5 = object2;
                aVIMConversation$4 = new AVIMConversation$4(this, (AVIMMessage)object2, (AVIMMessageUpdatedCallback)object3, (AVIMMessage)object, aVIMConversation$3);
                AVIMFileMessageAccessor.upload((AVIMFileMessage)object4, aVIMConversation$4);
            } else {
                clazz = InternalConfiguration.getOperationTube();
                clazz2 = this.client.getConnectionManager();
                object3 = this.client;
                String string2 = ((AVIMClient)object3).getClientId();
                int n10 = this.getType();
                clazz.updateMessage((AVConnectionManager)((Object)clazz2), string2, n10, (AVIMMessage)object, (AVIMMessage)object2, (AVIMCommonJsonCallback)aVIMConversation$3);
            }
            return;
        }
        if (object3 != null) {
            String string3 = "oldMessage/newMessage shouldn't be null";
            object2 = new IllegalArgumentException(string3);
            object = new AVException((Throwable)object2);
            ((AVCallback)object3).internalDone((AVException)object);
        }
    }

    public void updateUnreadCountAndMessage(AVIMMessage object, int n10, boolean bl2) {
        int n11;
        if (object != null) {
            this.setLastMessage((AVIMMessage)object);
            AVIMMessageStorage aVIMMessageStorage = this.storage;
            boolean bl3 = true;
            aVIMMessageStorage.insertMessage((AVIMMessage)object, bl3);
        }
        if ((n11 = this.unreadMessagesCount) != n10) {
            this.unreadMessagesCount = n10;
            this.unreadMessagesMentioned = bl2;
            object = this.getConversationId();
            AVIMMessageStorage aVIMMessageStorage = this.storage;
            int n12 = this.unreadMessagesCount;
            long l10 = n12;
            aVIMMessageStorage.updateConversationUreadCount((String)object, l10, bl2);
        }
    }
}

