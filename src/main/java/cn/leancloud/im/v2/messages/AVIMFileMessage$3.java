/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2.messages;

import cn.leancloud.AVLogger;
import cn.leancloud.callback.SaveCallback;
import cn.leancloud.im.v2.messages.AVIMFileMessage;
import cn.leancloud.json.JSON;
import cn.leancloud.json.JSONObject;
import g.c0;
import g.e;
import g.f;
import java.io.IOException;
import java.util.Map;

public class AVIMFileMessage$3
implements f {
    public final /* synthetic */ AVIMFileMessage this$0;
    public final /* synthetic */ SaveCallback val$callback;
    public final /* synthetic */ Map val$meta;
    public final /* synthetic */ String val$url;

    public AVIMFileMessage$3(AVIMFileMessage aVIMFileMessage, String string2, SaveCallback saveCallback, Map map) {
        this.this$0 = aVIMFileMessage;
        this.val$url = string2;
        this.val$callback = saveCallback;
        this.val$meta = map;
    }

    public void onFailure(e object, IOException object2) {
        object = AVIMFileMessage.access$000();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("error encountered while accessing qiniu with url:");
        String string2 = this.val$url;
        ((StringBuilder)object2).append(string2);
        object2 = ((StringBuilder)object2).toString();
        ((AVLogger)object).d((String)object2);
        this.val$callback.internalDone(null);
    }

    public void onResponse(e cloneable, c0 object) {
        cloneable = JSON.parseObject(((c0)object).r0().string());
        object = this.this$0;
        Map map = this.val$meta;
        ((AVIMFileMessage)object).parseAdditionalMetaData(map, (JSONObject)cloneable);
        this.val$callback.internalDone(null);
    }
}

