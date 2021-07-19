/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.im.v2.AVIMConversationsQuery;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.callback.AVIMCommonJsonCallback;
import cn.leancloud.im.v2.callback.AVIMConversationQueryCallback;
import cn.leancloud.json.JSON;
import java.util.List;
import java.util.Map;

public class AVIMConversationsQuery$4
extends AVIMCommonJsonCallback {
    public final /* synthetic */ AVIMConversationsQuery this$0;
    public final /* synthetic */ AVIMConversationQueryCallback val$callback;
    public final /* synthetic */ Map val$queryParams;

    public AVIMConversationsQuery$4(AVIMConversationsQuery aVIMConversationsQuery, Map map, AVIMConversationQueryCallback aVIMConversationQueryCallback) {
        this.this$0 = aVIMConversationsQuery;
        this.val$queryParams = map;
        this.val$callback = aVIMConversationQueryCallback;
    }

    /*
     * Unable to fully structure code
     */
    public void done(Map var1_1, AVIMException var2_2) {
        if (var1_1 == null) ** GOTO lbl-1000
        var3_3 = "callbackData";
        var4_4 = (var1_1 = var1_1.get(var3_3)) instanceof List;
        if (var4_4 != 0) {
            var1_1 = (List)var1_1;
            var3_3 = this.this$0;
            if ((var1_1 = AVIMConversationsQuery.access$300((AVIMConversationsQuery)var3_3, (List)var1_1)) != null && (var4_4 = var1_1.size()) > 0) {
                var3_3 = this.this$0;
                var5_5 = this.val$queryParams;
                AVIMConversationsQuery.access$400((AVIMConversationsQuery)var3_3, var5_5, (List)var1_1);
            }
        } else {
            var4_4 = var1_1 instanceof String;
            if (var4_4 != 0) {
                var3_3 = this.this$0;
                var1_1 = String.valueOf(var1_1);
                var5_6 = List.class;
                var1_1 = (List)JSON.parseObject((String)var1_1, var5_6);
                if ((var1_1 = AVIMConversationsQuery.access$300((AVIMConversationsQuery)var3_3, (List)var1_1)) != null && (var4_4 = var1_1.size()) > 0) {
                    var3_3 = this.this$0;
                    var5_6 = this.val$queryParams;
                    AVIMConversationsQuery.access$400((AVIMConversationsQuery)var3_3, (Map)var5_6, (List)var1_1);
                }
            } else lbl-1000:
            // 2 sources

            {
                var1_1 = null;
            }
        }
        if ((var3_3 = this.val$callback) != null) {
            var3_3.internalDone(var1_1, var2_2);
        }
    }
}

