/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 */
package cn.leancloud.im;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import cn.leancloud.AVException;
import cn.leancloud.AVInstallation;
import cn.leancloud.AVLogger;
import cn.leancloud.AVOSCloud;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.codec.MDFive;
import cn.leancloud.im.AVIMBaseBroadcastReceiver;
import cn.leancloud.im.AndroidOperationTube$1;
import cn.leancloud.im.AndroidOperationTube$10;
import cn.leancloud.im.AndroidOperationTube$11;
import cn.leancloud.im.AndroidOperationTube$12;
import cn.leancloud.im.AndroidOperationTube$13;
import cn.leancloud.im.AndroidOperationTube$14;
import cn.leancloud.im.AndroidOperationTube$15;
import cn.leancloud.im.AndroidOperationTube$2;
import cn.leancloud.im.AndroidOperationTube$3;
import cn.leancloud.im.AndroidOperationTube$4;
import cn.leancloud.im.AndroidOperationTube$5;
import cn.leancloud.im.AndroidOperationTube$6;
import cn.leancloud.im.AndroidOperationTube$7;
import cn.leancloud.im.AndroidOperationTube$8;
import cn.leancloud.im.AndroidOperationTube$9;
import cn.leancloud.im.IntentUtil;
import cn.leancloud.im.OperationTube;
import cn.leancloud.im.RequestCache;
import cn.leancloud.im.WindTalker;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.AVIMMessage;
import cn.leancloud.im.v2.AVIMMessageOption;
import cn.leancloud.im.v2.Conversation$AVIMOperation;
import cn.leancloud.im.v2.callback.AVIMClientCallback;
import cn.leancloud.im.v2.callback.AVIMClientStatusCallback;
import cn.leancloud.im.v2.callback.AVIMCommonJsonCallback;
import cn.leancloud.im.v2.callback.AVIMConversationCallback;
import cn.leancloud.im.v2.callback.AVIMMessagesQueryCallback;
import cn.leancloud.im.v2.callback.AVIMOnlineClientsCallback;
import cn.leancloud.json.JSON;
import cn.leancloud.livequery.AVLiveQuerySubscribeCallback;
import cn.leancloud.push.PushService;
import cn.leancloud.session.AVConnectionManager;
import cn.leancloud.session.AVSession;
import cn.leancloud.session.AVSessionManager;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AndroidOperationTube
implements OperationTube {
    private static AVLogger LOGGER = LogUtil.getLogger(AndroidOperationTube.class);

    public static /* synthetic */ AVLogger access$000() {
        return LOGGER;
    }

    public boolean closeClient(AVConnectionManager aVConnectionManager, String string2, AVIMClientCallback object) {
        AndroidOperationTube$3 androidOperationTube$3 = object != null ? new AndroidOperationTube$3(this, (AVCallback)object, string2) : null;
        object = Conversation$AVIMOperation.CLIENT_DISCONNECT;
        return this.sendClientCMDToPushService(string2, null, androidOperationTube$3, (Conversation$AVIMOperation)((Object)object));
    }

    public boolean createConversation(AVConnectionManager object, String string2, List object2, Map object3, boolean bl2, boolean bl3, boolean bl4, int n10, AVIMCommonJsonCallback aVIMCommonJsonCallback) {
        int n11;
        object = new HashMap();
        String string3 = "conversation.member";
        object.put(string3, object2);
        object2 = bl3;
        String string4 = "conversation.unique";
        object.put(string4, object2);
        object2 = bl2;
        object.put("conversation.transient", object2);
        object2 = bl4;
        String string5 = "conversation.temp";
        object.put(string5, object2);
        if (bl4) {
            object2 = n10;
            string5 = "conversation.tempTTL";
            object.put(string5, object2);
        }
        if (object3 != null && (n11 = object3.size()) > 0) {
            object2 = "conversation.attributes";
            object.put(object2, object3);
        }
        n11 = 0;
        object2 = null;
        if (aVIMCommonJsonCallback != null) {
            object2 = new AndroidOperationTube$6(this, aVIMCommonJsonCallback);
        }
        object = JSON.toJSONString(object);
        object3 = Conversation$AVIMOperation.CONVERSATION_CREATION;
        return this.sendClientCMDToPushService(string2, (String)object, (BroadcastReceiver)object2, (Conversation$AVIMOperation)((Object)object3));
    }

    public boolean fetchReceiptTimestamps(AVConnectionManager aVConnectionManager, String string2, String string3, int n10, Conversation$AVIMOperation conversation$AVIMOperation, AVIMCommonJsonCallback aVIMCommonJsonCallback) {
        return false;
    }

    public boolean loginLiveQuery(AVConnectionManager object, String object2, AVLiveQuerySubscribeCallback object3) {
        object = object3 != null ? new AndroidOperationTube$15(this, (AVCallback)object3) : null;
        Object object4 = AVOSCloud.getContext();
        if (object4 == null) {
            object = LOGGER;
            object2 = "failed to startService. cause: root Context is null.";
            ((AVLogger)object).e((String)object2);
            if (object3 != null) {
                int n10 = -1;
                object4 = "root Context is null, please initialize at first.";
                object = new AVException(n10, (String)object4);
                ((AVCallback)object3).internalDone((AVException)object);
            }
            return false;
        }
        int n11 = WindTalker.getNextIMRequestId();
        object4 = LocalBroadcastManager.getInstance(AVOSCloud.getContext());
        CharSequence charSequence = new StringBuilder();
        String string2 = "live_query_";
        charSequence.append(string2);
        charSequence.append(n11);
        charSequence = charSequence.toString();
        Object object5 = new IntentFilter((String)charSequence);
        ((LocalBroadcastManager)object4).registerReceiver((BroadcastReceiver)object, (IntentFilter)object5);
        try {
            object4 = AVOSCloud.getContext();
            object5 = PushService.class;
        }
        catch (Exception exception) {
            object2 = LOGGER;
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("failed to start PushServer. cause: ");
            String string3 = exception.getMessage();
            ((StringBuilder)object3).append(string3);
            string3 = ((StringBuilder)object3).toString();
            ((AVLogger)object2).e(string3);
            return false;
        }
        object = new Intent((Context)object4, (Class)object5);
        object4 = "action_live_query_login";
        object.setAction((String)object4);
        object4 = "id";
        object.putExtra((String)object4, (String)object2);
        object2 = "conversation.requestId";
        object.putExtra((String)object2, n11);
        object2 = AVOSCloud.getContext();
        object = IntentUtil.setupIntentFlags((Intent)object);
        object2.startService((Intent)object);
        return true;
    }

    public boolean markConversationRead(AVConnectionManager object, String string2, String string3, int n10, Map map) {
        object = map == null ? null : JSON.toJSONString(map);
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_READ;
        return this.sendClientCMDToPushService(string2, string3, n10, (String)object, null, null, conversation$AVIMOperation, null);
    }

    public void onLiveQueryCompleted(int n10, Throwable throwable) {
        IntentUtil.sendLiveQueryLocalBroadcast(n10, throwable);
    }

    public void onOperationCompleted(String string2, String object, int n10, Conversation$AVIMOperation conversation$AVIMOperation, Throwable throwable) {
        Object object2 = Conversation$AVIMOperation.CONVERSATION_QUERY;
        if (object2 == conversation$AVIMOperation && (object2 = RequestCache.getInstance().getRequestCallback(string2, null, n10)) != null) {
            object = AVIMException.wrapperAVException(throwable);
            ((AVCallback)object2).internalDone(null, (AVException)object);
            RequestCache.getInstance().cleanRequestCallback(string2, null, n10);
            return;
        }
        IntentUtil.sendIMLocalBroadcast(string2, (String)object, n10, throwable, conversation$AVIMOperation);
    }

    public void onOperationCompletedEx(String string2, String string3, int n10, Conversation$AVIMOperation conversation$AVIMOperation, HashMap hashMap) {
        Object object = Conversation$AVIMOperation.CONVERSATION_QUERY;
        if (object == conversation$AVIMOperation && (object = RequestCache.getInstance().getRequestCallback(string2, null, n10)) != null) {
            ((AVCallback)object).internalDone(hashMap, null);
            RequestCache.getInstance().cleanRequestCallback(string2, null, n10);
            return;
        }
        IntentUtil.sendMap2LocalBroadcase(string2, string3, n10, hashMap, null, conversation$AVIMOperation);
    }

    public void onPushMessage(String string2, String string3) {
    }

    public boolean openClient(AVConnectionManager object, String string2, String object2, String object3, boolean bl2, AVIMClientCallback aVIMClientCallback) {
        object = new HashMap();
        object.put("client.tag", object2);
        object.put("client.userSession", object3);
        object3 = bl2;
        object.put("client.reconnect", object3);
        object3 = LOGGER;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("openClient. clientId:");
        stringBuilder.append(string2);
        String string3 = ", tag:";
        stringBuilder.append(string3);
        stringBuilder.append((String)object2);
        stringBuilder.append(", callback:");
        stringBuilder.append(aVIMClientCallback);
        object2 = stringBuilder.toString();
        ((AVLogger)object3).d((String)object2);
        object2 = aVIMClientCallback != null ? new AndroidOperationTube$1(this, aVIMClientCallback, string2) : null;
        object = JSON.toJSONString(object);
        object3 = Conversation$AVIMOperation.CLIENT_OPEN;
        return this.sendClientCMDToPushService(string2, (String)object, (BroadcastReceiver)object2, (Conversation$AVIMOperation)((Object)object3));
    }

    public boolean participateConversation(AVConnectionManager aVConnectionManager, String string2, String string3, int n10, Map map, Conversation$AVIMOperation conversation$AVIMOperation, AVIMConversationCallback aVIMConversationCallback) {
        AndroidOperationTube$8 androidOperationTube$8;
        String string4 = null;
        AndroidOperationTube$8 androidOperationTube$82 = aVIMConversationCallback != null ? (androidOperationTube$8 = new AndroidOperationTube$8(this, aVIMConversationCallback)) : null;
        if (map != null) {
            string4 = JSON.toJSONString(map);
        }
        return this.sendClientCMDToPushService(string2, string3, n10, string4, null, null, conversation$AVIMOperation, androidOperationTube$82);
    }

    public boolean processMembers(AVConnectionManager aVConnectionManager, String string2, String string3, int n10, String string4, Conversation$AVIMOperation conversation$AVIMOperation, AVCallback aVCallback) {
        AndroidOperationTube$14 androidOperationTube$14 = aVCallback != null ? new AndroidOperationTube$14(this, aVCallback, conversation$AVIMOperation) : null;
        return this.sendClientCMDToPushService(string2, string3, n10, string4, null, null, conversation$AVIMOperation, androidOperationTube$14);
    }

    public boolean queryClientStatus(AVConnectionManager aVConnectionManager, String string2, AVIMClientStatusCallback object) {
        AndroidOperationTube$2 androidOperationTube$2 = object != null ? new AndroidOperationTube$2(this, (AVCallback)object) : null;
        object = Conversation$AVIMOperation.CLIENT_STATUS;
        return this.sendClientCMDToPushService(string2, null, androidOperationTube$2, (Conversation$AVIMOperation)((Object)object));
    }

    public boolean queryConversations(AVConnectionManager object, String string2, String string3, AVIMCommonJsonCallback object2) {
        object = object2 != null ? new AndroidOperationTube$9(this, (AVCallback)object2) : null;
        object2 = Conversation$AVIMOperation.CONVERSATION_QUERY;
        return this.sendClientCMDToPushService(string2, string3, (BroadcastReceiver)object, (Conversation$AVIMOperation)((Object)object2));
    }

    public boolean queryConversationsInternally(AVConnectionManager object, String object2, String string2, AVIMCommonJsonCallback object3) {
        LOGGER.d("queryConversationsInternally...");
        int n10 = WindTalker.getNextIMRequestId();
        RequestCache.getInstance().addRequestCallback((String)object2, null, n10, (AVCallback)object3);
        object3 = AVSessionManager.getInstance();
        String string3 = AVInstallation.getCurrentInstallation().getInstallationId();
        object = ((AVSessionManager)object3).getOrCreateSession((String)object2, string3, (AVConnectionManager)object);
        object2 = (Map)JSON.parseObject(string2, Map.class);
        string2 = MDFive.computeMD5(string2);
        ((AVSession)object).queryConversations((Map)object2, n10, string2);
        return true;
    }

    public boolean queryMessages(AVConnectionManager aVConnectionManager, String string2, String string3, int n10, String string4, Conversation$AVIMOperation conversation$AVIMOperation, AVIMMessagesQueryCallback aVIMMessagesQueryCallback) {
        AndroidOperationTube$13 androidOperationTube$13 = aVIMMessagesQueryCallback != null ? new AndroidOperationTube$13(this, aVIMMessagesQueryCallback) : null;
        Conversation$AVIMOperation conversation$AVIMOperation2 = Conversation$AVIMOperation.CONVERSATION_MESSAGE_QUERY;
        return this.sendClientCMDToPushService(string2, string3, n10, string4, null, null, conversation$AVIMOperation2, androidOperationTube$13);
    }

    public boolean queryOnlineClients(AVConnectionManager object, String string2, List object2, AVIMOnlineClientsCallback object3) {
        object = new HashMap();
        String string3 = "client.oneline";
        object.put(string3, object2);
        object2 = object3 != null ? new AndroidOperationTube$5(this, (AVCallback)object3) : null;
        object = JSON.toJSONString(object);
        object3 = Conversation$AVIMOperation.CLIENT_ONLINE_QUERY;
        return this.sendClientCMDToPushService(string2, (String)object, (BroadcastReceiver)object2, (Conversation$AVIMOperation)((Object)object3));
    }

    public boolean recallMessage(AVConnectionManager object, String string2, int n10, AVIMMessage aVIMMessage, AVIMCommonJsonCallback aVIMCommonJsonCallback) {
        object = aVIMCommonJsonCallback != null ? new AndroidOperationTube$12(this, aVIMCommonJsonCallback) : null;
        String string3 = aVIMMessage.getConversationId();
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_RECALL_MESSAGE;
        return this.sendClientCMDToPushService(string2, string3, n10, null, aVIMMessage, null, conversation$AVIMOperation, (BroadcastReceiver)object);
    }

    public boolean renewSessionToken(AVConnectionManager aVConnectionManager, String string2, AVIMClientCallback object) {
        AndroidOperationTube$4 androidOperationTube$4 = object != null ? new AndroidOperationTube$4(this, (AVCallback)object) : null;
        object = Conversation$AVIMOperation.CLIENT_REFRESH_TOKEN;
        return this.sendClientCMDToPushService(string2, null, androidOperationTube$4, (Conversation$AVIMOperation)((Object)object));
    }

    public boolean sendClientCMDToPushService(String object, String object2, int n10, String string2, AVIMMessage object3, AVIMMessageOption aVIMMessageOption, Conversation$AVIMOperation conversation$AVIMOperation, BroadcastReceiver broadcastReceiver) {
        Object object4;
        Object object5;
        Context context = AVOSCloud.getContext();
        if (context == null) {
            boolean bl2;
            object = LOGGER;
            object2 = "failed to startService. cause: root Context is null.";
            ((AVLogger)object).e((String)object2);
            if (broadcastReceiver != null && (bl2 = broadcastReceiver instanceof AVIMBaseBroadcastReceiver)) {
                broadcastReceiver = (AVIMBaseBroadcastReceiver)broadcastReceiver;
                object = new HashMap();
                n10 = -1;
                string2 = "root Context is null, please initialize at first.";
                object2 = new AVException(n10, string2);
                broadcastReceiver.execute((Map)object, (Throwable)object2);
            }
            return false;
        }
        int n11 = WindTalker.getNextIMRequestId();
        if (broadcastReceiver != null) {
            object5 = LocalBroadcastManager.getInstance(AVOSCloud.getContext());
            CharSequence charSequence = new StringBuilder();
            String string3 = conversation$AVIMOperation.getOperation();
            charSequence.append(string3);
            charSequence.append(n11);
            charSequence = charSequence.toString();
            object4 = new IntentFilter((String)charSequence);
            ((LocalBroadcastManager)object5).registerReceiver(broadcastReceiver, (IntentFilter)object4);
        }
        object5 = AVOSCloud.getContext();
        broadcastReceiver = new Intent((Context)object5, PushService.class);
        object5 = "com.avoscloud.im.v2.action";
        broadcastReceiver.setAction((String)object5);
        boolean bl3 = StringUtil.isEmpty(string2);
        object4 = "conversation.data";
        if (!bl3) {
            broadcastReceiver.putExtra((String)object4, string2);
        }
        if (object3 != null) {
            string2 = ((AVIMMessage)object3).toJSONString();
            broadcastReceiver.putExtra((String)object4, string2);
            if (aVIMMessageOption != null) {
                string2 = aVIMMessageOption.toJSONString();
                object3 = "conversation.messageoption";
                broadcastReceiver.putExtra((String)object3, string2);
            }
        }
        string2 = "conversation.client";
        broadcastReceiver.putExtra(string2, object);
        broadcastReceiver.putExtra("convesration.id", (String)object2);
        broadcastReceiver.putExtra("conversation.type", n10);
        int n12 = conversation$AVIMOperation.getCode();
        object2 = "conversation.operation";
        broadcastReceiver.putExtra((String)object2, n12);
        object = "conversation.requestId";
        broadcastReceiver.putExtra((String)object, n11);
        try {
            object = AVOSCloud.getContext();
        }
        catch (Exception exception) {
            object2 = LOGGER;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("failed to startService. cause: ");
            String string4 = exception.getMessage();
            stringBuilder.append(string4);
            string4 = stringBuilder.toString();
            ((AVLogger)object2).e(string4);
            return false;
        }
        object2 = IntentUtil.setupIntentFlags((Intent)broadcastReceiver);
        object.startService((Intent)object2);
        return true;
    }

    public boolean sendClientCMDToPushService(String object, String object2, BroadcastReceiver object3, Conversation$AVIMOperation conversation$AVIMOperation) {
        Object object4;
        Object object5;
        Object object6 = AVOSCloud.getContext();
        if (object6 == null) {
            boolean bl2;
            object = LOGGER;
            object2 = "failed to startService. cause: root Context is null.";
            ((AVLogger)object).e((String)object2);
            if (object3 != null && (bl2 = object3 instanceof AVIMBaseBroadcastReceiver)) {
                object3 = (AVIMBaseBroadcastReceiver)((Object)object3);
                object = new HashMap();
                int n10 = -1;
                object6 = "root Context is null, please initialize at first.";
                object2 = new AVException(n10, (String)object6);
                ((AVIMBaseBroadcastReceiver)((Object)object3)).execute((Map)object, (Throwable)object2);
            }
            return false;
        }
        int n11 = WindTalker.getNextIMRequestId();
        if (object3 != null) {
            object5 = LocalBroadcastManager.getInstance(AVOSCloud.getContext());
            CharSequence charSequence = new StringBuilder();
            String string2 = conversation$AVIMOperation.getOperation();
            charSequence.append(string2);
            charSequence.append(n11);
            charSequence = charSequence.toString();
            object4 = new IntentFilter((String)charSequence);
            ((LocalBroadcastManager)object5).registerReceiver((BroadcastReceiver)object3, (IntentFilter)object4);
        }
        object5 = AVOSCloud.getContext();
        object4 = PushService.class;
        object3 = new Intent((Context)object5, (Class)object4);
        object5 = "com.avoscloud.im.v2.action";
        object3.setAction((String)object5);
        boolean bl3 = StringUtil.isEmpty((String)object2);
        if (!bl3) {
            object5 = "conversation.data";
            object3.putExtra((String)object5, (String)object2);
        }
        object3.putExtra("conversation.client", object);
        object = "conversation.requestId";
        object3.putExtra((String)object, n11);
        int n12 = conversation$AVIMOperation.getCode();
        object2 = "conversation.operation";
        object3.putExtra((String)object2, n12);
        try {
            object = AVOSCloud.getContext();
        }
        catch (Exception exception) {
            object2 = LOGGER;
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("failed to startService. cause: ");
            String string3 = exception.getMessage();
            ((StringBuilder)object3).append(string3);
            string3 = ((StringBuilder)object3).toString();
            ((AVLogger)object2).e(string3);
            return false;
        }
        object2 = IntentUtil.setupIntentFlags((Intent)object3);
        object.startService((Intent)object2);
        return true;
    }

    public boolean sendClientCMDToPushService2(String object, String object2, int n10, AVIMMessage object3, AVIMMessage object4, Conversation$AVIMOperation conversation$AVIMOperation, BroadcastReceiver broadcastReceiver) {
        Object object5;
        Object object6;
        Context context = AVOSCloud.getContext();
        if (context == null) {
            boolean bl2;
            object = LOGGER;
            object2 = "failed to startService. cause: root Context is null.";
            ((AVLogger)object).e((String)object2);
            if (broadcastReceiver != null && (bl2 = broadcastReceiver instanceof AVIMBaseBroadcastReceiver)) {
                broadcastReceiver = (AVIMBaseBroadcastReceiver)broadcastReceiver;
                object = new HashMap();
                n10 = -1;
                object3 = "root Context is null, please initialize at first.";
                object2 = new AVException(n10, (String)object3);
                broadcastReceiver.execute((Map)object, (Throwable)object2);
            }
            return false;
        }
        int n11 = WindTalker.getNextIMRequestId();
        if (broadcastReceiver != null) {
            object6 = LocalBroadcastManager.getInstance(AVOSCloud.getContext());
            CharSequence charSequence = new StringBuilder();
            String string2 = conversation$AVIMOperation.getOperation();
            charSequence.append(string2);
            charSequence.append(n11);
            charSequence = charSequence.toString();
            object5 = new IntentFilter((String)charSequence);
            ((LocalBroadcastManager)object6).registerReceiver(broadcastReceiver, (IntentFilter)object5);
        }
        object6 = AVOSCloud.getContext();
        object5 = PushService.class;
        broadcastReceiver = new Intent((Context)object6, (Class)object5);
        object6 = "com.avoscloud.im.v2.action";
        broadcastReceiver.setAction((String)object6);
        if (object3 != null) {
            object3 = ((AVIMMessage)object3).toJSONString();
            object6 = "conversation.data";
            broadcastReceiver.putExtra((String)object6, (String)object3);
        }
        if (object4 != null) {
            object3 = ((AVIMMessage)object4).toJSONString();
            object4 = "conversation.message.ex";
            broadcastReceiver.putExtra((String)object4, (String)object3);
        }
        object3 = "conversation.client";
        broadcastReceiver.putExtra((String)object3, object);
        broadcastReceiver.putExtra("convesration.id", (String)object2);
        broadcastReceiver.putExtra("conversation.type", n10);
        int n12 = conversation$AVIMOperation.getCode();
        object2 = "conversation.operation";
        broadcastReceiver.putExtra((String)object2, n12);
        object = "conversation.requestId";
        broadcastReceiver.putExtra((String)object, n11);
        try {
            object = AVOSCloud.getContext();
        }
        catch (Exception exception) {
            object2 = LOGGER;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("failed to startService. cause: ");
            String string3 = exception.getMessage();
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            ((AVLogger)object2).e(string3);
            return false;
        }
        object2 = IntentUtil.setupIntentFlags((Intent)broadcastReceiver);
        object.startService((Intent)object2);
        return true;
    }

    public boolean sendMessage(AVConnectionManager aVConnectionManager, String string2, String string3, int n10, AVIMMessage aVIMMessage, AVIMMessageOption aVIMMessageOption, AVIMCommonJsonCallback aVIMCommonJsonCallback) {
        AndroidOperationTube$10 androidOperationTube$10 = aVIMCommonJsonCallback != null ? new AndroidOperationTube$10(this, aVIMCommonJsonCallback) : null;
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_SEND_MESSAGE;
        return this.sendClientCMDToPushService(string2, string3, n10, null, aVIMMessage, aVIMMessageOption, conversation$AVIMOperation, androidOperationTube$10);
    }

    public boolean updateConversation(AVConnectionManager object, String string2, String string3, int n10, Map map, AVIMCommonJsonCallback aVIMCommonJsonCallback) {
        object = aVIMCommonJsonCallback != null ? new AndroidOperationTube$7(this, aVIMCommonJsonCallback) : null;
        String string4 = JSON.toJSONString(map);
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_UPDATE;
        return this.sendClientCMDToPushService(string2, string3, n10, string4, null, null, conversation$AVIMOperation, (BroadcastReceiver)object);
    }

    public boolean updateMessage(AVConnectionManager object, String string2, int n10, AVIMMessage aVIMMessage, AVIMMessage aVIMMessage2, AVIMCommonJsonCallback aVIMCommonJsonCallback) {
        object = aVIMCommonJsonCallback != null ? new AndroidOperationTube$11(this, aVIMCommonJsonCallback) : null;
        String string3 = aVIMMessage.getConversationId();
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_UPDATE_MESSAGE;
        return this.sendClientCMDToPushService2(string2, string3, n10, aVIMMessage, aVIMMessage2, conversation$AVIMOperation, (BroadcastReceiver)object);
    }
}

