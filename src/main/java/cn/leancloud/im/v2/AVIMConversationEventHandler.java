/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.AVLogger;
import cn.leancloud.im.AVIMEventHandler;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMMessage;
import cn.leancloud.im.v2.conversation.AVIMConversationMemberInfo;
import cn.leancloud.json.JSONObject;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public abstract class AVIMConversationEventHandler
extends AVIMEventHandler {
    public static final AVLogger LOGGER = LogUtil.getLogger(AVIMConversationEventHandler.class);

    private void processConversationEvent(int n10, Object object, Object object2, AVIMConversation aVIMConversation) {
        boolean bl2 = true;
        switch (n10) {
            default: {
                break;
            }
            case 50026: {
                AVIMClient aVIMClient = aVIMConversation.client;
                object2 = (JSONObject)object2;
                object = (String)object;
                this.onInfoChanged(aVIMClient, aVIMConversation, (JSONObject)object2, (String)object);
                break;
            }
            case 50025: {
                AVIMClient aVIMClient = aVIMConversation.client;
                object2 = (List)object2;
                object = (String)object;
                this.onMemberUnblocked(aVIMClient, aVIMConversation, (List)object2, (String)object);
                break;
            }
            case 50024: {
                AVIMClient aVIMClient = aVIMConversation.client;
                object2 = (List)object2;
                object = (String)object;
                this.onMemberBlocked(aVIMClient, aVIMConversation, (List)object2, (String)object);
                break;
            }
            case 50023: {
                AVIMClient aVIMClient = aVIMConversation.client;
                object = (String)object;
                this.onUnblocked(aVIMClient, aVIMConversation, (String)object);
                break;
            }
            case 50022: {
                AVIMClient aVIMClient = aVIMConversation.client;
                object = (String)object;
                this.onBlocked(aVIMClient, aVIMConversation, (String)object);
                break;
            }
            case 50021: {
                AVIMClient aVIMClient = aVIMConversation.client;
                object2 = (List)object2;
                object = (String)object;
                this.onMemberUnmuted(aVIMClient, aVIMConversation, (List)object2, (String)object);
                break;
            }
            case 50020: {
                AVIMClient aVIMClient = aVIMConversation.client;
                object2 = (List)object2;
                object = (String)object;
                this.onMemberMuted(aVIMClient, aVIMConversation, (List)object2, (String)object);
                break;
            }
            case 50019: {
                AVIMClient aVIMClient = aVIMConversation.client;
                object = (String)object;
                this.onUnmuted(aVIMClient, aVIMConversation, (String)object);
                break;
            }
            case 50018: {
                AVIMClient aVIMClient = aVIMConversation.client;
                object = (String)object;
                this.onMuted(aVIMClient, aVIMConversation, (String)object);
                break;
            }
            case 50017: {
                ArrayList<String> arrayList = new ArrayList<String>();
                String string2 = "role";
                arrayList.add(string2);
                AVIMClient aVIMClient = aVIMConversation.client;
                Object object3 = object2;
                object3 = (AVIMConversationMemberInfo)object2;
                Object object4 = object;
                object4 = (String)object;
                this.onMemberInfoUpdated(aVIMClient, aVIMConversation, (AVIMConversationMemberInfo)object3, arrayList, (String)object4);
                break;
            }
            case 50016: {
                object = (AVIMMessage)object;
                aVIMConversation.updateLocalMessage((AVIMMessage)object);
                AVIMClient aVIMClient = aVIMConversation.client;
                this.onMessageRecalled(aVIMClient, aVIMConversation, (AVIMMessage)object);
                break;
            }
            case 50015: {
                object = (AVIMMessage)object;
                aVIMConversation.updateLocalMessage((AVIMMessage)object);
                AVIMClient aVIMClient = aVIMConversation.client;
                this.onMessageUpdated(aVIMClient, aVIMConversation, (AVIMMessage)object);
                break;
            }
            case 50014: {
                object = (Long)object;
                long l10 = (Long)object;
                aVIMConversation.setLastDeliveredAt(l10, bl2);
                AVIMClient aVIMClient = aVIMConversation.client;
                this.onLastDeliveredAtUpdated(aVIMClient, aVIMConversation);
                break;
            }
            case 50013: {
                object = (Long)object;
                long l11 = (Long)object;
                aVIMConversation.setLastReadAt(l11, bl2);
                AVIMClient aVIMClient = aVIMConversation.client;
                this.onLastReadAtUpdated(aVIMClient, aVIMConversation);
                break;
            }
            case 50012: {
                object2 = (AbstractMap.SimpleEntry)object2;
                object = (AVIMMessage)object;
                n10 = (Integer)((AbstractMap.SimpleEntry)object2).getKey();
                object2 = (Boolean)((AbstractMap.SimpleEntry)object2).getValue();
                boolean bl3 = (Boolean)object2;
                aVIMConversation.updateUnreadCountAndMessage((AVIMMessage)object, n10, bl3);
                AVIMClient aVIMClient = aVIMConversation.client;
                this.onUnreadMessagesCountUpdated(aVIMClient, aVIMConversation);
                break;
            }
            case 50009: {
                AVIMClient aVIMClient = aVIMConversation.client;
                object = (String)object;
                this.onKicked(aVIMClient, aVIMConversation, (String)object);
                break;
            }
            case 50008: {
                AVIMClient aVIMClient = aVIMConversation.client;
                object = (String)object;
                this.onInvited(aVIMClient, aVIMConversation, (String)object);
                break;
            }
            case 50005: {
                AVIMClient aVIMClient = aVIMConversation.client;
                object2 = (List)object2;
                object = (String)object;
                this.onMemberJoined(aVIMClient, aVIMConversation, (List)object2, (String)object);
                break;
            }
            case 50004: {
                AVIMClient aVIMClient = aVIMConversation.client;
                object2 = (List)object2;
                object = (String)object;
                this.onMemberLeft(aVIMClient, aVIMConversation, (List)object2, (String)object);
            }
        }
    }

    public void onBlocked(AVIMClient object, AVIMConversation object2, String string2) {
        object = LOGGER;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Notification ---  you are blocked by ");
        ((StringBuilder)object2).append(string2);
        object2 = ((StringBuilder)object2).toString();
        ((AVLogger)object).d((String)object2);
    }

    public void onInfoChanged(AVIMClient object, AVIMConversation object2, JSONObject object3, String string2) {
        object = LOGGER;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Notification --- ");
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(" by member: ");
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(", changedTo: ");
        object3 = ((JSONObject)object3).toJSONString();
        ((StringBuilder)object2).append((String)object3);
        object2 = ((StringBuilder)object2).toString();
        ((AVLogger)object).d((String)object2);
    }

    public abstract void onInvited(AVIMClient var1, AVIMConversation var2, String var3);

    public abstract void onKicked(AVIMClient var1, AVIMConversation var2, String var3);

    public void onLastDeliveredAtUpdated(AVIMClient aVIMClient, AVIMConversation aVIMConversation) {
    }

    public void onLastReadAtUpdated(AVIMClient aVIMClient, AVIMConversation aVIMConversation) {
    }

    public void onMemberBlocked(AVIMClient object, AVIMConversation object2, List object3, String string2) {
        object = LOGGER;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Notification --- ");
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(" blocked members: ");
        object3 = StringUtil.join(", ", (Iterable)object3);
        ((StringBuilder)object2).append((String)object3);
        object2 = ((StringBuilder)object2).toString();
        ((AVLogger)object).d((String)object2);
    }

    public void onMemberInfoUpdated(AVIMClient object, AVIMConversation object2, AVIMConversationMemberInfo object3, List list, String string2) {
        object = LOGGER;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Notification --- ");
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(" updated memberInfo: ");
        object3 = ((AVIMConversationMemberInfo)object3).toString();
        ((StringBuilder)object2).append((String)object3);
        object2 = ((StringBuilder)object2).toString();
        ((AVLogger)object).d((String)object2);
    }

    public abstract void onMemberJoined(AVIMClient var1, AVIMConversation var2, List var3, String var4);

    public abstract void onMemberLeft(AVIMClient var1, AVIMConversation var2, List var3, String var4);

    public void onMemberMuted(AVIMClient object, AVIMConversation object2, List object3, String string2) {
        object = LOGGER;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Notification --- ");
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(" muted members: ");
        object3 = StringUtil.join(", ", (Iterable)object3);
        ((StringBuilder)object2).append((String)object3);
        object2 = ((StringBuilder)object2).toString();
        ((AVLogger)object).d((String)object2);
    }

    public void onMemberUnblocked(AVIMClient object, AVIMConversation object2, List object3, String string2) {
        object = LOGGER;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Notification --- ");
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(" unblocked members: ");
        object3 = StringUtil.join(", ", (Iterable)object3);
        ((StringBuilder)object2).append((String)object3);
        object2 = ((StringBuilder)object2).toString();
        ((AVLogger)object).d((String)object2);
    }

    public void onMemberUnmuted(AVIMClient object, AVIMConversation object2, List object3, String string2) {
        object = LOGGER;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Notification --- ");
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(" unmuted members: ");
        object3 = StringUtil.join(", ", (Iterable)object3);
        ((StringBuilder)object2).append((String)object3);
        object2 = ((StringBuilder)object2).toString();
        ((AVLogger)object).d((String)object2);
    }

    public void onMessageRecalled(AVIMClient aVIMClient, AVIMConversation aVIMConversation, AVIMMessage aVIMMessage) {
    }

    public void onMessageUpdated(AVIMClient aVIMClient, AVIMConversation aVIMConversation, AVIMMessage aVIMMessage) {
    }

    public void onMuted(AVIMClient object, AVIMConversation object2, String string2) {
        object = LOGGER;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Notification ---  you are muted by ");
        ((StringBuilder)object2).append(string2);
        object2 = ((StringBuilder)object2).toString();
        ((AVLogger)object).d((String)object2);
    }

    public void onUnblocked(AVIMClient object, AVIMConversation object2, String string2) {
        object = LOGGER;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Notification ---  you are unblocked by ");
        ((StringBuilder)object2).append(string2);
        object2 = ((StringBuilder)object2).toString();
        ((AVLogger)object).d((String)object2);
    }

    public void onUnmuted(AVIMClient object, AVIMConversation object2, String string2) {
        object = LOGGER;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Notification ---  you are unmuted by ");
        ((StringBuilder)object2).append(string2);
        object2 = ((StringBuilder)object2).toString();
        ((AVLogger)object).d((String)object2);
    }

    public void onUnreadMessagesCountUpdated(AVIMClient aVIMClient, AVIMConversation aVIMConversation) {
    }

    public final void processEvent0(int n10, Object object, Object object2, Object object3) {
        object3 = (AVIMConversation)object3;
        this.processConversationEvent(n10, object, object2, (AVIMConversation)object3);
    }
}

