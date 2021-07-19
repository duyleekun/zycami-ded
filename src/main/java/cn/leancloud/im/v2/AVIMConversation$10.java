/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.callback.AVIMMessagesQueryCallback;
import java.util.List;

public class AVIMConversation$10
extends AVIMMessagesQueryCallback {
    public final /* synthetic */ AVIMConversation this$0;
    public final /* synthetic */ AVIMMessagesQueryCallback val$callback;
    public final /* synthetic */ int val$limit;

    public AVIMConversation$10(AVIMConversation aVIMConversation, int n10, AVIMMessagesQueryCallback aVIMMessagesQueryCallback) {
        this.this$0 = aVIMConversation;
        this.val$limit = n10;
        this.val$callback = aVIMMessagesQueryCallback;
    }

    public void done(List object, AVIMException object2) {
        if (object2 != null) {
            int n10;
            int n11 = ((AVException)object2).getCode();
            if (n11 != (n10 = 124) && (n11 = ((AVException)object2).getCode()) != 0 && (n11 = ((AVException)object2).getCode()) != (n10 = 3000)) {
                object = this.val$callback;
                if (object != null) {
                    ((AVCallback)object).internalDone((AVException)object2);
                }
            } else {
                AVIMConversation aVIMConversation = this.this$0;
                long l10 = 0L;
                int n12 = this.val$limit;
                AVIMMessagesQueryCallback aVIMMessagesQueryCallback = this.val$callback;
                AVIMConversation.access$300(aVIMConversation, null, l10, n12, aVIMMessagesQueryCallback);
            }
        } else {
            int n13;
            int n14;
            if (object != null && (n14 = object.size()) >= (n13 = 1)) {
                object2 = this.this$0;
                AVIMConversation.access$200((AVIMConversation)object2, (List)object);
            }
            AVIMConversation aVIMConversation = this.this$0;
            long l11 = 0L;
            int n15 = this.val$limit;
            AVIMMessagesQueryCallback aVIMMessagesQueryCallback = this.val$callback;
            AVIMConversation.access$300(aVIMConversation, null, l11, n15, aVIMMessagesQueryCallback);
        }
    }
}

