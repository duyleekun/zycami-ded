/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package com.xiaomi.mipush.sdk;

import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.PushMessageHandler$a;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MiPushMessage
implements PushMessageHandler$a {
    private static final String KEY_ALIAS = "alias";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_CONTENT = "content";
    private static final String KEY_DESC = "description";
    private static final String KEY_EXTRA = "extra";
    private static final String KEY_MESSAGE_ID = "messageId";
    private static final String KEY_MESSAGE_TYPE = "messageType";
    private static final String KEY_NOTIFIED = "isNotified";
    private static final String KEY_NOTIFY_ID = "notifyId";
    private static final String KEY_NOTIFY_TYPE = "notifyType";
    private static final String KEY_PASS_THROUGH = "passThrough";
    private static final String KEY_TITLE = "title";
    private static final String KEY_TOPIC = "topic";
    private static final String KEY_USER_ACCOUNT = "user_account";
    public static final int MESSAGE_TYPE_ACCOUNT = 3;
    public static final int MESSAGE_TYPE_ALIAS = 1;
    public static final int MESSAGE_TYPE_REG = 0;
    public static final int MESSAGE_TYPE_TOPIC = 2;
    private static final long serialVersionUID = 1L;
    private String alias;
    private boolean arrived = false;
    private String category;
    private String content;
    private String description;
    private HashMap extra;
    private boolean isNotified;
    private String messageId;
    private int messageType;
    private int notifyId;
    private int notifyType;
    private int passThrough;
    private String title;
    private String topic;
    private String userAccount;

    public MiPushMessage() {
        HashMap hashMap;
        this.extra = hashMap = new HashMap();
    }

    public static MiPushMessage fromBundle(Bundle object) {
        int n10;
        String string2;
        MiPushMessage miPushMessage = new MiPushMessage();
        miPushMessage.messageId = string2 = object.getString(KEY_MESSAGE_ID);
        miPushMessage.messageType = n10 = object.getInt(KEY_MESSAGE_TYPE);
        miPushMessage.passThrough = n10 = object.getInt(KEY_PASS_THROUGH);
        miPushMessage.alias = string2 = object.getString(KEY_ALIAS);
        miPushMessage.userAccount = string2 = object.getString(KEY_USER_ACCOUNT);
        miPushMessage.topic = string2 = object.getString(KEY_TOPIC);
        miPushMessage.content = string2 = object.getString(KEY_CONTENT);
        miPushMessage.description = string2 = object.getString(KEY_DESC);
        miPushMessage.title = string2 = object.getString(KEY_TITLE);
        n10 = (int)(object.getBoolean(KEY_NOTIFIED) ? 1 : 0);
        miPushMessage.isNotified = n10;
        miPushMessage.notifyId = n10 = object.getInt(KEY_NOTIFY_ID);
        miPushMessage.notifyType = n10 = object.getInt(KEY_NOTIFY_TYPE);
        miPushMessage.category = string2 = object.getString(KEY_CATEGORY);
        object = (HashMap)object.getSerializable(KEY_EXTRA);
        miPushMessage.extra = object;
        return miPushMessage;
    }

    public String getAlias() {
        return this.alias;
    }

    public String getCategory() {
        return this.category;
    }

    public String getContent() {
        return this.content;
    }

    public String getDescription() {
        return this.description;
    }

    public Map getExtra() {
        return this.extra;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public int getNotifyId() {
        return this.notifyId;
    }

    public int getNotifyType() {
        return this.notifyType;
    }

    public int getPassThrough() {
        return this.passThrough;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTopic() {
        return this.topic;
    }

    public String getUserAccount() {
        return this.userAccount;
    }

    public boolean isArrivedMessage() {
        return this.arrived;
    }

    public boolean isNotified() {
        return this.isNotified;
    }

    public void setAlias(String string2) {
        this.alias = string2;
    }

    public void setArrivedMessage(boolean bl2) {
        this.arrived = bl2;
    }

    public void setCategory(String string2) {
        this.category = string2;
    }

    public void setContent(String string2) {
        this.content = string2;
    }

    public void setDescription(String string2) {
        this.description = string2;
    }

    public void setExtra(Map map) {
        HashMap hashMap = this.extra;
        hashMap.clear();
        if (map != null) {
            hashMap = this.extra;
            hashMap.putAll(map);
        }
    }

    public void setMessageId(String string2) {
        this.messageId = string2;
    }

    public void setMessageType(int n10) {
        this.messageType = n10;
    }

    public void setNotified(boolean bl2) {
        this.isNotified = bl2;
    }

    public void setNotifyId(int n10) {
        this.notifyId = n10;
    }

    public void setNotifyType(int n10) {
        this.notifyType = n10;
    }

    public void setPassThrough(int n10) {
        this.passThrough = n10;
    }

    public void setTitle(String string2) {
        this.title = string2;
    }

    public void setTopic(String string2) {
        this.topic = string2;
    }

    public void setUserAccount(String string2) {
        this.userAccount = string2;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        Object object = this.messageId;
        bundle.putString(KEY_MESSAGE_ID, (String)object);
        int n10 = this.passThrough;
        bundle.putInt(KEY_PASS_THROUGH, n10);
        n10 = this.messageType;
        String string2 = KEY_MESSAGE_TYPE;
        bundle.putInt(string2, n10);
        object = this.alias;
        n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
        if (n10 == 0) {
            object = this.alias;
            string2 = KEY_ALIAS;
            bundle.putString(string2, (String)object);
        }
        if ((n10 = (int)(TextUtils.isEmpty((CharSequence)(object = this.userAccount)) ? 1 : 0)) == 0) {
            object = this.userAccount;
            string2 = KEY_USER_ACCOUNT;
            bundle.putString(string2, (String)object);
        }
        if ((n10 = (int)(TextUtils.isEmpty((CharSequence)(object = this.topic)) ? 1 : 0)) == 0) {
            object = this.topic;
            string2 = KEY_TOPIC;
            bundle.putString(string2, (String)object);
        }
        object = this.content;
        string2 = KEY_CONTENT;
        bundle.putString(string2, (String)object);
        object = this.description;
        n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
        if (n10 == 0) {
            object = this.description;
            string2 = KEY_DESC;
            bundle.putString(string2, (String)object);
        }
        if ((n10 = (int)(TextUtils.isEmpty((CharSequence)(object = this.title)) ? 1 : 0)) == 0) {
            object = this.title;
            string2 = KEY_TITLE;
            bundle.putString(string2, (String)object);
        }
        n10 = (int)(this.isNotified ? 1 : 0);
        bundle.putBoolean(KEY_NOTIFIED, n10 != 0);
        n10 = this.notifyId;
        bundle.putInt(KEY_NOTIFY_ID, n10);
        n10 = this.notifyType;
        string2 = KEY_NOTIFY_TYPE;
        bundle.putInt(string2, n10);
        object = this.category;
        n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
        if (n10 == 0) {
            object = this.category;
            string2 = KEY_CATEGORY;
            bundle.putString(string2, (String)object);
        }
        if ((object = this.extra) != null) {
            string2 = KEY_EXTRA;
            bundle.putSerializable(string2, (Serializable)object);
        }
        return bundle;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("messageId={");
        Object object = this.messageId;
        stringBuilder.append((String)object);
        stringBuilder.append("},passThrough={");
        int n10 = this.passThrough;
        stringBuilder.append(n10);
        stringBuilder.append("},alias={");
        object = this.alias;
        stringBuilder.append((String)object);
        stringBuilder.append("},topic={");
        object = this.topic;
        stringBuilder.append((String)object);
        stringBuilder.append("},userAccount={");
        object = this.userAccount;
        stringBuilder.append((String)object);
        stringBuilder.append("},content={");
        object = this.content;
        stringBuilder.append((String)object);
        stringBuilder.append("},description={");
        object = this.description;
        stringBuilder.append((String)object);
        stringBuilder.append("},title={");
        object = this.title;
        stringBuilder.append((String)object);
        stringBuilder.append("},isNotified={");
        n10 = (int)(this.isNotified ? 1 : 0);
        stringBuilder.append(n10 != 0);
        stringBuilder.append("},notifyId={");
        n10 = this.notifyId;
        stringBuilder.append(n10);
        stringBuilder.append("},notifyType={");
        n10 = this.notifyType;
        stringBuilder.append(n10);
        stringBuilder.append("}, category={");
        object = this.category;
        stringBuilder.append((String)object);
        stringBuilder.append("}, extra={");
        object = this.extra;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

