/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVLogger;
import cn.leancloud.AVObject;
import cn.leancloud.AVObject$7;
import cn.leancloud.json.JSONArray;
import cn.leancloud.json.JSONArray$Builder;
import cn.leancloud.json.JSONObject;
import cn.leancloud.json.JSONObject$Builder;
import cn.leancloud.utils.AVUtils;
import e.a.v0.o;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public class AVObject$7$1
implements o {
    public final /* synthetic */ AVObject$7 this$0;

    public AVObject$7$1(AVObject$7 aVObject$7) {
        this.this$0 = aVObject$7;
    }

    public JSONArray apply(List list) {
        int n10;
        Iterator iterator2;
        int n11;
        JSONArray jSONArray = JSONArray$Builder.create(null);
        if (list != null && (n11 = (iterator2 = this.this$0.val$objects).size()) == (n10 = list.size())) {
            int n12;
            iterator2 = AVObject.logger;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("batchSave result: ");
            Object object = list.toString();
            charSequence.append((String)object);
            charSequence = charSequence.toString();
            ((AVLogger)((Object)iterator2)).d((String)charSequence);
            iterator2 = this.this$0.val$objects.iterator();
            charSequence = null;
            for (n10 = 0; n10 < (n12 = list.size()) && (n12 = (int)(iterator2.hasNext() ? 1 : 0)) != 0; ++n10) {
                object = JSONObject$Builder.create((Map)list.get(n10));
                AVObject aVObject = (AVObject)iterator2.next();
                Object object2 = "success";
                boolean bl2 = object.containsKey(object2);
                if (bl2) {
                    ConcurrentMap concurrentMap = aVObject.serverData;
                    object2 = ((JSONObject)object).getJSONObject((String)object2).getInnerMap();
                    AVUtils.mergeConcurrentMap(concurrentMap, (Map)object2);
                    aVObject.onSaveSuccess();
                } else {
                    object2 = "error";
                    boolean bl3 = object.containsKey(object2);
                    if (bl3) {
                        aVObject.onSaveFailure();
                    }
                }
                jSONArray.add(object);
            }
        }
        return jSONArray;
    }
}

