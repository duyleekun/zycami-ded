/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.AVIMMessageStorage;
import cn.leancloud.im.v2.callback.AVIMCommonJsonCallback;
import cn.leancloud.im.v2.callback.AVIMConversationCallback;
import java.util.Arrays;
import java.util.Map;

public class AVIMConversation$14
extends AVIMCommonJsonCallback {
    public final /* synthetic */ AVIMConversation this$0;
    public final /* synthetic */ AVIMConversationCallback val$callback;

    public AVIMConversation$14(AVIMConversation aVIMConversation, AVIMConversationCallback aVIMConversationCallback) {
        this.this$0 = aVIMConversation;
        this.val$callback = aVIMConversationCallback;
    }

    public void done(Map list, AVIMException aVIMException) {
        if (aVIMException == null) {
            Map map;
            Object object;
            Object object2;
            boolean bl2;
            list = this.this$0.operations.entrySet().iterator();
            while (bl2 = list.hasNext()) {
                object2 = (String)list.next().getKey();
                object = this.this$0.get((String)object2);
                if (object == null) {
                    object = this.this$0.instanceData;
                    AVIMConversation.recurDeleteData((Map)object, (String)object2);
                    continue;
                }
                map = this.this$0.instanceData;
                AVIMConversation.recurSetData(map, (String)object2, object);
            }
            list = this.this$0;
            object2 = ((AVIMConversation)list).storage;
            int n10 = 1;
            object = new AVIMConversation[n10];
            map = null;
            object[0] = list;
            list = Arrays.asList(object);
            ((AVIMMessageStorage)object2).insertConversations(list);
        }
        if ((list = this.val$callback) != null) {
            ((AVCallback)((Object)list)).internalDone(aVIMException);
        }
    }
}

