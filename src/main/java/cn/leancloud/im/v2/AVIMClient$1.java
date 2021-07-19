/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.AVIMOptions;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.AVIMMessageStorage;
import cn.leancloud.im.v2.callback.AVIMCommonJsonCallback;
import cn.leancloud.im.v2.callback.AVIMConversationCreatedCallback;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AVIMClient$1
extends AVIMCommonJsonCallback {
    public final /* synthetic */ AVIMClient this$0;
    public final /* synthetic */ Map val$attributes;
    public final /* synthetic */ AVIMConversationCreatedCallback val$callback;
    public final /* synthetic */ List val$conversationMembers;
    public final /* synthetic */ boolean val$isTemp;
    public final /* synthetic */ boolean val$isTransient;
    public final /* synthetic */ String val$name;
    public final /* synthetic */ int val$tempTTL;

    public AVIMClient$1(AVIMClient aVIMClient, boolean bl2, boolean bl3, List list, Map map, String string2, int n10, AVIMConversationCreatedCallback aVIMConversationCreatedCallback) {
        this.this$0 = aVIMClient;
        this.val$isTransient = bl2;
        this.val$isTemp = bl3;
        this.val$conversationMembers = list;
        this.val$attributes = map;
        this.val$name = string2;
        this.val$tempTTL = n10;
        this.val$callback = aVIMConversationCreatedCallback;
    }

    public void done(Map object, AVIMException aVIMException) {
        Object object2;
        if (object != null) {
            Object object3 = (AVIMConversation[])object.get("callbackconversation");
            object2 = this.this$0;
            boolean bl2 = this.val$isTransient;
            int n10 = this.val$isTemp;
            object2 = ((AVIMClient)object2).getConversation((String)object3, bl2, n10 != 0);
            String string2 = (String)object.get("callbackCreatedAt");
            Object object4 = "callbackTemporaryTTL";
            boolean bl3 = object.containsKey(object4);
            if (bl3) {
                object4 = (Integer)object.get(object4);
                n10 = (Integer)object4;
            } else {
                n10 = 0;
                object4 = null;
            }
            String string3 = "callbackUniqueId";
            boolean bl4 = object.containsKey(string3);
            if (bl4) {
                object = (String)object.get(string3);
                ((AVIMConversation)object2).setUniqueId((String)object);
            }
            object = this.val$conversationMembers;
            ((AVIMConversation)object2).setMembers((List)object);
            object = this.val$attributes;
            ((AVIMConversation)object2).setAttributesForInit((Map)object);
            object = this.val$name;
            ((AVIMConversation)object2).setNameForInit((String)object);
            boolean bl5 = this.val$isTransient;
            ((AVIMConversation)object2).setTransientForInit(bl5);
            ((AVIMConversation)object2).setConversationId((String)object3);
            object = AVIMClient.access$000(this.this$0);
            ((AVIMConversation)object2).setCreator((String)object);
            ((AVIMConversation)object2).setCreatedAt(string2);
            ((AVIMConversation)object2).setUpdatedAt(string2);
            bl5 = this.val$isTemp;
            ((AVIMConversation)object2).setTemporary(bl5);
            long l10 = this.val$tempTTL;
            ((AVIMConversation)object2).setTemporaryExpiredat(l10);
            l10 = System.currentTimeMillis();
            ((AVIMConversation)object2).updateFetchTimestamp(l10);
            l10 = System.currentTimeMillis();
            long l11 = 1000L;
            l10 /= l11;
            long l12 = n10;
            ((AVIMConversation)object2).setTemporaryExpiredat(l10 += l12);
            object = AVIMOptions.getGlobalOptions();
            bl5 = ((AVIMOptions)object).isMessageQueryCacheEnabled();
            if (bl5) {
                object = AVIMClient.access$100(this.this$0);
                int n11 = 1;
                object3 = new AVIMConversation[n11];
                object3[0] = object2;
                object3 = Arrays.asList(object3);
                ((AVIMMessageStorage)object).insertConversations((List)object3);
            }
        } else {
            object2 = null;
        }
        if ((object = this.val$callback) != null) {
            aVIMException = AVIMException.wrapperAVException(aVIMException);
            ((AVCallback)object).internalDone(object2, aVIMException);
        }
    }
}

