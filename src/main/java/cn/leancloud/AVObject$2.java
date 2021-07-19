/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVLogger;
import cn.leancloud.AVObject;
import cn.leancloud.json.JSONObject;
import cn.leancloud.utils.AVUtils;
import e.a.v0.o;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public class AVObject$2
implements o {
    public final /* synthetic */ AVObject this$0;
    public final /* synthetic */ String val$currentObjectId;

    public AVObject$2(AVObject aVObject, String string2) {
        this.this$0 = aVObject;
        this.val$currentObjectId = string2;
    }

    public AVObject apply(JSONObject object) {
        if (object != null) {
            Object object2 = AVObject.logger;
            Object object3 = new StringBuilder();
            ((StringBuilder)object3).append("batchUpdate result: ");
            String string2 = ((JSONObject)object).toJSONString();
            ((StringBuilder)object3).append(string2);
            object3 = ((StringBuilder)object3).toString();
            ((AVLogger)object2).d((String)object3);
            object2 = this.val$currentObjectId;
            object3 = Map.class;
            object = (Map)((JSONObject)object).getObject((String)object2, (Class)object3);
            if (object != null) {
                object2 = this.this$0.serverData;
                AVUtils.mergeConcurrentMap((ConcurrentMap)object2, (Map)object);
                object = this.this$0;
                ((AVObject)object).onSaveSuccess();
            }
        }
        return this.this$0;
    }
}

