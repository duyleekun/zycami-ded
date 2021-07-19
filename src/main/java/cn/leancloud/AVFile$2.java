/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVFile;
import cn.leancloud.AVObject;
import cn.leancloud.json.JSONObject;
import cn.leancloud.utils.AVUtils;
import e.a.v0.o;
import java.util.concurrent.ConcurrentMap;

public class AVFile$2
implements o {
    public final /* synthetic */ AVFile this$0;
    public final /* synthetic */ JSONObject val$parameters;

    public AVFile$2(AVFile aVFile, JSONObject jSONObject) {
        this.this$0 = aVFile;
        this.val$parameters = jSONObject;
    }

    public AVFile apply(AVObject aVObject) {
        ConcurrentMap concurrentMap = this.this$0.serverData;
        JSONObject jSONObject = this.val$parameters;
        AVUtils.putAllWithNullFilter(concurrentMap, jSONObject);
        this.this$0.mergeRawData(aVObject, true);
        this.this$0.onSaveSuccess();
        return this.this$0;
    }
}

