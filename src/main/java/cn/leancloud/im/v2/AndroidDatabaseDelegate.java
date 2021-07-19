/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.Cursor
 *  android.database.DatabaseUtils
 *  android.database.sqlite.SQLiteDatabase
 */
package cn.leancloud.im.v2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import cn.leancloud.AVLogger;
import cn.leancloud.codec.Base64Decoder;
import cn.leancloud.im.DatabaseDelegate;
import cn.leancloud.im.v2.AVIMBinaryMessage;
import cn.leancloud.im.v2.AVIMChatRoom;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMMessage;
import cn.leancloud.im.v2.AVIMMessage$AVIMMessageStatus;
import cn.leancloud.im.v2.AVIMMessageManager;
import cn.leancloud.im.v2.AVIMMessageStorage$MessageQueryResult;
import cn.leancloud.im.v2.AVIMServiceConversation;
import cn.leancloud.im.v2.AVIMTemporaryConversation;
import cn.leancloud.im.v2.AndroidDatabaseDelegate$DBHelper;
import cn.leancloud.json.JSON;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AndroidDatabaseDelegate
implements DatabaseDelegate {
    private static final AVLogger LOGGER = LogUtil.getLogger(AndroidDatabaseDelegate.class);
    private String clientId;
    private AndroidDatabaseDelegate$DBHelper dbHelper;

    public AndroidDatabaseDelegate(Context context, String string2) {
        AndroidDatabaseDelegate$DBHelper androidDatabaseDelegate$DBHelper;
        this.dbHelper = androidDatabaseDelegate$DBHelper = new AndroidDatabaseDelegate$DBHelper(context, string2);
        this.clientId = string2;
    }

    public static /* synthetic */ AVLogger access$000() {
        return LOGGER;
    }

    private AVIMMessage createMessageFromCursor(Cursor cursor) {
        int n10;
        Object object = cursor;
        int n11 = cursor.getColumnIndex("message_id");
        Object object2 = cursor.getString(n11);
        int n12 = cursor.getColumnIndex("timestamp");
        long l10 = cursor.getLong(n12);
        n12 = cursor.getColumnIndex("conversation_id");
        String string2 = cursor.getString(n12);
        n12 = cursor.getColumnIndex("from_peer_id");
        String string3 = cursor.getString(n12);
        n12 = cursor.getColumnIndex("receipt_timestamp");
        long l11 = cursor.getLong(n12);
        n12 = cursor.getColumnIndex("readAt");
        long l12 = cursor.getLong(n12);
        n12 = cursor.getColumnIndex("updateAt");
        long l13 = cursor.getLong(n12);
        n12 = cursor.getColumnIndex("payload");
        Object object3 = cursor.getBlob(n12);
        int n13 = cursor.getColumnIndex("dtoken");
        String string4 = cursor.getString(n13);
        n13 = cursor.getColumnIndex("status");
        int n14 = cursor.getInt(n13);
        n13 = cursor.getColumnIndex("mentionAll");
        int n15 = cursor.getInt(n13);
        n13 = cursor.getColumnIndex("mentionList");
        String string5 = cursor.getString(n13);
        String string6 = "iType";
        n13 = cursor.getColumnIndex(string6);
        int n16 = cursor.getInt(n13);
        if (n16 == (n13 = 1)) {
            n10 = n15;
            string6 = object;
            object = new AVIMBinaryMessage(string2, string3, l10, l11, l12);
            ((AVIMBinaryMessage)object).setBytes((byte[])object3);
        } else {
            n10 = n15;
            string6 = object;
            object = new AVIMMessage(string2, string3, l10, l11, l12);
            string6 = new String((byte[])object3);
            ((AVIMMessage)object).setContent(string6);
        }
        ((AVIMMessage)object).setMessageId((String)object2);
        ((AVIMMessage)object).setUniqueToken(string4);
        object2 = AVIMMessage$AVIMMessageStatus.getMessageStatus(n14);
        ((AVIMMessage)object).setMessageStatus((AVIMMessage$AVIMMessageStatus)((Object)object2));
        ((AVIMMessage)object).setUpdateAt(l13);
        n11 = n10;
        n12 = 1;
        if (n10 == n12) {
            n13 = n12;
        } else {
            n13 = 0;
            string6 = null;
        }
        ((AVIMMessage)object).setMentionAll(n13 != 0);
        object2 = this;
        object3 = this.clientId;
        ((AVIMMessage)object).setCurrentClient((String)object3);
        n12 = StringUtil.isEmpty(string5);
        if (!n12) {
            object3 = string5;
            ((AVIMMessage)object).setMentionListString(string5);
        }
        return AVIMMessageManager.parseTypedMessage((AVIMMessage)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private AVIMConversation parseConversationFromCursor(Cursor cursor) {
        long l10;
        Object object = cursor;
        int n10 = cursor.getColumnIndex("conversation_id");
        Object object2 = cursor.getString(n10);
        int n11 = cursor.getColumnIndex("createdAt");
        Object object3 = cursor.getString(n11);
        int n12 = cursor.getColumnIndex("updatedAt");
        String string2 = cursor.getString(n12);
        int n13 = cursor.getColumnIndex("members");
        String string3 = cursor.getString(n13);
        int n14 = cursor.getColumnIndex("attr");
        String string4 = cursor.getString(n14);
        int n15 = cursor.getColumnIndex("instanceData");
        Object object4 = cursor.getString(n15);
        int n16 = cursor.getColumnIndex("creator");
        String string5 = cursor.getString(n16);
        String string6 = "lm";
        int n17 = cursor.getColumnIndex(string6);
        long l11 = cursor.getLong(n17);
        Object object5 = "isTransient";
        int n18 = cursor.getColumnIndex((String)object5);
        n18 = cursor.getInt(n18);
        int n19 = cursor.getColumnIndex("unread_count");
        n19 = cursor.getInt(n19);
        int n20 = cursor.getColumnIndex("mentioned");
        n20 = cursor.getInt(n20);
        int n21 = cursor.getColumnIndex("readAt");
        long l12 = cursor.getLong(n21);
        n21 = cursor.getColumnIndex("deliveredAt");
        long l13 = l10 = cursor.getLong(n21);
        n21 = cursor.getColumnIndex("last_message");
        String string7 = cursor.getString(n21);
        String string8 = "last_msg_iType";
        int n22 = cursor.getColumnIndex(string8);
        n22 = cursor.getInt(n22);
        int n23 = n20;
        Object object6 = "sys";
        n20 = cursor.getColumnIndex((String)object6);
        n20 = cursor.getInt(n20);
        int n24 = n19;
        Object object7 = "temp";
        n19 = cursor.getColumnIndex((String)object7);
        if ((n19 = cursor.getInt(n19)) > 0) {
            object7 = AVIMClient.getInstance(this.clientId);
            object5 = new AVIMTemporaryConversation((AVIMClient)object7, (String)object2);
            object7 = "temp_ttl";
            n19 = cursor.getColumnIndex((String)object7);
            long l14 = cursor.getLong(n19);
            ((AVIMConversation)object5).setTemporaryExpiredat(l14);
        } else if (n20 > 0) {
            object = AVIMClient.getInstance(this.clientId);
            object5 = new AVIMServiceConversation((AVIMClient)object, (String)object2);
        } else if (n18 > 0) {
            object = AVIMClient.getInstance(this.clientId);
            object5 = new AVIMChatRoom((AVIMClient)object, (String)object2);
        } else {
            object = AVIMClient.getInstance(this.clientId);
            object5 = new AVIMConversation((AVIMClient)object, (String)object2);
        }
        n19 = 1;
        try {
            boolean bl2 = StringUtil.isEmpty((String)object4);
            if (!bl2) {
                object = ((AVIMConversation)object5).instanceData;
                object6 = HashMap.class;
                object4 = JSON.parseObject((String)object4, (Class)object6);
                object4 = (Map)object4;
                object.putAll(object4);
            }
            ((AVIMConversation)object5).setCreatedAt((String)object3);
            ((AVIMConversation)object5).setUpdatedAt(string2);
            bl2 = StringUtil.isEmpty(string3);
            if (!bl2) {
                object = new ArrayList();
                object3 = Set.class;
                object3 = JSON.parseObject(string3, (Class)object3);
                object3 = (Collection)object3;
                object.addAll(object3);
                ((AVIMConversation)object5).setMembers((List)object);
            }
            if (!(bl2 = StringUtil.isEmpty(string4))) {
                object = HashMap.class;
                object = JSON.parseObject(string4, (Class)object);
                object = (Map)object;
                ((AVIMConversation)object5).setAttributesForInit((Map)object);
            }
            if (n22 != n19) {
                object = AVIMMessage.class;
                object = JSON.parseObject(string7, (Class)object);
                object = (AVIMMessage)object;
                ((AVIMConversation)object5).lastMessage = object;
            } else {
                n11 = 0;
                object3 = null;
                object = new AVIMBinaryMessage((String)object2, null);
                object2 = Base64Decoder.decodeToBytes(string7);
                ((AVIMBinaryMessage)object).setBytes((byte[])object2);
                ((AVIMConversation)object5).lastMessage = object;
            }
        }
        catch (Exception exception) {
            object2 = LOGGER;
            object3 = new StringBuilder();
            string2 = "failed to parse conversation query result. cause: ";
            ((StringBuilder)object3).append(string2);
            object = exception.getMessage();
            ((StringBuilder)object3).append((String)object);
            object = ((StringBuilder)object3).toString();
            ((AVLogger)object2).w((String)object);
        }
        ((AVIMConversation)object5).setCreator(string5);
        object = new Date(l11);
        ((AVIMConversation)object5).lastMessageAt = object;
        n10 = n24;
        ((AVIMConversation)object5).unreadMessagesCount = n24;
        n10 = n23;
        if (n23 != n19) {
            n19 = 0;
            object7 = null;
        }
        ((AVIMConversation)object5).unreadMessagesMentioned = n19;
        ((AVIMConversation)object5).lastReadAt = l12;
        ((AVIMConversation)object5).lastDeliveredAt = l13;
        return object5;
    }

    private ContentValues transferMap(Map object) {
        boolean bl2;
        ContentValues contentValues = new ContentValues();
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (Map.Entry)object.next();
            Object object3 = object2.getValue();
            boolean bl3 = object3 instanceof Long;
            if (bl3) {
                object2 = (String)object2.getKey();
                object3 = (Long)object3;
                contentValues.put((String)object2, object3);
                continue;
            }
            bl3 = object3 instanceof String;
            if (bl3) {
                object2 = (String)object2.getKey();
                object3 = (String)object3;
                contentValues.put((String)object2, object3);
                continue;
            }
            bl3 = object3 instanceof Byte;
            if (bl3) {
                object2 = (String)object2.getKey();
                object3 = (Byte)object3;
                contentValues.put((String)object2, object3);
                continue;
            }
            bl3 = object3 instanceof Integer;
            if (bl3) {
                object2 = (String)object2.getKey();
                object3 = (Integer)object3;
                contentValues.put((String)object2, object3);
                continue;
            }
            bl3 = object3 instanceof Float;
            if (bl3) {
                object2 = (String)object2.getKey();
                object3 = (Float)object3;
                contentValues.put((String)object2, object3);
                continue;
            }
            bl3 = object3 instanceof Double;
            if (bl3) {
                object2 = (String)object2.getKey();
                object3 = (Double)object3;
                contentValues.put((String)object2, object3);
                continue;
            }
            bl3 = object3 instanceof Boolean;
            if (bl3) {
                object2 = (String)object2.getKey();
                object3 = (Boolean)object3;
                contentValues.put((String)object2, object3);
                continue;
            }
            bl3 = object3 instanceof byte[];
            if (!bl3) continue;
            object2 = (String)object2.getKey();
            object3 = (byte[])object3;
            contentValues.put((String)object2, object3);
        }
        return contentValues;
    }

    public long countForQuery(String string2, String[] stringArray) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            return 0L;
        }
        return DatabaseUtils.longForQuery((SQLiteDatabase)this.dbHelper.getReadableDatabase(), (String)string2, (String[])stringArray);
    }

    public int delete(String string2, String object, String[] object2) {
        AndroidDatabaseDelegate$DBHelper androidDatabaseDelegate$DBHelper;
        try {
            androidDatabaseDelegate$DBHelper = this.dbHelper;
        }
        catch (Exception exception) {
            object = LOGGER;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("failed to execute delete instrument. cause: ");
            String string3 = exception.getMessage();
            ((StringBuilder)object2).append(string3);
            string3 = ((StringBuilder)object2).toString();
            ((AVLogger)object).w(string3);
            return 0;
        }
        androidDatabaseDelegate$DBHelper = androidDatabaseDelegate$DBHelper.getWritableDatabase();
        return androidDatabaseDelegate$DBHelper.delete(string2, (String)object, (String[])object2);
    }

    public int insert(String string2, Map object) {
        Object object2;
        try {
            object2 = this.dbHelper;
        }
        catch (Exception exception) {
            object = LOGGER;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("failed to execute insert instrument. cause: ");
            String string3 = exception.getMessage();
            ((StringBuilder)object2).append(string3);
            string3 = ((StringBuilder)object2).toString();
            ((AVLogger)object).w(string3);
            return -1;
        }
        object2 = object2.getWritableDatabase();
        object = this.transferMap((Map)object);
        int n10 = 4;
        return (int)object2.insertWithOnConflict(string2, null, (ContentValues)object, n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List queryConversations(String[] stringArray, String string2, String[] stringArray2, String string3, String string4, String string5, String string6) {
        LinkedList<SQLiteDatabase> linkedList = new LinkedList<SQLiteDatabase>();
        try {
            AndroidDatabaseDelegate$DBHelper androidDatabaseDelegate$DBHelper = this.dbHelper;
            Object object = androidDatabaseDelegate$DBHelper.getReadableDatabase();
            String string7 = "conversations";
            String[] stringArray3 = stringArray;
            androidDatabaseDelegate$DBHelper = object.query(string7, stringArray, string2, stringArray2, string3, string4, string5, string6);
            boolean bl2 = androidDatabaseDelegate$DBHelper.moveToFirst();
            if (bl2) {
                while (!(bl2 = androidDatabaseDelegate$DBHelper.isAfterLast())) {
                    object = this.parseConversationFromCursor((Cursor)androidDatabaseDelegate$DBHelper);
                    linkedList.add((SQLiteDatabase)object);
                    androidDatabaseDelegate$DBHelper.moveToNext();
                }
            }
            androidDatabaseDelegate$DBHelper.close();
            return linkedList;
        }
        catch (Exception exception) {
            AVLogger aVLogger = LOGGER;
            StringBuilder stringBuilder = new StringBuilder();
            String string8 = "failed to execute conversation query. cause: ";
            stringBuilder.append(string8);
            String string9 = exception.getMessage();
            stringBuilder.append(string9);
            string9 = stringBuilder.toString();
            aVLogger.w(string9);
        }
        return linkedList;
    }

    public int queryCount(String string2, String[] stringArray, String string3, String[] stringArray2, String string4, String string5, String string6) {
        int n10 = 0;
        AndroidDatabaseDelegate$DBHelper androidDatabaseDelegate$DBHelper = this.dbHelper;
        AVLogger aVLogger = androidDatabaseDelegate$DBHelper.getReadableDatabase();
        CharSequence charSequence = string2;
        String[] stringArray3 = stringArray;
        androidDatabaseDelegate$DBHelper = aVLogger.query(string2, stringArray, string3, stringArray2, string4, string5, string6);
        n10 = androidDatabaseDelegate$DBHelper.getCount();
        try {
            androidDatabaseDelegate$DBHelper.close();
        }
        catch (Exception exception) {
            aVLogger = LOGGER;
            charSequence = new StringBuilder();
            stringArray3 = "failed to execute count query. cause: ";
            ((StringBuilder)charSequence).append((String)stringArray3);
            String string7 = exception.getMessage();
            ((StringBuilder)charSequence).append(string7);
            string7 = ((StringBuilder)charSequence).toString();
            aVLogger.w(string7);
        }
        return n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public AVIMMessageStorage$MessageQueryResult queryMessages(String[] stringArray, String string2, String[] stringArray2, String string3, String string4, String string5, String string6) {
        Object object;
        ArrayList<SQLiteDatabase> arrayList = new ArrayList<SQLiteDatabase>();
        ArrayList<SQLiteDatabase> arrayList2 = new ArrayList<SQLiteDatabase>();
        try {
            object = this.dbHelper;
            Object object2 = object.getReadableDatabase();
            String string7 = "messages";
            String[] stringArray3 = stringArray;
            object = object2.query(string7, stringArray, string2, stringArray2, string3, string4, string5, string6);
            boolean bl2 = object.moveToFirst();
            if (bl2) {
                while (!(bl2 = object.isAfterLast())) {
                    object2 = this.createMessageFromCursor((Cursor)object);
                    string7 = "breakpoint";
                    boolean bl3 = object.getColumnIndex(string7);
                    if (bl3 = object.getInt((int)(bl3 ? 1 : 0))) {
                        bl3 = true;
                    } else {
                        bl3 = false;
                        string7 = null;
                    }
                    arrayList.add((SQLiteDatabase)object2);
                    object2 = bl3;
                    arrayList2.add((SQLiteDatabase)object2);
                    object.moveToNext();
                }
            }
            object.close();
        }
        catch (Exception exception) {
            AVLogger aVLogger = LOGGER;
            StringBuilder stringBuilder = new StringBuilder();
            String string8 = "failed to execute message query. cause: ";
            stringBuilder.append(string8);
            object = exception.getMessage();
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            aVLogger.w((String)object);
        }
        object = new AVIMMessageStorage$MessageQueryResult();
        ((AVIMMessageStorage$MessageQueryResult)object).messages = arrayList;
        ((AVIMMessageStorage$MessageQueryResult)object).breakpoints = arrayList2;
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List rawQueryConversations(String string2, String[] object) {
        LinkedList<Object> linkedList = new LinkedList<Object>();
        try {
            Object object2 = this.dbHelper;
            object2 = object2.getReadableDatabase();
            string2 = object2.rawQuery(string2, (String[])object);
            boolean bl2 = string2.moveToFirst();
            if (bl2) {
                while (!(bl2 = string2.isAfterLast())) {
                    object = this.parseConversationFromCursor((Cursor)string2);
                    linkedList.add(object);
                    string2.moveToNext();
                }
            } else {
                object = LOGGER;
                object2 = "rawQuery cursor is empty.";
                ((AVLogger)object).d((String)object2);
            }
            string2.close();
            return linkedList;
        }
        catch (Exception exception) {
            object = LOGGER;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "failed to execute raw query. cause: ";
            stringBuilder.append(string3);
            String string4 = exception.getMessage();
            stringBuilder.append(string4);
            string4 = stringBuilder.toString();
            ((AVLogger)object).w(string4);
        }
        return linkedList;
    }

    public int update(String string2, Map object, String charSequence, String[] stringArray) {
        AndroidDatabaseDelegate$DBHelper androidDatabaseDelegate$DBHelper;
        try {
            androidDatabaseDelegate$DBHelper = this.dbHelper;
        }
        catch (Exception exception) {
            object = LOGGER;
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("failed to execute update instrument. cause: ");
            String string3 = exception.getMessage();
            ((StringBuilder)charSequence).append(string3);
            string3 = ((StringBuilder)charSequence).toString();
            ((AVLogger)object).w(string3);
            return 0;
        }
        androidDatabaseDelegate$DBHelper = androidDatabaseDelegate$DBHelper.getWritableDatabase();
        object = this.transferMap((Map)object);
        return androidDatabaseDelegate$DBHelper.update(string2, (ContentValues)object, (String)charSequence, stringArray);
    }
}

