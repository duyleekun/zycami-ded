/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.service;

import cn.leancloud.im.v2.conversation.AVIMConversationMemberInfo;
import cn.leancloud.service.RealtimeClient;
import e.a.v0.o;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RealtimeClient$3
implements o {
    public final /* synthetic */ RealtimeClient this$0;

    public RealtimeClient$3(RealtimeClient realtimeClient) {
        this.this$0 = realtimeClient;
    }

    public List apply(Map iterator2) {
        boolean bl2;
        iterator2 = (List)iterator2.get("results");
        LinkedList<AVIMConversationMemberInfo> linkedList = new LinkedList<AVIMConversationMemberInfo>();
        iterator2 = iterator2.iterator();
        while (bl2 = iterator2.hasNext()) {
            AVIMConversationMemberInfo aVIMConversationMemberInfo = AVIMConversationMemberInfo.createInstance((Map)iterator2.next());
            linkedList.add(aVIMConversationMemberInfo);
        }
        return linkedList;
    }
}

