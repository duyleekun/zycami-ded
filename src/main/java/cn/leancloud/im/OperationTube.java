/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im;

import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.v2.AVIMMessage;
import cn.leancloud.im.v2.AVIMMessageOption;
import cn.leancloud.im.v2.Conversation$AVIMOperation;
import cn.leancloud.im.v2.callback.AVIMClientCallback;
import cn.leancloud.im.v2.callback.AVIMClientStatusCallback;
import cn.leancloud.im.v2.callback.AVIMCommonJsonCallback;
import cn.leancloud.im.v2.callback.AVIMConversationCallback;
import cn.leancloud.im.v2.callback.AVIMMessagesQueryCallback;
import cn.leancloud.im.v2.callback.AVIMOnlineClientsCallback;
import cn.leancloud.livequery.AVLiveQuerySubscribeCallback;
import cn.leancloud.session.AVConnectionManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface OperationTube {
    public boolean closeClient(AVConnectionManager var1, String var2, AVIMClientCallback var3);

    public boolean createConversation(AVConnectionManager var1, String var2, List var3, Map var4, boolean var5, boolean var6, boolean var7, int var8, AVIMCommonJsonCallback var9);

    public boolean fetchReceiptTimestamps(AVConnectionManager var1, String var2, String var3, int var4, Conversation$AVIMOperation var5, AVIMCommonJsonCallback var6);

    public boolean loginLiveQuery(AVConnectionManager var1, String var2, AVLiveQuerySubscribeCallback var3);

    public boolean markConversationRead(AVConnectionManager var1, String var2, String var3, int var4, Map var5);

    public void onLiveQueryCompleted(int var1, Throwable var2);

    public void onOperationCompleted(String var1, String var2, int var3, Conversation$AVIMOperation var4, Throwable var5);

    public void onOperationCompletedEx(String var1, String var2, int var3, Conversation$AVIMOperation var4, HashMap var5);

    public boolean openClient(AVConnectionManager var1, String var2, String var3, String var4, boolean var5, AVIMClientCallback var6);

    public boolean participateConversation(AVConnectionManager var1, String var2, String var3, int var4, Map var5, Conversation$AVIMOperation var6, AVIMConversationCallback var7);

    public boolean processMembers(AVConnectionManager var1, String var2, String var3, int var4, String var5, Conversation$AVIMOperation var6, AVCallback var7);

    public boolean queryClientStatus(AVConnectionManager var1, String var2, AVIMClientStatusCallback var3);

    public boolean queryConversations(AVConnectionManager var1, String var2, String var3, AVIMCommonJsonCallback var4);

    public boolean queryConversationsInternally(AVConnectionManager var1, String var2, String var3, AVIMCommonJsonCallback var4);

    public boolean queryMessages(AVConnectionManager var1, String var2, String var3, int var4, String var5, Conversation$AVIMOperation var6, AVIMMessagesQueryCallback var7);

    public boolean queryOnlineClients(AVConnectionManager var1, String var2, List var3, AVIMOnlineClientsCallback var4);

    public boolean recallMessage(AVConnectionManager var1, String var2, int var3, AVIMMessage var4, AVIMCommonJsonCallback var5);

    public boolean renewSessionToken(AVConnectionManager var1, String var2, AVIMClientCallback var3);

    public boolean sendMessage(AVConnectionManager var1, String var2, String var3, int var4, AVIMMessage var5, AVIMMessageOption var6, AVIMCommonJsonCallback var7);

    public boolean updateConversation(AVConnectionManager var1, String var2, String var3, int var4, Map var5, AVIMCommonJsonCallback var6);

    public boolean updateMessage(AVConnectionManager var1, String var2, int var3, AVIMMessage var4, AVIMMessage var5, AVIMCommonJsonCallback var6);
}

