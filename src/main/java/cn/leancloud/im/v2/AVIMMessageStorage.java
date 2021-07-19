/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.AVLogger;
import cn.leancloud.codec.Base64;
import cn.leancloud.im.DatabaseDelegate;
import cn.leancloud.im.InternalConfiguration;
import cn.leancloud.im.v2.AVIMBinaryMessage;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMMessage;
import cn.leancloud.im.v2.AVIMMessage$AVIMMessageStatus;
import cn.leancloud.im.v2.AVIMMessageStorage$MessageQueryResult;
import cn.leancloud.im.v2.AVIMMessageStorage$StorageMessageCallback;
import cn.leancloud.im.v2.AVIMMessageStorage$StorageQueryCallback;
import cn.leancloud.json.JSON;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class AVIMMessageStorage {
    public static final String BLOB = "BLOB";
    public static final String COLUMN_ATTRIBUTE = "attr";
    public static final String COLUMN_BREAKPOINT = "breakpoint";
    public static final String COLUMN_CONVERSATION_ID = "conversation_id";
    public static final String COLUMN_CONVERSATION_READAT = "readAt";
    public static final String COLUMN_CONVRESATION_DELIVEREDAT = "deliveredAt";
    public static final String COLUMN_CONV_LASTMESSAGE_INNERTYPE = "last_msg_iType";
    public static final String COLUMN_CONV_MENTIONED = "mentioned";
    public static final String COLUMN_CONV_SYSTEM = "sys";
    public static final String COLUMN_CONV_TEMP = "temp";
    public static final String COLUMN_CONV_TEMP_TTL = "temp_ttl";
    public static final String COLUMN_CREATEDAT = "createdAt";
    public static final String COLUMN_CREATOR = "creator";
    public static final String COLUMN_DEDUPLICATED_TOKEN = "dtoken";
    public static final String COLUMN_EXPIREAT = "expireAt";
    public static final String COLUMN_FROM_PEER_ID = "from_peer_id";
    public static final String COLUMN_INSTANCEDATA = "instanceData";
    public static final String COLUMN_LASTMESSAGE = "last_message";
    public static final String COLUMN_LM = "lm";
    public static final String COLUMN_MEMBERS = "members";
    public static final String COLUMN_MESSAGE_DELIVEREDAT = "receipt_timestamp";
    public static final String COLUMN_MESSAGE_ID = "message_id";
    public static final String COLUMN_MESSAGE_READAT = "readAt";
    public static final String COLUMN_MESSAGE_UPDATEAT = "updateAt";
    public static final String COLUMN_MSG_INNERTYPE = "iType";
    public static final String COLUMN_MSG_MENTION_ALL = "mentionAll";
    public static final String COLUMN_MSG_MENTION_LIST = "mentionList";
    public static final String COLUMN_PAYLOAD = "payload";
    public static final String COLUMN_STATUS = "status";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String COLUMN_TRANSIENT = "isTransient";
    public static final String COLUMN_UNREAD_COUNT = "unread_count";
    public static final String COLUMN_UPDATEDAT = "updatedAt";
    public static final String CONVERSATION_TABLE = "conversations";
    public static final String DB_NAME_PREFIX = "com.avos.avoscloud.im.v2.";
    public static final int DB_VERSION = 10;
    public static final String INTEGER = "INTEGER";
    private static final AVLogger LOGGER;
    public static final String MESSAGE_INDEX = "message_index";
    public static final int MESSAGE_INNERTYPE_BIN = 1;
    public static final int MESSAGE_INNERTYPE_PLAIN = 0;
    public static final String MESSAGE_TABLE = "messages";
    public static final String NUMBERIC = "NUMBERIC";
    public static final String TEXT = "TEXT";
    public static final String VARCHAR32 = "VARCHAR(32)";
    private static ConcurrentMap storages;
    private String clientId;
    private DatabaseDelegate delegate;

    static {
        ConcurrentHashMap concurrentHashMap;
        LOGGER = LogUtil.getLogger(AVIMMessageStorage.class);
        storages = concurrentHashMap = new ConcurrentHashMap();
    }

    private AVIMMessageStorage(String object) {
        String string2 = null;
        this.delegate = null;
        this.clientId = null;
        this.clientId = object;
        object = InternalConfiguration.getDatabaseDelegateFactory();
        if (object != null) {
            string2 = this.clientId;
            this.delegate = object = object.createInstance(string2);
        }
    }

    private String generateInternalMessageId(String string2) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            string2 = "";
        }
        return string2;
    }

    public static AVIMMessageStorage getInstance(String object) {
        ConcurrentMap concurrentMap;
        Object object2 = (AVIMMessageStorage)storages.get(object);
        if (object2 == null && (object = (concurrentMap = storages).putIfAbsent(object, object2 = new AVIMMessageStorage((String)object))) != null) {
            object2 = object;
        }
        return object2;
    }

    private static String getWhereClause(String ... stringArray) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string2 : stringArray) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(" = ? ");
            string2 = stringBuilder.toString();
            arrayList.add(string2);
        }
        return StringUtil.join(" and ", arrayList);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int insertMessages(List iterator2, boolean bl2) {
        synchronized (this) {
            DatabaseDelegate databaseDelegate = this.delegate;
            if (databaseDelegate == null) {
                return 0;
            }
            iterator2 = iterator2.iterator();
            int n10 = 0;
            databaseDelegate = null;
            int n11;
            while ((n11 = iterator2.hasNext()) != 0) {
                void var2_2;
                Object object;
                Object object2 = iterator2.next();
                object2 = (AVIMMessage)object2;
                HashMap<String, Object> hashMap = new HashMap<String, Object>();
                String string2 = COLUMN_CONVERSATION_ID;
                Object object3 = ((AVIMMessage)object2).getConversationId();
                hashMap.put(string2, object3);
                string2 = COLUMN_MESSAGE_ID;
                object3 = ((AVIMMessage)object2).getMessageId();
                hashMap.put(string2, object3);
                string2 = COLUMN_TIMESTAMP;
                long l10 = ((AVIMMessage)object2).getTimestamp();
                object3 = l10;
                hashMap.put(string2, object3);
                string2 = COLUMN_FROM_PEER_ID;
                object3 = ((AVIMMessage)object2).getFrom();
                hashMap.put(string2, object3);
                boolean bl3 = object2 instanceof AVIMBinaryMessage;
                int n12 = 1;
                if (bl3) {
                    string2 = COLUMN_PAYLOAD;
                    object = object2;
                    object = (AVIMBinaryMessage)object2;
                    object = ((AVIMBinaryMessage)object).getBytes();
                    hashMap.put(string2, object);
                    string2 = COLUMN_MSG_INNERTYPE;
                    object = n12;
                    hashMap.put(string2, object);
                } else {
                    string2 = COLUMN_PAYLOAD;
                    try {
                        object = ((AVIMMessage)object2).getContent();
                        String string3 = "UTF-8";
                        object = ((String)object).getBytes(string3);
                        hashMap.put(string2, object);
                    }
                    catch (UnsupportedEncodingException unsupportedEncodingException) {}
                    string2 = COLUMN_MSG_INNERTYPE;
                    object = 0;
                    hashMap.put(string2, object);
                }
                string2 = COLUMN_MESSAGE_DELIVEREDAT;
                long l11 = ((AVIMMessage)object2).getDeliveredAt();
                object = l11;
                hashMap.put(string2, object);
                string2 = "readAt";
                l11 = ((AVIMMessage)object2).getReadAt();
                object = l11;
                hashMap.put(string2, object);
                string2 = COLUMN_MESSAGE_UPDATEAT;
                l11 = ((AVIMMessage)object2).getUpdateAt();
                object = l11;
                hashMap.put(string2, object);
                string2 = COLUMN_STATUS;
                object = ((AVIMMessage)object2).getMessageStatus();
                int n13 = ((AVIMMessage$AVIMMessageStatus)((Object)object)).getStatusCode();
                object = n13;
                hashMap.put(string2, object);
                string2 = COLUMN_BREAKPOINT;
                if (var2_2 != false) {
                    n13 = n12;
                } else {
                    n13 = 0;
                    object = null;
                }
                object = n13;
                hashMap.put(string2, object);
                string2 = COLUMN_MSG_MENTION_ALL;
                n13 = (int)(((AVIMMessage)object2).isMentionAll() ? 1 : 0);
                if (n13 == 0) {
                    n12 = 0;
                    object3 = null;
                }
                object3 = n12;
                hashMap.put(string2, object3);
                string2 = COLUMN_MSG_MENTION_LIST;
                object2 = ((AVIMMessage)object2).getMentionListString();
                hashMap.put(string2, object2);
                object2 = this.delegate;
                string2 = MESSAGE_TABLE;
                n11 = object2.insert(string2, hashMap);
                if (n11 < 0) continue;
                ++n10;
            }
            return n10;
        }
    }

    private int updateBreakpointsForBatch(List hashMap, boolean bl2, String stringArray) {
        synchronized (this) {
            Object object;
            CharSequence charSequence;
            Object object2;
            DatabaseDelegate databaseDelegate;
            int n10;
            block28: {
                block27: {
                    stringArray = this.delegate;
                    n10 = 0;
                    databaseDelegate = null;
                    if (stringArray != null) break block27;
                    return 0;
                }
                int n11 = hashMap.size();
                stringArray = new String[n11];
                object2 = new ArrayList();
                int n12 = 0;
                charSequence = null;
                while (true) {
                    int n13 = hashMap.size();
                    if (n12 >= n13) break;
                    object = hashMap.get(n12);
                    object = (AVIMMessage)object;
                    object = ((AVIMMessage)object).getMessageId();
                    stringArray[n12] = object;
                    object = "?";
                    object2.add(object);
                    ++n12;
                    continue;
                    break;
                }
                hashMap = new HashMap<String, Integer>();
                charSequence = COLUMN_BREAKPOINT;
                if (!bl2) break block28;
                n10 = 1;
            }
            Object object3 = n10;
            hashMap.put((String)charSequence, (Integer)object3);
            object3 = ",";
            object3 = StringUtil.join((CharSequence)object3, object2);
            databaseDelegate = this.delegate;
            object2 = MESSAGE_TABLE;
            charSequence = new StringBuilder();
            object = "message_id in (";
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append((String)object3);
            object3 = ") ";
            ((StringBuilder)charSequence).append((String)object3);
            object3 = ((StringBuilder)charSequence).toString();
            int n14 = databaseDelegate.update((String)object2, hashMap, (String)object3, stringArray);
            return n14;
        }
    }

    public boolean containMessage(AVIMMessage object) {
        String string2;
        DatabaseDelegate databaseDelegate = this.delegate;
        boolean bl2 = false;
        if (databaseDelegate == null) {
            return false;
        }
        String[] stringArray = new String[]{};
        String string3 = AVIMMessageStorage.getWhereClause(COLUMN_CONVERSATION_ID, COLUMN_MESSAGE_ID);
        int n10 = 2;
        String[] stringArray2 = new String[n10];
        stringArray2[0] = string2 = ((AVIMMessage)object).getConversationId();
        object = ((AVIMMessage)object).getMessageId();
        boolean bl3 = true;
        stringArray2[bl3] = object;
        string2 = MESSAGE_TABLE;
        int n11 = databaseDelegate.queryCount(string2, stringArray, string3, stringArray2, null, null, null);
        if (n11 > 0) {
            bl2 = bl3;
        }
        return bl2;
    }

    public void deleteClientData() {
        synchronized (this) {
            DatabaseDelegate databaseDelegate;
            block5: {
                databaseDelegate = this.delegate;
                if (databaseDelegate != null) break block5;
                return;
            }
            String string2 = MESSAGE_TABLE;
            databaseDelegate.delete(string2, null, null);
            databaseDelegate = this.delegate;
            string2 = CONVERSATION_TABLE;
            databaseDelegate.delete(string2, null, null);
            return;
        }
    }

    public void deleteConversation(String string2) {
        DatabaseDelegate databaseDelegate = this.delegate;
        if (databaseDelegate == null) {
            return;
        }
        String string3 = AVIMMessageStorage.getWhereClause(COLUMN_CONVERSATION_ID);
        String[] stringArray = new String[]{string2};
        databaseDelegate.delete(CONVERSATION_TABLE, string3, stringArray);
    }

    public void deleteConversationData(String string2) {
        synchronized (this) {
            DatabaseDelegate databaseDelegate;
            block13: {
                databaseDelegate = this.delegate;
                if (databaseDelegate != null) break block13;
                return;
            }
            String string3 = MESSAGE_TABLE;
            Object object = "conversation_id";
            object = new String[]{object};
            object = AVIMMessageStorage.getWhereClause(object);
            int n10 = 1;
            String[] stringArray = new String[n10];
            stringArray[0] = string2;
            databaseDelegate.delete(string3, (String)object, stringArray);
            databaseDelegate = this.delegate;
            string3 = CONVERSATION_TABLE;
            object = COLUMN_CONVERSATION_ID;
            object = new String[]{object};
            object = AVIMMessageStorage.getWhereClause(object);
            String[] stringArray2 = new String[n10];
            stringArray2[0] = string2;
            databaseDelegate.delete(string3, (String)object, stringArray2);
            return;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void deleteMessages(List iterator2, String string2) {
        synchronized (this) {
            List<AVIMMessage> list = this.delegate;
            if (list == null) {
                return;
            }
            iterator2 = iterator2.iterator();
            boolean bl2;
            while (bl2 = iterator2.hasNext()) {
                list = iterator2.next();
                list = (AVIMMessage)((Object)list);
                String string3 = ((AVIMMessage)((Object)list)).getMessageId();
                Object object = this.getNextMessage((AVIMMessage)((Object)list));
                int n10 = 1;
                if (object != null) {
                    void var2_2;
                    object = new AVIMMessage[n10];
                    object[0] = list;
                    list = Arrays.asList(object);
                    this.updateBreakpoints(list, n10 != 0, (String)var2_2);
                }
                list = this.delegate;
                object = MESSAGE_TABLE;
                Object object2 = "message_id";
                object2 = new String[]{object2};
                object2 = AVIMMessageStorage.getWhereClause(object2);
                String[] stringArray = new String[n10];
                stringArray[0] = string3;
                list.delete((String)object, (String)object2, stringArray);
            }
            return;
        }
    }

    public List getCachedConversations(List object) {
        Serializable serializable = new LinkedList();
        DatabaseDelegate databaseDelegate = this.delegate;
        if (databaseDelegate == null) {
            return serializable;
        }
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("SELECT * FROM conversations WHERE conversation_id in ('");
        object = StringUtil.join("','", (Iterable)object);
        ((StringBuilder)serializable).append((String)object);
        ((StringBuilder)serializable).append("')");
        object = ((StringBuilder)serializable).toString();
        return databaseDelegate.rawQueryConversations((String)object, null);
    }

    public AVIMConversation getConversation(String object) {
        int n10;
        int n11 = 1;
        String[] stringArray = new String[n11];
        stringArray[0] = object;
        object = Arrays.asList(stringArray);
        if ((object = this.getCachedConversations((List)object)) != null && (n10 = object.size()) >= n11) {
            return (AVIMConversation)object.get(0);
        }
        return null;
    }

    public AVIMMessage getLatestMessage(String object) {
        int n10;
        Object object2 = this.delegate;
        if (object2 == null) {
            return null;
        }
        String string2 = AVIMMessageStorage.getWhereClause(COLUMN_CONVERSATION_ID);
        int n11 = 1;
        String[] stringArray = new String[n11];
        stringArray[0] = object;
        String string3 = "timestamp desc, message_id desc";
        String string4 = "1";
        object = object2.queryMessages(null, string2, stringArray, null, null, string3, string4);
        if (object != null && (object2 = ((AVIMMessageStorage$MessageQueryResult)object).messages) != null && (n10 = object2.size()) >= n11) {
            return (AVIMMessage)((AVIMMessageStorage$MessageQueryResult)object).messages.get(0);
        }
        return null;
    }

    public AVIMMessage getLatestMessageWithBreakpoint(String object, boolean n10) {
        int n11;
        Object object2 = this.delegate;
        if (object2 == null) {
            return null;
        }
        String string2 = AVIMMessageStorage.getWhereClause(COLUMN_CONVERSATION_ID, COLUMN_BREAKPOINT);
        int n12 = 2;
        String[] stringArray = new String[n12];
        stringArray[0] = object;
        object = n10 != 0 ? "1" : "0";
        n10 = 1;
        stringArray[n10] = object;
        String string3 = "timestamp desc, message_id desc";
        String string4 = "1";
        object = object2.queryMessages(null, string2, stringArray, null, null, string3, string4);
        if (object != null && (object2 = ((AVIMMessageStorage$MessageQueryResult)object).messages) != null && (n11 = object2.size()) >= n10) {
            return (AVIMMessage)((AVIMMessageStorage$MessageQueryResult)object).messages.get(0);
        }
        return null;
    }

    public void getMessage(String string2, long l10, String string3, AVIMMessageStorage$StorageMessageCallback aVIMMessageStorage$StorageMessageCallback) {
        AVIMMessageStorage$StorageMessageCallback aVIMMessageStorage$StorageMessageCallback2 = aVIMMessageStorage$StorageMessageCallback;
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        AVIMMessage aVIMMessage = null;
        boolean bl2 = false;
        Boolean bl3 = null;
        if (l12 <= 0) {
            aVIMMessageStorage$StorageMessageCallback.done(null, false);
        } else {
            Object object = this.delegate;
            if (object == null) {
                aVIMMessageStorage$StorageMessageCallback.done(null, false);
            } else {
                List list;
                int n10 = 1;
                if (string2 == null) {
                    String string4;
                    String[] stringArray = AVIMMessageStorage.getWhereClause(COLUMN_TIMESTAMP, COLUMN_CONVERSATION_ID);
                    String[] stringArray2 = new String[2];
                    stringArray2[0] = string4 = Long.toString(l10);
                    stringArray2[n10] = string3;
                    String string5 = "1";
                    n10 = 0;
                    list = null;
                    String[] stringArray3 = stringArray;
                    stringArray = stringArray2;
                    stringArray2 = null;
                    string4 = null;
                    object = object.queryMessages(null, (String)stringArray3, stringArray, null, null, null, string5);
                } else {
                    String[] stringArray = AVIMMessageStorage.getWhereClause(COLUMN_MESSAGE_ID);
                    String[] stringArray4 = new String[n10];
                    stringArray4[0] = string2;
                    String string6 = "1";
                    n10 = 0;
                    list = null;
                    String[] stringArray5 = stringArray;
                    stringArray = stringArray4;
                    stringArray4 = null;
                    Object var17_18 = null;
                    object = object.queryMessages(null, (String)stringArray5, stringArray, null, null, null, string6);
                }
                if (object != null) {
                    list = ((AVIMMessageStorage$MessageQueryResult)object).messages;
                    if (list != null && (n10 = list.size()) > 0) {
                        aVIMMessage = (AVIMMessage)((AVIMMessageStorage$MessageQueryResult)object).messages.get(0);
                    }
                    if ((list = ((AVIMMessageStorage$MessageQueryResult)object).breakpoints) != null && (n10 = list.size()) > 0) {
                        object = ((AVIMMessageStorage$MessageQueryResult)object).breakpoints;
                        bl3 = (Boolean)object.get(0);
                        bl2 = bl3;
                    }
                }
                aVIMMessageStorage$StorageMessageCallback2.done(aVIMMessage, bl2);
            }
        }
    }

    public long getMessageCount(String string2) {
        Object object = this.delegate;
        if (object == null) {
            return 0L;
        }
        int n10 = 1;
        AVIMMessage aVIMMessage = this.getLatestMessageWithBreakpoint(string2, n10 != 0);
        if (aVIMMessage == null) {
            object = new String[n10];
            object[0] = string2;
            string2 = "select count(*) from messages where conversation_id = ?";
        } else {
            int n11 = 4;
            String[] stringArray = new String[n11];
            stringArray[0] = string2;
            stringArray[n10] = string2 = String.valueOf(aVIMMessage.getTimestamp());
            long l10 = aVIMMessage.getTimestamp();
            stringArray[2] = object = String.valueOf(l10);
            int n12 = 3;
            stringArray[n12] = object = aVIMMessage.getMessageId();
            string2 = "select count(*) from messages where conversation_id = ? and (timestamp > ? or ( timestamp = ? and message_id >= ? )) order by timestamp desc, message_id desc";
            object = stringArray;
        }
        return this.delegate.countForQuery(string2, (String[])object);
    }

    public void getMessages(String string2, long l10, int n10, String string3, AVIMMessageStorage$StorageQueryCallback aVIMMessageStorage$StorageQueryCallback) {
        String string4;
        Object object;
        String[] stringArray;
        Object object2;
        AVIMMessageStorage aVIMMessageStorage = this;
        AVIMMessageStorage$StorageQueryCallback aVIMMessageStorage$StorageQueryCallback2 = aVIMMessageStorage$StorageQueryCallback;
        Object object3 = this.delegate;
        List list = null;
        if (object3 == null) {
            aVIMMessageStorage$StorageQueryCallback.done(null, null);
            return;
        }
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        String string5 = null;
        int n11 = 1;
        if (l12 > 0) {
            l12 = 2;
            if (string2 == null) {
                object3 = new String[l12];
                object2 = Long.toString(l10);
                object3[0] = object2;
                object3[n11] = string3;
                string5 = "timestamp < ? and conversation_id = ? ";
                stringArray = object3;
                object = string5;
            } else {
                int n12 = 4;
                object2 = new String[n12];
                object2[0] = string4 = Long.toString(l10);
                object2[n11] = string5 = Long.toString(l10);
                object2[l12] = string2;
                l12 = 3;
                object2[l12] = string3;
                string5 = " ( timestamp < ? or (timestamp = ? and message_id < ? )) and conversation_id = ? ";
                object = string5;
                stringArray = object2;
            }
        } else {
            object3 = AVIMMessageStorage.getWhereClause(COLUMN_CONVERSATION_ID);
            String[] stringArray2 = new String[n11];
            stringArray2[0] = string3;
            object = object3;
            stringArray = stringArray2;
        }
        object2 = aVIMMessageStorage.delegate;
        string4 = null;
        object3 = new StringBuilder();
        ((StringBuilder)object3).append(n10);
        string5 = "";
        ((StringBuilder)object3).append(string5);
        String string6 = ((StringBuilder)object3).toString();
        String string7 = "timestamp desc, message_id desc";
        object3 = object2.queryMessages(null, (String)object, stringArray, null, null, string7, string6);
        if (object3 == null) {
            aVIMMessageStorage$StorageQueryCallback2.done(null, null);
        } else {
            list = ((AVIMMessageStorage$MessageQueryResult)object3).messages;
            object3 = ((AVIMMessageStorage$MessageQueryResult)object3).breakpoints;
            aVIMMessageStorage$StorageQueryCallback2.done(list, (List)object3);
        }
    }

    public AVIMMessage getNextMessage(AVIMMessage object) {
        int n10;
        String string2;
        String string3;
        Object object2 = this.delegate;
        if (object2 == null) {
            return null;
        }
        String[] stringArray = new String[4];
        stringArray[0] = string3 = Long.toString(((AVIMMessage)object).getTimestamp());
        long l10 = ((AVIMMessage)object).getTimestamp();
        string3 = Long.toString(l10);
        int n11 = 1;
        stringArray[n11] = string3;
        stringArray[2] = string2 = ((AVIMMessage)object).getMessageId();
        int n12 = 3;
        stringArray[n12] = object = ((AVIMMessage)object).getConversationId();
        string2 = null;
        string3 = " ( timestamp > ? or (timestamp = ? and message_id > ? )) and conversation_id = ? ";
        String string4 = "timestamp , message_id";
        String string5 = "1";
        object = object2.queryMessages(null, string3, stringArray, null, null, string4, string5);
        if (object != null && (object2 = ((AVIMMessageStorage$MessageQueryResult)object).messages) != null && (n10 = object2.size()) >= n11) {
            return (AVIMMessage)((AVIMMessageStorage$MessageQueryResult)object).messages.get(0);
        }
        return null;
    }

    public void insertContinuousMessages(List list, String string2) {
        boolean bl2;
        DatabaseDelegate databaseDelegate = this.delegate;
        if (databaseDelegate == null) {
            return;
        }
        if (list != null && !(bl2 = list.isEmpty()) && !(bl2 = StringUtil.isEmpty(string2))) {
            boolean bl3;
            bl2 = false;
            databaseDelegate = null;
            AVIMMessage aVIMMessage = (AVIMMessage)list.get(0);
            int n10 = list.size();
            int n11 = 1;
            List list2 = list.subList(n11, n10);
            int n12 = list.size() - n11;
            if ((n12 = (int)(this.containMessage((AVIMMessage)((Object)(list = (AVIMMessage)list.get(n12)))) ? 1 : 0)) == 0 && (list = this.getNextMessage((AVIMMessage)((Object)list))) != null) {
                AVIMMessage[] aVIMMessageArray = new AVIMMessage[n11];
                aVIMMessageArray[0] = list;
                list = Arrays.asList(aVIMMessageArray);
                this.updateBreakpoints(list, n11 != 0, string2);
            }
            if (!(bl3 = list2.isEmpty())) {
                this.insertMessages(list2, false);
                this.updateBreakpoints(list2, false, string2);
            }
            this.insertMessage(aVIMMessage, n11 != 0);
        }
    }

    public int insertConversations(List object) {
        int n10;
        Object object2 = this.delegate;
        if (object2 == null) {
            return 0;
        }
        object = object.iterator();
        while (true) {
            Object object3;
            boolean bl2 = object.hasNext();
            n10 = 1;
            if (!bl2) break;
            object2 = (AVIMConversation)object.next();
            Serializable serializable = new HashMap();
            Object object4 = JSON.toJSONString(((AVIMConversation)object2).getAttributes());
            serializable.put(COLUMN_ATTRIBUTE, object4);
            object4 = JSON.toJSONString(((AVIMConversation)object2).instanceData);
            serializable.put(COLUMN_INSTANCEDATA, object4);
            object4 = ((AVIMConversation)object2).getCreatedAt();
            serializable.put(COLUMN_CREATEDAT, object4);
            object4 = ((AVIMConversation)object2).getUpdatedAt();
            serializable.put(COLUMN_UPDATEDAT, object4);
            object4 = ((AVIMConversation)object2).getCreator();
            serializable.put(COLUMN_CREATOR, object4);
            long l10 = System.currentTimeMillis();
            long l11 = 3600000L;
            object4 = l10 += l11;
            String string2 = COLUMN_EXPIREAT;
            serializable.put(string2, object4);
            object4 = ((AVIMConversation)object2).lastMessageAt;
            if (object4 != null) {
                l10 = ((Date)object4).getTime();
                object4 = l10;
                string2 = COLUMN_LM;
                serializable.put(string2, object4);
            }
            if ((object4 = ((AVIMConversation)object2).getLastMessage()) != null) {
                int n11 = object4 instanceof AVIMBinaryMessage;
                String string3 = COLUMN_CONV_LASTMESSAGE_INNERTYPE;
                String string4 = COLUMN_LASTMESSAGE;
                if (n11 != 0) {
                    object4 = ((AVIMBinaryMessage)object4).getBytes();
                    n11 = 2;
                    object4 = Base64.encodeToString((byte[])object4, n11);
                    serializable.put(string4, object4);
                    object3 = n10;
                    serializable.put(string3, object3);
                } else {
                    object3 = JSON.toJSONString(object4);
                    serializable.put(string4, object3);
                    object3 = 0;
                    serializable.put(string3, object3);
                }
            }
            object3 = JSON.toJSONString(((AVIMConversation)object2).getMembers());
            serializable.put(COLUMN_MEMBERS, object3);
            object3 = (int)(((AVIMConversation)object2).isTransient() ? 1 : 0);
            serializable.put(COLUMN_TRANSIENT, object3);
            object3 = ((AVIMConversation)object2).getUnreadMessagesCount();
            serializable.put(COLUMN_UNREAD_COUNT, object3);
            object3 = (int)(((AVIMConversation)object2).unreadMessagesMentioned() ? 1 : 0);
            serializable.put(COLUMN_CONV_MENTIONED, object3);
            object3 = ((AVIMConversation)object2).getLastReadAt();
            serializable.put("readAt", object3);
            l10 = ((AVIMConversation)object2).getLastDeliveredAt();
            object3 = l10;
            serializable.put(COLUMN_CONVRESATION_DELIVEREDAT, object3);
            object3 = ((AVIMConversation)object2).getConversationId();
            serializable.put(COLUMN_CONVERSATION_ID, object3);
            object3 = (int)(((AVIMConversation)object2).isSystem() ? 1 : 0);
            serializable.put(COLUMN_CONV_SYSTEM, object3);
            object3 = (int)(((AVIMConversation)object2).isTemporary() ? 1 : 0);
            serializable.put(COLUMN_CONV_TEMP, object3);
            object3 = ((AVIMConversation)object2).getTemporaryExpiredat();
            serializable.put(COLUMN_CONV_TEMP_TTL, object3);
            object3 = this.delegate;
            object4 = CONVERSATION_TABLE;
            n10 = object3.insert((String)object4, (Map)((Object)serializable));
            if (n10 >= 0) continue;
            object3 = LOGGER;
            serializable = new StringBuilder();
            object4 = "failed to insert conversation. conversationId=";
            ((StringBuilder)serializable).append((String)object4);
            object2 = ((AVIMConversation)object2).getConversationId();
            ((StringBuilder)serializable).append((String)object2);
            object2 = ((StringBuilder)serializable).toString();
            ((AVLogger)object3).d((String)object2);
        }
        return n10;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean insertLocalMessage(AVIMMessage object) {
        synchronized (this) {
            void var11_14;
            long l10;
            Object object2;
            HashMap<Object, Object> hashMap;
            boolean bl2;
            Object object3;
            boolean bl3;
            block12: {
                block13: {
                    bl3 = false;
                    if (object == null) {
                        return false;
                    }
                    object3 = ((AVIMMessage)object).getMessageId();
                    boolean bl4 = StringUtil.isEmpty((String)object3);
                    if (!bl4) return false;
                    object3 = ((AVIMMessage)object).getConversationId();
                    bl4 = StringUtil.isEmpty((String)object3);
                    if (bl4) return false;
                    object3 = ((AVIMMessage)object).getUniqueToken();
                    bl4 = StringUtil.isEmpty((String)object3);
                    if (bl4) break block13;
                    object3 = this.delegate;
                    bl2 = true;
                    if (object3 == null) {
                        return bl2;
                    }
                    object3 = ((AVIMMessage)object).getUniqueToken();
                    object3 = this.generateInternalMessageId((String)object3);
                    hashMap = new HashMap<Object, Object>();
                    object2 = COLUMN_CONVERSATION_ID;
                    String string2 = ((AVIMMessage)object).getConversationId();
                    hashMap.put(object2, string2);
                    object2 = COLUMN_MESSAGE_ID;
                    hashMap.put(object2, object3);
                    object3 = COLUMN_TIMESTAMP;
                    l10 = ((AVIMMessage)object).getTimestamp();
                    object2 = l10;
                    hashMap.put(object3, object2);
                    object3 = COLUMN_FROM_PEER_ID;
                    object2 = ((AVIMMessage)object).getFrom();
                    hashMap.put(object3, object2);
                    bl4 = object instanceof AVIMBinaryMessage;
                    if (bl4) {
                        object3 = COLUMN_PAYLOAD;
                        object2 = object;
                        object2 = (AVIMBinaryMessage)object;
                        object2 = ((AVIMBinaryMessage)object2).getBytes();
                        hashMap.put(object3, object2);
                        object3 = COLUMN_MSG_INNERTYPE;
                        object2 = (int)(bl2 ? 1 : 0);
                        hashMap.put(object3, object2);
                        break block12;
                    } else {
                        object3 = COLUMN_PAYLOAD;
                        object2 = ((AVIMMessage)object).getContent();
                        string2 = "UTF-8";
                        object2 = ((String)object2).getBytes(string2);
                        hashMap.put(object3, object2);
                        break block12;
                    }
                }
                return false;
                catch (UnsupportedEncodingException unsupportedEncodingException) {}
            }
            object3 = COLUMN_MESSAGE_DELIVEREDAT;
            l10 = ((AVIMMessage)object).getDeliveredAt();
            object2 = l10;
            hashMap.put(object3, object2);
            object3 = "readAt";
            l10 = ((AVIMMessage)object).getReadAt();
            object2 = l10;
            hashMap.put(object3, object2);
            object3 = COLUMN_MESSAGE_UPDATEAT;
            l10 = ((AVIMMessage)object).getUpdateAt();
            object2 = l10;
            hashMap.put(object3, object2);
            object3 = COLUMN_STATUS;
            object2 = AVIMMessage$AVIMMessageStatus.AVIMMessageStatusFailed;
            int n10 = ((AVIMMessage$AVIMMessageStatus)((Object)object2)).getStatusCode();
            object2 = n10;
            hashMap.put(object3, object2);
            object3 = COLUMN_BREAKPOINT;
            object2 = 0;
            hashMap.put(object3, object2);
            object3 = COLUMN_DEDUPLICATED_TOKEN;
            object2 = ((AVIMMessage)object).getUniqueToken();
            hashMap.put(object3, object2);
            object3 = COLUMN_MSG_MENTION_ALL;
            boolean bl5 = ((AVIMMessage)object).isMentionAll();
            if (bl5) {
                boolean bl6 = bl2;
            } else {
                boolean bl7 = false;
                object2 = null;
            }
            object2 = (int)var11_14;
            hashMap.put(object3, object2);
            object3 = COLUMN_MSG_MENTION_LIST;
            object = ((AVIMMessage)object).getMentionListString();
            hashMap.put(object3, object);
            object = this.delegate;
            object3 = MESSAGE_TABLE;
            int n11 = object.insert((String)object3, hashMap);
            if (n11 <= 0) return bl3;
            return bl2;
        }
    }

    public void insertMessage(AVIMMessage object, boolean bl2) {
        if (object == null) {
            return;
        }
        AVIMMessage[] aVIMMessageArray = new AVIMMessage[]{object};
        object = Arrays.asList(aVIMMessageArray);
        this.insertMessages((List)object, bl2);
    }

    public boolean removeLocalMessage(AVIMMessage object) {
        synchronized (this) {
            block22: {
                boolean bl2 = false;
                if (object != null) {
                    block24: {
                        boolean bl3;
                        int n10;
                        Object object2;
                        block23: {
                            object2 = ((AVIMMessage)object).getConversationId();
                            n10 = StringUtil.isEmpty((String)object2);
                            if (n10 != 0) break block22;
                            object2 = ((AVIMMessage)object).getUniqueToken();
                            n10 = StringUtil.isEmpty((String)object2);
                            if (n10 != 0) break block22;
                            object2 = this.delegate;
                            bl3 = true;
                            if (object2 != null) break block23;
                            return bl3;
                        }
                        object2 = ((AVIMMessage)object).getUniqueToken();
                        object2 = this.generateInternalMessageId((String)object2);
                        Object object3 = AVIMMessage$AVIMMessageStatus.AVIMMessageStatusFailed;
                        int n11 = object3.getStatusCode();
                        object3 = String.valueOf(n11);
                        DatabaseDelegate databaseDelegate = this.delegate;
                        String string2 = MESSAGE_TABLE;
                        String string3 = "conversation_id = ? and message_id = ? and status = ? and dtoken = ? ";
                        int n12 = 4;
                        String[] stringArray = new String[n12];
                        String string4 = ((AVIMMessage)object).getConversationId();
                        stringArray[0] = string4;
                        stringArray[bl3] = object2;
                        n10 = 2;
                        stringArray[n10] = object3;
                        n10 = 3;
                        object = ((AVIMMessage)object).getUniqueToken();
                        stringArray[n10] = object;
                        int n13 = databaseDelegate.delete(string2, string3, stringArray);
                        if (n13 <= 0) break block24;
                        bl2 = bl3;
                    }
                    return bl2;
                }
            }
            return false;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void updateBreakpoints(List list, boolean bl2, String string2) {
        synchronized (this) {
            block9: {
                int n10 = 900;
                int n11 = list.size();
                if (n11 <= n10) break block9;
                n11 = 0;
                List list2 = null;
                list2 = list.subList(0, n10);
                this.updateBreakpointsForBatch(list2, bl2, string2);
                n11 = list.size();
                list = list.subList(n10, n11);
                this.updateBreakpoints(list, bl2, string2);
                return;
            }
            this.updateBreakpointsForBatch(list, bl2, string2);
            return;
        }
    }

    public boolean updateConversationLastMessageAt(AVIMConversation object) {
        HashMap<String, Long> hashMap = ((AVIMConversation)object).getConversationId();
        hashMap = this.getConversation((String)((Object)hashMap));
        int n10 = 0;
        if (hashMap != null && (hashMap = ((AVIMConversation)object).getLastMessageAt()) != null) {
            hashMap = new HashMap<String, Long>();
            long l10 = ((AVIMConversation)object).getLastMessageAt().getTime();
            Object object2 = l10;
            hashMap.put(COLUMN_LM, (Long)object2);
            object2 = this.delegate;
            String string2 = AVIMMessageStorage.getWhereClause(COLUMN_CONVERSATION_ID);
            int n11 = 1;
            String[] stringArray = new String[n11];
            stringArray[0] = object = ((AVIMConversation)object).getConversationId();
            object = CONVERSATION_TABLE;
            int n12 = object2.update((String)object, hashMap, string2, stringArray);
            int n13 = -1;
            if (n12 > n13) {
                n10 = n11;
            }
        }
        return n10 != 0;
    }

    public boolean updateConversationTimes(AVIMConversation object) {
        HashMap<String, Long> hashMap = ((AVIMConversation)object).getConversationId();
        hashMap = this.getConversation((String)((Object)hashMap));
        int n10 = 0;
        if (hashMap != null) {
            hashMap = new HashMap<String, Long>();
            Object object2 = ((AVIMConversation)object).getLastReadAt();
            hashMap.put("readAt", (Long)object2);
            long l10 = ((AVIMConversation)object).getLastDeliveredAt();
            object2 = l10;
            hashMap.put(COLUMN_CONVRESATION_DELIVEREDAT, (Long)object2);
            object2 = this.delegate;
            String string2 = AVIMMessageStorage.getWhereClause(COLUMN_CONVERSATION_ID);
            int n11 = 1;
            String[] stringArray = new String[n11];
            stringArray[0] = object = ((AVIMConversation)object).getConversationId();
            object = CONVERSATION_TABLE;
            int n12 = object2.update((String)object, hashMap, string2, stringArray);
            int n13 = -1;
            if (n12 != n13) {
                n10 = n11;
            }
        }
        return n10 != 0;
    }

    public boolean updateConversationUreadCount(String string2, long l10, boolean bl2) {
        HashMap<String, Long> hashMap = this.getConversation(string2);
        boolean bl3 = false;
        if (hashMap != null) {
            hashMap = new HashMap<String, Long>();
            Object object = l10;
            hashMap.put(COLUMN_UNREAD_COUNT, (Long)object);
            object = (int)(bl2 ? 1 : 0);
            hashMap.put(COLUMN_CONV_MENTIONED, (Long)object);
            object = this.delegate;
            String string3 = AVIMMessageStorage.getWhereClause(COLUMN_CONVERSATION_ID);
            bl2 = true;
            String[] stringArray = new String[bl2];
            stringArray[0] = string2;
            string2 = CONVERSATION_TABLE;
            int n10 = object.update(string2, hashMap, string3, stringArray);
            int n11 = -1;
            if (n10 > n11) {
                bl3 = bl2;
            }
        }
        return bl3;
    }

    /*
     * WARNING - void declaration
     */
    public boolean updateMessage(AVIMMessage object, String string2) {
        synchronized (this) {
            boolean bl2;
            block36: {
                void var9_13;
                boolean bl3;
                Object object2;
                String string3;
                HashMap<String, Long> hashMap;
                block35: {
                    block34: {
                        hashMap = this.delegate;
                        bl2 = false;
                        if (hashMap != null) break block34;
                        return false;
                    }
                    hashMap = new HashMap<String, Long>();
                    string3 = COLUMN_TIMESTAMP;
                    long l10 = ((AVIMMessage)object).getTimestamp();
                    object2 = l10;
                    hashMap.put(string3, (Long)object2);
                    string3 = COLUMN_STATUS;
                    object2 = ((AVIMMessage)object).getMessageStatus();
                    int bl4 = ((AVIMMessage$AVIMMessageStatus)((Object)object2)).getStatusCode();
                    object2 = bl4;
                    hashMap.put(string3, (Long)object2);
                    string3 = COLUMN_MESSAGE_DELIVEREDAT;
                    l10 = ((AVIMMessage)object).getDeliveredAt();
                    object2 = l10;
                    hashMap.put(string3, (Long)object2);
                    string3 = "readAt";
                    l10 = ((AVIMMessage)object).getReadAt();
                    object2 = l10;
                    hashMap.put(string3, (Long)object2);
                    string3 = COLUMN_MESSAGE_UPDATEAT;
                    l10 = ((AVIMMessage)object).getUpdateAt();
                    object2 = l10;
                    hashMap.put(string3, (Long)object2);
                    string3 = COLUMN_MESSAGE_ID;
                    object2 = ((AVIMMessage)object).getMessageId();
                    hashMap.put(string3, (Long)object2);
                    string3 = COLUMN_MSG_MENTION_ALL;
                    boolean bl5 = ((AVIMMessage)object).isMentionAll();
                    bl3 = true;
                    if (bl5) {
                        boolean bl6 = bl3;
                        break block35;
                    }
                    boolean bl7 = false;
                    object2 = null;
                }
                object2 = (int)var9_13;
                hashMap.put(string3, (Long)object2);
                string3 = COLUMN_MSG_MENTION_LIST;
                object = ((AVIMMessage)object).getMentionListString();
                hashMap.put(string3, (Long)object);
                object = this.delegate;
                string3 = MESSAGE_TABLE;
                object2 = COLUMN_MESSAGE_ID;
                object2 = new String[]{object2};
                object2 = AVIMMessageStorage.getWhereClause((String[])object2);
                String[] stringArray = new String[bl3];
                stringArray[0] = string2;
                int n10 = object.update(string3, hashMap, (String)object2, stringArray);
                int n11 = -1;
                if (n10 <= n11) break block36;
                bl2 = bl3;
            }
            return bl2;
        }
    }

    public boolean updateMessageForPatch(AVIMMessage object) {
        synchronized (this) {
            boolean bl2;
            block30: {
                Object object2;
                Object object3;
                HashMap<String, Object> hashMap;
                block29: {
                    hashMap = this.delegate;
                    bl2 = false;
                    if (hashMap != null) break block29;
                    return false;
                }
                hashMap = new HashMap<String, Object>();
                boolean bl3 = object instanceof AVIMBinaryMessage;
                boolean bl4 = true;
                if (bl3) {
                    object3 = COLUMN_PAYLOAD;
                    object2 = object;
                    object2 = (AVIMBinaryMessage)object;
                    object2 = ((AVIMBinaryMessage)object2).getBytes();
                    hashMap.put((String)object3, object2);
                    object3 = COLUMN_MSG_INNERTYPE;
                    object2 = (int)(bl4 ? 1 : 0);
                    hashMap.put((String)object3, object2);
                } else {
                    object3 = COLUMN_PAYLOAD;
                    object2 = ((AVIMMessage)object).getContent();
                    hashMap.put((String)object3, object2);
                    object3 = COLUMN_MSG_INNERTYPE;
                    object2 = 0;
                    hashMap.put((String)object3, object2);
                }
                object3 = COLUMN_STATUS;
                object2 = ((AVIMMessage)object).getMessageStatus();
                int n10 = ((AVIMMessage$AVIMMessageStatus)((Object)object2)).getStatusCode();
                object2 = n10;
                hashMap.put((String)object3, object2);
                object3 = COLUMN_MESSAGE_UPDATEAT;
                long l10 = ((AVIMMessage)object).getUpdateAt();
                object2 = l10;
                hashMap.put((String)object3, object2);
                object3 = this.delegate;
                object2 = MESSAGE_TABLE;
                Object object4 = "message_id";
                object4 = new String[]{object4};
                object4 = AVIMMessageStorage.getWhereClause(object4);
                String[] stringArray = new String[bl4];
                object = ((AVIMMessage)object).getMessageId();
                stringArray[0] = object;
                int n11 = object3.update((String)object2, hashMap, (String)object4, stringArray);
                int n12 = -1;
                if (n11 <= n12) break block30;
                bl2 = bl4;
            }
            return bl2;
        }
    }
}

