/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.AVLogger;
import cn.leancloud.im.v2.AVIMConversationsQuery;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.json.JSON;
import e.a.v0.o;
import java.util.List;

public class AVIMConversationsQuery$3
implements o {
    public final /* synthetic */ AVIMConversationsQuery this$0;

    public AVIMConversationsQuery$3(AVIMConversationsQuery aVIMConversationsQuery) {
        this.this$0 = aVIMConversationsQuery;
    }

    public List apply(String object) {
        Object object2 = AVIMConversationsQuery.access$000();
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append("map function. input: ");
        ((StringBuilder)object3).append((String)object);
        object3 = ((StringBuilder)object3).toString();
        ((AVLogger)object2).d((String)object3);
        object = (List)JSON.parseObject((String)object, List.class);
        object2 = AVIMConversationsQuery.access$200(this.this$0).getStorage().getCachedConversations((List)object);
        object3 = AVIMConversationsQuery.access$000();
        CharSequence charSequence = new StringBuilder();
        String string2 = "map function. output: ";
        charSequence.append(string2);
        int n10 = object2.size();
        charSequence.append(n10);
        charSequence = charSequence.toString();
        ((AVLogger)object3).d((String)charSequence);
        int n11 = object2.size();
        int n12 = object.size();
        if (n11 >= n12) {
            return object2;
        }
        object = new AVIMException(120, "missing conversation cache in database");
        throw object;
    }
}

